/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.tuples;

import data.classes.ClassesPackage;

import modelmanagement.ModelmanagementPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see data.tuples.TuplesFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface TuplesPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "tuples";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http:///data/tuples.ecore";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "data.tuples";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	TuplesPackage eINSTANCE = data.tuples.impl.TuplesPackageImpl.init();

	/**
     * The meta object id for the '{@link data.tuples.impl.TupleTypeDefinitionImpl <em>Tuple Type Definition</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.tuples.impl.TupleTypeDefinitionImpl
     * @see data.tuples.impl.TuplesPackageImpl#getTupleTypeDefinition()
     * @generated
     */
	int TUPLE_TYPE_DEFINITION = 0;

	/**
     * The feature id for the '<em><b>Lower Multiplicity</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_TYPE_DEFINITION__LOWER_MULTIPLICITY = ClassesPackage.TYPE_DEFINITION__LOWER_MULTIPLICITY;

	/**
     * The feature id for the '<em><b>Upper Multiplicity</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_TYPE_DEFINITION__UPPER_MULTIPLICITY = ClassesPackage.TYPE_DEFINITION__UPPER_MULTIPLICITY;

	/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_TYPE_DEFINITION__ORDERED = ClassesPackage.TYPE_DEFINITION__ORDERED;

	/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_TYPE_DEFINITION__UNIQUE = ClassesPackage.TYPE_DEFINITION__UNIQUE;

	/**
     * The feature id for the '<em><b>Signatures With Output</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_TYPE_DEFINITION__SIGNATURES_WITH_OUTPUT = ClassesPackage.TYPE_DEFINITION__SIGNATURES_WITH_OUTPUT;

	/**
     * The feature id for the '<em><b>Owner Typed Element</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_TYPE_DEFINITION__OWNER_TYPED_ELEMENT = ClassesPackage.TYPE_DEFINITION__OWNER_TYPED_ELEMENT;

	/**
     * The feature id for the '<em><b>Owner Signature</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_TYPE_DEFINITION__OWNER_SIGNATURE = ClassesPackage.TYPE_DEFINITION__OWNER_SIGNATURE;

	/**
     * The feature id for the '<em><b>Elements</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_TYPE_DEFINITION__ELEMENTS = ClassesPackage.TYPE_DEFINITION_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Tuple Type Definition</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_TYPE_DEFINITION_FEATURE_COUNT = ClassesPackage.TYPE_DEFINITION_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link data.tuples.impl.TupleElementImpl <em>Tuple Element</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.tuples.impl.TupleElementImpl
     * @see data.tuples.impl.TuplesPackageImpl#getTupleElement()
     * @generated
     */
	int TUPLE_ELEMENT = 1;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_ELEMENT__NAME = ModelmanagementPackage.NAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_ELEMENT__DESCRIPTION = ModelmanagementPackage.NAMED_ELEMENT__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_ELEMENT__OWNED_TYPE_DEFINITION = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Tuple Element</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_ELEMENT_FEATURE_COUNT = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;


	/**
     * Returns the meta object for class '{@link data.tuples.TupleTypeDefinition <em>Tuple Type Definition</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Tuple Type Definition</em>'.
     * @see data.tuples.TupleTypeDefinition
     * @generated
     */
	EClass getTupleTypeDefinition();

	/**
     * Returns the meta object for the containment reference list '{@link data.tuples.TupleTypeDefinition#getElements <em>Elements</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Elements</em>'.
     * @see data.tuples.TupleTypeDefinition#getElements()
     * @see #getTupleTypeDefinition()
     * @generated
     */
	EReference getTupleTypeDefinition_Elements();

	/**
     * Returns the meta object for class '{@link data.tuples.TupleElement <em>Tuple Element</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Tuple Element</em>'.
     * @see data.tuples.TupleElement
     * @generated
     */
	EClass getTupleElement();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	TuplesFactory getTuplesFactory();

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
         * The meta object literal for the '{@link data.tuples.impl.TupleTypeDefinitionImpl <em>Tuple Type Definition</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.tuples.impl.TupleTypeDefinitionImpl
         * @see data.tuples.impl.TuplesPackageImpl#getTupleTypeDefinition()
         * @generated
         */
		EClass TUPLE_TYPE_DEFINITION = eINSTANCE.getTupleTypeDefinition();

		/**
         * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference TUPLE_TYPE_DEFINITION__ELEMENTS = eINSTANCE.getTupleTypeDefinition_Elements();

		/**
         * The meta object literal for the '{@link data.tuples.impl.TupleElementImpl <em>Tuple Element</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.tuples.impl.TupleElementImpl
         * @see data.tuples.impl.TuplesPackageImpl#getTupleElement()
         * @generated
         */
		EClass TUPLE_ELEMENT = eINSTANCE.getTupleElement();

	}

} //TuplesPackage
