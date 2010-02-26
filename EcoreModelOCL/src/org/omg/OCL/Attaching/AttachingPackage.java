/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.Attaching;

import com.sap.tc.moin.repository.mmi.Model.ModelPackage;

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
 * @see org.omg.OCL.Attaching.AttachingFactory
 * @model kind="package"
 * @generated
 */
public interface AttachingPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Attaching";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/OCL/Attaching";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "attaching";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AttachingPackage eINSTANCE = org.omg.OCL.Attaching.impl.AttachingPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.omg.OCL.Attaching.impl.OclConstraintImpl <em>Ocl Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.OCL.Attaching.impl.OclConstraintImpl
	 * @see org.omg.OCL.Attaching.impl.AttachingPackageImpl#getOclConstraint()
	 * @generated
	 */
	int OCL_CONSTRAINT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_CONSTRAINT__NAME = ModelPackage.CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_CONSTRAINT__QUALIFIED_NAME = ModelPackage.CONSTRAINT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_CONSTRAINT__ANNOTATION = ModelPackage.CONSTRAINT__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Required Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_CONSTRAINT__REQUIRED_ELEMENTS = ModelPackage.CONSTRAINT__REQUIRED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_CONSTRAINT__CONTAINER = ModelPackage.CONSTRAINT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_CONSTRAINT__CONSTRAINTS = ModelPackage.CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_CONSTRAINT__EXPRESSION = ModelPackage.CONSTRAINT__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_CONSTRAINT__LANGUAGE = ModelPackage.CONSTRAINT__LANGUAGE;

	/**
	 * The feature id for the '<em><b>Evaluation Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_CONSTRAINT__EVALUATION_POLICY = ModelPackage.CONSTRAINT__EVALUATION_POLICY;

	/**
	 * The feature id for the '<em><b>Constrained Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_CONSTRAINT__CONSTRAINED_ELEMENTS = ModelPackage.CONSTRAINT__CONSTRAINED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Ocl Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_CONSTRAINT__OCL_EXPRESSION = ModelPackage.CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Invariant Of</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_CONSTRAINT__INVARIANT_OF = ModelPackage.CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Precondition For</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_CONSTRAINT__PRECONDITION_FOR = ModelPackage.CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Postcondition For</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_CONSTRAINT__POSTCONDITION_FOR = ModelPackage.CONSTRAINT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Violation Message Expression</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_CONSTRAINT__VIOLATION_MESSAGE_EXPRESSION = ModelPackage.CONSTRAINT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Initialized Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_CONSTRAINT__INITIALIZED_ATTRIBUTE = ModelPackage.CONSTRAINT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Initialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_CONSTRAINT__INITIALIZED_ELEMENT = ModelPackage.CONSTRAINT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Ocl Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_CONSTRAINT_FEATURE_COUNT = ModelPackage.CONSTRAINT_FEATURE_COUNT + 7;


	/**
	 * Returns the meta object for class '{@link org.omg.OCL.Attaching.OclConstraint <em>Ocl Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ocl Constraint</em>'.
	 * @see org.omg.OCL.Attaching.OclConstraint
	 * @generated
	 */
	EClass getOclConstraint();

	/**
	 * Returns the meta object for the containment reference '{@link org.omg.OCL.Attaching.OclConstraint#getOclExpression <em>Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ocl Expression</em>'.
	 * @see org.omg.OCL.Attaching.OclConstraint#getOclExpression()
	 * @see #getOclConstraint()
	 * @generated
	 */
	EReference getOclConstraint_OclExpression();

	/**
	 * Returns the meta object for the reference list '{@link org.omg.OCL.Attaching.OclConstraint#getInvariantOf <em>Invariant Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Invariant Of</em>'.
	 * @see org.omg.OCL.Attaching.OclConstraint#getInvariantOf()
	 * @see #getOclConstraint()
	 * @generated
	 */
	EReference getOclConstraint_InvariantOf();

	/**
	 * Returns the meta object for the reference list '{@link org.omg.OCL.Attaching.OclConstraint#getPreconditionFor <em>Precondition For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Precondition For</em>'.
	 * @see org.omg.OCL.Attaching.OclConstraint#getPreconditionFor()
	 * @see #getOclConstraint()
	 * @generated
	 */
	EReference getOclConstraint_PreconditionFor();

	/**
	 * Returns the meta object for the reference list '{@link org.omg.OCL.Attaching.OclConstraint#getPostconditionFor <em>Postcondition For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Postcondition For</em>'.
	 * @see org.omg.OCL.Attaching.OclConstraint#getPostconditionFor()
	 * @see #getOclConstraint()
	 * @generated
	 */
	EReference getOclConstraint_PostconditionFor();

	/**
	 * Returns the meta object for the reference list '{@link org.omg.OCL.Attaching.OclConstraint#getViolationMessageExpression <em>Violation Message Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Violation Message Expression</em>'.
	 * @see org.omg.OCL.Attaching.OclConstraint#getViolationMessageExpression()
	 * @see #getOclConstraint()
	 * @generated
	 */
	EReference getOclConstraint_ViolationMessageExpression();

	/**
	 * Returns the meta object for the reference '{@link org.omg.OCL.Attaching.OclConstraint#getInitializedAttribute <em>Initialized Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Initialized Attribute</em>'.
	 * @see org.omg.OCL.Attaching.OclConstraint#getInitializedAttribute()
	 * @see #getOclConstraint()
	 * @generated
	 */
	EReference getOclConstraint_InitializedAttribute();

	/**
	 * Returns the meta object for the reference '{@link org.omg.OCL.Attaching.OclConstraint#getInitializedElement <em>Initialized Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Initialized Element</em>'.
	 * @see org.omg.OCL.Attaching.OclConstraint#getInitializedElement()
	 * @see #getOclConstraint()
	 * @generated
	 */
	EReference getOclConstraint_InitializedElement();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AttachingFactory getAttachingFactory();

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
		 * The meta object literal for the '{@link org.omg.OCL.Attaching.impl.OclConstraintImpl <em>Ocl Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.OCL.Attaching.impl.OclConstraintImpl
		 * @see org.omg.OCL.Attaching.impl.AttachingPackageImpl#getOclConstraint()
		 * @generated
		 */
		EClass OCL_CONSTRAINT = eINSTANCE.getOclConstraint();

		/**
		 * The meta object literal for the '<em><b>Ocl Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OCL_CONSTRAINT__OCL_EXPRESSION = eINSTANCE.getOclConstraint_OclExpression();

		/**
		 * The meta object literal for the '<em><b>Invariant Of</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OCL_CONSTRAINT__INVARIANT_OF = eINSTANCE.getOclConstraint_InvariantOf();

		/**
		 * The meta object literal for the '<em><b>Precondition For</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OCL_CONSTRAINT__PRECONDITION_FOR = eINSTANCE.getOclConstraint_PreconditionFor();

		/**
		 * The meta object literal for the '<em><b>Postcondition For</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OCL_CONSTRAINT__POSTCONDITION_FOR = eINSTANCE.getOclConstraint_PostconditionFor();

		/**
		 * The meta object literal for the '<em><b>Violation Message Expression</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OCL_CONSTRAINT__VIOLATION_MESSAGE_EXPRESSION = eINSTANCE.getOclConstraint_ViolationMessageExpression();

		/**
		 * The meta object literal for the '<em><b>Initialized Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OCL_CONSTRAINT__INITIALIZED_ATTRIBUTE = eINSTANCE.getOclConstraint_InitializedAttribute();

		/**
		 * The meta object literal for the '<em><b>Initialized Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OCL_CONSTRAINT__INITIALIZED_ELEMENT = eINSTANCE.getOclConstraint_InitializedElement();

	}

} //AttachingPackage
