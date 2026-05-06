package com.df.lonis.ventesrest.internal.backend;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.time.Instant;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.osgi.service.component.annotations.Component;

/**
 * Mappe les {@link BackendException} levées par {@link BackendHttpClient} vers une
 * {@link Response} JAX-RS qui propage tel quel le statut HTTP et le body JSON
 * renvoyés par le backend Spring Boot.
 *
 * <p>Si le body backend est absent ou invalide, on construit une réponse JSON
 * homogène {@code {timestamp, status, error, message}}.</p>
 */
@Component(
		property = {
				"osgi.jaxrs.application.select=(osgi.jaxrs.name=LonisVenteRest)",
				"osgi.jaxrs.extension=true",
				"osgi.jaxrs.name=Lonis.Backend.Exception.Mapper"
		},
		service = ExceptionMapper.class
)
@Provider
public class BackendExceptionMapper implements ExceptionMapper<BackendException> {

	private static final Log _log = LogFactoryUtil.getLog(BackendExceptionMapper.class);

	@Override
	public Response toResponse(BackendException exception) {
		int status = exception.getStatusCode() <= 0 ? 502 : exception.getStatusCode();

		if (_log.isDebugEnabled()) {
			_log.debug("Backend a répondu " + status + " — propagation au client", exception);
		}

		String body = exception.getBody();
		if (body != null && !body.isBlank() && looksLikeJson(body)) {
			return Response.status(status)
					.type(MediaType.APPLICATION_JSON)
					.entity(body)
					.build();
		}

		// Fallback : construire un body JSON homogène avec le format Spring.
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("timestamp", Instant.now().toString());
		json.put("status", status);
		json.put("error", reasonPhrase(status));
		json.put("message", exception.getMessage() == null ? "" : exception.getMessage());

		return Response.status(status)
				.type(MediaType.APPLICATION_JSON)
				.entity(json.toString())
				.build();
	}

	private static boolean looksLikeJson(String body) {
		String trimmed = body.trim();
		return trimmed.startsWith("{") || trimmed.startsWith("[");
	}

	private static String reasonPhrase(int status) {
		Response.Status s = Response.Status.fromStatusCode(status);
		return s == null ? "Backend Error" : s.getReasonPhrase();
	}
}
