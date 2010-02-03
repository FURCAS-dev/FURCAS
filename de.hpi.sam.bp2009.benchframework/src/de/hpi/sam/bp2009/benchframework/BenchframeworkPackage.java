/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkFactory
 * @model kind="package"
 * @generated
 */
public interface BenchframeworkPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "benchframework";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://de.hpi.sam.bp2009.benchframework";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "benchframework";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BenchframeworkPackage eINSTANCE = de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.impl.EngineImpl <em>Engine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.impl.EngineImpl
	 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getEngine()
	 * @generated
	 */
	int ENGINE = 0;

	/**
	 * The feature id for the '<em><b>Test Runs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE__TEST_RUNS = 0;

	/**
	 * The feature id for the '<em><b>Exeptions During Last Run</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE__EXEPTIONS_DURING_LAST_RUN = 1;

	/**
	 * The number of structural features of the '<em>Engine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.Operator <em>Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.Operator
	 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getOperator()
	 * @generated
	 */
	int OPERATOR = 1;

	/**
	 * The feature id for the '<em><b>Option</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__OPTION = 0;

	/**
	 * The feature id for the '<em><b>Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__RESULT = 1;

	/**
	 * The feature id for the '<em><b>Test Run</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__TEST_RUN = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__NAME = 3;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__DESCRIPTION = 4;

	/**
	 * The number of structural features of the '<em>Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.ResultProcessor <em>Result Processor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.ResultProcessor
	 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getResultProcessor()
	 * @generated
	 */
	int RESULT_PROCESSOR = 2;

	/**
	 * The feature id for the '<em><b>Result Page</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_PROCESSOR__RESULT_PAGE = 0;

	/**
	 * The feature id for the '<em><b>Testrun</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_PROCESSOR__TESTRUN = 1;

	/**
	 * The number of structural features of the '<em>Result Processor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_PROCESSOR_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.OptionObject <em>Option Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.OptionObject
	 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getOptionObject()
	 * @generated
	 */
	int OPTION_OBJECT = 3;

	/**
	 * The feature id for the '<em><b>Wizard Page</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION_OBJECT__WIZARD_PAGE = 0;

	/**
	 * The number of structural features of the '<em>Option Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION_OBJECT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.impl.ResultObjectImpl <em>Result Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.impl.ResultObjectImpl
	 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getResultObject()
	 * @generated
	 */
	int RESULT_OBJECT = 4;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_OBJECT__STATUS = 0;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_OBJECT__MESSAGE = 1;

	/**
	 * The number of structural features of the '<em>Result Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_OBJECT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.impl.UserInterfaceImpl <em>User Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.impl.UserInterfaceImpl
	 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getUserInterface()
	 * @generated
	 */
	int USER_INTERFACE = 5;

	/**
	 * The feature id for the '<em><b>Engine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERFACE__ENGINE = 0;

	/**
	 * The feature id for the '<em><b>Available Operators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERFACE__AVAILABLE_OPERATORS = 1;

	/**
	 * The feature id for the '<em><b>Result Processor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERFACE__RESULT_PROCESSOR = 2;

	/**
	 * The number of structural features of the '<em>User Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERFACE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.impl.TestRunImpl <em>Test Run</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.impl.TestRunImpl
	 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getTestRun()
	 * @generated
	 */
	int TEST_RUN = 6;

	/**
	 * The feature id for the '<em><b>Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_RUN__MODEL = 0;

	/**
	 * The feature id for the '<em><b>Operators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_RUN__OPERATORS = 1;

	/**
	 * The number of structural features of the '<em>Test Run</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_RUN_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.Status <em>Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.Status
	 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getStatus()
	 * @generated
	 */
	int STATUS = 7;

	/**
	 * The meta object id for the '<em>Output Stream</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.io.OutputStream
	 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getOutputStream()
	 * @generated
	 */
	int OUTPUT_STREAM = 8;

	/**
	 * The meta object id for the '<em>Wizard Page</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.jface.wizard.WizardPage
	 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getWizardPage()
	 * @generated
	 */
	int WIZARD_PAGE = 9;

	/**
	 * The meta object id for the '<em>UI Component</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.swt.widgets.Composite
	 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getUIComponent()
	 * @generated
	 */
	int UI_COMPONENT = 10;


	/**
	 * The meta object id for the '<em>Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Exception
	 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getException()
	 * @generated
	 */
	int EXCEPTION = 11;


	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.Engine <em>Engine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Engine</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.Engine
	 * @generated
	 */
	EClass getEngine();

	/**
	 * Returns the meta object for the reference list '{@link de.hpi.sam.bp2009.benchframework.Engine#getTestRuns <em>Test Runs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Test Runs</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.Engine#getTestRuns()
	 * @see #getEngine()
	 * @generated
	 */
	EReference getEngine_TestRuns();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.benchframework.Engine#getExeptionsDuringLastRun <em>Exeptions During Last Run</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exeptions During Last Run</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.Engine#getExeptionsDuringLastRun()
	 * @see #getEngine()
	 * @generated
	 */
	EAttribute getEngine_ExeptionsDuringLastRun();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.Operator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.Operator
	 * @generated
	 */
	EClass getOperator();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.benchframework.Operator#getOption <em>Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Option</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.Operator#getOption()
	 * @see #getOperator()
	 * @generated
	 */
	EReference getOperator_Option();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.benchframework.Operator#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.Operator#getResult()
	 * @see #getOperator()
	 * @generated
	 */
	EReference getOperator_Result();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.benchframework.Operator#getTestRun <em>Test Run</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Test Run</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.Operator#getTestRun()
	 * @see #getOperator()
	 * @generated
	 */
	EReference getOperator_TestRun();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.benchframework.Operator#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.Operator#getName()
	 * @see #getOperator()
	 * @generated
	 */
	EAttribute getOperator_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.benchframework.Operator#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.Operator#getDescription()
	 * @see #getOperator()
	 * @generated
	 */
	EAttribute getOperator_Description();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.ResultProcessor <em>Result Processor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Result Processor</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.ResultProcessor
	 * @generated
	 */
	EClass getResultProcessor();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.benchframework.ResultProcessor#getResultPage <em>Result Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result Page</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.ResultProcessor#getResultPage()
	 * @see #getResultProcessor()
	 * @generated
	 */
	EAttribute getResultProcessor_ResultPage();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.benchframework.ResultProcessor#getTestrun <em>Testrun</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Testrun</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.ResultProcessor#getTestrun()
	 * @see #getResultProcessor()
	 * @generated
	 */
	EReference getResultProcessor_Testrun();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.OptionObject <em>Option Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Option Object</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.OptionObject
	 * @generated
	 */
	EClass getOptionObject();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.benchframework.OptionObject#getWizardPage <em>Wizard Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wizard Page</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.OptionObject#getWizardPage()
	 * @see #getOptionObject()
	 * @generated
	 */
	EAttribute getOptionObject_WizardPage();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.ResultObject <em>Result Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Result Object</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.ResultObject
	 * @generated
	 */
	EClass getResultObject();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.benchframework.ResultObject#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.ResultObject#getStatus()
	 * @see #getResultObject()
	 * @generated
	 */
	EAttribute getResultObject_Status();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.benchframework.ResultObject#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.ResultObject#getMessage()
	 * @see #getResultObject()
	 * @generated
	 */
	EAttribute getResultObject_Message();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.UserInterface <em>User Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Interface</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.UserInterface
	 * @generated
	 */
	EClass getUserInterface();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.benchframework.UserInterface#getEngine <em>Engine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Engine</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.UserInterface#getEngine()
	 * @see #getUserInterface()
	 * @generated
	 */
	EReference getUserInterface_Engine();

	/**
	 * Returns the meta object for the reference list '{@link de.hpi.sam.bp2009.benchframework.UserInterface#getAvailableOperators <em>Available Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Available Operators</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.UserInterface#getAvailableOperators()
	 * @see #getUserInterface()
	 * @generated
	 */
	EReference getUserInterface_AvailableOperators();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.benchframework.UserInterface#getResultProcessor <em>Result Processor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result Processor</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.UserInterface#getResultProcessor()
	 * @see #getUserInterface()
	 * @generated
	 */
	EReference getUserInterface_ResultProcessor();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.TestRun <em>Test Run</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Run</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.TestRun
	 * @generated
	 */
	EClass getTestRun();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.benchframework.TestRun#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.TestRun#getModel()
	 * @see #getTestRun()
	 * @generated
	 */
	EAttribute getTestRun_Model();

	/**
	 * Returns the meta object for the reference list '{@link de.hpi.sam.bp2009.benchframework.TestRun#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Operators</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.TestRun#getOperators()
	 * @see #getTestRun()
	 * @generated
	 */
	EReference getTestRun_Operators();

	/**
	 * Returns the meta object for enum '{@link de.hpi.sam.bp2009.benchframework.Status <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Status</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.Status
	 * @generated
	 */
	EEnum getStatus();

	/**
	 * Returns the meta object for data type '{@link java.io.OutputStream <em>Output Stream</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Output Stream</em>'.
	 * @see java.io.OutputStream
	 * @model instanceClass="java.io.OutputStream"
	 * @generated
	 */
	EDataType getOutputStream();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.jface.wizard.WizardPage <em>Wizard Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Wizard Page</em>'.
	 * @see org.eclipse.jface.wizard.WizardPage
	 * @model instanceClass="org.eclipse.jface.wizard.WizardPage"
	 * @generated
	 */
	EDataType getWizardPage();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.swt.widgets.Composite <em>UI Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>UI Component</em>'.
	 * @see org.eclipse.swt.widgets.Composite
	 * @model instanceClass="org.eclipse.swt.widgets.Composite"
	 * @generated
	 */
	EDataType getUIComponent();

	/**
	 * Returns the meta object for data type '{@link java.lang.Exception <em>Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Exception</em>'.
	 * @see java.lang.Exception
	 * @model instanceClass="java.lang.Exception" serializeable="false"
	 * @generated
	 */
	EDataType getException();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BenchframeworkFactory getBenchframeworkFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.impl.EngineImpl <em>Engine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.impl.EngineImpl
		 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getEngine()
		 * @generated
		 */
		EClass ENGINE = eINSTANCE.getEngine();

		/**
		 * The meta object literal for the '<em><b>Test Runs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENGINE__TEST_RUNS = eINSTANCE.getEngine_TestRuns();

		/**
		 * The meta object literal for the '<em><b>Exeptions During Last Run</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENGINE__EXEPTIONS_DURING_LAST_RUN = eINSTANCE.getEngine_ExeptionsDuringLastRun();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.Operator <em>Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.Operator
		 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getOperator()
		 * @generated
		 */
		EClass OPERATOR = eINSTANCE.getOperator();

		/**
		 * The meta object literal for the '<em><b>Option</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR__OPTION = eINSTANCE.getOperator_Option();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR__RESULT = eINSTANCE.getOperator_Result();

		/**
		 * The meta object literal for the '<em><b>Test Run</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR__TEST_RUN = eINSTANCE.getOperator_TestRun();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATOR__NAME = eINSTANCE.getOperator_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATOR__DESCRIPTION = eINSTANCE.getOperator_Description();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.ResultProcessor <em>Result Processor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.ResultProcessor
		 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getResultProcessor()
		 * @generated
		 */
		EClass RESULT_PROCESSOR = eINSTANCE.getResultProcessor();

		/**
		 * The meta object literal for the '<em><b>Result Page</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULT_PROCESSOR__RESULT_PAGE = eINSTANCE.getResultProcessor_ResultPage();

		/**
		 * The meta object literal for the '<em><b>Testrun</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESULT_PROCESSOR__TESTRUN = eINSTANCE.getResultProcessor_Testrun();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.OptionObject <em>Option Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.OptionObject
		 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getOptionObject()
		 * @generated
		 */
		EClass OPTION_OBJECT = eINSTANCE.getOptionObject();

		/**
		 * The meta object literal for the '<em><b>Wizard Page</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTION_OBJECT__WIZARD_PAGE = eINSTANCE.getOptionObject_WizardPage();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.impl.ResultObjectImpl <em>Result Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.impl.ResultObjectImpl
		 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getResultObject()
		 * @generated
		 */
		EClass RESULT_OBJECT = eINSTANCE.getResultObject();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULT_OBJECT__STATUS = eINSTANCE.getResultObject_Status();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULT_OBJECT__MESSAGE = eINSTANCE.getResultObject_Message();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.impl.UserInterfaceImpl <em>User Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.impl.UserInterfaceImpl
		 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getUserInterface()
		 * @generated
		 */
		EClass USER_INTERFACE = eINSTANCE.getUserInterface();

		/**
		 * The meta object literal for the '<em><b>Engine</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_INTERFACE__ENGINE = eINSTANCE.getUserInterface_Engine();

		/**
		 * The meta object literal for the '<em><b>Available Operators</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_INTERFACE__AVAILABLE_OPERATORS = eINSTANCE.getUserInterface_AvailableOperators();

		/**
		 * The meta object literal for the '<em><b>Result Processor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_INTERFACE__RESULT_PROCESSOR = eINSTANCE.getUserInterface_ResultProcessor();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.impl.TestRunImpl <em>Test Run</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.impl.TestRunImpl
		 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getTestRun()
		 * @generated
		 */
		EClass TEST_RUN = eINSTANCE.getTestRun();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_RUN__MODEL = eINSTANCE.getTestRun_Model();

		/**
		 * The meta object literal for the '<em><b>Operators</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_RUN__OPERATORS = eINSTANCE.getTestRun_Operators();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.Status <em>Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.Status
		 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getStatus()
		 * @generated
		 */
		EEnum STATUS = eINSTANCE.getStatus();

		/**
		 * The meta object literal for the '<em>Output Stream</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.io.OutputStream
		 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getOutputStream()
		 * @generated
		 */
		EDataType OUTPUT_STREAM = eINSTANCE.getOutputStream();

		/**
		 * The meta object literal for the '<em>Wizard Page</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.jface.wizard.WizardPage
		 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getWizardPage()
		 * @generated
		 */
		EDataType WIZARD_PAGE = eINSTANCE.getWizardPage();

		/**
		 * The meta object literal for the '<em>UI Component</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.swt.widgets.Composite
		 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getUIComponent()
		 * @generated
		 */
		EDataType UI_COMPONENT = eINSTANCE.getUIComponent();

		/**
		 * The meta object literal for the '<em>Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Exception
		 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getException()
		 * @generated
		 */
		EDataType EXCEPTION = eINSTANCE.getException();

	}

} //BenchframeworkPackage
