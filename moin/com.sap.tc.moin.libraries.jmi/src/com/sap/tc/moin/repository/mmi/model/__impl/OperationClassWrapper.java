/**
 * Generated by the MOIN JMI Generator Version 3.0
 **/

package com.sap.tc.moin.repository.mmi.model.__impl;

public final class OperationClassWrapper extends com.sap.tc.moin.repository.core.jmi.reflect.RefClassWrapperImpl<com.sap.tc.moin.repository.mmi.model.__impl.OperationClassImpl> implements com.sap.tc.moin.repository.mmi.model.OperationClass,com.sap.tc.moin.repository.Partitionable {

    
    static {
    }

    public OperationClassWrapper(com.sap.tc.moin.repository.core.CoreConnection conn, com.sap.tc.moin.repository.mmi.model.__impl.OperationClassImpl baseObject, boolean synchronize) {
        super(conn, baseObject, synchronize);
    }
    
    private com.sap.tc.moin.repository.mmi.model.__impl.OperationClassImpl getCastWrappedObject() {
        return (com.sap.tc.moin.repository.mmi.model.__impl.OperationClassImpl) getWrappedObject();
    }
    
    public com.sap.tc.moin.repository.mmi.model.__impl.OperationClassImpl unwrap() {
        return (com.sap.tc.moin.repository.mmi.model.__impl.OperationClassImpl) getWrappedObject();
    }
    
    public com.sap.tc.moin.repository.mmi.model.Operation createOperation() throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        try {
            if (synchronize) {
                synchronized (synchronizationManager.getProhibitWriteSyncObject()) {
                    assertConnectionAlive();
                    attachConnectionIfRequired();
                    return  wrapResult(getCastWrappedObject().createOperation(connection));
                }       
            }
            assertConnectionAlive();
            attachConnectionIfRequired();
            return  wrapResult(getCastWrappedObject().createOperation(connection)); 
        } catch (com.sap.tc.moin.repository.mmi.reflect.JmiException ex) {
            wrapJmiExceptionArgs(ex);
            throw ex;
        }
    }
    public com.sap.tc.moin.repository.mmi.model.Operation createOperationInPartition(com.sap.tc.moin.repository.ModelPartition partition) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        try {
            if (synchronize) {
                synchronized (synchronizationManager.getProhibitWriteSyncObject()) {
                    assertConnectionAlive();
                    attachConnectionIfRequired();
                    return  wrapResult(getCastWrappedObject().createOperationInPartition(connection, unwrapArg(partition)));
                }       
            }
            assertConnectionAlive();
            attachConnectionIfRequired();
            return  wrapResult(getCastWrappedObject().createOperationInPartition(connection, unwrapArg(partition))); 
        } catch (com.sap.tc.moin.repository.mmi.reflect.JmiException ex) {
            wrapJmiExceptionArgs(ex);
            throw ex;
        }
    }
    public com.sap.tc.moin.repository.mmi.model.Operation createOperation(java.lang.String name, java.lang.String annotation, com.sap.tc.moin.repository.mmi.model.ScopeKind scope, com.sap.tc.moin.repository.mmi.model.VisibilityKind visibility, boolean isQuery) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        try {
            if (synchronize) {
                synchronized (synchronizationManager.getProhibitWriteSyncObject()) {
                    assertConnectionAlive();
                    attachConnectionIfRequired();
                    return  wrapResult(getCastWrappedObject().createOperation(connection, name, annotation, scope, visibility, isQuery));
                }       
            }
            assertConnectionAlive();
            attachConnectionIfRequired();
            return  wrapResult(getCastWrappedObject().createOperation(connection, name, annotation, scope, visibility, isQuery)); 
        } catch (com.sap.tc.moin.repository.mmi.reflect.JmiException ex) {
            wrapJmiExceptionArgs(ex);
            throw ex;
        }
    }
    public com.sap.tc.moin.repository.mmi.model.Operation createOperationInPartition(java.lang.String name, java.lang.String annotation, com.sap.tc.moin.repository.mmi.model.ScopeKind scope, com.sap.tc.moin.repository.mmi.model.VisibilityKind visibility, boolean isQuery, com.sap.tc.moin.repository.ModelPartition partition) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        try {
            if (synchronize) {
                synchronized (synchronizationManager.getProhibitWriteSyncObject()) {
                    assertConnectionAlive();
                    attachConnectionIfRequired();
                    return  wrapResult(getCastWrappedObject().createOperationInPartition(connection, name, annotation, scope, visibility, isQuery, unwrapArg(partition)));
                }       
            }
            assertConnectionAlive();
            attachConnectionIfRequired();
            return  wrapResult(getCastWrappedObject().createOperationInPartition(connection, name, annotation, scope, visibility, isQuery, unwrapArg(partition))); 
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
    public java.lang.Class<com.sap.tc.moin.repository.mmi.model.OperationClass> get___JmiInterface() {
        return com.sap.tc.moin.repository.mmi.model.OperationClass.class;
    }
    
    // to String
    protected String metaObjectToString() {
        return "com.sap.tc.moin.repository.mmi.model.OperationClass (Java Type)\nModel.Operation (MOF Type)"; //$NON-NLS-1$
    }    
}