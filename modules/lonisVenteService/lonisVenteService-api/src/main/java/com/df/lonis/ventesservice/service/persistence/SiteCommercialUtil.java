/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence;

import com.df.lonis.ventesservice.model.SiteCommercial;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the site commercial service. This utility wraps <code>com.df.lonis.ventesservice.service.persistence.impl.SiteCommercialPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SiteCommercialPersistence
 * @generated
 */
public class SiteCommercialUtil {

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
	public static void clearCache(SiteCommercial siteCommercial) {
		getPersistence().clearCache(siteCommercial);
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
	public static Map<Serializable, SiteCommercial> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SiteCommercial> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SiteCommercial> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SiteCommercial> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SiteCommercial> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SiteCommercial update(SiteCommercial siteCommercial) {
		return getPersistence().update(siteCommercial);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SiteCommercial update(
		SiteCommercial siteCommercial, ServiceContext serviceContext) {

		return getPersistence().update(siteCommercial, serviceContext);
	}

	/**
	 * Returns all the site commercials where siteId = &#63;.
	 *
	 * @param siteId the site ID
	 * @return the matching site commercials
	 */
	public static List<SiteCommercial> findBySiteId(long siteId) {
		return getPersistence().findBySiteId(siteId);
	}

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
	public static List<SiteCommercial> findBySiteId(
		long siteId, int start, int end) {

		return getPersistence().findBySiteId(siteId, start, end);
	}

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
	public static List<SiteCommercial> findBySiteId(
		long siteId, int start, int end,
		OrderByComparator<SiteCommercial> orderByComparator) {

		return getPersistence().findBySiteId(
			siteId, start, end, orderByComparator);
	}

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
	public static List<SiteCommercial> findBySiteId(
		long siteId, int start, int end,
		OrderByComparator<SiteCommercial> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySiteId(
			siteId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first site commercial in the ordered set where siteId = &#63;.
	 *
	 * @param siteId the site ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching site commercial
	 * @throws NoSuchSiteCommercialException if a matching site commercial could not be found
	 */
	public static SiteCommercial findBySiteId_First(
			long siteId, OrderByComparator<SiteCommercial> orderByComparator)
		throws com.df.lonis.ventesservice.exception.
			NoSuchSiteCommercialException {

		return getPersistence().findBySiteId_First(siteId, orderByComparator);
	}

	/**
	 * Returns the first site commercial in the ordered set where siteId = &#63;.
	 *
	 * @param siteId the site ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching site commercial, or <code>null</code> if a matching site commercial could not be found
	 */
	public static SiteCommercial fetchBySiteId_First(
		long siteId, OrderByComparator<SiteCommercial> orderByComparator) {

		return getPersistence().fetchBySiteId_First(siteId, orderByComparator);
	}

	/**
	 * Returns the last site commercial in the ordered set where siteId = &#63;.
	 *
	 * @param siteId the site ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching site commercial
	 * @throws NoSuchSiteCommercialException if a matching site commercial could not be found
	 */
	public static SiteCommercial findBySiteId_Last(
			long siteId, OrderByComparator<SiteCommercial> orderByComparator)
		throws com.df.lonis.ventesservice.exception.
			NoSuchSiteCommercialException {

		return getPersistence().findBySiteId_Last(siteId, orderByComparator);
	}

	/**
	 * Returns the last site commercial in the ordered set where siteId = &#63;.
	 *
	 * @param siteId the site ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching site commercial, or <code>null</code> if a matching site commercial could not be found
	 */
	public static SiteCommercial fetchBySiteId_Last(
		long siteId, OrderByComparator<SiteCommercial> orderByComparator) {

		return getPersistence().fetchBySiteId_Last(siteId, orderByComparator);
	}

	/**
	 * Returns the site commercials before and after the current site commercial in the ordered set where siteId = &#63;.
	 *
	 * @param id the primary key of the current site commercial
	 * @param siteId the site ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next site commercial
	 * @throws NoSuchSiteCommercialException if a site commercial with the primary key could not be found
	 */
	public static SiteCommercial[] findBySiteId_PrevAndNext(
			long id, long siteId,
			OrderByComparator<SiteCommercial> orderByComparator)
		throws com.df.lonis.ventesservice.exception.
			NoSuchSiteCommercialException {

		return getPersistence().findBySiteId_PrevAndNext(
			id, siteId, orderByComparator);
	}

	/**
	 * Removes all the site commercials where siteId = &#63; from the database.
	 *
	 * @param siteId the site ID
	 */
	public static void removeBySiteId(long siteId) {
		getPersistence().removeBySiteId(siteId);
	}

	/**
	 * Returns the number of site commercials where siteId = &#63;.
	 *
	 * @param siteId the site ID
	 * @return the number of matching site commercials
	 */
	public static int countBySiteId(long siteId) {
		return getPersistence().countBySiteId(siteId);
	}

	/**
	 * Returns all the site commercials where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @return the matching site commercials
	 */
	public static List<SiteCommercial> findByCommercialId(long commercialId) {
		return getPersistence().findByCommercialId(commercialId);
	}

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
	public static List<SiteCommercial> findByCommercialId(
		long commercialId, int start, int end) {

		return getPersistence().findByCommercialId(commercialId, start, end);
	}

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
	public static List<SiteCommercial> findByCommercialId(
		long commercialId, int start, int end,
		OrderByComparator<SiteCommercial> orderByComparator) {

		return getPersistence().findByCommercialId(
			commercialId, start, end, orderByComparator);
	}

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
	public static List<SiteCommercial> findByCommercialId(
		long commercialId, int start, int end,
		OrderByComparator<SiteCommercial> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCommercialId(
			commercialId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first site commercial in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching site commercial
	 * @throws NoSuchSiteCommercialException if a matching site commercial could not be found
	 */
	public static SiteCommercial findByCommercialId_First(
			long commercialId,
			OrderByComparator<SiteCommercial> orderByComparator)
		throws com.df.lonis.ventesservice.exception.
			NoSuchSiteCommercialException {

		return getPersistence().findByCommercialId_First(
			commercialId, orderByComparator);
	}

	/**
	 * Returns the first site commercial in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching site commercial, or <code>null</code> if a matching site commercial could not be found
	 */
	public static SiteCommercial fetchByCommercialId_First(
		long commercialId,
		OrderByComparator<SiteCommercial> orderByComparator) {

		return getPersistence().fetchByCommercialId_First(
			commercialId, orderByComparator);
	}

	/**
	 * Returns the last site commercial in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching site commercial
	 * @throws NoSuchSiteCommercialException if a matching site commercial could not be found
	 */
	public static SiteCommercial findByCommercialId_Last(
			long commercialId,
			OrderByComparator<SiteCommercial> orderByComparator)
		throws com.df.lonis.ventesservice.exception.
			NoSuchSiteCommercialException {

		return getPersistence().findByCommercialId_Last(
			commercialId, orderByComparator);
	}

	/**
	 * Returns the last site commercial in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching site commercial, or <code>null</code> if a matching site commercial could not be found
	 */
	public static SiteCommercial fetchByCommercialId_Last(
		long commercialId,
		OrderByComparator<SiteCommercial> orderByComparator) {

		return getPersistence().fetchByCommercialId_Last(
			commercialId, orderByComparator);
	}

	/**
	 * Returns the site commercials before and after the current site commercial in the ordered set where commercialId = &#63;.
	 *
	 * @param id the primary key of the current site commercial
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next site commercial
	 * @throws NoSuchSiteCommercialException if a site commercial with the primary key could not be found
	 */
	public static SiteCommercial[] findByCommercialId_PrevAndNext(
			long id, long commercialId,
			OrderByComparator<SiteCommercial> orderByComparator)
		throws com.df.lonis.ventesservice.exception.
			NoSuchSiteCommercialException {

		return getPersistence().findByCommercialId_PrevAndNext(
			id, commercialId, orderByComparator);
	}

	/**
	 * Removes all the site commercials where commercialId = &#63; from the database.
	 *
	 * @param commercialId the commercial ID
	 */
	public static void removeByCommercialId(long commercialId) {
		getPersistence().removeByCommercialId(commercialId);
	}

	/**
	 * Returns the number of site commercials where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @return the number of matching site commercials
	 */
	public static int countByCommercialId(long commercialId) {
		return getPersistence().countByCommercialId(commercialId);
	}

	/**
	 * Returns the site commercial where siteId = &#63; and commercialId = &#63; or throws a <code>NoSuchSiteCommercialException</code> if it could not be found.
	 *
	 * @param siteId the site ID
	 * @param commercialId the commercial ID
	 * @return the matching site commercial
	 * @throws NoSuchSiteCommercialException if a matching site commercial could not be found
	 */
	public static SiteCommercial findByS_C(long siteId, long commercialId)
		throws com.df.lonis.ventesservice.exception.
			NoSuchSiteCommercialException {

		return getPersistence().findByS_C(siteId, commercialId);
	}

	/**
	 * Returns the site commercial where siteId = &#63; and commercialId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param siteId the site ID
	 * @param commercialId the commercial ID
	 * @return the matching site commercial, or <code>null</code> if a matching site commercial could not be found
	 */
	public static SiteCommercial fetchByS_C(long siteId, long commercialId) {
		return getPersistence().fetchByS_C(siteId, commercialId);
	}

	/**
	 * Returns the site commercial where siteId = &#63; and commercialId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param siteId the site ID
	 * @param commercialId the commercial ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching site commercial, or <code>null</code> if a matching site commercial could not be found
	 */
	public static SiteCommercial fetchByS_C(
		long siteId, long commercialId, boolean useFinderCache) {

		return getPersistence().fetchByS_C(
			siteId, commercialId, useFinderCache);
	}

	/**
	 * Removes the site commercial where siteId = &#63; and commercialId = &#63; from the database.
	 *
	 * @param siteId the site ID
	 * @param commercialId the commercial ID
	 * @return the site commercial that was removed
	 */
	public static SiteCommercial removeByS_C(long siteId, long commercialId)
		throws com.df.lonis.ventesservice.exception.
			NoSuchSiteCommercialException {

		return getPersistence().removeByS_C(siteId, commercialId);
	}

	/**
	 * Returns the number of site commercials where siteId = &#63; and commercialId = &#63;.
	 *
	 * @param siteId the site ID
	 * @param commercialId the commercial ID
	 * @return the number of matching site commercials
	 */
	public static int countByS_C(long siteId, long commercialId) {
		return getPersistence().countByS_C(siteId, commercialId);
	}

	/**
	 * Caches the site commercial in the entity cache if it is enabled.
	 *
	 * @param siteCommercial the site commercial
	 */
	public static void cacheResult(SiteCommercial siteCommercial) {
		getPersistence().cacheResult(siteCommercial);
	}

	/**
	 * Caches the site commercials in the entity cache if it is enabled.
	 *
	 * @param siteCommercials the site commercials
	 */
	public static void cacheResult(List<SiteCommercial> siteCommercials) {
		getPersistence().cacheResult(siteCommercials);
	}

	/**
	 * Creates a new site commercial with the primary key. Does not add the site commercial to the database.
	 *
	 * @param id the primary key for the new site commercial
	 * @return the new site commercial
	 */
	public static SiteCommercial create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the site commercial with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the site commercial
	 * @return the site commercial that was removed
	 * @throws NoSuchSiteCommercialException if a site commercial with the primary key could not be found
	 */
	public static SiteCommercial remove(long id)
		throws com.df.lonis.ventesservice.exception.
			NoSuchSiteCommercialException {

		return getPersistence().remove(id);
	}

	public static SiteCommercial updateImpl(SiteCommercial siteCommercial) {
		return getPersistence().updateImpl(siteCommercial);
	}

	/**
	 * Returns the site commercial with the primary key or throws a <code>NoSuchSiteCommercialException</code> if it could not be found.
	 *
	 * @param id the primary key of the site commercial
	 * @return the site commercial
	 * @throws NoSuchSiteCommercialException if a site commercial with the primary key could not be found
	 */
	public static SiteCommercial findByPrimaryKey(long id)
		throws com.df.lonis.ventesservice.exception.
			NoSuchSiteCommercialException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the site commercial with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the site commercial
	 * @return the site commercial, or <code>null</code> if a site commercial with the primary key could not be found
	 */
	public static SiteCommercial fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the site commercials.
	 *
	 * @return the site commercials
	 */
	public static List<SiteCommercial> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<SiteCommercial> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<SiteCommercial> findAll(
		int start, int end,
		OrderByComparator<SiteCommercial> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<SiteCommercial> findAll(
		int start, int end, OrderByComparator<SiteCommercial> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the site commercials from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of site commercials.
	 *
	 * @return the number of site commercials
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SiteCommercialPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(SiteCommercialPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile SiteCommercialPersistence _persistence;

}