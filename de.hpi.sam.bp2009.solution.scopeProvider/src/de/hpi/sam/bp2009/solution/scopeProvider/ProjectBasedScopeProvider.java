/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.scopeProvider;

import java.util.Collection;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Extends {@link ScopeProvider} by operations that define visible scope and scope from where the
 * "point" repsetented by the scope provider can be seen, as {@link IProject}s. This is a particularly nice
 * match in case Eclipse project references are used to encode a simple set of visibility rules.
 */
public interface ProjectBasedScopeProvider extends ScopeProvider {
    /**
     * Returns the value of the '<em><b>Initial Projects</b></em>' attribute list. The list contents are of type {@link IProject}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Initial Projects</em>' attribute list isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Initial Projects</em>' attribute list.
     */
    Collection<IProject> getInitialProjects();

    /**
     * Returns the value of the '<em><b>InMemory Resources</b></em>' attribute list. The list contents are of type
     * {@link Resource}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>InMemory Resources</em>' attribute list isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>InMemory Resources</em>' attribute list.
     */
    Collection<Resource> getInMemoryResources();

    /**
     * Returns the value of the '<em><b>Forward Scope as Projects</b></em>' attribute list. The list contents are of type
     * {@link IProject}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Forward Scope as Projects</em>' attribute list isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Forward Scope as Projects</em>' attribute list.
     */
    Collection<IProject> getForwardScopeAsProjects();

    /**
     * Returns the value of the '<em><b>Forward Scope as Resources</b></em>' attribute list. The list contents are of type
     * {@link Resource}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Forward Scope as Resources</em>' attribute list isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Forward Scope as Resources</em>' attribute list.
     */
    Collection<Resource> getForwardScopeAsResources();

    /**
     * Returns the value of the '<em><b>Backward Scope as Project</b></em>' attribute list. The list contents are of type
     * {@link IProject}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Backward Scope as Project</em>' attribute list isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Backward Scope as Project</em>' attribute list.
     */
    Collection<IProject> getBackwardScopeAsProjects();

    /**
     * Returns the value of the '<em><b>Backward Scope as Resources</b></em>' attribute list. The list contents are of type
     * {@link Resource}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Backward Scope as Resources</em>' attribute list isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Backward Scope as Resources</em>' attribute list.
     */
    Collection<Resource> getBackwardScopeAsResources();

} // ProjectBasedScopeProvider
