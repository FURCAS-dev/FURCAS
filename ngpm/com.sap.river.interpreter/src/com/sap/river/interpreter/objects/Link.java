package com.sap.river.interpreter.objects;

import java.util.Arrays;
import java.util.List;

import com.sap.river.interpreter.LinkContainer;
import com.sap.river.interpreter.Side;
import com.sap.river.interpreter.repository.RepositoryObject;
import com.sap.river.interpreter.repository.SnapshotIdentifier;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.Multiplicity;

/**
 * Represents a link between two objects on behalf of an association. Links are immutable and can
 * only be created, added to and removed from the {@link LinkContainer link container}. The
 * {@link RiverObject}s on a link's ends are guaranteed not to be multi-objects.
 * <p>
 * 
 * Equality and hash code are based on the equality/hashCode of the two ends as well as the
 * equality/hashCode of the association of which this link is an instance.
 * 
 * @author Axel Uhl (D043530)
 */
public class Link implements RepositoryObject {
    private ClassTypedObject[] ends;
    private Association association;
    private SnapshotIdentifier origin;
    private boolean persistent = false;
    
    public Link(ClassTypedObject left, ClassTypedObject right, Association association, SnapshotIdentifier snapshot) {
	assert snapshot != null;
	assert left.getOrigin().equals(right.getOrigin());
	assert left.getOrigin().equals(snapshot);
	this.ends = new ClassTypedObject[Side.values().length];
	this.ends[Side.LEFT.endNumber()] = left;
	this.ends[Side.RIGHT.endNumber()] = right;
	this.association = association;
	this.origin = snapshot;
    }

    public ClassTypedObject getLeft() {
	return ends[Side.LEFT.endNumber()];
    }

    public ClassTypedObject getRight() {
	return ends[Side.RIGHT.endNumber()];
    }

    public ClassTypedObject get(Side side) {
	return ends[side.endNumber()];
    }
    
    public ClassTypedObject getAtOrderedEnd() {
	Side orderedSide = getOrderedSide();
	if (orderedSide == null) {
	    throw new RuntimeException("Trying to obtain ordered end from link "+this+
		    " of unordered association "+getAssociation().getName());
	}
	return get(orderedSide);
    }
    
    public ClassTypedObject getAtOppositeOfOrderedEnd() {
	Side orderedSide = getOrderedSide();
	if (orderedSide == null) {
	    throw new RuntimeException("Trying to obtain ordered end from link "+this+
		    " of unordered association "+getAssociation().getName());
	}
	return get(orderedSide.otherEnd());
    }
    
    /**
     * If <tt>cto</tt> appears on one side, that side is returned. If it appears on no side,
     * <tt>null</tt> is returned. If it appears on both sides, one side is arbitrarily chosen and
     * a non-<tt>null</tt> side is returned.
     */
    public Side getSideOf(ClassTypedObject cto) {
	for (Side side:Side.values()) {
	    if (get(side).equals(cto)) {
		return side;
	    }
	}
	return null;
    }

    public Association getAssociation() {
	return association;
    }

    @Override
    public int hashCode() {
	return association.hashCode() ^ ends[0].hashCode() ^ ends[1].hashCode()
		^ ((getOrigin() == null) ? 0 : getOrigin().hashCode());
    }

    @Override
    public boolean equals(Object o) {
	if (!(o instanceof Link)) {
	    return false;
	}
	Link l = (Link) o;
	return association.equals(l.association)
		&& Arrays.equals(l.ends, ends)
		&& (getOrigin() == l.getOrigin() || ((getOrigin() != null) && getOrigin().equals(
			l.getOrigin())));
    }

    public int logicalHashCode() {
	return association.hashCode() ^ ends[0].logicalHashCode() ^ ends[1].logicalHashCode();
    }
    
    public boolean logicallyEquals(Object o) {
	if (!(o instanceof Link)) {
	    return false;
	}
	Link l = (Link) o;
	return association.equals(l.association)
		&& Arrays.equals(l.ends, ends);
    }
    
    /**
     * Fixing the origin (snapshot) of a link also adjusts the snapshots of the two ends.
     */
    @Override
    public Link getCopyWithOrigin(SnapshotIdentifier snapshotIdentifier) {
	Link linkWithSnapshotAdjusted;
	if (getOrigin() != snapshotIdentifier) {
	    linkWithSnapshotAdjusted = new Link(
		    get(Side.LEFT).getCopyWithOrigin(snapshotIdentifier), 
		    get(Side.RIGHT).getCopyWithOrigin(snapshotIdentifier),
		    getAssociation(), snapshotIdentifier);
	    linkWithSnapshotAdjusted.setPersistent(isPersistent());
	} else {
	    linkWithSnapshotAdjusted = this;
	}
	return linkWithSnapshotAdjusted;
    }
    
    public Link clone() {
	try {
	    return (Link) super.clone();
	} catch (CloneNotSupportedException e) {
	    throw new RuntimeException("Internal error: link should be cloneable: "+this, e);
	}
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
    public boolean isUnique() {
	return getAssociation().getEnds().get(0).getType().isUnique();
    }
    
    /**
     * Tells if the association of which this link is an instance has an
     * {@link Multiplicity#isOrdered() ordered} end.
     */
    public boolean isOrdered() {
	return getOrderedSide() != null;
    }

    /**
     * Tells which of the two sides of the {@link #getAssociation() association} of which
     * this link is an instance is ordered. Returns <tt>null</tt> if both ends are unordered.
     */
    public Side getOrderedSide() {
	List<AssociationEnd> ends = getAssociation().getEnds();
	for (Side side : Side.values()) {
	    if (ends.get(side.endNumber()).getType().isOrdered()) {
		return side;
	    }
	}
	return null;
    }

    @Override
    public String toString() {
	return getAssociation().getName() + Arrays.toString(ends);
    }
}