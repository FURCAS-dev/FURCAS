package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.SemanticIdentity;

public class AssociationNavigationStep extends AbstractNavigationStep {
    private final EReference toEnd;
    private final SemanticIdentity semanticIdentity;

    public AssociationNavigationStep(EClass sourceType, EClass targetType, EReference toEnd, OCLExpression debugInfo) {
        super(sourceType, targetType, debugInfo);
        this.toEnd = toEnd;
        semanticIdentity = new AssociationNavigationStepIdentity();
    }

    private class AssociationNavigationStepIdentity extends SemanticIdentity {
	@Override
	public boolean equals(Object o) {
	    if (this == o) {
		return true;
	    }
	    if (o == null || hashCode() != o.hashCode()) {
		return false;
	    }
	    return getSemanticIdentityOfSuper().equals(o) && toEnd == ((AssociationNavigationStepIdentity)o).getNavigationStep().toEnd;
	}

	@Override
	public int calculateHashCode() {
	    return getSemanticIdentityOfSuper().hashCode() ^ toEnd.hashCode();
	}

	private AssociationNavigationStep getNavigationStep(){
	    return AssociationNavigationStep.this;
	}

	@Override
	public NavigationStep getStep() {
	    return getNavigationStep();
	}
    }

    private SemanticIdentity getSemanticIdentityOfSuper(){
	return super.getSemanticIdentity();
    }

    @Override
    protected Set<AnnotatedEObject> navigate(AnnotatedEObject fromObject, TracebackCache cache, Notification changeEvent) {
        Set<AnnotatedEObject> result = new HashSet<AnnotatedEObject>();
        // we have a "normal" EReference
        Object ref = fromObject.eGet(toEnd);
        if (toEnd.isMany()) {
            // eGet(toEnd) will return a list of EObjects
            if (ref instanceof EList<?>) {
                Iterator<?> it = ((EList<?>) ref).iterator();
                while (it.hasNext()) {
                    Object elem = it.next();
                    if (elem instanceof EObject) {
                        result.add(annotateEObject(fromObject, (EObject) elem));
                    }
                }
            }
        } else {
            // eGet(toEnd) will return an EObject
            if (ref != null) {
                result.add(annotateEObject(fromObject, (EObject) ref));
            }
        }
        return result;
    }

    @Override
    public String contentToString(Map<NavigationStep, Integer> visited, int indent) {
        return toEnd.getName();
    }

    @Override
    public SemanticIdentity getSemanticIdentity() {
	return semanticIdentity;
    }
}