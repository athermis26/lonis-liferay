package com.df.lonis.ventesrest.internal.resource.v1_0.internal.export;

import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Aiguille selon le format demande:
 * <ul>
 *   <li>pdf  -> {@link PdfExporter} (PDFBox)</li>
 *   <li>xlsx -> {@link XlsxExporter} (POI)</li>
 *   <li>csv  -> {@link CsvExporter} (pur Java, fallback par defaut)</li>
 * </ul>
 *
 * @author HP
 */
public final class ExportResponseUtil {

	public static <T> Response build(
			String format, String baseFileName, String title, List<T> rows,
			List<ExportColumn<T>> columns)
		throws Exception {

		byte[] bytes;
		String fileName;
		String contentType;

		String fmt = (format == null) ? "csv" : format.toLowerCase();

		switch (fmt) {
			case "pdf":
				bytes = PdfExporter.export(title, rows, columns);
				fileName = baseFileName + ".pdf";
				contentType = "application/pdf";
				break;
			case "xlsx":
				bytes = XlsxExporter.export(title, rows, columns);
				fileName = baseFileName + ".xlsx";
				contentType =
					"application/vnd.openxmlformats-officedocument." +
						"spreadsheetml.sheet";
				break;
			default:
				bytes = CsvExporter.export(rows, columns);
				fileName = baseFileName + ".csv";
				contentType = "text/csv; charset=UTF-8";
		}

		return Response.ok(
			bytes, MediaType.valueOf(contentType)
		).header(
			"Content-Disposition", "attachment; filename=\"" + fileName + "\""
		).build();
	}

	private ExportResponseUtil() {
	}

}
