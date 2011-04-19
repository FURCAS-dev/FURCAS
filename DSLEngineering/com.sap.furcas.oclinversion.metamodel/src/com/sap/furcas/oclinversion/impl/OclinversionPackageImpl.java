/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.oclinversion.impl;

import com.sap.furcas.oclinversion.OclinversionFactory;
import com.sap.furcas.oclinversion.OclinversionPackage;
import com.sap.furcas.oclinversion.QMarkLiteralExp;

import com.sap.furcas.oclinversion.oclequation.OclequationPackage;

import com.sap.furcas.oclinversion.oclequation.impl.OclequationPackageImpl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.ocl.ecore.EcorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OclinversionPackageImpl extends EPackageImpl implements OclinversionPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass qMarkLiteralExpEClass = null;

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
     * @see com.sap.furcas.oclinversion.OclinversionPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private OclinversionPackageImpl() {
        super(eNS_URI, OclinversionFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link OclinversionPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static OclinversionPackage init() {
        if (isInited) return (OclinversionPackage)EPackage.Registry.INSTANCE.getEPackage(OclinversionPackage.eNS_URI);

        // Obtain or create and register package
        OclinversionPackageImpl theOclinversionPackage = (OclinversionPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OclinversionPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OclinversionPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        EcorePackage.eINSTANCE.eClass();

        // Obtain or create and register interdependencies
        OclequationPackageImpl theOclequationPackage = (OclequationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(OclequationPackage.eNS_URI) instanceof OclequationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(OclequationPackage.eNS_URI) : OclequationPackage.eINSTANCE);

        // Create package meta-data objects
        theOclinversionPackage.createPackageContents();
        theOclequationPackage.createPackageContents();

        // Initialize created meta-data
        theOclinversionPackage.initializePackageContents();
        theOclequationPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theOclinversionPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(OclinversionPackage.eNS_URI, theOclinversionPackage);
        return theOclinversionPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getQMarkLiteralExp() {
        return qMarkLiteralExpEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OclinversionFactory getOclinversionFactory() {
        return (OclinversionFactory)getEFactoryInstance();
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
        qMarkLiteralExpEClass = createEClass(QMARK_LITERAL_EXP);
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
        OclequationPackage theOclequationPackage = (OclequationPackage)EPackage.Registry.INSTANCE.getEPackage(OclequationPackage.eNS_URI);
        EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

        // Add subpackages
        getESubpackages().add(theOclequationPackage);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        qMarkLiteralExpEClass.getESuperTypes().add(theEcorePackage.getBooleanLiteralExp());
        qMarkLiteralExpEClass.getESuperTypes().add(theEcorePackage.getEnumLiteralExp());
        qMarkLiteralExpEClass.getESuperTypes().add(theEcorePackage.getIntegerLiteralExp());
        qMarkLiteralExpEClass.getESuperTypes().add(theEcorePackage.getRealLiteralExp());
        qMarkLiteralExpEClass.getESuperTypes().add(theEcorePackage.getStringLiteralExp());

        // Initialize classes and features; add operations and parameters
        initEClass(qMarkLiteralExpEClass, QMarkLiteralExp.class, "QMarkLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        // Create resource
        createResource(eNS_URI);
    }

} //OclinversionPackageImpl
