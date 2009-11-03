package com.sap.tc.moin.repository.core.jmi.reflect;

import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefEnum;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefStruct;

import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * The RefObject abstract wrapper
 */
public abstract class RefPackageWrapperImpl<T> extends RefBaseObjectWrapperImpl<T> implements RefPackage {

    /**
     * @param connection
     * @param refObject
     * @param doSynchronize
     */
    public RefPackageWrapperImpl( CoreConnection connection, RefPackageImpl refObject, boolean doSynchronize ) {

        super( connection, refObject, doSynchronize );
    }

    private RefPackageImpl getCastWrappedObject( ) {

        return (RefPackageImpl) getWrappedObject( );
    }

    @Override
    public MofPackage refMetaObject( ) {

        return (MofPackage) super.refMetaObject( );
    }

    public Collection<RefAssociation> refAllAssociations( ) {

        if ( this.synchronize ) {
            this.synchronizationManager.acquireReadLock( );
            try {
                assertConnectionAlive( );
                attachConnectionIfRequired( );
                return this.wrapResult( this.getCastWrappedObject( ).refAllAssociations( connection ) );
            } finally {
                this.synchronizationManager.releaseReadLock( );
            }
        }
        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.wrapResult( this.getCastWrappedObject( ).refAllAssociations( connection ) );
    }

    public Collection<RefClass> refAllClasses( ) {

        if ( this.synchronize ) {
            this.synchronizationManager.acquireReadLock( );
            try {
                assertConnectionAlive( );
                attachConnectionIfRequired( );
                return this.wrapResult( this.getCastWrappedObject( ).refAllClasses( connection ) );
            } finally {
                this.synchronizationManager.releaseReadLock( );
            }
        }
        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.wrapResult( this.getCastWrappedObject( ).refAllClasses( connection ) );
    }

    public Collection<RefPackage> refAllPackages( ) {

        if ( this.synchronize ) {
            this.synchronizationManager.acquireReadLock( );
            try {
                assertConnectionAlive( );
                attachConnectionIfRequired( );
                return this.wrapResult( this.getCastWrappedObject( ).refAllPackages( connection ) );
            } finally {
                this.synchronizationManager.releaseReadLock( );
            }
        }
        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.wrapResult( this.getCastWrappedObject( ).refAllPackages( connection ) );
    }

    public RefAssociation refAssociation( RefObject association ) {

        if ( this.synchronize ) {
            this.synchronizationManager.acquireReadLock( );
            try {
                assertConnectionAlive( );
                attachConnectionIfRequired( );
                return this.wrapResult( this.getCastWrappedObject( ).refAssociation( connection, this.unwrapArg( association ) ) );
            } finally {
                this.synchronizationManager.releaseReadLock( );
            }
        }
        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.wrapResult( this.getCastWrappedObject( ).refAssociation( connection, this.unwrapArg( association ) ) );
    }

    public RefAssociation refAssociation( String associationName ) {

        if ( this.synchronize ) {
            this.synchronizationManager.acquireReadLock( );
            try {
                assertConnectionAlive( );
                attachConnectionIfRequired( );
                return this.wrapResult( this.getCastWrappedObject( ).refAssociation( connection, associationName ) );
            } finally {
                this.synchronizationManager.releaseReadLock( );
            }
        }
        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.wrapResult( this.getCastWrappedObject( ).refAssociation( connection, associationName ) );
    }

    public RefClass refClass( RefObject type ) {

        if ( this.synchronize ) {
            this.synchronizationManager.acquireReadLock( );
            try {
                assertConnectionAlive( );
                attachConnectionIfRequired( );
                return this.wrapResult( this.getCastWrappedObject( ).refClass( connection, this.unwrapArg( type ) ) );
            } finally {
                this.synchronizationManager.releaseReadLock( );
            }
        }
        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.wrapResult( this.getCastWrappedObject( ).refClass( connection, this.unwrapArg( type ) ) );
    }

    public RefClass refClass( String typeName ) {

        if ( this.synchronize ) {
            this.synchronizationManager.acquireReadLock( );
            try {
                assertConnectionAlive( );
                attachConnectionIfRequired( );
                return this.wrapResult( this.getCastWrappedObject( ).refClass( connection, typeName ) );
            } finally {
                this.synchronizationManager.releaseReadLock( );
            }
        }
        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.wrapResult( this.getCastWrappedObject( ).refClass( connection, typeName ) );
    }

    public RefStruct refCreateStruct( RefObject struct, List<? extends Object> params ) {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.getCastWrappedObject( ).refCreateStruct( connection, this.unwrapArg( struct ), this.unwrapArg( params ) );
        }
    }

    public RefStruct refCreateStruct( String structName, List<? extends Object> params ) {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.getCastWrappedObject( ).refCreateStruct( connection, structName, this.unwrapArg( params ) );
        }
    }

    public void refDelete( ) {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            this.getCastWrappedObject( ).refDelete( );
        }
    }

    public RefEnum refGetEnum( RefObject enumType, String name ) {

        if ( this.synchronize ) {
            this.synchronizationManager.acquireReadLock( );
            try {
                assertConnectionAlive( );
                attachConnectionIfRequired( );
                return this.getCastWrappedObject( ).refGetEnum( connection, this.unwrapArg( enumType ), name );
            } finally {
                this.synchronizationManager.releaseReadLock( );
            }
        }
        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.getCastWrappedObject( ).refGetEnum( connection, this.unwrapArg( enumType ), name );
    }

    public RefEnum refGetEnum( String enumName, String name ) {

        if ( this.synchronize ) {
            this.synchronizationManager.acquireReadLock( );
            try {
                assertConnectionAlive( );
                attachConnectionIfRequired( );
                return this.getCastWrappedObject( ).refGetEnum( connection, enumName, name );
            } finally {
                this.synchronizationManager.releaseReadLock( );
            }
        }
        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.getCastWrappedObject( ).refGetEnum( connection, enumName, name );
    }

    public RefPackage refPackage( RefObject nestedPackage ) {

        if ( this.synchronize ) {
            this.synchronizationManager.acquireReadLock( );
            try {
                assertConnectionAlive( );
                attachConnectionIfRequired( );
                return this.wrapResult( this.getCastWrappedObject( ).refPackage( connection, this.unwrapArg( nestedPackage ) ) );
            } finally {
                this.synchronizationManager.releaseReadLock( );
            }
        }
        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.wrapResult( this.getCastWrappedObject( ).refPackage( connection, this.unwrapArg( nestedPackage ) ) );
    }

    public RefPackage refPackage( String nestedPackageName ) {

        if ( this.synchronize ) {
            this.synchronizationManager.acquireReadLock( );
            try {
                assertConnectionAlive( );
                attachConnectionIfRequired( );
                return this.wrapResult( this.getCastWrappedObject( ).refPackage( connection, nestedPackageName ) );
            } finally {
                this.synchronizationManager.releaseReadLock( );
            }
        }
        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.wrapResult( this.getCastWrappedObject( ).refPackage( connection, nestedPackageName ) );
    }
}