/*
 * Created on 07-Jun-2003
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package org.oslo.ocl20.standard.lib;

import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.model.types.TupleType;


/**
 * @author dha
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public interface StdLibAdapter {
	OclProcessor getProcessor();
	
	OclAny OclAny(Classifier t, java.lang.Object obj);
	OclAny OclAny(java.lang.Object obj);
	//java.lang.Object impl(OclAny obj);
	
	OclAnyModelElement OclAnyModelElement(Classifier type, java.lang.Object obj);
	//java.lang.Object impl(OclAnyModelElement obj);

	OclEnumeration Enumeration(Classifier type,java.lang.Object obj);
	
	OclType Type(Classifier cls);
	//java.lang.Class impl(OclType type);
	
	OclUndefined Undefined();

	OclBoolean Boolean(boolean b);
	OclBoolean Boolean(java.lang.Boolean b);
	OclBoolean Boolean(java.lang.String b);
	//java.lang.Boolean impl(OclBoolean b);

	OclReal Real(double r);
	OclReal Real(Double r);
	OclReal Real(java.lang.String r);
	OclReal Real(float r);
	//java.lang.Double impl(OclReal r);

	OclInteger Integer(int i);
	OclInteger Integer(Integer i);
	OclInteger Integer(String i);
	//java.lang.Integer impl(OclInteger i);
	
	OclString String(java.lang.String s);
	//java.lang.String impl(OclString s);
	
	OclTuple Tuple(TupleType tT, java.util.Map m);
	OclTuple Tuple(TupleType tT, OclAny[] arr);
    OclTuple Tuple(TupleType tT, Object tuple);
	//OclTuple Tuple(Classifier tT, Classifier[] types, String[] keys, OclAny[] arr);
	//java.util.Map impl(OclTuple t);
	
	OclCollection Collection(Classifier eT);
	OclCollection Collection(java.util.Collection obj);
	//java.util.Collection impl(OclCollection b);
	
	OclSet Set(Classifier eT);
	OclSet Set(Classifier eT,java.util.Collection impl);
	OclSet Set(Classifier eT, Object[] array);
    OclSet Set(Classifier eT, Object data);    
	//java.util.Set impl(OclSet s);
	
	OclOrderedSet OrderedSet(Classifier eT);
	OclOrderedSet OrderedSet(Classifier eT,java.util.Collection impl);
	OclOrderedSet OrderedSet(Classifier eT, Object[] array);
    OclOrderedSet OrderedSet(Classifier eT, Object data);
	//java.util.List impl(OclOrderedSet s);
	
	OclSequence Sequence(Classifier eT);
	OclSequence Sequence(Classifier eT,java.util.Collection impl);
	OclSequence Sequence(Classifier eT, Object[] array);
    OclSequence Sequence(Classifier eT, Object data);
	//java.util.List impl(OclSequence s);
	
	OclBag Bag(Classifier eT);
	OclBag Bag(Classifier eT,java.util.Collection impl);
	OclBag Bag(Classifier eT, Object[] array);
    OclBag Bag(Classifier eT, Object data);
	//java.util.Collection impl(OclBag b);

}
