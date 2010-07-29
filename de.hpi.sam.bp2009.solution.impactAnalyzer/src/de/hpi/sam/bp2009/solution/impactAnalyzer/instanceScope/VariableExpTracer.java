package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

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

import de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.FilterSynthesisImpl;

public class VariableExpTracer extends AbstractTracer<VariableExp> {
    public VariableExpTracer(VariableExp expression, String[] tuplePartNames) {
	super(expression, tuplePartNames);
    }

    private Variable getVariableDeclaration() {
	return (Variable) getExpression().getReferredVariable();
    }

    private boolean isLetVariable() {
        // let variables are contained in the letExp
        Variable exp = getVariableDeclaration();
        return exp.eContainer() instanceof LetExp && ((LetExp)exp.eContainer()).getVariable() == exp;
    }

    private boolean isOperationParameter() {
        return getVariableDeclaration().getRepresentedParameter() != null;
    }

    private boolean isIterateResultVariable() {
        //result variables are contained in iterateExp
        Variable exp = getVariableDeclaration();
	return (exp.eContainer() instanceof IterateExp && ((IterateExp) exp.eContainer()).getResult() == exp);
    }

    private boolean isIteratorVariable() {
        Variable exp = getVariableDeclaration();
	return (exp.eContainer() instanceof LoopExp && ((LoopExp)exp.eContainer()).getIterator().contains(exp));
    }

    private boolean isSelf() {
	return getVariableDeclaration().getName().equals(EcoreEnvironment.SELF_VARIABLE_NAME);
    }

    @Override
    public NavigationStep traceback(EClass context, PathCache pathCache, FilterSynthesisImpl filterSynthesizer) {
	NavigationStep result;
	if (isSelf()) {
	    result = tracebackSelf(context, pathCache, filterSynthesizer);
	} else if (isIteratorVariable()) {
	    result = tracebackIteratorVariable(context, pathCache, filterSynthesizer);
	} else if (isIterateResultVariable()) {
	    result = tracebackIterateResultVariable(context, pathCache, filterSynthesizer);
	} else if (isLetVariable()) {
	    result = tracebackLetVariable(context, pathCache, filterSynthesizer);
	} else if (isOperationParameter()) {
	    result = tracebackOperationParameter(context, pathCache, filterSynthesizer);
	} else
	    throw new RuntimeException("Unknown variable expression that is neither an iterator variable "
		    + "nor an iterate result variable nor an operation parameter nor a let variable nor self: "
		    + getExpression().getReferredVariable().getName());
	return result;
    }

    private NavigationStep tracebackOperationParameter(EClass context, PathCache pathCache, FilterSynthesisImpl filterSynthesizer) {
	OCLExpression rootExpression = getRootExpression();

	// all operation bodies must have been reached through at least one call; all calls are
	// recorded in the filter synthesizer's cache. Therefore, we can determine the relationship
	// between body and EOperation.
	EOperation op = filterSynthesizer.getCallsOf(rootExpression).iterator().next().getReferredOperation();

	int pos = getParameterPosition(op);
	List<NavigationStep> stepsPerCall = new ArrayList<NavigationStep>();
	IndirectingStep indirectingStep = pathCache.createIndirectingStepFor(getExpression(), getTupleLiteralPartNamesToLookFor());
	// As new operation calls change the set of OperationCallExp returned here for existing operations,
	// the PathCache cannot trivially be re-used across expression registrations. We would have to
	// invalidate all cache entries that depend on this step. Or we add steps produced for new calls to this
	// step as the calls get added; but that may require a re-assessment of the isAlwaysEmpty() calls.
	// This may not pay off.
	for (OperationCallExp call : filterSynthesizer.getCallsOf(rootExpression)) {
	    OCLExpression argumentExpression = (OCLExpression) call.getArgument().get(pos);
	    stepsPerCall.add(pathCache.getOrCreateNavigationPath(argumentExpression, context, filterSynthesizer, getTupleLiteralPartNamesToLookFor()));
	}

	indirectingStep.setActualStep(new BranchingNavigationStep(
		getInnermostElementType(getExpression().getType()),
	        context,
	        getExpression(),
	        stepsPerCall.toArray(new NavigationStep[0])));
	return indirectingStep;
    }

    /**
     * Determines the position of the parameter of operation <tt>op</tt> that is named like
     * the variable referred to by this tracer's {@link #getExpression() variable expression).
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

    private NavigationStep tracebackLetVariable(EClass context, PathCache pathCache, FilterSynthesisImpl filterSynthesizer) {
	return pathCache.getOrCreateNavigationPath((OCLExpression) getVariableDeclaration().getInitExpression(),
	        context,
	        filterSynthesizer, getTupleLiteralPartNamesToLookFor());
    }

    private NavigationStep tracebackIterateResultVariable(EClass context, PathCache pathCache, FilterSynthesisImpl filterSynthesizer) {
	NavigationStep stepForInitExpression = pathCache.getOrCreateNavigationPath(
	        (OCLExpression) getVariableDeclaration().getInitExpression(),
	        context,
	        filterSynthesizer, getTupleLiteralPartNamesToLookFor());
	NavigationStep stepForBodyExpression = pathCache.getOrCreateNavigationPath(
	        (OCLExpression) ((IterateExp) getVariableDeclaration().eContainer()).getBody(),
	        context,
	        filterSynthesizer, getTupleLiteralPartNamesToLookFor());
	return new BranchingNavigationStep(
	        (EClass) getExpression().getType(),
	        context,
	        getExpression(),
	        stepForInitExpression,
	        stepForBodyExpression);
    }

    private NavigationStep tracebackIteratorVariable(EClass context, PathCache pathCache, FilterSynthesisImpl filterSynthesizer) {
	return pathCache.getOrCreateNavigationPath(
	        (OCLExpression) ((LoopExp) getVariableDeclaration().eContainer()).getSource(),
	        context,
	        filterSynthesizer, getTupleLiteralPartNamesToLookFor());
    }

    private NavigationStep tracebackSelf(EClass context, PathCache pathCache, FilterSynthesisImpl filterSynthesizer) {
	NavigationStep result;

	// all operation bodies must have been reached through at least one call; all calls are
	// recorded in the filter synthesizer's cache. Therefore, we can determine the relationship
	// between body and EOperation.
	Set<OperationCallExp> filterSynthesizerCallCache = filterSynthesizer.getCallsOf(getRootExpression());
	EOperation op = null;

	if(!filterSynthesizerCallCache.isEmpty()){
	    op = filterSynthesizerCallCache.iterator().next().getReferredOperation();
	}

	if (op != null) {
	    // in an operation, self needs to be traced back to all source expressions of
	    // calls to that operation
	    Collection<OperationCallExp> calls = filterSynthesizer.getCallsOf(getRootExpression());
	    IndirectingStep indirectingStep = pathCache.createIndirectingStepFor(getExpression(), getTupleLiteralPartNamesToLookFor());
	    List<NavigationStep> stepsForCalls = new ArrayList<NavigationStep>();
	    for (OperationCallExp call : calls) {
		OCLExpression callSource = (OCLExpression) call.getSource();
		stepsForCalls.add(pathCache.getOrCreateNavigationPath(callSource, context, filterSynthesizer, getTupleLiteralPartNamesToLookFor()));
	    }
	    indirectingStep.setActualStep(new BranchingNavigationStep(
		    (EClass) getExpression().getType(),
		    context,
		    getExpression(),
		    stepsForCalls.toArray(new NavigationStep[0])));
	    result = indirectingStep;
	} else {
	    // self occurred outside of an operation; it evaluates to s for s being the context
	    result = new IdentityNavigationStep(
	            (EClass) getExpression().getType(),
	            (EClass) getExpression().getType(),
		    getExpression());
	}
	return result;
    }
}
