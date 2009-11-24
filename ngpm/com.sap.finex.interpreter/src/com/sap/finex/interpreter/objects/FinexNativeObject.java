package com.sap.finex.interpreter.objects;



import java.util.Iterator;

import structure.Association;
import structure.Field;
import structure.FinexClass;
import structure.Type;

import com.sap.finex.interpreter.FinexInterpreter;
import com.sap.runlet.abstractinterpreter.objects.AbstractValueObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.abstractinterpreter.repository.SnapshotIdentifier;

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
public class FinexNativeObject extends AbstractValueObject<Association, Field, FinexClass, Type, FinexClass> {
    private Object nativeObject;
    
    public FinexNativeObject(FinexClass type, Object object, SnapshotIdentifier snapshot,
	    FinexInterpreter interpreter) {
	super(type, snapshot, interpreter.getModelAdapter());
	this.nativeObject = object;
    }
    
    public Object getNativeObject() {
	return nativeObject;
    }
    
    public boolean equals(Object o) {
	if (!(o instanceof FinexNativeObject)) {
	    return false;
	}
	return getNativeObject().equals(((FinexNativeObject) o).getNativeObject()) &&
		super.equals(o);
    }
    
    public boolean logicallyEquals(RunletObject<Field, Type, FinexClass> o) {
	if (this == o) {
	    return true;
	}
	Iterator<RunletObject<Field, Type, FinexClass>> oIter = o.iterator();
	if (!oIter.hasNext()) {
	    return false;
	}
	RunletObject<Field, Type, FinexClass> oro = oIter.next();
	if (oIter.hasNext() || !(oro instanceof FinexNativeObject)) {
	    return false;
	}
	if (this == oro) {
	    return true;
	}
	return getNativeObject().equals(((FinexNativeObject) o).getNativeObject()) && super.logicallyEquals(o);
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
