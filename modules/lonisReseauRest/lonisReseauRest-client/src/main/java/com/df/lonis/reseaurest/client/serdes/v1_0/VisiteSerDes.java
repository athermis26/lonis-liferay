package com.df.lonis.reseaurest.client.serdes.v1_0;

import com.df.lonis.reseaurest.client.dto.v1_0.Visite;
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
public class VisiteSerDes {

	public static Visite toDTO(String json) {
		VisiteJSONParser visiteJSONParser = new VisiteJSONParser();

		return visiteJSONParser.parseToDTO(json);
	}

	public static Visite[] toDTOs(String json) {
		VisiteJSONParser visiteJSONParser = new VisiteJSONParser();

		return visiteJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Visite visite) {
		if (visite == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (visite.getCommercialId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"commercialId\": ");

			sb.append(visite.getCommercialId());
		}

		if (visite.getCompteRendu() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"compteRendu\": ");

			sb.append("\"");

			sb.append(_escape(visite.getCompteRendu()));

			sb.append("\"");
		}

		if (visite.getDateVisite() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dateVisite\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(visite.getDateVisite()));

			sb.append("\"");
		}

		if (visite.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(visite.getId());
		}

		if (visite.getLatitude() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"latitude\": ");

			sb.append(visite.getLatitude());
		}

		if (visite.getLongitude() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"longitude\": ");

			sb.append(visite.getLongitude());
		}

		if (visite.getStatut() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"statut\": ");

			sb.append("\"");

			sb.append(visite.getStatut());

			sb.append("\"");
		}

		if (visite.getTerminalId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"terminalId\": ");

			sb.append(visite.getTerminalId());
		}

		if (visite.getTypeControle() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"typeControle\": ");

			sb.append("\"");

			sb.append(visite.getTypeControle());

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		VisiteJSONParser visiteJSONParser = new VisiteJSONParser();

		return visiteJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Visite visite) {
		if (visite == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (visite.getCommercialId() == null) {
			map.put("commercialId", null);
		}
		else {
			map.put("commercialId", String.valueOf(visite.getCommercialId()));
		}

		if (visite.getCompteRendu() == null) {
			map.put("compteRendu", null);
		}
		else {
			map.put("compteRendu", String.valueOf(visite.getCompteRendu()));
		}

		if (visite.getDateVisite() == null) {
			map.put("dateVisite", null);
		}
		else {
			map.put(
				"dateVisite",
				liferayToJSONDateFormat.format(visite.getDateVisite()));
		}

		if (visite.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(visite.getId()));
		}

		if (visite.getLatitude() == null) {
			map.put("latitude", null);
		}
		else {
			map.put("latitude", String.valueOf(visite.getLatitude()));
		}

		if (visite.getLongitude() == null) {
			map.put("longitude", null);
		}
		else {
			map.put("longitude", String.valueOf(visite.getLongitude()));
		}

		if (visite.getStatut() == null) {
			map.put("statut", null);
		}
		else {
			map.put("statut", String.valueOf(visite.getStatut()));
		}

		if (visite.getTerminalId() == null) {
			map.put("terminalId", null);
		}
		else {
			map.put("terminalId", String.valueOf(visite.getTerminalId()));
		}

		if (visite.getTypeControle() == null) {
			map.put("typeControle", null);
		}
		else {
			map.put("typeControle", String.valueOf(visite.getTypeControle()));
		}

		return map;
	}

	public static class VisiteJSONParser extends BaseJSONParser<Visite> {

		@Override
		protected Visite createDTO() {
			return new Visite();
		}

		@Override
		protected Visite[] createDTOArray(int size) {
			return new Visite[size];
		}

		@Override
		protected void setField(
			Visite visite, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "commercialId")) {
				if (jsonParserFieldValue != null) {
					visite.setCommercialId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "compteRendu")) {
				if (jsonParserFieldValue != null) {
					visite.setCompteRendu((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "dateVisite")) {
				if (jsonParserFieldValue != null) {
					visite.setDateVisite(toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					visite.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "latitude")) {
				if (jsonParserFieldValue != null) {
					visite.setLatitude(
						Double.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "longitude")) {
				if (jsonParserFieldValue != null) {
					visite.setLongitude(
						Double.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "statut")) {
				if (jsonParserFieldValue != null) {
					visite.setStatut(
						Visite.Statut.create((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "terminalId")) {
				if (jsonParserFieldValue != null) {
					visite.setTerminalId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "typeControle")) {
				if (jsonParserFieldValue != null) {
					visite.setTypeControle(
						Visite.TypeControle.create(
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