/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.types;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.oslo.ocl20.syntax.ast.types.TypesFactory
 * @model kind="package"
 * @generated
 */
public interface TypesPackage extends EPackage{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "types";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "urn:ast.types.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ast.types";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TypesPackage eINSTANCE = org.oslo.ocl20.syntax.ast.types.impl.TypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.types.impl.TypeASImpl <em>Type AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.types.impl.TypeASImpl
	 * @see org.oslo.ocl20.syntax.ast.types.impl.TypesPackageImpl#getTypeAS()
	 * @generated
	 */
	int TYPE_AS = 7;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_AS__IS_MARKED_PRE = ExpressionsPackage.LITERAL_EXP_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_AS__PARENT = ExpressionsPackage.LITERAL_EXP_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_AS__IF_EXP_AS = ExpressionsPackage.LITERAL_EXP_AS__IF_EXP_AS;

	/**
	 * The number of structural features of the '<em>Type AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_AS_FEATURE_COUNT = ExpressionsPackage.LITERAL_EXP_AS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.types.impl.CollectionTypeASImpl <em>Collection Type AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.types.impl.CollectionTypeASImpl
	 * @see org.oslo.ocl20.syntax.ast.types.impl.TypesPackageImpl#getCollectionTypeAS()
	 * @generated
	 */
	int COLLECTION_TYPE_AS = 2;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_AS__IS_MARKED_PRE = TYPE_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_AS__PARENT = TYPE_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_AS__IF_EXP_AS = TYPE_AS__IF_EXP_AS;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_AS__ELEMENT_TYPE = TYPE_AS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Collection Type AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_AS_FEATURE_COUNT = TYPE_AS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.types.impl.BagTypeASImpl <em>Bag Type AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.types.impl.BagTypeASImpl
	 * @see org.oslo.ocl20.syntax.ast.types.impl.TypesPackageImpl#getBagTypeAS()
	 * @generated
	 */
	int BAG_TYPE_AS = 0;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE_AS__IS_MARKED_PRE = COLLECTION_TYPE_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE_AS__PARENT = COLLECTION_TYPE_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE_AS__IF_EXP_AS = COLLECTION_TYPE_AS__IF_EXP_AS;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE_AS__ELEMENT_TYPE = COLLECTION_TYPE_AS__ELEMENT_TYPE;

	/**
	 * The number of structural features of the '<em>Bag Type AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE_AS_FEATURE_COUNT = COLLECTION_TYPE_AS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.types.impl.ClassifierASImpl <em>Classifier AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.types.impl.ClassifierASImpl
	 * @see org.oslo.ocl20.syntax.ast.types.impl.TypesPackageImpl#getClassifierAS()
	 * @generated
	 */
	int CLASSIFIER_AS = 1;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_AS__IS_MARKED_PRE = TYPE_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_AS__PARENT = TYPE_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_AS__IF_EXP_AS = TYPE_AS__IF_EXP_AS;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_AS__PATH_NAME = TYPE_AS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Classifier AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_AS_FEATURE_COUNT = TYPE_AS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.types.impl.OrderedSetTypeASImpl <em>Ordered Set Type AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.types.impl.OrderedSetTypeASImpl
	 * @see org.oslo.ocl20.syntax.ast.types.impl.TypesPackageImpl#getOrderedSetTypeAS()
	 * @generated
	 */
	int ORDERED_SET_TYPE_AS = 3;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE_AS__IS_MARKED_PRE = COLLECTION_TYPE_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE_AS__PARENT = COLLECTION_TYPE_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE_AS__IF_EXP_AS = COLLECTION_TYPE_AS__IF_EXP_AS;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE_AS__ELEMENT_TYPE = COLLECTION_TYPE_AS__ELEMENT_TYPE;

	/**
	 * The number of structural features of the '<em>Ordered Set Type AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE_AS_FEATURE_COUNT = COLLECTION_TYPE_AS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.types.impl.SequenceTypeASImpl <em>Sequence Type AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.types.impl.SequenceTypeASImpl
	 * @see org.oslo.ocl20.syntax.ast.types.impl.TypesPackageImpl#getSequenceTypeAS()
	 * @generated
	 */
	int SEQUENCE_TYPE_AS = 4;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE_AS__IS_MARKED_PRE = COLLECTION_TYPE_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE_AS__PARENT = COLLECTION_TYPE_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE_AS__IF_EXP_AS = COLLECTION_TYPE_AS__IF_EXP_AS;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE_AS__ELEMENT_TYPE = COLLECTION_TYPE_AS__ELEMENT_TYPE;

	/**
	 * The number of structural features of the '<em>Sequence Type AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE_AS_FEATURE_COUNT = COLLECTION_TYPE_AS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.types.impl.SetTypeASImpl <em>Set Type AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.types.impl.SetTypeASImpl
	 * @see org.oslo.ocl20.syntax.ast.types.impl.TypesPackageImpl#getSetTypeAS()
	 * @generated
	 */
	int SET_TYPE_AS = 5;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_AS__IS_MARKED_PRE = COLLECTION_TYPE_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_AS__PARENT = COLLECTION_TYPE_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_AS__IF_EXP_AS = COLLECTION_TYPE_AS__IF_EXP_AS;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_AS__ELEMENT_TYPE = COLLECTION_TYPE_AS__ELEMENT_TYPE;

	/**
	 * The number of structural features of the '<em>Set Type AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_AS_FEATURE_COUNT = COLLECTION_TYPE_AS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.types.impl.TupleTypeASImpl <em>Tuple Type AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.types.impl.TupleTypeASImpl
	 * @see org.oslo.ocl20.syntax.ast.types.impl.TypesPackageImpl#getTupleTypeAS()
	 * @generated
	 */
	int TUPLE_TYPE_AS = 6;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_AS__IS_MARKED_PRE = TYPE_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_AS__PARENT = TYPE_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_AS__IF_EXP_AS = TYPE_AS__IF_EXP_AS;

	/**
	 * The feature id for the '<em><b>Variable Declaration List</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_AS__VARIABLE_DECLARATION_LIST = TYPE_AS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tuple Type AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_AS_FEATURE_COUNT = TYPE_AS_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.types.BagTypeAS <em>Bag Type AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bag Type AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.types.BagTypeAS
	 * @generated
	 */
	EClass getBagTypeAS();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.types.ClassifierAS <em>Classifier AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Classifier AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.types.ClassifierAS
	 * @generated
	 */
	EClass getClassifierAS();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.types.ClassifierAS#getPathName <em>Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path Name</em>'.
	 * @see org.oslo.ocl20.syntax.ast.types.ClassifierAS#getPathName()
	 * @see #getClassifierAS()
	 * @generated
	 */
	EAttribute getClassifierAS_PathName();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.types.CollectionTypeAS <em>Collection Type AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Type AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.types.CollectionTypeAS
	 * @generated
	 */
	EClass getCollectionTypeAS();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.types.CollectionTypeAS#getElementType <em>Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element Type</em>'.
	 * @see org.oslo.ocl20.syntax.ast.types.CollectionTypeAS#getElementType()
	 * @see #getCollectionTypeAS()
	 * @generated
	 */
	EReference getCollectionTypeAS_ElementType();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.types.OrderedSetTypeAS <em>Ordered Set Type AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ordered Set Type AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.types.OrderedSetTypeAS
	 * @generated
	 */
	EClass getOrderedSetTypeAS();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.types.SequenceTypeAS <em>Sequence Type AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence Type AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.types.SequenceTypeAS
	 * @generated
	 */
	EClass getSequenceTypeAS();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.types.SetTypeAS <em>Set Type AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Type AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.types.SetTypeAS
	 * @generated
	 */
	EClass getSetTypeAS();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.types.TupleTypeAS <em>Tuple Type AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Type AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.types.TupleTypeAS
	 * @generated
	 */
	EClass getTupleTypeAS();

	/**
	 * Returns the meta object for the reference list '{@link org.oslo.ocl20.syntax.ast.types.TupleTypeAS#getVariableDeclarationList <em>Variable Declaration List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Variable Declaration List</em>'.
	 * @see org.oslo.ocl20.syntax.ast.types.TupleTypeAS#getVariableDeclarationList()
	 * @see #getTupleTypeAS()
	 * @generated
	 */
	EReference getTupleTypeAS_VariableDeclarationList();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.types.TypeAS <em>Type AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.types.TypeAS
	 * @generated
	 */
	EClass getTypeAS();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TypesFactory getTypesFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.types.impl.BagTypeASImpl <em>Bag Type AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.types.impl.BagTypeASImpl
		 * @see org.oslo.ocl20.syntax.ast.types.impl.TypesPackageImpl#getBagTypeAS()
		 * @generated
		 */
		EClass BAG_TYPE_AS = eINSTANCE.getBagTypeAS();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.types.impl.ClassifierASImpl <em>Classifier AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.types.impl.ClassifierASImpl
		 * @see org.oslo.ocl20.syntax.ast.types.impl.TypesPackageImpl#getClassifierAS()
		 * @generated
		 */
		EClass CLASSIFIER_AS = eINSTANCE.getClassifierAS();

		/**
		 * The meta object literal for the '<em><b>Path Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASSIFIER_AS__PATH_NAME = eINSTANCE.getClassifierAS_PathName();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.types.impl.CollectionTypeASImpl <em>Collection Type AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.types.impl.CollectionTypeASImpl
		 * @see org.oslo.ocl20.syntax.ast.types.impl.TypesPackageImpl#getCollectionTypeAS()
		 * @generated
		 */
		EClass COLLECTION_TYPE_AS = eINSTANCE.getCollectionTypeAS();

		/**
		 * The meta object literal for the '<em><b>Element Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_TYPE_AS__ELEMENT_TYPE = eINSTANCE.getCollectionTypeAS_ElementType();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.types.impl.OrderedSetTypeASImpl <em>Ordered Set Type AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.types.impl.OrderedSetTypeASImpl
		 * @see org.oslo.ocl20.syntax.ast.types.impl.TypesPackageImpl#getOrderedSetTypeAS()
		 * @generated
		 */
		EClass ORDERED_SET_TYPE_AS = eINSTANCE.getOrderedSetTypeAS();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.types.impl.SequenceTypeASImpl <em>Sequence Type AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.types.impl.SequenceTypeASImpl
		 * @see org.oslo.ocl20.syntax.ast.types.impl.TypesPackageImpl#getSequenceTypeAS()
		 * @generated
		 */
		EClass SEQUENCE_TYPE_AS = eINSTANCE.getSequenceTypeAS();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.types.impl.SetTypeASImpl <em>Set Type AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.types.impl.SetTypeASImpl
		 * @see org.oslo.ocl20.syntax.ast.types.impl.TypesPackageImpl#getSetTypeAS()
		 * @generated
		 */
		EClass SET_TYPE_AS = eINSTANCE.getSetTypeAS();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.types.impl.TupleTypeASImpl <em>Tuple Type AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.types.impl.TupleTypeASImpl
		 * @see org.oslo.ocl20.syntax.ast.types.impl.TypesPackageImpl#getTupleTypeAS()
		 * @generated
		 */
		EClass TUPLE_TYPE_AS = eINSTANCE.getTupleTypeAS();

		/**
		 * The meta object literal for the '<em><b>Variable Declaration List</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TUPLE_TYPE_AS__VARIABLE_DECLARATION_LIST = eINSTANCE.getTupleTypeAS_VariableDeclarationList();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.types.impl.TypeASImpl <em>Type AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.types.impl.TypeASImpl
		 * @see org.oslo.ocl20.syntax.ast.types.impl.TypesPackageImpl#getTypeAS()
		 * @generated
		 */
		EClass TYPE_AS = eINSTANCE.getTypeAS();

	}

} //TypesPackage
