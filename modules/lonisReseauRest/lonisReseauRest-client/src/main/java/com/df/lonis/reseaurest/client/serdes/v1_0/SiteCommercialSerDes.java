package com.df.lonis.reseaurest.client.serdes.v1_0;

import com.df.lonis.reseaurest.client.dto.v1_0.SiteCommercial;
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
public class SiteCommercialSerDes {

	public static SiteCommercial toDTO(String json) {
		SiteCommercialJSONParser siteCommercialJSONParser =
			new SiteCommercialJSONParser();

		return siteCommercialJSONParser.parseToDTO(json);
	}

	public static SiteCommercial[] toDTOs(String json) {
		SiteCommercialJSONParser siteCommercialJSONParser =
			new SiteCommercialJSONParser();

		return siteCommercialJSONParser.parseToDTOs(json);
	}

	public static String toJSON(SiteCommercial siteCommercial) {
		if (siteCommercial == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (siteCommercial.getCommercialId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"commercialId\": ");

			sb.append(siteCommercial.getCommercialId());
		}

		if (siteCommercial.getDateDebut() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dateDebut\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(siteCommercial.getDateDebut()));

			sb.append("\"");
		}

		if (siteCommercial.getDateFin() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dateFin\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(siteCommercial.getDateFin()));

			sb.append("\"");
		}

		if (siteCommercial.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(siteCommercial.getId());
		}

		if (siteCommercial.getIsPrincipal() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"isPrincipal\": ");

			sb.append(siteCommercial.getIsPrincipal());
		}

		if (siteCommercial.getSiteId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"siteId\": ");

			sb.append(siteCommercial.getSiteId());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		SiteCommercialJSONParser siteCommercialJSONParser =
			new SiteCommercialJSONParser();

		return siteCommercialJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(SiteCommercial siteCommercial) {
		if (siteCommercial == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (siteCommercial.getCommercialId() == null) {
			map.put("commercialId", null);
		}
		else {
			map.put(
				"commercialId",
				String.valueOf(siteCommercial.getCommercialId()));
		}

		if (siteCommercial.getDateDebut() == null) {
			map.put("dateDebut", null);
		}
		else {
			map.put(
				"dateDebut",
				liferayToJSONDateFormat.format(siteCommercial.getDateDebut()));
		}

		if (siteCommercial.getDateFin() == null) {
			map.put("dateFin", null);
		}
		else {
			map.put(
				"dateFin",
				liferayToJSONDateFormat.format(siteCommercial.getDateFin()));
		}

		if (siteCommercial.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(siteCommercial.getId()));
		}

		if (siteCommercial.getIsPrincipal() == null) {
			map.put("isPrincipal", null);
		}
		else {
			map.put(
				"isPrincipal", String.valueOf(siteCommercial.getIsPrincipal()));
		}

		if (siteCommercial.getSiteId() == null) {
			map.put("siteId", null);
		}
		else {
			map.put("siteId", String.valueOf(siteCommercial.getSiteId()));
		}

		return map;
	}

	public static class SiteCommercialJSONParser
		extends BaseJSONParser<SiteCommercial> {

		@Override
		protected SiteCommercial createDTO() {
			return new SiteCommercial();
		}

		@Override
		protected SiteCommercial[] createDTOArray(int size) {
			return new SiteCommercial[size];
		}

		@Override
		protected void setField(
			SiteCommercial siteCommercial, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "commercialId")) {
				if (jsonParserFieldValue != null) {
					siteCommercial.setCommercialId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "dateDebut")) {
				if (jsonParserFieldValue != null) {
					siteCommercial.setDateDebut(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "dateFin")) {
				if (jsonParserFieldValue != null) {
					siteCommercial.setDateFin(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					siteCommercial.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "isPrincipal")) {
				if (jsonParserFieldValue != null) {
					siteCommercial.setIsPrincipal(
						(Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "siteId")) {
				if (jsonParserFieldValue != null) {
					siteCommercial.setSiteId(
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