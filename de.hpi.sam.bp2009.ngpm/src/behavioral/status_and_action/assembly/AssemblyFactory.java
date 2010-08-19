/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.status_and_action.assembly;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see behavioral.status_and_action.assembly.AssemblyPackage
 * @generated
 */
public interface AssemblyFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	AssemblyFactory eINSTANCE = behavioral.status_and_action.assembly.impl.AssemblyFactoryImpl.init();

	/**
     * Returns a new object of class '<em>Status Schema</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Status Schema</em>'.
     * @generated
     */
	StatusSchema createStatusSchema();

	/**
     * Returns a new object of class '<em>Operator</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Operator</em>'.
     * @generated
     */
	Operator createOperator();

	/**
     * Returns a new object of class '<em>Action Proxy</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Action Proxy</em>'.
     * @generated
     */
	ActionProxy createActionProxy();

	/**
     * Returns a new object of class '<em>Status Value Proxy</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Status Value Proxy</em>'.
     * @generated
     */
	StatusValueProxy createStatusValueProxy();

	/**
     * Returns a new object of class '<em>Transition</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Transition</em>'.
     * @generated
     */
	Transition createTransition();

	/**
     * Returns a new object of class '<em>Synchroniser</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Synchroniser</em>'.
     * @generated
     */
	Synchroniser createSynchroniser();

	/**
     * Returns a new object of class '<em>Precondition</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Precondition</em>'.
     * @generated
     */
	Precondition createPrecondition();

	/**
     * Returns a new object of class '<em>Status Variable Proxy</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Status Variable Proxy</em>'.
     * @generated
     */
	StatusVariableProxy createStatusVariableProxy();

	/**
     * Returns a new object of class '<em>And Operator</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>And Operator</em>'.
     * @generated
     */
	AndOperator createAndOperator();

	/**
     * Returns a new object of class '<em>Or Operator</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Or Operator</em>'.
     * @generated
     */
	OrOperator createOrOperator();

	/**
     * Returns a new object of class '<em>Required Strategy</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Required Strategy</em>'.
     * @generated
     */
	RequiredStrategy createRequiredStrategy();

	/**
     * Returns a new object of class '<em>Neutral Strategy</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Neutral Strategy</em>'.
     * @generated
     */
	NeutralStrategy createNeutralStrategy();

	/**
     * Returns a new object of class '<em>Enabling Strategy</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Enabling Strategy</em>'.
     * @generated
     */
	EnablingStrategy createEnablingStrategy();

	/**
     * Returns a new object of class '<em>Inhibiting Strategy</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Inhibiting Strategy</em>'.
     * @generated
     */
	InhibitingStrategy createInhibitingStrategy();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	AssemblyPackage getAssemblyPackage();

} //AssemblyFactory
