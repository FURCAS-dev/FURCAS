/**
 * <copyright>
 * </copyright>
 *
 * $Id: TransactionsFactory.java,v 1.1 2011/02/07 17:17:58 auhl Exp $
 */
package behavioral.transactions;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see behavioral.transactions.TransactionsPackage
 * @generated
 */
public interface TransactionsFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	TransactionsFactory eINSTANCE = behavioral.transactions.impl.TransactionsFactoryImpl.init();

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
	TransactionsPackage getTransactionsPackage();

} //TransactionsFactory
