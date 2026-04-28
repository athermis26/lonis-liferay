package com.df.lonis.ventesrest.client.serdes.v1_0;

import com.df.lonis.ventesrest.client.dto.v1_0.Concessionnaire;
import com.df.lonis.ventesrest.client.json.BaseJSONParser;

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
public class ConcessionnaireSerDes {

	public static Concessionnaire toDTO(String json) {
		ConcessionnaireJSONParser concessionnaireJSONParser =
			new ConcessionnaireJSONParser();

		return concessionnaireJSONParser.parseToDTO(json);
	}

	public static Concessionnaire[] toDTOs(String json) {
		ConcessionnaireJSONParser concessionnaireJSONParser =
			new ConcessionnaireJSONParser();

		return concessionnaireJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Concessionnaire concessionnaire) {
		if (concessionnaire == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (concessionnaire.getEmail() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"email\": ");

			sb.append("\"");

			sb.append(_escape(concessionnaire.getEmail()));

			sb.append("\"");
		}

		if (concessionnaire.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(concessionnaire.getId());
		}

		if (concessionnaire.getNom() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"nom\": ");

			sb.append("\"");

			sb.append(_escape(concessionnaire.getNom()));

			sb.append("\"");
		}

		if (concessionnaire.getPrenoms() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"prenoms\": ");

			sb.append("\"");

			sb.append(_escape(concessionnaire.getPrenoms()));

			sb.append("\"");
		}

		if (concessionnaire.getTelephone() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"telephone\": ");

			sb.append("\"");

			sb.append(_escape(concessionnaire.getTelephone()));

			sb.append("\"");
		}

		if (concessionnaire.getUid() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"uid\": ");

			sb.append("\"");

			sb.append(_escape(concessionnaire.getUid()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ConcessionnaireJSONParser concessionnaireJSONParser =
			new ConcessionnaireJSONParser();

		return concessionnaireJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Concessionnaire concessionnaire) {
		if (concessionnaire == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (concessionnaire.getEmail() == null) {
			map.put("email", null);
		}
		else {
			map.put("email", String.valueOf(concessionnaire.getEmail()));
		}

		if (concessionnaire.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(concessionnaire.getId()));
		}

		if (concessionnaire.getNom() == null) {
			map.put("nom", null);
		}
		else {
			map.put("nom", String.valueOf(concessionnaire.getNom()));
		}

		if (concessionnaire.getPrenoms() == null) {
			map.put("prenoms", null);
		}
		else {
			map.put("prenoms", String.valueOf(concessionnaire.getPrenoms()));
		}

		if (concessionnaire.getTelephone() == null) {
			map.put("telephone", null);
		}
		else {
			map.put(
				"telephone", String.valueOf(concessionnaire.getTelephone()));
		}

		if (concessionnaire.getUid() == null) {
			map.put("uid", null);
		}
		else {
			map.put("uid", String.valueOf(concessionnaire.getUid()));
		}

		return map;
	}

	public static class ConcessionnaireJSONParser
		extends BaseJSONParser<Concessionnaire> {

		@Override
		protected Concessionnaire createDTO() {
			return new Concessionnaire();
		}

		@Override
		protected Concessionnaire[] createDTOArray(int size) {
			return new Concessionnaire[size];
		}

		@Override
		protected void setField(
			Concessionnaire concessionnaire, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "email")) {
				if (jsonParserFieldValue != null) {
					concessionnaire.setEmail((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					concessionnaire.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "nom")) {
				if (jsonParserFieldValue != null) {
					concessionnaire.setNom((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "prenoms")) {
				if (jsonParserFieldValue != null) {
					concessionnaire.setPrenoms((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "telephone")) {
				if (jsonParserFieldValue != null) {
					concessionnaire.setTelephone((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "uid")) {
				if (jsonParserFieldValue != null) {
					concessionnaire.setUid((String)jsonParserFieldValue);
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