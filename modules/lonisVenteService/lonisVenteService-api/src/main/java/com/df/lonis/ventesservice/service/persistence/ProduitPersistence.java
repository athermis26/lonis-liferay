/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence;

import com.df.lonis.ventesservice.exception.NoSuchProduitException;
import com.df.lonis.ventesservice.model.Produit;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the produit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProduitUtil
 * @generated
 */
@ProviderType
public interface ProduitPersistence extends BasePersistence<Produit> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProduitUtil} to access the produit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the produit where code = &#63; or throws a <code>NoSuchProduitException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching produit
	 * @throws NoSuchProduitException if a matching produit could not be found
	 */
	public Produit findByCode(String code) throws NoSuchProduitException;

	/**
	 * Returns the produit where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching produit, or <code>null</code> if a matching produit could not be found
	 */
	public Produit fetchByCode(String code);

	/**
	 * Returns the produit where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching produit, or <code>null</code> if a matching produit could not be found
	 */
	public Produit fetchByCode(String code, boolean useFinderCache);

	/**
	 * Removes the produit where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the produit that was removed
	 */
	public Produit removeByCode(String code) throws NoSuchProduitException;

	/**
	 * Returns the number of produits where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching produits
	 */
	public int countByCode(String code);

	/**
	 * Caches the produit in the entity cache if it is enabled.
	 *
	 * @param produit the produit
	 */
	public void cacheResult(Produit produit);

	/**
	 * Caches the produits in the entity cache if it is enabled.
	 *
	 * @param produits the produits
	 */
	public void cacheResult(java.util.List<Produit> produits);

	/**
	 * Creates a new produit with the primary key. Does not add the produit to the database.
	 *
	 * @param id the primary key for the new produit
	 * @return the new produit
	 */
	public Produit create(long id);

	/**
	 * Removes the produit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the produit
	 * @return the produit that was removed
	 * @throws NoSuchProduitException if a produit with the primary key could not be found
	 */
	public Produit remove(long id) throws NoSuchProduitException;

	public Produit updateImpl(Produit produit);

	/**
	 * Returns the produit with the primary key or throws a <code>NoSuchProduitException</code> if it could not be found.
	 *
	 * @param id the primary key of the produit
	 * @return the produit
	 * @throws NoSuchProduitException if a produit with the primary key could not be found
	 */
	public Produit findByPrimaryKey(long id) throws NoSuchProduitException;

	/**
	 * Returns the produit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the produit
	 * @return the produit, or <code>null</code> if a produit with the primary key could not be found
	 */
	public Produit fetchByPrimaryKey(long id);

	/**
	 * Returns all the produits.
	 *
	 * @return the produits
	 */
	public java.util.List<Produit> findAll();

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
	public java.util.List<Produit> findAll(int start, int end);

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
	public java.util.List<Produit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Produit>
			orderByComparator);

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
	public java.util.List<Produit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Produit>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the produits from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of produits.
	 *
	 * @return the number of produits
	 */
	public int countAll();

}