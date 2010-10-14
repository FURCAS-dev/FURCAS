package com.sap.runlet.abstractinterpreter.util;

import java.util.Iterator;

public class RelaxingIterableWrapper<S, T extends S> implements Iterable<S> {
    private Iterable<T> iterable;

    public RelaxingIterableWrapper(Iterable<T> iterable) {
	super();
	this.iterable = iterable;
    }

    @Override
    public Iterator<S> iterator() {
	return new RelaxingIteratorWrapper<S, T>(iterable.iterator());
    }
}
