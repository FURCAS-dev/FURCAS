/*
 * Created on 07-Jun-2003
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package org.oslo.ocl20.standard.lib;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.model.types.BagType;
import org.oslo.ocl20.semantics.model.types.BooleanType;
import org.oslo.ocl20.semantics.model.types.CollectionType;
import org.oslo.ocl20.semantics.model.types.IntegerType;
import org.oslo.ocl20.semantics.model.types.OclAnyType;
import org.oslo.ocl20.semantics.model.types.OrderedSetType;
import org.oslo.ocl20.semantics.model.types.RealType;
import org.oslo.ocl20.semantics.model.types.SequenceType;
import org.oslo.ocl20.semantics.model.types.SetType;
import org.oslo.ocl20.semantics.model.types.StringType;
import org.oslo.ocl20.semantics.model.types.TupleType;
import org.oslo.ocl20.semantics.model.types.VoidType;



/**
 * @author dha
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class StdLibAdapterImpl
implements StdLibAdapter
{
	private OclProcessor processor;
	public OclProcessor getProcessor() {return processor;}

	public StdLibAdapterImpl(OclProcessor proc) {
		this.processor = proc;
		OclUndefinedImpl.UNDEFINED = new OclUndefinedImpl("Default", null, this);
		OclBooleanImpl.FALSE = new OclBooleanImpl(this);
		OclBooleanImpl.TRUE = new OclBooleanImpl(this);
	}

	public OclAny OclAny(java.lang.Object obj) {
		if (obj == null) return this.Undefined();
		if (obj instanceof OclAny) return (OclAny)obj;
		if (obj instanceof OclCollection) return (OclCollection)obj;
		if (obj instanceof java.lang.Boolean) return this.Boolean((java.lang.Boolean)obj);
		if (obj instanceof java.lang.String) return this.String((java.lang.String)obj);
		if (obj instanceof java.lang.Double) return this.Real((java.lang.Double)obj);
		if (obj instanceof java.lang.Float) return this.Real(new Double(((java.lang.Float)obj).doubleValue()));
		if (obj instanceof java.lang.Integer) return this.Integer((java.lang.Integer)obj);
		if (obj instanceof java.lang.Long) return this.Integer(new Integer(((java.lang.Long)obj).intValue()));
		

		if (obj instanceof java.util.Collection) return this.Collection((java.util.Collection)obj);
		if (obj instanceof java.util.Map) return this.Tuple((java.util.Map)obj);

		if (obj instanceof java.lang.Object) return this.OclAnyModelElement(null, (java.lang.Object)obj);

		return this.Undefined();
	}

	public OclAny OclAny(Classifier type, java.lang.Object obj) {
		if (type == null) return this.Undefined();
		if (type instanceof VoidType) return this.Undefined();
		if (type instanceof BooleanType) return this.Boolean((Boolean)obj);
		if (type instanceof StringType) return this.String((String)obj);
		if (type instanceof IntegerType) return this.Integer((Integer)obj);
		if (type instanceof RealType) return this.Real((Double)obj);
		if (type instanceof TupleType) return this.Tuple((TupleType)type, (Map)obj);
		if (type instanceof CollectionType) return this.Collection((Collection)obj);
		return this.OclAnyModelElement(type, obj);
	}

	/*public Object impl(OclAny obj) {
		if (obj instanceof OclUndefined) return this.impl((OclUndefined)obj);
		if (obj instanceof OclString) return this.impl((OclString)obj);
		if (obj instanceof OclInteger) return this.impl((OclInteger)obj);
		if (obj instanceof OclReal) return this.impl((OclReal)obj);
		if (obj instanceof OclBoolean) return this.impl((OclBoolean)obj);
		if (obj instanceof OclTuple) return this.impl((OclTuple)obj);
		return null;
	}*/

	public OclType Type(Classifier cls) {
		return new OclTypeImpl(cls, this);
	}

	public OclAnyModelElement OclAnyModelElement(Classifier type, java.lang.Object obj) {
		return new OclAnyModelElementImpl(obj, this);
	}

	//public java.lang.Object impl(OclAnyModelElement obj) {
	//	return obj.asJavaObject();
	//}
	
	public OclEnumeration Enumeration(Classifier type,java.lang.Object obj) {
		return new OclEnumerationImpl(type, obj,this);
	}

	//--- Undefined ---
	//public Object impl(OclUndefined obj) {
	//	return null;
	//}
	
	public OclUndefined Undefined() {
		return OclUndefinedImpl.UNDEFINED;
	}

	//--- Boolean ---
	public OclBoolean Boolean(boolean b) {
		if (b)
			return OclBooleanImpl.TRUE;
		return OclBooleanImpl.FALSE;
	}

	public OclBoolean Boolean(java.lang.Boolean b) {
		if (b != null)
			return Boolean(b.booleanValue());
		else
			return Undefined();
	}

	public OclBoolean Boolean(java.lang.String b) {
		return Boolean(Boolean.valueOf(b).booleanValue());
	}

	//public java.lang.Boolean impl(OclBoolean b) {
	//	return (java.lang.Boolean)b.asJavaObject();
	//}

	//--- Real ---
	public OclReal Real(double r) {
		return new OclRealImpl(r, this);
	}

	public OclReal Real(Double r) {
		return new OclRealImpl(r.doubleValue(), this);
	}

	public OclReal Real(java.lang.String r) {
		return new OclRealImpl(Double.valueOf(r).doubleValue(), this);
	}

	public OclReal Real(float r) {
		return new OclRealImpl((double) r, this);
	}

	//public java.lang.Double impl(OclReal r) {
	//	if (r instanceof OclInteger) return new Double( ((java.lang.Integer)r.asJavaObject()).doubleValue() );
	//	if (r instanceof OclReal) return (java.lang.Double)r.asJavaObject();
	//	return null;
	//}

	//--- Integer ---
	public OclInteger Integer(int i) {
		return new OclIntegerImpl(i, this);
	}

	public OclInteger Integer(Integer i) {
		return new OclIntegerImpl(i.intValue(), this);
	}

	public OclInteger Integer(String i) {
		return new OclIntegerImpl(Integer.valueOf(i).intValue(), this);
	}

	//public java.lang.Integer impl(OclInteger i) {
	//	return (java.lang.Integer)i.asJavaObject();
	//}

	//--- String ---
	public OclString String(java.lang.String s) {
		return new OclStringImpl(s, this);
	}

	//public java.lang.String impl(OclString s) {
	//	return (java.lang.String)s.asJavaObject();
	//}

	//--- Tuple ---
	public OclTuple Tuple(TupleType eT, java.util.Map m) {
		return Tuple(eT, (OclAny[])m.values().toArray(new OclAny[0]) );
	}

	public OclTuple Tuple(java.util.Map m) {
		return new OclTupleImpl(m, this);
	}

	
	public OclTuple Tuple(TupleType eT, OclAny[] arr) {
		return new OclTupleImpl(eT, arr, this);
	}
    
    public OclTuple Tuple(TupleType tT, Object tuple) {
        if (tuple instanceof java.util.Map) {
            return Tuple(tT, (java.util.Map) tuple);
        } else if (tuple instanceof OclAny[]) {
            return Tuple(tT, (OclAny[]) tuple);
        } else {
            throw new RuntimeException("Only objects of type java.util.Map or OclAny[] supported for the creation of tuples."); 
        }
    }


	//public java.util.Map impl(OclTuple t) {
	//	return (java.util.Map)t.asJavaObject();
	//}

	//--- Collection ---
	public OclCollection Collection(java.util.Collection obj) {
		OclAnyType oat = processor.getTypeFactory().buildOclAnyType();
		if (obj == null) return this.Undefined();
		if (obj instanceof java.util.List) return this.Sequence(oat, (java.util.List)obj);
		if (obj instanceof java.util.Set) return this.Set(oat, (java.util.Set)obj);
		if (obj instanceof java.util.Collection) return this.Bag(oat, (java.util.Collection)obj);
		return this.Undefined();
	}
	
	public OclCollection Collection(Classifier eT) {
		if (eT instanceof OrderedSetType) return this.OrderedSet(eT);
		if (eT instanceof SetType) return this.Set(eT);
		if (eT instanceof SequenceType) return this.Sequence(eT);
		if (eT instanceof BagType) return this.Bag(eT);
		return this.Undefined();
	}

	/*public java.util.Collection impl(OclCollection col) {
		if (col instanceof OclOrderedSet) return this.impl((OclOrderedSet)col);
		if (col instanceof OclSet) return this.impl((OclSet)col);
		if (col instanceof OclSequence) return this.impl((OclSequence)col);
		if (col instanceof OclBag) return this.impl((OclBag)col);
		return ((OclCollectionImpl)col).implementation();
	}*/
   
	//--- Set ---
	public OclSet Set(Classifier eT) {
		return Set(eT,new OclAny[0]);
	}

	public OclSet Set(Classifier eT,Set impl) {
		if (impl != null) {
			return new OclSetImpl(eT, convert(eT, impl), this); 
		} else {
			return Set(eT); 
		}
			
	}

	public OclSet Set(Classifier eT,java.util.Collection impl) {
		if (impl != null) {
			if (impl instanceof Set)
				return Set(eT,(Set)impl);
			return Set(eT, convert(eT, impl.toArray()));
		} else {
			return Set(eT); 
		}
			
	}

	public OclSet Set(Classifier eT, Object[] array) {
		return new OclSetImpl(eT, convert(eT, array), this);
	}
    
    public OclSet Set(Classifier eT, Object data) {
        if (data == null) {
            return Set(eT); 
        } else if (data instanceof Object[]) {
            return Set(eT, (Object[]) data);
        } else if (data instanceof java.util.Collection) {
            return Set(eT, (java.util.Collection) data);
        }
        throw new RuntimeException("Set must contain a Object[] or a java.util.Collection.");
    }

	//public java.util.Set impl(OclSet s) {
	//	return (java.util.Set)s.asJavaObject();
	//}

	//--- OrderedSet ---
	public OclOrderedSet OrderedSet(Classifier eT) {
		return OrderedSet(eT,new OclAny[0]);
	}

	public OclOrderedSet OrderedSet(Classifier eT,java.util.Collection impl) {
		return OrderedSet(eT,convert(eT, impl.toArray()));
	}

	public OclOrderedSet OrderedSet(Classifier eT, Object[] array) {
		return new OclOrderedSetImpl(eT, convert(eT, array), this);
	}
    
    public OclOrderedSet OrderedSet(Classifier eT, Object data) {
        if (data == null) {
            return OrderedSet(eT); 
        } else if (data instanceof Object[]) {
            return OrderedSet(eT, (Object[]) data);
        } else if (data instanceof java.util.Collection) {
            return OrderedSet(eT, (java.util.Collection) data);
        }
        throw new RuntimeException("OrderedSet must contain a Object[] or a java.util.Collection.");
    }

	//public java.util.List impl(OclOrderedSet s) {
	//	return (java.util.List)s.asJavaObject();
	//}

	//--- Sequence ---
	public OclSequence Sequence(Classifier eT) {
		return Sequence(eT, new OclAny[0]);
	}

	public OclSequence Sequence(Classifier eT, java.util.Collection impl) {
		return Sequence(eT, convert(eT, impl.toArray()));
	}

	public OclSequence Sequence(Classifier eT, Object[] array) {
		return new OclSequenceImpl(eT, convert(eT, array), this);
	}
    
    public OclSequence Sequence(Classifier eT, Object data) {
        if (data == null) {
            return Sequence(eT); 
        } else if (data instanceof Object[]) {
            return Sequence(eT, (Object[]) data);
        } else if (data instanceof java.util.Collection) {
            return Sequence(eT, (java.util.Collection) data);
        }
        throw new RuntimeException("Sequence must contain a Object[] or a java.util.Collection.");
    }

	//public java.util.List impl(OclSequence s) {
	//	return (java.util.List)s.asJavaObject();
	//}

	//--- Bag ---
	public OclBag Bag(Classifier eT) {
		return Bag(eT,new OclAny[0]);
	}

	public OclBag Bag(Classifier eT,java.util.Collection impl) {
		return Bag(eT, convert(eT, impl.toArray()));
	}

	public OclBag Bag(Classifier eT, Object[] array) {
		return new OclBagImpl(eT, convert(eT, array), this);
	}
    
    public OclBag Bag(Classifier eT, Object data) {
        if (data == null) {
            return Bag(eT); 
        } else if (data instanceof Object[]) {
            return Bag(eT, (Object[]) data);
        } else if (data instanceof java.util.Collection) {
            return Bag(eT, (java.util.Collection) data);
        }
        throw new RuntimeException("Bag must contain a Object[] or a java.util.Collection.");
    }

	//public java.util.Collection impl(OclBag b) {
	//	return (java.util.Collection)b.asJavaObject();
	//}
	
	protected OclAny[] convert(Classifier eT, Object[] array) {
		if (array instanceof OclAny[]) return (OclAny[])array;
		OclAny[] oclArray = new OclAny[array.length];
		for(int i = 0; i<array.length;i++) {
			oclArray[i] = this.OclAny(array[i]);
		}
		return oclArray;
	}

	protected Set convert(Classifier eT, Set set) {
		if (set.iterator().hasNext() && set.iterator().next() instanceof OclAny) return set;
		Set oclSet = new LinkedHashSet();
		for (Iterator iter=set.iterator(); iter.hasNext(); ) {
			oclSet.add(this.OclAny(iter.next()));
		}
		return oclSet;
	}
	
}
