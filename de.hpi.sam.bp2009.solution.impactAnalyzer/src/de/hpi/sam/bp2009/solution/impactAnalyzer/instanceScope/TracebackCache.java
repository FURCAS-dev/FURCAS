package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.ocl.ecore.IterateExp;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.LoopExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.Variable;

import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.OclHelper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.Tuple.Pair;

/**
 * During the navigation of a {@link NavigationStep} tree, starting from an {@link EObject},
 * navigation steps may be reached several times with the same {@link EObject} at hand. To
 * avoid endless recursion and to accelerate the computation, an object of this class is
 * passed through an evaluation of a {@link NavigationStep} tree.<p>
 * 
 * In addition to remembering traceback navigation results, this cache also stores variable
 * values inferred during the traceback. Those can be used for partial evaluations, e.g., when
 * trying to determine if a subexpression may be reached at all based on the current variable
 * values. Variable values are keyed by their dynamic scopes. The static scope for a variable
 * in OCL is always an {@link OCLExpression} with its containment hierarchy. The dynamic scope
 * is the "invocation" instance of such a dynamic scope. For one static scope there may be many
 * dynamic scopes for the evaluation of a single expression on a single context element. For
 * example, during the evaluation of an <code>-&gt;iterate(...)</code> expression, the result
 * variable has the body expression as its static scope; for each iteration, a new dynamic scope
 * is created for the result variable. The navigation step used for the result variable traces
 * back using a {@link BranchingNavigationStep} which walks to the result variable's init
 * expression as well as to the body of the <code>iterate</code> expression. For the latter,
 * this ends up in a new dynamic scope for the result variable.<p>
 * 
 * Dynamic scopes are identified by combining a simple increasing numeric ID with the static scope
 * expression.<p>
 * 
 * @author Axel Uhl (D043530)
 *
 */
public class TracebackCache {
    /**
     * Cached values of {@link NavigationStep#navigate(Set, TracebackCache, org.eclipse.emf.common.notify.Notification)} calls,
     * keyed by the step and the <code>fromObject</code> from which navigation was computed, caching the prior results.
     */
    private final Map<Pair<NavigationStep, AnnotatedEObject>, Set<AnnotatedEObject>> navigateCache;
    
    private final Map<Pair<Variable<EClassifier, EParameter>, DynamicVariableScope>, Object> variableValues;
    
    private final OperationBodyToCallMapper operationBodyToCallMapper;
    
    private int evaluationId;
    
    public TracebackCache(OperationBodyToCallMapper operationBodyToCallMapper) {
        navigateCache = new HashMap<Pair<NavigationStep, AnnotatedEObject>, Set<AnnotatedEObject>>();
        variableValues = new HashMap<Pair<Variable<EClassifier, EParameter>, DynamicVariableScope>, Object>();
        this.operationBodyToCallMapper = operationBodyToCallMapper;
    }
    
    /**
     * Looks up a previously {@link #put entered} result for the <code>step</code> where navigation
     * started at the <code>from</code> object. If not found, <code>null</code> is returned.
     */
    public Set<AnnotatedEObject> get(NavigationStep step, AnnotatedEObject from) {
        Set<AnnotatedEObject> result = navigateCache.get(new Pair<NavigationStep, AnnotatedEObject>(step, from));
        return result;
    }
    
    public void put(NavigationStep step, AnnotatedEObject from, Set<AnnotatedEObject> result) {
        navigateCache.put(new Pair<NavigationStep, AnnotatedEObject>(step, from), result);
    }

    public void setVariableValue(VariableExp variable, AnnotatedEObject fromObject,
            OppositeEndFinder oppositeEndFinder) {
        variableValues.put(new Pair<Variable<EClassifier, EParameter>, DynamicVariableScope>(variable.getReferredVariable(),
                new DynamicVariableScope(getStaticScope(variable, oppositeEndFinder), evaluationId++)), fromObject);
    }

    private org.eclipse.ocl.expressions.OCLExpression<EClassifier> getStaticScope(VariableExp variableExp,
            OppositeEndFinder oppositeEndFinder) {
        Variable<EClassifier, EParameter> variable = variableExp.getReferredVariable();
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
                    if (variable.getName().equals("self")) {
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
        return result;
    }
}

