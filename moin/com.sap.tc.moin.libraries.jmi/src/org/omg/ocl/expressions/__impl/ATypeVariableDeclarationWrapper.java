/**
 * Generated by the MOIN Generator Version 3.0
 **/

package org.omg.ocl.expressions.__impl;

public class ATypeVariableDeclarationWrapper extends com.sap.tc.moin.repository.core.jmi.reflect.RefAssociationWrapperImpl<org.omg.ocl.expressions.ATypeVariableDeclaration> implements org.omg.ocl.expressions.ATypeVariableDeclaration,com.sap.tc.moin.repository.Partitionable
{

    /**
     * The ATypeVariableDeclaration wrapper
     */
    public ATypeVariableDeclarationWrapper(com.sap.tc.moin.repository.core.CoreConnection conn, org.omg.ocl.expressions.__impl.ATypeVariableDeclarationImpl baseObject, boolean synchronize) {
        super(conn, baseObject, synchronize);
    }
    
    private org.omg.ocl.expressions.__impl.ATypeVariableDeclarationImpl getCastWrappedObject() {
        return (org.omg.ocl.expressions.__impl.ATypeVariableDeclarationImpl) getWrappedObject();
    }

    public org.omg.ocl.expressions.ATypeVariableDeclaration unwrap() {
        return (org.omg.ocl.expressions.ATypeVariableDeclaration) getWrappedObject();
    }
    
    public boolean exists(com.sap.tc.moin.repository.mmi.model.Classifier _Type, org.omg.ocl.expressions.VariableDeclaration _VariableDeclaration) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        try {
            if (synchronize) {
                synchronizationManager.acquireReadLock();
                try {
                    assertConnectionAlive();
                    attachConnectionIfRequired();
                    return getCastWrappedObject().exists(connection, unwrapArg(_Type), unwrapArg(_VariableDeclaration));
                } finally {
                    synchronizationManager.releaseReadLock();
                }
       
            }
            assertConnectionAlive();
            attachConnectionIfRequired();
            return getCastWrappedObject().exists(connection, unwrapArg(_Type), unwrapArg(_VariableDeclaration)); 
        } catch (com.sap.tc.moin.repository.mmi.reflect.JmiException ex) {
            wrapJmiExceptionArgs(ex);
            throw ex;
        }
    }
    public com.sap.tc.moin.repository.mmi.model.Classifier getType(org.omg.ocl.expressions.VariableDeclaration _VariableDeclaration) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        try {
            if (synchronize) {
                synchronizationManager.acquireReadLock();
                try {
                    assertConnectionAlive();
                    attachConnectionIfRequired();
                    return  wrapResult(getCastWrappedObject().getType(connection, unwrapArg(_VariableDeclaration)));
                } finally {
                    synchronizationManager.releaseReadLock();
                }
       
            }
            assertConnectionAlive();
            attachConnectionIfRequired();
            return  wrapResult(getCastWrappedObject().getType(connection, unwrapArg(_VariableDeclaration))); 
        } catch (com.sap.tc.moin.repository.mmi.reflect.JmiException ex) {
            wrapJmiExceptionArgs(ex);
            throw ex;
        }
    }
    public java.util.Collection<org.omg.ocl.expressions.VariableDeclaration> getVariableDeclaration(com.sap.tc.moin.repository.mmi.model.Classifier _Type) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        try {
            if (synchronize) {
                synchronizationManager.acquireReadLock();
                try {
                    assertConnectionAlive();
                    attachConnectionIfRequired();
                    return  wrapResult(getCastWrappedObject().getVariableDeclaration(connection, unwrapArg(_Type)));
                } finally {
                    synchronizationManager.releaseReadLock();
                }
       
            }
            assertConnectionAlive();
            attachConnectionIfRequired();
            return  wrapResult(getCastWrappedObject().getVariableDeclaration(connection, unwrapArg(_Type))); 
        } catch (com.sap.tc.moin.repository.mmi.reflect.JmiException ex) {
            wrapJmiExceptionArgs(ex);
            throw ex;
        }
    }
    public boolean add(com.sap.tc.moin.repository.mmi.model.Classifier _Type, org.omg.ocl.expressions.VariableDeclaration _VariableDeclaration) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        try {
            if (synchronize) {
                synchronized (synchronizationManager.getProhibitWriteSyncObject()) {
                    assertConnectionAlive();
                    attachConnectionIfRequired();
                    return getCastWrappedObject().add(connection, unwrapArg(_Type), unwrapArg(_VariableDeclaration));
                }       
            }
            assertConnectionAlive();
            attachConnectionIfRequired();
            return getCastWrappedObject().add(connection, unwrapArg(_Type), unwrapArg(_VariableDeclaration)); 
        } catch (com.sap.tc.moin.repository.mmi.reflect.JmiException ex) {
            wrapJmiExceptionArgs(ex);
            throw ex;
        }
    }
    public boolean remove(com.sap.tc.moin.repository.mmi.model.Classifier _Type, org.omg.ocl.expressions.VariableDeclaration _VariableDeclaration) throws com.sap.tc.moin.repository.mmi.reflect.JmiException
    {
        try {
            if (synchronize) {
                synchronized (synchronizationManager.getProhibitWriteSyncObject()) {
                    assertConnectionAlive();
                    attachConnectionIfRequired();
                    return getCastWrappedObject().remove(connection, unwrapArg(_Type), unwrapArg(_VariableDeclaration));
                }       
            }
            assertConnectionAlive();
            attachConnectionIfRequired();
            return getCastWrappedObject().remove(connection, unwrapArg(_Type), unwrapArg(_VariableDeclaration)); 
        } catch (com.sap.tc.moin.repository.mmi.reflect.JmiException ex) {
            wrapJmiExceptionArgs(ex);
            throw ex;
        }
    }   

    public java.lang.Class<org.omg.ocl.expressions.ATypeVariableDeclaration> get___JmiInterface() {
        return org.omg.ocl.expressions.ATypeVariableDeclaration.class;
    }

    protected String metaObjectToString() {
        return "org.omg.ocl.expressions.ATypeVariableDeclaration (Java Type)\nOCL.Expressions.A_type_variableDeclaration (MOF Type)"; //$NON-NLS-1$
    }    
}