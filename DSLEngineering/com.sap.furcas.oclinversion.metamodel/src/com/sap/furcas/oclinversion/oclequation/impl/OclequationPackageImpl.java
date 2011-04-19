/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.oclinversion.oclequation.impl;

import com.sap.furcas.oclinversion.OclinversionPackage;

import com.sap.furcas.oclinversion.impl.OclinversionPackageImpl;

import com.sap.furcas.oclinversion.oclequation.OclEquation;
import com.sap.furcas.oclinversion.oclequation.OclequationFactory;
import com.sap.furcas.oclinversion.oclequation.OclequationPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.ocl.ecore.EcorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OclequationPackageImpl extends EPackageImpl implements OclequationPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass oclEquationEClass = null;

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
     * @see com.sap.furcas.oclinversion.oclequation.OclequationPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private OclequationPackageImpl() {
        super(eNS_URI, OclequationFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link OclequationPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static OclequationPackage init() {
        if (isInited) return (OclequationPackage)EPackage.Registry.INSTANCE.getEPackage(OclequationPackage.eNS_URI);

        // Obtain or create and register package
        OclequationPackageImpl theOclequationPackage = (OclequationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OclequationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OclequationPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        EcorePackage.eINSTANCE.eClass();

        // Obtain or create and register interdependencies
        OclinversionPackageImpl theOclinversionPackage = (OclinversionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(OclinversionPackage.eNS_URI) instanceof OclinversionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(OclinversionPackage.eNS_URI) : OclinversionPackage.eINSTANCE);

        // Create package meta-data objects
        theOclequationPackage.createPackageContents();
        theOclinversionPackage.createPackageContents();

        // Initialize created meta-data
        theOclequationPackage.initializePackageContents();
        theOclinversionPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theOclequationPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(OclequationPackage.eNS_URI, theOclequationPackage);
        return theOclequationPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOclEquation() {
        return oclEquationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOclEquation_Left() {
        return (EReference)oclEquationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOclEquation_Right() {
        return (EReference)oclEquationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOclEquation_IsSource() {
        return (EAttribute)oclEquationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OclequationFactory getOclequationFactory() {
        return (OclequationFactory)getEFactoryInstance();
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
        oclEquationEClass = createEClass(OCL_EQUATION);
        createEReference(oclEquationEClass, OCL_EQUATION__LEFT);
        createEReference(oclEquationEClass, OCL_EQUATION__RIGHT);
        createEAttribute(oclEquationEClass, OCL_EQUATION__IS_SOURCE);
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

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes

        // Initialize classes and features; add operations and parameters
        initEClass(oclEquationEClass, OclEquation.class, "OclEquation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getOclEquation_Left(), theEcorePackage.getOCLExpression(), null, "left", null, 1, 1, OclEquation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOclEquation_Right(), theEcorePackage.getOCLExpression(), null, "right", null, 1, 1, OclEquation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getOclEquation_IsSource(), ecorePackage.getEBoolean(), "isSource", null, 0, 1, OclEquation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    }

} //OclequationPackageImpl
