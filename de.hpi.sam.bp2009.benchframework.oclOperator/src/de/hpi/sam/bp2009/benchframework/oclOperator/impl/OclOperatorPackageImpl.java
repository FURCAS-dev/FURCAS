/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.oclOperator.impl;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;

import de.hpi.sam.bp2009.benchframework.oclOperator.OclOperator;
import de.hpi.sam.bp2009.benchframework.oclOperator.OclOperatorFactory;
import de.hpi.sam.bp2009.benchframework.oclOperator.OclOperatorPackage;
import de.hpi.sam.bp2009.benchframework.oclOperator.OclOptionObject;
import de.hpi.sam.bp2009.benchframework.oclOperator.OclUtil;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.query.statements.IQueryResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OclOperatorPackageImpl extends EPackageImpl implements OclOperatorPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oclOperatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oclOptionObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oclUtilEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iQueryResultEDataType = null;

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
	 * @see de.hpi.sam.bp2009.benchframework.oclOperator.OclOperatorPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OclOperatorPackageImpl() {
		super(eNS_URI, OclOperatorFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link OclOperatorPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OclOperatorPackage init() {
		if (isInited) return (OclOperatorPackage)EPackage.Registry.INSTANCE.getEPackage(OclOperatorPackage.eNS_URI);

		// Obtain or create and register package
		OclOperatorPackageImpl theOclOperatorPackage = (OclOperatorPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OclOperatorPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OclOperatorPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		BenchframeworkPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theOclOperatorPackage.createPackageContents();

		// Initialize created meta-data
		theOclOperatorPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOclOperatorPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OclOperatorPackage.eNS_URI, theOclOperatorPackage);
		return theOclOperatorPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOclOperator() {
		return oclOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOclOptionObject() {
		return oclOptionObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOclUtil() {
		return oclUtilEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIQueryResult() {
		return iQueryResultEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclOperatorFactory getOclOperatorFactory() {
		return (OclOperatorFactory)getEFactoryInstance();
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
		oclOperatorEClass = createEClass(OCL_OPERATOR);

		oclOptionObjectEClass = createEClass(OCL_OPTION_OBJECT);

		oclUtilEClass = createEClass(OCL_UTIL);

		// Create data types
		iQueryResultEDataType = createEDataType(IQUERY_RESULT);
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
		BenchframeworkPackage theBenchframeworkPackage = (BenchframeworkPackage)EPackage.Registry.INSTANCE.getEPackage(BenchframeworkPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		oclOperatorEClass.getESuperTypes().add(theBenchframeworkPackage.getOperator());
		oclOptionObjectEClass.getESuperTypes().add(theBenchframeworkPackage.getOptionObject());

		// Initialize classes and features; add operations and parameters
		initEClass(oclOperatorEClass, OclOperator.class, "OclOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(oclOperatorEClass, null, "execute", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEResource(), "resource", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theBenchframeworkPackage.getOptionObject(), "options", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(oclOperatorEClass, null, "executeQueries", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEResource(), "resource", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getOclOptionObject(), "option", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(oclOptionObjectEClass, OclOptionObject.class, "OclOptionObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(oclUtilEClass, OclUtil.class, "OclUtil", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(oclUtilEClass, this.getIQueryResult(), "executeQueryOn", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "completeConstraint", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEResource(), "resource", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Initialize data types
		initEDataType(iQueryResultEDataType, IQueryResult.class, "IQueryResult", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //OclOperatorPackageImpl
