package org.oslo.ocl20.standard.lib;

public interface OclTuple
    extends OclAny
{
	OclAny property(OclString s);
	void setProperty(OclString name, Object value);
	
}
