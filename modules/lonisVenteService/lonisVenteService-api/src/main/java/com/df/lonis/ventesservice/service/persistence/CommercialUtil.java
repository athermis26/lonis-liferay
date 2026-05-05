/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence;

import com.df.lonis.ventesservice.model.Commercial;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the commercial service. This utility wraps <code>com.df.lonis.ventesservice.service.persistence.impl.CommercialPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CommercialPersistence
 * @generated
 */
public class CommercialUtil {

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
	public static void clearCache(Commercial commercial) {
		getPersistence().clearCache(commercial);
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
	public static Map<Serializable, Commercial> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Commercial> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Commercial> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Commercial> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Commercial> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Commercial update(Commercial commercial) {
		return getPersistence().update(commercial);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Commercial update(
		Commercial commercial, ServiceContext serviceContext) {

		return getPersistence().update(commercial, serviceContext);
	}

	/**
	 * Returns the commercial where matricule = &#63; or throws a <code>NoSuchCommercialException</code> if it could not be found.
	 *
	 * @param matricule the matricule
	 * @return the matching commercial
	 * @throws NoSuchCommercialException if a matching commercial could not be found
	 */
	public static Commercial findByMatricule(String matricule)
		throws com.df.lonis.ventesservice.exception.NoSuchCommercialException {

		return getPersistence().findByMatricule(matricule);
	}

	/**
	 * Returns the commercial where matricule = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param matricule the matricule
	 * @return the matching commercial, or <code>null</code> if a matching commercial could not be found
	 */
	public static Commercial fetchByMatricule(String matricule) {
		return getPersistence().fetchByMatricule(matricule);
	}

	/**
	 * Returns the commercial where matricule = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param matricule the matricule
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching commercial, or <code>null</code> if a matching commercial could not be found
	 */
	public static Commercial fetchByMatricule(
		String matricule, boolean useFinderCache) {

		return getPersistence().fetchByMatricule(matricule, useFinderCache);
	}

	/**
	 * Removes the commercial where matricule = &#63; from the database.
	 *
	 * @param matricule the matricule
	 * @return the commercial that was removed
	 */
	public static Commercial removeByMatricule(String matricule)
		throws com.df.lonis.ventesservice.exception.NoSuchCommercialException {

		return getPersistence().removeByMatricule(matricule);
	}

	/**
	 * Returns the number of commercials where matricule = &#63;.
	 *
	 * @param matricule the matricule
	 * @return the number of matching commercials
	 */
	public static int countByMatricule(String matricule) {
		return getPersistence().countByMatricule(matricule);
	}

	/**
	 * Returns all the commercials where superviseurId = &#63;.
	 *
	 * @param superviseurId the superviseur ID
	 * @return the matching commercials
	 */
	public static List<Commercial> findBySuperviseurId(long superviseurId) {
		return getPersistence().findBySuperviseurId(superviseurId);
	}

	/**
	 * Returns a range of all the commercials where superviseurId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercialModelImpl</code>.
	 * </p>
	 *
	 * @param superviseurId the superviseur ID
	 * @param start the lower bound of the range of commercials
	 * @param end the upper bound of the range of commercials (not inclusive)
	 * @return the range of matching commercials
	 */
	public static List<Commercial> findBySuperviseurId(
		long superviseurId, int start, int end) {

		return getPersistence().findBySuperviseurId(superviseurId, start, end);
	}

	/**
	 * Returns an ordered range of all the commercials where superviseurId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercialModelImpl</code>.
	 * </p>
	 *
	 * @param superviseurId the superviseur ID
	 * @param start the lower bound of the range of commercials
	 * @param end the upper bound of the range of commercials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commercials
	 */
	public static List<Commercial> findBySuperviseurId(
		long superviseurId, int start, int end,
		OrderByComparator<Commercial> orderByComparator) {

		return getPersistence().findBySuperviseurId(
			superviseurId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the commercials where superviseurId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercialModelImpl</code>.
	 * </p>
	 *
	 * @param superviseurId the superviseur ID
	 * @param start the lower bound of the range of commercials
	 * @param end the upper bound of the range of commercials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commercials
	 */
	public static List<Commercial> findBySuperviseurId(
		long superviseurId, int start, int end,
		OrderByComparator<Commercial> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySuperviseurId(
			superviseurId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first commercial in the ordered set where superviseurId = &#63;.
	 *
	 * @param superviseurId the superviseur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commercial
	 * @throws NoSuchCommercialException if a matching commercial could not be found
	 */
	public static Commercial findBySuperviseurId_First(
			long superviseurId, OrderByComparator<Commercial> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchCommercialException {

		return getPersistence().findBySuperviseurId_First(
			superviseurId, orderByComparator);
	}

	/**
	 * Returns the first commercial in the ordered set where superviseurId = &#63;.
	 *
	 * @param superviseurId the superviseur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commercial, or <code>null</code> if a matching commercial could not be found
	 */
	public static Commercial fetchBySuperviseurId_First(
		long superviseurId, OrderByComparator<Commercial> orderByComparator) {

		return getPersistence().fetchBySuperviseurId_First(
			superviseurId, orderByComparator);
	}

	/**
	 * Returns the last commercial in the ordered set where superviseurId = &#63;.
	 *
	 * @param superviseurId the superviseur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commercial
	 * @throws NoSuchCommercialException if a matching commercial could not be found
	 */
	public static Commercial findBySuperviseurId_Last(
			long superviseurId, OrderByComparator<Commercial> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchCommercialException {

		return getPersistence().findBySuperviseurId_Last(
			superviseurId, orderByComparator);
	}

	/**
	 * Returns the last commercial in the ordered set where superviseurId = &#63;.
	 *
	 * @param superviseurId the superviseur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commercial, or <code>null</code> if a matching commercial could not be found
	 */
	public static Commercial fetchBySuperviseurId_Last(
		long superviseurId, OrderByComparator<Commercial> orderByComparator) {

		return getPersistence().fetchBySuperviseurId_Last(
			superviseurId, orderByComparator);
	}

	/**
	 * Returns the commercials before and after the current commercial in the ordered set where superviseurId = &#63;.
	 *
	 * @param id the primary key of the current commercial
	 * @param superviseurId the superviseur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commercial
	 * @throws NoSuchCommercialException if a commercial with the primary key could not be found
	 */
	public static Commercial[] findBySuperviseurId_PrevAndNext(
			long id, long superviseurId,
			OrderByComparator<Commercial> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchCommercialException {

		return getPersistence().findBySuperviseurId_PrevAndNext(
			id, superviseurId, orderByComparator);
	}

	/**
	 * Removes all the commercials where superviseurId = &#63; from the database.
	 *
	 * @param superviseurId the superviseur ID
	 */
	public static void removeBySuperviseurId(long superviseurId) {
		getPersistence().removeBySuperviseurId(superviseurId);
	}

	/**
	 * Returns the number of commercials where superviseurId = &#63;.
	 *
	 * @param superviseurId the superviseur ID
	 * @return the number of matching commercials
	 */
	public static int countBySuperviseurId(long superviseurId) {
		return getPersistence().countBySuperviseurId(superviseurId);
	}

	/**
	 * Returns all the commercials where statut = &#63;.
	 *
	 * @param statut the statut
	 * @return the matching commercials
	 */
	public static List<Commercial> findByStatut(String statut) {
		return getPersistence().findByStatut(statut);
	}

	/**
	 * Returns a range of all the commercials where statut = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercialModelImpl</code>.
	 * </p>
	 *
	 * @param statut the statut
	 * @param start the lower bound of the range of commercials
	 * @param end the upper bound of the range of commercials (not inclusive)
	 * @return the range of matching commercials
	 */
	public static List<Commercial> findByStatut(
		String statut, int start, int end) {

		return getPersistence().findByStatut(statut, start, end);
	}

	/**
	 * Returns an ordered range of all the commercials where statut = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercialModelImpl</code>.
	 * </p>
	 *
	 * @param statut the statut
	 * @param start the lower bound of the range of commercials
	 * @param end the upper bound of the range of commercials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commercials
	 */
	public static List<Commercial> findByStatut(
		String statut, int start, int end,
		OrderByComparator<Commercial> orderByComparator) {

		return getPersistence().findByStatut(
			statut, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the commercials where statut = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercialModelImpl</code>.
	 * </p>
	 *
	 * @param statut the statut
	 * @param start the lower bound of the range of commercials
	 * @param end the upper bound of the range of commercials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commercials
	 */
	public static List<Commercial> findByStatut(
		String statut, int start, int end,
		OrderByComparator<Commercial> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatut(
			statut, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first commercial in the ordered set where statut = &#63;.
	 *
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commercial
	 * @throws NoSuchCommercialException if a matching commercial could not be found
	 */
	public static Commercial findByStatut_First(
			String statut, OrderByComparator<Commercial> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchCommercialException {

		return getPersistence().findByStatut_First(statut, orderByComparator);
	}

	/**
	 * Returns the first commercial in the ordered set where statut = &#63;.
	 *
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commercial, or <code>null</code> if a matching commercial could not be found
	 */
	public static Commercial fetchByStatut_First(
		String statut, OrderByComparator<Commercial> orderByComparator) {

		return getPersistence().fetchByStatut_First(statut, orderByComparator);
	}

	/**
	 * Returns the last commercial in the ordered set where statut = &#63;.
	 *
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commercial
	 * @throws NoSuchCommercialException if a matching commercial could not be found
	 */
	public static Commercial findByStatut_Last(
			String statut, OrderByComparator<Commercial> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchCommercialException {

		return getPersistence().findByStatut_Last(statut, orderByComparator);
	}

	/**
	 * Returns the last commercial in the ordered set where statut = &#63;.
	 *
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commercial, or <code>null</code> if a matching commercial could not be found
	 */
	public static Commercial fetchByStatut_Last(
		String statut, OrderByComparator<Commercial> orderByComparator) {

		return getPersistence().fetchByStatut_Last(statut, orderByComparator);
	}

	/**
	 * Returns the commercials before and after the current commercial in the ordered set where statut = &#63;.
	 *
	 * @param id the primary key of the current commercial
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commercial
	 * @throws NoSuchCommercialException if a commercial with the primary key could not be found
	 */
	public static Commercial[] findByStatut_PrevAndNext(
			long id, String statut,
			OrderByComparator<Commercial> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchCommercialException {

		return getPersistence().findByStatut_PrevAndNext(
			id, statut, orderByComparator);
	}

	/**
	 * Removes all the commercials where statut = &#63; from the database.
	 *
	 * @param statut the statut
	 */
	public static void removeByStatut(String statut) {
		getPersistence().removeByStatut(statut);
	}

	/**
	 * Returns the number of commercials where statut = &#63;.
	 *
	 * @param statut the statut
	 * @return the number of matching commercials
	 */
	public static int countByStatut(String statut) {
		return getPersistence().countByStatut(statut);
	}

	/**
	 * Caches the commercial in the entity cache if it is enabled.
	 *
	 * @param commercial the commercial
	 */
	public static void cacheResult(Commercial commercial) {
		getPersistence().cacheResult(commercial);
	}

	/**
	 * Caches the commercials in the entity cache if it is enabled.
	 *
	 * @param commercials the commercials
	 */
	public static void cacheResult(List<Commercial> commercials) {
		getPersistence().cacheResult(commercials);
	}

	/**
	 * Creates a new commercial with the primary key. Does not add the commercial to the database.
	 *
	 * @param id the primary key for the new commercial
	 * @return the new commercial
	 */
	public static Commercial create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the commercial with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the commercial
	 * @return the commercial that was removed
	 * @throws NoSuchCommercialException if a commercial with the primary key could not be found
	 */
	public static Commercial remove(long id)
		throws com.df.lonis.ventesservice.exception.NoSuchCommercialException {

		return getPersistence().remove(id);
	}

	public static Commercial updateImpl(Commercial commercial) {
		return getPersistence().updateImpl(commercial);
	}

	/**
	 * Returns the commercial with the primary key or throws a <code>NoSuchCommercialException</code> if it could not be found.
	 *
	 * @param id the primary key of the commercial
	 * @return the commercial
	 * @throws NoSuchCommercialException if a commercial with the primary key could not be found
	 */
	public static Commercial findByPrimaryKey(long id)
		throws com.df.lonis.ventesservice.exception.NoSuchCommercialException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the commercial with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the commercial
	 * @return the commercial, or <code>null</code> if a commercial with the primary key could not be found
	 */
	public static Commercial fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the commercials.
	 *
	 * @return the commercials
	 */
	public static List<Commercial> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the commercials.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercialModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commercials
	 * @param end the upper bound of the range of commercials (not inclusive)
	 * @return the range of commercials
	 */
	public static List<Commercial> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the commercials.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercialModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commercials
	 * @param end the upper bound of the range of commercials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of commercials
	 */
	public static List<Commercial> findAll(
		int start, int end, OrderByComparator<Commercial> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the commercials.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercialModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commercials
	 * @param end the upper bound of the range of commercials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of commercials
	 */
	public static List<Commercial> findAll(
		int start, int end, OrderByComparator<Commercial> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the commercials from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of commercials.
	 *
	 * @return the number of commercials
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CommercialPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(CommercialPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile CommercialPersistence _persistence;

}