/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.scopeProvider;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scope Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getInitialProjects <em>Initial Projects</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProviderPackage#getScopeProvider()
 * @model
 * @generated
 */
public interface ScopeProvider extends EObject {
	/**
	 * Returns the value of the '<em><b>Initial Projects</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.core.resources.IProject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Projects</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Projects</em>' attribute list.
	 * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProviderPackage#getScopeProvider_InitialProjects()
	 * @model dataType="de.hpi.sam.bp2009.solution.scopeProvider.IProject" required="true" ordered="false"
	 * @generated
	 */
	EList<IProject> getInitialProjects();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model initialObjectsRequired="true" initialObjectsMany="true"
	 * @generated
	 */
	void setupForEObjects(EList<EObject> initialObjects);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model initialResourcesRequired="true" initialResourcesMany="true"
	 * @generated
	 */
	void setupForResources(EList<Resource> initialResources);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model initialResourceSetsRequired="true" initialResourceSetsMany="true"
	 * @generated
	 */
	void setupForResourceSets(EList<ResourceSet> initialResourceSets);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<Resource> getForwardScopeAsResources();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<EObject> getForwardScopeAsEObjects();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="de.hpi.sam.bp2009.solution.scopeProvider.IProject"
	 * @generated
	 */
	EList<IProject> getForwardScopeAsProjects();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="de.hpi.sam.bp2009.solution.scopeProvider.URI"
	 * @generated
	 */
	EList<URI> getForwardScopeAsURIs();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<Resource> getBackwardScopeAsResources();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<EObject> getBackwardScopeAsEObjects();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="de.hpi.sam.bp2009.solution.scopeProvider.IProject"
	 * @generated
	 */
	EList<IProject> getBackwardScopeAsProjects();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="de.hpi.sam.bp2009.solution.scopeProvider.URI"
	 * @generated
	 */
	EList<URI> getBackwardScopeAsURIs();

} // ScopeProvider
