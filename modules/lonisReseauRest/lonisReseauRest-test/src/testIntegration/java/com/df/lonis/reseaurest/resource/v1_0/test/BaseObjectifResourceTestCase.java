package com.df.lonis.reseaurest.resource.v1_0.test;

import com.df.lonis.reseaurest.client.dto.v1_0.Objectif;
import com.df.lonis.reseaurest.client.http.HttpInvoker;
import com.df.lonis.reseaurest.client.pagination.Page;
import com.df.lonis.reseaurest.client.pagination.Pagination;
import com.df.lonis.reseaurest.client.resource.v1_0.ObjectifResource;
import com.df.lonis.reseaurest.client.serdes.v1_0.ObjectifSerDes;

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
public abstract class BaseObjectifResourceTestCase {

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

		_objectifResource.setContextCompany(testCompany);

		ObjectifResource.Builder builder = ObjectifResource.builder();

		objectifResource = builder.authentication(
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

		Objectif objectif1 = randomObjectif();

		String json = objectMapper.writeValueAsString(objectif1);

		Objectif objectif2 = ObjectifSerDes.toDTO(json);

		Assert.assertTrue(equals(objectif1, objectif2));
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

		Objectif objectif = randomObjectif();

		String json1 = objectMapper.writeValueAsString(objectif);
		String json2 = ObjectifSerDes.toJSON(objectif);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Objectif objectif = randomObjectif();

		String json = ObjectifSerDes.toJSON(objectif);

		Assert.assertFalse(json.contains(regex));

		objectif = ObjectifSerDes.toDTO(json);
	}

	@Test
	public void testGetObjectifsPage() throws Exception {
		Page<Objectif> page = objectifResource.getObjectifsPage(
			null, null, null, null, null, Pagination.of(1, 10), null);

		long totalCount = page.getTotalCount();

		Objectif objectif1 = testGetObjectifsPage_addObjectif(randomObjectif());

		Objectif objectif2 = testGetObjectifsPage_addObjectif(randomObjectif());

		page = objectifResource.getObjectifsPage(
			null, null, null, null, null, Pagination.of(1, 10), null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(objectif1, (List<Objectif>)page.getItems());
		assertContains(objectif2, (List<Objectif>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetObjectifsPageWithFilterDateTimeEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Objectif objectif1 = randomObjectif();

		objectif1 = testGetObjectifsPage_addObjectif(objectif1);

		for (EntityField entityField : entityFields) {
			Page<Objectif> page = objectifResource.getObjectifsPage(
				null, null, null, null,
				getFilterString(entityField, "between", objectif1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(objectif1),
				(List<Objectif>)page.getItems());
		}
	}

	@Test
	public void testGetObjectifsPageWithFilterStringEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Objectif objectif1 = testGetObjectifsPage_addObjectif(randomObjectif());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Objectif objectif2 = testGetObjectifsPage_addObjectif(randomObjectif());

		for (EntityField entityField : entityFields) {
			Page<Objectif> page = objectifResource.getObjectifsPage(
				null, null, null, null,
				getFilterString(entityField, "eq", objectif1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(objectif1),
				(List<Objectif>)page.getItems());
		}
	}

	@Test
	public void testGetObjectifsPageWithPagination() throws Exception {
		Page<Objectif> totalPage = objectifResource.getObjectifsPage(
			null, null, null, null, null, null, null);

		int totalCount = GetterUtil.getInteger(totalPage.getTotalCount());

		Objectif objectif1 = testGetObjectifsPage_addObjectif(randomObjectif());

		Objectif objectif2 = testGetObjectifsPage_addObjectif(randomObjectif());

		Objectif objectif3 = testGetObjectifsPage_addObjectif(randomObjectif());

		Page<Objectif> page1 = objectifResource.getObjectifsPage(
			null, null, null, null, null, Pagination.of(1, totalCount + 2),
			null);

		List<Objectif> objectifs1 = (List<Objectif>)page1.getItems();

		Assert.assertEquals(
			objectifs1.toString(), totalCount + 2, objectifs1.size());

		Page<Objectif> page2 = objectifResource.getObjectifsPage(
			null, null, null, null, null, Pagination.of(2, totalCount + 2),
			null);

		Assert.assertEquals(totalCount + 3, page2.getTotalCount());

		List<Objectif> objectifs2 = (List<Objectif>)page2.getItems();

		Assert.assertEquals(objectifs2.toString(), 1, objectifs2.size());

		Page<Objectif> page3 = objectifResource.getObjectifsPage(
			null, null, null, null, null, Pagination.of(1, totalCount + 3),
			null);

		assertContains(objectif1, (List<Objectif>)page3.getItems());
		assertContains(objectif2, (List<Objectif>)page3.getItems());
		assertContains(objectif3, (List<Objectif>)page3.getItems());
	}

	@Test
	public void testGetObjectifsPageWithSortDateTime() throws Exception {
		testGetObjectifsPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, objectif1, objectif2) -> {
				BeanUtils.setProperty(
					objectif1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetObjectifsPageWithSortInteger() throws Exception {
		testGetObjectifsPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, objectif1, objectif2) -> {
				BeanUtils.setProperty(objectif1, entityField.getName(), 0);
				BeanUtils.setProperty(objectif2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetObjectifsPageWithSortString() throws Exception {
		testGetObjectifsPageWithSort(
			EntityField.Type.STRING,
			(entityField, objectif1, objectif2) -> {
				Class<?> clazz = objectif1.getClass();

				String entityFieldName = entityField.getName();

				java.lang.reflect.Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						objectif1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						objectif2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						objectif1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						objectif2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						objectif1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						objectif2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetObjectifsPageWithSort(
			EntityField.Type type,
			UnsafeTriConsumer<EntityField, Objectif, Objectif, Exception>
				unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		Objectif objectif1 = randomObjectif();
		Objectif objectif2 = randomObjectif();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(entityField, objectif1, objectif2);
		}

		objectif1 = testGetObjectifsPage_addObjectif(objectif1);

		objectif2 = testGetObjectifsPage_addObjectif(objectif2);

		for (EntityField entityField : entityFields) {
			Page<Objectif> ascPage = objectifResource.getObjectifsPage(
				null, null, null, null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(objectif1, objectif2),
				(List<Objectif>)ascPage.getItems());

			Page<Objectif> descPage = objectifResource.getObjectifsPage(
				null, null, null, null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(objectif2, objectif1),
				(List<Objectif>)descPage.getItems());
		}
	}

	protected Objectif testGetObjectifsPage_addObjectif(Objectif objectif)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetObjectifsPage() throws Exception {
		GraphQLField graphQLField = new GraphQLField(
			"objectifs",
			new HashMap<String, Object>() {
				{
					put("page", 1);
					put("pageSize", 10);
				}
			},
			new GraphQLField("items", getGraphQLFields()),
			new GraphQLField("page"), new GraphQLField("totalCount"));

		JSONObject objectifsJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/objectifs");

		long totalCount = objectifsJSONObject.getLong("totalCount");

		Objectif objectif1 = testGraphQLObjectif_addObjectif();
		Objectif objectif2 = testGraphQLObjectif_addObjectif();

		objectifsJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/objectifs");

		Assert.assertEquals(
			totalCount + 2, objectifsJSONObject.getLong("totalCount"));

		assertContains(
			objectif1,
			Arrays.asList(
				ObjectifSerDes.toDTOs(objectifsJSONObject.getString("items"))));
		assertContains(
			objectif2,
			Arrays.asList(
				ObjectifSerDes.toDTOs(objectifsJSONObject.getString("items"))));
	}

	@Test
	public void testPostObjectif() throws Exception {
		Objectif randomObjectif = randomObjectif();

		Objectif postObjectif = testPostObjectif_addObjectif(randomObjectif);

		assertEquals(randomObjectif, postObjectif);
		assertValid(postObjectif);
	}

	protected Objectif testPostObjectif_addObjectif(Objectif objectif)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPutObjectif() throws Exception {
		Objectif postObjectif = testPutObjectif_addObjectif();

		Objectif randomObjectif = randomObjectif();

		Objectif putObjectif = objectifResource.putObjectif(
			postObjectif.getId(), randomObjectif);

		assertEquals(randomObjectif, putObjectif);
		assertValid(putObjectif);

		Objectif getObjectif = objectifResource.getObjectif(
			putObjectif.getId());

		assertEquals(randomObjectif, getObjectif);
		assertValid(getObjectif);
	}

	protected Objectif testPutObjectif_addObjectif() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetCommercialObjectifsPage() throws Exception {
		Long commercialId = testGetCommercialObjectifsPage_getCommercialId();
		Long irrelevantCommercialId =
			testGetCommercialObjectifsPage_getIrrelevantCommercialId();

		Page<Objectif> page = objectifResource.getCommercialObjectifsPage(
			commercialId);

		Assert.assertEquals(0, page.getTotalCount());

		if (irrelevantCommercialId != null) {
			Objectif irrelevantObjectif =
				testGetCommercialObjectifsPage_addObjectif(
					irrelevantCommercialId, randomIrrelevantObjectif());

			page = objectifResource.getCommercialObjectifsPage(
				irrelevantCommercialId);

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantObjectif),
				(List<Objectif>)page.getItems());
			assertValid(page);
		}

		Objectif objectif1 = testGetCommercialObjectifsPage_addObjectif(
			commercialId, randomObjectif());

		Objectif objectif2 = testGetCommercialObjectifsPage_addObjectif(
			commercialId, randomObjectif());

		page = objectifResource.getCommercialObjectifsPage(commercialId);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(objectif1, objectif2),
			(List<Objectif>)page.getItems());
		assertValid(page);
	}

	protected Objectif testGetCommercialObjectifsPage_addObjectif(
			Long commercialId, Objectif objectif)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetCommercialObjectifsPage_getCommercialId()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetCommercialObjectifsPage_getIrrelevantCommercialId()
		throws Exception {

		return null;
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	protected Objectif testGraphQLObjectif_addObjectif() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(Objectif objectif, List<Objectif> objectifs) {
		boolean contains = false;

		for (Objectif item : objectifs) {
			if (equals(objectif, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			objectifs + " does not contain " + objectif, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Objectif objectif1, Objectif objectif2) {
		Assert.assertTrue(
			objectif1 + " does not equal " + objectif2,
			equals(objectif1, objectif2));
	}

	protected void assertEquals(
		List<Objectif> objectifs1, List<Objectif> objectifs2) {

		Assert.assertEquals(objectifs1.size(), objectifs2.size());

		for (int i = 0; i < objectifs1.size(); i++) {
			Objectif objectif1 = objectifs1.get(i);
			Objectif objectif2 = objectifs2.get(i);

			assertEquals(objectif1, objectif2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Objectif> objectifs1, List<Objectif> objectifs2) {

		Assert.assertEquals(objectifs1.size(), objectifs2.size());

		for (Objectif objectif1 : objectifs1) {
			boolean contains = false;

			for (Objectif objectif2 : objectifs2) {
				if (equals(objectif1, objectif2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				objectifs2 + " does not contain " + objectif1, contains);
		}
	}

	protected void assertValid(Objectif objectif) throws Exception {
		boolean valid = true;

		if (objectif.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("annee", additionalAssertFieldName)) {
				if (objectif.getAnnee() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("commercialId", additionalAssertFieldName)) {
				if (objectif.getCommercialId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("mois", additionalAssertFieldName)) {
				if (objectif.getMois() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("periode", additionalAssertFieldName)) {
				if (objectif.getPeriode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("trimestre", additionalAssertFieldName)) {
				if (objectif.getTrimestre() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("type", additionalAssertFieldName)) {
				if (objectif.getType() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("valeurCible", additionalAssertFieldName)) {
				if (objectif.getValeurCible() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("valeurReelle", additionalAssertFieldName)) {
				if (objectif.getValeurReelle() == null) {
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

	protected void assertValid(Page<Objectif> page) {
		boolean valid = false;

		java.util.Collection<Objectif> objectifs = page.getItems();

		int size = objectifs.size();

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
					com.df.lonis.reseaurest.dto.v1_0.Objectif.class)) {

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

	protected boolean equals(Objectif objectif1, Objectif objectif2) {
		if (objectif1 == objectif2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("annee", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						objectif1.getAnnee(), objectif2.getAnnee())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("commercialId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						objectif1.getCommercialId(),
						objectif2.getCommercialId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(objectif1.getId(), objectif2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("mois", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						objectif1.getMois(), objectif2.getMois())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("periode", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						objectif1.getPeriode(), objectif2.getPeriode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("trimestre", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						objectif1.getTrimestre(), objectif2.getTrimestre())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("type", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						objectif1.getType(), objectif2.getType())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("valeurCible", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						objectif1.getValeurCible(),
						objectif2.getValeurCible())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("valeurReelle", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						objectif1.getValeurReelle(),
						objectif2.getValeurReelle())) {

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

		if (!(_objectifResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_objectifResource;

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
		EntityField entityField, String operator, Objectif objectif) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("annee")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("commercialId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("mois")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("periode")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("trimestre")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("type")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("valeurCible")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("valeurReelle")) {
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

	protected Objectif randomObjectif() throws Exception {
		return new Objectif() {
			{
				annee = RandomTestUtil.randomInt();
				commercialId = RandomTestUtil.randomLong();
				id = RandomTestUtil.randomLong();
				mois = RandomTestUtil.randomInt();
				trimestre = RandomTestUtil.randomInt();
				valeurCible = RandomTestUtil.randomInt();
				valeurReelle = RandomTestUtil.randomInt();
			}
		};
	}

	protected Objectif randomIrrelevantObjectif() throws Exception {
		Objectif randomIrrelevantObjectif = randomObjectif();

		return randomIrrelevantObjectif;
	}

	protected Objectif randomPatchObjectif() throws Exception {
		return randomObjectif();
	}

	protected ObjectifResource objectifResource;
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
		LogFactoryUtil.getLog(BaseObjectifResourceTestCase.class);

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
	private com.df.lonis.reseaurest.resource.v1_0.ObjectifResource
		_objectifResource;

}