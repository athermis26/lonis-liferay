/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence;

import com.df.lonis.ventesservice.model.ChiffreAffaires;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the chiffre affaires service. This utility wraps <code>com.df.lonis.ventesservice.service.persistence.impl.ChiffreAffairesPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChiffreAffairesPersistence
 * @generated
 */
public class ChiffreAffairesUtil {

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
	public static void clearCache(ChiffreAffaires chiffreAffaires) {
		getPersistence().clearCache(chiffreAffaires);
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
	public static Map<Serializable, ChiffreAffaires> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ChiffreAffaires> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ChiffreAffaires> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ChiffreAffaires> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ChiffreAffaires> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ChiffreAffaires update(ChiffreAffaires chiffreAffaires) {
		return getPersistence().update(chiffreAffaires);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ChiffreAffaires update(
		ChiffreAffaires chiffreAffaires, ServiceContext serviceContext) {

		return getPersistence().update(chiffreAffaires, serviceContext);
	}

	/**
	 * Returns all the chiffre affaireses where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @return the matching chiffre affaireses
	 */
	public static List<ChiffreAffaires> findByTerminalId(long terminalId) {
		return getPersistence().findByTerminalId(terminalId);
	}

	/**
	 * Returns a range of all the chiffre affaireses where terminalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChiffreAffairesModelImpl</code>.
	 * </p>
	 *
	 * @param terminalId the terminal ID
	 * @param start the lower bound of the range of chiffre affaireses
	 * @param end the upper bound of the range of chiffre affaireses (not inclusive)
	 * @return the range of matching chiffre affaireses
	 */
	public static List<ChiffreAffaires> findByTerminalId(
		long terminalId, int start, int end) {

		return getPersistence().findByTerminalId(terminalId, start, end);
	}

	/**
	 * Returns an ordered range of all the chiffre affaireses where terminalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChiffreAffairesModelImpl</code>.
	 * </p>
	 *
	 * @param terminalId the terminal ID
	 * @param start the lower bound of the range of chiffre affaireses
	 * @param end the upper bound of the range of chiffre affaireses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chiffre affaireses
	 */
	public static List<ChiffreAffaires> findByTerminalId(
		long terminalId, int start, int end,
		OrderByComparator<ChiffreAffaires> orderByComparator) {

		return getPersistence().findByTerminalId(
			terminalId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the chiffre affaireses where terminalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChiffreAffairesModelImpl</code>.
	 * </p>
	 *
	 * @param terminalId the terminal ID
	 * @param start the lower bound of the range of chiffre affaireses
	 * @param end the upper bound of the range of chiffre affaireses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching chiffre affaireses
	 */
	public static List<ChiffreAffaires> findByTerminalId(
		long terminalId, int start, int end,
		OrderByComparator<ChiffreAffaires> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTerminalId(
			terminalId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first chiffre affaires in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chiffre affaires
	 * @throws NoSuchChiffreAffairesException if a matching chiffre affaires could not be found
	 */
	public static ChiffreAffaires findByTerminalId_First(
			long terminalId,
			OrderByComparator<ChiffreAffaires> orderByComparator)
		throws com.df.lonis.ventesservice.exception.
			NoSuchChiffreAffairesException {

		return getPersistence().findByTerminalId_First(
			terminalId, orderByComparator);
	}

	/**
	 * Returns the first chiffre affaires in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chiffre affaires, or <code>null</code> if a matching chiffre affaires could not be found
	 */
	public static ChiffreAffaires fetchByTerminalId_First(
		long terminalId, OrderByComparator<ChiffreAffaires> orderByComparator) {

		return getPersistence().fetchByTerminalId_First(
			terminalId, orderByComparator);
	}

	/**
	 * Returns the last chiffre affaires in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chiffre affaires
	 * @throws NoSuchChiffreAffairesException if a matching chiffre affaires could not be found
	 */
	public static ChiffreAffaires findByTerminalId_Last(
			long terminalId,
			OrderByComparator<ChiffreAffaires> orderByComparator)
		throws com.df.lonis.ventesservice.exception.
			NoSuchChiffreAffairesException {

		return getPersistence().findByTerminalId_Last(
			terminalId, orderByComparator);
	}

	/**
	 * Returns the last chiffre affaires in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chiffre affaires, or <code>null</code> if a matching chiffre affaires could not be found
	 */
	public static ChiffreAffaires fetchByTerminalId_Last(
		long terminalId, OrderByComparator<ChiffreAffaires> orderByComparator) {

		return getPersistence().fetchByTerminalId_Last(
			terminalId, orderByComparator);
	}

	/**
	 * Returns the chiffre affaireses before and after the current chiffre affaires in the ordered set where terminalId = &#63;.
	 *
	 * @param id the primary key of the current chiffre affaires
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chiffre affaires
	 * @throws NoSuchChiffreAffairesException if a chiffre affaires with the primary key could not be found
	 */
	public static ChiffreAffaires[] findByTerminalId_PrevAndNext(
			long id, long terminalId,
			OrderByComparator<ChiffreAffaires> orderByComparator)
		throws com.df.lonis.ventesservice.exception.
			NoSuchChiffreAffairesException {

		return getPersistence().findByTerminalId_PrevAndNext(
			id, terminalId, orderByComparator);
	}

	/**
	 * Removes all the chiffre affaireses where terminalId = &#63; from the database.
	 *
	 * @param terminalId the terminal ID
	 */
	public static void removeByTerminalId(long terminalId) {
		getPersistence().removeByTerminalId(terminalId);
	}

	/**
	 * Returns the number of chiffre affaireses where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @return the number of matching chiffre affaireses
	 */
	public static int countByTerminalId(long terminalId) {
		return getPersistence().countByTerminalId(terminalId);
	}

	/**
	 * Returns all the chiffre affaireses where terminalId = &#63; and date &ge; &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param date the date
	 * @return the matching chiffre affaireses
	 */
	public static List<ChiffreAffaires> findByT_D(long terminalId, Date date) {
		return getPersistence().findByT_D(terminalId, date);
	}

	/**
	 * Returns a range of all the chiffre affaireses where terminalId = &#63; and date &ge; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChiffreAffairesModelImpl</code>.
	 * </p>
	 *
	 * @param terminalId the terminal ID
	 * @param date the date
	 * @param start the lower bound of the range of chiffre affaireses
	 * @param end the upper bound of the range of chiffre affaireses (not inclusive)
	 * @return the range of matching chiffre affaireses
	 */
	public static List<ChiffreAffaires> findByT_D(
		long terminalId, Date date, int start, int end) {

		return getPersistence().findByT_D(terminalId, date, start, end);
	}

	/**
	 * Returns an ordered range of all the chiffre affaireses where terminalId = &#63; and date &ge; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChiffreAffairesModelImpl</code>.
	 * </p>
	 *
	 * @param terminalId the terminal ID
	 * @param date the date
	 * @param start the lower bound of the range of chiffre affaireses
	 * @param end the upper bound of the range of chiffre affaireses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chiffre affaireses
	 */
	public static List<ChiffreAffaires> findByT_D(
		long terminalId, Date date, int start, int end,
		OrderByComparator<ChiffreAffaires> orderByComparator) {

		return getPersistence().findByT_D(
			terminalId, date, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the chiffre affaireses where terminalId = &#63; and date &ge; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChiffreAffairesModelImpl</code>.
	 * </p>
	 *
	 * @param terminalId the terminal ID
	 * @param date the date
	 * @param start the lower bound of the range of chiffre affaireses
	 * @param end the upper bound of the range of chiffre affaireses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching chiffre affaireses
	 */
	public static List<ChiffreAffaires> findByT_D(
		long terminalId, Date date, int start, int end,
		OrderByComparator<ChiffreAffaires> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByT_D(
			terminalId, date, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first chiffre affaires in the ordered set where terminalId = &#63; and date &ge; &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chiffre affaires
	 * @throws NoSuchChiffreAffairesException if a matching chiffre affaires could not be found
	 */
	public static ChiffreAffaires findByT_D_First(
			long terminalId, Date date,
			OrderByComparator<ChiffreAffaires> orderByComparator)
		throws com.df.lonis.ventesservice.exception.
			NoSuchChiffreAffairesException {

		return getPersistence().findByT_D_First(
			terminalId, date, orderByComparator);
	}

	/**
	 * Returns the first chiffre affaires in the ordered set where terminalId = &#63; and date &ge; &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chiffre affaires, or <code>null</code> if a matching chiffre affaires could not be found
	 */
	public static ChiffreAffaires fetchByT_D_First(
		long terminalId, Date date,
		OrderByComparator<ChiffreAffaires> orderByComparator) {

		return getPersistence().fetchByT_D_First(
			terminalId, date, orderByComparator);
	}

	/**
	 * Returns the last chiffre affaires in the ordered set where terminalId = &#63; and date &ge; &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chiffre affaires
	 * @throws NoSuchChiffreAffairesException if a matching chiffre affaires could not be found
	 */
	public static ChiffreAffaires findByT_D_Last(
			long terminalId, Date date,
			OrderByComparator<ChiffreAffaires> orderByComparator)
		throws com.df.lonis.ventesservice.exception.
			NoSuchChiffreAffairesException {

		return getPersistence().findByT_D_Last(
			terminalId, date, orderByComparator);
	}

	/**
	 * Returns the last chiffre affaires in the ordered set where terminalId = &#63; and date &ge; &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chiffre affaires, or <code>null</code> if a matching chiffre affaires could not be found
	 */
	public static ChiffreAffaires fetchByT_D_Last(
		long terminalId, Date date,
		OrderByComparator<ChiffreAffaires> orderByComparator) {

		return getPersistence().fetchByT_D_Last(
			terminalId, date, orderByComparator);
	}

	/**
	 * Returns the chiffre affaireses before and after the current chiffre affaires in the ordered set where terminalId = &#63; and date &ge; &#63;.
	 *
	 * @param id the primary key of the current chiffre affaires
	 * @param terminalId the terminal ID
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chiffre affaires
	 * @throws NoSuchChiffreAffairesException if a chiffre affaires with the primary key could not be found
	 */
	public static ChiffreAffaires[] findByT_D_PrevAndNext(
			long id, long terminalId, Date date,
			OrderByComparator<ChiffreAffaires> orderByComparator)
		throws com.df.lonis.ventesservice.exception.
			NoSuchChiffreAffairesException {

		return getPersistence().findByT_D_PrevAndNext(
			id, terminalId, date, orderByComparator);
	}

	/**
	 * Removes all the chiffre affaireses where terminalId = &#63; and date &ge; &#63; from the database.
	 *
	 * @param terminalId the terminal ID
	 * @param date the date
	 */
	public static void removeByT_D(long terminalId, Date date) {
		getPersistence().removeByT_D(terminalId, date);
	}

	/**
	 * Returns the number of chiffre affaireses where terminalId = &#63; and date &ge; &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param date the date
	 * @return the number of matching chiffre affaireses
	 */
	public static int countByT_D(long terminalId, Date date) {
		return getPersistence().countByT_D(terminalId, date);
	}

	/**
	 * Caches the chiffre affaires in the entity cache if it is enabled.
	 *
	 * @param chiffreAffaires the chiffre affaires
	 */
	public static void cacheResult(ChiffreAffaires chiffreAffaires) {
		getPersistence().cacheResult(chiffreAffaires);
	}

	/**
	 * Caches the chiffre affaireses in the entity cache if it is enabled.
	 *
	 * @param chiffreAffaireses the chiffre affaireses
	 */
	public static void cacheResult(List<ChiffreAffaires> chiffreAffaireses) {
		getPersistence().cacheResult(chiffreAffaireses);
	}

	/**
	 * Creates a new chiffre affaires with the primary key. Does not add the chiffre affaires to the database.
	 *
	 * @param id the primary key for the new chiffre affaires
	 * @return the new chiffre affaires
	 */
	public static ChiffreAffaires create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the chiffre affaires with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the chiffre affaires
	 * @return the chiffre affaires that was removed
	 * @throws NoSuchChiffreAffairesException if a chiffre affaires with the primary key could not be found
	 */
	public static ChiffreAffaires remove(long id)
		throws com.df.lonis.ventesservice.exception.
			NoSuchChiffreAffairesException {

		return getPersistence().remove(id);
	}

	public static ChiffreAffaires updateImpl(ChiffreAffaires chiffreAffaires) {
		return getPersistence().updateImpl(chiffreAffaires);
	}

	/**
	 * Returns the chiffre affaires with the primary key or throws a <code>NoSuchChiffreAffairesException</code> if it could not be found.
	 *
	 * @param id the primary key of the chiffre affaires
	 * @return the chiffre affaires
	 * @throws NoSuchChiffreAffairesException if a chiffre affaires with the primary key could not be found
	 */
	public static ChiffreAffaires findByPrimaryKey(long id)
		throws com.df.lonis.ventesservice.exception.
			NoSuchChiffreAffairesException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the chiffre affaires with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the chiffre affaires
	 * @return the chiffre affaires, or <code>null</code> if a chiffre affaires with the primary key could not be found
	 */
	public static ChiffreAffaires fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the chiffre affaireses.
	 *
	 * @return the chiffre affaireses
	 */
	public static List<ChiffreAffaires> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the chiffre affaireses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChiffreAffairesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chiffre affaireses
	 * @param end the upper bound of the range of chiffre affaireses (not inclusive)
	 * @return the range of chiffre affaireses
	 */
	public static List<ChiffreAffaires> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the chiffre affaireses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChiffreAffairesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chiffre affaireses
	 * @param end the upper bound of the range of chiffre affaireses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of chiffre affaireses
	 */
	public static List<ChiffreAffaires> findAll(
		int start, int end,
		OrderByComparator<ChiffreAffaires> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the chiffre affaireses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChiffreAffairesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chiffre affaireses
	 * @param end the upper bound of the range of chiffre affaireses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of chiffre affaireses
	 */
	public static List<ChiffreAffaires> findAll(
		int start, int end,
		OrderByComparator<ChiffreAffaires> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the chiffre affaireses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of chiffre affaireses.
	 *
	 * @return the number of chiffre affaireses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ChiffreAffairesPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ChiffreAffairesPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ChiffreAffairesPersistence _persistence;

}