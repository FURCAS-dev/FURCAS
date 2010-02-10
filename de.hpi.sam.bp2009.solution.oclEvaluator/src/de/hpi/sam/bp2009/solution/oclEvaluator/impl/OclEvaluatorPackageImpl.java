/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.oclEvaluator.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.ecore.EcorePackage;

import org.eclipse.ocl.expressions.OCLExpression;
import de.hpi.sam.bp2009.solution.oclEvaluator.Interpreter;
import de.hpi.sam.bp2009.solution.oclEvaluator.OCLEvaluator;
import de.hpi.sam.bp2009.solution.oclEvaluator.OclEvaluatorFactory;
import de.hpi.sam.bp2009.solution.oclEvaluator.OclEvaluatorPackage;
import de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OclEvaluatorPackageImpl extends EPackageImpl implements OclEvaluatorPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oclEvaluatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oclQueryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum interpreterEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType expressionEDataType = null;

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
	 * @see de.hpi.sam.bp2009.solution.oclEvaluator.OclEvaluatorPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OclEvaluatorPackageImpl() {
		super(eNS_URI, OclEvaluatorFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link OclEvaluatorPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OclEvaluatorPackage init() {
		if (isInited) return (OclEvaluatorPackage)EPackage.Registry.INSTANCE.getEPackage(OclEvaluatorPackage.eNS_URI);

		// Obtain or create and register package
		OclEvaluatorPackageImpl theOclEvaluatorPackage = (OclEvaluatorPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OclEvaluatorPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OclEvaluatorPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theOclEvaluatorPackage.createPackageContents();

		// Initialize created meta-data
		theOclEvaluatorPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOclEvaluatorPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OclEvaluatorPackage.eNS_URI, theOclEvaluatorPackage);
		return theOclEvaluatorPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOCLEvaluator() {
		return oclEvaluatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOclQuery() {
		return oclQueryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOclQuery_Context() {
		return (EReference)oclQueryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOclQuery_Expression() {
		return (EAttribute)oclQueryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOclQuery_Result() {
		return (EAttribute)oclQueryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOclQuery_Map() {
		return (EAttribute)oclQueryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getInterpreter() {
		return interpreterEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getexpression() {
		return expressionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclEvaluatorFactory getOclEvaluatorFactory() {
		return (OclEvaluatorFactory)getEFactoryInstance();
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
		oclEvaluatorEClass = createEClass(OCL_EVALUATOR);

		oclQueryEClass = createEClass(OCL_QUERY);
		createEReference(oclQueryEClass, OCL_QUERY__CONTEXT);
		createEAttribute(oclQueryEClass, OCL_QUERY__RESULT);
		createEAttribute(oclQueryEClass, OCL_QUERY__MAP);
		createEAttribute(oclQueryEClass, OCL_QUERY__EXPRESSION);

		// Create enums
		interpreterEEnum = createEEnum(INTERPRETER);

		// Create data types
		expressionEDataType = createEDataType(EXPRESSION);
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

		// Obtain other dependent packages
		org.eclipse.emf.ecore.EcorePackage theEcorePackage_1 = (org.eclipse.emf.ecore.EcorePackage)EPackage.Registry.INSTANCE.getEPackage(org.eclipse.emf.ecore.EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(oclEvaluatorEClass, OCLEvaluator.class, "OCLEvaluator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(oclEvaluatorEClass, ecorePackage.getEJavaObject(), "evaluate", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getOclQuery(), "queryobject", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(oclEvaluatorEClass, null, "evaluate", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEEList());
		EGenericType g2 = createEGenericType(this.getOclQuery());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "queries", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEEList());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = addEOperation(oclEvaluatorEClass, theEcorePackage_1.getEJavaObject(), "passToInterpreter", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getInterpreter(), "interpreter", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getOclQuery(), "queryobject", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(oclQueryEClass, OclQuery.class, "OclQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOclQuery_Context(), ecorePackage.getEObject(), null, "context", null, 0, 1, OclQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOclQuery_Result(), ecorePackage.getEJavaObject(), "result", null, 0, 1, OclQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(theEcorePackage_1.getEClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage_1.getEEList());
		g1.getETypeArguments().add(g2);
		EGenericType g3 = createEGenericType(theEcorePackage_1.getEObject());
		g2.getETypeArguments().add(g3);
		initEAttribute(getOclQuery_Map(), g1, "map", null, 0, 1, OclQuery.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOclQuery_Expression(), this.getexpression(), "expression", null, 0, 1, OclQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(interpreterEEnum, Interpreter.class, "Interpreter");
		addEEnumLiteral(interpreterEEnum, Interpreter.OCL);
		addEEnumLiteral(interpreterEEnum, Interpreter.MQL);

		// Initialize data types
		initEDataType(expressionEDataType, OCLExpression.class, "expression", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //OclEvaluatorPackageImpl
