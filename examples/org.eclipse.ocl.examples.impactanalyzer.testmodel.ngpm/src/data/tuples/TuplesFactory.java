/**
 * <copyright>
 * </copyright>
 *
 * $Id: TuplesFactory.java,v 1.1 2011/02/07 16:43:32 auhl Exp $
 */
package data.tuples;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see data.tuples.TuplesPackage
 * @generated
 */
public interface TuplesFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	TuplesFactory eINSTANCE = data.tuples.impl.TuplesFactoryImpl.init();

	/**
     * Returns a new object of class '<em>Tuple Type Definition</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Tuple Type Definition</em>'.
     * @generated
     */
	TupleTypeDefinition createTupleTypeDefinition();

	/**
     * Returns a new object of class '<em>Tuple Element</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Tuple Element</em>'.
     * @generated
     */
	TupleElement createTupleElement();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	TuplesPackage getTuplesPackage();

} //TuplesFactory
