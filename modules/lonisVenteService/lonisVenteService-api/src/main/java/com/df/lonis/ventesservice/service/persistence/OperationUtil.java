/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence;

import com.df.lonis.ventesservice.model.Operation;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the operation service. This utility wraps <code>com.df.lonis.ventesservice.service.persistence.impl.OperationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OperationPersistence
 * @generated
 */
public class OperationUtil {

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
	public static void clearCache(Operation operation) {
		getPersistence().clearCache(operation);
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
	public static Map<Serializable, Operation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Operation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Operation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Operation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Operation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Operation update(Operation operation) {
		return getPersistence().update(operation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Operation update(
		Operation operation, ServiceContext serviceContext) {

		return getPersistence().update(operation, serviceContext);
	}

	/**
	 * Returns all the operations where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @return the matching operations
	 */
	public static List<Operation> findByTerminalId(long terminalId) {
		return getPersistence().findByTerminalId(terminalId);
	}

	/**
	 * Returns a range of all the operations where terminalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OperationModelImpl</code>.
	 * </p>
	 *
	 * @param terminalId the terminal ID
	 * @param start the lower bound of the range of operations
	 * @param end the upper bound of the range of operations (not inclusive)
	 * @return the range of matching operations
	 */
	public static List<Operation> findByTerminalId(
		long terminalId, int start, int end) {

		return getPersistence().findByTerminalId(terminalId, start, end);
	}

	/**
	 * Returns an ordered range of all the operations where terminalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OperationModelImpl</code>.
	 * </p>
	 *
	 * @param terminalId the terminal ID
	 * @param start the lower bound of the range of operations
	 * @param end the upper bound of the range of operations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching operations
	 */
	public static List<Operation> findByTerminalId(
		long terminalId, int start, int end,
		OrderByComparator<Operation> orderByComparator) {

		return getPersistence().findByTerminalId(
			terminalId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the operations where terminalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OperationModelImpl</code>.
	 * </p>
	 *
	 * @param terminalId the terminal ID
	 * @param start the lower bound of the range of operations
	 * @param end the upper bound of the range of operations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching operations
	 */
	public static List<Operation> findByTerminalId(
		long terminalId, int start, int end,
		OrderByComparator<Operation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTerminalId(
			terminalId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first operation in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching operation
	 * @throws NoSuchOperationException if a matching operation could not be found
	 */
	public static Operation findByTerminalId_First(
			long terminalId, OrderByComparator<Operation> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchOperationException {

		return getPersistence().findByTerminalId_First(
			terminalId, orderByComparator);
	}

	/**
	 * Returns the first operation in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching operation, or <code>null</code> if a matching operation could not be found
	 */
	public static Operation fetchByTerminalId_First(
		long terminalId, OrderByComparator<Operation> orderByComparator) {

		return getPersistence().fetchByTerminalId_First(
			terminalId, orderByComparator);
	}

	/**
	 * Returns the last operation in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching operation
	 * @throws NoSuchOperationException if a matching operation could not be found
	 */
	public static Operation findByTerminalId_Last(
			long terminalId, OrderByComparator<Operation> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchOperationException {

		return getPersistence().findByTerminalId_Last(
			terminalId, orderByComparator);
	}

	/**
	 * Returns the last operation in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching operation, or <code>null</code> if a matching operation could not be found
	 */
	public static Operation fetchByTerminalId_Last(
		long terminalId, OrderByComparator<Operation> orderByComparator) {

		return getPersistence().fetchByTerminalId_Last(
			terminalId, orderByComparator);
	}

	/**
	 * Returns the operations before and after the current operation in the ordered set where terminalId = &#63;.
	 *
	 * @param id the primary key of the current operation
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next operation
	 * @throws NoSuchOperationException if a operation with the primary key could not be found
	 */
	public static Operation[] findByTerminalId_PrevAndNext(
			long id, long terminalId,
			OrderByComparator<Operation> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchOperationException {

		return getPersistence().findByTerminalId_PrevAndNext(
			id, terminalId, orderByComparator);
	}

	/**
	 * Removes all the operations where terminalId = &#63; from the database.
	 *
	 * @param terminalId the terminal ID
	 */
	public static void removeByTerminalId(long terminalId) {
		getPersistence().removeByTerminalId(terminalId);
	}

	/**
	 * Returns the number of operations where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @return the number of matching operations
	 */
	public static int countByTerminalId(long terminalId) {
		return getPersistence().countByTerminalId(terminalId);
	}

	/**
	 * Returns the operation where reference = &#63; or throws a <code>NoSuchOperationException</code> if it could not be found.
	 *
	 * @param reference the reference
	 * @return the matching operation
	 * @throws NoSuchOperationException if a matching operation could not be found
	 */
	public static Operation findByReference(String reference)
		throws com.df.lonis.ventesservice.exception.NoSuchOperationException {

		return getPersistence().findByReference(reference);
	}

	/**
	 * Returns the operation where reference = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param reference the reference
	 * @return the matching operation, or <code>null</code> if a matching operation could not be found
	 */
	public static Operation fetchByReference(String reference) {
		return getPersistence().fetchByReference(reference);
	}

	/**
	 * Returns the operation where reference = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param reference the reference
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching operation, or <code>null</code> if a matching operation could not be found
	 */
	public static Operation fetchByReference(
		String reference, boolean useFinderCache) {

		return getPersistence().fetchByReference(reference, useFinderCache);
	}

	/**
	 * Removes the operation where reference = &#63; from the database.
	 *
	 * @param reference the reference
	 * @return the operation that was removed
	 */
	public static Operation removeByReference(String reference)
		throws com.df.lonis.ventesservice.exception.NoSuchOperationException {

		return getPersistence().removeByReference(reference);
	}

	/**
	 * Returns the number of operations where reference = &#63;.
	 *
	 * @param reference the reference
	 * @return the number of matching operations
	 */
	public static int countByReference(String reference) {
		return getPersistence().countByReference(reference);
	}

	/**
	 * Returns all the operations where statut = &#63;.
	 *
	 * @param statut the statut
	 * @return the matching operations
	 */
	public static List<Operation> findByStatut(String statut) {
		return getPersistence().findByStatut(statut);
	}

	/**
	 * Returns a range of all the operations where statut = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OperationModelImpl</code>.
	 * </p>
	 *
	 * @param statut the statut
	 * @param start the lower bound of the range of operations
	 * @param end the upper bound of the range of operations (not inclusive)
	 * @return the range of matching operations
	 */
	public static List<Operation> findByStatut(
		String statut, int start, int end) {

		return getPersistence().findByStatut(statut, start, end);
	}

	/**
	 * Returns an ordered range of all the operations where statut = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OperationModelImpl</code>.
	 * </p>
	 *
	 * @param statut the statut
	 * @param start the lower bound of the range of operations
	 * @param end the upper bound of the range of operations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching operations
	 */
	public static List<Operation> findByStatut(
		String statut, int start, int end,
		OrderByComparator<Operation> orderByComparator) {

		return getPersistence().findByStatut(
			statut, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the operations where statut = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OperationModelImpl</code>.
	 * </p>
	 *
	 * @param statut the statut
	 * @param start the lower bound of the range of operations
	 * @param end the upper bound of the range of operations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching operations
	 */
	public static List<Operation> findByStatut(
		String statut, int start, int end,
		OrderByComparator<Operation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatut(
			statut, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first operation in the ordered set where statut = &#63;.
	 *
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching operation
	 * @throws NoSuchOperationException if a matching operation could not be found
	 */
	public static Operation findByStatut_First(
			String statut, OrderByComparator<Operation> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchOperationException {

		return getPersistence().findByStatut_First(statut, orderByComparator);
	}

	/**
	 * Returns the first operation in the ordered set where statut = &#63;.
	 *
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching operation, or <code>null</code> if a matching operation could not be found
	 */
	public static Operation fetchByStatut_First(
		String statut, OrderByComparator<Operation> orderByComparator) {

		return getPersistence().fetchByStatut_First(statut, orderByComparator);
	}

	/**
	 * Returns the last operation in the ordered set where statut = &#63;.
	 *
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching operation
	 * @throws NoSuchOperationException if a matching operation could not be found
	 */
	public static Operation findByStatut_Last(
			String statut, OrderByComparator<Operation> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchOperationException {

		return getPersistence().findByStatut_Last(statut, orderByComparator);
	}

	/**
	 * Returns the last operation in the ordered set where statut = &#63;.
	 *
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching operation, or <code>null</code> if a matching operation could not be found
	 */
	public static Operation fetchByStatut_Last(
		String statut, OrderByComparator<Operation> orderByComparator) {

		return getPersistence().fetchByStatut_Last(statut, orderByComparator);
	}

	/**
	 * Returns the operations before and after the current operation in the ordered set where statut = &#63;.
	 *
	 * @param id the primary key of the current operation
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next operation
	 * @throws NoSuchOperationException if a operation with the primary key could not be found
	 */
	public static Operation[] findByStatut_PrevAndNext(
			long id, String statut,
			OrderByComparator<Operation> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchOperationException {

		return getPersistence().findByStatut_PrevAndNext(
			id, statut, orderByComparator);
	}

	/**
	 * Removes all the operations where statut = &#63; from the database.
	 *
	 * @param statut the statut
	 */
	public static void removeByStatut(String statut) {
		getPersistence().removeByStatut(statut);
	}

	/**
	 * Returns the number of operations where statut = &#63;.
	 *
	 * @param statut the statut
	 * @return the number of matching operations
	 */
	public static int countByStatut(String statut) {
		return getPersistence().countByStatut(statut);
	}

	/**
	 * Caches the operation in the entity cache if it is enabled.
	 *
	 * @param operation the operation
	 */
	public static void cacheResult(Operation operation) {
		getPersistence().cacheResult(operation);
	}

	/**
	 * Caches the operations in the entity cache if it is enabled.
	 *
	 * @param operations the operations
	 */
	public static void cacheResult(List<Operation> operations) {
		getPersistence().cacheResult(operations);
	}

	/**
	 * Creates a new operation with the primary key. Does not add the operation to the database.
	 *
	 * @param id the primary key for the new operation
	 * @return the new operation
	 */
	public static Operation create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the operation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the operation
	 * @return the operation that was removed
	 * @throws NoSuchOperationException if a operation with the primary key could not be found
	 */
	public static Operation remove(long id)
		throws com.df.lonis.ventesservice.exception.NoSuchOperationException {

		return getPersistence().remove(id);
	}

	public static Operation updateImpl(Operation operation) {
		return getPersistence().updateImpl(operation);
	}

	/**
	 * Returns the operation with the primary key or throws a <code>NoSuchOperationException</code> if it could not be found.
	 *
	 * @param id the primary key of the operation
	 * @return the operation
	 * @throws NoSuchOperationException if a operation with the primary key could not be found
	 */
	public static Operation findByPrimaryKey(long id)
		throws com.df.lonis.ventesservice.exception.NoSuchOperationException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the operation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the operation
	 * @return the operation, or <code>null</code> if a operation with the primary key could not be found
	 */
	public static Operation fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the operations.
	 *
	 * @return the operations
	 */
	public static List<Operation> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the operations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OperationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of operations
	 * @param end the upper bound of the range of operations (not inclusive)
	 * @return the range of operations
	 */
	public static List<Operation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the operations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OperationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of operations
	 * @param end the upper bound of the range of operations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of operations
	 */
	public static List<Operation> findAll(
		int start, int end, OrderByComparator<Operation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the operations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OperationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of operations
	 * @param end the upper bound of the range of operations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of operations
	 */
	public static List<Operation> findAll(
		int start, int end, OrderByComparator<Operation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the operations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of operations.
	 *
	 * @return the number of operations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static OperationPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(OperationPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile OperationPersistence _persistence;

}