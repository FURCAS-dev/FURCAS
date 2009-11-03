package org.oslo.ocl20.standard.lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.oslo.ocl20.semantics.bridge.Classifier;


public class OclSequenceImpl extends OclCollectionImpl implements OclSequence {
	private java.util.List _implementation;

	protected void setImplementation(java.util.List list) {
		_implementation = list;
	}
	protected java.util.Collection implementation() {
		return _implementation;
	}
	protected java.util.List list_impl() {
		return _implementation;
	}

	public OclSequenceImpl(Classifier eT, Object[] array, StdLibAdapter adapter) {
		super(eT, adapter);
		setImplementation(new Vector(Arrays.asList(array)));
	}

	public OclType oclType() {
		Classifier type = adapter.getProcessor().getTypeFactory().buildSequenceType(super.getElementType());
		return adapter.Type(type);
	}

	//--- IOclSequence ---
	public OclInteger count(OclAny object) {
		return super.count(object);
	}

	public OclBoolean equalTo(OclSequence sequence2) {
		if ( ((OclBooleanImpl)this.size().equalTo(sequence2.size()).not()) == OclBooleanImpl.TRUE )
			return adapter.Boolean(false);
		List l = list_impl();
		List l2 = ((OclSequenceImpl) sequence2).list_impl();
		return adapter.Boolean(l.equals(l2));
	}

	public OclBoolean notEqualTo(OclSequence sequence2) {
		return equalTo(sequence2).not();
	}

	public OclSequence union(OclSequence sequence2) {
		OclSequenceImpl s = (OclSequenceImpl) adapter.Sequence(this.getElementType(), list_impl());
		s.list_impl().addAll(((OclSequenceImpl) sequence2).list_impl());
		return s;
	}

	public OclSequence append(OclAny object) {
		OclSequenceImpl seq = (OclSequenceImpl) adapter.Sequence(this.getElementType(), list_impl());
		if (object instanceof OclUndefined) return seq;
		seq.implementation().add(object);
		return seq;
	}

	public OclSequence prepend(OclAny object) {
		OclSequenceImpl seq = (OclSequenceImpl) adapter.Sequence(this.getElementType(), list_impl());
		if (object instanceof OclUndefined) return seq;
		seq.list_impl().add(0, object);
		return seq;
	}

	public OclSequence subSequence(OclInteger lower, OclInteger upper) {
		if (((OclIntegerImpl)lower).int_impl() < 1) return null;
		if (((OclIntegerImpl)upper).int_impl() > ((OclIntegerImpl)this.size()).int_impl() )  return null;
		int l = ((OclIntegerImpl) lower).int_impl() - 1;
		int u = ((OclIntegerImpl) upper).int_impl() - 1 +1;
		return adapter.Sequence(this.getElementType(), new Vector(list_impl().subList(l, u)));
	}

	public Object at(OclInteger i) {
		if (((OclIntegerImpl)i).int_impl() < 1) return null;
		if (((OclIntegerImpl)i).int_impl() > list_impl().size() )  return null;
		return list_impl().get(((OclIntegerImpl) i).int_impl() - 1);
	}

	public OclInteger indexOf(OclAny o) {
		return adapter.Integer( list_impl().indexOf(o) + 1 );
	}

	public OclAny first() {
		if (list_impl().size() < 1) return adapter.Undefined();
		Object first = list_impl().get(0); 
		return (OclAny)first;
	}
	
	public OclSequence tail() {
		return adapter.Sequence(this.getElementType(), list_impl().subList(1,list_impl().size()) );
	}
	
	public OclSequence insertAt(OclInteger i, OclAny object) {
		OclSequenceImpl seq = (OclSequenceImpl)this.clone();
		if (object instanceof OclUndefined) return seq;
		seq.list_impl().add( ((OclIntegerImpl)i).int_impl()-1, object );
		return seq;
	}
	
	public OclAny last() {
		if (list_impl().size() < 1) return adapter.Undefined();
		return (OclAny) list_impl().get(list_impl().size() - 1);
	}

	public OclSequence including(OclAny object) {
		return this.append(object);
	}

	public OclSequence excluding(OclAny object) {
		OclSequenceImpl s = (OclSequenceImpl) adapter.Sequence(this.getElementType(), this.list_impl());
		Collection col = new ArrayList();
		col.add(object);
		s.list_impl().removeAll(col);
		return s;
	}

	public OclSequence flatten() {
		OclSequenceImpl flat = (OclSequenceImpl) adapter.Sequence(this.getElementType());
		java.util.Iterator i = _implementation.iterator();
		while (i.hasNext()) {
			Object elem = (Object) i.next();
			if (elem instanceof OclBag) {
				flat.implementation().addAll(((Collection)((OclBag) elem).flatten().getImplementation()));
			} else if (elem instanceof OclSet) {
				flat.implementation().addAll(((Collection)((OclSet) elem).flatten().getImplementation()));
			} else if (elem instanceof OclSequence) {
				flat.implementation().addAll(((Collection)((OclSequence) elem).flatten().getImplementation()));
			} else {
				flat.implementation().add(elem);
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
		String str = "Sequence { ";
		Iterator i = _implementation.iterator();
		while (i.hasNext()) {
			str += i.next();
			if (i.hasNext())
				str += ", ";
		}
		return str + " }";
	}

	public Object clone() {
		return adapter.Sequence(this.getElementType(),list_impl());
	}

	public boolean equals(Object o) {
		return (o instanceof OclSequence) ? ((OclBooleanImpl)equalTo((OclSequence)o)) == OclBooleanImpl.TRUE : false;
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
