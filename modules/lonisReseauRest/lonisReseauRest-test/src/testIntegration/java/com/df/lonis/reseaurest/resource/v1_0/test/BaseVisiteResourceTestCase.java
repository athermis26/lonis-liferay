package com.df.lonis.reseaurest.resource.v1_0.test;

import com.df.lonis.reseaurest.client.dto.v1_0.Visite;
import com.df.lonis.reseaurest.client.http.HttpInvoker;
import com.df.lonis.reseaurest.client.pagination.Page;
import com.df.lonis.reseaurest.client.pagination.Pagination;
import com.df.lonis.reseaurest.client.resource.v1_0.VisiteResource;
import com.df.lonis.reseaurest.client.serdes.v1_0.VisiteSerDes;

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
public abstract class BaseVisiteResourceTestCase {

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

		_visiteResource.setContextCompany(testCompany);

		VisiteResource.Builder builder = VisiteResource.builder();

		visiteResource = builder.authentication(
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

		Visite visite1 = randomVisite();

		String json = objectMapper.writeValueAsString(visite1);

		Visite visite2 = VisiteSerDes.toDTO(json);

		Assert.assertTrue(equals(visite1, visite2));
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

		Visite visite = randomVisite();

		String json1 = objectMapper.writeValueAsString(visite);
		String json2 = VisiteSerDes.toJSON(visite);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Visite visite = randomVisite();

		visite.setCompteRendu(regex);

		String json = VisiteSerDes.toJSON(visite);

		Assert.assertFalse(json.contains(regex));

		visite = VisiteSerDes.toDTO(json);

		Assert.assertEquals(regex, visite.getCompteRendu());
	}

	@Test
	public void testGetVisitesPage() throws Exception {
		Page<Visite> page = visiteResource.getVisitesPage(
			null, null, RandomTestUtil.randomString(),
			RandomTestUtil.nextDate(), RandomTestUtil.nextDate(), null, null,
			Pagination.of(1, 10), null);

		long totalCount = page.getTotalCount();

		Visite visite1 = testGetVisitesPage_addVisite(randomVisite());

		Visite visite2 = testGetVisitesPage_addVisite(randomVisite());

		page = visiteResource.getVisitesPage(
			null, null, null, null, null, null, null, Pagination.of(1, 10),
			null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(visite1, (List<Visite>)page.getItems());
		assertContains(visite2, (List<Visite>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetVisitesPageWithFilterDateTimeEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Visite visite1 = randomVisite();

		visite1 = testGetVisitesPage_addVisite(visite1);

		for (EntityField entityField : entityFields) {
			Page<Visite> page = visiteResource.getVisitesPage(
				null, null, null, null, null, null,
				getFilterString(entityField, "between", visite1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(visite1),
				(List<Visite>)page.getItems());
		}
	}

	@Test
	public void testGetVisitesPageWithFilterStringEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Visite visite1 = testGetVisitesPage_addVisite(randomVisite());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Visite visite2 = testGetVisitesPage_addVisite(randomVisite());

		for (EntityField entityField : entityFields) {
			Page<Visite> page = visiteResource.getVisitesPage(
				null, null, null, null, null, null,
				getFilterString(entityField, "eq", visite1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(visite1),
				(List<Visite>)page.getItems());
		}
	}

	@Test
	public void testGetVisitesPageWithPagination() throws Exception {
		Page<Visite> totalPage = visiteResource.getVisitesPage(
			null, null, null, null, null, null, null, null, null);

		int totalCount = GetterUtil.getInteger(totalPage.getTotalCount());

		Visite visite1 = testGetVisitesPage_addVisite(randomVisite());

		Visite visite2 = testGetVisitesPage_addVisite(randomVisite());

		Visite visite3 = testGetVisitesPage_addVisite(randomVisite());

		Page<Visite> page1 = visiteResource.getVisitesPage(
			null, null, null, null, null, null, null,
			Pagination.of(1, totalCount + 2), null);

		List<Visite> visites1 = (List<Visite>)page1.getItems();

		Assert.assertEquals(
			visites1.toString(), totalCount + 2, visites1.size());

		Page<Visite> page2 = visiteResource.getVisitesPage(
			null, null, null, null, null, null, null,
			Pagination.of(2, totalCount + 2), null);

		Assert.assertEquals(totalCount + 3, page2.getTotalCount());

		List<Visite> visites2 = (List<Visite>)page2.getItems();

		Assert.assertEquals(visites2.toString(), 1, visites2.size());

		Page<Visite> page3 = visiteResource.getVisitesPage(
			null, null, null, null, null, null, null,
			Pagination.of(1, totalCount + 3), null);

		assertContains(visite1, (List<Visite>)page3.getItems());
		assertContains(visite2, (List<Visite>)page3.getItems());
		assertContains(visite3, (List<Visite>)page3.getItems());
	}

	@Test
	public void testGetVisitesPageWithSortDateTime() throws Exception {
		testGetVisitesPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, visite1, visite2) -> {
				BeanUtils.setProperty(
					visite1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetVisitesPageWithSortInteger() throws Exception {
		testGetVisitesPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, visite1, visite2) -> {
				BeanUtils.setProperty(visite1, entityField.getName(), 0);
				BeanUtils.setProperty(visite2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetVisitesPageWithSortString() throws Exception {
		testGetVisitesPageWithSort(
			EntityField.Type.STRING,
			(entityField, visite1, visite2) -> {
				Class<?> clazz = visite1.getClass();

				String entityFieldName = entityField.getName();

				java.lang.reflect.Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						visite1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						visite2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						visite1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						visite2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						visite1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						visite2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetVisitesPageWithSort(
			EntityField.Type type,
			UnsafeTriConsumer<EntityField, Visite, Visite, Exception>
				unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		Visite visite1 = randomVisite();
		Visite visite2 = randomVisite();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(entityField, visite1, visite2);
		}

		visite1 = testGetVisitesPage_addVisite(visite1);

		visite2 = testGetVisitesPage_addVisite(visite2);

		for (EntityField entityField : entityFields) {
			Page<Visite> ascPage = visiteResource.getVisitesPage(
				null, null, null, null, null, null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(visite1, visite2),
				(List<Visite>)ascPage.getItems());

			Page<Visite> descPage = visiteResource.getVisitesPage(
				null, null, null, null, null, null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(visite2, visite1),
				(List<Visite>)descPage.getItems());
		}
	}

	protected Visite testGetVisitesPage_addVisite(Visite visite)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetVisitesPage() throws Exception {
		GraphQLField graphQLField = new GraphQLField(
			"visites",
			new HashMap<String, Object>() {
				{
					put("page", 1);
					put("pageSize", 10);
				}
			},
			new GraphQLField("items", getGraphQLFields()),
			new GraphQLField("page"), new GraphQLField("totalCount"));

		JSONObject visitesJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/visites");

		long totalCount = visitesJSONObject.getLong("totalCount");

		Visite visite1 = testGraphQLVisite_addVisite();
		Visite visite2 = testGraphQLVisite_addVisite();

		visitesJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/visites");

		Assert.assertEquals(
			totalCount + 2, visitesJSONObject.getLong("totalCount"));

		assertContains(
			visite1,
			Arrays.asList(
				VisiteSerDes.toDTOs(visitesJSONObject.getString("items"))));
		assertContains(
			visite2,
			Arrays.asList(
				VisiteSerDes.toDTOs(visitesJSONObject.getString("items"))));
	}

	@Test
	public void testPostVisite() throws Exception {
		Visite randomVisite = randomVisite();

		Visite postVisite = testPostVisite_addVisite(randomVisite);

		assertEquals(randomVisite, postVisite);
		assertValid(postVisite);
	}

	protected Visite testPostVisite_addVisite(Visite visite) throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetVisite() throws Exception {
		Visite postVisite = testGetVisite_addVisite();

		Visite getVisite = visiteResource.getVisite(postVisite.getId());

		assertEquals(postVisite, getVisite);
		assertValid(getVisite);
	}

	protected Visite testGetVisite_addVisite() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetVisite() throws Exception {
		Visite visite = testGraphQLVisite_addVisite();

		Assert.assertTrue(
			equals(
				visite,
				VisiteSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"visite",
								new HashMap<String, Object>() {
									{
										put("visiteId", visite.getId());
									}
								},
								getGraphQLFields())),
						"JSONObject/data", "Object/visite"))));
	}

	@Test
	public void testGraphQLGetVisiteNotFound() throws Exception {
		Long irrelevantVisiteId = RandomTestUtil.randomLong();

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"visite",
						new HashMap<String, Object>() {
							{
								put("visiteId", irrelevantVisiteId);
							}
						},
						getGraphQLFields())),
				"JSONArray/errors", "Object/0", "JSONObject/extensions",
				"Object/code"));
	}

	@Test
	public void testGetVisitesTempsReel() throws Exception {
		Page<Visite> page = visiteResource.getVisitesTempsReel();

		long totalCount = page.getTotalCount();

		Visite visite1 = testGetVisitesTempsReel_addVisite(randomVisite());

		Visite visite2 = testGetVisitesTempsReel_addVisite(randomVisite());

		page = visiteResource.getVisitesTempsReel();

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(visite1, (List<Visite>)page.getItems());
		assertContains(visite2, (List<Visite>)page.getItems());
		assertValid(page);
	}

	protected Visite testGetVisitesTempsReel_addVisite(Visite visite)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetCommercialVisitesPage() throws Exception {
		Long commercialId = testGetCommercialVisitesPage_getCommercialId();
		Long irrelevantCommercialId =
			testGetCommercialVisitesPage_getIrrelevantCommercialId();

		Page<Visite> page = visiteResource.getCommercialVisitesPage(
			commercialId);

		Assert.assertEquals(0, page.getTotalCount());

		if (irrelevantCommercialId != null) {
			Visite irrelevantVisite = testGetCommercialVisitesPage_addVisite(
				irrelevantCommercialId, randomIrrelevantVisite());

			page = visiteResource.getCommercialVisitesPage(
				irrelevantCommercialId);

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantVisite), (List<Visite>)page.getItems());
			assertValid(page);
		}

		Visite visite1 = testGetCommercialVisitesPage_addVisite(
			commercialId, randomVisite());

		Visite visite2 = testGetCommercialVisitesPage_addVisite(
			commercialId, randomVisite());

		page = visiteResource.getCommercialVisitesPage(commercialId);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(visite1, visite2), (List<Visite>)page.getItems());
		assertValid(page);
	}

	protected Visite testGetCommercialVisitesPage_addVisite(
			Long commercialId, Visite visite)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetCommercialVisitesPage_getCommercialId()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetCommercialVisitesPage_getIrrelevantCommercialId()
		throws Exception {

		return null;
	}

	@Test
	public void testGetCommercialVisitesPlanningPage() throws Exception {
		Long commercialId =
			testGetCommercialVisitesPlanningPage_getCommercialId();
		Long irrelevantCommercialId =
			testGetCommercialVisitesPlanningPage_getIrrelevantCommercialId();

		Page<Visite> page = visiteResource.getCommercialVisitesPlanningPage(
			commercialId);

		Assert.assertEquals(0, page.getTotalCount());

		if (irrelevantCommercialId != null) {
			Visite irrelevantVisite =
				testGetCommercialVisitesPlanningPage_addVisite(
					irrelevantCommercialId, randomIrrelevantVisite());

			page = visiteResource.getCommercialVisitesPlanningPage(
				irrelevantCommercialId);

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantVisite), (List<Visite>)page.getItems());
			assertValid(page);
		}

		Visite visite1 = testGetCommercialVisitesPlanningPage_addVisite(
			commercialId, randomVisite());

		Visite visite2 = testGetCommercialVisitesPlanningPage_addVisite(
			commercialId, randomVisite());

		page = visiteResource.getCommercialVisitesPlanningPage(commercialId);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(visite1, visite2), (List<Visite>)page.getItems());
		assertValid(page);
	}

	protected Visite testGetCommercialVisitesPlanningPage_addVisite(
			Long commercialId, Visite visite)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetCommercialVisitesPlanningPage_getCommercialId()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long
			testGetCommercialVisitesPlanningPage_getIrrelevantCommercialId()
		throws Exception {

		return null;
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	protected Visite testGraphQLVisite_addVisite() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(Visite visite, List<Visite> visites) {
		boolean contains = false;

		for (Visite item : visites) {
			if (equals(visite, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(visites + " does not contain " + visite, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Visite visite1, Visite visite2) {
		Assert.assertTrue(
			visite1 + " does not equal " + visite2, equals(visite1, visite2));
	}

	protected void assertEquals(List<Visite> visites1, List<Visite> visites2) {
		Assert.assertEquals(visites1.size(), visites2.size());

		for (int i = 0; i < visites1.size(); i++) {
			Visite visite1 = visites1.get(i);
			Visite visite2 = visites2.get(i);

			assertEquals(visite1, visite2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Visite> visites1, List<Visite> visites2) {

		Assert.assertEquals(visites1.size(), visites2.size());

		for (Visite visite1 : visites1) {
			boolean contains = false;

			for (Visite visite2 : visites2) {
				if (equals(visite1, visite2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				visites2 + " does not contain " + visite1, contains);
		}
	}

	protected void assertValid(Visite visite) throws Exception {
		boolean valid = true;

		if (visite.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("commercialId", additionalAssertFieldName)) {
				if (visite.getCommercialId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("compteRendu", additionalAssertFieldName)) {
				if (visite.getCompteRendu() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("dateVisite", additionalAssertFieldName)) {
				if (visite.getDateVisite() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("latitude", additionalAssertFieldName)) {
				if (visite.getLatitude() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("longitude", additionalAssertFieldName)) {
				if (visite.getLongitude() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("statut", additionalAssertFieldName)) {
				if (visite.getStatut() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("terminalId", additionalAssertFieldName)) {
				if (visite.getTerminalId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("typeControle", additionalAssertFieldName)) {
				if (visite.getTypeControle() == null) {
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

	protected void assertValid(Page<Visite> page) {
		boolean valid = false;

		java.util.Collection<Visite> visites = page.getItems();

		int size = visites.size();

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
					com.df.lonis.reseaurest.dto.v1_0.Visite.class)) {

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

	protected boolean equals(Visite visite1, Visite visite2) {
		if (visite1 == visite2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("commercialId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						visite1.getCommercialId(), visite2.getCommercialId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("compteRendu", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						visite1.getCompteRendu(), visite2.getCompteRendu())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("dateVisite", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						visite1.getDateVisite(), visite2.getDateVisite())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(visite1.getId(), visite2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("latitude", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						visite1.getLatitude(), visite2.getLatitude())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("longitude", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						visite1.getLongitude(), visite2.getLongitude())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("statut", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						visite1.getStatut(), visite2.getStatut())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("terminalId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						visite1.getTerminalId(), visite2.getTerminalId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("typeControle", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						visite1.getTypeControle(), visite2.getTypeControle())) {

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

		if (!(_visiteResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_visiteResource;

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
		EntityField entityField, String operator, Visite visite) {

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

		if (entityFieldName.equals("compteRendu")) {
			sb.append("'");
			sb.append(String.valueOf(visite.getCompteRendu()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("dateVisite")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(visite.getDateVisite(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(visite.getDateVisite(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(visite.getDateVisite()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("latitude")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("longitude")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("statut")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("terminalId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("typeControle")) {
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

	protected Visite randomVisite() throws Exception {
		return new Visite() {
			{
				commercialId = RandomTestUtil.randomLong();
				compteRendu = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				dateVisite = RandomTestUtil.nextDate();
				id = RandomTestUtil.randomLong();
				latitude = RandomTestUtil.randomDouble();
				longitude = RandomTestUtil.randomDouble();
				terminalId = RandomTestUtil.randomLong();
			}
		};
	}

	protected Visite randomIrrelevantVisite() throws Exception {
		Visite randomIrrelevantVisite = randomVisite();

		return randomIrrelevantVisite;
	}

	protected Visite randomPatchVisite() throws Exception {
		return randomVisite();
	}

	protected VisiteResource visiteResource;
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
		LogFactoryUtil.getLog(BaseVisiteResourceTestCase.class);

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
	private com.df.lonis.reseaurest.resource.v1_0.VisiteResource
		_visiteResource;

}