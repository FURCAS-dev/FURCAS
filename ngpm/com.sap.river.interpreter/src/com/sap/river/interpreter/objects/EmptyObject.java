package com.sap.river.interpreter.objects;

import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.naming.OperationNotSupportedException;

import data.classes.TypeDefinition;

public final class EmptyObject extends RiverObject {
    
    static final String MESSAGE = "<empty>";

    /**
     * Reusable iterator implementation with empty behavior.
     */
    private final static Iterator<RiverObject> staticIterator = new Iterator<RiverObject>() {
	@Override
	public boolean hasNext() {
	    return false;
	}

	@Override
	public RiverObject next() {
	    throw new NoSuchElementException("called next twice on a single-valued object");
	}

	@Override
	public void remove() {
	    throw new RuntimeException(new OperationNotSupportedException(
		    "no remove on RiverObject"));
	}
    };

    public EmptyObject(TypeDefinition type) {
	super(type);
    }

    public final int size() {
	return 0;
    }

    public Iterator<RiverObject> iterator() {
	return  staticIterator;
    }
    
    @Override
    public String toString() {
	return MESSAGE;
    }
    
    /**
     * An EmptyObject is always logically equals to all other EmptyObjects
     * with a conforming {@link TypeDefinition}.
     */
    public boolean logicallyEquals(RiverObject other) {
	return this.getType().conformsTo(other.getType());
    }
    
    /**
     * Computes a hash code that is based only on those features that also contribute to
     * the definition of {@link #logicallyEquals(RiverObject)}.
     */
    public int logicalHashCode() {
	return getType().hashCode();
    }
}
