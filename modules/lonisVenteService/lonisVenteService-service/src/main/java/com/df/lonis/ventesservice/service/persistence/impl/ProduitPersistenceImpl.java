/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence.impl;

import com.df.lonis.ventesservice.exception.NoSuchProduitException;
import com.df.lonis.ventesservice.model.Produit;
import com.df.lonis.ventesservice.model.ProduitTable;
import com.df.lonis.ventesservice.model.impl.ProduitImpl;
import com.df.lonis.ventesservice.model.impl.ProduitModelImpl;
import com.df.lonis.ventesservice.service.persistence.ProduitPersistence;
import com.df.lonis.ventesservice.service.persistence.ProduitUtil;
import com.df.lonis.ventesservice.service.persistence.impl.constants.LONISPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the produit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProduitPersistence.class)
public class ProduitPersistenceImpl
	extends BasePersistenceImpl<Produit> implements ProduitPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProduitUtil</code> to access the produit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProduitImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByCode;

	/**
	 * Returns the produit where code = &#63; or throws a <code>NoSuchProduitException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching produit
	 * @throws NoSuchProduitException if a matching produit could not be found
	 */
	@Override
	public Produit findByCode(String code) throws NoSuchProduitException {
		Produit produit = fetchByCode(code);

		if (produit == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("code=");
			sb.append(code);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProduitException(sb.toString());
		}

		return produit;
	}

	/**
	 * Returns the produit where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching produit, or <code>null</code> if a matching produit could not be found
	 */
	@Override
	public Produit fetchByCode(String code) {
		return fetchByCode(code, true);
	}

	/**
	 * Returns the produit where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching produit, or <code>null</code> if a matching produit could not be found
	 */
	@Override
	public Produit fetchByCode(String code, boolean useFinderCache) {
		code = Objects.toString(code, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {code};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByCode, finderArgs, this);
		}

		if (result instanceof Produit) {
			Produit produit = (Produit)result;

			if (!Objects.equals(code, produit.getCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_PRODUIT_WHERE);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCode) {
					queryPos.add(code);
				}

				List<Produit> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByCode, finderArgs, list);
					}
				}
				else {
					Produit produit = list.get(0);

					result = produit;

					cacheResult(produit);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Produit)result;
		}
	}

	/**
	 * Removes the produit where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the produit that was removed
	 */
	@Override
	public Produit removeByCode(String code) throws NoSuchProduitException {
		Produit produit = findByCode(code);

		return remove(produit);
	}

	/**
	 * Returns the number of produits where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching produits
	 */
	@Override
	public int countByCode(String code) {
		Produit produit = fetchByCode(code);

		if (produit == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_CODE_CODE_2 = "produit.code = ?";

	private static final String _FINDER_COLUMN_CODE_CODE_3 =
		"(produit.code IS NULL OR produit.code = '')";

	public ProduitPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("createdAt", "created_at");
		dbColumnNames.put("updatedAt", "updated_at");

		setDBColumnNames(dbColumnNames);

		setModelClass(Produit.class);

		setModelImplClass(ProduitImpl.class);
		setModelPKClass(long.class);

		setTable(ProduitTable.INSTANCE);
	}

	/**
	 * Caches the produit in the entity cache if it is enabled.
	 *
	 * @param produit the produit
	 */
	@Override
	public void cacheResult(Produit produit) {
		entityCache.putResult(
			ProduitImpl.class, produit.getPrimaryKey(), produit);

		finderCache.putResult(
			_finderPathFetchByCode, new Object[] {produit.getCode()}, produit);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the produits in the entity cache if it is enabled.
	 *
	 * @param produits the produits
	 */
	@Override
	public void cacheResult(List<Produit> produits) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (produits.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Produit produit : produits) {
			if (entityCache.getResult(
					ProduitImpl.class, produit.getPrimaryKey()) == null) {

				cacheResult(produit);
			}
		}
	}

	/**
	 * Clears the cache for all produits.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProduitImpl.class);

		finderCache.clearCache(ProduitImpl.class);
	}

	/**
	 * Clears the cache for the produit.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Produit produit) {
		entityCache.removeResult(ProduitImpl.class, produit);
	}

	@Override
	public void clearCache(List<Produit> produits) {
		for (Produit produit : produits) {
			entityCache.removeResult(ProduitImpl.class, produit);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProduitImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ProduitImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(ProduitModelImpl produitModelImpl) {
		Object[] args = new Object[] {produitModelImpl.getCode()};

		finderCache.putResult(_finderPathFetchByCode, args, produitModelImpl);
	}

	/**
	 * Creates a new produit with the primary key. Does not add the produit to the database.
	 *
	 * @param id the primary key for the new produit
	 * @return the new produit
	 */
	@Override
	public Produit create(long id) {
		Produit produit = new ProduitImpl();

		produit.setNew(true);
		produit.setPrimaryKey(id);

		return produit;
	}

	/**
	 * Removes the produit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the produit
	 * @return the produit that was removed
	 * @throws NoSuchProduitException if a produit with the primary key could not be found
	 */
	@Override
	public Produit remove(long id) throws NoSuchProduitException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the produit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the produit
	 * @return the produit that was removed
	 * @throws NoSuchProduitException if a produit with the primary key could not be found
	 */
	@Override
	public Produit remove(Serializable primaryKey)
		throws NoSuchProduitException {

		Session session = null;

		try {
			session = openSession();

			Produit produit = (Produit)session.get(
				ProduitImpl.class, primaryKey);

			if (produit == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProduitException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(produit);
		}
		catch (NoSuchProduitException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Produit removeImpl(Produit produit) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(produit)) {
				produit = (Produit)session.get(
					ProduitImpl.class, produit.getPrimaryKeyObj());
			}

			if (produit != null) {
				session.delete(produit);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (produit != null) {
			clearCache(produit);
		}

		return produit;
	}

	@Override
	public Produit updateImpl(Produit produit) {
		boolean isNew = produit.isNew();

		if (!(produit instanceof ProduitModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(produit.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(produit);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in produit proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Produit implementation " +
					produit.getClass());
		}

		ProduitModelImpl produitModelImpl = (ProduitModelImpl)produit;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(produit);
			}
			else {
				produit = (Produit)session.merge(produit);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(ProduitImpl.class, produitModelImpl, false, true);

		cacheUniqueFindersCache(produitModelImpl);

		if (isNew) {
			produit.setNew(false);
		}

		produit.resetOriginalValues();

		return produit;
	}

	/**
	 * Returns the produit with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the produit
	 * @return the produit
	 * @throws NoSuchProduitException if a produit with the primary key could not be found
	 */
	@Override
	public Produit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProduitException {

		Produit produit = fetchByPrimaryKey(primaryKey);

		if (produit == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProduitException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return produit;
	}

	/**
	 * Returns the produit with the primary key or throws a <code>NoSuchProduitException</code> if it could not be found.
	 *
	 * @param id the primary key of the produit
	 * @return the produit
	 * @throws NoSuchProduitException if a produit with the primary key could not be found
	 */
	@Override
	public Produit findByPrimaryKey(long id) throws NoSuchProduitException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the produit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the produit
	 * @return the produit, or <code>null</code> if a produit with the primary key could not be found
	 */
	@Override
	public Produit fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the produits.
	 *
	 * @return the produits
	 */
	@Override
	public List<Produit> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Produit> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Produit> findAll(
		int start, int end, OrderByComparator<Produit> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Produit> findAll(
		int start, int end, OrderByComparator<Produit> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Produit> list = null;

		if (useFinderCache) {
			list = (List<Produit>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PRODUIT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PRODUIT;

				sql = sql.concat(ProduitModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Produit>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the produits from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Produit produit : findAll()) {
			remove(produit);
		}
	}

	/**
	 * Returns the number of produits.
	 *
	 * @return the number of produits
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PRODUIT);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PRODUIT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProduitModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the produit persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchByCode = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByCode",
			new String[] {String.class.getName()}, new String[] {"code"}, true);

		ProduitUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ProduitUtil.setPersistence(null);

		entityCache.removeCache(ProduitImpl.class.getName());
	}

	@Override
	@Reference(
		target = LONISPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = LONISPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = LONISPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PRODUIT =
		"SELECT produit FROM Produit produit";

	private static final String _SQL_SELECT_PRODUIT_WHERE =
		"SELECT produit FROM Produit produit WHERE ";

	private static final String _SQL_COUNT_PRODUIT =
		"SELECT COUNT(produit) FROM Produit produit";

	private static final String _SQL_COUNT_PRODUIT_WHERE =
		"SELECT COUNT(produit) FROM Produit produit WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "produit.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Produit exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Produit exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProduitPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"createdAt", "updatedAt"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}