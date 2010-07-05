package com.sap.emf.ocl.hiddenopposites;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

public class ExtentMap implements Map<EClass, Set<EObject>> {
    private final Map<EClass, Set<EObject>> delegate;
    private OppositeEndFinder oppositeEndFinder;
    private EObject context;

    public ExtentMap(EObject context, OppositeEndFinder oppositeEndFinder) {
        this.context = context;
        this.oppositeEndFinder = oppositeEndFinder;
        this.delegate = new HashMap<EClass, Set<EObject>>();
    }

    /**
     * Lazily computes the extent of the specified class <code>key</code> based on a forward lookup on the
     * {@link OppositeEndFinder} passed to this map during construction.
     * 
     * @param key
     *            a class in the model
     */
    public Set<EObject> get(Object cls) {
        Set<EObject> result = delegate.get(cls);
        if (result == null) {
            result = oppositeEndFinder.getAllInstancesSeenBy((EClass) cls, context);
            delegate.put((EClass) cls, result);
        }
        return result;
    }

    public int size() {
        return delegate.size();
    }

    public boolean isEmpty() {
        return delegate.isEmpty();
    }

    public boolean containsKey(Object key) {
        return delegate.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return delegate.containsValue(value);
    }

    public Set<EObject> put(EClass key, Set<EObject> value) {
        return delegate.put(key, value);
    }

    public Set<EObject> remove(Object key) {
        return delegate.remove(key);
    }

    public void putAll(Map<? extends EClass, ? extends Set<EObject>> m) {
        delegate.putAll(m);
    }

    public void clear() {
        delegate.clear();
    }

    public Set<EClass> keySet() {
        return delegate.keySet();
    }

    public Collection<Set<EObject>> values() {
        return delegate.values();
    }

    public Set<java.util.Map.Entry<EClass, Set<EObject>>> entrySet() {
        return delegate.entrySet();
    }

}
