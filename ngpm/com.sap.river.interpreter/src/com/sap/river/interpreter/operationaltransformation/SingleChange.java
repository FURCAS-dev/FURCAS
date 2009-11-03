package com.sap.river.interpreter.operationaltransformation;

import java.util.Iterator;

import com.sap.river.interpreter.repository.RepositoryChange;

public class SingleChange implements Change {
    private RepositoryChange change;
    
    public SingleChange(RepositoryChange change) {
	this.change = change;
    }

    @Override
    public int totalSize() {
	return 1;
    }

    @Override
    public Iterator<RepositoryChange> iterator() {
	return new Iterator<RepositoryChange>() {
	    private boolean nextCalled = false;
	    @Override
	    public boolean hasNext() {
		return !nextCalled;
	    }
	    @Override
	    public RepositoryChange next() {
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
