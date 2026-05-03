package com.df.lonis.ventesrest.resource.v1_0.test;

import com.df.lonis.ventesrest.client.dto.v1_0.ChiffreAffaire;
import com.df.lonis.ventesrest.client.http.HttpInvoker;
import com.df.lonis.ventesrest.client.pagination.Page;
import com.df.lonis.ventesrest.client.pagination.Pagination;
import com.df.lonis.ventesrest.client.resource.v1_0.ChiffreAffaireResource;
import com.df.lonis.ventesrest.client.serdes.v1_0.ChiffreAffaireSerDes;

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
public abstract class BaseChiffreAffaireResourceTestCase {

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

		_chiffreAffaireResource.setContextCompany(testCompany);

		ChiffreAffaireResource.Builder builder =
			ChiffreAffaireResource.builder();

		chiffreAffaireResource = builder.authentication(
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

		ChiffreAffaire chiffreAffaire1 = randomChiffreAffaire();

		String json = objectMapper.writeValueAsString(chiffreAffaire1);

		ChiffreAffaire chiffreAffaire2 = ChiffreAffaireSerDes.toDTO(json);

		Assert.assertTrue(equals(chiffreAffaire1, chiffreAffaire2));
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

		ChiffreAffaire chiffreAffaire = randomChiffreAffaire();

		String json1 = objectMapper.writeValueAsString(chiffreAffaire);
		String json2 = ChiffreAffaireSerDes.toJSON(chiffreAffaire);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		ChiffreAffaire chiffreAffaire = randomChiffreAffaire();

		chiffreAffaire.setCodeProduit(regex);
		chiffreAffaire.setCodeTerminal(regex);
		chiffreAffaire.setConcessionnaireNomPrenom(regex);
		chiffreAffaire.setProduitType(regex);
		chiffreAffaire.setSite(regex);

		String json = ChiffreAffaireSerDes.toJSON(chiffreAffaire);

		Assert.assertFalse(json.contains(regex));

		chiffreAffaire = ChiffreAffaireSerDes.toDTO(json);

		Assert.assertEquals(regex, chiffreAffaire.getCodeProduit());
		Assert.assertEquals(regex, chiffreAffaire.getCodeTerminal());
		Assert.assertEquals(
			regex, chiffreAffaire.getConcessionnaireNomPrenom());
		Assert.assertEquals(regex, chiffreAffaire.getProduitType());
		Assert.assertEquals(regex, chiffreAffaire.getSite());
	}

	@Test
	public void testGetChiffresAffairesPage() throws Exception {
		Page<ChiffreAffaire> page =
			chiffreAffaireResource.getChiffresAffairesPage(
				null, null, Pagination.of(1, 10), null);

		long totalCount = page.getTotalCount();

		ChiffreAffaire chiffreAffaire1 =
			testGetChiffresAffairesPage_addChiffreAffaire(
				randomChiffreAffaire());

		ChiffreAffaire chiffreAffaire2 =
			testGetChiffresAffairesPage_addChiffreAffaire(
				randomChiffreAffaire());

		page = chiffreAffaireResource.getChiffresAffairesPage(
			null, null, Pagination.of(1, 10), null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(chiffreAffaire1, (List<ChiffreAffaire>)page.getItems());
		assertContains(chiffreAffaire2, (List<ChiffreAffaire>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetChiffresAffairesPageWithFilterDateTimeEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		ChiffreAffaire chiffreAffaire1 = randomChiffreAffaire();

		chiffreAffaire1 = testGetChiffresAffairesPage_addChiffreAffaire(
			chiffreAffaire1);

		for (EntityField entityField : entityFields) {
			Page<ChiffreAffaire> page =
				chiffreAffaireResource.getChiffresAffairesPage(
					null,
					getFilterString(entityField, "between", chiffreAffaire1),
					Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(chiffreAffaire1),
				(List<ChiffreAffaire>)page.getItems());
		}
	}

	@Test
	public void testGetChiffresAffairesPageWithFilterStringEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		ChiffreAffaire chiffreAffaire1 =
			testGetChiffresAffairesPage_addChiffreAffaire(
				randomChiffreAffaire());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		ChiffreAffaire chiffreAffaire2 =
			testGetChiffresAffairesPage_addChiffreAffaire(
				randomChiffreAffaire());

		for (EntityField entityField : entityFields) {
			Page<ChiffreAffaire> page =
				chiffreAffaireResource.getChiffresAffairesPage(
					null, getFilterString(entityField, "eq", chiffreAffaire1),
					Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(chiffreAffaire1),
				(List<ChiffreAffaire>)page.getItems());
		}
	}

	@Test
	public void testGetChiffresAffairesPageWithPagination() throws Exception {
		Page<ChiffreAffaire> totalPage =
			chiffreAffaireResource.getChiffresAffairesPage(
				null, null, null, null);

		int totalCount = GetterUtil.getInteger(totalPage.getTotalCount());

		ChiffreAffaire chiffreAffaire1 =
			testGetChiffresAffairesPage_addChiffreAffaire(
				randomChiffreAffaire());

		ChiffreAffaire chiffreAffaire2 =
			testGetChiffresAffairesPage_addChiffreAffaire(
				randomChiffreAffaire());

		ChiffreAffaire chiffreAffaire3 =
			testGetChiffresAffairesPage_addChiffreAffaire(
				randomChiffreAffaire());

		Page<ChiffreAffaire> page1 =
			chiffreAffaireResource.getChiffresAffairesPage(
				null, null, Pagination.of(1, totalCount + 2), null);

		List<ChiffreAffaire> chiffreAffaires1 =
			(List<ChiffreAffaire>)page1.getItems();

		Assert.assertEquals(
			chiffreAffaires1.toString(), totalCount + 2,
			chiffreAffaires1.size());

		Page<ChiffreAffaire> page2 =
			chiffreAffaireResource.getChiffresAffairesPage(
				null, null, Pagination.of(2, totalCount + 2), null);

		Assert.assertEquals(totalCount + 3, page2.getTotalCount());

		List<ChiffreAffaire> chiffreAffaires2 =
			(List<ChiffreAffaire>)page2.getItems();

		Assert.assertEquals(
			chiffreAffaires2.toString(), 1, chiffreAffaires2.size());

		Page<ChiffreAffaire> page3 =
			chiffreAffaireResource.getChiffresAffairesPage(
				null, null, Pagination.of(1, totalCount + 3), null);

		assertContains(chiffreAffaire1, (List<ChiffreAffaire>)page3.getItems());
		assertContains(chiffreAffaire2, (List<ChiffreAffaire>)page3.getItems());
		assertContains(chiffreAffaire3, (List<ChiffreAffaire>)page3.getItems());
	}

	@Test
	public void testGetChiffresAffairesPageWithSortDateTime() throws Exception {
		testGetChiffresAffairesPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, chiffreAffaire1, chiffreAffaire2) -> {
				BeanUtils.setProperty(
					chiffreAffaire1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetChiffresAffairesPageWithSortInteger() throws Exception {
		testGetChiffresAffairesPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, chiffreAffaire1, chiffreAffaire2) -> {
				BeanUtils.setProperty(
					chiffreAffaire1, entityField.getName(), 0);
				BeanUtils.setProperty(
					chiffreAffaire2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetChiffresAffairesPageWithSortString() throws Exception {
		testGetChiffresAffairesPageWithSort(
			EntityField.Type.STRING,
			(entityField, chiffreAffaire1, chiffreAffaire2) -> {
				Class<?> clazz = chiffreAffaire1.getClass();

				String entityFieldName = entityField.getName();

				java.lang.reflect.Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						chiffreAffaire1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						chiffreAffaire2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						chiffreAffaire1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						chiffreAffaire2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						chiffreAffaire1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						chiffreAffaire2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetChiffresAffairesPageWithSort(
			EntityField.Type type,
			UnsafeTriConsumer
				<EntityField, ChiffreAffaire, ChiffreAffaire, Exception>
					unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		ChiffreAffaire chiffreAffaire1 = randomChiffreAffaire();
		ChiffreAffaire chiffreAffaire2 = randomChiffreAffaire();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(
				entityField, chiffreAffaire1, chiffreAffaire2);
		}

		chiffreAffaire1 = testGetChiffresAffairesPage_addChiffreAffaire(
			chiffreAffaire1);

		chiffreAffaire2 = testGetChiffresAffairesPage_addChiffreAffaire(
			chiffreAffaire2);

		for (EntityField entityField : entityFields) {
			Page<ChiffreAffaire> ascPage =
				chiffreAffaireResource.getChiffresAffairesPage(
					null, null, Pagination.of(1, 2),
					entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(chiffreAffaire1, chiffreAffaire2),
				(List<ChiffreAffaire>)ascPage.getItems());

			Page<ChiffreAffaire> descPage =
				chiffreAffaireResource.getChiffresAffairesPage(
					null, null, Pagination.of(1, 2),
					entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(chiffreAffaire2, chiffreAffaire1),
				(List<ChiffreAffaire>)descPage.getItems());
		}
	}

	protected ChiffreAffaire testGetChiffresAffairesPage_addChiffreAffaire(
			ChiffreAffaire chiffreAffaire)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testExportChiffresAffaires() throws Exception {
		Assert.assertTrue(false);
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	protected ChiffreAffaire testGraphQLChiffreAffaire_addChiffreAffaire()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(
		ChiffreAffaire chiffreAffaire, List<ChiffreAffaire> chiffreAffaires) {

		boolean contains = false;

		for (ChiffreAffaire item : chiffreAffaires) {
			if (equals(chiffreAffaire, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			chiffreAffaires + " does not contain " + chiffreAffaire, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		ChiffreAffaire chiffreAffaire1, ChiffreAffaire chiffreAffaire2) {

		Assert.assertTrue(
			chiffreAffaire1 + " does not equal " + chiffreAffaire2,
			equals(chiffreAffaire1, chiffreAffaire2));
	}

	protected void assertEquals(
		List<ChiffreAffaire> chiffreAffaires1,
		List<ChiffreAffaire> chiffreAffaires2) {

		Assert.assertEquals(chiffreAffaires1.size(), chiffreAffaires2.size());

		for (int i = 0; i < chiffreAffaires1.size(); i++) {
			ChiffreAffaire chiffreAffaire1 = chiffreAffaires1.get(i);
			ChiffreAffaire chiffreAffaire2 = chiffreAffaires2.get(i);

			assertEquals(chiffreAffaire1, chiffreAffaire2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<ChiffreAffaire> chiffreAffaires1,
		List<ChiffreAffaire> chiffreAffaires2) {

		Assert.assertEquals(chiffreAffaires1.size(), chiffreAffaires2.size());

		for (ChiffreAffaire chiffreAffaire1 : chiffreAffaires1) {
			boolean contains = false;

			for (ChiffreAffaire chiffreAffaire2 : chiffreAffaires2) {
				if (equals(chiffreAffaire1, chiffreAffaire2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				chiffreAffaires2 + " does not contain " + chiffreAffaire1,
				contains);
		}
	}

	protected void assertValid(ChiffreAffaire chiffreAffaire) throws Exception {
		boolean valid = true;

		if (chiffreAffaire.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("annulation", additionalAssertFieldName)) {
				if (chiffreAffaire.getAnnulation() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("balance", additionalAssertFieldName)) {
				if (chiffreAffaire.getBalance() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("brut", additionalAssertFieldName)) {
				if (chiffreAffaire.getBrut() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("chiffreAffaire", additionalAssertFieldName)) {
				if (chiffreAffaire.getChiffreAffaire() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("codeProduit", additionalAssertFieldName)) {
				if (chiffreAffaire.getCodeProduit() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("codeTerminal", additionalAssertFieldName)) {
				if (chiffreAffaire.getCodeTerminal() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"concessionnaireNomPrenom", additionalAssertFieldName)) {

				if (chiffreAffaire.getConcessionnaireNomPrenom() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("createdAt", additionalAssertFieldName)) {
				if (chiffreAffaire.getCreatedAt() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("date", additionalAssertFieldName)) {
				if (chiffreAffaire.getDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("deposite", additionalAssertFieldName)) {
				if (chiffreAffaire.getDeposite() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("paiement", additionalAssertFieldName)) {
				if (chiffreAffaire.getPaiement() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("produitType", additionalAssertFieldName)) {
				if (chiffreAffaire.getProduitType() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("rembourcement", additionalAssertFieldName)) {
				if (chiffreAffaire.getRembourcement() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("site", additionalAssertFieldName)) {
				if (chiffreAffaire.getSite() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("updatedAt", additionalAssertFieldName)) {
				if (chiffreAffaire.getUpdatedAt() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("ventes", additionalAssertFieldName)) {
				if (chiffreAffaire.getVentes() == null) {
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

	protected void assertValid(Page<ChiffreAffaire> page) {
		boolean valid = false;

		java.util.Collection<ChiffreAffaire> chiffreAffaires = page.getItems();

		int size = chiffreAffaires.size();

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
					com.df.lonis.ventesrest.dto.v1_0.ChiffreAffaire.class)) {

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
		ChiffreAffaire chiffreAffaire1, ChiffreAffaire chiffreAffaire2) {

		if (chiffreAffaire1 == chiffreAffaire2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("annulation", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						chiffreAffaire1.getAnnulation(),
						chiffreAffaire2.getAnnulation())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("balance", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						chiffreAffaire1.getBalance(),
						chiffreAffaire2.getBalance())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("brut", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						chiffreAffaire1.getBrut(), chiffreAffaire2.getBrut())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("chiffreAffaire", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						chiffreAffaire1.getChiffreAffaire(),
						chiffreAffaire2.getChiffreAffaire())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("codeProduit", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						chiffreAffaire1.getCodeProduit(),
						chiffreAffaire2.getCodeProduit())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("codeTerminal", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						chiffreAffaire1.getCodeTerminal(),
						chiffreAffaire2.getCodeTerminal())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"concessionnaireNomPrenom", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						chiffreAffaire1.getConcessionnaireNomPrenom(),
						chiffreAffaire2.getConcessionnaireNomPrenom())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("createdAt", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						chiffreAffaire1.getCreatedAt(),
						chiffreAffaire2.getCreatedAt())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("date", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						chiffreAffaire1.getDate(), chiffreAffaire2.getDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("deposite", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						chiffreAffaire1.getDeposite(),
						chiffreAffaire2.getDeposite())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						chiffreAffaire1.getId(), chiffreAffaire2.getId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("paiement", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						chiffreAffaire1.getPaiement(),
						chiffreAffaire2.getPaiement())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("produitType", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						chiffreAffaire1.getProduitType(),
						chiffreAffaire2.getProduitType())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("rembourcement", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						chiffreAffaire1.getRembourcement(),
						chiffreAffaire2.getRembourcement())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("site", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						chiffreAffaire1.getSite(), chiffreAffaire2.getSite())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("updatedAt", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						chiffreAffaire1.getUpdatedAt(),
						chiffreAffaire2.getUpdatedAt())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("ventes", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						chiffreAffaire1.getVentes(),
						chiffreAffaire2.getVentes())) {

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

		if (!(_chiffreAffaireResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_chiffreAffaireResource;

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
		ChiffreAffaire chiffreAffaire) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("annulation")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("balance")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("brut")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("chiffreAffaire")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("codeProduit")) {
			sb.append("'");
			sb.append(String.valueOf(chiffreAffaire.getCodeProduit()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("codeTerminal")) {
			sb.append("'");
			sb.append(String.valueOf(chiffreAffaire.getCodeTerminal()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("concessionnaireNomPrenom")) {
			sb.append("'");
			sb.append(
				String.valueOf(chiffreAffaire.getConcessionnaireNomPrenom()));
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
						DateUtils.addSeconds(
							chiffreAffaire.getCreatedAt(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(
							chiffreAffaire.getCreatedAt(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(chiffreAffaire.getCreatedAt()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("date")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(chiffreAffaire.getDate(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(chiffreAffaire.getDate(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(chiffreAffaire.getDate()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("deposite")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("paiement")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("produitType")) {
			sb.append("'");
			sb.append(String.valueOf(chiffreAffaire.getProduitType()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("rembourcement")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("site")) {
			sb.append("'");
			sb.append(String.valueOf(chiffreAffaire.getSite()));
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
						DateUtils.addSeconds(
							chiffreAffaire.getUpdatedAt(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(
							chiffreAffaire.getUpdatedAt(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(chiffreAffaire.getUpdatedAt()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("ventes")) {
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

	protected ChiffreAffaire randomChiffreAffaire() throws Exception {
		return new ChiffreAffaire() {
			{
				annulation = RandomTestUtil.randomLong();
				balance = RandomTestUtil.randomLong();
				brut = RandomTestUtil.randomLong();
				chiffreAffaire = RandomTestUtil.randomLong();
				codeProduit = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				codeTerminal = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				concessionnaireNomPrenom = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				createdAt = RandomTestUtil.nextDate();
				date = RandomTestUtil.nextDate();
				deposite = RandomTestUtil.randomLong();
				id = RandomTestUtil.randomLong();
				paiement = RandomTestUtil.randomLong();
				produitType = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				rembourcement = RandomTestUtil.randomLong();
				site = StringUtil.toLowerCase(RandomTestUtil.randomString());
				updatedAt = RandomTestUtil.nextDate();
				ventes = RandomTestUtil.randomLong();
			}
		};
	}

	protected ChiffreAffaire randomIrrelevantChiffreAffaire() throws Exception {
		ChiffreAffaire randomIrrelevantChiffreAffaire = randomChiffreAffaire();

		return randomIrrelevantChiffreAffaire;
	}

	protected ChiffreAffaire randomPatchChiffreAffaire() throws Exception {
		return randomChiffreAffaire();
	}

	protected ChiffreAffaireResource chiffreAffaireResource;
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
		LogFactoryUtil.getLog(BaseChiffreAffaireResourceTestCase.class);

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
	private com.df.lonis.ventesrest.resource.v1_0.ChiffreAffaireResource
		_chiffreAffaireResource;

}