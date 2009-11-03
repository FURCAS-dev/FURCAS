package com.sap.tc.moin.repository.core.jmi.reflect;

import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefEnum;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefStruct;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor;
import com.sap.tc.moin.repository.mmi.reflect.RefClassCalculatedMofId;

/**
 * The RefFeatured abstract wrapper implementation
 */
public class RefClassWrapperImpl<T> extends RefFeaturedWrapperImpl<T> implements RefClass, RefClassCalculatedMofId {

    /**
     * @param connection
     * @param refFeatured
     * @param doSynchronized
     */
    public RefClassWrapperImpl( CoreConnection connection, RefClassImpl refFeatured, boolean doSynchronized ) {

        super( connection, refFeatured, doSynchronized );
    }

    private RefClassImpl getCastWrappedObject( ) {

        return (RefClassImpl) getWrappedObject( );
    }

    @Override
    public MofClass refMetaObject( ) {

        return (MofClass) super.refMetaObject( );
    }

    public Collection<RefObject> refAllOfClass( ) {

        if ( this.synchronize ) {
            this.synchronizationManager.acquireReadLock( );
            try {
                assertConnectionAlive( );
                attachConnectionIfRequired( );
                return this.wrapResult( this.getCastWrappedObject( ).refAllOfClass( connection ) );
            } finally {
                this.synchronizationManager.releaseReadLock( );
            }
        }
        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.wrapResult( this.getCastWrappedObject( ).refAllOfClass( connection ) );
    }

    public Collection<RefObject> refAllOfType( ) {

        if ( this.synchronize ) {
            this.synchronizationManager.acquireReadLock( );
            try {
                assertConnectionAlive( );
                attachConnectionIfRequired( );
                return this.wrapResult( this.getCastWrappedObject( ).refAllOfType( connection ) );
            } finally {
                this.synchronizationManager.releaseReadLock( );
            }
        }
        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.wrapResult( this.getCastWrappedObject( ).refAllOfType( connection ) );
    }

    public RefObject refCreateInstance( List<? extends Object> args ) {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.wrapResult( this.getCastWrappedObject( ).refCreateInstance( connection, this.unwrapArg( args ) ) );
        }
    }

    public RefObject refCreateInstance( ) {

        return refCreateInstance( (List) null );
    }

    public RefObject refCreateInstanceInPartition( List<? extends Object> args, ModelPartition partition ) {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.wrapResult( this.getCastWrappedObject( ).refCreateInstanceInPartition( connection, this.unwrapArg( args ), this.unwrapArg( partition ) ) );
        }
    }

    public RefObject refCreateInstanceInPartition( ModelPartition partition ) {

        return refCreateInstanceInPartition( (List) null, partition );
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

    public RefObject refCreateInstance( String[] logicalKey ) {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.wrapResult( this.getCastWrappedObject( ).refCreateInstance( connection, null, logicalKey ) );
        }
    }

    public RefObject refCreateInstanceInPartition( ModelPartition partition, String... logicalKey ) {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.wrapResult( this.getCastWrappedObject( ).refCreateInstanceInPartition( connection, null, logicalKey, this.unwrapArg( partition ) ) );
        }
    }

    public RefObject refCreateInstanceInPartition( ModelPartition partition, ClassDescriptor<?, ?> superClassDescriptor, String... logicalKey ) {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.wrapResult( this.getCastWrappedObject( ).refCreateInstanceInPartition( connection, logicalKey, superClassDescriptor, this.unwrapArg( partition ) ) );
        }
    }

    public RefObject refCreateInstanceInPartition( String locality, String[] logicalKey, ClassDescriptor<?, ?> superClassDescriptor, ModelPartition partition ) {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.wrapResult( this.getCastWrappedObject( ).refCreateInstanceInPartition( connection, logicalKey, superClassDescriptor, this.unwrapArg( partition ) ) );
        }
    }

    public String calculateMofId( String... logicalKey ) {

        return this.getCastWrappedObject( ).calculateMofId( logicalKey );
    }

    public String calculateMofId( ClassDescriptor<?, ?> superClassDescriptor, String... logicalKey ) {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.getCastWrappedObject( ).calculateMofId( connection, logicalKey, superClassDescriptor );
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    public <T extends RefBaseObject> Class<T> get___JmiInterface( ) {

        // TODO Auto-generated method stub
        return null;
    }

    public T unwrap( ) {

        return (T) getWrappedObject( );
    }
}