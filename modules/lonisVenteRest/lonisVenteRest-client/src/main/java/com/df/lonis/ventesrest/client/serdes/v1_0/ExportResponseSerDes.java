package com.df.lonis.ventesrest.client.serdes.v1_0;

import com.df.lonis.ventesrest.client.dto.v1_0.ExportResponse;
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
public class ExportResponseSerDes {

	public static ExportResponse toDTO(String json) {
		ExportResponseJSONParser exportResponseJSONParser =
			new ExportResponseJSONParser();

		return exportResponseJSONParser.parseToDTO(json);
	}

	public static ExportResponse[] toDTOs(String json) {
		ExportResponseJSONParser exportResponseJSONParser =
			new ExportResponseJSONParser();

		return exportResponseJSONParser.parseToDTOs(json);
	}

	public static String toJSON(ExportResponse exportResponse) {
		if (exportResponse == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (exportResponse.getDownloadUrl() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"downloadUrl\": ");

			sb.append("\"");

			sb.append(_escape(exportResponse.getDownloadUrl()));

			sb.append("\"");
		}

		if (exportResponse.getExpiresAt() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"expiresAt\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(exportResponse.getExpiresAt()));

			sb.append("\"");
		}

		if (exportResponse.getFileName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileName\": ");

			sb.append("\"");

			sb.append(_escape(exportResponse.getFileName()));

			sb.append("\"");
		}

		if (exportResponse.getFormat() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"format\": ");

			sb.append("\"");

			sb.append(exportResponse.getFormat());

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ExportResponseJSONParser exportResponseJSONParser =
			new ExportResponseJSONParser();

		return exportResponseJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(ExportResponse exportResponse) {
		if (exportResponse == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (exportResponse.getDownloadUrl() == null) {
			map.put("downloadUrl", null);
		}
		else {
			map.put(
				"downloadUrl", String.valueOf(exportResponse.getDownloadUrl()));
		}

		if (exportResponse.getExpiresAt() == null) {
			map.put("expiresAt", null);
		}
		else {
			map.put(
				"expiresAt",
				liferayToJSONDateFormat.format(exportResponse.getExpiresAt()));
		}

		if (exportResponse.getFileName() == null) {
			map.put("fileName", null);
		}
		else {
			map.put("fileName", String.valueOf(exportResponse.getFileName()));
		}

		if (exportResponse.getFormat() == null) {
			map.put("format", null);
		}
		else {
			map.put("format", String.valueOf(exportResponse.getFormat()));
		}

		return map;
	}

	public static class ExportResponseJSONParser
		extends BaseJSONParser<ExportResponse> {

		@Override
		protected ExportResponse createDTO() {
			return new ExportResponse();
		}

		@Override
		protected ExportResponse[] createDTOArray(int size) {
			return new ExportResponse[size];
		}

		@Override
		protected void setField(
			ExportResponse exportResponse, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "downloadUrl")) {
				if (jsonParserFieldValue != null) {
					exportResponse.setDownloadUrl((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "expiresAt")) {
				if (jsonParserFieldValue != null) {
					exportResponse.setExpiresAt(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "fileName")) {
				if (jsonParserFieldValue != null) {
					exportResponse.setFileName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "format")) {
				if (jsonParserFieldValue != null) {
					exportResponse.setFormat(
						ExportResponse.Format.create(
							(String)jsonParserFieldValue));
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