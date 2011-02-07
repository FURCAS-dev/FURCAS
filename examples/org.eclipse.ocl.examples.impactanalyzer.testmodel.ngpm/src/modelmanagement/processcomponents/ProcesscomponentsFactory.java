/**
 * <copyright>
 * </copyright>
 *
 * $Id: ProcesscomponentsFactory.java,v 1.1 2011/02/07 16:43:30 auhl Exp $
 */
package modelmanagement.processcomponents;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see modelmanagement.processcomponents.ProcesscomponentsPackage
 * @generated
 */
public interface ProcesscomponentsFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	ProcesscomponentsFactory eINSTANCE = modelmanagement.processcomponents.impl.ProcesscomponentsFactoryImpl.init();

	/**
     * Returns a new object of class '<em>Process Component Inside Company</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Process Component Inside Company</em>'.
     * @generated
     */
	ProcessComponentInsideCompany createProcessComponentInsideCompany();

	/**
     * Returns a new object of class '<em>Process Component Outside Company</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Process Component Outside Company</em>'.
     * @generated
     */
	ProcessComponentOutsideCompany createProcessComponentOutsideCompany();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	ProcesscomponentsPackage getProcesscomponentsPackage();

} //ProcesscomponentsFactory
