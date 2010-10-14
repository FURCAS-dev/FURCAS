package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation;

import java.util.Map;
import java.util.Set;

import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;

public interface UnusedEvaluationRequestValue {
    public int hashCode();
    public boolean equals(Object obj);

    /**
     * @return an always-valid but possibly empty map; this also means that if a subclass constructor allowed for
     *         <code>null</code> as a possible value for this map, it internally needs to be mapped to an empty map
     */
    public Map<Variable, Object> getInferredVariableValues();
    public Set<Variable> getSlots();
    public OCLExpression getExpression();
    public Object getResultIndicatingUnused();
}
