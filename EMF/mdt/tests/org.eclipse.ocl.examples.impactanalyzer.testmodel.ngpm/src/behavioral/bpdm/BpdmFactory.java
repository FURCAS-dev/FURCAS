/**
 * <copyright>
 * </copyright>
 *
 * $Id: BpdmFactory.java,v 1.1 2011/02/07 17:17:58 auhl Exp $
 */
package behavioral.bpdm;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see behavioral.bpdm.BpdmPackage
 * @generated
 */
public interface BpdmFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	BpdmFactory eINSTANCE = behavioral.bpdm.impl.BpdmFactoryImpl.init();

	/**
     * Returns a new object of class '<em>Dummy</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Dummy</em>'.
     * @generated
     */
	Dummy createDummy();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	BpdmPackage getBpdmPackage();

} //BpdmFactory
