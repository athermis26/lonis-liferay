package com.df.lonis.ventesrest.client.serdes.v1_0;

import com.df.lonis.ventesrest.client.dto.v1_0.TerminalDetail;
import com.df.lonis.ventesrest.client.dto.v1_0.TerminauxConcessionnaire;
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
public class TerminauxConcessionnaireSerDes {

	public static TerminauxConcessionnaire toDTO(String json) {
		TerminauxConcessionnaireJSONParser terminauxConcessionnaireJSONParser =
			new TerminauxConcessionnaireJSONParser();

		return terminauxConcessionnaireJSONParser.parseToDTO(json);
	}

	public static TerminauxConcessionnaire[] toDTOs(String json) {
		TerminauxConcessionnaireJSONParser terminauxConcessionnaireJSONParser =
			new TerminauxConcessionnaireJSONParser();

		return terminauxConcessionnaireJSONParser.parseToDTOs(json);
	}

	public static String toJSON(
		TerminauxConcessionnaire terminauxConcessionnaire) {

		if (terminauxConcessionnaire == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (terminauxConcessionnaire.getChiffreAffaires() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"chiffreAffaires\": ");

			sb.append(terminauxConcessionnaire.getChiffreAffaires());
		}

		if (terminauxConcessionnaire.getSoldeTotal() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"soldeTotal\": ");

			sb.append(terminauxConcessionnaire.getSoldeTotal());
		}

		if (terminauxConcessionnaire.getTerminalDetails() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"terminalDetails\": ");

			sb.append("[");

			for (int i = 0;
				 i < terminauxConcessionnaire.getTerminalDetails().length;
				 i++) {

				sb.append(
					String.valueOf(
						terminauxConcessionnaire.getTerminalDetails()[i]));

				if ((i + 1) <
						terminauxConcessionnaire.getTerminalDetails().length) {

					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (terminauxConcessionnaire.getTotalOperations() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"totalOperations\": ");

			sb.append(terminauxConcessionnaire.getTotalOperations());
		}

		if (terminauxConcessionnaire.getTotalPaiements() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"totalPaiements\": ");

			sb.append(terminauxConcessionnaire.getTotalPaiements());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		TerminauxConcessionnaireJSONParser terminauxConcessionnaireJSONParser =
			new TerminauxConcessionnaireJSONParser();

		return terminauxConcessionnaireJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		TerminauxConcessionnaire terminauxConcessionnaire) {

		if (terminauxConcessionnaire == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (terminauxConcessionnaire.getChiffreAffaires() == null) {
			map.put("chiffreAffaires", null);
		}
		else {
			map.put(
				"chiffreAffaires",
				String.valueOf(terminauxConcessionnaire.getChiffreAffaires()));
		}

		if (terminauxConcessionnaire.getSoldeTotal() == null) {
			map.put("soldeTotal", null);
		}
		else {
			map.put(
				"soldeTotal",
				String.valueOf(terminauxConcessionnaire.getSoldeTotal()));
		}

		if (terminauxConcessionnaire.getTerminalDetails() == null) {
			map.put("terminalDetails", null);
		}
		else {
			map.put(
				"terminalDetails",
				String.valueOf(terminauxConcessionnaire.getTerminalDetails()));
		}

		if (terminauxConcessionnaire.getTotalOperations() == null) {
			map.put("totalOperations", null);
		}
		else {
			map.put(
				"totalOperations",
				String.valueOf(terminauxConcessionnaire.getTotalOperations()));
		}

		if (terminauxConcessionnaire.getTotalPaiements() == null) {
			map.put("totalPaiements", null);
		}
		else {
			map.put(
				"totalPaiements",
				String.valueOf(terminauxConcessionnaire.getTotalPaiements()));
		}

		return map;
	}

	public static class TerminauxConcessionnaireJSONParser
		extends BaseJSONParser<TerminauxConcessionnaire> {

		@Override
		protected TerminauxConcessionnaire createDTO() {
			return new TerminauxConcessionnaire();
		}

		@Override
		protected TerminauxConcessionnaire[] createDTOArray(int size) {
			return new TerminauxConcessionnaire[size];
		}

		@Override
		protected void setField(
			TerminauxConcessionnaire terminauxConcessionnaire,
			String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "chiffreAffaires")) {
				if (jsonParserFieldValue != null) {
					terminauxConcessionnaire.setChiffreAffaires(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "soldeTotal")) {
				if (jsonParserFieldValue != null) {
					terminauxConcessionnaire.setSoldeTotal(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "terminalDetails")) {
				if (jsonParserFieldValue != null) {
					terminauxConcessionnaire.setTerminalDetails(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> TerminalDetailSerDes.toDTO((String)object)
						).toArray(
							size -> new TerminalDetail[size]
						));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "totalOperations")) {
				if (jsonParserFieldValue != null) {
					terminauxConcessionnaire.setTotalOperations(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "totalPaiements")) {
				if (jsonParserFieldValue != null) {
					terminauxConcessionnaire.setTotalPaiements(
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