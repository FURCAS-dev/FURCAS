package org.oslo.ocl20.standard.lib;

public interface OclSequence
    extends OclCollection
{
	OclInteger count(OclAny object);
	OclBoolean equalTo(OclSequence seq2);
	//OclBoolean notEqualTo(OclSequence seq2);
    OclSequence union(OclSequence sequence2);
    OclSequence flatten();
    OclSequence append(OclAny object);
    OclSequence prepend(OclAny object);
    OclSequence insertAt(OclInteger index, OclAny object);
    OclSequence subSequence(OclInteger lower, OclInteger upper);
    Object at(OclInteger i);
    OclInteger indexOf(OclAny object);
    OclAny first();
	OclAny last();
    OclSequence including(OclAny object);
    OclSequence excluding(OclAny object);

}
