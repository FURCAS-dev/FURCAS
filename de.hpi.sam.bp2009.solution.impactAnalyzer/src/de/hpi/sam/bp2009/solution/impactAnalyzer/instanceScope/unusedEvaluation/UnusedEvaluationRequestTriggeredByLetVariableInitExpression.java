package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation;

import java.util.Map;

import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;

import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback.TracebackCache;

/**
 * If an {@link UnusedEvaluationRequest} has a <code>let</code>-variable as its unknown variable, and the variable's
 * initialization expression can't be evaluated because of an unknown variable value, an evaluation request of this type is
 * created, with the unknown variable set to the one required by the initialization expression. If it gets triggered because the
 * missing variable's value became available, it'll try to compute the initialization expression again. If it fails again, a next
 * request is created as the evaluation result that uses the same initialization expression and nested evaluation request, but is
 * associated with the now missing variable.
 * 
 * @author Axel Uhl (D043530)
 * 
 */
public class UnusedEvaluationRequestTriggeredByLetVariableInitExpression extends UnusedEvaluationRequest {
//    private final UnusedEvaluationRequest nestedRequest;
//    private final OCLExpression initExpression;
    
    public UnusedEvaluationRequestTriggeredByLetVariableInitExpression(OCLExpression initExpression,
            UnusedEvaluationRequest nestedRequest,
            Variable unknownVariable,
            OCLExpression expressionToCheckIfUnused, OCLExpression rootExpression, Map<Variable, Integer> dynamicVariableScopes,
            TracebackCache cache) {
        super(expressionToCheckIfUnused, null, null, null); // TODO
//        this.initExpression = initExpression;
//        this.nestedRequest = nestedRequest;
    }

    @Override
    public boolean evaluate(OppositeEndFinder oppositeEndFinder) {
        boolean result = false;
        /*
        Map<Variable, Object> newKnownVariables = new HashMap<Variable, Object>(getKnownVariableValues());
        newKnownVariables.put(getUnknownVariable(), valueForFormerlyUnknownVariable);
        PartialEvaluator p = new PartialEvaluator(oppositeEndFinder);
        p.getOcl().getEvaluationEnvironment().add(getUnknownVariable().getName(), valueForFormerlyUnknownVariable);
        setVariables(p, newKnownVariables);
        try {
            Object letVariableValue = p.evaluate(null, initExpression);
            result = nestedRequest.evaluate(cache, oppositeEndFinder);
        } catch (ValueNotFoundException e) {
            UnusedEvaluationRequest nextRequest = new UnusedEvaluationRequest(expressionToCheckIfUnused, TODO, getDynamicVariableScopes());
            result = false;
        }
        */
        return result;
    }


}
