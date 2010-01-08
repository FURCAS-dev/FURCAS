/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.expressionSupplier.impl;

import de.hpi.sam.bp2009.solution.expressionSupplier.ExpressionSupplier;
import de.hpi.sam.bp2009.solution.expressionSupplier.ExpressionSupplierFactory;
import de.hpi.sam.bp2009.solution.expressionSupplier.ExpressionSupplierPackage;

import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerPackage;

import de.hpi.sam.bp2009.solution.oclEvaluator.OclEvaluatorPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExpressionSupplierPackageImpl extends EPackageImpl implements ExpressionSupplierPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionSupplierEClass = null;

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
	 * @see de.hpi.sam.bp2009.solution.expressionSupplier.ExpressionSupplierPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ExpressionSupplierPackageImpl() {
		super(eNS_URI, ExpressionSupplierFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ExpressionSupplierPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ExpressionSupplierPackage init() {
		if (isInited) return (ExpressionSupplierPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionSupplierPackage.eNS_URI);

		// Obtain or create and register package
		ExpressionSupplierPackageImpl theExpressionSupplierPackage = (ExpressionSupplierPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ExpressionSupplierPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ExpressionSupplierPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ImpactAnalyzerPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theExpressionSupplierPackage.createPackageContents();

		// Initialize created meta-data
		theExpressionSupplierPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theExpressionSupplierPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ExpressionSupplierPackage.eNS_URI, theExpressionSupplierPackage);
		return theExpressionSupplierPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpressionSupplier() {
		return expressionSupplierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpressionSupplier_Analyzer() {
		return (EReference)expressionSupplierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpressionSupplier_Queries() {
		return (EAttribute)expressionSupplierEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionSupplierFactory getExpressionSupplierFactory() {
		return (ExpressionSupplierFactory)getEFactoryInstance();
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
		expressionSupplierEClass = createEClass(EXPRESSION_SUPPLIER);
		createEReference(expressionSupplierEClass, EXPRESSION_SUPPLIER__ANALYZER);
		createEAttribute(expressionSupplierEClass, EXPRESSION_SUPPLIER__QUERIES);
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
		ImpactAnalyzerPackage theImpactAnalyzerPackage = (ImpactAnalyzerPackage)EPackage.Registry.INSTANCE.getEPackage(ImpactAnalyzerPackage.eNS_URI);
		OclEvaluatorPackage theOclEvaluatorPackage = (OclEvaluatorPackage)EPackage.Registry.INSTANCE.getEPackage(OclEvaluatorPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(expressionSupplierEClass, ExpressionSupplier.class, "ExpressionSupplier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpressionSupplier_Analyzer(), theImpactAnalyzerPackage.getImpactAnalyzer(), null, "analyzer", null, 0, 1, ExpressionSupplier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEEList());
		EGenericType g2 = createEGenericType(theOclEvaluatorPackage.getOclQuery());
		g1.getETypeArguments().add(g2);
		initEAttribute(getExpressionSupplier_Queries(), g1, "queries", null, 0, 1, ExpressionSupplier.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ExpressionSupplierPackageImpl
