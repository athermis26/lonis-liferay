/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence;

import com.df.lonis.ventesservice.exception.NoSuchChiffreAffairesException;
import com.df.lonis.ventesservice.model.ChiffreAffaires;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the chiffre affaires service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChiffreAffairesUtil
 * @generated
 */
@ProviderType
public interface ChiffreAffairesPersistence
	extends BasePersistence<ChiffreAffaires> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ChiffreAffairesUtil} to access the chiffre affaires persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the chiffre affaireses where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @return the matching chiffre affaireses
	 */
	public java.util.List<ChiffreAffaires> findByTerminalId(long terminalId);

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
	public java.util.List<ChiffreAffaires> findByTerminalId(
		long terminalId, int start, int end);

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
	public java.util.List<ChiffreAffaires> findByTerminalId(
		long terminalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChiffreAffaires>
			orderByComparator);

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
	public java.util.List<ChiffreAffaires> findByTerminalId(
		long terminalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChiffreAffaires>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first chiffre affaires in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chiffre affaires
	 * @throws NoSuchChiffreAffairesException if a matching chiffre affaires could not be found
	 */
	public ChiffreAffaires findByTerminalId_First(
			long terminalId,
			com.liferay.portal.kernel.util.OrderByComparator<ChiffreAffaires>
				orderByComparator)
		throws NoSuchChiffreAffairesException;

	/**
	 * Returns the first chiffre affaires in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chiffre affaires, or <code>null</code> if a matching chiffre affaires could not be found
	 */
	public ChiffreAffaires fetchByTerminalId_First(
		long terminalId,
		com.liferay.portal.kernel.util.OrderByComparator<ChiffreAffaires>
			orderByComparator);

	/**
	 * Returns the last chiffre affaires in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chiffre affaires
	 * @throws NoSuchChiffreAffairesException if a matching chiffre affaires could not be found
	 */
	public ChiffreAffaires findByTerminalId_Last(
			long terminalId,
			com.liferay.portal.kernel.util.OrderByComparator<ChiffreAffaires>
				orderByComparator)
		throws NoSuchChiffreAffairesException;

	/**
	 * Returns the last chiffre affaires in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chiffre affaires, or <code>null</code> if a matching chiffre affaires could not be found
	 */
	public ChiffreAffaires fetchByTerminalId_Last(
		long terminalId,
		com.liferay.portal.kernel.util.OrderByComparator<ChiffreAffaires>
			orderByComparator);

	/**
	 * Returns the chiffre affaireses before and after the current chiffre affaires in the ordered set where terminalId = &#63;.
	 *
	 * @param id the primary key of the current chiffre affaires
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chiffre affaires
	 * @throws NoSuchChiffreAffairesException if a chiffre affaires with the primary key could not be found
	 */
	public ChiffreAffaires[] findByTerminalId_PrevAndNext(
			long id, long terminalId,
			com.liferay.portal.kernel.util.OrderByComparator<ChiffreAffaires>
				orderByComparator)
		throws NoSuchChiffreAffairesException;

	/**
	 * Removes all the chiffre affaireses where terminalId = &#63; from the database.
	 *
	 * @param terminalId the terminal ID
	 */
	public void removeByTerminalId(long terminalId);

	/**
	 * Returns the number of chiffre affaireses where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @return the number of matching chiffre affaireses
	 */
	public int countByTerminalId(long terminalId);

	/**
	 * Returns all the chiffre affaireses where terminalId = &#63; and date &ge; &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param date the date
	 * @return the matching chiffre affaireses
	 */
	public java.util.List<ChiffreAffaires> findByT_D(
		long terminalId, Date date);

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
	public java.util.List<ChiffreAffaires> findByT_D(
		long terminalId, Date date, int start, int end);

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
	public java.util.List<ChiffreAffaires> findByT_D(
		long terminalId, Date date, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChiffreAffaires>
			orderByComparator);

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
	public java.util.List<ChiffreAffaires> findByT_D(
		long terminalId, Date date, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChiffreAffaires>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first chiffre affaires in the ordered set where terminalId = &#63; and date &ge; &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chiffre affaires
	 * @throws NoSuchChiffreAffairesException if a matching chiffre affaires could not be found
	 */
	public ChiffreAffaires findByT_D_First(
			long terminalId, Date date,
			com.liferay.portal.kernel.util.OrderByComparator<ChiffreAffaires>
				orderByComparator)
		throws NoSuchChiffreAffairesException;

	/**
	 * Returns the first chiffre affaires in the ordered set where terminalId = &#63; and date &ge; &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chiffre affaires, or <code>null</code> if a matching chiffre affaires could not be found
	 */
	public ChiffreAffaires fetchByT_D_First(
		long terminalId, Date date,
		com.liferay.portal.kernel.util.OrderByComparator<ChiffreAffaires>
			orderByComparator);

	/**
	 * Returns the last chiffre affaires in the ordered set where terminalId = &#63; and date &ge; &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chiffre affaires
	 * @throws NoSuchChiffreAffairesException if a matching chiffre affaires could not be found
	 */
	public ChiffreAffaires findByT_D_Last(
			long terminalId, Date date,
			com.liferay.portal.kernel.util.OrderByComparator<ChiffreAffaires>
				orderByComparator)
		throws NoSuchChiffreAffairesException;

	/**
	 * Returns the last chiffre affaires in the ordered set where terminalId = &#63; and date &ge; &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chiffre affaires, or <code>null</code> if a matching chiffre affaires could not be found
	 */
	public ChiffreAffaires fetchByT_D_Last(
		long terminalId, Date date,
		com.liferay.portal.kernel.util.OrderByComparator<ChiffreAffaires>
			orderByComparator);

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
	public ChiffreAffaires[] findByT_D_PrevAndNext(
			long id, long terminalId, Date date,
			com.liferay.portal.kernel.util.OrderByComparator<ChiffreAffaires>
				orderByComparator)
		throws NoSuchChiffreAffairesException;

	/**
	 * Removes all the chiffre affaireses where terminalId = &#63; and date &ge; &#63; from the database.
	 *
	 * @param terminalId the terminal ID
	 * @param date the date
	 */
	public void removeByT_D(long terminalId, Date date);

	/**
	 * Returns the number of chiffre affaireses where terminalId = &#63; and date &ge; &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param date the date
	 * @return the number of matching chiffre affaireses
	 */
	public int countByT_D(long terminalId, Date date);

	/**
	 * Caches the chiffre affaires in the entity cache if it is enabled.
	 *
	 * @param chiffreAffaires the chiffre affaires
	 */
	public void cacheResult(ChiffreAffaires chiffreAffaires);

	/**
	 * Caches the chiffre affaireses in the entity cache if it is enabled.
	 *
	 * @param chiffreAffaireses the chiffre affaireses
	 */
	public void cacheResult(java.util.List<ChiffreAffaires> chiffreAffaireses);

	/**
	 * Creates a new chiffre affaires with the primary key. Does not add the chiffre affaires to the database.
	 *
	 * @param id the primary key for the new chiffre affaires
	 * @return the new chiffre affaires
	 */
	public ChiffreAffaires create(long id);

	/**
	 * Removes the chiffre affaires with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the chiffre affaires
	 * @return the chiffre affaires that was removed
	 * @throws NoSuchChiffreAffairesException if a chiffre affaires with the primary key could not be found
	 */
	public ChiffreAffaires remove(long id)
		throws NoSuchChiffreAffairesException;

	public ChiffreAffaires updateImpl(ChiffreAffaires chiffreAffaires);

	/**
	 * Returns the chiffre affaires with the primary key or throws a <code>NoSuchChiffreAffairesException</code> if it could not be found.
	 *
	 * @param id the primary key of the chiffre affaires
	 * @return the chiffre affaires
	 * @throws NoSuchChiffreAffairesException if a chiffre affaires with the primary key could not be found
	 */
	public ChiffreAffaires findByPrimaryKey(long id)
		throws NoSuchChiffreAffairesException;

	/**
	 * Returns the chiffre affaires with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the chiffre affaires
	 * @return the chiffre affaires, or <code>null</code> if a chiffre affaires with the primary key could not be found
	 */
	public ChiffreAffaires fetchByPrimaryKey(long id);

	/**
	 * Returns all the chiffre affaireses.
	 *
	 * @return the chiffre affaireses
	 */
	public java.util.List<ChiffreAffaires> findAll();

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
	public java.util.List<ChiffreAffaires> findAll(int start, int end);

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
	public java.util.List<ChiffreAffaires> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChiffreAffaires>
			orderByComparator);

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
	public java.util.List<ChiffreAffaires> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChiffreAffaires>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the chiffre affaireses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of chiffre affaireses.
	 *
	 * @return the number of chiffre affaireses
	 */
	public int countAll();

}