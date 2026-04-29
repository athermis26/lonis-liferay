package com.df.lonis.ventesrest.client.dto.v1_0;

import com.df.lonis.ventesrest.client.function.UnsafeSupplier;
import com.df.lonis.ventesrest.client.serdes.v1_0.ExportResponseSerDes;

import java.io.Serializable;

import java.util.Date;
import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author HP
 * @generated
 */
@Generated("")
public class ExportResponse implements Cloneable, Serializable {

	public static ExportResponse toDTO(String json) {
		return ExportResponseSerDes.toDTO(json);
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public void setDownloadUrl(
		UnsafeSupplier<String, Exception> downloadUrlUnsafeSupplier) {

		try {
			downloadUrl = downloadUrlUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String downloadUrl;

	public Date getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Date expiresAt) {
		this.expiresAt = expiresAt;
	}

	public void setExpiresAt(
		UnsafeSupplier<Date, Exception> expiresAtUnsafeSupplier) {

		try {
			expiresAt = expiresAtUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date expiresAt;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setFileName(
		UnsafeSupplier<String, Exception> fileNameUnsafeSupplier) {

		try {
			fileName = fileNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String fileName;

	public Format getFormat() {
		return format;
	}

	public String getFormatAsString() {
		if (format == null) {
			return null;
		}

		return format.toString();
	}

	public void setFormat(Format format) {
		this.format = format;
	}

	public void setFormat(
		UnsafeSupplier<Format, Exception> formatUnsafeSupplier) {

		try {
			format = formatUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Format format;

	@Override
	public ExportResponse clone() throws CloneNotSupportedException {
		return (ExportResponse)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ExportResponse)) {
			return false;
		}

		ExportResponse exportResponse = (ExportResponse)object;

		return Objects.equals(toString(), exportResponse.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return ExportResponseSerDes.toJSON(this);
	}

	public static enum Format {

		XLSX("xlsx"), PDF("pdf");

		public static Format create(String value) {
			for (Format format : values()) {
				if (Objects.equals(format.getValue(), value) ||
					Objects.equals(format.name(), value)) {

					return format;
				}
			}

			return null;
		}

		public String getValue() {
			return _value;
		}

		@Override
		public String toString() {
			return _value;
		}

		private Format(String value) {
			_value = value;
		}

		private final String _value;

	}

}