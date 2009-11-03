package com.sap.river.interpreter.objects;

import java.util.Iterator;

import com.sap.river.interpreter.RiverInterpreter;

import data.classes.TypeDefinition;

/**
 * Wraps a {@link MultiValuedObject} and converts the objects on the fly during iteration
 * to the {@link #getType() target type}. An object of this type is always tied to a single
 * {@link RiverInterpreter interpreter} which is required for performing the actual conversion.
 * 
 * @author Axel Uhl (D043530)
 */
public class ConvertedMultiObject extends MultiValuedObject {
    private MultiValuedObject wrapped;
    
    /**
     * The interpreter is required for performing the actual conversion.
     */
    private RiverInterpreter interpreter;
    
    private class ConvertingIterator implements Iterator<RiverObject> {
	Iterator<RiverObject> wrappedIterator;
	
	public ConvertingIterator() {
	    wrappedIterator = wrapped.iterator();
	}
	
	@Override
	public boolean hasNext() {
	    return wrappedIterator.hasNext();
	}

	@Override
	public RiverObject next() {
	    RiverObject unconverted = wrappedIterator.next();
	    RiverObject result = interpreter.convert(unconverted, getType());
	    return result;
	}

	@Override
	public void remove() {
	    wrappedIterator.remove();
	}
    }
    
    public ConvertedMultiObject(MultiValuedObject wrapped, TypeDefinition targetType,
	    RiverInterpreter interpreter) {
	super(targetType, /* objects */ null);
	this.wrapped = wrapped;
	this.interpreter = interpreter;
    }

    @Override
    public Iterator<RiverObject> iterator() {
	return new ConvertingIterator();
    }

    @Override
    public int size() {
	return wrapped.size();
    }

}
