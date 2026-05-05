package com.df.lonis.reseaurest.resource.v1_0.test;

import com.df.lonis.reseaurest.client.dto.v1_0.SiteCommercial;
import com.df.lonis.reseaurest.client.http.HttpInvoker;
import com.df.lonis.reseaurest.client.pagination.Page;
import com.df.lonis.reseaurest.client.pagination.Pagination;
import com.df.lonis.reseaurest.client.resource.v1_0.SiteCommercialResource;
import com.df.lonis.reseaurest.client.serdes.v1_0.SiteCommercialSerDes;

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
public abstract class BaseSiteCommercialResourceTestCase {

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

		_siteCommercialResource.setContextCompany(testCompany);

		SiteCommercialResource.Builder builder =
			SiteCommercialResource.builder();

		siteCommercialResource = builder.authentication(
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

		SiteCommercial siteCommercial1 = randomSiteCommercial();

		String json = objectMapper.writeValueAsString(siteCommercial1);

		SiteCommercial siteCommercial2 = SiteCommercialSerDes.toDTO(json);

		Assert.assertTrue(equals(siteCommercial1, siteCommercial2));
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

		SiteCommercial siteCommercial = randomSiteCommercial();

		String json1 = objectMapper.writeValueAsString(siteCommercial);
		String json2 = SiteCommercialSerDes.toJSON(siteCommercial);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		SiteCommercial siteCommercial = randomSiteCommercial();

		String json = SiteCommercialSerDes.toJSON(siteCommercial);

		Assert.assertFalse(json.contains(regex));

		siteCommercial = SiteCommercialSerDes.toDTO(json);
	}

	@Test
	public void testGetCommercialSitesPage() throws Exception {
		Long commercialId = testGetCommercialSitesPage_getCommercialId();
		Long irrelevantCommercialId =
			testGetCommercialSitesPage_getIrrelevantCommercialId();

		Page<SiteCommercial> page =
			siteCommercialResource.getCommercialSitesPage(commercialId);

		Assert.assertEquals(0, page.getTotalCount());

		if (irrelevantCommercialId != null) {
			SiteCommercial irrelevantSiteCommercial =
				testGetCommercialSitesPage_addSiteCommercial(
					irrelevantCommercialId, randomIrrelevantSiteCommercial());

			page = siteCommercialResource.getCommercialSitesPage(
				irrelevantCommercialId);

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantSiteCommercial),
				(List<SiteCommercial>)page.getItems());
			assertValid(page);
		}

		SiteCommercial siteCommercial1 =
			testGetCommercialSitesPage_addSiteCommercial(
				commercialId, randomSiteCommercial());

		SiteCommercial siteCommercial2 =
			testGetCommercialSitesPage_addSiteCommercial(
				commercialId, randomSiteCommercial());

		page = siteCommercialResource.getCommercialSitesPage(commercialId);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(siteCommercial1, siteCommercial2),
			(List<SiteCommercial>)page.getItems());
		assertValid(page);
	}

	protected SiteCommercial testGetCommercialSitesPage_addSiteCommercial(
			Long commercialId, SiteCommercial siteCommercial)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetCommercialSitesPage_getCommercialId()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetCommercialSitesPage_getIrrelevantCommercialId()
		throws Exception {

		return null;
	}

	@Test
	public void testPostCommercialSite() throws Exception {
		SiteCommercial randomSiteCommercial = randomSiteCommercial();

		SiteCommercial postSiteCommercial =
			testPostCommercialSite_addSiteCommercial(randomSiteCommercial);

		assertEquals(randomSiteCommercial, postSiteCommercial);
		assertValid(postSiteCommercial);
	}

	protected SiteCommercial testPostCommercialSite_addSiteCommercial(
			SiteCommercial siteCommercial)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteCommercialSite() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		SiteCommercial siteCommercial =
			testDeleteCommercialSite_addSiteCommercial();

		assertHttpResponseStatusCode(
			204,
			siteCommercialResource.deleteCommercialSiteHttpResponse(
				siteCommercial.getCommercialId(), siteCommercial.getSiteId()));
	}

	protected SiteCommercial testDeleteCommercialSite_addSiteCommercial()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetSiteCommerciauxPage() throws Exception {
		Long siteId = testGetSiteCommerciauxPage_getSiteId();
		Long irrelevantSiteId =
			testGetSiteCommerciauxPage_getIrrelevantSiteId();

		Page<SiteCommercial> page =
			siteCommercialResource.getSiteCommerciauxPage(
				siteId, null, null, Pagination.of(1, 10), null);

		Assert.assertEquals(0, page.getTotalCount());

		if (irrelevantSiteId != null) {
			SiteCommercial irrelevantSiteCommercial =
				testGetSiteCommerciauxPage_addSiteCommercial(
					irrelevantSiteId, randomIrrelevantSiteCommercial());

			page = siteCommercialResource.getSiteCommerciauxPage(
				irrelevantSiteId, null, null, Pagination.of(1, 2), null);

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantSiteCommercial),
				(List<SiteCommercial>)page.getItems());
			assertValid(page);
		}

		SiteCommercial siteCommercial1 =
			testGetSiteCommerciauxPage_addSiteCommercial(
				siteId, randomSiteCommercial());

		SiteCommercial siteCommercial2 =
			testGetSiteCommerciauxPage_addSiteCommercial(
				siteId, randomSiteCommercial());

		page = siteCommercialResource.getSiteCommerciauxPage(
			siteId, null, null, Pagination.of(1, 10), null);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(siteCommercial1, siteCommercial2),
			(List<SiteCommercial>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetSiteCommerciauxPageWithFilterDateTimeEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Long siteId = testGetSiteCommerciauxPage_getSiteId();

		SiteCommercial siteCommercial1 = randomSiteCommercial();

		siteCommercial1 = testGetSiteCommerciauxPage_addSiteCommercial(
			siteId, siteCommercial1);

		for (EntityField entityField : entityFields) {
			Page<SiteCommercial> page =
				siteCommercialResource.getSiteCommerciauxPage(
					siteId, null,
					getFilterString(entityField, "between", siteCommercial1),
					Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(siteCommercial1),
				(List<SiteCommercial>)page.getItems());
		}
	}

	@Test
	public void testGetSiteCommerciauxPageWithFilterStringEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Long siteId = testGetSiteCommerciauxPage_getSiteId();

		SiteCommercial siteCommercial1 =
			testGetSiteCommerciauxPage_addSiteCommercial(
				siteId, randomSiteCommercial());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		SiteCommercial siteCommercial2 =
			testGetSiteCommerciauxPage_addSiteCommercial(
				siteId, randomSiteCommercial());

		for (EntityField entityField : entityFields) {
			Page<SiteCommercial> page =
				siteCommercialResource.getSiteCommerciauxPage(
					siteId, null,
					getFilterString(entityField, "eq", siteCommercial1),
					Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(siteCommercial1),
				(List<SiteCommercial>)page.getItems());
		}
	}

	@Test
	public void testGetSiteCommerciauxPageWithPagination() throws Exception {
		Long siteId = testGetSiteCommerciauxPage_getSiteId();

		SiteCommercial siteCommercial1 =
			testGetSiteCommerciauxPage_addSiteCommercial(
				siteId, randomSiteCommercial());

		SiteCommercial siteCommercial2 =
			testGetSiteCommerciauxPage_addSiteCommercial(
				siteId, randomSiteCommercial());

		SiteCommercial siteCommercial3 =
			testGetSiteCommerciauxPage_addSiteCommercial(
				siteId, randomSiteCommercial());

		Page<SiteCommercial> page1 =
			siteCommercialResource.getSiteCommerciauxPage(
				siteId, null, null, Pagination.of(1, 2), null);

		List<SiteCommercial> siteCommercials1 =
			(List<SiteCommercial>)page1.getItems();

		Assert.assertEquals(
			siteCommercials1.toString(), 2, siteCommercials1.size());

		Page<SiteCommercial> page2 =
			siteCommercialResource.getSiteCommerciauxPage(
				siteId, null, null, Pagination.of(2, 2), null);

		Assert.assertEquals(3, page2.getTotalCount());

		List<SiteCommercial> siteCommercials2 =
			(List<SiteCommercial>)page2.getItems();

		Assert.assertEquals(
			siteCommercials2.toString(), 1, siteCommercials2.size());

		Page<SiteCommercial> page3 =
			siteCommercialResource.getSiteCommerciauxPage(
				siteId, null, null, Pagination.of(1, 3), null);

		assertEqualsIgnoringOrder(
			Arrays.asList(siteCommercial1, siteCommercial2, siteCommercial3),
			(List<SiteCommercial>)page3.getItems());
	}

	@Test
	public void testGetSiteCommerciauxPageWithSortDateTime() throws Exception {
		testGetSiteCommerciauxPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, siteCommercial1, siteCommercial2) -> {
				BeanUtils.setProperty(
					siteCommercial1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetSiteCommerciauxPageWithSortInteger() throws Exception {
		testGetSiteCommerciauxPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, siteCommercial1, siteCommercial2) -> {
				BeanUtils.setProperty(
					siteCommercial1, entityField.getName(), 0);
				BeanUtils.setProperty(
					siteCommercial2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetSiteCommerciauxPageWithSortString() throws Exception {
		testGetSiteCommerciauxPageWithSort(
			EntityField.Type.STRING,
			(entityField, siteCommercial1, siteCommercial2) -> {
				Class<?> clazz = siteCommercial1.getClass();

				String entityFieldName = entityField.getName();

				java.lang.reflect.Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						siteCommercial1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						siteCommercial2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						siteCommercial1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						siteCommercial2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						siteCommercial1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						siteCommercial2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetSiteCommerciauxPageWithSort(
			EntityField.Type type,
			UnsafeTriConsumer
				<EntityField, SiteCommercial, SiteCommercial, Exception>
					unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		Long siteId = testGetSiteCommerciauxPage_getSiteId();

		SiteCommercial siteCommercial1 = randomSiteCommercial();
		SiteCommercial siteCommercial2 = randomSiteCommercial();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(
				entityField, siteCommercial1, siteCommercial2);
		}

		siteCommercial1 = testGetSiteCommerciauxPage_addSiteCommercial(
			siteId, siteCommercial1);

		siteCommercial2 = testGetSiteCommerciauxPage_addSiteCommercial(
			siteId, siteCommercial2);

		for (EntityField entityField : entityFields) {
			Page<SiteCommercial> ascPage =
				siteCommercialResource.getSiteCommerciauxPage(
					siteId, null, null, Pagination.of(1, 2),
					entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(siteCommercial1, siteCommercial2),
				(List<SiteCommercial>)ascPage.getItems());

			Page<SiteCommercial> descPage =
				siteCommercialResource.getSiteCommerciauxPage(
					siteId, null, null, Pagination.of(1, 2),
					entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(siteCommercial2, siteCommercial1),
				(List<SiteCommercial>)descPage.getItems());
		}
	}

	protected SiteCommercial testGetSiteCommerciauxPage_addSiteCommercial(
			Long siteId, SiteCommercial siteCommercial)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetSiteCommerciauxPage_getSiteId() throws Exception {
		return testGroup.getGroupId();
	}

	protected Long testGetSiteCommerciauxPage_getIrrelevantSiteId()
		throws Exception {

		return irrelevantGroup.getGroupId();
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	protected SiteCommercial testGraphQLSiteCommercial_addSiteCommercial()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(
		SiteCommercial siteCommercial, List<SiteCommercial> siteCommercials) {

		boolean contains = false;

		for (SiteCommercial item : siteCommercials) {
			if (equals(siteCommercial, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			siteCommercials + " does not contain " + siteCommercial, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		SiteCommercial siteCommercial1, SiteCommercial siteCommercial2) {

		Assert.assertTrue(
			siteCommercial1 + " does not equal " + siteCommercial2,
			equals(siteCommercial1, siteCommercial2));
	}

	protected void assertEquals(
		List<SiteCommercial> siteCommercials1,
		List<SiteCommercial> siteCommercials2) {

		Assert.assertEquals(siteCommercials1.size(), siteCommercials2.size());

		for (int i = 0; i < siteCommercials1.size(); i++) {
			SiteCommercial siteCommercial1 = siteCommercials1.get(i);
			SiteCommercial siteCommercial2 = siteCommercials2.get(i);

			assertEquals(siteCommercial1, siteCommercial2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<SiteCommercial> siteCommercials1,
		List<SiteCommercial> siteCommercials2) {

		Assert.assertEquals(siteCommercials1.size(), siteCommercials2.size());

		for (SiteCommercial siteCommercial1 : siteCommercials1) {
			boolean contains = false;

			for (SiteCommercial siteCommercial2 : siteCommercials2) {
				if (equals(siteCommercial1, siteCommercial2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				siteCommercials2 + " does not contain " + siteCommercial1,
				contains);
		}
	}

	protected void assertValid(SiteCommercial siteCommercial) throws Exception {
		boolean valid = true;

		if (siteCommercial.getId() == null) {
			valid = false;
		}

		if (!Objects.equals(
				siteCommercial.getSiteId(), testGroup.getGroupId())) {

			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("commercialId", additionalAssertFieldName)) {
				if (siteCommercial.getCommercialId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("dateDebut", additionalAssertFieldName)) {
				if (siteCommercial.getDateDebut() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("dateFin", additionalAssertFieldName)) {
				if (siteCommercial.getDateFin() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("isPrincipal", additionalAssertFieldName)) {
				if (siteCommercial.getIsPrincipal() == null) {
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

	protected void assertValid(Page<SiteCommercial> page) {
		boolean valid = false;

		java.util.Collection<SiteCommercial> siteCommercials = page.getItems();

		int size = siteCommercials.size();

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

		graphQLFields.add(new GraphQLField("siteId"));

		for (java.lang.reflect.Field field :
				getDeclaredFields(
					com.df.lonis.reseaurest.dto.v1_0.SiteCommercial.class)) {

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

	protected boolean equals(
		SiteCommercial siteCommercial1, SiteCommercial siteCommercial2) {

		if (siteCommercial1 == siteCommercial2) {
			return true;
		}

		if (!Objects.equals(
				siteCommercial1.getSiteId(), siteCommercial2.getSiteId())) {

			return false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("commercialId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						siteCommercial1.getCommercialId(),
						siteCommercial2.getCommercialId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("dateDebut", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						siteCommercial1.getDateDebut(),
						siteCommercial2.getDateDebut())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("dateFin", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						siteCommercial1.getDateFin(),
						siteCommercial2.getDateFin())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						siteCommercial1.getId(), siteCommercial2.getId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("isPrincipal", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						siteCommercial1.getIsPrincipal(),
						siteCommercial2.getIsPrincipal())) {

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

		if (!(_siteCommercialResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_siteCommercialResource;

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
		EntityField entityField, String operator,
		SiteCommercial siteCommercial) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("commercialId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("dateDebut")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(
							siteCommercial.getDateDebut(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(
							siteCommercial.getDateDebut(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(siteCommercial.getDateDebut()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("dateFin")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(siteCommercial.getDateFin(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(siteCommercial.getDateFin(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(siteCommercial.getDateFin()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("isPrincipal")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("siteId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
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

	protected SiteCommercial randomSiteCommercial() throws Exception {
		return new SiteCommercial() {
			{
				commercialId = RandomTestUtil.randomLong();
				dateDebut = RandomTestUtil.nextDate();
				dateFin = RandomTestUtil.nextDate();
				id = RandomTestUtil.randomLong();
				isPrincipal = RandomTestUtil.randomBoolean();
				siteId = testGroup.getGroupId();
			}
		};
	}

	protected SiteCommercial randomIrrelevantSiteCommercial() throws Exception {
		SiteCommercial randomIrrelevantSiteCommercial = randomSiteCommercial();

		randomIrrelevantSiteCommercial.setSiteId(irrelevantGroup.getGroupId());

		return randomIrrelevantSiteCommercial;
	}

	protected SiteCommercial randomPatchSiteCommercial() throws Exception {
		return randomSiteCommercial();
	}

	protected SiteCommercialResource siteCommercialResource;
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
		LogFactoryUtil.getLog(BaseSiteCommercialResourceTestCase.class);

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
	private com.df.lonis.reseaurest.resource.v1_0.SiteCommercialResource
		_siteCommercialResource;

}