package com.sap.river.interpreter.objects;


import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.repository.RepositoryObject;
import com.sap.river.interpreter.repository.SnapshotIdentifier;

import data.classes.ClassTypeDefinition;

/**
 * Represents an object that is instance of a class.
 * 
 * @author Axel Uhl (D043530)
 */
public abstract class ClassTypedObject extends RiverObject implements RepositoryObject {
    /**
     * Snapshot this object originates from and in which association navigation starting
     * at this object shall be interpreter. May be a special {@link SnapshotPointer} that
     * means that the object will be interpreted as part of the snapshot that the
     * {@link RiverInterpreter interpreter} considers its default snapshot.
     */
    private SnapshotIdentifier origin;
    
    private boolean persistent = false;

    public ClassTypedObject(ClassTypeDefinition type, SnapshotIdentifier snapshot) {
	super(type);
	assert snapshot != null;
	this.origin = snapshot;
    }

    @Override
    public ClassTypeDefinition getType() {
	return (ClassTypeDefinition) super.getType();
    }
    
    @Override
    public ClassTypedObject getCopyWithOrigin(SnapshotIdentifier snapshotIdentifier) {
	ClassTypedObject result;
	if (getOrigin() != snapshotIdentifier) {
	    result = this.clone();
	    result.origin = snapshotIdentifier;
	} else {
	    result = this;
	}
	return result;
    }

    @Override
    public SnapshotIdentifier getOrigin() {
	return origin;
    }

    @Override
    public boolean isPersistent() {
	return persistent;
    }
    
    @Override
    public void setPersistent(boolean persistent) {
	this.persistent = persistent;
    }
    
    @Override
    public ClassTypedObject clone() {
	try {
	    return (ClassTypedObject) super.clone();
	} catch (CloneNotSupportedException e) {
	    throw new RuntimeException("Internal error: ClassTypedObject should be cloneable: "+this, e);
	}
    }

}
