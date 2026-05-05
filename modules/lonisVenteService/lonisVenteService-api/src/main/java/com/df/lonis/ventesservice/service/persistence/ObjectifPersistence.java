/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence;

import com.df.lonis.ventesservice.exception.NoSuchObjectifException;
import com.df.lonis.ventesservice.model.Objectif;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the objectif service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ObjectifUtil
 * @generated
 */
@ProviderType
public interface ObjectifPersistence extends BasePersistence<Objectif> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ObjectifUtil} to access the objectif persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the objectifs where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @return the matching objectifs
	 */
	public java.util.List<Objectif> findByCommercialId(long commercialId);

	/**
	 * Returns a range of all the objectifs where commercialId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ObjectifModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param start the lower bound of the range of objectifs
	 * @param end the upper bound of the range of objectifs (not inclusive)
	 * @return the range of matching objectifs
	 */
	public java.util.List<Objectif> findByCommercialId(
		long commercialId, int start, int end);

	/**
	 * Returns an ordered range of all the objectifs where commercialId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ObjectifModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param start the lower bound of the range of objectifs
	 * @param end the upper bound of the range of objectifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching objectifs
	 */
	public java.util.List<Objectif> findByCommercialId(
		long commercialId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Objectif>
			orderByComparator);

	/**
	 * Returns an ordered range of all the objectifs where commercialId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ObjectifModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param start the lower bound of the range of objectifs
	 * @param end the upper bound of the range of objectifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching objectifs
	 */
	public java.util.List<Objectif> findByCommercialId(
		long commercialId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Objectif>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first objectif in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching objectif
	 * @throws NoSuchObjectifException if a matching objectif could not be found
	 */
	public Objectif findByCommercialId_First(
			long commercialId,
			com.liferay.portal.kernel.util.OrderByComparator<Objectif>
				orderByComparator)
		throws NoSuchObjectifException;

	/**
	 * Returns the first objectif in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching objectif, or <code>null</code> if a matching objectif could not be found
	 */
	public Objectif fetchByCommercialId_First(
		long commercialId,
		com.liferay.portal.kernel.util.OrderByComparator<Objectif>
			orderByComparator);

	/**
	 * Returns the last objectif in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching objectif
	 * @throws NoSuchObjectifException if a matching objectif could not be found
	 */
	public Objectif findByCommercialId_Last(
			long commercialId,
			com.liferay.portal.kernel.util.OrderByComparator<Objectif>
				orderByComparator)
		throws NoSuchObjectifException;

	/**
	 * Returns the last objectif in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching objectif, or <code>null</code> if a matching objectif could not be found
	 */
	public Objectif fetchByCommercialId_Last(
		long commercialId,
		com.liferay.portal.kernel.util.OrderByComparator<Objectif>
			orderByComparator);

	/**
	 * Returns the objectifs before and after the current objectif in the ordered set where commercialId = &#63;.
	 *
	 * @param id the primary key of the current objectif
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next objectif
	 * @throws NoSuchObjectifException if a objectif with the primary key could not be found
	 */
	public Objectif[] findByCommercialId_PrevAndNext(
			long id, long commercialId,
			com.liferay.portal.kernel.util.OrderByComparator<Objectif>
				orderByComparator)
		throws NoSuchObjectifException;

	/**
	 * Removes all the objectifs where commercialId = &#63; from the database.
	 *
	 * @param commercialId the commercial ID
	 */
	public void removeByCommercialId(long commercialId);

	/**
	 * Returns the number of objectifs where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @return the number of matching objectifs
	 */
	public int countByCommercialId(long commercialId);

	/**
	 * Returns all the objectifs where commercialId = &#63; and annee = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @return the matching objectifs
	 */
	public java.util.List<Objectif> findByC_A(long commercialId, int annee);

	/**
	 * Returns a range of all the objectifs where commercialId = &#63; and annee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ObjectifModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param start the lower bound of the range of objectifs
	 * @param end the upper bound of the range of objectifs (not inclusive)
	 * @return the range of matching objectifs
	 */
	public java.util.List<Objectif> findByC_A(
		long commercialId, int annee, int start, int end);

	/**
	 * Returns an ordered range of all the objectifs where commercialId = &#63; and annee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ObjectifModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param start the lower bound of the range of objectifs
	 * @param end the upper bound of the range of objectifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching objectifs
	 */
	public java.util.List<Objectif> findByC_A(
		long commercialId, int annee, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Objectif>
			orderByComparator);

	/**
	 * Returns an ordered range of all the objectifs where commercialId = &#63; and annee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ObjectifModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param start the lower bound of the range of objectifs
	 * @param end the upper bound of the range of objectifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching objectifs
	 */
	public java.util.List<Objectif> findByC_A(
		long commercialId, int annee, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Objectif>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first objectif in the ordered set where commercialId = &#63; and annee = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching objectif
	 * @throws NoSuchObjectifException if a matching objectif could not be found
	 */
	public Objectif findByC_A_First(
			long commercialId, int annee,
			com.liferay.portal.kernel.util.OrderByComparator<Objectif>
				orderByComparator)
		throws NoSuchObjectifException;

	/**
	 * Returns the first objectif in the ordered set where commercialId = &#63; and annee = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching objectif, or <code>null</code> if a matching objectif could not be found
	 */
	public Objectif fetchByC_A_First(
		long commercialId, int annee,
		com.liferay.portal.kernel.util.OrderByComparator<Objectif>
			orderByComparator);

	/**
	 * Returns the last objectif in the ordered set where commercialId = &#63; and annee = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching objectif
	 * @throws NoSuchObjectifException if a matching objectif could not be found
	 */
	public Objectif findByC_A_Last(
			long commercialId, int annee,
			com.liferay.portal.kernel.util.OrderByComparator<Objectif>
				orderByComparator)
		throws NoSuchObjectifException;

	/**
	 * Returns the last objectif in the ordered set where commercialId = &#63; and annee = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching objectif, or <code>null</code> if a matching objectif could not be found
	 */
	public Objectif fetchByC_A_Last(
		long commercialId, int annee,
		com.liferay.portal.kernel.util.OrderByComparator<Objectif>
			orderByComparator);

	/**
	 * Returns the objectifs before and after the current objectif in the ordered set where commercialId = &#63; and annee = &#63;.
	 *
	 * @param id the primary key of the current objectif
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next objectif
	 * @throws NoSuchObjectifException if a objectif with the primary key could not be found
	 */
	public Objectif[] findByC_A_PrevAndNext(
			long id, long commercialId, int annee,
			com.liferay.portal.kernel.util.OrderByComparator<Objectif>
				orderByComparator)
		throws NoSuchObjectifException;

	/**
	 * Removes all the objectifs where commercialId = &#63; and annee = &#63; from the database.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 */
	public void removeByC_A(long commercialId, int annee);

	/**
	 * Returns the number of objectifs where commercialId = &#63; and annee = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @return the number of matching objectifs
	 */
	public int countByC_A(long commercialId, int annee);

	/**
	 * Returns the objectif where commercialId = &#63; and annee = &#63; and mois = &#63; or throws a <code>NoSuchObjectifException</code> if it could not be found.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param mois the mois
	 * @return the matching objectif
	 * @throws NoSuchObjectifException if a matching objectif could not be found
	 */
	public Objectif findByC_A_M(long commercialId, int annee, int mois)
		throws NoSuchObjectifException;

	/**
	 * Returns the objectif where commercialId = &#63; and annee = &#63; and mois = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param mois the mois
	 * @return the matching objectif, or <code>null</code> if a matching objectif could not be found
	 */
	public Objectif fetchByC_A_M(long commercialId, int annee, int mois);

	/**
	 * Returns the objectif where commercialId = &#63; and annee = &#63; and mois = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param mois the mois
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching objectif, or <code>null</code> if a matching objectif could not be found
	 */
	public Objectif fetchByC_A_M(
		long commercialId, int annee, int mois, boolean useFinderCache);

	/**
	 * Removes the objectif where commercialId = &#63; and annee = &#63; and mois = &#63; from the database.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param mois the mois
	 * @return the objectif that was removed
	 */
	public Objectif removeByC_A_M(long commercialId, int annee, int mois)
		throws NoSuchObjectifException;

	/**
	 * Returns the number of objectifs where commercialId = &#63; and annee = &#63; and mois = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param mois the mois
	 * @return the number of matching objectifs
	 */
	public int countByC_A_M(long commercialId, int annee, int mois);

	/**
	 * Caches the objectif in the entity cache if it is enabled.
	 *
	 * @param objectif the objectif
	 */
	public void cacheResult(Objectif objectif);

	/**
	 * Caches the objectifs in the entity cache if it is enabled.
	 *
	 * @param objectifs the objectifs
	 */
	public void cacheResult(java.util.List<Objectif> objectifs);

	/**
	 * Creates a new objectif with the primary key. Does not add the objectif to the database.
	 *
	 * @param id the primary key for the new objectif
	 * @return the new objectif
	 */
	public Objectif create(long id);

	/**
	 * Removes the objectif with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the objectif
	 * @return the objectif that was removed
	 * @throws NoSuchObjectifException if a objectif with the primary key could not be found
	 */
	public Objectif remove(long id) throws NoSuchObjectifException;

	public Objectif updateImpl(Objectif objectif);

	/**
	 * Returns the objectif with the primary key or throws a <code>NoSuchObjectifException</code> if it could not be found.
	 *
	 * @param id the primary key of the objectif
	 * @return the objectif
	 * @throws NoSuchObjectifException if a objectif with the primary key could not be found
	 */
	public Objectif findByPrimaryKey(long id) throws NoSuchObjectifException;

	/**
	 * Returns the objectif with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the objectif
	 * @return the objectif, or <code>null</code> if a objectif with the primary key could not be found
	 */
	public Objectif fetchByPrimaryKey(long id);

	/**
	 * Returns all the objectifs.
	 *
	 * @return the objectifs
	 */
	public java.util.List<Objectif> findAll();

	/**
	 * Returns a range of all the objectifs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ObjectifModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of objectifs
	 * @param end the upper bound of the range of objectifs (not inclusive)
	 * @return the range of objectifs
	 */
	public java.util.List<Objectif> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the objectifs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ObjectifModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of objectifs
	 * @param end the upper bound of the range of objectifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of objectifs
	 */
	public java.util.List<Objectif> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Objectif>
			orderByComparator);

	/**
	 * Returns an ordered range of all the objectifs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ObjectifModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of objectifs
	 * @param end the upper bound of the range of objectifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of objectifs
	 */
	public java.util.List<Objectif> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Objectif>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the objectifs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of objectifs.
	 *
	 * @return the number of objectifs
	 */
	public int countAll();

}