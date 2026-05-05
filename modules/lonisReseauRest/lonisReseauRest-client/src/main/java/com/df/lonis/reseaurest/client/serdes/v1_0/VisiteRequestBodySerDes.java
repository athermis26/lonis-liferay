package com.df.lonis.reseaurest.client.serdes.v1_0;

import com.df.lonis.reseaurest.client.dto.v1_0.VisiteRequestBody;
import com.df.lonis.reseaurest.client.json.BaseJSONParser;

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
public class VisiteRequestBodySerDes {

	public static VisiteRequestBody toDTO(String json) {
		VisiteRequestBodyJSONParser visiteRequestBodyJSONParser =
			new VisiteRequestBodyJSONParser();

		return visiteRequestBodyJSONParser.parseToDTO(json);
	}

	public static VisiteRequestBody[] toDTOs(String json) {
		VisiteRequestBodyJSONParser visiteRequestBodyJSONParser =
			new VisiteRequestBodyJSONParser();

		return visiteRequestBodyJSONParser.parseToDTOs(json);
	}

	public static String toJSON(VisiteRequestBody visiteRequestBody) {
		if (visiteRequestBody == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (visiteRequestBody.getCommercialId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"commercialId\": ");

			sb.append(visiteRequestBody.getCommercialId());
		}

		if (visiteRequestBody.getCompteRendu() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"compteRendu\": ");

			sb.append("\"");

			sb.append(_escape(visiteRequestBody.getCompteRendu()));

			sb.append("\"");
		}

		if (visiteRequestBody.getDateVisite() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dateVisite\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(
					visiteRequestBody.getDateVisite()));

			sb.append("\"");
		}

		if (visiteRequestBody.getLatitude() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"latitude\": ");

			sb.append(visiteRequestBody.getLatitude());
		}

		if (visiteRequestBody.getLongitude() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"longitude\": ");

			sb.append(visiteRequestBody.getLongitude());
		}

		if (visiteRequestBody.getStatut() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"statut\": ");

			sb.append("\"");

			sb.append(visiteRequestBody.getStatut());

			sb.append("\"");
		}

		if (visiteRequestBody.getTerminalId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"terminalId\": ");

			sb.append(visiteRequestBody.getTerminalId());
		}

		if (visiteRequestBody.getTypeControle() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"typeControle\": ");

			sb.append("\"");

			sb.append(visiteRequestBody.getTypeControle());

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		VisiteRequestBodyJSONParser visiteRequestBodyJSONParser =
			new VisiteRequestBodyJSONParser();

		return visiteRequestBodyJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		VisiteRequestBody visiteRequestBody) {

		if (visiteRequestBody == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (visiteRequestBody.getCommercialId() == null) {
			map.put("commercialId", null);
		}
		else {
			map.put(
				"commercialId",
				String.valueOf(visiteRequestBody.getCommercialId()));
		}

		if (visiteRequestBody.getCompteRendu() == null) {
			map.put("compteRendu", null);
		}
		else {
			map.put(
				"compteRendu",
				String.valueOf(visiteRequestBody.getCompteRendu()));
		}

		if (visiteRequestBody.getDateVisite() == null) {
			map.put("dateVisite", null);
		}
		else {
			map.put(
				"dateVisite",
				liferayToJSONDateFormat.format(
					visiteRequestBody.getDateVisite()));
		}

		if (visiteRequestBody.getLatitude() == null) {
			map.put("latitude", null);
		}
		else {
			map.put(
				"latitude", String.valueOf(visiteRequestBody.getLatitude()));
		}

		if (visiteRequestBody.getLongitude() == null) {
			map.put("longitude", null);
		}
		else {
			map.put(
				"longitude", String.valueOf(visiteRequestBody.getLongitude()));
		}

		if (visiteRequestBody.getStatut() == null) {
			map.put("statut", null);
		}
		else {
			map.put("statut", String.valueOf(visiteRequestBody.getStatut()));
		}

		if (visiteRequestBody.getTerminalId() == null) {
			map.put("terminalId", null);
		}
		else {
			map.put(
				"terminalId",
				String.valueOf(visiteRequestBody.getTerminalId()));
		}

		if (visiteRequestBody.getTypeControle() == null) {
			map.put("typeControle", null);
		}
		else {
			map.put(
				"typeControle",
				String.valueOf(visiteRequestBody.getTypeControle()));
		}

		return map;
	}

	public static class VisiteRequestBodyJSONParser
		extends BaseJSONParser<VisiteRequestBody> {

		@Override
		protected VisiteRequestBody createDTO() {
			return new VisiteRequestBody();
		}

		@Override
		protected VisiteRequestBody[] createDTOArray(int size) {
			return new VisiteRequestBody[size];
		}

		@Override
		protected void setField(
			VisiteRequestBody visiteRequestBody, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "commercialId")) {
				if (jsonParserFieldValue != null) {
					visiteRequestBody.setCommercialId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "compteRendu")) {
				if (jsonParserFieldValue != null) {
					visiteRequestBody.setCompteRendu(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "dateVisite")) {
				if (jsonParserFieldValue != null) {
					visiteRequestBody.setDateVisite(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "latitude")) {
				if (jsonParserFieldValue != null) {
					visiteRequestBody.setLatitude(
						Double.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "longitude")) {
				if (jsonParserFieldValue != null) {
					visiteRequestBody.setLongitude(
						Double.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "statut")) {
				if (jsonParserFieldValue != null) {
					visiteRequestBody.setStatut(
						VisiteRequestBody.Statut.create(
							(String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "terminalId")) {
				if (jsonParserFieldValue != null) {
					visiteRequestBody.setTerminalId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "typeControle")) {
				if (jsonParserFieldValue != null) {
					visiteRequestBody.setTypeControle(
						VisiteRequestBody.TypeControle.create(
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