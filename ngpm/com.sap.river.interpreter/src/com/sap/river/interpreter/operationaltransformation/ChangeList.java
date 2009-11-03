package com.sap.river.interpreter.operationaltransformation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.sap.river.interpreter.repository.RepositoryChange;

public class ChangeList implements Change {
    private List<Change> changes;
    
    public ChangeList(Change[] changes) {
	this.changes = Arrays.asList(changes);
    }
    
    public ChangeList() {
	this.changes = new ArrayList<Change>();
    }
    
    public void add(Change change) {
	changes.add(change);
    }

    @Override
    public int totalSize() {
	int result = 0;
	for (Change c : changes) {
	    result += c.totalSize();
	}
	return result;
    }

    @Override
    public Iterator<RepositoryChange> iterator() {
	return new Iterator<RepositoryChange>() {
	    private Iterator<Change> iteratorOverChanges = changes.iterator();
	    private Iterator<RepositoryChange> localIterator = null;
	    
	    @Override
	    public boolean hasNext() {
		if (localIterator == null || !localIterator.hasNext()) {
		    if (iteratorOverChanges.hasNext()) {
			localIterator = iteratorOverChanges.next().iterator();
			return hasNext(); // try again
		    } else {
			return false;
		    }
		} else {
		    return true;
		}
	    }
	    @Override
	    public RepositoryChange next() {
		if (localIterator == null || !localIterator.hasNext()) {
		    localIterator = iteratorOverChanges.next().iterator();
		    return next();
		} else {
		    return localIterator.next();
		}
	    }
	    @Override
	    public void remove() {
		throw new UnsupportedOperationException("remove not supported");
	    }
	};
    }
    
    @Override
    public String toString() {
	return changes.toString();
    }
}
