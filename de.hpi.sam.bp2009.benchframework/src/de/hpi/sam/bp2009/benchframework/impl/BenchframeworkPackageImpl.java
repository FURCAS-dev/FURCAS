/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.impl;

import de.hpi.sam.bp2009.benchframework.BenchframeworkFactory;
import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;
import de.hpi.sam.bp2009.benchframework.EndOperator;
import de.hpi.sam.bp2009.benchframework.Engine;
import de.hpi.sam.bp2009.benchframework.Operator;
import de.hpi.sam.bp2009.benchframework.OptionObject;
import de.hpi.sam.bp2009.benchframework.RandomNumberOptionObject;
import de.hpi.sam.bp2009.benchframework.ResultObject;
import de.hpi.sam.bp2009.benchframework.ResultProcessor;
import de.hpi.sam.bp2009.benchframework.StartAndEndOperatorOptionObject;
import de.hpi.sam.bp2009.benchframework.StartOperator;
import de.hpi.sam.bp2009.benchframework.Status;
import de.hpi.sam.bp2009.benchframework.TestRun;
import de.hpi.sam.bp2009.benchframework.UserInterface;

import java.io.OutputStream;

import java.util.Random;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.jface.wizard.WizardPage;

import org.eclipse.swt.widgets.Composite;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BenchframeworkPackageImpl extends EPackageImpl implements BenchframeworkPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass engineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resultProcessorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass optionObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resultObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testRunEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass randomNumberOptionObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass startOperatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endOperatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass startAndEndOperatorOptionObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum statusEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType outputStreamEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType wizardPageEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uiComponentEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType exceptionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType randomNumberGeneratorEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType cloneNotSupportedExceptionEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BenchframeworkPackageImpl() {
		super(eNS_URI, BenchframeworkFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link BenchframeworkPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BenchframeworkPackage init() {
		if (isInited) return (BenchframeworkPackage)EPackage.Registry.INSTANCE.getEPackage(BenchframeworkPackage.eNS_URI);

		// Obtain or create and register package
		BenchframeworkPackageImpl theBenchframeworkPackage = (BenchframeworkPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof BenchframeworkPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new BenchframeworkPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theBenchframeworkPackage.createPackageContents();

		// Initialize created meta-data
		theBenchframeworkPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBenchframeworkPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BenchframeworkPackage.eNS_URI, theBenchframeworkPackage);
		return theBenchframeworkPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEngine() {
		return engineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEngine_TestRuns() {
		return (EReference)engineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEngine_ExeptionsDuringLastRun() {
		return (EAttribute)engineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperator() {
		return operatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperator_Option() {
		return (EReference)operatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperator_Result() {
		return (EReference)operatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperator_TestRun() {
		return (EReference)operatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperator_Name() {
		return (EAttribute)operatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperator_Description() {
		return (EAttribute)operatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResultProcessor() {
		return resultProcessorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResultProcessor_ResultPage() {
		return (EAttribute)resultProcessorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResultProcessor_Testrun() {
		return (EReference)resultProcessorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResultProcessor_Name() {
		return (EAttribute)resultProcessorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOptionObject() {
		return optionObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOptionObject_WizardPage() {
		return (EAttribute)optionObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResultObject() {
		return resultObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResultObject_Status() {
		return (EAttribute)resultObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResultObject_Message() {
		return (EAttribute)resultObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUserInterface() {
		return userInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserInterface_Engine() {
		return (EReference)userInterfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserInterface_AvailableOperators() {
		return (EReference)userInterfaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserInterface_ResultProcessor() {
		return (EReference)userInterfaceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestRun() {
		return testRunEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestRun_Model() {
		return (EAttribute)testRunEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestRun_Operators() {
		return (EReference)testRunEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRandomNumberOptionObject() {
		return randomNumberOptionObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRandomNumberOptionObject_NumberListIndex() {
		return (EAttribute)randomNumberOptionObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRandomNumberOptionObject_NumberList() {
		return (EAttribute)randomNumberOptionObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRandomNumberOptionObject_NumberGenerator() {
		return (EAttribute)randomNumberOptionObjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStartOperator() {
		return startOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEndOperator() {
		return endOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStartAndEndOperatorOptionObject() {
		return startAndEndOperatorOptionObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStartAndEndOperatorOptionObject_OtherEnd() {
		return (EReference)startAndEndOperatorOptionObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getStatus() {
		return statusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getOutputStream() {
		return outputStreamEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getWizardPage() {
		return wizardPageEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getUIComponent() {
		return uiComponentEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getException() {
		return exceptionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getRandomNumberGenerator() {
		return randomNumberGeneratorEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getCloneNotSupportedException() {
		return cloneNotSupportedExceptionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BenchframeworkFactory getBenchframeworkFactory() {
		return (BenchframeworkFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		engineEClass = createEClass(ENGINE);
		createEReference(engineEClass, ENGINE__TEST_RUNS);
		createEAttribute(engineEClass, ENGINE__EXEPTIONS_DURING_LAST_RUN);

		operatorEClass = createEClass(OPERATOR);
		createEReference(operatorEClass, OPERATOR__OPTION);
		createEReference(operatorEClass, OPERATOR__RESULT);
		createEReference(operatorEClass, OPERATOR__TEST_RUN);
		createEAttribute(operatorEClass, OPERATOR__NAME);
		createEAttribute(operatorEClass, OPERATOR__DESCRIPTION);

		resultProcessorEClass = createEClass(RESULT_PROCESSOR);
		createEAttribute(resultProcessorEClass, RESULT_PROCESSOR__RESULT_PAGE);
		createEReference(resultProcessorEClass, RESULT_PROCESSOR__TESTRUN);
		createEAttribute(resultProcessorEClass, RESULT_PROCESSOR__NAME);

		optionObjectEClass = createEClass(OPTION_OBJECT);
		createEAttribute(optionObjectEClass, OPTION_OBJECT__WIZARD_PAGE);

		resultObjectEClass = createEClass(RESULT_OBJECT);
		createEAttribute(resultObjectEClass, RESULT_OBJECT__STATUS);
		createEAttribute(resultObjectEClass, RESULT_OBJECT__MESSAGE);

		userInterfaceEClass = createEClass(USER_INTERFACE);
		createEReference(userInterfaceEClass, USER_INTERFACE__ENGINE);
		createEReference(userInterfaceEClass, USER_INTERFACE__AVAILABLE_OPERATORS);
		createEReference(userInterfaceEClass, USER_INTERFACE__RESULT_PROCESSOR);

		testRunEClass = createEClass(TEST_RUN);
		createEAttribute(testRunEClass, TEST_RUN__MODEL);
		createEReference(testRunEClass, TEST_RUN__OPERATORS);

		randomNumberOptionObjectEClass = createEClass(RANDOM_NUMBER_OPTION_OBJECT);
		createEAttribute(randomNumberOptionObjectEClass, RANDOM_NUMBER_OPTION_OBJECT__NUMBER_LIST_INDEX);
		createEAttribute(randomNumberOptionObjectEClass, RANDOM_NUMBER_OPTION_OBJECT__NUMBER_LIST);
		createEAttribute(randomNumberOptionObjectEClass, RANDOM_NUMBER_OPTION_OBJECT__NUMBER_GENERATOR);

		startOperatorEClass = createEClass(START_OPERATOR);

		endOperatorEClass = createEClass(END_OPERATOR);

		startAndEndOperatorOptionObjectEClass = createEClass(START_AND_END_OPERATOR_OPTION_OBJECT);
		createEReference(startAndEndOperatorOptionObjectEClass, START_AND_END_OPERATOR_OPTION_OBJECT__OTHER_END);

		// Create enums
		statusEEnum = createEEnum(STATUS);

		// Create data types
		outputStreamEDataType = createEDataType(OUTPUT_STREAM);
		wizardPageEDataType = createEDataType(WIZARD_PAGE);
		uiComponentEDataType = createEDataType(UI_COMPONENT);
		exceptionEDataType = createEDataType(EXCEPTION);
		randomNumberGeneratorEDataType = createEDataType(RANDOM_NUMBER_GENERATOR);
		cloneNotSupportedExceptionEDataType = createEDataType(CLONE_NOT_SUPPORTED_EXCEPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		randomNumberOptionObjectEClass.getESuperTypes().add(this.getOptionObject());
		startOperatorEClass.getESuperTypes().add(this.getOperator());
		endOperatorEClass.getESuperTypes().add(this.getOperator());
		startAndEndOperatorOptionObjectEClass.getESuperTypes().add(this.getOptionObject());

		// Initialize classes and features; add operations and parameters
		initEClass(engineEClass, Engine.class, "Engine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEngine_TestRuns(), this.getTestRun(), null, "testRuns", null, 0, -1, Engine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEEList());
		EGenericType g2 = createEGenericType(this.getException());
		g1.getETypeArguments().add(g2);
		initEAttribute(getEngine_ExeptionsDuringLastRun(), g1, "exeptionsDuringLastRun", null, 0, 1, Engine.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(engineEClass, null, "benchmark", 0, 1, IS_UNIQUE, IS_ORDERED);

		EOperation op = addEOperation(engineEClass, null, "getRegisteredOperators", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEEList());
		g2 = createEGenericType(this.getOperator());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = addEOperation(engineEClass, null, "getRegisteredResultProcessors", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEEList());
		g2 = createEGenericType(this.getResultProcessor());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		initEClass(operatorEClass, Operator.class, "Operator", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperator_Option(), this.getOptionObject(), null, "option", null, 0, 1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperator_Result(), this.getResultObject(), null, "result", null, 0, 1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperator_TestRun(), this.getTestRun(), this.getTestRun_Operators(), "testRun", null, 0, 1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperator_Name(), ecorePackage.getEString(), "name", "", 0, 1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperator_Description(), ecorePackage.getEString(), "description", null, 0, 1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(operatorEClass, null, "execute", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(resultProcessorEClass, ResultProcessor.class, "ResultProcessor", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResultProcessor_ResultPage(), this.getWizardPage(), "resultPage", null, 0, 1, ResultProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResultProcessor_Testrun(), this.getTestRun(), null, "testrun", null, 0, 1, ResultProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResultProcessor_Name(), ecorePackage.getEString(), "name", null, 0, 1, ResultProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(optionObjectEClass, OptionObject.class, "OptionObject", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOptionObject_WizardPage(), this.getWizardPage(), "wizardPage", null, 0, 1, OptionObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(optionObjectEClass, null, "getOptionsAsMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = addEOperation(optionObjectEClass, null, "setOptionsAsMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "map", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(optionObjectEClass, this.getOptionObject(), "clone", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getCloneNotSupportedException());

		initEClass(resultObjectEClass, ResultObject.class, "ResultObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResultObject_Status(), this.getStatus(), "status", "", 0, 1, ResultObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResultObject_Message(), ecorePackage.getEString(), "message", null, 0, 1, ResultObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(resultObjectEClass, this.getUIComponent(), "getComposite", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getUIComponent(), "parent", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(userInterfaceEClass, UserInterface.class, "UserInterface", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUserInterface_Engine(), this.getEngine(), null, "engine", null, 0, 1, UserInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUserInterface_AvailableOperators(), this.getOperator(), null, "availableOperators", null, 0, -1, UserInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUserInterface_ResultProcessor(), this.getResultProcessor(), null, "resultProcessor", null, 0, 1, UserInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testRunEClass, TestRun.class, "TestRun", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTestRun_Model(), ecorePackage.getEResourceSet(), "model", null, 0, 1, TestRun.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestRun_Operators(), this.getOperator(), this.getOperator_TestRun(), "operators", null, 0, -1, TestRun.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(testRunEClass, null, "getInstanceForClass", 0, 1, IS_UNIQUE, IS_ORDERED);
		ETypeParameter t1 = addETypeParameter(op, "returnType");
		g1 = createEGenericType(ecorePackage.getEJavaClass());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "aClass", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = addEOperation(testRunEClass, ecorePackage.getEBoolean(), "setInstanceForClass", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEJavaClass());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "aClass", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "anObject", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(testRunEClass, null, "getStartOperators", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEEList());
		g2 = createEGenericType(this.getStartOperator());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = addEOperation(testRunEClass, null, "getEndOperators", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEEList());
		g2 = createEGenericType(this.getEndOperator());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		initEClass(randomNumberOptionObjectEClass, RandomNumberOptionObject.class, "RandomNumberOptionObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRandomNumberOptionObject_NumberListIndex(), ecorePackage.getEInt(), "numberListIndex", null, 0, 1, RandomNumberOptionObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEEList());
		g2 = createEGenericType(ecorePackage.getEIntegerObject());
		g1.getETypeArguments().add(g2);
		initEAttribute(getRandomNumberOptionObject_NumberList(), g1, "numberList", null, 0, 1, RandomNumberOptionObject.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRandomNumberOptionObject_NumberGenerator(), this.getRandomNumberGenerator(), "numberGenerator", null, 0, 1, RandomNumberOptionObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(randomNumberOptionObjectEClass, ecorePackage.getEIntegerObject(), "getNextInt", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEIntegerObject(), "upperLimit", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(randomNumberOptionObjectEClass, ecorePackage.getEIntegerObject(), "getNextInt", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(startOperatorEClass, StartOperator.class, "StartOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(endOperatorEClass, EndOperator.class, "EndOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(startAndEndOperatorOptionObjectEClass, StartAndEndOperatorOptionObject.class, "StartAndEndOperatorOptionObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStartAndEndOperatorOptionObject_OtherEnd(), this.getOperator(), null, "otherEnd", null, 0, 1, StartAndEndOperatorOptionObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(statusEEnum, Status.class, "Status");
		addEEnumLiteral(statusEEnum, Status.FAILED);
		addEEnumLiteral(statusEEnum, Status.SUCCESSFUL);
		addEEnumLiteral(statusEEnum, Status.UNKNOWN);

		// Initialize data types
		initEDataType(outputStreamEDataType, OutputStream.class, "OutputStream", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(wizardPageEDataType, WizardPage.class, "WizardPage", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(uiComponentEDataType, Composite.class, "UIComponent", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(exceptionEDataType, Exception.class, "Exception", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(randomNumberGeneratorEDataType, Random.class, "RandomNumberGenerator", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(cloneNotSupportedExceptionEDataType, CloneNotSupportedException.class, "CloneNotSupportedException", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// null
		createNullAnnotations();
	}

	/**
	 * Initializes the annotations for <b>null</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createNullAnnotations() {
		String source = null;													
		addAnnotation
		  ((testRunEClass.getEOperations().get(0)).getEParameters().get(0), 
		   source, 
		   new String[] {
			 "documentation", "This is a test"
		   });				
	}

} //BenchframeworkPackageImpl
