/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence.impl;

import com.df.lonis.ventesservice.exception.NoSuchSiteException;
import com.df.lonis.ventesservice.model.Site;
import com.df.lonis.ventesservice.model.SiteTable;
import com.df.lonis.ventesservice.model.impl.SiteImpl;
import com.df.lonis.ventesservice.model.impl.SiteModelImpl;
import com.df.lonis.ventesservice.service.persistence.SitePersistence;
import com.df.lonis.ventesservice.service.persistence.SiteUtil;
import com.df.lonis.ventesservice.service.persistence.impl.constants.LONISPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the site service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SitePersistence.class)
public class SitePersistenceImpl
	extends BasePersistenceImpl<Site> implements SitePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SiteUtil</code> to access the site persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SiteImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public SitePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("parentId", "parent_id");
		dbColumnNames.put("codeProvinov", "code_provinov");
		dbColumnNames.put("createdAt", "created_at");
		dbColumnNames.put("updatedAt", "updated_at");

		setDBColumnNames(dbColumnNames);

		setModelClass(Site.class);

		setModelImplClass(SiteImpl.class);
		setModelPKClass(long.class);

		setTable(SiteTable.INSTANCE);
	}

	/**
	 * Caches the site in the entity cache if it is enabled.
	 *
	 * @param site the site
	 */
	@Override
	public void cacheResult(Site site) {
		entityCache.putResult(SiteImpl.class, site.getPrimaryKey(), site);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the sites in the entity cache if it is enabled.
	 *
	 * @param sites the sites
	 */
	@Override
	public void cacheResult(List<Site> sites) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (sites.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Site site : sites) {
			if (entityCache.getResult(SiteImpl.class, site.getPrimaryKey()) ==
					null) {

				cacheResult(site);
			}
		}
	}

	/**
	 * Clears the cache for all sites.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SiteImpl.class);

		finderCache.clearCache(SiteImpl.class);
	}

	/**
	 * Clears the cache for the site.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Site site) {
		entityCache.removeResult(SiteImpl.class, site);
	}

	@Override
	public void clearCache(List<Site> sites) {
		for (Site site : sites) {
			entityCache.removeResult(SiteImpl.class, site);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SiteImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SiteImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new site with the primary key. Does not add the site to the database.
	 *
	 * @param id the primary key for the new site
	 * @return the new site
	 */
	@Override
	public Site create(long id) {
		Site site = new SiteImpl();

		site.setNew(true);
		site.setPrimaryKey(id);

		return site;
	}

	/**
	 * Removes the site with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the site
	 * @return the site that was removed
	 * @throws NoSuchSiteException if a site with the primary key could not be found
	 */
	@Override
	public Site remove(long id) throws NoSuchSiteException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the site with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the site
	 * @return the site that was removed
	 * @throws NoSuchSiteException if a site with the primary key could not be found
	 */
	@Override
	public Site remove(Serializable primaryKey) throws NoSuchSiteException {
		Session session = null;

		try {
			session = openSession();

			Site site = (Site)session.get(SiteImpl.class, primaryKey);

			if (site == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSiteException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(site);
		}
		catch (NoSuchSiteException noSuchEntityException) {
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
	protected Site removeImpl(Site site) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(site)) {
				site = (Site)session.get(
					SiteImpl.class, site.getPrimaryKeyObj());
			}

			if (site != null) {
				session.delete(site);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (site != null) {
			clearCache(site);
		}

		return site;
	}

	@Override
	public Site updateImpl(Site site) {
		boolean isNew = site.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(site);
			}
			else {
				site = (Site)session.merge(site);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(SiteImpl.class, site, false, true);

		if (isNew) {
			site.setNew(false);
		}

		site.resetOriginalValues();

		return site;
	}

	/**
	 * Returns the site with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the site
	 * @return the site
	 * @throws NoSuchSiteException if a site with the primary key could not be found
	 */
	@Override
	public Site findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSiteException {

		Site site = fetchByPrimaryKey(primaryKey);

		if (site == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSiteException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return site;
	}

	/**
	 * Returns the site with the primary key or throws a <code>NoSuchSiteException</code> if it could not be found.
	 *
	 * @param id the primary key of the site
	 * @return the site
	 * @throws NoSuchSiteException if a site with the primary key could not be found
	 */
	@Override
	public Site findByPrimaryKey(long id) throws NoSuchSiteException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the site with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the site
	 * @return the site, or <code>null</code> if a site with the primary key could not be found
	 */
	@Override
	public Site fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the sites.
	 *
	 * @return the sites
	 */
	@Override
	public List<Site> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sites.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SiteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sites
	 * @param end the upper bound of the range of sites (not inclusive)
	 * @return the range of sites
	 */
	@Override
	public List<Site> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sites.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SiteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sites
	 * @param end the upper bound of the range of sites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sites
	 */
	@Override
	public List<Site> findAll(
		int start, int end, OrderByComparator<Site> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sites.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SiteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sites
	 * @param end the upper bound of the range of sites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sites
	 */
	@Override
	public List<Site> findAll(
		int start, int end, OrderByComparator<Site> orderByComparator,
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

		List<Site> list = null;

		if (useFinderCache) {
			list = (List<Site>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SITE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SITE;

				sql = sql.concat(SiteModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Site>)QueryUtil.list(
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
	 * Removes all the sites from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Site site : findAll()) {
			remove(site);
		}
	}

	/**
	 * Returns the number of sites.
	 *
	 * @return the number of sites
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SITE);

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
		return _SQL_SELECT_SITE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SiteModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the site persistence.
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

		SiteUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		SiteUtil.setPersistence(null);

		entityCache.removeCache(SiteImpl.class.getName());
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

	private static final String _SQL_SELECT_SITE = "SELECT site FROM Site site";

	private static final String _SQL_COUNT_SITE =
		"SELECT COUNT(site) FROM Site site";

	private static final String _ORDER_BY_ENTITY_ALIAS = "site.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Site exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		SitePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"parentId", "codeProvinov", "createdAt", "updatedAt"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}