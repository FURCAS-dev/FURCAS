/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.Attaching.impl;

import com.sap.tc.moin.repository.mmi.Model.ModelPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.omg.OCL.Attaching.AttachingFactory;
import org.omg.OCL.Attaching.AttachingPackage;
import org.omg.OCL.Attaching.OclConstraint;

import org.omg.OCL.Expressions.ExpressionsPackage;

import org.omg.OCL.Expressions.impl.ExpressionsPackageImpl;

import org.omg.OCL.StdLibrary.StdLibraryPackage;

import org.omg.OCL.StdLibrary.impl.StdLibraryPackageImpl;

import org.omg.OCL.Types.TypesPackage;

import org.omg.OCL.Types.impl.TypesPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AttachingPackageImpl extends EPackageImpl implements AttachingPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oclConstraintEClass = null;

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
	 * @see org.omg.OCL.Attaching.AttachingPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AttachingPackageImpl() {
		super(eNS_URI, AttachingFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link AttachingPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AttachingPackage init() {
		if (isInited) return (AttachingPackage)EPackage.Registry.INSTANCE.getEPackage(AttachingPackage.eNS_URI);

		// Obtain or create and register package
		AttachingPackageImpl theAttachingPackage = (AttachingPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AttachingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AttachingPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ModelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		TypesPackageImpl theTypesPackage = (TypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) : TypesPackage.eINSTANCE);
		ExpressionsPackageImpl theExpressionsPackage = (ExpressionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI) instanceof ExpressionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI) : ExpressionsPackage.eINSTANCE);
		StdLibraryPackageImpl theStdLibraryPackage = (StdLibraryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StdLibraryPackage.eNS_URI) instanceof StdLibraryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StdLibraryPackage.eNS_URI) : StdLibraryPackage.eINSTANCE);

		// Create package meta-data objects
		theAttachingPackage.createPackageContents();
		theTypesPackage.createPackageContents();
		theExpressionsPackage.createPackageContents();
		theStdLibraryPackage.createPackageContents();

		// Initialize created meta-data
		theAttachingPackage.initializePackageContents();
		theTypesPackage.initializePackageContents();
		theExpressionsPackage.initializePackageContents();
		theStdLibraryPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAttachingPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AttachingPackage.eNS_URI, theAttachingPackage);
		return theAttachingPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOclConstraint() {
		return oclConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOclConstraint_OclExpression() {
		return (EReference)oclConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOclConstraint_InvariantOf() {
		return (EReference)oclConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOclConstraint_PreconditionFor() {
		return (EReference)oclConstraintEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOclConstraint_PostconditionFor() {
		return (EReference)oclConstraintEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOclConstraint_ViolationMessageExpression() {
		return (EReference)oclConstraintEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOclConstraint_InitializedAttribute() {
		return (EReference)oclConstraintEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOclConstraint_InitializedElement() {
		return (EReference)oclConstraintEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttachingFactory getAttachingFactory() {
		return (AttachingFactory)getEFactoryInstance();
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
		oclConstraintEClass = createEClass(OCL_CONSTRAINT);
		createEReference(oclConstraintEClass, OCL_CONSTRAINT__OCL_EXPRESSION);
		createEReference(oclConstraintEClass, OCL_CONSTRAINT__INVARIANT_OF);
		createEReference(oclConstraintEClass, OCL_CONSTRAINT__PRECONDITION_FOR);
		createEReference(oclConstraintEClass, OCL_CONSTRAINT__POSTCONDITION_FOR);
		createEReference(oclConstraintEClass, OCL_CONSTRAINT__VIOLATION_MESSAGE_EXPRESSION);
		createEReference(oclConstraintEClass, OCL_CONSTRAINT__INITIALIZED_ATTRIBUTE);
		createEReference(oclConstraintEClass, OCL_CONSTRAINT__INITIALIZED_ELEMENT);
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
		ModelPackage theModelPackage = (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);
		ExpressionsPackage theExpressionsPackage = (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		oclConstraintEClass.getESuperTypes().add(theModelPackage.getConstraint());

		// Initialize classes and features; add operations and parameters
		initEClass(oclConstraintEClass, OclConstraint.class, "OclConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOclConstraint_OclExpression(), theExpressionsPackage.getOclExpression(), null, "oclExpression", null, 1, 1, OclConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOclConstraint_InvariantOf(), theModelPackage.getClassifier(), null, "invariantOf", null, 0, -1, OclConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOclConstraint_PreconditionFor(), theModelPackage.getOperation(), null, "preconditionFor", null, 0, -1, OclConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOclConstraint_PostconditionFor(), theModelPackage.getOperation(), null, "postconditionFor", null, 0, -1, OclConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOclConstraint_ViolationMessageExpression(), theExpressionsPackage.getOclExpression(), null, "violationMessageExpression", null, 0, -1, OclConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOclConstraint_InitializedAttribute(), theModelPackage.getAttribute(), null, "initializedAttribute", null, 0, 1, OclConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOclConstraint_InitializedElement(), theModelPackage.getTypedElement(), null, "initializedElement", null, 0, 1, OclConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://sap.com/MOIN
		createMOINAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://sap.com/MOIN</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createMOINAnnotations() {
		String source = "http://sap.com/MOIN";		
		addAnnotation
		  (oclConstraintEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Attaching.OclConstraint",
			 "metaObjectMofId", "45ED2E296BF3BA190A154A871BE194593FC488D2",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (getOclConstraint_OclExpression(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Attaching.OclConstraintExpression",
			 "metaObjectMofId", "45ED2E2978C53990A5BC4C2422388AFB1EB36113",
			 "storedEnd", "1",
			 "compositeEnd", "1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (getOclConstraint_InvariantOf(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Attaching.ClassifierInvariant",
			 "metaObjectMofId", "45ED2E29B18FDCFB1C7C45620794D5388EE71A7D",
			 "storedEnd", "0",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "0"
		   });		
		addAnnotation
		  (getOclConstraint_PreconditionFor(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Attaching.PreconditionConstraint",
			 "metaObjectMofId", "45ED2E297AA45A8BC6274DCA3556BA29F90C887A",
			 "storedEnd", "0",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "0"
		   });		
		addAnnotation
		  (getOclConstraint_PostconditionFor(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Attaching.PostconditionConstraint",
			 "metaObjectMofId", "45ED2E298B6069BDF2AD46B50C9CE09F7EACD165",
			 "storedEnd", "0",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "0"
		   });		
		addAnnotation
		  (getOclConstraint_ViolationMessageExpression(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Attaching.ViolationMessageExpression",
			 "metaObjectMofId", "465EBCDCE887F4120F7011DC8D6000199904B925",
			 "storedEnd", "1",
			 "compositeEnd", "-1",
			 "orderedEnd", "0",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (getOclConstraint_InitializedAttribute(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Attaching.AttributeInitializerConstraint",
			 "metaObjectMofId", "47CFA6A89B3BA5B2EB5411DC95AA00199904B925",
			 "storedEnd", "1",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (getOclConstraint_InitializedElement(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Attaching.InitializedElement",
			 "metaObjectMofId", "486E16B04485CCE349C411DDA8FD00199904B925",
			 "storedEnd", "1",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "1"
		   });
	}

} //AttachingPackageImpl
