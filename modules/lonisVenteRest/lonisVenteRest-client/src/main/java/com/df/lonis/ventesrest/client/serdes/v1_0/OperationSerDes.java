package com.df.lonis.ventesrest.client.serdes.v1_0;

import com.df.lonis.ventesrest.client.dto.v1_0.Operation;
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
public class OperationSerDes {

	public static Operation toDTO(String json) {
		OperationJSONParser operationJSONParser = new OperationJSONParser();

		return operationJSONParser.parseToDTO(json);
	}

	public static Operation[] toDTOs(String json) {
		OperationJSONParser operationJSONParser = new OperationJSONParser();

		return operationJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Operation operation) {
		if (operation == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (operation.getCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"code\": ");

			sb.append("\"");

			sb.append(_escape(operation.getCode()));

			sb.append("\"");
		}

		if (operation.getCodeTerminal() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"codeTerminal\": ");

			sb.append("\"");

			sb.append(_escape(operation.getCodeTerminal()));

			sb.append("\"");
		}

		if (operation.getDateOperation() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dateOperation\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(operation.getDateOperation()));

			sb.append("\"");
		}

		if (operation.getGuichet() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"guichet\": ");

			sb.append("\"");

			sb.append(_escape(operation.getGuichet()));

			sb.append("\"");
		}

		if (operation.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(operation.getId());
		}

		if (operation.getLibelle() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"libelle\": ");

			sb.append("\"");

			sb.append(_escape(operation.getLibelle()));

			sb.append("\"");
		}

		if (operation.getMontant() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"montant\": ");

			sb.append(operation.getMontant());
		}

		if (operation.getMontantReel() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"montantReel\": ");

			sb.append(operation.getMontantReel());
		}

		if (operation.getReference() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"reference\": ");

			sb.append("\"");

			sb.append(_escape(operation.getReference()));

			sb.append("\"");
		}

		if (operation.getStatut() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"statut\": ");

			sb.append("\"");

			sb.append(_escape(operation.getStatut()));

			sb.append("\"");
		}

		if (operation.getTerminalId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"terminalId\": ");

			sb.append(operation.getTerminalId());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		OperationJSONParser operationJSONParser = new OperationJSONParser();

		return operationJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Operation operation) {
		if (operation == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (operation.getCode() == null) {
			map.put("code", null);
		}
		else {
			map.put("code", String.valueOf(operation.getCode()));
		}

		if (operation.getCodeTerminal() == null) {
			map.put("codeTerminal", null);
		}
		else {
			map.put(
				"codeTerminal", String.valueOf(operation.getCodeTerminal()));
		}

		if (operation.getDateOperation() == null) {
			map.put("dateOperation", null);
		}
		else {
			map.put(
				"dateOperation",
				liferayToJSONDateFormat.format(operation.getDateOperation()));
		}

		if (operation.getGuichet() == null) {
			map.put("guichet", null);
		}
		else {
			map.put("guichet", String.valueOf(operation.getGuichet()));
		}

		if (operation.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(operation.getId()));
		}

		if (operation.getLibelle() == null) {
			map.put("libelle", null);
		}
		else {
			map.put("libelle", String.valueOf(operation.getLibelle()));
		}

		if (operation.getMontant() == null) {
			map.put("montant", null);
		}
		else {
			map.put("montant", String.valueOf(operation.getMontant()));
		}

		if (operation.getMontantReel() == null) {
			map.put("montantReel", null);
		}
		else {
			map.put("montantReel", String.valueOf(operation.getMontantReel()));
		}

		if (operation.getReference() == null) {
			map.put("reference", null);
		}
		else {
			map.put("reference", String.valueOf(operation.getReference()));
		}

		if (operation.getStatut() == null) {
			map.put("statut", null);
		}
		else {
			map.put("statut", String.valueOf(operation.getStatut()));
		}

		if (operation.getTerminalId() == null) {
			map.put("terminalId", null);
		}
		else {
			map.put("terminalId", String.valueOf(operation.getTerminalId()));
		}

		return map;
	}

	public static class OperationJSONParser extends BaseJSONParser<Operation> {

		@Override
		protected Operation createDTO() {
			return new Operation();
		}

		@Override
		protected Operation[] createDTOArray(int size) {
			return new Operation[size];
		}

		@Override
		protected void setField(
			Operation operation, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "code")) {
				if (jsonParserFieldValue != null) {
					operation.setCode((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "codeTerminal")) {
				if (jsonParserFieldValue != null) {
					operation.setCodeTerminal((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "dateOperation")) {
				if (jsonParserFieldValue != null) {
					operation.setDateOperation(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "guichet")) {
				if (jsonParserFieldValue != null) {
					operation.setGuichet((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					operation.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "libelle")) {
				if (jsonParserFieldValue != null) {
					operation.setLibelle((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "montant")) {
				if (jsonParserFieldValue != null) {
					operation.setMontant(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "montantReel")) {
				if (jsonParserFieldValue != null) {
					operation.setMontantReel(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "reference")) {
				if (jsonParserFieldValue != null) {
					operation.setReference((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "statut")) {
				if (jsonParserFieldValue != null) {
					operation.setStatut((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "terminalId")) {
				if (jsonParserFieldValue != null) {
					operation.setTerminalId(
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