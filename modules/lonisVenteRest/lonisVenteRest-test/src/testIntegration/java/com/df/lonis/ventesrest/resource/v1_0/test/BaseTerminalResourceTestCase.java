package com.df.lonis.ventesrest.resource.v1_0.test;

import com.df.lonis.ventesrest.client.dto.v1_0.Terminal;
import com.df.lonis.ventesrest.client.http.HttpInvoker;
import com.df.lonis.ventesrest.client.pagination.Page;
import com.df.lonis.ventesrest.client.pagination.Pagination;
import com.df.lonis.ventesrest.client.resource.v1_0.TerminalResource;
import com.df.lonis.ventesrest.client.serdes.v1_0.TerminalSerDes;

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
public abstract class BaseTerminalResourceTestCase {

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

		_terminalResource.setContextCompany(testCompany);

		TerminalResource.Builder builder = TerminalResource.builder();

		terminalResource = builder.authentication(
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

		Terminal terminal1 = randomTerminal();

		String json = objectMapper.writeValueAsString(terminal1);

		Terminal terminal2 = TerminalSerDes.toDTO(json);

		Assert.assertTrue(equals(terminal1, terminal2));
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

		Terminal terminal = randomTerminal();

		String json1 = objectMapper.writeValueAsString(terminal);
		String json2 = TerminalSerDes.toJSON(terminal);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Terminal terminal = randomTerminal();

		terminal.setCodeTerminal(regex);
		terminal.setConcessionnaireCode(regex);
		terminal.setConcessionnaireNomPrenom(regex);
		terminal.setConcessionnaireProduitCode(regex);
		terminal.setProduitType(regex);
		terminal.setSiteLibelle(regex);

		String json = TerminalSerDes.toJSON(terminal);

		Assert.assertFalse(json.contains(regex));

		terminal = TerminalSerDes.toDTO(json);

		Assert.assertEquals(regex, terminal.getCodeTerminal());
		Assert.assertEquals(regex, terminal.getConcessionnaireCode());
		Assert.assertEquals(regex, terminal.getConcessionnaireNomPrenom());
		Assert.assertEquals(regex, terminal.getConcessionnaireProduitCode());
		Assert.assertEquals(regex, terminal.getProduitType());
		Assert.assertEquals(regex, terminal.getSiteLibelle());
	}

	@Test
	public void testGetTerminauxPage() throws Exception {
		Page<Terminal> page = terminalResource.getTerminauxPage(
			null, null, Pagination.of(1, 10), null);

		long totalCount = page.getTotalCount();

		Terminal terminal1 = testGetTerminauxPage_addTerminal(randomTerminal());

		Terminal terminal2 = testGetTerminauxPage_addTerminal(randomTerminal());

		page = terminalResource.getTerminauxPage(
			null, null, Pagination.of(1, 10), null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(terminal1, (List<Terminal>)page.getItems());
		assertContains(terminal2, (List<Terminal>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetTerminauxPageWithFilterDateTimeEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Terminal terminal1 = randomTerminal();

		terminal1 = testGetTerminauxPage_addTerminal(terminal1);

		for (EntityField entityField : entityFields) {
			Page<Terminal> page = terminalResource.getTerminauxPage(
				null, getFilterString(entityField, "between", terminal1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(terminal1),
				(List<Terminal>)page.getItems());
		}
	}

	@Test
	public void testGetTerminauxPageWithFilterStringEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Terminal terminal1 = testGetTerminauxPage_addTerminal(randomTerminal());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Terminal terminal2 = testGetTerminauxPage_addTerminal(randomTerminal());

		for (EntityField entityField : entityFields) {
			Page<Terminal> page = terminalResource.getTerminauxPage(
				null, getFilterString(entityField, "eq", terminal1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(terminal1),
				(List<Terminal>)page.getItems());
		}
	}

	@Test
	public void testGetTerminauxPageWithPagination() throws Exception {
		Page<Terminal> totalPage = terminalResource.getTerminauxPage(
			null, null, null, null);

		int totalCount = GetterUtil.getInteger(totalPage.getTotalCount());

		Terminal terminal1 = testGetTerminauxPage_addTerminal(randomTerminal());

		Terminal terminal2 = testGetTerminauxPage_addTerminal(randomTerminal());

		Terminal terminal3 = testGetTerminauxPage_addTerminal(randomTerminal());

		Page<Terminal> page1 = terminalResource.getTerminauxPage(
			null, null, Pagination.of(1, totalCount + 2), null);

		List<Terminal> terminals1 = (List<Terminal>)page1.getItems();

		Assert.assertEquals(
			terminals1.toString(), totalCount + 2, terminals1.size());

		Page<Terminal> page2 = terminalResource.getTerminauxPage(
			null, null, Pagination.of(2, totalCount + 2), null);

		Assert.assertEquals(totalCount + 3, page2.getTotalCount());

		List<Terminal> terminals2 = (List<Terminal>)page2.getItems();

		Assert.assertEquals(terminals2.toString(), 1, terminals2.size());

		Page<Terminal> page3 = terminalResource.getTerminauxPage(
			null, null, Pagination.of(1, totalCount + 3), null);

		assertContains(terminal1, (List<Terminal>)page3.getItems());
		assertContains(terminal2, (List<Terminal>)page3.getItems());
		assertContains(terminal3, (List<Terminal>)page3.getItems());
	}

	@Test
	public void testGetTerminauxPageWithSortDateTime() throws Exception {
		testGetTerminauxPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, terminal1, terminal2) -> {
				BeanUtils.setProperty(
					terminal1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetTerminauxPageWithSortInteger() throws Exception {
		testGetTerminauxPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, terminal1, terminal2) -> {
				BeanUtils.setProperty(terminal1, entityField.getName(), 0);
				BeanUtils.setProperty(terminal2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetTerminauxPageWithSortString() throws Exception {
		testGetTerminauxPageWithSort(
			EntityField.Type.STRING,
			(entityField, terminal1, terminal2) -> {
				Class<?> clazz = terminal1.getClass();

				String entityFieldName = entityField.getName();

				java.lang.reflect.Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						terminal1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						terminal2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						terminal1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						terminal2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						terminal1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						terminal2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetTerminauxPageWithSort(
			EntityField.Type type,
			UnsafeTriConsumer<EntityField, Terminal, Terminal, Exception>
				unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		Terminal terminal1 = randomTerminal();
		Terminal terminal2 = randomTerminal();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(entityField, terminal1, terminal2);
		}

		terminal1 = testGetTerminauxPage_addTerminal(terminal1);

		terminal2 = testGetTerminauxPage_addTerminal(terminal2);

		for (EntityField entityField : entityFields) {
			Page<Terminal> ascPage = terminalResource.getTerminauxPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(terminal1, terminal2),
				(List<Terminal>)ascPage.getItems());

			Page<Terminal> descPage = terminalResource.getTerminauxPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(terminal2, terminal1),
				(List<Terminal>)descPage.getItems());
		}
	}

	protected Terminal testGetTerminauxPage_addTerminal(Terminal terminal)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testExportTerminaux() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGetConcessionnaireTerminaux() throws Exception {
		Long id = testGetConcessionnaireTerminaux_getId();
		Long irrelevantId = testGetConcessionnaireTerminaux_getIrrelevantId();

		Page<Terminal> page = terminalResource.getConcessionnaireTerminaux(
			id, RandomTestUtil.randomString(), RandomTestUtil.randomString(),
			RandomTestUtil.randomString());

		Assert.assertEquals(0, page.getTotalCount());

		if (irrelevantId != null) {
			Terminal irrelevantTerminal =
				testGetConcessionnaireTerminaux_addTerminal(
					irrelevantId, randomIrrelevantTerminal());

			page = terminalResource.getConcessionnaireTerminaux(
				irrelevantId, null, null, null);

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantTerminal),
				(List<Terminal>)page.getItems());
			assertValid(page);
		}

		Terminal terminal1 = testGetConcessionnaireTerminaux_addTerminal(
			id, randomTerminal());

		Terminal terminal2 = testGetConcessionnaireTerminaux_addTerminal(
			id, randomTerminal());

		page = terminalResource.getConcessionnaireTerminaux(
			id, null, null, null);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(terminal1, terminal2),
			(List<Terminal>)page.getItems());
		assertValid(page);
	}

	protected Terminal testGetConcessionnaireTerminaux_addTerminal(
			Long id, Terminal terminal)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetConcessionnaireTerminaux_getId() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetConcessionnaireTerminaux_getIrrelevantId()
		throws Exception {

		return null;
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	protected Terminal testGraphQLTerminal_addTerminal() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(Terminal terminal, List<Terminal> terminals) {
		boolean contains = false;

		for (Terminal item : terminals) {
			if (equals(terminal, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			terminals + " does not contain " + terminal, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Terminal terminal1, Terminal terminal2) {
		Assert.assertTrue(
			terminal1 + " does not equal " + terminal2,
			equals(terminal1, terminal2));
	}

	protected void assertEquals(
		List<Terminal> terminals1, List<Terminal> terminals2) {

		Assert.assertEquals(terminals1.size(), terminals2.size());

		for (int i = 0; i < terminals1.size(); i++) {
			Terminal terminal1 = terminals1.get(i);
			Terminal terminal2 = terminals2.get(i);

			assertEquals(terminal1, terminal2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Terminal> terminals1, List<Terminal> terminals2) {

		Assert.assertEquals(terminals1.size(), terminals2.size());

		for (Terminal terminal1 : terminals1) {
			boolean contains = false;

			for (Terminal terminal2 : terminals2) {
				if (equals(terminal1, terminal2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				terminals2 + " does not contain " + terminal1, contains);
		}
	}

	protected void assertValid(Terminal terminal) throws Exception {
		boolean valid = true;

		if (terminal.getId() == null) {
			valid = false;
		}

		if (!Objects.equals(terminal.getSiteId(), testGroup.getGroupId())) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("codeTerminal", additionalAssertFieldName)) {
				if (terminal.getCodeTerminal() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"concessionnaireCode", additionalAssertFieldName)) {

				if (terminal.getConcessionnaireCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"concessionnaireId", additionalAssertFieldName)) {

				if (terminal.getConcessionnaireId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"concessionnaireNomPrenom", additionalAssertFieldName)) {

				if (terminal.getConcessionnaireNomPrenom() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"concessionnaireProduitCode", additionalAssertFieldName)) {

				if (terminal.getConcessionnaireProduitCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("createdAt", additionalAssertFieldName)) {
				if (terminal.getCreatedAt() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("produit", additionalAssertFieldName)) {
				if (terminal.getProduit() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("produitId", additionalAssertFieldName)) {
				if (terminal.getProduitId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("produitType", additionalAssertFieldName)) {
				if (terminal.getProduitType() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("site", additionalAssertFieldName)) {
				if (terminal.getSite() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("siteLibelle", additionalAssertFieldName)) {
				if (terminal.getSiteLibelle() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("solde", additionalAssertFieldName)) {
				if (terminal.getSolde() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("updatedAt", additionalAssertFieldName)) {
				if (terminal.getUpdatedAt() == null) {
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

	protected void assertValid(Page<Terminal> page) {
		boolean valid = false;

		java.util.Collection<Terminal> terminals = page.getItems();

		int size = terminals.size();

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
					com.df.lonis.ventesrest.dto.v1_0.Terminal.class)) {

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

	protected boolean equals(Terminal terminal1, Terminal terminal2) {
		if (terminal1 == terminal2) {
			return true;
		}

		if (!Objects.equals(terminal1.getSiteId(), terminal2.getSiteId())) {
			return false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("codeTerminal", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						terminal1.getCodeTerminal(),
						terminal2.getCodeTerminal())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"concessionnaireCode", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						terminal1.getConcessionnaireCode(),
						terminal2.getConcessionnaireCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"concessionnaireId", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						terminal1.getConcessionnaireId(),
						terminal2.getConcessionnaireId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"concessionnaireNomPrenom", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						terminal1.getConcessionnaireNomPrenom(),
						terminal2.getConcessionnaireNomPrenom())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"concessionnaireProduitCode", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						terminal1.getConcessionnaireProduitCode(),
						terminal2.getConcessionnaireProduitCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("createdAt", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						terminal1.getCreatedAt(), terminal2.getCreatedAt())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(terminal1.getId(), terminal2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("produit", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						terminal1.getProduit(), terminal2.getProduit())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("produitId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						terminal1.getProduitId(), terminal2.getProduitId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("produitType", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						terminal1.getProduitType(),
						terminal2.getProduitType())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("site", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						terminal1.getSite(), terminal2.getSite())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("siteLibelle", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						terminal1.getSiteLibelle(),
						terminal2.getSiteLibelle())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("solde", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						terminal1.getSolde(), terminal2.getSolde())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("updatedAt", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						terminal1.getUpdatedAt(), terminal2.getUpdatedAt())) {

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

		if (!(_terminalResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_terminalResource;

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
		EntityField entityField, String operator, Terminal terminal) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("codeTerminal")) {
			sb.append("'");
			sb.append(String.valueOf(terminal.getCodeTerminal()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("concessionnaireCode")) {
			sb.append("'");
			sb.append(String.valueOf(terminal.getConcessionnaireCode()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("concessionnaireId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("concessionnaireNomPrenom")) {
			sb.append("'");
			sb.append(String.valueOf(terminal.getConcessionnaireNomPrenom()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("concessionnaireProduitCode")) {
			sb.append("'");
			sb.append(String.valueOf(terminal.getConcessionnaireProduitCode()));
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
						DateUtils.addSeconds(terminal.getCreatedAt(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(terminal.getCreatedAt(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(terminal.getCreatedAt()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("produit")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("produitId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("produitType")) {
			sb.append("'");
			sb.append(String.valueOf(terminal.getProduitType()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("site")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("siteId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("siteLibelle")) {
			sb.append("'");
			sb.append(String.valueOf(terminal.getSiteLibelle()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("solde")) {
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
						DateUtils.addSeconds(terminal.getUpdatedAt(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(terminal.getUpdatedAt(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(terminal.getUpdatedAt()));
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

	protected Terminal randomTerminal() throws Exception {
		return new Terminal() {
			{
				codeTerminal = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				concessionnaireCode = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				concessionnaireId = RandomTestUtil.randomLong();
				concessionnaireNomPrenom = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				concessionnaireProduitCode = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				createdAt = RandomTestUtil.nextDate();
				id = RandomTestUtil.randomLong();
				produitId = RandomTestUtil.randomLong();
				produitType = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				siteId = testGroup.getGroupId();
				siteLibelle = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				solde = RandomTestUtil.randomLong();
				updatedAt = RandomTestUtil.nextDate();
			}
		};
	}

	protected Terminal randomIrrelevantTerminal() throws Exception {
		Terminal randomIrrelevantTerminal = randomTerminal();

		randomIrrelevantTerminal.setSiteId(irrelevantGroup.getGroupId());

		return randomIrrelevantTerminal;
	}

	protected Terminal randomPatchTerminal() throws Exception {
		return randomTerminal();
	}

	protected TerminalResource terminalResource;
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
		LogFactoryUtil.getLog(BaseTerminalResourceTestCase.class);

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
	private com.df.lonis.ventesrest.resource.v1_0.TerminalResource
		_terminalResource;

}