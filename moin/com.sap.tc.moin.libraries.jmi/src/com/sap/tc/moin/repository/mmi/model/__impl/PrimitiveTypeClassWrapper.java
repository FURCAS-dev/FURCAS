/**
 * Generated by the MOIN JMI Generator Version 3.0
 **/

package com.sap.tc.moin.repository.mmi.model.__impl;

public final class PrimitiveTypeClassWrapper extends com.sap.tc.moin.repository.core.jmi.reflect.RefClassWrapperImpl<com.sap.tc.moin.repository.mmi.model.__impl.PrimitiveTypeClassImpl> implements com.sap.tc.moin.repository.mmi.model.PrimitiveTypeClass,com.sap.tc.moin.repository.Partitionable {

    
    static {
    }

    public PrimitiveTypeClassWrapper(com.sap.tc.moin.repository.core.CoreConnection conn, com.sap.tc.moin.repository.mmi.model.__impl.PrimitiveTypeClassImpl baseObject, boolean synchronize) {
        super(conn, baseObject, synchronize);
    }
    
    private com.sap.tc.moin.repository.mmi.model.__impl.PrimitiveTypeClassImpl getCastWrappedObject() {
        return (com.sap.tc.moin.repository.mmi.model.__impl.PrimitiveTypeClassImpl) getWrappedObject();
    }
    
    public com.sap.tc.moin.repository.mmi.model.__impl.PrimitiveTypeClassImpl unwrap() {
        return (com.sap.tc.moin.repository.mmi.model.__impl.PrimitiveTypeClassImpl) getWrappedObject();
    }
    
    public com.sap.tc.moin.repository.mmi.model.PrimitiveType createPrimitiveType() throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        try {
            if (synchronize) {
                synchronized (synchronizationManager.getProhibitWriteSyncObject()) {
                    assertConnectionAlive();
                    attachConnectionIfRequired();
                    return  wrapResult(getCastWrappedObject().createPrimitiveType(connection));
                }       
            }
            assertConnectionAlive();
            attachConnectionIfRequired();
            return  wrapResult(getCastWrappedObject().createPrimitiveType(connection)); 
        } catch (com.sap.tc.moin.repository.mmi.reflect.JmiException ex) {
            wrapJmiExceptionArgs(ex);
            throw ex;
        }
    }
    public com.sap.tc.moin.repository.mmi.model.PrimitiveType createPrimitiveTypeInPartition(com.sap.tc.moin.repository.ModelPartition partition) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        try {
            if (synchronize) {
                synchronized (synchronizationManager.getProhibitWriteSyncObject()) {
                    assertConnectionAlive();
                    attachConnectionIfRequired();
                    return  wrapResult(getCastWrappedObject().createPrimitiveTypeInPartition(connection, unwrapArg(partition)));
                }       
            }
            assertConnectionAlive();
            attachConnectionIfRequired();
            return  wrapResult(getCastWrappedObject().createPrimitiveTypeInPartition(connection, unwrapArg(partition))); 
        } catch (com.sap.tc.moin.repository.mmi.reflect.JmiException ex) {
            wrapJmiExceptionArgs(ex);
            throw ex;
        }
    }
    public com.sap.tc.moin.repository.mmi.model.PrimitiveType createPrimitiveType(java.lang.String name, java.lang.String annotation, boolean isRoot, boolean isLeaf, boolean isAbstract, com.sap.tc.moin.repository.mmi.model.VisibilityKind visibility) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        try {
            if (synchronize) {
                synchronized (synchronizationManager.getProhibitWriteSyncObject()) {
                    assertConnectionAlive();
                    attachConnectionIfRequired();
                    return  wrapResult(getCastWrappedObject().createPrimitiveType(connection, name, annotation, isRoot, isLeaf, isAbstract, visibility));
                }       
            }
            assertConnectionAlive();
            attachConnectionIfRequired();
            return  wrapResult(getCastWrappedObject().createPrimitiveType(connection, name, annotation, isRoot, isLeaf, isAbstract, visibility)); 
        } catch (com.sap.tc.moin.repository.mmi.reflect.JmiException ex) {
            wrapJmiExceptionArgs(ex);
            throw ex;
        }
    }
    public com.sap.tc.moin.repository.mmi.model.PrimitiveType createPrimitiveTypeInPartition(java.lang.String name, java.lang.String annotation, boolean isRoot, boolean isLeaf, boolean isAbstract, com.sap.tc.moin.repository.mmi.model.VisibilityKind visibility, com.sap.tc.moin.repository.ModelPartition partition) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        try {
            if (synchronize) {
                synchronized (synchronizationManager.getProhibitWriteSyncObject()) {
                    assertConnectionAlive();
                    attachConnectionIfRequired();
                    return  wrapResult(getCastWrappedObject().createPrimitiveTypeInPartition(connection, name, annotation, isRoot, isLeaf, isAbstract, visibility, unwrapArg(partition)));
                }       
            }
            assertConnectionAlive();
            attachConnectionIfRequired();
            return  wrapResult(getCastWrappedObject().createPrimitiveTypeInPartition(connection, name, annotation, isRoot, isLeaf, isAbstract, visibility, unwrapArg(partition))); 
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
    public java.lang.Class<com.sap.tc.moin.repository.mmi.model.PrimitiveTypeClass> get___JmiInterface() {
        return com.sap.tc.moin.repository.mmi.model.PrimitiveTypeClass.class;
    }
    
    // to String
    protected String metaObjectToString() {
        return "com.sap.tc.moin.repository.mmi.model.PrimitiveTypeClass (Java Type)\nModel.PrimitiveType (MOF Type)"; //$NON-NLS-1$
    }    
}