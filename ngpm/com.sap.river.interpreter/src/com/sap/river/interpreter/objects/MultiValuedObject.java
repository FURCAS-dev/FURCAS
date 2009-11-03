package com.sap.river.interpreter.objects;

import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

import com.sap.river.interpreter.RiverInterpreter;

import data.classes.TypeDefinition;

/**
 * Represents a multi-object that is instance of one of the different
 * kinds of type definitions, such as class, function or nested (see {@link TypeDefinition} and
 * subclasses). It holds a reference to its (runtime) type. The reference to the type is immutable.
 * <p>
 * 
 * @author Axel Uhl (D043530)
 */
public class MultiValuedObject extends RiverObject {
    /**
     * An iterator over this multi-object that guarantees to return only single
     * objects from its {@link #next()} operation. Any multi-object that would be
     * returned by the multi-object's regular iterator because of nesting will
     * be unwound by this flattening iterator.
     */
    private class FlatteningIterator implements Iterator<RiverObject> {
	/**
	 * The stack of iterators as corresponds with the unwinding of the object nesting
	 * structure. Invariant: <tt>peek().hasNext() || size()==1</tt>. In other words,
	 * consumed iterators are popped off the stack after the last call to <tt>next</tt>.
	 */
	private Stack<Iterator<RiverObject>> iteratorStack = new Stack<Iterator<RiverObject>>();
	
	/**
	 * Either <tt>null</tt> in case there is no next object or a {@link RiverObject} that
	 * is not a {@link MultiValuedObject}.
	 */
	private RiverObject next;
	
	public FlatteningIterator() {
	    iteratorStack.push(MultiValuedObject.this.iterator());
	    advanceToNextSingleObject();
	}
	
	/**
	 * If the {@link #iteratorStack} is empty, sets {@link #next} to <tt>null</tt> and
	 * returns. Otherwise, consumes the next element of the stack's top iterator. If that yields
	 * a single object, assigns it to {@link #next}. Otherwise, creates an iterator over the
	 * multi-object, pushes it onto the stack and recurses. If the stack's top iterator has no
	 * next element, the iterator is popped off the stack, and this method is called
	 * recursively, unless the stack is empty in which case the method sets {@link #next} to
	 * <tt>null</tt> and returns.
	 */
	private void advanceToNextSingleObject() {
	    if (iteratorStack.isEmpty()) {
		next = null;
	    } else {
		Iterator<RiverObject> i = iteratorStack.peek();
		if (i.hasNext()) {
		    RiverObject candidate = i.next();
		    if (candidate instanceof MultiValuedObject) {
			iteratorStack.push(candidate.iterator());
			advanceToNextSingleObject();
		    } else if (candidate instanceof EmptyObject) {
			// skip empty object
			advanceToNextSingleObject();
		    } else {
			next = candidate;
		    }
		} else {
		    iteratorStack.pop();
		    advanceToNextSingleObject();
		}
	    }
	}

	@Override
	public boolean hasNext() {
	    return next != null;
	}

	@Override
	public RiverObject next() {
	    RiverObject result = next;
	    advanceToNextSingleObject();
	    return result;
	}

	@Override
	public void remove() {
	    throw new UnsupportedOperationException("No remove on multi-object");
	}
	
    }
    
    /**
     * An iterator wrapping an iterable and skipping the first element. This gives
     * "tail" behavior.
     * 
     * @author Axel Uhl (D043530)
     */
    private static class TailIterable<T> implements Iterable<T> {
	private Iterable<T> wrapped;
	
	private static class TailIterator<T> implements Iterator<T> {
	    private Iterator<T> iter;

	    public TailIterator(Iterable<T> iterable) {
		iter = iterable.iterator();
		if (iter.hasNext()) {
		    iter.next(); // skip first
		}
	    }

	    @Override
	    public boolean hasNext() {
		return iter.hasNext();
	    }

	    @Override
	    public T next() {
		return iter.next();
	    }

	    @Override
	    public void remove() {
		throw new RuntimeException("Remove not supported on multi-object");
	    }
	}
	
	public TailIterable(Iterable<T> i) {
	    wrapped = i;
	}
	
	public Iterator<T> iterator() {
	    return new TailIterator<T>(wrapped);
	}
	
    }
    
    private Iterable<RiverObject> objects;
    
    public MultiValuedObject(TypeDefinition type, Iterable<RiverObject> objects) {
	super(type);
	// TODO this assertion should be re-activated once we have solved the NestedTypeDefinition / OutputMultiplicities problem
	// assert(RiverInterpreter.isMultiple(type.getUpperMultiplicity()));
	this.objects = objects;
    }
    
    public Iterator<RiverObject> iterator() {
	// TODO ensure that remove() will throw an exception when called on the resulting iterator
	return objects.iterator();
    }
    
    public Iterable<RiverObject> flatten() {
	return new Iterable<RiverObject>() {
	    public Iterator<RiverObject> iterator() {
		return new FlatteningIterator();
	    }
	};
    }
    
    public boolean equals(Object o) {
	if (!(o instanceof RiverObject)) {
	    return false;
	}
	if (this == o) {
	    return true;
	}
	return RiverInterpreter.equals(this, (RiverObject) o);
    }
    
    public boolean logicallyEquals(RiverObject o) {
	Iterator<RiverObject> it1 = this.iterator();
	Iterator<RiverObject> it2 = o.iterator();
	while (it1.hasNext()) {
	    if (!it2.hasNext() || !it1.next().logicallyEquals(it2.next())) {
		return false;
	    }
	}
	if (it2.hasNext()) {
	    return false;
	}
	return true;
    }
    
    public int hashCode() {
	int result = 198274309;
	for (RiverObject ro:this) {
	    result ^= ro.hashCode();
	}
	return result;
    }
    
    public int size() {
	if (objects instanceof Collection<?>) {
	    return ((Collection<?>) objects).size();
	} else {
	    int result = 0;
	    Iterator<RiverObject> i=iterator();
	    while (i.hasNext()) {
		result++;
		i.next();
	    }
	    return result;
	}
    }
    
    public String toString() {
	StringBuilder sb = new StringBuilder();
	if (size() > 0) { // FIXME: replace by getType.isMany() when OutputMultiplicity issue is fixed
	    boolean first = true;
	    if (getType() != null && getType().isUnique()) {
		if (getType().isOrdered()) {
		    sb.append("{[");
		} else {
		    sb.append('{');
		}
	    } else {
		if (getType() != null && getType().isOrdered()) {
		    sb.append("[");
		} else {
		    sb.append('(');
		}
	    }
	    for (RiverObject ro : this) {
		if (!first) {
		    sb.append(", ");
		}
		sb.append(ro);
		first = false;
	    }
	    if (getType() != null && getType().isUnique()) {
		if (getType().isOrdered()) {
		    sb.append("]}");
		} else {
		    sb.append('}');
		}
	    } else {
		if (getType() != null && getType().isOrdered()) {
		    sb.append("]");
		} else {
		    sb.append(')');
		}
	    }
	} else {
	    // MultiObject has Upper Multiplicity == 1
	    if (!this.isEmpty()) {
		sb.append(this.iterator().next());
	    }
	    else {
		sb.append(EmptyObject.MESSAGE);
	    }
	}
	return sb.toString();
    }

    /**
     * Returns the tail of this {@link MultiValuedObject}.
     */
    public RiverObject tail() {
	return new MultiValuedObject(getType(), new TailIterable<RiverObject>(this));
    }
}
