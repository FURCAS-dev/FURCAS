/**
 * Generated by the MOIN JMI Generator Version 3.0
 **/

package org.omg.ocl.types.__impl;

public final class OclModelElementTypeClassWrapper extends com.sap.tc.moin.repository.core.jmi.reflect.RefClassWrapperImpl<org.omg.ocl.types.__impl.OclModelElementTypeClassImpl> implements org.omg.ocl.types.OclModelElementTypeClass,com.sap.tc.moin.repository.Partitionable {

    
    static {
    }

    public OclModelElementTypeClassWrapper(com.sap.tc.moin.repository.core.CoreConnection conn, org.omg.ocl.types.__impl.OclModelElementTypeClassImpl baseObject, boolean synchronize) {
        super(conn, baseObject, synchronize);
    }
    
    private org.omg.ocl.types.__impl.OclModelElementTypeClassImpl getCastWrappedObject() {
        return (org.omg.ocl.types.__impl.OclModelElementTypeClassImpl) getWrappedObject();
    }
    
    public org.omg.ocl.types.__impl.OclModelElementTypeClassImpl unwrap() {
        return (org.omg.ocl.types.__impl.OclModelElementTypeClassImpl) getWrappedObject();
    }
    
    public org.omg.ocl.types.OclModelElementType createOclModelElementType() throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        try {
            if (synchronize) {
                synchronized (synchronizationManager.getProhibitWriteSyncObject()) {
                    assertConnectionAlive();
                    attachConnectionIfRequired();
                    return  wrapResult(getCastWrappedObject().createOclModelElementType(connection));
                }       
            }
            assertConnectionAlive();
            attachConnectionIfRequired();
            return  wrapResult(getCastWrappedObject().createOclModelElementType(connection)); 
        } catch (com.sap.tc.moin.repository.mmi.reflect.JmiException ex) {
            wrapJmiExceptionArgs(ex);
            throw ex;
        }
    }
    public org.omg.ocl.types.OclModelElementType createOclModelElementTypeInPartition(com.sap.tc.moin.repository.ModelPartition partition) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        try {
            if (synchronize) {
                synchronized (synchronizationManager.getProhibitWriteSyncObject()) {
                    assertConnectionAlive();
                    attachConnectionIfRequired();
                    return  wrapResult(getCastWrappedObject().createOclModelElementTypeInPartition(connection, unwrapArg(partition)));
                }       
            }
            assertConnectionAlive();
            attachConnectionIfRequired();
            return  wrapResult(getCastWrappedObject().createOclModelElementTypeInPartition(connection, unwrapArg(partition))); 
        } catch (com.sap.tc.moin.repository.mmi.reflect.JmiException ex) {
            wrapJmiExceptionArgs(ex);
            throw ex;
        }
    }
    public org.omg.ocl.types.OclModelElementType createOclModelElementType(java.lang.String name, java.lang.String annotation, boolean isRoot, boolean isLeaf, boolean isAbstract, com.sap.tc.moin.repository.mmi.model.VisibilityKind visibility) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        try {
            if (synchronize) {
                synchronized (synchronizationManager.getProhibitWriteSyncObject()) {
                    assertConnectionAlive();
                    attachConnectionIfRequired();
                    return  wrapResult(getCastWrappedObject().createOclModelElementType(connection, name, annotation, isRoot, isLeaf, isAbstract, visibility));
                }       
            }
            assertConnectionAlive();
            attachConnectionIfRequired();
            return  wrapResult(getCastWrappedObject().createOclModelElementType(connection, name, annotation, isRoot, isLeaf, isAbstract, visibility)); 
        } catch (com.sap.tc.moin.repository.mmi.reflect.JmiException ex) {
            wrapJmiExceptionArgs(ex);
            throw ex;
        }
    }
    public org.omg.ocl.types.OclModelElementType createOclModelElementTypeInPartition(java.lang.String name, java.lang.String annotation, boolean isRoot, boolean isLeaf, boolean isAbstract, com.sap.tc.moin.repository.mmi.model.VisibilityKind visibility, com.sap.tc.moin.repository.ModelPartition partition) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        try {
            if (synchronize) {
                synchronized (synchronizationManager.getProhibitWriteSyncObject()) {
                    assertConnectionAlive();
                    attachConnectionIfRequired();
                    return  wrapResult(getCastWrappedObject().createOclModelElementTypeInPartition(connection, name, annotation, isRoot, isLeaf, isAbstract, visibility, unwrapArg(partition)));
                }       
            }
            assertConnectionAlive();
            attachConnectionIfRequired();
            return  wrapResult(getCastWrappedObject().createOclModelElementTypeInPartition(connection, name, annotation, isRoot, isLeaf, isAbstract, visibility, unwrapArg(partition))); 
        } catch (com.sap.tc.moin.repository.mmi.reflect.JmiException ex) {
            wrapJmiExceptionArgs(ex);
            throw ex;
        }
    }    

    // methods for static attributes
    

    // methods for modeled static operations

    // methods for structure type creators

    
    // methods for internal modeled operations

    // reflective methods
    

    // get the JMI interface
    public java.lang.Class<org.omg.ocl.types.OclModelElementTypeClass> get___JmiInterface() {
        return org.omg.ocl.types.OclModelElementTypeClass.class;
    }
    
    // to String
    protected String metaObjectToString() {
        return "org.omg.ocl.types.OclModelElementTypeClass (Java Type)\nOCL.Types.OclModelElementType (MOF Type)"; //$NON-NLS-1$
    }    
}