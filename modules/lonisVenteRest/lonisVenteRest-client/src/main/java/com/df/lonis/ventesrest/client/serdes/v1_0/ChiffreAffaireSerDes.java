package com.df.lonis.ventesrest.client.serdes.v1_0;

import com.df.lonis.ventesrest.client.dto.v1_0.ChiffreAffaire;
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
public class ChiffreAffaireSerDes {

	public static ChiffreAffaire toDTO(String json) {
		ChiffreAffaireJSONParser chiffreAffaireJSONParser =
			new ChiffreAffaireJSONParser();

		return chiffreAffaireJSONParser.parseToDTO(json);
	}

	public static ChiffreAffaire[] toDTOs(String json) {
		ChiffreAffaireJSONParser chiffreAffaireJSONParser =
			new ChiffreAffaireJSONParser();

		return chiffreAffaireJSONParser.parseToDTOs(json);
	}

	public static String toJSON(ChiffreAffaire chiffreAffaire) {
		if (chiffreAffaire == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (chiffreAffaire.getAnnulation() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"annulation\": ");

			sb.append(chiffreAffaire.getAnnulation());
		}

		if (chiffreAffaire.getBalance() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"balance\": ");

			sb.append(chiffreAffaire.getBalance());
		}

		if (chiffreAffaire.getBrut() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"brut\": ");

			sb.append(chiffreAffaire.getBrut());
		}

		if (chiffreAffaire.getChiffreAffaire() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"chiffreAffaire\": ");

			sb.append(chiffreAffaire.getChiffreAffaire());
		}

		if (chiffreAffaire.getCodeProduit() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"codeProduit\": ");

			sb.append("\"");

			sb.append(_escape(chiffreAffaire.getCodeProduit()));

			sb.append("\"");
		}

		if (chiffreAffaire.getCodeTerminal() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"codeTerminal\": ");

			sb.append("\"");

			sb.append(_escape(chiffreAffaire.getCodeTerminal()));

			sb.append("\"");
		}

		if (chiffreAffaire.getConcessionnaireNomPrenom() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"concessionnaireNomPrenom\": ");

			sb.append("\"");

			sb.append(_escape(chiffreAffaire.getConcessionnaireNomPrenom()));

			sb.append("\"");
		}

		if (chiffreAffaire.getCreatedAt() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"createdAt\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(chiffreAffaire.getCreatedAt()));

			sb.append("\"");
		}

		if (chiffreAffaire.getDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"date\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(chiffreAffaire.getDate()));

			sb.append("\"");
		}

		if (chiffreAffaire.getDeposite() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"deposite\": ");

			sb.append(chiffreAffaire.getDeposite());
		}

		if (chiffreAffaire.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(chiffreAffaire.getId());
		}

		if (chiffreAffaire.getPaiement() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"paiement\": ");

			sb.append(chiffreAffaire.getPaiement());
		}

		if (chiffreAffaire.getProduitType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"produitType\": ");

			sb.append("\"");

			sb.append(_escape(chiffreAffaire.getProduitType()));

			sb.append("\"");
		}

		if (chiffreAffaire.getRembourcement() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"rembourcement\": ");

			sb.append(chiffreAffaire.getRembourcement());
		}

		if (chiffreAffaire.getSite() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"site\": ");

			sb.append("\"");

			sb.append(_escape(chiffreAffaire.getSite()));

			sb.append("\"");
		}

		if (chiffreAffaire.getUpdatedAt() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"updatedAt\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(chiffreAffaire.getUpdatedAt()));

			sb.append("\"");
		}

		if (chiffreAffaire.getVentes() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"ventes\": ");

			sb.append(chiffreAffaire.getVentes());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ChiffreAffaireJSONParser chiffreAffaireJSONParser =
			new ChiffreAffaireJSONParser();

		return chiffreAffaireJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(ChiffreAffaire chiffreAffaire) {
		if (chiffreAffaire == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (chiffreAffaire.getAnnulation() == null) {
			map.put("annulation", null);
		}
		else {
			map.put(
				"annulation", String.valueOf(chiffreAffaire.getAnnulation()));
		}

		if (chiffreAffaire.getBalance() == null) {
			map.put("balance", null);
		}
		else {
			map.put("balance", String.valueOf(chiffreAffaire.getBalance()));
		}

		if (chiffreAffaire.getBrut() == null) {
			map.put("brut", null);
		}
		else {
			map.put("brut", String.valueOf(chiffreAffaire.getBrut()));
		}

		if (chiffreAffaire.getChiffreAffaire() == null) {
			map.put("chiffreAffaire", null);
		}
		else {
			map.put(
				"chiffreAffaire",
				String.valueOf(chiffreAffaire.getChiffreAffaire()));
		}

		if (chiffreAffaire.getCodeProduit() == null) {
			map.put("codeProduit", null);
		}
		else {
			map.put(
				"codeProduit", String.valueOf(chiffreAffaire.getCodeProduit()));
		}

		if (chiffreAffaire.getCodeTerminal() == null) {
			map.put("codeTerminal", null);
		}
		else {
			map.put(
				"codeTerminal",
				String.valueOf(chiffreAffaire.getCodeTerminal()));
		}

		if (chiffreAffaire.getConcessionnaireNomPrenom() == null) {
			map.put("concessionnaireNomPrenom", null);
		}
		else {
			map.put(
				"concessionnaireNomPrenom",
				String.valueOf(chiffreAffaire.getConcessionnaireNomPrenom()));
		}

		if (chiffreAffaire.getCreatedAt() == null) {
			map.put("createdAt", null);
		}
		else {
			map.put(
				"createdAt",
				liferayToJSONDateFormat.format(chiffreAffaire.getCreatedAt()));
		}

		if (chiffreAffaire.getDate() == null) {
			map.put("date", null);
		}
		else {
			map.put(
				"date",
				liferayToJSONDateFormat.format(chiffreAffaire.getDate()));
		}

		if (chiffreAffaire.getDeposite() == null) {
			map.put("deposite", null);
		}
		else {
			map.put("deposite", String.valueOf(chiffreAffaire.getDeposite()));
		}

		if (chiffreAffaire.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(chiffreAffaire.getId()));
		}

		if (chiffreAffaire.getPaiement() == null) {
			map.put("paiement", null);
		}
		else {
			map.put("paiement", String.valueOf(chiffreAffaire.getPaiement()));
		}

		if (chiffreAffaire.getProduitType() == null) {
			map.put("produitType", null);
		}
		else {
			map.put(
				"produitType", String.valueOf(chiffreAffaire.getProduitType()));
		}

		if (chiffreAffaire.getRembourcement() == null) {
			map.put("rembourcement", null);
		}
		else {
			map.put(
				"rembourcement",
				String.valueOf(chiffreAffaire.getRembourcement()));
		}

		if (chiffreAffaire.getSite() == null) {
			map.put("site", null);
		}
		else {
			map.put("site", String.valueOf(chiffreAffaire.getSite()));
		}

		if (chiffreAffaire.getUpdatedAt() == null) {
			map.put("updatedAt", null);
		}
		else {
			map.put(
				"updatedAt",
				liferayToJSONDateFormat.format(chiffreAffaire.getUpdatedAt()));
		}

		if (chiffreAffaire.getVentes() == null) {
			map.put("ventes", null);
		}
		else {
			map.put("ventes", String.valueOf(chiffreAffaire.getVentes()));
		}

		return map;
	}

	public static class ChiffreAffaireJSONParser
		extends BaseJSONParser<ChiffreAffaire> {

		@Override
		protected ChiffreAffaire createDTO() {
			return new ChiffreAffaire();
		}

		@Override
		protected ChiffreAffaire[] createDTOArray(int size) {
			return new ChiffreAffaire[size];
		}

		@Override
		protected void setField(
			ChiffreAffaire chiffreAffaire, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "annulation")) {
				if (jsonParserFieldValue != null) {
					chiffreAffaire.setAnnulation(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "balance")) {
				if (jsonParserFieldValue != null) {
					chiffreAffaire.setBalance(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "brut")) {
				if (jsonParserFieldValue != null) {
					chiffreAffaire.setBrut(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "chiffreAffaire")) {
				if (jsonParserFieldValue != null) {
					chiffreAffaire.setChiffreAffaire(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "codeProduit")) {
				if (jsonParserFieldValue != null) {
					chiffreAffaire.setCodeProduit((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "codeTerminal")) {
				if (jsonParserFieldValue != null) {
					chiffreAffaire.setCodeTerminal(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "concessionnaireNomPrenom")) {

				if (jsonParserFieldValue != null) {
					chiffreAffaire.setConcessionnaireNomPrenom(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "createdAt")) {
				if (jsonParserFieldValue != null) {
					chiffreAffaire.setCreatedAt(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "date")) {
				if (jsonParserFieldValue != null) {
					chiffreAffaire.setDate(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "deposite")) {
				if (jsonParserFieldValue != null) {
					chiffreAffaire.setDeposite(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					chiffreAffaire.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "paiement")) {
				if (jsonParserFieldValue != null) {
					chiffreAffaire.setPaiement(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "produitType")) {
				if (jsonParserFieldValue != null) {
					chiffreAffaire.setProduitType((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "rembourcement")) {
				if (jsonParserFieldValue != null) {
					chiffreAffaire.setRembourcement(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "site")) {
				if (jsonParserFieldValue != null) {
					chiffreAffaire.setSite((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "updatedAt")) {
				if (jsonParserFieldValue != null) {
					chiffreAffaire.setUpdatedAt(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "ventes")) {
				if (jsonParserFieldValue != null) {
					chiffreAffaire.setVentes(
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