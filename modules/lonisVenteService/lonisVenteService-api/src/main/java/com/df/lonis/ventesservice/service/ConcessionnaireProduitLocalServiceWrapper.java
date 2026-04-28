/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ConcessionnaireProduitLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ConcessionnaireProduitLocalService
 * @generated
 */
public class ConcessionnaireProduitLocalServiceWrapper
	implements ConcessionnaireProduitLocalService,
			   ServiceWrapper<ConcessionnaireProduitLocalService> {

	public ConcessionnaireProduitLocalServiceWrapper() {
		this(null);
	}

	public ConcessionnaireProduitLocalServiceWrapper(
		ConcessionnaireProduitLocalService concessionnaireProduitLocalService) {

		_concessionnaireProduitLocalService =
			concessionnaireProduitLocalService;
	}

	/**
	 * Adds the concessionnaire produit to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConcessionnaireProduitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param concessionnaireProduit the concessionnaire produit
	 * @return the concessionnaire produit that was added
	 */
	@Override
	public com.df.lonis.ventesservice.model.ConcessionnaireProduit
		addConcessionnaireProduit(
			com.df.lonis.ventesservice.model.ConcessionnaireProduit
				concessionnaireProduit) {

		return _concessionnaireProduitLocalService.addConcessionnaireProduit(
			concessionnaireProduit);
	}

	/**
	 * Creates a new concessionnaire produit with the primary key. Does not add the concessionnaire produit to the database.
	 *
	 * @param id the primary key for the new concessionnaire produit
	 * @return the new concessionnaire produit
	 */
	@Override
	public com.df.lonis.ventesservice.model.ConcessionnaireProduit
		createConcessionnaireProduit(long id) {

		return _concessionnaireProduitLocalService.createConcessionnaireProduit(
			id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _concessionnaireProduitLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the concessionnaire produit from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConcessionnaireProduitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param concessionnaireProduit the concessionnaire produit
	 * @return the concessionnaire produit that was removed
	 */
	@Override
	public com.df.lonis.ventesservice.model.ConcessionnaireProduit
		deleteConcessionnaireProduit(
			com.df.lonis.ventesservice.model.ConcessionnaireProduit
				concessionnaireProduit) {

		return _concessionnaireProduitLocalService.deleteConcessionnaireProduit(
			concessionnaireProduit);
	}

	/**
	 * Deletes the concessionnaire produit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConcessionnaireProduitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the concessionnaire produit
	 * @return the concessionnaire produit that was removed
	 * @throws PortalException if a concessionnaire produit with the primary key could not be found
	 */
	@Override
	public com.df.lonis.ventesservice.model.ConcessionnaireProduit
			deleteConcessionnaireProduit(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _concessionnaireProduitLocalService.deleteConcessionnaireProduit(
			id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _concessionnaireProduitLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _concessionnaireProduitLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _concessionnaireProduitLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _concessionnaireProduitLocalService.dynamicQuery();
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

		return _concessionnaireProduitLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.df.lonis.ventesservice.model.impl.ConcessionnaireProduitModelImpl</code>.
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

		return _concessionnaireProduitLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.df.lonis.ventesservice.model.impl.ConcessionnaireProduitModelImpl</code>.
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

		return _concessionnaireProduitLocalService.dynamicQuery(
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

		return _concessionnaireProduitLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _concessionnaireProduitLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.df.lonis.ventesservice.model.ConcessionnaireProduit
		fetchConcessionnaireProduit(long id) {

		return _concessionnaireProduitLocalService.fetchConcessionnaireProduit(
			id);
	}

	@Override
	public java.util.List
		<com.df.lonis.ventesservice.model.ConcessionnaireProduit>
			findByConcessionnaireId(long concessionnaireId) {

		return _concessionnaireProduitLocalService.findByConcessionnaireId(
			concessionnaireId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _concessionnaireProduitLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the concessionnaire produit with the primary key.
	 *
	 * @param id the primary key of the concessionnaire produit
	 * @return the concessionnaire produit
	 * @throws PortalException if a concessionnaire produit with the primary key could not be found
	 */
	@Override
	public com.df.lonis.ventesservice.model.ConcessionnaireProduit
			getConcessionnaireProduit(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _concessionnaireProduitLocalService.getConcessionnaireProduit(
			id);
	}

	/**
	 * Returns a range of all the concessionnaire produits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.df.lonis.ventesservice.model.impl.ConcessionnaireProduitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of concessionnaire produits
	 * @param end the upper bound of the range of concessionnaire produits (not inclusive)
	 * @return the range of concessionnaire produits
	 */
	@Override
	public java.util.List
		<com.df.lonis.ventesservice.model.ConcessionnaireProduit>
			getConcessionnaireProduits(int start, int end) {

		return _concessionnaireProduitLocalService.getConcessionnaireProduits(
			start, end);
	}

	/**
	 * Returns the number of concessionnaire produits.
	 *
	 * @return the number of concessionnaire produits
	 */
	@Override
	public int getConcessionnaireProduitsCount() {
		return _concessionnaireProduitLocalService.
			getConcessionnaireProduitsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _concessionnaireProduitLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _concessionnaireProduitLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _concessionnaireProduitLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the concessionnaire produit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConcessionnaireProduitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param concessionnaireProduit the concessionnaire produit
	 * @return the concessionnaire produit that was updated
	 */
	@Override
	public com.df.lonis.ventesservice.model.ConcessionnaireProduit
		updateConcessionnaireProduit(
			com.df.lonis.ventesservice.model.ConcessionnaireProduit
				concessionnaireProduit) {

		return _concessionnaireProduitLocalService.updateConcessionnaireProduit(
			concessionnaireProduit);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _concessionnaireProduitLocalService.getBasePersistence();
	}

	@Override
	public ConcessionnaireProduitLocalService getWrappedService() {
		return _concessionnaireProduitLocalService;
	}

	@Override
	public void setWrappedService(
		ConcessionnaireProduitLocalService concessionnaireProduitLocalService) {

		_concessionnaireProduitLocalService =
			concessionnaireProduitLocalService;
	}

	private ConcessionnaireProduitLocalService
		_concessionnaireProduitLocalService;

}