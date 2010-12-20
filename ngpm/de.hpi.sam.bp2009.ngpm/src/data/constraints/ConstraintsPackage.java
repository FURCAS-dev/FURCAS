/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.constraints;

import modelmanagement.ModelmanagementPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * <!-- begin-model-doc -->
 * Complex data types (as opposed to the basic data types that are plain CCTS types)
 * <!-- end-model-doc -->
 * @see data.constraints.ConstraintsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface ConstraintsPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "constraints";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/data/constraints.ecore";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "data.constraints";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	ConstraintsPackage eINSTANCE = data.constraints.impl.ConstraintsPackageImpl.init();

	/**
     * The meta object id for the '{@link data.constraints.impl.ConstraintImpl <em>Constraint</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.constraints.impl.ConstraintImpl
     * @see data.constraints.impl.ConstraintsPackageImpl#getConstraint()
     * @generated
     */
	int CONSTRAINT = 0;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONSTRAINT__NAME = ModelmanagementPackage.NAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONSTRAINT__DESCRIPTION = ModelmanagementPackage.NAMED_ELEMENT__DESCRIPTION;

	/**
     * The feature id for the '<em><b>The Context</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONSTRAINT__THE_CONTEXT = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Constrained Type</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONSTRAINT__CONSTRAINED_TYPE = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Severity In State</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONSTRAINT__SEVERITY_IN_STATE = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Constraint Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONSTRAINT__CONSTRAINT_EXPRESSION = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
     * The number of structural features of the '<em>Constraint</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONSTRAINT_FEATURE_COUNT = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
     * The meta object id for the '{@link data.constraints.impl.SeverityInStateImpl <em>Severity In State</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.constraints.impl.SeverityInStateImpl
     * @see data.constraints.impl.ConstraintsPackageImpl#getSeverityInState()
     * @generated
     */
	int SEVERITY_IN_STATE = 1;

	/**
     * The feature id for the '<em><b>State</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SEVERITY_IN_STATE__STATE = 0;

	/**
     * The feature id for the '<em><b>Severity</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SEVERITY_IN_STATE__SEVERITY = 1;

	/**
     * The number of structural features of the '<em>Severity In State</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SEVERITY_IN_STATE_FEATURE_COUNT = 2;

	/**
     * The meta object id for the '{@link data.constraints.ObjectState <em>Object State</em>}' enum.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.constraints.ObjectState
     * @see data.constraints.impl.ConstraintsPackageImpl#getObjectState()
     * @generated
     */
	int OBJECT_STATE = 2;

	/**
     * The meta object id for the '{@link data.constraints.Severity <em>Severity</em>}' enum.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.constraints.Severity
     * @see data.constraints.impl.ConstraintsPackageImpl#getSeverity()
     * @generated
     */
	int SEVERITY = 3;


	/**
     * Returns the meta object for class '{@link data.constraints.Constraint <em>Constraint</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Constraint</em>'.
     * @see data.constraints.Constraint
     * @generated
     */
	EClass getConstraint();

	/**
     * Returns the meta object for the container reference '{@link data.constraints.Constraint#getTheContext <em>The Context</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>The Context</em>'.
     * @see data.constraints.Constraint#getTheContext()
     * @see #getConstraint()
     * @generated
     */
	EReference getConstraint_TheContext();

	/**
     * Returns the meta object for the container reference '{@link data.constraints.Constraint#getConstrainedType <em>Constrained Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Constrained Type</em>'.
     * @see data.constraints.Constraint#getConstrainedType()
     * @see #getConstraint()
     * @generated
     */
	EReference getConstraint_ConstrainedType();

	/**
     * Returns the meta object for the containment reference list '{@link data.constraints.Constraint#getSeverityInState <em>Severity In State</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Severity In State</em>'.
     * @see data.constraints.Constraint#getSeverityInState()
     * @see #getConstraint()
     * @generated
     */
	EReference getConstraint_SeverityInState();

	/**
     * Returns the meta object for the containment reference '{@link data.constraints.Constraint#getConstraintExpression <em>Constraint Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Constraint Expression</em>'.
     * @see data.constraints.Constraint#getConstraintExpression()
     * @see #getConstraint()
     * @generated
     */
	EReference getConstraint_ConstraintExpression();

	/**
     * Returns the meta object for class '{@link data.constraints.SeverityInState <em>Severity In State</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Severity In State</em>'.
     * @see data.constraints.SeverityInState
     * @generated
     */
	EClass getSeverityInState();

	/**
     * Returns the meta object for the attribute '{@link data.constraints.SeverityInState#getState <em>State</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>State</em>'.
     * @see data.constraints.SeverityInState#getState()
     * @see #getSeverityInState()
     * @generated
     */
	EAttribute getSeverityInState_State();

	/**
     * Returns the meta object for the attribute '{@link data.constraints.SeverityInState#getSeverity <em>Severity</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Severity</em>'.
     * @see data.constraints.SeverityInState#getSeverity()
     * @see #getSeverityInState()
     * @generated
     */
	EAttribute getSeverityInState_Severity();

	/**
     * Returns the meta object for enum '{@link data.constraints.ObjectState <em>Object State</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Object State</em>'.
     * @see data.constraints.ObjectState
     * @generated
     */
	EEnum getObjectState();

	/**
     * Returns the meta object for enum '{@link data.constraints.Severity <em>Severity</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Severity</em>'.
     * @see data.constraints.Severity
     * @generated
     */
	EEnum getSeverity();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	ConstraintsFactory getConstraintsFactory();

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
         * The meta object literal for the '{@link data.constraints.impl.ConstraintImpl <em>Constraint</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.constraints.impl.ConstraintImpl
         * @see data.constraints.impl.ConstraintsPackageImpl#getConstraint()
         * @generated
         */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
         * The meta object literal for the '<em><b>The Context</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CONSTRAINT__THE_CONTEXT = eINSTANCE.getConstraint_TheContext();

		/**
         * The meta object literal for the '<em><b>Constrained Type</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CONSTRAINT__CONSTRAINED_TYPE = eINSTANCE.getConstraint_ConstrainedType();

		/**
         * The meta object literal for the '<em><b>Severity In State</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CONSTRAINT__SEVERITY_IN_STATE = eINSTANCE.getConstraint_SeverityInState();

		/**
         * The meta object literal for the '<em><b>Constraint Expression</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CONSTRAINT__CONSTRAINT_EXPRESSION = eINSTANCE.getConstraint_ConstraintExpression();

		/**
         * The meta object literal for the '{@link data.constraints.impl.SeverityInStateImpl <em>Severity In State</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.constraints.impl.SeverityInStateImpl
         * @see data.constraints.impl.ConstraintsPackageImpl#getSeverityInState()
         * @generated
         */
		EClass SEVERITY_IN_STATE = eINSTANCE.getSeverityInState();

		/**
         * The meta object literal for the '<em><b>State</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute SEVERITY_IN_STATE__STATE = eINSTANCE.getSeverityInState_State();

		/**
         * The meta object literal for the '<em><b>Severity</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute SEVERITY_IN_STATE__SEVERITY = eINSTANCE.getSeverityInState_Severity();

		/**
         * The meta object literal for the '{@link data.constraints.ObjectState <em>Object State</em>}' enum.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.constraints.ObjectState
         * @see data.constraints.impl.ConstraintsPackageImpl#getObjectState()
         * @generated
         */
		EEnum OBJECT_STATE = eINSTANCE.getObjectState();

		/**
         * The meta object literal for the '{@link data.constraints.Severity <em>Severity</em>}' enum.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.constraints.Severity
         * @see data.constraints.impl.ConstraintsPackageImpl#getSeverity()
         * @generated
         */
		EEnum SEVERITY = eINSTANCE.getSeverity();

	}

} //ConstraintsPackage
