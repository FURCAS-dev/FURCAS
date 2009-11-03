package com.sap.river.interpreter.objects;



import java.util.Iterator;
import java.util.List;

import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.repository.SnapshotIdentifier;

import data.classes.ClassTypeDefinition;

/**
 * Represents an object that is instance of a native class, such as a string
 * for which a native representation may be used, or a number. Key functionality
 * of a native object is that it can be cloned, e.g., to produce a copy which then
 * can have composite parts replaced as compared to the original.<p>
 * 
 * Equality/hash code is based on the equality/hash code of the native object plus
 * the exposed composite association ends' values.
 * 
 * @author Axel Uhl (D043530)
 */
public class NativeObject extends ValueObject {
    private Object nativeObject;
    
    public NativeObject(ClassTypeDefinition type, Object object, SnapshotIdentifier snapshot, RiverInterpreter interpreter) {
	super(type, snapshot, interpreter);
	this.nativeObject = object;
    }
    
    public NativeObject(ClassTypeDefinition type, List<RiverObject> actualObjectParameters, Object object, SnapshotIdentifier snapshot, RiverInterpreter interpreter) {
	super(type, snapshot, interpreter);
	this.nativeObject = object;
    }
    
    public Object getNativeObject() {
	return nativeObject;
    }
    
    public boolean equals(Object o) {
	if (!(o instanceof NativeObject)) {
	    return false;
	}
	return getNativeObject().equals(((NativeObject) o).getNativeObject()) &&
		super.equals(o);
    }
    
    public boolean logicallyEquals(RiverObject o) {
	if (this == o) {
	    return true;
	}
	Iterator<RiverObject> oIter = o.iterator();
	if (!oIter.hasNext()) {
	    return false;
	}
	RiverObject oro = oIter.next();
	if (oIter.hasNext() || !(oro instanceof NativeObject)) {
	    return false;
	}
	if (this == oro) {
	    return true;
	}
	return getNativeObject().equals(((NativeObject) o).getNativeObject()) && super.logicallyEquals(o);
    }
    
    @Override
    public int logicalHashCode() {
	return getNativeObject().hashCode() ^ super.logicalHashCode();
    }
    
    public int hashCode() {
	return getNativeObject().hashCode() ^ super.hashCode();
    }
    
    public String toString() {
	return getNativeObject().toString();
    }
    
    
}
