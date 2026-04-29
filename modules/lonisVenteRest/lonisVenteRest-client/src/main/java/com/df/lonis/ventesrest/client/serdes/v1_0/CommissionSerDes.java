package com.df.lonis.ventesrest.client.serdes.v1_0;

import com.df.lonis.ventesrest.client.dto.v1_0.Commission;
import com.df.lonis.ventesrest.client.json.BaseJSONParser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
public class CommissionSerDes {

	public static Commission toDTO(String json) {
		CommissionJSONParser commissionJSONParser = new CommissionJSONParser();

		return commissionJSONParser.parseToDTO(json);
	}

	public static Commission[] toDTOs(String json) {
		CommissionJSONParser commissionJSONParser = new CommissionJSONParser();

		return commissionJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Commission commission) {
		if (commission == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (commission.getCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"code\": ");

			sb.append("\"");

			sb.append(_escape(commission.getCode()));

			sb.append("\"");
		}

		if (commission.getCodeTerminal() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"codeTerminal\": ");

			sb.append("\"");

			sb.append(_escape(commission.getCodeTerminal()));

			sb.append("\"");
		}

		if (commission.getCreatedAt() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"createdAt\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(commission.getCreatedAt()));

			sb.append("\"");
		}

		if (commission.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(commission.getId());
		}

		if (commission.getLibelle() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"libelle\": ");

			sb.append("\"");

			sb.append(_escape(commission.getLibelle()));

			sb.append("\"");
		}

		if (commission.getNombreTerminaux() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"nombreTerminaux\": ");

			sb.append(commission.getNombreTerminaux());
		}

		if (commission.getPaye() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"paye\": ");

			sb.append(commission.getPaye());
		}

		if (commission.getStatus() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"status\": ");

			sb.append("\"");

			sb.append(_escape(commission.getStatus()));

			sb.append("\"");
		}

		if (commission.getTerminalId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"terminalId\": ");

			sb.append(commission.getTerminalId());
		}

		if (commission.getUpdatedAt() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"updatedAt\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(commission.getUpdatedAt()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		CommissionJSONParser commissionJSONParser = new CommissionJSONParser();

		return commissionJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Commission commission) {
		if (commission == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (commission.getCode() == null) {
			map.put("code", null);
		}
		else {
			map.put("code", String.valueOf(commission.getCode()));
		}

		if (commission.getCodeTerminal() == null) {
			map.put("codeTerminal", null);
		}
		else {
			map.put(
				"codeTerminal", String.valueOf(commission.getCodeTerminal()));
		}

		if (commission.getCreatedAt() == null) {
			map.put("createdAt", null);
		}
		else {
			map.put(
				"createdAt",
				liferayToJSONDateFormat.format(commission.getCreatedAt()));
		}

		if (commission.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(commission.getId()));
		}

		if (commission.getLibelle() == null) {
			map.put("libelle", null);
		}
		else {
			map.put("libelle", String.valueOf(commission.getLibelle()));
		}

		if (commission.getNombreTerminaux() == null) {
			map.put("nombreTerminaux", null);
		}
		else {
			map.put(
				"nombreTerminaux",
				String.valueOf(commission.getNombreTerminaux()));
		}

		if (commission.getPaye() == null) {
			map.put("paye", null);
		}
		else {
			map.put("paye", String.valueOf(commission.getPaye()));
		}

		if (commission.getStatus() == null) {
			map.put("status", null);
		}
		else {
			map.put("status", String.valueOf(commission.getStatus()));
		}

		if (commission.getTerminalId() == null) {
			map.put("terminalId", null);
		}
		else {
			map.put("terminalId", String.valueOf(commission.getTerminalId()));
		}

		if (commission.getUpdatedAt() == null) {
			map.put("updatedAt", null);
		}
		else {
			map.put(
				"updatedAt",
				liferayToJSONDateFormat.format(commission.getUpdatedAt()));
		}

		return map;
	}

	public static class CommissionJSONParser
		extends BaseJSONParser<Commission> {

		@Override
		protected Commission createDTO() {
			return new Commission();
		}

		@Override
		protected Commission[] createDTOArray(int size) {
			return new Commission[size];
		}

		@Override
		protected void setField(
			Commission commission, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "code")) {
				if (jsonParserFieldValue != null) {
					commission.setCode((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "codeTerminal")) {
				if (jsonParserFieldValue != null) {
					commission.setCodeTerminal((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "createdAt")) {
				if (jsonParserFieldValue != null) {
					commission.setCreatedAt(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					commission.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "libelle")) {
				if (jsonParserFieldValue != null) {
					commission.setLibelle((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "nombreTerminaux")) {
				if (jsonParserFieldValue != null) {
					commission.setNombreTerminaux(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "paye")) {
				if (jsonParserFieldValue != null) {
					commission.setPaye((Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "status")) {
				if (jsonParserFieldValue != null) {
					commission.setStatus((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "terminalId")) {
				if (jsonParserFieldValue != null) {
					commission.setTerminalId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "updatedAt")) {
				if (jsonParserFieldValue != null) {
					commission.setUpdatedAt(
						toDate((String)jsonParserFieldValue));
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