/**
 * Generated by the MOIN Generator Version 3.0
 **/

package com.sap.tc.moin.testcases.case020.__impl;

public final class ChildInheritsMultiple1Impl extends com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl {

    
    static {
    }
    
    // default constructor
    public ChildInheritsMultiple1Impl() {
        super();
    }
    
    // specific constructor
    public ChildInheritsMultiple1Impl(java.lang.Object workspace, String mofId, com.sap.tc.moin.repository.mmi.reflect.RefPackage immediatePackage, com.sap.tc.moin.repository.mmi.reflect.RefObject metaObject, com.sap.tc.moin.repository.mmi.reflect.RefClass refClass) {
        super(workspace, mofId, immediatePackage, metaObject, refClass);
    }
    
    // methods for internal attribute setter

    // reflective methods
        
    


    // get the JMI interface
    public java.lang.Class<com.sap.tc.moin.testcases.case020.ChildInheritsMultiple1> get___JmiInterface() {
        return com.sap.tc.moin.testcases.case020.ChildInheritsMultiple1.class;
    }

    // create the wrapper
    @Override
    public com.sap.tc.moin.repository.spi.core.Wrapper<com.sap.tc.moin.testcases.case020.__impl.ChildInheritsMultiple1Impl> createWrapper(com.sap.tc.moin.repository.core.CoreConnection conn, boolean synchronize) {
        return new com.sap.tc.moin.testcases.case020.__impl.ChildInheritsMultiple1Wrapper(conn, this, synchronize);
    }
    
}