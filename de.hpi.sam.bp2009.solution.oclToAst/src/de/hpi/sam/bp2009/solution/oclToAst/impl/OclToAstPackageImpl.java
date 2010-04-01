/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.oclToAst.impl;

import de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser;
import de.hpi.sam.bp2009.solution.oclToAst.OclToAstFactory;
import de.hpi.sam.bp2009.solution.oclToAst.OclToAstPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OclToAstPackageImpl extends EPackageImpl implements OclToAstPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAnnotationOCLParserEClass = null;

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
	 * @see de.hpi.sam.bp2009.solution.oclToAst.OclToAstPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OclToAstPackageImpl() {
		super(eNS_URI, OclToAstFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link OclToAstPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OclToAstPackage init() {
		if (isInited) return (OclToAstPackage)EPackage.Registry.INSTANCE.getEPackage(OclToAstPackage.eNS_URI);

		// Obtain or create and register package
		OclToAstPackageImpl theOclToAstPackage = (OclToAstPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OclToAstPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OclToAstPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theOclToAstPackage.createPackageContents();

		// Initialize created meta-data
		theOclToAstPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOclToAstPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OclToAstPackage.eNS_URI, theOclToAstPackage);
		return theOclToAstPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAnnotationOCLParser() {
		return eAnnotationOCLParserEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAnnotationOCLParser_SOURCE() {
		return (EAttribute)eAnnotationOCLParserEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAnnotationOCLParser_KIND() {
		return (EAttribute)eAnnotationOCLParserEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAnnotationOCLParser_EXPRESSION() {
		return (EAttribute)eAnnotationOCLParserEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAnnotationOCLParser_NAME() {
		return (EAttribute)eAnnotationOCLParserEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclToAstFactory getOclToAstFactory() {
		return (OclToAstFactory)getEFactoryInstance();
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
		eAnnotationOCLParserEClass = createEClass(EANNOTATION_OCL_PARSER);
		createEAttribute(eAnnotationOCLParserEClass, EANNOTATION_OCL_PARSER__SOURCE);
		createEAttribute(eAnnotationOCLParserEClass, EANNOTATION_OCL_PARSER__KIND);
		createEAttribute(eAnnotationOCLParserEClass, EANNOTATION_OCL_PARSER__EXPRESSION);
		createEAttribute(eAnnotationOCLParserEClass, EANNOTATION_OCL_PARSER__NAME);
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
		initEClass(eAnnotationOCLParserEClass, EAnnotationOCLParser.class, "EAnnotationOCLParser", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEAnnotationOCLParser_SOURCE(), ecorePackage.getEString(), "SOURCE", "http://de.hpi.sam.bp2009.OCL", 0, 1, EAnnotationOCLParser.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAnnotationOCLParser_KIND(), ecorePackage.getEString(), "KIND", "OCL.Kind", 0, 1, EAnnotationOCLParser.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAnnotationOCLParser_EXPRESSION(), ecorePackage.getEString(), "EXPRESSION", "OCL.Expression", 0, 1, EAnnotationOCLParser.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAnnotationOCLParser_NAME(), ecorePackage.getEString(), "NAME", "OCL.Name", 0, 1, EAnnotationOCLParser.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(eAnnotationOCLParserEClass, null, "convertOclAnnotation", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEModelElement(), "modelElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //OclToAstPackageImpl
