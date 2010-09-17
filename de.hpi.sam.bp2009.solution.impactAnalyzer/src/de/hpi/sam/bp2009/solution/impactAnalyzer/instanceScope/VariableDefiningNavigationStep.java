package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.ocl.ecore.VariableExp;

import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.OptimizationActivation;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

/**
 * Remembers the <code>fromObject</code> as the value for a particular {@link #variable} in the {@link TracebackCache}
 * for the current dynamic scope, then executes the {@link IndirectingStep#getActualStep() nested step} passed to
 * the constructor. If the variable has a collection type, this step behaves like a normal {@link IndirectingStep}
 * because the <code>fromObject</code> passed to {@link #navigate(AnnotatedEObject, TracebackCache, Notification)}
 * would only be one of potentially many elements constituting the variable's value, and hence we wouldn't know
 * the full value of the variable. In this case, the {@link #variableExp} is set to <code>null</code>.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public class VariableDefiningNavigationStep extends IndirectingStep {
    /**
     * An expression using a variable whose value will be set when {@link #navigate} is called with a value
     * for this expression; or <code>null</code> in case the variable has a collection type and hence the
     * {@link #navigate} call identifies only one out of potentially many collection elements. In the latter
     * case, we don't set a value for the variable in the cache because we don't know for sure that no other
     * elements will be part of the collection.
     */
    private final VariableExp variableExp;
    private final OppositeEndFinder oppositeEndFinder;

    public VariableDefiningNavigationStep(VariableExp variableExp, OppositeEndFinder oppositeEndFinder) {
        super(variableExp);
        if (!Collection.class.isAssignableFrom(variableExp.getReferredVariable().getType().getInstanceClass())) {
            this.variableExp = variableExp;
        } else {
            // collection type; fromObject would only be one of possibly many elements; don't set variable value
            this.variableExp = null;
        }
        this.oppositeEndFinder = oppositeEndFinder;
    }

    @Override
    public String contentToString(Map<NavigationStep, Integer> visited, int indent) {
        return (variableExp == null ? "" : "(" + variableExp.getReferredVariable().getName() + ":=...) ") +
               super.contentToString(visited, indent);
    }

    @Override
    protected Set<AnnotatedEObject> navigate(AnnotatedEObject fromObject, TracebackCache cache, Notification changeEvent) {
        if (OptimizationActivation.getOption().isUnusedDetectionActive() && variableExp != null) {
            if (cache.setVariableValueAndCheckIfUnused(variableExp, fromObject, oppositeEndFinder)) {
                // A stored UnusedEvaluationRequest got triggered and successfully inferred that a subexpression
                // through which the change got propagated is unused. Therefore, for no context object does the
                // original change affect the OCL expression's value. Return an empty set.
                return Collections.emptySet();
            }
        }
        return super.navigate(fromObject, cache, changeEvent);
    }
    
}
