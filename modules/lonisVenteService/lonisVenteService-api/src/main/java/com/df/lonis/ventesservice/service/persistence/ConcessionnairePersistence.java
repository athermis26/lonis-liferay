/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence;

import com.df.lonis.ventesservice.exception.NoSuchConcessionnaireException;
import com.df.lonis.ventesservice.model.Concessionnaire;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the concessionnaire service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConcessionnaireUtil
 * @generated
 */
@ProviderType
public interface ConcessionnairePersistence
	extends BasePersistence<Concessionnaire> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ConcessionnaireUtil} to access the concessionnaire persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the concessionnaire where uid = &#63; or throws a <code>NoSuchConcessionnaireException</code> if it could not be found.
	 *
	 * @param uid the uid
	 * @return the matching concessionnaire
	 * @throws NoSuchConcessionnaireException if a matching concessionnaire could not be found
	 */
	public Concessionnaire findByUid(String uid)
		throws NoSuchConcessionnaireException;

	/**
	 * Returns the concessionnaire where uid = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uid the uid
	 * @return the matching concessionnaire, or <code>null</code> if a matching concessionnaire could not be found
	 */
	public Concessionnaire fetchByUid(String uid);

	/**
	 * Returns the concessionnaire where uid = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uid the uid
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching concessionnaire, or <code>null</code> if a matching concessionnaire could not be found
	 */
	public Concessionnaire fetchByUid(String uid, boolean useFinderCache);

	/**
	 * Removes the concessionnaire where uid = &#63; from the database.
	 *
	 * @param uid the uid
	 * @return the concessionnaire that was removed
	 */
	public Concessionnaire removeByUid(String uid)
		throws NoSuchConcessionnaireException;

	/**
	 * Returns the number of concessionnaires where uid = &#63;.
	 *
	 * @param uid the uid
	 * @return the number of matching concessionnaires
	 */
	public int countByUid(String uid);

	/**
	 * Returns all the concessionnaires where nom = &#63;.
	 *
	 * @param nom the nom
	 * @return the matching concessionnaires
	 */
	public java.util.List<Concessionnaire> findByNom(String nom);

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
	public java.util.List<Concessionnaire> findByNom(
		String nom, int start, int end);

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
	public java.util.List<Concessionnaire> findByNom(
		String nom, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Concessionnaire>
			orderByComparator);

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
	public java.util.List<Concessionnaire> findByNom(
		String nom, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Concessionnaire>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first concessionnaire in the ordered set where nom = &#63;.
	 *
	 * @param nom the nom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concessionnaire
	 * @throws NoSuchConcessionnaireException if a matching concessionnaire could not be found
	 */
	public Concessionnaire findByNom_First(
			String nom,
			com.liferay.portal.kernel.util.OrderByComparator<Concessionnaire>
				orderByComparator)
		throws NoSuchConcessionnaireException;

	/**
	 * Returns the first concessionnaire in the ordered set where nom = &#63;.
	 *
	 * @param nom the nom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concessionnaire, or <code>null</code> if a matching concessionnaire could not be found
	 */
	public Concessionnaire fetchByNom_First(
		String nom,
		com.liferay.portal.kernel.util.OrderByComparator<Concessionnaire>
			orderByComparator);

	/**
	 * Returns the last concessionnaire in the ordered set where nom = &#63;.
	 *
	 * @param nom the nom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concessionnaire
	 * @throws NoSuchConcessionnaireException if a matching concessionnaire could not be found
	 */
	public Concessionnaire findByNom_Last(
			String nom,
			com.liferay.portal.kernel.util.OrderByComparator<Concessionnaire>
				orderByComparator)
		throws NoSuchConcessionnaireException;

	/**
	 * Returns the last concessionnaire in the ordered set where nom = &#63;.
	 *
	 * @param nom the nom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concessionnaire, or <code>null</code> if a matching concessionnaire could not be found
	 */
	public Concessionnaire fetchByNom_Last(
		String nom,
		com.liferay.portal.kernel.util.OrderByComparator<Concessionnaire>
			orderByComparator);

	/**
	 * Returns the concessionnaires before and after the current concessionnaire in the ordered set where nom = &#63;.
	 *
	 * @param id the primary key of the current concessionnaire
	 * @param nom the nom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next concessionnaire
	 * @throws NoSuchConcessionnaireException if a concessionnaire with the primary key could not be found
	 */
	public Concessionnaire[] findByNom_PrevAndNext(
			long id, String nom,
			com.liferay.portal.kernel.util.OrderByComparator<Concessionnaire>
				orderByComparator)
		throws NoSuchConcessionnaireException;

	/**
	 * Removes all the concessionnaires where nom = &#63; from the database.
	 *
	 * @param nom the nom
	 */
	public void removeByNom(String nom);

	/**
	 * Returns the number of concessionnaires where nom = &#63;.
	 *
	 * @param nom the nom
	 * @return the number of matching concessionnaires
	 */
	public int countByNom(String nom);

	/**
	 * Caches the concessionnaire in the entity cache if it is enabled.
	 *
	 * @param concessionnaire the concessionnaire
	 */
	public void cacheResult(Concessionnaire concessionnaire);

	/**
	 * Caches the concessionnaires in the entity cache if it is enabled.
	 *
	 * @param concessionnaires the concessionnaires
	 */
	public void cacheResult(java.util.List<Concessionnaire> concessionnaires);

	/**
	 * Creates a new concessionnaire with the primary key. Does not add the concessionnaire to the database.
	 *
	 * @param id the primary key for the new concessionnaire
	 * @return the new concessionnaire
	 */
	public Concessionnaire create(long id);

	/**
	 * Removes the concessionnaire with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the concessionnaire
	 * @return the concessionnaire that was removed
	 * @throws NoSuchConcessionnaireException if a concessionnaire with the primary key could not be found
	 */
	public Concessionnaire remove(long id)
		throws NoSuchConcessionnaireException;

	public Concessionnaire updateImpl(Concessionnaire concessionnaire);

	/**
	 * Returns the concessionnaire with the primary key or throws a <code>NoSuchConcessionnaireException</code> if it could not be found.
	 *
	 * @param id the primary key of the concessionnaire
	 * @return the concessionnaire
	 * @throws NoSuchConcessionnaireException if a concessionnaire with the primary key could not be found
	 */
	public Concessionnaire findByPrimaryKey(long id)
		throws NoSuchConcessionnaireException;

	/**
	 * Returns the concessionnaire with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the concessionnaire
	 * @return the concessionnaire, or <code>null</code> if a concessionnaire with the primary key could not be found
	 */
	public Concessionnaire fetchByPrimaryKey(long id);

	/**
	 * Returns all the concessionnaires.
	 *
	 * @return the concessionnaires
	 */
	public java.util.List<Concessionnaire> findAll();

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
	public java.util.List<Concessionnaire> findAll(int start, int end);

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
	public java.util.List<Concessionnaire> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Concessionnaire>
			orderByComparator);

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
	public java.util.List<Concessionnaire> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Concessionnaire>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the concessionnaires from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of concessionnaires.
	 *
	 * @return the number of concessionnaires
	 */
	public int countAll();

}