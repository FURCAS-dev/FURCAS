package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.IterateExp;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.LoopExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.VariableExp;

import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;

/**
 * Computes a {@link NavigationStep} for a {@link VariableExp} which, given an element constituting a value the variable
 * shall assume, infers a set of elements which, when used as the value of the outermost expression's <code>self</code> variable,
 * may lead the variable considered here to assume the expected value.<p>
 * 
 * OCL knows occurrences of different "stereotypes" of variables, depending on where/how the variable is defined:
 * <ul>
 *   <li>a <code>self</code> variable occurring within the body of an operation</li>
 *   <li>a <code>self</code> variable occurring outside the body of an operation</li>
 *   <li>an operation's formal parameter</li>
 *   <li>an iterator variable</li>
 *   <li>the result variable of an {@link IterateExp}</li>
 *   <li>the variable assigned by a {@link LetExp}</li>
 * </ul>
 * 
 * In all cases, traceback continues with the expression defining the possible values that the variable may assume. In all
 * cases, this leaves the scope in which the variable is visible. This becomes important when considering how variable values
 * travel through the computation of the <code>unused</code> function, trying to prove for each expression visited by traceback,
 * whether or not it is used, given what is known about variable values.
 * 
 * @author Axel Uhl (D043530)
 *
 */
// TODO refactor into several subclasses, one for each is... case, and let tracer factory in InstanceScopeAnalysis.createTracer choose the appropriate one
public class VariableExpTracer extends AbstractTracer<VariableExp> {
    public VariableExpTracer(VariableExp expression, Stack<String> tuplePartNames, OCLFactory oclFactory) {
        super(expression, tuplePartNames, oclFactory);
    }

    private Variable getVariableDeclaration() {
        return (Variable) getExpression().getReferredVariable();
    }

    private boolean isLetVariable() {
        // let variables are contained in the letExp
        Variable exp = getVariableDeclaration();
        return exp.eContainer() instanceof LetExp && ((LetExp) exp.eContainer()).getVariable() == exp;
    }

    private boolean isOperationParameter() {
        return getVariableDeclaration().getRepresentedParameter() != null;
    }

    private boolean isIterateResultVariable() {
        // result variables are contained in iterateExp
        Variable exp = getVariableDeclaration();
        return (exp.eContainer() instanceof IterateExp && ((IterateExp) exp.eContainer()).getResult() == exp);
    }

    private boolean isIteratorVariable() {
        Variable exp = getVariableDeclaration();
        return (exp.eContainer() instanceof LoopExp && ((LoopExp) exp.eContainer()).getIterator().contains(exp));
    }

    private boolean isSelf() {
        return getVariableDeclaration().getName().equals(EcoreEnvironment.SELF_VARIABLE_NAME);
    }

    /**
     * The step produced will be invoked with the value for the variable. This knowledge can be helpful when trying to perform
     * partial evaluations. Variables have an {@link OCLExpression} as their scope. For example, a let-variable has the
     * {@link LetExp#getIn() in} expression as its static scope. Additionally, scopes are dynamically instantiated during
     * expression evaluation. For example, during evaluation of an {@link IterateExp}, the body expression forms the static scope
     * for the {@link IterateExp#getResult() result variable}. During each iteration, a new dynamic scope is created and the same
     * static result variable may have a different value in each dynamic scope. It is important to understand that the navigation
     * step learns about the value of the variable only in one particular dynamic scope.
     * <p>
     * 
     * Dynamic scopes are identified by the {@link OCLExpression} object forming the static scope, combined with a unique
     * identifier, implemented as a simple counter.
     * <p>
     * 
     * It is also important to understand that variables of a collection type cannot have their value fully inferred by the
     * traceback process as only single elements are visited during the trace.
     */
    @Override
    public NavigationStep traceback(EClass context, PathCache pathCache, OperationBodyToCallMapper operationBodyToCallMapper) {
        NavigationStep result;
        if (isSelf()) {
            result = tracebackSelf(context, pathCache, operationBodyToCallMapper);
        } else if (isIteratorVariable()) {
            result = tracebackIteratorVariable(context, pathCache, operationBodyToCallMapper);
        } else if (isIterateResultVariable()) {
            result = tracebackIterateResultVariable(context, pathCache, operationBodyToCallMapper);
        } else if (isLetVariable()) {
            result = tracebackLetVariable(context, pathCache, operationBodyToCallMapper);
        } else if (isOperationParameter()) {
            result = tracebackOperationParameter(context, pathCache, operationBodyToCallMapper);
        } else {
            throw new RuntimeException("Unknown variable expression that is neither an iterator variable "
                    + "nor an iterate result variable nor an operation parameter nor a let variable nor self: "
                    + getExpression().getReferredVariable().getName());
        }
        applyScopesOnNavigationStep(result, operationBodyToCallMapper);
        return result;
    }

    private NavigationStep tracebackOperationParameter(EClass context, PathCache pathCache,
            OperationBodyToCallMapper operationBodyToCallMapper) {
        OCLExpression rootExpression = getRootExpression();
        // all operation bodies must have been reached through at least one call; all calls are
        // recorded in the filter synthesizer's cache. Therefore, we can determine the relationship
        // between body and EOperation.
        EOperation op = operationBodyToCallMapper.getCallsOf(rootExpression).iterator().next().getReferredOperation();
        int pos = getParameterPosition(op);
        List<NavigationStep> stepsPerCall = new ArrayList<NavigationStep>();
        IndirectingStep indirectingStep = pathCache.createIndirectingStepFor(getExpression(), getTupleLiteralPartNamesToLookFor());
        // As new operation calls change the set of OperationCallExp returned here for existing operations,
        // the PathCache cannot trivially be re-used across expression registrations. We would have to
        // invalidate all cache entries that depend on this step. Or we add steps produced for new calls to this
        // step as the calls get added; but that may require a re-assessment of the isAlwaysEmpty() calls.
        // This may not pay off.
        for (OperationCallExp call : operationBodyToCallMapper.getCallsOf(rootExpression)) {
            OCLExpression argumentExpression = (OCLExpression) call.getArgument().get(pos);
            NavigationStep stepForCall = pathCache.getOrCreateNavigationPath(argumentExpression, context, operationBodyToCallMapper,
                    getTupleLiteralPartNamesToLookFor(), oclFactory);
            // leaves all variables currently in scope because it'll jump into a new expression context;
            // the step enters into all scopes in which the argument expression in the operation call is nested,
            // starting from the root expression for the argument expression
            stepForCall.addLeavingScopes(getAllVariablesInScope(getExpression(), operationBodyToCallMapper));
            stepForCall.addEnteringScopes(getAllVariablesInScope(argumentExpression, operationBodyToCallMapper));
            stepsPerCall.add(stepForCall);
        }
        indirectingStep.setActualStep(pathCache.navigationStepForBranch(getInnermostElementType(getExpression().getType()),
                context, getExpression(), getTupleLiteralPartNamesToLookFor(), stepsPerCall.toArray(new NavigationStep[0])));
        return indirectingStep;
    }

    /**
     * Determines the position of the parameter of operation <tt>op</tt> that is named like the variable referred to by this
     * tracer's {@link #getExpression() variable expression).
     */
    private int getParameterPosition(EOperation op) {
        String variableName = getVariableDeclaration().getName();
        // determine position of formal IN_DIR parameter named variableName
        int pos = 0;
        EList<EObject> pList = op.eContents();
        for (EObject p : pList) {
            if (p instanceof EParameter) {
                if (variableName.equals(((EParameter) p).getName())) {
                    break;
                } else {
                    pos++;
                }
            }
        }
        return pos;
    }

    private NavigationStep tracebackLetVariable(EClass context, PathCache pathCache,
            OperationBodyToCallMapper operationBodyToCallMapper) {
        NavigationStep result = pathCache.getOrCreateNavigationPath((OCLExpression) getVariableDeclaration().getInitExpression(),
                context, operationBodyToCallMapper, getTupleLiteralPartNamesToLookFor(), oclFactory);
        return result;
    }

    private NavigationStep tracebackIterateResultVariable(EClass context, PathCache pathCache,
            OperationBodyToCallMapper operationBodyToCallMapper) {
        // the init expression can't reference the result variable, therefore no recursive reference may occur here:
        NavigationStep stepForInitExpression = pathCache.getOrCreateNavigationPath((OCLExpression) getVariableDeclaration()
                .getInitExpression(), context, operationBodyToCallMapper, getTupleLiteralPartNamesToLookFor(), oclFactory);
        // the body expression, however, may reference the result variable; computing the body's navigation step graph
        // may therefore recursively look up the navigation step graph for the result variable. We therefore need to
        // enter a placeholder into the cache before we start computing the navigation step graph for the body expression:
        IndirectingStep indirectingStep = pathCache.createIndirectingStepFor(
                getExpression(), getTupleLiteralPartNamesToLookFor());
        NavigationStep stepForBodyExpression = pathCache.getOrCreateNavigationPath(
                (OCLExpression) ((IterateExp) getVariableDeclaration().eContainer()).getBody(), context, operationBodyToCallMapper,
                getTupleLiteralPartNamesToLookFor(), oclFactory);
        NavigationStep actualStepForIterateResultVariableExp = pathCache.navigationStepForBranch(
                getInnermostElementType(getExpression().getType()), context, getExpression(),
                getTupleLiteralPartNamesToLookFor(), stepForInitExpression, stepForBodyExpression);
        indirectingStep.setActualStep(actualStepForIterateResultVariableExp);
        return indirectingStep;
    }

    private NavigationStep tracebackIteratorVariable(EClass context, PathCache pathCache,
            OperationBodyToCallMapper operationBodyToCallMapper) {
        NavigationStep result = pathCache.getOrCreateNavigationPath(
                (OCLExpression) ((LoopExp) getVariableDeclaration().eContainer()).getSource(), context, operationBodyToCallMapper,
                getTupleLiteralPartNamesToLookFor(), oclFactory);
        return result;
    }

    private NavigationStep tracebackSelf(EClass context, PathCache pathCache,
            OperationBodyToCallMapper operationBodyToCallMapper) {
        IndirectingStep result;
        EOperation op = getOperationOfWhichRootExpressionIsTheBody(operationBodyToCallMapper);
        if (op != null) {
            // in an operation, self needs to be traced back to all source expressions of
            // calls to that operation
            Collection<OperationCallExp> calls = operationBodyToCallMapper.getCallsOf(getRootExpression());
            IndirectingStep indirectingStep = pathCache.createIndirectingStepFor(
                    getExpression(), getTupleLiteralPartNamesToLookFor());
            List<NavigationStep> stepsForCalls = new ArrayList<NavigationStep>();
            for (OperationCallExp call : calls) {
                OCLExpression callSource = (OCLExpression) call.getSource();
                NavigationStep stepForCall = pathCache.getOrCreateNavigationPath(callSource, context, operationBodyToCallMapper,
                        getTupleLiteralPartNamesToLookFor(), oclFactory);
                // leaves all variables currently in scope because it'll jump into a new expression context;
                // the step enters into all scopes in which the source expression in the operation call is nested,
                // starting from the root expression for the source expression
                stepForCall.addLeavingScopes(getAllVariablesInScope(getExpression(), operationBodyToCallMapper));
                stepForCall.addEnteringScopes(getAllVariablesInScope(callSource, operationBodyToCallMapper));
                stepsForCalls.add(stepForCall);
            }
            // the branching navigation step must not be cached or looked up in a cache because its
            // associated expression is the same as the one used for the IndirectingStep created and cached
            // above.
            indirectingStep.setActualStep(pathCache.navigationStepForBranch(getInnermostElementType(getExpression().getType()),
                    context, getExpression(), getTupleLiteralPartNamesToLookFor(), stepsForCalls.toArray(new NavigationStep[0])));
            result = indirectingStep;
        } else {
            // self occurred outside of an operation; it evaluates to s for s being the context
            result = pathCache.createIndirectingStepFor(getExpression(),
                    getTupleLiteralPartNamesToLookFor());
            result.setActualStep(new IdentityNavigationStep((EClass) getExpression().getType(), (EClass) getExpression()
                    .getType(), getExpression()));
        }
        return result;
    }

    private EOperation getOperationOfWhichRootExpressionIsTheBody(OperationBodyToCallMapper operationBodyToCallMapper) {
        // all operation bodies must have been reached through at least one call; all calls are
        // recorded in the filter synthesizer's cache. Therefore, we can determine the relationship
        // between body and EOperation.
        Set<OperationCallExp> filterSynthesizerCallCache = operationBodyToCallMapper.getCallsOf(getRootExpression());
        EOperation op = null;
        if (!filterSynthesizerCallCache.isEmpty()) {
            op = filterSynthesizerCallCache.iterator().next().getReferredOperation();
        }
        return op;
    }

    @Override
    protected Set<Variable> calculateLeavingScopes(OperationBodyToCallMapper operationBodyToCallMapper) {
        // when tracing back a VariableExp, a number of scopes may be left when navigating to the variable definition
        // leaving scopes are calculated by finding all scope creating expressions between the traced VariableExp
        // and the common composition parent of the VariableExp and its definition
        Set<Variable> result;
        if (isLetVariable()) {
            result = getVariablesIntroducedBetweenHereAnd((OCLExpression) ((LetExp) getVariableDeclaration().eContainer()).getIn(),
                    operationBodyToCallMapper);
        } else if (isIteratorVariable() || isIterateResultVariable()) {
            result = getVariablesIntroducedBetweenHereAnd((OCLExpression) ((LoopExp) getVariableDeclaration().eContainer()).getBody(),
                    operationBodyToCallMapper);
        } else if (isOperationParameter() || (isSelf() && getOperationOfWhichRootExpressionIsTheBody(operationBodyToCallMapper) != null)) {
            // for operation parameters or self inside an operation body, traceback continues with the call expression,
            // leaving all scopes
            result = getAllVariablesInScope(getExpression(), operationBodyToCallMapper);
        } else {
            result = Collections.emptySet();
        }
        return result;
    }
}
