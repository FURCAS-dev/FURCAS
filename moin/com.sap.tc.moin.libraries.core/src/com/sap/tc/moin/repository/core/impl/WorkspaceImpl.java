package com.sap.tc.moin.repository.core.impl;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreInstanceManager;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionFactory;
import com.sap.tc.moin.repository.core.CorePartitionManager;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.JmiInstantiator;
import com.sap.tc.moin.repository.core.MemoryLinkManager;
import com.sap.tc.moin.repository.core.MriReference;
import com.sap.tc.moin.repository.core.PriReference;
import com.sap.tc.moin.repository.core.QueryLinkManager;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.core.links.MemoryLinkManagerImpl;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;
import com.sap.tc.moin.repository.messages.core.RepositoryCoreMessages;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.shared.util.HousekeepingThread.ActionOnBeingGarbageCollectedProvider;
import com.sap.tc.moin.repository.spi.core.SpiLinkManager;
import com.sap.tc.moin.repository.spi.facility.SpiPartitionDelta;

public abstract class WorkspaceImpl implements Workspace {

    // ------------------------ attributes --------------------

    private WorkspaceSet workspaceSet;

    protected MemoryLinkManager memoryLinkManager;

    /**
     * The {@link JmiInstantiator} instance used for creating instances of JMI
     * entities like MofClass, MofPackage, Association, etc.
     */
    private JmiInstantiator jmiInstantiator;

    private CorePartitionManager partitionManager;

    private CorePartitionFactory partitionFactory;

    protected CoreInstanceManager instanceManager;

    private boolean alive;

    Map<MRI, WeakMriReference> mriReferences;

    Map<PRI, WeakPriReference> priReferences;

    public WorkspaceImpl( WorkspaceSet workspaceSet ) {

        this.workspaceSet = workspaceSet;
        this.alive = true;
        this.partitionManager = new PartitionManagerImpl( this );
        this.partitionFactory = new PartitionFactoryImpl( this );
        initInstanceManager( );
        this.priReferences = new HashMap<PRI, WeakPriReference>( 128 );
        initMriReferenceMap( );
    }

    @SuppressWarnings( "unchecked" )
    protected final ReferenceQueue getReferenceQueue( ) {

        return this.workspaceSet.getMoin( ).getReferenceQueue( );
    }

    /**
     * Can be overwritten by more specific implementation classes which bring
     * their own instance manager.
     */
    protected void initInstanceManager( ) {

        this.instanceManager = new InstanceManagerImpl( this );
    }

    /**
     * Can be overwritten by more specific implementation classes.
     */
    protected void initMriReferenceMap( ) {

        this.mriReferences = new HashMap<MRI, WeakMriReference>( 2048 );
    }

    public QueryLinkManager getQueryLinkManager( ) {

        // default implementation, is supposed to be overriden in subclasses
        throw new MoinUnsupportedOperationException( CoreImplMessages.INSTANCEDOESNOTSUPPORTQUERYLINKMANAGER );
    }

    public CoreInstanceManager getInstanceManager( ) {

        return instanceManager;
    }

    public MemoryLinkManager getMemoryLinkManager( ) {

        if ( this.memoryLinkManager == null ) {
            this.memoryLinkManager = new MemoryLinkManagerImpl( this );
        }
        return this.memoryLinkManager;
    }

    public CorePartitionManager getPartitionManager( ) {

        return this.partitionManager;
    }

    public CorePartitionFactory getPartitionFactory( ) {

        return this.partitionFactory;
    }

    public SpiLinkManager getLinkManager( ) {

        return getMemoryLinkManager( );
    }

    public WorkspaceSet getWorkspaceSet( ) {

        return workspaceSet;
    }

    public void partitionChanged( PRI pri, SpiPartitionDelta delta ) {

        if ( pri == null ) {
            throw new MoinIllegalArgumentException( RepositoryCoreMessages.MANDATORY_PARAMETER_MISSING, "PRI" ); //$NON-NLS-1$
        }
        // main implementation is in subclass
    }

    public CorePartitionable resolveElementMri( CoreSession session, final MRI mri ) {

        // resolve the corresponding partition first
        CoreModelPartition partition = this.partitionManager.getPartition( session, mri.getPri( ), true );
        if ( partition == null ) {
            return null;
        }
        return this.getInstanceManager( ).getInstance( mri );
    }

    public boolean isMetamodelWorkspace( ) {

        // is overwritten in subclass
        return false;
    }

    public String createMofId( CoreModelPartition forPartition ) {

        return Utilities.getUtilities( ).createSegmentedMofId( forPartition.getPrefixForSegmentedMofIds( ) );
    }

    /** @return Returns the workspaces's {@link JmiInstantiator}. */
    public JmiInstantiator getJmiInstantiator( ) {

        if ( jmiInstantiator == null ) {
            jmiInstantiator = new JmiInstantiatorImpl( this );
        }
        return jmiInstantiator;
    }


    public CoreSession getSession( ) {

        // meaningful implementation is in subclass
        return null;
    }

    public void destroy( ) {

        this.jmiInstantiator = null;
        this.partitionManager.destroy( );
        this.partitionManager = null;
        this.instanceManager = null;
        this.memoryLinkManager = null;
        // The following four maps must not be nulled, because other threads might still access them (e.g. the HousekeepingThread).
        // We set them to the EMPTY_MAP instead to free the memory.
        this.mriReferences = Collections.emptyMap( );
        this.priReferences = Collections.emptyMap( );
        this.alive = false;
    }

    public boolean isAlive( ) {

        return alive;
    }

    @Override
    public String toString( ) {

        StringBuilder sb = new StringBuilder( "{" ); //$NON-NLS-1$
        toStringInternal( sb );
        sb.append( "}" ); //$NON-NLS-1$
        return sb.toString( );
    }

    /**
     * Extracted, to allow subclasses to extend the String.
     * 
     * @param sb
     */
    protected void toStringInternal( StringBuilder sb ) {

        sb.append( "MetamodelWorkspace = " ); //$NON-NLS-1$
        sb.append( this.isMetamodelWorkspace( ) );
        sb.append( ", shared = " ); //$NON-NLS-1$
        sb.append( this.isShared( ) );
        sb.append( ", alive = " ); //$NON-NLS-1$
        sb.append( this.isAlive( ) );
    }

    public void elementRelocated( CoreConnection connection, CoreModelPartition newPartition, MRI oldMri ) {

        synchronized ( mriReferences ) {
            if ( mriReferences != Collections.EMPTY_MAP ) { // otherwise destroy() has already run
                WeakMriReference weakRef = mriReferences.get( oldMri );
                if ( weakRef != null ) {
                    weakRef.elementRelocated( newPartition );
                    mriReferences.remove( oldMri );
                    mriReferences.put( weakRef.mri, weakRef );
                }
            }
        }
    }

    public final PriReference getPriReference( PRI pri ) {

        return getOrCreatePriReference( null, pri );
    }

    public final PriReference getPriReference( CoreModelPartition partition ) {

        return getOrCreatePriReference( partition, null );
    }

    private final PriReference getOrCreatePriReference( CoreModelPartition partition, PRI pri ) {

        pri = partition != null ? partition.getPri( ) : pri;
        PriReference result = null;
        synchronized ( priReferences ) {
            if ( priReferences != Collections.EMPTY_MAP ) { // otherwise destroy() has already run
                WeakPriReference weakRef = priReferences.get( pri );
                if ( weakRef == null || ( result = weakRef.get( ) ) == null ) {
                    if ( partition == null ) {
                        result = new PriReferenceImpl( pri, this.getWorkspaceSet( ) );
                    } else {
                        result = new PriReferenceImpl( partition, this.getWorkspaceSet( ) );
                    }
                    priReferences.put( pri, new WeakPriReference( result, this.getReferenceQueue( ) ) );
                }
            }
        }
        return result;
    }


    public final void uncachePriReference( ModelPartition partition ) {

        synchronized ( priReferences ) {
            if ( priReferences != Collections.EMPTY_MAP ) { // otherwise destroy() has already run
                WeakPriReference weakRef = priReferences.get( partition.getPri( ) );
                if ( weakRef != null ) {
                    PriReference priRef = weakRef.get( );
                    if ( priRef != null && priRef.isCached( ) && priRef.getIfResolved( ) == partition ) {
                        priRef.uncache( );
                    }
                }
            }
        }
    }

    public MriReference getMriReference( CorePartitionable partitionable, MRI mri ) {

        MriReference result = null;
        synchronized ( mriReferences ) {
            if ( mriReferences != Collections.EMPTY_MAP ) { // otherwise destroy() has already run
                WeakMriReference weakRef = mriReferences.get( mri );
                result = weakRef != null ? weakRef.get( ) : null;
                if ( result == null ) {
                    result = new MriReferenceImpl( partitionable, mri, true /* cacheable */, this.getWorkspaceSet( ).getMoin( ) );
                    mriReferences.put( mri, new WeakMriReference( result, this.getReferenceQueue( ) ) );
                }
            }
        }
        return result;
    }

    public Collection<MriReference> getHostedMriReferences( ) {

        Collection<MriReference> result = new ArrayList<MriReference>( );
        synchronized ( mriReferences ) {
            if ( mriReferences != Collections.EMPTY_MAP ) { // otherwise destroy() has already run
                for ( WeakMriReference weakRef : mriReferences.values( ) ) {
                    if ( weakRef != null ) {
                        MriReference mriRef = weakRef.get( );
                        if ( mriRef != null ) {
                            result.add( mriRef );
                        }
                    }
                }
            }
        }
        return result;
    }

    public void uncacheMriReference( MRI mri ) {

        synchronized ( mriReferences ) {
            if ( mriReferences != Collections.EMPTY_MAP ) { // otherwise destroy() has already run
                WeakMriReference weakRef = mriReferences.get( mri );
                if ( weakRef != null ) {
                    MriReference mriRef = weakRef.get( );
                    if ( mriRef != null ) {
                        mriRef.uncache( );
                    }
                }
            }
        }
    }

    @SuppressWarnings( "unchecked" )
    private final class WeakPriReference extends WeakReference<PriReference> implements ActionOnBeingGarbageCollectedProvider {

        private final PRI pri;

        public WeakPriReference( PriReference referent, ReferenceQueue refQueue ) {

            super( referent, refQueue );
            this.pri = referent.getPri( );
        }

        public void actionOnBeingGarbageCollected( Reference referenceToObjectWhichHasBeenGarbageCollected ) {

            synchronized ( priReferences ) {
                if ( priReferences != Collections.EMPTY_MAP ) { // otherwise destroy() has already run
                    WeakPriReference weakPri = priReferences.get( pri );
                    if ( weakPri != null ) {
                        if ( weakPri.get( ) == null ) {
                            // to make sure that not another weak pri reference
                            // was requested in time span between
                            // garbage collection and this call, we have to
                            // check that the referent is really null. Only
                            // if there is no more referent the weak reference
                            // can be removed from the map.
                            priReferences.remove( pri );
                        }
                    }
                }
            }
        }
    }

    @SuppressWarnings( "unchecked" )
    private final class WeakMriReference extends WeakReference<MriReference> implements ActionOnBeingGarbageCollectedProvider {

        MRI mri;

        public WeakMriReference( MriReference referent, ReferenceQueue refQueue ) {

            super( referent, refQueue );
            this.mri = referent.getMri( );
        }

        public void actionOnBeingGarbageCollected( Reference referenceToObjectWhichHasBeenGarbageCollected ) {

            synchronized ( mriReferences ) {
                if ( mriReferences != Collections.EMPTY_MAP ) { // otherwise destroy() has already run
                    WeakMriReference weakMri = mriReferences.get( mri );
                    if ( weakMri != null ) {
                        if ( weakMri.get( ) == null ) {
                            // to make sure that not another weak mri reference
                            // was requested in time span between
                            // garbage collection and this call, we have to
                            // check that the referent is really null. Only
                            // if there is no more referent the weak reference
                            // can be removed from the map.
                            mriReferences.remove( mri );
                        }
                    }
                }
            }
        }

        public void elementRelocated( CoreModelPartition newPartition ) {

            if ( !mri.getPri( ).equals( newPartition.getPri( ) ) ) {
                mri = newPartition.getPri( ).createMri( mri.getMofId( ) );
                MriReference mriReference = this.get( );
                if ( mriReference != null ) {
                    mriReference.elementRelocated( newPartition );
                }
            }
        }
    }
}
