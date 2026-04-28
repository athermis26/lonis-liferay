/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence;

import com.df.lonis.ventesservice.model.Produit;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the produit service. This utility wraps <code>com.df.lonis.ventesservice.service.persistence.impl.ProduitPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProduitPersistence
 * @generated
 */
public class ProduitUtil {

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
	public static void clearCache(Produit produit) {
		getPersistence().clearCache(produit);
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
	public static Map<Serializable, Produit> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Produit> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Produit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Produit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Produit> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Produit update(Produit produit) {
		return getPersistence().update(produit);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Produit update(
		Produit produit, ServiceContext serviceContext) {

		return getPersistence().update(produit, serviceContext);
	}

	/**
	 * Returns the produit where code = &#63; or throws a <code>NoSuchProduitException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching produit
	 * @throws NoSuchProduitException if a matching produit could not be found
	 */
	public static Produit findByCode(String code)
		throws com.df.lonis.ventesservice.exception.NoSuchProduitException {

		return getPersistence().findByCode(code);
	}

	/**
	 * Returns the produit where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching produit, or <code>null</code> if a matching produit could not be found
	 */
	public static Produit fetchByCode(String code) {
		return getPersistence().fetchByCode(code);
	}

	/**
	 * Returns the produit where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching produit, or <code>null</code> if a matching produit could not be found
	 */
	public static Produit fetchByCode(String code, boolean useFinderCache) {
		return getPersistence().fetchByCode(code, useFinderCache);
	}

	/**
	 * Removes the produit where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the produit that was removed
	 */
	public static Produit removeByCode(String code)
		throws com.df.lonis.ventesservice.exception.NoSuchProduitException {

		return getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of produits where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching produits
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Caches the produit in the entity cache if it is enabled.
	 *
	 * @param produit the produit
	 */
	public static void cacheResult(Produit produit) {
		getPersistence().cacheResult(produit);
	}

	/**
	 * Caches the produits in the entity cache if it is enabled.
	 *
	 * @param produits the produits
	 */
	public static void cacheResult(List<Produit> produits) {
		getPersistence().cacheResult(produits);
	}

	/**
	 * Creates a new produit with the primary key. Does not add the produit to the database.
	 *
	 * @param id the primary key for the new produit
	 * @return the new produit
	 */
	public static Produit create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the produit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the produit
	 * @return the produit that was removed
	 * @throws NoSuchProduitException if a produit with the primary key could not be found
	 */
	public static Produit remove(long id)
		throws com.df.lonis.ventesservice.exception.NoSuchProduitException {

		return getPersistence().remove(id);
	}

	public static Produit updateImpl(Produit produit) {
		return getPersistence().updateImpl(produit);
	}

	/**
	 * Returns the produit with the primary key or throws a <code>NoSuchProduitException</code> if it could not be found.
	 *
	 * @param id the primary key of the produit
	 * @return the produit
	 * @throws NoSuchProduitException if a produit with the primary key could not be found
	 */
	public static Produit findByPrimaryKey(long id)
		throws com.df.lonis.ventesservice.exception.NoSuchProduitException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the produit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the produit
	 * @return the produit, or <code>null</code> if a produit with the primary key could not be found
	 */
	public static Produit fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the produits.
	 *
	 * @return the produits
	 */
	public static List<Produit> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the produits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProduitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of produits
	 * @param end the upper bound of the range of produits (not inclusive)
	 * @return the range of produits
	 */
	public static List<Produit> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the produits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProduitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of produits
	 * @param end the upper bound of the range of produits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of produits
	 */
	public static List<Produit> findAll(
		int start, int end, OrderByComparator<Produit> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the produits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProduitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of produits
	 * @param end the upper bound of the range of produits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of produits
	 */
	public static List<Produit> findAll(
		int start, int end, OrderByComparator<Produit> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the produits from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of produits.
	 *
	 * @return the number of produits
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProduitPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ProduitPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ProduitPersistence _persistence;

}