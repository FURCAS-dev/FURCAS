package com.sap.runlet.abstractinterpreter.objects;

import java.util.Arrays;
import java.util.List;

import com.sap.runlet.abstractinterpreter.Side;
import com.sap.runlet.abstractinterpreter.repository.RepositoryObject;
import com.sap.runlet.abstractinterpreter.repository.SnapshotIdentifier;
import com.sap.runlet.abstractinterpreter.util.AssociationService;

/**
 * Represents a link between two objects on behalf of an association. Links are immutable and can
 * only be created, added to and removed from the {@link LinkContainer link container}. The
 * {@link RunletObject}s on a link's ends are guaranteed not to be multi-objects.
 * <p>
 * 
 * Equality and hash code are based on the equality/hashCode of the two ends as well as the
 * equality/hashCode of the association of which this link is an instance.
 * 
 * @author Axel Uhl (D043530)
 */
public class Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage extends TypeUsage> implements RepositoryObject {
    private ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>[] ends;
    private LinkMetaObject association;
    private SnapshotIdentifier origin;
    private boolean persistent = false;
    private AssociationService<LinkMetaObject, LinkEndMetaObject, MetaClass, ClassUsage> associationService;
    
    @SuppressWarnings("unchecked")
    public Link(ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> left,
	    ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> right,
	    LinkMetaObject association, SnapshotIdentifier snapshot,
	    AssociationService<LinkMetaObject, LinkEndMetaObject, MetaClass, ClassUsage> associationService) {
	assert snapshot != null;
	assert left.getOrigin().equals(right.getOrigin());
	assert left.getOrigin().equals(snapshot);
	this.ends = (ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>[]) new ClassTypedObject<?, ?, ?>[Side.values().length];
	this.ends[Side.LEFT.endNumber()] = left;
	this.ends[Side.RIGHT.endNumber()] = right;
	this.association = association;
	this.origin = snapshot;
	this.associationService = associationService;
    }

    public ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> getLeft() {
	return ends[Side.LEFT.endNumber()];
    }

    public ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> getRight() {
	return ends[Side.RIGHT.endNumber()];
    }

    public ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> get(Side side) {
	return ends[side.endNumber()];
    }
    
    public ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> getAtOrderedEnd() {
	Side orderedSide = getOrderedSide();
	if (orderedSide == null) {
	    throw new RuntimeException("Trying to obtain ordered end from link "+this+
		    " of unordered association "+associationService.getAssociationName(getAssociation()));
	}
	return get(orderedSide);
    }
    
    public ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> getAtOppositeOfOrderedEnd() {
	Side orderedSide = getOrderedSide();
	if (orderedSide == null) {
	    throw new RuntimeException("Trying to obtain ordered end from link "+this+
		    " of unordered association "+associationService.getAssociationName(getAssociation()));
	}
	return get(orderedSide.otherEnd());
    }
    
    /**
     * If <tt>cto</tt> appears on one side, that side is returned. If it appears on no side,
     * <tt>null</tt> is returned. If it appears on both sides, one side is arbitrarily chosen and
     * a non-<tt>null</tt> side is returned.
     */
    public Side getSideOf(ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> cto) {
	for (Side side:Side.values()) {
	    if (get(side).equals(cto)) {
		return side;
	    }
	}
	return null;
    }

    public LinkMetaObject getAssociation() {
	return association;
    }

    @Override
    public int hashCode() {
	return association.hashCode() ^ ends[0].hashCode() ^ ends[1].hashCode()
		^ ((getOrigin() == null) ? 0 : getOrigin().hashCode());
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o) {
	if (!(o instanceof Link)) {
	    return false;
	}
	Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> l = (Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) o;
	return association.equals(l.association)
		&& Arrays.equals(l.ends, ends)
		&& (getOrigin() == l.getOrigin() || ((getOrigin() != null) && getOrigin().equals(
			l.getOrigin())));
    }

    public int logicalHashCode() {
	return association.hashCode() ^ ends[0].logicalHashCode() ^ ends[1].logicalHashCode();
    }
    
    @SuppressWarnings("unchecked")
    public boolean logicallyEquals(Object o) {
	if (!(o instanceof Link)) {
	    return false;
	}
	Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> l = (Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) o;
	return association.equals(l.association)
		&& Arrays.equals(l.ends, ends);
    }
    
    /**
     * Fixing the origin (snapshot) of a link also adjusts the snapshots of the two ends.
     */
    @Override
    public Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> getCopyWithOrigin(SnapshotIdentifier snapshotIdentifier) {
	Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> linkWithSnapshotAdjusted;
	if (getOrigin() != snapshotIdentifier) {
	    linkWithSnapshotAdjusted = new Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(
		    get(Side.LEFT).getCopyWithOrigin(snapshotIdentifier), 
		    get(Side.RIGHT).getCopyWithOrigin(snapshotIdentifier),
		    getAssociation(), snapshotIdentifier, associationService);
	    linkWithSnapshotAdjusted.setPersistent(isPersistent());
	} else {
	    linkWithSnapshotAdjusted = this;
	}
	return linkWithSnapshotAdjusted;
    }
    
    @SuppressWarnings("unchecked")
    public Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> clone() {
	try {
	    return (Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) super.clone();
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
	return associationService.isUnique(associationService.getEnds(getAssociation()).get(0));
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
	List<LinkEndMetaObject> ends = associationService.getEnds(getAssociation());
	for (Side side : Side.values()) {
	    if (associationService.isOrdered(ends.get(side.endNumber()))) {
		return side;
	    }
	}
	return null;
    }

    @Override
    public String toString() {
	return associationService.getAssociationName(getAssociation()) + Arrays.toString(ends);
    }
}