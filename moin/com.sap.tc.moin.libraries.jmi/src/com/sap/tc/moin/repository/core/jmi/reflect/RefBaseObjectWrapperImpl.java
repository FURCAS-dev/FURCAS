package com.sap.tc.moin.repository.core.jmi.reflect;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.InvalidObjectException;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.AbstractConnectionAwareWrapper;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.JmiCoreMessages;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.MriReference;
import com.sap.tc.moin.repository.core.UnresolvableException;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.core.WrapperManager;
import com.sap.tc.moin.repository.messages.jmi.impl.JmiBase;
import com.sap.tc.moin.repository.spi.core.Wrapper;

/**
 * The abstract wrapper implementation for RefBaseObject
 * 
 * @param <T> the type
 */
public abstract class RefBaseObjectWrapperImpl<T> extends AbstractConnectionAwareWrapper<T> implements RefBaseObject, Partitionable {

    // well, this must be updated in case the wrapped object was repartitioned
    protected MriReference mriReference;

    // no getter, just protected for use in the subclasses
    protected final boolean synchronize;

    // used to wrap the results of operations
    protected final WrapperManager wrapperManager;

    /**
     * Constructs the wrapper
     * 
     * @param connection
     * @param refObject
     * @param doSynchronize
     */
    public RefBaseObjectWrapperImpl( CoreConnection connection, RefBaseObjectImpl refObject, boolean doSynchronize ) {

        super( connection, connection.getSession( ).getWorkspaceSet( ).getSynchronizationManager( ) );
        WorkspaceSet workspaceSet = connection.getSession( ).getWorkspaceSet( );
        this.wrapperManager = workspaceSet.getWrapperManager( );
        this.synchronize = doSynchronize;
        this.mriReference = workspaceSet.getReferenceManager( ).getMriReference( refObject, refObject.get___Workspace( ) );
    }

    protected final RefBaseObjectImpl getWrappedObject( ) {

        RefBaseObjectImpl result = this.getWrappedObjectWithoutException( );
        if ( result == null ) {
            throw new InvalidObjectException( null, JmiBase.ELEMENTDELETED, this.mriReference.getMri( ).toString( ), this.connection.toString( ) );
        } else if ( result.get___Workspace( ) == null ) {
            if ( this.mriReference.isCached( ) ) {
                throw new InvalidObjectException( null, JmiBase.ELEMENTDELETEDBUTFOUNDCACHED, this.mriReference.getMri( ).toString( ), this.connection.toString( ) );
            }
            throw new InvalidObjectException( null, JmiBase.ELEMENTDELETEDBUTFOUNDNOTCACHED, this.mriReference.getMri( ).toString( ), this.connection.toString( ) );

        }



        return result;
    }

    private RefBaseObjectImpl getWrappedObjectWithoutException( ) {

        RefBaseObjectImpl result = (RefBaseObjectImpl) this.mriReference.getWithoutException( this.connection.getSession( ) );
        if ( result == null ) {
            LRI lri = this.mriReference.getLri( );
            result = (RefBaseObjectImpl) this.connection.getElement( lri );
            if ( result != null ) {
                if ( !( (CorePartitionable) result ).get___Mri( ).equals( this.mriReference.getMri( ) ) ) {
                    // We found the model element in a different partition. Ask the ReferenceManager for an up-to-date MriReference and update
                    // the 'mriReference' field.
                    this.mriReference = this.connection.getSession( ).getWorkspaceSet( ).getReferenceManager( ).getMriReference( result, result.get___Workspace( ) );
                } else {
                    // We searched the element by its LRI, and got an element with the same MRI as in the current mriReference!
                    // This can only occur if the element has been deleted in the SessionWorkspace, but still exists in the 
                    // CompoundClientSpecWorkspace. We must not return the element from the CompoundClientSpecWorkspace, but have
                    // to return 'null' to correctly reflect the deletion.
                    result = null;
                }
            }
        }
        return result;
    }

    public RefPackage refImmediatePackage( ) {

        if ( this.synchronize ) {
            this.synchronizationManager.acquireReadLock( );
            try {
                this.assertConnectionAlive( );
                this.attachConnectionIfRequired( );
                return this.wrapResult( this.getWrappedObject( ).refImmediatePackage( ) );
            } finally {
                this.synchronizationManager.releaseReadLock( );
            }
        }
        this.assertConnectionAlive( );
        this.attachConnectionIfRequired( );
        return this.wrapResult( this.getWrappedObject( ).refImmediatePackage( ) );
    }

    public RefObject refMetaObject( ) {

        if ( this.synchronize ) {
            this.synchronizationManager.acquireReadLock( );
            try {
                this.assertConnectionAlive( );
                this.attachConnectionIfRequired( );
                return this.wrapResult( this.getWrappedObject( ).refMetaObject( ) );
            } finally {
                this.synchronizationManager.releaseReadLock( );
            }
        }
        this.assertConnectionAlive( );
        this.attachConnectionIfRequired( );
        return this.wrapResult( this.getWrappedObject( ).refMetaObject( ) );
    }

    public String refMofId( ) {

        if ( this.synchronize ) {
            this.synchronizationManager.acquireReadLock( );
            try {
                this.assertConnectionAlive( );
                this.attachConnectionIfRequired( );
                return this.getWrappedObject( ).refMofId( );
            } finally {
                this.synchronizationManager.releaseReadLock( );
            }
        }
        this.assertConnectionAlive( );
        this.attachConnectionIfRequired( );
        return this.getWrappedObject( ).refMofId( );
    }

    public RefPackage refOutermostPackage( ) {

        if ( this.synchronize ) {
            this.synchronizationManager.acquireReadLock( );
            try {
                this.assertConnectionAlive( );
                this.attachConnectionIfRequired( );
                return this.wrapResult( this.getWrappedObject( ).refOutermostPackage( ) );
            } finally {
                this.synchronizationManager.releaseReadLock( );
            }
        }
        this.assertConnectionAlive( );
        this.attachConnectionIfRequired( );
        return this.wrapResult( this.getWrappedObject( ).refOutermostPackage( ) );
    }

    public Collection<JmiException> refVerifyConstraints( boolean deepVerify ) {

        if ( this.synchronize ) {
            synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
                this.assertConnectionAlive( );
                this.attachConnectionIfRequired( );
                Collection<JmiException> result = this.wrapResult( this.getWrappedObject( ).refVerifyConstraints( this.connection, deepVerify ) );
                return result;
            }
        }
        this.assertConnectionAlive( );
        this.attachConnectionIfRequired( );
        Collection<JmiException> result = this.wrapResult( this.getWrappedObject( ).refVerifyConstraints( this.connection, deepVerify ) );
        if ( result.isEmpty( ) ) {
            return null;
        }
        return result;
    }

    @Override
    public boolean equals( Object other ) {

        assert !( other instanceof RefBaseObject && !( other instanceof Wrapper ) ) : JmiReflectMessages.COMPAREWRAPPERWITHCORE.format( );
        if ( this == other ) {
            return true;
        }

        // No synchronization or "CurrentConnection" required, because only the MRI/LRI is used here
        if ( other instanceof RefBaseObjectWrapperImpl ) {
            return this.get___Mri( ).getLri( ).equals( ( (RefBaseObjectWrapperImpl) other ).get___Mri( ).getLri( ) );
        }

        return false;
    }

    @Override
    public final int hashCode( ) {

        return this.mriReference.getMofId( ).hashCode( );
    }

    @SuppressWarnings( "unchecked" )
    protected final <TYPE> TYPE wrapResult( TYPE result ) {

        return (TYPE) this.wrapperManager.wrapObject( this.connection, result );
    }

    @SuppressWarnings( "unchecked" )
    protected final Collection<RefObject> wrapJmiList( JmiList jmiList ) {

        return (Collection<RefObject>) this.wrapperManager.wrapObject( this.connection, jmiList );
    }

    protected void wrapJmiExceptionArgs( JmiException ex ) {

        this.wrapperManager.wrapJmiExceptionAttributes( this.connection, ex );
    }

    protected static final boolean unwrapArg( boolean wrapperOrObject ) {

        return wrapperOrObject;
    }

    public void assign___Partition( ModelPartition mp ) {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            this.assertConnectionAlive( );
            this.attachConnectionIfRequired( );
            this.getWrappedObject( ).assign___Partition( this.connection, this.unwrapArg( mp ) );
        }
    }

    public void assign___PartitionIncludingChildren( ModelPartition mp ) {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            this.assertConnectionAlive( );
            this.attachConnectionIfRequired( );
            this.getWrappedObject( ).assign___PartitionIncludingChildren( this.connection, this.unwrapArg( mp ) );
        }
    }

    public Connection get___Connection( ) {

        return this.connection.getWrapper( );
    }

    public MRI get___Mri( ) {

        CorePartitionable partitionable = this.mriReference.getIfResolved( );
        if ( partitionable != null ) {
            return partitionable.get___Mri( );
        }
        if ( this.synchronize ) {
            this.synchronizationManager.acquireReadLock( );
            try {
                // no connection attaching and alive checks here; we ask the
                // reference
                return this.mriReference.getMri( );
            } finally {
                this.synchronizationManager.releaseReadLock( );
            }
        }
        return this.mriReference.getMri( );
    }

    public ModelPartition get___Partition( ) {

        if ( this.synchronize ) {
            this.synchronizationManager.acquireReadLock( );
            try {
                this.assertConnectionAlive( );
                this.attachConnectionIfRequired( );
                return this.wrapResult( this.getWrappedObject( ).get___Partition( ) );
            } finally {
                this.synchronizationManager.releaseReadLock( );
            }
        }
        this.assertConnectionAlive( );
        this.attachConnectionIfRequired( );
        return this.wrapResult( this.getWrappedObject( ).get___Partition( ) );
    }

    public boolean is___Alive( ) {

        if ( !this.connection.isAlive( ) ) {
            return false;
        }
        CorePartitionable partitionable = this.mriReference.getIfResolved( );
        if ( partitionable != null ) {
            return partitionable.is___Alive( );
        }

        if ( this.synchronize ) {
            this.synchronizationManager.acquireReadLock( );
            try {
                if ( this.connection.isAlive( ) ) {
                    this.attachConnectionIfRequired( );
                    RefBaseObjectImpl rbo = this.getWrappedObjectWithoutException( );
                    if ( rbo != null && rbo.is___Alive( ) ) {
                        return true;
                    }
                }
                return false;
            } finally {
                this.synchronizationManager.releaseReadLock( );
            }
        }
        if ( this.connection.isAlive( ) ) {
            RefBaseObjectImpl rbo = this.getWrappedObjectWithoutException( );
            return ( rbo != null && rbo.is___Alive( ) );
        }
        return false;
    }

    protected String metaObjectToString( ) {

        return ""; //$NON-NLS-1$
    }

    @Override
    public String toString( ) {

        return metaObjectToString( ) + "\n" + this.mriReference.toString( ) + " (MRI)"; //$NON-NLS-1$//$NON-NLS-2$
    }

    @Override
    protected T resolveWrappedElement( CoreConnection connectionForResolving ) {

        MRI mri = this.mriReference.getMri( );
        RefBaseObject result = connectionForResolving.getElement( mri );
        if ( result == null ) {
            throw new UnresolvableException( JmiCoreMessages.MODELELEMENTNOTRESOLVEDFROMSESSION, mri, connectionForResolving.getSession( ) );
        }

        return (T) result;
    }

    public void setMriReference( MriReference mriReference ) {

        this.mriReference = mriReference;
    }

    public MriReference getMriReference( ) {

        return this.mriReference;
    }
}