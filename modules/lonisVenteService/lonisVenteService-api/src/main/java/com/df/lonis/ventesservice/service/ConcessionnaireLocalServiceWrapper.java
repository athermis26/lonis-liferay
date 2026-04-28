/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ConcessionnaireLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ConcessionnaireLocalService
 * @generated
 */
public class ConcessionnaireLocalServiceWrapper
	implements ConcessionnaireLocalService,
			   ServiceWrapper<ConcessionnaireLocalService> {

	public ConcessionnaireLocalServiceWrapper() {
		this(null);
	}

	public ConcessionnaireLocalServiceWrapper(
		ConcessionnaireLocalService concessionnaireLocalService) {

		_concessionnaireLocalService = concessionnaireLocalService;
	}

	/**
	 * Adds the concessionnaire to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConcessionnaireLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param concessionnaire the concessionnaire
	 * @return the concessionnaire that was added
	 */
	@Override
	public com.df.lonis.ventesservice.model.Concessionnaire addConcessionnaire(
		com.df.lonis.ventesservice.model.Concessionnaire concessionnaire) {

		return _concessionnaireLocalService.addConcessionnaire(concessionnaire);
	}

	/**
	 * Creates a new concessionnaire with the primary key. Does not add the concessionnaire to the database.
	 *
	 * @param id the primary key for the new concessionnaire
	 * @return the new concessionnaire
	 */
	@Override
	public com.df.lonis.ventesservice.model.Concessionnaire
		createConcessionnaire(long id) {

		return _concessionnaireLocalService.createConcessionnaire(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _concessionnaireLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the concessionnaire from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConcessionnaireLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param concessionnaire the concessionnaire
	 * @return the concessionnaire that was removed
	 */
	@Override
	public com.df.lonis.ventesservice.model.Concessionnaire
		deleteConcessionnaire(
			com.df.lonis.ventesservice.model.Concessionnaire concessionnaire) {

		return _concessionnaireLocalService.deleteConcessionnaire(
			concessionnaire);
	}

	/**
	 * Deletes the concessionnaire with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConcessionnaireLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the concessionnaire
	 * @return the concessionnaire that was removed
	 * @throws PortalException if a concessionnaire with the primary key could not be found
	 */
	@Override
	public com.df.lonis.ventesservice.model.Concessionnaire
			deleteConcessionnaire(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _concessionnaireLocalService.deleteConcessionnaire(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _concessionnaireLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _concessionnaireLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _concessionnaireLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _concessionnaireLocalService.dynamicQuery();
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

		return _concessionnaireLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.df.lonis.ventesservice.model.impl.ConcessionnaireModelImpl</code>.
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

		return _concessionnaireLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.df.lonis.ventesservice.model.impl.ConcessionnaireModelImpl</code>.
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

		return _concessionnaireLocalService.dynamicQuery(
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

		return _concessionnaireLocalService.dynamicQueryCount(dynamicQuery);
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

		return _concessionnaireLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.df.lonis.ventesservice.model.Concessionnaire
		fetchConcessionnaire(long id) {

		return _concessionnaireLocalService.fetchConcessionnaire(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _concessionnaireLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the concessionnaire with the primary key.
	 *
	 * @param id the primary key of the concessionnaire
	 * @return the concessionnaire
	 * @throws PortalException if a concessionnaire with the primary key could not be found
	 */
	@Override
	public com.df.lonis.ventesservice.model.Concessionnaire getConcessionnaire(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _concessionnaireLocalService.getConcessionnaire(id);
	}

	/**
	 * Returns a range of all the concessionnaires.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.df.lonis.ventesservice.model.impl.ConcessionnaireModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of concessionnaires
	 * @param end the upper bound of the range of concessionnaires (not inclusive)
	 * @return the range of concessionnaires
	 */
	@Override
	public java.util.List<com.df.lonis.ventesservice.model.Concessionnaire>
		getConcessionnaires(int start, int end) {

		return _concessionnaireLocalService.getConcessionnaires(start, end);
	}

	/**
	 * Returns the number of concessionnaires.
	 *
	 * @return the number of concessionnaires
	 */
	@Override
	public int getConcessionnairesCount() {
		return _concessionnaireLocalService.getConcessionnairesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _concessionnaireLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _concessionnaireLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _concessionnaireLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the concessionnaire in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConcessionnaireLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param concessionnaire the concessionnaire
	 * @return the concessionnaire that was updated
	 */
	@Override
	public com.df.lonis.ventesservice.model.Concessionnaire
		updateConcessionnaire(
			com.df.lonis.ventesservice.model.Concessionnaire concessionnaire) {

		return _concessionnaireLocalService.updateConcessionnaire(
			concessionnaire);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _concessionnaireLocalService.getBasePersistence();
	}

	@Override
	public ConcessionnaireLocalService getWrappedService() {
		return _concessionnaireLocalService;
	}

	@Override
	public void setWrappedService(
		ConcessionnaireLocalService concessionnaireLocalService) {

		_concessionnaireLocalService = concessionnaireLocalService;
	}

	private ConcessionnaireLocalService _concessionnaireLocalService;

}