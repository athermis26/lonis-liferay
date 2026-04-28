package com.df.lonis.ventesrest.resource.v1_0.test;

import com.df.lonis.ventesrest.client.dto.v1_0.Site;
import com.df.lonis.ventesrest.client.http.HttpInvoker;
import com.df.lonis.ventesrest.client.pagination.Page;
import com.df.lonis.ventesrest.client.pagination.Pagination;
import com.df.lonis.ventesrest.client.resource.v1_0.SiteResource;
import com.df.lonis.ventesrest.client.serdes.v1_0.SiteSerDes;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.petra.function.UnsafeTriConsumer;
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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.search.test.util.SearchTestRule;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import java.lang.reflect.InvocationTargetException;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.lang.time.DateUtils;

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
public abstract class BaseSiteResourceTestCase {

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

		_siteResource.setContextCompany(testCompany);

		SiteResource.Builder builder = SiteResource.builder();

		siteResource = builder.authentication(
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
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		Site site1 = randomSite();

		String json = objectMapper.writeValueAsString(site1);

		Site site2 = SiteSerDes.toDTO(json);

		Assert.assertTrue(equals(site1, site2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		Site site = randomSite();

		String json1 = objectMapper.writeValueAsString(site);
		String json2 = SiteSerDes.toJSON(site);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Site site = randomSite();

		site.setCode(regex);
		site.setCodeProvince(regex);
		site.setLibelle(regex);

		String json = SiteSerDes.toJSON(site);

		Assert.assertFalse(json.contains(regex));

		site = SiteSerDes.toDTO(json);

		Assert.assertEquals(regex, site.getCode());
		Assert.assertEquals(regex, site.getCodeProvince());
		Assert.assertEquals(regex, site.getLibelle());
	}

	@Test
	public void testGetSitesPage() throws Exception {
		Page<Site> page = siteResource.getSitesPage(
			null, null, Pagination.of(1, 10), null);

		long totalCount = page.getTotalCount();

		Site site1 = testGetSitesPage_addSite(randomSite());

		Site site2 = testGetSitesPage_addSite(randomSite());

		page = siteResource.getSitesPage(
			null, null, Pagination.of(1, 10), null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(site1, (List<Site>)page.getItems());
		assertContains(site2, (List<Site>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetSitesPageWithFilterDateTimeEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Site site1 = randomSite();

		site1 = testGetSitesPage_addSite(site1);

		for (EntityField entityField : entityFields) {
			Page<Site> page = siteResource.getSitesPage(
				null, getFilterString(entityField, "between", site1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(site1), (List<Site>)page.getItems());
		}
	}

	@Test
	public void testGetSitesPageWithFilterStringEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Site site1 = testGetSitesPage_addSite(randomSite());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Site site2 = testGetSitesPage_addSite(randomSite());

		for (EntityField entityField : entityFields) {
			Page<Site> page = siteResource.getSitesPage(
				null, getFilterString(entityField, "eq", site1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(site1), (List<Site>)page.getItems());
		}
	}

	@Test
	public void testGetSitesPageWithPagination() throws Exception {
		Page<Site> totalPage = siteResource.getSitesPage(
			null, null, null, null);

		int totalCount = GetterUtil.getInteger(totalPage.getTotalCount());

		Site site1 = testGetSitesPage_addSite(randomSite());

		Site site2 = testGetSitesPage_addSite(randomSite());

		Site site3 = testGetSitesPage_addSite(randomSite());

		Page<Site> page1 = siteResource.getSitesPage(
			null, null, Pagination.of(1, totalCount + 2), null);

		List<Site> sites1 = (List<Site>)page1.getItems();

		Assert.assertEquals(sites1.toString(), totalCount + 2, sites1.size());

		Page<Site> page2 = siteResource.getSitesPage(
			null, null, Pagination.of(2, totalCount + 2), null);

		Assert.assertEquals(totalCount + 3, page2.getTotalCount());

		List<Site> sites2 = (List<Site>)page2.getItems();

		Assert.assertEquals(sites2.toString(), 1, sites2.size());

		Page<Site> page3 = siteResource.getSitesPage(
			null, null, Pagination.of(1, totalCount + 3), null);

		assertContains(site1, (List<Site>)page3.getItems());
		assertContains(site2, (List<Site>)page3.getItems());
		assertContains(site3, (List<Site>)page3.getItems());
	}

	@Test
	public void testGetSitesPageWithSortDateTime() throws Exception {
		testGetSitesPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, site1, site2) -> {
				BeanUtils.setProperty(
					site1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetSitesPageWithSortInteger() throws Exception {
		testGetSitesPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, site1, site2) -> {
				BeanUtils.setProperty(site1, entityField.getName(), 0);
				BeanUtils.setProperty(site2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetSitesPageWithSortString() throws Exception {
		testGetSitesPageWithSort(
			EntityField.Type.STRING,
			(entityField, site1, site2) -> {
				Class<?> clazz = site1.getClass();

				String entityFieldName = entityField.getName();

				java.lang.reflect.Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						site1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						site2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						site1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						site2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						site1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						site2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetSitesPageWithSort(
			EntityField.Type type,
			UnsafeTriConsumer<EntityField, Site, Site, Exception>
				unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		Site site1 = randomSite();
		Site site2 = randomSite();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(entityField, site1, site2);
		}

		site1 = testGetSitesPage_addSite(site1);

		site2 = testGetSitesPage_addSite(site2);

		for (EntityField entityField : entityFields) {
			Page<Site> ascPage = siteResource.getSitesPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(site1, site2), (List<Site>)ascPage.getItems());

			Page<Site> descPage = siteResource.getSitesPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(site2, site1), (List<Site>)descPage.getItems());
		}
	}

	protected Site testGetSitesPage_addSite(Site site) throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetAllSites() throws Exception {
		Page<Site> page = siteResource.getAllSites();

		long totalCount = page.getTotalCount();

		Site site1 = testGetAllSites_addSite(randomSite());

		Site site2 = testGetAllSites_addSite(randomSite());

		page = siteResource.getAllSites();

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(site1, (List<Site>)page.getItems());
		assertContains(site2, (List<Site>)page.getItems());
		assertValid(page);
	}

	protected Site testGetAllSites_addSite(Site site) throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	protected Site testGraphQLSite_addSite() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(Site site, List<Site> sites) {
		boolean contains = false;

		for (Site item : sites) {
			if (equals(site, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(sites + " does not contain " + site, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Site site1, Site site2) {
		Assert.assertTrue(
			site1 + " does not equal " + site2, equals(site1, site2));
	}

	protected void assertEquals(List<Site> sites1, List<Site> sites2) {
		Assert.assertEquals(sites1.size(), sites2.size());

		for (int i = 0; i < sites1.size(); i++) {
			Site site1 = sites1.get(i);
			Site site2 = sites2.get(i);

			assertEquals(site1, site2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Site> sites1, List<Site> sites2) {

		Assert.assertEquals(sites1.size(), sites2.size());

		for (Site site1 : sites1) {
			boolean contains = false;

			for (Site site2 : sites2) {
				if (equals(site1, site2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(sites2 + " does not contain " + site1, contains);
		}
	}

	protected void assertValid(Site site) throws Exception {
		boolean valid = true;

		if (site.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("code", additionalAssertFieldName)) {
				if (site.getCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("codeProvince", additionalAssertFieldName)) {
				if (site.getCodeProvince() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("createdAt", additionalAssertFieldName)) {
				if (site.getCreatedAt() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("libelle", additionalAssertFieldName)) {
				if (site.getLibelle() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("parentId", additionalAssertFieldName)) {
				if (site.getParentId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (site.getStatus() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("type", additionalAssertFieldName)) {
				if (site.getType() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("updatedAt", additionalAssertFieldName)) {
				if (site.getUpdatedAt() == null) {
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

	protected void assertValid(Page<Site> page) {
		boolean valid = false;

		java.util.Collection<Site> sites = page.getItems();

		int size = sites.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field :
				getDeclaredFields(
					com.df.lonis.ventesrest.dto.v1_0.Site.class)) {

			if (!ArrayUtil.contains(
					getAdditionalAssertFieldNames(), field.getName())) {

				continue;
			}

			graphQLFields.addAll(getGraphQLFields(field));
		}

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

	protected boolean equals(Site site1, Site site2) {
		if (site1 == site2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("code", additionalAssertFieldName)) {
				if (!Objects.deepEquals(site1.getCode(), site2.getCode())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("codeProvince", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						site1.getCodeProvince(), site2.getCodeProvince())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("createdAt", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						site1.getCreatedAt(), site2.getCreatedAt())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(site1.getId(), site2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("libelle", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						site1.getLibelle(), site2.getLibelle())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("parentId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						site1.getParentId(), site2.getParentId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (!Objects.deepEquals(site1.getStatus(), site2.getStatus())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("type", additionalAssertFieldName)) {
				if (!Objects.deepEquals(site1.getType(), site2.getType())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("updatedAt", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						site1.getUpdatedAt(), site2.getUpdatedAt())) {

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

		if (!(_siteResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_siteResource;

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
		EntityField entityField, String operator, Site site) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("code")) {
			sb.append("'");
			sb.append(String.valueOf(site.getCode()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("codeProvince")) {
			sb.append("'");
			sb.append(String.valueOf(site.getCodeProvince()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("createdAt")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(site.getCreatedAt(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(site.getCreatedAt(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(site.getCreatedAt()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("libelle")) {
			sb.append("'");
			sb.append(String.valueOf(site.getLibelle()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("parentId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("status")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("type")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("updatedAt")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(site.getUpdatedAt(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(site.getUpdatedAt(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(site.getUpdatedAt()));
			}

			return sb.toString();
		}

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

	protected Site randomSite() throws Exception {
		return new Site() {
			{
				code = StringUtil.toLowerCase(RandomTestUtil.randomString());
				codeProvince = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				createdAt = RandomTestUtil.nextDate();
				id = RandomTestUtil.randomLong();
				libelle = StringUtil.toLowerCase(RandomTestUtil.randomString());
				parentId = RandomTestUtil.randomLong();
				status = RandomTestUtil.randomBoolean();
				type = RandomTestUtil.randomInt();
				updatedAt = RandomTestUtil.nextDate();
			}
		};
	}

	protected Site randomIrrelevantSite() throws Exception {
		Site randomIrrelevantSite = randomSite();

		return randomIrrelevantSite;
	}

	protected Site randomPatchSite() throws Exception {
		return randomSite();
	}

	protected SiteResource siteResource;
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
		LogFactoryUtil.getLog(BaseSiteResourceTestCase.class);

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
	private com.df.lonis.ventesrest.resource.v1_0.SiteResource _siteResource;

}