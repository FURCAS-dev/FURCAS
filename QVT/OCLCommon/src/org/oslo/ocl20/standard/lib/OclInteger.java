package org.oslo.ocl20.standard.lib;

public interface OclInteger
    extends OclReal
{
	OclInteger inegate();
    OclInteger add(OclInteger i2);
    OclInteger subtract(OclInteger i2);
    OclInteger multiply(OclInteger i2);
    OclReal divide(OclInteger i2);
    OclInteger div(OclInteger i2);
    OclReal abs();
    OclInteger mod(OclInteger i2);
    OclInteger max(OclInteger i2);
    OclInteger min(OclInteger i2);
    
}
