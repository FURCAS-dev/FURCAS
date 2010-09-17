package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.SemanticIdentity;

/**
 * A navigation step that branches in several paths and combines the results into one.
 *
 */
public class BranchingNavigationStep extends CompositeNavigationStep {
    /**
     * Marks steps that because of source or target type mismatches don't need to be evaluated in the scope of this
     * branching step. This step tracks initially unknown source/target types so that additional steps may be marked as
     * empty in this step's context.
     */
    private final List<NavigationStep> stepsAlwaysEmptyInThisStepsContext;

    private final SemanticIdentity semanticIdentity;

    public BranchingNavigationStep(EClass sourceType, EClass targetType, OCLExpression debugInfo, NavigationStep... parallelSteps) {
        // TODO be smart about allInstances steps that subsume other steps with same or specialized targetType
        // TODO be smart and recognize alwaysEmpty in case of a single GOTO that goes immediately to this
        // TODO be smart and combine steps where one is just an indirection for another
        // TODO if parallelSteps contains a BranchingNavigationStep, pull its branches up into this step
        super(sourceType, targetType, debugInfo, parallelSteps);
        semanticIdentity = new BranchingNavigationStepIdentity();

        stepsAlwaysEmptyInThisStepsContext = new ArrayList<NavigationStep>();
        if (areAllStepsAlwaysEmpty()) {
            setAlwaysEmpty();
        } else {
            for (NavigationStep step : getSteps()) {
                if (!step.isAlwaysEmpty()) {
                    step.addAlwaysEmptyChangeListener(new AlwaysEmptyChangeListener() {
                        public void alwaysEmptyChanged(NavigationStep stepForWhichAlwaysEmptyChanged) {
                            if (areAllStepsAlwaysEmpty()) {
                                setAlwaysEmpty();
                            }
                        }
                    });
                    if (step.getSourceType() == null) {
                        step.addSourceTypeChangeListener(new SourceTypeChangeListener() {
                            public void sourceTypeChanged(NavigationStep stepForWhichSourceTypeChanged) {
                                // if source type is set where it was previously not set, check if that step
                                // can be removed
                                if (!haveIntersectingSubclassTree(stepForWhichSourceTypeChanged.getSourceType(), getSourceType())) {
                                    stepsAlwaysEmptyInThisStepsContext.add(stepForWhichSourceTypeChanged);
                                    if (stepsAlwaysEmptyInThisStepsContext.size() == getSteps().length) {
                                        setAlwaysEmpty();
                                    }
                                }
                            }
                        });
                    } else {
                        if (!haveIntersectingSubclassTree(step.getSourceType(), getSourceType())) {
                            stepsAlwaysEmptyInThisStepsContext.add(step);
                        }
                    }
                    if (step.getTargetType() == null) {
                        step.addTargetTypeChangeListener(new TargetTypeChangeListener() {
                            public void targetTypeChanged(NavigationStep stepForWhichTargetTypeChanged) {
                                // if source type is set where it was previously not set, check if that step
                                // can be removed
                                if (!haveIntersectingSubclassTree(stepForWhichTargetTypeChanged.getTargetType(), getTargetType())) {
                                    stepsAlwaysEmptyInThisStepsContext.add(stepForWhichTargetTypeChanged);
                                    if (stepsAlwaysEmptyInThisStepsContext.size() == getSteps().length) {
                                        setAlwaysEmpty();
                                    }
                                }
                            }
                        });
                    } else {
                        if (!haveIntersectingSubclassTree(step.getSourceType(), getTargetType())) {
                            stepsAlwaysEmptyInThisStepsContext.add(step);
                        }
                    }
                }
            }
        }
    }

    private class BranchingNavigationStepIdentity extends SemanticIdentity {
	public BranchingNavigationStep getNavigationStep() {
	    return BranchingNavigationStep.this;
	}

	@Override
	public boolean equals(Object o) {
	    if (this == o) {
		return true;
	    }
	    if (o == null || hashCode() != o.hashCode()) {
		return false;
	    }
	    if (!getSemanticIdentityOfSuperSuper().equals(o)) {
		return false;
	    }

	    BranchingNavigationStep other = ((BranchingNavigationStepIdentity) o).getNavigationStep();

	    if (other.getSteps().length != getNavigationStep().getSteps().length) {
		return false;
	    }

	    for (NavigationStep step : getNavigationStep().getSteps()) {
		if (!otherStepHasEqualStep(step, other.getSteps())) {
		    return false;
		}
	    }
	    return true;
	}

	private boolean otherStepHasEqualStep(NavigationStep step, NavigationStep... otherSteps) {
	    for (NavigationStep stepOfOther : otherSteps) {
		if (stepOfOther.getSemanticIdentity().equals(step.getSemanticIdentity())) {
		    return true;
		}
	    }
	    return false;
	}

	@Override
	public int calculateHashCode() {
	    int hashCode = getSemanticIdentityOfSuperSuper().hashCode();

	    for (NavigationStep step : getSteps()) {
		hashCode ^= step.hashCode();
	    }

	    return hashCode;
	}

	@Override
	public NavigationStep getStep() {
	    return getNavigationStep();
	}
    }


    /**
     * TODO: This method was created initially to semantically compare branching navigation steps
     * at top level. Therefore a BranchingNavigationStep hierarchy shall be flattened when comparing two
     * BranchingNavigationSteps semantically. This method is unused at the moment since the implementation
     * of this idea has not been finished.
     *
     * @param branchingNavigationStep
     * @return
     */
    @SuppressWarnings("unused")
    private List<NavigationStep> getFlattenedSubsteps(BranchingNavigationStep branchingNavigationStep){
	List<NavigationStep> subStepListHierarchic = new ArrayList<NavigationStep>(branchingNavigationStep.getSteps().length);
	subStepListHierarchic.addAll(Arrays.asList(branchingNavigationStep.getSteps()));

	return reduceBranchingNavigationSteps(subStepListHierarchic);
    }

    private final static Set<List<NavigationStep>> currentlyReducingForList = new HashSet<List<NavigationStep>>();

    private List<NavigationStep> reduceBranchingNavigationSteps(List<NavigationStep> stepList){
	List<NavigationStep> result = new ArrayList<NavigationStep>();
	result.addAll(stepList);

	if(!currentlyReducingForList.contains(stepList)){
	    currentlyReducingForList.add(stepList);
	//System.out.println("Before: " + stepList);
	for(NavigationStep subStep : stepList){
	    if(subStep instanceof BranchingNavigationStep){
		BranchingNavigationStep subBranchingNavigationStep = (BranchingNavigationStep)subStep;

		if (getSourceType() != null && subBranchingNavigationStep.getSourceType() != null && getSourceType().equals(subBranchingNavigationStep.getSourceType())
		 && getTargetType() != null && subBranchingNavigationStep.getTargetType() != null && getTargetType().equals(subBranchingNavigationStep.getTargetType())) {
		    List<NavigationStep> subStepListHierarchic = new ArrayList<NavigationStep>(subBranchingNavigationStep.getSteps().length);
		    subStepListHierarchic.addAll(Arrays.asList(subBranchingNavigationStep.getSteps()));

		    List<NavigationStep> subStepListFlat = reduceBranchingNavigationSteps(subStepListHierarchic);

		    result.remove(subBranchingNavigationStep);
		    result.addAll(subStepListFlat);
		}
	    }
	}
	currentlyReducingForList.remove(stepList);
	}
	return result;
    }


	public SemanticIdentity getSemanticIdentityOfSuperSuper() {
	    return super.getSemanticIdentityOfAbstractNavigationStep();
	}

    private boolean areAllStepsAlwaysEmpty() {
        boolean result = true;
        for (int i=0; result && i<getSteps().length; i++) {
            result = getSteps()[i].isAlwaysEmpty();
        }
        return result;
    }

    /**
     * If there are no branches, the step always returns an empty result and therefore is
     * absolute, regardless its inputs.
     */
    @Override
    public boolean isAbsolute() {
        // TODO also return true if all branches have isAbsolute()==true
        return isAlwaysEmpty();
    }

    @Override
    protected Set<AnnotatedEObject> navigate(AnnotatedEObject fromObject, TracebackCache cache, Notification changeEvent) {
        Set<AnnotatedEObject> result = new HashSet<AnnotatedEObject>();
        for (NavigationStep singleStep : getSteps()) {
            Set<AnnotatedEObject> fromSet = Collections.singleton(fromObject);
            // create a copy of the TracebackCache with separate variablesInScope copy because each branch may traverse scopes differently
            TracebackCache cacheCopyForBranch = cache.copyWithClonedVariablesInScope();
            result.addAll(singleStep.navigate(fromSet, cacheCopyForBranch, changeEvent));
        }
        return result;
    }

    @Override
    public String contentToString(Map<NavigationStep, Integer> visited, int indent) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        sb.append("{\n");
        for (NavigationStep step : getSteps()) {
            addIndent(indent+2, sb);
            if (!first) {
                sb.append("| ");
            } else {
                first = false;
            }
            if (step instanceof AbstractNavigationStep) {
                sb.append(((AbstractNavigationStep) step).toString(visited, indent+2));
            } else {
                sb.append(step);
            }
            sb.append('\n');
        }
        addIndent(indent, sb);
        sb.append('}');
        return sb.toString();
    }

    private void addIndent(int indent, StringBuilder sb) {
        for (int i=0; i<indent; i++) {
            sb.append(' ');
        }
    }

    @Override
    public SemanticIdentity getSemanticIdentity() {
	return semanticIdentity;
    }
}
