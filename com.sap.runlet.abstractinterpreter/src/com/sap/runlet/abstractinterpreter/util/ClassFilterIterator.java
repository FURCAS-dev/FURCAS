package com.sap.runlet.abstractinterpreter.util;

import java.util.Iterator;

/**
 * An iterator that wraps another iterator and returns only those elements
 * that are assigment compatible to class <tt>E</tt>.
 * 
 * @author Axel Uhl D043530
 */
public class ClassFilterIterator<E> implements Iterator<E> {
    private Iterator<?> iterator;
    private Class<?> clazz;
    private E next;
    private boolean hasNext; // needed because iterators may return null values
    
    public ClassFilterIterator(Class<?> clazz, Iterator<?> iterator) {
	this.clazz = clazz;
	this.iterator = iterator;
	determineNext();
    }

    @SuppressWarnings("unchecked")
    private void determineNext() {
	boolean found = false;
	hasNext = false;
	while (!found && iterator.hasNext()) {
	    Object nextCandidate = iterator.next();
	    if (nextCandidate == null || clazz.isAssignableFrom(nextCandidate.getClass())) {
	    	next = (E) nextCandidate;
	    	hasNext = true;
	    	found = true;
	    }
	}
    }
    
    @Override
    public boolean hasNext() {
	return hasNext;
    }

    @Override
    public E next() {
	E result = next;
	determineNext();
	return result;
    }

    @Override
    public void remove() {
	throw new UnsupportedOperationException("remove not supported on this iterator type");
    }

}
