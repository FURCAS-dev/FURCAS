package com.sap.runlet.abstractinterpreter.objects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.naming.OperationNotSupportedException;

import com.sap.runlet.abstractinterpreter.repository.Snapshot;
import com.sap.runlet.abstractinterpreter.util.HashBag;

/**
 * Represents an object that could be a multi-object and that is instance of one of the different
 * kinds of type definitions, such as class, function or nested (see {@link TypeUsage} and
 * subclasses). It holds a reference to its (runtime) type. The reference to the type is immutable.
 * <p>
 * 
 * Because it can potentially be a multi-object, this class implements the
 * {@link Iterable} interface. The instances returned by the respective iterator
 * are again {@link RunletObject}s. For a single-valued object the iterator returns
 * <tt>this</tt> as the only instance.
 * 
 * TODO could implement equals and hashCode as implementation of Equals expression type
 * 
 * @author Axel Uhl (D043530)
 */
public abstract class RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage extends TypeUsage>
implements Iterable<RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>>, Cloneable {
    /**
     * The object's runtime type. The multiplicity information does not
     * necessarily represent the actual number of objects in case of a
     * multi-valued object.
     */
    private TypeUsage type;
    
    /**
     * A flavor of an array list that does never hold two equal objects at the
     * same time.
     * 
     * @author Axel Uhl (D043530)
     */
    private static class UniqueArrayList<T> extends ArrayList<T> {
	private static final long serialVersionUID = -1688206130944887279L;
	@Override
	public boolean add(T element) {
	    if (!contains(element)) {
		return super.add(element);
	    } else {
		return false;
	    }
	}
	@Override
	public void add(int index, T element) {
	    if (!contains(element)) {
		super.add(index, element);
	    }
	}
	@Override
	public boolean addAll(Collection<? extends T> c) {
	    Collection<? extends T> toAdd = new ArrayList<T>(c);
	    toAdd.removeAll(this);
	    return super.addAll(toAdd);
	}
	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
	    Collection<? extends T> toAdd = new ArrayList<T>(c);
	    toAdd.removeAll(this);
	    return super.addAll(index, toAdd);
	}
	@Override
	public T set(int index, T element) {
	    super.set(index, null);
	    if (contains(element)) {
		return remove(index);
	    } else {
		return super.set(index, element);
	    }
	}
    }
    
    public RunletObject(TypeUsage type) {
	this.type = type;
    }
    
    public int size() {
	return 1;
    }
    
    public TypeUsage getType() {
	return type;
    }
    
    public Iterator<RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>> iterator() {
	return new Iterator<RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>>() {
	    private boolean nextCalled = false;
	    @Override
	    public boolean hasNext() {
		return !nextCalled;
	    }
	    @Override
	    public RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> next() {
		if (nextCalled) {
		    throw new NoSuchElementException("called next twice on a single-valued object");
		}
		nextCalled = true;
		return RunletObject.this;
	    }
	    @Override
	    public void remove() {
		throw new RuntimeException(
			new OperationNotSupportedException("no remove on RiverObject"));
	    }
	};
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
	return this;
    }
    
    public boolean isEmpty() {
	return !iterator().hasNext();
    }
    
    /**
     * Called by the {@link LinkContainer} to announce that a link to another object has
     * been established which is relevant for this object's equality. This default implementation
     * does nothing, but {@link ValueObject} and its descendants should evaluate this and
     * account for the change in value that this represents. Note that for values this
     * only has to be expected during the construction phase of the value object because
     * values are generally immutable.
     */
    public void equalityRelevantLinkAdded(LinkEndMetaObject to, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> added) {
	// does nothing; subclasses may be interested in accounting for the change
    }

    /**
     * Called by the {@link LinkContainer} to announce that a link to another object has
     * been removed which was relevant for this object's equality. This default implementation
     * does nothing, but {@link ValueObject} and its descendants should evaluate this and
     * account for the change in value that this represents. Note that for value objects this
     * means a change to another value. This should only happen if the runtime can guarantee
     * that the value object is not shared.
     */
    public void equalityRelevantLinkRemoved(LinkEndMetaObject to, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> removed) {
	// does nothing; subclasses may be interested in accounting for the change
    }

    /**
     * Based on uniqueness and orderedness, creates a Java collection appropriate
     * for implementing these characteristics. The resulting collection can be used
     * to represents a multi-valued object.
     */
    public static <T> Collection<T> createCollection(boolean ordered, boolean unique) {
	Collection<T> result;
	if (ordered) {
	    if (unique) {
		result = new UniqueArrayList<T>();
	    } else {
		result = new ArrayList<T>();
	    }
	} else {
	    if (unique) {
		result = new HashSet<T>();
	    } else {
		result = new HashBag<T>();
	    }
	}
	return result;
    }

    /**
     * Logical equality implements the "==" operator of the programming model which
     * is defined slightly different from the Java equality of the {@link RunletObject}s
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
	return this.equals(other);
    }
    
    /**
     * Content-wise, two entities equal each other if all the objects reached by navigating all
     * equality-relevant associations are {@link #contentEquals} recursively to those objects reached when
     * navigating the same association starting from <tt>o</tt>. The snapshot is not considered in this
     * comparison. By default, this implementation uses {@link #logicallyEquals(RunletObject)}.
     */
    public boolean contentEquals(RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> o) {
	return logicallyEquals(o);
    }
    
    /**
     * Computes a hash code that is the same for two objects that compare equal with
     * {@link #equalsWithinSameSnapshot}. By default, this is the {@link #logicalHashCode()},
     * but entities should redefine this to be ID-based.
     */
    public int hashCodeWithinSnapshot() {
	return this.logicalHashCode();
    }
    
    /**
     * Computes a hash code that is based only on those features that also contribute to
     * the definition of {@link #logicallyEquals(RunletObject)}. The default implementation
     * is to use the regular hash code.
     */
    public int logicalHashCode() {
	return hashCode();
    }
}
