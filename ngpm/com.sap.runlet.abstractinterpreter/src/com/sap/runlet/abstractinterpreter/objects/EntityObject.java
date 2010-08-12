package com.sap.runlet.abstractinterpreter.objects;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

import com.sap.runlet.abstractinterpreter.AbstractRunletInterpreter;
import com.sap.runlet.abstractinterpreter.repository.SnapshotIdentifier;
import com.sap.runlet.abstractinterpreter.util.ModelAdapter;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.shared.util.Tuple.Pair;

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
public class EntityObject<LinkMetaObject extends RefObject, LinkEndMetaObject extends RefObject, MetaClass extends RefObject,
TypeUsage extends RefObject, ClassUsage extends TypeUsage>
extends ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> {
    private final ModelAdapter<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> modelAdapter;
    private final AbstractRunletInterpreter<MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, ?, ?, ?, ?, ?, ?> interpreter;
    private final UUID id;
    /**
     * Generates a new UUID for the object. To be used when a new object is constructed that
     * requires a new identity.
     * @param modelAdapter TODO
     * @param interpreter TODO
     */
    public EntityObject(ClassUsage type, SnapshotIdentifier snapshot,
	    ModelAdapter<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> modelAdapter,
	    AbstractRunletInterpreter<MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, ?, ?, ?, ?, ?, ?> interpreter) {
	super(type, snapshot);
	this.modelAdapter = modelAdapter;
	this.interpreter = interpreter;
	id = UUID.randomUUID();
    }

    /**
     * Constructs an object based on a previously known ID, such as when loading the object from
     * some persistent representation.
     * @param modelAdapter TODO
     * @param interpreter TODO
     */
    public EntityObject(ClassUsage type, UUID id, SnapshotIdentifier snapshot,
	    ModelAdapter<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> modelAdapter,
	    AbstractRunletInterpreter<MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, ?, ?, ?, ?, ?, ?> interpreter) {
	super(type, snapshot);
	this.modelAdapter = modelAdapter;
	this.interpreter = interpreter;
	this.id = id;
    }

    private AbstractRunletInterpreter<MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, ?, ?, ?, ?, ?, ?> getInterpreter() {
        return interpreter;
    }

    private ModelAdapter<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> getModelAdapter() {
        return modelAdapter;
    }

    public UUID getId() {
	return id;
    }
    
    @SuppressWarnings("unchecked")
    public EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> clone() {
	return (EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) super.clone();
    }

    /**
     * Computes a hash code based on ID and snapshot, consistent with {@link #equals}
     */
    public int hashCode() {
	return id.hashCode() ^ (( getOrigin() == null) ? 0 : getOrigin().hashCode() );
    }

    /**
     * Checks equality of ID and snapshot
     */
    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
	if (!(o instanceof RunletObject)) {
	    return false;
	}
	Iterator<RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>> oIter =
	    ((RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>) o).iterator();
	if (!oIter.hasNext()) {
	    return false;
	}
	RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> oro = oIter.next();
	if (oIter.hasNext() || !(oro instanceof EntityObject)) {
	    return false;
	}
	if (this == oro) {
	    return true;
	}
	EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> other = (EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) oro;
	return getId().equals(other.getId())
		&& (getOrigin() == other.getOrigin() 
			|| ((getOrigin() != null) 
				&& getOrigin().equals(other.getOrigin())
			    )
			);
    }

    /**
     * Content-wise, two entities equal each other if all the objects reached by navigating all
     * equality-relevant associations are {@link #contentEquals} recursively to those objects reached when
     * navigating the same association starting from <tt>o</tt>. The snapshot is not considered in this
     * comparison.
     */
    @SuppressWarnings("unchecked")
    public boolean contentEquals(RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> o) {
	if (this == o) {
	    return true;
	}
	Iterator<RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>> oIter = o.iterator();
	if (!oIter.hasNext()) {
	    return false;
	}
	RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> oro = oIter.next();
	if (oIter.hasNext() || !(oro instanceof EntityObject)) {
	    return false;
	}
	if (this == oro) {
	    return true;
	}
	return !isDifferentFrom((EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) o,
		new HashSet<Pair<RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>, RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>>>());
    }
    
    /**
     * Logically, two entities equal each other if they have equal IDs. The {@link #getOrigin() snapshot}
     * to which they pertain does not matter for this comparison.<p>
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean logicallyEquals(RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> o) {
	if (this == o) {
	    return true;
	}
	Iterator<RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>> oIter = o.iterator();
	if (!oIter.hasNext()) {
	    return false;
	}
	RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> oro = oIter.next();
	if (oIter.hasNext() || !(oro instanceof EntityObject)) {
	    return false;
	}
	if (this == oro) {
	    return true;
	}
	return getId().equals(((EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) oro).getId());
    }

    /**
     * Returns <code>true</code> if the two objects are different. RiverObjects are always different
     * if they have different concrete subclasses. Otherwise they are compared with respect to their
     * content but ignoring snapshot containment.
     */
    @SuppressWarnings("unchecked")
    private boolean areDifferent(RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> o1,
	    RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> o2,
	    Set<Pair<RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>, RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>>> alreadyCompared) {
	Pair<RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>, RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>> pair =
	    new Pair<RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>,
	RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>>(o1, o2);
	if (alreadyCompared.contains(pair)) {
	    return false; // if a pair has already been investigated or is currently under investigation, we
	    		  // assume by default that they are not different; if they still are, some invocation up
	    		  // the call stack will return true.
	}
	alreadyCompared.add(pair);
	if (!o1.getClass().equals(o2.getClass())) {
	    return true;
	}
	if (o1 instanceof EntityObject) {
	    return ((EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) o1).isDifferentFrom(
		    (EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) o2, alreadyCompared);
	}
	if (o1 instanceof AbstractValueObject) {
	    return areDifferent((AbstractValueObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) o1,
		    (AbstractValueObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) o2);
	}
	if (o1 instanceof MultiValuedObject) {
	    MultiValuedObject<LinkEndMetaObject, TypeUsage, ClassUsage> m1 =
		(MultiValuedObject<LinkEndMetaObject, TypeUsage, ClassUsage>) o1;
	    MultiValuedObject<LinkEndMetaObject, TypeUsage, ClassUsage> m2 =
		(MultiValuedObject<LinkEndMetaObject, TypeUsage, ClassUsage>) o2;
	    // must be different if size differs
	    if (m1.size() != m2.size()) {
		return true;
	    }
	    // not different if size 0
	    else if (m1.size() == 0) {
		return false;
	    }
	    Iterator<RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>> i1 = m1.flatten().iterator();
	    Iterator<RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>> i2 = m2.flatten().iterator();
	    while (i1.hasNext()) {
		if (areDifferent(i1.next(), i2.next(), alreadyCompared)) {
		    return true;
		}
	    }
	    return false;
	}
	throw new RuntimeException("Illegal class in 'areDifferent': " + o1.getClass().getName());
    }
    
    /**
     * Delegates to {@link ValueObject#logicallyEquals(RunletObject)}.
     * @param v1
     * @param v2
     * @return
     */
    private boolean areDifferent(AbstractValueObject<?, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> v1,
	    AbstractValueObject<?, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> v2) {
	return v1.logicallyEquals(v2);
    }
    
    /**
     * Returns <code>true</code> if two copies of the same entity are different. An entity from the same
     * snapshot is always equal to itself. If two versions from different snapshots
     * are compared, the entities are equal if all outgoing associations are logically
     * equal along the composition hierarchy.
     * 
     * @precondition this and e2 are the same entity instance
     * @param e2
     *                {@link EntityObject} to compare
     * @param alreadyCompared 
     * @return <code>true</code> if the {@link EntityObject}s there are changes from e1 to e2,
     *         <code>false</code> otherwise.
     */
    public boolean isDifferentFrom(
	    EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> e2,
	    Set<Pair<RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>, RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>>> alreadyCompared) {
	// if both entities have the same ID and come from the same snapshot they have to be equal as well
	if (this.getId().equals(e2.getId()) && this.getOrigin().equals(e2.getOrigin())) {
	    return false;
	}

	for (LinkEndMetaObject ae : getModelAdapter().getEqualityRelevantAssociationEnds(getModelAdapter().getClazz(this.getType()))) {
	    LinkEndMetaObject otherEnd = getModelAdapter().otherEnd(ae);
	    RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> o1 = getInterpreter().navigate(
		    this, getModelAdapter().getSideOfEnd(otherEnd).otherEnd(),
		    getModelAdapter().getAssociation(otherEnd));
	    RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> o2 = getInterpreter().navigate(
		    e2, getModelAdapter().getSideOfEnd(otherEnd).otherEnd(),
		    getModelAdapter().getAssociation(otherEnd));
	    if (!o1.logicallyEquals(o2)) { // FIXME what about endless recursion issues here?
		return true;
	    }
	    if (getModelAdapter().isComposite(ae)) {
		if (areDifferent(o1, o2, alreadyCompared)) {
		    return true;
		}
	    }
	}
	return false;
    }
    
    @Override
    public int hashCodeWithinSnapshot() {
	return this.logicalHashCode();
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
	sb.append(getModelAdapter().getClassUsageName(getType()));
	sb.append(" @ ");
	sb.append(getOrigin());
	return sb.toString();
    }

    @Override
    public boolean isUnique() {
	return true;
    }

}
