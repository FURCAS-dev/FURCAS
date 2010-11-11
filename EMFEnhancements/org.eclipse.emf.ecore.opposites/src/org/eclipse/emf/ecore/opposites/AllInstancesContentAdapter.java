/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.emf.ecore.opposites;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * A content adapter that maintains a map of all {@link EObject}s in the scope observed (typically
 * a {@link ResourceSet}), keyed by the {@link EClass}es to which the objects conform. This allows
 * for fast lookup, e.g., of an <code>allInstances()</code> expression value in the given scope.
 * 
 * @author Axel Uhl
 * @since 3.0
 *
 */
public class AllInstancesContentAdapter extends EContentAdapter {
    private Map<EClass, Set<EObject>> allInstances = new HashMap<EClass, Set<EObject>>();
    
    /**
     * Looks up an adapter of type {@link AllInstancesContentAdapter} in the adapter list of
     * <code>context</code>'s root context. The root context is determined by ascending the {@link EObject}
     * containment hierarchy, then to a {@link Resource} and perhaps a {@link ResourceSet}. The last element
     * reachable in this order is the root context. If on this root context an adapter of type
     * {@link AllInstancesContentAdapter} is already registered, it is returned. Otherwise, a new
     * adapter of this class is created and added to the root context's adapter list. This will recursively
     * apply the adapter to all contents, populating the adapter's <code>allInstances</code> map so that
     * afterwards {@link #allInstances(EClass)} returns results in the scope of <code>context</code>'s
     * root context.
     */
    public static AllInstancesContentAdapter getInstanceForRootContextOf(Notifier context) {
        Notifier rootContext = getRootContext(context);
        for (Adapter a : rootContext.eAdapters()) {
            if (a instanceof AllInstancesContentAdapter) {
                return (AllInstancesContentAdapter) a;
            }
        }
        AllInstancesContentAdapter result = new AllInstancesContentAdapter();
        rootContext.eAdapters().add(result);
        return result;
    }

    private static Notifier getRootContext(Notifier context) {
        Notifier rootContext;
        if (context instanceof ResourceSet) {
            rootContext = context;
        } else if (context instanceof Resource) {
            if (((Resource) context).getResourceSet() != null) {
                rootContext = ((Resource) context).getResourceSet();
            } else {
                rootContext = context;
            }
        } else if (context instanceof EObject) {
            EObject rootEObject = EcoreUtil.getRootContainer((EObject) context);
            Resource rootResource = rootEObject.eResource();
            if (rootResource != null) {
                ResourceSet rootResourceSet = rootResource.getResourceSet();
                if (rootResourceSet != null) { 
                    rootContext = rootResourceSet;
                } else {
                    rootContext = rootResource;
                }
            } else {
                rootContext = rootEObject;
            }
        } else {
            throw new RuntimeException("What type of Notifier is this? " + context.getClass().getName());
        }
        return rootContext;
    }

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
