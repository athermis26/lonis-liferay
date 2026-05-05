package com.df.lonis.reseaurest.resource.v1_0.test;

import com.df.lonis.reseaurest.client.dto.v1_0.Commercial;
import com.df.lonis.reseaurest.client.http.HttpInvoker;
import com.df.lonis.reseaurest.client.pagination.Page;
import com.df.lonis.reseaurest.client.pagination.Pagination;
import com.df.lonis.reseaurest.client.resource.v1_0.CommercialResource;
import com.df.lonis.reseaurest.client.serdes.v1_0.CommercialSerDes;

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
import com.liferay.portal.kernel.json.JSONArray;
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
public abstract class BaseCommercialResourceTestCase {

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

		_commercialResource.setContextCompany(testCompany);

		CommercialResource.Builder builder = CommercialResource.builder();

		commercialResource = builder.authentication(
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

		Commercial commercial1 = randomCommercial();

		String json = objectMapper.writeValueAsString(commercial1);

		Commercial commercial2 = CommercialSerDes.toDTO(json);

		Assert.assertTrue(equals(commercial1, commercial2));
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

		Commercial commercial = randomCommercial();

		String json1 = objectMapper.writeValueAsString(commercial);
		String json2 = CommercialSerDes.toJSON(commercial);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Commercial commercial = randomCommercial();

		commercial.setEmail(regex);
		commercial.setMatricule(regex);
		commercial.setNom(regex);
		commercial.setPrenoms(regex);
		commercial.setStatut(regex);
		commercial.setTelephone(regex);

		String json = CommercialSerDes.toJSON(commercial);

		Assert.assertFalse(json.contains(regex));

		commercial = CommercialSerDes.toDTO(json);

		Assert.assertEquals(regex, commercial.getEmail());
		Assert.assertEquals(regex, commercial.getMatricule());
		Assert.assertEquals(regex, commercial.getNom());
		Assert.assertEquals(regex, commercial.getPrenoms());
		Assert.assertEquals(regex, commercial.getStatut());
		Assert.assertEquals(regex, commercial.getTelephone());
	}

	@Test
	public void testGetCommerciauxPage() throws Exception {
		Page<Commercial> page = commercialResource.getCommerciauxPage(
			null, null, null, Pagination.of(1, 10), null);

		long totalCount = page.getTotalCount();

		Commercial commercial1 = testGetCommerciauxPage_addCommercial(
			randomCommercial());

		Commercial commercial2 = testGetCommerciauxPage_addCommercial(
			randomCommercial());

		page = commercialResource.getCommerciauxPage(
			null, null, null, Pagination.of(1, 10), null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(commercial1, (List<Commercial>)page.getItems());
		assertContains(commercial2, (List<Commercial>)page.getItems());
		assertValid(page);

		commercialResource.deleteCommercial(commercial1.getId());

		commercialResource.deleteCommercial(commercial2.getId());
	}

	@Test
	public void testGetCommerciauxPageWithFilterDateTimeEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Commercial commercial1 = randomCommercial();

		commercial1 = testGetCommerciauxPage_addCommercial(commercial1);

		for (EntityField entityField : entityFields) {
			Page<Commercial> page = commercialResource.getCommerciauxPage(
				null, null,
				getFilterString(entityField, "between", commercial1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(commercial1),
				(List<Commercial>)page.getItems());
		}
	}

	@Test
	public void testGetCommerciauxPageWithFilterStringEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Commercial commercial1 = testGetCommerciauxPage_addCommercial(
			randomCommercial());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Commercial commercial2 = testGetCommerciauxPage_addCommercial(
			randomCommercial());

		for (EntityField entityField : entityFields) {
			Page<Commercial> page = commercialResource.getCommerciauxPage(
				null, null, getFilterString(entityField, "eq", commercial1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(commercial1),
				(List<Commercial>)page.getItems());
		}
	}

	@Test
	public void testGetCommerciauxPageWithPagination() throws Exception {
		Page<Commercial> totalPage = commercialResource.getCommerciauxPage(
			null, null, null, null, null);

		int totalCount = GetterUtil.getInteger(totalPage.getTotalCount());

		Commercial commercial1 = testGetCommerciauxPage_addCommercial(
			randomCommercial());

		Commercial commercial2 = testGetCommerciauxPage_addCommercial(
			randomCommercial());

		Commercial commercial3 = testGetCommerciauxPage_addCommercial(
			randomCommercial());

		Page<Commercial> page1 = commercialResource.getCommerciauxPage(
			null, null, null, Pagination.of(1, totalCount + 2), null);

		List<Commercial> commercials1 = (List<Commercial>)page1.getItems();

		Assert.assertEquals(
			commercials1.toString(), totalCount + 2, commercials1.size());

		Page<Commercial> page2 = commercialResource.getCommerciauxPage(
			null, null, null, Pagination.of(2, totalCount + 2), null);

		Assert.assertEquals(totalCount + 3, page2.getTotalCount());

		List<Commercial> commercials2 = (List<Commercial>)page2.getItems();

		Assert.assertEquals(commercials2.toString(), 1, commercials2.size());

		Page<Commercial> page3 = commercialResource.getCommerciauxPage(
			null, null, null, Pagination.of(1, totalCount + 3), null);

		assertContains(commercial1, (List<Commercial>)page3.getItems());
		assertContains(commercial2, (List<Commercial>)page3.getItems());
		assertContains(commercial3, (List<Commercial>)page3.getItems());
	}

	@Test
	public void testGetCommerciauxPageWithSortDateTime() throws Exception {
		testGetCommerciauxPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, commercial1, commercial2) -> {
				BeanUtils.setProperty(
					commercial1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetCommerciauxPageWithSortInteger() throws Exception {
		testGetCommerciauxPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, commercial1, commercial2) -> {
				BeanUtils.setProperty(commercial1, entityField.getName(), 0);
				BeanUtils.setProperty(commercial2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetCommerciauxPageWithSortString() throws Exception {
		testGetCommerciauxPageWithSort(
			EntityField.Type.STRING,
			(entityField, commercial1, commercial2) -> {
				Class<?> clazz = commercial1.getClass();

				String entityFieldName = entityField.getName();

				java.lang.reflect.Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						commercial1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						commercial2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						commercial1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						commercial2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						commercial1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						commercial2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetCommerciauxPageWithSort(
			EntityField.Type type,
			UnsafeTriConsumer<EntityField, Commercial, Commercial, Exception>
				unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		Commercial commercial1 = randomCommercial();
		Commercial commercial2 = randomCommercial();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(entityField, commercial1, commercial2);
		}

		commercial1 = testGetCommerciauxPage_addCommercial(commercial1);

		commercial2 = testGetCommerciauxPage_addCommercial(commercial2);

		for (EntityField entityField : entityFields) {
			Page<Commercial> ascPage = commercialResource.getCommerciauxPage(
				null, null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(commercial1, commercial2),
				(List<Commercial>)ascPage.getItems());

			Page<Commercial> descPage = commercialResource.getCommerciauxPage(
				null, null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(commercial2, commercial1),
				(List<Commercial>)descPage.getItems());
		}
	}

	protected Commercial testGetCommerciauxPage_addCommercial(
			Commercial commercial)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPostCommercial() throws Exception {
		Commercial randomCommercial = randomCommercial();

		Commercial postCommercial = testPostCommercial_addCommercial(
			randomCommercial);

		assertEquals(randomCommercial, postCommercial);
		assertValid(postCommercial);
	}

	protected Commercial testPostCommercial_addCommercial(Commercial commercial)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteCommercial() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Commercial commercial = testDeleteCommercial_addCommercial();

		assertHttpResponseStatusCode(
			204,
			commercialResource.deleteCommercialHttpResponse(
				commercial.getId()));

		assertHttpResponseStatusCode(
			404,
			commercialResource.getCommercialHttpResponse(commercial.getId()));

		assertHttpResponseStatusCode(
			404, commercialResource.getCommercialHttpResponse(0L));
	}

	protected Commercial testDeleteCommercial_addCommercial() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLDeleteCommercial() throws Exception {
		Commercial commercial = testGraphQLCommercial_addCommercial();

		Assert.assertTrue(
			JSONUtil.getValueAsBoolean(
				invokeGraphQLMutation(
					new GraphQLField(
						"deleteCommercial",
						new HashMap<String, Object>() {
							{
								put("commercialId", commercial.getId());
							}
						})),
				"JSONObject/data", "Object/deleteCommercial"));

		JSONArray errorsJSONArray = JSONUtil.getValueAsJSONArray(
			invokeGraphQLQuery(
				new GraphQLField(
					"commercial",
					new HashMap<String, Object>() {
						{
							put("commercialId", commercial.getId());
						}
					},
					new GraphQLField("id"))),
			"JSONArray/errors");

		Assert.assertTrue(errorsJSONArray.length() > 0);
	}

	@Test
	public void testGetCommercial() throws Exception {
		Commercial postCommercial = testGetCommercial_addCommercial();

		Commercial getCommercial = commercialResource.getCommercial(
			postCommercial.getId());

		assertEquals(postCommercial, getCommercial);
		assertValid(getCommercial);
	}

	protected Commercial testGetCommercial_addCommercial() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetCommercial() throws Exception {
		Commercial commercial = testGraphQLCommercial_addCommercial();

		Assert.assertTrue(
			equals(
				commercial,
				CommercialSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"commercial",
								new HashMap<String, Object>() {
									{
										put("commercialId", commercial.getId());
									}
								},
								getGraphQLFields())),
						"JSONObject/data", "Object/commercial"))));
	}

	@Test
	public void testGraphQLGetCommercialNotFound() throws Exception {
		Long irrelevantCommercialId = RandomTestUtil.randomLong();

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"commercial",
						new HashMap<String, Object>() {
							{
								put("commercialId", irrelevantCommercialId);
							}
						},
						getGraphQLFields())),
				"JSONArray/errors", "Object/0", "JSONObject/extensions",
				"Object/code"));
	}

	@Test
	public void testPutCommercial() throws Exception {
		Commercial postCommercial = testPutCommercial_addCommercial();

		Commercial randomCommercial = randomCommercial();

		Commercial putCommercial = commercialResource.putCommercial(
			postCommercial.getId(), randomCommercial);

		assertEquals(randomCommercial, putCommercial);
		assertValid(putCommercial);

		Commercial getCommercial = commercialResource.getCommercial(
			putCommercial.getId());

		assertEquals(randomCommercial, getCommercial);
		assertValid(getCommercial);
	}

	protected Commercial testPutCommercial_addCommercial() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	protected Commercial testGraphQLCommercial_addCommercial()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(
		Commercial commercial, List<Commercial> commercials) {

		boolean contains = false;

		for (Commercial item : commercials) {
			if (equals(commercial, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			commercials + " does not contain " + commercial, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		Commercial commercial1, Commercial commercial2) {

		Assert.assertTrue(
			commercial1 + " does not equal " + commercial2,
			equals(commercial1, commercial2));
	}

	protected void assertEquals(
		List<Commercial> commercials1, List<Commercial> commercials2) {

		Assert.assertEquals(commercials1.size(), commercials2.size());

		for (int i = 0; i < commercials1.size(); i++) {
			Commercial commercial1 = commercials1.get(i);
			Commercial commercial2 = commercials2.get(i);

			assertEquals(commercial1, commercial2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Commercial> commercials1, List<Commercial> commercials2) {

		Assert.assertEquals(commercials1.size(), commercials2.size());

		for (Commercial commercial1 : commercials1) {
			boolean contains = false;

			for (Commercial commercial2 : commercials2) {
				if (equals(commercial1, commercial2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				commercials2 + " does not contain " + commercial1, contains);
		}
	}

	protected void assertValid(Commercial commercial) throws Exception {
		boolean valid = true;

		if (commercial.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("agenceId", additionalAssertFieldName)) {
				if (commercial.getAgenceId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("email", additionalAssertFieldName)) {
				if (commercial.getEmail() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("matricule", additionalAssertFieldName)) {
				if (commercial.getMatricule() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("nom", additionalAssertFieldName)) {
				if (commercial.getNom() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("prenoms", additionalAssertFieldName)) {
				if (commercial.getPrenoms() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("statut", additionalAssertFieldName)) {
				if (commercial.getStatut() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("superviseurId", additionalAssertFieldName)) {
				if (commercial.getSuperviseurId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("telephone", additionalAssertFieldName)) {
				if (commercial.getTelephone() == null) {
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

	protected void assertValid(Page<Commercial> page) {
		boolean valid = false;

		java.util.Collection<Commercial> commercials = page.getItems();

		int size = commercials.size();

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
					com.df.lonis.reseaurest.dto.v1_0.Commercial.class)) {

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

	protected boolean equals(Commercial commercial1, Commercial commercial2) {
		if (commercial1 == commercial2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("agenceId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						commercial1.getAgenceId(), commercial2.getAgenceId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("email", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						commercial1.getEmail(), commercial2.getEmail())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						commercial1.getId(), commercial2.getId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("matricule", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						commercial1.getMatricule(),
						commercial2.getMatricule())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("nom", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						commercial1.getNom(), commercial2.getNom())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("prenoms", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						commercial1.getPrenoms(), commercial2.getPrenoms())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("statut", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						commercial1.getStatut(), commercial2.getStatut())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("superviseurId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						commercial1.getSuperviseurId(),
						commercial2.getSuperviseurId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("telephone", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						commercial1.getTelephone(),
						commercial2.getTelephone())) {

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

		if (!(_commercialResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_commercialResource;

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
		EntityField entityField, String operator, Commercial commercial) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("agenceId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("email")) {
			sb.append("'");
			sb.append(String.valueOf(commercial.getEmail()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("matricule")) {
			sb.append("'");
			sb.append(String.valueOf(commercial.getMatricule()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("nom")) {
			sb.append("'");
			sb.append(String.valueOf(commercial.getNom()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("prenoms")) {
			sb.append("'");
			sb.append(String.valueOf(commercial.getPrenoms()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("statut")) {
			sb.append("'");
			sb.append(String.valueOf(commercial.getStatut()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("superviseurId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("telephone")) {
			sb.append("'");
			sb.append(String.valueOf(commercial.getTelephone()));
			sb.append("'");

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

	protected Commercial randomCommercial() throws Exception {
		return new Commercial() {
			{
				agenceId = RandomTestUtil.randomLong();
				email =
					StringUtil.toLowerCase(RandomTestUtil.randomString()) +
						"@liferay.com";
				id = RandomTestUtil.randomLong();
				matricule = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				nom = StringUtil.toLowerCase(RandomTestUtil.randomString());
				prenoms = StringUtil.toLowerCase(RandomTestUtil.randomString());
				statut = StringUtil.toLowerCase(RandomTestUtil.randomString());
				superviseurId = RandomTestUtil.randomLong();
				telephone = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
			}
		};
	}

	protected Commercial randomIrrelevantCommercial() throws Exception {
		Commercial randomIrrelevantCommercial = randomCommercial();

		return randomIrrelevantCommercial;
	}

	protected Commercial randomPatchCommercial() throws Exception {
		return randomCommercial();
	}

	protected CommercialResource commercialResource;
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
		LogFactoryUtil.getLog(BaseCommercialResourceTestCase.class);

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
	private com.df.lonis.reseaurest.resource.v1_0.CommercialResource
		_commercialResource;

}