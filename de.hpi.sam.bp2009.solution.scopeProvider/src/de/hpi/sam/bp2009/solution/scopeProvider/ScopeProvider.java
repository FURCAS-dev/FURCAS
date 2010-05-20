/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.scopeProvider;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.query2.QueryContext;

/**
 * 
 * ScopeProvider tries to load all resources from the referenced projects with an XMIResourceImpl. Attention: No instance equality
 * provided, when resources are not in the inMemory list.
 * 
 * @author tobias.hoppe
 * 
 */
public interface ScopeProvider {

    /**
     * Returns the value of the '<em><b>Forward Scope as Query Context</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * 
     * <b> ATTENTION: </b> all possible resources must be in the same {@link ResourceSet}. <br>
     * If the meaning of the ' <em>Forward Scope as Query Context</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Forward Scope as Query Context</em>' attribute.
     */
    QueryContext getForwardScopeAsQueryContext();

    /**
     * Returns the value of the '<em><b>Forward Scope as EObjects</b></em>' attribute list. The list contents are of type
     * {@link EObject}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Forward Scope as EObjects</em>' attribute list isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Forward Scope as EObjects</em>' attribute list.
     */
    Collection<EObject> getForwardScopeAsEObjects();

    /**
     * Returns the value of the '<em><b>Forward Scope as URI</b></em>' attribute list. The list contents are of type {@link URI}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Forward Scope as URI</em>' attribute list isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Forward Scope as URI</em>' attribute list.
     */
    Collection<URI> getForwardScopeAsURIs();

    /**
     * Returns the value of the '<em><b>Backward Scope as Query Context</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * 
     * <b> ATTENTION: </b> all possible resources must be in the same {@link ResourceSet}. <br>
     * If the meaning of the ' <em>Backward Scope as Query Context</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Backward Scope as Query Context</em>' attribute.
     */
    QueryContext getBackwardScopeAsQueryContext();

    /**
     * Returns the value of the '<em><b>Backward Scope as URI</b></em>' attribute list. The list contents are of type {@link URI}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Backward Scope as URI</em>' attribute list isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Backward Scope as URI</em>' attribute list.
     */
    Collection<EObject> getBackwardScopeAsEObjects();

    /**
     * Returns the value of the '<em><b>Backward Scope as URI</b></em>' attribute list. The list contents are of type {@link URI}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Backward Scope as URI</em>' attribute list isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Backward Scope as URI</em>' attribute list.
     */
    Collection<URI> getBackwardScopeAsURIs();

} // ScopeProvider
