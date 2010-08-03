package com.sap.emf.ocl.hiddenopposites;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;

/**
 * A content adapter that maintains a map of all {@link EObject}s in the scope observed (typically
 * a {@link ResourceSet}), keyed by the {@link EClass}es to which the objects conform. This allows
 * for fast lookup, e.g., of an <code>allInstances()</code> expression value in the given scope.
 * 
 * @author Axel Uhl
 *
 */
public class AllInstancesContentAdapter extends EContentAdapter {
    private Map<EClass, Set<EObject>> allInstances = new HashMap<EClass, Set<EObject>>();
    
    @Override
    protected void setTarget(EObject target) {
        for (EClass c : target.eClass().getEAllSuperTypes()) {
            put(c, target);
        }
        put(target.eClass(), target);
        super.setTarget(target);
    }

    private void put(EClass c, EObject target) {
        Set<EObject> set = allInstances.get(c);
        if (set == null) {
            set = new HashSet<EObject>();
            allInstances.put(c, set);
        }
        set.add(target);
    }

    @Override
    protected void unsetTarget(EObject target) {
        for (EClass c : target.eClass().getEAllSuperTypes()) {
            remove(c, target);
        }
        remove(target.eClass(), target);
        super.unsetTarget(target);
    }

    private void remove(EClass c, EObject target) {
        Set<EObject> set = allInstances.get(c);
        if (set != null) {
            if (set.remove(target)) {
                if (set.isEmpty()) {
                    allInstances.remove(c);
                }
            }
        }
    }
    
    public Set<EObject> allInstances(EClass c) {
        Set<EObject> result = allInstances.get(c);
        if (result == null) {
            result = Collections.emptySet();
        }
        return result;
    }
}
