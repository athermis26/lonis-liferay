package com.df.lonis.ventesrest.internal.resource.v1_0.internal.export;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import java.nio.charset.StandardCharsets;

import java.util.List;

/**
 * Exporteur CSV pur Java, zero dependance.
 *
 * <p>Le BOM UTF-8 est ajoute pour qu Excel detecte automatiquement l encodage
 * et affiche correctement les caracteres accentues.</p>
 *
 * <p>Le separateur est le point-virgule (compatibilite Excel FR).</p>
 *
 * @author HP
 */
public final class CsvExporter {

	public static <T> byte[] export(
			List<T> rows, List<ExportColumn<T>> columns)
		throws Exception {

		try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
			 Writer w = new OutputStreamWriter(baos, StandardCharsets.UTF_8)) {

			// BOM UTF-8 pour qu Excel reconnaisse l encodage
			baos.write(0xEF);
			baos.write(0xBB);
			baos.write(0xBF);

			// Header
			for (int i = 0; i < columns.size(); i++) {
				if (i > 0) {
					w.write(_SEP);
				}
				w.write(_escape(columns.get(i).header));
			}
			w.write(_EOL);

			// Lignes
			for (T item : rows) {
				for (int i = 0; i < columns.size(); i++) {
					if (i > 0) {
						w.write(_SEP);
					}
					w.write(_escape(columns.get(i).formatValue(item)));
				}
				w.write(_EOL);
			}

			w.flush();
			return baos.toByteArray();
		}
	}

	private static String _escape(String s) {
		if (s == null) {
			return "";
		}
		boolean needsQuotes =
			s.contains(_SEP) || s.contains("\"") || s.contains("\n") ||
			s.contains("\r");

		if (needsQuotes) {
			return "\"" + s.replace("\"", "\"\"") + "\"";
		}
		return s;
	}

	private static final String _EOL = "\r\n";
	private static final String _SEP = ";";

	private CsvExporter() {
	}

}
