/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.textblocks;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.sap.furcas.metamodel.textblocks.TextblocksPackage
 * @generated
 */
public interface TextblocksFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TextblocksFactory eINSTANCE = com.sap.furcas.metamodel.textblocks.impl.TextblocksFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Omitted Token</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Omitted Token</em>'.
	 * @generated
	 */
	OmittedToken createOmittedToken();

	/**
	 * Returns a new object of class '<em>Lexed Token</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lexed Token</em>'.
	 * @generated
	 */
	LexedToken createLexedToken();

	/**
	 * Returns a new object of class '<em>Unlexed Token</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unlexed Token</em>'.
	 * @generated
	 */
	UnlexedToken createUnlexedToken();

	/**
	 * Returns a new object of class '<em>For Each Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>For Each Context</em>'.
	 * @generated
	 */
	ForEachContext createForEachContext();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TextblocksPackage getTextblocksPackage();

} //TextblocksFactory
