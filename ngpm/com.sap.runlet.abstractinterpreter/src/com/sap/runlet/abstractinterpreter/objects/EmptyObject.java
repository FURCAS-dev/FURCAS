package com.sap.runlet.abstractinterpreter.objects;

import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.naming.OperationNotSupportedException;

import com.sap.runlet.abstractinterpreter.util.TypeService;

public final class EmptyObject<LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage extends TypeUsage>
extends RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> {
    private final TypeService<TypeUsage> typeService;
    
    static final String MESSAGE = "<empty>";

    /**
     * Reusable iterator implementation with empty behavior.
     */
    private Iterator<RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>> staticIterator =
	new Iterator<RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>>() {
	@Override
	public boolean hasNext() {
	    return false;
	}

	@Override
	public RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> next() {
	    throw new NoSuchElementException("called next twice on a single-valued object");
	}

	@Override
	public void remove() {
	    throw new RuntimeException(new OperationNotSupportedException(
		    "no remove on RiverObject"));
	}
    };

    /**
     * The class service is required to check type conformance in {@link #logicallyEquals(RunletObject)}.
     */
    public EmptyObject(TypeUsage type, TypeService<TypeUsage> typeService) {
	super(type);
	this.typeService = typeService;
    }

    public final int size() {
	return 0;
    }

    public Iterator<RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>> iterator() {
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
    public boolean logicallyEquals(RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> other) {
	return this.size() == other.size() && typeService.aConformsToB(this.getType(), other.getType());
    }
    
    /**
     * Computes a hash code that is based only on those features that also contribute to
     * the definition of {@link #logicallyEquals(RunletObject)}.
     */
    public int logicalHashCode() {
	return getType().hashCode();
    }
}
