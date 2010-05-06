package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.IterateExp;
import org.eclipse.ocl.ecore.IteratorExp;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.ocl.expressions.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.FilterSynthesis;



public class VariableExpTracer extends AbstractTracer<VariableExp> {
    public VariableExpTracer(VariableExp expression) {
	super(expression);
    }

    private Variable getVariableDeclaration() {
	return (Variable) getExpression().getReferredVariable();
    }

    private boolean isNull() {
	return getVariableDeclaration().getName().equals("null");
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
	return (exp.eContainer() instanceof IteratorExp && ((IteratorExp)exp.eContainer()).getIterator().contains(exp));
    }

    private boolean isSelf() {
	return getVariableDeclaration().getName().equals(EcoreEnvironment.SELF_VARIABLE_NAME);
    }

    @Override
    public NavigationStep traceback(EClass context, PathCache pathCache, FilterSynthesis filterSynthesizer) {
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
	} else if (isNull()) {
	    result = new EmptyResultNavigationStep(getExpression());
	} else {
	    throw new RuntimeException("Unknown variable expression that is neither an iterator variable "
		    + "nor an iterate result variable nor an operation parameter nor a let variable nor self: "
		    + getExpression().getReferredVariable().getName());
	}
	return result;
    }

    private NavigationStep tracebackOperationParameter(EClass context, PathCache pathCache, FilterSynthesis filterSynthesizer) {
	OCLExpression<EClassifier> rootExpression = getRootExpression();
	EOperation op = InstanceScopeAnalysis.getDefines(rootExpression);
	int pos = getParameterPosition(op);
	List<NavigationStep> stepsPerCall = new ArrayList<NavigationStep>();
	IndirectingStep indirectingStep = pathCache.createIndirectingStepFor(getExpression());
	// As new operation calls change the set of OperationCallExp returned here for existing operations,
	// the PathCache cannot trivially be re-used across expression registrations. We would have to
	// invalidate all cache entries that depend on this step. Or we add steps produced for new calls to this
	// step as the calls get added; but that may require a re-assessment of the isAlwaysEmpty() calls.
	// This may not pay off.
	for (OperationCallExp call : filterSynthesizer.getCallsOf(rootExpression)) {
	    OCLExpression<EClassifier> argumentExpression = ((EList<OCLExpression<EClassifier>>) (call).getArgument()).get(pos);
	    stepsPerCall.add(pathCache.getOrCreateNavigationPath(argumentExpression, context, filterSynthesizer));
	}
	indirectingStep.setActualStep(new BranchingNavigationStep(
	        (EClass) getExpression().getType(),
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
	for (Iterator<EObject> i=pList.iterator(); i.hasNext(); ) {
	    EObject p = i.next();
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

    private NavigationStep tracebackLetVariable(EClass context, PathCache pathCache, FilterSynthesis filterSynthesizer) {
	return pathCache.getOrCreateNavigationPath(getVariableDeclaration().getInitExpression(), 
	        context, 
	        filterSynthesizer);
    }

    private NavigationStep tracebackIterateResultVariable(EClass context, PathCache pathCache, FilterSynthesis filterSynthesizer) {
	NavigationStep stepForInitExpression = pathCache.getOrCreateNavigationPath(
	        getVariableDeclaration().getInitExpression(),
	        context, 
	        filterSynthesizer);
	NavigationStep stepForBodyExpression = pathCache.getOrCreateNavigationPath(
	        ((IterateExp) getVariableDeclaration().eContainer()).getBody(),
	        context, 
	        filterSynthesizer);
	return new BranchingNavigationStep(
	        (EClass) getExpression().getType(),
	        context,
	        getExpression(),
	        stepForInitExpression,
	        stepForBodyExpression);
    }

    private NavigationStep tracebackIteratorVariable(EClass context, PathCache pathCache, FilterSynthesis filterSynthesizer) {
	return pathCache.getOrCreateNavigationPath(
	        ((IteratorExp) getVariableDeclaration().eContainer()).getSource(),
	        context, 
	        filterSynthesizer);
    }

    private NavigationStep tracebackSelf(EClass context, PathCache pathCache, FilterSynthesis filterSynthesizer) {
	NavigationStep result;
	EOperation op = InstanceScopeAnalysis.getDefines(getRootExpression());
	if (op != null) {
	    // in an operation, self needs to be traced back to all source expressions of
	    // calls to that operation
	    Collection<OperationCallExp> calls = filterSynthesizer.getCallsOf(getRootExpression());
	    IndirectingStep indirectingStep = pathCache.createIndirectingStepFor(getExpression());
	    List<NavigationStep> stepsForCalls = new ArrayList<NavigationStep>();
	    for (OperationCallExp call : calls) {
		OCLExpression<EClassifier> callSource = call.getSource();
		stepsForCalls.add(pathCache.getOrCreateNavigationPath(callSource, context, filterSynthesizer));
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
