/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence;

import com.df.lonis.ventesservice.model.Objectif;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the objectif service. This utility wraps <code>com.df.lonis.ventesservice.service.persistence.impl.ObjectifPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ObjectifPersistence
 * @generated
 */
public class ObjectifUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Objectif objectif) {
		getPersistence().clearCache(objectif);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Objectif> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Objectif> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Objectif> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Objectif> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Objectif> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Objectif update(Objectif objectif) {
		return getPersistence().update(objectif);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Objectif update(
		Objectif objectif, ServiceContext serviceContext) {

		return getPersistence().update(objectif, serviceContext);
	}

	/**
	 * Returns all the objectifs where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @return the matching objectifs
	 */
	public static List<Objectif> findByCommercialId(long commercialId) {
		return getPersistence().findByCommercialId(commercialId);
	}

	/**
	 * Returns a range of all the objectifs where commercialId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ObjectifModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param start the lower bound of the range of objectifs
	 * @param end the upper bound of the range of objectifs (not inclusive)
	 * @return the range of matching objectifs
	 */
	public static List<Objectif> findByCommercialId(
		long commercialId, int start, int end) {

		return getPersistence().findByCommercialId(commercialId, start, end);
	}

	/**
	 * Returns an ordered range of all the objectifs where commercialId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ObjectifModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param start the lower bound of the range of objectifs
	 * @param end the upper bound of the range of objectifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching objectifs
	 */
	public static List<Objectif> findByCommercialId(
		long commercialId, int start, int end,
		OrderByComparator<Objectif> orderByComparator) {

		return getPersistence().findByCommercialId(
			commercialId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the objectifs where commercialId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ObjectifModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param start the lower bound of the range of objectifs
	 * @param end the upper bound of the range of objectifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching objectifs
	 */
	public static List<Objectif> findByCommercialId(
		long commercialId, int start, int end,
		OrderByComparator<Objectif> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCommercialId(
			commercialId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first objectif in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching objectif
	 * @throws NoSuchObjectifException if a matching objectif could not be found
	 */
	public static Objectif findByCommercialId_First(
			long commercialId, OrderByComparator<Objectif> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchObjectifException {

		return getPersistence().findByCommercialId_First(
			commercialId, orderByComparator);
	}

	/**
	 * Returns the first objectif in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching objectif, or <code>null</code> if a matching objectif could not be found
	 */
	public static Objectif fetchByCommercialId_First(
		long commercialId, OrderByComparator<Objectif> orderByComparator) {

		return getPersistence().fetchByCommercialId_First(
			commercialId, orderByComparator);
	}

	/**
	 * Returns the last objectif in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching objectif
	 * @throws NoSuchObjectifException if a matching objectif could not be found
	 */
	public static Objectif findByCommercialId_Last(
			long commercialId, OrderByComparator<Objectif> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchObjectifException {

		return getPersistence().findByCommercialId_Last(
			commercialId, orderByComparator);
	}

	/**
	 * Returns the last objectif in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching objectif, or <code>null</code> if a matching objectif could not be found
	 */
	public static Objectif fetchByCommercialId_Last(
		long commercialId, OrderByComparator<Objectif> orderByComparator) {

		return getPersistence().fetchByCommercialId_Last(
			commercialId, orderByComparator);
	}

	/**
	 * Returns the objectifs before and after the current objectif in the ordered set where commercialId = &#63;.
	 *
	 * @param id the primary key of the current objectif
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next objectif
	 * @throws NoSuchObjectifException if a objectif with the primary key could not be found
	 */
	public static Objectif[] findByCommercialId_PrevAndNext(
			long id, long commercialId,
			OrderByComparator<Objectif> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchObjectifException {

		return getPersistence().findByCommercialId_PrevAndNext(
			id, commercialId, orderByComparator);
	}

	/**
	 * Removes all the objectifs where commercialId = &#63; from the database.
	 *
	 * @param commercialId the commercial ID
	 */
	public static void removeByCommercialId(long commercialId) {
		getPersistence().removeByCommercialId(commercialId);
	}

	/**
	 * Returns the number of objectifs where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @return the number of matching objectifs
	 */
	public static int countByCommercialId(long commercialId) {
		return getPersistence().countByCommercialId(commercialId);
	}

	/**
	 * Returns all the objectifs where commercialId = &#63; and annee = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @return the matching objectifs
	 */
	public static List<Objectif> findByC_A(long commercialId, int annee) {
		return getPersistence().findByC_A(commercialId, annee);
	}

	/**
	 * Returns a range of all the objectifs where commercialId = &#63; and annee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ObjectifModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param start the lower bound of the range of objectifs
	 * @param end the upper bound of the range of objectifs (not inclusive)
	 * @return the range of matching objectifs
	 */
	public static List<Objectif> findByC_A(
		long commercialId, int annee, int start, int end) {

		return getPersistence().findByC_A(commercialId, annee, start, end);
	}

	/**
	 * Returns an ordered range of all the objectifs where commercialId = &#63; and annee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ObjectifModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param start the lower bound of the range of objectifs
	 * @param end the upper bound of the range of objectifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching objectifs
	 */
	public static List<Objectif> findByC_A(
		long commercialId, int annee, int start, int end,
		OrderByComparator<Objectif> orderByComparator) {

		return getPersistence().findByC_A(
			commercialId, annee, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the objectifs where commercialId = &#63; and annee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ObjectifModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param start the lower bound of the range of objectifs
	 * @param end the upper bound of the range of objectifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching objectifs
	 */
	public static List<Objectif> findByC_A(
		long commercialId, int annee, int start, int end,
		OrderByComparator<Objectif> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByC_A(
			commercialId, annee, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first objectif in the ordered set where commercialId = &#63; and annee = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching objectif
	 * @throws NoSuchObjectifException if a matching objectif could not be found
	 */
	public static Objectif findByC_A_First(
			long commercialId, int annee,
			OrderByComparator<Objectif> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchObjectifException {

		return getPersistence().findByC_A_First(
			commercialId, annee, orderByComparator);
	}

	/**
	 * Returns the first objectif in the ordered set where commercialId = &#63; and annee = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching objectif, or <code>null</code> if a matching objectif could not be found
	 */
	public static Objectif fetchByC_A_First(
		long commercialId, int annee,
		OrderByComparator<Objectif> orderByComparator) {

		return getPersistence().fetchByC_A_First(
			commercialId, annee, orderByComparator);
	}

	/**
	 * Returns the last objectif in the ordered set where commercialId = &#63; and annee = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching objectif
	 * @throws NoSuchObjectifException if a matching objectif could not be found
	 */
	public static Objectif findByC_A_Last(
			long commercialId, int annee,
			OrderByComparator<Objectif> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchObjectifException {

		return getPersistence().findByC_A_Last(
			commercialId, annee, orderByComparator);
	}

	/**
	 * Returns the last objectif in the ordered set where commercialId = &#63; and annee = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching objectif, or <code>null</code> if a matching objectif could not be found
	 */
	public static Objectif fetchByC_A_Last(
		long commercialId, int annee,
		OrderByComparator<Objectif> orderByComparator) {

		return getPersistence().fetchByC_A_Last(
			commercialId, annee, orderByComparator);
	}

	/**
	 * Returns the objectifs before and after the current objectif in the ordered set where commercialId = &#63; and annee = &#63;.
	 *
	 * @param id the primary key of the current objectif
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next objectif
	 * @throws NoSuchObjectifException if a objectif with the primary key could not be found
	 */
	public static Objectif[] findByC_A_PrevAndNext(
			long id, long commercialId, int annee,
			OrderByComparator<Objectif> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchObjectifException {

		return getPersistence().findByC_A_PrevAndNext(
			id, commercialId, annee, orderByComparator);
	}

	/**
	 * Removes all the objectifs where commercialId = &#63; and annee = &#63; from the database.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 */
	public static void removeByC_A(long commercialId, int annee) {
		getPersistence().removeByC_A(commercialId, annee);
	}

	/**
	 * Returns the number of objectifs where commercialId = &#63; and annee = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @return the number of matching objectifs
	 */
	public static int countByC_A(long commercialId, int annee) {
		return getPersistence().countByC_A(commercialId, annee);
	}

	/**
	 * Returns the objectif where commercialId = &#63; and annee = &#63; and mois = &#63; or throws a <code>NoSuchObjectifException</code> if it could not be found.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param mois the mois
	 * @return the matching objectif
	 * @throws NoSuchObjectifException if a matching objectif could not be found
	 */
	public static Objectif findByC_A_M(long commercialId, int annee, int mois)
		throws com.df.lonis.ventesservice.exception.NoSuchObjectifException {

		return getPersistence().findByC_A_M(commercialId, annee, mois);
	}

	/**
	 * Returns the objectif where commercialId = &#63; and annee = &#63; and mois = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param mois the mois
	 * @return the matching objectif, or <code>null</code> if a matching objectif could not be found
	 */
	public static Objectif fetchByC_A_M(
		long commercialId, int annee, int mois) {

		return getPersistence().fetchByC_A_M(commercialId, annee, mois);
	}

	/**
	 * Returns the objectif where commercialId = &#63; and annee = &#63; and mois = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param mois the mois
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching objectif, or <code>null</code> if a matching objectif could not be found
	 */
	public static Objectif fetchByC_A_M(
		long commercialId, int annee, int mois, boolean useFinderCache) {

		return getPersistence().fetchByC_A_M(
			commercialId, annee, mois, useFinderCache);
	}

	/**
	 * Removes the objectif where commercialId = &#63; and annee = &#63; and mois = &#63; from the database.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param mois the mois
	 * @return the objectif that was removed
	 */
	public static Objectif removeByC_A_M(long commercialId, int annee, int mois)
		throws com.df.lonis.ventesservice.exception.NoSuchObjectifException {

		return getPersistence().removeByC_A_M(commercialId, annee, mois);
	}

	/**
	 * Returns the number of objectifs where commercialId = &#63; and annee = &#63; and mois = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param mois the mois
	 * @return the number of matching objectifs
	 */
	public static int countByC_A_M(long commercialId, int annee, int mois) {
		return getPersistence().countByC_A_M(commercialId, annee, mois);
	}

	/**
	 * Caches the objectif in the entity cache if it is enabled.
	 *
	 * @param objectif the objectif
	 */
	public static void cacheResult(Objectif objectif) {
		getPersistence().cacheResult(objectif);
	}

	/**
	 * Caches the objectifs in the entity cache if it is enabled.
	 *
	 * @param objectifs the objectifs
	 */
	public static void cacheResult(List<Objectif> objectifs) {
		getPersistence().cacheResult(objectifs);
	}

	/**
	 * Creates a new objectif with the primary key. Does not add the objectif to the database.
	 *
	 * @param id the primary key for the new objectif
	 * @return the new objectif
	 */
	public static Objectif create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the objectif with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the objectif
	 * @return the objectif that was removed
	 * @throws NoSuchObjectifException if a objectif with the primary key could not be found
	 */
	public static Objectif remove(long id)
		throws com.df.lonis.ventesservice.exception.NoSuchObjectifException {

		return getPersistence().remove(id);
	}

	public static Objectif updateImpl(Objectif objectif) {
		return getPersistence().updateImpl(objectif);
	}

	/**
	 * Returns the objectif with the primary key or throws a <code>NoSuchObjectifException</code> if it could not be found.
	 *
	 * @param id the primary key of the objectif
	 * @return the objectif
	 * @throws NoSuchObjectifException if a objectif with the primary key could not be found
	 */
	public static Objectif findByPrimaryKey(long id)
		throws com.df.lonis.ventesservice.exception.NoSuchObjectifException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the objectif with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the objectif
	 * @return the objectif, or <code>null</code> if a objectif with the primary key could not be found
	 */
	public static Objectif fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the objectifs.
	 *
	 * @return the objectifs
	 */
	public static List<Objectif> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the objectifs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ObjectifModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of objectifs
	 * @param end the upper bound of the range of objectifs (not inclusive)
	 * @return the range of objectifs
	 */
	public static List<Objectif> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the objectifs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ObjectifModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of objectifs
	 * @param end the upper bound of the range of objectifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of objectifs
	 */
	public static List<Objectif> findAll(
		int start, int end, OrderByComparator<Objectif> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the objectifs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ObjectifModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of objectifs
	 * @param end the upper bound of the range of objectifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of objectifs
	 */
	public static List<Objectif> findAll(
		int start, int end, OrderByComparator<Objectif> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the objectifs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of objectifs.
	 *
	 * @return the number of objectifs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ObjectifPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ObjectifPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ObjectifPersistence _persistence;

}