package com.sap.runlet.abstractinterpreter.objects;

import java.util.Iterator;

import com.sap.runlet.abstractinterpreter.repository.Snapshot;

/**
 * Wraps an existing {@link RunletObject}, delegates all methods to the wrapped object and defines {@link #equals} and
 * {@link #hashCode} based on the {@link #logicallyEquals(RunletObject) logical equality} and {@link #logicalHashCode()
 * logical hash code}, respectively.
 * 
 * @author Axel Uhl (D043530)
 */
public class LogicallyEqualsWrapper<LinkEndMetaObject, TypeUsage, ClassUsage extends TypeUsage> extends
RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> {
    private final RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> wrappedObject;
    
    public LogicallyEqualsWrapper(RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> wrappedObject) {
	super(wrappedObject.getType());
	this.wrappedObject = wrappedObject;
    }
    
    public int size() {
	return wrappedObject.size();
    }
    
    public TypeUsage getType() {
	return wrappedObject.getType();
    }
    
    public Iterator<RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>> iterator() {
	return wrappedObject.iterator();
    }
    
    /**
     * Objects may be nested {@link MultiValuedObject multi-objects}, for example because
     * method calls with output multiplicity <tt>n</tt> are called on a multi-object. This is
     * particularly inconvenient in case a client wants to deal with elementary objects that
     * are no multi-objects. This operation flattens an object to the extent that its
     * {@link #iterator()} operation is guaranteed to return only objects that are not
     * multi-objects.
     */
    public Iterable<RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>> flatten() {
	return wrappedObject.flatten();
    }
    
    public boolean isEmpty() {
	return wrappedObject.isEmpty();
    }
    
    /**
     * Logical equality implements the "==" operator of the programming model which
     * is defined slightly different from the Java equality of the {@link LogicallyEqualsWrapper}s
     * representing them in the interpreter. In particular, there is this issue of
     * the {@link Snapshot}. While in the interpreter it is essential to be able to
     * distinguish otherwise equal instances if they come from different snapshots,
     * for a logical equality comparison the snapshot does not matter. For example,
     * if the number 42 was obtained from snapshot 7, then navigating an association
     * from that copy of 42 shall navigate using snapshot 7. However, if this copy of 42
     * is compared to any other copy of 42, the result should be that these are logically
     * equal.<p>
     * 
     * The default implementation used here defaults to the Java equality. Subclasses
     * that know about snapshots need to distinguish, though.
     */
    public boolean logicallyEquals(RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> other) {
	return wrappedObject.equals(other);
    }
    
    /**
     * Computes a hash code that is the same for two objects that compare equal with
     * {@link #equalsWithinSameSnapshot}. By default, this is the {@link #logicalHashCode()},
     * but entities should redefine this to be ID-based.
     */
    public int hashCodeWithinSnapshot() {
	return wrappedObject.logicalHashCode();
    }
    
    /**
     * Computes a hash code that is based only on those features that also contribute to
     * the definition of {@link #logicallyEquals(LogicallyEqualsWrapper)}. The default implementation
     * is to use the regular hash code.
     */
    public int logicalHashCode() {
	return wrappedObject.hashCode();
    }
    
    /**
     * Equality and hash code are mapped to logical equality and logical hash code of the wrapped
     * object by this wrapper.
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o) {
	return wrappedObject.logicallyEquals(
		((LogicallyEqualsWrapper<LinkEndMetaObject, TypeUsage, ClassUsage>) o).getWrappedObject());
    }

    /**
     * Equality and hash code are mapped to logical equality and logical hash code of the wrapped
     * object by this wrapper.
     */
    @Override
    public int hashCode() {
	return wrappedObject.logicalHashCode();
    }
    
    public RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> getWrappedObject() {
	return wrappedObject;
    }
    
    @Override
    public String toString() {
	return wrappedObject.toString();
    }
}
