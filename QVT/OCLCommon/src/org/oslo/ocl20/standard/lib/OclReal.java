package org.oslo.ocl20.standard.lib;

public interface OclReal
    extends OclAny
{
    public OclReal add(OclReal r2);
    public OclReal subtract(OclReal r2);
    public OclReal multiply(OclReal r2);
    public OclReal negate();
    public OclReal divide(OclReal r2);
    public OclReal abs();
    public OclInteger floor();
    public OclInteger round();
    public OclReal max(OclReal r2);
    public OclReal min(OclReal r2);
    public OclBoolean lessThan(OclReal r2);
    public OclBoolean greaterThan(OclReal r2);
    public OclBoolean lessThanOrEqualTo(OclReal r2);
    public OclBoolean greaterThanOrEqualTo(OclReal r2);
    //public IOclBoolean lessThan(IOclInteger r2);
    //public IOclBoolean greaterThan(IOclInteger r2);
    //public IOclBoolean lessThanOrEqualTo(IOclInteger r2);
    //public IOclBoolean greaterThanOrEqualTo(IOclInteger r2);
}
