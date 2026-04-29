package com.df.lonis.ventesrest.client.serdes.v1_0;

import com.df.lonis.ventesrest.client.dto.v1_0.CommissionDetail;
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
public class CommissionDetailSerDes {

	public static CommissionDetail toDTO(String json) {
		CommissionDetailJSONParser commissionDetailJSONParser =
			new CommissionDetailJSONParser();

		return commissionDetailJSONParser.parseToDTO(json);
	}

	public static CommissionDetail[] toDTOs(String json) {
		CommissionDetailJSONParser commissionDetailJSONParser =
			new CommissionDetailJSONParser();

		return commissionDetailJSONParser.parseToDTOs(json);
	}

	public static String toJSON(CommissionDetail commissionDetail) {
		if (commissionDetail == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (commissionDetail.getChiffreAffaires() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"chiffreAffaires\": ");

			sb.append(commissionDetail.getChiffreAffaires());
		}

		if (commissionDetail.getCodeTerminal() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"codeTerminal\": ");

			sb.append("\"");

			sb.append(_escape(commissionDetail.getCodeTerminal()));

			sb.append("\"");
		}

		if (commissionDetail.getCommissionVersee() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"commissionVersee\": ");

			sb.append(commissionDetail.getCommissionVersee());
		}

		if (commissionDetail.getCompteReception() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"compteReception\": ");

			sb.append("\"");

			sb.append(_escape(commissionDetail.getCompteReception()));

			sb.append("\"");
		}

		if (commissionDetail.getDateVersement() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dateVersement\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(
					commissionDetail.getDateVersement()));

			sb.append("\"");
		}

		if (commissionDetail.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(commissionDetail.getId());
		}

		if (commissionDetail.getPaye() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"paye\": ");

			sb.append(commissionDetail.getPaye());
		}

		if (commissionDetail.getStatus() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"status\": ");

			sb.append("\"");

			sb.append(_escape(commissionDetail.getStatus()));

			sb.append("\"");
		}

		if (commissionDetail.getTypeVersement() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"typeVersement\": ");

			sb.append("\"");

			sb.append(_escape(commissionDetail.getTypeVersement()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		CommissionDetailJSONParser commissionDetailJSONParser =
			new CommissionDetailJSONParser();

		return commissionDetailJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(CommissionDetail commissionDetail) {
		if (commissionDetail == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (commissionDetail.getChiffreAffaires() == null) {
			map.put("chiffreAffaires", null);
		}
		else {
			map.put(
				"chiffreAffaires",
				String.valueOf(commissionDetail.getChiffreAffaires()));
		}

		if (commissionDetail.getCodeTerminal() == null) {
			map.put("codeTerminal", null);
		}
		else {
			map.put(
				"codeTerminal",
				String.valueOf(commissionDetail.getCodeTerminal()));
		}

		if (commissionDetail.getCommissionVersee() == null) {
			map.put("commissionVersee", null);
		}
		else {
			map.put(
				"commissionVersee",
				String.valueOf(commissionDetail.getCommissionVersee()));
		}

		if (commissionDetail.getCompteReception() == null) {
			map.put("compteReception", null);
		}
		else {
			map.put(
				"compteReception",
				String.valueOf(commissionDetail.getCompteReception()));
		}

		if (commissionDetail.getDateVersement() == null) {
			map.put("dateVersement", null);
		}
		else {
			map.put(
				"dateVersement",
				liferayToJSONDateFormat.format(
					commissionDetail.getDateVersement()));
		}

		if (commissionDetail.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(commissionDetail.getId()));
		}

		if (commissionDetail.getPaye() == null) {
			map.put("paye", null);
		}
		else {
			map.put("paye", String.valueOf(commissionDetail.getPaye()));
		}

		if (commissionDetail.getStatus() == null) {
			map.put("status", null);
		}
		else {
			map.put("status", String.valueOf(commissionDetail.getStatus()));
		}

		if (commissionDetail.getTypeVersement() == null) {
			map.put("typeVersement", null);
		}
		else {
			map.put(
				"typeVersement",
				String.valueOf(commissionDetail.getTypeVersement()));
		}

		return map;
	}

	public static class CommissionDetailJSONParser
		extends BaseJSONParser<CommissionDetail> {

		@Override
		protected CommissionDetail createDTO() {
			return new CommissionDetail();
		}

		@Override
		protected CommissionDetail[] createDTOArray(int size) {
			return new CommissionDetail[size];
		}

		@Override
		protected void setField(
			CommissionDetail commissionDetail, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "chiffreAffaires")) {
				if (jsonParserFieldValue != null) {
					commissionDetail.setChiffreAffaires(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "codeTerminal")) {
				if (jsonParserFieldValue != null) {
					commissionDetail.setCodeTerminal(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "commissionVersee")) {
				if (jsonParserFieldValue != null) {
					commissionDetail.setCommissionVersee(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "compteReception")) {
				if (jsonParserFieldValue != null) {
					commissionDetail.setCompteReception(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "dateVersement")) {
				if (jsonParserFieldValue != null) {
					commissionDetail.setDateVersement(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					commissionDetail.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "paye")) {
				if (jsonParserFieldValue != null) {
					commissionDetail.setPaye((Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "status")) {
				if (jsonParserFieldValue != null) {
					commissionDetail.setStatus((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "typeVersement")) {
				if (jsonParserFieldValue != null) {
					commissionDetail.setTypeVersement(
						(String)jsonParserFieldValue);
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