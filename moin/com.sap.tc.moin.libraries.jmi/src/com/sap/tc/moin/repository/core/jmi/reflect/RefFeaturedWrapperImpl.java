package com.sap.tc.moin.repository.core.jmi.reflect;

import java.util.List;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.reflect.InvalidCallException;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefException;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.messages.jmi.impl.JmiBase;
import com.sap.tc.moin.repository.transactions.transactionables.ModeledOperationInvokeTransactionable;

/**
 * The RefFeatured abstract wrapper implementation
 */
public abstract class RefFeaturedWrapperImpl<T> extends RefBaseObjectWrapperImpl<T> implements RefFeatured {

    /**
     * @param actConnection
     * @param refFeatured
     * @param doSynchronized
     */
    public RefFeaturedWrapperImpl( CoreConnection connection, RefFeaturedImpl refFeatured, boolean doSynchronized ) {

        super( connection, refFeatured, doSynchronized );
    }

    private RefFeaturedImpl getCastWrappedObject( ) {

        return (RefFeaturedImpl) getWrappedObject( );
    }

    public Object refGetValue( RefObject feature ) {

        if ( this.synchronize ) {
            this.synchronizationManager.acquireReadLock( );
            try {
                assertConnectionAlive( );
                attachConnectionIfRequired( );
                return this.wrapResult( this.getCastWrappedObject( ).refGetValue( connection, this.unwrapArg( feature ) ) );
            } finally {
                this.synchronizationManager.releaseReadLock( );
            }
        }
        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.wrapResult( this.getCastWrappedObject( ).refGetValue( connection, this.unwrapArg( feature ) ) );
    }

    public Object refGetValue( String featureName ) {

        if ( this.synchronize ) {
            this.synchronizationManager.acquireReadLock( );
            try {
                assertConnectionAlive( );
                attachConnectionIfRequired( );
                return this.wrapResult( this.getCastWrappedObject( ).refGetValue( connection, featureName ) );
            } finally {
                this.synchronizationManager.releaseReadLock( );
            }
        }
        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.wrapResult( this.getCastWrappedObject( ).refGetValue( connection, featureName ) );
    }

    public void refSetValue( RefObject feature, Object value ) {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            this.getCastWrappedObject( ).refSetValue( connection, unwrapArg( feature ), unwrapArg( value ) );
        }
    }

    public void refSetValue( String featureName, Object value ) {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            this.getCastWrappedObject( ).refSetValue( connection, featureName, unwrapArg( value ) );
        }
    }

    public Object refInvokeOperation( RefObject requestedOperation, List<? extends Object> args ) throws RefException {

        if ( requestedOperation instanceof ModelElement ) {
            return refInvokeOperation( ( (ModelElement) requestedOperation ).getName( ), args );
        }
        return null;
    }

    public Object refInvokeOperation( String requestedOperation, List<? extends Object> args ) throws RefException {

        return refInvokeOperation( connection, requestedOperation, args );
    }

    public Object refInvokeOperation( CoreConnection connection, String requestedOperation, List<? extends Object> args ) throws RefException {

        // meaningful implementation in subclasses
        if ( requestedOperation == null ) {
            throw new com.sap.tc.moin.repository.mmi.reflect.InvalidNameException( requestedOperation, JmiBase.CANNOTINVOKEOPERATIONNULL );
        }
        throw new com.sap.tc.moin.repository.mmi.reflect.InvalidNameException( requestedOperation, JmiBase.UNKNOWNOPERATION );
    }

    protected final Object ___invokeOperation( CoreConnection connection, int operationId, String operationMofId, List<? extends Object> args ) throws RefException {

        assertConnectionAlive( );
        Operation operation = (Operation) getCastWrappedObject( ).get___MetamodelElementByMofId( connection, operationMofId );
        ModeledOperationInvokeTransactionable moitx = getCastWrappedObject( ).get___TransactionableFactory( ).createModeledOperationInvokeTransactionable( connection, true, this, operation, operationId, args );
        try {
            if ( !operation.isQuery( ) ) {
                // changing operations run in transactions
                synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
                    connection.getSession( ).getTransactionManager( ).runInTransaction( moitx );
                }
            } else {
                moitx.runInTransaction( );
            }
        } catch ( JmiException jmiException ) {
            Throwable cause = jmiException.getCause( );
            if ( cause != null && cause instanceof RefException ) {
                throw (RefException) cause;
            }
            throw jmiException;
        }
        return moitx.getReturnValue( );
    }

    public Object invoke___Operation( CoreConnection connection, int operationNumber, List<? extends Object> args ) throws RefException {

        // meaningful implementation in subclasses
        throw new InvalidCallException( operationNumber, refMetaObject( ), JmiReflectMessages.OPERATIONWITHIDNOTINCLASS, ( (com.sap.tc.moin.repository.mmi.model.MofClass) refMetaObject( ) ).getName( ), operationNumber );
    }
}
