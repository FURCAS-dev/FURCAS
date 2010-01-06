/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.oclEvaluator.impl;

import de.hpi.sam.bp2009.solution.oclEvaluator.OCLEvaluator;
import de.hpi.sam.bp2009.solution.oclEvaluator.OclEvaluatorFactory;
import de.hpi.sam.bp2009.solution.oclEvaluator.OclEvaluatorPackage;
import de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.query.ocl.conditions.AbstractOCLCondition;

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
	private EDataType oclConditionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType eObjectEDataType = null;

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
	public EAttribute getOclQuery_Context() {
		return (EAttribute)oclQueryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOclQuery_Condition() {
		return (EAttribute)oclQueryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getOclCondition() {
		return oclConditionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEObject() {
		return eObjectEDataType;
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
		createEAttribute(oclQueryEClass, OCL_QUERY__CONTEXT);
		createEAttribute(oclQueryEClass, OCL_QUERY__CONDITION);

		// Create data types
		oclConditionEDataType = createEDataType(OCL_CONDITION);
		eObjectEDataType = createEDataType(EOBJECT);
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

		// Initialize classes and features; add operations and parameters
		initEClass(oclEvaluatorEClass, OCLEvaluator.class, "OCLEvaluator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(oclEvaluatorEClass, ecorePackage.getEJavaObject(), "evaluate", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getOclCondition(), "queryobject", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEObject(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(oclEvaluatorEClass, null, "evaluate", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEEList());
		EGenericType g2 = createEGenericType(this.getOclQuery());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "queries", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEEList());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		initEClass(oclQueryEClass, OclQuery.class, "OclQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOclQuery_Context(), this.getEObject(), "context", null, 0, 1, OclQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOclQuery_Condition(), this.getOclCondition(), "condition", null, 0, 1, OclQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(oclConditionEDataType, AbstractOCLCondition.class, "OclCondition", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(eObjectEDataType, EObject.class, "EObject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //OclEvaluatorPackageImpl
