/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence;

import com.df.lonis.ventesservice.model.Commission;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the commission service. This utility wraps <code>com.df.lonis.ventesservice.service.persistence.impl.CommissionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CommissionPersistence
 * @generated
 */
public class CommissionUtil {

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
	public static void clearCache(Commission commission) {
		getPersistence().clearCache(commission);
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
	public static Map<Serializable, Commission> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Commission> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Commission> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Commission> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Commission> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Commission update(Commission commission) {
		return getPersistence().update(commission);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Commission update(
		Commission commission, ServiceContext serviceContext) {

		return getPersistence().update(commission, serviceContext);
	}

	/**
	 * Returns all the commissions where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @return the matching commissions
	 */
	public static List<Commission> findByTerminalId(long terminalId) {
		return getPersistence().findByTerminalId(terminalId);
	}

	/**
	 * Returns a range of all the commissions where terminalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommissionModelImpl</code>.
	 * </p>
	 *
	 * @param terminalId the terminal ID
	 * @param start the lower bound of the range of commissions
	 * @param end the upper bound of the range of commissions (not inclusive)
	 * @return the range of matching commissions
	 */
	public static List<Commission> findByTerminalId(
		long terminalId, int start, int end) {

		return getPersistence().findByTerminalId(terminalId, start, end);
	}

	/**
	 * Returns an ordered range of all the commissions where terminalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommissionModelImpl</code>.
	 * </p>
	 *
	 * @param terminalId the terminal ID
	 * @param start the lower bound of the range of commissions
	 * @param end the upper bound of the range of commissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commissions
	 */
	public static List<Commission> findByTerminalId(
		long terminalId, int start, int end,
		OrderByComparator<Commission> orderByComparator) {

		return getPersistence().findByTerminalId(
			terminalId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the commissions where terminalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommissionModelImpl</code>.
	 * </p>
	 *
	 * @param terminalId the terminal ID
	 * @param start the lower bound of the range of commissions
	 * @param end the upper bound of the range of commissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commissions
	 */
	public static List<Commission> findByTerminalId(
		long terminalId, int start, int end,
		OrderByComparator<Commission> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTerminalId(
			terminalId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first commission in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commission
	 * @throws NoSuchCommissionException if a matching commission could not be found
	 */
	public static Commission findByTerminalId_First(
			long terminalId, OrderByComparator<Commission> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchCommissionException {

		return getPersistence().findByTerminalId_First(
			terminalId, orderByComparator);
	}

	/**
	 * Returns the first commission in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commission, or <code>null</code> if a matching commission could not be found
	 */
	public static Commission fetchByTerminalId_First(
		long terminalId, OrderByComparator<Commission> orderByComparator) {

		return getPersistence().fetchByTerminalId_First(
			terminalId, orderByComparator);
	}

	/**
	 * Returns the last commission in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commission
	 * @throws NoSuchCommissionException if a matching commission could not be found
	 */
	public static Commission findByTerminalId_Last(
			long terminalId, OrderByComparator<Commission> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchCommissionException {

		return getPersistence().findByTerminalId_Last(
			terminalId, orderByComparator);
	}

	/**
	 * Returns the last commission in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commission, or <code>null</code> if a matching commission could not be found
	 */
	public static Commission fetchByTerminalId_Last(
		long terminalId, OrderByComparator<Commission> orderByComparator) {

		return getPersistence().fetchByTerminalId_Last(
			terminalId, orderByComparator);
	}

	/**
	 * Returns the commissions before and after the current commission in the ordered set where terminalId = &#63;.
	 *
	 * @param id the primary key of the current commission
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commission
	 * @throws NoSuchCommissionException if a commission with the primary key could not be found
	 */
	public static Commission[] findByTerminalId_PrevAndNext(
			long id, long terminalId,
			OrderByComparator<Commission> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchCommissionException {

		return getPersistence().findByTerminalId_PrevAndNext(
			id, terminalId, orderByComparator);
	}

	/**
	 * Removes all the commissions where terminalId = &#63; from the database.
	 *
	 * @param terminalId the terminal ID
	 */
	public static void removeByTerminalId(long terminalId) {
		getPersistence().removeByTerminalId(terminalId);
	}

	/**
	 * Returns the number of commissions where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @return the number of matching commissions
	 */
	public static int countByTerminalId(long terminalId) {
		return getPersistence().countByTerminalId(terminalId);
	}

	/**
	 * Returns all the commissions where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching commissions
	 */
	public static List<Commission> findByStatus(String status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the commissions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommissionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of commissions
	 * @param end the upper bound of the range of commissions (not inclusive)
	 * @return the range of matching commissions
	 */
	public static List<Commission> findByStatus(
		String status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the commissions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommissionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of commissions
	 * @param end the upper bound of the range of commissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commissions
	 */
	public static List<Commission> findByStatus(
		String status, int start, int end,
		OrderByComparator<Commission> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the commissions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommissionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of commissions
	 * @param end the upper bound of the range of commissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commissions
	 */
	public static List<Commission> findByStatus(
		String status, int start, int end,
		OrderByComparator<Commission> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first commission in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commission
	 * @throws NoSuchCommissionException if a matching commission could not be found
	 */
	public static Commission findByStatus_First(
			String status, OrderByComparator<Commission> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchCommissionException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first commission in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commission, or <code>null</code> if a matching commission could not be found
	 */
	public static Commission fetchByStatus_First(
		String status, OrderByComparator<Commission> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last commission in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commission
	 * @throws NoSuchCommissionException if a matching commission could not be found
	 */
	public static Commission findByStatus_Last(
			String status, OrderByComparator<Commission> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchCommissionException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last commission in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commission, or <code>null</code> if a matching commission could not be found
	 */
	public static Commission fetchByStatus_Last(
		String status, OrderByComparator<Commission> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the commissions before and after the current commission in the ordered set where status = &#63;.
	 *
	 * @param id the primary key of the current commission
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commission
	 * @throws NoSuchCommissionException if a commission with the primary key could not be found
	 */
	public static Commission[] findByStatus_PrevAndNext(
			long id, String status,
			OrderByComparator<Commission> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchCommissionException {

		return getPersistence().findByStatus_PrevAndNext(
			id, status, orderByComparator);
	}

	/**
	 * Removes all the commissions where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(String status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of commissions where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching commissions
	 */
	public static int countByStatus(String status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Caches the commission in the entity cache if it is enabled.
	 *
	 * @param commission the commission
	 */
	public static void cacheResult(Commission commission) {
		getPersistence().cacheResult(commission);
	}

	/**
	 * Caches the commissions in the entity cache if it is enabled.
	 *
	 * @param commissions the commissions
	 */
	public static void cacheResult(List<Commission> commissions) {
		getPersistence().cacheResult(commissions);
	}

	/**
	 * Creates a new commission with the primary key. Does not add the commission to the database.
	 *
	 * @param id the primary key for the new commission
	 * @return the new commission
	 */
	public static Commission create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the commission with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the commission
	 * @return the commission that was removed
	 * @throws NoSuchCommissionException if a commission with the primary key could not be found
	 */
	public static Commission remove(long id)
		throws com.df.lonis.ventesservice.exception.NoSuchCommissionException {

		return getPersistence().remove(id);
	}

	public static Commission updateImpl(Commission commission) {
		return getPersistence().updateImpl(commission);
	}

	/**
	 * Returns the commission with the primary key or throws a <code>NoSuchCommissionException</code> if it could not be found.
	 *
	 * @param id the primary key of the commission
	 * @return the commission
	 * @throws NoSuchCommissionException if a commission with the primary key could not be found
	 */
	public static Commission findByPrimaryKey(long id)
		throws com.df.lonis.ventesservice.exception.NoSuchCommissionException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the commission with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the commission
	 * @return the commission, or <code>null</code> if a commission with the primary key could not be found
	 */
	public static Commission fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the commissions.
	 *
	 * @return the commissions
	 */
	public static List<Commission> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the commissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommissionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commissions
	 * @param end the upper bound of the range of commissions (not inclusive)
	 * @return the range of commissions
	 */
	public static List<Commission> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the commissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommissionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commissions
	 * @param end the upper bound of the range of commissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of commissions
	 */
	public static List<Commission> findAll(
		int start, int end, OrderByComparator<Commission> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the commissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommissionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commissions
	 * @param end the upper bound of the range of commissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of commissions
	 */
	public static List<Commission> findAll(
		int start, int end, OrderByComparator<Commission> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the commissions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of commissions.
	 *
	 * @return the number of commissions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CommissionPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(CommissionPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile CommissionPersistence _persistence;

}