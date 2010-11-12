/**
 * <copyright>
 * 
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  C.Damus, K.Hussey, E.D.Willink - Initial API and implementation
 * 	E.D.Willink - Bug 306079, 322159
 * 
 * </copyright>
 *
 * $Id: DelegatesTest.java,v 1.4 2010/08/24 16:16:55 ewillink Exp $
 */
package org.eclipse.ocl.ecore.tests;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import noreflectioncompany.NoreflectioncompanyPackage;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.ocl.ecore.delegate.DelegateDomain;
import org.eclipse.ocl.ecore.delegate.DelegateResourceSetAdapter;
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomain;
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomainFactory;
import org.eclipse.ocl.ecore.delegate.OCLDelegateException;
import org.eclipse.ocl.ecore.delegate.OCLInvocationDelegateFactory;
import org.eclipse.ocl.ecore.delegate.OCLSettingDelegateFactory;
import org.eclipse.ocl.ecore.delegate.OCLValidationDelegateFactory;
import org.eclipse.ocl.ecore.delegate.ValidationDelegate;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.osgi.util.NLS;

import company.CompanyPackage;



/**
 * Tests for the OCL delegate implementations.
 */
@SuppressWarnings("nls")
public class DelegatesTest extends AbstractTestSuite
{
	protected static final String COMPANY_XMI = "/model/Company.xmi";	
	protected static final String NO_REFLECTION_COMPANY_XMI = "/model/NoReflectionCompany.xmi";
	protected static final String MODEL_WITH_ERRORS_XMI = "/model/ModelWithErrors.xmi";

	public Resource testResource;
	public EPackage companyPackage;
	public EFactory companyFactory;
	public EClass companyClass;
	public EAttribute companyName;
	public EReference companyEmployees;
	public EAttribute companySize;
	public EClass employeeClass;
	public EAttribute employeeName;
	public EReference employeeManager;
	public EReference employeeDirectReports;
	public EReference employeeAllReports;
	public EOperation employeeReportsTo;
	public EEnum sizeKind;
	public Enumerator sizeSmall;
	public Enumerator sizeMedium;
	public Enumerator sizeLarge;
	public EObject acme;
	public Map<String, EObject> employees;
	public EClass badClassClass;
	public EReference companyDetritus;

	public Map<Object, Object> context = new HashMap<Object, Object>();
	public boolean eclipseIsRunning;
	//
	// Test framework
	//
	@Override
	protected void setUp() {
		super.setUp();
		eclipseIsRunning = eclipseIsRunning();

		String oclDelegateURI = OCLDelegateDomain.OCL_DELEGATE_URI;
		if (!eclipseIsRunning) {		// Install the 'plugin' registrations
			EOperation.Internal.InvocationDelegate.Factory.Registry.INSTANCE.put(oclDelegateURI,
				new OCLInvocationDelegateFactory.Global());
			EStructuralFeature.Internal.SettingDelegate.Factory.Registry.INSTANCE.put(oclDelegateURI,
				new OCLSettingDelegateFactory.Global());
			EValidator.ValidationDelegate.Registry.INSTANCE.put(oclDelegateURI,
				new OCLValidationDelegateFactory.Global());
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				"xmi", new EcoreResourceFactoryImpl());		
			EPackage.Registry.INSTANCE.remove(CompanyPackage.eNS_URI);	// Reference and nullify the side effect of the reference			
			resourceSet.getPackageRegistry().remove(CompanyPackage.eNS_URI);	// In case previous test failed
			EPackage.Registry.INSTANCE.remove(NoreflectioncompanyPackage.eNS_URI);	// Reference and nullify the side effect of the reference
			resourceSet.getPackageRegistry().remove(NoreflectioncompanyPackage.eNS_URI);	// In case previous test failed
		}

		// Install a DelegateResourceSetAdapter to supervise local registries and resource post-loading
		DelegateResourceSetAdapter adapter = DelegateResourceSetAdapter.getAdapter(resourceSet);

		// Install a local DelegateDomain.Factory
		DelegateDomain.Factory.Registry.Impl delegateDomainFactory =
			new DelegateDomain.Factory.Registry.Impl();
		delegateDomainFactory.put(oclDelegateURI, new OCLDelegateDomainFactory());
		adapter.putRegistry(DelegateDomain.Factory.Registry.class, delegateDomainFactory);
				
		// Install a local ValidationDelegate.Factory
		ValidationDelegate.Factory.Registry validationDelegateFactoryRegistry =
			new ValidationDelegate.Factory.Registry.Impl();
		validationDelegateFactoryRegistry.put(oclDelegateURI, new OCLValidationDelegateFactory());
		adapter.putRegistry(ValidationDelegate.Factory.Registry.class, validationDelegateFactoryRegistry);

		// Install a local SettingDelegate.Factory
		EStructuralFeature.Internal.SettingDelegate.Factory.Registry settingDelegateFactoryRegistry =
			new EStructuralFeature.Internal.SettingDelegate.Factory.Registry.Impl();
		settingDelegateFactoryRegistry.put(oclDelegateURI, new OCLSettingDelegateFactory());
		adapter.putRegistry(EStructuralFeature.Internal.SettingDelegate.Factory.Registry.class, settingDelegateFactoryRegistry);

		// Install a local InvocationDelegate.Factory
		EOperation.Internal.InvocationDelegate.Factory.Registry invocationDelegateFactoryRegistry =
			new EOperation.Internal.InvocationDelegate.Factory.Registry.Impl();
		invocationDelegateFactoryRegistry.put(oclDelegateURI, new OCLInvocationDelegateFactory());
		adapter.putRegistry(EOperation.Internal.InvocationDelegate.Factory.Registry.class, invocationDelegateFactoryRegistry);	
		
	}

	protected void initModel(String testModelName) {
		URI uri = getTestModelURI(testModelName);
		testResource = resourceSet.getResource(uri, true);
		
		acme = testResource.getContents().get(0);

		companyClass = acme.eClass();
		companyPackage = companyClass.getEPackage();
		companyFactory = companyPackage.getEFactoryInstance();

		companyName = (EAttribute) companyClass.getEStructuralFeature("name");
		companyEmployees = (EReference) companyClass
			.getEStructuralFeature("employees");
		companySize = (EAttribute) companyClass.getEStructuralFeature("size");

		employeeClass = companyEmployees.getEReferenceType();
		employeeName = (EAttribute) employeeClass.getEStructuralFeature("name");
		employeeManager = (EReference) employeeClass
			.getEStructuralFeature("manager");
		employeeDirectReports = (EReference) employeeClass
			.getEStructuralFeature("directReports");
		employeeAllReports = (EReference) employeeClass
			.getEStructuralFeature("allReports");
		employeeReportsTo = getOperation(employeeClass, "reportsTo");

		sizeKind = (EEnum) companySize.getEAttributeType();
		sizeSmall = sizeKind.getEEnumLiteral("small").getInstance();
		sizeMedium = sizeKind.getEEnumLiteral("medium").getInstance();
		sizeLarge = sizeKind.getEEnumLiteral("large").getInstance();

		employees = new java.util.HashMap<String, EObject>();
	}

	protected void initModelWithErrors() {
		URI uri = getTestModelURI(MODEL_WITH_ERRORS_XMI);
		testResource = resourceSet.getResource(uri, true);
		acme = testResource.getContents().get(0);
		companyClass = acme.eClass();
		companyPackage = companyClass.getEPackage();
		companyFactory = companyPackage.getEFactoryInstance();
		badClassClass = (EClass) companyPackage.getEClassifier("BadClass");
		companyDetritus = (EReference) companyClass .getEStructuralFeature("detritus");
	}

	protected void initPackageRegistrations() {
		if (!eclipseIsRunning) {
			resourceSet.getPackageRegistry().put(CompanyPackage.eNS_URI, CompanyPackage.eINSTANCE);
			resourceSet.getPackageRegistry().put(NoreflectioncompanyPackage.eNS_URI, NoreflectioncompanyPackage.eINSTANCE);
		}
	}

	public void doTest_allInstances(String modelName) {
		initModel(modelName);
		EList<EObject> amyAllReports = allReports(employee("Amy"));
		assertEquals(5, amyAllReports.size());
		assertTrue(amyAllReports.contains(employee("Bob")));
		assertTrue(amyAllReports.contains(employee("Jane")));
		assertTrue(amyAllReports.contains(employee("Fred")));
		assertTrue(amyAllReports.contains(employee("Norbert")));
		assertTrue(amyAllReports.contains(employee("Sally")));

		// change the set of all instances of Employee
		set(create(acme, companyEmployees, employeeClass, "Manuel"),
			employeeManager, employee("Bob"));

		amyAllReports = allReports(employee("Amy"));
		assertEquals(6, amyAllReports.size());
		assertTrue(amyAllReports.contains(employee("Manuel")));
	}

	public void doTest_constraintValidation(String modelName) {
		initModel(modelName);
		EObject employee = create(acme, companyEmployees, employeeClass, null);
		set(employee, employeeManager, employee("Bob"));
		validateConstraintWithError("mustHaveName", employee);
		
		set(employee, employeeName, "Joe");
		validateWithoutError(employee);

		validateWithoutError(acme);
	}

	public void doTest_eAttributeDerivation(String modelName) {
		initModel(modelName);
		assertSame(sizeSmall, size(acme));

		// add a load of employees
		EList<EObject> emps = employees(acme);

		for (int i = 0; i < 60; i++) {
			emps.add(companyFactory.create(employeeClass));
		}

		assertSame(sizeMedium, size(acme));

		// and another bunch
		for (int i = 0; i < 1000; i++) {
			emps.add(companyFactory.create(employeeClass));
		}

		assertSame(sizeLarge, size(acme));
	}

	public void doTest_eReferenceDerivation(String modelName) {
		initModel(modelName);
		EList<EObject> amyReports = directReports(employee("Amy"));
		assertEquals(3, amyReports.size());
		assertTrue(amyReports.contains(employee("Bob")));
		assertTrue(amyReports.contains(employee("Jane")));
		assertTrue(amyReports.contains(employee("Fred")));

		EList<EObject> bobReports = directReports(employee("Bob"));
		assertEquals(2, bobReports.size());
		assertTrue(bobReports.contains(employee("Norbert")));
		assertTrue(bobReports.contains(employee("Sally")));

		EList<EObject> sallyReports = directReports(employee("Sally"));
		assertEquals(0, sallyReports.size());
	}

	public void doTest_invariantValidation(String modelName, boolean hasInvariants) {
		initModel(modelName);
		EObject joe = create(acme, companyEmployees, employeeClass, "Joe");
		if (hasInvariants) {
			validateInvariantWithError("noManagerImpliesDirectReports", joe);
		}
		else {
			validateConstraintWithError("noManagerImpliesDirectReports", joe);
		}

		set(employee("Amy"), employeeManager, joe);
		validateWithoutError(joe);
	}

	public void doTest_operationInvocation(String modelName) {
		initModel(modelName);
		EObject amy = employee("Amy");

		// allReports is implemented using reportsTo()
		EList<EObject> amyAllReports = allReports(amy);
		assertEquals(5, amyAllReports.size());

		for (EObject next : amyAllReports) {
			assertTrue(this.<Boolean> invoke(next, employeeReportsTo, amy));
		}
	}

	public void test_allInstances() {
		doTest_allInstances(COMPANY_XMI);
	}

	public void test_allInstances_registered() {
		initPackageRegistrations();
		doTest_allInstances(COMPANY_XMI);
	}

	public void test_attributeDefinedWithDerivationAndInitial() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		Object actual = get(badClassInstance, (EAttribute)badClassClass.getEStructuralFeature("attributeDefinedWithDerivationAndInitial"));
		assertEquals(42, actual);
	}

	public void test_attributeDefinedWithInitial() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		Object actual = get(badClassInstance, (EAttribute)badClassClass.getEStructuralFeature("attributeDefinedWithInitial"));
		assertEquals(-42, actual);
	}

	public void test_attributeDefinedWithoutDerivation() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		getWithException(badClassInstance, "attributeDefinedWithoutDerivation",
			OCLMessages.MissingDerivationForSettingDelegate_ERROR_, "modelWithErrors::BadClass.attributeDefinedWithoutDerivation");
	}

	public void test_attributeDefinedWithoutDerivationBody() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		getWithException(badClassInstance, "attributeDefinedWithoutDerivationBody",
			OCLMessages.MissingDerivationForSettingDelegate_ERROR_, "modelWithErrors::BadClass.attributeDefinedWithoutDerivationBody");
	}

	public void test_attributeEvaluatingToInvalid() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		getWithException(badClassInstance, "attributeEvaluatingToInvalid",
			OCLMessages.EvaluationResultIsInvalid_ERROR_, "modelWithErrors::BadClass.attributeEvaluatingToInvalid");
	}

	public void test_attributeEvaluatingToNull() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		EStructuralFeature eStructuralFeature = badClassInstance.eClass().getEStructuralFeature("attributeEvaluatingToNull");
		assertEquals(null, get(badClassInstance, eStructuralFeature));
	}

	public void test_attributeEvaluatingToWrongType() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		getWithException(badClassInstance, "attributeEvaluatingToWrongType",
			OCLMessages.InitOrDerConstraintConformance_ERROR_, "String", "attributeEvaluatingToWrongType", "Boolean");
	}

	public void test_attributeParsingToLexicalError() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		getWithException(badClassInstance, "attributeParsingToLexicalError",
			OCLMessages.OCLParseErrorCodes_LEX_ERROR, "2:2", "\"#\"");
	}

	public void test_attributeParsingToSemanticError() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		getWithException(badClassInstance, "attributeParsingToSemanticError",
			OCLMessages.OperationNotFound_ERROR_, "and(Integer)", "String");
	}

	public void test_attributeParsingToSyntacticError() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		getWithException(badClassInstance, "attributeParsingToSyntacticError",
			OCLMessages.OCLParseErrorCodes_DELETION, "2:9:2:12", "\"null\"");
	}

	public void test_constraintValidation() {
		doTest_constraintValidation(COMPANY_XMI);
	}

	public void test_constraintValidation_withoutReflection() {
		doTest_constraintValidation(NO_REFLECTION_COMPANY_XMI);
	}

	public void test_constraintValidation_registered() {
		initPackageRegistrations();
		doTest_constraintValidation(COMPANY_XMI);
	}

	public void test_eAttributeDerivation() {
		doTest_eAttributeDerivation(COMPANY_XMI);
	}

	public void test_eAttributeDerivation_registered() {
		initPackageRegistrations();
		doTest_eAttributeDerivation(COMPANY_XMI);
	}

	public void test_eReferenceDerivation() {
		doTest_eReferenceDerivation(COMPANY_XMI);
	}

	public void test_eReferenceDerivation_registered() {
		initPackageRegistrations();
		doTest_eReferenceDerivation(COMPANY_XMI);
	}

	public void test_invariantValidation() {
		doTest_invariantValidation(COMPANY_XMI, true);
	}

	public void test_invariantValidation_registered() {
		initPackageRegistrations();
		doTest_invariantValidation(COMPANY_XMI, true);
	}

	public void test_invariantValidation_withoutReflection() {
		doTest_invariantValidation(NO_REFLECTION_COMPANY_XMI, true);
	}
	public void test_invariantValidation_withoutReflection_registered() {
		initPackageRegistrations();
		doTest_invariantValidation(NO_REFLECTION_COMPANY_XMI, true);
	}

	public void test_operationDefinedWithoutBody() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		invokeWithException(badClassInstance, "operationDefinedWithoutBody",
			OCLMessages.MissingBodyForInvocationDelegate_ERROR_, "modelWithErrors::BadClass.operationDefinedWithoutBody");
	}

	public void test_operationDefinedWithoutBodyBody() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		invokeWithException(badClassInstance, "operationDefinedWithoutBodyBody",
			OCLMessages.MissingBodyForInvocationDelegate_ERROR_, "modelWithErrors::BadClass.operationDefinedWithoutBodyBody");
	}

	public void test_operationEvaluatingToInvalid() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		invokeWithException(badClassInstance, "operationEvaluatingToInvalid",
			OCLMessages.EvaluationResultIsInvalid_ERROR_, "modelWithErrors::BadClass.operationEvaluatingToInvalid");
	}

	public void test_operationEvaluatingToNull() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		EOperation operation = getOperation(badClassInstance.eClass(), "operationEvaluatingToNull");
		assertEquals(null, invoke(badClassInstance, operation));
	}

	public void test_operationEvaluatingToWrongType() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		invokeWithException(badClassInstance, "operationEvaluatingToWrongType",
			OCLMessages.BodyConditionConformance_ERROR_, "operationEvaluatingToWrongType", "Integer", "Boolean");
	}

	public void test_operationInvocation() {
		doTest_operationInvocation(COMPANY_XMI);
	}

	public void test_operationInvocation_registered() {
		initPackageRegistrations();
		doTest_operationInvocation(COMPANY_XMI);
	}

	public void test_operationParsingToLexicalError() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		invokeWithException(badClassInstance, "operationParsingToLexicalError",
			OCLMessages.OCLParseErrorCodes_DELETION, "2:1:2:2", "\"@@\"");
	}

	public void test_operationParsingToSemanticError() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		invokeWithException(badClassInstance, "operationParsingToSemanticError",
			OCLMessages.OperationNotFound_ERROR_, "oclIsInvalid()", "Set(BadClass)");
	}

	public void test_operationParsingToSyntacticError() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		invokeWithException(badClassInstance, "operationParsingToSyntacticError",
			OCLMessages.OCLParseErrorCodes_DELETION, "2:5:2:6", "\"in\"");
	}

	/**
	 * EObjectValidator  .validateDelegatedConstraints just skips over missing constraints.
	 *
	public void test_validationOfMissingConstraint() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, badClassClass, null);
		validateConstraintWithError("MissingConstraint", badClassInstance);
	} */
	
	/**
	 * EObjectValidator  .validateDelegatedConstraints just skips over null bodies.
	 *
	public void test_validationOfMissingConstraintBody() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, (EClass) companyPackage.getEClassifier("MissingConstraintBody"), null);
		validateConstraintWithError("MissingConstraint", badClassInstance);
	} */
	
	public void test_validationEvaluatingToInvalid() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, (EClass) companyPackage.getEClassifier("ValidationEvaluatingToInvalid"), null);
		String message = NLS.bind(OCLMessages.ValidationResultIsInvalid_ERROR_, "evaluatingToInvalid");
		validateWithError("evaluatingToInvalid", "_UI_ConstraintDelegateException_diagnostic", badClassInstance,
			"evaluatingToInvalid", EObjectValidator.getObjectLabel(badClassInstance, context), message);
	}
	
	public void test_validationEvaluatingToNull() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, (EClass) companyPackage.getEClassifier("ValidationEvaluatingToNull"), null);
		String message = NLS.bind(OCLMessages.ValidationResultIsNull_ERROR_, "evaluatingToNull");
		validateWithError("evaluatingToNull", "_UI_ConstraintDelegateException_diagnostic", badClassInstance,
			"evaluatingToNull", EObjectValidator.getObjectLabel(badClassInstance, context), message);
	}
	
	public void test_validationEvaluatingToWrongType() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, (EClass) companyPackage.getEClassifier("ValidationEvaluatingToWrongType"), null);
		String message = NLS.bind(OCLMessages.InvariantConstraintBoolean_ERROR_, "ValidationEvaluatingToWrongType");
		validateWithError("evaluatingToWrongType", "_UI_ConstraintDelegateException_diagnostic", badClassInstance,
			"evaluatingToWrongType", EObjectValidator.getObjectLabel(badClassInstance, context), message);
	}
	
	public void test_validationParsingToLexicalError() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, (EClass) companyPackage.getEClassifier("ValidationParsingToLexicalError"), null);
		String message = NLS.bind(OCLMessages.OCLParseErrorCodes_INVALID_TOKEN, "1:4", "\"'part\"");
		validateWithError("parsingToLexicalError", "_UI_ConstraintDelegateException_diagnostic", badClassInstance,
			"parsingToLexicalError", EObjectValidator.getObjectLabel(badClassInstance, context), message);
	}
	
	public void test_validationParsingToSemanticError() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, (EClass) companyPackage.getEClassifier("ValidationParsingToSemanticError"), null);
		String message = NLS.bind(OCLMessages.OperationNotFound_ERROR_, "not()", "String");
		validateWithError("parsingToSemanticError", "_UI_ConstraintDelegateException_diagnostic", badClassInstance,
			"parsingToSemanticError", EObjectValidator.getObjectLabel(badClassInstance, context), message);
	}
	
	public void test_validationParsingToSyntacticError() {
		initModelWithErrors();
		EObject badClassInstance = create(acme, companyDetritus, (EClass) companyPackage.getEClassifier("ValidationParsingToSyntacticError"), null);
		String message = NLS.bind(OCLMessages.OCLParseErrorCodes_INVALID_TOKEN, "2:1:2:4", "\"else\"");
		validateWithError("parsingToSyntacticError", "_UI_ConstraintDelegateException_diagnostic", badClassInstance,
			"parsingToSyntacticError", EObjectValidator.getObjectLabel(badClassInstance, context), message);
	}

	void add(EObject owner, EStructuralFeature feature, Object value) {
		this.<EList<Object>> get(owner, feature).add(value);
	}

	EList<EObject> allReports(EObject employee) {
		return get(employee, employeeAllReports);
	}

	EObject create(EObject owner, EReference containment, EClass type,
			String name) {
		EObject result = companyFactory.create(type);

		if (containment.isMany()) {
			add(owner, containment, result);
		} else {
			set(owner, containment, result);
		}

		if (name != null) {
			set(result, type.getEStructuralFeature("name"), name);
		}

		return result;
	}

	EList<EObject> directReports(EObject employee) {
		return get(employee, employeeDirectReports);
	}

	EObject employee(String name) {
		EObject result = employees.get(name);

		if (result == null) {
			EList<EObject> emps = get(acme, companyEmployees);

			for (EObject next : emps) {

				if (name.equals(name(next))) {
					result = next;
					employees.put(name, result);
					break;
				}
			}
		}

		return result;
	}

	EList<EObject> employees(EObject company) {
		return get(company, companyEmployees);
	}

	@SuppressWarnings("unchecked")
	<T> T get(EObject owner, EStructuralFeature feature) {
		return (T) owner.eGet(feature);
	}

	public EOperation getOperation(EClass eClass, String name) {
		for (EOperation eOperation : eClass.getEOperations()) {
			if (name.equals(eOperation.getName())) {
				return eOperation;
			}
		}
		fail("Expected to find operation: " + name);
		return null;
	}

	public void getWithException(EObject eObject, String featureName, String messageTemplate, Object... bindings) {
		EClass eClass = eObject.eClass();
		EAttribute eAttribute = (EAttribute) eClass.getEStructuralFeature(featureName);
		String expectedMessage = NLS.bind(messageTemplate, bindings);
		try {
			@SuppressWarnings("unused")
			Object object = get(eObject, eAttribute);
			fail("Expected to catch OCLDelegateException: " + expectedMessage);
		} catch (OCLDelegateException e) {
			assertEquals("OCLDelegateException: ", expectedMessage, e.getLocalizedMessage());
		}
	}	

	@SuppressWarnings("unchecked")
	<T> T invoke(EObject target, EOperation operation, Object... arguments) {
		try {
			return (T) target.eInvoke(operation, (arguments.length == 0)
				? ECollections.<Object> emptyEList()
				: new BasicEList.UnmodifiableEList<Object>(arguments.length,
					arguments));
		} catch (InvocationTargetException ite) {
			fail("Failed to invoke operation: " + ite.getLocalizedMessage());
			return null;
		}
	}

	public void invokeWithException(EObject eObject, String name,
			String messageTemplate, Object... bindings) {
		EClass eClass = eObject.eClass();
		String expectedMessage = NLS.bind(messageTemplate, bindings);
		for (EOperation eOperation : eClass.getEOperations()) {
			if (name.equals(eOperation.getName())) {
				try {
					@SuppressWarnings("unused")
					Object object = invoke(eObject, eOperation);
					fail("Expected to catch OCLDelegateException: " + expectedMessage);
				} catch (OCLDelegateException e) {
					assertEquals("OCLDelegateException: ", expectedMessage, e.getLocalizedMessage());
					return;
				}
			}
		}
		fail("Expected to find: " + name);
	}

	<T> EList<T> list(T... element) {
		return new BasicEList<T>(Arrays.asList(element));
	}

	EObject manager(EObject employee) {
		return get(employee, employeeManager);
	}

	String name(EObject employeeOrCompany) {
		EAttribute name = employeeClass.isInstance(employeeOrCompany)
			? employeeName
			: companyName;

		return get(employeeOrCompany, name);
	}

	void set(EObject owner, EStructuralFeature feature, Object value) {
		owner.eSet(feature, value);
	}

	Enumerator size(EObject company) {
		return get(company, companySize);
	}

	protected void validateWithoutError(EObject eObject) {
		Diagnostic validation = Diagnostician.INSTANCE.validate(eObject, context);
		if (validation.getSeverity() != Diagnostic.OK) {
			List<Diagnostic> diagnostics = validation.getChildren();
			if (!diagnostics.isEmpty()) {
				StringBuffer s = new StringBuffer();
				for (Diagnostic diagnostic : diagnostics) {
					s.append(diagnostic.getMessage());
					s.append("\n");
				}
				fail(s.toString());
			}
		}
		assertEquals("Validation severity:", Diagnostic.OK, validation.getSeverity());
		List<Diagnostic> diagnostics = validation.getChildren();
		assertEquals("Validation child count:", 0, diagnostics.size());
	}

	protected void validateConstraintWithError(String constraintName, EObject eObject) {
		Diagnostic validation = Diagnostician.INSTANCE.validate(eObject, context);
		assertEquals("Validation of '" + constraintName + "' severity:", Diagnostic.ERROR, validation.getSeverity());
		List<Diagnostic> diagnostics = validation.getChildren();
		assertEquals("Validation of '" + constraintName + "' child count:", 1, diagnostics.size());
		Diagnostic diagnostic = diagnostics.get(0);
		assertEquals("Validation of '" + constraintName + "' data count:", 1, diagnostic.getData().size());
		assertEquals("Validation of '" + constraintName + "' data object:", eObject, diagnostic.getData().get(0));
		Object objectLabel = EObjectValidator.getObjectLabel(eObject, context);
		String messageTemplate = EcorePlugin.INSTANCE.getString("_UI_GenericConstraint_diagnostic");
		String message = NLS.bind(messageTemplate, constraintName, objectLabel);
		assertEquals("Validation of '" + constraintName + "' message:", message, diagnostic.getMessage());
	}

	protected void validateInvariantWithError(String constraintName, EObject eObject) {
		validateWithError(constraintName, "_UI_GenericInvariant_diagnostic", eObject, constraintName, EObjectValidator.getObjectLabel(eObject, context));
	}

	protected void validateWithError(String constraintName, String errorKey, EObject eObject, Object... bindings) {
		Diagnostic validation = Diagnostician.INSTANCE.validate(eObject, context);
		assertEquals("Validation of '" + constraintName + "' severity:", Diagnostic.ERROR, validation.getSeverity());
		List<Diagnostic> diagnostics = validation.getChildren();
		assertEquals("Validation of '" + constraintName + "' child count:", 1, diagnostics.size());
		Diagnostic diagnostic = diagnostics.get(0);
		assertEquals("Validation of '" + constraintName + "' data count:", 1, diagnostic.getData().size());
		assertEquals("Validation of '" + constraintName + "' data object:", eObject, diagnostic.getData().get(0));
		String messageTemplate = EcorePlugin.INSTANCE.getString(errorKey);
		String message = NLS.bind(messageTemplate, bindings);
		assertEquals("Validation of '" + constraintName + "' message:", message, diagnostic.getMessage());
	}
}
