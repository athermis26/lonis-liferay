/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence;

import com.df.lonis.ventesservice.exception.NoSuchCommercialException;
import com.df.lonis.ventesservice.model.Commercial;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the commercial service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CommercialUtil
 * @generated
 */
@ProviderType
public interface CommercialPersistence extends BasePersistence<Commercial> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CommercialUtil} to access the commercial persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the commercial where matricule = &#63; or throws a <code>NoSuchCommercialException</code> if it could not be found.
	 *
	 * @param matricule the matricule
	 * @return the matching commercial
	 * @throws NoSuchCommercialException if a matching commercial could not be found
	 */
	public Commercial findByMatricule(String matricule)
		throws NoSuchCommercialException;

	/**
	 * Returns the commercial where matricule = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param matricule the matricule
	 * @return the matching commercial, or <code>null</code> if a matching commercial could not be found
	 */
	public Commercial fetchByMatricule(String matricule);

	/**
	 * Returns the commercial where matricule = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param matricule the matricule
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching commercial, or <code>null</code> if a matching commercial could not be found
	 */
	public Commercial fetchByMatricule(
		String matricule, boolean useFinderCache);

	/**
	 * Removes the commercial where matricule = &#63; from the database.
	 *
	 * @param matricule the matricule
	 * @return the commercial that was removed
	 */
	public Commercial removeByMatricule(String matricule)
		throws NoSuchCommercialException;

	/**
	 * Returns the number of commercials where matricule = &#63;.
	 *
	 * @param matricule the matricule
	 * @return the number of matching commercials
	 */
	public int countByMatricule(String matricule);

	/**
	 * Returns all the commercials where superviseurId = &#63;.
	 *
	 * @param superviseurId the superviseur ID
	 * @return the matching commercials
	 */
	public java.util.List<Commercial> findBySuperviseurId(long superviseurId);

	/**
	 * Returns a range of all the commercials where superviseurId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercialModelImpl</code>.
	 * </p>
	 *
	 * @param superviseurId the superviseur ID
	 * @param start the lower bound of the range of commercials
	 * @param end the upper bound of the range of commercials (not inclusive)
	 * @return the range of matching commercials
	 */
	public java.util.List<Commercial> findBySuperviseurId(
		long superviseurId, int start, int end);

	/**
	 * Returns an ordered range of all the commercials where superviseurId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercialModelImpl</code>.
	 * </p>
	 *
	 * @param superviseurId the superviseur ID
	 * @param start the lower bound of the range of commercials
	 * @param end the upper bound of the range of commercials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commercials
	 */
	public java.util.List<Commercial> findBySuperviseurId(
		long superviseurId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Commercial>
			orderByComparator);

	/**
	 * Returns an ordered range of all the commercials where superviseurId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercialModelImpl</code>.
	 * </p>
	 *
	 * @param superviseurId the superviseur ID
	 * @param start the lower bound of the range of commercials
	 * @param end the upper bound of the range of commercials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commercials
	 */
	public java.util.List<Commercial> findBySuperviseurId(
		long superviseurId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Commercial>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first commercial in the ordered set where superviseurId = &#63;.
	 *
	 * @param superviseurId the superviseur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commercial
	 * @throws NoSuchCommercialException if a matching commercial could not be found
	 */
	public Commercial findBySuperviseurId_First(
			long superviseurId,
			com.liferay.portal.kernel.util.OrderByComparator<Commercial>
				orderByComparator)
		throws NoSuchCommercialException;

	/**
	 * Returns the first commercial in the ordered set where superviseurId = &#63;.
	 *
	 * @param superviseurId the superviseur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commercial, or <code>null</code> if a matching commercial could not be found
	 */
	public Commercial fetchBySuperviseurId_First(
		long superviseurId,
		com.liferay.portal.kernel.util.OrderByComparator<Commercial>
			orderByComparator);

	/**
	 * Returns the last commercial in the ordered set where superviseurId = &#63;.
	 *
	 * @param superviseurId the superviseur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commercial
	 * @throws NoSuchCommercialException if a matching commercial could not be found
	 */
	public Commercial findBySuperviseurId_Last(
			long superviseurId,
			com.liferay.portal.kernel.util.OrderByComparator<Commercial>
				orderByComparator)
		throws NoSuchCommercialException;

	/**
	 * Returns the last commercial in the ordered set where superviseurId = &#63;.
	 *
	 * @param superviseurId the superviseur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commercial, or <code>null</code> if a matching commercial could not be found
	 */
	public Commercial fetchBySuperviseurId_Last(
		long superviseurId,
		com.liferay.portal.kernel.util.OrderByComparator<Commercial>
			orderByComparator);

	/**
	 * Returns the commercials before and after the current commercial in the ordered set where superviseurId = &#63;.
	 *
	 * @param id the primary key of the current commercial
	 * @param superviseurId the superviseur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commercial
	 * @throws NoSuchCommercialException if a commercial with the primary key could not be found
	 */
	public Commercial[] findBySuperviseurId_PrevAndNext(
			long id, long superviseurId,
			com.liferay.portal.kernel.util.OrderByComparator<Commercial>
				orderByComparator)
		throws NoSuchCommercialException;

	/**
	 * Removes all the commercials where superviseurId = &#63; from the database.
	 *
	 * @param superviseurId the superviseur ID
	 */
	public void removeBySuperviseurId(long superviseurId);

	/**
	 * Returns the number of commercials where superviseurId = &#63;.
	 *
	 * @param superviseurId the superviseur ID
	 * @return the number of matching commercials
	 */
	public int countBySuperviseurId(long superviseurId);

	/**
	 * Returns all the commercials where statut = &#63;.
	 *
	 * @param statut the statut
	 * @return the matching commercials
	 */
	public java.util.List<Commercial> findByStatut(String statut);

	/**
	 * Returns a range of all the commercials where statut = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercialModelImpl</code>.
	 * </p>
	 *
	 * @param statut the statut
	 * @param start the lower bound of the range of commercials
	 * @param end the upper bound of the range of commercials (not inclusive)
	 * @return the range of matching commercials
	 */
	public java.util.List<Commercial> findByStatut(
		String statut, int start, int end);

	/**
	 * Returns an ordered range of all the commercials where statut = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercialModelImpl</code>.
	 * </p>
	 *
	 * @param statut the statut
	 * @param start the lower bound of the range of commercials
	 * @param end the upper bound of the range of commercials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commercials
	 */
	public java.util.List<Commercial> findByStatut(
		String statut, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Commercial>
			orderByComparator);

	/**
	 * Returns an ordered range of all the commercials where statut = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercialModelImpl</code>.
	 * </p>
	 *
	 * @param statut the statut
	 * @param start the lower bound of the range of commercials
	 * @param end the upper bound of the range of commercials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commercials
	 */
	public java.util.List<Commercial> findByStatut(
		String statut, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Commercial>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first commercial in the ordered set where statut = &#63;.
	 *
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commercial
	 * @throws NoSuchCommercialException if a matching commercial could not be found
	 */
	public Commercial findByStatut_First(
			String statut,
			com.liferay.portal.kernel.util.OrderByComparator<Commercial>
				orderByComparator)
		throws NoSuchCommercialException;

	/**
	 * Returns the first commercial in the ordered set where statut = &#63;.
	 *
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commercial, or <code>null</code> if a matching commercial could not be found
	 */
	public Commercial fetchByStatut_First(
		String statut,
		com.liferay.portal.kernel.util.OrderByComparator<Commercial>
			orderByComparator);

	/**
	 * Returns the last commercial in the ordered set where statut = &#63;.
	 *
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commercial
	 * @throws NoSuchCommercialException if a matching commercial could not be found
	 */
	public Commercial findByStatut_Last(
			String statut,
			com.liferay.portal.kernel.util.OrderByComparator<Commercial>
				orderByComparator)
		throws NoSuchCommercialException;

	/**
	 * Returns the last commercial in the ordered set where statut = &#63;.
	 *
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commercial, or <code>null</code> if a matching commercial could not be found
	 */
	public Commercial fetchByStatut_Last(
		String statut,
		com.liferay.portal.kernel.util.OrderByComparator<Commercial>
			orderByComparator);

	/**
	 * Returns the commercials before and after the current commercial in the ordered set where statut = &#63;.
	 *
	 * @param id the primary key of the current commercial
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commercial
	 * @throws NoSuchCommercialException if a commercial with the primary key could not be found
	 */
	public Commercial[] findByStatut_PrevAndNext(
			long id, String statut,
			com.liferay.portal.kernel.util.OrderByComparator<Commercial>
				orderByComparator)
		throws NoSuchCommercialException;

	/**
	 * Removes all the commercials where statut = &#63; from the database.
	 *
	 * @param statut the statut
	 */
	public void removeByStatut(String statut);

	/**
	 * Returns the number of commercials where statut = &#63;.
	 *
	 * @param statut the statut
	 * @return the number of matching commercials
	 */
	public int countByStatut(String statut);

	/**
	 * Caches the commercial in the entity cache if it is enabled.
	 *
	 * @param commercial the commercial
	 */
	public void cacheResult(Commercial commercial);

	/**
	 * Caches the commercials in the entity cache if it is enabled.
	 *
	 * @param commercials the commercials
	 */
	public void cacheResult(java.util.List<Commercial> commercials);

	/**
	 * Creates a new commercial with the primary key. Does not add the commercial to the database.
	 *
	 * @param id the primary key for the new commercial
	 * @return the new commercial
	 */
	public Commercial create(long id);

	/**
	 * Removes the commercial with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the commercial
	 * @return the commercial that was removed
	 * @throws NoSuchCommercialException if a commercial with the primary key could not be found
	 */
	public Commercial remove(long id) throws NoSuchCommercialException;

	public Commercial updateImpl(Commercial commercial);

	/**
	 * Returns the commercial with the primary key or throws a <code>NoSuchCommercialException</code> if it could not be found.
	 *
	 * @param id the primary key of the commercial
	 * @return the commercial
	 * @throws NoSuchCommercialException if a commercial with the primary key could not be found
	 */
	public Commercial findByPrimaryKey(long id)
		throws NoSuchCommercialException;

	/**
	 * Returns the commercial with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the commercial
	 * @return the commercial, or <code>null</code> if a commercial with the primary key could not be found
	 */
	public Commercial fetchByPrimaryKey(long id);

	/**
	 * Returns all the commercials.
	 *
	 * @return the commercials
	 */
	public java.util.List<Commercial> findAll();

	/**
	 * Returns a range of all the commercials.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercialModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commercials
	 * @param end the upper bound of the range of commercials (not inclusive)
	 * @return the range of commercials
	 */
	public java.util.List<Commercial> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the commercials.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercialModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commercials
	 * @param end the upper bound of the range of commercials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of commercials
	 */
	public java.util.List<Commercial> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Commercial>
			orderByComparator);

	/**
	 * Returns an ordered range of all the commercials.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercialModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commercials
	 * @param end the upper bound of the range of commercials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of commercials
	 */
	public java.util.List<Commercial> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Commercial>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the commercials from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of commercials.
	 *
	 * @return the number of commercials
	 */
	public int countAll();

}