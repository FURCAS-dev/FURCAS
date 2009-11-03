package org.oslo.ocl20.standard.lib;

public interface OclVisitable
{
  public Object accept(OclVisitor v, Object obj);
}
