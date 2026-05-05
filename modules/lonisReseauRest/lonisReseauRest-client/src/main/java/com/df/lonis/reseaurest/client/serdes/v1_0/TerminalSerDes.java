package com.df.lonis.reseaurest.client.serdes.v1_0;

import com.df.lonis.reseaurest.client.dto.v1_0.Terminal;
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
public class TerminalSerDes {

	public static Terminal toDTO(String json) {
		TerminalJSONParser terminalJSONParser = new TerminalJSONParser();

		return terminalJSONParser.parseToDTO(json);
	}

	public static Terminal[] toDTOs(String json) {
		TerminalJSONParser terminalJSONParser = new TerminalJSONParser();

		return terminalJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Terminal terminal) {
		if (terminal == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (terminal.getAdresse() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"adresse\": ");

			sb.append("\"");

			sb.append(_escape(terminal.getAdresse()));

			sb.append("\"");
		}

		if (terminal.getCodeTerminal() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"codeTerminal\": ");

			sb.append("\"");

			sb.append(_escape(terminal.getCodeTerminal()));

			sb.append("\"");
		}

		if (terminal.getConcessionnaireId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"concessionnaireId\": ");

			sb.append(terminal.getConcessionnaireId());
		}

		if (terminal.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(terminal.getId());
		}

		if (terminal.getLatitude() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"latitude\": ");

			sb.append(terminal.getLatitude());
		}

		if (terminal.getLongitude() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"longitude\": ");

			sb.append(terminal.getLongitude());
		}

		if (terminal.getSiteId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"siteId\": ");

			sb.append(terminal.getSiteId());
		}

		if (terminal.getStatutValidation() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"statutValidation\": ");

			sb.append("\"");

			sb.append(terminal.getStatutValidation());

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		TerminalJSONParser terminalJSONParser = new TerminalJSONParser();

		return terminalJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Terminal terminal) {
		if (terminal == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (terminal.getAdresse() == null) {
			map.put("adresse", null);
		}
		else {
			map.put("adresse", String.valueOf(terminal.getAdresse()));
		}

		if (terminal.getCodeTerminal() == null) {
			map.put("codeTerminal", null);
		}
		else {
			map.put("codeTerminal", String.valueOf(terminal.getCodeTerminal()));
		}

		if (terminal.getConcessionnaireId() == null) {
			map.put("concessionnaireId", null);
		}
		else {
			map.put(
				"concessionnaireId",
				String.valueOf(terminal.getConcessionnaireId()));
		}

		if (terminal.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(terminal.getId()));
		}

		if (terminal.getLatitude() == null) {
			map.put("latitude", null);
		}
		else {
			map.put("latitude", String.valueOf(terminal.getLatitude()));
		}

		if (terminal.getLongitude() == null) {
			map.put("longitude", null);
		}
		else {
			map.put("longitude", String.valueOf(terminal.getLongitude()));
		}

		if (terminal.getSiteId() == null) {
			map.put("siteId", null);
		}
		else {
			map.put("siteId", String.valueOf(terminal.getSiteId()));
		}

		if (terminal.getStatutValidation() == null) {
			map.put("statutValidation", null);
		}
		else {
			map.put(
				"statutValidation",
				String.valueOf(terminal.getStatutValidation()));
		}

		return map;
	}

	public static class TerminalJSONParser extends BaseJSONParser<Terminal> {

		@Override
		protected Terminal createDTO() {
			return new Terminal();
		}

		@Override
		protected Terminal[] createDTOArray(int size) {
			return new Terminal[size];
		}

		@Override
		protected void setField(
			Terminal terminal, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "adresse")) {
				if (jsonParserFieldValue != null) {
					terminal.setAdresse((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "codeTerminal")) {
				if (jsonParserFieldValue != null) {
					terminal.setCodeTerminal((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "concessionnaireId")) {
				if (jsonParserFieldValue != null) {
					terminal.setConcessionnaireId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					terminal.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "latitude")) {
				if (jsonParserFieldValue != null) {
					terminal.setLatitude(
						Double.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "longitude")) {
				if (jsonParserFieldValue != null) {
					terminal.setLongitude(
						Double.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "siteId")) {
				if (jsonParserFieldValue != null) {
					terminal.setSiteId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "statutValidation")) {
				if (jsonParserFieldValue != null) {
					terminal.setStatutValidation(
						Terminal.StatutValidation.create(
							(String)jsonParserFieldValue));
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