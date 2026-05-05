package com.df.lonis.reseaurest.client.serdes.v1_0;

import com.df.lonis.reseaurest.client.dto.v1_0.TerminalRequestBody;
import com.df.lonis.reseaurest.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author HP
 * @generated
 */
@Generated("")
public class TerminalRequestBodySerDes {

	public static TerminalRequestBody toDTO(String json) {
		TerminalRequestBodyJSONParser terminalRequestBodyJSONParser =
			new TerminalRequestBodyJSONParser();

		return terminalRequestBodyJSONParser.parseToDTO(json);
	}

	public static TerminalRequestBody[] toDTOs(String json) {
		TerminalRequestBodyJSONParser terminalRequestBodyJSONParser =
			new TerminalRequestBodyJSONParser();

		return terminalRequestBodyJSONParser.parseToDTOs(json);
	}

	public static String toJSON(TerminalRequestBody terminalRequestBody) {
		if (terminalRequestBody == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (terminalRequestBody.getAdresse() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"adresse\": ");

			sb.append("\"");

			sb.append(_escape(terminalRequestBody.getAdresse()));

			sb.append("\"");
		}

		if (terminalRequestBody.getConcessionnaireId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"concessionnaireId\": ");

			sb.append(terminalRequestBody.getConcessionnaireId());
		}

		if (terminalRequestBody.getLatitude() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"latitude\": ");

			sb.append(terminalRequestBody.getLatitude());
		}

		if (terminalRequestBody.getLongitude() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"longitude\": ");

			sb.append(terminalRequestBody.getLongitude());
		}

		if (terminalRequestBody.getSiteId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"siteId\": ");

			sb.append(terminalRequestBody.getSiteId());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		TerminalRequestBodyJSONParser terminalRequestBodyJSONParser =
			new TerminalRequestBodyJSONParser();

		return terminalRequestBodyJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		TerminalRequestBody terminalRequestBody) {

		if (terminalRequestBody == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (terminalRequestBody.getAdresse() == null) {
			map.put("adresse", null);
		}
		else {
			map.put(
				"adresse", String.valueOf(terminalRequestBody.getAdresse()));
		}

		if (terminalRequestBody.getConcessionnaireId() == null) {
			map.put("concessionnaireId", null);
		}
		else {
			map.put(
				"concessionnaireId",
				String.valueOf(terminalRequestBody.getConcessionnaireId()));
		}

		if (terminalRequestBody.getLatitude() == null) {
			map.put("latitude", null);
		}
		else {
			map.put(
				"latitude", String.valueOf(terminalRequestBody.getLatitude()));
		}

		if (terminalRequestBody.getLongitude() == null) {
			map.put("longitude", null);
		}
		else {
			map.put(
				"longitude",
				String.valueOf(terminalRequestBody.getLongitude()));
		}

		if (terminalRequestBody.getSiteId() == null) {
			map.put("siteId", null);
		}
		else {
			map.put("siteId", String.valueOf(terminalRequestBody.getSiteId()));
		}

		return map;
	}

	public static class TerminalRequestBodyJSONParser
		extends BaseJSONParser<TerminalRequestBody> {

		@Override
		protected TerminalRequestBody createDTO() {
			return new TerminalRequestBody();
		}

		@Override
		protected TerminalRequestBody[] createDTOArray(int size) {
			return new TerminalRequestBody[size];
		}

		@Override
		protected void setField(
			TerminalRequestBody terminalRequestBody, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "adresse")) {
				if (jsonParserFieldValue != null) {
					terminalRequestBody.setAdresse(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "concessionnaireId")) {
				if (jsonParserFieldValue != null) {
					terminalRequestBody.setConcessionnaireId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "latitude")) {
				if (jsonParserFieldValue != null) {
					terminalRequestBody.setLatitude(
						Double.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "longitude")) {
				if (jsonParserFieldValue != null) {
					terminalRequestBody.setLongitude(
						Double.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "siteId")) {
				if (jsonParserFieldValue != null) {
					terminalRequestBody.setSiteId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}