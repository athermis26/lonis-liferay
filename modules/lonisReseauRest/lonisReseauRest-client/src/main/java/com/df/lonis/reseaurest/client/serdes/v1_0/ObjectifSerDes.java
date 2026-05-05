package com.df.lonis.reseaurest.client.serdes.v1_0;

import com.df.lonis.reseaurest.client.dto.v1_0.Objectif;
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
public class ObjectifSerDes {

	public static Objectif toDTO(String json) {
		ObjectifJSONParser objectifJSONParser = new ObjectifJSONParser();

		return objectifJSONParser.parseToDTO(json);
	}

	public static Objectif[] toDTOs(String json) {
		ObjectifJSONParser objectifJSONParser = new ObjectifJSONParser();

		return objectifJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Objectif objectif) {
		if (objectif == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (objectif.getAnnee() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"annee\": ");

			sb.append(objectif.getAnnee());
		}

		if (objectif.getCommercialId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"commercialId\": ");

			sb.append(objectif.getCommercialId());
		}

		if (objectif.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(objectif.getId());
		}

		if (objectif.getMois() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"mois\": ");

			sb.append(objectif.getMois());
		}

		if (objectif.getPeriode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"periode\": ");

			sb.append("\"");

			sb.append(objectif.getPeriode());

			sb.append("\"");
		}

		if (objectif.getTrimestre() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"trimestre\": ");

			sb.append(objectif.getTrimestre());
		}

		if (objectif.getType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"type\": ");

			sb.append("\"");

			sb.append(objectif.getType());

			sb.append("\"");
		}

		if (objectif.getValeurCible() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"valeurCible\": ");

			sb.append(objectif.getValeurCible());
		}

		if (objectif.getValeurReelle() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"valeurReelle\": ");

			sb.append(objectif.getValeurReelle());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ObjectifJSONParser objectifJSONParser = new ObjectifJSONParser();

		return objectifJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Objectif objectif) {
		if (objectif == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (objectif.getAnnee() == null) {
			map.put("annee", null);
		}
		else {
			map.put("annee", String.valueOf(objectif.getAnnee()));
		}

		if (objectif.getCommercialId() == null) {
			map.put("commercialId", null);
		}
		else {
			map.put("commercialId", String.valueOf(objectif.getCommercialId()));
		}

		if (objectif.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(objectif.getId()));
		}

		if (objectif.getMois() == null) {
			map.put("mois", null);
		}
		else {
			map.put("mois", String.valueOf(objectif.getMois()));
		}

		if (objectif.getPeriode() == null) {
			map.put("periode", null);
		}
		else {
			map.put("periode", String.valueOf(objectif.getPeriode()));
		}

		if (objectif.getTrimestre() == null) {
			map.put("trimestre", null);
		}
		else {
			map.put("trimestre", String.valueOf(objectif.getTrimestre()));
		}

		if (objectif.getType() == null) {
			map.put("type", null);
		}
		else {
			map.put("type", String.valueOf(objectif.getType()));
		}

		if (objectif.getValeurCible() == null) {
			map.put("valeurCible", null);
		}
		else {
			map.put("valeurCible", String.valueOf(objectif.getValeurCible()));
		}

		if (objectif.getValeurReelle() == null) {
			map.put("valeurReelle", null);
		}
		else {
			map.put("valeurReelle", String.valueOf(objectif.getValeurReelle()));
		}

		return map;
	}

	public static class ObjectifJSONParser extends BaseJSONParser<Objectif> {

		@Override
		protected Objectif createDTO() {
			return new Objectif();
		}

		@Override
		protected Objectif[] createDTOArray(int size) {
			return new Objectif[size];
		}

		@Override
		protected void setField(
			Objectif objectif, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "annee")) {
				if (jsonParserFieldValue != null) {
					objectif.setAnnee(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "commercialId")) {
				if (jsonParserFieldValue != null) {
					objectif.setCommercialId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					objectif.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "mois")) {
				if (jsonParserFieldValue != null) {
					objectif.setMois(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "periode")) {
				if (jsonParserFieldValue != null) {
					objectif.setPeriode(
						Objectif.Periode.create((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "trimestre")) {
				if (jsonParserFieldValue != null) {
					objectif.setTrimestre(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "type")) {
				if (jsonParserFieldValue != null) {
					objectif.setType(
						Objectif.Type.create((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "valeurCible")) {
				if (jsonParserFieldValue != null) {
					objectif.setValeurCible(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "valeurReelle")) {
				if (jsonParserFieldValue != null) {
					objectif.setValeurReelle(
						Integer.valueOf((String)jsonParserFieldValue));
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