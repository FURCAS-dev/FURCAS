/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.StdLibrary.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.omg.OCL.StdLibrary.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StdLibraryFactoryImpl extends EFactoryImpl implements StdLibraryFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StdLibraryFactory init() {
		try {
			StdLibraryFactory theStdLibraryFactory = (StdLibraryFactory)EPackage.Registry.INSTANCE.getEFactory("http://sap.com/moin/OCL/StdLibrary"); 
			if (theStdLibraryFactory != null) {
				return theStdLibraryFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StdLibraryFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StdLibraryFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case StdLibraryPackage.OCL_ANY_STD_LIB: return createOclAnyStdLib();
			case StdLibraryPackage.STRING_STD_LIB: return createStringStdLib();
			case StdLibraryPackage.BOOLEAN_STD_LIB: return createBooleanStdLib();
			case StdLibraryPackage.FLOAT_STD_LIB: return createFloatStdLib();
			case StdLibraryPackage.COLLECTION_TYPE_STD_LIB: return createCollectionTypeStdLib();
			case StdLibraryPackage.SET_TYPE_STD_LIB: return createSetTypeStdLib();
			case StdLibraryPackage.SEQUENCE_TYPE_STD_LIB: return createSequenceTypeStdLib();
			case StdLibraryPackage.BAG_TYPE_STD_LIB: return createBagTypeStdLib();
			case StdLibraryPackage.ORDERED_SET_TYPE_STD_LIB: return createOrderedSetTypeStdLib();
			case StdLibraryPackage.OCL_VOID_STD_LIB: return createOclVoidStdLib();
			case StdLibraryPackage.INTEGER_STD_LIB: return createIntegerStdLib();
			case StdLibraryPackage.OCL_TYPE_STD_LIB: return createOclTypeStdLib();
			case StdLibraryPackage.TUPLE_TYPE_STD_LIB: return createTupleTypeStdLib();
			case StdLibraryPackage.DOUBLE_STD_LIB: return createDoubleStdLib();
			case StdLibraryPackage.LONG_STD_LIB: return createLongStdLib();
			case StdLibraryPackage.OCL_INVALID_STD_LIB: return createOclInvalidStdLib();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclAnyStdLib createOclAnyStdLib() {
		OclAnyStdLibImpl oclAnyStdLib = new OclAnyStdLibImpl();
		return oclAnyStdLib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringStdLib createStringStdLib() {
		StringStdLibImpl stringStdLib = new StringStdLibImpl();
		return stringStdLib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanStdLib createBooleanStdLib() {
		BooleanStdLibImpl booleanStdLib = new BooleanStdLibImpl();
		return booleanStdLib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FloatStdLib createFloatStdLib() {
		FloatStdLibImpl floatStdLib = new FloatStdLibImpl();
		return floatStdLib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionTypeStdLib createCollectionTypeStdLib() {
		CollectionTypeStdLibImpl collectionTypeStdLib = new CollectionTypeStdLibImpl();
		return collectionTypeStdLib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetTypeStdLib createSetTypeStdLib() {
		SetTypeStdLibImpl setTypeStdLib = new SetTypeStdLibImpl();
		return setTypeStdLib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceTypeStdLib createSequenceTypeStdLib() {
		SequenceTypeStdLibImpl sequenceTypeStdLib = new SequenceTypeStdLibImpl();
		return sequenceTypeStdLib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BagTypeStdLib createBagTypeStdLib() {
		BagTypeStdLibImpl bagTypeStdLib = new BagTypeStdLibImpl();
		return bagTypeStdLib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrderedSetTypeStdLib createOrderedSetTypeStdLib() {
		OrderedSetTypeStdLibImpl orderedSetTypeStdLib = new OrderedSetTypeStdLibImpl();
		return orderedSetTypeStdLib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclVoidStdLib createOclVoidStdLib() {
		OclVoidStdLibImpl oclVoidStdLib = new OclVoidStdLibImpl();
		return oclVoidStdLib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerStdLib createIntegerStdLib() {
		IntegerStdLibImpl integerStdLib = new IntegerStdLibImpl();
		return integerStdLib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclTypeStdLib createOclTypeStdLib() {
		OclTypeStdLibImpl oclTypeStdLib = new OclTypeStdLibImpl();
		return oclTypeStdLib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TupleTypeStdLib createTupleTypeStdLib() {
		TupleTypeStdLibImpl tupleTypeStdLib = new TupleTypeStdLibImpl();
		return tupleTypeStdLib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleStdLib createDoubleStdLib() {
		DoubleStdLibImpl doubleStdLib = new DoubleStdLibImpl();
		return doubleStdLib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LongStdLib createLongStdLib() {
		LongStdLibImpl longStdLib = new LongStdLibImpl();
		return longStdLib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclInvalidStdLib createOclInvalidStdLib() {
		OclInvalidStdLibImpl oclInvalidStdLib = new OclInvalidStdLibImpl();
		return oclInvalidStdLib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StdLibraryPackage getStdLibraryPackage() {
		return (StdLibraryPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StdLibraryPackage getPackage() {
		return StdLibraryPackage.eINSTANCE;
	}

} //StdLibraryFactoryImpl
