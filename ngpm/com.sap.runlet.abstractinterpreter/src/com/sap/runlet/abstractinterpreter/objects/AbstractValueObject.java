package com.sap.runlet.abstractinterpreter.objects;


import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import com.sap.runlet.abstractinterpreter.LinkContainer;
import com.sap.runlet.abstractinterpreter.Side;
import com.sap.runlet.abstractinterpreter.repository.RepositoryObject;
import com.sap.runlet.abstractinterpreter.repository.SnapshotIdentifier;
import com.sap.runlet.abstractinterpreter.util.ModelAdapter;

/**
 * Represents an object that is instance of a value class. Key functionality
 * of a value object is that it can be cloned, e.g., to produce a copy which then
 * can have composite parts replaced as compared to the original.<p>
 * 
 * Equality/hash code is based on the class of this object (formally:
 * <tt>getType().getClazz()</tt>) and all the values of those association ends whose
 * other end attaches to this class and is marked as contributing to equality. It would
 * not be possible to determine those association links from the {@link LinkContainer}
 * because the link container requires the equality definition already to look up
 * this object in its data structures. Therefore, the equality-relevant association
 * end values need to be replicated into this object. This redundancy is managed by
 * the {@link LinkContainer} alone.<p>
 * 
 * @author Axel Uhl (D043530)
 */
public class AbstractValueObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage extends TypeUsage>
extends ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> implements Cloneable {
    /**
     * Maintains the immutable equality-related association end values ("properties") for this
     * value object. Keys are the association ends on the far end; values are the
     * collections (respecting ordering and uniqueness properties of the association end)
     * containing the values that correspond with the currently existing links for
     * the association.<p>
     * 
     * None of the value collections is empty. If removing a link would turn the collection
     * empty, the whole entry for the key will be removed.
     */
    private Map<LinkEndMetaObject, Collection<ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>>> equalityRelevantAssociationEndValues;

    private final ModelAdapter<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> modelAdapter;

    /**
     * Constructs an object representing a value. Values are characterized by the combination of the
     * values of the opposite ends of those association ends attaching to this object's class and
     * marked as contributing to equality {@see AssociationEnd#isContributesToEquality()}.
     * @param getModelAdapter() TODO
     * @param interpreter
     *                needed to evaluate any actual object parameter expressions on the class type
     *                definition <tt>type</tt>
     */
    protected AbstractValueObject(ClassUsage type, SnapshotIdentifier snapshot,
	    ModelAdapter<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> modelAdapter) {
	super(type, snapshot);
	this.modelAdapter = modelAdapter;
	equalityRelevantAssociationEndValues = Collections.emptyMap();
    }
    
    /**
     * Constructs an object representing a value, initializing its equality-defining properties
     * which from then on are immutable. Values are generally characterized by the combination of
     * the values of the opposite ends of those association ends attaching to this object's class
     * and marked as contributing to equality {@see AssociationEnd#isContributesToEquality()}.
     * 
     * @param interpreter
     *                needed to evaluate any actual object parameter expressions on the class type
     *                definition <tt>type</tt>
     */
    public AbstractValueObject(ClassUsage type,
	    Map<LinkEndMetaObject, Collection<ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>>> propertyValues,
	    SnapshotIdentifier snapshot,
	    ModelAdapter<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> modelAdapter) {
	this(type, snapshot, modelAdapter);
	equalityRelevantAssociationEndValues = Collections.unmodifiableMap(propertyValues);
    }

    /**
     * Creates a clone of this value object by copying the references to all attributes
     * including the type definition, native objects for potential <tt>NativeObject</tt> subclasses
     * as well as the map that contains the equality-relevant "property" values and the
     * {@link ClassTypedObject#getOrigin() snapshot}. The clone returned may, e.g., get
     * its snapshot altered without this object having its snapshot altered. However,
     * it is not permissible to try to write into {@link #equalityRelevantAssociationEndValues}
     * because it would change the equality/hashCode definitions for this value object. 
     */
    @SuppressWarnings("unchecked")
    public AbstractValueObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> clone() {
	AbstractValueObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> result =
	    (AbstractValueObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) super.clone();
	return result;
    }
    
    protected ModelAdapter<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> getModelAdapter() {
        return modelAdapter;
    }

    public Map<LinkEndMetaObject, Collection<ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>>> getEqualityRelevantAssociationEndValues() {
	return Collections.unmodifiableMap(equalityRelevantAssociationEndValues);
    }
    
    /**
     * From the {@link #equalityRelevantAssociationEndValues} map creates a set of links that a
     * {@link LinkContainer} may load and that establish (part of) this value from the link
     * container's perspective, limited to the association indicated by
     * <tt>equalityRelevantFarEnd</tt>. The links returned share the same
     * {@link SnapshotIdentifier} as this value returns from its
     * {@link RepositoryObject#getOrigin()} operation. The objects at the far end are cloned if
     * their {@link RunletObject#getOrigin snapshot} does not match this value's snapshot, and the
     * clone is assigned the same snapshot identifier returned by this value's
     * {@link RepositoryObject#getOrigin() snapshot}.<p>
     * 
     * This method only returns links connected to this value object. It does not recurse
     * into other value objects that are equality-relevant for this value object.<p>
     * 
     * Example: If an <tt>Address</tt> class has two equality-relevant associations, one to
     * <tt>String</tt> with far end <tt>street</tt>, one to <tt>City</tt> with far end <tt>city</tt>,
     * then if the <tt>street</tt> end is passed to this method, it will create a link from this
     * <tt>Address</tt> object to the <tt>String</tt> object that this value has as its <tt>street</tt>
     * role. If the <tt>String</tt> value has a different snapshot identifier than this value,
     * it will be cloned and the snapshot of the clone will be adjusted to match this object's
     * snapshot identifier.
     */
    public Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> getEqualityRelevantLinks(
	    LinkEndMetaObject equalityRelevantFarEnd) {
	Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> links =
	    createCollection(getModelAdapter().isOrdered(equalityRelevantFarEnd),
		    getModelAdapter().isUnique(equalityRelevantFarEnd));
	Side farSide = getModelAdapter().getSideOfEnd(equalityRelevantFarEnd);
	boolean thisIsLeft = farSide.equals(Side.RIGHT);
	Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> link;
	for (ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> objectAtFarEnd : equalityRelevantAssociationEndValues
		.get(equalityRelevantFarEnd)) {
	    ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> objectAtFarEndWithSnapshotAdjusted = objectAtFarEnd
		    .getCopyWithOrigin(getOrigin());
	    if (thisIsLeft) {
		link = new Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(
			this, objectAtFarEndWithSnapshotAdjusted, getModelAdapter().getAssociation(equalityRelevantFarEnd), getOrigin(),
			getModelAdapter());
	    } else {
		link = new Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(
			objectAtFarEndWithSnapshotAdjusted, this, getModelAdapter().getAssociation(equalityRelevantFarEnd), getOrigin(),
			getModelAdapter());
	    }
	    links.add(link);
	}
	return links;
    }
    
    /**
     * The hash code takes into account the class of which which value object is an instance
     * as well as all the property values where the association ends are marked relevant
     * for the equality of this object.
     */
    @Override
    public int hashCode() {
	return logicalHashCode() ^ ((getOrigin() == null)?0:getOrigin().hashCode());
    }

    /**
     * Two values are considered Java-technically equal if they are instance of the same class and
     * all their equality-relevant properties have equal values (meaning they are
     * {@link #logicallyEquals logically equal} and originate from the same
     * {@link #getOrigin snapshot}.
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o) {
	if (!(o instanceof RunletObject)) {
	    return false;
	}
	Iterator<RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>> oIter = ((RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>) o).iterator();
	if (!oIter.hasNext()) {
	    return false;
	}
	RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> oro = oIter.next();
	if (oIter.hasNext() || !(oro instanceof AbstractValueObject)) {
	    return false;
	}
	if (this == oro) {
	    return true;
	}
	AbstractValueObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> vo =
	    (AbstractValueObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) oro;
	return logicallyEquals(vo) && (getOrigin() == vo.getOrigin() 
		|| ((getOrigin() != null) 
			&& getOrigin().equals(vo.getOrigin())
		    )
		);
    }
    /**
     * Two values are considered logically equal if they are instance of the same class and all their
     * equality-relevant properties have equal values.
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
	if (oIter.hasNext() || !(oro instanceof AbstractValueObject)) {
	    return false;
	}
	if (this == oro) {
	    return true;
	}
	AbstractValueObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> vo =
	    (AbstractValueObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) oro;
	return getModelAdapter().getClazz(getType()).equals(getModelAdapter().getClazz(vo.getType())) &&
		logicallyEquals(equalityRelevantAssociationEndValues, vo.equalityRelevantAssociationEndValues);
    }
    
    @Override
    public int logicalHashCode() {
	return getType().getClass().hashCode() ^ equalityRelevantAssociationEndValues.hashCode();
    }

    /**
     * Compares the two maps based on the {@link RunletObject#logicallyEquals(RunletObject) logical equality}
     * of the {@link RunletObject}s contained in the value collections.
     */
    @SuppressWarnings("unchecked") // need to cast from Collection<ClassTypedObject> to Collection<RiverObject>
    protected boolean logicallyEquals(
	    Map<LinkEndMetaObject, Collection<ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>>> a,
	    Map<LinkEndMetaObject, Collection<ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>>> b) {
	if (a == b) {
	    return true;
	}
	if (a.keySet().equals(b.keySet())) {
	    for (LinkEndMetaObject key:a.keySet()) {
		Collection<?> c_a = a.get(key);
		Collection<?> c_b = b.get(key);
		if (!logicallyEquals((Collection<RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>>) c_a,
			(Collection<RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>>) c_b)) {
		    return false;
		}
	    }
	    return true;
	} else {
	    return false;
	}
    }

    protected boolean logicallyEquals(Collection<RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>> c_a,
	    Collection<RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>> c_b) {
	boolean result = true;
	if (c_a.size() != c_b.size()) {
	    result = false;
	} else {
	    Iterator<RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>> i_a = c_a.iterator();
	    Iterator<RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>> i_b = c_b.iterator();
	    while (result && i_a.hasNext()) {
		if (!i_a.next().logicallyEquals(i_b.next())) {
		    result = false;
		}
	    }
	}
	return result;
    }

    @Override
    public boolean isUnique() {
	return false;
    }
    
    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append(getModelAdapter().getClassUsageName(getType()));
	sb.append("(");
	boolean first = true;
	Map<LinkEndMetaObject, Collection<ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>>> values =
	    getEqualityRelevantAssociationEndValues();
	for (LinkEndMetaObject ae:values.keySet()) {
	    if (!first) {
		sb.append(", ");
	    } else {
		first = false;
	    }
	    sb.append(getModelAdapter().getEndName(ae));
	    sb.append(": ");
	    if (values.get(ae).size() > 1) {
		if (getModelAdapter().isUnique(ae)) {
		    sb.append('{');
		}
		if (getModelAdapter().isOrdered(ae)) {
		    sb.append('[');
		}
		if (!getModelAdapter().isOrdered(ae) && !getModelAdapter().isUnique(ae)) {
		    sb.append('(');
		}
	    }
	    boolean ffirst = true;
	    for (ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> cto : values.get(ae)) {
		if (!ffirst) {
		    sb.append(", ");
		} else {
		    ffirst = false;
		}
		sb.append(cto);
	    }
	    if (values.get(ae).size() > 1) {
		if (getModelAdapter().isOrdered(ae)) {
		    sb.append(']');
		}
		if (getModelAdapter().isUnique(ae)) {
		    sb.append('}');
		}
		if (!getModelAdapter().isOrdered(ae) && !getModelAdapter().isUnique(ae)) {
		    sb.append(')');
		}
	    }
	}
	sb.append(")");
	return sb.toString();
    }

}
