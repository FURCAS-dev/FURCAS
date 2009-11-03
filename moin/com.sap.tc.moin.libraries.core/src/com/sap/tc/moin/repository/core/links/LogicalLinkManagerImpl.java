package com.sap.tc.moin.repository.core.links;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.consistency.DuplicateElementConsistencyViolation;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CoreMoin;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.EndAndMetaObject;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.EndStorageLinkManager;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.LogicalLinkManager;
import com.sap.tc.moin.repository.core.MemoryLinkManager;
import com.sap.tc.moin.repository.core.MoinReference;
import com.sap.tc.moin.repository.core.MriReference;
import com.sap.tc.moin.repository.core.OverflowContainer;
import com.sap.tc.moin.repository.core.QueryLinkManager;
import com.sap.tc.moin.repository.core.SessionWorkspace;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.consistency.ConsistencyViolationRegistry;
import com.sap.tc.moin.repository.core.jmi.extension.RefClassExtension;
import com.sap.tc.moin.repository.core.jmi.extension.RefFeaturedExtension;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;

public final class LogicalLinkManagerImpl implements LogicalLinkManager {

    private final CoreMoin moin;

    public LogicalLinkManagerImpl( CoreMoin moin ) {

        this.moin = moin;

    }

    public JmiList<CorePartitionable> getElementsForEndAndMetaobject( CoreConnection connection, EndAndMetaObject endAndMetaObject, CorePartitionable elementAtEnd ) {

        //TODO change signature to session
        EndStorageLinkManager linkManager = getResponsibleLinkManagerForNavigation( connection.getSession( ), endAndMetaObject, elementAtEnd );
        return linkManager.getElementsForEndAndMetaobject( connection, endAndMetaObject, elementAtEnd );
    }

    public int getNumberOfElementsForEndAndMetaObjectIncludingOverflows( CoreSession session, EndAndMetaObject endAndMetaObject, CorePartitionable elementAtEnd ) {

        EndStorageLinkManager linkManager = getResponsibleLinkManagerForNavigation( session, endAndMetaObject, elementAtEnd );
        return linkManager.getNumberOfElementsForEndAndMetaObjectIncludingOverflows( session, endAndMetaObject, elementAtEnd );
    }

    public EndStorageLink getCompositeParentLink( CoreSession session, CorePartitionable componentElement ) {

        List<EndStorageLink> allCompositeParentLinks = this.getCompositeParentLinks( session, componentElement );
        if ( allCompositeParentLinks.isEmpty( ) ) {
            return null;
        }
        // Handle inconsistencies: if LRI is equal, it is a duplicate element inconsistency.
        // If not, it is a duplicate parent link inconsistency. Both cases could also be mixed.
        if ( allCompositeParentLinks.size( ) > 1 ) {
            EndStorageLink usedLink = null;
            MRI usedParentMri = getUsedMriForDuplicateElement( session, allCompositeParentLinks );
            boolean duplicateParentFound = false;
            for ( int i = 0, n = allCompositeParentLinks.size( ); i < n; i++ ) {
                EndStorageLink compositeLink = allCompositeParentLinks.get( i );
                MRI compositeEndsMri = this.getCompositeEndsMri( session, compositeLink );
                if ( usedParentMri == null ) {
                    usedParentMri = compositeEndsMri;
                }
                if ( !compositeEndsMri.getLri( ).equals( usedParentMri.getLri( ) ) ) {
                    duplicateParentFound = true;
                } else if ( compositeEndsMri.equals( usedParentMri ) ) {
                    // will be the link to the selected duplicate element
                    usedLink = compositeLink;
                }

            }
            if ( duplicateParentFound ) {
                EndStorageLink usedPhysicalLink = session.getConsistencyViolationRegistry( ).notifyDuplicateParentLinkInconsistency( componentElement.get___Mri( ), allCompositeParentLinks );
                return usedPhysicalLink;
            }
            // return correct link for duplicate elements
            return usedLink;
        }
        return allCompositeParentLinks.get( 0 );
    }

    /**
     * In case there are duplicate elements, this method returns the MRI of the
     * composition parent element that is to be used according to the
     * inconsistency management.
     */
    private MRI getUsedMriForDuplicateElement( CoreSession session, List<EndStorageLink> allCompositeParentLinks ) {

        MRI usedMri = null;
        EndStorageLink firstLink = allCompositeParentLinks.get( 0 );
        MRI firstLinkMri = getCompositeEndsMri( session, firstLink );
        DuplicateElementConsistencyViolation duplicateElement = session.getConsistencyViolationRegistry( ).checkRegisteredDuplicateElement( firstLinkMri );
        if ( duplicateElement != null ) {
            usedMri = duplicateElement.getUsedElementsMri( );
        }
        return usedMri;
    }

    private MRI getCompositeEndsMri( CoreSession session, EndStorageLink link ) {

        MRI firstLinkMri = link.getEnd( link.getCompositeEnd( ) ).getMri( session );
        return firstLinkMri;
    }

    public List<EndStorageLink> getCompositeParentLinks( CoreSession session, CorePartitionable componentElement ) {

        List<EndStorageLink> result = null;
        List<EndStorageLink> compositeParentLinksStoredAtElement = getCompositeParentLinksStoredAtElement( session, componentElement );
        if ( compositeParentLinksStoredAtElement != null ) {
            result = new ArrayList<EndStorageLink>( compositeParentLinksStoredAtElement.size( ) );
            for ( int i = 0, n = compositeParentLinksStoredAtElement.size( ); i < n; i++ ) {
                result.add( compositeParentLinksStoredAtElement.get( i ) );
            }
        }
        List<EndStorageLink> compositeParentLinksInOverflowContainer = componentElement.get___Partition( ).getOverflowContainer( ).getCompositeParentLinks( componentElement.get___Mri( ).getLri( ) );
        if ( compositeParentLinksInOverflowContainer != null ) {
            for ( int i = 0, n = compositeParentLinksInOverflowContainer.size( ); i < n; i++ ) {
                EndStorageLink link = compositeParentLinksInOverflowContainer.get( i );
                result.add( link );
            }
        }
        List<EndStorageLink> distributedCompositeParentLinksForAssociations = getDistributedCompositeParentLinks( session, componentElement, getUnstoredCompositeChildAssociationEnds( session, componentElement ) );
        List<EndStorageLink> distributedCompositeParentLinksForAttributes = getCompositeLinksForAttributeValues( session, componentElement );
        if ( distributedCompositeParentLinksForAssociations != null ) {
            if ( result == null ) {
                result = new ArrayList<EndStorageLink>( );
            }
            for ( int i = 0, n = distributedCompositeParentLinksForAssociations.size( ); i < n; i++ ) {
                result.add( distributedCompositeParentLinksForAssociations.get( i ) );
            }
        }
        if ( distributedCompositeParentLinksForAttributes != null ) {
            if ( result == null ) {
                result = new ArrayList<EndStorageLink>( );
            }
            for ( int i = 0, n = distributedCompositeParentLinksForAttributes.size( ); i < n; i++ ) {
                result.add( distributedCompositeParentLinksForAttributes.get( i ) );
            }
        }
        if ( result == null ) {
            return Collections.emptyList( );
        }
        return result;
    }

    private List<EndStorageLink> getCompositeParentLinksStoredAtElement( CoreSession session, CorePartitionable componentElement ) {

        List<EndStorageLink> result = null;
        List<EndStorageLink> links = ( (RefFeaturedExtension) componentElement ).get___AllStoredLinks( );
        if ( links != null ) {
            for ( int i = 0, size = links.size( ); i < size; i++ ) {
                EndStorageLink link = links.get( i );
                int componentEnd = link.getComponentEnd( );
                if ( componentEnd != -1 ) {
                    if ( componentElement.get___Mri( ).getLri( ).equals( link.getEnd( componentEnd ).getLri( ) ) ) {
                        if ( result == null ) {
                            result = new ArrayList<EndStorageLink>( );
                        }
                        result.add( link );
                    }
                }
            }
        }
        return result;
    }

    private List<EndStorageLink> getComponentChildrenLinksStoredAtElement( CoreSession session, CorePartitionable compositeElement ) {

        List<EndStorageLink> result = null;
        List<EndStorageLink> links = ( (RefFeaturedExtension) compositeElement ).get___AllStoredLinks( );
        if ( links != null ) {
            for ( int i = 0, size = links.size( ); i < size; i++ ) {
                EndStorageLink link = links.get( i );
                int compositeEnd = link.getCompositeEnd( );
                if ( compositeEnd != -1 ) {
                    if ( compositeElement.get___Mri( ).getLri( ).equals( link.getEnd( compositeEnd ).getLri( ) ) ) {
                        if ( result == null ) {
                            result = new ArrayList<EndStorageLink>( );
                        }
                        result.add( link );
                    }
                }
            }
        }
        return result;
    }

    public Collection<EndStorageLink> getComponentChildrenLinks( CoreSession session, CorePartitionable compositeElement ) {

        List<EndStorageLink> result = null;
        List<EndStorageLink> componentChildrenLinksStoredAtElement = getComponentChildrenLinksStoredAtElement( session, compositeElement );
        if ( componentChildrenLinksStoredAtElement != null ) {
            result = new ArrayList<EndStorageLink>( );
            for ( int i = 0, n = componentChildrenLinksStoredAtElement.size( ); i < n; i++ ) {
                result.add( componentChildrenLinksStoredAtElement.get( i ) );
            }
        }
        if ( isQueryNeededForComponentChildrenLinks( session, compositeElement ) ) {
            List<EndStorageLink> distributedComponentChildrenLinks = getDistributedComponentChildrenLinks( session, compositeElement, getUnstoredCompositeParentAssociationEnds( session, compositeElement ) );
            if ( distributedComponentChildrenLinks != null ) {
                if ( result == null ) {
                    result = new ArrayList<EndStorageLink>( );
                }
                for ( int i = 0, n = distributedComponentChildrenLinks.size( ); i < n; i++ ) {
                    result.add( distributedComponentChildrenLinks.get( i ) );
                }
            }
        }
        if ( result == null ) {
            return Collections.emptyList( );
        }
        return result;
    }

    public Collection<CorePartitionable> getComponentChildren( CoreSession session, CorePartitionable modelElement ) {

        Collection<CorePartitionable> result = null;
        List<EndStorageLink> componentChildrenLinks = (List<EndStorageLink>) this.getComponentChildrenLinks( session, modelElement );
        for ( int i = 0, n = componentChildrenLinks.size( ); i < n; i++ ) {
            EndStorageLink link = componentChildrenLinks.get( i );
            CorePartitionable componentElement = link.getElementAtEnd( session, link.getComponentEnd( ) );
            if ( componentElement != null ) {
                componentElement = checkPartitionConsistency( session, componentElement, modelElement );
                if ( result == null ) {
                    result = new HashSet<CorePartitionable>( );
                }
                result.add( componentElement );
            }
        }
        if ( result == null ) {
            return Collections.emptySet( );
        }
        return result;
    }

    /**
     * Is only used in case of inconsistencies. Checks if the returned component
     * is stored in the same partition as the composite.
     */
    private CorePartitionable checkPartitionConsistency( CoreSession session, CorePartitionable componentChildElement, CorePartitionable compositeModelElement ) {

        List<DuplicateElementConsistencyViolation> duplicateElements = this.getConsistencyViolationRegistry( session ).checkRegisteredDuplicateElement( componentChildElement.get___Mri( ).getLri( ) );
        if ( duplicateElements != null ) {
            for ( int i = 0, n = duplicateElements.size( ); i < n; i++ ) {
                DuplicateElementConsistencyViolation violation = duplicateElements.get( i );
                // check if there is a duplicate element with the same pri as the composite
                if ( violation.getMri( ).getPri( ).equals( compositeModelElement.get___Mri( ).getPri( ) ) ) {
                    return moin.resolveMri( session, violation.getMri( ) );
                }
            }
        }
        return componentChildElement;
    }

    private ConsistencyViolationRegistry getConsistencyViolationRegistry( CoreSession session ) {

        return session.getConsistencyViolationRegistry( );
    }

    @SuppressWarnings( "unchecked" )
    public void elementRelocated( CoreConnection connection, CoreModelPartition oldPartition, CoreModelPartition newPartition, CorePartitionable element ) {

        List<EndStorageLink> allStoredLinks = ( (RefFeaturedExtension) element ).get___AllStoredLinks( );
        if ( allStoredLinks != null ) {
            for ( int i = 0, n = allStoredLinks.size( ); i < n; i++ ) {
                EndStorageLink link = allStoredLinks.get( i );
                LRI lriOfElementAtOtherEnd = link.getOtherEnd( ).getLri( );
                oldPartition.getDistributedLinkContainer( ).removeLink( lriOfElementAtOtherEnd, link );
                newPartition.getDistributedLinkContainer( ).addLink( lriOfElementAtOtherEnd, link );
            }
        }
        // Move non-distributed JmiLists to the new partition's JmiListContainer.
        LRI lriOfElement = element.get___Mri( ).getLri( );
        Map<EndAndMetaObject, JmiList> registeredJmiLists = oldPartition.getJmiListContainer( ).getRegisteredJmiLists( lriOfElement );
        for ( Entry<EndAndMetaObject, JmiList> entry : registeredJmiLists.entrySet( ) ) {
            newPartition.getJmiListContainer( ).registerJmiList( entry.getKey( ), lriOfElement, entry.getValue( ) );
        }
        // Move overflow inconsistencies to the new partition's OverflowContainer.
        OverflowContainer overflowContainer = oldPartition.getOverflowContainer( );
        for ( EndStorageLink link : overflowContainer.getAllOverflowLinks( lriOfElement ) ) {
            newPartition.getOverflowContainer( ).add( link );
            overflowContainer.remove( link );
        }
    }

    public List<EndStorageLink> getLinksForElement( CoreSession session, CorePartitionable element ) {

        List<EndStorageLink> result = null;

        List<EndStorageLink> allStoredLogicalLinks = ( (RefFeaturedExtension) element ).get___AllStoredLinks( );
        if ( allStoredLogicalLinks != null ) {
            result = new ArrayList<EndStorageLink>( allStoredLogicalLinks.size( ) );
            for ( int i = 0, n = allStoredLogicalLinks.size( ); i < n; i++ ) {
                result.add( allStoredLogicalLinks.get( i ) );
            }
        }

        CoreModelPartition mp = element.get___Partition( );
        if ( mp.isExtentPartition( ) || ( !mp.getPri( ).isVolatilePartition( ) && !mp.isDirty( ) ) ) {
            // The element's partition has to be considered.
            result = mergeLinksForPartition( mp, element, result );
        }



        // Dirty partitions have to be considered.
        // Transient partitions have to be considered as they are never persisted.
        // The null-partition has to be considered as it is not persisted.
        for ( CoreModelPartition partition : session.getPartitionsToConsiderMemoryState( ) ) {
            result = mergeLinksForPartition( partition, element, result );
        }



        // Ask the index for persisted cross-partition links to our element.
        QueryLinkManager queryLinkManager = session.getWorkspace( ).getQueryLinkManager( );
        Collection<PRI> referringPris = queryLinkManager.getReferringPartitions( session, element.get___Mri( ) );
        if ( referringPris != null ) {
            for ( PRI pri : referringPris ) {
                // Load the partitions and add them to partitionsToConsiderMemoryState.
                // It could be that the partition was dirty deleted and therefore we only add partitions
                // which can be resolved.
                CoreModelPartition partition = moin.resolvePri( session, pri );
                if ( partition != null ) {
                    result = mergeLinksForPartition( partition, element, result );
                }
            }
        }

        if ( result == null ) {
            result = Collections.emptyList( );
        }

        return result;

    }



    private List<EndStorageLink> mergeLinksForPartition( CoreModelPartition partition, CorePartitionable element, List<EndStorageLink> previousResult ) {

        List<EndStorageLink> result = previousResult;
        if ( partition.isAlive( ) ) {
            List<EndStorageLink> linksForElement = partition.getDistributedLinkContainer( ).getLinksForElement( element );
            if ( linksForElement != null ) {
                if ( result == null ) {
                    result = new ArrayList<EndStorageLink>( );
                }
                for ( int i = 0, n = linksForElement.size( ); i < n; i++ ) {
                    result.add( linksForElement.get( i ) );
                }
            }
        }
        return result;
    }

    public Map<EndStorageLink, Integer> getLinksForElementWithIndexInformation( CoreSession session, CorePartitionable element ) {

        List<EndStorageLink> linksForElement = getLinksForElement( session, element );
        Map<EndStorageLink, Integer> result = new LinkedHashMap<EndStorageLink, Integer>( linksForElement.size( ) );
        for ( int i = 0, n = linksForElement.size( ); i < n; i++ ) {
            EndStorageLink link = linksForElement.get( i );
            int orderedEndNumber = link.getOrderedEnd( );
            int index = -1;
            if ( orderedEndNumber != -1 ) {
                CorePartitionable elementAtNonOrderedEnd = link.getElementAtEnd( session, 1 - orderedEndNumber );
                if ( link.getEndNumberOfStorageEnd( ) != orderedEndNumber ) {
                    RefObject metaObject = link.getMetaObject( );
                    List<EndStorageLink> allLinks;
                    if ( metaObject instanceof Association ) {
                        AssociationEnd end = this.moin.getMetamodelWorkspace( ).getWorkspaceSet( ).getMoin( ).getJmiHelper( ).getAssociationEnds( session, (Association) metaObject ).get( orderedEndNumber );
                        allLinks = (List<EndStorageLink>) ( (RefFeaturedExtension) elementAtNonOrderedEnd ).get___AssociationLinks( end.refMofId( ) );
                    } else {
                        allLinks = (List<EndStorageLink>) ( (RefFeaturedExtension) elementAtNonOrderedEnd ).get___AttributeLinks( metaObject.refMofId( ) );
                    }
                    index = allLinks.indexOf( link );
                    result.put( link, index );
                } else {
                    result.put( link, index );
                }
            } else {
                result.put( link, index );
            }
        }
        return result;
    }

    private EndStorageLinkManager getResponsibleLinkManagerForNavigation( CoreSession session, EndAndMetaObject endAndMetaObject, CorePartitionable element ) {

        Workspace workspace = element.get___Workspace( );
        RefObject metaObject = (RefObject) endAndMetaObject.getMetaObject( moin ).get( session );
        byte storedEnd = getStoredEnd( session, metaObject, metaObject instanceof Association );
        if ( storedEnd == endAndMetaObject.getFromEnd( ) ) {
            // the end where navigation starts is stored, therefore all links are available in memory
            return workspace.getMemoryLinkManager( );
        }
        // the end which is navigated to is stored, therefore a query might be needed
        return session.getWorkspace( ).getQueryLinkManager( );
    }



    public EndStorageLink createLinkForAttribute( CoreSession session, SessionWorkspace workspaceOfStorageEnd, MRI elementAtEnd0, CorePartitionable elementAtEnd1, Attribute metaObject ) {

        byte storageEndNumber = 0;
        MemoryLinkManager memoryLinkManager = workspaceOfStorageEnd.getMemoryLinkManager( );
        MoinReference referenceOtherEnd;
        MriReference storageEnd;
        if ( storageEndNumber == 0 ) {
            referenceOtherEnd = memoryLinkManager.createMoinReferenceForOtherEnd( elementAtEnd0.getPri( ), elementAtEnd1 );
            storageEnd = this.moin.getMetamodelWorkspace( ).getWorkspaceSet( ).getReferenceManager( ).getMriReference( elementAtEnd0, workspaceOfStorageEnd );
        } else {
            // TODO consider method where the MRI goes in for other end -> intra-partition link logic
            referenceOtherEnd = memoryLinkManager.createMoinReferenceForOtherEnd( elementAtEnd0.getLri( ) );
            storageEnd = this.moin.getMetamodelWorkspace( ).getWorkspaceSet( ).getReferenceManager( ).getMriReference( elementAtEnd1, workspaceOfStorageEnd );
        }
        EndStorageLink result = this.moin.getMetamodelWorkspace( ).getWorkspaceSet( ).getLinkFactory( ).createEndStorageLink( session, storageEndNumber, metaObject, storageEnd, referenceOtherEnd );
        return result;
    }

    public EndStorageLink createLink( CoreSession session, CorePartitionable elementAtEnd0, CorePartitionable elementAtEnd1, Object metaObject, boolean association ) {

        //TODO change signature to session
        byte storedEnd = getStoredEnd( session, metaObject, association );
        EndStorageLink link = null;
        if ( association ) { // Association
            link = this.moin.getMetamodelWorkspace( ).getWorkspaceSet( ).getLinkFactory( ).createEndStorageLink( session, elementAtEnd0, elementAtEnd1, (Association) metaObject, storedEnd );
        } else { // Attribute
            link = this.moin.getMetamodelWorkspace( ).getWorkspaceSet( ).getLinkFactory( ).createEndStorageLink( session, elementAtEnd0, elementAtEnd1, (Attribute) metaObject, storedEnd );
        }

        return link;
    }

    public EndStorageLink createLink( CoreSession session, CorePartitionable elementAtStoredEnd, LRI target, byte numberOfStoredEnd, Association association ) {

        EndStorageLink link = elementAtStoredEnd.get___Workspace( ).getMemoryLinkManager( ).createLink( session, numberOfStoredEnd, elementAtStoredEnd, target, association );

        return link;
    }

    private byte getStoredEnd( CoreSession session, Object metaObject, boolean association ) {



        if ( association ) {
            return this.moin.getMetamodelWorkspace( ).getWorkspaceSet( ).getMoin( ).getJmiHelper( ).getStoredEnd( session, (Association) metaObject );
        }
        return this.moin.getMetamodelWorkspace( ).getWorkspaceSet( ).getMoin( ).getJmiHelper( ).getStoredEnd( (Attribute) metaObject );
    }


    public Collection<EndStorageLink> getLinksForAttribute( CoreSession session, CorePartitionable elementAtEnd0, CorePartitionable elementAtEnd1, Attribute attribute ) {

        Collection<EndStorageLink> result = null;
        Collection<EndStorageLink> links = ( (RefFeaturedExtension) elementAtEnd0 ).get___AttributeLinks( attribute.refMofId( ) );
        if ( links != null ) {
            for ( EndStorageLink link : links ) {
                if ( link.getOtherEnd( ).getLri( ).equals( elementAtEnd1.get___Mri( ).getLri( ) ) ) {
                    if ( result == null ) {
                        result = new ArrayList<EndStorageLink>( );
                    }
                    result.add( link );
                }
            }
        }
        if ( result == null ) {
            return Collections.emptyList( );
        }
        return result;
    }


    public EndStorageLink getLink( CoreSession session, CorePartitionable elementAtEnd0, CorePartitionable elementAtEnd1, RefObject metaObject, boolean association ) {

        byte storedEnd = getStoredEnd( session, metaObject, association );
        EndStorageLink endStorageLink = null;
        if ( storedEnd == 0 ) {
            if ( association ) {
                AssociationEnd end1 = this.moin.getMetamodelWorkspace( ).getWorkspaceSet( ).getMoin( ).getJmiHelper( ).getAssociationEnds( session, (Association) metaObject ).get( 1 );
                if ( end1.getMultiplicity( ).getUpper( ) == 1 ) {
                    endStorageLink = ( (RefFeaturedExtension) elementAtEnd0 ).get___AssociationLink( end1.refMofId( ) );
                } else {
                    Collection<EndStorageLink> links = ( (RefFeaturedExtension) elementAtEnd0 ).get___AssociationLinks( end1.refMofId( ) );
                    if ( links != null ) {
                        endStorageLink = findEndStorageLink( links, elementAtEnd1.get___Mri( ).getLri( ) );
                    }
                }
            } else {
                Attribute attribute = (Attribute) metaObject;
                if ( attribute.getMultiplicity( ).getUpper( ) == 1 ) {
                    endStorageLink = ( (RefFeaturedExtension) elementAtEnd0 ).get___AttributeLink( metaObject.refMofId( ) );
                } else {
                    Collection<EndStorageLink> links = ( (RefFeaturedExtension) elementAtEnd0 ).get___AttributeLinks( attribute.refMofId( ) );
                    if ( links != null ) {
                        endStorageLink = findEndStorageLink( links, elementAtEnd1.get___Mri( ).getLri( ) );
                    }
                }
            }
        } else if ( storedEnd == 1 ) {
            // Must be an association.
            AssociationEnd end0 = this.moin.getMetamodelWorkspace( ).getWorkspaceSet( ).getMoin( ).getJmiHelper( ).getAssociationEnds( session, (Association) metaObject ).get( 0 );
            if ( end0.getMultiplicity( ).getUpper( ) == 1 ) {
                endStorageLink = ( (RefFeaturedExtension) elementAtEnd1 ).get___AssociationLink( end0.refMofId( ) );
            } else {
                Collection<EndStorageLink> links = ( (RefFeaturedExtension) elementAtEnd1 ).get___AssociationLinks( end0.refMofId( ) );
                if ( links != null ) {
                    endStorageLink = findEndStorageLink( links, elementAtEnd0.get___Mri( ).getLri( ) );
                }
            }
        }
        return endStorageLink;
    }


    private EndStorageLink findEndStorageLink( Collection<EndStorageLink> linksToSearch, LRI lriOfElementToSearch ) {

        if ( linksToSearch instanceof List ) {
            List<EndStorageLink> list = (List<EndStorageLink>) linksToSearch;
            for ( int i = 0, n = linksToSearch.size( ); i < n; i++ ) {
                EndStorageLink link = list.get( i );
                if ( link.getOtherEnd( ).getLri( ).equals( lriOfElementToSearch ) ) {
                    return link;
                }
            }
        } else {
            for ( EndStorageLink link : linksToSearch ) {
                if ( link.getOtherEnd( ).getLri( ).equals( lriOfElementToSearch ) ) {
                    return link;
                }
            }
        }
        return null;
    }

    private Collection<PRI> getDistinctPris( Collection<MRI> elements ) {

        HashSet<PRI> result = new HashSet<PRI>( );
        for ( MRI mri : elements ) {
            result.add( mri.getPri( ) );
        }
        return result;
    }


    private AssociationEnd[] getUnstoredCompositeChildAssociationEnds( CoreSession session, CorePartitionable child ) {

        RefClassExtension refClassExtensionOfElement = (RefClassExtension) ( (RefObject) child ).refClass( );
        Set<AssociationEnd> unstoredCompositeChildAssociationEnds = refClassExtensionOfElement.get___UnstoredCompositeChildAssociationEnds( session );
        return unstoredCompositeChildAssociationEnds.toArray( new AssociationEnd[unstoredCompositeChildAssociationEnds.size( )] );
    }

    private AssociationEnd[] getUnstoredCompositeParentAssociationEnds( CoreSession session, CorePartitionable parent ) {

        RefClassExtension refClassExtensionOfElement = (RefClassExtension) ( (RefObject) parent ).refClass( );
        Set<AssociationEnd> unstoredCompositeParentAssociationEnds = refClassExtensionOfElement.get___UnstoredCompositeParentAssociationEnds( session );
        return unstoredCompositeParentAssociationEnds.toArray( new AssociationEnd[unstoredCompositeParentAssociationEnds.size( )] );
    }

    private boolean isQueryNeededForComponentChildrenLinks( CoreSession session, CorePartitionable parentElement ) {

        RefClassExtension refClassExtensionOfElement = (RefClassExtension) ( (RefObject) parentElement ).refClass( );
        return refClassExtensionOfElement.___mayHaveChildLinkInOtherPartition( session );
    }

    private List<EndStorageLink> getDistributedCompositeParentLinks( CoreSession session, CorePartitionable componentElement, AssociationEnd[] unstoredCompositeChildAssociationEnds ) {

        return getCompositeLinksForAssociationEnds( session, componentElement, unstoredCompositeChildAssociationEnds, false /* elementAsParent */);
    }

    private List<EndStorageLink> getDistributedComponentChildrenLinks( CoreSession session, CorePartitionable compositeElement, AssociationEnd[] unstoredCompositeParentAssociationEnds ) {

        return getCompositeLinksForAssociationEnds( session, compositeElement, unstoredCompositeParentAssociationEnds, true /* elementAsParent */);
    }

    private List<EndStorageLink> getCompositeLinksForAssociationEnds( CoreSession session, CorePartitionable element, AssociationEnd[] associationEnds, boolean elementAsParent ) {

        SpiJmiHelper jmiHelper = this.moin.getMetamodelWorkspace( ).getWorkspaceSet( ).getMoin( ).getJmiHelper( );
        List<EndStorageLink> result = null;
        for ( AssociationEnd associationEnd : associationEnds ) {
            int fromEnd = jmiHelper.getAssociationEndNumber( session, associationEnd );
            Association association = (Association) ( (RefObjectImpl) associationEnd ).refImmediateComposite( session );
            EndAndMetaObject endAndMetaObject = this.moin.getMetamodelWorkspace( ).getWorkspaceSet( ).getEndAndMetaObjectPool( ).getEndAndMetaObject( fromEnd, association );
            Collection<EndStorageLink> linksForEndAndMetaObject = session.getWorkspace( ).getQueryLinkManager( ).getLinksForEndAndMetaObject( session, endAndMetaObject, element );
            for ( EndStorageLink link : linksForEndAndMetaObject ) {
                if ( link.getCompositeEnd( ) != -1 ) {
                    int relevantEndNumber = ( elementAsParent ? link.getCompositeEnd( ) : link.getComponentEnd( ) );
                    if ( element.get___Mri( ).getLri( ).equals( link.getEnd( relevantEndNumber ).getLri( ) ) ) {
                        if ( result == null ) {
                            result = new ArrayList<EndStorageLink>( );
                        }
                        result.add( link );
                    }
                }
            }
        }
        return result;
    }

    private List<EndStorageLink> getCompositeLinksForAttributeValues( CoreSession session, CorePartitionable element ) {

        SpiJmiHelper jmiHelper = this.moin.getMetamodelWorkspace( ).getWorkspaceSet( ).getMoin( ).getJmiHelper( );
        Set<Attribute> attributesOfType = jmiHelper.getObjectValuedAttributesOfType( session, (MofClass) ( (RefBaseObject) element ).refMetaObject( ), false );
        List<EndStorageLink> result = null;
        LRI lriOfElement = element.get___Mri( ).getLri( );
        for ( Attribute attribute : attributesOfType ) {
            // The JmiHelper can return Attribute instances from a ClientSpecificWorkspace (OCL-generated, living in the
            // OCL transient partition). We need to filter these out.
            if ( ( (CorePartitionable) attribute ).get___Workspace( ).isMetamodelWorkspace( ) ) {
                EndAndMetaObject endAndMetaObject = this.moin.getMetamodelWorkspace( ).getWorkspaceSet( ).getEndAndMetaObjectPool( ).getEndAndMetaObject( 1 /* fromEnd */, attribute );
                Collection<EndStorageLink> linksForEndAndMetaObject = session.getWorkspace( ).getQueryLinkManager( ).getLinksForEndAndMetaObject( session, endAndMetaObject, element );
                for ( EndStorageLink link : linksForEndAndMetaObject ) {
                    if ( lriOfElement.equals( link.getEnd( link.getComponentEnd( ) ).getLri( ) ) ) {
                        if ( result == null ) {
                            result = new ArrayList<EndStorageLink>( );
                        }
                        result.add( link );
                    }
                }
            }
        }
        return result;
    }
}
