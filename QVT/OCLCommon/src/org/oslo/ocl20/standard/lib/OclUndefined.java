package org.oslo.ocl20.standard.lib;

public interface OclUndefined
    extends OclAny, OclBoolean, OclReal, OclInteger, OclString,
            OclCollection
{
	public OclBoolean equalTo(OclCollection bag2);
	public OclBoolean notEqualTo(OclCollection bag2);
	
	public OclCollection union(OclCollection bag2);

	public OclCollection intersection(OclCollection bag2);

	public OclCollection including(OclAny object);
	public OclCollection excluding(OclAny object);

	public OclInteger count(OclAny object);
	public OclCollection flatten();

	public OclBag asBag();
	public OclSet asSet();
	public OclSequence asSequence();
	public OclOrderedSet asOrderedSet();
	
	public OclCollection subtract(OclSet set2);
	public OclCollection symmetricDifference(OclSet set2);
	
	OclCollection append(OclAny object);
	OclCollection prepend(OclAny object);
	OclCollection insertAt(OclInteger index, OclAny object);
	OclCollection subSequence(OclInteger lower, OclInteger upper);
	Object at(OclInteger i);
	OclInteger indexOf(OclAny object);
	OclAny first();
	OclAny last();
}
