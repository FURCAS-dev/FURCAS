package com.sap.runlet.abstractinterpreter.operationaltransformation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.sap.runlet.abstractinterpreter.repository.RepositoryChange;

public class ChangeList<LinkMetaObject extends EObject, LinkEndMetaObject extends EObject,
MetaClass extends EObject, TypeUsage extends EObject, ClassUsage extends TypeUsage>
implements Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> {
    private List<Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> changes;
    
    public ChangeList(Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>[] changes) {
	this.changes = Arrays.asList(changes);
    }
    
    public ChangeList() {
	this.changes = new ArrayList<Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>();
    }
    
    public void add(Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> change) {
	changes.add(change);
    }

    @Override
    public int totalSize() {
	int result = 0;
	for (Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> c : changes) {
	    result += c.totalSize();
	}
	return result;
    }

    @Override
    public Iterator<RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> iterator() {
	return new Iterator<RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>() {
	    private Iterator<Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> iteratorOverChanges = changes.iterator();
	    private Iterator<RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> localIterator = null;
	    
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
	    public RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> next() {
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
