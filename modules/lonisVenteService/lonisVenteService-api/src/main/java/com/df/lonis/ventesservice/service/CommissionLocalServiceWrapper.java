/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link CommissionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CommissionLocalService
 * @generated
 */
public class CommissionLocalServiceWrapper
	implements CommissionLocalService, ServiceWrapper<CommissionLocalService> {

	public CommissionLocalServiceWrapper() {
		this(null);
	}

	public CommissionLocalServiceWrapper(
		CommissionLocalService commissionLocalService) {

		_commissionLocalService = commissionLocalService;
	}

	/**
	 * Adds the commission to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommissionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commission the commission
	 * @return the commission that was added
	 */
	@Override
	public com.df.lonis.ventesservice.model.Commission addCommission(
		com.df.lonis.ventesservice.model.Commission commission) {

		return _commissionLocalService.addCommission(commission);
	}

	/**
	 * Creates a new commission with the primary key. Does not add the commission to the database.
	 *
	 * @param id the primary key for the new commission
	 * @return the new commission
	 */
	@Override
	public com.df.lonis.ventesservice.model.Commission createCommission(
		long id) {

		return _commissionLocalService.createCommission(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commissionLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the commission from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommissionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commission the commission
	 * @return the commission that was removed
	 */
	@Override
	public com.df.lonis.ventesservice.model.Commission deleteCommission(
		com.df.lonis.ventesservice.model.Commission commission) {

		return _commissionLocalService.deleteCommission(commission);
	}

	/**
	 * Deletes the commission with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommissionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the commission
	 * @return the commission that was removed
	 * @throws PortalException if a commission with the primary key could not be found
	 */
	@Override
	public com.df.lonis.ventesservice.model.Commission deleteCommission(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commissionLocalService.deleteCommission(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commissionLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _commissionLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _commissionLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _commissionLocalService.dynamicQuery();
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

		return _commissionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.df.lonis.ventesservice.model.impl.CommissionModelImpl</code>.
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

		return _commissionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.df.lonis.ventesservice.model.impl.CommissionModelImpl</code>.
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

		return _commissionLocalService.dynamicQuery(
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

		return _commissionLocalService.dynamicQueryCount(dynamicQuery);
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

		return _commissionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.df.lonis.ventesservice.model.Commission fetchCommission(
		long id) {

		return _commissionLocalService.fetchCommission(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _commissionLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the commission with the primary key.
	 *
	 * @param id the primary key of the commission
	 * @return the commission
	 * @throws PortalException if a commission with the primary key could not be found
	 */
	@Override
	public com.df.lonis.ventesservice.model.Commission getCommission(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commissionLocalService.getCommission(id);
	}

	/**
	 * Returns a range of all the commissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.df.lonis.ventesservice.model.impl.CommissionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commissions
	 * @param end the upper bound of the range of commissions (not inclusive)
	 * @return the range of commissions
	 */
	@Override
	public java.util.List<com.df.lonis.ventesservice.model.Commission>
		getCommissions(int start, int end) {

		return _commissionLocalService.getCommissions(start, end);
	}

	/**
	 * Returns the number of commissions.
	 *
	 * @return the number of commissions
	 */
	@Override
	public int getCommissionsCount() {
		return _commissionLocalService.getCommissionsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _commissionLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _commissionLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commissionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the commission in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommissionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commission the commission
	 * @return the commission that was updated
	 */
	@Override
	public com.df.lonis.ventesservice.model.Commission updateCommission(
		com.df.lonis.ventesservice.model.Commission commission) {

		return _commissionLocalService.updateCommission(commission);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _commissionLocalService.getBasePersistence();
	}

	@Override
	public CommissionLocalService getWrappedService() {
		return _commissionLocalService;
	}

	@Override
	public void setWrappedService(
		CommissionLocalService commissionLocalService) {

		_commissionLocalService = commissionLocalService;
	}

	private CommissionLocalService _commissionLocalService;

}