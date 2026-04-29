/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence;

import com.df.lonis.ventesservice.exception.NoSuchTerminalException;
import com.df.lonis.ventesservice.model.Terminal;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the terminal service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TerminalUtil
 * @generated
 */
@ProviderType
public interface TerminalPersistence extends BasePersistence<Terminal> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TerminalUtil} to access the terminal persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the terminals where concessionnaireProduitCode = &#63;.
	 *
	 * @param concessionnaireProduitCode the concessionnaire produit code
	 * @return the matching terminals
	 */
	public java.util.List<Terminal> findByConcessionnaireProduitCode(
		String concessionnaireProduitCode);

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
	public java.util.List<Terminal> findByConcessionnaireProduitCode(
		String concessionnaireProduitCode, int start, int end);

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
	public java.util.List<Terminal> findByConcessionnaireProduitCode(
		String concessionnaireProduitCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Terminal>
			orderByComparator);

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
	public java.util.List<Terminal> findByConcessionnaireProduitCode(
		String concessionnaireProduitCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Terminal>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first terminal in the ordered set where concessionnaireProduitCode = &#63;.
	 *
	 * @param concessionnaireProduitCode the concessionnaire produit code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching terminal
	 * @throws NoSuchTerminalException if a matching terminal could not be found
	 */
	public Terminal findByConcessionnaireProduitCode_First(
			String concessionnaireProduitCode,
			com.liferay.portal.kernel.util.OrderByComparator<Terminal>
				orderByComparator)
		throws NoSuchTerminalException;

	/**
	 * Returns the first terminal in the ordered set where concessionnaireProduitCode = &#63;.
	 *
	 * @param concessionnaireProduitCode the concessionnaire produit code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching terminal, or <code>null</code> if a matching terminal could not be found
	 */
	public Terminal fetchByConcessionnaireProduitCode_First(
		String concessionnaireProduitCode,
		com.liferay.portal.kernel.util.OrderByComparator<Terminal>
			orderByComparator);

	/**
	 * Returns the last terminal in the ordered set where concessionnaireProduitCode = &#63;.
	 *
	 * @param concessionnaireProduitCode the concessionnaire produit code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching terminal
	 * @throws NoSuchTerminalException if a matching terminal could not be found
	 */
	public Terminal findByConcessionnaireProduitCode_Last(
			String concessionnaireProduitCode,
			com.liferay.portal.kernel.util.OrderByComparator<Terminal>
				orderByComparator)
		throws NoSuchTerminalException;

	/**
	 * Returns the last terminal in the ordered set where concessionnaireProduitCode = &#63;.
	 *
	 * @param concessionnaireProduitCode the concessionnaire produit code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching terminal, or <code>null</code> if a matching terminal could not be found
	 */
	public Terminal fetchByConcessionnaireProduitCode_Last(
		String concessionnaireProduitCode,
		com.liferay.portal.kernel.util.OrderByComparator<Terminal>
			orderByComparator);

	/**
	 * Returns the terminals before and after the current terminal in the ordered set where concessionnaireProduitCode = &#63;.
	 *
	 * @param id the primary key of the current terminal
	 * @param concessionnaireProduitCode the concessionnaire produit code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next terminal
	 * @throws NoSuchTerminalException if a terminal with the primary key could not be found
	 */
	public Terminal[] findByConcessionnaireProduitCode_PrevAndNext(
			long id, String concessionnaireProduitCode,
			com.liferay.portal.kernel.util.OrderByComparator<Terminal>
				orderByComparator)
		throws NoSuchTerminalException;

	/**
	 * Removes all the terminals where concessionnaireProduitCode = &#63; from the database.
	 *
	 * @param concessionnaireProduitCode the concessionnaire produit code
	 */
	public void removeByConcessionnaireProduitCode(
		String concessionnaireProduitCode);

	/**
	 * Returns the number of terminals where concessionnaireProduitCode = &#63;.
	 *
	 * @param concessionnaireProduitCode the concessionnaire produit code
	 * @return the number of matching terminals
	 */
	public int countByConcessionnaireProduitCode(
		String concessionnaireProduitCode);

	/**
	 * Returns all the terminals where concessionnaireId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @return the matching terminals
	 */
	public java.util.List<Terminal> findByConcessionnaireId(
		long concessionnaireId);

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
	public java.util.List<Terminal> findByConcessionnaireId(
		long concessionnaireId, int start, int end);

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
	public java.util.List<Terminal> findByConcessionnaireId(
		long concessionnaireId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Terminal>
			orderByComparator);

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
	public java.util.List<Terminal> findByConcessionnaireId(
		long concessionnaireId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Terminal>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first terminal in the ordered set where concessionnaireId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching terminal
	 * @throws NoSuchTerminalException if a matching terminal could not be found
	 */
	public Terminal findByConcessionnaireId_First(
			long concessionnaireId,
			com.liferay.portal.kernel.util.OrderByComparator<Terminal>
				orderByComparator)
		throws NoSuchTerminalException;

	/**
	 * Returns the first terminal in the ordered set where concessionnaireId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching terminal, or <code>null</code> if a matching terminal could not be found
	 */
	public Terminal fetchByConcessionnaireId_First(
		long concessionnaireId,
		com.liferay.portal.kernel.util.OrderByComparator<Terminal>
			orderByComparator);

	/**
	 * Returns the last terminal in the ordered set where concessionnaireId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching terminal
	 * @throws NoSuchTerminalException if a matching terminal could not be found
	 */
	public Terminal findByConcessionnaireId_Last(
			long concessionnaireId,
			com.liferay.portal.kernel.util.OrderByComparator<Terminal>
				orderByComparator)
		throws NoSuchTerminalException;

	/**
	 * Returns the last terminal in the ordered set where concessionnaireId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching terminal, or <code>null</code> if a matching terminal could not be found
	 */
	public Terminal fetchByConcessionnaireId_Last(
		long concessionnaireId,
		com.liferay.portal.kernel.util.OrderByComparator<Terminal>
			orderByComparator);

	/**
	 * Returns the terminals before and after the current terminal in the ordered set where concessionnaireId = &#63;.
	 *
	 * @param id the primary key of the current terminal
	 * @param concessionnaireId the concessionnaire ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next terminal
	 * @throws NoSuchTerminalException if a terminal with the primary key could not be found
	 */
	public Terminal[] findByConcessionnaireId_PrevAndNext(
			long id, long concessionnaireId,
			com.liferay.portal.kernel.util.OrderByComparator<Terminal>
				orderByComparator)
		throws NoSuchTerminalException;

	/**
	 * Removes all the terminals where concessionnaireId = &#63; from the database.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 */
	public void removeByConcessionnaireId(long concessionnaireId);

	/**
	 * Returns the number of terminals where concessionnaireId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @return the number of matching terminals
	 */
	public int countByConcessionnaireId(long concessionnaireId);

	/**
	 * Caches the terminal in the entity cache if it is enabled.
	 *
	 * @param terminal the terminal
	 */
	public void cacheResult(Terminal terminal);

	/**
	 * Caches the terminals in the entity cache if it is enabled.
	 *
	 * @param terminals the terminals
	 */
	public void cacheResult(java.util.List<Terminal> terminals);

	/**
	 * Creates a new terminal with the primary key. Does not add the terminal to the database.
	 *
	 * @param id the primary key for the new terminal
	 * @return the new terminal
	 */
	public Terminal create(long id);

	/**
	 * Removes the terminal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the terminal
	 * @return the terminal that was removed
	 * @throws NoSuchTerminalException if a terminal with the primary key could not be found
	 */
	public Terminal remove(long id) throws NoSuchTerminalException;

	public Terminal updateImpl(Terminal terminal);

	/**
	 * Returns the terminal with the primary key or throws a <code>NoSuchTerminalException</code> if it could not be found.
	 *
	 * @param id the primary key of the terminal
	 * @return the terminal
	 * @throws NoSuchTerminalException if a terminal with the primary key could not be found
	 */
	public Terminal findByPrimaryKey(long id) throws NoSuchTerminalException;

	/**
	 * Returns the terminal with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the terminal
	 * @return the terminal, or <code>null</code> if a terminal with the primary key could not be found
	 */
	public Terminal fetchByPrimaryKey(long id);

	/**
	 * Returns all the terminals.
	 *
	 * @return the terminals
	 */
	public java.util.List<Terminal> findAll();

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
	public java.util.List<Terminal> findAll(int start, int end);

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
	public java.util.List<Terminal> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Terminal>
			orderByComparator);

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
	public java.util.List<Terminal> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Terminal>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the terminals from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of terminals.
	 *
	 * @return the number of terminals
	 */
	public int countAll();

}