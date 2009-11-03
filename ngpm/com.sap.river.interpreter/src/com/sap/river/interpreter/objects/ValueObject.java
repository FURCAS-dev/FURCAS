package com.sap.river.interpreter.objects;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.sap.river.interpreter.LinkContainer;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.Side;
import com.sap.river.interpreter.repository.RepositoryObject;
import com.sap.river.interpreter.repository.SnapshotIdentifier;

import data.classes.ActualObjectParameter;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.Parameter;
import data.classes.SapClass;

/**
 * Represents an object that is instance of a value class. Key functionality
 * of a value object is that it can be cloned, e.g., to produce a copy which then
 * can have composite parts replaced as compared to the original.<p>
 * 
 * Equality/hash code is based on the class of this object (formally:
 * <tt>getType().getClazz()</tt>) and all the values of those association ends whose
 * other end attaches to this class and is marked as
 * {@link AssociationEnd#isContributesToEquality() contributing to equality}. It would
 * not be possible to determine those association links from the {@link LinkContainer}
 * because the link container requires the equality definition already to look up
 * this object in its data structures. Therefore, the equality-relevant association
 * end values need to be replicated into this object. This redundancy is managed by
 * the {@link LinkContainer} alone.<p>
 * 
 * @author Axel Uhl (D043530)
 */
public class ValueObject extends ClassTypedObject implements Cloneable {
    private static Logger log = Logger.getLogger(ValueObject.class.getName());
    
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
    private Map<AssociationEnd, Collection<ClassTypedObject>> equalityRelevantAssociationEndValues;
    
    /**
     * If the value class of which this is an instance uses object parameters
     * (see {@link SapClass#getFormalObjectParameters}), this list contains the objects
     * resulting from evaluating the actual object parameters when this value object
     * was created. Always non-<tt>null</tt>.
     */
    private List<RiverObject> actualObjectParameters;
    
    /**
     * Constructs an object representing a value. Values are characterized by the combination of the
     * values of the opposite ends of those association ends attaching to this object's class and
     * marked as contributing to equality {@see AssociationEnd#isContributesToEquality()}.
     * 
     * @param interpreter
     *                needed to evaluate any actual object parameter expressions on the class type
     *                definition <tt>type</tt>
     */
    protected ValueObject(ClassTypeDefinition type, SnapshotIdentifier snapshot, RiverInterpreter interpreter) {
	super(type, snapshot);
	if (type != null) { // null case may occur in case an ExceptionObject is being constructed
	    fillActualObjectParameters(type, interpreter);
	}
	equalityRelevantAssociationEndValues = Collections.emptyMap();
    }
    
    /**
     * Constructs an object representing a value, specifying the actual object parameters explicitly
     * instead of taking them from the type definition. Values are characterized by the combination of the
     * values of the opposite ends of those association ends attaching to this object's class and
     * marked as contributing to equality {@see AssociationEnd#isContributesToEquality()}.
     * 
     * @param interpreter
     *                needed to evaluate any actual object parameter expressions on the class type
     *                definition <tt>type</tt>
     */
    protected ValueObject(ClassTypeDefinition type, List<RiverObject> actualObjectParameters, SnapshotIdentifier snapshot,
	    RiverInterpreter interpreter) {
	super(type, snapshot);
	this.actualObjectParameters = actualObjectParameters;
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
    public ValueObject(ClassTypeDefinition type,
	    Map<AssociationEnd, Collection<ClassTypedObject>> propertyValues,
	    SnapshotIdentifier snapshot, RiverInterpreter interpreter) {
	super(type, snapshot);
	fillActualObjectParameters(type, interpreter);
	equalityRelevantAssociationEndValues = Collections.unmodifiableMap(propertyValues);
    }

    /**
     * From the {@link ActualObjectParameter}s attached to <tt>type</tt>
     * evaluates the {@link ActualObjectParameter#getValue() expressions} that
     * define the actual parameter values, using the <tt>interpreter</tt>. If
     * values are not specified for default parameters, these will be filled
     * from the default values defined for the respective formal parameters. The
     * results are added to {@link #actualObjectParameters} in the order in
     * which the parameters occur in {@link ActualObjectParameter#getValue()}.
     */
    private void fillActualObjectParameters(ClassTypeDefinition type, RiverInterpreter interpreter) {
	List<Parameter> formalObjectParameters = type.getClazz().getFormalObjectParameters();
	if (formalObjectParameters.size() > 0) {
	    actualObjectParameters = new ArrayList<RiverObject>(type.getObjectParameters().size());
	    for (ActualObjectParameter aop : type.getObjectParameters()) {
		try {
		    actualObjectParameters.add(interpreter.evaluate(aop.getValue()));
		} catch (Exception e) {
		    log.throwing(ValueObject.class.getName(), "fillActualObjectParameters", e);
		    throw new RuntimeException(e);
		}
	    }
	    // fill missing from default values:
	    for (int i=type.getObjectParameters().size(); i<formalObjectParameters.size(); i++) {
		try {
		    /** TODO avoid endless recursion for default values of the same type as *type*
		     * 
		     * Example: Number|Number precision=1|
		     * 
		     * When only the type "Number" is used, the default value expression "1" is evaluated
		     * here which requires creating a native value object for "1" which has to have
		     * its actual object parameters set. Since the number literal "1" does not provide
		     * a value for the formal object parameter "precision," the default value will be
		     * computed again here, leading to an endless recursion.
		     */
		    actualObjectParameters.add(interpreter.evaluate(formalObjectParameters.get(i).getDefaultValue()));
		} catch (Exception e) {
		    throw new RuntimeException(e);
		}
	    }
	} else {
	    actualObjectParameters = Collections.emptyList();
	}
    }

    /**
     * Creates a clone of this value object by copying the references to all attributes
     * including the type definition, native objects for the {@link NativeObject} subclass
     * as well as the map that contains the equality-relevant "property" values and the
     * {@link ClassTypedObject#getOrigin() snapshot}. The clone returned may, e.g., get
     * its snapshot altered without this object having its snapshot altered. However,
     * it is not permissible to try to write into {@link #equalityRelevantAssociationEndValues}
     * because it would change the equality/hashCode definitions for this value object. 
     */
    public ValueObject clone() {
	ValueObject result = (ValueObject) super.clone();
	return result;
    }
    
    public Map<AssociationEnd, Collection<ClassTypedObject>> getEqualityRelevantAssociationEndValues() {
	return Collections.unmodifiableMap(equalityRelevantAssociationEndValues);
    }
    
    /**
     * From the {@link #equalityRelevantAssociationEndValues} map creates a set of links that a
     * {@link LinkContainer} may load and that establish (part of) this value from the link
     * container's perspective, limited to the association indicated by
     * <tt>equalityRelevantFarEnd</tt>. The links returned share the same
     * {@link SnapshotIdentifier} as this value returns from its
     * {@link RepositoryObject#getOrigin()} operation. The objects at the far end are cloned if
     * their {@link RiverObject#getOrigin snapshot} does not match this value's snapshot, and the
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
    public Collection<Link> getEqualityRelevantLinks(AssociationEnd equalityRelevantFarEnd) {
	Collection<Link> links = createCollection(equalityRelevantFarEnd.getType().isOrdered(),
		equalityRelevantFarEnd.getType().isUnique());
	Side farSide = LinkContainer.getSideOfEnd(equalityRelevantFarEnd);
	boolean thisIsLeft = farSide.equals(Side.RIGHT);
	Link link;
	for (ClassTypedObject objectAtFarEnd : equalityRelevantAssociationEndValues
		.get(equalityRelevantFarEnd)) {
	    ClassTypedObject objectAtFarEndWithSnapshotAdjusted = objectAtFarEnd
		    .getCopyWithOrigin(getOrigin());
	    if (thisIsLeft) {
		link = new Link(this, objectAtFarEndWithSnapshotAdjusted, equalityRelevantFarEnd
			.getAssociation(), getOrigin());
	    } else {
		link = new Link(objectAtFarEndWithSnapshotAdjusted, this, equalityRelevantFarEnd
			.getAssociation(), getOrigin());
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
    @Override
    public boolean equals(Object o) {
	if (!(o instanceof RiverObject)) {
	    return false;
	}
	Iterator<RiverObject> oIter = ((RiverObject) o).iterator();
	if (!oIter.hasNext()) {
	    return false;
	}
	RiverObject oro = oIter.next();
	if (oIter.hasNext() || !(oro instanceof ValueObject)) {
	    return false;
	}
	if (this == oro) {
	    return true;
	}
	ValueObject vo = (ValueObject) oro;
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
    @Override
    public boolean logicallyEquals(RiverObject o) {
	if (this == o) {
	    return true;
	}
	Iterator<RiverObject> oIter = o.iterator();
	if (!oIter.hasNext()) {
	    return false;
	}
	RiverObject oro = oIter.next();
	if (oIter.hasNext() || !(oro instanceof ValueObject)) {
	    return false;
	}
	if (this == oro) {
	    return true;
	}
	ValueObject vo = (ValueObject) oro;
	return getType().getClazz().equals(vo.getType().getClazz()) &&
		logicallyEquals(equalityRelevantAssociationEndValues, vo.equalityRelevantAssociationEndValues) &&
		logicallyEquals(actualObjectParameters, vo.actualObjectParameters);
    }
    
    @Override
    public int logicalHashCode() {
	return getType().getClass().hashCode() ^ equalityRelevantAssociationEndValues.hashCode() ^
		(actualObjectParameters == null ? 0 : actualObjectParameters.hashCode());
    }

    /**
     * Compares the two maps based on the {@link RiverObject#logicallyEquals(RiverObject) logical equality}
     * of the {@link RiverObject}s contained in the value collections.
     */
    @SuppressWarnings("unchecked") // need to cast from Collection<ClassTypedObject> to Collection<RiverObject>
    private boolean logicallyEquals(
	    Map<AssociationEnd, Collection<ClassTypedObject>> a,
	    Map<AssociationEnd, Collection<ClassTypedObject>> b) {
	if (a == b) {
	    return true;
	}
	if (a.keySet().equals(b.keySet())) {
	    for (AssociationEnd key:a.keySet()) {
		Collection<?> c_a = a.get(key);
		Collection<?> c_b = b.get(key);
		if (!logicallyEquals((Collection<RiverObject>) c_a, (Collection<RiverObject>) c_b)) {
		    return false;
		}
	    }
	}
	return true;
    }

    private boolean logicallyEquals(Collection<RiverObject> c_a,
	    Collection<RiverObject> c_b) {
	boolean result = true;
	if (c_a.size() != c_b.size()) {
	    result = false;
	} else {
	    Iterator<RiverObject> i_a = c_a.iterator();
	    Iterator<RiverObject> i_b = c_b.iterator();
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
	sb.append(getType().getClazz().getName());
	if (getType().getObjectParameters().size() > 0) {
	    sb.append('|');
	    boolean commaBefore = false;
	    for (RiverObject aop : getActualObjectParameters()) {
		if (commaBefore) {
		    sb.append(", ");
		} else {
		    commaBefore = true;
		}
		sb.append(aop);
	    }
	    sb.append('|');
	}
	sb.append("(");
	boolean first = true;
	Map<AssociationEnd, Collection<ClassTypedObject>> values = getEqualityRelevantAssociationEndValues();
	for (AssociationEnd ae:values.keySet()) {
	    if (!first) {
		sb.append(", ");
	    } else {
		first = false;
	    }
	    sb.append(ae.getName());
	    sb.append(": ");
	    if (values.get(ae).size() > 1) {
		if (ae.getType().isUnique()) {
		    sb.append('{');
		}
		if (ae.getType().isOrdered()) {
		    sb.append('[');
		}
		if (!ae.getType().isOrdered() && !ae.getType().isUnique()) {
		    sb.append('(');
		}
	    }
	    boolean ffirst = true;
	    for (ClassTypedObject cto : values.get(ae)) {
		if (!ffirst) {
		    sb.append(", ");
		} else {
		    ffirst = false;
		}
		sb.append(cto);
	    }
	    if (values.get(ae).size() > 1) {
		if (ae.getType().isOrdered()) {
		    sb.append(']');
		}
		if (ae.getType().isUnique()) {
		    sb.append('}');
		}
		if (!ae.getType().isOrdered() && !ae.getType().isUnique()) {
		    sb.append(')');
		}
	    }
	}
	sb.append(")");
	return sb.toString();
    }

    /**
     * Returns an immutable collection of the actual object parameters for this value object.
     * These correspond to the formal object parameters defined for this object's value class.
     * 
     * @see ActualObjectParameter
     * @see SapClass#getFormalObjectParameters()
     */
    public List<RiverObject> getActualObjectParameters() {
	return Collections.unmodifiableList(actualObjectParameters);
    }
}
