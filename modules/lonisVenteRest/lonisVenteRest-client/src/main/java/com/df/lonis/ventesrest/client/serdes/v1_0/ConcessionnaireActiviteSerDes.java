package com.df.lonis.ventesrest.client.serdes.v1_0;

import com.df.lonis.ventesrest.client.dto.v1_0.ConcessionnaireActivite;
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
public class ConcessionnaireActiviteSerDes {

	public static ConcessionnaireActivite toDTO(String json) {
		ConcessionnaireActiviteJSONParser concessionnaireActiviteJSONParser =
			new ConcessionnaireActiviteJSONParser();

		return concessionnaireActiviteJSONParser.parseToDTO(json);
	}

	public static ConcessionnaireActivite[] toDTOs(String json) {
		ConcessionnaireActiviteJSONParser concessionnaireActiviteJSONParser =
			new ConcessionnaireActiviteJSONParser();

		return concessionnaireActiviteJSONParser.parseToDTOs(json);
	}

	public static String toJSON(
		ConcessionnaireActivite concessionnaireActivite) {

		if (concessionnaireActivite == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (concessionnaireActivite.getChiffreAffaires() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"chiffreAffaires\": ");

			sb.append(concessionnaireActivite.getChiffreAffaires());
		}

		if (concessionnaireActivite.getConcessionnaireCodes() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"concessionnaireCodes\": ");

			sb.append("[");

			for (int i = 0;
				 i < concessionnaireActivite.getConcessionnaireCodes().length;
				 i++) {

				sb.append("\"");

				sb.append(
					_escape(
						concessionnaireActivite.getConcessionnaireCodes()[i]));

				sb.append("\"");

				if ((i + 1) <
						concessionnaireActivite.
							getConcessionnaireCodes().length) {

					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (concessionnaireActivite.getConcessionnaireId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"concessionnaireId\": ");

			sb.append(concessionnaireActivite.getConcessionnaireId());
		}

		if (concessionnaireActivite.getNom() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"nom\": ");

			sb.append("\"");

			sb.append(_escape(concessionnaireActivite.getNom()));

			sb.append("\"");
		}

		if (concessionnaireActivite.getNombreOperations() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"nombreOperations\": ");

			sb.append(concessionnaireActivite.getNombreOperations());
		}

		if (concessionnaireActivite.getNombreTerminaux() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"nombreTerminaux\": ");

			sb.append(concessionnaireActivite.getNombreTerminaux());
		}

		if (concessionnaireActivite.getPrenoms() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"prenoms\": ");

			sb.append("\"");

			sb.append(_escape(concessionnaireActivite.getPrenoms()));

			sb.append("\"");
		}

		if (concessionnaireActivite.getSoldeTotal() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"soldeTotal\": ");

			sb.append(concessionnaireActivite.getSoldeTotal());
		}

		if (concessionnaireActivite.getTelephone() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"telephone\": ");

			sb.append("\"");

			sb.append(_escape(concessionnaireActivite.getTelephone()));

			sb.append("\"");
		}

		if (concessionnaireActivite.getUid() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"uid\": ");

			sb.append("\"");

			sb.append(_escape(concessionnaireActivite.getUid()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ConcessionnaireActiviteJSONParser concessionnaireActiviteJSONParser =
			new ConcessionnaireActiviteJSONParser();

		return concessionnaireActiviteJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		ConcessionnaireActivite concessionnaireActivite) {

		if (concessionnaireActivite == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (concessionnaireActivite.getChiffreAffaires() == null) {
			map.put("chiffreAffaires", null);
		}
		else {
			map.put(
				"chiffreAffaires",
				String.valueOf(concessionnaireActivite.getChiffreAffaires()));
		}

		if (concessionnaireActivite.getConcessionnaireCodes() == null) {
			map.put("concessionnaireCodes", null);
		}
		else {
			map.put(
				"concessionnaireCodes",
				String.valueOf(
					concessionnaireActivite.getConcessionnaireCodes()));
		}

		if (concessionnaireActivite.getConcessionnaireId() == null) {
			map.put("concessionnaireId", null);
		}
		else {
			map.put(
				"concessionnaireId",
				String.valueOf(concessionnaireActivite.getConcessionnaireId()));
		}

		if (concessionnaireActivite.getNom() == null) {
			map.put("nom", null);
		}
		else {
			map.put("nom", String.valueOf(concessionnaireActivite.getNom()));
		}

		if (concessionnaireActivite.getNombreOperations() == null) {
			map.put("nombreOperations", null);
		}
		else {
			map.put(
				"nombreOperations",
				String.valueOf(concessionnaireActivite.getNombreOperations()));
		}

		if (concessionnaireActivite.getNombreTerminaux() == null) {
			map.put("nombreTerminaux", null);
		}
		else {
			map.put(
				"nombreTerminaux",
				String.valueOf(concessionnaireActivite.getNombreTerminaux()));
		}

		if (concessionnaireActivite.getPrenoms() == null) {
			map.put("prenoms", null);
		}
		else {
			map.put(
				"prenoms",
				String.valueOf(concessionnaireActivite.getPrenoms()));
		}

		if (concessionnaireActivite.getSoldeTotal() == null) {
			map.put("soldeTotal", null);
		}
		else {
			map.put(
				"soldeTotal",
				String.valueOf(concessionnaireActivite.getSoldeTotal()));
		}

		if (concessionnaireActivite.getTelephone() == null) {
			map.put("telephone", null);
		}
		else {
			map.put(
				"telephone",
				String.valueOf(concessionnaireActivite.getTelephone()));
		}

		if (concessionnaireActivite.getUid() == null) {
			map.put("uid", null);
		}
		else {
			map.put("uid", String.valueOf(concessionnaireActivite.getUid()));
		}

		return map;
	}

	public static class ConcessionnaireActiviteJSONParser
		extends BaseJSONParser<ConcessionnaireActivite> {

		@Override
		protected ConcessionnaireActivite createDTO() {
			return new ConcessionnaireActivite();
		}

		@Override
		protected ConcessionnaireActivite[] createDTOArray(int size) {
			return new ConcessionnaireActivite[size];
		}

		@Override
		protected void setField(
			ConcessionnaireActivite concessionnaireActivite,
			String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "chiffreAffaires")) {
				if (jsonParserFieldValue != null) {
					concessionnaireActivite.setChiffreAffaires(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "concessionnaireCodes")) {

				if (jsonParserFieldValue != null) {
					concessionnaireActivite.setConcessionnaireCodes(
						toStrings((Object[])jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "concessionnaireId")) {
				if (jsonParserFieldValue != null) {
					concessionnaireActivite.setConcessionnaireId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "nom")) {
				if (jsonParserFieldValue != null) {
					concessionnaireActivite.setNom(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "nombreOperations")) {
				if (jsonParserFieldValue != null) {
					concessionnaireActivite.setNombreOperations(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "nombreTerminaux")) {
				if (jsonParserFieldValue != null) {
					concessionnaireActivite.setNombreTerminaux(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "prenoms")) {
				if (jsonParserFieldValue != null) {
					concessionnaireActivite.setPrenoms(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "soldeTotal")) {
				if (jsonParserFieldValue != null) {
					concessionnaireActivite.setSoldeTotal(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "telephone")) {
				if (jsonParserFieldValue != null) {
					concessionnaireActivite.setTelephone(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "uid")) {
				if (jsonParserFieldValue != null) {
					concessionnaireActivite.setUid(
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