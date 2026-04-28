package com.df.lonis.ventesrest.client.serdes.v1_0;

import com.df.lonis.ventesrest.client.dto.v1_0.OperationDetail;
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
public class OperationDetailSerDes {

	public static OperationDetail toDTO(String json) {
		OperationDetailJSONParser operationDetailJSONParser =
			new OperationDetailJSONParser();

		return operationDetailJSONParser.parseToDTO(json);
	}

	public static OperationDetail[] toDTOs(String json) {
		OperationDetailJSONParser operationDetailJSONParser =
			new OperationDetailJSONParser();

		return operationDetailJSONParser.parseToDTOs(json);
	}

	public static String toJSON(OperationDetail operationDetail) {
		if (operationDetail == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (operationDetail.getCodeOperation() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"codeOperation\": ");

			sb.append("\"");

			sb.append(_escape(operationDetail.getCodeOperation()));

			sb.append("\"");
		}

		if (operationDetail.getCodeTerminal() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"codeTerminal\": ");

			sb.append("\"");

			sb.append(_escape(operationDetail.getCodeTerminal()));

			sb.append("\"");
		}

		if (operationDetail.getDateHeure() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dateHeure\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(operationDetail.getDateHeure()));

			sb.append("\"");
		}

		if (operationDetail.getGuichet() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"guichet\": ");

			sb.append("\"");

			sb.append(_escape(operationDetail.getGuichet()));

			sb.append("\"");
		}

		if (operationDetail.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(operationDetail.getId());
		}

		if (operationDetail.getLibelle() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"libelle\": ");

			sb.append("\"");

			sb.append(_escape(operationDetail.getLibelle()));

			sb.append("\"");
		}

		if (operationDetail.getMontant() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"montant\": ");

			sb.append(operationDetail.getMontant());
		}

		if (operationDetail.getMontantReel() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"montantReel\": ");

			sb.append(operationDetail.getMontantReel());
		}

		if (operationDetail.getReference() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"reference\": ");

			sb.append("\"");

			sb.append(_escape(operationDetail.getReference()));

			sb.append("\"");
		}

		if (operationDetail.getStatut() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"statut\": ");

			sb.append("\"");

			sb.append(_escape(operationDetail.getStatut()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		OperationDetailJSONParser operationDetailJSONParser =
			new OperationDetailJSONParser();

		return operationDetailJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(OperationDetail operationDetail) {
		if (operationDetail == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (operationDetail.getCodeOperation() == null) {
			map.put("codeOperation", null);
		}
		else {
			map.put(
				"codeOperation",
				String.valueOf(operationDetail.getCodeOperation()));
		}

		if (operationDetail.getCodeTerminal() == null) {
			map.put("codeTerminal", null);
		}
		else {
			map.put(
				"codeTerminal",
				String.valueOf(operationDetail.getCodeTerminal()));
		}

		if (operationDetail.getDateHeure() == null) {
			map.put("dateHeure", null);
		}
		else {
			map.put(
				"dateHeure",
				liferayToJSONDateFormat.format(operationDetail.getDateHeure()));
		}

		if (operationDetail.getGuichet() == null) {
			map.put("guichet", null);
		}
		else {
			map.put("guichet", String.valueOf(operationDetail.getGuichet()));
		}

		if (operationDetail.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(operationDetail.getId()));
		}

		if (operationDetail.getLibelle() == null) {
			map.put("libelle", null);
		}
		else {
			map.put("libelle", String.valueOf(operationDetail.getLibelle()));
		}

		if (operationDetail.getMontant() == null) {
			map.put("montant", null);
		}
		else {
			map.put("montant", String.valueOf(operationDetail.getMontant()));
		}

		if (operationDetail.getMontantReel() == null) {
			map.put("montantReel", null);
		}
		else {
			map.put(
				"montantReel",
				String.valueOf(operationDetail.getMontantReel()));
		}

		if (operationDetail.getReference() == null) {
			map.put("reference", null);
		}
		else {
			map.put(
				"reference", String.valueOf(operationDetail.getReference()));
		}

		if (operationDetail.getStatut() == null) {
			map.put("statut", null);
		}
		else {
			map.put("statut", String.valueOf(operationDetail.getStatut()));
		}

		return map;
	}

	public static class OperationDetailJSONParser
		extends BaseJSONParser<OperationDetail> {

		@Override
		protected OperationDetail createDTO() {
			return new OperationDetail();
		}

		@Override
		protected OperationDetail[] createDTOArray(int size) {
			return new OperationDetail[size];
		}

		@Override
		protected void setField(
			OperationDetail operationDetail, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "codeOperation")) {
				if (jsonParserFieldValue != null) {
					operationDetail.setCodeOperation(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "codeTerminal")) {
				if (jsonParserFieldValue != null) {
					operationDetail.setCodeTerminal(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "dateHeure")) {
				if (jsonParserFieldValue != null) {
					operationDetail.setDateHeure(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "guichet")) {
				if (jsonParserFieldValue != null) {
					operationDetail.setGuichet((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					operationDetail.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "libelle")) {
				if (jsonParserFieldValue != null) {
					operationDetail.setLibelle((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "montant")) {
				if (jsonParserFieldValue != null) {
					operationDetail.setMontant(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "montantReel")) {
				if (jsonParserFieldValue != null) {
					operationDetail.setMontantReel(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "reference")) {
				if (jsonParserFieldValue != null) {
					operationDetail.setReference((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "statut")) {
				if (jsonParserFieldValue != null) {
					operationDetail.setStatut((String)jsonParserFieldValue);
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