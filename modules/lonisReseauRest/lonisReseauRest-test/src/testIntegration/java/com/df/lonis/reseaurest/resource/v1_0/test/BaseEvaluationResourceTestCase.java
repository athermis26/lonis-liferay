package com.df.lonis.reseaurest.resource.v1_0.test;

import com.df.lonis.reseaurest.client.dto.v1_0.Evaluation;
import com.df.lonis.reseaurest.client.http.HttpInvoker;
import com.df.lonis.reseaurest.client.pagination.Page;
import com.df.lonis.reseaurest.client.resource.v1_0.EvaluationResource;
import com.df.lonis.reseaurest.client.serdes.v1_0.EvaluationSerDes;

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
public abstract class BaseEvaluationResourceTestCase {

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

		_evaluationResource.setContextCompany(testCompany);

		EvaluationResource.Builder builder = EvaluationResource.builder();

		evaluationResource = builder.authentication(
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

		Evaluation evaluation1 = randomEvaluation();

		String json = objectMapper.writeValueAsString(evaluation1);

		Evaluation evaluation2 = EvaluationSerDes.toDTO(json);

		Assert.assertTrue(equals(evaluation1, evaluation2));
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

		Evaluation evaluation = randomEvaluation();

		String json1 = objectMapper.writeValueAsString(evaluation);
		String json2 = EvaluationSerDes.toJSON(evaluation);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Evaluation evaluation = randomEvaluation();

		evaluation.setNom(regex);
		evaluation.setPrenoms(regex);

		String json = EvaluationSerDes.toJSON(evaluation);

		Assert.assertFalse(json.contains(regex));

		evaluation = EvaluationSerDes.toDTO(json);

		Assert.assertEquals(regex, evaluation.getNom());
		Assert.assertEquals(regex, evaluation.getPrenoms());
	}

	@Test
	public void testGetEvaluationsClassementPage() throws Exception {
		Page<Evaluation> page = evaluationResource.getEvaluationsClassementPage(
			null, null, null, RandomTestUtil.randomString());

		long totalCount = page.getTotalCount();

		Evaluation evaluation1 = testGetEvaluationsClassementPage_addEvaluation(
			randomEvaluation());

		Evaluation evaluation2 = testGetEvaluationsClassementPage_addEvaluation(
			randomEvaluation());

		page = evaluationResource.getEvaluationsClassementPage(
			null, null, null, null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(evaluation1, (List<Evaluation>)page.getItems());
		assertContains(evaluation2, (List<Evaluation>)page.getItems());
		assertValid(page);
	}

	protected Evaluation testGetEvaluationsClassementPage_addEvaluation(
			Evaluation evaluation)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetCommercialEvaluationsPage() throws Exception {
		Long commercialId = testGetCommercialEvaluationsPage_getCommercialId();
		Long irrelevantCommercialId =
			testGetCommercialEvaluationsPage_getIrrelevantCommercialId();

		Page<Evaluation> page = evaluationResource.getCommercialEvaluationsPage(
			commercialId, null, null);

		Assert.assertEquals(0, page.getTotalCount());

		if (irrelevantCommercialId != null) {
			Evaluation irrelevantEvaluation =
				testGetCommercialEvaluationsPage_addEvaluation(
					irrelevantCommercialId, randomIrrelevantEvaluation());

			page = evaluationResource.getCommercialEvaluationsPage(
				irrelevantCommercialId, null, null);

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantEvaluation),
				(List<Evaluation>)page.getItems());
			assertValid(page);
		}

		Evaluation evaluation1 = testGetCommercialEvaluationsPage_addEvaluation(
			commercialId, randomEvaluation());

		Evaluation evaluation2 = testGetCommercialEvaluationsPage_addEvaluation(
			commercialId, randomEvaluation());

		page = evaluationResource.getCommercialEvaluationsPage(
			commercialId, null, null);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(evaluation1, evaluation2),
			(List<Evaluation>)page.getItems());
		assertValid(page);
	}

	protected Evaluation testGetCommercialEvaluationsPage_addEvaluation(
			Long commercialId, Evaluation evaluation)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetCommercialEvaluationsPage_getCommercialId()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetCommercialEvaluationsPage_getIrrelevantCommercialId()
		throws Exception {

		return null;
	}

	@Test
	public void testPostEvaluationsGenerer() throws Exception {
		Assert.assertTrue(false);
	}

	protected Evaluation testGraphQLEvaluation_addEvaluation()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(
		Evaluation evaluation, List<Evaluation> evaluations) {

		boolean contains = false;

		for (Evaluation item : evaluations) {
			if (equals(evaluation, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			evaluations + " does not contain " + evaluation, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		Evaluation evaluation1, Evaluation evaluation2) {

		Assert.assertTrue(
			evaluation1 + " does not equal " + evaluation2,
			equals(evaluation1, evaluation2));
	}

	protected void assertEquals(
		List<Evaluation> evaluations1, List<Evaluation> evaluations2) {

		Assert.assertEquals(evaluations1.size(), evaluations2.size());

		for (int i = 0; i < evaluations1.size(); i++) {
			Evaluation evaluation1 = evaluations1.get(i);
			Evaluation evaluation2 = evaluations2.get(i);

			assertEquals(evaluation1, evaluation2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Evaluation> evaluations1, List<Evaluation> evaluations2) {

		Assert.assertEquals(evaluations1.size(), evaluations2.size());

		for (Evaluation evaluation1 : evaluations1) {
			boolean contains = false;

			for (Evaluation evaluation2 : evaluations2) {
				if (equals(evaluation1, evaluation2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				evaluations2 + " does not contain " + evaluation1, contains);
		}
	}

	protected void assertValid(Evaluation evaluation) throws Exception {
		boolean valid = true;

		if (evaluation.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("annee", additionalAssertFieldName)) {
				if (evaluation.getAnnee() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("commercialId", additionalAssertFieldName)) {
				if (evaluation.getCommercialId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("createdAt", additionalAssertFieldName)) {
				if (evaluation.getCreatedAt() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("mois", additionalAssertFieldName)) {
				if (evaluation.getMois() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"nbVisitesEffectuees", additionalAssertFieldName)) {

				if (evaluation.getNbVisitesEffectuees() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("nbVisitesPrevues", additionalAssertFieldName)) {
				if (evaluation.getNbVisitesPrevues() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("nom", additionalAssertFieldName)) {
				if (evaluation.getNom() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("periode", additionalAssertFieldName)) {
				if (evaluation.getPeriode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("prenoms", additionalAssertFieldName)) {
				if (evaluation.getPrenoms() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("rang", additionalAssertFieldName)) {
				if (evaluation.getRang() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("tauxRealisation", additionalAssertFieldName)) {
				if (evaluation.getTauxRealisation() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("trimestre", additionalAssertFieldName)) {
				if (evaluation.getTrimestre() == null) {
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

	protected void assertValid(Page<Evaluation> page) {
		boolean valid = false;

		java.util.Collection<Evaluation> evaluations = page.getItems();

		int size = evaluations.size();

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
					com.df.lonis.reseaurest.dto.v1_0.Evaluation.class)) {

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

	protected boolean equals(Evaluation evaluation1, Evaluation evaluation2) {
		if (evaluation1 == evaluation2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("annee", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						evaluation1.getAnnee(), evaluation2.getAnnee())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("commercialId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						evaluation1.getCommercialId(),
						evaluation2.getCommercialId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("createdAt", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						evaluation1.getCreatedAt(),
						evaluation2.getCreatedAt())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						evaluation1.getId(), evaluation2.getId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("mois", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						evaluation1.getMois(), evaluation2.getMois())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"nbVisitesEffectuees", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						evaluation1.getNbVisitesEffectuees(),
						evaluation2.getNbVisitesEffectuees())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("nbVisitesPrevues", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						evaluation1.getNbVisitesPrevues(),
						evaluation2.getNbVisitesPrevues())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("nom", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						evaluation1.getNom(), evaluation2.getNom())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("periode", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						evaluation1.getPeriode(), evaluation2.getPeriode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("prenoms", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						evaluation1.getPrenoms(), evaluation2.getPrenoms())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("rang", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						evaluation1.getRang(), evaluation2.getRang())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("tauxRealisation", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						evaluation1.getTauxRealisation(),
						evaluation2.getTauxRealisation())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("trimestre", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						evaluation1.getTrimestre(),
						evaluation2.getTrimestre())) {

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

		if (!(_evaluationResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_evaluationResource;

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
		EntityField entityField, String operator, Evaluation evaluation) {

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

		if (entityFieldName.equals("createdAt")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(evaluation.getCreatedAt(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(evaluation.getCreatedAt(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(evaluation.getCreatedAt()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("mois")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("nbVisitesEffectuees")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("nbVisitesPrevues")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("nom")) {
			sb.append("'");
			sb.append(String.valueOf(evaluation.getNom()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("periode")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("prenoms")) {
			sb.append("'");
			sb.append(String.valueOf(evaluation.getPrenoms()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("rang")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("tauxRealisation")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("trimestre")) {
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

	protected Evaluation randomEvaluation() throws Exception {
		return new Evaluation() {
			{
				annee = RandomTestUtil.randomInt();
				commercialId = RandomTestUtil.randomLong();
				createdAt = RandomTestUtil.nextDate();
				id = RandomTestUtil.randomLong();
				mois = RandomTestUtil.randomInt();
				nbVisitesEffectuees = RandomTestUtil.randomInt();
				nbVisitesPrevues = RandomTestUtil.randomInt();
				nom = StringUtil.toLowerCase(RandomTestUtil.randomString());
				prenoms = StringUtil.toLowerCase(RandomTestUtil.randomString());
				rang = RandomTestUtil.randomInt();
				tauxRealisation = RandomTestUtil.randomDouble();
				trimestre = RandomTestUtil.randomInt();
			}
		};
	}

	protected Evaluation randomIrrelevantEvaluation() throws Exception {
		Evaluation randomIrrelevantEvaluation = randomEvaluation();

		return randomIrrelevantEvaluation;
	}

	protected Evaluation randomPatchEvaluation() throws Exception {
		return randomEvaluation();
	}

	protected EvaluationResource evaluationResource;
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
		LogFactoryUtil.getLog(BaseEvaluationResourceTestCase.class);

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
	private com.df.lonis.reseaurest.resource.v1_0.EvaluationResource
		_evaluationResource;

}