package org.oslo.ocl20.standard.lib;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.oslo.ocl20.semantics.bridge.Classifier;


public class OclOrderedSetImpl
extends OclCollectionImpl
	implements OclOrderedSet
{
	public OclOrderedSetImpl(Classifier eT, Object[] array, StdLibAdapter adapter) {
		super(eT,adapter);
		_implementation = new Vector();
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				if (((OclBooleanImpl)includes(array[i])) != OclBooleanImpl.TRUE) 
					_implementation.add(array[i]);
			}
		}
	}

	public OclType oclType() {
		Classifier type = adapter.getProcessor().getTypeFactory().buildOrderedSetType(super.getElementType());
		return adapter.Type(type);
	}

	java.util.List _implementation;
	protected java.util.Collection implementation() {
		return _implementation;
	}
	protected java.util.List orderedset_impl() {
		return _implementation;
	}

	public OclBoolean equalTo(OclOrderedSet set2) {
		if ( ((OclBooleanImpl)this.size().notEqualTo(set2.size())) == OclBooleanImpl.TRUE )
			return adapter.Boolean(false);
		Collection b = implementation();
		Iterator it = b.iterator();
		List t = orderedset_impl();
		List s = (List)set2.getImplementation();
		for(int i=0; i< t.size(); i++) {
			if (!t.get(i).equals(s.get(i)))
				return (OclBoolean)adapter.Boolean(false);
		}
		return adapter.Boolean(true);
	}
	
	public OclBoolean notEqualTo(OclOrderedSet set2) {
		return equalTo(set2).not();
	}

	//--- Set ---
	public OclBoolean equalTo(OclSet set2) {
		return this.asSet().equalTo(set2);
	}
	public OclBoolean notEqualTo(OclSet set2) {
		if (set2 instanceof OclOrderedSet)
			return this.notEqualTo((OclOrderedSet)set2);
		else
			return adapter.Boolean(true);
	}

	public OclSet union(OclOrderedSet set2) {
		OclOrderedSet s = this.union(set2.asBag()).asOrderedSet();
		return s;
	}

	public OclSet union(OclSet set2) {
		OclSet s = this.union(set2.asBag()).asSet();
		return s;
	}

	public OclBag union(OclBag bag) {
		OclBagImpl b = (OclBagImpl) adapter.Bag(this.getElementType(), orderedset_impl());
		b.implementation().addAll(((OclBagImpl) bag).implementation());
		return b;
	}

	public OclSet intersection(OclSet set2) {
		OclSet s =  adapter.Set(this.getElementType() );
		List s1 = (List)this.implementation();
		Collection s2;
		if (set2 instanceof OclOrderedSetImpl) {
			s2 = (Collection)((OclOrderedSetImpl)set2).implementation();
		} else {
			s2 = (Collection)((OclSetImpl)set2).implementation();
		}
		Iterator i1 = s1.iterator();
		while (i1.hasNext()) {
			OclAny o = (OclAny) i1.next();
			if (((OclBooleanImpl)set2.includes(o)) == OclBooleanImpl.TRUE)
				s = s.including(o);
		}
		Iterator i2 = s2.iterator();
		while (i2.hasNext()) {
		    OclAny o = (OclAny) i2.next();
			if (((OclBooleanImpl)this.includes(o)) == OclBooleanImpl.TRUE)
				s = s.including(o);
		}
		return s;
	}

	public OclSet intersection(OclBag bag) {
		return this.intersection(bag.asSet());
	}

	public OclSet intersection(OclOrderedSet set2) {
		return this.intersection(set2.asSet()).asOrderedSet();
	}

	public OclSet subtract(OclSet set2) {
		OclSet s =  adapter.Set(this.getElementType());
		List set = (List)this.implementation();
        // TODO TODOMWA remove dirty hack !!
		Collection s2 = null;
        if (set2 instanceof OclSetImpl) {
            s2 = ((OclSetImpl)set2).implementation();            
        } else {
            s2 = ((OclOrderedSetImpl)set2).implementation();            
        }
		Iterator i1 = set.iterator();
		while (i1.hasNext()) {
		    OclAny o = (OclAny) i1.next();
			if (!s2.contains(o))
				s=s.including(o);
		}
		return s;
	}

	public OclSet symmetricDifference(OclSet set2) {
		OclSet s = adapter.Set(this.getElementType());
		List s1 = (List)this.implementation();
        // TODO TODOMWA remove dirty hack !!
        Collection s2 = null;
        if (set2 instanceof OclSetImpl) {
            s2 = ((OclSetImpl)set2).implementation();            
        } else {
            s2 = ((OclOrderedSetImpl)set2).implementation();            
        }
		Iterator i1 = s1.iterator();
		while (i1.hasNext()) {
		    OclAny o = (OclAny) i1.next();
			if (!s2.contains(o))
				s=s.including(o);
		}
		Iterator i2 = s2.iterator();
		while (i2.hasNext()) {
		    OclAny o = (OclAny) i2.next();
			if (!s1.contains(o))
				s=s.including(o);
		}
		return s;
	}

	//--- OrderedSet ---
	public OclOrderedSet append(OclAny object) {
		OclOrderedSetImpl seq = (OclOrderedSetImpl)this.clone();
		if (object instanceof OclUndefined) return seq;
		if (((OclBooleanImpl)includes(object)) != OclBooleanImpl.TRUE) 
			seq._implementation.add(object);
		return seq;
	}

	public OclOrderedSet prepend(OclAny object) {
		OclOrderedSetImpl seq = (OclOrderedSetImpl)this.clone();
		if (object instanceof OclUndefined) return seq;
		if (((OclBooleanImpl)includes(object)) != OclBooleanImpl.TRUE) 
			seq._implementation.add(0,object);
		return seq;
	}

	public OclSet including(OclAny object) {
		return this.append(object);
	}

	public OclSet excluding(OclAny object) {
		OclOrderedSetImpl seq = (OclOrderedSetImpl)this.clone();
		Collection col = new ArrayList();
		col.add(object);
		seq._implementation.removeAll(col);
		return seq;
	}

	public OclOrderedSet insertAt(OclInteger index, OclAny object) {
		OclOrderedSetImpl seq = (OclOrderedSetImpl)this.clone();
		if (object instanceof OclUndefined) return seq;
		int i = ((OclIntegerImpl)index).int_impl();
		if (((OclBooleanImpl)includes(object)) != OclBooleanImpl.TRUE) 
			seq._implementation.add(i-1,object);
		return seq;
	}

	public OclOrderedSet subOrderedSet(OclInteger lower, OclInteger upper) {
		if (((OclIntegerImpl)lower).int_impl() < 1) return null;
		if (((OclIntegerImpl)upper).int_impl() > ((OclIntegerImpl)this.size()).int_impl() )  return null;
		int l = ((OclIntegerImpl)lower).int_impl() - 1;
		int u = ((OclIntegerImpl)upper).int_impl() - 1 +1;
		return adapter.OrderedSet(this.getElementType(), orderedset_impl().subList(l, u));
	}

	public OclAny at(OclInteger i) {
		return (OclAny)orderedset_impl().get(((OclIntegerImpl)i).int_impl()-1);
	}

	public OclInteger indexOf(OclAny object) {
		Iterator i = _implementation.iterator();
		int j = 1;
		while (i.hasNext()) {
			Object obj = i.next();
			if (obj.equals(object)) return adapter.Integer(j);
			j++;
		}
		return adapter.Integer(0);
	}

	public OclAny first() {
		if (orderedset_impl().size() < 1) return adapter.Undefined();
		return (OclAny)orderedset_impl().get(0);
	}
	
	public OclAny last() {
		if (orderedset_impl().size() < 1) return adapter.Undefined();
		return (OclAny)orderedset_impl().get(orderedset_impl().size() - 1);
	}

	public OclSet flatten() {
		OclOrderedSet flat = (OclOrderedSet)this.clone();
		((java.util.Collection)flat.getImplementation()).clear();
		java.util.Iterator i = _implementation.iterator();
		while (i.hasNext()) {
			Object elem = i.next();
			if (elem instanceof OclCollection) {
				java.util.Iterator j = null;
				if (elem instanceof OclBag) {
					j = ((Collection)((OclBag)elem).flatten().getImplementation()).iterator();
				} else if (elem instanceof OclOrderedSet) {
					j = ((Collection)((OclOrderedSet)elem).flatten().getImplementation()).iterator();
				} else if (elem instanceof OclSet) {
					j = ((Collection)((OclSet)elem).flatten().getImplementation()).iterator();
				} else if (elem instanceof OclSequence) {
					j = ((Collection)((OclSequence)elem).flatten().getImplementation()).iterator();
				}
				while (j.hasNext()) {
					OclAny x = (OclAny)j.next();
					if (x!= null && ((OclBooleanImpl)flat.excludes(x)) == OclBooleanImpl.TRUE )
					   flat = (OclOrderedSet)flat.including(x);
				}
			} else {
				((java.util.Collection)flat.getImplementation()).add(elem);
			}
		}
		return flat;
	}

	//--- Object ---
	public String toString() {
		String str = "OrderedSet { ";
		java.util.Iterator i = _implementation.iterator();
		while (i.hasNext()) {
			str += i.next();
			if (i.hasNext())
				str += ", ";
		}
		return str + " }";
	}
	
	public boolean equals(Object o) {
		return (o instanceof OclSet) ? ((OclBooleanImpl)equalTo((OclOrderedSet)o)) == OclBooleanImpl.TRUE : false;
	}
	
	public Object clone() {
		return adapter.OrderedSet(this.getElementType(), _implementation);
	}
	
	public Object asJavaObject() {
		EList jObj = new BasicEList();
		Iterator i = _implementation.iterator();
		while (i.hasNext()) {
			Object o = i.next();
			if (o instanceof OclAny)
				o = ((OclAny)o).asJavaObject();
			jObj.add( o );
		}
		return ECollections.unmodifiableEList(jObj);
	}
}
