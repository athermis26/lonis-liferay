package com.df.lonis.reseaurest.client.serdes.v1_0;

import com.df.lonis.reseaurest.client.dto.v1_0.Evaluation;
import com.df.lonis.reseaurest.client.json.BaseJSONParser;

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
public class EvaluationSerDes {

	public static Evaluation toDTO(String json) {
		EvaluationJSONParser evaluationJSONParser = new EvaluationJSONParser();

		return evaluationJSONParser.parseToDTO(json);
	}

	public static Evaluation[] toDTOs(String json) {
		EvaluationJSONParser evaluationJSONParser = new EvaluationJSONParser();

		return evaluationJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Evaluation evaluation) {
		if (evaluation == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (evaluation.getAnnee() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"annee\": ");

			sb.append(evaluation.getAnnee());
		}

		if (evaluation.getCommercialId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"commercialId\": ");

			sb.append(evaluation.getCommercialId());
		}

		if (evaluation.getCreatedAt() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"createdAt\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(evaluation.getCreatedAt()));

			sb.append("\"");
		}

		if (evaluation.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(evaluation.getId());
		}

		if (evaluation.getMois() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"mois\": ");

			sb.append(evaluation.getMois());
		}

		if (evaluation.getNbVisitesEffectuees() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"nbVisitesEffectuees\": ");

			sb.append(evaluation.getNbVisitesEffectuees());
		}

		if (evaluation.getNbVisitesPrevues() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"nbVisitesPrevues\": ");

			sb.append(evaluation.getNbVisitesPrevues());
		}

		if (evaluation.getNom() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"nom\": ");

			sb.append("\"");

			sb.append(_escape(evaluation.getNom()));

			sb.append("\"");
		}

		if (evaluation.getPeriode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"periode\": ");

			sb.append("\"");

			sb.append(evaluation.getPeriode());

			sb.append("\"");
		}

		if (evaluation.getPrenoms() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"prenoms\": ");

			sb.append("\"");

			sb.append(_escape(evaluation.getPrenoms()));

			sb.append("\"");
		}

		if (evaluation.getRang() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"rang\": ");

			sb.append(evaluation.getRang());
		}

		if (evaluation.getTauxRealisation() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"tauxRealisation\": ");

			sb.append(evaluation.getTauxRealisation());
		}

		if (evaluation.getTrimestre() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"trimestre\": ");

			sb.append(evaluation.getTrimestre());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		EvaluationJSONParser evaluationJSONParser = new EvaluationJSONParser();

		return evaluationJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Evaluation evaluation) {
		if (evaluation == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (evaluation.getAnnee() == null) {
			map.put("annee", null);
		}
		else {
			map.put("annee", String.valueOf(evaluation.getAnnee()));
		}

		if (evaluation.getCommercialId() == null) {
			map.put("commercialId", null);
		}
		else {
			map.put(
				"commercialId", String.valueOf(evaluation.getCommercialId()));
		}

		if (evaluation.getCreatedAt() == null) {
			map.put("createdAt", null);
		}
		else {
			map.put(
				"createdAt",
				liferayToJSONDateFormat.format(evaluation.getCreatedAt()));
		}

		if (evaluation.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(evaluation.getId()));
		}

		if (evaluation.getMois() == null) {
			map.put("mois", null);
		}
		else {
			map.put("mois", String.valueOf(evaluation.getMois()));
		}

		if (evaluation.getNbVisitesEffectuees() == null) {
			map.put("nbVisitesEffectuees", null);
		}
		else {
			map.put(
				"nbVisitesEffectuees",
				String.valueOf(evaluation.getNbVisitesEffectuees()));
		}

		if (evaluation.getNbVisitesPrevues() == null) {
			map.put("nbVisitesPrevues", null);
		}
		else {
			map.put(
				"nbVisitesPrevues",
				String.valueOf(evaluation.getNbVisitesPrevues()));
		}

		if (evaluation.getNom() == null) {
			map.put("nom", null);
		}
		else {
			map.put("nom", String.valueOf(evaluation.getNom()));
		}

		if (evaluation.getPeriode() == null) {
			map.put("periode", null);
		}
		else {
			map.put("periode", String.valueOf(evaluation.getPeriode()));
		}

		if (evaluation.getPrenoms() == null) {
			map.put("prenoms", null);
		}
		else {
			map.put("prenoms", String.valueOf(evaluation.getPrenoms()));
		}

		if (evaluation.getRang() == null) {
			map.put("rang", null);
		}
		else {
			map.put("rang", String.valueOf(evaluation.getRang()));
		}

		if (evaluation.getTauxRealisation() == null) {
			map.put("tauxRealisation", null);
		}
		else {
			map.put(
				"tauxRealisation",
				String.valueOf(evaluation.getTauxRealisation()));
		}

		if (evaluation.getTrimestre() == null) {
			map.put("trimestre", null);
		}
		else {
			map.put("trimestre", String.valueOf(evaluation.getTrimestre()));
		}

		return map;
	}

	public static class EvaluationJSONParser
		extends BaseJSONParser<Evaluation> {

		@Override
		protected Evaluation createDTO() {
			return new Evaluation();
		}

		@Override
		protected Evaluation[] createDTOArray(int size) {
			return new Evaluation[size];
		}

		@Override
		protected void setField(
			Evaluation evaluation, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "annee")) {
				if (jsonParserFieldValue != null) {
					evaluation.setAnnee(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "commercialId")) {
				if (jsonParserFieldValue != null) {
					evaluation.setCommercialId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "createdAt")) {
				if (jsonParserFieldValue != null) {
					evaluation.setCreatedAt(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					evaluation.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "mois")) {
				if (jsonParserFieldValue != null) {
					evaluation.setMois(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "nbVisitesEffectuees")) {

				if (jsonParserFieldValue != null) {
					evaluation.setNbVisitesEffectuees(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "nbVisitesPrevues")) {
				if (jsonParserFieldValue != null) {
					evaluation.setNbVisitesPrevues(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "nom")) {
				if (jsonParserFieldValue != null) {
					evaluation.setNom((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "periode")) {
				if (jsonParserFieldValue != null) {
					evaluation.setPeriode(
						Evaluation.Periode.create(
							(String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "prenoms")) {
				if (jsonParserFieldValue != null) {
					evaluation.setPrenoms((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "rang")) {
				if (jsonParserFieldValue != null) {
					evaluation.setRang(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "tauxRealisation")) {
				if (jsonParserFieldValue != null) {
					evaluation.setTauxRealisation(
						Double.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "trimestre")) {
				if (jsonParserFieldValue != null) {
					evaluation.setTrimestre(
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