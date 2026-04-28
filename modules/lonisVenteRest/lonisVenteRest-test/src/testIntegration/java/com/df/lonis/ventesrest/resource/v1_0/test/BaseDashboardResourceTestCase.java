package com.df.lonis.ventesrest.resource.v1_0.test;

import com.df.lonis.ventesrest.client.dto.v1_0.DashboardKpis;
import com.df.lonis.ventesrest.client.http.HttpInvoker;
import com.df.lonis.ventesrest.client.pagination.Page;
import com.df.lonis.ventesrest.client.resource.v1_0.DashboardResource;

import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import java.lang.reflect.InvocationTargetException;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.beanutils.BeanUtilsBean;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author HP
 * @generated
 */
@Generated("")
public abstract class BaseDashboardResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_dashboardResource.setContextCompany(testCompany);

		DashboardResource.Builder builder = DashboardResource.builder();

		dashboardResource = builder.authentication(
			"test@liferay.com", "test"
		).locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testGetDashboardKpis() throws Exception {
		Dashboard postDashboard = testGetDashboard_addDashboard();

		DashboardKpis postDashboardKpis = testGetDashboardKpis_addDashboardKpis(
			postDashboard.getId(), randomDashboardKpis());

		DashboardKpis getDashboardKpis = dashboardResource.getDashboardKpis(
			postDashboard.getId());

		assertEquals(postDashboardKpis, getDashboardKpis);
		assertValid(getDashboardKpis);
	}

	protected DashboardKpis testGetDashboardKpis_addDashboardKpis(
			long dashboardId, DashboardKpis dashboardKpis)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(Object dashboard, List<Object> dashboards) {
		boolean contains = false;

		for (Object item : dashboards) {
			if (equals(dashboard, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			dashboards + " does not contain " + dashboard, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Object dashboard1, Object dashboard2) {
		Assert.assertTrue(
			dashboard1 + " does not equal " + dashboard2,
			equals(dashboard1, dashboard2));
	}

	protected void assertEquals(
		List<Object> dashboards1, List<Object> dashboards2) {

		Assert.assertEquals(dashboards1.size(), dashboards2.size());

		for (int i = 0; i < dashboards1.size(); i++) {
			Object dashboard1 = dashboards1.get(i);
			Object dashboard2 = dashboards2.get(i);

			assertEquals(dashboard1, dashboard2);
		}
	}

	protected void assertEquals(
		DashboardKpis dashboardKpis1, DashboardKpis dashboardKpis2) {

		Assert.assertTrue(
			dashboardKpis1 + " does not equal " + dashboardKpis2,
			equals(dashboardKpis1, dashboardKpis2));
	}

	protected void assertEqualsIgnoringOrder(
		List<Object> dashboards1, List<Object> dashboards2) {

		Assert.assertEquals(dashboards1.size(), dashboards2.size());

		for (Object dashboard1 : dashboards1) {
			boolean contains = false;

			for (Object dashboard2 : dashboards2) {
				if (equals(dashboard1, dashboard2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				dashboards2 + " does not contain " + dashboard1, contains);
		}
	}

	protected void assertValid(Object dashboard) throws Exception {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<Object> page) {
		boolean valid = false;

		java.util.Collection<Object> dashboards = page.getItems();

		int size = dashboards.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(DashboardKpis dashboardKpis) {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalDashboardKpisAssertFieldNames()) {

			if (Objects.equals(
					"chiffreAffairesTotal", additionalAssertFieldName)) {

				if (dashboardKpis.getChiffreAffairesTotal() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("paiementsTotal", additionalAssertFieldName)) {
				if (dashboardKpis.getPaiementsTotal() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"totalConcessionnaires", additionalAssertFieldName)) {

				if (dashboardKpis.getTotalConcessionnaires() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"totalPointsDeVente", additionalAssertFieldName)) {

				if (dashboardKpis.getTotalPointsDeVente() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected String[] getAdditionalDashboardKpisAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(
			java.lang.reflect.Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(Object dashboard1, Object dashboard2) {
		if (dashboard1 == dashboard2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected boolean equals(
		DashboardKpis dashboardKpis1, DashboardKpis dashboardKpis2) {

		if (dashboardKpis1 == dashboardKpis2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalDashboardKpisAssertFieldNames()) {

			if (Objects.equals(
					"chiffreAffairesTotal", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						dashboardKpis1.getChiffreAffairesTotal(),
						dashboardKpis2.getChiffreAffairesTotal())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("paiementsTotal", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						dashboardKpis1.getPaiementsTotal(),
						dashboardKpis2.getPaiementsTotal())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"totalConcessionnaires", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						dashboardKpis1.getTotalConcessionnaires(),
						dashboardKpis2.getTotalConcessionnaires())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"totalPointsDeVente", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						dashboardKpis1.getTotalPointsDeVente(),
						dashboardKpis2.getTotalPointsDeVente())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected java.lang.reflect.Field[] getDeclaredFields(Class clazz)
		throws Exception {

		Stream<java.lang.reflect.Field> stream = Stream.of(
			ReflectionUtil.getDeclaredFields(clazz));

		return stream.filter(
			field -> !field.isSynthetic()
		).toArray(
			java.lang.reflect.Field[]::new
		);
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_dashboardResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_dashboardResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		java.util.Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField ->
				Objects.equals(entityField.getType(), type) &&
				!ArrayUtil.contains(
					getIgnoredEntityFieldNames(), entityField.getName())
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator, Object dashboard) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected DashboardKpis randomDashboardKpis() throws Exception {
		return new DashboardKpis() {
			{
				chiffreAffairesTotal = RandomTestUtil.randomLong();
				paiementsTotal = RandomTestUtil.randomLong();
				totalConcessionnaires = RandomTestUtil.randomLong();
				totalPointsDeVente = RandomTestUtil.randomLong();
			}
		};
	}

	protected DashboardResource dashboardResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(": ");
					sb.append(entry.getValue());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final com.liferay.portal.kernel.log.Log _log =
		LogFactoryUtil.getLog(BaseDashboardResourceTestCase.class);

	private static BeanUtilsBean _beanUtilsBean = new BeanUtilsBean() {

		@Override
		public void copyProperty(Object bean, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {

			if (value != null) {
				super.copyProperty(bean, name, value);
			}
		}

	};
	private static DateFormat _dateFormat;

	@Inject
	private com.df.lonis.ventesrest.resource.v1_0.DashboardResource
		_dashboardResource;

}