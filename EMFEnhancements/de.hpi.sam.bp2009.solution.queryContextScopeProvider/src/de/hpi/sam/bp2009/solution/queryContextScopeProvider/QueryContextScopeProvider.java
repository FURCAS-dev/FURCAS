/**
 * 
 */
package de.hpi.sam.bp2009.solution.queryContextScopeProvider;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.query2.QueryContext;

import de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider;

/**
 * @author Tobias Hoppe
 *
 */
public interface QueryContextScopeProvider extends ScopeProvider {
    
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
}
