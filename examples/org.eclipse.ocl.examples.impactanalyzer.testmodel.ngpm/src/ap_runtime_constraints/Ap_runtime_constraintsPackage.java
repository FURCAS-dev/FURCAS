/**
 * <copyright>
 * </copyright>
 *
 * $Id: Ap_runtime_constraintsPackage.java,v 1.1 2011/02/07 16:47:04 auhl Exp $
 */
package ap_runtime_constraints;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see ap_runtime_constraints.Ap_runtime_constraintsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface Ap_runtime_constraintsPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "ap_runtime_constraints";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/ap_runtime_constraints.ecore";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "ap_runtime_constraints";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	Ap_runtime_constraintsPackage eINSTANCE = ap_runtime_constraints.impl.Ap_runtime_constraintsPackageImpl.init();

	/**
     * The meta object id for the '{@link ap_runtime_constraints.impl.QueryConstraintImpl <em>Query Constraint</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see ap_runtime_constraints.impl.QueryConstraintImpl
     * @see ap_runtime_constraints.impl.Ap_runtime_constraintsPackageImpl#getQueryConstraint()
     * @generated
     */
	int QUERY_CONSTRAINT = 0;

	/**
     * The number of structural features of the '<em>Query Constraint</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY_CONSTRAINT_FEATURE_COUNT = 0;


	/**
     * Returns the meta object for class '{@link ap_runtime_constraints.QueryConstraint <em>Query Constraint</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Query Constraint</em>'.
     * @see ap_runtime_constraints.QueryConstraint
     * @generated
     */
	EClass getQueryConstraint();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	Ap_runtime_constraintsFactory getAp_runtime_constraintsFactory();

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
         * The meta object literal for the '{@link ap_runtime_constraints.impl.QueryConstraintImpl <em>Query Constraint</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see ap_runtime_constraints.impl.QueryConstraintImpl
         * @see ap_runtime_constraints.impl.Ap_runtime_constraintsPackageImpl#getQueryConstraint()
         * @generated
         */
		EClass QUERY_CONSTRAINT = eINSTANCE.getQueryConstraint();

	}

} //Ap_runtime_constraintsPackage
