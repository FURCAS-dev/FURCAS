/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions.fp;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see dataaccess.expressions.fp.FpPackage
 * @generated
 */
public interface FpFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	FpFactory eINSTANCE = dataaccess.expressions.fp.impl.FpFactoryImpl.init();

	/**
     * Returns a new object of class '<em>Anonymous Function Expr</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Anonymous Function Expr</em>'.
     * @generated
     */
	AnonymousFunctionExpr createAnonymousFunctionExpr();

	/**
     * Returns a new object of class '<em>Function From Method Expr</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Function From Method Expr</em>'.
     * @generated
     */
	FunctionFromMethodExpr createFunctionFromMethodExpr();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	FpPackage getFpPackage();

} //FpFactory
