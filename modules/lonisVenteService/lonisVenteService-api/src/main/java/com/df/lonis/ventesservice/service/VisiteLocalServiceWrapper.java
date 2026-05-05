/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link VisiteLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see VisiteLocalService
 * @generated
 */
public class VisiteLocalServiceWrapper
	implements ServiceWrapper<VisiteLocalService>, VisiteLocalService {

	public VisiteLocalServiceWrapper() {
		this(null);
	}

	public VisiteLocalServiceWrapper(VisiteLocalService visiteLocalService) {
		_visiteLocalService = visiteLocalService;
	}

	/**
	 * Adds the visite to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VisiteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param visite the visite
	 * @return the visite that was added
	 */
	@Override
	public com.df.lonis.ventesservice.model.Visite addVisite(
		com.df.lonis.ventesservice.model.Visite visite) {

		return _visiteLocalService.addVisite(visite);
	}

	@Override
	public int countByCommercialId(long commercialId) {
		return _visiteLocalService.countByCommercialId(commercialId);
	}

	@Override
	public int countByCommercialIdAndPeriode(
		long commercialId, String statut, java.util.Date debut,
		java.util.Date fin) {

		return _visiteLocalService.countByCommercialIdAndPeriode(
			commercialId, statut, debut, fin);
	}

	@Override
	public int countByTerminalId(long terminalId) {
		return _visiteLocalService.countByTerminalId(terminalId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _visiteLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new visite with the primary key. Does not add the visite to the database.
	 *
	 * @param id the primary key for the new visite
	 * @return the new visite
	 */
	@Override
	public com.df.lonis.ventesservice.model.Visite createVisite(long id) {
		return _visiteLocalService.createVisite(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _visiteLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the visite with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VisiteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the visite
	 * @return the visite that was removed
	 * @throws PortalException if a visite with the primary key could not be found
	 */
	@Override
	public com.df.lonis.ventesservice.model.Visite deleteVisite(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _visiteLocalService.deleteVisite(id);
	}

	/**
	 * Deletes the visite from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VisiteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param visite the visite
	 * @return the visite that was removed
	 */
	@Override
	public com.df.lonis.ventesservice.model.Visite deleteVisite(
		com.df.lonis.ventesservice.model.Visite visite) {

		return _visiteLocalService.deleteVisite(visite);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _visiteLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _visiteLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _visiteLocalService.dynamicQuery();
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

		return _visiteLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.df.lonis.ventesservice.model.impl.VisiteModelImpl</code>.
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

		return _visiteLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.df.lonis.ventesservice.model.impl.VisiteModelImpl</code>.
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

		return _visiteLocalService.dynamicQuery(
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

		return _visiteLocalService.dynamicQueryCount(dynamicQuery);
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

		return _visiteLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.df.lonis.ventesservice.model.Visite fetchVisite(long id) {
		return _visiteLocalService.fetchVisite(id);
	}

	@Override
	public java.util.List<com.df.lonis.ventesservice.model.Visite>
		findByCommercialId(long commercialId) {

		return _visiteLocalService.findByCommercialId(commercialId);
	}

	@Override
	public java.util.List<com.df.lonis.ventesservice.model.Visite>
		findByCommercialIdAndPeriode(
			long commercialId, String statut, java.util.Date debut,
			java.util.Date fin) {

		return _visiteLocalService.findByCommercialIdAndPeriode(
			commercialId, statut, debut, fin);
	}

	@Override
	public java.util.List<com.df.lonis.ventesservice.model.Visite>
		findByTerminalId(long terminalId) {

		return _visiteLocalService.findByTerminalId(terminalId);
	}

	@Override
	public java.util.List<com.df.lonis.ventesservice.model.Visite>
		findByTerminalId(long terminalId, int start, int end) {

		return _visiteLocalService.findByTerminalId(terminalId, start, end);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _visiteLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _visiteLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _visiteLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _visiteLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the visite with the primary key.
	 *
	 * @param id the primary key of the visite
	 * @return the visite
	 * @throws PortalException if a visite with the primary key could not be found
	 */
	@Override
	public com.df.lonis.ventesservice.model.Visite getVisite(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _visiteLocalService.getVisite(id);
	}

	/**
	 * Returns a range of all the visites.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.df.lonis.ventesservice.model.impl.VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @return the range of visites
	 */
	@Override
	public java.util.List<com.df.lonis.ventesservice.model.Visite> getVisites(
		int start, int end) {

		return _visiteLocalService.getVisites(start, end);
	}

	/**
	 * Returns the number of visites.
	 *
	 * @return the number of visites
	 */
	@Override
	public int getVisitesCount() {
		return _visiteLocalService.getVisitesCount();
	}

	/**
	 * Updates the visite in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VisiteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param visite the visite
	 * @return the visite that was updated
	 */
	@Override
	public com.df.lonis.ventesservice.model.Visite updateVisite(
		com.df.lonis.ventesservice.model.Visite visite) {

		return _visiteLocalService.updateVisite(visite);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _visiteLocalService.getBasePersistence();
	}

	@Override
	public VisiteLocalService getWrappedService() {
		return _visiteLocalService;
	}

	@Override
	public void setWrappedService(VisiteLocalService visiteLocalService) {
		_visiteLocalService = visiteLocalService;
	}

	private VisiteLocalService _visiteLocalService;

}