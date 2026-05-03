package com.df.lonis.ventesrest.internal.resource.v1_0.internal.export;

import java.util.function.Function;

/**
 * Une colonne d export typee: en-tete + extracteur de valeur depuis l entite.
 *
 * @author HP
 */
public class ExportColumn<T> {

	public final String header;
	public final Function<T, Object> extractor;

	public ExportColumn(String header, Function<T, Object> extractor) {
		this.header = header;
		this.extractor = extractor;
	}

	public String formatValue(T item) {
		Object v = extractor.apply(item);
		return (v == null) ? "" : v.toString();
	}

}
