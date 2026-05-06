package com.df.lonis.reseaurest.internal.backend;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

public final class BackendJsonUtil {

	private BackendJsonUtil() {}

	public static JSONObject obj(String body) {
		try {
			return JSONFactoryUtil.createJSONObject(body == null || body.isBlank() ? "{}" : body);
		}
		catch (Exception e) {
			throw new BackendException(0, "JSON object invalide : " + body, e);
		}
	}

	public static JSONArray arr(String body) {
		try {
			return JSONFactoryUtil.createJSONArray(body == null || body.isBlank() ? "[]" : body);
		}
		catch (Exception e) {
			throw new BackendException(0, "JSON array invalide : " + body, e);
		}
	}

	public static String  str(JSONObject o, String k)  { return o == null || !o.has(k) || o.isNull(k) ? null : o.getString(k); }
	public static Long    longVal(JSONObject o, String k) { return o == null || !o.has(k) || o.isNull(k) ? null : o.getLong(k); }
	public static Integer intVal(JSONObject o, String k)  { return o == null || !o.has(k) || o.isNull(k) ? null : o.getInt(k); }
	public static Double  dbl(JSONObject o, String k)     { return o == null || !o.has(k) || o.isNull(k) ? null : o.getDouble(k); }
	public static Boolean bool(JSONObject o, String k)    { return o == null || !o.has(k) || o.isNull(k) ? null : o.getBoolean(k); }

	public static Date date(JSONObject obj, String key) {
		String s = str(obj, key);
		if (s == null) return null;
		try {
			return Date.from(Instant.parse(s));
		}
		catch (DateTimeParseException e) {
			return null;
		}
	}

	public static String[] strArr(JSONObject obj, String key) {
		if (obj == null || !obj.has(key) || obj.isNull(key)) return new String[0];
		JSONArray arr = obj.getJSONArray(key);
		String[] result = new String[arr.length()];
		for (int i = 0; i < arr.length(); i++) {
			result[i] = arr.getString(i);
		}
		return result;
	}

	public static final class Page<T> {
		private final List<T> items;
		private final long total;

		public Page(List<T> items, long total) {
			this.items = items == null ? java.util.Collections.emptyList() : items;
			this.total = total;
		}

		public List<T> items() { return items; }
		public long total()    { return total; }
	}

	public static <T> Page<T> page(String body, Function<JSONObject, T> mapper) {
		JSONObject json = obj(body);
		JSONArray items = json.getJSONArray("items");
		List<T> result = new ArrayList<>();
		if (items != null) {
			for (int i = 0; i < items.length(); i++) {
				result.add(mapper.apply(items.getJSONObject(i)));
			}
		}
		long total = json.has("totalItems") ? json.getLong("totalItems") : result.size();
		return new Page<>(result, total);
	}

	public static <T> List<T> list(String body, Function<JSONObject, T> mapper) {
		JSONArray arr = arr(body);
		List<T> result = new ArrayList<>(arr.length());
		for (int i = 0; i < arr.length(); i++) {
			result.add(mapper.apply(arr.getJSONObject(i)));
		}
		return result;
	}
}
