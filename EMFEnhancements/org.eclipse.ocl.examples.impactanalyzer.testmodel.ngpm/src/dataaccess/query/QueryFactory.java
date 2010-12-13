/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.query;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see dataaccess.query.QueryPackage
 * @generated
 */
public interface QueryFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	QueryFactory eINSTANCE = dataaccess.query.impl.QueryFactoryImpl.init();

	/**
     * Returns a new object of class '<em>Selection</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Selection</em>'.
     * @generated
     */
	Selection createSelection();

	/**
     * Returns a new object of class '<em>Oql Query</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Oql Query</em>'.
     * @generated
     */
	OqlQuery createOqlQuery();

	/**
     * Returns a new object of class '<em>From Clause</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>From Clause</em>'.
     * @generated
     */
	FromClause createFromClause();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	QueryPackage getQueryPackage();

} //QueryFactory
