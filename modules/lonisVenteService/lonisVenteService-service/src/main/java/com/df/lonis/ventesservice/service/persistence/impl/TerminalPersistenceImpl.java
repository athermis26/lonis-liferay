/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence.impl;

import com.df.lonis.ventesservice.exception.NoSuchTerminalException;
import com.df.lonis.ventesservice.model.Terminal;
import com.df.lonis.ventesservice.model.TerminalTable;
import com.df.lonis.ventesservice.model.impl.TerminalImpl;
import com.df.lonis.ventesservice.model.impl.TerminalModelImpl;
import com.df.lonis.ventesservice.service.persistence.TerminalPersistence;
import com.df.lonis.ventesservice.service.persistence.TerminalUtil;
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
 * The persistence implementation for the terminal service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TerminalPersistence.class)
public class TerminalPersistenceImpl
	extends BasePersistenceImpl<Terminal> implements TerminalPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TerminalUtil</code> to access the terminal persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TerminalImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath
		_finderPathWithPaginationFindByConcessionnaireProduitCode;
	private FinderPath
		_finderPathWithoutPaginationFindByConcessionnaireProduitCode;
	private FinderPath _finderPathCountByConcessionnaireProduitCode;

	/**
	 * Returns all the terminals where concessionnaireProduitCode = &#63;.
	 *
	 * @param concessionnaireProduitCode the concessionnaire produit code
	 * @return the matching terminals
	 */
	@Override
	public List<Terminal> findByConcessionnaireProduitCode(
		String concessionnaireProduitCode) {

		return findByConcessionnaireProduitCode(
			concessionnaireProduitCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the terminals where concessionnaireProduitCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TerminalModelImpl</code>.
	 * </p>
	 *
	 * @param concessionnaireProduitCode the concessionnaire produit code
	 * @param start the lower bound of the range of terminals
	 * @param end the upper bound of the range of terminals (not inclusive)
	 * @return the range of matching terminals
	 */
	@Override
	public List<Terminal> findByConcessionnaireProduitCode(
		String concessionnaireProduitCode, int start, int end) {

		return findByConcessionnaireProduitCode(
			concessionnaireProduitCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the terminals where concessionnaireProduitCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TerminalModelImpl</code>.
	 * </p>
	 *
	 * @param concessionnaireProduitCode the concessionnaire produit code
	 * @param start the lower bound of the range of terminals
	 * @param end the upper bound of the range of terminals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terminals
	 */
	@Override
	public List<Terminal> findByConcessionnaireProduitCode(
		String concessionnaireProduitCode, int start, int end,
		OrderByComparator<Terminal> orderByComparator) {

		return findByConcessionnaireProduitCode(
			concessionnaireProduitCode, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the terminals where concessionnaireProduitCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TerminalModelImpl</code>.
	 * </p>
	 *
	 * @param concessionnaireProduitCode the concessionnaire produit code
	 * @param start the lower bound of the range of terminals
	 * @param end the upper bound of the range of terminals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching terminals
	 */
	@Override
	public List<Terminal> findByConcessionnaireProduitCode(
		String concessionnaireProduitCode, int start, int end,
		OrderByComparator<Terminal> orderByComparator, boolean useFinderCache) {

		concessionnaireProduitCode = Objects.toString(
			concessionnaireProduitCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByConcessionnaireProduitCode;
				finderArgs = new Object[] {concessionnaireProduitCode};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByConcessionnaireProduitCode;
			finderArgs = new Object[] {
				concessionnaireProduitCode, start, end, orderByComparator
			};
		}

		List<Terminal> list = null;

		if (useFinderCache) {
			list = (List<Terminal>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Terminal terminal : list) {
					if (!concessionnaireProduitCode.equals(
							terminal.getConcessionnaireProduitCode())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_TERMINAL_WHERE);

			boolean bindConcessionnaireProduitCode = false;

			if (concessionnaireProduitCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_CONCESSIONNAIREPRODUITCODE_CONCESSIONNAIREPRODUITCODE_3);
			}
			else {
				bindConcessionnaireProduitCode = true;

				sb.append(
					_FINDER_COLUMN_CONCESSIONNAIREPRODUITCODE_CONCESSIONNAIREPRODUITCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TerminalModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindConcessionnaireProduitCode) {
					queryPos.add(concessionnaireProduitCode);
				}

				list = (List<Terminal>)QueryUtil.list(
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
	 * Returns the first terminal in the ordered set where concessionnaireProduitCode = &#63;.
	 *
	 * @param concessionnaireProduitCode the concessionnaire produit code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching terminal
	 * @throws NoSuchTerminalException if a matching terminal could not be found
	 */
	@Override
	public Terminal findByConcessionnaireProduitCode_First(
			String concessionnaireProduitCode,
			OrderByComparator<Terminal> orderByComparator)
		throws NoSuchTerminalException {

		Terminal terminal = fetchByConcessionnaireProduitCode_First(
			concessionnaireProduitCode, orderByComparator);

		if (terminal != null) {
			return terminal;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("concessionnaireProduitCode=");
		sb.append(concessionnaireProduitCode);

		sb.append("}");

		throw new NoSuchTerminalException(sb.toString());
	}

	/**
	 * Returns the first terminal in the ordered set where concessionnaireProduitCode = &#63;.
	 *
	 * @param concessionnaireProduitCode the concessionnaire produit code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching terminal, or <code>null</code> if a matching terminal could not be found
	 */
	@Override
	public Terminal fetchByConcessionnaireProduitCode_First(
		String concessionnaireProduitCode,
		OrderByComparator<Terminal> orderByComparator) {

		List<Terminal> list = findByConcessionnaireProduitCode(
			concessionnaireProduitCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last terminal in the ordered set where concessionnaireProduitCode = &#63;.
	 *
	 * @param concessionnaireProduitCode the concessionnaire produit code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching terminal
	 * @throws NoSuchTerminalException if a matching terminal could not be found
	 */
	@Override
	public Terminal findByConcessionnaireProduitCode_Last(
			String concessionnaireProduitCode,
			OrderByComparator<Terminal> orderByComparator)
		throws NoSuchTerminalException {

		Terminal terminal = fetchByConcessionnaireProduitCode_Last(
			concessionnaireProduitCode, orderByComparator);

		if (terminal != null) {
			return terminal;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("concessionnaireProduitCode=");
		sb.append(concessionnaireProduitCode);

		sb.append("}");

		throw new NoSuchTerminalException(sb.toString());
	}

	/**
	 * Returns the last terminal in the ordered set where concessionnaireProduitCode = &#63;.
	 *
	 * @param concessionnaireProduitCode the concessionnaire produit code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching terminal, or <code>null</code> if a matching terminal could not be found
	 */
	@Override
	public Terminal fetchByConcessionnaireProduitCode_Last(
		String concessionnaireProduitCode,
		OrderByComparator<Terminal> orderByComparator) {

		int count = countByConcessionnaireProduitCode(
			concessionnaireProduitCode);

		if (count == 0) {
			return null;
		}

		List<Terminal> list = findByConcessionnaireProduitCode(
			concessionnaireProduitCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the terminals before and after the current terminal in the ordered set where concessionnaireProduitCode = &#63;.
	 *
	 * @param id the primary key of the current terminal
	 * @param concessionnaireProduitCode the concessionnaire produit code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next terminal
	 * @throws NoSuchTerminalException if a terminal with the primary key could not be found
	 */
	@Override
	public Terminal[] findByConcessionnaireProduitCode_PrevAndNext(
			long id, String concessionnaireProduitCode,
			OrderByComparator<Terminal> orderByComparator)
		throws NoSuchTerminalException {

		concessionnaireProduitCode = Objects.toString(
			concessionnaireProduitCode, "");

		Terminal terminal = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Terminal[] array = new TerminalImpl[3];

			array[0] = getByConcessionnaireProduitCode_PrevAndNext(
				session, terminal, concessionnaireProduitCode,
				orderByComparator, true);

			array[1] = terminal;

			array[2] = getByConcessionnaireProduitCode_PrevAndNext(
				session, terminal, concessionnaireProduitCode,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Terminal getByConcessionnaireProduitCode_PrevAndNext(
		Session session, Terminal terminal, String concessionnaireProduitCode,
		OrderByComparator<Terminal> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TERMINAL_WHERE);

		boolean bindConcessionnaireProduitCode = false;

		if (concessionnaireProduitCode.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_CONCESSIONNAIREPRODUITCODE_CONCESSIONNAIREPRODUITCODE_3);
		}
		else {
			bindConcessionnaireProduitCode = true;

			sb.append(
				_FINDER_COLUMN_CONCESSIONNAIREPRODUITCODE_CONCESSIONNAIREPRODUITCODE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TerminalModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindConcessionnaireProduitCode) {
			queryPos.add(concessionnaireProduitCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(terminal)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Terminal> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the terminals where concessionnaireProduitCode = &#63; from the database.
	 *
	 * @param concessionnaireProduitCode the concessionnaire produit code
	 */
	@Override
	public void removeByConcessionnaireProduitCode(
		String concessionnaireProduitCode) {

		for (Terminal terminal :
				findByConcessionnaireProduitCode(
					concessionnaireProduitCode, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(terminal);
		}
	}

	/**
	 * Returns the number of terminals where concessionnaireProduitCode = &#63;.
	 *
	 * @param concessionnaireProduitCode the concessionnaire produit code
	 * @return the number of matching terminals
	 */
	@Override
	public int countByConcessionnaireProduitCode(
		String concessionnaireProduitCode) {

		concessionnaireProduitCode = Objects.toString(
			concessionnaireProduitCode, "");

		FinderPath finderPath = _finderPathCountByConcessionnaireProduitCode;

		Object[] finderArgs = new Object[] {concessionnaireProduitCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TERMINAL_WHERE);

			boolean bindConcessionnaireProduitCode = false;

			if (concessionnaireProduitCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_CONCESSIONNAIREPRODUITCODE_CONCESSIONNAIREPRODUITCODE_3);
			}
			else {
				bindConcessionnaireProduitCode = true;

				sb.append(
					_FINDER_COLUMN_CONCESSIONNAIREPRODUITCODE_CONCESSIONNAIREPRODUITCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindConcessionnaireProduitCode) {
					queryPos.add(concessionnaireProduitCode);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
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

	private static final String
		_FINDER_COLUMN_CONCESSIONNAIREPRODUITCODE_CONCESSIONNAIREPRODUITCODE_2 =
			"terminal.concessionnaireProduitCode = ?";

	private static final String
		_FINDER_COLUMN_CONCESSIONNAIREPRODUITCODE_CONCESSIONNAIREPRODUITCODE_3 =
			"(terminal.concessionnaireProduitCode IS NULL OR terminal.concessionnaireProduitCode = '')";

	private FinderPath _finderPathWithPaginationFindByConcessionnaireId;
	private FinderPath _finderPathWithoutPaginationFindByConcessionnaireId;
	private FinderPath _finderPathCountByConcessionnaireId;

	/**
	 * Returns all the terminals where concessionnaireId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @return the matching terminals
	 */
	@Override
	public List<Terminal> findByConcessionnaireId(long concessionnaireId) {
		return findByConcessionnaireId(
			concessionnaireId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the terminals where concessionnaireId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TerminalModelImpl</code>.
	 * </p>
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param start the lower bound of the range of terminals
	 * @param end the upper bound of the range of terminals (not inclusive)
	 * @return the range of matching terminals
	 */
	@Override
	public List<Terminal> findByConcessionnaireId(
		long concessionnaireId, int start, int end) {

		return findByConcessionnaireId(concessionnaireId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the terminals where concessionnaireId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TerminalModelImpl</code>.
	 * </p>
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param start the lower bound of the range of terminals
	 * @param end the upper bound of the range of terminals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terminals
	 */
	@Override
	public List<Terminal> findByConcessionnaireId(
		long concessionnaireId, int start, int end,
		OrderByComparator<Terminal> orderByComparator) {

		return findByConcessionnaireId(
			concessionnaireId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the terminals where concessionnaireId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TerminalModelImpl</code>.
	 * </p>
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param start the lower bound of the range of terminals
	 * @param end the upper bound of the range of terminals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching terminals
	 */
	@Override
	public List<Terminal> findByConcessionnaireId(
		long concessionnaireId, int start, int end,
		OrderByComparator<Terminal> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByConcessionnaireId;
				finderArgs = new Object[] {concessionnaireId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByConcessionnaireId;
			finderArgs = new Object[] {
				concessionnaireId, start, end, orderByComparator
			};
		}

		List<Terminal> list = null;

		if (useFinderCache) {
			list = (List<Terminal>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Terminal terminal : list) {
					if (concessionnaireId != terminal.getConcessionnaireId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_TERMINAL_WHERE);

			sb.append(_FINDER_COLUMN_CONCESSIONNAIREID_CONCESSIONNAIREID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TerminalModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(concessionnaireId);

				list = (List<Terminal>)QueryUtil.list(
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
	 * Returns the first terminal in the ordered set where concessionnaireId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching terminal
	 * @throws NoSuchTerminalException if a matching terminal could not be found
	 */
	@Override
	public Terminal findByConcessionnaireId_First(
			long concessionnaireId,
			OrderByComparator<Terminal> orderByComparator)
		throws NoSuchTerminalException {

		Terminal terminal = fetchByConcessionnaireId_First(
			concessionnaireId, orderByComparator);

		if (terminal != null) {
			return terminal;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("concessionnaireId=");
		sb.append(concessionnaireId);

		sb.append("}");

		throw new NoSuchTerminalException(sb.toString());
	}

	/**
	 * Returns the first terminal in the ordered set where concessionnaireId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching terminal, or <code>null</code> if a matching terminal could not be found
	 */
	@Override
	public Terminal fetchByConcessionnaireId_First(
		long concessionnaireId, OrderByComparator<Terminal> orderByComparator) {

		List<Terminal> list = findByConcessionnaireId(
			concessionnaireId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last terminal in the ordered set where concessionnaireId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching terminal
	 * @throws NoSuchTerminalException if a matching terminal could not be found
	 */
	@Override
	public Terminal findByConcessionnaireId_Last(
			long concessionnaireId,
			OrderByComparator<Terminal> orderByComparator)
		throws NoSuchTerminalException {

		Terminal terminal = fetchByConcessionnaireId_Last(
			concessionnaireId, orderByComparator);

		if (terminal != null) {
			return terminal;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("concessionnaireId=");
		sb.append(concessionnaireId);

		sb.append("}");

		throw new NoSuchTerminalException(sb.toString());
	}

	/**
	 * Returns the last terminal in the ordered set where concessionnaireId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching terminal, or <code>null</code> if a matching terminal could not be found
	 */
	@Override
	public Terminal fetchByConcessionnaireId_Last(
		long concessionnaireId, OrderByComparator<Terminal> orderByComparator) {

		int count = countByConcessionnaireId(concessionnaireId);

		if (count == 0) {
			return null;
		}

		List<Terminal> list = findByConcessionnaireId(
			concessionnaireId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the terminals before and after the current terminal in the ordered set where concessionnaireId = &#63;.
	 *
	 * @param id the primary key of the current terminal
	 * @param concessionnaireId the concessionnaire ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next terminal
	 * @throws NoSuchTerminalException if a terminal with the primary key could not be found
	 */
	@Override
	public Terminal[] findByConcessionnaireId_PrevAndNext(
			long id, long concessionnaireId,
			OrderByComparator<Terminal> orderByComparator)
		throws NoSuchTerminalException {

		Terminal terminal = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Terminal[] array = new TerminalImpl[3];

			array[0] = getByConcessionnaireId_PrevAndNext(
				session, terminal, concessionnaireId, orderByComparator, true);

			array[1] = terminal;

			array[2] = getByConcessionnaireId_PrevAndNext(
				session, terminal, concessionnaireId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Terminal getByConcessionnaireId_PrevAndNext(
		Session session, Terminal terminal, long concessionnaireId,
		OrderByComparator<Terminal> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TERMINAL_WHERE);

		sb.append(_FINDER_COLUMN_CONCESSIONNAIREID_CONCESSIONNAIREID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TerminalModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(concessionnaireId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(terminal)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Terminal> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the terminals where concessionnaireId = &#63; from the database.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 */
	@Override
	public void removeByConcessionnaireId(long concessionnaireId) {
		for (Terminal terminal :
				findByConcessionnaireId(
					concessionnaireId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(terminal);
		}
	}

	/**
	 * Returns the number of terminals where concessionnaireId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @return the number of matching terminals
	 */
	@Override
	public int countByConcessionnaireId(long concessionnaireId) {
		FinderPath finderPath = _finderPathCountByConcessionnaireId;

		Object[] finderArgs = new Object[] {concessionnaireId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TERMINAL_WHERE);

			sb.append(_FINDER_COLUMN_CONCESSIONNAIREID_CONCESSIONNAIREID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(concessionnaireId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
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

	private static final String
		_FINDER_COLUMN_CONCESSIONNAIREID_CONCESSIONNAIREID_2 =
			"terminal.concessionnaireId = ?";

	private FinderPath _finderPathWithPaginationFindBySiteId;
	private FinderPath _finderPathWithoutPaginationFindBySiteId;
	private FinderPath _finderPathCountBySiteId;

	/**
	 * Returns all the terminals where siteId = &#63;.
	 *
	 * @param siteId the site ID
	 * @return the matching terminals
	 */
	@Override
	public List<Terminal> findBySiteId(long siteId) {
		return findBySiteId(siteId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the terminals where siteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TerminalModelImpl</code>.
	 * </p>
	 *
	 * @param siteId the site ID
	 * @param start the lower bound of the range of terminals
	 * @param end the upper bound of the range of terminals (not inclusive)
	 * @return the range of matching terminals
	 */
	@Override
	public List<Terminal> findBySiteId(long siteId, int start, int end) {
		return findBySiteId(siteId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the terminals where siteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TerminalModelImpl</code>.
	 * </p>
	 *
	 * @param siteId the site ID
	 * @param start the lower bound of the range of terminals
	 * @param end the upper bound of the range of terminals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terminals
	 */
	@Override
	public List<Terminal> findBySiteId(
		long siteId, int start, int end,
		OrderByComparator<Terminal> orderByComparator) {

		return findBySiteId(siteId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the terminals where siteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TerminalModelImpl</code>.
	 * </p>
	 *
	 * @param siteId the site ID
	 * @param start the lower bound of the range of terminals
	 * @param end the upper bound of the range of terminals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching terminals
	 */
	@Override
	public List<Terminal> findBySiteId(
		long siteId, int start, int end,
		OrderByComparator<Terminal> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBySiteId;
				finderArgs = new Object[] {siteId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySiteId;
			finderArgs = new Object[] {siteId, start, end, orderByComparator};
		}

		List<Terminal> list = null;

		if (useFinderCache) {
			list = (List<Terminal>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Terminal terminal : list) {
					if (siteId != terminal.getSiteId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_TERMINAL_WHERE);

			sb.append(_FINDER_COLUMN_SITEID_SITEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TerminalModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(siteId);

				list = (List<Terminal>)QueryUtil.list(
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
	 * Returns the first terminal in the ordered set where siteId = &#63;.
	 *
	 * @param siteId the site ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching terminal
	 * @throws NoSuchTerminalException if a matching terminal could not be found
	 */
	@Override
	public Terminal findBySiteId_First(
			long siteId, OrderByComparator<Terminal> orderByComparator)
		throws NoSuchTerminalException {

		Terminal terminal = fetchBySiteId_First(siteId, orderByComparator);

		if (terminal != null) {
			return terminal;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("siteId=");
		sb.append(siteId);

		sb.append("}");

		throw new NoSuchTerminalException(sb.toString());
	}

	/**
	 * Returns the first terminal in the ordered set where siteId = &#63;.
	 *
	 * @param siteId the site ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching terminal, or <code>null</code> if a matching terminal could not be found
	 */
	@Override
	public Terminal fetchBySiteId_First(
		long siteId, OrderByComparator<Terminal> orderByComparator) {

		List<Terminal> list = findBySiteId(siteId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last terminal in the ordered set where siteId = &#63;.
	 *
	 * @param siteId the site ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching terminal
	 * @throws NoSuchTerminalException if a matching terminal could not be found
	 */
	@Override
	public Terminal findBySiteId_Last(
			long siteId, OrderByComparator<Terminal> orderByComparator)
		throws NoSuchTerminalException {

		Terminal terminal = fetchBySiteId_Last(siteId, orderByComparator);

		if (terminal != null) {
			return terminal;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("siteId=");
		sb.append(siteId);

		sb.append("}");

		throw new NoSuchTerminalException(sb.toString());
	}

	/**
	 * Returns the last terminal in the ordered set where siteId = &#63;.
	 *
	 * @param siteId the site ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching terminal, or <code>null</code> if a matching terminal could not be found
	 */
	@Override
	public Terminal fetchBySiteId_Last(
		long siteId, OrderByComparator<Terminal> orderByComparator) {

		int count = countBySiteId(siteId);

		if (count == 0) {
			return null;
		}

		List<Terminal> list = findBySiteId(
			siteId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the terminals before and after the current terminal in the ordered set where siteId = &#63;.
	 *
	 * @param id the primary key of the current terminal
	 * @param siteId the site ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next terminal
	 * @throws NoSuchTerminalException if a terminal with the primary key could not be found
	 */
	@Override
	public Terminal[] findBySiteId_PrevAndNext(
			long id, long siteId, OrderByComparator<Terminal> orderByComparator)
		throws NoSuchTerminalException {

		Terminal terminal = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Terminal[] array = new TerminalImpl[3];

			array[0] = getBySiteId_PrevAndNext(
				session, terminal, siteId, orderByComparator, true);

			array[1] = terminal;

			array[2] = getBySiteId_PrevAndNext(
				session, terminal, siteId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Terminal getBySiteId_PrevAndNext(
		Session session, Terminal terminal, long siteId,
		OrderByComparator<Terminal> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TERMINAL_WHERE);

		sb.append(_FINDER_COLUMN_SITEID_SITEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TerminalModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(siteId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(terminal)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Terminal> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the terminals where siteId = &#63; from the database.
	 *
	 * @param siteId the site ID
	 */
	@Override
	public void removeBySiteId(long siteId) {
		for (Terminal terminal :
				findBySiteId(
					siteId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(terminal);
		}
	}

	/**
	 * Returns the number of terminals where siteId = &#63;.
	 *
	 * @param siteId the site ID
	 * @return the number of matching terminals
	 */
	@Override
	public int countBySiteId(long siteId) {
		FinderPath finderPath = _finderPathCountBySiteId;

		Object[] finderArgs = new Object[] {siteId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TERMINAL_WHERE);

			sb.append(_FINDER_COLUMN_SITEID_SITEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(siteId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
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

	private static final String _FINDER_COLUMN_SITEID_SITEID_2 =
		"terminal.siteId = ?";

	private FinderPath _finderPathWithPaginationFindByStatutValidation;
	private FinderPath _finderPathWithoutPaginationFindByStatutValidation;
	private FinderPath _finderPathCountByStatutValidation;

	/**
	 * Returns all the terminals where statutValidation = &#63;.
	 *
	 * @param statutValidation the statut validation
	 * @return the matching terminals
	 */
	@Override
	public List<Terminal> findByStatutValidation(String statutValidation) {
		return findByStatutValidation(
			statutValidation, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the terminals where statutValidation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TerminalModelImpl</code>.
	 * </p>
	 *
	 * @param statutValidation the statut validation
	 * @param start the lower bound of the range of terminals
	 * @param end the upper bound of the range of terminals (not inclusive)
	 * @return the range of matching terminals
	 */
	@Override
	public List<Terminal> findByStatutValidation(
		String statutValidation, int start, int end) {

		return findByStatutValidation(statutValidation, start, end, null);
	}

	/**
	 * Returns an ordered range of all the terminals where statutValidation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TerminalModelImpl</code>.
	 * </p>
	 *
	 * @param statutValidation the statut validation
	 * @param start the lower bound of the range of terminals
	 * @param end the upper bound of the range of terminals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terminals
	 */
	@Override
	public List<Terminal> findByStatutValidation(
		String statutValidation, int start, int end,
		OrderByComparator<Terminal> orderByComparator) {

		return findByStatutValidation(
			statutValidation, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the terminals where statutValidation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TerminalModelImpl</code>.
	 * </p>
	 *
	 * @param statutValidation the statut validation
	 * @param start the lower bound of the range of terminals
	 * @param end the upper bound of the range of terminals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching terminals
	 */
	@Override
	public List<Terminal> findByStatutValidation(
		String statutValidation, int start, int end,
		OrderByComparator<Terminal> orderByComparator, boolean useFinderCache) {

		statutValidation = Objects.toString(statutValidation, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatutValidation;
				finderArgs = new Object[] {statutValidation};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatutValidation;
			finderArgs = new Object[] {
				statutValidation, start, end, orderByComparator
			};
		}

		List<Terminal> list = null;

		if (useFinderCache) {
			list = (List<Terminal>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Terminal terminal : list) {
					if (!statutValidation.equals(
							terminal.getStatutValidation())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_TERMINAL_WHERE);

			boolean bindStatutValidation = false;

			if (statutValidation.isEmpty()) {
				sb.append(_FINDER_COLUMN_STATUTVALIDATION_STATUTVALIDATION_3);
			}
			else {
				bindStatutValidation = true;

				sb.append(_FINDER_COLUMN_STATUTVALIDATION_STATUTVALIDATION_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TerminalModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStatutValidation) {
					queryPos.add(statutValidation);
				}

				list = (List<Terminal>)QueryUtil.list(
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
	 * Returns the first terminal in the ordered set where statutValidation = &#63;.
	 *
	 * @param statutValidation the statut validation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching terminal
	 * @throws NoSuchTerminalException if a matching terminal could not be found
	 */
	@Override
	public Terminal findByStatutValidation_First(
			String statutValidation,
			OrderByComparator<Terminal> orderByComparator)
		throws NoSuchTerminalException {

		Terminal terminal = fetchByStatutValidation_First(
			statutValidation, orderByComparator);

		if (terminal != null) {
			return terminal;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("statutValidation=");
		sb.append(statutValidation);

		sb.append("}");

		throw new NoSuchTerminalException(sb.toString());
	}

	/**
	 * Returns the first terminal in the ordered set where statutValidation = &#63;.
	 *
	 * @param statutValidation the statut validation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching terminal, or <code>null</code> if a matching terminal could not be found
	 */
	@Override
	public Terminal fetchByStatutValidation_First(
		String statutValidation,
		OrderByComparator<Terminal> orderByComparator) {

		List<Terminal> list = findByStatutValidation(
			statutValidation, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last terminal in the ordered set where statutValidation = &#63;.
	 *
	 * @param statutValidation the statut validation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching terminal
	 * @throws NoSuchTerminalException if a matching terminal could not be found
	 */
	@Override
	public Terminal findByStatutValidation_Last(
			String statutValidation,
			OrderByComparator<Terminal> orderByComparator)
		throws NoSuchTerminalException {

		Terminal terminal = fetchByStatutValidation_Last(
			statutValidation, orderByComparator);

		if (terminal != null) {
			return terminal;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("statutValidation=");
		sb.append(statutValidation);

		sb.append("}");

		throw new NoSuchTerminalException(sb.toString());
	}

	/**
	 * Returns the last terminal in the ordered set where statutValidation = &#63;.
	 *
	 * @param statutValidation the statut validation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching terminal, or <code>null</code> if a matching terminal could not be found
	 */
	@Override
	public Terminal fetchByStatutValidation_Last(
		String statutValidation,
		OrderByComparator<Terminal> orderByComparator) {

		int count = countByStatutValidation(statutValidation);

		if (count == 0) {
			return null;
		}

		List<Terminal> list = findByStatutValidation(
			statutValidation, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the terminals before and after the current terminal in the ordered set where statutValidation = &#63;.
	 *
	 * @param id the primary key of the current terminal
	 * @param statutValidation the statut validation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next terminal
	 * @throws NoSuchTerminalException if a terminal with the primary key could not be found
	 */
	@Override
	public Terminal[] findByStatutValidation_PrevAndNext(
			long id, String statutValidation,
			OrderByComparator<Terminal> orderByComparator)
		throws NoSuchTerminalException {

		statutValidation = Objects.toString(statutValidation, "");

		Terminal terminal = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Terminal[] array = new TerminalImpl[3];

			array[0] = getByStatutValidation_PrevAndNext(
				session, terminal, statutValidation, orderByComparator, true);

			array[1] = terminal;

			array[2] = getByStatutValidation_PrevAndNext(
				session, terminal, statutValidation, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Terminal getByStatutValidation_PrevAndNext(
		Session session, Terminal terminal, String statutValidation,
		OrderByComparator<Terminal> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TERMINAL_WHERE);

		boolean bindStatutValidation = false;

		if (statutValidation.isEmpty()) {
			sb.append(_FINDER_COLUMN_STATUTVALIDATION_STATUTVALIDATION_3);
		}
		else {
			bindStatutValidation = true;

			sb.append(_FINDER_COLUMN_STATUTVALIDATION_STATUTVALIDATION_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TerminalModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindStatutValidation) {
			queryPos.add(statutValidation);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(terminal)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Terminal> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the terminals where statutValidation = &#63; from the database.
	 *
	 * @param statutValidation the statut validation
	 */
	@Override
	public void removeByStatutValidation(String statutValidation) {
		for (Terminal terminal :
				findByStatutValidation(
					statutValidation, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(terminal);
		}
	}

	/**
	 * Returns the number of terminals where statutValidation = &#63;.
	 *
	 * @param statutValidation the statut validation
	 * @return the number of matching terminals
	 */
	@Override
	public int countByStatutValidation(String statutValidation) {
		statutValidation = Objects.toString(statutValidation, "");

		FinderPath finderPath = _finderPathCountByStatutValidation;

		Object[] finderArgs = new Object[] {statutValidation};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TERMINAL_WHERE);

			boolean bindStatutValidation = false;

			if (statutValidation.isEmpty()) {
				sb.append(_FINDER_COLUMN_STATUTVALIDATION_STATUTVALIDATION_3);
			}
			else {
				bindStatutValidation = true;

				sb.append(_FINDER_COLUMN_STATUTVALIDATION_STATUTVALIDATION_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStatutValidation) {
					queryPos.add(statutValidation);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
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

	private static final String
		_FINDER_COLUMN_STATUTVALIDATION_STATUTVALIDATION_2 =
			"terminal.statutValidation = ?";

	private static final String
		_FINDER_COLUMN_STATUTVALIDATION_STATUTVALIDATION_3 =
			"(terminal.statutValidation IS NULL OR terminal.statutValidation = '')";

	public TerminalPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("codeTerminal", "code_terminal");
		dbColumnNames.put("concessionnaireId", "concessionnaire_id");
		dbColumnNames.put("concessionnaireCode", "concessionnaire_code");
		dbColumnNames.put("produitId", "produit_id");
		dbColumnNames.put(
			"concessionnaireProduitCode", "concessionnaire_produit_code");
		dbColumnNames.put("siteId", "site_id");
		dbColumnNames.put("statutValidation", "statut_validation");
		dbColumnNames.put("createdAt", "created_at");
		dbColumnNames.put("updatedAt", "updated_at");

		setDBColumnNames(dbColumnNames);

		setModelClass(Terminal.class);

		setModelImplClass(TerminalImpl.class);
		setModelPKClass(long.class);

		setTable(TerminalTable.INSTANCE);
	}

	/**
	 * Caches the terminal in the entity cache if it is enabled.
	 *
	 * @param terminal the terminal
	 */
	@Override
	public void cacheResult(Terminal terminal) {
		entityCache.putResult(
			TerminalImpl.class, terminal.getPrimaryKey(), terminal);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the terminals in the entity cache if it is enabled.
	 *
	 * @param terminals the terminals
	 */
	@Override
	public void cacheResult(List<Terminal> terminals) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (terminals.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Terminal terminal : terminals) {
			if (entityCache.getResult(
					TerminalImpl.class, terminal.getPrimaryKey()) == null) {

				cacheResult(terminal);
			}
		}
	}

	/**
	 * Clears the cache for all terminals.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TerminalImpl.class);

		finderCache.clearCache(TerminalImpl.class);
	}

	/**
	 * Clears the cache for the terminal.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Terminal terminal) {
		entityCache.removeResult(TerminalImpl.class, terminal);
	}

	@Override
	public void clearCache(List<Terminal> terminals) {
		for (Terminal terminal : terminals) {
			entityCache.removeResult(TerminalImpl.class, terminal);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(TerminalImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(TerminalImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new terminal with the primary key. Does not add the terminal to the database.
	 *
	 * @param id the primary key for the new terminal
	 * @return the new terminal
	 */
	@Override
	public Terminal create(long id) {
		Terminal terminal = new TerminalImpl();

		terminal.setNew(true);
		terminal.setPrimaryKey(id);

		return terminal;
	}

	/**
	 * Removes the terminal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the terminal
	 * @return the terminal that was removed
	 * @throws NoSuchTerminalException if a terminal with the primary key could not be found
	 */
	@Override
	public Terminal remove(long id) throws NoSuchTerminalException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the terminal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the terminal
	 * @return the terminal that was removed
	 * @throws NoSuchTerminalException if a terminal with the primary key could not be found
	 */
	@Override
	public Terminal remove(Serializable primaryKey)
		throws NoSuchTerminalException {

		Session session = null;

		try {
			session = openSession();

			Terminal terminal = (Terminal)session.get(
				TerminalImpl.class, primaryKey);

			if (terminal == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTerminalException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(terminal);
		}
		catch (NoSuchTerminalException noSuchEntityException) {
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
	protected Terminal removeImpl(Terminal terminal) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(terminal)) {
				terminal = (Terminal)session.get(
					TerminalImpl.class, terminal.getPrimaryKeyObj());
			}

			if (terminal != null) {
				session.delete(terminal);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (terminal != null) {
			clearCache(terminal);
		}

		return terminal;
	}

	@Override
	public Terminal updateImpl(Terminal terminal) {
		boolean isNew = terminal.isNew();

		if (!(terminal instanceof TerminalModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(terminal.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(terminal);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in terminal proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Terminal implementation " +
					terminal.getClass());
		}

		TerminalModelImpl terminalModelImpl = (TerminalModelImpl)terminal;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(terminal);
			}
			else {
				terminal = (Terminal)session.merge(terminal);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TerminalImpl.class, terminalModelImpl, false, true);

		if (isNew) {
			terminal.setNew(false);
		}

		terminal.resetOriginalValues();

		return terminal;
	}

	/**
	 * Returns the terminal with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the terminal
	 * @return the terminal
	 * @throws NoSuchTerminalException if a terminal with the primary key could not be found
	 */
	@Override
	public Terminal findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTerminalException {

		Terminal terminal = fetchByPrimaryKey(primaryKey);

		if (terminal == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTerminalException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return terminal;
	}

	/**
	 * Returns the terminal with the primary key or throws a <code>NoSuchTerminalException</code> if it could not be found.
	 *
	 * @param id the primary key of the terminal
	 * @return the terminal
	 * @throws NoSuchTerminalException if a terminal with the primary key could not be found
	 */
	@Override
	public Terminal findByPrimaryKey(long id) throws NoSuchTerminalException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the terminal with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the terminal
	 * @return the terminal, or <code>null</code> if a terminal with the primary key could not be found
	 */
	@Override
	public Terminal fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the terminals.
	 *
	 * @return the terminals
	 */
	@Override
	public List<Terminal> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the terminals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TerminalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of terminals
	 * @param end the upper bound of the range of terminals (not inclusive)
	 * @return the range of terminals
	 */
	@Override
	public List<Terminal> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the terminals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TerminalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of terminals
	 * @param end the upper bound of the range of terminals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of terminals
	 */
	@Override
	public List<Terminal> findAll(
		int start, int end, OrderByComparator<Terminal> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the terminals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TerminalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of terminals
	 * @param end the upper bound of the range of terminals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of terminals
	 */
	@Override
	public List<Terminal> findAll(
		int start, int end, OrderByComparator<Terminal> orderByComparator,
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

		List<Terminal> list = null;

		if (useFinderCache) {
			list = (List<Terminal>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TERMINAL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TERMINAL;

				sql = sql.concat(TerminalModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Terminal>)QueryUtil.list(
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
	 * Removes all the terminals from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Terminal terminal : findAll()) {
			remove(terminal);
		}
	}

	/**
	 * Returns the number of terminals.
	 *
	 * @return the number of terminals
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TERMINAL);

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
		return _SQL_SELECT_TERMINAL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TerminalModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the terminal persistence.
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

		_finderPathWithPaginationFindByConcessionnaireProduitCode =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByConcessionnaireProduitCode",
				new String[] {
					String.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"concessionnaire_produit_code"}, true);

		_finderPathWithoutPaginationFindByConcessionnaireProduitCode =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByConcessionnaireProduitCode",
				new String[] {String.class.getName()},
				new String[] {"concessionnaire_produit_code"}, true);

		_finderPathCountByConcessionnaireProduitCode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByConcessionnaireProduitCode",
			new String[] {String.class.getName()},
			new String[] {"concessionnaire_produit_code"}, false);

		_finderPathWithPaginationFindByConcessionnaireId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByConcessionnaireId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"concessionnaire_id"}, true);

		_finderPathWithoutPaginationFindByConcessionnaireId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByConcessionnaireId", new String[] {Long.class.getName()},
			new String[] {"concessionnaire_id"}, true);

		_finderPathCountByConcessionnaireId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByConcessionnaireId", new String[] {Long.class.getName()},
			new String[] {"concessionnaire_id"}, false);

		_finderPathWithPaginationFindBySiteId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySiteId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"site_id"}, true);

		_finderPathWithoutPaginationFindBySiteId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySiteId",
			new String[] {Long.class.getName()}, new String[] {"site_id"},
			true);

		_finderPathCountBySiteId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySiteId",
			new String[] {Long.class.getName()}, new String[] {"site_id"},
			false);

		_finderPathWithPaginationFindByStatutValidation = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatutValidation",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"statut_validation"}, true);

		_finderPathWithoutPaginationFindByStatutValidation = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatutValidation",
			new String[] {String.class.getName()},
			new String[] {"statut_validation"}, true);

		_finderPathCountByStatutValidation = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByStatutValidation", new String[] {String.class.getName()},
			new String[] {"statut_validation"}, false);

		TerminalUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		TerminalUtil.setPersistence(null);

		entityCache.removeCache(TerminalImpl.class.getName());
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

	private static final String _SQL_SELECT_TERMINAL =
		"SELECT terminal FROM Terminal terminal";

	private static final String _SQL_SELECT_TERMINAL_WHERE =
		"SELECT terminal FROM Terminal terminal WHERE ";

	private static final String _SQL_COUNT_TERMINAL =
		"SELECT COUNT(terminal) FROM Terminal terminal";

	private static final String _SQL_COUNT_TERMINAL_WHERE =
		"SELECT COUNT(terminal) FROM Terminal terminal WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "terminal.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Terminal exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Terminal exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TerminalPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"codeTerminal", "concessionnaireId", "concessionnaireCode",
			"produitId", "concessionnaireProduitCode", "siteId",
			"statutValidation", "createdAt", "updatedAt"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}