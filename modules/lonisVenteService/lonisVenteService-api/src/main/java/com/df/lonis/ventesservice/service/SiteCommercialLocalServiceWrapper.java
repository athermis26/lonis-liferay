/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link SiteCommercialLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SiteCommercialLocalService
 * @generated
 */
public class SiteCommercialLocalServiceWrapper
	implements ServiceWrapper<SiteCommercialLocalService>,
			   SiteCommercialLocalService {

	public SiteCommercialLocalServiceWrapper() {
		this(null);
	}

	public SiteCommercialLocalServiceWrapper(
		SiteCommercialLocalService siteCommercialLocalService) {

		_siteCommercialLocalService = siteCommercialLocalService;
	}

	/**
	 * Adds the site commercial to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SiteCommercialLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param siteCommercial the site commercial
	 * @return the site commercial that was added
	 */
	@Override
	public com.df.lonis.ventesservice.model.SiteCommercial addSiteCommercial(
		com.df.lonis.ventesservice.model.SiteCommercial siteCommercial) {

		return _siteCommercialLocalService.addSiteCommercial(siteCommercial);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _siteCommercialLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new site commercial with the primary key. Does not add the site commercial to the database.
	 *
	 * @param id the primary key for the new site commercial
	 * @return the new site commercial
	 */
	@Override
	public com.df.lonis.ventesservice.model.SiteCommercial createSiteCommercial(
		long id) {

		return _siteCommercialLocalService.createSiteCommercial(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _siteCommercialLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the site commercial with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SiteCommercialLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the site commercial
	 * @return the site commercial that was removed
	 * @throws PortalException if a site commercial with the primary key could not be found
	 */
	@Override
	public com.df.lonis.ventesservice.model.SiteCommercial deleteSiteCommercial(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _siteCommercialLocalService.deleteSiteCommercial(id);
	}

	/**
	 * Deletes the site commercial from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SiteCommercialLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param siteCommercial the site commercial
	 * @return the site commercial that was removed
	 */
	@Override
	public com.df.lonis.ventesservice.model.SiteCommercial deleteSiteCommercial(
		com.df.lonis.ventesservice.model.SiteCommercial siteCommercial) {

		return _siteCommercialLocalService.deleteSiteCommercial(siteCommercial);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _siteCommercialLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _siteCommercialLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _siteCommercialLocalService.dynamicQuery();
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

		return _siteCommercialLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.df.lonis.ventesservice.model.impl.SiteCommercialModelImpl</code>.
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

		return _siteCommercialLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.df.lonis.ventesservice.model.impl.SiteCommercialModelImpl</code>.
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

		return _siteCommercialLocalService.dynamicQuery(
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

		return _siteCommercialLocalService.dynamicQueryCount(dynamicQuery);
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

		return _siteCommercialLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.df.lonis.ventesservice.model.SiteCommercial fetchByS_C(
		long siteId, long commercialId) {

		return _siteCommercialLocalService.fetchByS_C(siteId, commercialId);
	}

	@Override
	public com.df.lonis.ventesservice.model.SiteCommercial fetchSiteCommercial(
		long id) {

		return _siteCommercialLocalService.fetchSiteCommercial(id);
	}

	@Override
	public java.util.List<com.df.lonis.ventesservice.model.SiteCommercial>
		findByCommercialId(long commercialId) {

		return _siteCommercialLocalService.findByCommercialId(commercialId);
	}

	@Override
	public java.util.List<com.df.lonis.ventesservice.model.SiteCommercial>
		findBySiteId(long siteId) {

		return _siteCommercialLocalService.findBySiteId(siteId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _siteCommercialLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _siteCommercialLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _siteCommercialLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _siteCommercialLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the site commercial with the primary key.
	 *
	 * @param id the primary key of the site commercial
	 * @return the site commercial
	 * @throws PortalException if a site commercial with the primary key could not be found
	 */
	@Override
	public com.df.lonis.ventesservice.model.SiteCommercial getSiteCommercial(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _siteCommercialLocalService.getSiteCommercial(id);
	}

	/**
	 * Returns a range of all the site commercials.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.df.lonis.ventesservice.model.impl.SiteCommercialModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of site commercials
	 * @param end the upper bound of the range of site commercials (not inclusive)
	 * @return the range of site commercials
	 */
	@Override
	public java.util.List<com.df.lonis.ventesservice.model.SiteCommercial>
		getSiteCommercials(int start, int end) {

		return _siteCommercialLocalService.getSiteCommercials(start, end);
	}

	/**
	 * Returns the number of site commercials.
	 *
	 * @return the number of site commercials
	 */
	@Override
	public int getSiteCommercialsCount() {
		return _siteCommercialLocalService.getSiteCommercialsCount();
	}

	/**
	 * Updates the site commercial in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SiteCommercialLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param siteCommercial the site commercial
	 * @return the site commercial that was updated
	 */
	@Override
	public com.df.lonis.ventesservice.model.SiteCommercial updateSiteCommercial(
		com.df.lonis.ventesservice.model.SiteCommercial siteCommercial) {

		return _siteCommercialLocalService.updateSiteCommercial(siteCommercial);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _siteCommercialLocalService.getBasePersistence();
	}

	@Override
	public SiteCommercialLocalService getWrappedService() {
		return _siteCommercialLocalService;
	}

	@Override
	public void setWrappedService(
		SiteCommercialLocalService siteCommercialLocalService) {

		_siteCommercialLocalService = siteCommercialLocalService;
	}

	private SiteCommercialLocalService _siteCommercialLocalService;

}