/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.ecore.EcorePackage;

import com.sap.furcas.metamodel.FURCAS.EmptyDummyClassToWorkaroundGeneratorBug;
import com.sap.furcas.metamodel.FURCAS.FURCASFactory;
import com.sap.furcas.metamodel.FURCAS.FURCASPackage;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;
import com.sap.furcas.metamodel.FURCAS.TCS.impl.TCSPackageImpl;
import com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockdefinitionPackage;
import com.sap.furcas.metamodel.FURCAS.textblockdefinition.impl.TextblockdefinitionPackageImpl;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage;
import com.sap.furcas.metamodel.FURCAS.textblocks.impl.TextblocksPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FURCASPackageImpl extends EPackageImpl implements FURCASPackage {
        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        private EClass emptyDummyClassToWorkaroundGeneratorBugEClass = null;
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
	 * @see com.sap.furcas.metamodel.FURCAS.FURCASPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
        private FURCASPackageImpl() {
		super(eNS_URI, FURCASFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link FURCASPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
        public static FURCASPackage init() {
		if (isInited) return (FURCASPackage)EPackage.Registry.INSTANCE.getEPackage(FURCASPackage.eNS_URI);

		// Obtain or create and register package
		FURCASPackageImpl theFURCASPackage = (FURCASPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FURCASPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FURCASPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		TCSPackageImpl theTCSPackage = (TCSPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TCSPackage.eNS_URI) instanceof TCSPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TCSPackage.eNS_URI) : TCSPackage.eINSTANCE);
		TextblocksPackageImpl theTextblocksPackage = (TextblocksPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TextblocksPackage.eNS_URI) instanceof TextblocksPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TextblocksPackage.eNS_URI) : TextblocksPackage.eINSTANCE);
		TextblockdefinitionPackageImpl theTextblockdefinitionPackage = (TextblockdefinitionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TextblockdefinitionPackage.eNS_URI) instanceof TextblockdefinitionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TextblockdefinitionPackage.eNS_URI) : TextblockdefinitionPackage.eINSTANCE);

		// Create package meta-data objects
		theFURCASPackage.createPackageContents();
		theTCSPackage.createPackageContents();
		theTextblocksPackage.createPackageContents();
		theTextblockdefinitionPackage.createPackageContents();

		// Initialize created meta-data
		theFURCASPackage.initializePackageContents();
		theTCSPackage.initializePackageContents();
		theTextblocksPackage.initializePackageContents();
		theTextblockdefinitionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFURCASPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FURCASPackage.eNS_URI, theFURCASPackage);
		return theFURCASPackage;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public EClass getEmptyDummyClassToWorkaroundGeneratorBug() {
		return emptyDummyClassToWorkaroundGeneratorBugEClass;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public FURCASFactory getFURCASFactory() {
		return (FURCASFactory)getEFactoryInstance();
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
		emptyDummyClassToWorkaroundGeneratorBugEClass = createEClass(EMPTY_DUMMY_CLASS_TO_WORKAROUND_GENERATOR_BUG);
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
		TCSPackage theTCSPackage = (TCSPackage)EPackage.Registry.INSTANCE.getEPackage(TCSPackage.eNS_URI);
		TextblocksPackage theTextblocksPackage = (TextblocksPackage)EPackage.Registry.INSTANCE.getEPackage(TextblocksPackage.eNS_URI);
		TextblockdefinitionPackage theTextblockdefinitionPackage = (TextblockdefinitionPackage)EPackage.Registry.INSTANCE.getEPackage(TextblockdefinitionPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theTCSPackage);
		getESubpackages().add(theTextblocksPackage);
		getESubpackages().add(theTextblockdefinitionPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(emptyDummyClassToWorkaroundGeneratorBugEClass, EmptyDummyClassToWorkaroundGeneratorBug.class, "EmptyDummyClassToWorkaroundGeneratorBug", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //FURCASPackageImpl
