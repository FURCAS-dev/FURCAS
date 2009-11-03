package org.oslo.ocl20.standard.lib;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.model.types.TupleType;


public class OclTupleImpl extends OclAnyImpl implements OclTuple {
	private java.util.Map _implementation;

	protected java.util.Map implementation() {
		return _implementation;
	}
	Map _elementTypes;
	String[] _keys;
	Classifier[] _types;

	public OclTupleImpl(Map m, StdLibAdapter adapter) {
		super(adapter);
		_implementation = m;
		_keys = (String[])m.keySet().toArray(new String[]{});
		Vector types = new Vector();
		Iterator i = m.values().iterator();
		while(i.hasNext()) {
		    Object o = i.next();
		    OclAny oa = adapter.OclAny(o);
		    Classifier c = (Classifier)oa.oclType().asJavaObject();
		    types.add(c);
		}
		_types= (Classifier[])types.toArray(new Classifier[]{});
		type = adapter.getProcessor().getTypeFactory().buildTupleType(_keys,_types);
	}

    public OclTupleImpl(TupleType tT, OclAny[] arr, StdLibAdapter adapter) {
		super(adapter);
		type = tT;
		_implementation = new HashMap();
		_types = (Classifier[])tT.getTypes().toArray(new Classifier[0]);
		_keys = (String[])tT.getNames().toArray(new String[0]);
		for (int i = 0; i < _keys.length; i++) {
			_implementation.put(_keys[i], arr[i]);
		}
	}
	public Object asJavaObject() {
		return implementation();
	}

	TupleType type;
	public OclType oclType() {
		//Classifier type = adapter.getProcessor().getTypeFactory().buildTupleType(_keys, _types);
		return adapter.Type(type);
	}

	//--- IOclTuple ---
	public OclAny property(OclString s) {
		String key = ((OclStringImpl)s).implementation();
		OclAny o = (OclAny)_implementation.get(key);
		if (o == null)
			//return adapter.Undefined("Tuple doesn't contain element - "+key,null);
			return adapter.Undefined();
		return o;
	}

	public OclAny property(OclString s, Object[] pobjs) {
		return adapter.Undefined(); //property(s);
	}

	public void setProperty(OclString name, Object value) {
		String key = ((OclStringImpl)name).implementation();
		_implementation.put(key, value);
	}

	//--- Object ---
	public String toString() {
		String str = "Tuple { ";
		Iterator i = _implementation.keySet().iterator();
		while (i.hasNext()) {
			String s = (String) i.next();
			str += s + " = " + _implementation.get(s);
			if (i.hasNext())
				str += ", ";
		}
		return str + " }";
	}

	public boolean equals(Object o) {
		if (o instanceof OclTupleImpl) {
			OclTupleImpl tuple = (OclTupleImpl)o;
			return _implementation.equals(tuple._implementation);
		} else {
			return false;
		}
	}

	public Object clone() {
		return new OclTupleImpl(
		    type,
			(OclAny[])_implementation.values().toArray(new OclAny[0]),
			super.adapter
			);
	}

	//--- IOclVisitable ---
	public Object accept(OclVisitor v, Object obj) {
		return v.visit(this, obj);
	}
}
