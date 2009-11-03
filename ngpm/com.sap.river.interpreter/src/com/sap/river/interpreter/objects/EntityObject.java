package com.sap.river.interpreter.objects;

import java.util.Iterator;
import java.util.UUID;

import com.sap.river.interpreter.repository.SnapshotIdentifier;

import data.classes.ClassTypeDefinition;

/**
 * Represents an object that is instance of a entity class. It is only a container for an ID
 * uniquely identifying the object to be referenced by association links, as well as a reference to
 * its type. Both, type and ID are immutable.
 * <p>
 * 
 * Hash code and equals are implemented based on the ID.
 * 
 * @author Axel Uhl (D043530)
 */
public class EntityObject extends ClassTypedObject {
    private UUID id;
    /**
     * Generates a new UUID for the object. To be used when a new object is constructed that
     * requires a new identity.
     */
    public EntityObject(ClassTypeDefinition type, SnapshotIdentifier snapshot) {
	super(type, snapshot);
	id = UUID.randomUUID();
    }

    /**
     * Constructs an object based on a previously known ID, such as when loading the object from
     * some persistent representation.
     */
    public EntityObject(ClassTypeDefinition type, UUID id, SnapshotIdentifier snapshot) {
	this(type, snapshot);
	this.id = id;
    }

    public UUID getId() {
	return id;
    }
    
    public EntityObject clone() {
	return (EntityObject) super.clone();
    }

    public int hashCode() {
	return id.hashCode() ^ (( getOrigin() == null) ? 0 : getOrigin().hashCode() );
    }

    public boolean equals(Object o) {
	if (!(o instanceof RiverObject)) {
	    return false;
	}
	Iterator<RiverObject> oIter = ((RiverObject) o).iterator();
	if (!oIter.hasNext()) {
	    return false;
	}
	RiverObject oro = oIter.next();
	if (oIter.hasNext() || !(oro instanceof EntityObject)) {
	    return false;
	}
	if (this == oro) {
	    return true;
	}
	EntityObject other = (EntityObject) oro;
	return getId().equals(other.getId())
		&& (getOrigin() == other.getOrigin() 
			|| ((getOrigin() != null) 
				&& getOrigin().equals(other.getOrigin())
			    )
			);
    }

    /**
     * Logically, two entities equal each other if they have equal IDs. The {@link #getOrigin() snapshot}
     * to which they pertain does not matter for this comparison.<p>
     * 
     * TODO Shouldn't this also just evaluate the equality-relevant association ends?
     */
    public boolean logicallyEquals(RiverObject o) {
	if (this == o) {
	    return true;
	}
	Iterator<RiverObject> oIter = o.iterator();
	if (!oIter.hasNext()) {
	    return false;
	}
	RiverObject oro = oIter.next();
	if (oIter.hasNext() || !(oro instanceof EntityObject)) {
	    return false;
	}
	if (this == oro) {
	    return true;
	}
	return getId().equals(((EntityObject) oro).getId());
    }
    
    @Override
    public int logicalHashCode() {
	return id.hashCode();
    }

    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder("Entity ");
	sb.append(getId());
	sb.append(" of class ");
	sb.append(getType().getClazz().getName());
	sb.append(" @ ");
	sb.append(getOrigin());
	return sb.toString();
    }

    @Override
    public boolean isUnique() {
	return true;
    }

}
