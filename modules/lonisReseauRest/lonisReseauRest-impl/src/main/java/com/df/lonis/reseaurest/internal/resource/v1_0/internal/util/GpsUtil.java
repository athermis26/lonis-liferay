package com.df.lonis.reseaurest.internal.resource.v1_0.internal.util;

/**
 * Calcul de distance entre 2 points GPS (formule de Haversine).
 *
 * @author HP
 */
public final class GpsUtil {

	/**
	 * Distance en metres entre 2 points GPS.
	 */
	public static double distanceMeters(
		double lat1, double lon1, double lat2, double lon2) {

		final int R = 6371000; // rayon Terre en metres

		double dLat = Math.toRadians(lat2 - lat1);
		double dLon = Math.toRadians(lon2 - lon1);

		double a =
			(Math.sin(dLat / 2) * Math.sin(dLat / 2)) +
			(Math.cos(Math.toRadians(lat1)) *
				Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2) *
				Math.sin(dLon / 2));

		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		return R * c;
	}

	private GpsUtil() {
	}

}
