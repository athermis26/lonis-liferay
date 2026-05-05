package com.df.lonis.reseaurest.internal.resource.v1_0.internal.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Calcul des bornes [debut, fin] d'une periode (mensuelle ou trimestrielle).
 *
 * @author HP
 */
public final class PeriodeUtil {

	public static class Range {
		public final Date debut;
		public final Date fin;
		public Range(Date debut, Date fin) {
			this.debut = debut;
			this.fin = fin;
		}
	}

	/**
	 * @param periode "MENSUEL" ou "TRIMESTRIEL"
	 * @param annee   annee complete (ex: 2026)
	 * @param mois    1-12 (utilise si MENSUEL)
	 * @param trimestre 1-4 (utilise si TRIMESTRIEL)
	 */
	public static Range range(
		String periode, int annee, Integer mois, Integer trimestre) {

		Calendar deb = Calendar.getInstance();
		Calendar fin = Calendar.getInstance();

		if ("TRIMESTRIEL".equalsIgnoreCase(periode)) {
			int t = (trimestre == null) ? 1 : trimestre;
			int firstMonth = (t - 1) * 3;
			deb.set(annee, firstMonth, 1, 0, 0, 0);
			deb.set(Calendar.MILLISECOND, 0);
			fin.set(annee, firstMonth + 2, 1, 0, 0, 0);
			fin.set(Calendar.DAY_OF_MONTH, fin.getActualMaximum(Calendar.DAY_OF_MONTH));
			fin.set(Calendar.HOUR_OF_DAY, 23);
			fin.set(Calendar.MINUTE, 59);
			fin.set(Calendar.SECOND, 59);
			fin.set(Calendar.MILLISECOND, 999);
		}
		else {
			int m = (mois == null) ? 1 : mois;
			deb.set(annee, m - 1, 1, 0, 0, 0);
			deb.set(Calendar.MILLISECOND, 0);
			fin.set(annee, m - 1, 1, 23, 59, 59);
			fin.set(Calendar.DAY_OF_MONTH, fin.getActualMaximum(Calendar.DAY_OF_MONTH));
			fin.set(Calendar.MILLISECOND, 999);
		}

		return new Range(deb.getTime(), fin.getTime());
	}

	private PeriodeUtil() {
	}

}
