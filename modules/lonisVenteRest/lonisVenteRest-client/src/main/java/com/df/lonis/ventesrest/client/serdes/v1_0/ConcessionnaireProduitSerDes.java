package com.df.lonis.ventesrest.client.serdes.v1_0;

import com.df.lonis.ventesrest.client.dto.v1_0.ConcessionnaireProduit;
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
public class ConcessionnaireProduitSerDes {

	public static ConcessionnaireProduit toDTO(String json) {
		ConcessionnaireProduitJSONParser concessionnaireProduitJSONParser =
			new ConcessionnaireProduitJSONParser();

		return concessionnaireProduitJSONParser.parseToDTO(json);
	}

	public static ConcessionnaireProduit[] toDTOs(String json) {
		ConcessionnaireProduitJSONParser concessionnaireProduitJSONParser =
			new ConcessionnaireProduitJSONParser();

		return concessionnaireProduitJSONParser.parseToDTOs(json);
	}

	public static String toJSON(ConcessionnaireProduit concessionnaireProduit) {
		if (concessionnaireProduit == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (concessionnaireProduit.getActive() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"active\": ");

			sb.append(concessionnaireProduit.getActive());
		}

		if (concessionnaireProduit.getChiffreAffaires() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"chiffreAffaires\": ");

			sb.append(concessionnaireProduit.getChiffreAffaires());
		}

		if (concessionnaireProduit.getCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"code\": ");

			sb.append("\"");

			sb.append(_escape(concessionnaireProduit.getCode()));

			sb.append("\"");
		}

		if (concessionnaireProduit.getConcessionnaireCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"concessionnaireCode\": ");

			sb.append("\"");

			sb.append(_escape(concessionnaireProduit.getConcessionnaireCode()));

			sb.append("\"");
		}

		if (concessionnaireProduit.getConcessionnaireId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"concessionnaireId\": ");

			sb.append(concessionnaireProduit.getConcessionnaireId());
		}

		if (concessionnaireProduit.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(concessionnaireProduit.getId());
		}

		if (concessionnaireProduit.getProduit() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"produit\": ");

			sb.append(String.valueOf(concessionnaireProduit.getProduit()));
		}

		if (concessionnaireProduit.getProduitId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"produitId\": ");

			sb.append(concessionnaireProduit.getProduitId());
		}

		if (concessionnaireProduit.getSite() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"site\": ");

			sb.append(String.valueOf(concessionnaireProduit.getSite()));
		}

		if (concessionnaireProduit.getSiteId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"siteId\": ");

			sb.append(concessionnaireProduit.getSiteId());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ConcessionnaireProduitJSONParser concessionnaireProduitJSONParser =
			new ConcessionnaireProduitJSONParser();

		return concessionnaireProduitJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		ConcessionnaireProduit concessionnaireProduit) {

		if (concessionnaireProduit == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (concessionnaireProduit.getActive() == null) {
			map.put("active", null);
		}
		else {
			map.put(
				"active", String.valueOf(concessionnaireProduit.getActive()));
		}

		if (concessionnaireProduit.getChiffreAffaires() == null) {
			map.put("chiffreAffaires", null);
		}
		else {
			map.put(
				"chiffreAffaires",
				String.valueOf(concessionnaireProduit.getChiffreAffaires()));
		}

		if (concessionnaireProduit.getCode() == null) {
			map.put("code", null);
		}
		else {
			map.put("code", String.valueOf(concessionnaireProduit.getCode()));
		}

		if (concessionnaireProduit.getConcessionnaireCode() == null) {
			map.put("concessionnaireCode", null);
		}
		else {
			map.put(
				"concessionnaireCode",
				String.valueOf(
					concessionnaireProduit.getConcessionnaireCode()));
		}

		if (concessionnaireProduit.getConcessionnaireId() == null) {
			map.put("concessionnaireId", null);
		}
		else {
			map.put(
				"concessionnaireId",
				String.valueOf(concessionnaireProduit.getConcessionnaireId()));
		}

		if (concessionnaireProduit.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(concessionnaireProduit.getId()));
		}

		if (concessionnaireProduit.getProduit() == null) {
			map.put("produit", null);
		}
		else {
			map.put(
				"produit", String.valueOf(concessionnaireProduit.getProduit()));
		}

		if (concessionnaireProduit.getProduitId() == null) {
			map.put("produitId", null);
		}
		else {
			map.put(
				"produitId",
				String.valueOf(concessionnaireProduit.getProduitId()));
		}

		if (concessionnaireProduit.getSite() == null) {
			map.put("site", null);
		}
		else {
			map.put("site", String.valueOf(concessionnaireProduit.getSite()));
		}

		if (concessionnaireProduit.getSiteId() == null) {
			map.put("siteId", null);
		}
		else {
			map.put(
				"siteId", String.valueOf(concessionnaireProduit.getSiteId()));
		}

		return map;
	}

	public static class ConcessionnaireProduitJSONParser
		extends BaseJSONParser<ConcessionnaireProduit> {

		@Override
		protected ConcessionnaireProduit createDTO() {
			return new ConcessionnaireProduit();
		}

		@Override
		protected ConcessionnaireProduit[] createDTOArray(int size) {
			return new ConcessionnaireProduit[size];
		}

		@Override
		protected void setField(
			ConcessionnaireProduit concessionnaireProduit,
			String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "active")) {
				if (jsonParserFieldValue != null) {
					concessionnaireProduit.setActive(
						(Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "chiffreAffaires")) {
				if (jsonParserFieldValue != null) {
					concessionnaireProduit.setChiffreAffaires(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "code")) {
				if (jsonParserFieldValue != null) {
					concessionnaireProduit.setCode(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "concessionnaireCode")) {

				if (jsonParserFieldValue != null) {
					concessionnaireProduit.setConcessionnaireCode(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "concessionnaireId")) {
				if (jsonParserFieldValue != null) {
					concessionnaireProduit.setConcessionnaireId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					concessionnaireProduit.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "produit")) {
				if (jsonParserFieldValue != null) {
					concessionnaireProduit.setProduit(
						ProduitSerDes.toDTO((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "produitId")) {
				if (jsonParserFieldValue != null) {
					concessionnaireProduit.setProduitId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "site")) {
				if (jsonParserFieldValue != null) {
					concessionnaireProduit.setSite(
						SiteSerDes.toDTO((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "siteId")) {
				if (jsonParserFieldValue != null) {
					concessionnaireProduit.setSiteId(
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