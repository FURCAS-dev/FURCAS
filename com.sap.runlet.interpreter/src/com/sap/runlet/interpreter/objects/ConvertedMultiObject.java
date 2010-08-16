package com.sap.runlet.interpreter.objects;

import java.util.Iterator;

import com.sap.runlet.abstractinterpreter.objects.MultiValuedObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.interpreter.RunletInterpreter;

import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.TypeDefinition;

/**
 * Wraps a {@link MultiValuedObject} and converts the objects on the fly during iteration
 * to the {@link #getType() target type}. An object of this type is always tied to a single
 * {@link RunletInterpreter interpreter} which is required for performing the actual conversion.
 * 
 * @author Axel Uhl (D043530)
 */
public class ConvertedMultiObject extends MultiValuedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> {
    private MultiValuedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> wrapped;
    
    /**
     * The interpreter is required for performing the actual conversion.
     */
    private RunletInterpreter interpreter;
    
    private class ConvertingIterator implements Iterator<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> {
	Iterator<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> wrappedIterator;
	
	public ConvertingIterator() {
	    wrappedIterator = wrapped.iterator();
	}
	
	@Override
	public boolean hasNext() {
	    return wrappedIterator.hasNext();
	}

	@Override
	public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> next() {
	    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> unconverted = wrappedIterator.next();
	    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> result = interpreter.convert(unconverted, getType());
	    return result;
	}

	@Override
	public void remove() {
	    wrappedIterator.remove();
	}
    }
    
    public ConvertedMultiObject(MultiValuedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> wrapped,
	    TypeDefinition targetType, RunletInterpreter interpreter, boolean ordered, boolean unique) {
	super(targetType, /* objects */ null, ordered, unique);
	this.wrapped = wrapped;
	this.interpreter = interpreter;
    }

    @Override
    public Iterator<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> iterator() {
	return new ConvertingIterator();
    }

    @Override
    public int size() {
	return wrapped.size();
    }

}
