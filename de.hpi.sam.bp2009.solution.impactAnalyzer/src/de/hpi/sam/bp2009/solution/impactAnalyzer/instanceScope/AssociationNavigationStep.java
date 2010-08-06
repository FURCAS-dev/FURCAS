package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

public class AssociationNavigationStep extends AbstractNavigationStep {
    private final EReference toEnd;

    public AssociationNavigationStep(EClass sourceType, EClass targetType, EReference toEnd, OCLExpression debugInfo) {
        super(sourceType, targetType, debugInfo);
        this.toEnd = toEnd;
    }
    
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || hashCode() != o.hashCode()) {
            return false;
        }
        return super.equals(o) && toEnd == ((AssociationNavigationStep) o).toEnd;
    }
    
    public int hashCode() {
        return super.hashCode() ^ toEnd.hashCode();
    }

    @Override
    protected Set<AnnotatedEObject> navigate(AnnotatedEObject fromObject, Map<List<Object>, Set<AnnotatedEObject>> cache, Notification changeEvent) {
        // check if we can satisfy the request from the cache
        List<Object> cacheLookup = new BasicEList<Object>();
        cacheLookup.add(this);
        cacheLookup.add(fromObject);
        if (cache.containsKey(cacheLookup))
            return cache.get(cacheLookup);

        // cache lookup was unsuccessful -> perform the navigation
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

        // update the cache
        cache.put(cacheLookup, result);
        return result;
    }

    @Override
    public String contentToString(Map<NavigationStep, Integer> visited, int indent) {
        return toEnd.getName();
    }
}
