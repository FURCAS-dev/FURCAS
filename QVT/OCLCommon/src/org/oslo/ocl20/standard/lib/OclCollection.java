package org.oslo.ocl20.standard.lib;


public interface OclCollection
    extends OclAny, Impl
{
    OclInteger size();
    OclBoolean includes(Object object);
    OclBoolean excludes(Object object);
    OclInteger count(OclAny object);
    OclBoolean includesAll(OclCollection col);
    OclBoolean excludesAll(OclCollection col);
    OclBoolean isEmpty();
    OclBoolean notEmpty();
    Object sum();
    OclSet product(OclCollection c2);
    
    OclBag asBag();
    OclSet asSet();
    OclSequence asSequence();
    OclOrderedSet asOrderedSet();

    Object asJavaObject();
}
