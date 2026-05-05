package com.df.lonis.reseaurest.client.resource.v1_0;

import com.df.lonis.reseaurest.client.dto.v1_0.Evaluation;
import com.df.lonis.reseaurest.client.http.HttpInvoker;
import com.df.lonis.reseaurest.client.pagination.Page;
import com.df.lonis.reseaurest.client.problem.Problem;
import com.df.lonis.reseaurest.client.serdes.v1_0.EvaluationSerDes;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Generated;

/**
 * @author HP
 * @generated
 */
@Generated("")
public interface EvaluationResource {

	public static Builder builder() {
		return new Builder();
	}

	public Page<Evaluation> getEvaluationsClassementPage(
			Integer annee, Integer mois, Integer trimestre, String periode)
		throws Exception;

	public HttpInvoker.HttpResponse getEvaluationsClassementPageHttpResponse(
			Integer annee, Integer mois, Integer trimestre, String periode)
		throws Exception;

	public Page<Evaluation> getCommercialEvaluationsPage(
			Long commercialId, Integer annee, Integer mois)
		throws Exception;

	public HttpInvoker.HttpResponse getCommercialEvaluationsPageHttpResponse(
			Long commercialId, Integer annee, Integer mois)
		throws Exception;

	public void postEvaluationsGenerer(Object object) throws Exception;

	public HttpInvoker.HttpResponse postEvaluationsGenererHttpResponse(
			Object object)
		throws Exception;

	public static class Builder {

		public Builder authentication(String login, String password) {
			_login = login;
			_password = password;

			return this;
		}

		public EvaluationResource build() {
			return new EvaluationResourceImpl(this);
		}

		public Builder endpoint(String host, int port, String scheme) {
			_host = host;
			_port = port;
			_scheme = scheme;

			return this;
		}

		public Builder header(String key, String value) {
			_headers.put(key, value);

			return this;
		}

		public Builder locale(Locale locale) {
			_locale = locale;

			return this;
		}

		public Builder parameter(String key, String value) {
			_parameters.put(key, value);

			return this;
		}

		public Builder parameters(String... parameters) {
			if ((parameters.length % 2) != 0) {
				throw new IllegalArgumentException(
					"Parameters length is not an even number");
			}

			for (int i = 0; i < parameters.length; i += 2) {
				String parameterName = String.valueOf(parameters[i]);
				String parameterValue = String.valueOf(parameters[i + 1]);

				_parameters.put(parameterName, parameterValue);
			}

			return this;
		}

		private Builder() {
		}

		private Map<String, String> _headers = new LinkedHashMap<>();
		private String _host = "localhost";
		private Locale _locale;
		private String _login = "";
		private String _password = "";
		private Map<String, String> _parameters = new LinkedHashMap<>();
		private int _port = 8080;
		private String _scheme = "http";

	}

	public static class EvaluationResourceImpl implements EvaluationResource {

		public Page<Evaluation> getEvaluationsClassementPage(
				Integer annee, Integer mois, Integer trimestre, String periode)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				getEvaluationsClassementPageHttpResponse(
					annee, mois, trimestre, periode);

			String content = httpResponse.getContent();

			if ((httpResponse.getStatusCode() / 100) != 2) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response content: " + content);
				_logger.log(
					Level.WARNING,
					"HTTP response message: " + httpResponse.getMessage());
				_logger.log(
					Level.WARNING,
					"HTTP response status code: " +
						httpResponse.getStatusCode());

				throw new Problem.ProblemException(Problem.toDTO(content));
			}
			else {
				_logger.fine("HTTP response content: " + content);
				_logger.fine(
					"HTTP response message: " + httpResponse.getMessage());
				_logger.fine(
					"HTTP response status code: " +
						httpResponse.getStatusCode());
			}

			try {
				return Page.of(content, EvaluationSerDes::toDTO);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw new Problem.ProblemException(Problem.toDTO(content));
			}
		}

		public HttpInvoker.HttpResponse
				getEvaluationsClassementPageHttpResponse(
					Integer annee, Integer mois, Integer trimestre,
					String periode)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			for (Map.Entry<String, String> entry :
					_builder._headers.entrySet()) {

				httpInvoker.header(entry.getKey(), entry.getValue());
			}

			for (Map.Entry<String, String> entry :
					_builder._parameters.entrySet()) {

				httpInvoker.parameter(entry.getKey(), entry.getValue());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

			if (annee != null) {
				httpInvoker.parameter("annee", String.valueOf(annee));
			}

			if (mois != null) {
				httpInvoker.parameter("mois", String.valueOf(mois));
			}

			if (trimestre != null) {
				httpInvoker.parameter("trimestre", String.valueOf(trimestre));
			}

			if (periode != null) {
				httpInvoker.parameter("periode", String.valueOf(periode));
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/lonisReseauRest/v1.0/evaluations/classement");

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public Page<Evaluation> getCommercialEvaluationsPage(
				Long commercialId, Integer annee, Integer mois)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				getCommercialEvaluationsPageHttpResponse(
					commercialId, annee, mois);

			String content = httpResponse.getContent();

			if ((httpResponse.getStatusCode() / 100) != 2) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response content: " + content);
				_logger.log(
					Level.WARNING,
					"HTTP response message: " + httpResponse.getMessage());
				_logger.log(
					Level.WARNING,
					"HTTP response status code: " +
						httpResponse.getStatusCode());

				throw new Problem.ProblemException(Problem.toDTO(content));
			}
			else {
				_logger.fine("HTTP response content: " + content);
				_logger.fine(
					"HTTP response message: " + httpResponse.getMessage());
				_logger.fine(
					"HTTP response status code: " +
						httpResponse.getStatusCode());
			}

			try {
				return Page.of(content, EvaluationSerDes::toDTO);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw new Problem.ProblemException(Problem.toDTO(content));
			}
		}

		public HttpInvoker.HttpResponse
				getCommercialEvaluationsPageHttpResponse(
					Long commercialId, Integer annee, Integer mois)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			for (Map.Entry<String, String> entry :
					_builder._headers.entrySet()) {

				httpInvoker.header(entry.getKey(), entry.getValue());
			}

			for (Map.Entry<String, String> entry :
					_builder._parameters.entrySet()) {

				httpInvoker.parameter(entry.getKey(), entry.getValue());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

			if (annee != null) {
				httpInvoker.parameter("annee", String.valueOf(annee));
			}

			if (mois != null) {
				httpInvoker.parameter("mois", String.valueOf(mois));
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/lonisReseauRest/v1.0/commerciaux/{commercialId}/evaluations");

			httpInvoker.path("commercialId", commercialId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public void postEvaluationsGenerer(Object object) throws Exception {
			HttpInvoker.HttpResponse httpResponse =
				postEvaluationsGenererHttpResponse(object);

			String content = httpResponse.getContent();

			if ((httpResponse.getStatusCode() / 100) != 2) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response content: " + content);
				_logger.log(
					Level.WARNING,
					"HTTP response message: " + httpResponse.getMessage());
				_logger.log(
					Level.WARNING,
					"HTTP response status code: " +
						httpResponse.getStatusCode());

				throw new Problem.ProblemException(Problem.toDTO(content));
			}
			else {
				_logger.fine("HTTP response content: " + content);
				_logger.fine(
					"HTTP response message: " + httpResponse.getMessage());
				_logger.fine(
					"HTTP response status code: " +
						httpResponse.getStatusCode());
			}
		}

		public HttpInvoker.HttpResponse postEvaluationsGenererHttpResponse(
				Object object)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			httpInvoker.body(object.toString(), "application/json");

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			for (Map.Entry<String, String> entry :
					_builder._headers.entrySet()) {

				httpInvoker.header(entry.getKey(), entry.getValue());
			}

			for (Map.Entry<String, String> entry :
					_builder._parameters.entrySet()) {

				httpInvoker.parameter(entry.getKey(), entry.getValue());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/lonisReseauRest/v1.0/evaluations/generer");

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		private EvaluationResourceImpl(Builder builder) {
			_builder = builder;
		}

		private static final Logger _logger = Logger.getLogger(
			EvaluationResource.class.getName());

		private Builder _builder;

	}

}