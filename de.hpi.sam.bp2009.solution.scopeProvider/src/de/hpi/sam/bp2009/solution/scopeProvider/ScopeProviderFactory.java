/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.scopeProvider;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProviderPackage
 * @generated
 */
public interface ScopeProviderFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ScopeProviderFactory eINSTANCE = de.hpi.sam.bp2009.solution.scopeProvider.impl.ScopeProviderFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Project Based Scope Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Project Based Scope Provider</em>'.
	 * @generated
	 */
	ProjectBasedScopeProvider createProjectBasedScopeProvider();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ScopeProviderPackage getScopeProviderPackage();

} //ScopeProviderFactory
