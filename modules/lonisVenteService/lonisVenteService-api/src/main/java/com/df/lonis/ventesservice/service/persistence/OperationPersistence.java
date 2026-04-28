/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence;

import com.df.lonis.ventesservice.exception.NoSuchOperationException;
import com.df.lonis.ventesservice.model.Operation;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the operation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OperationUtil
 * @generated
 */
@ProviderType
public interface OperationPersistence extends BasePersistence<Operation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OperationUtil} to access the operation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the operations where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @return the matching operations
	 */
	public java.util.List<Operation> findByTerminalId(long terminalId);

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
	public java.util.List<Operation> findByTerminalId(
		long terminalId, int start, int end);

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
	public java.util.List<Operation> findByTerminalId(
		long terminalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Operation>
			orderByComparator);

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
	public java.util.List<Operation> findByTerminalId(
		long terminalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Operation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first operation in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching operation
	 * @throws NoSuchOperationException if a matching operation could not be found
	 */
	public Operation findByTerminalId_First(
			long terminalId,
			com.liferay.portal.kernel.util.OrderByComparator<Operation>
				orderByComparator)
		throws NoSuchOperationException;

	/**
	 * Returns the first operation in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching operation, or <code>null</code> if a matching operation could not be found
	 */
	public Operation fetchByTerminalId_First(
		long terminalId,
		com.liferay.portal.kernel.util.OrderByComparator<Operation>
			orderByComparator);

	/**
	 * Returns the last operation in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching operation
	 * @throws NoSuchOperationException if a matching operation could not be found
	 */
	public Operation findByTerminalId_Last(
			long terminalId,
			com.liferay.portal.kernel.util.OrderByComparator<Operation>
				orderByComparator)
		throws NoSuchOperationException;

	/**
	 * Returns the last operation in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching operation, or <code>null</code> if a matching operation could not be found
	 */
	public Operation fetchByTerminalId_Last(
		long terminalId,
		com.liferay.portal.kernel.util.OrderByComparator<Operation>
			orderByComparator);

	/**
	 * Returns the operations before and after the current operation in the ordered set where terminalId = &#63;.
	 *
	 * @param id the primary key of the current operation
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next operation
	 * @throws NoSuchOperationException if a operation with the primary key could not be found
	 */
	public Operation[] findByTerminalId_PrevAndNext(
			long id, long terminalId,
			com.liferay.portal.kernel.util.OrderByComparator<Operation>
				orderByComparator)
		throws NoSuchOperationException;

	/**
	 * Removes all the operations where terminalId = &#63; from the database.
	 *
	 * @param terminalId the terminal ID
	 */
	public void removeByTerminalId(long terminalId);

	/**
	 * Returns the number of operations where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @return the number of matching operations
	 */
	public int countByTerminalId(long terminalId);

	/**
	 * Returns the operation where reference = &#63; or throws a <code>NoSuchOperationException</code> if it could not be found.
	 *
	 * @param reference the reference
	 * @return the matching operation
	 * @throws NoSuchOperationException if a matching operation could not be found
	 */
	public Operation findByReference(String reference)
		throws NoSuchOperationException;

	/**
	 * Returns the operation where reference = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param reference the reference
	 * @return the matching operation, or <code>null</code> if a matching operation could not be found
	 */
	public Operation fetchByReference(String reference);

	/**
	 * Returns the operation where reference = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param reference the reference
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching operation, or <code>null</code> if a matching operation could not be found
	 */
	public Operation fetchByReference(String reference, boolean useFinderCache);

	/**
	 * Removes the operation where reference = &#63; from the database.
	 *
	 * @param reference the reference
	 * @return the operation that was removed
	 */
	public Operation removeByReference(String reference)
		throws NoSuchOperationException;

	/**
	 * Returns the number of operations where reference = &#63;.
	 *
	 * @param reference the reference
	 * @return the number of matching operations
	 */
	public int countByReference(String reference);

	/**
	 * Returns all the operations where statut = &#63;.
	 *
	 * @param statut the statut
	 * @return the matching operations
	 */
	public java.util.List<Operation> findByStatut(String statut);

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
	public java.util.List<Operation> findByStatut(
		String statut, int start, int end);

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
	public java.util.List<Operation> findByStatut(
		String statut, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Operation>
			orderByComparator);

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
	public java.util.List<Operation> findByStatut(
		String statut, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Operation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first operation in the ordered set where statut = &#63;.
	 *
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching operation
	 * @throws NoSuchOperationException if a matching operation could not be found
	 */
	public Operation findByStatut_First(
			String statut,
			com.liferay.portal.kernel.util.OrderByComparator<Operation>
				orderByComparator)
		throws NoSuchOperationException;

	/**
	 * Returns the first operation in the ordered set where statut = &#63;.
	 *
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching operation, or <code>null</code> if a matching operation could not be found
	 */
	public Operation fetchByStatut_First(
		String statut,
		com.liferay.portal.kernel.util.OrderByComparator<Operation>
			orderByComparator);

	/**
	 * Returns the last operation in the ordered set where statut = &#63;.
	 *
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching operation
	 * @throws NoSuchOperationException if a matching operation could not be found
	 */
	public Operation findByStatut_Last(
			String statut,
			com.liferay.portal.kernel.util.OrderByComparator<Operation>
				orderByComparator)
		throws NoSuchOperationException;

	/**
	 * Returns the last operation in the ordered set where statut = &#63;.
	 *
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching operation, or <code>null</code> if a matching operation could not be found
	 */
	public Operation fetchByStatut_Last(
		String statut,
		com.liferay.portal.kernel.util.OrderByComparator<Operation>
			orderByComparator);

	/**
	 * Returns the operations before and after the current operation in the ordered set where statut = &#63;.
	 *
	 * @param id the primary key of the current operation
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next operation
	 * @throws NoSuchOperationException if a operation with the primary key could not be found
	 */
	public Operation[] findByStatut_PrevAndNext(
			long id, String statut,
			com.liferay.portal.kernel.util.OrderByComparator<Operation>
				orderByComparator)
		throws NoSuchOperationException;

	/**
	 * Removes all the operations where statut = &#63; from the database.
	 *
	 * @param statut the statut
	 */
	public void removeByStatut(String statut);

	/**
	 * Returns the number of operations where statut = &#63;.
	 *
	 * @param statut the statut
	 * @return the number of matching operations
	 */
	public int countByStatut(String statut);

	/**
	 * Caches the operation in the entity cache if it is enabled.
	 *
	 * @param operation the operation
	 */
	public void cacheResult(Operation operation);

	/**
	 * Caches the operations in the entity cache if it is enabled.
	 *
	 * @param operations the operations
	 */
	public void cacheResult(java.util.List<Operation> operations);

	/**
	 * Creates a new operation with the primary key. Does not add the operation to the database.
	 *
	 * @param id the primary key for the new operation
	 * @return the new operation
	 */
	public Operation create(long id);

	/**
	 * Removes the operation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the operation
	 * @return the operation that was removed
	 * @throws NoSuchOperationException if a operation with the primary key could not be found
	 */
	public Operation remove(long id) throws NoSuchOperationException;

	public Operation updateImpl(Operation operation);

	/**
	 * Returns the operation with the primary key or throws a <code>NoSuchOperationException</code> if it could not be found.
	 *
	 * @param id the primary key of the operation
	 * @return the operation
	 * @throws NoSuchOperationException if a operation with the primary key could not be found
	 */
	public Operation findByPrimaryKey(long id) throws NoSuchOperationException;

	/**
	 * Returns the operation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the operation
	 * @return the operation, or <code>null</code> if a operation with the primary key could not be found
	 */
	public Operation fetchByPrimaryKey(long id);

	/**
	 * Returns all the operations.
	 *
	 * @return the operations
	 */
	public java.util.List<Operation> findAll();

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
	public java.util.List<Operation> findAll(int start, int end);

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
	public java.util.List<Operation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Operation>
			orderByComparator);

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
	public java.util.List<Operation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Operation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the operations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of operations.
	 *
	 * @return the number of operations
	 */
	public int countAll();

}