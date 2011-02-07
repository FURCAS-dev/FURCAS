/**
 * <copyright>
 * </copyright>
 *
 * $Id: BusinesstasksFactory.java,v 1.1 2011/02/07 16:47:39 auhl Exp $
 */
package behavioral.businesstasks;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see behavioral.businesstasks.BusinesstasksPackage
 * @generated
 */
public interface BusinesstasksFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	BusinesstasksFactory eINSTANCE = behavioral.businesstasks.impl.BusinesstasksFactoryImpl.init();

	/**
     * Returns a new object of class '<em>Task Agent</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Task Agent</em>'.
     * @generated
     */
	TaskAgent createTaskAgent();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	BusinesstasksPackage getBusinesstasksPackage();

} //BusinesstasksFactory
