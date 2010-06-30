/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package oclwithhiddenopposites.impl;

import oclwithhiddenopposites.OclwithhiddenoppositesFactory;
import oclwithhiddenopposites.OclwithhiddenoppositesPackage;
import oclwithhiddenopposites.OppositePropertyCallExp;
import oclwithhiddenopposites.VisitorWithHiddenOpposite;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.ocl.ecore.EcorePackage;

import org.eclipse.ocl.utilities.UtilitiesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OclwithhiddenoppositesPackageImpl extends EPackageImpl implements OclwithhiddenoppositesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oppositePropertyCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass visitorWithHiddenOppositeEClass = null;

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
	 * @see oclwithhiddenopposites.OclwithhiddenoppositesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OclwithhiddenoppositesPackageImpl() {
		super(eNS_URI, OclwithhiddenoppositesFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link OclwithhiddenoppositesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OclwithhiddenoppositesPackage init() {
		if (isInited) return (OclwithhiddenoppositesPackage)EPackage.Registry.INSTANCE.getEPackage(OclwithhiddenoppositesPackage.eNS_URI);

		// Obtain or create and register package
		OclwithhiddenoppositesPackageImpl theOclwithhiddenoppositesPackage = (OclwithhiddenoppositesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OclwithhiddenoppositesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OclwithhiddenoppositesPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theOclwithhiddenoppositesPackage.createPackageContents();

		// Initialize created meta-data
		theOclwithhiddenoppositesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOclwithhiddenoppositesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OclwithhiddenoppositesPackage.eNS_URI, theOclwithhiddenoppositesPackage);
		return theOclwithhiddenoppositesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOppositePropertyCallExp() {
		return oppositePropertyCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOppositePropertyCallExp_ReferredOppositeProperty() {
		return (EReference)oppositePropertyCallExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVisitorWithHiddenOpposite() {
		return visitorWithHiddenOppositeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclwithhiddenoppositesFactory getOclwithhiddenoppositesFactory() {
		return (OclwithhiddenoppositesFactory)getEFactoryInstance();
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
		oppositePropertyCallExpEClass = createEClass(OPPOSITE_PROPERTY_CALL_EXP);
		createEReference(oppositePropertyCallExpEClass, OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY);

		visitorWithHiddenOppositeEClass = createEClass(VISITOR_WITH_HIDDEN_OPPOSITE);
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
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		org.eclipse.emf.ecore.EcorePackage theEcorePackage_1 = (org.eclipse.emf.ecore.EcorePackage)EPackage.Registry.INSTANCE.getEPackage(org.eclipse.emf.ecore.EcorePackage.eNS_URI);
		UtilitiesPackage theUtilitiesPackage = (UtilitiesPackage)EPackage.Registry.INSTANCE.getEPackage(UtilitiesPackage.eNS_URI);

		// Create type parameters
		addETypeParameter(visitorWithHiddenOppositeEClass, "T");

		// Set bounds for type parameters

		// Add supertypes to classes
		oppositePropertyCallExpEClass.getESuperTypes().add(theEcorePackage.getNavigationCallExp());
		EGenericType g1 = createEGenericType(theUtilitiesPackage.getVisitor());
		EGenericType g2 = createEGenericType(theEcorePackage_1.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage_1.getEClassifier());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage_1.getEOperation());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage_1.getEStructuralFeature());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage_1.getEEnumLiteral());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage_1.getEParameter());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage_1.getEObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage.getCallOperationAction());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage.getSendSignalAction());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage.getConstraint());
		g1.getETypeArguments().add(g2);
		visitorWithHiddenOppositeEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes and features; add operations and parameters
		initEClass(oppositePropertyCallExpEClass, OppositePropertyCallExp.class, "OppositePropertyCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOppositePropertyCallExp_ReferredOppositeProperty(), theEcorePackage_1.getEReference(), null, "referredOppositeProperty", null, 0, 1, OppositePropertyCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(visitorWithHiddenOppositeEClass, VisitorWithHiddenOpposite.class, "VisitorWithHiddenOpposite", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(visitorWithHiddenOppositeEClass, theEcorePackage_1.getEJavaObject(), "visitOppositePropertyCallExp", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getOppositePropertyCallExp(), "callExp", 1, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //OclwithhiddenoppositesPackageImpl
