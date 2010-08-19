/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.actions;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see behavioral.actions.ActionsPackage
 * @generated
 */
public interface ActionsFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	ActionsFactory eINSTANCE = behavioral.actions.impl.ActionsFactoryImpl.init();

	/**
     * Returns a new object of class '<em>Assignment</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Assignment</em>'.
     * @generated
     */
	Assignment createAssignment();

	/**
     * Returns a new object of class '<em>Block</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Block</em>'.
     * @generated
     */
	Block createBlock();

	/**
     * Returns a new object of class '<em>If Else</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>If Else</em>'.
     * @generated
     */
	IfElse createIfElse();

	/**
     * Returns a new object of class '<em>While Loop</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>While Loop</em>'.
     * @generated
     */
	WhileLoop createWhileLoop();

	/**
     * Returns a new object of class '<em>Foreach</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Foreach</em>'.
     * @generated
     */
	Foreach createForeach();

	/**
     * Returns a new object of class '<em>Return</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Return</em>'.
     * @generated
     */
	Return createReturn();

	/**
     * Returns a new object of class '<em>Add Link</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Add Link</em>'.
     * @generated
     */
	AddLink createAddLink();

	/**
     * Returns a new object of class '<em>Remove Link</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Remove Link</em>'.
     * @generated
     */
	RemoveLink createRemoveLink();

	/**
     * Returns a new object of class '<em>Expression Statement</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Expression Statement</em>'.
     * @generated
     */
	ExpressionStatement createExpressionStatement();

	/**
     * Returns a new object of class '<em>Sort</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Sort</em>'.
     * @generated
     */
	Sort createSort();

	/**
     * Returns a new object of class '<em>Query Invocation</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Query Invocation</em>'.
     * @generated
     */
	QueryInvocation createQueryInvocation();

	/**
     * Returns a new object of class '<em>Constant</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Constant</em>'.
     * @generated
     */
	Constant createConstant();

	/**
     * Returns a new object of class '<em>Variable</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Variable</em>'.
     * @generated
     */
	Variable createVariable();

	/**
     * Returns a new object of class '<em>Iterator</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Iterator</em>'.
     * @generated
     */
	Iterator createIterator();

	/**
     * Returns a new object of class '<em>Named Value Declaration</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Named Value Declaration</em>'.
     * @generated
     */
	NamedValueDeclaration createNamedValueDeclaration();

	/**
     * Returns a new object of class '<em>Statement With Nested Blocks</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Statement With Nested Blocks</em>'.
     * @generated
     */
	StatementWithNestedBlocks createStatementWithNestedBlocks();

	/**
     * Returns a new object of class '<em>Single Block Statement</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Single Block Statement</em>'.
     * @generated
     */
	SingleBlockStatement createSingleBlockStatement();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	ActionsPackage getActionsPackage();

} //ActionsFactory
