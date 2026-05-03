package com.df.lonis.ventesrest.internal.resource.v1_0.internal.export;

import java.io.ByteArrayOutputStream;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Generation XLSX via Apache POI (fourni par Liferay).
 *
 * @author HP
 */
public final class XlsxExporter {

	public static <T> byte[] export(
			String sheetName, List<T> rows, List<ExportColumn<T>> columns)
		throws Exception {

		try (XSSFWorkbook wb = new XSSFWorkbook();
			 ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

			XSSFSheet sheet = wb.createSheet(sheetName);

			// Style header
			CellStyle headerStyle = wb.createCellStyle();
			Font headerFont = wb.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.WHITE.getIndex());
			headerStyle.setFont(headerFont);
			headerStyle.setFillForegroundColor(
				IndexedColors.DARK_BLUE.getIndex());
			headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

			// Header row
			Row header = sheet.createRow(0);
			for (int i = 0; i < columns.size(); i++) {
				Cell cell = header.createCell(i);
				cell.setCellValue(columns.get(i).header);
				cell.setCellStyle(headerStyle);
			}

			// Data rows
			for (int r = 0; r < rows.size(); r++) {
				Row row = sheet.createRow(r + 1);
				T item = rows.get(r);
				for (int c = 0; c < columns.size(); c++) {
					row.createCell(c).setCellValue(
						columns.get(c).formatValue(item));
				}
			}

			for (int i = 0; i < columns.size(); i++) {
				sheet.autoSizeColumn(i);
			}

			wb.write(baos);
			return baos.toByteArray();
		}
	}

	private XlsxExporter() {
	}

}
