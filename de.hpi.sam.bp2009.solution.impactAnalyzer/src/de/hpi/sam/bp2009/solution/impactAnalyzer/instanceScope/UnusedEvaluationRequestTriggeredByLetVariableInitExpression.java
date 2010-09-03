package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.VariableExp;

import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.PartialEvaluator;
import de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.ValueNotFoundException;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;

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
    private final UnusedEvaluationRequest nestedRequest;
    private final OCLExpression initExpression;
    
    public UnusedEvaluationRequestTriggeredByLetVariableInitExpression(OCLExpression initExpression,
            UnusedEvaluationRequest nestedRequest,
            Map<Variable, Object> knownVariableValues,
            Variable unknownVariable, OCLExpression variableScope, OCLExpression expressionToCheckIfUnused,
            OCLExpression rootExpression) {
        super(knownVariableValues, unknownVariable, variableScope, expressionToCheckIfUnused, rootExpression);
        this.initExpression = initExpression;
        this.nestedRequest = nestedRequest;
    }

    @Override
    public EvaluationResult evaluate(Object valueForFormerlyUnknownVariable, OppositeEndFinder oppositeEndFinder,
            OperationBodyToCallMapper operationBodyToCallMapper) {
        EvaluationResult result;
        Map<Variable, Object> newKnownVariables = new HashMap<Variable, Object>(getKnownVariableValues());
        newKnownVariables.put(getUnknownVariable(), valueForFormerlyUnknownVariable);
        PartialEvaluator p = new PartialEvaluator(oppositeEndFinder);
        p.getOcl().getEvaluationEnvironment().add(getUnknownVariable().getName(), valueForFormerlyUnknownVariable);
        setVariables(p, newKnownVariables);
        try {
            Object letVariableValue = p.evaluate(/*context*/ null, initExpression);
            result = nestedRequest.evaluate(letVariableValue, oppositeEndFinder, operationBodyToCallMapper);
        } catch (ValueNotFoundException e) {
            UnusedEvaluationRequest nextRequest = new UnusedEvaluationRequest(newKnownVariables, (Variable) e.getVariableExp()
                    .getReferredVariable(), getStaticScope((VariableExp) e.getVariableExp(), oppositeEndFinder,
                    operationBodyToCallMapper), expressionToCheckIfUnused, rootExpression);
            result = new EvaluationResult(false, nextRequest);
        }
        return result;
    }


}
