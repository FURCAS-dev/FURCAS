package org.oslo.ocl20.standard.lib;

public interface OclAny {
	OclBoolean equalTo(OclAny object2);
	OclBoolean notEqualTo(OclAny object2);
    //public OclBoolean oclIsNew();
    OclBoolean oclIsUndefined();
    OclAny oclAsType(OclType type);
    OclBoolean oclIsTypeOf(OclType type);
    OclBoolean oclIsKindOf(OclType type);
    //public OclBoolean oclIsInState(Object type);
    //OclSet allInstances();
    
	OclType oclType();
	
    Object clone();
    
	Object asJavaObject();

}
