/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.scopeProvider;

import java.util.Collection;

import org.eclipse.core.resources.IProject;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * Implementation of the ScopeProvider, identifies Forward and BackwardScope via EclipseProject references
 */
public interface ProjectBasedScopeProvider extends ScopeProvider {
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
	 */
	Collection<IProject> getInitialProjects();
	/**
	 * ScopeProvider tries to load all resources from the referenced projects with an XMIResourceImpl.
	 * Attention: No instance equality provided, when resources are not in the inMemory list.
	 */
	Collection<EObject> getForwardScopeAsEObjects();
	Collection<IProject> getForwardScopeAsProjects();
	Collection<Resource> getForwardScopeAsResources();
	Collection<URI> getForwardScopeAsURIs();
	Collection<EObject> getBackwardScopeAsEObjects();
	Collection<IProject> getBackwardScopeAsProjects();
	Collection<Resource> getBackwardScopeAsResources();
	Collection<URI> getBackwardScopeAsURIs();

} // ProjectBasedScopeProvider
