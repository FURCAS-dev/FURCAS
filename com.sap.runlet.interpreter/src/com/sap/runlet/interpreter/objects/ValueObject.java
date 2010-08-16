package com.sap.runlet.interpreter.objects;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.sap.runlet.abstractinterpreter.Side;
import com.sap.runlet.abstractinterpreter.objects.AbstractValueObject;
import com.sap.runlet.abstractinterpreter.objects.ClassTypedObject;
import com.sap.runlet.abstractinterpreter.objects.Link;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.abstractinterpreter.repository.RepositoryObject;
import com.sap.runlet.abstractinterpreter.repository.SnapshotIdentifier;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.RunletLinkContainer;

import data.classes.ActualObjectParameter;
import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.Parameter;
import data.classes.SapClass;
import data.classes.TypeDefinition;

/**
 * Represents an object that is instance of a value class. Key functionality
 * of a value object is that it can be cloned, e.g., to produce a copy which then
 * can have composite parts replaced as compared to the original.<p>
 * 
 * Equality/hash code is based on the class of this object (formally:
 * <tt>getType().getClazz()</tt>) and all the values of those association ends whose
 * other end attaches to this class and is marked as
 * {@link AssociationEnd#isContributesToEquality() contributing to equality}. It would
 * not be possible to determine those association links from the {@link RunletLinkContainer}
 * because the link container requires the equality definition already to look up
 * this object in its data structures. Therefore, the equality-relevant association
 * end values need to be replicated into this object. This redundancy is managed by
 * the {@link RunletLinkContainer} alone.<p>
 * 
 * @author Axel Uhl (D043530)
 */
public class ValueObject
extends AbstractValueObject<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition>
implements Cloneable {
    private static Logger log = Logger.getLogger(ValueObject.class.getName());
    
    /**
     * If the value class of which this is an instance uses object parameters
     * (see {@link SapClass#getFormalObjectParameters}), this list contains the objects
     * resulting from evaluating the actual object parameters when this value object
     * was created. Always non-<tt>null</tt>.
     */
    private List<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> actualObjectParameters;
    
    /**
     * Constructs an object representing a value. Values are characterized by the combination of the
     * values of the opposite ends of those association ends attaching to this object's class and
     * marked as contributing to equality {@see AssociationEnd#isContributesToEquality()}.
     * @param interpreter
     *                needed to evaluate any actual object parameter expressions on the class type
     *                definition <tt>type</tt>
     */
    protected ValueObject(ClassTypeDefinition type, SnapshotIdentifier snapshot, RunletInterpreter interpreter) {
	super(type, snapshot, interpreter.getModelAdapter());
	if (type != null) { // null case may occur in case an ExceptionObject is being constructed
	    fillActualObjectParameters(type, interpreter);
	}
    }
    
    /**
     * Constructs an object representing a value, initializing its equality-defining properties
     * which from then on are immutable. Values are generally characterized by the combination of
     * the values of the opposite ends of those association ends attaching to this object's class
     * and marked as contributing to equality {@see AssociationEnd#isContributesToEquality()}.
     * @param interpreter
     *                needed to evaluate any actual object parameter expressions on the class type
     *                definition <tt>type</tt>
     */
    public ValueObject(ClassTypeDefinition type,
	    Map<AssociationEnd, Collection<ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>> propertyValues,
	    SnapshotIdentifier snapshot, RunletInterpreter interpreter) {
	super(type, propertyValues, snapshot, interpreter.getModelAdapter());
	fillActualObjectParameters(type, interpreter);
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
    private void fillActualObjectParameters(ClassTypeDefinition type, RunletInterpreter interpreter) {
	List<Parameter> formalObjectParameters = type.getClazz().getFormalObjectParameters();
	if (formalObjectParameters.size() > 0) {
	    actualObjectParameters = new ArrayList<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>(
		    type.getObjectParameters().size());
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
    
    public Map<AssociationEnd, Collection<ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>> getEqualityRelevantAssociationEndValues() {
	return Collections.unmodifiableMap(super.getEqualityRelevantAssociationEndValues());
    }
    
    /**
     * From the {@link #equalityRelevantAssociationEndValues} map creates a set of links that a
     * {@link RunletLinkContainer} may load and that establish (part of) this value from the link
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
    public Collection<Link<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition>> getEqualityRelevantLinks(AssociationEnd equalityRelevantFarEnd) {
	Collection<Link<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition>> links = createCollection(equalityRelevantFarEnd.getType().isOrdered(),
		equalityRelevantFarEnd.getType().isUnique());
	Side farSide = getModelAdapter().getSideOfEnd(equalityRelevantFarEnd);
	boolean thisIsLeft = farSide.equals(Side.RIGHT);
	Link<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition> link;
	for (ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> objectAtFarEnd : getEqualityRelevantAssociationEndValues()
		.get(equalityRelevantFarEnd)) {
	    ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> objectAtFarEndWithSnapshotAdjusted = objectAtFarEnd
		    .getCopyWithOrigin(getOrigin());
	    if (thisIsLeft) {
		link = new Link<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition>(
			this, objectAtFarEndWithSnapshotAdjusted, equalityRelevantFarEnd
			.getAssociation(), getOrigin(), getModelAdapter());
	    } else {
		link = new Link<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition>(
			objectAtFarEndWithSnapshotAdjusted, this, equalityRelevantFarEnd
			.getAssociation(), getOrigin(), getModelAdapter());
	    }
	    links.add(link);
	}
	return links;
    }
    
    /**
     * Two values are considered logically equal if they are instance of the same class and all their
     * equality-relevant properties have equal values.
     */
    @Override
    public boolean logicallyEquals(RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> o) {
	if (this == o) {
	    return true;
	}
	Iterator<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> oIter = o.iterator();
	if (!oIter.hasNext()) {
	    return false;
	}
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> oro = oIter.next();
	if (oIter.hasNext() || !(oro instanceof ValueObject)) {
	    return false;
	}
	if (this == oro) {
	    return true;
	}
	ValueObject vo = (ValueObject) oro;
	return getType().getClazz().equals(vo.getType().getClazz()) &&
		logicallyEquals(getEqualityRelevantAssociationEndValues(), vo.getEqualityRelevantAssociationEndValues()) &&
		logicallyEquals(actualObjectParameters, vo.actualObjectParameters);
    }
    
    @Override
    public int logicalHashCode() {
	return getType().getClass().hashCode() ^ getEqualityRelevantAssociationEndValues().hashCode() ^
		(actualObjectParameters == null ? 0 : actualObjectParameters.hashCode());
    }

    /**
     * Compares the two maps based on the {@link RunletObject#logicallyEquals(RunletObject) logical equality}
     * of the {@link RunletObject}s contained in the value collections.
     */
    @SuppressWarnings("unchecked") // need to cast from Collection<ClassTypedObject> to Collection<RiverObject>
    protected boolean logicallyEquals(
	    Map<AssociationEnd, Collection<ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>> a,
	    Map<AssociationEnd, Collection<ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>> b) {
	if (a == b) {
	    return true;
	}
	if (a.keySet().equals(b.keySet())) {
	    for (AssociationEnd key:a.keySet()) {
		Collection<?> c_a = a.get(key);
		Collection<?> c_b = b.get(key);
		if (!logicallyEquals((Collection<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>) c_a,
			(Collection<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>) c_b)) {
		    return false;
		}
	    }
	}
	return true;
    }

    protected boolean logicallyEquals(Collection<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> c_a,
	    Collection<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> c_b) {
	boolean result = true;
	if (c_a.size() != c_b.size()) {
	    result = false;
	} else {
	    Iterator<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> i_a = c_a.iterator();
	    Iterator<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> i_b = c_b.iterator();
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
	    for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> aop : getActualObjectParameters()) {
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
	Map<AssociationEnd, Collection<ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>> values = getEqualityRelevantAssociationEndValues();
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
	    for (ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> cto : values.get(ae)) {
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
    public List<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> getActualObjectParameters() {
	return Collections.unmodifiableList(actualObjectParameters);
    }
}
