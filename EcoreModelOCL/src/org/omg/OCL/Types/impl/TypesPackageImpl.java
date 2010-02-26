/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.Types.impl;

import com.sap.tc.moin.repository.mmi.Model.ModelPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.omg.OCL.Attaching.AttachingPackage;

import org.omg.OCL.Attaching.impl.AttachingPackageImpl;

import org.omg.OCL.Expressions.ExpressionsPackage;

import org.omg.OCL.Expressions.impl.ExpressionsPackageImpl;

import org.omg.OCL.StdLibrary.StdLibraryPackage;

import org.omg.OCL.StdLibrary.impl.StdLibraryPackageImpl;

import org.omg.OCL.Types.BagType;
import org.omg.OCL.Types.CollectionType;
import org.omg.OCL.Types.OclModelElementType;
import org.omg.OCL.Types.OrderedSetType;
import org.omg.OCL.Types.SequenceType;
import org.omg.OCL.Types.SetType;
import org.omg.OCL.Types.TupleType;
import org.omg.OCL.Types.TypesFactory;
import org.omg.OCL.Types.TypesPackage;
import org.omg.OCL.Types.VoidType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TypesPackageImpl extends EPackageImpl implements TypesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oclModelElementTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass voidTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tupleTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orderedSetTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bagTypeEClass = null;

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
	 * @see org.omg.OCL.Types.TypesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TypesPackageImpl() {
		super(eNS_URI, TypesFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TypesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TypesPackage init() {
		if (isInited) return (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Obtain or create and register package
		TypesPackageImpl theTypesPackage = (TypesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TypesPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ModelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ExpressionsPackageImpl theExpressionsPackage = (ExpressionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI) instanceof ExpressionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI) : ExpressionsPackage.eINSTANCE);
		AttachingPackageImpl theAttachingPackage = (AttachingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AttachingPackage.eNS_URI) instanceof AttachingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AttachingPackage.eNS_URI) : AttachingPackage.eINSTANCE);
		StdLibraryPackageImpl theStdLibraryPackage = (StdLibraryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StdLibraryPackage.eNS_URI) instanceof StdLibraryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StdLibraryPackage.eNS_URI) : StdLibraryPackage.eINSTANCE);

		// Create package meta-data objects
		theTypesPackage.createPackageContents();
		theExpressionsPackage.createPackageContents();
		theAttachingPackage.createPackageContents();
		theStdLibraryPackage.createPackageContents();

		// Initialize created meta-data
		theTypesPackage.initializePackageContents();
		theExpressionsPackage.initializePackageContents();
		theAttachingPackage.initializePackageContents();
		theStdLibraryPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTypesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TypesPackage.eNS_URI, theTypesPackage);
		return theTypesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOclModelElementType() {
		return oclModelElementTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVoidType() {
		return voidTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTupleType() {
		return tupleTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionType() {
		return collectionTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionType_ElementType() {
		return (EReference)collectionTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetType() {
		return setTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequenceType() {
		return sequenceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrderedSetType() {
		return orderedSetTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBagType() {
		return bagTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesFactory getTypesFactory() {
		return (TypesFactory)getEFactoryInstance();
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
		oclModelElementTypeEClass = createEClass(OCL_MODEL_ELEMENT_TYPE);

		voidTypeEClass = createEClass(VOID_TYPE);

		tupleTypeEClass = createEClass(TUPLE_TYPE);

		collectionTypeEClass = createEClass(COLLECTION_TYPE);
		createEReference(collectionTypeEClass, COLLECTION_TYPE__ELEMENT_TYPE);

		setTypeEClass = createEClass(SET_TYPE);

		sequenceTypeEClass = createEClass(SEQUENCE_TYPE);

		orderedSetTypeEClass = createEClass(ORDERED_SET_TYPE);

		bagTypeEClass = createEClass(BAG_TYPE);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		oclModelElementTypeEClass.getESuperTypes().add(theModelPackage.getClassifier());
		voidTypeEClass.getESuperTypes().add(theModelPackage.getClassifier());
		tupleTypeEClass.getESuperTypes().add(theModelPackage.getDataType());
		collectionTypeEClass.getESuperTypes().add(theModelPackage.getDataType());
		setTypeEClass.getESuperTypes().add(this.getCollectionType());
		sequenceTypeEClass.getESuperTypes().add(this.getCollectionType());
		orderedSetTypeEClass.getESuperTypes().add(this.getCollectionType());
		bagTypeEClass.getESuperTypes().add(this.getCollectionType());

		// Initialize classes and features; add operations and parameters
		initEClass(oclModelElementTypeEClass, OclModelElementType.class, "OclModelElementType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(voidTypeEClass, VoidType.class, "VoidType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tupleTypeEClass, TupleType.class, "TupleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(collectionTypeEClass, CollectionType.class, "CollectionType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollectionType_ElementType(), theModelPackage.getClassifier(), null, "elementType", null, 1, 1, CollectionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(setTypeEClass, SetType.class, "SetType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sequenceTypeEClass, SequenceType.class, "SequenceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(orderedSetTypeEClass, OrderedSetType.class, "OrderedSetType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(bagTypeEClass, BagType.class, "BagType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

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
		  (oclModelElementTypeEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Types.OclModelElementType",
			 "metaObjectMofId", "45ED2E297F20E178A39B4A0109E1E1D76AD0D153",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (voidTypeEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Types.VoidType",
			 "metaObjectMofId", "45ED2E294438A3878B224B53045ECF618510E116",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (tupleTypeEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Types.TupleType",
			 "metaObjectMofId", "45ED2E29264CA5434DDC4F0333D8C92FC76E550B",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (getCollectionType_ElementType(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Types.A_collectionTypes_elementType",
			 "metaObjectMofId", "45ED2E29CE5CF0446B2B400712B1D80EAAB445BB",
			 "storedEnd", "0",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "0"
		   });		
		addAnnotation
		  (setTypeEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Types.SetType",
			 "metaObjectMofId", "45ED2E29D75FF04330094FC20BE6DE064AE7D28E",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (sequenceTypeEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Types.SequenceType",
			 "metaObjectMofId", "45ED2E29230ACC93A4294FE41A0190463EB649A4",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (orderedSetTypeEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Types.OrderedSetType",
			 "metaObjectMofId", "45ED2E29C01B4B91125D45A326988DEADB9FEA29",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (bagTypeEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Types.BagType",
			 "metaObjectMofId", "45ED2E29038A616F701F464A2F54CC4242056F02",
			 "isStructureType", "false"
		   });
	}

} //TypesPackageImpl
