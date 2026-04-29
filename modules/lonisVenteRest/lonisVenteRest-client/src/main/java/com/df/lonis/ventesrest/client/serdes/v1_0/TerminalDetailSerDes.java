package com.df.lonis.ventesrest.client.serdes.v1_0;

import com.df.lonis.ventesrest.client.dto.v1_0.TerminalDetail;
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
public class TerminalDetailSerDes {

	public static TerminalDetail toDTO(String json) {
		TerminalDetailJSONParser terminalDetailJSONParser =
			new TerminalDetailJSONParser();

		return terminalDetailJSONParser.parseToDTO(json);
	}

	public static TerminalDetail[] toDTOs(String json) {
		TerminalDetailJSONParser terminalDetailJSONParser =
			new TerminalDetailJSONParser();

		return terminalDetailJSONParser.parseToDTOs(json);
	}

	public static String toJSON(TerminalDetail terminalDetail) {
		if (terminalDetail == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (terminalDetail.getChiffreAffaires() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"chiffreAffaires\": ");

			sb.append(terminalDetail.getChiffreAffaires());
		}

		if (terminalDetail.getCodeTerminal() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"codeTerminal\": ");

			sb.append("\"");

			sb.append(_escape(terminalDetail.getCodeTerminal()));

			sb.append("\"");
		}

		if (terminalDetail.getConcessionnaireProduitCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"concessionnaireProduitCode\": ");

			sb.append("\"");

			sb.append(_escape(terminalDetail.getConcessionnaireProduitCode()));

			sb.append("\"");
		}

		if (terminalDetail.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(terminalDetail.getId());
		}

		if (terminalDetail.getSiteId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"siteId\": ");

			sb.append(terminalDetail.getSiteId());
		}

		if (terminalDetail.getSolde() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"solde\": ");

			sb.append(terminalDetail.getSolde());
		}

		if (terminalDetail.getTotalOperations() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"totalOperations\": ");

			sb.append(terminalDetail.getTotalOperations());
		}

		if (terminalDetail.getTotalPaiements() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"totalPaiements\": ");

			sb.append(terminalDetail.getTotalPaiements());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		TerminalDetailJSONParser terminalDetailJSONParser =
			new TerminalDetailJSONParser();

		return terminalDetailJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(TerminalDetail terminalDetail) {
		if (terminalDetail == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (terminalDetail.getChiffreAffaires() == null) {
			map.put("chiffreAffaires", null);
		}
		else {
			map.put(
				"chiffreAffaires",
				String.valueOf(terminalDetail.getChiffreAffaires()));
		}

		if (terminalDetail.getCodeTerminal() == null) {
			map.put("codeTerminal", null);
		}
		else {
			map.put(
				"codeTerminal",
				String.valueOf(terminalDetail.getCodeTerminal()));
		}

		if (terminalDetail.getConcessionnaireProduitCode() == null) {
			map.put("concessionnaireProduitCode", null);
		}
		else {
			map.put(
				"concessionnaireProduitCode",
				String.valueOf(terminalDetail.getConcessionnaireProduitCode()));
		}

		if (terminalDetail.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(terminalDetail.getId()));
		}

		if (terminalDetail.getSiteId() == null) {
			map.put("siteId", null);
		}
		else {
			map.put("siteId", String.valueOf(terminalDetail.getSiteId()));
		}

		if (terminalDetail.getSolde() == null) {
			map.put("solde", null);
		}
		else {
			map.put("solde", String.valueOf(terminalDetail.getSolde()));
		}

		if (terminalDetail.getTotalOperations() == null) {
			map.put("totalOperations", null);
		}
		else {
			map.put(
				"totalOperations",
				String.valueOf(terminalDetail.getTotalOperations()));
		}

		if (terminalDetail.getTotalPaiements() == null) {
			map.put("totalPaiements", null);
		}
		else {
			map.put(
				"totalPaiements",
				String.valueOf(terminalDetail.getTotalPaiements()));
		}

		return map;
	}

	public static class TerminalDetailJSONParser
		extends BaseJSONParser<TerminalDetail> {

		@Override
		protected TerminalDetail createDTO() {
			return new TerminalDetail();
		}

		@Override
		protected TerminalDetail[] createDTOArray(int size) {
			return new TerminalDetail[size];
		}

		@Override
		protected void setField(
			TerminalDetail terminalDetail, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "chiffreAffaires")) {
				if (jsonParserFieldValue != null) {
					terminalDetail.setChiffreAffaires(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "codeTerminal")) {
				if (jsonParserFieldValue != null) {
					terminalDetail.setCodeTerminal(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "concessionnaireProduitCode")) {

				if (jsonParserFieldValue != null) {
					terminalDetail.setConcessionnaireProduitCode(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					terminalDetail.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "siteId")) {
				if (jsonParserFieldValue != null) {
					terminalDetail.setSiteId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "solde")) {
				if (jsonParserFieldValue != null) {
					terminalDetail.setSolde(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "totalOperations")) {
				if (jsonParserFieldValue != null) {
					terminalDetail.setTotalOperations(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "totalPaiements")) {
				if (jsonParserFieldValue != null) {
					terminalDetail.setTotalPaiements(
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