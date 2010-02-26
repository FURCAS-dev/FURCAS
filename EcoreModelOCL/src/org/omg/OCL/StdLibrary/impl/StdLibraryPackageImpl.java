/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.StdLibrary.impl;

import com.sap.tc.moin.repository.mmi.Model.ModelPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.omg.OCL.Attaching.AttachingPackage;

import org.omg.OCL.Attaching.impl.AttachingPackageImpl;

import org.omg.OCL.Expressions.ExpressionsPackage;

import org.omg.OCL.Expressions.impl.ExpressionsPackageImpl;

import org.omg.OCL.StdLibrary.BagTypeStdLib;
import org.omg.OCL.StdLibrary.BooleanStdLib;
import org.omg.OCL.StdLibrary.CollectionTypeStdLib;
import org.omg.OCL.StdLibrary.DoubleStdLib;
import org.omg.OCL.StdLibrary.FloatStdLib;
import org.omg.OCL.StdLibrary.IntegerStdLib;
import org.omg.OCL.StdLibrary.LongStdLib;
import org.omg.OCL.StdLibrary.OclAnyStdLib;
import org.omg.OCL.StdLibrary.OclInvalidStdLib;
import org.omg.OCL.StdLibrary.OclTypeStdLib;
import org.omg.OCL.StdLibrary.OclVoidStdLib;
import org.omg.OCL.StdLibrary.OrderedSetTypeStdLib;
import org.omg.OCL.StdLibrary.SequenceTypeStdLib;
import org.omg.OCL.StdLibrary.SetTypeStdLib;
import org.omg.OCL.StdLibrary.StdLibraryFactory;
import org.omg.OCL.StdLibrary.StdLibraryPackage;
import org.omg.OCL.StdLibrary.StringStdLib;
import org.omg.OCL.StdLibrary.TupleTypeStdLib;

import org.omg.OCL.Types.TypesPackage;

import org.omg.OCL.Types.impl.TypesPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StdLibraryPackageImpl extends EPackageImpl implements StdLibraryPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oclAnyStdLibEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringStdLibEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanStdLibEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass floatStdLibEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionTypeStdLibEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setTypeStdLibEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceTypeStdLibEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bagTypeStdLibEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orderedSetTypeStdLibEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oclVoidStdLibEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerStdLibEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oclTypeStdLibEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tupleTypeStdLibEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doubleStdLibEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass longStdLibEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oclInvalidStdLibEClass = null;

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
	 * @see org.omg.OCL.StdLibrary.StdLibraryPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private StdLibraryPackageImpl() {
		super(eNS_URI, StdLibraryFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link StdLibraryPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static StdLibraryPackage init() {
		if (isInited) return (StdLibraryPackage)EPackage.Registry.INSTANCE.getEPackage(StdLibraryPackage.eNS_URI);

		// Obtain or create and register package
		StdLibraryPackageImpl theStdLibraryPackage = (StdLibraryPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof StdLibraryPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new StdLibraryPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ModelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		TypesPackageImpl theTypesPackage = (TypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) : TypesPackage.eINSTANCE);
		ExpressionsPackageImpl theExpressionsPackage = (ExpressionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI) instanceof ExpressionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI) : ExpressionsPackage.eINSTANCE);
		AttachingPackageImpl theAttachingPackage = (AttachingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AttachingPackage.eNS_URI) instanceof AttachingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AttachingPackage.eNS_URI) : AttachingPackage.eINSTANCE);

		// Create package meta-data objects
		theStdLibraryPackage.createPackageContents();
		theTypesPackage.createPackageContents();
		theExpressionsPackage.createPackageContents();
		theAttachingPackage.createPackageContents();

		// Initialize created meta-data
		theStdLibraryPackage.initializePackageContents();
		theTypesPackage.initializePackageContents();
		theExpressionsPackage.initializePackageContents();
		theAttachingPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theStdLibraryPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(StdLibraryPackage.eNS_URI, theStdLibraryPackage);
		return theStdLibraryPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOclAnyStdLib() {
		return oclAnyStdLibEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringStdLib() {
		return stringStdLibEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanStdLib() {
		return booleanStdLibEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFloatStdLib() {
		return floatStdLibEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionTypeStdLib() {
		return collectionTypeStdLibEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetTypeStdLib() {
		return setTypeStdLibEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequenceTypeStdLib() {
		return sequenceTypeStdLibEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBagTypeStdLib() {
		return bagTypeStdLibEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrderedSetTypeStdLib() {
		return orderedSetTypeStdLibEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOclVoidStdLib() {
		return oclVoidStdLibEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerStdLib() {
		return integerStdLibEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOclTypeStdLib() {
		return oclTypeStdLibEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTupleTypeStdLib() {
		return tupleTypeStdLibEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDoubleStdLib() {
		return doubleStdLibEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLongStdLib() {
		return longStdLibEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOclInvalidStdLib() {
		return oclInvalidStdLibEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StdLibraryFactory getStdLibraryFactory() {
		return (StdLibraryFactory)getEFactoryInstance();
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
		oclAnyStdLibEClass = createEClass(OCL_ANY_STD_LIB);

		stringStdLibEClass = createEClass(STRING_STD_LIB);

		booleanStdLibEClass = createEClass(BOOLEAN_STD_LIB);

		floatStdLibEClass = createEClass(FLOAT_STD_LIB);

		collectionTypeStdLibEClass = createEClass(COLLECTION_TYPE_STD_LIB);

		setTypeStdLibEClass = createEClass(SET_TYPE_STD_LIB);

		sequenceTypeStdLibEClass = createEClass(SEQUENCE_TYPE_STD_LIB);

		bagTypeStdLibEClass = createEClass(BAG_TYPE_STD_LIB);

		orderedSetTypeStdLibEClass = createEClass(ORDERED_SET_TYPE_STD_LIB);

		oclVoidStdLibEClass = createEClass(OCL_VOID_STD_LIB);

		integerStdLibEClass = createEClass(INTEGER_STD_LIB);

		oclTypeStdLibEClass = createEClass(OCL_TYPE_STD_LIB);

		tupleTypeStdLibEClass = createEClass(TUPLE_TYPE_STD_LIB);

		doubleStdLibEClass = createEClass(DOUBLE_STD_LIB);

		longStdLibEClass = createEClass(LONG_STD_LIB);

		oclInvalidStdLibEClass = createEClass(OCL_INVALID_STD_LIB);
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
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		oclAnyStdLibEClass.getESuperTypes().add(theModelPackage.getClassifier());
		stringStdLibEClass.getESuperTypes().add(this.getOclAnyStdLib());
		booleanStdLibEClass.getESuperTypes().add(this.getOclAnyStdLib());
		floatStdLibEClass.getESuperTypes().add(this.getOclAnyStdLib());
		collectionTypeStdLibEClass.getESuperTypes().add(theModelPackage.getClassifier());
		setTypeStdLibEClass.getESuperTypes().add(this.getCollectionTypeStdLib());
		sequenceTypeStdLibEClass.getESuperTypes().add(this.getCollectionTypeStdLib());
		bagTypeStdLibEClass.getESuperTypes().add(this.getCollectionTypeStdLib());
		orderedSetTypeStdLibEClass.getESuperTypes().add(this.getCollectionTypeStdLib());
		oclVoidStdLibEClass.getESuperTypes().add(this.getOclAnyStdLib());
		integerStdLibEClass.getESuperTypes().add(this.getOclAnyStdLib());
		oclTypeStdLibEClass.getESuperTypes().add(this.getOclAnyStdLib());
		tupleTypeStdLibEClass.getESuperTypes().add(theModelPackage.getClassifier());
		doubleStdLibEClass.getESuperTypes().add(this.getOclAnyStdLib());
		longStdLibEClass.getESuperTypes().add(this.getOclAnyStdLib());
		oclInvalidStdLibEClass.getESuperTypes().add(this.getOclAnyStdLib());

		// Initialize classes and features; add operations and parameters
		initEClass(oclAnyStdLibEClass, OclAnyStdLib.class, "OclAnyStdLib", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(oclAnyStdLibEClass, ecorePackage.getEBoolean(), "equalsStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theModelPackage.getClassifier(), "o2", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclAnyStdLibEClass, ecorePackage.getEBoolean(), "notEqualsStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theModelPackage.getClassifier(), "o2", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(oclAnyStdLibEClass, ecorePackage.getEBoolean(), "oclIsNew", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(oclAnyStdLibEClass, ecorePackage.getEBoolean(), "oclIsUndefined", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(oclAnyStdLibEClass, ecorePackage.getEBoolean(), "oclIsInvalid", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclAnyStdLibEClass, theModelPackage.getClassifier(), "oclAsType", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theModelPackage.getClassifier(), "t", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclAnyStdLibEClass, ecorePackage.getEBoolean(), "oclIsTypeOf", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theModelPackage.getClassifier(), "t", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclAnyStdLibEClass, ecorePackage.getEBoolean(), "oclIsKindOf", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theModelPackage.getClassifier(), "t", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(oclAnyStdLibEClass, theTypesPackage.getSetType(), "asSet", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(oclAnyStdLibEClass, ecorePackage.getEString(), "toString", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		initEClass(stringStdLibEClass, StringStdLib.class, "StringStdLib", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(stringStdLibEClass, ecorePackage.getEInt(), "size", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(stringStdLibEClass, ecorePackage.getEString(), "concat", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "s", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(stringStdLibEClass, ecorePackage.getEString(), "subString", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "lower", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "upper", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(stringStdLibEClass, ecorePackage.getEInt(), "toInteger", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(stringStdLibEClass, ecorePackage.getEFloat(), "toFloat", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(stringStdLibEClass, ecorePackage.getELong(), "toLong", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(stringStdLibEClass, ecorePackage.getEDouble(), "toDouble", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(stringStdLibEClass, ecorePackage.getEBoolean(), "matches", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "regex", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(stringStdLibEClass, ecorePackage.getEString(), "toUpperCase", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(stringStdLibEClass, ecorePackage.getEString(), "toLowerCase", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		initEClass(booleanStdLibEClass, BooleanStdLib.class, "BooleanStdLib", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(booleanStdLibEClass, ecorePackage.getEBoolean(), "or", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "b", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(booleanStdLibEClass, ecorePackage.getEBoolean(), "and", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "b", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(booleanStdLibEClass, ecorePackage.getEBoolean(), "xor", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "b", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(booleanStdLibEClass, ecorePackage.getEBoolean(), "not", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(booleanStdLibEClass, ecorePackage.getEBoolean(), "implies", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "b", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		initEClass(floatStdLibEClass, FloatStdLib.class, "FloatStdLib", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(floatStdLibEClass, ecorePackage.getEFloat(), "plusStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEFloat(), "r", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(floatStdLibEClass, ecorePackage.getEFloat(), "minusStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEFloat(), "r", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(floatStdLibEClass, ecorePackage.getEFloat(), "multStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEFloat(), "r", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(floatStdLibEClass, ecorePackage.getEFloat(), "divStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEFloat(), "r", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(floatStdLibEClass, ecorePackage.getEFloat(), "abs", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(floatStdLibEClass, ecorePackage.getEInt(), "floor", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(floatStdLibEClass, ecorePackage.getEInt(), "round", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(floatStdLibEClass, ecorePackage.getEFloat(), "max", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEFloat(), "r", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(floatStdLibEClass, ecorePackage.getEFloat(), "min", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEFloat(), "r", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(floatStdLibEClass, ecorePackage.getEBoolean(), "ltStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEFloat(), "r", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(floatStdLibEClass, ecorePackage.getEBoolean(), "gtStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEFloat(), "r", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(floatStdLibEClass, ecorePackage.getEBoolean(), "lteqStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEFloat(), "r", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(floatStdLibEClass, ecorePackage.getEBoolean(), "gteqStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEFloat(), "r", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(floatStdLibEClass, ecorePackage.getEFloat(), "negStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		initEClass(collectionTypeStdLibEClass, CollectionTypeStdLib.class, "CollectionTypeStdLib", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(collectionTypeStdLibEClass, ecorePackage.getEInt(), "size", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(collectionTypeStdLibEClass, ecorePackage.getEBoolean(), "includes", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theModelPackage.getClassifier(), "o", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(collectionTypeStdLibEClass, ecorePackage.getEBoolean(), "excludes", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theModelPackage.getClassifier(), "o", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(collectionTypeStdLibEClass, ecorePackage.getEInt(), "count", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theModelPackage.getClassifier(), "o", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(collectionTypeStdLibEClass, ecorePackage.getEBoolean(), "includesAll", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theTypesPackage.getCollectionType(), "c", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(collectionTypeStdLibEClass, ecorePackage.getEBoolean(), "excludesAll", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theTypesPackage.getCollectionType(), "c", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(collectionTypeStdLibEClass, ecorePackage.getEBoolean(), "isEmpty", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(collectionTypeStdLibEClass, ecorePackage.getEBoolean(), "notEmpty", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(collectionTypeStdLibEClass, theModelPackage.getClassifier(), "sum", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(collectionTypeStdLibEClass, theTypesPackage.getSetType(), "product", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theTypesPackage.getCollectionType(), "c", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(collectionTypeStdLibEClass, theTypesPackage.getSetType(), "asSet", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(collectionTypeStdLibEClass, theTypesPackage.getBagType(), "asBag", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(collectionTypeStdLibEClass, theTypesPackage.getOrderedSetType(), "asOrderedSet", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(collectionTypeStdLibEClass, theTypesPackage.getSequenceType(), "asSequence", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(collectionTypeStdLibEClass, ecorePackage.getEBoolean(), "oclIsUndefined", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		initEClass(setTypeStdLibEClass, SetTypeStdLib.class, "SetTypeStdLib", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(setTypeStdLibEClass, theTypesPackage.getCollectionType(), "union", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theTypesPackage.getCollectionType(), "s", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(setTypeStdLibEClass, ecorePackage.getEBoolean(), "equalsStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theTypesPackage.getSetType(), "s", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(setTypeStdLibEClass, theTypesPackage.getCollectionType(), "intersection", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theTypesPackage.getCollectionType(), "s", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(setTypeStdLibEClass, theTypesPackage.getSetType(), "n", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theTypesPackage.getSetType(), "s", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(setTypeStdLibEClass, theTypesPackage.getSetType(), "including", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theModelPackage.getClassifier(), "o", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(setTypeStdLibEClass, theTypesPackage.getSetType(), "excluding", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theModelPackage.getClassifier(), "o", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(setTypeStdLibEClass, theTypesPackage.getSetType(), "symmetricDifference", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theTypesPackage.getSetType(), "s", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(setTypeStdLibEClass, theTypesPackage.getSetType(), "flatten", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(setTypeStdLibEClass, theTypesPackage.getSetType(), "minusStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theTypesPackage.getSetType(), "s", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		initEClass(sequenceTypeStdLibEClass, SequenceTypeStdLib.class, "SequenceTypeStdLib", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(sequenceTypeStdLibEClass, ecorePackage.getEBoolean(), "equalsStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theTypesPackage.getSequenceType(), "s", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(sequenceTypeStdLibEClass, theTypesPackage.getSequenceType(), "union", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theTypesPackage.getSequenceType(), "s", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(sequenceTypeStdLibEClass, theTypesPackage.getSequenceType(), "flatten", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(sequenceTypeStdLibEClass, theTypesPackage.getSequenceType(), "append", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theModelPackage.getClassifier(), "o", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(sequenceTypeStdLibEClass, theTypesPackage.getSequenceType(), "prepend", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theModelPackage.getClassifier(), "o", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(sequenceTypeStdLibEClass, theTypesPackage.getSequenceType(), "insertAt", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "i", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theModelPackage.getClassifier(), "o", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(sequenceTypeStdLibEClass, theTypesPackage.getSequenceType(), "subSequence", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "lower", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "upper", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(sequenceTypeStdLibEClass, theModelPackage.getClassifier(), "at", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "i", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(sequenceTypeStdLibEClass, ecorePackage.getEInt(), "indexOf", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theModelPackage.getClassifier(), "o", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(sequenceTypeStdLibEClass, theModelPackage.getClassifier(), "first", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(sequenceTypeStdLibEClass, theModelPackage.getClassifier(), "last", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(sequenceTypeStdLibEClass, theTypesPackage.getSequenceType(), "including", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theModelPackage.getClassifier(), "o", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(sequenceTypeStdLibEClass, theTypesPackage.getSequenceType(), "excluding", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theModelPackage.getClassifier(), "o", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		initEClass(bagTypeStdLibEClass, BagTypeStdLib.class, "BagTypeStdLib", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(bagTypeStdLibEClass, ecorePackage.getEBoolean(), "equalsStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theTypesPackage.getBagType(), "b", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(bagTypeStdLibEClass, theTypesPackage.getBagType(), "union", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theTypesPackage.getCollectionType(), "b", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(bagTypeStdLibEClass, theTypesPackage.getCollectionType(), "intersection", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theTypesPackage.getCollectionType(), "b", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(bagTypeStdLibEClass, theTypesPackage.getBagType(), "including", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theModelPackage.getClassifier(), "o", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(bagTypeStdLibEClass, theTypesPackage.getBagType(), "excluding", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theModelPackage.getClassifier(), "o", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(bagTypeStdLibEClass, theTypesPackage.getBagType(), "flatten", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		initEClass(orderedSetTypeStdLibEClass, OrderedSetTypeStdLib.class, "OrderedSetTypeStdLib", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(orderedSetTypeStdLibEClass, theTypesPackage.getOrderedSetType(), "append", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theModelPackage.getClassifier(), "o", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(orderedSetTypeStdLibEClass, theTypesPackage.getOrderedSetType(), "prepend", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theModelPackage.getClassifier(), "o", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(orderedSetTypeStdLibEClass, theTypesPackage.getOrderedSetType(), "insertAt", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "index", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theModelPackage.getClassifier(), "o", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(orderedSetTypeStdLibEClass, theTypesPackage.getOrderedSetType(), "subOrderedSet", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "lower", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "upper", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(orderedSetTypeStdLibEClass, theModelPackage.getClassifier(), "at", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "i", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(orderedSetTypeStdLibEClass, ecorePackage.getEInt(), "indexOf", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theModelPackage.getClassifier(), "o", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(orderedSetTypeStdLibEClass, theModelPackage.getClassifier(), "first", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(orderedSetTypeStdLibEClass, theModelPackage.getClassifier(), "last", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(orderedSetTypeStdLibEClass, ecorePackage.getEBoolean(), "equalsStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theTypesPackage.getOrderedSetType(), "o", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		initEClass(oclVoidStdLibEClass, OclVoidStdLib.class, "OclVoidStdLib", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(integerStdLibEClass, IntegerStdLib.class, "IntegerStdLib", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(integerStdLibEClass, ecorePackage.getEInt(), "plusStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "i", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(integerStdLibEClass, ecorePackage.getEInt(), "minusStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "i", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(integerStdLibEClass, ecorePackage.getEInt(), "multStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "i", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(integerStdLibEClass, ecorePackage.getEFloat(), "divStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "i", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(integerStdLibEClass, ecorePackage.getEInt(), "abs", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(integerStdLibEClass, ecorePackage.getEInt(), "intDivStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "i", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(integerStdLibEClass, ecorePackage.getEInt(), "mod", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "i", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(integerStdLibEClass, ecorePackage.getEInt(), "max", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "i", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(integerStdLibEClass, ecorePackage.getEInt(), "min", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "i", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(integerStdLibEClass, ecorePackage.getEBoolean(), "ltStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "i", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(integerStdLibEClass, ecorePackage.getEBoolean(), "gtStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "i", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(integerStdLibEClass, ecorePackage.getEBoolean(), "lteqStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "i", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(integerStdLibEClass, ecorePackage.getEBoolean(), "gteqStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "i", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(integerStdLibEClass, ecorePackage.getEInt(), "negStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		initEClass(oclTypeStdLibEClass, OclTypeStdLib.class, "OclTypeStdLib", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(oclTypeStdLibEClass, theTypesPackage.getSetType(), "allInstances", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		initEClass(tupleTypeStdLibEClass, TupleTypeStdLib.class, "TupleTypeStdLib", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(doubleStdLibEClass, DoubleStdLib.class, "DoubleStdLib", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(doubleStdLibEClass, ecorePackage.getEDouble(), "plusStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEDouble(), "d", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(doubleStdLibEClass, ecorePackage.getEDouble(), "minusStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEDouble(), "d", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(doubleStdLibEClass, ecorePackage.getEDouble(), "multStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEDouble(), "d", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(doubleStdLibEClass, ecorePackage.getEDouble(), "divStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEDouble(), "d", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(doubleStdLibEClass, ecorePackage.getEDouble(), "abs", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(doubleStdLibEClass, ecorePackage.getELong(), "floor", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(doubleStdLibEClass, ecorePackage.getELong(), "round", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(doubleStdLibEClass, ecorePackage.getEDouble(), "max", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEDouble(), "d", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(doubleStdLibEClass, ecorePackage.getEDouble(), "min", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEDouble(), "d", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(doubleStdLibEClass, ecorePackage.getEBoolean(), "ltStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEDouble(), "d", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(doubleStdLibEClass, ecorePackage.getEBoolean(), "gtStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEDouble(), "d", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(doubleStdLibEClass, ecorePackage.getEBoolean(), "lteqStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEDouble(), "d", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(doubleStdLibEClass, ecorePackage.getEBoolean(), "gteqStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEDouble(), "d", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(doubleStdLibEClass, ecorePackage.getEDouble(), "negStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		initEClass(longStdLibEClass, LongStdLib.class, "LongStdLib", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(longStdLibEClass, ecorePackage.getELong(), "plusStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getELong(), "l", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(longStdLibEClass, ecorePackage.getELong(), "minusStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getELong(), "l", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(longStdLibEClass, ecorePackage.getELong(), "multStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getELong(), "l", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(longStdLibEClass, ecorePackage.getEDouble(), "divStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getELong(), "l", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(longStdLibEClass, ecorePackage.getELong(), "abs", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(longStdLibEClass, ecorePackage.getELong(), "longDivStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getELong(), "l", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(longStdLibEClass, ecorePackage.getELong(), "mod", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getELong(), "l", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(longStdLibEClass, ecorePackage.getELong(), "max", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getELong(), "l", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(longStdLibEClass, ecorePackage.getELong(), "min", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getELong(), "l", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(longStdLibEClass, ecorePackage.getEBoolean(), "ltStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getELong(), "l", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(longStdLibEClass, ecorePackage.getEBoolean(), "gtStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getELong(), "l", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(longStdLibEClass, ecorePackage.getEBoolean(), "lteqStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getELong(), "l", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(longStdLibEClass, ecorePackage.getEBoolean(), "gteqStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getELong(), "l", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(longStdLibEClass, ecorePackage.getELong(), "negStdLib", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		initEClass(oclInvalidStdLibEClass, OclInvalidStdLib.class, "OclInvalidStdLib", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

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
		  (oclAnyStdLibEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.StdLibrary.OclAnyStdLib",
			 "metaObjectMofId", "45ED2E29626779E1E17D496F14C3D2ED6DDD2C4B",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (stringStdLibEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.StdLibrary.StringStdLib",
			 "metaObjectMofId", "45ED2E291763650F53494A340D609041A1E4C024",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (booleanStdLibEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.StdLibrary.BooleanStdLib",
			 "metaObjectMofId", "45ED2E29936A1B7BC643426C1D8E826FC8CA8D7B",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (floatStdLibEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.StdLibrary.FloatStdLib",
			 "metaObjectMofId", "45ED2E29FDD74AB18360422C3730F6CE5E13D54C",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (collectionTypeStdLibEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.StdLibrary.CollectionTypeStdLib",
			 "metaObjectMofId", "45ED2E29AA6650B52A0A4C141ACE8E378EC5E936",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (setTypeStdLibEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.StdLibrary.SetTypeStdLib",
			 "metaObjectMofId", "45ED2E2983B5E1A17ED545372F4BEB032F90AF7F",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (sequenceTypeStdLibEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.StdLibrary.SequenceTypeStdLib",
			 "metaObjectMofId", "45ED2E29F46B14105FFE42971C70B643565ADCEB",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (bagTypeStdLibEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.StdLibrary.BagTypeStdLib",
			 "metaObjectMofId", "45ED2E29AC1A4BFACBA04E8B3C39E3FC1CEFE881",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (orderedSetTypeStdLibEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.StdLibrary.OrderedSetTypeStdLib",
			 "metaObjectMofId", "45ED2E290E6B723558384B7209B4C045EF349EE6",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (oclVoidStdLibEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.StdLibrary.OclVoidStdLib",
			 "metaObjectMofId", "45ED2E290CAFA8D16B86466B3F7DA09CB90428FF",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (integerStdLibEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.StdLibrary.IntegerStdLib",
			 "metaObjectMofId", "45ED2E29E0380D2A55C54D502E3AE01FDDF9CA6C",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (oclTypeStdLibEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.StdLibrary.OclTypeStdLib",
			 "metaObjectMofId", "45ED2E29CF01CC07E0044EF30C8AB75BA10A62E3",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (tupleTypeStdLibEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.StdLibrary.TupleTypeStdLib",
			 "metaObjectMofId", "45ED2E292C74CA2C6E214A2E03D5BEDF8F8014F2",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (doubleStdLibEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.StdLibrary.DoubleStdLib",
			 "metaObjectMofId", "45ED2E2A639716B339E648510C3BC4DC46A17FC2",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (longStdLibEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.StdLibrary.LongStdLib",
			 "metaObjectMofId", "45ED2E2A39277D849526407A280AFC94661884F2",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (oclInvalidStdLibEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.StdLibrary.OclInvalidStdLib",
			 "metaObjectMofId", "4670DA1FEE757FB01A3C11DC842C00199904B925",
			 "isStructureType", "false"
		   });
	}

} //StdLibraryPackageImpl
