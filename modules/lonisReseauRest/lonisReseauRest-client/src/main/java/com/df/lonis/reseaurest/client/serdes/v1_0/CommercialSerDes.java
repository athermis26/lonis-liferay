package com.df.lonis.reseaurest.client.serdes.v1_0;

import com.df.lonis.reseaurest.client.dto.v1_0.Commercial;
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
public class CommercialSerDes {

	public static Commercial toDTO(String json) {
		CommercialJSONParser commercialJSONParser = new CommercialJSONParser();

		return commercialJSONParser.parseToDTO(json);
	}

	public static Commercial[] toDTOs(String json) {
		CommercialJSONParser commercialJSONParser = new CommercialJSONParser();

		return commercialJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Commercial commercial) {
		if (commercial == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (commercial.getAgenceId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"agenceId\": ");

			sb.append(commercial.getAgenceId());
		}

		if (commercial.getEmail() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"email\": ");

			sb.append("\"");

			sb.append(_escape(commercial.getEmail()));

			sb.append("\"");
		}

		if (commercial.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(commercial.getId());
		}

		if (commercial.getMatricule() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"matricule\": ");

			sb.append("\"");

			sb.append(_escape(commercial.getMatricule()));

			sb.append("\"");
		}

		if (commercial.getNom() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"nom\": ");

			sb.append("\"");

			sb.append(_escape(commercial.getNom()));

			sb.append("\"");
		}

		if (commercial.getPrenoms() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"prenoms\": ");

			sb.append("\"");

			sb.append(_escape(commercial.getPrenoms()));

			sb.append("\"");
		}

		if (commercial.getStatut() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"statut\": ");

			sb.append("\"");

			sb.append(_escape(commercial.getStatut()));

			sb.append("\"");
		}

		if (commercial.getSuperviseurId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"superviseurId\": ");

			sb.append(commercial.getSuperviseurId());
		}

		if (commercial.getTelephone() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"telephone\": ");

			sb.append("\"");

			sb.append(_escape(commercial.getTelephone()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		CommercialJSONParser commercialJSONParser = new CommercialJSONParser();

		return commercialJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Commercial commercial) {
		if (commercial == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (commercial.getAgenceId() == null) {
			map.put("agenceId", null);
		}
		else {
			map.put("agenceId", String.valueOf(commercial.getAgenceId()));
		}

		if (commercial.getEmail() == null) {
			map.put("email", null);
		}
		else {
			map.put("email", String.valueOf(commercial.getEmail()));
		}

		if (commercial.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(commercial.getId()));
		}

		if (commercial.getMatricule() == null) {
			map.put("matricule", null);
		}
		else {
			map.put("matricule", String.valueOf(commercial.getMatricule()));
		}

		if (commercial.getNom() == null) {
			map.put("nom", null);
		}
		else {
			map.put("nom", String.valueOf(commercial.getNom()));
		}

		if (commercial.getPrenoms() == null) {
			map.put("prenoms", null);
		}
		else {
			map.put("prenoms", String.valueOf(commercial.getPrenoms()));
		}

		if (commercial.getStatut() == null) {
			map.put("statut", null);
		}
		else {
			map.put("statut", String.valueOf(commercial.getStatut()));
		}

		if (commercial.getSuperviseurId() == null) {
			map.put("superviseurId", null);
		}
		else {
			map.put(
				"superviseurId", String.valueOf(commercial.getSuperviseurId()));
		}

		if (commercial.getTelephone() == null) {
			map.put("telephone", null);
		}
		else {
			map.put("telephone", String.valueOf(commercial.getTelephone()));
		}

		return map;
	}

	public static class CommercialJSONParser
		extends BaseJSONParser<Commercial> {

		@Override
		protected Commercial createDTO() {
			return new Commercial();
		}

		@Override
		protected Commercial[] createDTOArray(int size) {
			return new Commercial[size];
		}

		@Override
		protected void setField(
			Commercial commercial, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "agenceId")) {
				if (jsonParserFieldValue != null) {
					commercial.setAgenceId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "email")) {
				if (jsonParserFieldValue != null) {
					commercial.setEmail((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					commercial.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "matricule")) {
				if (jsonParserFieldValue != null) {
					commercial.setMatricule((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "nom")) {
				if (jsonParserFieldValue != null) {
					commercial.setNom((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "prenoms")) {
				if (jsonParserFieldValue != null) {
					commercial.setPrenoms((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "statut")) {
				if (jsonParserFieldValue != null) {
					commercial.setStatut((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "superviseurId")) {
				if (jsonParserFieldValue != null) {
					commercial.setSuperviseurId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "telephone")) {
				if (jsonParserFieldValue != null) {
					commercial.setTelephone((String)jsonParserFieldValue);
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