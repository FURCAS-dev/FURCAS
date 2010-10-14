package com.sap.runlet.interpreter.objects;



import java.util.Iterator;
import java.util.List;

import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.abstractinterpreter.repository.SnapshotIdentifier;
import com.sap.runlet.interpreter.RunletInterpreter;

import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.TypeDefinition;

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
    
    public NativeObject(ClassTypeDefinition type, Object object, SnapshotIdentifier snapshot,
	    RunletInterpreter interpreter) {
	super(type, snapshot, interpreter);
	this.nativeObject = object;
    }
    
    public NativeObject(ClassTypeDefinition type, List<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> actualObjectParameters,
	    Object object, SnapshotIdentifier snapshot, RunletInterpreter interpreter) {
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
    
    public boolean logicallyEquals(RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> o) {
	if (this == o) {
	    return true;
	}
	Iterator<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> oIter = o.iterator();
	if (!oIter.hasNext()) {
	    return false;
	}
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> oro = oIter.next();
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
