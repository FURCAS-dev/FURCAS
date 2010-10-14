package com.sap.runlet.abstractinterpreter.util;

import java.util.Iterator;

public class RelaxingIteratorWrapper<S, T extends S> implements Iterator<S> {
    private Iterator<T> iterator;
    
    public RelaxingIteratorWrapper(Iterator<T> iterator) {
	this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
	return iterator.hasNext();
    }

    @Override
    public S next() {
	return iterator.next();
    }

    @Override
    public void remove() {
	iterator.remove();
    }
}
