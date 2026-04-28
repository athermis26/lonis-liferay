/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link SiteLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SiteLocalService
 * @generated
 */
public class SiteLocalServiceWrapper
	implements ServiceWrapper<SiteLocalService>, SiteLocalService {

	public SiteLocalServiceWrapper() {
		this(null);
	}

	public SiteLocalServiceWrapper(SiteLocalService siteLocalService) {
		_siteLocalService = siteLocalService;
	}

	/**
	 * Adds the site to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SiteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param site the site
	 * @return the site that was added
	 */
	@Override
	public com.df.lonis.ventesservice.model.Site addSite(
		com.df.lonis.ventesservice.model.Site site) {

		return _siteLocalService.addSite(site);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _siteLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new site with the primary key. Does not add the site to the database.
	 *
	 * @param id the primary key for the new site
	 * @return the new site
	 */
	@Override
	public com.df.lonis.ventesservice.model.Site createSite(long id) {
		return _siteLocalService.createSite(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _siteLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the site with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SiteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the site
	 * @return the site that was removed
	 * @throws PortalException if a site with the primary key could not be found
	 */
	@Override
	public com.df.lonis.ventesservice.model.Site deleteSite(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _siteLocalService.deleteSite(id);
	}

	/**
	 * Deletes the site from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SiteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param site the site
	 * @return the site that was removed
	 */
	@Override
	public com.df.lonis.ventesservice.model.Site deleteSite(
		com.df.lonis.ventesservice.model.Site site) {

		return _siteLocalService.deleteSite(site);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _siteLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _siteLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _siteLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _siteLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.df.lonis.ventesservice.model.impl.SiteModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _siteLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.df.lonis.ventesservice.model.impl.SiteModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _siteLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _siteLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _siteLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.df.lonis.ventesservice.model.Site fetchSite(long id) {
		return _siteLocalService.fetchSite(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _siteLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _siteLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _siteLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _siteLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the site with the primary key.
	 *
	 * @param id the primary key of the site
	 * @return the site
	 * @throws PortalException if a site with the primary key could not be found
	 */
	@Override
	public com.df.lonis.ventesservice.model.Site getSite(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _siteLocalService.getSite(id);
	}

	/**
	 * Returns a range of all the sites.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.df.lonis.ventesservice.model.impl.SiteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sites
	 * @param end the upper bound of the range of sites (not inclusive)
	 * @return the range of sites
	 */
	@Override
	public java.util.List<com.df.lonis.ventesservice.model.Site> getSites(
		int start, int end) {

		return _siteLocalService.getSites(start, end);
	}

	/**
	 * Returns the number of sites.
	 *
	 * @return the number of sites
	 */
	@Override
	public int getSitesCount() {
		return _siteLocalService.getSitesCount();
	}

	/**
	 * Updates the site in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SiteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param site the site
	 * @return the site that was updated
	 */
	@Override
	public com.df.lonis.ventesservice.model.Site updateSite(
		com.df.lonis.ventesservice.model.Site site) {

		return _siteLocalService.updateSite(site);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _siteLocalService.getBasePersistence();
	}

	@Override
	public SiteLocalService getWrappedService() {
		return _siteLocalService;
	}

	@Override
	public void setWrappedService(SiteLocalService siteLocalService) {
		_siteLocalService = siteLocalService;
	}

	private SiteLocalService _siteLocalService;

}