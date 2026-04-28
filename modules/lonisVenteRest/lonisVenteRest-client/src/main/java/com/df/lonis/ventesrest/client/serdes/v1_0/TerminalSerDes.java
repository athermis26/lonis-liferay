package com.df.lonis.ventesrest.client.serdes.v1_0;

import com.df.lonis.ventesrest.client.dto.v1_0.Terminal;
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
public class TerminalSerDes {

	public static Terminal toDTO(String json) {
		TerminalJSONParser terminalJSONParser = new TerminalJSONParser();

		return terminalJSONParser.parseToDTO(json);
	}

	public static Terminal[] toDTOs(String json) {
		TerminalJSONParser terminalJSONParser = new TerminalJSONParser();

		return terminalJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Terminal terminal) {
		if (terminal == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (terminal.getCodeTerminal() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"codeTerminal\": ");

			sb.append("\"");

			sb.append(_escape(terminal.getCodeTerminal()));

			sb.append("\"");
		}

		if (terminal.getConcessionnaireCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"concessionnaireCode\": ");

			sb.append("\"");

			sb.append(_escape(terminal.getConcessionnaireCode()));

			sb.append("\"");
		}

		if (terminal.getConcessionnaireId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"concessionnaireId\": ");

			sb.append(terminal.getConcessionnaireId());
		}

		if (terminal.getConcessionnaireProduitCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"concessionnaireProduitCode\": ");

			sb.append("\"");

			sb.append(_escape(terminal.getConcessionnaireProduitCode()));

			sb.append("\"");
		}

		if (terminal.getCreatedAt() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"createdAt\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(terminal.getCreatedAt()));

			sb.append("\"");
		}

		if (terminal.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(terminal.getId());
		}

		if (terminal.getProduit() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"produit\": ");

			sb.append(String.valueOf(terminal.getProduit()));
		}

		if (terminal.getProduitId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"produitId\": ");

			sb.append(terminal.getProduitId());
		}

		if (terminal.getSite() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"site\": ");

			sb.append(String.valueOf(terminal.getSite()));
		}

		if (terminal.getSiteId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"siteId\": ");

			sb.append(terminal.getSiteId());
		}

		if (terminal.getSolde() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"solde\": ");

			sb.append(terminal.getSolde());
		}

		if (terminal.getUpdatedAt() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"updatedAt\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(terminal.getUpdatedAt()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		TerminalJSONParser terminalJSONParser = new TerminalJSONParser();

		return terminalJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Terminal terminal) {
		if (terminal == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (terminal.getCodeTerminal() == null) {
			map.put("codeTerminal", null);
		}
		else {
			map.put("codeTerminal", String.valueOf(terminal.getCodeTerminal()));
		}

		if (terminal.getConcessionnaireCode() == null) {
			map.put("concessionnaireCode", null);
		}
		else {
			map.put(
				"concessionnaireCode",
				String.valueOf(terminal.getConcessionnaireCode()));
		}

		if (terminal.getConcessionnaireId() == null) {
			map.put("concessionnaireId", null);
		}
		else {
			map.put(
				"concessionnaireId",
				String.valueOf(terminal.getConcessionnaireId()));
		}

		if (terminal.getConcessionnaireProduitCode() == null) {
			map.put("concessionnaireProduitCode", null);
		}
		else {
			map.put(
				"concessionnaireProduitCode",
				String.valueOf(terminal.getConcessionnaireProduitCode()));
		}

		if (terminal.getCreatedAt() == null) {
			map.put("createdAt", null);
		}
		else {
			map.put(
				"createdAt",
				liferayToJSONDateFormat.format(terminal.getCreatedAt()));
		}

		if (terminal.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(terminal.getId()));
		}

		if (terminal.getProduit() == null) {
			map.put("produit", null);
		}
		else {
			map.put("produit", String.valueOf(terminal.getProduit()));
		}

		if (terminal.getProduitId() == null) {
			map.put("produitId", null);
		}
		else {
			map.put("produitId", String.valueOf(terminal.getProduitId()));
		}

		if (terminal.getSite() == null) {
			map.put("site", null);
		}
		else {
			map.put("site", String.valueOf(terminal.getSite()));
		}

		if (terminal.getSiteId() == null) {
			map.put("siteId", null);
		}
		else {
			map.put("siteId", String.valueOf(terminal.getSiteId()));
		}

		if (terminal.getSolde() == null) {
			map.put("solde", null);
		}
		else {
			map.put("solde", String.valueOf(terminal.getSolde()));
		}

		if (terminal.getUpdatedAt() == null) {
			map.put("updatedAt", null);
		}
		else {
			map.put(
				"updatedAt",
				liferayToJSONDateFormat.format(terminal.getUpdatedAt()));
		}

		return map;
	}

	public static class TerminalJSONParser extends BaseJSONParser<Terminal> {

		@Override
		protected Terminal createDTO() {
			return new Terminal();
		}

		@Override
		protected Terminal[] createDTOArray(int size) {
			return new Terminal[size];
		}

		@Override
		protected void setField(
			Terminal terminal, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "codeTerminal")) {
				if (jsonParserFieldValue != null) {
					terminal.setCodeTerminal((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "concessionnaireCode")) {

				if (jsonParserFieldValue != null) {
					terminal.setConcessionnaireCode(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "concessionnaireId")) {
				if (jsonParserFieldValue != null) {
					terminal.setConcessionnaireId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "concessionnaireProduitCode")) {

				if (jsonParserFieldValue != null) {
					terminal.setConcessionnaireProduitCode(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "createdAt")) {
				if (jsonParserFieldValue != null) {
					terminal.setCreatedAt(toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					terminal.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "produit")) {
				if (jsonParserFieldValue != null) {
					terminal.setProduit(
						ProduitSerDes.toDTO((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "produitId")) {
				if (jsonParserFieldValue != null) {
					terminal.setProduitId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "site")) {
				if (jsonParserFieldValue != null) {
					terminal.setSite(
						SiteSerDes.toDTO((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "siteId")) {
				if (jsonParserFieldValue != null) {
					terminal.setSiteId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "solde")) {
				if (jsonParserFieldValue != null) {
					terminal.setSolde(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "updatedAt")) {
				if (jsonParserFieldValue != null) {
					terminal.setUpdatedAt(toDate((String)jsonParserFieldValue));
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