package com.df.lonis.ventesrest.client.serdes.v1_0;

import com.df.lonis.ventesrest.client.dto.v1_0.ConcessionnaireDetail;
import com.df.lonis.ventesrest.client.dto.v1_0.ConcessionnaireProduit;
import com.df.lonis.ventesrest.client.dto.v1_0.Terminal;
import com.df.lonis.ventesrest.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Stream;

import javax.annotation.Generated;

/**
 * @author HP
 * @generated
 */
@Generated("")
public class ConcessionnaireDetailSerDes {

	public static ConcessionnaireDetail toDTO(String json) {
		ConcessionnaireDetailJSONParser concessionnaireDetailJSONParser =
			new ConcessionnaireDetailJSONParser();

		return concessionnaireDetailJSONParser.parseToDTO(json);
	}

	public static ConcessionnaireDetail[] toDTOs(String json) {
		ConcessionnaireDetailJSONParser concessionnaireDetailJSONParser =
			new ConcessionnaireDetailJSONParser();

		return concessionnaireDetailJSONParser.parseToDTOs(json);
	}

	public static String toJSON(ConcessionnaireDetail concessionnaireDetail) {
		if (concessionnaireDetail == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (concessionnaireDetail.getConcessionnaireProduits() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"concessionnaireProduits\": ");

			sb.append("[");

			for (int i = 0;
				 i < concessionnaireDetail.getConcessionnaireProduits().length;
				 i++) {

				sb.append(
					String.valueOf(
						concessionnaireDetail.getConcessionnaireProduits()[i]));

				if ((i + 1) <
						concessionnaireDetail.
							getConcessionnaireProduits().length) {

					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (concessionnaireDetail.getConcessionnaireTerminals() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"concessionnaireTerminals\": ");

			sb.append("[");

			for (int i = 0;
				 i < concessionnaireDetail.getConcessionnaireTerminals().length;
				 i++) {

				sb.append(
					String.valueOf(
						concessionnaireDetail.getConcessionnaireTerminals()
							[i]));

				if ((i + 1) < concessionnaireDetail.
						getConcessionnaireTerminals().length) {

					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (concessionnaireDetail.getEmail() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"email\": ");

			sb.append("\"");

			sb.append(_escape(concessionnaireDetail.getEmail()));

			sb.append("\"");
		}

		if (concessionnaireDetail.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(concessionnaireDetail.getId());
		}

		if (concessionnaireDetail.getNom() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"nom\": ");

			sb.append("\"");

			sb.append(_escape(concessionnaireDetail.getNom()));

			sb.append("\"");
		}

		if (concessionnaireDetail.getPrenoms() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"prenoms\": ");

			sb.append("\"");

			sb.append(_escape(concessionnaireDetail.getPrenoms()));

			sb.append("\"");
		}

		if (concessionnaireDetail.getSoldeTotal() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"soldeTotal\": ");

			sb.append(concessionnaireDetail.getSoldeTotal());
		}

		if (concessionnaireDetail.getStats() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"stats\": ");

			sb.append(String.valueOf(concessionnaireDetail.getStats()));
		}

		if (concessionnaireDetail.getTelephone() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"telephone\": ");

			sb.append("\"");

			sb.append(_escape(concessionnaireDetail.getTelephone()));

			sb.append("\"");
		}

		if (concessionnaireDetail.getUid() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"uid\": ");

			sb.append("\"");

			sb.append(_escape(concessionnaireDetail.getUid()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ConcessionnaireDetailJSONParser concessionnaireDetailJSONParser =
			new ConcessionnaireDetailJSONParser();

		return concessionnaireDetailJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		ConcessionnaireDetail concessionnaireDetail) {

		if (concessionnaireDetail == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (concessionnaireDetail.getConcessionnaireProduits() == null) {
			map.put("concessionnaireProduits", null);
		}
		else {
			map.put(
				"concessionnaireProduits",
				String.valueOf(
					concessionnaireDetail.getConcessionnaireProduits()));
		}

		if (concessionnaireDetail.getConcessionnaireTerminals() == null) {
			map.put("concessionnaireTerminals", null);
		}
		else {
			map.put(
				"concessionnaireTerminals",
				String.valueOf(
					concessionnaireDetail.getConcessionnaireTerminals()));
		}

		if (concessionnaireDetail.getEmail() == null) {
			map.put("email", null);
		}
		else {
			map.put("email", String.valueOf(concessionnaireDetail.getEmail()));
		}

		if (concessionnaireDetail.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(concessionnaireDetail.getId()));
		}

		if (concessionnaireDetail.getNom() == null) {
			map.put("nom", null);
		}
		else {
			map.put("nom", String.valueOf(concessionnaireDetail.getNom()));
		}

		if (concessionnaireDetail.getPrenoms() == null) {
			map.put("prenoms", null);
		}
		else {
			map.put(
				"prenoms", String.valueOf(concessionnaireDetail.getPrenoms()));
		}

		if (concessionnaireDetail.getSoldeTotal() == null) {
			map.put("soldeTotal", null);
		}
		else {
			map.put(
				"soldeTotal",
				String.valueOf(concessionnaireDetail.getSoldeTotal()));
		}

		if (concessionnaireDetail.getStats() == null) {
			map.put("stats", null);
		}
		else {
			map.put("stats", String.valueOf(concessionnaireDetail.getStats()));
		}

		if (concessionnaireDetail.getTelephone() == null) {
			map.put("telephone", null);
		}
		else {
			map.put(
				"telephone",
				String.valueOf(concessionnaireDetail.getTelephone()));
		}

		if (concessionnaireDetail.getUid() == null) {
			map.put("uid", null);
		}
		else {
			map.put("uid", String.valueOf(concessionnaireDetail.getUid()));
		}

		return map;
	}

	public static class ConcessionnaireDetailJSONParser
		extends BaseJSONParser<ConcessionnaireDetail> {

		@Override
		protected ConcessionnaireDetail createDTO() {
			return new ConcessionnaireDetail();
		}

		@Override
		protected ConcessionnaireDetail[] createDTOArray(int size) {
			return new ConcessionnaireDetail[size];
		}

		@Override
		protected void setField(
			ConcessionnaireDetail concessionnaireDetail,
			String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(
					jsonParserFieldName, "concessionnaireProduits")) {

				if (jsonParserFieldValue != null) {
					concessionnaireDetail.setConcessionnaireProduits(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> ConcessionnaireProduitSerDes.toDTO(
								(String)object)
						).toArray(
							size -> new ConcessionnaireProduit[size]
						));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "concessionnaireTerminals")) {

				if (jsonParserFieldValue != null) {
					concessionnaireDetail.setConcessionnaireTerminals(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> TerminalSerDes.toDTO((String)object)
						).toArray(
							size -> new Terminal[size]
						));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "email")) {
				if (jsonParserFieldValue != null) {
					concessionnaireDetail.setEmail(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					concessionnaireDetail.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "nom")) {
				if (jsonParserFieldValue != null) {
					concessionnaireDetail.setNom((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "prenoms")) {
				if (jsonParserFieldValue != null) {
					concessionnaireDetail.setPrenoms(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "soldeTotal")) {
				if (jsonParserFieldValue != null) {
					concessionnaireDetail.setSoldeTotal(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "stats")) {
				if (jsonParserFieldValue != null) {
					concessionnaireDetail.setStats(
						ConcessionnaireStatsSerDes.toDTO(
							(String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "telephone")) {
				if (jsonParserFieldValue != null) {
					concessionnaireDetail.setTelephone(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "uid")) {
				if (jsonParserFieldValue != null) {
					concessionnaireDetail.setUid((String)jsonParserFieldValue);
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