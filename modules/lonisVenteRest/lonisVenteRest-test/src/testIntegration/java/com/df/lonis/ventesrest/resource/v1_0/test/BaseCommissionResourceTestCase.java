package com.df.lonis.ventesrest.resource.v1_0.test;

import com.df.lonis.ventesrest.client.dto.v1_0.Commission;
import com.df.lonis.ventesrest.client.dto.v1_0.CommissionDetail;
import com.df.lonis.ventesrest.client.dto.v1_0.ExportResponse;
import com.df.lonis.ventesrest.client.http.HttpInvoker;
import com.df.lonis.ventesrest.client.pagination.Page;
import com.df.lonis.ventesrest.client.pagination.Pagination;
import com.df.lonis.ventesrest.client.resource.v1_0.CommissionResource;
import com.df.lonis.ventesrest.client.serdes.v1_0.CommissionSerDes;

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
import com.liferay.portal.kernel.util.GetterUtil;
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
public abstract class BaseCommissionResourceTestCase {

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

		_commissionResource.setContextCompany(testCompany);

		CommissionResource.Builder builder = CommissionResource.builder();

		commissionResource = builder.authentication(
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

		Commission commission1 = randomCommission();

		String json = objectMapper.writeValueAsString(commission1);

		Commission commission2 = CommissionSerDes.toDTO(json);

		Assert.assertTrue(equals(commission1, commission2));
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

		Commission commission = randomCommission();

		String json1 = objectMapper.writeValueAsString(commission);
		String json2 = CommissionSerDes.toJSON(commission);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Commission commission = randomCommission();

		commission.setCode(regex);
		commission.setCodeTerminal(regex);
		commission.setLibelle(regex);
		commission.setStatus(regex);

		String json = CommissionSerDes.toJSON(commission);

		Assert.assertFalse(json.contains(regex));

		commission = CommissionSerDes.toDTO(json);

		Assert.assertEquals(regex, commission.getCode());
		Assert.assertEquals(regex, commission.getCodeTerminal());
		Assert.assertEquals(regex, commission.getLibelle());
		Assert.assertEquals(regex, commission.getStatus());
	}

	@Test
	public void testGetCommissionsPage() throws Exception {
		Page<Commission> page = commissionResource.getCommissionsPage(
			null, null, RandomTestUtil.randomString(), Pagination.of(1, 10));

		long totalCount = page.getTotalCount();

		Commission commission1 = testGetCommissionsPage_addCommission(
			randomCommission());

		Commission commission2 = testGetCommissionsPage_addCommission(
			randomCommission());

		page = commissionResource.getCommissionsPage(
			null, null, null, Pagination.of(1, 10));

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(commission1, (List<Commission>)page.getItems());
		assertContains(commission2, (List<Commission>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetCommissionsPageWithPagination() throws Exception {
		Page<Commission> totalPage = commissionResource.getCommissionsPage(
			null, null, null, null);

		int totalCount = GetterUtil.getInteger(totalPage.getTotalCount());

		Commission commission1 = testGetCommissionsPage_addCommission(
			randomCommission());

		Commission commission2 = testGetCommissionsPage_addCommission(
			randomCommission());

		Commission commission3 = testGetCommissionsPage_addCommission(
			randomCommission());

		Page<Commission> page1 = commissionResource.getCommissionsPage(
			null, null, null, Pagination.of(1, totalCount + 2));

		List<Commission> commissions1 = (List<Commission>)page1.getItems();

		Assert.assertEquals(
			commissions1.toString(), totalCount + 2, commissions1.size());

		Page<Commission> page2 = commissionResource.getCommissionsPage(
			null, null, null, Pagination.of(2, totalCount + 2));

		Assert.assertEquals(totalCount + 3, page2.getTotalCount());

		List<Commission> commissions2 = (List<Commission>)page2.getItems();

		Assert.assertEquals(commissions2.toString(), 1, commissions2.size());

		Page<Commission> page3 = commissionResource.getCommissionsPage(
			null, null, null, Pagination.of(1, totalCount + 3));

		assertContains(commission1, (List<Commission>)page3.getItems());
		assertContains(commission2, (List<Commission>)page3.getItems());
		assertContains(commission3, (List<Commission>)page3.getItems());
	}

	protected Commission testGetCommissionsPage_addCommission(
			Commission commission)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetConcessionnaireCommissions() throws Exception {
		Commission postCommission =
			testGetConcessionnaireCommissions_addCommission();

		Commission getCommission =
			commissionResource.getConcessionnaireCommissions(
				postCommission.getId(), null, null, Pagination.of(1, 2));

		assertEquals(postCommission, getCommission);
		assertValid(getCommission);
	}

	protected Commission testGetConcessionnaireCommissions_addCommission()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetCommissionsExport() throws Exception {
		Commission postCommission = testGetCommission_addCommission();

		ExportResponse postExportResponse =
			testGetCommissionsExport_addExportResponse(
				postCommission.getId(), randomExportResponse());

		ExportResponse getExportResponse =
			commissionResource.getCommissionsExport(postCommission.getId());

		assertEquals(postExportResponse, getExportResponse);
		assertValid(getExportResponse);
	}

	protected ExportResponse testGetCommissionsExport_addExportResponse(
			long commissionId, ExportResponse exportResponse)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetCommission() throws Exception {
		Commission postCommission = testGetCommission_addCommission();

		CommissionDetail postCommissionDetail =
			testGetCommission_addCommissionDetail(
				postCommission.getId(), randomCommissionDetail());

		CommissionDetail getCommissionDetail = commissionResource.getCommission(
			postCommission.getId());

		assertEquals(postCommissionDetail, getCommissionDetail);
		assertValid(getCommissionDetail);
	}

	protected CommissionDetail testGetCommission_addCommissionDetail(
			long commissionId, CommissionDetail commissionDetail)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Commission testGraphQLCommission_addCommission()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(
		Commission commission, List<Commission> commissions) {

		boolean contains = false;

		for (Commission item : commissions) {
			if (equals(commission, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			commissions + " does not contain " + commission, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		Commission commission1, Commission commission2) {

		Assert.assertTrue(
			commission1 + " does not equal " + commission2,
			equals(commission1, commission2));
	}

	protected void assertEquals(
		List<Commission> commissions1, List<Commission> commissions2) {

		Assert.assertEquals(commissions1.size(), commissions2.size());

		for (int i = 0; i < commissions1.size(); i++) {
			Commission commission1 = commissions1.get(i);
			Commission commission2 = commissions2.get(i);

			assertEquals(commission1, commission2);
		}
	}

	protected void assertEquals(
		ExportResponse exportResponse1, ExportResponse exportResponse2) {

		Assert.assertTrue(
			exportResponse1 + " does not equal " + exportResponse2,
			equals(exportResponse1, exportResponse2));
	}

	protected void assertEquals(
		CommissionDetail commissionDetail1,
		CommissionDetail commissionDetail2) {

		Assert.assertTrue(
			commissionDetail1 + " does not equal " + commissionDetail2,
			equals(commissionDetail1, commissionDetail2));
	}

	protected void assertEqualsIgnoringOrder(
		List<Commission> commissions1, List<Commission> commissions2) {

		Assert.assertEquals(commissions1.size(), commissions2.size());

		for (Commission commission1 : commissions1) {
			boolean contains = false;

			for (Commission commission2 : commissions2) {
				if (equals(commission1, commission2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				commissions2 + " does not contain " + commission1, contains);
		}
	}

	protected void assertValid(Commission commission) throws Exception {
		boolean valid = true;

		if (commission.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("code", additionalAssertFieldName)) {
				if (commission.getCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("codeTerminal", additionalAssertFieldName)) {
				if (commission.getCodeTerminal() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("createdAt", additionalAssertFieldName)) {
				if (commission.getCreatedAt() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("libelle", additionalAssertFieldName)) {
				if (commission.getLibelle() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("nombreTerminaux", additionalAssertFieldName)) {
				if (commission.getNombreTerminaux() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("paye", additionalAssertFieldName)) {
				if (commission.getPaye() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (commission.getStatus() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("terminalId", additionalAssertFieldName)) {
				if (commission.getTerminalId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("updatedAt", additionalAssertFieldName)) {
				if (commission.getUpdatedAt() == null) {
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

	protected void assertValid(Page<Commission> page) {
		boolean valid = false;

		java.util.Collection<Commission> commissions = page.getItems();

		int size = commissions.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(ExportResponse exportResponse) {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalExportResponseAssertFieldNames()) {

			if (Objects.equals("downloadUrl", additionalAssertFieldName)) {
				if (exportResponse.getDownloadUrl() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("expiresAt", additionalAssertFieldName)) {
				if (exportResponse.getExpiresAt() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("fileName", additionalAssertFieldName)) {
				if (exportResponse.getFileName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("format", additionalAssertFieldName)) {
				if (exportResponse.getFormat() == null) {
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

	protected void assertValid(CommissionDetail commissionDetail) {
		boolean valid = true;

		if (commissionDetail.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalCommissionDetailAssertFieldNames()) {

			if (Objects.equals("chiffreAffaires", additionalAssertFieldName)) {
				if (commissionDetail.getChiffreAffaires() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("codeTerminal", additionalAssertFieldName)) {
				if (commissionDetail.getCodeTerminal() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("commissionVersee", additionalAssertFieldName)) {
				if (commissionDetail.getCommissionVersee() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("compteReception", additionalAssertFieldName)) {
				if (commissionDetail.getCompteReception() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("dateVersement", additionalAssertFieldName)) {
				if (commissionDetail.getDateVersement() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("paye", additionalAssertFieldName)) {
				if (commissionDetail.getPaye() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (commissionDetail.getStatus() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("typeVersement", additionalAssertFieldName)) {
				if (commissionDetail.getTypeVersement() == null) {
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

	protected String[] getAdditionalExportResponseAssertFieldNames() {
		return new String[0];
	}

	protected String[] getAdditionalCommissionDetailAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field :
				getDeclaredFields(
					com.df.lonis.ventesrest.dto.v1_0.Commission.class)) {

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

	protected boolean equals(Commission commission1, Commission commission2) {
		if (commission1 == commission2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("code", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						commission1.getCode(), commission2.getCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("codeTerminal", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						commission1.getCodeTerminal(),
						commission2.getCodeTerminal())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("createdAt", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						commission1.getCreatedAt(),
						commission2.getCreatedAt())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						commission1.getId(), commission2.getId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("libelle", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						commission1.getLibelle(), commission2.getLibelle())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("nombreTerminaux", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						commission1.getNombreTerminaux(),
						commission2.getNombreTerminaux())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("paye", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						commission1.getPaye(), commission2.getPaye())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						commission1.getStatus(), commission2.getStatus())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("terminalId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						commission1.getTerminalId(),
						commission2.getTerminalId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("updatedAt", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						commission1.getUpdatedAt(),
						commission2.getUpdatedAt())) {

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
		ExportResponse exportResponse1, ExportResponse exportResponse2) {

		if (exportResponse1 == exportResponse2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalExportResponseAssertFieldNames()) {

			if (Objects.equals("downloadUrl", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						exportResponse1.getDownloadUrl(),
						exportResponse2.getDownloadUrl())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("expiresAt", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						exportResponse1.getExpiresAt(),
						exportResponse2.getExpiresAt())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("fileName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						exportResponse1.getFileName(),
						exportResponse2.getFileName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("format", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						exportResponse1.getFormat(),
						exportResponse2.getFormat())) {

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
		CommissionDetail commissionDetail1,
		CommissionDetail commissionDetail2) {

		if (commissionDetail1 == commissionDetail2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalCommissionDetailAssertFieldNames()) {

			if (Objects.equals("chiffreAffaires", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						commissionDetail1.getChiffreAffaires(),
						commissionDetail2.getChiffreAffaires())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("codeTerminal", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						commissionDetail1.getCodeTerminal(),
						commissionDetail2.getCodeTerminal())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("commissionVersee", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						commissionDetail1.getCommissionVersee(),
						commissionDetail2.getCommissionVersee())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("compteReception", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						commissionDetail1.getCompteReception(),
						commissionDetail2.getCompteReception())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("dateVersement", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						commissionDetail1.getDateVersement(),
						commissionDetail2.getDateVersement())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						commissionDetail1.getId(), commissionDetail2.getId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("paye", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						commissionDetail1.getPaye(),
						commissionDetail2.getPaye())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						commissionDetail1.getStatus(),
						commissionDetail2.getStatus())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("typeVersement", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						commissionDetail1.getTypeVersement(),
						commissionDetail2.getTypeVersement())) {

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

		if (!(_commissionResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_commissionResource;

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
		EntityField entityField, String operator, Commission commission) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("code")) {
			sb.append("'");
			sb.append(String.valueOf(commission.getCode()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("codeTerminal")) {
			sb.append("'");
			sb.append(String.valueOf(commission.getCodeTerminal()));
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
						DateUtils.addSeconds(commission.getCreatedAt(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(commission.getCreatedAt(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(commission.getCreatedAt()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("libelle")) {
			sb.append("'");
			sb.append(String.valueOf(commission.getLibelle()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("nombreTerminaux")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("paye")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("status")) {
			sb.append("'");
			sb.append(String.valueOf(commission.getStatus()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("terminalId")) {
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
						DateUtils.addSeconds(commission.getUpdatedAt(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(commission.getUpdatedAt(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(commission.getUpdatedAt()));
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

	protected Commission randomCommission() throws Exception {
		return new Commission() {
			{
				code = StringUtil.toLowerCase(RandomTestUtil.randomString());
				codeTerminal = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				createdAt = RandomTestUtil.nextDate();
				id = RandomTestUtil.randomLong();
				libelle = StringUtil.toLowerCase(RandomTestUtil.randomString());
				nombreTerminaux = RandomTestUtil.randomInt();
				paye = RandomTestUtil.randomBoolean();
				status = StringUtil.toLowerCase(RandomTestUtil.randomString());
				terminalId = RandomTestUtil.randomLong();
				updatedAt = RandomTestUtil.nextDate();
			}
		};
	}

	protected Commission randomIrrelevantCommission() throws Exception {
		Commission randomIrrelevantCommission = randomCommission();

		return randomIrrelevantCommission;
	}

	protected Commission randomPatchCommission() throws Exception {
		return randomCommission();
	}

	protected ExportResponse randomExportResponse() throws Exception {
		return new ExportResponse() {
			{
				downloadUrl = RandomTestUtil.randomString();
				expiresAt = RandomTestUtil.nextDate();
				fileName = RandomTestUtil.randomString();
			}
		};
	}

	protected CommissionDetail randomCommissionDetail() throws Exception {
		return new CommissionDetail() {
			{
				chiffreAffaires = RandomTestUtil.randomLong();
				codeTerminal = RandomTestUtil.randomString();
				commissionVersee = RandomTestUtil.randomLong();
				compteReception = RandomTestUtil.randomString();
				dateVersement = RandomTestUtil.nextDate();
				id = RandomTestUtil.randomLong();
				paye = RandomTestUtil.randomBoolean();
				status = RandomTestUtil.randomString();
				typeVersement = RandomTestUtil.randomString();
			}
		};
	}

	protected CommissionResource commissionResource;
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
		LogFactoryUtil.getLog(BaseCommissionResourceTestCase.class);

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
	private com.df.lonis.ventesrest.resource.v1_0.CommissionResource
		_commissionResource;

}