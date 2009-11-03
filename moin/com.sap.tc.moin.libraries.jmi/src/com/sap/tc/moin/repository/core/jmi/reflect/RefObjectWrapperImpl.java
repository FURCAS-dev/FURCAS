package com.sap.tc.moin.repository.core.jmi.reflect;

import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * The RefObject abstract wrapper
 */
public abstract class RefObjectWrapperImpl<T> extends RefFeaturedWrapperImpl<T> implements RefObject {

    /**
     * @param actConnection
     * @param refObject
     * @param doSynchronize
     */
    public RefObjectWrapperImpl( CoreConnection actConnection, RefObjectImpl refObject, boolean doSynchronize ) {

        super( actConnection, refObject, doSynchronize );
    }

    private RefObjectImpl getCastWrappedObject( ) {

        return (RefObjectImpl) getWrappedObject( );
    }

    public RefClass refClass( ) {

        if ( this.synchronize ) {
            this.synchronizationManager.acquireReadLock( );
            try {
                assertConnectionAlive( );
                attachConnectionIfRequired( );
                return wrapResult( this.getCastWrappedObject( ).refClass( ) );
            } finally {
                this.synchronizationManager.releaseReadLock( );
            }
        }
        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return wrapResult( this.getCastWrappedObject( ).refClass( ) );
    }

    public void refDelete( ) {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            this.getCastWrappedObject( ).refDelete( connection );
        }
    }

    public RefFeatured refImmediateComposite( ) {

        if ( this.synchronize ) {
            this.synchronizationManager.acquireReadLock( );
            try {
                assertConnectionAlive( );
                attachConnectionIfRequired( );
                return wrapResult( this.getCastWrappedObject( ).refImmediateComposite( connection.getSession( ) ) );
            } finally {
                this.synchronizationManager.releaseReadLock( );
            }
        }
        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return wrapResult( this.getCastWrappedObject( ).refImmediateComposite( connection.getSession( ) ) );
    }

    public boolean refIsInstanceOf( RefObject objType, boolean considerSubtypes ) {

        if ( this.synchronize ) {
            this.synchronizationManager.acquireReadLock( );
            try {
                assertConnectionAlive( );
                attachConnectionIfRequired( );
                return this.getCastWrappedObject( ).refIsInstanceOf( connection.getSession( ), this.unwrapArg( objType ), considerSubtypes );
            } finally {
                this.synchronizationManager.releaseReadLock( );
            }
        }
        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.getCastWrappedObject( ).refIsInstanceOf( connection.getSession( ), this.unwrapArg( objType ), considerSubtypes );
    }

    public RefFeatured refOutermostComposite( ) {

        if ( this.synchronize ) {
            this.synchronizationManager.acquireReadLock( );
            try {
                assertConnectionAlive( );
                attachConnectionIfRequired( );
                return wrapResult( this.getCastWrappedObject( ).refOutermostComposite( connection.getSession( ) ) );
            } finally {
                this.synchronizationManager.releaseReadLock( );
            }

        }
        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return wrapResult( this.getCastWrappedObject( ).refOutermostComposite( connection.getSession( ) ) );
    }
}