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
 *  K.Hussey - Bug 331143
 * 
 * </copyright>
 *
 * $Id: DelegatesTest.java,v 1.6 2011/01/23 22:20:00 auhl Exp $
 */
package org.eclipse.ocl.ecore.tests;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import noreflectioncompany.NoreflectioncompanyPackage;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EOperation.Internal.InvocationDelegate;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Internal.SettingDelegate;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.QueryDelegate;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.BooleanLiteralExp;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.EvaluationVisitorImpl;
import org.eclipse.ocl.ecore.NullLiteralExp;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.PropertyCallExp;
import org.eclipse.ocl.ecore.delegate.DelegateDomain;
import org.eclipse.ocl.ecore.delegate.DelegateResourceSetAdapter;
import org.eclipse.ocl.ecore.delegate.InvocationBehavior;
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomain;
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomainFactory;
import org.eclipse.ocl.ecore.delegate.OCLDelegateException;
import org.eclipse.ocl.ecore.delegate.OCLInvocationDelegateFactory;
import org.eclipse.ocl.ecore.delegate.OCLQueryDelegateFactory;
import org.eclipse.ocl.ecore.delegate.OCLSettingDelegateFactory;
import org.eclipse.ocl.ecore.delegate.OCLValidationDelegateFactory;
import org.eclipse.ocl.ecore.delegate.SettingBehavior;
import org.eclipse.ocl.ecore.delegate.ValidationBehavior;
import org.eclipse.ocl.ecore.delegate.ValidationDelegate;
import org.eclipse.ocl.ecore.opposites.DefaultOppositeEndFinder;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.osgi.util.NLS;

import company.CompanyPackage;
import company.Employee;
import company.util.CompanyValidator;



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
	public boolean usedLocalRegistry;
	//
	// Test framework
	//
	@Override
	protected void setUp() {
		super.setUp();
		eclipseIsRunning = eclipseIsRunning();
		usedLocalRegistry = false;

		String oclDelegateURI = OCLDelegateDomain.OCL_DELEGATE_URI;
		if (!eclipseIsRunning) {		// Install the 'plugin' registrations
			EOperation.Internal.InvocationDelegate.Factory.Registry.INSTANCE.put(oclDelegateURI,
				new OCLInvocationDelegateFactory.Global());
			EStructuralFeature.Internal.SettingDelegate.Factory.Registry.INSTANCE.put(oclDelegateURI,
				new OCLSettingDelegateFactory.Global());
			EValidator.ValidationDelegate.Registry.INSTANCE.put(oclDelegateURI,
				new OCLValidationDelegateFactory.Global());
			QueryDelegate.Factory.Registry.INSTANCE.put(oclDelegateURI,
				new OCLQueryDelegateFactory.Global());
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
		validationDelegateFactoryRegistry.put(oclDelegateURI, new OCLValidationDelegateFactory() {

			@Override
			public ValidationDelegate createValidationDelegate(EClassifier classifier) {
				usedLocalRegistry = true;
				return super.createValidationDelegate(classifier);
			}
			
		});
		adapter.putRegistry(ValidationDelegate.Factory.Registry.class, validationDelegateFactoryRegistry);

		// Install a local SettingDelegate.Factory
		EStructuralFeature.Internal.SettingDelegate.Factory.Registry settingDelegateFactoryRegistry =
			new EStructuralFeature.Internal.SettingDelegate.Factory.Registry.Impl();
		settingDelegateFactoryRegistry.put(oclDelegateURI, new OCLSettingDelegateFactory() {

			@Override
			public SettingDelegate createSettingDelegate(EStructuralFeature structuralFeature) {
				usedLocalRegistry = true;
				return super.createSettingDelegate(structuralFeature);
			}
			
		});
		adapter.putRegistry(EStructuralFeature.Internal.SettingDelegate.Factory.Registry.class, settingDelegateFactoryRegistry);

		// Install a local InvocationDelegate.Factory
		EOperation.Internal.InvocationDelegate.Factory.Registry invocationDelegateFactoryRegistry =
			new EOperation.Internal.InvocationDelegate.Factory.Registry.Impl();
		invocationDelegateFactoryRegistry.put(oclDelegateURI, new OCLInvocationDelegateFactory() {
			@Override
			public InvocationDelegate createInvocationDelegate(EOperation operation) {
				usedLocalRegistry = true;
				return super.createInvocationDelegate(operation);
			}
			
		});
		adapter.putRegistry(EOperation.Internal.InvocationDelegate.Factory.Registry.class, invocationDelegateFactoryRegistry);	

		// Install a local QueryDelegate.Factory
		QueryDelegate.Factory.Registry queryDelegateFactoryRegistry =
			new QueryDelegate.Factory.Registry.Impl();
		queryDelegateFactoryRegistry.put(oclDelegateURI, new OCLQueryDelegateFactory() {
			@Override
			public QueryDelegate createQueryDelegate(EClassifier context,
					Map<String, EClassifier> parameters, String expression) {
				usedLocalRegistry = true;
				return super.createQueryDelegate(context, parameters, expression);
			}});
		adapter.putRegistry(QueryDelegate.Factory.Registry.class, queryDelegateFactoryRegistry);			
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

	public void doTest_queryExecution(String modelName) {
		initModel(modelName);

		QueryDelegate.Factory factory = QueryDelegate.Factory.Registry.INSTANCE
			.getFactory(OCLDelegateDomain.OCL_DELEGATE_URI);

		String n = "n";
		String expression = "self.employees->select(employee | employee.manager <> null and employee.manager.name = n)";
		EObject amy = employee("Amy");
		Map<String, EClassifier> parameters = new HashMap<String, EClassifier>();
		parameters.put(n, EcorePackage.Literals.ESTRING);

		QueryDelegate delegate = factory.createQueryDelegate(companyClass,
			parameters, expression);

		executeWithException(delegate, amy, null,
			OCLMessages.WrongContextClassifier_ERROR_, amy.eClass().getName(), acme.eClass().getName());

		Map<String, Object> arguments = new HashMap<String, Object>();
		arguments.put(n, "Amy");

		Collection<?> amyReports = (Collection<?>) execute(delegate, acme, arguments);
		assertEquals(3, amyReports.size());
		assertTrue(amyReports.contains(employee("Bob")));
		assertTrue(amyReports.contains(employee("Jane")));
		assertTrue(amyReports.contains(employee("Fred")));

		executeWithException(delegate, employee("Bob"), null,
			OCLMessages.WrongContextClassifier_ERROR_, amy.eClass().getName(), acme.eClass().getName());

		arguments = new HashMap<String, Object>();
		arguments.put(n, "Bob");

		Collection<?> bobReports = (Collection<?>) execute(delegate, acme, arguments);
		assertEquals(2, bobReports.size());
		assertTrue(bobReports.contains(employee("Norbert")));
		assertTrue(bobReports.contains(employee("Sally")));

		executeWithException(delegate, employee("Sally"), null,
			OCLMessages.WrongContextClassifier_ERROR_, amy.eClass().getName(), acme.eClass().getName());

		arguments = new HashMap<String, Object>();
		arguments.put(n, "Sally");

		Collection<?> sallyReports = (Collection<?>) execute(delegate, acme, arguments);
		assertEquals(0, sallyReports.size());
	}

	public void doTest_queryExecutionWithExceptions(String modelName) throws InvocationTargetException {
		initModel(modelName);

		QueryDelegate.Factory factory = QueryDelegate.Factory.Registry.INSTANCE
			.getFactory(OCLDelegateDomain.OCL_DELEGATE_URI);

		String okName = "ok";
		String badName = "xyzzy";
		EObject amy = employee("Amy");
		Map<String, Object> okBindings = new HashMap<String, Object>();
		okBindings.put(okName, Integer.valueOf(123));
		Map<String, EClassifier> variables = new HashMap<String, EClassifier>();
		variables.put(okName, EcorePackage.Literals.ESTRING);
		QueryDelegate delegate;
		//
		//	Syntax error in expression
		//
		delegate = factory.createQueryDelegate(companyClass, null, "n=");
		executeWithException(delegate, amy, null,
			"2:2:2:2 \"relationalNotLetCS\" expected after \"=\"");
		//
		//	Undeclared variable
		//
		delegate = factory.createQueryDelegate(companyClass, variables, badName);
		executeWithException(delegate, acme, null,
			OCLMessages.UnrecognizedVar_ERROR_, badName);
		//
		//	Definition of undeclared variable
		//
		delegate = factory.createQueryDelegate(companyClass, variables, "self");
		Map<String, Object> bindings = new HashMap<String, Object>();
		bindings.put(okName, "xx");
		bindings.put(badName, Integer.valueOf(123));
		executeWithException(delegate, acme, bindings,
			OCLMessages.ExtraArg_ERROR_, badName);
		//
		//	Mis-definition of context
		//
		delegate = factory.createQueryDelegate(companyClass, variables, "self");
		delegate.prepare();
		executeWithException(delegate, amy, okBindings,
			OCLMessages.WrongContextClassifier_ERROR_, amy.eClass().getName(), acme.eClass().getName());
		//
		//	Mis-definition of variable
		//
		delegate = factory.createQueryDelegate(companyClass, variables, "self");
		delegate.prepare();
		executeWithException(delegate, acme, okBindings,
			OCLMessages.TypeConformanceInit_ERROR_, okName);
	}

	public void test_allInstances() {
		doTest_allInstances(COMPANY_XMI);
		assertEquals(!eclipseIsRunning, usedLocalRegistry);
	}

	public void test_allInstances_registered() {
		initPackageRegistrations();
		doTest_allInstances(COMPANY_XMI);
		assertFalse(usedLocalRegistry);
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

	/**
	 * Ensures that {@link InvocationBehavior#getOperationBody(OCL, EOperation)}
	 * consistently returns <code>null</code> for stdlib operations that don't
	 * have a body defined at all instead of returning an <code>invalid</code> literal.
	 * @throws ParserException 
	 */
	public void test_attributeNotDefinedInOCLRemainsNull() throws ParserException {
		helper.setContext(EcorePackage.eINSTANCE.getEClassifier());
		OCLExpression expr = (OCLExpression) helper.createQuery("self.name");
		assertTrue(expr instanceof PropertyCallExp);
		PropertyCallExp pce = (PropertyCallExp) expr;
		EStructuralFeature p = pce.getReferredProperty();
		OCLExpression body = SettingBehavior.INSTANCE.getFeatureBody((OCL) ocl, p);
		assertNull(body);
		// and again, now reading from cache
		OCLExpression bodyStillNull = SettingBehavior.INSTANCE.getFeatureBody((OCL) ocl, p);
		assertNull(bodyStillNull);
	}

	public void test_constraintValidation() {
		doTest_constraintValidation(COMPANY_XMI);
		assertEquals(!eclipseIsRunning, usedLocalRegistry);
	}

	public void test_constraintValidation_withoutReflection() {
		doTest_constraintValidation(NO_REFLECTION_COMPANY_XMI);
	}

	public void test_constraintValidation_registered() {
		initPackageRegistrations();
		doTest_constraintValidation(COMPANY_XMI);
		assertFalse(usedLocalRegistry);
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

	/**
	 * Caches an operation AST in the annotation used by the {@link SettingBehavior} implementation
	 * and ensures that it's used by the delegate as well as the {@link EvaluationVisitorImpl}
	 * @throws ParserException 
	 * @throws InvocationTargetException 
	 */
	public void test_eReferenceDerivationUsedFromCache() throws ParserException, InvocationTargetException {
		initModel(COMPANY_XMI);
		EObject company = companyFactory.create(companyClass);
		EObject manager = companyFactory.create(employeeClass);
		manager.eSet(employeeClass.getEStructuralFeature("company"), company);
		EObject employee = companyFactory.create(employeeClass);
		employee.eSet(employeeClass.getEStructuralFeature("company"), company);
		employee.eSet(employeeClass.getEStructuralFeature("manager"), manager);
		OCL ocl = OCL.newInstance();
		Helper helper = ocl.createOCLHelper();
		helper.setContext(employeeClass);
		OCLExpression expr = helper.createQuery("self.directReports");
		assertTrue(((Collection<?>) ocl.evaluate(manager, expr)).contains(employee));
		EStructuralFeature directReportsRef = employeeClass.getEStructuralFeature("directReports");
		// Now cache a NullLiteralExp as the derivation expression for directReports:
		NullLiteralExp nullLiteralExp = EcoreFactory.eINSTANCE.createNullLiteralExp();
		EAnnotation directReportsAnn = directReportsRef.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
		assertTrue(directReportsAnn.getDetails().containsKey(SettingBehavior.DERIVATION_CONSTRAINT_KEY));
		String derivationExpression =  directReportsAnn.getDetails().get(SettingBehavior.DERIVATION_CONSTRAINT_KEY);
		try {
			directReportsAnn.getDetails().remove(SettingBehavior.DERIVATION_CONSTRAINT_KEY);
			// ensure that the plugin cache doesn't have an expression cached:
			SettingBehavior.INSTANCE.cacheOCLExpression(directReportsRef, nullLiteralExp);
			assertNull(ocl.evaluate(manager, expr));
		} finally {
			directReportsAnn.getDetails().put(SettingBehavior.DERIVATION_CONSTRAINT_KEY, derivationExpression);
			SettingBehavior.INSTANCE.cacheOCLExpression(directReportsRef, null);
		}
	}
	
	public void test_hiddenOppositeInOperationDefault() throws InvocationTargetException {
		URI uri = getTestModelURI("/model/HiddenOpposites.ecore");
		Resource res = resourceSet.getResource(uri, true);
		res.eAdapters().add(new ECrossReferenceAdapter());
		EPackage hiddenOppositesPackage = (EPackage) res.getContents().get(0);
		resourceSet.getPackageRegistry().put(hiddenOppositesPackage.getNsURI(), hiddenOppositesPackage);
		EFactory hiddenOppositesFactory = hiddenOppositesPackage.getEFactoryInstance();
		EClass sup2 = (EClass) hiddenOppositesPackage.getEClassifier("Sup2");
		EClass unrelated = (EClass) hiddenOppositesPackage.getEClassifier("Unrelated");
		EObject unrelatedObj = hiddenOppositesFactory.create(unrelated);
		EObject sup2Obj = hiddenOppositesFactory.create(sup2);
		res.getContents().add(unrelatedObj);
		res.getContents().add(sup2Obj);
		unrelatedObj.eSet(unrelated.getEStructuralFeature("forward"), sup2Obj);
		EOperation getUnrelated = null;
		for (EOperation eo : sup2.getEOperations()) {
			if (eo.getName().equals("getUnrelated")) {
				getUnrelated = eo;
				break;
			}
		}
		assertNotNull(getUnrelated);
		Object o = sup2Obj.eInvoke(getUnrelated, null);
		assertEquals(unrelatedObj, o);
	}	
	public void test_hiddenOppositeInOperationDefined() throws InvocationTargetException {
		URI uri = getTestModelURI("/model/HiddenOpposites.ecore");
		Resource res = resourceSet.getResource(uri, true);
		res.eAdapters().add(new ECrossReferenceAdapter());
		EPackage hiddenOppositesPackage = (EPackage) res.getContents().get(0);
		EAnnotation anno = hiddenOppositesPackage.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
		anno.getDetails().put("oppositeEndFinderClass", "org.eclipse.ocl.ecore.opposites.DefaultOppositeEndFinder");
		resourceSet.getPackageRegistry().put(hiddenOppositesPackage.getNsURI(), hiddenOppositesPackage);
		EFactory hiddenOppositesFactory = hiddenOppositesPackage.getEFactoryInstance();
		EClass sup2 = (EClass) hiddenOppositesPackage.getEClassifier("Sup2");
		EClass unrelated = (EClass) hiddenOppositesPackage.getEClassifier("Unrelated");
		EObject unrelatedObj = hiddenOppositesFactory.create(unrelated);
		EObject sup2Obj = hiddenOppositesFactory.create(sup2);
		res.getContents().add(unrelatedObj);
		res.getContents().add(sup2Obj);
		unrelatedObj.eSet(unrelated.getEStructuralFeature("forward"), sup2Obj);
		EOperation getUnrelated = null;
		for (EOperation eo : sup2.getEOperations()) {
			if (eo.getName().equals("getUnrelated")) {
				getUnrelated = eo;
				break;
			}
		}
		assertNotNull(getUnrelated);
		Object o = sup2Obj.eInvoke(getUnrelated, null);
		assertEquals(unrelatedObj, o);
	}
	
	public static class LocalOppositeEndFinder extends DefaultOppositeEndFinder {
		public static boolean localOppositeEndFinderUsed = false;
		public LocalOppositeEndFinder(Registry registry) {
			super(registry);
			localOppositeEndFinderUsed = true;
		}
	}

	public void test_hiddenOppositeInOperationDefinedToLocalClass() throws InvocationTargetException {
		URI uri = getTestModelURI("/model/HiddenOpposites.ecore");
		Resource res = resourceSet.getResource(uri, true);
		res.eAdapters().add(new ECrossReferenceAdapter());
		EPackage hiddenOppositesPackage = (EPackage) res.getContents().get(0);
		EAnnotation anno = hiddenOppositesPackage.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
		anno.getDetails().put("oppositeEndFinderClass", getClass().getName()+"$LocalOppositeEndFinder");
		resourceSet.getPackageRegistry().put(hiddenOppositesPackage.getNsURI(), hiddenOppositesPackage);
		EFactory hiddenOppositesFactory = hiddenOppositesPackage.getEFactoryInstance();
		EClass sup2 = (EClass) hiddenOppositesPackage.getEClassifier("Sup2");
		EClass unrelated = (EClass) hiddenOppositesPackage.getEClassifier("Unrelated");
		EObject unrelatedObj = hiddenOppositesFactory.create(unrelated);
		EObject sup2Obj = hiddenOppositesFactory.create(sup2);
		res.getContents().add(unrelatedObj);
		res.getContents().add(sup2Obj);
		unrelatedObj.eSet(unrelated.getEStructuralFeature("forward"), sup2Obj);
		EOperation getUnrelated = null;
		for (EOperation eo : sup2.getEOperations()) {
			if (eo.getName().equals("getUnrelated")) {
				getUnrelated = eo;
				break;
			}
		}
		assertNotNull(getUnrelated);
		Object o = sup2Obj.eInvoke(getUnrelated, null);
		assertEquals(unrelatedObj, o);
		assertTrue("The configured local opposite end finder was not used",
			LocalOppositeEndFinder.localOppositeEndFinderUsed);
	}

	public void test_invariantCacheBeingUsed() throws ParserException {
		initPackageRegistrations();
		initModel(COMPANY_XMI);
		EAnnotation annotation = employeeClass.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
		
		DiagnosticChain diagnostics = new BasicDiagnostic();
		// first ensure that contents are padded up to where we need it:
		assertTrue("Expecting \"Amy\" to be a valid name",
			CompanyValidator.INSTANCE.validateEmployee_mustHaveName((Employee) employee("Amy"), diagnostics, context));
		final String constraintName = "mustHaveName";
		String mustHaveNameConstraint = annotation.getDetails().get(constraintName);
		Helper helper = OCL.newInstance().createOCLHelper();
		helper.setContext(employeeClass);
		OCLExpression query = helper.createQuery("false"); // a constraint always returning false
		try {
			annotation.getDetails().remove(constraintName);
			ValidationBehavior.INSTANCE.cacheOCLExpression(employeeClass,
				constraintName, query);
			assertFalse(
				"Expected the always-false cached constraint to be used",
				CompanyValidator.INSTANCE.validateEmployee_mustHaveName(
					(Employee) employee("Amy"), diagnostics, context));
		} finally {
			// restore annotation detail
			annotation.getDetails().put(constraintName, mustHaveNameConstraint);
		}
	}
	
	public void test_invariantCachingForFirst() {
		initPackageRegistrations();
		initModel(COMPANY_XMI);
		DiagnosticChain diagnostics = new BasicDiagnostic();
		ValidationBehavior.INSTANCE.cacheOCLExpression(employeeClass, "mustHaveName", null);
		CompanyValidator.INSTANCE.validateEmployee_mustHaveName((Employee) employee("Amy"), diagnostics, context);
		OCLExpression cached = ValidationBehavior.INSTANCE.getCachedOCLExpression(employeeClass, "mustHaveName");
		assertTrue("Expected to find compiled expression in cache",
			cached != null && !ValidationBehavior.isNoOCLDefinition(cached));
	}
	
	public void test_invariantCachingForSecond() {
		initPackageRegistrations();
		initModel(COMPANY_XMI);
		DiagnosticChain diagnostics = new BasicDiagnostic();
		ValidationBehavior.INSTANCE.cacheOCLExpression(employeeClass, "mustHaveNonEmptyName", null);
		CompanyValidator.INSTANCE.validateEmployee_mustHaveNonEmptyName((Employee) employee("Amy"), diagnostics, context);
		OCLExpression cached = ValidationBehavior.INSTANCE.getCachedOCLExpression(employeeClass, "mustHaveNonEmptyName");
		assertTrue("Expected to find compiled expression in cache",
			cached != null && !ValidationBehavior.isNoOCLDefinition(cached));
	}
	
	public void test_invariantValidation() {
		doTest_invariantValidation(COMPANY_XMI, true);
		assertEquals(!eclipseIsRunning, usedLocalRegistry);
	}

	public void test_invariantValidation_registered() {
		initPackageRegistrations();
		doTest_invariantValidation(COMPANY_XMI, true);
		assertFalse(usedLocalRegistry);
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
		assertEquals(!eclipseIsRunning, usedLocalRegistry);
	}

	public void test_operationInvocation_registered() {
		initPackageRegistrations();
		doTest_operationInvocation(COMPANY_XMI);
		assertFalse(usedLocalRegistry);
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
	 * Ensures that {@link InvocationBehavior#getOperationBody(OCL, EOperation)}
	 * consistently returns <code>null</code> for stdlib operations that don't
	 * have a body defined at all instead of returning an <code>invalid</code> literal.
	 * @throws ParserException 
	 */
	public void test_operationDefinedInStdlibBodyRemainsNull() throws ParserException {
		helper.setContext(EcorePackage.eINSTANCE.getEClassifier());
		OCLExpression expr = (OCLExpression) helper.createQuery("'abc'.oclAsType(String)");
		assertTrue(expr instanceof OperationCallExp);
		OperationCallExp oce = (OperationCallExp) expr;
		EOperation o = oce.getReferredOperation();
		OCLExpression body = InvocationBehavior.INSTANCE.getOperationBody((OCL) ocl, o);
		assertNull(body);
		// and again, now reading from cache
		OCLExpression bodyStillNull = InvocationBehavior.INSTANCE.getOperationBody((OCL) ocl, o);;
		assertTrue(bodyStillNull == null || InvocationBehavior.isNoOCLDefinition(bodyStillNull));
	}
	
	/**
	 * Caches an operation AST in the annotation used by the {@link InvocationBehavior} implementation
	 * and ensures that it's used by the delegate as well as the {@link EvaluationVisitorImpl}.
	 * Implicitly, the test ensures that no modification is applied to the original textual annotation,
	 * so that the annotation's contents are <em>not</em> used to cache the compiled AST because that
	 * may make some clients expecting the metamodel resources to remain unchanged angry.
	 * 
	 * @throws ParserException 
	 * @throws InvocationTargetException 
	 */
	public void test_operationUsedFromCache() throws ParserException, InvocationTargetException {
		initModel(COMPANY_XMI);
		EObject manager = companyFactory.create(employeeClass);
		EObject employee = companyFactory.create(employeeClass);
		employee.eSet(employeeClass.getEStructuralFeature("manager"), manager);
		helper.setContext(employeeClass);
		OCLExpression expr = (OCLExpression) helper.createQuery("self.reportsTo(self.manager)");
		assertTrue((Boolean) ocl.evaluate(employee, expr)); // by the default impl, employee reports to manager
		EOperation reportsToOp = employeeClass.getEOperation(CompanyPackage.EMPLOYEE___REPORTS_TO__EMPLOYEE);
		// Now cache a BooleanLiteralExp with the "false" literal as the implementation for reportsTo:
		BooleanLiteralExp falseLiteralExp = EcoreFactory.eINSTANCE.createBooleanLiteralExp();
		falseLiteralExp.setBooleanSymbol(false);
		EAnnotation reportsToAnn = reportsToOp.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
		assertTrue(reportsToAnn.getDetails().containsKey(InvocationBehavior.BODY_CONSTRAINT_KEY));
		String body = reportsToAnn.getDetails().get(InvocationBehavior.BODY_CONSTRAINT_KEY);
		try {
			reportsToAnn.getDetails().remove(InvocationBehavior.BODY_CONSTRAINT_KEY);
			// ensure that the plugin cache doesn't have an expression cached:
			InvocationBehavior.INSTANCE.cacheOCLExpression(reportsToOp, falseLiteralExp);
			assertFalse((Boolean) ocl.evaluate(employee, expr));
		} finally {
			reportsToAnn.getDetails().put(InvocationBehavior.BODY_CONSTRAINT_KEY, body);
			InvocationBehavior.INSTANCE.cacheOCLExpression(reportsToOp, null);
		}
	}
	
	public void test_performanceOfCacheRetrieval() throws ParserException {
		initModel(COMPANY_XMI);
		EObject manager = companyFactory.create(employeeClass);
		EObject employee = companyFactory.create(employeeClass);
		employee.eSet(employeeClass.getEStructuralFeature("manager"), manager);
		OCL ocl = OCL.newInstance();
		Helper helper = ocl.createOCLHelper();
		helper.setContext(employeeClass);
		String expression = "self.reportsTo(self.manager)";
		OCLExpression expr = helper.createQuery(expression);
		final int TIMES = 1;
		final int REPEAT = 1;
		for (int r = 0; r < REPEAT; r++) {
			long start = System.currentTimeMillis();
			for (int i = 0; i < TIMES; i++) {
				ocl.evaluate(employee, expr);
			}
			long end = System.currentTimeMillis();
			System.out.println("Executing " + expression + " " + TIMES
				+ " times took " + (end - start) + "ms");
		}
	}

	public void test_queryExecution() {
		doTest_queryExecution(COMPANY_XMI);
		assertEquals(!eclipseIsRunning, usedLocalRegistry);
	}

	public void test_queryExecution_registered() {
		initPackageRegistrations();
		doTest_queryExecution(COMPANY_XMI);
		assertFalse(usedLocalRegistry);
	}

	public void test_queryExecutionWithExceptions() throws InvocationTargetException {
		doTest_queryExecutionWithExceptions(COMPANY_XMI);
		assertEquals(!eclipseIsRunning, usedLocalRegistry);
	}

	public void test_queryExecutionWithExceptions_registered() throws InvocationTargetException {
		initPackageRegistrations();
		doTest_queryExecutionWithExceptions(COMPANY_XMI);
		assertFalse(usedLocalRegistry);
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

	Object execute(QueryDelegate delegate, Object target,
			Map<String, Object> bindings) {
		try {
			return delegate.execute(target, bindings);
		} catch (InvocationTargetException ite) {
			fail("Failed to execute query: " + ite.getCause().getLocalizedMessage());
			return null;
		}
	}

	public void executeWithException(QueryDelegate delegate, Object target,
			Map<String, Object> bindings, String messageTemplate,
			Object... messageBindings) {
		String expectedMessage = NLS.bind(messageTemplate, messageBindings);
		try {
			@SuppressWarnings("unused")
			Object object = delegate.execute(target, bindings);
			fail("Expected to catch InvocationTargetException: " + expectedMessage);
		} catch (InvocationTargetException e) {
			Throwable cause = e.getCause();
			assertEquals(cause + ": ", expectedMessage, cause.getLocalizedMessage());
		}
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
