package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

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
    private Set<NavigationStep> stepsAlwaysEmptyInThisStepsContext;

    public BranchingNavigationStep(EClass sourceType, EClass targetType, OCLExpression debugInfo, NavigationStep... parallelSteps) {
        // TODO be smart about allInstances steps that subsume other steps with same or specialized targetType
        // TODO be smart and recognize alwaysEmpty in case of a single GOTO that goes immediately to this
        // TODO be smart and combine steps where one is just an indirection for another
        // TODO if parallelSteps contains a BranchingNavigationStep, pull its branches up into this step
        super(sourceType, targetType, debugInfo, parallelSteps);
        stepsAlwaysEmptyInThisStepsContext = new HashSet<NavigationStep>();
        if (areAllStepsAlwaysEmpty()) {
            setAlwaysEmpty();
        } else {
            for (NavigationStep step : getSteps()) {
                if (!step.isAlwaysEmpty()) {
                    step.addAlwaysEmptyChangeListener(new AlwaysEmptyChangeListener() {
                        @Override
                        public void alwaysEmptyChanged(NavigationStep stepForWhichAlwaysEmptyChanged) {
                            if (areAllStepsAlwaysEmpty()) {
                                setAlwaysEmpty();
                            }
                        }
                    });
                    if (step.getSourceType() == null) {
                        step.addSourceTypeChangeListener(new SourceTypeChangeListener() {
                            @Override
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
                            @Override
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
    protected Set<AnnotatedEObject> navigate(AnnotatedEObject fromObject, Map<List<Object>, Set<AnnotatedEObject>> cache, Notification changeEvent) {
        Set<AnnotatedEObject> result = new HashSet<AnnotatedEObject>();
        for (NavigationStep singleStep : getSteps()) {
            Set<AnnotatedEObject> fromSet = Collections.singleton(fromObject);
            result.addAll(singleStep.navigate(fromSet, cache, changeEvent));
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
}
