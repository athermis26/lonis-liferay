package com.df.lonis.ventesrest.client.serdes.v1_0;

import com.df.lonis.ventesrest.client.dto.v1_0.Produit;
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
public class ProduitSerDes {

	public static Produit toDTO(String json) {
		ProduitJSONParser produitJSONParser = new ProduitJSONParser();

		return produitJSONParser.parseToDTO(json);
	}

	public static Produit[] toDTOs(String json) {
		ProduitJSONParser produitJSONParser = new ProduitJSONParser();

		return produitJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Produit produit) {
		if (produit == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (produit.getAbreviation() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"abreviation\": ");

			sb.append("\"");

			sb.append(_escape(produit.getAbreviation()));

			sb.append("\"");
		}

		if (produit.getActive() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"active\": ");

			sb.append(produit.getActive());
		}

		if (produit.getCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"code\": ");

			sb.append("\"");

			sb.append(_escape(produit.getCode()));

			sb.append("\"");
		}

		if (produit.getCreatedAt() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"createdAt\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(produit.getCreatedAt()));

			sb.append("\"");
		}

		if (produit.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(produit.getId());
		}

		if (produit.getLibelle() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"libelle\": ");

			sb.append("\"");

			sb.append(_escape(produit.getLibelle()));

			sb.append("\"");
		}

		if (produit.getUpdatedAt() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"updatedAt\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(produit.getUpdatedAt()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ProduitJSONParser produitJSONParser = new ProduitJSONParser();

		return produitJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Produit produit) {
		if (produit == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (produit.getAbreviation() == null) {
			map.put("abreviation", null);
		}
		else {
			map.put("abreviation", String.valueOf(produit.getAbreviation()));
		}

		if (produit.getActive() == null) {
			map.put("active", null);
		}
		else {
			map.put("active", String.valueOf(produit.getActive()));
		}

		if (produit.getCode() == null) {
			map.put("code", null);
		}
		else {
			map.put("code", String.valueOf(produit.getCode()));
		}

		if (produit.getCreatedAt() == null) {
			map.put("createdAt", null);
		}
		else {
			map.put(
				"createdAt",
				liferayToJSONDateFormat.format(produit.getCreatedAt()));
		}

		if (produit.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(produit.getId()));
		}

		if (produit.getLibelle() == null) {
			map.put("libelle", null);
		}
		else {
			map.put("libelle", String.valueOf(produit.getLibelle()));
		}

		if (produit.getUpdatedAt() == null) {
			map.put("updatedAt", null);
		}
		else {
			map.put(
				"updatedAt",
				liferayToJSONDateFormat.format(produit.getUpdatedAt()));
		}

		return map;
	}

	public static class ProduitJSONParser extends BaseJSONParser<Produit> {

		@Override
		protected Produit createDTO() {
			return new Produit();
		}

		@Override
		protected Produit[] createDTOArray(int size) {
			return new Produit[size];
		}

		@Override
		protected void setField(
			Produit produit, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "abreviation")) {
				if (jsonParserFieldValue != null) {
					produit.setAbreviation((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "active")) {
				if (jsonParserFieldValue != null) {
					produit.setActive((Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "code")) {
				if (jsonParserFieldValue != null) {
					produit.setCode((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "createdAt")) {
				if (jsonParserFieldValue != null) {
					produit.setCreatedAt(toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					produit.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "libelle")) {
				if (jsonParserFieldValue != null) {
					produit.setLibelle((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "updatedAt")) {
				if (jsonParserFieldValue != null) {
					produit.setUpdatedAt(toDate((String)jsonParserFieldValue));
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