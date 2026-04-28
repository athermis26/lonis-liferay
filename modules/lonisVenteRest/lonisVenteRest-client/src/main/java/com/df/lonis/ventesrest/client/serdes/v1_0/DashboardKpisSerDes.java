package com.df.lonis.ventesrest.client.serdes.v1_0;

import com.df.lonis.ventesrest.client.dto.v1_0.DashboardKpis;
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
public class DashboardKpisSerDes {

	public static DashboardKpis toDTO(String json) {
		DashboardKpisJSONParser dashboardKpisJSONParser =
			new DashboardKpisJSONParser();

		return dashboardKpisJSONParser.parseToDTO(json);
	}

	public static DashboardKpis[] toDTOs(String json) {
		DashboardKpisJSONParser dashboardKpisJSONParser =
			new DashboardKpisJSONParser();

		return dashboardKpisJSONParser.parseToDTOs(json);
	}

	public static String toJSON(DashboardKpis dashboardKpis) {
		if (dashboardKpis == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (dashboardKpis.getChiffreAffairesTotal() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"chiffreAffairesTotal\": ");

			sb.append(dashboardKpis.getChiffreAffairesTotal());
		}

		if (dashboardKpis.getPaiementsTotal() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"paiementsTotal\": ");

			sb.append(dashboardKpis.getPaiementsTotal());
		}

		if (dashboardKpis.getTotalConcessionnaires() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"totalConcessionnaires\": ");

			sb.append(dashboardKpis.getTotalConcessionnaires());
		}

		if (dashboardKpis.getTotalPointsDeVente() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"totalPointsDeVente\": ");

			sb.append(dashboardKpis.getTotalPointsDeVente());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		DashboardKpisJSONParser dashboardKpisJSONParser =
			new DashboardKpisJSONParser();

		return dashboardKpisJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(DashboardKpis dashboardKpis) {
		if (dashboardKpis == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (dashboardKpis.getChiffreAffairesTotal() == null) {
			map.put("chiffreAffairesTotal", null);
		}
		else {
			map.put(
				"chiffreAffairesTotal",
				String.valueOf(dashboardKpis.getChiffreAffairesTotal()));
		}

		if (dashboardKpis.getPaiementsTotal() == null) {
			map.put("paiementsTotal", null);
		}
		else {
			map.put(
				"paiementsTotal",
				String.valueOf(dashboardKpis.getPaiementsTotal()));
		}

		if (dashboardKpis.getTotalConcessionnaires() == null) {
			map.put("totalConcessionnaires", null);
		}
		else {
			map.put(
				"totalConcessionnaires",
				String.valueOf(dashboardKpis.getTotalConcessionnaires()));
		}

		if (dashboardKpis.getTotalPointsDeVente() == null) {
			map.put("totalPointsDeVente", null);
		}
		else {
			map.put(
				"totalPointsDeVente",
				String.valueOf(dashboardKpis.getTotalPointsDeVente()));
		}

		return map;
	}

	public static class DashboardKpisJSONParser
		extends BaseJSONParser<DashboardKpis> {

		@Override
		protected DashboardKpis createDTO() {
			return new DashboardKpis();
		}

		@Override
		protected DashboardKpis[] createDTOArray(int size) {
			return new DashboardKpis[size];
		}

		@Override
		protected void setField(
			DashboardKpis dashboardKpis, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "chiffreAffairesTotal")) {
				if (jsonParserFieldValue != null) {
					dashboardKpis.setChiffreAffairesTotal(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "paiementsTotal")) {
				if (jsonParserFieldValue != null) {
					dashboardKpis.setPaiementsTotal(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "totalConcessionnaires")) {

				if (jsonParserFieldValue != null) {
					dashboardKpis.setTotalConcessionnaires(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "totalPointsDeVente")) {

				if (jsonParserFieldValue != null) {
					dashboardKpis.setTotalPointsDeVente(
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