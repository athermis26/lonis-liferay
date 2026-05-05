package com.df.lonis.reseaurest.client.serdes.v1_0;

import com.df.lonis.reseaurest.client.dto.v1_0.CommercialRequestBody;
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
public class CommercialRequestBodySerDes {

	public static CommercialRequestBody toDTO(String json) {
		CommercialRequestBodyJSONParser commercialRequestBodyJSONParser =
			new CommercialRequestBodyJSONParser();

		return commercialRequestBodyJSONParser.parseToDTO(json);
	}

	public static CommercialRequestBody[] toDTOs(String json) {
		CommercialRequestBodyJSONParser commercialRequestBodyJSONParser =
			new CommercialRequestBodyJSONParser();

		return commercialRequestBodyJSONParser.parseToDTOs(json);
	}

	public static String toJSON(CommercialRequestBody commercialRequestBody) {
		if (commercialRequestBody == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (commercialRequestBody.getAgenceId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"agenceId\": ");

			sb.append(commercialRequestBody.getAgenceId());
		}

		if (commercialRequestBody.getEmail() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"email\": ");

			sb.append("\"");

			sb.append(_escape(commercialRequestBody.getEmail()));

			sb.append("\"");
		}

		if (commercialRequestBody.getMatricule() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"matricule\": ");

			sb.append("\"");

			sb.append(_escape(commercialRequestBody.getMatricule()));

			sb.append("\"");
		}

		if (commercialRequestBody.getNom() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"nom\": ");

			sb.append("\"");

			sb.append(_escape(commercialRequestBody.getNom()));

			sb.append("\"");
		}

		if (commercialRequestBody.getPrenoms() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"prenoms\": ");

			sb.append("\"");

			sb.append(_escape(commercialRequestBody.getPrenoms()));

			sb.append("\"");
		}

		if (commercialRequestBody.getStatut() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"statut\": ");

			sb.append("\"");

			sb.append(_escape(commercialRequestBody.getStatut()));

			sb.append("\"");
		}

		if (commercialRequestBody.getTelephone() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"telephone\": ");

			sb.append("\"");

			sb.append(_escape(commercialRequestBody.getTelephone()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		CommercialRequestBodyJSONParser commercialRequestBodyJSONParser =
			new CommercialRequestBodyJSONParser();

		return commercialRequestBodyJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		CommercialRequestBody commercialRequestBody) {

		if (commercialRequestBody == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (commercialRequestBody.getAgenceId() == null) {
			map.put("agenceId", null);
		}
		else {
			map.put(
				"agenceId",
				String.valueOf(commercialRequestBody.getAgenceId()));
		}

		if (commercialRequestBody.getEmail() == null) {
			map.put("email", null);
		}
		else {
			map.put("email", String.valueOf(commercialRequestBody.getEmail()));
		}

		if (commercialRequestBody.getMatricule() == null) {
			map.put("matricule", null);
		}
		else {
			map.put(
				"matricule",
				String.valueOf(commercialRequestBody.getMatricule()));
		}

		if (commercialRequestBody.getNom() == null) {
			map.put("nom", null);
		}
		else {
			map.put("nom", String.valueOf(commercialRequestBody.getNom()));
		}

		if (commercialRequestBody.getPrenoms() == null) {
			map.put("prenoms", null);
		}
		else {
			map.put(
				"prenoms", String.valueOf(commercialRequestBody.getPrenoms()));
		}

		if (commercialRequestBody.getStatut() == null) {
			map.put("statut", null);
		}
		else {
			map.put(
				"statut", String.valueOf(commercialRequestBody.getStatut()));
		}

		if (commercialRequestBody.getTelephone() == null) {
			map.put("telephone", null);
		}
		else {
			map.put(
				"telephone",
				String.valueOf(commercialRequestBody.getTelephone()));
		}

		return map;
	}

	public static class CommercialRequestBodyJSONParser
		extends BaseJSONParser<CommercialRequestBody> {

		@Override
		protected CommercialRequestBody createDTO() {
			return new CommercialRequestBody();
		}

		@Override
		protected CommercialRequestBody[] createDTOArray(int size) {
			return new CommercialRequestBody[size];
		}

		@Override
		protected void setField(
			CommercialRequestBody commercialRequestBody,
			String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "agenceId")) {
				if (jsonParserFieldValue != null) {
					commercialRequestBody.setAgenceId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "email")) {
				if (jsonParserFieldValue != null) {
					commercialRequestBody.setEmail(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "matricule")) {
				if (jsonParserFieldValue != null) {
					commercialRequestBody.setMatricule(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "nom")) {
				if (jsonParserFieldValue != null) {
					commercialRequestBody.setNom((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "prenoms")) {
				if (jsonParserFieldValue != null) {
					commercialRequestBody.setPrenoms(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "statut")) {
				if (jsonParserFieldValue != null) {
					commercialRequestBody.setStatut(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "telephone")) {
				if (jsonParserFieldValue != null) {
					commercialRequestBody.setTelephone(
						(String)jsonParserFieldValue);
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