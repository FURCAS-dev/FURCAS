package com.sap.runlet.abstractinterpreter.objects;


import com.sap.runlet.abstractinterpreter.repository.RepositoryObject;
import com.sap.runlet.abstractinterpreter.repository.SnapshotIdentifier;

/**
 * Represents an object that is instance of a class.
 * 
 * @author Axel Uhl (D043530)
 */
public abstract class ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage extends TypeUsage>
extends RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> implements RepositoryObject {
    /**
     * Snapshot this object originates from and in which association navigation starting
     * at this object shall be interpreter. May be a special {@link SnapshotPointer} that
     * means that the object will be interpreted as part of the snapshot that the
     * {@link RiverInterpreter interpreter} considers its default snapshot.
     */
    private SnapshotIdentifier origin;
    
    private boolean persistent = false;

    public ClassTypedObject(ClassUsage type, SnapshotIdentifier snapshot) {
	super(type);
	assert snapshot != null;
	this.origin = snapshot;
    }

    @SuppressWarnings("unchecked")
    @Override
    public ClassUsage getType() {
	return (ClassUsage) super.getType();
    }
    
    @Override
    public ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> getCopyWithOrigin(SnapshotIdentifier snapshotIdentifier) {
	ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> result;
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
    
    @SuppressWarnings("unchecked")
    @Override
    public ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> clone() {
	try {
	    return (ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>) super.clone();
	} catch (CloneNotSupportedException e) {
	    throw new RuntimeException("Internal error: ClassTypedObject should be cloneable: "+this, e);
	}
    }

}
