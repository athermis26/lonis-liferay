/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence;

import com.df.lonis.ventesservice.model.Visite;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the visite service. This utility wraps <code>com.df.lonis.ventesservice.service.persistence.impl.VisitePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VisitePersistence
 * @generated
 */
public class VisiteUtil {

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
	public static void clearCache(Visite visite) {
		getPersistence().clearCache(visite);
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
	public static Map<Serializable, Visite> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Visite> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Visite> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Visite> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Visite> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Visite update(Visite visite) {
		return getPersistence().update(visite);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Visite update(Visite visite, ServiceContext serviceContext) {
		return getPersistence().update(visite, serviceContext);
	}

	/**
	 * Returns all the visites where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @return the matching visites
	 */
	public static List<Visite> findByCommercialId(long commercialId) {
		return getPersistence().findByCommercialId(commercialId);
	}

	/**
	 * Returns a range of all the visites where commercialId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @return the range of matching visites
	 */
	public static List<Visite> findByCommercialId(
		long commercialId, int start, int end) {

		return getPersistence().findByCommercialId(commercialId, start, end);
	}

	/**
	 * Returns an ordered range of all the visites where commercialId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visites
	 */
	public static List<Visite> findByCommercialId(
		long commercialId, int start, int end,
		OrderByComparator<Visite> orderByComparator) {

		return getPersistence().findByCommercialId(
			commercialId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the visites where commercialId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visites
	 */
	public static List<Visite> findByCommercialId(
		long commercialId, int start, int end,
		OrderByComparator<Visite> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCommercialId(
			commercialId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first visite in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visite
	 * @throws NoSuchVisiteException if a matching visite could not be found
	 */
	public static Visite findByCommercialId_First(
			long commercialId, OrderByComparator<Visite> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchVisiteException {

		return getPersistence().findByCommercialId_First(
			commercialId, orderByComparator);
	}

	/**
	 * Returns the first visite in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visite, or <code>null</code> if a matching visite could not be found
	 */
	public static Visite fetchByCommercialId_First(
		long commercialId, OrderByComparator<Visite> orderByComparator) {

		return getPersistence().fetchByCommercialId_First(
			commercialId, orderByComparator);
	}

	/**
	 * Returns the last visite in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visite
	 * @throws NoSuchVisiteException if a matching visite could not be found
	 */
	public static Visite findByCommercialId_Last(
			long commercialId, OrderByComparator<Visite> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchVisiteException {

		return getPersistence().findByCommercialId_Last(
			commercialId, orderByComparator);
	}

	/**
	 * Returns the last visite in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visite, or <code>null</code> if a matching visite could not be found
	 */
	public static Visite fetchByCommercialId_Last(
		long commercialId, OrderByComparator<Visite> orderByComparator) {

		return getPersistence().fetchByCommercialId_Last(
			commercialId, orderByComparator);
	}

	/**
	 * Returns the visites before and after the current visite in the ordered set where commercialId = &#63;.
	 *
	 * @param id the primary key of the current visite
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visite
	 * @throws NoSuchVisiteException if a visite with the primary key could not be found
	 */
	public static Visite[] findByCommercialId_PrevAndNext(
			long id, long commercialId,
			OrderByComparator<Visite> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchVisiteException {

		return getPersistence().findByCommercialId_PrevAndNext(
			id, commercialId, orderByComparator);
	}

	/**
	 * Removes all the visites where commercialId = &#63; from the database.
	 *
	 * @param commercialId the commercial ID
	 */
	public static void removeByCommercialId(long commercialId) {
		getPersistence().removeByCommercialId(commercialId);
	}

	/**
	 * Returns the number of visites where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @return the number of matching visites
	 */
	public static int countByCommercialId(long commercialId) {
		return getPersistence().countByCommercialId(commercialId);
	}

	/**
	 * Returns all the visites where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @return the matching visites
	 */
	public static List<Visite> findByTerminalId(long terminalId) {
		return getPersistence().findByTerminalId(terminalId);
	}

	/**
	 * Returns a range of all the visites where terminalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param terminalId the terminal ID
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @return the range of matching visites
	 */
	public static List<Visite> findByTerminalId(
		long terminalId, int start, int end) {

		return getPersistence().findByTerminalId(terminalId, start, end);
	}

	/**
	 * Returns an ordered range of all the visites where terminalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param terminalId the terminal ID
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visites
	 */
	public static List<Visite> findByTerminalId(
		long terminalId, int start, int end,
		OrderByComparator<Visite> orderByComparator) {

		return getPersistence().findByTerminalId(
			terminalId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the visites where terminalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param terminalId the terminal ID
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visites
	 */
	public static List<Visite> findByTerminalId(
		long terminalId, int start, int end,
		OrderByComparator<Visite> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByTerminalId(
			terminalId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first visite in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visite
	 * @throws NoSuchVisiteException if a matching visite could not be found
	 */
	public static Visite findByTerminalId_First(
			long terminalId, OrderByComparator<Visite> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchVisiteException {

		return getPersistence().findByTerminalId_First(
			terminalId, orderByComparator);
	}

	/**
	 * Returns the first visite in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visite, or <code>null</code> if a matching visite could not be found
	 */
	public static Visite fetchByTerminalId_First(
		long terminalId, OrderByComparator<Visite> orderByComparator) {

		return getPersistence().fetchByTerminalId_First(
			terminalId, orderByComparator);
	}

	/**
	 * Returns the last visite in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visite
	 * @throws NoSuchVisiteException if a matching visite could not be found
	 */
	public static Visite findByTerminalId_Last(
			long terminalId, OrderByComparator<Visite> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchVisiteException {

		return getPersistence().findByTerminalId_Last(
			terminalId, orderByComparator);
	}

	/**
	 * Returns the last visite in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visite, or <code>null</code> if a matching visite could not be found
	 */
	public static Visite fetchByTerminalId_Last(
		long terminalId, OrderByComparator<Visite> orderByComparator) {

		return getPersistence().fetchByTerminalId_Last(
			terminalId, orderByComparator);
	}

	/**
	 * Returns the visites before and after the current visite in the ordered set where terminalId = &#63;.
	 *
	 * @param id the primary key of the current visite
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visite
	 * @throws NoSuchVisiteException if a visite with the primary key could not be found
	 */
	public static Visite[] findByTerminalId_PrevAndNext(
			long id, long terminalId,
			OrderByComparator<Visite> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchVisiteException {

		return getPersistence().findByTerminalId_PrevAndNext(
			id, terminalId, orderByComparator);
	}

	/**
	 * Removes all the visites where terminalId = &#63; from the database.
	 *
	 * @param terminalId the terminal ID
	 */
	public static void removeByTerminalId(long terminalId) {
		getPersistence().removeByTerminalId(terminalId);
	}

	/**
	 * Returns the number of visites where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @return the number of matching visites
	 */
	public static int countByTerminalId(long terminalId) {
		return getPersistence().countByTerminalId(terminalId);
	}

	/**
	 * Returns all the visites where statut = &#63;.
	 *
	 * @param statut the statut
	 * @return the matching visites
	 */
	public static List<Visite> findByStatut(String statut) {
		return getPersistence().findByStatut(statut);
	}

	/**
	 * Returns a range of all the visites where statut = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param statut the statut
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @return the range of matching visites
	 */
	public static List<Visite> findByStatut(String statut, int start, int end) {
		return getPersistence().findByStatut(statut, start, end);
	}

	/**
	 * Returns an ordered range of all the visites where statut = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param statut the statut
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visites
	 */
	public static List<Visite> findByStatut(
		String statut, int start, int end,
		OrderByComparator<Visite> orderByComparator) {

		return getPersistence().findByStatut(
			statut, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the visites where statut = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param statut the statut
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visites
	 */
	public static List<Visite> findByStatut(
		String statut, int start, int end,
		OrderByComparator<Visite> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByStatut(
			statut, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first visite in the ordered set where statut = &#63;.
	 *
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visite
	 * @throws NoSuchVisiteException if a matching visite could not be found
	 */
	public static Visite findByStatut_First(
			String statut, OrderByComparator<Visite> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchVisiteException {

		return getPersistence().findByStatut_First(statut, orderByComparator);
	}

	/**
	 * Returns the first visite in the ordered set where statut = &#63;.
	 *
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visite, or <code>null</code> if a matching visite could not be found
	 */
	public static Visite fetchByStatut_First(
		String statut, OrderByComparator<Visite> orderByComparator) {

		return getPersistence().fetchByStatut_First(statut, orderByComparator);
	}

	/**
	 * Returns the last visite in the ordered set where statut = &#63;.
	 *
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visite
	 * @throws NoSuchVisiteException if a matching visite could not be found
	 */
	public static Visite findByStatut_Last(
			String statut, OrderByComparator<Visite> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchVisiteException {

		return getPersistence().findByStatut_Last(statut, orderByComparator);
	}

	/**
	 * Returns the last visite in the ordered set where statut = &#63;.
	 *
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visite, or <code>null</code> if a matching visite could not be found
	 */
	public static Visite fetchByStatut_Last(
		String statut, OrderByComparator<Visite> orderByComparator) {

		return getPersistence().fetchByStatut_Last(statut, orderByComparator);
	}

	/**
	 * Returns the visites before and after the current visite in the ordered set where statut = &#63;.
	 *
	 * @param id the primary key of the current visite
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visite
	 * @throws NoSuchVisiteException if a visite with the primary key could not be found
	 */
	public static Visite[] findByStatut_PrevAndNext(
			long id, String statut, OrderByComparator<Visite> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchVisiteException {

		return getPersistence().findByStatut_PrevAndNext(
			id, statut, orderByComparator);
	}

	/**
	 * Removes all the visites where statut = &#63; from the database.
	 *
	 * @param statut the statut
	 */
	public static void removeByStatut(String statut) {
		getPersistence().removeByStatut(statut);
	}

	/**
	 * Returns the number of visites where statut = &#63;.
	 *
	 * @param statut the statut
	 * @return the number of matching visites
	 */
	public static int countByStatut(String statut) {
		return getPersistence().countByStatut(statut);
	}

	/**
	 * Returns all the visites where commercialId = &#63; and statut = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param statut the statut
	 * @return the matching visites
	 */
	public static List<Visite> findByC_S(long commercialId, String statut) {
		return getPersistence().findByC_S(commercialId, statut);
	}

	/**
	 * Returns a range of all the visites where commercialId = &#63; and statut = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param statut the statut
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @return the range of matching visites
	 */
	public static List<Visite> findByC_S(
		long commercialId, String statut, int start, int end) {

		return getPersistence().findByC_S(commercialId, statut, start, end);
	}

	/**
	 * Returns an ordered range of all the visites where commercialId = &#63; and statut = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param statut the statut
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visites
	 */
	public static List<Visite> findByC_S(
		long commercialId, String statut, int start, int end,
		OrderByComparator<Visite> orderByComparator) {

		return getPersistence().findByC_S(
			commercialId, statut, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the visites where commercialId = &#63; and statut = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param statut the statut
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visites
	 */
	public static List<Visite> findByC_S(
		long commercialId, String statut, int start, int end,
		OrderByComparator<Visite> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByC_S(
			commercialId, statut, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first visite in the ordered set where commercialId = &#63; and statut = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visite
	 * @throws NoSuchVisiteException if a matching visite could not be found
	 */
	public static Visite findByC_S_First(
			long commercialId, String statut,
			OrderByComparator<Visite> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchVisiteException {

		return getPersistence().findByC_S_First(
			commercialId, statut, orderByComparator);
	}

	/**
	 * Returns the first visite in the ordered set where commercialId = &#63; and statut = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visite, or <code>null</code> if a matching visite could not be found
	 */
	public static Visite fetchByC_S_First(
		long commercialId, String statut,
		OrderByComparator<Visite> orderByComparator) {

		return getPersistence().fetchByC_S_First(
			commercialId, statut, orderByComparator);
	}

	/**
	 * Returns the last visite in the ordered set where commercialId = &#63; and statut = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visite
	 * @throws NoSuchVisiteException if a matching visite could not be found
	 */
	public static Visite findByC_S_Last(
			long commercialId, String statut,
			OrderByComparator<Visite> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchVisiteException {

		return getPersistence().findByC_S_Last(
			commercialId, statut, orderByComparator);
	}

	/**
	 * Returns the last visite in the ordered set where commercialId = &#63; and statut = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visite, or <code>null</code> if a matching visite could not be found
	 */
	public static Visite fetchByC_S_Last(
		long commercialId, String statut,
		OrderByComparator<Visite> orderByComparator) {

		return getPersistence().fetchByC_S_Last(
			commercialId, statut, orderByComparator);
	}

	/**
	 * Returns the visites before and after the current visite in the ordered set where commercialId = &#63; and statut = &#63;.
	 *
	 * @param id the primary key of the current visite
	 * @param commercialId the commercial ID
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visite
	 * @throws NoSuchVisiteException if a visite with the primary key could not be found
	 */
	public static Visite[] findByC_S_PrevAndNext(
			long id, long commercialId, String statut,
			OrderByComparator<Visite> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchVisiteException {

		return getPersistence().findByC_S_PrevAndNext(
			id, commercialId, statut, orderByComparator);
	}

	/**
	 * Removes all the visites where commercialId = &#63; and statut = &#63; from the database.
	 *
	 * @param commercialId the commercial ID
	 * @param statut the statut
	 */
	public static void removeByC_S(long commercialId, String statut) {
		getPersistence().removeByC_S(commercialId, statut);
	}

	/**
	 * Returns the number of visites where commercialId = &#63; and statut = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param statut the statut
	 * @return the number of matching visites
	 */
	public static int countByC_S(long commercialId, String statut) {
		return getPersistence().countByC_S(commercialId, statut);
	}

	/**
	 * Returns all the visites where commercialId = &#63; and dateVisite &ge; &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param dateVisite the date visite
	 * @return the matching visites
	 */
	public static List<Visite> findByC_D(long commercialId, Date dateVisite) {
		return getPersistence().findByC_D(commercialId, dateVisite);
	}

	/**
	 * Returns a range of all the visites where commercialId = &#63; and dateVisite &ge; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param dateVisite the date visite
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @return the range of matching visites
	 */
	public static List<Visite> findByC_D(
		long commercialId, Date dateVisite, int start, int end) {

		return getPersistence().findByC_D(commercialId, dateVisite, start, end);
	}

	/**
	 * Returns an ordered range of all the visites where commercialId = &#63; and dateVisite &ge; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param dateVisite the date visite
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visites
	 */
	public static List<Visite> findByC_D(
		long commercialId, Date dateVisite, int start, int end,
		OrderByComparator<Visite> orderByComparator) {

		return getPersistence().findByC_D(
			commercialId, dateVisite, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the visites where commercialId = &#63; and dateVisite &ge; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param dateVisite the date visite
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visites
	 */
	public static List<Visite> findByC_D(
		long commercialId, Date dateVisite, int start, int end,
		OrderByComparator<Visite> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByC_D(
			commercialId, dateVisite, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first visite in the ordered set where commercialId = &#63; and dateVisite &ge; &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param dateVisite the date visite
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visite
	 * @throws NoSuchVisiteException if a matching visite could not be found
	 */
	public static Visite findByC_D_First(
			long commercialId, Date dateVisite,
			OrderByComparator<Visite> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchVisiteException {

		return getPersistence().findByC_D_First(
			commercialId, dateVisite, orderByComparator);
	}

	/**
	 * Returns the first visite in the ordered set where commercialId = &#63; and dateVisite &ge; &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param dateVisite the date visite
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visite, or <code>null</code> if a matching visite could not be found
	 */
	public static Visite fetchByC_D_First(
		long commercialId, Date dateVisite,
		OrderByComparator<Visite> orderByComparator) {

		return getPersistence().fetchByC_D_First(
			commercialId, dateVisite, orderByComparator);
	}

	/**
	 * Returns the last visite in the ordered set where commercialId = &#63; and dateVisite &ge; &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param dateVisite the date visite
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visite
	 * @throws NoSuchVisiteException if a matching visite could not be found
	 */
	public static Visite findByC_D_Last(
			long commercialId, Date dateVisite,
			OrderByComparator<Visite> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchVisiteException {

		return getPersistence().findByC_D_Last(
			commercialId, dateVisite, orderByComparator);
	}

	/**
	 * Returns the last visite in the ordered set where commercialId = &#63; and dateVisite &ge; &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param dateVisite the date visite
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visite, or <code>null</code> if a matching visite could not be found
	 */
	public static Visite fetchByC_D_Last(
		long commercialId, Date dateVisite,
		OrderByComparator<Visite> orderByComparator) {

		return getPersistence().fetchByC_D_Last(
			commercialId, dateVisite, orderByComparator);
	}

	/**
	 * Returns the visites before and after the current visite in the ordered set where commercialId = &#63; and dateVisite &ge; &#63;.
	 *
	 * @param id the primary key of the current visite
	 * @param commercialId the commercial ID
	 * @param dateVisite the date visite
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visite
	 * @throws NoSuchVisiteException if a visite with the primary key could not be found
	 */
	public static Visite[] findByC_D_PrevAndNext(
			long id, long commercialId, Date dateVisite,
			OrderByComparator<Visite> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchVisiteException {

		return getPersistence().findByC_D_PrevAndNext(
			id, commercialId, dateVisite, orderByComparator);
	}

	/**
	 * Removes all the visites where commercialId = &#63; and dateVisite &ge; &#63; from the database.
	 *
	 * @param commercialId the commercial ID
	 * @param dateVisite the date visite
	 */
	public static void removeByC_D(long commercialId, Date dateVisite) {
		getPersistence().removeByC_D(commercialId, dateVisite);
	}

	/**
	 * Returns the number of visites where commercialId = &#63; and dateVisite &ge; &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param dateVisite the date visite
	 * @return the number of matching visites
	 */
	public static int countByC_D(long commercialId, Date dateVisite) {
		return getPersistence().countByC_D(commercialId, dateVisite);
	}

	/**
	 * Caches the visite in the entity cache if it is enabled.
	 *
	 * @param visite the visite
	 */
	public static void cacheResult(Visite visite) {
		getPersistence().cacheResult(visite);
	}

	/**
	 * Caches the visites in the entity cache if it is enabled.
	 *
	 * @param visites the visites
	 */
	public static void cacheResult(List<Visite> visites) {
		getPersistence().cacheResult(visites);
	}

	/**
	 * Creates a new visite with the primary key. Does not add the visite to the database.
	 *
	 * @param id the primary key for the new visite
	 * @return the new visite
	 */
	public static Visite create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the visite with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the visite
	 * @return the visite that was removed
	 * @throws NoSuchVisiteException if a visite with the primary key could not be found
	 */
	public static Visite remove(long id)
		throws com.df.lonis.ventesservice.exception.NoSuchVisiteException {

		return getPersistence().remove(id);
	}

	public static Visite updateImpl(Visite visite) {
		return getPersistence().updateImpl(visite);
	}

	/**
	 * Returns the visite with the primary key or throws a <code>NoSuchVisiteException</code> if it could not be found.
	 *
	 * @param id the primary key of the visite
	 * @return the visite
	 * @throws NoSuchVisiteException if a visite with the primary key could not be found
	 */
	public static Visite findByPrimaryKey(long id)
		throws com.df.lonis.ventesservice.exception.NoSuchVisiteException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the visite with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the visite
	 * @return the visite, or <code>null</code> if a visite with the primary key could not be found
	 */
	public static Visite fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the visites.
	 *
	 * @return the visites
	 */
	public static List<Visite> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the visites.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @return the range of visites
	 */
	public static List<Visite> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the visites.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of visites
	 */
	public static List<Visite> findAll(
		int start, int end, OrderByComparator<Visite> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the visites.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of visites
	 */
	public static List<Visite> findAll(
		int start, int end, OrderByComparator<Visite> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the visites from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of visites.
	 *
	 * @return the number of visites
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static VisitePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(VisitePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile VisitePersistence _persistence;

}