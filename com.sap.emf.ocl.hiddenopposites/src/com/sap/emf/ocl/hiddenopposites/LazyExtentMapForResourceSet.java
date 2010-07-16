package com.sap.emf.ocl.hiddenopposites;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class LazyExtentMapForResourceSet implements Map<EClass, Set<EObject>> {
    private final Map<EClass, Set<EObject>> delegate = new java.util.HashMap<EClass, Set<EObject>>();

    private final Notifier rootContext;

    public LazyExtentMapForResourceSet(Notifier context) {
        if (context instanceof ResourceSet) {
            rootContext = context;
        } else if (context instanceof Resource) {
            if (((Resource) context).getResourceSet() != null) {
                rootContext = ((Resource) context).getResourceSet();
            } else {
                rootContext = context;
            }
        } else if (context instanceof EObject) {
            rootContext = EcoreUtil.getRootContainer((EObject) context);
        } else {
            throw new RuntimeException("What type of Notifier is this? " + context.getClass().getName());
        }
    }

    private boolean isInstance(EClass EClass, Object element) {
        return EClass.isInstance(element);
    }

    /**
     * Lazily computes the extent of the specified class <code>key</code>.
     * 
     * @param key
     *            a class in the model
     */
    public Set<EObject> get(Object key) {
        Set<EObject> result = delegate.get(key);
        if (result == null) {
            EClass EClass = (EClass) key;
            result = new java.util.HashSet<EObject>();
            delegate.put(EClass, result);
            for (Iterator<Notifier> iter = EcoreUtil.getAllContents(Collections.singleton(rootContext)); iter.hasNext();) {
                Object next = iter.next();
                if (isInstance(EClass, next)) {
                    result.add((EObject) next);
                }
            }
        }
        return result;
    }

    public void clear() {
        delegate.clear();
    }

    public boolean containsKey(Object key) {
        return delegate.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return delegate.containsValue(value);
    }

    public Set<Map.Entry<EClass, Set<EObject>>> entrySet() {
        return delegate.entrySet();
    }

    @Override
    public boolean equals(Object obj) {
        return delegate.equals(obj);
    }

    @Override
    public int hashCode() {
        return delegate.hashCode();
    }

    public boolean isEmpty() {
        return delegate.isEmpty();
    }

    public Set<EClass> keySet() {
        return delegate.keySet();
    }

    public Set<EObject> put(EClass key, Set<EObject> value) {
        return delegate.put(key, value);
    }

    public void putAll(Map<? extends EClass, ? extends Set<EObject>> t) {
        delegate.putAll(t);
    }

    public Set<EObject> remove(Object key) {
        return delegate.remove(key);
    }

    public int size() {
        return delegate.size();
    }

    @Override
    public String toString() {
        return delegate.toString();
    }

    public Collection<Set<EObject>> values() {
        return delegate.values();
    }
}
