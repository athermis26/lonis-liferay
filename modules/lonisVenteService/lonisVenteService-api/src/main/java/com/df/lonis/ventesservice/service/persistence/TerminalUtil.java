/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence;

import com.df.lonis.ventesservice.model.Terminal;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the terminal service. This utility wraps <code>com.df.lonis.ventesservice.service.persistence.impl.TerminalPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TerminalPersistence
 * @generated
 */
public class TerminalUtil {

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
	public static void clearCache(Terminal terminal) {
		getPersistence().clearCache(terminal);
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
	public static Map<Serializable, Terminal> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Terminal> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Terminal> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Terminal> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Terminal> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Terminal update(Terminal terminal) {
		return getPersistence().update(terminal);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Terminal update(
		Terminal terminal, ServiceContext serviceContext) {

		return getPersistence().update(terminal, serviceContext);
	}

	/**
	 * Returns all the terminals where concessionnaireProduitCode = &#63;.
	 *
	 * @param concessionnaireProduitCode the concessionnaire produit code
	 * @return the matching terminals
	 */
	public static List<Terminal> findByConcessionnaireProduitCode(
		String concessionnaireProduitCode) {

		return getPersistence().findByConcessionnaireProduitCode(
			concessionnaireProduitCode);
	}

	/**
	 * Returns a range of all the terminals where concessionnaireProduitCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TerminalModelImpl</code>.
	 * </p>
	 *
	 * @param concessionnaireProduitCode the concessionnaire produit code
	 * @param start the lower bound of the range of terminals
	 * @param end the upper bound of the range of terminals (not inclusive)
	 * @return the range of matching terminals
	 */
	public static List<Terminal> findByConcessionnaireProduitCode(
		String concessionnaireProduitCode, int start, int end) {

		return getPersistence().findByConcessionnaireProduitCode(
			concessionnaireProduitCode, start, end);
	}

	/**
	 * Returns an ordered range of all the terminals where concessionnaireProduitCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TerminalModelImpl</code>.
	 * </p>
	 *
	 * @param concessionnaireProduitCode the concessionnaire produit code
	 * @param start the lower bound of the range of terminals
	 * @param end the upper bound of the range of terminals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terminals
	 */
	public static List<Terminal> findByConcessionnaireProduitCode(
		String concessionnaireProduitCode, int start, int end,
		OrderByComparator<Terminal> orderByComparator) {

		return getPersistence().findByConcessionnaireProduitCode(
			concessionnaireProduitCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the terminals where concessionnaireProduitCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TerminalModelImpl</code>.
	 * </p>
	 *
	 * @param concessionnaireProduitCode the concessionnaire produit code
	 * @param start the lower bound of the range of terminals
	 * @param end the upper bound of the range of terminals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching terminals
	 */
	public static List<Terminal> findByConcessionnaireProduitCode(
		String concessionnaireProduitCode, int start, int end,
		OrderByComparator<Terminal> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByConcessionnaireProduitCode(
			concessionnaireProduitCode, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first terminal in the ordered set where concessionnaireProduitCode = &#63;.
	 *
	 * @param concessionnaireProduitCode the concessionnaire produit code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching terminal
	 * @throws NoSuchTerminalException if a matching terminal could not be found
	 */
	public static Terminal findByConcessionnaireProduitCode_First(
			String concessionnaireProduitCode,
			OrderByComparator<Terminal> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchTerminalException {

		return getPersistence().findByConcessionnaireProduitCode_First(
			concessionnaireProduitCode, orderByComparator);
	}

	/**
	 * Returns the first terminal in the ordered set where concessionnaireProduitCode = &#63;.
	 *
	 * @param concessionnaireProduitCode the concessionnaire produit code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching terminal, or <code>null</code> if a matching terminal could not be found
	 */
	public static Terminal fetchByConcessionnaireProduitCode_First(
		String concessionnaireProduitCode,
		OrderByComparator<Terminal> orderByComparator) {

		return getPersistence().fetchByConcessionnaireProduitCode_First(
			concessionnaireProduitCode, orderByComparator);
	}

	/**
	 * Returns the last terminal in the ordered set where concessionnaireProduitCode = &#63;.
	 *
	 * @param concessionnaireProduitCode the concessionnaire produit code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching terminal
	 * @throws NoSuchTerminalException if a matching terminal could not be found
	 */
	public static Terminal findByConcessionnaireProduitCode_Last(
			String concessionnaireProduitCode,
			OrderByComparator<Terminal> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchTerminalException {

		return getPersistence().findByConcessionnaireProduitCode_Last(
			concessionnaireProduitCode, orderByComparator);
	}

	/**
	 * Returns the last terminal in the ordered set where concessionnaireProduitCode = &#63;.
	 *
	 * @param concessionnaireProduitCode the concessionnaire produit code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching terminal, or <code>null</code> if a matching terminal could not be found
	 */
	public static Terminal fetchByConcessionnaireProduitCode_Last(
		String concessionnaireProduitCode,
		OrderByComparator<Terminal> orderByComparator) {

		return getPersistence().fetchByConcessionnaireProduitCode_Last(
			concessionnaireProduitCode, orderByComparator);
	}

	/**
	 * Returns the terminals before and after the current terminal in the ordered set where concessionnaireProduitCode = &#63;.
	 *
	 * @param id the primary key of the current terminal
	 * @param concessionnaireProduitCode the concessionnaire produit code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next terminal
	 * @throws NoSuchTerminalException if a terminal with the primary key could not be found
	 */
	public static Terminal[] findByConcessionnaireProduitCode_PrevAndNext(
			long id, String concessionnaireProduitCode,
			OrderByComparator<Terminal> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchTerminalException {

		return getPersistence().findByConcessionnaireProduitCode_PrevAndNext(
			id, concessionnaireProduitCode, orderByComparator);
	}

	/**
	 * Removes all the terminals where concessionnaireProduitCode = &#63; from the database.
	 *
	 * @param concessionnaireProduitCode the concessionnaire produit code
	 */
	public static void removeByConcessionnaireProduitCode(
		String concessionnaireProduitCode) {

		getPersistence().removeByConcessionnaireProduitCode(
			concessionnaireProduitCode);
	}

	/**
	 * Returns the number of terminals where concessionnaireProduitCode = &#63;.
	 *
	 * @param concessionnaireProduitCode the concessionnaire produit code
	 * @return the number of matching terminals
	 */
	public static int countByConcessionnaireProduitCode(
		String concessionnaireProduitCode) {

		return getPersistence().countByConcessionnaireProduitCode(
			concessionnaireProduitCode);
	}

	/**
	 * Returns all the terminals where concessionnaireId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @return the matching terminals
	 */
	public static List<Terminal> findByConcessionnaireId(
		long concessionnaireId) {

		return getPersistence().findByConcessionnaireId(concessionnaireId);
	}

	/**
	 * Returns a range of all the terminals where concessionnaireId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TerminalModelImpl</code>.
	 * </p>
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param start the lower bound of the range of terminals
	 * @param end the upper bound of the range of terminals (not inclusive)
	 * @return the range of matching terminals
	 */
	public static List<Terminal> findByConcessionnaireId(
		long concessionnaireId, int start, int end) {

		return getPersistence().findByConcessionnaireId(
			concessionnaireId, start, end);
	}

	/**
	 * Returns an ordered range of all the terminals where concessionnaireId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TerminalModelImpl</code>.
	 * </p>
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param start the lower bound of the range of terminals
	 * @param end the upper bound of the range of terminals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terminals
	 */
	public static List<Terminal> findByConcessionnaireId(
		long concessionnaireId, int start, int end,
		OrderByComparator<Terminal> orderByComparator) {

		return getPersistence().findByConcessionnaireId(
			concessionnaireId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the terminals where concessionnaireId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TerminalModelImpl</code>.
	 * </p>
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param start the lower bound of the range of terminals
	 * @param end the upper bound of the range of terminals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching terminals
	 */
	public static List<Terminal> findByConcessionnaireId(
		long concessionnaireId, int start, int end,
		OrderByComparator<Terminal> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByConcessionnaireId(
			concessionnaireId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first terminal in the ordered set where concessionnaireId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching terminal
	 * @throws NoSuchTerminalException if a matching terminal could not be found
	 */
	public static Terminal findByConcessionnaireId_First(
			long concessionnaireId,
			OrderByComparator<Terminal> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchTerminalException {

		return getPersistence().findByConcessionnaireId_First(
			concessionnaireId, orderByComparator);
	}

	/**
	 * Returns the first terminal in the ordered set where concessionnaireId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching terminal, or <code>null</code> if a matching terminal could not be found
	 */
	public static Terminal fetchByConcessionnaireId_First(
		long concessionnaireId, OrderByComparator<Terminal> orderByComparator) {

		return getPersistence().fetchByConcessionnaireId_First(
			concessionnaireId, orderByComparator);
	}

	/**
	 * Returns the last terminal in the ordered set where concessionnaireId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching terminal
	 * @throws NoSuchTerminalException if a matching terminal could not be found
	 */
	public static Terminal findByConcessionnaireId_Last(
			long concessionnaireId,
			OrderByComparator<Terminal> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchTerminalException {

		return getPersistence().findByConcessionnaireId_Last(
			concessionnaireId, orderByComparator);
	}

	/**
	 * Returns the last terminal in the ordered set where concessionnaireId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching terminal, or <code>null</code> if a matching terminal could not be found
	 */
	public static Terminal fetchByConcessionnaireId_Last(
		long concessionnaireId, OrderByComparator<Terminal> orderByComparator) {

		return getPersistence().fetchByConcessionnaireId_Last(
			concessionnaireId, orderByComparator);
	}

	/**
	 * Returns the terminals before and after the current terminal in the ordered set where concessionnaireId = &#63;.
	 *
	 * @param id the primary key of the current terminal
	 * @param concessionnaireId the concessionnaire ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next terminal
	 * @throws NoSuchTerminalException if a terminal with the primary key could not be found
	 */
	public static Terminal[] findByConcessionnaireId_PrevAndNext(
			long id, long concessionnaireId,
			OrderByComparator<Terminal> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchTerminalException {

		return getPersistence().findByConcessionnaireId_PrevAndNext(
			id, concessionnaireId, orderByComparator);
	}

	/**
	 * Removes all the terminals where concessionnaireId = &#63; from the database.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 */
	public static void removeByConcessionnaireId(long concessionnaireId) {
		getPersistence().removeByConcessionnaireId(concessionnaireId);
	}

	/**
	 * Returns the number of terminals where concessionnaireId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @return the number of matching terminals
	 */
	public static int countByConcessionnaireId(long concessionnaireId) {
		return getPersistence().countByConcessionnaireId(concessionnaireId);
	}

	/**
	 * Returns all the terminals where siteId = &#63;.
	 *
	 * @param siteId the site ID
	 * @return the matching terminals
	 */
	public static List<Terminal> findBySiteId(long siteId) {
		return getPersistence().findBySiteId(siteId);
	}

	/**
	 * Returns a range of all the terminals where siteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TerminalModelImpl</code>.
	 * </p>
	 *
	 * @param siteId the site ID
	 * @param start the lower bound of the range of terminals
	 * @param end the upper bound of the range of terminals (not inclusive)
	 * @return the range of matching terminals
	 */
	public static List<Terminal> findBySiteId(long siteId, int start, int end) {
		return getPersistence().findBySiteId(siteId, start, end);
	}

	/**
	 * Returns an ordered range of all the terminals where siteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TerminalModelImpl</code>.
	 * </p>
	 *
	 * @param siteId the site ID
	 * @param start the lower bound of the range of terminals
	 * @param end the upper bound of the range of terminals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terminals
	 */
	public static List<Terminal> findBySiteId(
		long siteId, int start, int end,
		OrderByComparator<Terminal> orderByComparator) {

		return getPersistence().findBySiteId(
			siteId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the terminals where siteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TerminalModelImpl</code>.
	 * </p>
	 *
	 * @param siteId the site ID
	 * @param start the lower bound of the range of terminals
	 * @param end the upper bound of the range of terminals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching terminals
	 */
	public static List<Terminal> findBySiteId(
		long siteId, int start, int end,
		OrderByComparator<Terminal> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBySiteId(
			siteId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first terminal in the ordered set where siteId = &#63;.
	 *
	 * @param siteId the site ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching terminal
	 * @throws NoSuchTerminalException if a matching terminal could not be found
	 */
	public static Terminal findBySiteId_First(
			long siteId, OrderByComparator<Terminal> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchTerminalException {

		return getPersistence().findBySiteId_First(siteId, orderByComparator);
	}

	/**
	 * Returns the first terminal in the ordered set where siteId = &#63;.
	 *
	 * @param siteId the site ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching terminal, or <code>null</code> if a matching terminal could not be found
	 */
	public static Terminal fetchBySiteId_First(
		long siteId, OrderByComparator<Terminal> orderByComparator) {

		return getPersistence().fetchBySiteId_First(siteId, orderByComparator);
	}

	/**
	 * Returns the last terminal in the ordered set where siteId = &#63;.
	 *
	 * @param siteId the site ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching terminal
	 * @throws NoSuchTerminalException if a matching terminal could not be found
	 */
	public static Terminal findBySiteId_Last(
			long siteId, OrderByComparator<Terminal> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchTerminalException {

		return getPersistence().findBySiteId_Last(siteId, orderByComparator);
	}

	/**
	 * Returns the last terminal in the ordered set where siteId = &#63;.
	 *
	 * @param siteId the site ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching terminal, or <code>null</code> if a matching terminal could not be found
	 */
	public static Terminal fetchBySiteId_Last(
		long siteId, OrderByComparator<Terminal> orderByComparator) {

		return getPersistence().fetchBySiteId_Last(siteId, orderByComparator);
	}

	/**
	 * Returns the terminals before and after the current terminal in the ordered set where siteId = &#63;.
	 *
	 * @param id the primary key of the current terminal
	 * @param siteId the site ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next terminal
	 * @throws NoSuchTerminalException if a terminal with the primary key could not be found
	 */
	public static Terminal[] findBySiteId_PrevAndNext(
			long id, long siteId, OrderByComparator<Terminal> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchTerminalException {

		return getPersistence().findBySiteId_PrevAndNext(
			id, siteId, orderByComparator);
	}

	/**
	 * Removes all the terminals where siteId = &#63; from the database.
	 *
	 * @param siteId the site ID
	 */
	public static void removeBySiteId(long siteId) {
		getPersistence().removeBySiteId(siteId);
	}

	/**
	 * Returns the number of terminals where siteId = &#63;.
	 *
	 * @param siteId the site ID
	 * @return the number of matching terminals
	 */
	public static int countBySiteId(long siteId) {
		return getPersistence().countBySiteId(siteId);
	}

	/**
	 * Returns all the terminals where statutValidation = &#63;.
	 *
	 * @param statutValidation the statut validation
	 * @return the matching terminals
	 */
	public static List<Terminal> findByStatutValidation(
		String statutValidation) {

		return getPersistence().findByStatutValidation(statutValidation);
	}

	/**
	 * Returns a range of all the terminals where statutValidation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TerminalModelImpl</code>.
	 * </p>
	 *
	 * @param statutValidation the statut validation
	 * @param start the lower bound of the range of terminals
	 * @param end the upper bound of the range of terminals (not inclusive)
	 * @return the range of matching terminals
	 */
	public static List<Terminal> findByStatutValidation(
		String statutValidation, int start, int end) {

		return getPersistence().findByStatutValidation(
			statutValidation, start, end);
	}

	/**
	 * Returns an ordered range of all the terminals where statutValidation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TerminalModelImpl</code>.
	 * </p>
	 *
	 * @param statutValidation the statut validation
	 * @param start the lower bound of the range of terminals
	 * @param end the upper bound of the range of terminals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terminals
	 */
	public static List<Terminal> findByStatutValidation(
		String statutValidation, int start, int end,
		OrderByComparator<Terminal> orderByComparator) {

		return getPersistence().findByStatutValidation(
			statutValidation, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the terminals where statutValidation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TerminalModelImpl</code>.
	 * </p>
	 *
	 * @param statutValidation the statut validation
	 * @param start the lower bound of the range of terminals
	 * @param end the upper bound of the range of terminals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching terminals
	 */
	public static List<Terminal> findByStatutValidation(
		String statutValidation, int start, int end,
		OrderByComparator<Terminal> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByStatutValidation(
			statutValidation, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first terminal in the ordered set where statutValidation = &#63;.
	 *
	 * @param statutValidation the statut validation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching terminal
	 * @throws NoSuchTerminalException if a matching terminal could not be found
	 */
	public static Terminal findByStatutValidation_First(
			String statutValidation,
			OrderByComparator<Terminal> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchTerminalException {

		return getPersistence().findByStatutValidation_First(
			statutValidation, orderByComparator);
	}

	/**
	 * Returns the first terminal in the ordered set where statutValidation = &#63;.
	 *
	 * @param statutValidation the statut validation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching terminal, or <code>null</code> if a matching terminal could not be found
	 */
	public static Terminal fetchByStatutValidation_First(
		String statutValidation,
		OrderByComparator<Terminal> orderByComparator) {

		return getPersistence().fetchByStatutValidation_First(
			statutValidation, orderByComparator);
	}

	/**
	 * Returns the last terminal in the ordered set where statutValidation = &#63;.
	 *
	 * @param statutValidation the statut validation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching terminal
	 * @throws NoSuchTerminalException if a matching terminal could not be found
	 */
	public static Terminal findByStatutValidation_Last(
			String statutValidation,
			OrderByComparator<Terminal> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchTerminalException {

		return getPersistence().findByStatutValidation_Last(
			statutValidation, orderByComparator);
	}

	/**
	 * Returns the last terminal in the ordered set where statutValidation = &#63;.
	 *
	 * @param statutValidation the statut validation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching terminal, or <code>null</code> if a matching terminal could not be found
	 */
	public static Terminal fetchByStatutValidation_Last(
		String statutValidation,
		OrderByComparator<Terminal> orderByComparator) {

		return getPersistence().fetchByStatutValidation_Last(
			statutValidation, orderByComparator);
	}

	/**
	 * Returns the terminals before and after the current terminal in the ordered set where statutValidation = &#63;.
	 *
	 * @param id the primary key of the current terminal
	 * @param statutValidation the statut validation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next terminal
	 * @throws NoSuchTerminalException if a terminal with the primary key could not be found
	 */
	public static Terminal[] findByStatutValidation_PrevAndNext(
			long id, String statutValidation,
			OrderByComparator<Terminal> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchTerminalException {

		return getPersistence().findByStatutValidation_PrevAndNext(
			id, statutValidation, orderByComparator);
	}

	/**
	 * Removes all the terminals where statutValidation = &#63; from the database.
	 *
	 * @param statutValidation the statut validation
	 */
	public static void removeByStatutValidation(String statutValidation) {
		getPersistence().removeByStatutValidation(statutValidation);
	}

	/**
	 * Returns the number of terminals where statutValidation = &#63;.
	 *
	 * @param statutValidation the statut validation
	 * @return the number of matching terminals
	 */
	public static int countByStatutValidation(String statutValidation) {
		return getPersistence().countByStatutValidation(statutValidation);
	}

	/**
	 * Caches the terminal in the entity cache if it is enabled.
	 *
	 * @param terminal the terminal
	 */
	public static void cacheResult(Terminal terminal) {
		getPersistence().cacheResult(terminal);
	}

	/**
	 * Caches the terminals in the entity cache if it is enabled.
	 *
	 * @param terminals the terminals
	 */
	public static void cacheResult(List<Terminal> terminals) {
		getPersistence().cacheResult(terminals);
	}

	/**
	 * Creates a new terminal with the primary key. Does not add the terminal to the database.
	 *
	 * @param id the primary key for the new terminal
	 * @return the new terminal
	 */
	public static Terminal create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the terminal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the terminal
	 * @return the terminal that was removed
	 * @throws NoSuchTerminalException if a terminal with the primary key could not be found
	 */
	public static Terminal remove(long id)
		throws com.df.lonis.ventesservice.exception.NoSuchTerminalException {

		return getPersistence().remove(id);
	}

	public static Terminal updateImpl(Terminal terminal) {
		return getPersistence().updateImpl(terminal);
	}

	/**
	 * Returns the terminal with the primary key or throws a <code>NoSuchTerminalException</code> if it could not be found.
	 *
	 * @param id the primary key of the terminal
	 * @return the terminal
	 * @throws NoSuchTerminalException if a terminal with the primary key could not be found
	 */
	public static Terminal findByPrimaryKey(long id)
		throws com.df.lonis.ventesservice.exception.NoSuchTerminalException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the terminal with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the terminal
	 * @return the terminal, or <code>null</code> if a terminal with the primary key could not be found
	 */
	public static Terminal fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the terminals.
	 *
	 * @return the terminals
	 */
	public static List<Terminal> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the terminals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TerminalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of terminals
	 * @param end the upper bound of the range of terminals (not inclusive)
	 * @return the range of terminals
	 */
	public static List<Terminal> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the terminals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TerminalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of terminals
	 * @param end the upper bound of the range of terminals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of terminals
	 */
	public static List<Terminal> findAll(
		int start, int end, OrderByComparator<Terminal> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the terminals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TerminalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of terminals
	 * @param end the upper bound of the range of terminals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of terminals
	 */
	public static List<Terminal> findAll(
		int start, int end, OrderByComparator<Terminal> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the terminals from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of terminals.
	 *
	 * @return the number of terminals
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TerminalPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(TerminalPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile TerminalPersistence _persistence;

}