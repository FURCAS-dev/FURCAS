/**
 * <copyright>
 * </copyright>
 *
 * $Id: PrimitivetypesPackageImpl.java,v 1.1 2011/01/20 15:52:51 auhl Exp $
 */
package primitivetypes.impl;

import company.CompanyPackage;

import company.impl.CompanyPackageImpl;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import primitivetypes.PrimitivetypesFactory;
import primitivetypes.PrimitivetypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PrimitivetypesPackageImpl extends EPackageImpl implements PrimitivetypesPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType integerEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType floatEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType doubleEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType stringEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType longEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType booleanEDataType = null;

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
     * @see primitivetypes.PrimitivetypesPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private PrimitivetypesPackageImpl() {
        super(eNS_URI, PrimitivetypesFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link PrimitivetypesPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static PrimitivetypesPackage init() {
        if (isInited) return (PrimitivetypesPackage)EPackage.Registry.INSTANCE.getEPackage(PrimitivetypesPackage.eNS_URI);

        // Obtain or create and register package
        PrimitivetypesPackageImpl thePrimitivetypesPackage = (PrimitivetypesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PrimitivetypesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PrimitivetypesPackageImpl());

        isInited = true;

        // Obtain or create and register interdependencies
        CompanyPackageImpl theCompanyPackage = (CompanyPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CompanyPackage.eNS_URI) instanceof CompanyPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CompanyPackage.eNS_URI) : CompanyPackage.eINSTANCE);

        // Create package meta-data objects
        thePrimitivetypesPackage.createPackageContents();
        theCompanyPackage.createPackageContents();

        // Initialize created meta-data
        thePrimitivetypesPackage.initializePackageContents();
        theCompanyPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        thePrimitivetypesPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(PrimitivetypesPackage.eNS_URI, thePrimitivetypesPackage);
        return thePrimitivetypesPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getInteger() {
        return integerEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getFloat() {
        return floatEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getDouble() {
        return doubleEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getString() {
        return stringEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getLong() {
        return longEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getBoolean() {
        return booleanEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PrimitivetypesFactory getPrimitivetypesFactory() {
        return (PrimitivetypesFactory)getEFactoryInstance();
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

        // Create data types
        integerEDataType = createEDataType(INTEGER);
        floatEDataType = createEDataType(FLOAT);
        doubleEDataType = createEDataType(DOUBLE);
        stringEDataType = createEDataType(STRING);
        longEDataType = createEDataType(LONG);
        booleanEDataType = createEDataType(BOOLEAN);
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

        // Initialize data types
        initEDataType(integerEDataType, int.class, "Integer", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(floatEDataType, float.class, "Float", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(doubleEDataType, double.class, "Double", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(stringEDataType, String.class, "String", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(longEDataType, long.class, "Long", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(booleanEDataType, boolean.class, "Boolean", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

        // Create resource
        createResource(eNS_URI);

        // Create annotations
        // http://www.eclipse.org/emf/2002/Ecore
        createEcoreAnnotations();
    }

    /**
     * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createEcoreAnnotations() {
        String source = "http://www.eclipse.org/emf/2002/Ecore";		
        addAnnotation
          (this, 
           source, 
           new String[] {
             "invocationDelegates", "http://de.hpi.sam.bp2009.OCL",
             "settingDelegates", "http://de.hpi.sam.bp2009.OCL",
             "validationDelegates", "http://de.hpi.sam.bp2009.OCL"
           });	
    }

} //PrimitivetypesPackageImpl
