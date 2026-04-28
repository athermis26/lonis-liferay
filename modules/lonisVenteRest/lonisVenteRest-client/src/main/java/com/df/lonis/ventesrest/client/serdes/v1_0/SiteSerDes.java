package com.df.lonis.ventesrest.client.serdes.v1_0;

import com.df.lonis.ventesrest.client.dto.v1_0.Site;
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
public class SiteSerDes {

	public static Site toDTO(String json) {
		SiteJSONParser siteJSONParser = new SiteJSONParser();

		return siteJSONParser.parseToDTO(json);
	}

	public static Site[] toDTOs(String json) {
		SiteJSONParser siteJSONParser = new SiteJSONParser();

		return siteJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Site site) {
		if (site == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (site.getCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"code\": ");

			sb.append("\"");

			sb.append(_escape(site.getCode()));

			sb.append("\"");
		}

		if (site.getCodeProvince() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"codeProvince\": ");

			sb.append("\"");

			sb.append(_escape(site.getCodeProvince()));

			sb.append("\"");
		}

		if (site.getCreatedAt() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"createdAt\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(site.getCreatedAt()));

			sb.append("\"");
		}

		if (site.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(site.getId());
		}

		if (site.getLibelle() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"libelle\": ");

			sb.append("\"");

			sb.append(_escape(site.getLibelle()));

			sb.append("\"");
		}

		if (site.getParentId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"parentId\": ");

			sb.append(site.getParentId());
		}

		if (site.getStatus() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"status\": ");

			sb.append(site.getStatus());
		}

		if (site.getType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"type\": ");

			sb.append(site.getType());
		}

		if (site.getUpdatedAt() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"updatedAt\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(site.getUpdatedAt()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		SiteJSONParser siteJSONParser = new SiteJSONParser();

		return siteJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Site site) {
		if (site == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (site.getCode() == null) {
			map.put("code", null);
		}
		else {
			map.put("code", String.valueOf(site.getCode()));
		}

		if (site.getCodeProvince() == null) {
			map.put("codeProvince", null);
		}
		else {
			map.put("codeProvince", String.valueOf(site.getCodeProvince()));
		}

		if (site.getCreatedAt() == null) {
			map.put("createdAt", null);
		}
		else {
			map.put(
				"createdAt",
				liferayToJSONDateFormat.format(site.getCreatedAt()));
		}

		if (site.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(site.getId()));
		}

		if (site.getLibelle() == null) {
			map.put("libelle", null);
		}
		else {
			map.put("libelle", String.valueOf(site.getLibelle()));
		}

		if (site.getParentId() == null) {
			map.put("parentId", null);
		}
		else {
			map.put("parentId", String.valueOf(site.getParentId()));
		}

		if (site.getStatus() == null) {
			map.put("status", null);
		}
		else {
			map.put("status", String.valueOf(site.getStatus()));
		}

		if (site.getType() == null) {
			map.put("type", null);
		}
		else {
			map.put("type", String.valueOf(site.getType()));
		}

		if (site.getUpdatedAt() == null) {
			map.put("updatedAt", null);
		}
		else {
			map.put(
				"updatedAt",
				liferayToJSONDateFormat.format(site.getUpdatedAt()));
		}

		return map;
	}

	public static class SiteJSONParser extends BaseJSONParser<Site> {

		@Override
		protected Site createDTO() {
			return new Site();
		}

		@Override
		protected Site[] createDTOArray(int size) {
			return new Site[size];
		}

		@Override
		protected void setField(
			Site site, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "code")) {
				if (jsonParserFieldValue != null) {
					site.setCode((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "codeProvince")) {
				if (jsonParserFieldValue != null) {
					site.setCodeProvince((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "createdAt")) {
				if (jsonParserFieldValue != null) {
					site.setCreatedAt(toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					site.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "libelle")) {
				if (jsonParserFieldValue != null) {
					site.setLibelle((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "parentId")) {
				if (jsonParserFieldValue != null) {
					site.setParentId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "status")) {
				if (jsonParserFieldValue != null) {
					site.setStatus((Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "type")) {
				if (jsonParserFieldValue != null) {
					site.setType(Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "updatedAt")) {
				if (jsonParserFieldValue != null) {
					site.setUpdatedAt(toDate((String)jsonParserFieldValue));
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