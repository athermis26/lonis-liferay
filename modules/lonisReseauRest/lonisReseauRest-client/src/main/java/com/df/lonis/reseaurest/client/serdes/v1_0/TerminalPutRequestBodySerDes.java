package com.df.lonis.reseaurest.client.serdes.v1_0;

import com.df.lonis.reseaurest.client.dto.v1_0.TerminalPutRequestBody;
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
public class TerminalPutRequestBodySerDes {

	public static TerminalPutRequestBody toDTO(String json) {
		TerminalPutRequestBodyJSONParser terminalPutRequestBodyJSONParser =
			new TerminalPutRequestBodyJSONParser();

		return terminalPutRequestBodyJSONParser.parseToDTO(json);
	}

	public static TerminalPutRequestBody[] toDTOs(String json) {
		TerminalPutRequestBodyJSONParser terminalPutRequestBodyJSONParser =
			new TerminalPutRequestBodyJSONParser();

		return terminalPutRequestBodyJSONParser.parseToDTOs(json);
	}

	public static String toJSON(TerminalPutRequestBody terminalPutRequestBody) {
		if (terminalPutRequestBody == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (terminalPutRequestBody.getAdresse() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"adresse\": ");

			sb.append("\"");

			sb.append(_escape(terminalPutRequestBody.getAdresse()));

			sb.append("\"");
		}

		if (terminalPutRequestBody.getConcessionnaireId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"concessionnaireId\": ");

			sb.append(terminalPutRequestBody.getConcessionnaireId());
		}

		if (terminalPutRequestBody.getLatitude() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"latitude\": ");

			sb.append(terminalPutRequestBody.getLatitude());
		}

		if (terminalPutRequestBody.getLongitude() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"longitude\": ");

			sb.append(terminalPutRequestBody.getLongitude());
		}

		if (terminalPutRequestBody.getSiteId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"siteId\": ");

			sb.append(terminalPutRequestBody.getSiteId());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		TerminalPutRequestBodyJSONParser terminalPutRequestBodyJSONParser =
			new TerminalPutRequestBodyJSONParser();

		return terminalPutRequestBodyJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		TerminalPutRequestBody terminalPutRequestBody) {

		if (terminalPutRequestBody == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (terminalPutRequestBody.getAdresse() == null) {
			map.put("adresse", null);
		}
		else {
			map.put(
				"adresse", String.valueOf(terminalPutRequestBody.getAdresse()));
		}

		if (terminalPutRequestBody.getConcessionnaireId() == null) {
			map.put("concessionnaireId", null);
		}
		else {
			map.put(
				"concessionnaireId",
				String.valueOf(terminalPutRequestBody.getConcessionnaireId()));
		}

		if (terminalPutRequestBody.getLatitude() == null) {
			map.put("latitude", null);
		}
		else {
			map.put(
				"latitude",
				String.valueOf(terminalPutRequestBody.getLatitude()));
		}

		if (terminalPutRequestBody.getLongitude() == null) {
			map.put("longitude", null);
		}
		else {
			map.put(
				"longitude",
				String.valueOf(terminalPutRequestBody.getLongitude()));
		}

		if (terminalPutRequestBody.getSiteId() == null) {
			map.put("siteId", null);
		}
		else {
			map.put(
				"siteId", String.valueOf(terminalPutRequestBody.getSiteId()));
		}

		return map;
	}

	public static class TerminalPutRequestBodyJSONParser
		extends BaseJSONParser<TerminalPutRequestBody> {

		@Override
		protected TerminalPutRequestBody createDTO() {
			return new TerminalPutRequestBody();
		}

		@Override
		protected TerminalPutRequestBody[] createDTOArray(int size) {
			return new TerminalPutRequestBody[size];
		}

		@Override
		protected void setField(
			TerminalPutRequestBody terminalPutRequestBody,
			String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "adresse")) {
				if (jsonParserFieldValue != null) {
					terminalPutRequestBody.setAdresse(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "concessionnaireId")) {
				if (jsonParserFieldValue != null) {
					terminalPutRequestBody.setConcessionnaireId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "latitude")) {
				if (jsonParserFieldValue != null) {
					terminalPutRequestBody.setLatitude(
						Double.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "longitude")) {
				if (jsonParserFieldValue != null) {
					terminalPutRequestBody.setLongitude(
						Double.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "siteId")) {
				if (jsonParserFieldValue != null) {
					terminalPutRequestBody.setSiteId(
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