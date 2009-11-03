package org.oslo.ocl20.standard.lib;

public interface OclBoolean
    extends OclAny
{
    public OclBoolean or(OclBoolean b2);
    public OclBoolean xor(OclBoolean b2);
    public OclBoolean and(OclBoolean b2);
    public OclBoolean not();
    public OclBoolean implies(OclBoolean b2);
}
