/**
 * <copyright>
 * </copyright>
 *
 * $Id: RulesFactory.java,v 1.1 2011/02/07 16:47:39 auhl Exp $
 */
package behavioral.rules;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see behavioral.rules.RulesPackage
 * @generated
 */
public interface RulesFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	RulesFactory eINSTANCE = behavioral.rules.impl.RulesFactoryImpl.init();

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
	RulesPackage getRulesPackage();

} //RulesFactory
