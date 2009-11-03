package com.sap.river.interpreter.repository;

import java.util.Set;

import com.sap.river.interpreter.objects.EntityObject;
import com.sap.river.interpreter.objects.Link;

import data.classes.Multiplicity;

/**
 * Describes a single change in a {@link ChangeSet}. Positions must be specified
 * for {@link Link links} of ordered associations. An association is ordered if
 * one of its ends is marked {@link Multiplicity#isOrdered() ordered}.
 * <p>
 * 
 * Equality and hash code are basaed on Java object identity, not on content.
 * 
 * @author Axel Uhl D043530
 * @author Jan Karstens D046040
 * 
 */
public abstract class RepositoryChange implements Cloneable {
    private RepositoryObject object;
    public RepositoryChange(RepositoryObject object) {
	super();
	this.object = object;
    }

    public RepositoryObject getObject() {
	return object;
    }

    /**
     * Returns <tt>true</tt> iff this change describes the creation of an entity
     * or a link.
     */
    public abstract boolean isCreate();

    public abstract void apply(Set<EntityObject> entities, SimpleLinkContainer links);

    /**
     * Returns <tt>true</tt> iff this change describes the deletion of an entity
     * or a link.
     */
    public boolean isDelete() {
	return !isCreate();
    }

    /**
     * Returns <code>true</code> iff this change describes an entity.
     * @return
     */
    public abstract boolean isEntityChange();

    /**
     * Returns <code>true</code> iff this change describes a link.
     * @return
     */
    public boolean isLinkChange() {
	return !isEntityChange();
    }
    
    public Object clone() {
	try {
	    return super.clone();
	} catch (CloneNotSupportedException e) {
	    // this should never happen unless someone changes the super class of this class
	    throw new RuntimeException(e);
	}
    }

    /**
     * Records this change in <tt>changeSet</tt>. A new {@link RepositoryChange}
     * object will be created in the change set as a copy of this change.
     */
    public abstract void addTo(ChangeSetImpl changeSet);
    
}
