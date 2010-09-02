package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.expressions.Variable;

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
    private final Variable<EClassifier, EParameter> variable;

    public VariableDefiningNavigationStep(Variable<EClassifier, EParameter> variable, OCLExpression debugInfo) {
        super(debugInfo);
        this.variable = variable;
    }

    @Override
    public String contentToString(Map<NavigationStep, Integer> visited, int indent) {
        return "(" + variable.getName() + ":=...) " + super.contentToString(visited, indent);
    }

    @Override
    protected Set<AnnotatedEObject> navigate(AnnotatedEObject fromObject, TracebackCache cache, Notification changeEvent) {
        cache.setVariableValue(variable, fromObject);
        return super.navigate(fromObject, cache, changeEvent);
    }
    
}
