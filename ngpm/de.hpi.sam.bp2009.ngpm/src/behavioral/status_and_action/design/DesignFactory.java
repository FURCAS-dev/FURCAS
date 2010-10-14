/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.status_and_action.design;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see behavioral.status_and_action.design.DesignPackage
 * @generated
 */
public interface DesignFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	DesignFactory eINSTANCE = behavioral.status_and_action.design.impl.DesignFactoryImpl.init();

	/**
     * Returns a new object of class '<em>Business Object</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Business Object</em>'.
     * @generated
     */
	BusinessObject createBusinessObject();

	/**
     * Returns a new object of class '<em>Business Object Node</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Business Object Node</em>'.
     * @generated
     */
	BusinessObjectNode createBusinessObjectNode();

	/**
     * Returns a new object of class '<em>Status Variable</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Status Variable</em>'.
     * @generated
     */
	StatusVariable createStatusVariable();

	/**
     * Returns a new object of class '<em>Status Value</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Status Value</em>'.
     * @generated
     */
	StatusValue createStatusValue();

	/**
     * Returns a new object of class '<em>Action</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Action</em>'.
     * @generated
     */
	Action createAction();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	DesignPackage getDesignPackage();

} //DesignFactory
