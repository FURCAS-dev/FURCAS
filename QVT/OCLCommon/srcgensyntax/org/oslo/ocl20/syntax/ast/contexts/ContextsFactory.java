/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.contexts;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.oslo.ocl20.syntax.ast.contexts.ContextsPackage
 * @generated
 */
public interface ContextsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ContextsFactory eINSTANCE = org.oslo.ocl20.syntax.ast.contexts.impl.ContextsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Classifier Context Decl AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Classifier Context Decl AS</em>'.
	 * @generated
	 */
	ClassifierContextDeclAS createClassifierContextDeclAS();

	/**
	 * Returns a new object of class '<em>Constraint AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constraint AS</em>'.
	 * @generated
	 */
	ConstraintAS createConstraintAS();

	/**
	 * Returns a new object of class '<em>Context Declaration AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Context Declaration AS</em>'.
	 * @generated
	 */
	ContextDeclarationAS createContextDeclarationAS();

	/**
	 * Returns a new object of class '<em>Operation AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation AS</em>'.
	 * @generated
	 */
	OperationAS createOperationAS();

	/**
	 * Returns a new object of class '<em>Operation Context Decl AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation Context Decl AS</em>'.
	 * @generated
	 */
	OperationContextDeclAS createOperationContextDeclAS();

	/**
	 * Returns a new object of class '<em>Package Declaration AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Package Declaration AS</em>'.
	 * @generated
	 */
	PackageDeclarationAS createPackageDeclarationAS();

	/**
	 * Returns a new object of class '<em>Property Context Decl AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Context Decl AS</em>'.
	 * @generated
	 */
	PropertyContextDeclAS createPropertyContextDeclAS();

	/**
	 * Returns a new object of class '<em>Variable Declaration AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Declaration AS</em>'.
	 * @generated
	 */
	VariableDeclarationAS createVariableDeclarationAS();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ContextsPackage getContextsPackage();

} //ContextsFactory
