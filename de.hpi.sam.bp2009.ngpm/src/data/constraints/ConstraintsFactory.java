/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.constraints;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see data.constraints.ConstraintsPackage
 * @generated
 */
public interface ConstraintsFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	ConstraintsFactory eINSTANCE = data.constraints.impl.ConstraintsFactoryImpl.init();

	/**
     * Returns a new object of class '<em>Constraint</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Constraint</em>'.
     * @generated
     */
	Constraint createConstraint();

	/**
     * Returns a new object of class '<em>Severity In State</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Severity In State</em>'.
     * @generated
     */
	SeverityInState createSeverityInState();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	ConstraintsPackage getConstraintsPackage();

} //ConstraintsFactory
