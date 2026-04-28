package com.df.lonis.ventesrest.client.serdes.v1_0;

import com.df.lonis.ventesrest.client.dto.v1_0.ConcessionnaireStats;
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
public class ConcessionnaireStatsSerDes {

	public static ConcessionnaireStats toDTO(String json) {
		ConcessionnaireStatsJSONParser concessionnaireStatsJSONParser =
			new ConcessionnaireStatsJSONParser();

		return concessionnaireStatsJSONParser.parseToDTO(json);
	}

	public static ConcessionnaireStats[] toDTOs(String json) {
		ConcessionnaireStatsJSONParser concessionnaireStatsJSONParser =
			new ConcessionnaireStatsJSONParser();

		return concessionnaireStatsJSONParser.parseToDTOs(json);
	}

	public static String toJSON(ConcessionnaireStats concessionnaireStats) {
		if (concessionnaireStats == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (concessionnaireStats.getChiffreAffaires() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"chiffreAffaires\": ");

			sb.append(concessionnaireStats.getChiffreAffaires());
		}

		if (concessionnaireStats.getTotalOperations() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"totalOperations\": ");

			sb.append(concessionnaireStats.getTotalOperations());
		}

		if (concessionnaireStats.getTotalPaiements() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"totalPaiements\": ");

			sb.append(concessionnaireStats.getTotalPaiements());
		}

		if (concessionnaireStats.getTotalProduits() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"totalProduits\": ");

			sb.append(concessionnaireStats.getTotalProduits());
		}

		if (concessionnaireStats.getTotalTerminaux() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"totalTerminaux\": ");

			sb.append(concessionnaireStats.getTotalTerminaux());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ConcessionnaireStatsJSONParser concessionnaireStatsJSONParser =
			new ConcessionnaireStatsJSONParser();

		return concessionnaireStatsJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		ConcessionnaireStats concessionnaireStats) {

		if (concessionnaireStats == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (concessionnaireStats.getChiffreAffaires() == null) {
			map.put("chiffreAffaires", null);
		}
		else {
			map.put(
				"chiffreAffaires",
				String.valueOf(concessionnaireStats.getChiffreAffaires()));
		}

		if (concessionnaireStats.getTotalOperations() == null) {
			map.put("totalOperations", null);
		}
		else {
			map.put(
				"totalOperations",
				String.valueOf(concessionnaireStats.getTotalOperations()));
		}

		if (concessionnaireStats.getTotalPaiements() == null) {
			map.put("totalPaiements", null);
		}
		else {
			map.put(
				"totalPaiements",
				String.valueOf(concessionnaireStats.getTotalPaiements()));
		}

		if (concessionnaireStats.getTotalProduits() == null) {
			map.put("totalProduits", null);
		}
		else {
			map.put(
				"totalProduits",
				String.valueOf(concessionnaireStats.getTotalProduits()));
		}

		if (concessionnaireStats.getTotalTerminaux() == null) {
			map.put("totalTerminaux", null);
		}
		else {
			map.put(
				"totalTerminaux",
				String.valueOf(concessionnaireStats.getTotalTerminaux()));
		}

		return map;
	}

	public static class ConcessionnaireStatsJSONParser
		extends BaseJSONParser<ConcessionnaireStats> {

		@Override
		protected ConcessionnaireStats createDTO() {
			return new ConcessionnaireStats();
		}

		@Override
		protected ConcessionnaireStats[] createDTOArray(int size) {
			return new ConcessionnaireStats[size];
		}

		@Override
		protected void setField(
			ConcessionnaireStats concessionnaireStats,
			String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "chiffreAffaires")) {
				if (jsonParserFieldValue != null) {
					concessionnaireStats.setChiffreAffaires(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "totalOperations")) {
				if (jsonParserFieldValue != null) {
					concessionnaireStats.setTotalOperations(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "totalPaiements")) {
				if (jsonParserFieldValue != null) {
					concessionnaireStats.setTotalPaiements(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "totalProduits")) {
				if (jsonParserFieldValue != null) {
					concessionnaireStats.setTotalProduits(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "totalTerminaux")) {
				if (jsonParserFieldValue != null) {
					concessionnaireStats.setTotalTerminaux(
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