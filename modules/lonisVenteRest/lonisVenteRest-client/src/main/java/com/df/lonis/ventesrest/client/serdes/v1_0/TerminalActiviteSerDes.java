package com.df.lonis.ventesrest.client.serdes.v1_0;

import com.df.lonis.ventesrest.client.dto.v1_0.TerminalActivite;
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
public class TerminalActiviteSerDes {

	public static TerminalActivite toDTO(String json) {
		TerminalActiviteJSONParser terminalActiviteJSONParser =
			new TerminalActiviteJSONParser();

		return terminalActiviteJSONParser.parseToDTO(json);
	}

	public static TerminalActivite[] toDTOs(String json) {
		TerminalActiviteJSONParser terminalActiviteJSONParser =
			new TerminalActiviteJSONParser();

		return terminalActiviteJSONParser.parseToDTOs(json);
	}

	public static String toJSON(TerminalActivite terminalActivite) {
		if (terminalActivite == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (terminalActivite.getChiffreAffaires() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"chiffreAffaires\": ");

			sb.append(terminalActivite.getChiffreAffaires());
		}

		if (terminalActivite.getCodeTerminal() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"codeTerminal\": ");

			sb.append("\"");

			sb.append(_escape(terminalActivite.getCodeTerminal()));

			sb.append("\"");
		}

		if (terminalActivite.getConcessionnaireId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"concessionnaireId\": ");

			sb.append(terminalActivite.getConcessionnaireId());
		}

		if (terminalActivite.getConcessionnaireNomPrenom() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"concessionnaireNomPrenom\": ");

			sb.append("\"");

			sb.append(_escape(terminalActivite.getConcessionnaireNomPrenom()));

			sb.append("\"");
		}

		if (terminalActivite.getConcessionnaireProduitCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"concessionnaireProduitCode\": ");

			sb.append("\"");

			sb.append(
				_escape(terminalActivite.getConcessionnaireProduitCode()));

			sb.append("\"");
		}

		if (terminalActivite.getNombreOperations() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"nombreOperations\": ");

			sb.append(terminalActivite.getNombreOperations());
		}

		if (terminalActivite.getNombreRechargements() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"nombreRechargements\": ");

			sb.append(terminalActivite.getNombreRechargements());
		}

		if (terminalActivite.getProduitCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"produitCode\": ");

			sb.append("\"");

			sb.append(_escape(terminalActivite.getProduitCode()));

			sb.append("\"");
		}

		if (terminalActivite.getProduitLibelle() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"produitLibelle\": ");

			sb.append("\"");

			sb.append(_escape(terminalActivite.getProduitLibelle()));

			sb.append("\"");
		}

		if (terminalActivite.getSiteLibelle() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"siteLibelle\": ");

			sb.append("\"");

			sb.append(_escape(terminalActivite.getSiteLibelle()));

			sb.append("\"");
		}

		if (terminalActivite.getSolde() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"solde\": ");

			sb.append(terminalActivite.getSolde());
		}

		if (terminalActivite.getTerminalId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"terminalId\": ");

			sb.append(terminalActivite.getTerminalId());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		TerminalActiviteJSONParser terminalActiviteJSONParser =
			new TerminalActiviteJSONParser();

		return terminalActiviteJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(TerminalActivite terminalActivite) {
		if (terminalActivite == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (terminalActivite.getChiffreAffaires() == null) {
			map.put("chiffreAffaires", null);
		}
		else {
			map.put(
				"chiffreAffaires",
				String.valueOf(terminalActivite.getChiffreAffaires()));
		}

		if (terminalActivite.getCodeTerminal() == null) {
			map.put("codeTerminal", null);
		}
		else {
			map.put(
				"codeTerminal",
				String.valueOf(terminalActivite.getCodeTerminal()));
		}

		if (terminalActivite.getConcessionnaireId() == null) {
			map.put("concessionnaireId", null);
		}
		else {
			map.put(
				"concessionnaireId",
				String.valueOf(terminalActivite.getConcessionnaireId()));
		}

		if (terminalActivite.getConcessionnaireNomPrenom() == null) {
			map.put("concessionnaireNomPrenom", null);
		}
		else {
			map.put(
				"concessionnaireNomPrenom",
				String.valueOf(terminalActivite.getConcessionnaireNomPrenom()));
		}

		if (terminalActivite.getConcessionnaireProduitCode() == null) {
			map.put("concessionnaireProduitCode", null);
		}
		else {
			map.put(
				"concessionnaireProduitCode",
				String.valueOf(
					terminalActivite.getConcessionnaireProduitCode()));
		}

		if (terminalActivite.getNombreOperations() == null) {
			map.put("nombreOperations", null);
		}
		else {
			map.put(
				"nombreOperations",
				String.valueOf(terminalActivite.getNombreOperations()));
		}

		if (terminalActivite.getNombreRechargements() == null) {
			map.put("nombreRechargements", null);
		}
		else {
			map.put(
				"nombreRechargements",
				String.valueOf(terminalActivite.getNombreRechargements()));
		}

		if (terminalActivite.getProduitCode() == null) {
			map.put("produitCode", null);
		}
		else {
			map.put(
				"produitCode",
				String.valueOf(terminalActivite.getProduitCode()));
		}

		if (terminalActivite.getProduitLibelle() == null) {
			map.put("produitLibelle", null);
		}
		else {
			map.put(
				"produitLibelle",
				String.valueOf(terminalActivite.getProduitLibelle()));
		}

		if (terminalActivite.getSiteLibelle() == null) {
			map.put("siteLibelle", null);
		}
		else {
			map.put(
				"siteLibelle",
				String.valueOf(terminalActivite.getSiteLibelle()));
		}

		if (terminalActivite.getSolde() == null) {
			map.put("solde", null);
		}
		else {
			map.put("solde", String.valueOf(terminalActivite.getSolde()));
		}

		if (terminalActivite.getTerminalId() == null) {
			map.put("terminalId", null);
		}
		else {
			map.put(
				"terminalId", String.valueOf(terminalActivite.getTerminalId()));
		}

		return map;
	}

	public static class TerminalActiviteJSONParser
		extends BaseJSONParser<TerminalActivite> {

		@Override
		protected TerminalActivite createDTO() {
			return new TerminalActivite();
		}

		@Override
		protected TerminalActivite[] createDTOArray(int size) {
			return new TerminalActivite[size];
		}

		@Override
		protected void setField(
			TerminalActivite terminalActivite, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "chiffreAffaires")) {
				if (jsonParserFieldValue != null) {
					terminalActivite.setChiffreAffaires(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "codeTerminal")) {
				if (jsonParserFieldValue != null) {
					terminalActivite.setCodeTerminal(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "concessionnaireId")) {
				if (jsonParserFieldValue != null) {
					terminalActivite.setConcessionnaireId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "concessionnaireNomPrenom")) {

				if (jsonParserFieldValue != null) {
					terminalActivite.setConcessionnaireNomPrenom(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "concessionnaireProduitCode")) {

				if (jsonParserFieldValue != null) {
					terminalActivite.setConcessionnaireProduitCode(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "nombreOperations")) {
				if (jsonParserFieldValue != null) {
					terminalActivite.setNombreOperations(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "nombreRechargements")) {

				if (jsonParserFieldValue != null) {
					terminalActivite.setNombreRechargements(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "produitCode")) {
				if (jsonParserFieldValue != null) {
					terminalActivite.setProduitCode(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "produitLibelle")) {
				if (jsonParserFieldValue != null) {
					terminalActivite.setProduitLibelle(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "siteLibelle")) {
				if (jsonParserFieldValue != null) {
					terminalActivite.setSiteLibelle(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "solde")) {
				if (jsonParserFieldValue != null) {
					terminalActivite.setSolde(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "terminalId")) {
				if (jsonParserFieldValue != null) {
					terminalActivite.setTerminalId(
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