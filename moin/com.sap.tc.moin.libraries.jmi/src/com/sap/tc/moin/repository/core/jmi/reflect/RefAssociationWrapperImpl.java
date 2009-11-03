package com.sap.tc.moin.repository.core.jmi.reflect;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * The abstract wrapper implementation for RefBaseObject
 */
public abstract class RefAssociationWrapperImpl<T> extends RefBaseObjectWrapperImpl<T> implements RefAssociation, Partitionable {

    /**
     * Constructs the wrapper
     * 
     * @param connection
     * @param refObject
     * @param doSynchronize
     */
    public RefAssociationWrapperImpl( CoreConnection connection, RefBaseObjectImpl refObject, boolean doSynchronize ) {

        super( connection, refObject, doSynchronize );
    }

    private RefAssociationImpl getCastWrappedObject( ) {

        return (RefAssociationImpl) getWrappedObject( );
    }

    @Override
    public Association refMetaObject( ) {

        return (Association) super.refMetaObject( );
    }

    public boolean refAddLink( RefObject firstEnd, RefObject secondEnd ) {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.getCastWrappedObject( ).refAddLink( connection, this.unwrapArg( firstEnd ), this.unwrapArg( secondEnd ) );
        }
    }



    public boolean refLinkExists( RefObject firstEnd, RefObject secondEnd ) {

        if ( this.synchronize ) {
            this.synchronizationManager.acquireReadLock( );
            try {
                assertConnectionAlive( );
                attachConnectionIfRequired( );
                return this.getCastWrappedObject( ).refLinkExists( connection, this.unwrapArg( firstEnd ), this.unwrapArg( secondEnd ) );
            } finally {
                this.synchronizationManager.releaseReadLock( );
            }
        }
        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.getCastWrappedObject( ).refLinkExists( connection, this.unwrapArg( firstEnd ), this.unwrapArg( secondEnd ) );
    }

    public Collection<RefObject> refQuery( RefObject queryEnd, RefObject queryObject ) {

        if ( this.synchronize ) {
            this.synchronizationManager.acquireReadLock( );
            try {
                assertConnectionAlive( );
                attachConnectionIfRequired( );
                return this.wrapJmiList( this.getCastWrappedObject( ).refQuery( connection, this.unwrapArg( queryEnd ), this.unwrapArg( queryObject ) ) );
            } finally {
                this.synchronizationManager.releaseReadLock( );
            }
        }
        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.wrapJmiList( this.getCastWrappedObject( ).refQuery( connection, this.unwrapArg( queryEnd ), this.unwrapArg( queryObject ) ) );
    }

    public Collection<RefObject> refQuery( String endName, RefObject queryObject ) {

        if ( this.synchronize ) {
            this.synchronizationManager.acquireReadLock( );
            try {
                assertConnectionAlive( );
                attachConnectionIfRequired( );
                return this.wrapJmiList( this.getCastWrappedObject( ).refQuery( connection, endName, this.unwrapArg( queryObject ) ) );
            } finally {
                this.synchronizationManager.releaseReadLock( );
            }
        }
        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.wrapJmiList( this.getCastWrappedObject( ).refQuery( connection, endName, this.unwrapArg( queryObject ) ) );
    }

    public boolean refRemoveLink( RefObject firstEnd, RefObject secondEnd ) {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.getCastWrappedObject( ).refRemoveLink( connection, this.unwrapArg( firstEnd ), this.unwrapArg( secondEnd ) );
        }
    }

}