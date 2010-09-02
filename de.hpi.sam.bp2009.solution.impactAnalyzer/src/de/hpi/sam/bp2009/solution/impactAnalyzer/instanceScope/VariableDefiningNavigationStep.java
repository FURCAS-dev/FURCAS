package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.ocl.ecore.VariableExp;

import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

/**
 * Remembers the <code>fromObject</code> as the value for a particular {@link #variable} in the {@link TracebackCache}
 * for the current dynamic scope, then executes the {@link IndirectingStep#getActualStep() nested step} passed to
 * the constructor.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public class VariableDefiningNavigationStep extends IndirectingStep {
    private final VariableExp variableExp;
    private final OppositeEndFinder oppositeEndFinder;

    public VariableDefiningNavigationStep(VariableExp variableExp, OppositeEndFinder oppositeEndFinder) {
        super(variableExp);
        this.variableExp = variableExp;
        this.oppositeEndFinder = oppositeEndFinder;
    }

    @Override
    public String contentToString(Map<NavigationStep, Integer> visited, int indent) {
        return "(" + variableExp.getReferredVariable().getName() + ":=...) " + super.contentToString(visited, indent);
    }

    @Override
    protected Set<AnnotatedEObject> navigate(AnnotatedEObject fromObject, TracebackCache cache, Notification changeEvent) {
        cache.setVariableValue(variableExp, fromObject, oppositeEndFinder);
        return super.navigate(fromObject, cache, changeEvent);
    }
    
}
