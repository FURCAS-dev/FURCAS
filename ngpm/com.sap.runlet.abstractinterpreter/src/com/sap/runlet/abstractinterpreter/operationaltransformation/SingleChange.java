package com.sap.runlet.abstractinterpreter.operationaltransformation;

import java.util.Iterator;

import com.sap.runlet.abstractinterpreter.repository.RepositoryChange;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class SingleChange<LinkMetaObject extends RefObject, LinkEndMetaObject extends RefObject,
MetaClass extends RefObject, TypeUsage extends RefObject, ClassUsage extends TypeUsage>
implements Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> {
    private RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> change;
    
    public SingleChange(RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> change) {
	this.change = change;
    }

    @Override
    public int totalSize() {
	return 1;
    }

    @Override
    public Iterator<RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> iterator() {
	return new Iterator<RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>() {
	    private boolean nextCalled = false;
	    @Override
	    public boolean hasNext() {
		return !nextCalled;
	    }
	    @Override
	    public RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> next() {
		nextCalled = true;
		return change;
	    }
	    @Override
	    public void remove() {
		throw new UnsupportedOperationException("This iterator type does not support remove");
	    }
	};
    }
    
    @Override
    public String toString() {
	return change.toString();
    }

}
