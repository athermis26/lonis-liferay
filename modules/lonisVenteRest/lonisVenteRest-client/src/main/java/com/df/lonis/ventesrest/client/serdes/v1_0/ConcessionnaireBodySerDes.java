package com.df.lonis.ventesrest.client.serdes.v1_0;

import com.df.lonis.ventesrest.client.dto.v1_0.ConcessionnaireBody;
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
public class ConcessionnaireBodySerDes {

	public static ConcessionnaireBody toDTO(String json) {
		ConcessionnaireBodyJSONParser concessionnaireBodyJSONParser =
			new ConcessionnaireBodyJSONParser();

		return concessionnaireBodyJSONParser.parseToDTO(json);
	}

	public static ConcessionnaireBody[] toDTOs(String json) {
		ConcessionnaireBodyJSONParser concessionnaireBodyJSONParser =
			new ConcessionnaireBodyJSONParser();

		return concessionnaireBodyJSONParser.parseToDTOs(json);
	}

	public static String toJSON(ConcessionnaireBody concessionnaireBody) {
		if (concessionnaireBody == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (concessionnaireBody.getNom() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"nom\": ");

			sb.append("\"");

			sb.append(_escape(concessionnaireBody.getNom()));

			sb.append("\"");
		}

		if (concessionnaireBody.getPrenom() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"prenom\": ");

			sb.append("\"");

			sb.append(_escape(concessionnaireBody.getPrenom()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ConcessionnaireBodyJSONParser concessionnaireBodyJSONParser =
			new ConcessionnaireBodyJSONParser();

		return concessionnaireBodyJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		ConcessionnaireBody concessionnaireBody) {

		if (concessionnaireBody == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (concessionnaireBody.getNom() == null) {
			map.put("nom", null);
		}
		else {
			map.put("nom", String.valueOf(concessionnaireBody.getNom()));
		}

		if (concessionnaireBody.getPrenom() == null) {
			map.put("prenom", null);
		}
		else {
			map.put("prenom", String.valueOf(concessionnaireBody.getPrenom()));
		}

		return map;
	}

	public static class ConcessionnaireBodyJSONParser
		extends BaseJSONParser<ConcessionnaireBody> {

		@Override
		protected ConcessionnaireBody createDTO() {
			return new ConcessionnaireBody();
		}

		@Override
		protected ConcessionnaireBody[] createDTOArray(int size) {
			return new ConcessionnaireBody[size];
		}

		@Override
		protected void setField(
			ConcessionnaireBody concessionnaireBody, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "nom")) {
				if (jsonParserFieldValue != null) {
					concessionnaireBody.setNom((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "prenom")) {
				if (jsonParserFieldValue != null) {
					concessionnaireBody.setPrenom((String)jsonParserFieldValue);
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