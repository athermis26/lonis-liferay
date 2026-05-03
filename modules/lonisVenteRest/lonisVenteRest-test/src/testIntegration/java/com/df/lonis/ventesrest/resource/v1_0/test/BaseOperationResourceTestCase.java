package com.df.lonis.ventesrest.resource.v1_0.test;

import com.df.lonis.ventesrest.client.dto.v1_0.Operation;
import com.df.lonis.ventesrest.client.dto.v1_0.OperationDetail;
import com.df.lonis.ventesrest.client.http.HttpInvoker;
import com.df.lonis.ventesrest.client.pagination.Page;
import com.df.lonis.ventesrest.client.pagination.Pagination;
import com.df.lonis.ventesrest.client.resource.v1_0.OperationResource;
import com.df.lonis.ventesrest.client.serdes.v1_0.OperationSerDes;

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
public abstract class BaseOperationResourceTestCase {

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

		_operationResource.setContextCompany(testCompany);

		OperationResource.Builder builder = OperationResource.builder();

		operationResource = builder.authentication(
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

		Operation operation1 = randomOperation();

		String json = objectMapper.writeValueAsString(operation1);

		Operation operation2 = OperationSerDes.toDTO(json);

		Assert.assertTrue(equals(operation1, operation2));
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

		Operation operation = randomOperation();

		String json1 = objectMapper.writeValueAsString(operation);
		String json2 = OperationSerDes.toJSON(operation);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Operation operation = randomOperation();

		operation.setCode(regex);
		operation.setCodeTerminal(regex);
		operation.setGuichet(regex);
		operation.setLibelle(regex);
		operation.setReference(regex);
		operation.setStatut(regex);

		String json = OperationSerDes.toJSON(operation);

		Assert.assertFalse(json.contains(regex));

		operation = OperationSerDes.toDTO(json);

		Assert.assertEquals(regex, operation.getCode());
		Assert.assertEquals(regex, operation.getCodeTerminal());
		Assert.assertEquals(regex, operation.getGuichet());
		Assert.assertEquals(regex, operation.getLibelle());
		Assert.assertEquals(regex, operation.getReference());
		Assert.assertEquals(regex, operation.getStatut());
	}

	@Test
	public void testGetOperationsPage() throws Exception {
		Page<Operation> page = operationResource.getOperationsPage(
			null, null, Pagination.of(1, 10), null);

		long totalCount = page.getTotalCount();

		Operation operation1 = testGetOperationsPage_addOperation(
			randomOperation());

		Operation operation2 = testGetOperationsPage_addOperation(
			randomOperation());

		page = operationResource.getOperationsPage(
			null, null, Pagination.of(1, 10), null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(operation1, (List<Operation>)page.getItems());
		assertContains(operation2, (List<Operation>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetOperationsPageWithFilterDateTimeEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Operation operation1 = randomOperation();

		operation1 = testGetOperationsPage_addOperation(operation1);

		for (EntityField entityField : entityFields) {
			Page<Operation> page = operationResource.getOperationsPage(
				null, getFilterString(entityField, "between", operation1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(operation1),
				(List<Operation>)page.getItems());
		}
	}

	@Test
	public void testGetOperationsPageWithFilterStringEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Operation operation1 = testGetOperationsPage_addOperation(
			randomOperation());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Operation operation2 = testGetOperationsPage_addOperation(
			randomOperation());

		for (EntityField entityField : entityFields) {
			Page<Operation> page = operationResource.getOperationsPage(
				null, getFilterString(entityField, "eq", operation1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(operation1),
				(List<Operation>)page.getItems());
		}
	}

	@Test
	public void testGetOperationsPageWithPagination() throws Exception {
		Page<Operation> totalPage = operationResource.getOperationsPage(
			null, null, null, null);

		int totalCount = GetterUtil.getInteger(totalPage.getTotalCount());

		Operation operation1 = testGetOperationsPage_addOperation(
			randomOperation());

		Operation operation2 = testGetOperationsPage_addOperation(
			randomOperation());

		Operation operation3 = testGetOperationsPage_addOperation(
			randomOperation());

		Page<Operation> page1 = operationResource.getOperationsPage(
			null, null, Pagination.of(1, totalCount + 2), null);

		List<Operation> operations1 = (List<Operation>)page1.getItems();

		Assert.assertEquals(
			operations1.toString(), totalCount + 2, operations1.size());

		Page<Operation> page2 = operationResource.getOperationsPage(
			null, null, Pagination.of(2, totalCount + 2), null);

		Assert.assertEquals(totalCount + 3, page2.getTotalCount());

		List<Operation> operations2 = (List<Operation>)page2.getItems();

		Assert.assertEquals(operations2.toString(), 1, operations2.size());

		Page<Operation> page3 = operationResource.getOperationsPage(
			null, null, Pagination.of(1, totalCount + 3), null);

		assertContains(operation1, (List<Operation>)page3.getItems());
		assertContains(operation2, (List<Operation>)page3.getItems());
		assertContains(operation3, (List<Operation>)page3.getItems());
	}

	@Test
	public void testGetOperationsPageWithSortDateTime() throws Exception {
		testGetOperationsPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, operation1, operation2) -> {
				BeanUtils.setProperty(
					operation1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetOperationsPageWithSortInteger() throws Exception {
		testGetOperationsPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, operation1, operation2) -> {
				BeanUtils.setProperty(operation1, entityField.getName(), 0);
				BeanUtils.setProperty(operation2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetOperationsPageWithSortString() throws Exception {
		testGetOperationsPageWithSort(
			EntityField.Type.STRING,
			(entityField, operation1, operation2) -> {
				Class<?> clazz = operation1.getClass();

				String entityFieldName = entityField.getName();

				java.lang.reflect.Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						operation1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						operation2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						operation1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						operation2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						operation1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						operation2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetOperationsPageWithSort(
			EntityField.Type type,
			UnsafeTriConsumer<EntityField, Operation, Operation, Exception>
				unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		Operation operation1 = randomOperation();
		Operation operation2 = randomOperation();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(entityField, operation1, operation2);
		}

		operation1 = testGetOperationsPage_addOperation(operation1);

		operation2 = testGetOperationsPage_addOperation(operation2);

		for (EntityField entityField : entityFields) {
			Page<Operation> ascPage = operationResource.getOperationsPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(operation1, operation2),
				(List<Operation>)ascPage.getItems());

			Page<Operation> descPage = operationResource.getOperationsPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(operation2, operation1),
				(List<Operation>)descPage.getItems());
		}
	}

	protected Operation testGetOperationsPage_addOperation(Operation operation)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testExportOperations() throws Exception {
		Assert.assertTrue(false);
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	@Test
	public void testGetOperation() throws Exception {
		Operation postOperation = testGetOperation_addOperation();

		OperationDetail postOperationDetail =
			testGetOperation_addOperationDetail(
				postOperation.getId(), randomOperationDetail());

		OperationDetail getOperationDetail = operationResource.getOperation(
			postOperation.getId());

		assertEquals(postOperationDetail, getOperationDetail);
		assertValid(getOperationDetail);
	}

	protected OperationDetail testGetOperation_addOperationDetail(
			long operationId, OperationDetail operationDetail)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Operation testGraphQLOperation_addOperation() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(
		Operation operation, List<Operation> operations) {

		boolean contains = false;

		for (Operation item : operations) {
			if (equals(operation, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			operations + " does not contain " + operation, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Operation operation1, Operation operation2) {
		Assert.assertTrue(
			operation1 + " does not equal " + operation2,
			equals(operation1, operation2));
	}

	protected void assertEquals(
		List<Operation> operations1, List<Operation> operations2) {

		Assert.assertEquals(operations1.size(), operations2.size());

		for (int i = 0; i < operations1.size(); i++) {
			Operation operation1 = operations1.get(i);
			Operation operation2 = operations2.get(i);

			assertEquals(operation1, operation2);
		}
	}

	protected void assertEquals(
		OperationDetail operationDetail1, OperationDetail operationDetail2) {

		Assert.assertTrue(
			operationDetail1 + " does not equal " + operationDetail2,
			equals(operationDetail1, operationDetail2));
	}

	protected void assertEqualsIgnoringOrder(
		List<Operation> operations1, List<Operation> operations2) {

		Assert.assertEquals(operations1.size(), operations2.size());

		for (Operation operation1 : operations1) {
			boolean contains = false;

			for (Operation operation2 : operations2) {
				if (equals(operation1, operation2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				operations2 + " does not contain " + operation1, contains);
		}
	}

	protected void assertValid(Operation operation) throws Exception {
		boolean valid = true;

		if (operation.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("code", additionalAssertFieldName)) {
				if (operation.getCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("codeTerminal", additionalAssertFieldName)) {
				if (operation.getCodeTerminal() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("dateOperation", additionalAssertFieldName)) {
				if (operation.getDateOperation() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("guichet", additionalAssertFieldName)) {
				if (operation.getGuichet() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("libelle", additionalAssertFieldName)) {
				if (operation.getLibelle() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("montant", additionalAssertFieldName)) {
				if (operation.getMontant() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("montantReel", additionalAssertFieldName)) {
				if (operation.getMontantReel() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("reference", additionalAssertFieldName)) {
				if (operation.getReference() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("statut", additionalAssertFieldName)) {
				if (operation.getStatut() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("terminalId", additionalAssertFieldName)) {
				if (operation.getTerminalId() == null) {
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

	protected void assertValid(Page<Operation> page) {
		boolean valid = false;

		java.util.Collection<Operation> operations = page.getItems();

		int size = operations.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(OperationDetail operationDetail) {
		boolean valid = true;

		if (operationDetail.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalOperationDetailAssertFieldNames()) {

			if (Objects.equals("codeOperation", additionalAssertFieldName)) {
				if (operationDetail.getCodeOperation() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("codeTerminal", additionalAssertFieldName)) {
				if (operationDetail.getCodeTerminal() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("dateHeure", additionalAssertFieldName)) {
				if (operationDetail.getDateHeure() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("guichet", additionalAssertFieldName)) {
				if (operationDetail.getGuichet() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("libelle", additionalAssertFieldName)) {
				if (operationDetail.getLibelle() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("montant", additionalAssertFieldName)) {
				if (operationDetail.getMontant() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("montantReel", additionalAssertFieldName)) {
				if (operationDetail.getMontantReel() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("reference", additionalAssertFieldName)) {
				if (operationDetail.getReference() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("statut", additionalAssertFieldName)) {
				if (operationDetail.getStatut() == null) {
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

	protected String[] getAdditionalOperationDetailAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field :
				getDeclaredFields(
					com.df.lonis.ventesrest.dto.v1_0.Operation.class)) {

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

	protected boolean equals(Operation operation1, Operation operation2) {
		if (operation1 == operation2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("code", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						operation1.getCode(), operation2.getCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("codeTerminal", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						operation1.getCodeTerminal(),
						operation2.getCodeTerminal())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("dateOperation", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						operation1.getDateOperation(),
						operation2.getDateOperation())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("guichet", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						operation1.getGuichet(), operation2.getGuichet())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						operation1.getId(), operation2.getId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("libelle", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						operation1.getLibelle(), operation2.getLibelle())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("montant", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						operation1.getMontant(), operation2.getMontant())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("montantReel", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						operation1.getMontantReel(),
						operation2.getMontantReel())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("reference", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						operation1.getReference(), operation2.getReference())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("statut", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						operation1.getStatut(), operation2.getStatut())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("terminalId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						operation1.getTerminalId(),
						operation2.getTerminalId())) {

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

	protected boolean equals(
		OperationDetail operationDetail1, OperationDetail operationDetail2) {

		if (operationDetail1 == operationDetail2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalOperationDetailAssertFieldNames()) {

			if (Objects.equals("codeOperation", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						operationDetail1.getCodeOperation(),
						operationDetail2.getCodeOperation())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("codeTerminal", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						operationDetail1.getCodeTerminal(),
						operationDetail2.getCodeTerminal())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("dateHeure", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						operationDetail1.getDateHeure(),
						operationDetail2.getDateHeure())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("guichet", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						operationDetail1.getGuichet(),
						operationDetail2.getGuichet())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						operationDetail1.getId(), operationDetail2.getId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("libelle", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						operationDetail1.getLibelle(),
						operationDetail2.getLibelle())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("montant", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						operationDetail1.getMontant(),
						operationDetail2.getMontant())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("montantReel", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						operationDetail1.getMontantReel(),
						operationDetail2.getMontantReel())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("reference", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						operationDetail1.getReference(),
						operationDetail2.getReference())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("statut", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						operationDetail1.getStatut(),
						operationDetail2.getStatut())) {

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

		if (!(_operationResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_operationResource;

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
		EntityField entityField, String operator, Operation operation) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("code")) {
			sb.append("'");
			sb.append(String.valueOf(operation.getCode()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("codeTerminal")) {
			sb.append("'");
			sb.append(String.valueOf(operation.getCodeTerminal()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("dateOperation")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(
							operation.getDateOperation(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(operation.getDateOperation(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(operation.getDateOperation()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("guichet")) {
			sb.append("'");
			sb.append(String.valueOf(operation.getGuichet()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("libelle")) {
			sb.append("'");
			sb.append(String.valueOf(operation.getLibelle()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("montant")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("montantReel")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("reference")) {
			sb.append("'");
			sb.append(String.valueOf(operation.getReference()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("statut")) {
			sb.append("'");
			sb.append(String.valueOf(operation.getStatut()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("terminalId")) {
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

	protected Operation randomOperation() throws Exception {
		return new Operation() {
			{
				code = StringUtil.toLowerCase(RandomTestUtil.randomString());
				codeTerminal = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				dateOperation = RandomTestUtil.nextDate();
				guichet = StringUtil.toLowerCase(RandomTestUtil.randomString());
				id = RandomTestUtil.randomLong();
				libelle = StringUtil.toLowerCase(RandomTestUtil.randomString());
				montant = RandomTestUtil.randomLong();
				montantReel = RandomTestUtil.randomLong();
				reference = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				statut = StringUtil.toLowerCase(RandomTestUtil.randomString());
				terminalId = RandomTestUtil.randomLong();
			}
		};
	}

	protected Operation randomIrrelevantOperation() throws Exception {
		Operation randomIrrelevantOperation = randomOperation();

		return randomIrrelevantOperation;
	}

	protected Operation randomPatchOperation() throws Exception {
		return randomOperation();
	}

	protected OperationDetail randomOperationDetail() throws Exception {
		return new OperationDetail() {
			{
				codeOperation = RandomTestUtil.randomString();
				codeTerminal = RandomTestUtil.randomString();
				dateHeure = RandomTestUtil.nextDate();
				guichet = RandomTestUtil.randomString();
				id = RandomTestUtil.randomLong();
				libelle = RandomTestUtil.randomString();
				montant = RandomTestUtil.randomLong();
				montantReel = RandomTestUtil.randomLong();
				reference = RandomTestUtil.randomString();
				statut = RandomTestUtil.randomString();
			}
		};
	}

	protected OperationResource operationResource;
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
		LogFactoryUtil.getLog(BaseOperationResourceTestCase.class);

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
	private com.df.lonis.ventesrest.resource.v1_0.OperationResource
		_operationResource;

}