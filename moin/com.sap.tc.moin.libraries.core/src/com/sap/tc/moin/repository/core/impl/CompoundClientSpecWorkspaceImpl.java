package com.sap.tc.moin.repository.core.impl;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.cdam.CompoundClientSpec;
import com.sap.tc.moin.repository.core.CompoundClientSpecWorkspace;
import com.sap.tc.moin.repository.core.EvictionThread;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.spi.core.SpiStage;

public final class CompoundClientSpecWorkspaceImpl extends WorkspaceImpl implements CompoundClientSpecWorkspace {

    private Map<DataAreaDescriptor, SpiStage> allClientSpecificStages;

    private final CompoundClientSpec compoundClientSpec;

    private Set<PRI> privateCopies;

    public CompoundClientSpecWorkspaceImpl( WorkspaceSet workspaceSet, CompoundClientSpec compoundClientSpec, Set<SpiStage> allClientSpecificStages ) {

        super( workspaceSet );
        this.compoundClientSpec = compoundClientSpec;
        this.allClientSpecificStages = new HashMap<DataAreaDescriptor, SpiStage>( allClientSpecificStages.size( ) );
        for ( SpiStage stage : allClientSpecificStages ) {
            this.allClientSpecificStages.put( stage.getDataAreaDescriptor( ), stage );
        }
        this.privateCopies = new LinkedHashSet<PRI>( );
        // Register our partition manager for timer-triggered eviction runs.
        workspaceSet.getMoin( ).getEvictionThread( ).register( getPartitionManager( ) );
    }

    public CompoundClientSpec getCompoundClientSpec( ) {

        return this.compoundClientSpec;
    }

    @Override
    public void destroy( ) {

        // Unregistering the MBean has to occur *before* the call to super.destroy(), otherwise the PartitionManager
        // is already nulled!
        EvictionThread evictionThread = getWorkspaceSet( ).getMoin( ).getEvictionThread( );
        if ( evictionThread != null ) {
            evictionThread.unregister( getPartitionManager( ) );
        }
        super.destroy( );
        this.allClientSpecificStages = null;
        this.privateCopies = null;
    }

    @Override
    protected void toStringInternal( StringBuilder sb ) {

        super.toStringInternal( sb );
        sb.append( ", CompoundClientSpecWorkspace = true" ); //$NON-NLS-1$
    }

    public boolean isShared( ) {

        return false;
    }

    public SpiStage getStage( DataAreaDescriptor dataAreaDescriptor ) {

        return allClientSpecificStages.get( dataAreaDescriptor );
    }

    public void privateCopyAdded( PRI pri ) {

        this.privateCopies.add( pri );
    }

    public void privateCopyRemoved( PRI pri ) {

        this.privateCopies.remove( pri );
    }

    public boolean privateCopyExists( PRI pri ) {

        return this.privateCopies.contains( pri );
    }

    public Set<PRI> getPrivateCopies( ) {

        return this.privateCopies;
    }
}