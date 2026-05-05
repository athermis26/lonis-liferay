package com.df.lonis.reseaurest.resource.v1_0.test;

import com.df.lonis.reseaurest.client.dto.v1_0.Terminal;
import com.df.lonis.reseaurest.client.http.HttpInvoker;
import com.df.lonis.reseaurest.client.pagination.Page;
import com.df.lonis.reseaurest.client.pagination.Pagination;
import com.df.lonis.reseaurest.client.resource.v1_0.TerminalResource;
import com.df.lonis.reseaurest.client.serdes.v1_0.TerminalSerDes;

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

		terminal.setAdresse(regex);
		terminal.setCodeTerminal(regex);

		String json = TerminalSerDes.toJSON(terminal);

		Assert.assertFalse(json.contains(regex));

		terminal = TerminalSerDes.toDTO(json);

		Assert.assertEquals(regex, terminal.getAdresse());
		Assert.assertEquals(regex, terminal.getCodeTerminal());
	}

	@Test
	public void testGetTerminalsPage() throws Exception {
		Page<Terminal> page = terminalResource.getTerminalsPage(
			null, RandomTestUtil.randomString(), null, null,
			Pagination.of(1, 10), null);

		long totalCount = page.getTotalCount();

		Terminal terminal1 = testGetTerminalsPage_addTerminal(randomTerminal());

		Terminal terminal2 = testGetTerminalsPage_addTerminal(randomTerminal());

		page = terminalResource.getTerminalsPage(
			null, null, null, null, Pagination.of(1, 10), null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(terminal1, (List<Terminal>)page.getItems());
		assertContains(terminal2, (List<Terminal>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetTerminalsPageWithFilterDateTimeEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Terminal terminal1 = randomTerminal();

		terminal1 = testGetTerminalsPage_addTerminal(terminal1);

		for (EntityField entityField : entityFields) {
			Page<Terminal> page = terminalResource.getTerminalsPage(
				null, null, null,
				getFilterString(entityField, "between", terminal1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(terminal1),
				(List<Terminal>)page.getItems());
		}
	}

	@Test
	public void testGetTerminalsPageWithFilterStringEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Terminal terminal1 = testGetTerminalsPage_addTerminal(randomTerminal());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Terminal terminal2 = testGetTerminalsPage_addTerminal(randomTerminal());

		for (EntityField entityField : entityFields) {
			Page<Terminal> page = terminalResource.getTerminalsPage(
				null, null, null, getFilterString(entityField, "eq", terminal1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(terminal1),
				(List<Terminal>)page.getItems());
		}
	}

	@Test
	public void testGetTerminalsPageWithPagination() throws Exception {
		Page<Terminal> totalPage = terminalResource.getTerminalsPage(
			null, null, null, null, null, null);

		int totalCount = GetterUtil.getInteger(totalPage.getTotalCount());

		Terminal terminal1 = testGetTerminalsPage_addTerminal(randomTerminal());

		Terminal terminal2 = testGetTerminalsPage_addTerminal(randomTerminal());

		Terminal terminal3 = testGetTerminalsPage_addTerminal(randomTerminal());

		Page<Terminal> page1 = terminalResource.getTerminalsPage(
			null, null, null, null, Pagination.of(1, totalCount + 2), null);

		List<Terminal> terminals1 = (List<Terminal>)page1.getItems();

		Assert.assertEquals(
			terminals1.toString(), totalCount + 2, terminals1.size());

		Page<Terminal> page2 = terminalResource.getTerminalsPage(
			null, null, null, null, Pagination.of(2, totalCount + 2), null);

		Assert.assertEquals(totalCount + 3, page2.getTotalCount());

		List<Terminal> terminals2 = (List<Terminal>)page2.getItems();

		Assert.assertEquals(terminals2.toString(), 1, terminals2.size());

		Page<Terminal> page3 = terminalResource.getTerminalsPage(
			null, null, null, null, Pagination.of(1, totalCount + 3), null);

		assertContains(terminal1, (List<Terminal>)page3.getItems());
		assertContains(terminal2, (List<Terminal>)page3.getItems());
		assertContains(terminal3, (List<Terminal>)page3.getItems());
	}

	@Test
	public void testGetTerminalsPageWithSortDateTime() throws Exception {
		testGetTerminalsPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, terminal1, terminal2) -> {
				BeanUtils.setProperty(
					terminal1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetTerminalsPageWithSortInteger() throws Exception {
		testGetTerminalsPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, terminal1, terminal2) -> {
				BeanUtils.setProperty(terminal1, entityField.getName(), 0);
				BeanUtils.setProperty(terminal2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetTerminalsPageWithSortString() throws Exception {
		testGetTerminalsPageWithSort(
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

	protected void testGetTerminalsPageWithSort(
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

		terminal1 = testGetTerminalsPage_addTerminal(terminal1);

		terminal2 = testGetTerminalsPage_addTerminal(terminal2);

		for (EntityField entityField : entityFields) {
			Page<Terminal> ascPage = terminalResource.getTerminalsPage(
				null, null, null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(terminal1, terminal2),
				(List<Terminal>)ascPage.getItems());

			Page<Terminal> descPage = terminalResource.getTerminalsPage(
				null, null, null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(terminal2, terminal1),
				(List<Terminal>)descPage.getItems());
		}
	}

	protected Terminal testGetTerminalsPage_addTerminal(Terminal terminal)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetTerminalsPage() throws Exception {
		GraphQLField graphQLField = new GraphQLField(
			"terminals",
			new HashMap<String, Object>() {
				{
					put("page", 1);
					put("pageSize", 10);
				}
			},
			new GraphQLField("items", getGraphQLFields()),
			new GraphQLField("page"), new GraphQLField("totalCount"));

		JSONObject terminalsJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/terminals");

		long totalCount = terminalsJSONObject.getLong("totalCount");

		Terminal terminal1 = testGraphQLTerminal_addTerminal();
		Terminal terminal2 = testGraphQLTerminal_addTerminal();

		terminalsJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/terminals");

		Assert.assertEquals(
			totalCount + 2, terminalsJSONObject.getLong("totalCount"));

		assertContains(
			terminal1,
			Arrays.asList(
				TerminalSerDes.toDTOs(terminalsJSONObject.getString("items"))));
		assertContains(
			terminal2,
			Arrays.asList(
				TerminalSerDes.toDTOs(terminalsJSONObject.getString("items"))));
	}

	@Test
	public void testPostTerminal() throws Exception {
		Terminal randomTerminal = randomTerminal();

		Terminal postTerminal = testPostTerminal_addTerminal(randomTerminal);

		assertEquals(randomTerminal, postTerminal);
		assertValid(postTerminal);
	}

	protected Terminal testPostTerminal_addTerminal(Terminal terminal)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetTerminal() throws Exception {
		Terminal postTerminal = testGetTerminal_addTerminal();

		Terminal getTerminal = terminalResource.getTerminal(
			postTerminal.getId());

		assertEquals(postTerminal, getTerminal);
		assertValid(getTerminal);
	}

	protected Terminal testGetTerminal_addTerminal() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetTerminal() throws Exception {
		Terminal terminal = testGraphQLTerminal_addTerminal();

		Assert.assertTrue(
			equals(
				terminal,
				TerminalSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"terminal",
								new HashMap<String, Object>() {
									{
										put("terminalId", terminal.getId());
									}
								},
								getGraphQLFields())),
						"JSONObject/data", "Object/terminal"))));
	}

	@Test
	public void testGraphQLGetTerminalNotFound() throws Exception {
		Long irrelevantTerminalId = RandomTestUtil.randomLong();

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"terminal",
						new HashMap<String, Object>() {
							{
								put("terminalId", irrelevantTerminalId);
							}
						},
						getGraphQLFields())),
				"JSONArray/errors", "Object/0", "JSONObject/extensions",
				"Object/code"));
	}

	@Test
	public void testPutTerminal() throws Exception {
		Terminal postTerminal = testPutTerminal_addTerminal();

		Terminal randomTerminal = randomTerminal();

		Terminal putTerminal = terminalResource.putTerminal(
			postTerminal.getId(), randomTerminal);

		assertEquals(randomTerminal, putTerminal);
		assertValid(putTerminal);

		Terminal getTerminal = terminalResource.getTerminal(
			putTerminal.getId());

		assertEquals(randomTerminal, getTerminal);
		assertValid(getTerminal);
	}

	protected Terminal testPutTerminal_addTerminal() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetTerminalsAValiderPage() throws Exception {
		Page<Terminal> page = terminalResource.getTerminalsAValiderPage(
			null, null, Pagination.of(1, 10), null);

		long totalCount = page.getTotalCount();

		Terminal terminal1 = testGetTerminalsAValiderPage_addTerminal(
			randomTerminal());

		Terminal terminal2 = testGetTerminalsAValiderPage_addTerminal(
			randomTerminal());

		page = terminalResource.getTerminalsAValiderPage(
			null, null, Pagination.of(1, 10), null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(terminal1, (List<Terminal>)page.getItems());
		assertContains(terminal2, (List<Terminal>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetTerminalsAValiderPageWithFilterDateTimeEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Terminal terminal1 = randomTerminal();

		terminal1 = testGetTerminalsAValiderPage_addTerminal(terminal1);

		for (EntityField entityField : entityFields) {
			Page<Terminal> page = terminalResource.getTerminalsAValiderPage(
				null, getFilterString(entityField, "between", terminal1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(terminal1),
				(List<Terminal>)page.getItems());
		}
	}

	@Test
	public void testGetTerminalsAValiderPageWithFilterStringEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Terminal terminal1 = testGetTerminalsAValiderPage_addTerminal(
			randomTerminal());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Terminal terminal2 = testGetTerminalsAValiderPage_addTerminal(
			randomTerminal());

		for (EntityField entityField : entityFields) {
			Page<Terminal> page = terminalResource.getTerminalsAValiderPage(
				null, getFilterString(entityField, "eq", terminal1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(terminal1),
				(List<Terminal>)page.getItems());
		}
	}

	@Test
	public void testGetTerminalsAValiderPageWithPagination() throws Exception {
		Page<Terminal> totalPage = terminalResource.getTerminalsAValiderPage(
			null, null, null, null);

		int totalCount = GetterUtil.getInteger(totalPage.getTotalCount());

		Terminal terminal1 = testGetTerminalsAValiderPage_addTerminal(
			randomTerminal());

		Terminal terminal2 = testGetTerminalsAValiderPage_addTerminal(
			randomTerminal());

		Terminal terminal3 = testGetTerminalsAValiderPage_addTerminal(
			randomTerminal());

		Page<Terminal> page1 = terminalResource.getTerminalsAValiderPage(
			null, null, Pagination.of(1, totalCount + 2), null);

		List<Terminal> terminals1 = (List<Terminal>)page1.getItems();

		Assert.assertEquals(
			terminals1.toString(), totalCount + 2, terminals1.size());

		Page<Terminal> page2 = terminalResource.getTerminalsAValiderPage(
			null, null, Pagination.of(2, totalCount + 2), null);

		Assert.assertEquals(totalCount + 3, page2.getTotalCount());

		List<Terminal> terminals2 = (List<Terminal>)page2.getItems();

		Assert.assertEquals(terminals2.toString(), 1, terminals2.size());

		Page<Terminal> page3 = terminalResource.getTerminalsAValiderPage(
			null, null, Pagination.of(1, totalCount + 3), null);

		assertContains(terminal1, (List<Terminal>)page3.getItems());
		assertContains(terminal2, (List<Terminal>)page3.getItems());
		assertContains(terminal3, (List<Terminal>)page3.getItems());
	}

	@Test
	public void testGetTerminalsAValiderPageWithSortDateTime()
		throws Exception {

		testGetTerminalsAValiderPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, terminal1, terminal2) -> {
				BeanUtils.setProperty(
					terminal1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetTerminalsAValiderPageWithSortInteger() throws Exception {
		testGetTerminalsAValiderPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, terminal1, terminal2) -> {
				BeanUtils.setProperty(terminal1, entityField.getName(), 0);
				BeanUtils.setProperty(terminal2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetTerminalsAValiderPageWithSortString() throws Exception {
		testGetTerminalsAValiderPageWithSort(
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

	protected void testGetTerminalsAValiderPageWithSort(
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

		terminal1 = testGetTerminalsAValiderPage_addTerminal(terminal1);

		terminal2 = testGetTerminalsAValiderPage_addTerminal(terminal2);

		for (EntityField entityField : entityFields) {
			Page<Terminal> ascPage = terminalResource.getTerminalsAValiderPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(terminal1, terminal2),
				(List<Terminal>)ascPage.getItems());

			Page<Terminal> descPage = terminalResource.getTerminalsAValiderPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(terminal2, terminal1),
				(List<Terminal>)descPage.getItems());
		}
	}

	protected Terminal testGetTerminalsAValiderPage_addTerminal(
			Terminal terminal)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPatchTerminalValider() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testPatchTerminalRejeter() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGetTerminalsCartographie() throws Exception {
		Page<Terminal> page = terminalResource.getTerminalsCartographie(
			null, null, Pagination.of(1, 10), null);

		long totalCount = page.getTotalCount();

		Terminal terminal1 = testGetTerminalsCartographie_addTerminal(
			randomTerminal());

		Terminal terminal2 = testGetTerminalsCartographie_addTerminal(
			randomTerminal());

		page = terminalResource.getTerminalsCartographie(
			null, null, Pagination.of(1, 10), null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(terminal1, (List<Terminal>)page.getItems());
		assertContains(terminal2, (List<Terminal>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetTerminalsCartographieWithFilterDateTimeEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Terminal terminal1 = randomTerminal();

		terminal1 = testGetTerminalsCartographie_addTerminal(terminal1);

		for (EntityField entityField : entityFields) {
			Page<Terminal> page = terminalResource.getTerminalsCartographie(
				null, getFilterString(entityField, "between", terminal1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(terminal1),
				(List<Terminal>)page.getItems());
		}
	}

	@Test
	public void testGetTerminalsCartographieWithFilterStringEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Terminal terminal1 = testGetTerminalsCartographie_addTerminal(
			randomTerminal());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Terminal terminal2 = testGetTerminalsCartographie_addTerminal(
			randomTerminal());

		for (EntityField entityField : entityFields) {
			Page<Terminal> page = terminalResource.getTerminalsCartographie(
				null, getFilterString(entityField, "eq", terminal1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(terminal1),
				(List<Terminal>)page.getItems());
		}
	}

	@Test
	public void testGetTerminalsCartographieWithPagination() throws Exception {
		Page<Terminal> totalPage = terminalResource.getTerminalsCartographie(
			null, null, null, null);

		int totalCount = GetterUtil.getInteger(totalPage.getTotalCount());

		Terminal terminal1 = testGetTerminalsCartographie_addTerminal(
			randomTerminal());

		Terminal terminal2 = testGetTerminalsCartographie_addTerminal(
			randomTerminal());

		Terminal terminal3 = testGetTerminalsCartographie_addTerminal(
			randomTerminal());

		Page<Terminal> page1 = terminalResource.getTerminalsCartographie(
			null, null, Pagination.of(1, totalCount + 2), null);

		List<Terminal> terminals1 = (List<Terminal>)page1.getItems();

		Assert.assertEquals(
			terminals1.toString(), totalCount + 2, terminals1.size());

		Page<Terminal> page2 = terminalResource.getTerminalsCartographie(
			null, null, Pagination.of(2, totalCount + 2), null);

		Assert.assertEquals(totalCount + 3, page2.getTotalCount());

		List<Terminal> terminals2 = (List<Terminal>)page2.getItems();

		Assert.assertEquals(terminals2.toString(), 1, terminals2.size());

		Page<Terminal> page3 = terminalResource.getTerminalsCartographie(
			null, null, Pagination.of(1, totalCount + 3), null);

		assertContains(terminal1, (List<Terminal>)page3.getItems());
		assertContains(terminal2, (List<Terminal>)page3.getItems());
		assertContains(terminal3, (List<Terminal>)page3.getItems());
	}

	@Test
	public void testGetTerminalsCartographieWithSortDateTime()
		throws Exception {

		testGetTerminalsCartographieWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, terminal1, terminal2) -> {
				BeanUtils.setProperty(
					terminal1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetTerminalsCartographieWithSortInteger() throws Exception {
		testGetTerminalsCartographieWithSort(
			EntityField.Type.INTEGER,
			(entityField, terminal1, terminal2) -> {
				BeanUtils.setProperty(terminal1, entityField.getName(), 0);
				BeanUtils.setProperty(terminal2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetTerminalsCartographieWithSortString() throws Exception {
		testGetTerminalsCartographieWithSort(
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

	protected void testGetTerminalsCartographieWithSort(
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

		terminal1 = testGetTerminalsCartographie_addTerminal(terminal1);

		terminal2 = testGetTerminalsCartographie_addTerminal(terminal2);

		for (EntityField entityField : entityFields) {
			Page<Terminal> ascPage = terminalResource.getTerminalsCartographie(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(terminal1, terminal2),
				(List<Terminal>)ascPage.getItems());

			Page<Terminal> descPage = terminalResource.getTerminalsCartographie(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(terminal2, terminal1),
				(List<Terminal>)descPage.getItems());
		}
	}

	protected Terminal testGetTerminalsCartographie_addTerminal(
			Terminal terminal)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetTerminalsCartographieTop20() throws Exception {
		Page<Terminal> page = terminalResource.getTerminalsCartographieTop20(
			null, null, Pagination.of(1, 10), null);

		long totalCount = page.getTotalCount();

		Terminal terminal1 = testGetTerminalsCartographieTop20_addTerminal(
			randomTerminal());

		Terminal terminal2 = testGetTerminalsCartographieTop20_addTerminal(
			randomTerminal());

		page = terminalResource.getTerminalsCartographieTop20(
			null, null, Pagination.of(1, 10), null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(terminal1, (List<Terminal>)page.getItems());
		assertContains(terminal2, (List<Terminal>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetTerminalsCartographieTop20WithFilterDateTimeEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Terminal terminal1 = randomTerminal();

		terminal1 = testGetTerminalsCartographieTop20_addTerminal(terminal1);

		for (EntityField entityField : entityFields) {
			Page<Terminal> page =
				terminalResource.getTerminalsCartographieTop20(
					null, getFilterString(entityField, "between", terminal1),
					Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(terminal1),
				(List<Terminal>)page.getItems());
		}
	}

	@Test
	public void testGetTerminalsCartographieTop20WithFilterStringEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Terminal terminal1 = testGetTerminalsCartographieTop20_addTerminal(
			randomTerminal());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Terminal terminal2 = testGetTerminalsCartographieTop20_addTerminal(
			randomTerminal());

		for (EntityField entityField : entityFields) {
			Page<Terminal> page =
				terminalResource.getTerminalsCartographieTop20(
					null, getFilterString(entityField, "eq", terminal1),
					Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(terminal1),
				(List<Terminal>)page.getItems());
		}
	}

	@Test
	public void testGetTerminalsCartographieTop20WithPagination()
		throws Exception {

		Page<Terminal> totalPage =
			terminalResource.getTerminalsCartographieTop20(
				null, null, null, null);

		int totalCount = GetterUtil.getInteger(totalPage.getTotalCount());

		Terminal terminal1 = testGetTerminalsCartographieTop20_addTerminal(
			randomTerminal());

		Terminal terminal2 = testGetTerminalsCartographieTop20_addTerminal(
			randomTerminal());

		Terminal terminal3 = testGetTerminalsCartographieTop20_addTerminal(
			randomTerminal());

		Page<Terminal> page1 = terminalResource.getTerminalsCartographieTop20(
			null, null, Pagination.of(1, totalCount + 2), null);

		List<Terminal> terminals1 = (List<Terminal>)page1.getItems();

		Assert.assertEquals(
			terminals1.toString(), totalCount + 2, terminals1.size());

		Page<Terminal> page2 = terminalResource.getTerminalsCartographieTop20(
			null, null, Pagination.of(2, totalCount + 2), null);

		Assert.assertEquals(totalCount + 3, page2.getTotalCount());

		List<Terminal> terminals2 = (List<Terminal>)page2.getItems();

		Assert.assertEquals(terminals2.toString(), 1, terminals2.size());

		Page<Terminal> page3 = terminalResource.getTerminalsCartographieTop20(
			null, null, Pagination.of(1, totalCount + 3), null);

		assertContains(terminal1, (List<Terminal>)page3.getItems());
		assertContains(terminal2, (List<Terminal>)page3.getItems());
		assertContains(terminal3, (List<Terminal>)page3.getItems());
	}

	@Test
	public void testGetTerminalsCartographieTop20WithSortDateTime()
		throws Exception {

		testGetTerminalsCartographieTop20WithSort(
			EntityField.Type.DATE_TIME,
			(entityField, terminal1, terminal2) -> {
				BeanUtils.setProperty(
					terminal1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetTerminalsCartographieTop20WithSortInteger()
		throws Exception {

		testGetTerminalsCartographieTop20WithSort(
			EntityField.Type.INTEGER,
			(entityField, terminal1, terminal2) -> {
				BeanUtils.setProperty(terminal1, entityField.getName(), 0);
				BeanUtils.setProperty(terminal2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetTerminalsCartographieTop20WithSortString()
		throws Exception {

		testGetTerminalsCartographieTop20WithSort(
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

	protected void testGetTerminalsCartographieTop20WithSort(
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

		terminal1 = testGetTerminalsCartographieTop20_addTerminal(terminal1);

		terminal2 = testGetTerminalsCartographieTop20_addTerminal(terminal2);

		for (EntityField entityField : entityFields) {
			Page<Terminal> ascPage =
				terminalResource.getTerminalsCartographieTop20(
					null, null, Pagination.of(1, 2),
					entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(terminal1, terminal2),
				(List<Terminal>)ascPage.getItems());

			Page<Terminal> descPage =
				terminalResource.getTerminalsCartographieTop20(
					null, null, Pagination.of(1, 2),
					entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(terminal2, terminal1),
				(List<Terminal>)descPage.getItems());
		}
	}

	protected Terminal testGetTerminalsCartographieTop20_addTerminal(
			Terminal terminal)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetTerminalVisitesPage() throws Exception {
		Long terminalId = testGetTerminalVisitesPage_getTerminalId();
		Long irrelevantTerminalId =
			testGetTerminalVisitesPage_getIrrelevantTerminalId();

		Page<Terminal> page = terminalResource.getTerminalVisitesPage(
			terminalId, null, null, Pagination.of(1, 10), null);

		Assert.assertEquals(0, page.getTotalCount());

		if (irrelevantTerminalId != null) {
			Terminal irrelevantTerminal =
				testGetTerminalVisitesPage_addTerminal(
					irrelevantTerminalId, randomIrrelevantTerminal());

			page = terminalResource.getTerminalVisitesPage(
				irrelevantTerminalId, null, null, Pagination.of(1, 2), null);

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantTerminal),
				(List<Terminal>)page.getItems());
			assertValid(page);
		}

		Terminal terminal1 = testGetTerminalVisitesPage_addTerminal(
			terminalId, randomTerminal());

		Terminal terminal2 = testGetTerminalVisitesPage_addTerminal(
			terminalId, randomTerminal());

		page = terminalResource.getTerminalVisitesPage(
			terminalId, null, null, Pagination.of(1, 10), null);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(terminal1, terminal2),
			(List<Terminal>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetTerminalVisitesPageWithFilterDateTimeEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Long terminalId = testGetTerminalVisitesPage_getTerminalId();

		Terminal terminal1 = randomTerminal();

		terminal1 = testGetTerminalVisitesPage_addTerminal(
			terminalId, terminal1);

		for (EntityField entityField : entityFields) {
			Page<Terminal> page = terminalResource.getTerminalVisitesPage(
				terminalId, null,
				getFilterString(entityField, "between", terminal1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(terminal1),
				(List<Terminal>)page.getItems());
		}
	}

	@Test
	public void testGetTerminalVisitesPageWithFilterStringEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Long terminalId = testGetTerminalVisitesPage_getTerminalId();

		Terminal terminal1 = testGetTerminalVisitesPage_addTerminal(
			terminalId, randomTerminal());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Terminal terminal2 = testGetTerminalVisitesPage_addTerminal(
			terminalId, randomTerminal());

		for (EntityField entityField : entityFields) {
			Page<Terminal> page = terminalResource.getTerminalVisitesPage(
				terminalId, null, getFilterString(entityField, "eq", terminal1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(terminal1),
				(List<Terminal>)page.getItems());
		}
	}

	@Test
	public void testGetTerminalVisitesPageWithPagination() throws Exception {
		Long terminalId = testGetTerminalVisitesPage_getTerminalId();

		Terminal terminal1 = testGetTerminalVisitesPage_addTerminal(
			terminalId, randomTerminal());

		Terminal terminal2 = testGetTerminalVisitesPage_addTerminal(
			terminalId, randomTerminal());

		Terminal terminal3 = testGetTerminalVisitesPage_addTerminal(
			terminalId, randomTerminal());

		Page<Terminal> page1 = terminalResource.getTerminalVisitesPage(
			terminalId, null, null, Pagination.of(1, 2), null);

		List<Terminal> terminals1 = (List<Terminal>)page1.getItems();

		Assert.assertEquals(terminals1.toString(), 2, terminals1.size());

		Page<Terminal> page2 = terminalResource.getTerminalVisitesPage(
			terminalId, null, null, Pagination.of(2, 2), null);

		Assert.assertEquals(3, page2.getTotalCount());

		List<Terminal> terminals2 = (List<Terminal>)page2.getItems();

		Assert.assertEquals(terminals2.toString(), 1, terminals2.size());

		Page<Terminal> page3 = terminalResource.getTerminalVisitesPage(
			terminalId, null, null, Pagination.of(1, 3), null);

		assertEqualsIgnoringOrder(
			Arrays.asList(terminal1, terminal2, terminal3),
			(List<Terminal>)page3.getItems());
	}

	@Test
	public void testGetTerminalVisitesPageWithSortDateTime() throws Exception {
		testGetTerminalVisitesPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, terminal1, terminal2) -> {
				BeanUtils.setProperty(
					terminal1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetTerminalVisitesPageWithSortInteger() throws Exception {
		testGetTerminalVisitesPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, terminal1, terminal2) -> {
				BeanUtils.setProperty(terminal1, entityField.getName(), 0);
				BeanUtils.setProperty(terminal2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetTerminalVisitesPageWithSortString() throws Exception {
		testGetTerminalVisitesPageWithSort(
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

	protected void testGetTerminalVisitesPageWithSort(
			EntityField.Type type,
			UnsafeTriConsumer<EntityField, Terminal, Terminal, Exception>
				unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		Long terminalId = testGetTerminalVisitesPage_getTerminalId();

		Terminal terminal1 = randomTerminal();
		Terminal terminal2 = randomTerminal();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(entityField, terminal1, terminal2);
		}

		terminal1 = testGetTerminalVisitesPage_addTerminal(
			terminalId, terminal1);

		terminal2 = testGetTerminalVisitesPage_addTerminal(
			terminalId, terminal2);

		for (EntityField entityField : entityFields) {
			Page<Terminal> ascPage = terminalResource.getTerminalVisitesPage(
				terminalId, null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(terminal1, terminal2),
				(List<Terminal>)ascPage.getItems());

			Page<Terminal> descPage = terminalResource.getTerminalVisitesPage(
				terminalId, null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(terminal2, terminal1),
				(List<Terminal>)descPage.getItems());
		}
	}

	protected Terminal testGetTerminalVisitesPage_addTerminal(
			Long terminalId, Terminal terminal)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetTerminalVisitesPage_getTerminalId() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetTerminalVisitesPage_getIrrelevantTerminalId()
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

			if (Objects.equals("adresse", additionalAssertFieldName)) {
				if (terminal.getAdresse() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("codeTerminal", additionalAssertFieldName)) {
				if (terminal.getCodeTerminal() == null) {
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

			if (Objects.equals("latitude", additionalAssertFieldName)) {
				if (terminal.getLatitude() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("longitude", additionalAssertFieldName)) {
				if (terminal.getLongitude() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("statutValidation", additionalAssertFieldName)) {
				if (terminal.getStatutValidation() == null) {
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
					com.df.lonis.reseaurest.dto.v1_0.Terminal.class)) {

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

			if (Objects.equals("adresse", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						terminal1.getAdresse(), terminal2.getAdresse())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("codeTerminal", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						terminal1.getCodeTerminal(),
						terminal2.getCodeTerminal())) {

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

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(terminal1.getId(), terminal2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("latitude", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						terminal1.getLatitude(), terminal2.getLatitude())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("longitude", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						terminal1.getLongitude(), terminal2.getLongitude())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("statutValidation", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						terminal1.getStatutValidation(),
						terminal2.getStatutValidation())) {

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

		if (entityFieldName.equals("adresse")) {
			sb.append("'");
			sb.append(String.valueOf(terminal.getAdresse()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("codeTerminal")) {
			sb.append("'");
			sb.append(String.valueOf(terminal.getCodeTerminal()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("concessionnaireId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
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

		if (entityFieldName.equals("siteId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("statutValidation")) {
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

	protected Terminal randomTerminal() throws Exception {
		return new Terminal() {
			{
				adresse = StringUtil.toLowerCase(RandomTestUtil.randomString());
				codeTerminal = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				concessionnaireId = RandomTestUtil.randomLong();
				id = RandomTestUtil.randomLong();
				latitude = RandomTestUtil.randomDouble();
				longitude = RandomTestUtil.randomDouble();
				siteId = testGroup.getGroupId();
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
	private com.df.lonis.reseaurest.resource.v1_0.TerminalResource
		_terminalResource;

}