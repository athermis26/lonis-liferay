/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ProduitLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProduitLocalService
 * @generated
 */
public class ProduitLocalServiceWrapper
	implements ProduitLocalService, ServiceWrapper<ProduitLocalService> {

	public ProduitLocalServiceWrapper() {
		this(null);
	}

	public ProduitLocalServiceWrapper(ProduitLocalService produitLocalService) {
		_produitLocalService = produitLocalService;
	}

	/**
	 * Adds the produit to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProduitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param produit the produit
	 * @return the produit that was added
	 */
	@Override
	public com.df.lonis.ventesservice.model.Produit addProduit(
		com.df.lonis.ventesservice.model.Produit produit) {

		return _produitLocalService.addProduit(produit);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _produitLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new produit with the primary key. Does not add the produit to the database.
	 *
	 * @param id the primary key for the new produit
	 * @return the new produit
	 */
	@Override
	public com.df.lonis.ventesservice.model.Produit createProduit(long id) {
		return _produitLocalService.createProduit(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _produitLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the produit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProduitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the produit
	 * @return the produit that was removed
	 * @throws PortalException if a produit with the primary key could not be found
	 */
	@Override
	public com.df.lonis.ventesservice.model.Produit deleteProduit(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _produitLocalService.deleteProduit(id);
	}

	/**
	 * Deletes the produit from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProduitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param produit the produit
	 * @return the produit that was removed
	 */
	@Override
	public com.df.lonis.ventesservice.model.Produit deleteProduit(
		com.df.lonis.ventesservice.model.Produit produit) {

		return _produitLocalService.deleteProduit(produit);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _produitLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _produitLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _produitLocalService.dynamicQuery();
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

		return _produitLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.df.lonis.ventesservice.model.impl.ProduitModelImpl</code>.
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

		return _produitLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.df.lonis.ventesservice.model.impl.ProduitModelImpl</code>.
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

		return _produitLocalService.dynamicQuery(
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

		return _produitLocalService.dynamicQueryCount(dynamicQuery);
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

		return _produitLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.df.lonis.ventesservice.model.Produit fetchProduit(long id) {
		return _produitLocalService.fetchProduit(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _produitLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _produitLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _produitLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _produitLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the produit with the primary key.
	 *
	 * @param id the primary key of the produit
	 * @return the produit
	 * @throws PortalException if a produit with the primary key could not be found
	 */
	@Override
	public com.df.lonis.ventesservice.model.Produit getProduit(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _produitLocalService.getProduit(id);
	}

	/**
	 * Returns a range of all the produits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.df.lonis.ventesservice.model.impl.ProduitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of produits
	 * @param end the upper bound of the range of produits (not inclusive)
	 * @return the range of produits
	 */
	@Override
	public java.util.List<com.df.lonis.ventesservice.model.Produit> getProduits(
		int start, int end) {

		return _produitLocalService.getProduits(start, end);
	}

	/**
	 * Returns the number of produits.
	 *
	 * @return the number of produits
	 */
	@Override
	public int getProduitsCount() {
		return _produitLocalService.getProduitsCount();
	}

	/**
	 * Updates the produit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProduitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param produit the produit
	 * @return the produit that was updated
	 */
	@Override
	public com.df.lonis.ventesservice.model.Produit updateProduit(
		com.df.lonis.ventesservice.model.Produit produit) {

		return _produitLocalService.updateProduit(produit);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _produitLocalService.getBasePersistence();
	}

	@Override
	public ProduitLocalService getWrappedService() {
		return _produitLocalService;
	}

	@Override
	public void setWrappedService(ProduitLocalService produitLocalService) {
		_produitLocalService = produitLocalService;
	}

	private ProduitLocalService _produitLocalService;

}