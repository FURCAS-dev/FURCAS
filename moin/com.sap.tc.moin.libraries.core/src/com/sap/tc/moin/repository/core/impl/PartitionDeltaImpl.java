package com.sap.tc.moin.repository.core.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.EndAndMetaObject;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.shared.util.QualifiedName;
import com.sap.tc.moin.repository.spi.core.SpiEndAndMetaObject;
import com.sap.tc.moin.repository.spi.core.SpiLink;
import com.sap.tc.moin.repository.spi.core.SpiModelPartition;
import com.sap.tc.moin.repository.spi.facility.SpiPartitionDelta;

public final class PartitionDeltaImpl implements SpiPartitionDelta {

    private final CoreModelPartition partition;

    private final Map<Partitionable, Map<Attribute, Object /* persistentValue */>> changedAttributes;

    private final Collection<Partitionable> createdElements;

    private final Collection<MRI> deletedElements;

    private final Collection<SpiLink> addedLinks;

    private final Collection<SpiLink> removedLinks;

    private final Map<Partitionable, ModelPartition> assignedElements;

    private final Map<Partitionable, ModelPartition> unassignedElements;

    private final Map<SpiLink, ModelPartition> assignedLinks;

    private final Map<SpiLink, ModelPartition> unassignedLinks;

    private final Map<MRI, Map<SpiEndAndMetaObject, List<SpiLink>>> modifiedOrderedLinkCollections;

    private final CoreConnection connection;

    public PartitionDeltaImpl( CoreConnection connection, CoreModelPartition partition ) {

        this.connection = connection;
        this.partition = partition;
        this.changedAttributes = new LinkedHashMap<Partitionable, Map<Attribute, Object>>( );
        this.createdElements = new LinkedHashSet<Partitionable>( );
        this.deletedElements = new LinkedHashSet<MRI>( );
        this.assignedElements = new LinkedHashMap<Partitionable, ModelPartition>( );
        this.unassignedElements = new LinkedHashMap<Partitionable, ModelPartition>( );
        this.assignedLinks = new LinkedHashMap<SpiLink, ModelPartition>( );
        this.unassignedLinks = new LinkedHashMap<SpiLink, ModelPartition>( );
        this.addedLinks = new LinkedHashSet<SpiLink>( );
        this.removedLinks = new LinkedHashSet<SpiLink>( );
        this.modifiedOrderedLinkCollections = new LinkedHashMap<MRI, Map<SpiEndAndMetaObject, List<SpiLink>>>( );
    }

    public void attributeChanged( CorePartitionable element, Attribute attribute, Object oldValue ) {

        Map<Attribute, Object> attrs = changedAttributes.get( element );
        if ( attrs == null ) {
            attrs = new LinkedHashMap<Attribute, Object>( );
            changedAttributes.put( element, attrs );
        }
        attrs.put( attribute, oldValue );
    }

    public void elementCreated( CorePartitionable element ) {

        createdElements.add( element );
    }

    public void linkAdded( SpiLink link ) {

        addedLinks.add( link );
    }

    public void linkRemoved( SpiLink link ) {

        removedLinks.add( link );
    }

    public void orderedLinkCollectionModified( SpiLink link ) {

        EndStorageLink endStorageLink = (EndStorageLink) link;
        int orderedEnd = endStorageLink.getOrderedEnd( );
        int storageEnd = endStorageLink.getEndNumberOfStorageEnd( );
        if ( orderedEnd != storageEnd ) {
            MRI mriOfElementAtStorageEnd = endStorageLink.getStorageEnd( ).getMri( );
            // Only produce a delta if the model element at the non-ordered end is in this partition.
            if ( mriOfElementAtStorageEnd.getPri( ).equals( partition.getPri( ) ) ) {
                Workspace workspace = connection.getSession( ).getWorkspace( );
                EndAndMetaObject endAndMetaObject = workspace.getWorkspaceSet( ).getEndAndMetaObjectPool( ).getEndAndMetaObject( link.getEndNumberOfStorageEnd( ), endStorageLink.getMetaObject( ) );
                Collection<EndStorageLink> linksForEndAndMetaObject = workspace.getMemoryLinkManager( ).getLinksForEndAndMetaObject( connection.getSession( ), endAndMetaObject, mriOfElementAtStorageEnd );
                Map<SpiEndAndMetaObject, List<SpiLink>> mapOfLinkCollections = modifiedOrderedLinkCollections.get( mriOfElementAtStorageEnd );
                if ( mapOfLinkCollections == null ) {
                    modifiedOrderedLinkCollections.put( mriOfElementAtStorageEnd, mapOfLinkCollections = new LinkedHashMap<SpiEndAndMetaObject, List<SpiLink>>( ) );
                    mapOfLinkCollections.put( endAndMetaObject, new ArrayList<SpiLink>( linksForEndAndMetaObject ) );
                }
            }
        }
    }

    public void orderedLinkCollectionModified( MRI mriOfElementAtStorageEnd, SpiEndAndMetaObject endAndMetaObject, List<SpiLink> links ) {

        Map<SpiEndAndMetaObject, List<SpiLink>> mapOfLinkCollections = modifiedOrderedLinkCollections.get( mriOfElementAtStorageEnd );
        if ( mapOfLinkCollections == null ) {
            modifiedOrderedLinkCollections.put( mriOfElementAtStorageEnd, mapOfLinkCollections = new LinkedHashMap<SpiEndAndMetaObject, List<SpiLink>>( ) );
            mapOfLinkCollections.put( endAndMetaObject, links );
        }
    }

    public void elementAssigned( CorePartitionable element, CoreModelPartition previousPartition ) {

        assignedElements.put( element, previousPartition );
    }

    public void elementUnassigned( CorePartitionable element, CoreModelPartition newPartition ) {

        unassignedElements.put( element, newPartition );
    }

    public void linkAssigned( SpiLink link, CoreModelPartition previousPartition ) {

        assignedLinks.put( link, previousPartition );
    }

    public void linkUnassigned( SpiLink link, CoreModelPartition newPartition ) {

        unassignedLinks.put( link, newPartition );
    }

    public void elementDeleted( MRI mri ) {

        deletedElements.add( mri );
    }

    public SpiModelPartition getPartition( ) {

        return partition;
    }

    public boolean isEmpty( ) {

        return ( changedAttributes.isEmpty( ) && createdElements.isEmpty( ) && deletedElements.isEmpty( ) && assignedElements.isEmpty( ) && unassignedElements.isEmpty( ) && addedLinks.isEmpty( ) && removedLinks.isEmpty( ) && assignedLinks.isEmpty( ) && unassignedLinks.isEmpty( ) && modifiedOrderedLinkCollections
            .isEmpty( ) );
    }

    public Collection<SpiLink> getAddedLinks( ) {

        return addedLinks;
    }

    public Map<Partitionable, ModelPartition> getAssignedElements( ) {

        return assignedElements;
    }

    public Map<Partitionable, Map<Attribute, Object>> getChangedAttributes( ) {

        return changedAttributes;
    }

    public Collection<SpiLink> getRemovedLinks( ) {

        return removedLinks;
    }

    public CoreConnection getCoreConnection( ) {

        return connection;
    }

    public Map<Partitionable, ModelPartition> getUnassignedElements( ) {

        return unassignedElements;
    }

    public Collection<Partitionable> getCreatedElements( ) {

        return createdElements;
    }

    public Collection<MRI> getDeletedElements( ) {

        return deletedElements;
    }

    public Map<SpiLink, ModelPartition> getAssignedLinks( ) {

        return assignedLinks;
    }

    public Map<SpiLink, ModelPartition> getUnassignedLinks( ) {

        return unassignedLinks;
    }

    public Map<MRI, Map<SpiEndAndMetaObject, List<SpiLink>>> getModifiedOrderedLinkCollections( ) {

        return modifiedOrderedLinkCollections;
    }

    @Override
    public String toString( ) {

        StringBuilder result = new StringBuilder( );
        String title = "Changelog for partition " + partition.getPri( ); //$NON-NLS-1$
        result.append( title ).append( "\n" ); //$NON-NLS-1$
        for ( int i = 0; i < title.length( ); i++ ) {
            result.append( '=' );
        }
        result.append( "\n" ); //$NON-NLS-1$
        for ( Entry<Partitionable, Map<Attribute, Object>> entry : getChangedAttributes( ).entrySet( ) ) {
            Partitionable featured = entry.getKey( );
            Map<Attribute, Object> attributes = entry.getValue( );
            StringBuilder attributeNames = new StringBuilder( );
            for ( Iterator<Attribute> it = attributes.keySet( ).iterator( ); it.hasNext( ); ) {
                Attribute attr = it.next( );
                attributeNames.append( attr.getName( ) );
                if ( it.hasNext( ) ) {
                    attributeNames.append( ", " ); //$NON-NLS-1$
                }
            }
            result.append( "Updating attributes { " + attributeNames.toString( ) + " } of element with MOF-ID " + featured.refMofId( ) + " (" + featured.get___JmiInterface( ) + ")\n" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$//$NON-NLS-4$
        }
        for ( Entry<Partitionable, ModelPartition> entry : getAssignedElements( ).entrySet( ) ) {
            result.append( "Assigning element with MOF-ID " + entry.getKey( ).refMofId( ) + " (" + entry.getKey( ).get___JmiInterface( ) + ") from source partition " + entry.getValue( ).getPri( ) + "\n" ); //$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$
        }
        for ( Entry<Partitionable, ModelPartition> entry : getUnassignedElements( ).entrySet( ) ) {
            result.append( "Unassigning element with MOF-ID " + entry.getKey( ).refMofId( ) + " (" + entry.getKey( ).get___JmiInterface( ) + ") to target partition " + entry.getValue( ).getPri( ) + "\n" ); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$//$NON-NLS-4$
        }
        for ( Entry<SpiLink, ModelPartition> entry : getAssignedLinks( ).entrySet( ) ) {
            EndStorageLink link = (EndStorageLink) entry.getKey( );
            RefObject metaObject = link.getMetaObject( );
            if ( metaObject instanceof Association ) {
                result.append( "Assigning link of association " ); //$NON-NLS-1$
            } else {
                result.append( "Assigning link of object-valued attribute " ); //$NON-NLS-1$
            }
            result.append( QualifiedName.toDotSeparatedString( ( (ModelElementInternal) metaObject ).getQualifiedName( connection ) ) + " between " + link.getEnd( 0 ) + " and " + link.getEnd( 1 ) + " from source partition " + entry.getValue( ).getPri( ) + "\n" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$//$NON-NLS-4$
        }
        for ( Entry<SpiLink, ModelPartition> entry : getUnassignedLinks( ).entrySet( ) ) {
            EndStorageLink link = (EndStorageLink) entry.getKey( );
            RefObject metaObject = link.getMetaObject( );
            if ( metaObject instanceof Association ) {
                result.append( "Unassigning link of association " ); //$NON-NLS-1$
            } else {
                result.append( "Unassigning link of object-valued attribute " ); //$NON-NLS-1$
            }
            result.append( QualifiedName.toDotSeparatedString( ( (ModelElementInternal) metaObject ).getQualifiedName( connection ) ) + " between " + link.getEnd( 0 ) + " and " + link.getEnd( 1 ) + " to target partition " + entry.getValue( ).getPri( ) + "\n" ); //$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$
        }
        for ( Partitionable element : getCreatedElements( ) ) {
            result.append( "Creating element with MOF-ID " + element.refMofId( ) + " (" + element.get___JmiInterface( ) + ")\n" ); //$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$
        }
        for ( MRI mri : getDeletedElements( ) ) {
            result.append( "Deleting element with MRI " + mri + "\n" ); //$NON-NLS-1$//$NON-NLS-2$
        }
        for ( SpiLink link : getAddedLinks( ) ) {
            RefObject metaObject = ( (EndStorageLink) link ).getMetaObject( );
            if ( metaObject instanceof Association ) {
                result.append( "Adding link of association " ); //$NON-NLS-1$
            } else {
                result.append( "Adding link of object-valued attribute " ); //$NON-NLS-1$
            }
            result.append( QualifiedName.toDotSeparatedString( ( (ModelElementInternal) metaObject ).getQualifiedName( connection ) ) + " between " + ( (EndStorageLink) link ).getEnd( 0 ) + " and " + ( (EndStorageLink) link ).getEnd( 1 ) + "\n" ); //$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$
        }
        for ( SpiLink link : getRemovedLinks( ) ) {
            RefObject metaObject = ( (EndStorageLink) link ).getMetaObject( );
            if ( metaObject instanceof Association ) {
                result.append( "Removing link of association " ); //$NON-NLS-1$
            } else {
                result.append( "Removing link of object-valued attribute " ); //$NON-NLS-1$
            }
            result.append( QualifiedName.toDotSeparatedString( ( (ModelElementInternal) metaObject ).getQualifiedName( connection ) ) + " between " + ( (EndStorageLink) link ).getEnd( 0 ) + " and " + ( (EndStorageLink) link ).getEnd( 1 ) + "\n" ); //$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$
        }
        for ( Entry<MRI, Map<SpiEndAndMetaObject, List<SpiLink>>> entry : getModifiedOrderedLinkCollections( ).entrySet( ) ) {
            MRI mri = entry.getKey( );
            result.append( "Modified ordered link collections for element with MRI " + mri.toString( ) + " : " ); //$NON-NLS-1$ //$NON-NLS-2$
            for ( Iterator<Entry<SpiEndAndMetaObject, List<SpiLink>>> it = entry.getValue( ).entrySet( ).iterator( ); it.hasNext( ); ) {
                Entry<SpiEndAndMetaObject, List<SpiLink>> entry2 = it.next( );
                RefObject metaObject = (RefObject) ( (EndAndMetaObject) entry2.getKey( ) ).getMetaObject( connection.getSession( ).getWorkspaceSet( ).getMoin( ) ).get( connection.getSession( ) );
                if ( metaObject instanceof Association ) {
                    result.append( "association " ); //$NON-NLS-1$
                } else {
                    result.append( "object-valued attribute " ); //$NON-NLS-1$
                }
                result.append( QualifiedName.toDotSeparatedString( ( (ModelElementInternal) metaObject ).getQualifiedName( connection ) ) );
                if ( it.hasNext( ) ) {
                    result.append( ", " ); //$NON-NLS-1$
                }
            }
            result.append( "\n" ); //$NON-NLS-1$
        }
        return result.toString( );
    }
}
