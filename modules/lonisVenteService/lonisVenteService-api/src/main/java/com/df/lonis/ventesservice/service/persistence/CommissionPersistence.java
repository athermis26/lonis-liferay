/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence;

import com.df.lonis.ventesservice.exception.NoSuchCommissionException;
import com.df.lonis.ventesservice.model.Commission;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the commission service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CommissionUtil
 * @generated
 */
@ProviderType
public interface CommissionPersistence extends BasePersistence<Commission> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CommissionUtil} to access the commission persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the commissions where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @return the matching commissions
	 */
	public java.util.List<Commission> findByTerminalId(long terminalId);

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
	public java.util.List<Commission> findByTerminalId(
		long terminalId, int start, int end);

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
	public java.util.List<Commission> findByTerminalId(
		long terminalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Commission>
			orderByComparator);

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
	public java.util.List<Commission> findByTerminalId(
		long terminalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Commission>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first commission in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commission
	 * @throws NoSuchCommissionException if a matching commission could not be found
	 */
	public Commission findByTerminalId_First(
			long terminalId,
			com.liferay.portal.kernel.util.OrderByComparator<Commission>
				orderByComparator)
		throws NoSuchCommissionException;

	/**
	 * Returns the first commission in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commission, or <code>null</code> if a matching commission could not be found
	 */
	public Commission fetchByTerminalId_First(
		long terminalId,
		com.liferay.portal.kernel.util.OrderByComparator<Commission>
			orderByComparator);

	/**
	 * Returns the last commission in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commission
	 * @throws NoSuchCommissionException if a matching commission could not be found
	 */
	public Commission findByTerminalId_Last(
			long terminalId,
			com.liferay.portal.kernel.util.OrderByComparator<Commission>
				orderByComparator)
		throws NoSuchCommissionException;

	/**
	 * Returns the last commission in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commission, or <code>null</code> if a matching commission could not be found
	 */
	public Commission fetchByTerminalId_Last(
		long terminalId,
		com.liferay.portal.kernel.util.OrderByComparator<Commission>
			orderByComparator);

	/**
	 * Returns the commissions before and after the current commission in the ordered set where terminalId = &#63;.
	 *
	 * @param id the primary key of the current commission
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commission
	 * @throws NoSuchCommissionException if a commission with the primary key could not be found
	 */
	public Commission[] findByTerminalId_PrevAndNext(
			long id, long terminalId,
			com.liferay.portal.kernel.util.OrderByComparator<Commission>
				orderByComparator)
		throws NoSuchCommissionException;

	/**
	 * Removes all the commissions where terminalId = &#63; from the database.
	 *
	 * @param terminalId the terminal ID
	 */
	public void removeByTerminalId(long terminalId);

	/**
	 * Returns the number of commissions where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @return the number of matching commissions
	 */
	public int countByTerminalId(long terminalId);

	/**
	 * Returns all the commissions where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching commissions
	 */
	public java.util.List<Commission> findByStatus(String status);

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
	public java.util.List<Commission> findByStatus(
		String status, int start, int end);

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
	public java.util.List<Commission> findByStatus(
		String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Commission>
			orderByComparator);

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
	public java.util.List<Commission> findByStatus(
		String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Commission>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first commission in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commission
	 * @throws NoSuchCommissionException if a matching commission could not be found
	 */
	public Commission findByStatus_First(
			String status,
			com.liferay.portal.kernel.util.OrderByComparator<Commission>
				orderByComparator)
		throws NoSuchCommissionException;

	/**
	 * Returns the first commission in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commission, or <code>null</code> if a matching commission could not be found
	 */
	public Commission fetchByStatus_First(
		String status,
		com.liferay.portal.kernel.util.OrderByComparator<Commission>
			orderByComparator);

	/**
	 * Returns the last commission in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commission
	 * @throws NoSuchCommissionException if a matching commission could not be found
	 */
	public Commission findByStatus_Last(
			String status,
			com.liferay.portal.kernel.util.OrderByComparator<Commission>
				orderByComparator)
		throws NoSuchCommissionException;

	/**
	 * Returns the last commission in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commission, or <code>null</code> if a matching commission could not be found
	 */
	public Commission fetchByStatus_Last(
		String status,
		com.liferay.portal.kernel.util.OrderByComparator<Commission>
			orderByComparator);

	/**
	 * Returns the commissions before and after the current commission in the ordered set where status = &#63;.
	 *
	 * @param id the primary key of the current commission
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commission
	 * @throws NoSuchCommissionException if a commission with the primary key could not be found
	 */
	public Commission[] findByStatus_PrevAndNext(
			long id, String status,
			com.liferay.portal.kernel.util.OrderByComparator<Commission>
				orderByComparator)
		throws NoSuchCommissionException;

	/**
	 * Removes all the commissions where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(String status);

	/**
	 * Returns the number of commissions where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching commissions
	 */
	public int countByStatus(String status);

	/**
	 * Caches the commission in the entity cache if it is enabled.
	 *
	 * @param commission the commission
	 */
	public void cacheResult(Commission commission);

	/**
	 * Caches the commissions in the entity cache if it is enabled.
	 *
	 * @param commissions the commissions
	 */
	public void cacheResult(java.util.List<Commission> commissions);

	/**
	 * Creates a new commission with the primary key. Does not add the commission to the database.
	 *
	 * @param id the primary key for the new commission
	 * @return the new commission
	 */
	public Commission create(long id);

	/**
	 * Removes the commission with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the commission
	 * @return the commission that was removed
	 * @throws NoSuchCommissionException if a commission with the primary key could not be found
	 */
	public Commission remove(long id) throws NoSuchCommissionException;

	public Commission updateImpl(Commission commission);

	/**
	 * Returns the commission with the primary key or throws a <code>NoSuchCommissionException</code> if it could not be found.
	 *
	 * @param id the primary key of the commission
	 * @return the commission
	 * @throws NoSuchCommissionException if a commission with the primary key could not be found
	 */
	public Commission findByPrimaryKey(long id)
		throws NoSuchCommissionException;

	/**
	 * Returns the commission with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the commission
	 * @return the commission, or <code>null</code> if a commission with the primary key could not be found
	 */
	public Commission fetchByPrimaryKey(long id);

	/**
	 * Returns all the commissions.
	 *
	 * @return the commissions
	 */
	public java.util.List<Commission> findAll();

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
	public java.util.List<Commission> findAll(int start, int end);

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
	public java.util.List<Commission> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Commission>
			orderByComparator);

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
	public java.util.List<Commission> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Commission>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the commissions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of commissions.
	 *
	 * @return the number of commissions
	 */
	public int countAll();

}