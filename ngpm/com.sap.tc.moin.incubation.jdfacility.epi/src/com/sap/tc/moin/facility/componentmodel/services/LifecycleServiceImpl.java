package com.sap.tc.moin.facility.componentmodel.services;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import com.sap.tc.moin.facility.componentmodel.CMContainer;
import com.sap.tc.moin.facility.componentmodel.CMDataArea;
import com.sap.tc.moin.facility.componentmodel.CMManager;
import com.sap.tc.moin.facility.primary.ipi.IpiDataArea;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.PartitionCreatingNotPossibleException;
import com.sap.tc.moin.repository.PartitionDeletingNotPossibleException;
import com.sap.tc.moin.repository.PartitionEditingNotPossibleException;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;
import com.sap.tc.moin.repository.spi.facility.SpiLifecycleManagement;


public class LifecycleServiceImpl implements SpiLifecycleManagement {

    private CMManager cmManager;

    public void bind( CMManager cmManager ) {

        this.cmManager = cmManager;

    }

    // JD: TODO: check if this cast is <b>always</b> valid. 
    // The current implementation of AbstractClientSpecImpl does it this way.
    private static final IpiDataArea toIpiDataArea( SpiClientSpec clientSpec ) {

        return (IpiDataArea) clientSpec.getDataArea( );
    }

    // Create, edit, delete
    public void ensureCreatingAllowed( PRI pri, SpiClientSpec clientSpec ) throws PartitionCreatingNotPossibleException {

        if ( !isContainerModifiable( pri.getCri( ), clientSpec ) ) {
            throw new PartitionCreatingNotPossibleException( LifecycleMessages.PARTITION_CREATION_NOT_POSSIBLE, pri );
        }
    }

    public void ensureDeletingAllowed( PRI pri, SpiClientSpec clientSpec ) throws PartitionDeletingNotPossibleException {

        if ( !isContainerModifiable( pri.getCri( ), clientSpec ) ) {
            throw new PartitionDeletingNotPossibleException( LifecycleMessages.PARTITION_DELETION_NOT_POSSIBLE, pri );
        }
    }

    public void ensureEditingAllowed( PRI pri, SpiClientSpec clientSpec ) throws PartitionEditingNotPossibleException {

        if ( !isContainerModifiable( pri.getCri( ), clientSpec ) ) {
            throw new PartitionEditingNotPossibleException( LifecycleMessages.PARTITION_EDITING_NOT_POSSIBLE, pri );
        }
    }

    public Collection<PRI> getOuterPartitions( SpiClientSpec clientSpec, CRI cri, List<PartitionOperation> dirtyPartitions ) {

        HashSet<PRI> res = new HashSet<PRI>( );

        CMDataArea def = cmManager.getDataArea( toIpiDataArea( clientSpec ).getDescriptor( ) );
        if ( def != null ) {
            CMContainer container = cmManager.getContainer( cri );
            if ( container != null ) {
                final Collection<CRI> outerContainers = container.getVisibleContainers( );

                for ( CRI childCRI : outerContainers ) {
                    CMContainer child = cmManager.getContainer( childCRI );
                    if ( child != null ) {
                        child.addVisiblePartitions( res );
                    }
                }

                if ( dirtyPartitions != null && !dirtyPartitions.isEmpty( ) ) {
                    for ( PartitionOperation pop : dirtyPartitions ) {
                        switch ( pop.getOperation( ) ) {
                            case CREATE:
                                if ( outerContainers.contains( pop.getPartitionPri( ).getCri( ) ) ) {
                                    res.add( pop.getPartitionPri( ) );
                                }
                                break;
                            case DELETE:
                                if ( outerContainers.contains( pop.getPartitionPri( ).getCri( ) ) ) {
                                    res.remove( pop.getPartitionPri( ) );
                                }
                                break;
                            default:
                                ; // not relevant
                        }
                    }
                }
            }
        }
        return res;
    }

    // JD: TODO: API contract unclear. 
    // 1. Circumstances to return an emptyList or throw an exception.
    // 2. Is the collection mutable or immutable.
    // 
    public Collection<CRI> getVisibleContainers( SpiClientSpec clientSpec, CRI cri ) {

        CMContainer container = cmManager.getContainer( cri );
        if ( container != null ) {
            return container.getVisibleContainers( );
        }
        return Collections.emptyList( );
    }

    public boolean isContainerModifiable( CRI cri, SpiClientSpec clientSpec ) {

        IpiDataArea dataArea = toIpiDataArea( clientSpec );
        if ( !dataArea.isModifiable( ) ) {
            return false;
        }
        return cmManager.isDataArea_and_ContainerModifiable( cri );
    }

    public boolean isLinkBackedByContainerUsage( PRI usingPri, PRI usedPri, SpiClientSpec clientSpecOfUsingPri, SpiClientSpec clientSpecOfUsedPri ) {

        // Links between model elements in the same container are allowed:
        if ( usingPri.getCri( ).equals( usedPri.getCri( ) ) ) {
            return true; // link is allowed
        }

        // (2) Cross client spec links are not allowed
        if ( !clientSpecOfUsedPri.equals( clientSpecOfUsingPri ) ) {
            return false;
        }

        return cmManager.isLinkAllowed( usingPri, usedPri );
    }

};