/**
 * <copyright>
 * </copyright>
 *
 * $Id: TimedependencyFactory.java,v 1.1 2011/02/07 17:18:47 auhl Exp $
 */
package data.timedependency;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see data.timedependency.TimedependencyPackage
 * @generated
 */
public interface TimedependencyFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	TimedependencyFactory eINSTANCE = data.timedependency.impl.TimedependencyFactoryImpl.init();

	/**
     * Returns a new object of class '<em>Time Dependency</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Time Dependency</em>'.
     * @generated
     */
	TimeDependency createTimeDependency();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	TimedependencyPackage getTimedependencyPackage();

} //TimedependencyFactory
