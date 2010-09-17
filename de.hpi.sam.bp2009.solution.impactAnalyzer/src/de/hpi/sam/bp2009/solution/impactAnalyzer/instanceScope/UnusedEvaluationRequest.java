package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ecore.IterateExp;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.LoopExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.ocl.expressions.ExpressionsPackage;

import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;
import com.sap.emf.ocl.util.OclHelper;

import de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.PartialEvaluator;
import de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.ValueNotFoundException;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;

/**
 * Represents a request to (re-)evaluate the <code>unused</code> function which for an {@link OCLExpression} tries to
 * prove that it isn't used under a given set of variable values. The variable values held by this request are set
 * in the {@link EvaluationEnvironment} before any partial evaluation is started.<p>
 * 
 * An evaluation request exists because in an attempt to evaluate the <code>unused</code> function, a variable value
 * was not known. This {@link Variable} is remembered by this evaluation request. When the variable's value is
 * inferred, the request can be executed, providing the value inferred which will then be added to the
 * {@link EvaluationEnvironment} for any OCL evaluation as well.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public class UnusedEvaluationRequest {
    // TODO should not hold the variable values but only the dynamic scope IDs for all the variables in scope for the expression
    private final Map<Variable, Integer> dynamicVariableScopes;
    private final Variable unknownVariable;
    protected final OCLExpression expressionToCheckIfUnused;
    protected final OCLExpression rootExpression;
    private final TracebackCache cache;
    
    /**
     * The result of an attempt to evaluate an {@link UnusedEvaluationRequest}. If {@link #wasSuccessful() successful},
     * then the {@link #isUnused()} method tells if the {@link UnusedEvaluationRequest#expressionToCheckIfUnused} is unused.
     * If not successful, a variable was missing for performing some evaluation, and a {@link #getNextEvaluationRequest() next
     * evaluation request} can be obtained which uses the same {@link UnusedEvaluationRequest#expressionToCheckIfUnused} and
     * {@link UnusedEvaluationRequest#rootExpression}, but has a different {@link UnusedEvaluationRequest#unknownVariable},
     * and whose {@link UnusedEvaluationRequest#knownVariableValues} map is extended by the variable whose inference triggered
     * the evaluation.
     * 
     * @author Axel Uhl (D043530)
     *
     */
    public static class EvaluationResult {
        private final boolean unused;
        private final UnusedEvaluationRequest nextRequest;
        
        public EvaluationResult(boolean unused, UnusedEvaluationRequest nextRequest) {
            this.unused = unused;
            this.nextRequest = nextRequest;
        }

        public boolean wasSuccessful() {
            return nextRequest == null;
        }
        
        public boolean isUnused() {
            return unused;
        }
        
        public UnusedEvaluationRequest getNextEvaluationRequest() {
            return nextRequest;
        }
    }
    
    public UnusedEvaluationRequest(Variable unknownVariable, OCLExpression expressionToCheckIfUnused,
            OCLExpression rootExpression,
            Map<Variable, Integer> dynamicVariableScopes, TracebackCache cache) {
        this.unknownVariable = unknownVariable;
        this.expressionToCheckIfUnused = expressionToCheckIfUnused;
        this.rootExpression = rootExpression;
        this.dynamicVariableScopes = dynamicVariableScopes;
        this.cache = cache;
    }
    
    /**
     * Returns an unmodifiable version of the mapping of variables and their known values to be used for evaluating
     * the <code>unused</code> function. Returns a new, modifiable map.
     */
    protected Map<Variable, Object> getKnownVariableValues() {
        return cache.getKnownVariableValues(dynamicVariableScopes);
    }

    public Variable getUnknownVariable() {
        return unknownVariable;
    }
    
    public EvaluationResult evaluate(Object valueForFormerlyUnknownVariable, OppositeEndFinder oppositeEndFinder,
            OperationBodyToCallMapper operationBodyToCallMapper, TracebackCache cache) {
        EvaluationResult result;
        Map<Variable, Object> newKnownVariables = getKnownVariableValues();
        newKnownVariables.put(unknownVariable, valueForFormerlyUnknownVariable);
        try {
            boolean unused = computeUnused(expressionToCheckIfUnused, expressionToCheckIfUnused, newKnownVariables);
            result = new EvaluationResult(unused, /* no next request; evaluation was successful */ null);
        } catch (ValueNotFoundException e) {
            UnusedEvaluationRequest nextRequest = new UnusedEvaluationRequest((Variable) e.getVariableExp()
                    .getReferredVariable(), expressionToCheckIfUnused,
                    rootExpression,
                    dynamicVariableScopes, cache);
            result = new EvaluationResult(false, nextRequest);
        }
        return result;
    }

    protected static OCLExpression getStaticScope(VariableExp variableExp,
            OppositeEndFinder oppositeEndFinder, OperationBodyToCallMapper operationBodyToCallMapper) {
        Variable variable = (Variable) variableExp.getReferredVariable();
        org.eclipse.ocl.expressions.OCLExpression<EClassifier> result = null;
        // let variable?
        Collection<EObject> letExpression = oppositeEndFinder.navigateOppositePropertyWithBackwardScope(
                ExpressionsPackage.eINSTANCE.getLetExp_Variable(), variable);
        if (letExpression != null && !letExpression.isEmpty()) {
            result = ((LetExp) letExpression.iterator().next()).getIn();
        } else {
            // iterator variable of a LoopExp?
            Collection<EObject> loopExpressionOfIterator = oppositeEndFinder.navigateOppositePropertyWithBackwardScope(
                    ExpressionsPackage.eINSTANCE.getLoopExp_Iterator(), variable);
            if (loopExpressionOfIterator != null && !loopExpressionOfIterator.isEmpty()) {
                result = ((LoopExp) loopExpressionOfIterator.iterator().next()).getBody();
            } else {
                // result variable of an IterateExp?
                Collection<EObject> loopExpressionOfResult = oppositeEndFinder.navigateOppositePropertyWithBackwardScope(
                        ExpressionsPackage.eINSTANCE.getIterateExp_Result(), variable);
                if (loopExpressionOfResult != null && !loopExpressionOfResult.isEmpty()) {
                    result = ((IterateExp) loopExpressionOfResult.iterator().next()).getBody();
                } else {
                    if (variable.getName().equals(Environment.SELF_VARIABLE_NAME)) {
                        OCLExpression root = OclHelper.getRootExpression(variableExp);
                        result = root; 
                    } else {
                        // must be operation parameter:
                        OCLExpression operationBody = OclHelper.getRootExpression(variableExp);
                        EOperation o = operationBodyToCallMapper.getCallsOf(operationBody).iterator().next()
                                .getReferredOperation();
                        boolean found = false;
                        for (EParameter param : o.getEParameters()) {
                            if (param.getName().equals(variableExp.getReferredVariable().getName())) {
                                found = true;
                                break;
                            }
                        }
                        if (found) {
                            result = OclHelper.getRootExpression(variableExp);
                        }
                    }
                }
            }
        }
        if (result == null) {
            throw new RuntimeException("Can't determine static scope of variable "+variable);
        }
        return (OCLExpression) result;
    }

    /**
     * Adds the known variable values provided in <code>newKnownVariables</code> to the partial evaluator's initial OCL evaluation
     * environment.
     */
    protected void setVariables(PartialEvaluator p, Map<Variable, Object> newKnownVariables) {
        EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> env = p.getOcl().getEvaluationEnvironment();
        for (Map.Entry<Variable, Object> entry : newKnownVariables.entrySet()) {
            env.add(entry.getKey().getName(), entry.getValue());
        }
    }
    
    private boolean computeUnused(OCLExpression expressionToCheckIfUnused2, OCLExpression expressionToCheckIfUnused3,
            Map<Variable, Object> newKnownVariables) {
        // TODO implement UnusedEvaluationRequest.computeUnknown
        return false;
    }

    protected Map<Variable, Integer> getDynamicVariableScopes() {
        return dynamicVariableScopes;
    }
}
