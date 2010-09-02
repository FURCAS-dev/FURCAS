package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.ecore.OCLExpression;

/**
 * An OCL variable has a static scope in an {@link OCLExpression} and a dynamic scope during evaluation which works similar to a
 * stack trace. Objects of this class describe one evaluation of a given {@link OCLExpression}. Should this evaluation iteratively
 * or recursively lead to other evaluations of the same expression, or should it be part of an outer evaluation, then more
 * {@link DynamicVariableScope} objects for the same expression will exist.
 * 
 * @author Axel Uhl (D043530)
 * 
 */
public class DynamicVariableScope {
    private final org.eclipse.ocl.expressions.OCLExpression<EClassifier> staticScopeExpression;
    private final int evaluationId;
    
    public DynamicVariableScope(org.eclipse.ocl.expressions.OCLExpression<EClassifier> oclExpression, int evaluationId) {
        this.staticScopeExpression = oclExpression;
        this.evaluationId = evaluationId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + evaluationId;
        result = prime * result + ((staticScopeExpression == null) ? 0 : staticScopeExpression.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DynamicVariableScope other = (DynamicVariableScope) obj;
        if (evaluationId != other.evaluationId)
            return false;
        if (staticScopeExpression == null) {
            if (other.staticScopeExpression != null)
                return false;
        } else if (!staticScopeExpression.equals(other.staticScopeExpression))
            return false;
        return true;
    }
}
