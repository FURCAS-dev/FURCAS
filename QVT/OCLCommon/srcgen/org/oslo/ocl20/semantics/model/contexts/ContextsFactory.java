/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.contexts;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see org.oslo.ocl20.semantics.model.contexts.ContextsPackage
 * @generated
 */
public interface ContextsFactory extends EFactory {
	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	ContextsFactory eINSTANCE = org.oslo.ocl20.semantics.model.contexts.impl.ContextsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Classifier Context Decl</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Classifier Context Decl</em>'.
	 * @generated
	 */
	ClassifierContextDecl createClassifierContextDecl();

	/**
	 * Returns a new object of class '<em>Constraint</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Constraint</em>'.
	 * @generated
	 */
	Constraint createConstraint();

	/**
	 * Returns a new object of class '<em>Context Declaration</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Context Declaration</em>'.
	 * @generated
	 */
	ContextDeclaration createContextDeclaration();

	/**
	 * Returns a new object of class '<em>Defined Operation</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Defined Operation</em>'.
	 * @generated
	 */
	DefinedOperation createDefinedOperation();

	/**
	 * Returns a new object of class '<em>Defined Property</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Defined Property</em>'.
	 * @generated
	 */
	DefinedProperty createDefinedProperty();

	/**
	 * Returns a new object of class '<em>Operation Context Decl</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Operation Context Decl</em>'.
	 * @generated
	 */
	OperationContextDecl createOperationContextDecl();

	/**
	 * Returns a new object of class '<em>Property Context Decl</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Property Context Decl</em>'.
	 * @generated
	 */
	PropertyContextDecl createPropertyContextDecl();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	ContextsPackage getContextsPackage();

} // ContextsFactory
