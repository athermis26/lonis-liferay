/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence;

import com.df.lonis.ventesservice.model.Concessionnaire;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the concessionnaire service. This utility wraps <code>com.df.lonis.ventesservice.service.persistence.impl.ConcessionnairePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConcessionnairePersistence
 * @generated
 */
public class ConcessionnaireUtil {

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
	public static void clearCache(Concessionnaire concessionnaire) {
		getPersistence().clearCache(concessionnaire);
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
	public static Map<Serializable, Concessionnaire> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Concessionnaire> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Concessionnaire> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Concessionnaire> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Concessionnaire> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Concessionnaire update(Concessionnaire concessionnaire) {
		return getPersistence().update(concessionnaire);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Concessionnaire update(
		Concessionnaire concessionnaire, ServiceContext serviceContext) {

		return getPersistence().update(concessionnaire, serviceContext);
	}

	/**
	 * Returns the concessionnaire where uid = &#63; or throws a <code>NoSuchConcessionnaireException</code> if it could not be found.
	 *
	 * @param uid the uid
	 * @return the matching concessionnaire
	 * @throws NoSuchConcessionnaireException if a matching concessionnaire could not be found
	 */
	public static Concessionnaire findByUid(String uid)
		throws com.df.lonis.ventesservice.exception.
			NoSuchConcessionnaireException {

		return getPersistence().findByUid(uid);
	}

	/**
	 * Returns the concessionnaire where uid = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uid the uid
	 * @return the matching concessionnaire, or <code>null</code> if a matching concessionnaire could not be found
	 */
	public static Concessionnaire fetchByUid(String uid) {
		return getPersistence().fetchByUid(uid);
	}

	/**
	 * Returns the concessionnaire where uid = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uid the uid
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching concessionnaire, or <code>null</code> if a matching concessionnaire could not be found
	 */
	public static Concessionnaire fetchByUid(
		String uid, boolean useFinderCache) {

		return getPersistence().fetchByUid(uid, useFinderCache);
	}

	/**
	 * Removes the concessionnaire where uid = &#63; from the database.
	 *
	 * @param uid the uid
	 * @return the concessionnaire that was removed
	 */
	public static Concessionnaire removeByUid(String uid)
		throws com.df.lonis.ventesservice.exception.
			NoSuchConcessionnaireException {

		return getPersistence().removeByUid(uid);
	}

	/**
	 * Returns the number of concessionnaires where uid = &#63;.
	 *
	 * @param uid the uid
	 * @return the number of matching concessionnaires
	 */
	public static int countByUid(String uid) {
		return getPersistence().countByUid(uid);
	}

	/**
	 * Returns all the concessionnaires where nom = &#63;.
	 *
	 * @param nom the nom
	 * @return the matching concessionnaires
	 */
	public static List<Concessionnaire> findByNom(String nom) {
		return getPersistence().findByNom(nom);
	}

	/**
	 * Returns a range of all the concessionnaires where nom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConcessionnaireModelImpl</code>.
	 * </p>
	 *
	 * @param nom the nom
	 * @param start the lower bound of the range of concessionnaires
	 * @param end the upper bound of the range of concessionnaires (not inclusive)
	 * @return the range of matching concessionnaires
	 */
	public static List<Concessionnaire> findByNom(
		String nom, int start, int end) {

		return getPersistence().findByNom(nom, start, end);
	}

	/**
	 * Returns an ordered range of all the concessionnaires where nom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConcessionnaireModelImpl</code>.
	 * </p>
	 *
	 * @param nom the nom
	 * @param start the lower bound of the range of concessionnaires
	 * @param end the upper bound of the range of concessionnaires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching concessionnaires
	 */
	public static List<Concessionnaire> findByNom(
		String nom, int start, int end,
		OrderByComparator<Concessionnaire> orderByComparator) {

		return getPersistence().findByNom(nom, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the concessionnaires where nom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConcessionnaireModelImpl</code>.
	 * </p>
	 *
	 * @param nom the nom
	 * @param start the lower bound of the range of concessionnaires
	 * @param end the upper bound of the range of concessionnaires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching concessionnaires
	 */
	public static List<Concessionnaire> findByNom(
		String nom, int start, int end,
		OrderByComparator<Concessionnaire> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByNom(
			nom, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first concessionnaire in the ordered set where nom = &#63;.
	 *
	 * @param nom the nom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concessionnaire
	 * @throws NoSuchConcessionnaireException if a matching concessionnaire could not be found
	 */
	public static Concessionnaire findByNom_First(
			String nom, OrderByComparator<Concessionnaire> orderByComparator)
		throws com.df.lonis.ventesservice.exception.
			NoSuchConcessionnaireException {

		return getPersistence().findByNom_First(nom, orderByComparator);
	}

	/**
	 * Returns the first concessionnaire in the ordered set where nom = &#63;.
	 *
	 * @param nom the nom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concessionnaire, or <code>null</code> if a matching concessionnaire could not be found
	 */
	public static Concessionnaire fetchByNom_First(
		String nom, OrderByComparator<Concessionnaire> orderByComparator) {

		return getPersistence().fetchByNom_First(nom, orderByComparator);
	}

	/**
	 * Returns the last concessionnaire in the ordered set where nom = &#63;.
	 *
	 * @param nom the nom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concessionnaire
	 * @throws NoSuchConcessionnaireException if a matching concessionnaire could not be found
	 */
	public static Concessionnaire findByNom_Last(
			String nom, OrderByComparator<Concessionnaire> orderByComparator)
		throws com.df.lonis.ventesservice.exception.
			NoSuchConcessionnaireException {

		return getPersistence().findByNom_Last(nom, orderByComparator);
	}

	/**
	 * Returns the last concessionnaire in the ordered set where nom = &#63;.
	 *
	 * @param nom the nom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concessionnaire, or <code>null</code> if a matching concessionnaire could not be found
	 */
	public static Concessionnaire fetchByNom_Last(
		String nom, OrderByComparator<Concessionnaire> orderByComparator) {

		return getPersistence().fetchByNom_Last(nom, orderByComparator);
	}

	/**
	 * Returns the concessionnaires before and after the current concessionnaire in the ordered set where nom = &#63;.
	 *
	 * @param id the primary key of the current concessionnaire
	 * @param nom the nom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next concessionnaire
	 * @throws NoSuchConcessionnaireException if a concessionnaire with the primary key could not be found
	 */
	public static Concessionnaire[] findByNom_PrevAndNext(
			long id, String nom,
			OrderByComparator<Concessionnaire> orderByComparator)
		throws com.df.lonis.ventesservice.exception.
			NoSuchConcessionnaireException {

		return getPersistence().findByNom_PrevAndNext(
			id, nom, orderByComparator);
	}

	/**
	 * Removes all the concessionnaires where nom = &#63; from the database.
	 *
	 * @param nom the nom
	 */
	public static void removeByNom(String nom) {
		getPersistence().removeByNom(nom);
	}

	/**
	 * Returns the number of concessionnaires where nom = &#63;.
	 *
	 * @param nom the nom
	 * @return the number of matching concessionnaires
	 */
	public static int countByNom(String nom) {
		return getPersistence().countByNom(nom);
	}

	/**
	 * Caches the concessionnaire in the entity cache if it is enabled.
	 *
	 * @param concessionnaire the concessionnaire
	 */
	public static void cacheResult(Concessionnaire concessionnaire) {
		getPersistence().cacheResult(concessionnaire);
	}

	/**
	 * Caches the concessionnaires in the entity cache if it is enabled.
	 *
	 * @param concessionnaires the concessionnaires
	 */
	public static void cacheResult(List<Concessionnaire> concessionnaires) {
		getPersistence().cacheResult(concessionnaires);
	}

	/**
	 * Creates a new concessionnaire with the primary key. Does not add the concessionnaire to the database.
	 *
	 * @param id the primary key for the new concessionnaire
	 * @return the new concessionnaire
	 */
	public static Concessionnaire create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the concessionnaire with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the concessionnaire
	 * @return the concessionnaire that was removed
	 * @throws NoSuchConcessionnaireException if a concessionnaire with the primary key could not be found
	 */
	public static Concessionnaire remove(long id)
		throws com.df.lonis.ventesservice.exception.
			NoSuchConcessionnaireException {

		return getPersistence().remove(id);
	}

	public static Concessionnaire updateImpl(Concessionnaire concessionnaire) {
		return getPersistence().updateImpl(concessionnaire);
	}

	/**
	 * Returns the concessionnaire with the primary key or throws a <code>NoSuchConcessionnaireException</code> if it could not be found.
	 *
	 * @param id the primary key of the concessionnaire
	 * @return the concessionnaire
	 * @throws NoSuchConcessionnaireException if a concessionnaire with the primary key could not be found
	 */
	public static Concessionnaire findByPrimaryKey(long id)
		throws com.df.lonis.ventesservice.exception.
			NoSuchConcessionnaireException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the concessionnaire with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the concessionnaire
	 * @return the concessionnaire, or <code>null</code> if a concessionnaire with the primary key could not be found
	 */
	public static Concessionnaire fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the concessionnaires.
	 *
	 * @return the concessionnaires
	 */
	public static List<Concessionnaire> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the concessionnaires.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConcessionnaireModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of concessionnaires
	 * @param end the upper bound of the range of concessionnaires (not inclusive)
	 * @return the range of concessionnaires
	 */
	public static List<Concessionnaire> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the concessionnaires.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConcessionnaireModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of concessionnaires
	 * @param end the upper bound of the range of concessionnaires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of concessionnaires
	 */
	public static List<Concessionnaire> findAll(
		int start, int end,
		OrderByComparator<Concessionnaire> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the concessionnaires.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConcessionnaireModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of concessionnaires
	 * @param end the upper bound of the range of concessionnaires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of concessionnaires
	 */
	public static List<Concessionnaire> findAll(
		int start, int end,
		OrderByComparator<Concessionnaire> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the concessionnaires from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of concessionnaires.
	 *
	 * @return the number of concessionnaires
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ConcessionnairePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ConcessionnairePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ConcessionnairePersistence _persistence;

}