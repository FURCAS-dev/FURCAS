/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.tc.moin.repository.mmi.CorbaIdlTypes.impl;

import com.sap.tc.moin.repository.mmi.CorbaIdlTypes.CorbaChar;
import com.sap.tc.moin.repository.mmi.CorbaIdlTypes.CorbaIdlTypesFactory;
import com.sap.tc.moin.repository.mmi.CorbaIdlTypes.CorbaIdlTypesPackage;
import com.sap.tc.moin.repository.mmi.CorbaIdlTypes.CorbaLongDouble;
import com.sap.tc.moin.repository.mmi.CorbaIdlTypes.CorbaOctet;
import com.sap.tc.moin.repository.mmi.CorbaIdlTypes.CorbaShort;
import com.sap.tc.moin.repository.mmi.CorbaIdlTypes.CorbaString;
import com.sap.tc.moin.repository.mmi.CorbaIdlTypes.CorbaUnsignedLong;
import com.sap.tc.moin.repository.mmi.CorbaIdlTypes.CorbaUnsignedLongLong;
import com.sap.tc.moin.repository.mmi.CorbaIdlTypes.CorbaUnsignedShort;
import com.sap.tc.moin.repository.mmi.CorbaIdlTypes.CorbaWChar;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CorbaIdlTypesPackageImpl extends EPackageImpl implements CorbaIdlTypesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass corbaOctetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass corbaShortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass corbaUnsignedShortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass corbaUnsignedLongEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass corbaUnsignedLongLongEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass corbaLongDoubleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass corbaStringEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass corbaCharEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass corbaWCharEClass = null;

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
	 * @see com.sap.tc.moin.repository.mmi.CorbaIdlTypes.CorbaIdlTypesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CorbaIdlTypesPackageImpl() {
		super(eNS_URI, CorbaIdlTypesFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CorbaIdlTypesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CorbaIdlTypesPackage init() {
		if (isInited) return (CorbaIdlTypesPackage)EPackage.Registry.INSTANCE.getEPackage(CorbaIdlTypesPackage.eNS_URI);

		// Obtain or create and register package
		CorbaIdlTypesPackageImpl theCorbaIdlTypesPackage = (CorbaIdlTypesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CorbaIdlTypesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CorbaIdlTypesPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theCorbaIdlTypesPackage.createPackageContents();

		// Initialize created meta-data
		theCorbaIdlTypesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCorbaIdlTypesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CorbaIdlTypesPackage.eNS_URI, theCorbaIdlTypesPackage);
		return theCorbaIdlTypesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCorbaOctet() {
		return corbaOctetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCorbaShort() {
		return corbaShortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCorbaUnsignedShort() {
		return corbaUnsignedShortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCorbaUnsignedLong() {
		return corbaUnsignedLongEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCorbaUnsignedLongLong() {
		return corbaUnsignedLongLongEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCorbaLongDouble() {
		return corbaLongDoubleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCorbaString() {
		return corbaStringEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCorbaChar() {
		return corbaCharEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCorbaWChar() {
		return corbaWCharEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CorbaIdlTypesFactory getCorbaIdlTypesFactory() {
		return (CorbaIdlTypesFactory)getEFactoryInstance();
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
		corbaOctetEClass = createEClass(CORBA_OCTET);

		corbaShortEClass = createEClass(CORBA_SHORT);

		corbaUnsignedShortEClass = createEClass(CORBA_UNSIGNED_SHORT);

		corbaUnsignedLongEClass = createEClass(CORBA_UNSIGNED_LONG);

		corbaUnsignedLongLongEClass = createEClass(CORBA_UNSIGNED_LONG_LONG);

		corbaLongDoubleEClass = createEClass(CORBA_LONG_DOUBLE);

		corbaStringEClass = createEClass(CORBA_STRING);

		corbaCharEClass = createEClass(CORBA_CHAR);

		corbaWCharEClass = createEClass(CORBA_WCHAR);
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
		initEClass(corbaOctetEClass, CorbaOctet.class, "CorbaOctet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(corbaShortEClass, CorbaShort.class, "CorbaShort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(corbaUnsignedShortEClass, CorbaUnsignedShort.class, "CorbaUnsignedShort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(corbaUnsignedLongEClass, CorbaUnsignedLong.class, "CorbaUnsignedLong", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(corbaUnsignedLongLongEClass, CorbaUnsignedLongLong.class, "CorbaUnsignedLongLong", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(corbaLongDoubleEClass, CorbaLongDouble.class, "CorbaLongDouble", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(corbaStringEClass, CorbaString.class, "CorbaString", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(corbaCharEClass, CorbaChar.class, "CorbaChar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(corbaWCharEClass, CorbaWChar.class, "CorbaWChar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

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
		  (this, 
		   source, 
		   new String[] {
			 "CorbaIdlTypes.CorbaOctet", "//CorbaOctet",
			 "CorbaIdlTypes.CorbaShort", "//CorbaShort",
			 "CorbaIdlTypes.CorbaUnsignedShort", "//CorbaUnsignedShort",
			 "CorbaIdlTypes.CorbaUnsignedLong", "//CorbaUnsignedLong",
			 "CorbaIdlTypes.CorbaUnsignedLongLong", "//CorbaUnsignedLongLong",
			 "CorbaIdlTypes.CorbaLongDouble", "//CorbaLongDouble",
			 "CorbaIdlTypes.CorbaString", "//CorbaString",
			 "CorbaIdlTypes.CorbaChar", "//CorbaChar",
			 "CorbaIdlTypes.CorbaWChar", "//CorbaWChar"
		   });		
		addAnnotation
		  (corbaOctetEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "CorbaIdlTypes.CorbaOctet",
			 "metaObjectMofId", "4625EA0207E9C53B88824EC92D44CF71684E3BF8",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (corbaShortEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "CorbaIdlTypes.CorbaShort",
			 "metaObjectMofId", "4625EA025A8B87151E42492E220987C485BFF582",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (corbaUnsignedShortEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "CorbaIdlTypes.CorbaUnsignedShort",
			 "metaObjectMofId", "4625EA0285B26943A09D4CF22E9D8E6F789125C4",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (corbaUnsignedLongEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "CorbaIdlTypes.CorbaUnsignedLong",
			 "metaObjectMofId", "4625EA02E33898C22AF840E01878CD4B83ECDB03",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (corbaUnsignedLongLongEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "CorbaIdlTypes.CorbaUnsignedLongLong",
			 "metaObjectMofId", "4625EA02143D63ED323E4FF006D5943DF62FF4B4",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (corbaLongDoubleEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "CorbaIdlTypes.CorbaLongDouble",
			 "metaObjectMofId", "4625EA02D42A2B4136A34D351D2DD894F502E061",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (corbaStringEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "CorbaIdlTypes.CorbaString",
			 "metaObjectMofId", "4625EA02621591FEEB8F4D030C4BD82B1489EE74",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (corbaCharEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "CorbaIdlTypes.CorbaChar",
			 "metaObjectMofId", "4625EA02D4F5DEB55DE94CDE145D85D89B0F22DD",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (corbaWCharEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "CorbaIdlTypes.CorbaWChar",
			 "metaObjectMofId", "4625EA0254D19C09D87B478B26A8CD268FD80681",
			 "isStructureType", "false"
		   });
	}

} //CorbaIdlTypesPackageImpl
