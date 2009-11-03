/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.types.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.oslo.ocl20.syntax.ast.types.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TypesFactoryImpl extends EFactoryImpl implements TypesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TypesFactory init() {
		try {
			TypesFactory theTypesFactory = (TypesFactory)EPackage.Registry.INSTANCE.getEFactory("urn:ast.types.ecore"); 
			if (theTypesFactory != null) {
				return theTypesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TypesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case TypesPackage.BAG_TYPE_AS: return createBagTypeAS();
			case TypesPackage.CLASSIFIER_AS: return createClassifierAS();
			case TypesPackage.COLLECTION_TYPE_AS: return createCollectionTypeAS();
			case TypesPackage.ORDERED_SET_TYPE_AS: return createOrderedSetTypeAS();
			case TypesPackage.SEQUENCE_TYPE_AS: return createSequenceTypeAS();
			case TypesPackage.SET_TYPE_AS: return createSetTypeAS();
			case TypesPackage.TUPLE_TYPE_AS: return createTupleTypeAS();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BagTypeAS createBagTypeAS() {
		BagTypeASImpl bagTypeAS = new BagTypeASImpl();
		return bagTypeAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassifierAS createClassifierAS() {
		ClassifierASImpl classifierAS = new ClassifierASImpl();
		return classifierAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionTypeAS createCollectionTypeAS() {
		CollectionTypeASImpl collectionTypeAS = new CollectionTypeASImpl();
		return collectionTypeAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrderedSetTypeAS createOrderedSetTypeAS() {
		OrderedSetTypeASImpl orderedSetTypeAS = new OrderedSetTypeASImpl();
		return orderedSetTypeAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceTypeAS createSequenceTypeAS() {
		SequenceTypeASImpl sequenceTypeAS = new SequenceTypeASImpl();
		return sequenceTypeAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetTypeAS createSetTypeAS() {
		SetTypeASImpl setTypeAS = new SetTypeASImpl();
		return setTypeAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TupleTypeAS createTupleTypeAS() {
		TupleTypeASImpl tupleTypeAS = new TupleTypeASImpl();
		return tupleTypeAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesPackage getTypesPackage() {
		return (TypesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static TypesPackage getPackage() {
		return TypesPackage.eINSTANCE;
	}

} //TypesFactoryImpl
