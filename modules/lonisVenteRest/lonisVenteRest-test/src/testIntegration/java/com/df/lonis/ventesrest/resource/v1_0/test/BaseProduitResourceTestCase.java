package com.df.lonis.ventesrest.resource.v1_0.test;

import com.df.lonis.ventesrest.client.dto.v1_0.Produit;
import com.df.lonis.ventesrest.client.http.HttpInvoker;
import com.df.lonis.ventesrest.client.pagination.Page;
import com.df.lonis.ventesrest.client.resource.v1_0.ProduitResource;
import com.df.lonis.ventesrest.client.serdes.v1_0.ProduitSerDes;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

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
public abstract class BaseProduitResourceTestCase {

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

		_produitResource.setContextCompany(testCompany);

		ProduitResource.Builder builder = ProduitResource.builder();

		produitResource = builder.authentication(
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

		Produit produit1 = randomProduit();

		String json = objectMapper.writeValueAsString(produit1);

		Produit produit2 = ProduitSerDes.toDTO(json);

		Assert.assertTrue(equals(produit1, produit2));
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

		Produit produit = randomProduit();

		String json1 = objectMapper.writeValueAsString(produit);
		String json2 = ProduitSerDes.toJSON(produit);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Produit produit = randomProduit();

		produit.setAbreviation(regex);
		produit.setCode(regex);
		produit.setLibelle(regex);

		String json = ProduitSerDes.toJSON(produit);

		Assert.assertFalse(json.contains(regex));

		produit = ProduitSerDes.toDTO(json);

		Assert.assertEquals(regex, produit.getAbreviation());
		Assert.assertEquals(regex, produit.getCode());
		Assert.assertEquals(regex, produit.getLibelle());
	}

	@Test
	public void testGetAllProduits() throws Exception {
		Page<Produit> page = produitResource.getAllProduits();

		long totalCount = page.getTotalCount();

		Produit produit1 = testGetAllProduits_addProduit(randomProduit());

		Produit produit2 = testGetAllProduits_addProduit(randomProduit());

		page = produitResource.getAllProduits();

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(produit1, (List<Produit>)page.getItems());
		assertContains(produit2, (List<Produit>)page.getItems());
		assertValid(page);
	}

	protected Produit testGetAllProduits_addProduit(Produit produit)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Produit testGraphQLProduit_addProduit() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(Produit produit, List<Produit> produits) {
		boolean contains = false;

		for (Produit item : produits) {
			if (equals(produit, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(produits + " does not contain " + produit, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Produit produit1, Produit produit2) {
		Assert.assertTrue(
			produit1 + " does not equal " + produit2,
			equals(produit1, produit2));
	}

	protected void assertEquals(
		List<Produit> produits1, List<Produit> produits2) {

		Assert.assertEquals(produits1.size(), produits2.size());

		for (int i = 0; i < produits1.size(); i++) {
			Produit produit1 = produits1.get(i);
			Produit produit2 = produits2.get(i);

			assertEquals(produit1, produit2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Produit> produits1, List<Produit> produits2) {

		Assert.assertEquals(produits1.size(), produits2.size());

		for (Produit produit1 : produits1) {
			boolean contains = false;

			for (Produit produit2 : produits2) {
				if (equals(produit1, produit2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				produits2 + " does not contain " + produit1, contains);
		}
	}

	protected void assertValid(Produit produit) throws Exception {
		boolean valid = true;

		if (produit.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("abreviation", additionalAssertFieldName)) {
				if (produit.getAbreviation() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("active", additionalAssertFieldName)) {
				if (produit.getActive() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("code", additionalAssertFieldName)) {
				if (produit.getCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("createdAt", additionalAssertFieldName)) {
				if (produit.getCreatedAt() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("libelle", additionalAssertFieldName)) {
				if (produit.getLibelle() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("updatedAt", additionalAssertFieldName)) {
				if (produit.getUpdatedAt() == null) {
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

	protected void assertValid(Page<Produit> page) {
		boolean valid = false;

		java.util.Collection<Produit> produits = page.getItems();

		int size = produits.size();

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
					com.df.lonis.ventesrest.dto.v1_0.Produit.class)) {

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

	protected boolean equals(Produit produit1, Produit produit2) {
		if (produit1 == produit2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("abreviation", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						produit1.getAbreviation(), produit2.getAbreviation())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("active", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						produit1.getActive(), produit2.getActive())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("code", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						produit1.getCode(), produit2.getCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("createdAt", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						produit1.getCreatedAt(), produit2.getCreatedAt())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(produit1.getId(), produit2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("libelle", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						produit1.getLibelle(), produit2.getLibelle())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("updatedAt", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						produit1.getUpdatedAt(), produit2.getUpdatedAt())) {

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

		if (!(_produitResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_produitResource;

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
		EntityField entityField, String operator, Produit produit) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("abreviation")) {
			sb.append("'");
			sb.append(String.valueOf(produit.getAbreviation()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("active")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("code")) {
			sb.append("'");
			sb.append(String.valueOf(produit.getCode()));
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
						DateUtils.addSeconds(produit.getCreatedAt(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(produit.getCreatedAt(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(produit.getCreatedAt()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("libelle")) {
			sb.append("'");
			sb.append(String.valueOf(produit.getLibelle()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("updatedAt")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(produit.getUpdatedAt(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(produit.getUpdatedAt(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(produit.getUpdatedAt()));
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

	protected Produit randomProduit() throws Exception {
		return new Produit() {
			{
				abreviation = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				active = RandomTestUtil.randomBoolean();
				code = StringUtil.toLowerCase(RandomTestUtil.randomString());
				createdAt = RandomTestUtil.nextDate();
				id = RandomTestUtil.randomLong();
				libelle = StringUtil.toLowerCase(RandomTestUtil.randomString());
				updatedAt = RandomTestUtil.nextDate();
			}
		};
	}

	protected Produit randomIrrelevantProduit() throws Exception {
		Produit randomIrrelevantProduit = randomProduit();

		return randomIrrelevantProduit;
	}

	protected Produit randomPatchProduit() throws Exception {
		return randomProduit();
	}

	protected ProduitResource produitResource;
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
		LogFactoryUtil.getLog(BaseProduitResourceTestCase.class);

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
	private com.df.lonis.ventesrest.resource.v1_0.ProduitResource
		_produitResource;

}