package com.df.lonis.ventesrest.internal.resource.v1_0.internal.export;

import java.awt.Color;

import java.io.ByteArrayOutputStream;

import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 * Generation PDF via Apache PDFBox (fourni par Liferay). Tableau auto-pagine
 * avec separateurs verticaux et troncation par largeur de colonne.
 *
 * @author HP
 */
public final class PdfExporter {

	public static <T> byte[] export(
			String title, List<T> rows, List<ExportColumn<T>> columns)
		throws Exception {

		try (PDDocument doc = new PDDocument();
			 ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

			PDFont fontBold = PDType1Font.HELVETICA_BOLD;
			PDFont fontRegular = PDType1Font.HELVETICA;

			float pageWidth = PDRectangle.A4.getHeight(); // landscape
			float pageHeight = PDRectangle.A4.getWidth();
			float margin = 30f;
			float usableWidth = pageWidth - (2 * margin);
			float colWidth = usableWidth / columns.size();
			float rowHeight = 18f;
			float titleHeight = 30f;
			float cellPadding = 4f;

			float headerFontSize = 9f;
			float bodyFontSize = 8f;

			int rowsPerPage =
				(int)((pageHeight - margin - titleHeight - rowHeight) /
					rowHeight);

			int pages = (int)Math.ceil(
				rows.size() / (double)Math.max(rowsPerPage, 1));
			if (pages == 0) {
				pages = 1;
			}

			for (int p = 0; p < pages; p++) {
				PDPage page = new PDPage(
					new PDRectangle(pageWidth, pageHeight));
				doc.addPage(page);

				try (PDPageContentStream cs = new PDPageContentStream(
						doc, page)) {

					float y = pageHeight - margin;

					// Titre (1ere page seulement)
					if (p == 0) {
						cs.beginText();
						cs.setFont(fontBold, 16);
						cs.newLineAtOffset(margin, y - 15);
						cs.showText(_clean(title));
						cs.endText();
						y -= titleHeight;
					}

					// Header background
					cs.setNonStrokingColor(new Color(0, 51, 102));
					cs.addRect(margin, y - rowHeight, usableWidth, rowHeight);
					cs.fill();

					// Header text
					cs.setNonStrokingColor(Color.WHITE);
					for (int c = 0; c < columns.size(); c++) {
						String h = _fit(
							_clean(columns.get(c).header), colWidth,
							cellPadding, fontBold, headerFontSize);

						cs.beginText();
						cs.setFont(fontBold, headerFontSize);
						cs.newLineAtOffset(
							margin + (c * colWidth) + cellPadding,
							y - rowHeight + cellPadding + 3);
						cs.showText(h);
						cs.endText();
					}

					// Header separateurs verticaux (en blanc)
					cs.setStrokingColor(Color.WHITE);
					cs.setLineWidth(0.5f);
					for (int c = 1; c < columns.size(); c++) {
						float x = margin + (c * colWidth);
						cs.moveTo(x, y - rowHeight);
						cs.lineTo(x, y);
						cs.stroke();
					}

					y -= rowHeight;
					cs.setNonStrokingColor(Color.BLACK);

					// Data rows
					int start = p * rowsPerPage;
					int end = Math.min(start + rowsPerPage, rows.size());

					for (int r = start; r < end; r++) {
						T item = rows.get(r);

						// Bordure exterieure de la ligne
						cs.setStrokingColor(Color.LIGHT_GRAY);
						cs.setLineWidth(0.5f);
						cs.addRect(
							margin, y - rowHeight, usableWidth, rowHeight);
						cs.stroke();

						// Separateurs verticaux entre cellules
						for (int c = 1; c < columns.size(); c++) {
							float x = margin + (c * colWidth);
							cs.moveTo(x, y - rowHeight);
							cs.lineTo(x, y);
							cs.stroke();
						}

						// Texte de chaque cellule (tronque pour tenir)
						for (int c = 0; c < columns.size(); c++) {
							String value = _fit(
								_clean(columns.get(c).formatValue(item)),
								colWidth, cellPadding, fontRegular,
								bodyFontSize);

							cs.beginText();
							cs.setFont(fontRegular, bodyFontSize);
							cs.newLineAtOffset(
								margin + (c * colWidth) + cellPadding,
								y - rowHeight + cellPadding + 3);
							cs.showText(value);
							cs.endText();
						}
						y -= rowHeight;
					}
				}
			}

			doc.save(baos);
			return baos.toByteArray();
		}
	}

	/**
	 * PDFBox/WinAnsiEncoding ne supporte pas tous les caracteres Unicode.
	 */
	private static String _clean(String s) {
		if (s == null) {
			return "";
		}
		return s.replace('…', '.').replace('’', '\'').replaceAll(
			"[^\\x00-\\xFF]", "?");
	}

	/**
	 * Tronque la chaine si elle depasse la largeur de cellule disponible.
	 */
	private static String _fit(
			String s, float colWidth, float padding, PDFont font,
			float fontSize)
		throws Exception {

		float maxWidth = colWidth - (2 * padding);

		if (_textWidth(s, font, fontSize) <= maxWidth) {
			return s;
		}

		String ellipsis = "...";
		float ellipsisWidth = _textWidth(ellipsis, font, fontSize);

		StringBuilder sb = new StringBuilder();
		float current = 0;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			float charWidth = font.getStringWidth(String.valueOf(ch)) / 1000f *
				fontSize;

			if ((current + charWidth + ellipsisWidth) > maxWidth) {
				break;
			}
			sb.append(ch);
			current += charWidth;
		}

		return sb.toString() + ellipsis;
	}

	private static float _textWidth(String s, PDFont font, float fontSize)
		throws Exception {

		return font.getStringWidth(s) / 1000f * fontSize;
	}

	private PdfExporter() {
	}

}
