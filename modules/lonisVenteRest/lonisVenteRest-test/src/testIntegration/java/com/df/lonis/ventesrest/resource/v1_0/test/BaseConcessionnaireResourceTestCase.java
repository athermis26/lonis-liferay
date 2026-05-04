package com.df.lonis.ventesrest.resource.v1_0.test;

import com.df.lonis.ventesrest.client.dto.v1_0.Concessionnaire;
import com.df.lonis.ventesrest.client.dto.v1_0.ConcessionnaireDetail;
import com.df.lonis.ventesrest.client.http.HttpInvoker;
import com.df.lonis.ventesrest.client.pagination.Page;
import com.df.lonis.ventesrest.client.pagination.Pagination;
import com.df.lonis.ventesrest.client.resource.v1_0.ConcessionnaireResource;
import com.df.lonis.ventesrest.client.serdes.v1_0.ConcessionnaireSerDes;

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
public abstract class BaseConcessionnaireResourceTestCase {

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

		_concessionnaireResource.setContextCompany(testCompany);

		ConcessionnaireResource.Builder builder =
			ConcessionnaireResource.builder();

		concessionnaireResource = builder.authentication(
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

		Concessionnaire concessionnaire1 = randomConcessionnaire();

		String json = objectMapper.writeValueAsString(concessionnaire1);

		Concessionnaire concessionnaire2 = ConcessionnaireSerDes.toDTO(json);

		Assert.assertTrue(equals(concessionnaire1, concessionnaire2));
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

		Concessionnaire concessionnaire = randomConcessionnaire();

		String json1 = objectMapper.writeValueAsString(concessionnaire);
		String json2 = ConcessionnaireSerDes.toJSON(concessionnaire);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Concessionnaire concessionnaire = randomConcessionnaire();

		concessionnaire.setEmail(regex);
		concessionnaire.setNom(regex);
		concessionnaire.setPrenoms(regex);
		concessionnaire.setTelephone(regex);
		concessionnaire.setUid(regex);

		String json = ConcessionnaireSerDes.toJSON(concessionnaire);

		Assert.assertFalse(json.contains(regex));

		concessionnaire = ConcessionnaireSerDes.toDTO(json);

		Assert.assertEquals(regex, concessionnaire.getEmail());
		Assert.assertEquals(regex, concessionnaire.getNom());
		Assert.assertEquals(regex, concessionnaire.getPrenoms());
		Assert.assertEquals(regex, concessionnaire.getTelephone());
		Assert.assertEquals(regex, concessionnaire.getUid());
	}

	@Test
	public void testGetConcessionnairesPage() throws Exception {
		Page<Concessionnaire> page =
			concessionnaireResource.getConcessionnairesPage(
				null, null, Pagination.of(1, 10), null);

		long totalCount = page.getTotalCount();

		Concessionnaire concessionnaire1 =
			testGetConcessionnairesPage_addConcessionnaire(
				randomConcessionnaire());

		Concessionnaire concessionnaire2 =
			testGetConcessionnairesPage_addConcessionnaire(
				randomConcessionnaire());

		page = concessionnaireResource.getConcessionnairesPage(
			null, null, Pagination.of(1, 10), null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(
			concessionnaire1, (List<Concessionnaire>)page.getItems());
		assertContains(
			concessionnaire2, (List<Concessionnaire>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetConcessionnairesPageWithFilterDateTimeEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Concessionnaire concessionnaire1 = randomConcessionnaire();

		concessionnaire1 = testGetConcessionnairesPage_addConcessionnaire(
			concessionnaire1);

		for (EntityField entityField : entityFields) {
			Page<Concessionnaire> page =
				concessionnaireResource.getConcessionnairesPage(
					null,
					getFilterString(entityField, "between", concessionnaire1),
					Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(concessionnaire1),
				(List<Concessionnaire>)page.getItems());
		}
	}

	@Test
	public void testGetConcessionnairesPageWithFilterStringEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Concessionnaire concessionnaire1 =
			testGetConcessionnairesPage_addConcessionnaire(
				randomConcessionnaire());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Concessionnaire concessionnaire2 =
			testGetConcessionnairesPage_addConcessionnaire(
				randomConcessionnaire());

		for (EntityField entityField : entityFields) {
			Page<Concessionnaire> page =
				concessionnaireResource.getConcessionnairesPage(
					null, getFilterString(entityField, "eq", concessionnaire1),
					Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(concessionnaire1),
				(List<Concessionnaire>)page.getItems());
		}
	}

	@Test
	public void testGetConcessionnairesPageWithPagination() throws Exception {
		Page<Concessionnaire> totalPage =
			concessionnaireResource.getConcessionnairesPage(
				null, null, null, null);

		int totalCount = GetterUtil.getInteger(totalPage.getTotalCount());

		Concessionnaire concessionnaire1 =
			testGetConcessionnairesPage_addConcessionnaire(
				randomConcessionnaire());

		Concessionnaire concessionnaire2 =
			testGetConcessionnairesPage_addConcessionnaire(
				randomConcessionnaire());

		Concessionnaire concessionnaire3 =
			testGetConcessionnairesPage_addConcessionnaire(
				randomConcessionnaire());

		Page<Concessionnaire> page1 =
			concessionnaireResource.getConcessionnairesPage(
				null, null, Pagination.of(1, totalCount + 2), null);

		List<Concessionnaire> concessionnaires1 =
			(List<Concessionnaire>)page1.getItems();

		Assert.assertEquals(
			concessionnaires1.toString(), totalCount + 2,
			concessionnaires1.size());

		Page<Concessionnaire> page2 =
			concessionnaireResource.getConcessionnairesPage(
				null, null, Pagination.of(2, totalCount + 2), null);

		Assert.assertEquals(totalCount + 3, page2.getTotalCount());

		List<Concessionnaire> concessionnaires2 =
			(List<Concessionnaire>)page2.getItems();

		Assert.assertEquals(
			concessionnaires2.toString(), 1, concessionnaires2.size());

		Page<Concessionnaire> page3 =
			concessionnaireResource.getConcessionnairesPage(
				null, null, Pagination.of(1, totalCount + 3), null);

		assertContains(
			concessionnaire1, (List<Concessionnaire>)page3.getItems());
		assertContains(
			concessionnaire2, (List<Concessionnaire>)page3.getItems());
		assertContains(
			concessionnaire3, (List<Concessionnaire>)page3.getItems());
	}

	@Test
	public void testGetConcessionnairesPageWithSortDateTime() throws Exception {
		testGetConcessionnairesPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, concessionnaire1, concessionnaire2) -> {
				BeanUtils.setProperty(
					concessionnaire1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetConcessionnairesPageWithSortInteger() throws Exception {
		testGetConcessionnairesPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, concessionnaire1, concessionnaire2) -> {
				BeanUtils.setProperty(
					concessionnaire1, entityField.getName(), 0);
				BeanUtils.setProperty(
					concessionnaire2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetConcessionnairesPageWithSortString() throws Exception {
		testGetConcessionnairesPageWithSort(
			EntityField.Type.STRING,
			(entityField, concessionnaire1, concessionnaire2) -> {
				Class<?> clazz = concessionnaire1.getClass();

				String entityFieldName = entityField.getName();

				java.lang.reflect.Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						concessionnaire1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						concessionnaire2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						concessionnaire1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						concessionnaire2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						concessionnaire1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						concessionnaire2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetConcessionnairesPageWithSort(
			EntityField.Type type,
			UnsafeTriConsumer
				<EntityField, Concessionnaire, Concessionnaire, Exception>
					unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		Concessionnaire concessionnaire1 = randomConcessionnaire();
		Concessionnaire concessionnaire2 = randomConcessionnaire();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(
				entityField, concessionnaire1, concessionnaire2);
		}

		concessionnaire1 = testGetConcessionnairesPage_addConcessionnaire(
			concessionnaire1);

		concessionnaire2 = testGetConcessionnairesPage_addConcessionnaire(
			concessionnaire2);

		for (EntityField entityField : entityFields) {
			Page<Concessionnaire> ascPage =
				concessionnaireResource.getConcessionnairesPage(
					null, null, Pagination.of(1, 2),
					entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(concessionnaire1, concessionnaire2),
				(List<Concessionnaire>)ascPage.getItems());

			Page<Concessionnaire> descPage =
				concessionnaireResource.getConcessionnairesPage(
					null, null, Pagination.of(1, 2),
					entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(concessionnaire2, concessionnaire1),
				(List<Concessionnaire>)descPage.getItems());
		}
	}

	protected Concessionnaire testGetConcessionnairesPage_addConcessionnaire(
			Concessionnaire concessionnaire)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testAddConcessionnaire() throws Exception {
		Concessionnaire randomConcessionnaire = randomConcessionnaire();

		Concessionnaire postConcessionnaire =
			testAddConcessionnaire_addConcessionnaire(randomConcessionnaire);

		assertEquals(randomConcessionnaire, postConcessionnaire);
		assertValid(postConcessionnaire);
	}

	protected Concessionnaire testAddConcessionnaire_addConcessionnaire(
			Concessionnaire concessionnaire)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetTopConcessionnairesActifs() throws Exception {
		Page<Concessionnaire> page =
			concessionnaireResource.getTopConcessionnairesActifs(null, null);

		long totalCount = page.getTotalCount();

		Concessionnaire concessionnaire1 =
			testGetTopConcessionnairesActifs_addConcessionnaire(
				randomConcessionnaire());

		Concessionnaire concessionnaire2 =
			testGetTopConcessionnairesActifs_addConcessionnaire(
				randomConcessionnaire());

		page = concessionnaireResource.getTopConcessionnairesActifs(null, null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(
			concessionnaire1, (List<Concessionnaire>)page.getItems());
		assertContains(
			concessionnaire2, (List<Concessionnaire>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetTopConcessionnairesActifsWithFilterDateTimeEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Concessionnaire concessionnaire1 = randomConcessionnaire();

		concessionnaire1 = testGetTopConcessionnairesActifs_addConcessionnaire(
			concessionnaire1);

		for (EntityField entityField : entityFields) {
			Page<Concessionnaire> page =
				concessionnaireResource.getTopConcessionnairesActifs(
					null,
					getFilterString(entityField, "between", concessionnaire1));

			assertEquals(
				Collections.singletonList(concessionnaire1),
				(List<Concessionnaire>)page.getItems());
		}
	}

	@Test
	public void testGetTopConcessionnairesActifsWithFilterStringEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Concessionnaire concessionnaire1 =
			testGetTopConcessionnairesActifs_addConcessionnaire(
				randomConcessionnaire());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Concessionnaire concessionnaire2 =
			testGetTopConcessionnairesActifs_addConcessionnaire(
				randomConcessionnaire());

		for (EntityField entityField : entityFields) {
			Page<Concessionnaire> page =
				concessionnaireResource.getTopConcessionnairesActifs(
					null, getFilterString(entityField, "eq", concessionnaire1));

			assertEquals(
				Collections.singletonList(concessionnaire1),
				(List<Concessionnaire>)page.getItems());
		}
	}

	protected Concessionnaire
			testGetTopConcessionnairesActifs_addConcessionnaire(
				Concessionnaire concessionnaire)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetConcessionnaireProduits() throws Exception {
		Long id = testGetConcessionnaireProduits_getId();
		Long irrelevantId = testGetConcessionnaireProduits_getIrrelevantId();

		Page<Concessionnaire> page =
			concessionnaireResource.getConcessionnaireProduits(id);

		Assert.assertEquals(0, page.getTotalCount());

		if (irrelevantId != null) {
			Concessionnaire irrelevantConcessionnaire =
				testGetConcessionnaireProduits_addConcessionnaire(
					irrelevantId, randomIrrelevantConcessionnaire());

			page = concessionnaireResource.getConcessionnaireProduits(
				irrelevantId);

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantConcessionnaire),
				(List<Concessionnaire>)page.getItems());
			assertValid(page);
		}

		Concessionnaire concessionnaire1 =
			testGetConcessionnaireProduits_addConcessionnaire(
				id, randomConcessionnaire());

		Concessionnaire concessionnaire2 =
			testGetConcessionnaireProduits_addConcessionnaire(
				id, randomConcessionnaire());

		page = concessionnaireResource.getConcessionnaireProduits(id);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(concessionnaire1, concessionnaire2),
			(List<Concessionnaire>)page.getItems());
		assertValid(page);
	}

	protected Concessionnaire testGetConcessionnaireProduits_addConcessionnaire(
			Long id, Concessionnaire concessionnaire)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetConcessionnaireProduits_getId() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetConcessionnaireProduits_getIrrelevantId()
		throws Exception {

		return null;
	}

	@Test
	public void testDeleteConcessionnaireProduit() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Concessionnaire concessionnaire =
			testDeleteConcessionnaireProduit_addConcessionnaire();

		assertHttpResponseStatusCode(
			204,
			concessionnaireResource.deleteConcessionnaireProduitHttpResponse(
				concessionnaire.getId(), null));
	}

	protected Concessionnaire
			testDeleteConcessionnaireProduit_addConcessionnaire()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	@Test
	public void testGetConcessionnaireById() throws Exception {
		Concessionnaire postConcessionnaire =
			testGetConcessionnaire_addConcessionnaire();

		ConcessionnaireDetail postConcessionnaireDetail =
			testGetConcessionnaireById_addConcessionnaireDetail(
				postConcessionnaire.getId(), randomConcessionnaireDetail());

		ConcessionnaireDetail getConcessionnaireDetail =
			concessionnaireResource.getConcessionnaireById(
				postConcessionnaire.getId());

		assertEquals(postConcessionnaireDetail, getConcessionnaireDetail);
		assertValid(getConcessionnaireDetail);
	}

	protected ConcessionnaireDetail
			testGetConcessionnaireById_addConcessionnaireDetail(
				long concessionnaireId,
				ConcessionnaireDetail concessionnaireDetail)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Concessionnaire testGraphQLConcessionnaire_addConcessionnaire()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(
		Concessionnaire concessionnaire,
		List<Concessionnaire> concessionnaires) {

		boolean contains = false;

		for (Concessionnaire item : concessionnaires) {
			if (equals(concessionnaire, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			concessionnaires + " does not contain " + concessionnaire,
			contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		Concessionnaire concessionnaire1, Concessionnaire concessionnaire2) {

		Assert.assertTrue(
			concessionnaire1 + " does not equal " + concessionnaire2,
			equals(concessionnaire1, concessionnaire2));
	}

	protected void assertEquals(
		List<Concessionnaire> concessionnaires1,
		List<Concessionnaire> concessionnaires2) {

		Assert.assertEquals(concessionnaires1.size(), concessionnaires2.size());

		for (int i = 0; i < concessionnaires1.size(); i++) {
			Concessionnaire concessionnaire1 = concessionnaires1.get(i);
			Concessionnaire concessionnaire2 = concessionnaires2.get(i);

			assertEquals(concessionnaire1, concessionnaire2);
		}
	}

	protected void assertEquals(
		ConcessionnaireDetail concessionnaireDetail1,
		ConcessionnaireDetail concessionnaireDetail2) {

		Assert.assertTrue(
			concessionnaireDetail1 + " does not equal " +
				concessionnaireDetail2,
			equals(concessionnaireDetail1, concessionnaireDetail2));
	}

	protected void assertEqualsIgnoringOrder(
		List<Concessionnaire> concessionnaires1,
		List<Concessionnaire> concessionnaires2) {

		Assert.assertEquals(concessionnaires1.size(), concessionnaires2.size());

		for (Concessionnaire concessionnaire1 : concessionnaires1) {
			boolean contains = false;

			for (Concessionnaire concessionnaire2 : concessionnaires2) {
				if (equals(concessionnaire1, concessionnaire2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				concessionnaires2 + " does not contain " + concessionnaire1,
				contains);
		}
	}

	protected void assertValid(Concessionnaire concessionnaire)
		throws Exception {

		boolean valid = true;

		if (concessionnaire.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("email", additionalAssertFieldName)) {
				if (concessionnaire.getEmail() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("nom", additionalAssertFieldName)) {
				if (concessionnaire.getNom() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("prenoms", additionalAssertFieldName)) {
				if (concessionnaire.getPrenoms() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("telephone", additionalAssertFieldName)) {
				if (concessionnaire.getTelephone() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("uid", additionalAssertFieldName)) {
				if (concessionnaire.getUid() == null) {
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

	protected void assertValid(Page<Concessionnaire> page) {
		boolean valid = false;

		java.util.Collection<Concessionnaire> concessionnaires =
			page.getItems();

		int size = concessionnaires.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(ConcessionnaireDetail concessionnaireDetail) {
		boolean valid = true;

		if (concessionnaireDetail.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalConcessionnaireDetailAssertFieldNames()) {

			if (Objects.equals(
					"concessionnaireProduits", additionalAssertFieldName)) {

				if (concessionnaireDetail.getConcessionnaireProduits() ==
						null) {

					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"concessionnaireTerminals", additionalAssertFieldName)) {

				if (concessionnaireDetail.getConcessionnaireTerminals() ==
						null) {

					valid = false;
				}

				continue;
			}

			if (Objects.equals("email", additionalAssertFieldName)) {
				if (concessionnaireDetail.getEmail() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("nom", additionalAssertFieldName)) {
				if (concessionnaireDetail.getNom() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("prenoms", additionalAssertFieldName)) {
				if (concessionnaireDetail.getPrenoms() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("soldeTotal", additionalAssertFieldName)) {
				if (concessionnaireDetail.getSoldeTotal() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("stats", additionalAssertFieldName)) {
				if (concessionnaireDetail.getStats() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("telephone", additionalAssertFieldName)) {
				if (concessionnaireDetail.getTelephone() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("uid", additionalAssertFieldName)) {
				if (concessionnaireDetail.getUid() == null) {
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

	protected String[] getAdditionalConcessionnaireDetailAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field :
				getDeclaredFields(
					com.df.lonis.ventesrest.dto.v1_0.Concessionnaire.class)) {

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
		Concessionnaire concessionnaire1, Concessionnaire concessionnaire2) {

		if (concessionnaire1 == concessionnaire2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("email", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						concessionnaire1.getEmail(),
						concessionnaire2.getEmail())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						concessionnaire1.getId(), concessionnaire2.getId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("nom", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						concessionnaire1.getNom(), concessionnaire2.getNom())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("prenoms", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						concessionnaire1.getPrenoms(),
						concessionnaire2.getPrenoms())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("telephone", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						concessionnaire1.getTelephone(),
						concessionnaire2.getTelephone())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("uid", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						concessionnaire1.getUid(), concessionnaire2.getUid())) {

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
		ConcessionnaireDetail concessionnaireDetail1,
		ConcessionnaireDetail concessionnaireDetail2) {

		if (concessionnaireDetail1 == concessionnaireDetail2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalConcessionnaireDetailAssertFieldNames()) {

			if (Objects.equals(
					"concessionnaireProduits", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						concessionnaireDetail1.getConcessionnaireProduits(),
						concessionnaireDetail2.getConcessionnaireProduits())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"concessionnaireTerminals", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						concessionnaireDetail1.getConcessionnaireTerminals(),
						concessionnaireDetail2.getConcessionnaireTerminals())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("email", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						concessionnaireDetail1.getEmail(),
						concessionnaireDetail2.getEmail())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						concessionnaireDetail1.getId(),
						concessionnaireDetail2.getId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("nom", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						concessionnaireDetail1.getNom(),
						concessionnaireDetail2.getNom())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("prenoms", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						concessionnaireDetail1.getPrenoms(),
						concessionnaireDetail2.getPrenoms())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("soldeTotal", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						concessionnaireDetail1.getSoldeTotal(),
						concessionnaireDetail2.getSoldeTotal())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("stats", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						concessionnaireDetail1.getStats(),
						concessionnaireDetail2.getStats())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("telephone", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						concessionnaireDetail1.getTelephone(),
						concessionnaireDetail2.getTelephone())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("uid", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						concessionnaireDetail1.getUid(),
						concessionnaireDetail2.getUid())) {

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

		if (!(_concessionnaireResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_concessionnaireResource;

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
		Concessionnaire concessionnaire) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("email")) {
			sb.append("'");
			sb.append(String.valueOf(concessionnaire.getEmail()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("nom")) {
			sb.append("'");
			sb.append(String.valueOf(concessionnaire.getNom()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("prenoms")) {
			sb.append("'");
			sb.append(String.valueOf(concessionnaire.getPrenoms()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("telephone")) {
			sb.append("'");
			sb.append(String.valueOf(concessionnaire.getTelephone()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("uid")) {
			sb.append("'");
			sb.append(String.valueOf(concessionnaire.getUid()));
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

	protected Concessionnaire randomConcessionnaire() throws Exception {
		return new Concessionnaire() {
			{
				email =
					StringUtil.toLowerCase(RandomTestUtil.randomString()) +
						"@liferay.com";
				id = RandomTestUtil.randomLong();
				nom = StringUtil.toLowerCase(RandomTestUtil.randomString());
				prenoms = StringUtil.toLowerCase(RandomTestUtil.randomString());
				telephone = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				uid = StringUtil.toLowerCase(RandomTestUtil.randomString());
			}
		};
	}

	protected Concessionnaire randomIrrelevantConcessionnaire()
		throws Exception {

		Concessionnaire randomIrrelevantConcessionnaire =
			randomConcessionnaire();

		return randomIrrelevantConcessionnaire;
	}

	protected Concessionnaire randomPatchConcessionnaire() throws Exception {
		return randomConcessionnaire();
	}

	protected ConcessionnaireDetail randomConcessionnaireDetail()
		throws Exception {

		return new ConcessionnaireDetail() {
			{
				email = RandomTestUtil.randomString();
				id = RandomTestUtil.randomLong();
				nom = RandomTestUtil.randomString();
				prenoms = RandomTestUtil.randomString();
				soldeTotal = RandomTestUtil.randomLong();
				telephone = RandomTestUtil.randomString();
				uid = RandomTestUtil.randomString();
			}
		};
	}

	protected ConcessionnaireResource concessionnaireResource;
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
		LogFactoryUtil.getLog(BaseConcessionnaireResourceTestCase.class);

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
	private com.df.lonis.ventesrest.resource.v1_0.ConcessionnaireResource
		_concessionnaireResource;

}