package org.oslo.ocl20.standard.lib;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import org.oslo.ocl20.semantics.bridge.Classifier;


public class OclBagImpl
 extends OclCollectionImpl
 implements OclBag
{
	public OclBagImpl(Classifier eT, Object[] array, StdLibAdapter adapter) {
		super(eT,adapter);
		_implementation = new Vector(Arrays.asList(array));
	}

	public OclType oclType() {
		Classifier type = adapter.getProcessor().getTypeFactory().buildBagType(super.getElementType());
		return adapter.Type(type);
	}

	java.util.Collection _implementation;
	protected java.util.Collection implementation() {
		return _implementation;
	}
	protected java.util.Collection bag_impl() {
		return _implementation;
	}

	public OclBoolean equalTo(OclBag bag2) {
	    Collection this_bag = (Collection)this.implementation();
	    Collection b2 = (Collection)((OclBagImpl)bag2).implementation();
		if (this_bag.size() != b2.size() )
			return adapter.Boolean(false);
		Collection b = implementation();
		Iterator it = b.iterator();
		while (it.hasNext()) {
			OclAny ob = (OclAny) it.next();
			if (((OclBooleanImpl)count(ob).equalTo(bag2.count(ob))) != OclBooleanImpl.TRUE)
				return adapter.Boolean(false);
		}
		return adapter.Boolean(true);
	}

	public OclBoolean notEqualTo(OclBag bag2) {
		return equalTo(bag2).not();
	}

	public OclBag union(OclBag bag2) {
		OclBagImpl b = (OclBagImpl) adapter.Bag(this.getElementType(), implementation());
		b.implementation().addAll(((OclBagImpl) bag2).implementation());
		return b;
	}

	public OclBag union(OclSet set) {
		OclBagImpl b = (OclBagImpl) adapter.Bag(this.getElementType(), implementation());
		if (set instanceof OclOrderedSetImpl) { 
			// TODO
			// TODOMWA introduce get as java collection !!
			b.implementation().addAll(((OclOrderedSetImpl) set).orderedset_impl());			
		} else {
			b.implementation().addAll(((OclSetImpl) set).set_impl());
		}
		return b;
	}

	public OclBag union(OclOrderedSet set) {
		OclBagImpl b = (OclBagImpl) adapter.Bag(this.getElementType(), implementation());
		b.implementation().addAll(((OclOrderedSetImpl) set).orderedset_impl());
		return b;
	}

	public OclBag intersection(OclBag bag2) {
		OclBag b = adapter.Bag(this.getElementType());
		Collection b1 = new Vector((Collection)this.getImplementation());
		Collection b2 = new Vector((Collection)bag2.getImplementation());
		Iterator i1 = b1.iterator();
		while (i1.hasNext()) {
			OclAny o = (OclAny) i1.next();
			if (((OclBooleanImpl)bag2.includes(o)) == OclBooleanImpl.TRUE) {
				b = b.including(o);
				i1.remove();
				b2.remove(o);
			}
		}
		Iterator i2 = b2.iterator();
		while (i2.hasNext()) {
		    OclAny o = (OclAny) i2.next();
			if (((OclBooleanImpl)this.includes(o)) == OclBooleanImpl.TRUE)
				b = b.including(o);
		}
		return b;
	}

	public OclSet intersection(OclSet set) {
		return this.intersection(set.asBag()).asSet();
	}

	public OclOrderedSet intersection(OclOrderedSet set) {
		return this.intersection(set.asOrderedSet());
	}

	public OclBag including(OclAny object) {
		OclBagImpl b = (OclBagImpl) adapter.Bag(this.getElementType(), implementation());
		if (object instanceof OclUndefined) return b;
		((Collection)b.getImplementation()).add(object);
		return b;
	}

	public OclBag excluding(OclAny object) {
		OclBagImpl b = (OclBagImpl) adapter.Bag(this.getElementType(), implementation());
		Vector v = new Vector();
		v.add(object);
		b.implementation().removeAll(v);
		return b;
	}

	public OclInteger count(OclAny object) {
		return super.count(object);
	}

	public OclBag flatten() {
		OclBag flat = adapter.Bag(this.getElementType());
		java.util.Iterator i = _implementation.iterator();
		while (i.hasNext()) {
			OclAny elem = (OclAny) i.next();
			if (elem instanceof OclBag) {
				flat = flat.union( ((OclBag)elem) );
			} else if (elem instanceof OclSet) {
				flat = flat.union( ((OclSet)elem) );
			} else if (elem instanceof OclSequence) {
				flat = flat.union( ((OclSequence)elem).asBag() );
			} else {
				flat = flat.including(elem);
			}
		}
		return flat;
	}

	//--- IOclVisitable ---
	public Object accept(OclVisitor v, Object obj) {
		return v.visit(this, obj);
	}

	//--- Object ---
	public String toString() {
		String str = "Bag { ";
		java.util.Iterator i = _implementation.iterator();
		while (i.hasNext()) {
			str += i.next();
			if (i.hasNext())
				str += ", ";
		}
		return str + " }";
	}

	public Object clone() {
		return adapter.Bag(this.getElementType(), implementation());
	}

	public boolean equals(Object o) {
		if (o instanceof OclBag) {
			OclBoolean b = equalTo((OclBag)o);
			return ((OclBooleanImpl)b) == OclBooleanImpl.TRUE;
		}
		return false;
	}

	public Object asJavaObject() {
		Collection jObj = new Vector();
		Iterator i = _implementation.iterator();
		while (i.hasNext()) {
			Object o = i.next();
			if (o instanceof OclAny)
				o = ((OclAny)o).asJavaObject();
			jObj.add( o );
		}
		return java.util.Collections.unmodifiableCollection(jObj);
	}

}
