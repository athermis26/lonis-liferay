package com.df.lonis.reseaurest.internal.backend;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

/**
 * Client HTTP OSGi vers le backend Spring Boot pour le module réseau.
 */
@Component(
		configurationPid = "com.df.lonis.reseaurest.internal.backend.BackendClientConfiguration",
		immediate = true,
		service = BackendHttpClient.class
)
public class BackendHttpClient {

	private static final Log _log = LogFactoryUtil.getLog(BackendHttpClient.class);

	private volatile BackendClientConfiguration _configuration;
	private volatile HttpClient _httpClient;

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(
				BackendClientConfiguration.class, properties);

		_httpClient = HttpClient.newBuilder()
				.connectTimeout(Duration.ofMillis(_configuration.connectTimeoutMs()))
				.followRedirects(HttpClient.Redirect.NORMAL)
				.build();

		if (_log.isInfoEnabled()) {
			_log.info("Reseau BackendHttpClient activé sur " + _configuration.baseUrl());
		}
	}

	public String get(String path, Map<String, Object> queryParams) {
		String url = _configuration.baseUrl() + path + buildQueryString(queryParams);
		HttpRequest request = baseRequest(url).GET().build();
		return execute(request);
	}

	public String post(String path, String jsonBody) {
		String url = _configuration.baseUrl() + path;
		HttpRequest request = baseRequest(url)
				.header("Content-Type", "application/json")
				.POST(HttpRequest.BodyPublishers.ofString(
						jsonBody == null ? "" : jsonBody, StandardCharsets.UTF_8))
				.build();
		return execute(request);
	}

	public String put(String path, String jsonBody) {
		String url = _configuration.baseUrl() + path;
		HttpRequest request = baseRequest(url)
				.header("Content-Type", "application/json")
				.PUT(HttpRequest.BodyPublishers.ofString(
						jsonBody == null ? "" : jsonBody, StandardCharsets.UTF_8))
				.build();
		return execute(request);
	}

	public String patch(String path, String jsonBody) {
		String url = _configuration.baseUrl() + path;
		HttpRequest request = baseRequest(url)
				.header("Content-Type", "application/json")
				.method("PATCH", HttpRequest.BodyPublishers.ofString(
						jsonBody == null ? "" : jsonBody, StandardCharsets.UTF_8))
				.build();
		return execute(request);
	}

	public void delete(String path) {
		String url = _configuration.baseUrl() + path;
		HttpRequest request = baseRequest(url).DELETE().build();
		execute(request);
	}

	private HttpRequest.Builder baseRequest(String url) {
		return HttpRequest.newBuilder(URI.create(url))
				.timeout(Duration.ofMillis(_configuration.readTimeoutMs()))
				.header("Accept", "application/json")
				.header("X-API-Key", _configuration.apiKey());
	}

	private String execute(HttpRequest request) {
		try {
			HttpResponse<String> response = _httpClient.send(
					request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

			int status = response.statusCode();
			String body = response.body();

			if (status >= 200 && status < 300) {
				return body;
			}

			throw new BackendException(
					status,
					"Backend " + request.method() + " " + request.uri()
							+ " a répondu " + status + " : " + body,
					body, null);
		}
		catch (BackendException be) {
			throw be;
		}
		catch (Exception e) {
			throw new BackendException(
					0, "Erreur d'appel au backend : " + e.getMessage(), e);
		}
	}

	private static String buildQueryString(Map<String, Object> params) {
		if (params == null || params.isEmpty()) {
			return "";
		}
		Map<String, Object> ordered = new LinkedHashMap<>(params);
		StringBuilder sb = new StringBuilder("?");
		boolean first = true;
		for (Map.Entry<String, Object> e : ordered.entrySet()) {
			if (e.getValue() == null) continue;
			if (!first) sb.append('&');
			sb.append(URLEncoder.encode(e.getKey(), StandardCharsets.UTF_8))
					.append('=')
					.append(URLEncoder.encode(String.valueOf(e.getValue()), StandardCharsets.UTF_8));
			first = false;
		}
		return sb.length() == 1 ? "" : sb.toString();
	}
}
