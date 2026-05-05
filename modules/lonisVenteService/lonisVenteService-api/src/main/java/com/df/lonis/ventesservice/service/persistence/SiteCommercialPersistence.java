/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence;

import com.df.lonis.ventesservice.exception.NoSuchSiteCommercialException;
import com.df.lonis.ventesservice.model.SiteCommercial;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the site commercial service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SiteCommercialUtil
 * @generated
 */
@ProviderType
public interface SiteCommercialPersistence
	extends BasePersistence<SiteCommercial> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SiteCommercialUtil} to access the site commercial persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the site commercials where siteId = &#63;.
	 *
	 * @param siteId the site ID
	 * @return the matching site commercials
	 */
	public java.util.List<SiteCommercial> findBySiteId(long siteId);

	/**
	 * Returns a range of all the site commercials where siteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SiteCommercialModelImpl</code>.
	 * </p>
	 *
	 * @param siteId the site ID
	 * @param start the lower bound of the range of site commercials
	 * @param end the upper bound of the range of site commercials (not inclusive)
	 * @return the range of matching site commercials
	 */
	public java.util.List<SiteCommercial> findBySiteId(
		long siteId, int start, int end);

	/**
	 * Returns an ordered range of all the site commercials where siteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SiteCommercialModelImpl</code>.
	 * </p>
	 *
	 * @param siteId the site ID
	 * @param start the lower bound of the range of site commercials
	 * @param end the upper bound of the range of site commercials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching site commercials
	 */
	public java.util.List<SiteCommercial> findBySiteId(
		long siteId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SiteCommercial>
			orderByComparator);

	/**
	 * Returns an ordered range of all the site commercials where siteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SiteCommercialModelImpl</code>.
	 * </p>
	 *
	 * @param siteId the site ID
	 * @param start the lower bound of the range of site commercials
	 * @param end the upper bound of the range of site commercials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching site commercials
	 */
	public java.util.List<SiteCommercial> findBySiteId(
		long siteId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SiteCommercial>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first site commercial in the ordered set where siteId = &#63;.
	 *
	 * @param siteId the site ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching site commercial
	 * @throws NoSuchSiteCommercialException if a matching site commercial could not be found
	 */
	public SiteCommercial findBySiteId_First(
			long siteId,
			com.liferay.portal.kernel.util.OrderByComparator<SiteCommercial>
				orderByComparator)
		throws NoSuchSiteCommercialException;

	/**
	 * Returns the first site commercial in the ordered set where siteId = &#63;.
	 *
	 * @param siteId the site ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching site commercial, or <code>null</code> if a matching site commercial could not be found
	 */
	public SiteCommercial fetchBySiteId_First(
		long siteId,
		com.liferay.portal.kernel.util.OrderByComparator<SiteCommercial>
			orderByComparator);

	/**
	 * Returns the last site commercial in the ordered set where siteId = &#63;.
	 *
	 * @param siteId the site ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching site commercial
	 * @throws NoSuchSiteCommercialException if a matching site commercial could not be found
	 */
	public SiteCommercial findBySiteId_Last(
			long siteId,
			com.liferay.portal.kernel.util.OrderByComparator<SiteCommercial>
				orderByComparator)
		throws NoSuchSiteCommercialException;

	/**
	 * Returns the last site commercial in the ordered set where siteId = &#63;.
	 *
	 * @param siteId the site ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching site commercial, or <code>null</code> if a matching site commercial could not be found
	 */
	public SiteCommercial fetchBySiteId_Last(
		long siteId,
		com.liferay.portal.kernel.util.OrderByComparator<SiteCommercial>
			orderByComparator);

	/**
	 * Returns the site commercials before and after the current site commercial in the ordered set where siteId = &#63;.
	 *
	 * @param id the primary key of the current site commercial
	 * @param siteId the site ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next site commercial
	 * @throws NoSuchSiteCommercialException if a site commercial with the primary key could not be found
	 */
	public SiteCommercial[] findBySiteId_PrevAndNext(
			long id, long siteId,
			com.liferay.portal.kernel.util.OrderByComparator<SiteCommercial>
				orderByComparator)
		throws NoSuchSiteCommercialException;

	/**
	 * Removes all the site commercials where siteId = &#63; from the database.
	 *
	 * @param siteId the site ID
	 */
	public void removeBySiteId(long siteId);

	/**
	 * Returns the number of site commercials where siteId = &#63;.
	 *
	 * @param siteId the site ID
	 * @return the number of matching site commercials
	 */
	public int countBySiteId(long siteId);

	/**
	 * Returns all the site commercials where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @return the matching site commercials
	 */
	public java.util.List<SiteCommercial> findByCommercialId(long commercialId);

	/**
	 * Returns a range of all the site commercials where commercialId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SiteCommercialModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param start the lower bound of the range of site commercials
	 * @param end the upper bound of the range of site commercials (not inclusive)
	 * @return the range of matching site commercials
	 */
	public java.util.List<SiteCommercial> findByCommercialId(
		long commercialId, int start, int end);

	/**
	 * Returns an ordered range of all the site commercials where commercialId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SiteCommercialModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param start the lower bound of the range of site commercials
	 * @param end the upper bound of the range of site commercials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching site commercials
	 */
	public java.util.List<SiteCommercial> findByCommercialId(
		long commercialId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SiteCommercial>
			orderByComparator);

	/**
	 * Returns an ordered range of all the site commercials where commercialId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SiteCommercialModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param start the lower bound of the range of site commercials
	 * @param end the upper bound of the range of site commercials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching site commercials
	 */
	public java.util.List<SiteCommercial> findByCommercialId(
		long commercialId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SiteCommercial>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first site commercial in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching site commercial
	 * @throws NoSuchSiteCommercialException if a matching site commercial could not be found
	 */
	public SiteCommercial findByCommercialId_First(
			long commercialId,
			com.liferay.portal.kernel.util.OrderByComparator<SiteCommercial>
				orderByComparator)
		throws NoSuchSiteCommercialException;

	/**
	 * Returns the first site commercial in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching site commercial, or <code>null</code> if a matching site commercial could not be found
	 */
	public SiteCommercial fetchByCommercialId_First(
		long commercialId,
		com.liferay.portal.kernel.util.OrderByComparator<SiteCommercial>
			orderByComparator);

	/**
	 * Returns the last site commercial in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching site commercial
	 * @throws NoSuchSiteCommercialException if a matching site commercial could not be found
	 */
	public SiteCommercial findByCommercialId_Last(
			long commercialId,
			com.liferay.portal.kernel.util.OrderByComparator<SiteCommercial>
				orderByComparator)
		throws NoSuchSiteCommercialException;

	/**
	 * Returns the last site commercial in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching site commercial, or <code>null</code> if a matching site commercial could not be found
	 */
	public SiteCommercial fetchByCommercialId_Last(
		long commercialId,
		com.liferay.portal.kernel.util.OrderByComparator<SiteCommercial>
			orderByComparator);

	/**
	 * Returns the site commercials before and after the current site commercial in the ordered set where commercialId = &#63;.
	 *
	 * @param id the primary key of the current site commercial
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next site commercial
	 * @throws NoSuchSiteCommercialException if a site commercial with the primary key could not be found
	 */
	public SiteCommercial[] findByCommercialId_PrevAndNext(
			long id, long commercialId,
			com.liferay.portal.kernel.util.OrderByComparator<SiteCommercial>
				orderByComparator)
		throws NoSuchSiteCommercialException;

	/**
	 * Removes all the site commercials where commercialId = &#63; from the database.
	 *
	 * @param commercialId the commercial ID
	 */
	public void removeByCommercialId(long commercialId);

	/**
	 * Returns the number of site commercials where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @return the number of matching site commercials
	 */
	public int countByCommercialId(long commercialId);

	/**
	 * Returns the site commercial where siteId = &#63; and commercialId = &#63; or throws a <code>NoSuchSiteCommercialException</code> if it could not be found.
	 *
	 * @param siteId the site ID
	 * @param commercialId the commercial ID
	 * @return the matching site commercial
	 * @throws NoSuchSiteCommercialException if a matching site commercial could not be found
	 */
	public SiteCommercial findByS_C(long siteId, long commercialId)
		throws NoSuchSiteCommercialException;

	/**
	 * Returns the site commercial where siteId = &#63; and commercialId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param siteId the site ID
	 * @param commercialId the commercial ID
	 * @return the matching site commercial, or <code>null</code> if a matching site commercial could not be found
	 */
	public SiteCommercial fetchByS_C(long siteId, long commercialId);

	/**
	 * Returns the site commercial where siteId = &#63; and commercialId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param siteId the site ID
	 * @param commercialId the commercial ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching site commercial, or <code>null</code> if a matching site commercial could not be found
	 */
	public SiteCommercial fetchByS_C(
		long siteId, long commercialId, boolean useFinderCache);

	/**
	 * Removes the site commercial where siteId = &#63; and commercialId = &#63; from the database.
	 *
	 * @param siteId the site ID
	 * @param commercialId the commercial ID
	 * @return the site commercial that was removed
	 */
	public SiteCommercial removeByS_C(long siteId, long commercialId)
		throws NoSuchSiteCommercialException;

	/**
	 * Returns the number of site commercials where siteId = &#63; and commercialId = &#63;.
	 *
	 * @param siteId the site ID
	 * @param commercialId the commercial ID
	 * @return the number of matching site commercials
	 */
	public int countByS_C(long siteId, long commercialId);

	/**
	 * Caches the site commercial in the entity cache if it is enabled.
	 *
	 * @param siteCommercial the site commercial
	 */
	public void cacheResult(SiteCommercial siteCommercial);

	/**
	 * Caches the site commercials in the entity cache if it is enabled.
	 *
	 * @param siteCommercials the site commercials
	 */
	public void cacheResult(java.util.List<SiteCommercial> siteCommercials);

	/**
	 * Creates a new site commercial with the primary key. Does not add the site commercial to the database.
	 *
	 * @param id the primary key for the new site commercial
	 * @return the new site commercial
	 */
	public SiteCommercial create(long id);

	/**
	 * Removes the site commercial with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the site commercial
	 * @return the site commercial that was removed
	 * @throws NoSuchSiteCommercialException if a site commercial with the primary key could not be found
	 */
	public SiteCommercial remove(long id) throws NoSuchSiteCommercialException;

	public SiteCommercial updateImpl(SiteCommercial siteCommercial);

	/**
	 * Returns the site commercial with the primary key or throws a <code>NoSuchSiteCommercialException</code> if it could not be found.
	 *
	 * @param id the primary key of the site commercial
	 * @return the site commercial
	 * @throws NoSuchSiteCommercialException if a site commercial with the primary key could not be found
	 */
	public SiteCommercial findByPrimaryKey(long id)
		throws NoSuchSiteCommercialException;

	/**
	 * Returns the site commercial with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the site commercial
	 * @return the site commercial, or <code>null</code> if a site commercial with the primary key could not be found
	 */
	public SiteCommercial fetchByPrimaryKey(long id);

	/**
	 * Returns all the site commercials.
	 *
	 * @return the site commercials
	 */
	public java.util.List<SiteCommercial> findAll();

	/**
	 * Returns a range of all the site commercials.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SiteCommercialModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of site commercials
	 * @param end the upper bound of the range of site commercials (not inclusive)
	 * @return the range of site commercials
	 */
	public java.util.List<SiteCommercial> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the site commercials.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SiteCommercialModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of site commercials
	 * @param end the upper bound of the range of site commercials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of site commercials
	 */
	public java.util.List<SiteCommercial> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SiteCommercial>
			orderByComparator);

	/**
	 * Returns an ordered range of all the site commercials.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SiteCommercialModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of site commercials
	 * @param end the upper bound of the range of site commercials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of site commercials
	 */
	public java.util.List<SiteCommercial> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SiteCommercial>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the site commercials from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of site commercials.
	 *
	 * @return the number of site commercials
	 */
	public int countAll();

}