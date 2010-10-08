package de.hpi.sam.bp2009.solution.impactAnalyzer.util;

import java.util.Map;

import org.eclipse.ocl.ecore.OperationCallExp;

public class EntryIterableWithIterableForNullKey implements Map.Entry<OperationCallExp, Iterable<AnnotatedEObject>> {
    private final Iterable<AnnotatedEObject> iterable;

    public EntryIterableWithIterableForNullKey(Iterable<AnnotatedEObject> iterable) {
        this.iterable = iterable;
    }

    public OperationCallExp getKey() {
        return null;
    }

    public Iterable<AnnotatedEObject> getValue() {
        return iterable;
    }

    public Iterable<AnnotatedEObject> setValue(Iterable<AnnotatedEObject> value) {
        throw new UnsupportedOperationException("setValue() not supported here");
    }
}
