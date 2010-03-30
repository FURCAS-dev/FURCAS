/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.queryEvaluator.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.ecore.OCL.Query;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;
import de.hpi.sam.bp2009.benchframework.queryEvaluator.EmbedQEOperator;
import de.hpi.sam.bp2009.benchframework.queryEvaluator.QueryEvaluator;
import de.hpi.sam.bp2009.benchframework.queryEvaluator.QueryEvaluatorFactory;
import de.hpi.sam.bp2009.benchframework.queryEvaluator.QueryEvaluatorNotifyLiterals;
import de.hpi.sam.bp2009.benchframework.queryEvaluator.QueryEvaluatorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QueryEvaluatorPackageImpl extends EPackageImpl implements QueryEvaluatorPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass embedQEOperatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass queryEvaluatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum queryEvaluatorNotifyLiteralsEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType queryEDataType = null;

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
	 * @see de.hpi.sam.bp2009.benchframework.queryEvaluator.QueryEvaluatorPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QueryEvaluatorPackageImpl() {
		super(eNS_URI, QueryEvaluatorFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link QueryEvaluatorPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QueryEvaluatorPackage init() {
		if (isInited) return (QueryEvaluatorPackage)EPackage.Registry.INSTANCE.getEPackage(QueryEvaluatorPackage.eNS_URI);

		// Obtain or create and register package
		QueryEvaluatorPackageImpl theQueryEvaluatorPackage = (QueryEvaluatorPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof QueryEvaluatorPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new QueryEvaluatorPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		BenchframeworkPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theQueryEvaluatorPackage.createPackageContents();

		// Initialize created meta-data
		theQueryEvaluatorPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theQueryEvaluatorPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(QueryEvaluatorPackage.eNS_URI, theQueryEvaluatorPackage);
		return theQueryEvaluatorPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEmbedQEOperator() {
		return embedQEOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQueryEvaluator() {
		return queryEvaluatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getQueryEvaluatorNotifyLiterals() {
		return queryEvaluatorNotifyLiteralsEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getQuery() {
		return queryEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QueryEvaluatorFactory getQueryEvaluatorFactory() {
		return (QueryEvaluatorFactory)getEFactoryInstance();
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
		embedQEOperatorEClass = createEClass(EMBED_QE_OPERATOR);

		queryEvaluatorEClass = createEClass(QUERY_EVALUATOR);

		// Create enums
		queryEvaluatorNotifyLiteralsEEnum = createEEnum(QUERY_EVALUATOR_NOTIFY_LITERALS);

		// Create data types
		queryEDataType = createEDataType(QUERY);
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
		embedQEOperatorEClass.getESuperTypes().add(theBenchframeworkPackage.getOperator());

		// Initialize classes and features; add operations and parameters
		initEClass(embedQEOperatorEClass, EmbedQEOperator.class, "EmbedQEOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(queryEvaluatorEClass, QueryEvaluator.class, "QueryEvaluator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(queryEvaluatorEClass, ecorePackage.getEBoolean(), "evaluateQuery", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getQuery(), "query", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEEList());
		EGenericType g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "contextInstances", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(queryEvaluatorNotifyLiteralsEEnum, QueryEvaluatorNotifyLiterals.class, "QueryEvaluatorNotifyLiterals");
		addEEnumLiteral(queryEvaluatorNotifyLiteralsEEnum, QueryEvaluatorNotifyLiterals.START_QUERY_EVALUATION);
		addEEnumLiteral(queryEvaluatorNotifyLiteralsEEnum, QueryEvaluatorNotifyLiterals.END_QUERY_EVALUATION);

		// Initialize data types
		initEDataType(queryEDataType, Query.class, "Query", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //QueryEvaluatorPackageImpl
