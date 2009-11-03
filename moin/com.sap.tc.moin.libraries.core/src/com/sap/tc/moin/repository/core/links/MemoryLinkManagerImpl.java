package com.sap.tc.moin.repository.core.links;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.consistency.DuplicateElementConsistencyViolation;
import com.sap.tc.moin.repository.core.AssociationExtent;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.EndAndMetaObject;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.EndStorageLinkFactory;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.JmiListContainer;
import com.sap.tc.moin.repository.core.MemoryLinkManager;
import com.sap.tc.moin.repository.core.MetamodelInstanceManager;
import com.sap.tc.moin.repository.core.MoinReference;
import com.sap.tc.moin.repository.core.MriReference;
import com.sap.tc.moin.repository.core.OverflowContainer;
import com.sap.tc.moin.repository.core.ReferenceManager;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.core.jmi.extension.RefFeaturedExtension;
import com.sap.tc.moin.repository.core.jmi.extension.RefObjectExtension;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.shared.util.IteratorKnowingCollection;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.core.SpiLinkManager;
import com.sap.tc.moin.repository.spi.core.SpiPartitionable;
import com.sap.tc.moin.repository.spi.core.SpiSession;

public class MemoryLinkManagerImpl extends AbstractEndStorageLinkManager implements MemoryLinkManager, SpiLinkManager {

    private static final Comparator<EndStorageLink> MOF_ID_OF_OTHER_LINK_END_COMPARATOR = new Comparator<EndStorageLink>( ) {

        public int compare( EndStorageLink link1, EndStorageLink link2 ) {

            String mofId1 = link1.getOtherEnd( ).getMofId( );
            String mofId2 = link2.getOtherEnd( ).getMofId( );
            int result = mofId1.compareTo( mofId2 );
            if ( result == 0 ) {
                if ( link1.canHaveDuplicates( ) ) {
                    result = System.identityHashCode( link1 ) - System.identityHashCode( link2 );
                }
            }
            return result;
        }
    };

    public MemoryLinkManagerImpl( Workspace workspace ) {

        super( workspace );
    }

    public final MoinReference createMoinReferenceForOtherEnd( PRI storageEndPri, CorePartitionable otherEnd ) {

        WorkspaceSet workspaceSet = this.getWorkspace( ).getWorkspaceSet( );
        ReferenceManager referenceManager = workspaceSet.getReferenceManager( );
        MoinReference result;
        if ( otherEnd.get___Workspace( ).isMetamodelWorkspace( ) ) {
            result = referenceManager.getMetamodelMriReference( otherEnd );
        } else {
            result = referenceManager.getLriReference( otherEnd.get___Mri( ).getLri( ) );
        }
        return result;
    }

    public final MoinReference createMoinReferenceForOtherEnd( LRI otherEnd ) {

        WorkspaceSet workspaceSet = this.getWorkspace( ).getWorkspaceSet( );
        ReferenceManager referenceManager = workspaceSet.getReferenceManager( );
        MoinReference result;
        if ( otherEnd.getDataAreaDescriptor( ).isMetamodelDataArea( ) ) {
            // we don't need a session if the other end is in the metamodel data area
            // Loading of a metamodel partition should never trigger loading of a second metamodel partition!!!
            // (Otherwise: "deadlock" possible, if second partition in turn has a link into the first partition!)
            // This is only possible with a StagedLriReference similar to the existing StagedMriReference.
            MetamodelInstanceManager instanceManager = workspaceSet.getMoin( ).getMetamodelWorkspace( ).getInstanceManager( );
            CorePartitionable element = instanceManager.getInstance( otherEnd.getMofId( ) );
            if ( element == null ) {
                // create cacheable MetamodelLriReference
                result = referenceManager.getMetamodelLriReference( otherEnd );
            } else {
                result = referenceManager.getMetamodelMriReference( element );
            }
        } else {
            result = referenceManager.getLriReference( otherEnd );
        }
        return result;
    }

    public final Collection<EndStorageLink> getLinksForEndAndMetaObject( CoreSession session, EndAndMetaObject endAndMetaObject, CorePartitionable elementAtEnd ) {

        Collection<EndStorageLink> result = null;
        Object metaObject = endAndMetaObject.getMetaObject( getWorkspace( ).getWorkspaceSet( ).getMoin( ) ).get( session );
        if ( metaObject instanceof Association ) {
            List<AssociationEnd> ends = getWorkspace( ).getWorkspaceSet( ).getMoin( ).getJmiHelper( ).getAssociationEnds( session, (Association) metaObject );
            AssociationEnd end = ends.get( endAndMetaObject.getToEnd( ) );
            if ( end.getMultiplicity( ).getUpper( ) == 1 ) {
                EndStorageLink link = ( (RefFeaturedExtension) elementAtEnd ).get___AssociationLink( end.refMofId( ) );
                if ( link != null ) {
                    result = new ArrayList<EndStorageLink>( 1 );
                    result.add( link );
                }
            } else {
                Collection<EndStorageLink> links = ( (RefFeaturedExtension) elementAtEnd ).get___AssociationLinks( end.refMofId( ) );
                if ( links != null ) {
                    result = new ArrayList<EndStorageLink>( links );
                }
            }
        } else {
            Attribute attribute = (Attribute) metaObject;
            if ( attribute.getMultiplicity( ).getUpper( ) == 1 ) {
                EndStorageLink link = ( (RefFeaturedExtension) elementAtEnd ).get___AttributeLink( attribute.refMofId( ) );
                if ( link != null ) {
                    result = new ArrayList<EndStorageLink>( 1 );
                    result.add( link );
                }
            } else {
                Collection<EndStorageLink> links = ( (RefFeaturedExtension) elementAtEnd ).get___AttributeLinks( attribute.refMofId( ) );
                if ( links != null ) {
                    result = new ArrayList<EndStorageLink>( links );
                }
            }
        }
        if ( result == null ) {
            result = Collections.emptyList( );
        }
        return result;
    }

    public final Collection<EndStorageLink> getLinksForEndAndMetaObject( CoreSession session, EndAndMetaObject endAndMetaObject, MRI elementAtEndMri ) {

        CorePartitionable element = session.getElement( elementAtEndMri );
        if ( element != null ) {
            return getLinksForEndAndMetaObject( session, endAndMetaObject, element );
        }
        return Collections.emptyList( );
    }

    public final Collection<EndStorageLink> getLinkCollectionForEndAndMetaObject( CoreSession session, EndAndMetaObject endAndMetaObject, CorePartitionable elementAtEnd ) {

        Object metaObject = endAndMetaObject.getMetaObject( getWorkspace( ).getWorkspaceSet( ).getMoin( ) ).get( session );
        if ( metaObject instanceof Association ) {
            Association association = (Association) metaObject;
            List<AssociationEnd> ends = getWorkspace( ).getWorkspaceSet( ).getMoin( ).getJmiHelper( ).getAssociationEnds( session, association );
            AssociationEnd end = ends.get( endAndMetaObject.getToEnd( ) );
            if ( end.getMultiplicity( ).getUpper( ) == 1 ) {
                EndStorageLink link = ( (RefFeaturedExtension) elementAtEnd ).get___AssociationLink( end.refMofId( ) );
                if ( link != null ) {
                    return Collections.singletonList( link );
                }
                return null;
            }
            return ( (RefFeaturedExtension) elementAtEnd ).get___AssociationLinks( end.refMofId( ) );
        }
        Attribute attribute = (Attribute) metaObject;
        return ( (RefFeaturedExtension) elementAtEnd ).get___AttributeLinks( attribute.refMofId( ) );
    }

    public final boolean isAssociationLinkExisting( CoreConnection connection, EndStorageLink link ) {

        RefFeaturedExtension elementWhereLinkIsStored = (RefFeaturedExtension) link.getStorageEnd( ).get( connection.getSession( ) );
        if ( link.getMetaObject( ) instanceof Association ) {
            AssociationEnd end = getWorkspace( ).getWorkspaceSet( ).getMoin( ).getJmiHelper( ).getAssociationEnds( connection.getSession( ), (Association) link.getMetaObject( ) ).get( link.getEndNumberOfOtherEnd( ) );
            if ( end.getMultiplicity( ).getUpper( ) == 1 ) {
                EndStorageLink existingLink = elementWhereLinkIsStored.get___AssociationLink( end.refMofId( ) );
                if ( link.equals( existingLink ) ) {
                    return true;
                }
            } else { // multiplicity n
                Collection<EndStorageLink> existingLinks = elementWhereLinkIsStored.get___AssociationLinks( end.refMofId( ) );
                if ( existingLinks != null && existingLinks.contains( link ) ) {
                    return true;
                }
            }
        } else {
            throw new MoinIllegalArgumentException( CoreLinksMessages.CALLISASSOCLINKEXISTINGONNONASSOCLINK );
        }
        return false;
    }

    private void loadLink( CoreSession session, EndStorageLink link, CorePartitionable elementAtStorageEnd ) {

        this.injectLink( session, link, Workspace.LINK_NOT_ADDED_AT_INDEX, false /* linkWasAdded */, elementAtStorageEnd );
    }

    private EndAndMetaObject injectLink( CoreSession session, EndStorageLink link, int index, boolean linkWasAdded, CorePartitionable elementAtStorageEnd ) {

        EndAndMetaObject endAndMetaObject = getEndAndMetaObjectForLink( link );
        String attributeOrAssociationEndMofId = null;
        if ( link.getMetaObject( ) instanceof Association ) {
            AssociationExtent extent = (AssociationExtent) getWorkspace( ).getWorkspaceSet( ).getMoin( ).getJmiHelper( ).getRefAssociationForAssociation( session, (Association) link.getMetaObject( ) );
            AssociationEnd end = extent.get___AssociationEnds( ).get( link.getEndNumberOfOtherEnd( ) );
            attributeOrAssociationEndMofId = end.refMofId( );
        } else {
            attributeOrAssociationEndMofId = endAndMetaObject.getMetaObjectMofId( );
        }
        injectLink( session, link, attributeOrAssociationEndMofId, index, linkWasAdded, elementAtStorageEnd );
        return endAndMetaObject;
    }

    public final void addLink( CoreConnection connection, String attributeOrAssociationEndMofId, EndStorageLink link, int index ) {

        CoreSession session = connection.getSession( );
        injectLink( session, link, attributeOrAssociationEndMofId, index, true /* linkWasAdded */, link.getStorageEnd( ).get( connection.getSession( ) ) );
        EndAndMetaObject endAndMetaObject = link.getStorageEnd( ).get( session ).get___Workspace( ).getWorkspaceSet( ).getEndAndMetaObjectPool( ).getEndAndMetaObject( link.getEndNumberOfStorageEnd( ), link.getMetaObject( ) );
        updateJmiListIfNecessary( session, link.getStorageEnd( ), endAndMetaObject );
        session.getWorkspace( ).getQueryLinkManager( ).updateCaches( link.getOtherEnd( ).getLri( ), endAndMetaObject, null );
    }

    private void injectLink( CoreSession session, EndStorageLink link, String attributeOrAssociationEndMofId, int index, boolean linkWasAdded, CorePartitionable elementAtStorageEnd ) {

        RefFeaturedExtension featured = (RefFeaturedExtension) elementAtStorageEnd;
        RefObject metaObject = link.getMetaObject( );
        int endNumberOfFeaturedEnd = link.getEndNumberOfStorageEnd( );
        boolean linkAddedToOverflowContainer = false;
        if ( link.getUpperBound( session, link.getEndNumberOfOtherEnd( ) ) == 1 ) {
            // multiplicity one
            if ( metaObject instanceof Association ) {
                if ( featured.get___AssociationLink( attributeOrAssociationEndMofId ) != null ) {
                    // Attempt to set a second link violating the upper bound of 1 => store link in overflow container
                    // and leave currently set link untouched.
                    OverflowContainer overflowContainer = featured.get___Partition( ).getOverflowContainer( );
                    if ( linkWasAdded ) {
                        // The link has been added by a MicroTransaction, and will be removed again in its post processing phase.
                        overflowContainer.add( link );
                        linkAddedToOverflowContainer = true;
                    } else {
                        throw new MoinIllegalStateException( CoreLinksMessages.LOADSECONDLINKFORSINGLEASSOC );
                    }
                } else {
                    featured.set___AssociationLink( attributeOrAssociationEndMofId, link );
                }
            } else { // Attribute
                // Object-valued attributes can be non-unique => we must make sure that adding the same link twice is possible
                // and that the second link does not end up in the overflow container!
                EndStorageLink existingLink = featured.get___AttributeLink( attributeOrAssociationEndMofId );
                if ( existingLink != null && !existingLink.logicalEquals( link ) ) {
                    // Attempt to set a second link violating the upper bound of 1 => store link in overflow container
                    // and leave currently set link untouched.
                    OverflowContainer overflowContainer = featured.get___Partition( ).getOverflowContainer( );
                    if ( linkWasAdded ) {
                        // The link has been added by a MicroTransaction, and will be removed again in its post processing phase.
                        overflowContainer.add( link );
                        linkAddedToOverflowContainer = true;
                    } else {
                        throw new MoinIllegalStateException( CoreLinksMessages.LOADSECONDLINKFORSINGLEATTR );
                    }
                } else {
                    featured.set___AttributeLink( attributeOrAssociationEndMofId, link );
                }
            }
        } else {
            // multiplicity many
            boolean ordered = ( link.getOrderedEnd( ) > -1 ) && ( link.getOrderedEnd( ) != endNumberOfFeaturedEnd );
            boolean isAssociation = ( metaObject instanceof Association );
            Collection<EndStorageLink> links;
            if ( isAssociation ) {
                links = featured.get___AssociationLinks( attributeOrAssociationEndMofId );
            } else { // attribute link
                links = featured.get___AttributeLinks( attributeOrAssociationEndMofId );
            }
            if ( links == null ) {
                if ( ordered ) {
                    // use implementation which considers ordering
                    links = new ArrayList<EndStorageLink>( );
                } else {
                    // use implementation which ignores ordering criterion, but keeps
                    // the sorting of elements stable
                    links = new TreeSet<EndStorageLink>( MOF_ID_OF_OTHER_LINK_END_COMPARATOR );
                }
                if ( isAssociation ) {
                    featured.set___AssociationLinks( links, attributeOrAssociationEndMofId );
                } else { // attribute link
                    featured.set___AttributeLinks( links, attributeOrAssociationEndMofId );
                }
            }
            if ( ordered ) {
                if ( index != Workspace.LINK_NOT_ADDED_AT_INDEX ) {
                    // insert the link at the specified index
                    ( (List<EndStorageLink>) links ).add( index, link );
                } else {
                    links.add( link );
                }
            } else {
                links.add( link );
            }
        }
        if ( link.getCompositeEnd( ) != -1 && !linkAddedToOverflowContainer ) {
            // A composite link was added => we need to update the __compositeParentLink field if the element at the
            // component end is loaded.
            CorePartitionable componentElement = getElementInMemory( session, link.getEnd( link.getComponentEnd( ) ) );
            if ( componentElement != null ) {
                boolean applyRules = true;
                if ( !linkWasAdded && elementAtStorageEnd == componentElement ) {
                    applyRules = false;
                }
                if ( applyRules ) {
                    CorePartitionable compositeElement = getElementInMemory( session, link.getEnd( link.getCompositeEnd( ) ) );
                    if ( compositeElement != null ) {
                        boolean allowed = true;
                        if ( session != null ) {
                            MRI compositeMri = compositeElement.get___Mri( );
                            List<DuplicateElementConsistencyViolation> violations = session.getConsistencyViolationRegistry( ).checkRegisteredDuplicateElement( compositeMri.getLri( ) );
                            if ( violations != null ) {
                                if ( !violations.get( 0 ).getUsedElementsMri( ).equals( compositeMri ) ) {
                                    allowed = false;
                                }
                            }
                        }
                        if ( allowed && RefObjectImpl.isCachingOfCompositeParentLinkAllowed( compositeElement, componentElement ) ) {
                            ( (RefObjectExtension) componentElement ).set___CompositeParentLink( link );
                        }
                    }
                } else {
                    ( (RefObjectExtension) componentElement ).set___CompositeParentLink( link );
                }
            }
        }
        featured.get___Partition( ).getDistributedLinkContainer( ).addLink( link.getOtherEnd( ).getLri( ), link );
    }

    private CorePartitionable getElementInMemory( CoreSession session, MoinReference reference ) {

        if ( reference.isCached( ) ) {
            return reference.get( null /* session */);
        }
        return getWorkspace( ).getWorkspaceSet( ).resolveLriInMemory( session, reference.getLri( ) );
    }

    public final void removeLinkOnRevert( CoreConnection connection, String attributeOrAssociationEndMofId, EndStorageLink link ) {

        removeLink( connection, attributeOrAssociationEndMofId, link, null /* iterator */, true /* onRevert */);
    }

    public final void removeLink( CoreConnection connection, String attributeOrAssociationEndMofId, EndStorageLink link, IteratorKnowingCollection<EndStorageLink> iterator ) {

        removeLink( connection, attributeOrAssociationEndMofId, link, iterator, false /* onRevert */);
    }

    private void removeLink( CoreConnection connection, String attributeOrAssociationEndMofId, EndStorageLink link, IteratorKnowingCollection<EndStorageLink> iterator, boolean onRevert ) {

        RefFeaturedExtension featured = (RefFeaturedExtension) link.getStorageEnd( ).get( connection.getSession( ) );
        RefObject metaObject = link.getMetaObject( );
        if ( link.getUpperBound( connection.getSession( ), link.getEndNumberOfOtherEnd( ) ) == 1 ) {
            // multiplicity one
            if ( metaObject instanceof Association ) {
                if ( onRevert ) {
                    // Clear the overflow structure.
                    featured.get___Partition( ).getOverflowContainer( ).remove( link );
                    if ( link.equals( featured.get___AssociationLink( attributeOrAssociationEndMofId ) ) ) {
                        featured.set___AssociationLink( attributeOrAssociationEndMofId, null /* link */);
                    }
                } else {
                    featured.set___AssociationLink( attributeOrAssociationEndMofId, null /* link */);
                    // The following call is necessary because in spite of multiplicity-one, a JmiList can exist (reason: refQuery()).
                    notifyOnLastLinkRemoved( getEndAndMetaObjectForLink( link ), featured, true /* wasLastForEndAndMetaObject */);
                }
            } else {
                if ( onRevert ) {
                    // Clear the overflow structure.
                    featured.get___Partition( ).getOverflowContainer( ).remove( link );
                    if ( link.equals( featured.get___AttributeLink( attributeOrAssociationEndMofId ) ) ) {
                        featured.set___AttributeLink( attributeOrAssociationEndMofId, null /* link */);
                    }
                } else {
                    featured.set___AttributeLink( attributeOrAssociationEndMofId, null /* link */);
                }
            }
        } else {
            // multiplicity many
            if ( metaObject instanceof Association ) {
                Collection<EndStorageLink> links = featured.get___AssociationLinks( attributeOrAssociationEndMofId );
                if ( links != null ) {
                    if ( iterator != null ) {
                        iterator.remove( );
                    } else {
                        links.remove( link );
                    }
                    if ( links.isEmpty( ) ) {
                        featured.set___AssociationLinks( null, attributeOrAssociationEndMofId );
                        notifyOnLastLinkRemoved( getEndAndMetaObjectForLink( link ), featured, true /* wasLastForEndAndMetaObject */);
                    }
                }
            } else {
                Collection<EndStorageLink> links = featured.get___AttributeLinks( attributeOrAssociationEndMofId );
                if ( links != null ) {
                    if ( iterator != null ) {
                        iterator.remove( );
                    } else {
                        links.remove( link );
                    }
                    if ( links.isEmpty( ) ) {
                        featured.set___AttributeLinks( null, attributeOrAssociationEndMofId );
                        notifyOnLastLinkRemoved( getEndAndMetaObjectForLink( link ), featured, true /* wasLastForEndAndMetaObject */);
                    }
                }
            }
        }
        if ( link.getCompositeEnd( ) != -1 ) {
            // A composite link was remove => we need to clear the __compositeParentLink field if the element at the
            // component end is loaded.
            MoinReference reference = link.getEnd( link.getComponentEnd( ) );
            if ( reference.isCached( ) ) {
                if ( onRevert ) {
                    ( (RefObjectExtension) reference.get( connection.getSession( ) ) ).reset___CompositeParentLink( );
                } else {
                    CorePartitionable componentElement = reference.get( connection.getSession( ) );
                    CorePartitionable compositeElement = getElementInMemory( connection.getSession( ), link.getEnd( link.getCompositeEnd( ) ) );
                    if ( compositeElement != null && RefObjectImpl.isCachingOfCompositeParentLinkAllowed( compositeElement, componentElement ) ) {
                        ( (RefObjectExtension) componentElement ).set___CompositeParentLink( null );
                    }
                }
            } else {
                // Might be not cached due to duplicate element inconsistency. Both composite and component can be duplicates. 
                // In case of duplicate components, the composite parent link must be updated for all duplicate components.
                // If the composite parent is a duplicate, the composite parent link of the components must be set to "not yet resolved"
                // since only one of the composite parents is deleted and there is still another one. Setting the composite parent link
                // to 'null' would be wrong in this case!
                Collection<CorePartitionable> elements = getWorkspace( ).getWorkspaceSet( ).resolveLriInMemoryIncludingInconsistencies( connection.getSession( ), reference.getLri( ) );
                for ( CorePartitionable element : elements ) {
                    RefObjectExtension refObject = ( (RefObjectExtension) element );
                    EndStorageLink compositeParentLink = refObject.get___CompositeParentLink( );
                    if ( compositeParentLink != null && compositeParentLink != RefObjectImpl.NOT_YET_RETRIEVED ) {
                        if ( link.equals( compositeParentLink ) ) {
                            if ( connection.getSession( ).getConsistencyViolationRegistry( ).checkRegisteredDuplicateElement( featured.get___Mri( ).getLri( ) ) == null ) {
                                // TODO Check if the composite parent link is allowed to be changed via cachingOfCompositeParentLinkAllowed()
                                if ( onRevert ) {
                                    refObject.reset___CompositeParentLink( );
                                } else {
                                    refObject.set___CompositeParentLink( null );
                                }
                            } else {
                                refObject.reset___CompositeParentLink( );
                            }
                        }
                    }
                }
            }
        }
        featured.get___Partition( ).getDistributedLinkContainer( ).removeLink( link.getOtherEnd( ).getLri( ), link );
        connection.getSession( ).getWorkspace( ).getQueryLinkManager( ).updateCaches( link.getOtherEnd( ).getLri( ), getEndAndMetaObjectForLink( link ), iterator );
    }

    @SuppressWarnings( "unchecked" )
    private void updateJmiListIfNecessary( CoreSession session, MriReference fromEnd, EndAndMetaObject endAndMetaObject ) {

        // The following is done in order to set the link collection of a JmiList.
        // There are two cases:
        // 1) The link collection is already there when the JmiList is created -> then it will be set after the creation
        // of the JmiList (see createJmiList()) and not here.
        // 2) The JmiList is created before the link collection exists (and is then used to add links) -> then the link
        // collection has to be set afterwards, which is done here.
        MRI fromEndMri = fromEnd.getMri( );
        if ( fromEndMri != null ) {
            CorePartitionable element = fromEnd.get( session );
            JmiList list = element.get___Partition( ).getJmiListContainer( ).findJmiList( endAndMetaObject, fromEndMri.getLri( ) );
            if ( list != null && list.getLinkCollection( ) == null ) {
                // There is a JmiList, but the link collection is not yet set. As we have just added a link, such a link
                // collection should exist now, therefore we have to set it.
                list.setLinkCollection( getLinkCollectionForEndAndMetaObject( session, endAndMetaObject, element ) );
            }
        }
    }

    @SuppressWarnings( "unchecked" )
    private JmiList createJmiList( CoreSession session, EndAndMetaObject endAndMetaObject, MriReference fromEnd ) {

        JmiList result = new JmiListImpl( session, endAndMetaObject, fromEnd, this.getWorkspace( ) );
        CorePartitionable element = fromEnd.get( session );
        Collection<EndStorageLink> backingCollection = getLinkCollectionForEndAndMetaObject( session, endAndMetaObject, element );
        result.setLinkCollection( backingCollection );
        return result;
    }

    @SuppressWarnings( "unchecked" )
    @Override
    protected final JmiList getOrCreateJmiList( CoreSession session, EndAndMetaObject endAndMetaObject, CorePartitionable fromEnd ) {

        JmiListContainer jmiListContainer = fromEnd.get___Partition( ).getJmiListContainer( );
        JmiList result = jmiListContainer.findJmiList( endAndMetaObject, fromEnd.get___Mri( ).getLri( ) );
        if ( result == null ) {
            MriReference fromEndReference = createMriReference( fromEnd );
            result = this.createJmiList( session, endAndMetaObject, fromEndReference );
            jmiListContainer.registerJmiList( endAndMetaObject, fromEnd.get___Mri( ).getLri( ), result );
        }
        return result;
    }

    @Override
    protected final EndStorageLink getSingleLinkForEndAndMetaObject( CoreSession session, EndAndMetaObject endAndMetaObject, CorePartitionable elementAtEnd ) {

        CorePartitionable metaObject = endAndMetaObject.getMetaObject( getWorkspace( ).getWorkspaceSet( ).getMoin( ) ).get( session );
        if ( metaObject instanceof Association ) {
            AssociationEnd end = getWorkspace( ).getWorkspaceSet( ).getMoin( ).getJmiHelper( ).getAssociationEnds( session, (Association) metaObject ).get( endAndMetaObject.getToEnd( ) );
            return ( (RefFeaturedExtension) elementAtEnd ).get___AssociationLink( end.refMofId( ) );
        }
        return ( (RefFeaturedExtension) elementAtEnd ).get___AttributeLink( metaObject.refMofId( ) );
    }

    public final void evictLinksAndInvalidateJmiLists( CoreModelPartition partition ) {

        evictLinksStoredInPartition( partition );
        partition.getJmiListContainer( ).invalidateJmiLists( );
    }

    public void evictLinksStoredInPartition( CoreModelPartition partition ) {

        partition.evictLinks( );
    }

    /**
     * This method is to be called by the {@link #linkContainer} when the last
     * link for the specified MRI was removed. The boolean parameter tells if
     * that was even the last entry for the specified {@link EndAndMetaObject}.
     * 
     * @param endAndMetaObject the corresponding end and meta object of the last
     * link which was removed.
     * @param mriAtEnd the MRI of the element at the end specified in the
     * endAndMetaObject.
     * @param wasLastForEndAndMetaObject <code>true</code> if it was the last
     * link for the specified endAndMetaObject
     */
    @SuppressWarnings( "unchecked" )
    public final void notifyOnLastLinkRemoved( EndAndMetaObject endAndMetaObject, CorePartitionable featured, boolean wasLastForEndAndMetaObject ) {

        JmiList jmiList = featured.get___Partition( ).getJmiListContainer( ).findJmiList( endAndMetaObject, featured.get___Mri( ).getLri( ) );
        if ( jmiList != null ) {
            jmiList.setLinkCollection( null );
        }
    }

    public final Collection<EndStorageLink> getDistributedEndStorageLinksForEndAndMetaObject( CoreConnection connection, String metaObjectMofId, CorePartitionable element, Set<PRI> scope ) {

        List<EndStorageLink> result = null;

        // The element's partition has to be considered.
        CoreModelPartition mp = element.get___Partition( );
        if ( mp.isExtentPartition( ) || ( !mp.getPri( ).isVolatilePartition( ) && !mp.isDirty( ) ) ) {
            // The element's partition has to be considered.
            if ( !scope.contains( mp.getPri( ) ) ) {
                result = mergeDistributedEndStorageLinksInPartition( mp, metaObjectMofId, element, result );
            }
        }

        // Dirty partitions have to be considered.
        for ( CoreModelPartition partition : connection.getDirtyPartitionsWithoutNullPartition( ) ) {
            if ( !scope.contains( partition.getPri( ) ) ) {
                result = mergeDistributedEndStorageLinksInPartition( partition, metaObjectMofId, element, result );
            }
        }

        // Transient partitions have to be considered as they are never persisted.
        for ( CoreModelPartition partition : connection.getTransientPartitionsInternal( ) ) {
            if ( !scope.contains( partition.getPri( ) ) ) {
                result = mergeDistributedEndStorageLinksInPartition( partition, metaObjectMofId, element, result );
            }
        }

        // The null-partition has to be considered as it is not persisted.
        CoreModelPartition nullPartition = connection.getNullPartition( );
        if ( !scope.contains( nullPartition.getPri( ) ) ) {
            result = mergeDistributedEndStorageLinksInPartition( connection.getNullPartition( ), metaObjectMofId, element, result );
        }

        for ( PRI pri : scope ) {
            CoreModelPartition partition = getWorkspace( ).getPartitionManager( ).getPartition( connection.getSession( ), pri, false /* loadIfMissing */);
            if ( partition != null ) {
                result = mergeDistributedEndStorageLinksInPartition( partition, metaObjectMofId, element, result );
            }
        }

        if ( result == null ) {
            result = Collections.emptyList( );
        }
        return result;
    }

    private List<EndStorageLink> mergeDistributedEndStorageLinksInPartition( CoreModelPartition partition, String metaObjectMofId, CorePartitionable element, List<EndStorageLink> previousResult ) {

        // TODO Do we need to check whether the partition is alive?
        List<EndStorageLink> result = previousResult;
        List<EndStorageLink> distributedLinksForMetaObject = partition.getDistributedLinkContainer( ).getLinksForMetaObject( metaObjectMofId, element );
        if ( distributedLinksForMetaObject != null ) {
            if ( result == null ) {
                result = new ArrayList<EndStorageLink>( 4 );
            }
            for ( int i = 0, n = distributedLinksForMetaObject.size( ); i < n; i++ ) {
                result.add( distributedLinksForMetaObject.get( i ) );
            }
        }
        return result;
    }

    protected final EndAndMetaObject getEndAndMetaObjectForLink( EndStorageLink link ) {

        return this.getWorkspace( ).getWorkspaceSet( ).getEndAndMetaObjectPool( ).getEndAndMetaObject( link.getEndNumberOfStorageEnd( ), link.getMetaObject( ) );
    }

    public final void loadLink( SpiSession session, LRI elementAtEnd0, SpiPartitionable elementAtEnd1, Association association ) {

        CoreSession coreSession = (CoreSession) session;
        EndStorageLink link = getLinkFactory( ).createEndStorageLink( coreSession, (byte) 1, association, createCachedMriReference( (CorePartitionable) elementAtEnd1 ), createMoinReferenceForOtherEnd( elementAtEnd0 ) );
        loadLink( coreSession, link, (CorePartitionable) elementAtEnd1 );
    }

    public final void loadLink( SpiSession session, LRI elementAtEnd0, SpiPartitionable elementAtEnd1, Attribute attribute ) {

        CoreSession coreSession = (CoreSession) session;
        EndStorageLink link = getLinkFactory( ).createEndStorageLink( coreSession, (byte) 1, attribute, createCachedMriReference( (CorePartitionable) elementAtEnd1 ), createMoinReferenceForOtherEnd( elementAtEnd0 ) );
        loadLink( coreSession, link, (CorePartitionable) elementAtEnd1 );
    }

    public final void loadLink( SpiSession session, SpiPartitionable elementAtEnd0, LRI elementAtEnd1, Association association ) {

        CoreSession coreSession = (CoreSession) session;
        EndStorageLink link = getLinkFactory( ).createEndStorageLink( coreSession, (byte) 0, association, createCachedMriReference( (CorePartitionable) elementAtEnd0 ), createMoinReferenceForOtherEnd( elementAtEnd1 ) );
        loadLink( coreSession, link, (CorePartitionable) elementAtEnd0 );
    }

    public final EndStorageLink createLink( CoreSession session, byte storageEnd, CorePartitionable elementAtStoredEnd, LRI lri, Association association ) {


        return getLinkFactory( ).createEndStorageLink( session, storageEnd, association, createCachedMriReference( elementAtStoredEnd ), createMoinReferenceForOtherEnd( lri ) );
    }

    public final void loadLink( SpiSession session, SpiPartitionable elementAtEnd0, LRI elementAtEnd1, Attribute attribute ) {

        CoreSession coreSession = (CoreSession) session;
        EndStorageLink link = getLinkFactory( ).createEndStorageLink( coreSession, (byte) 0, attribute, createCachedMriReference( (CorePartitionable) elementAtEnd0 ), createMoinReferenceForOtherEnd( elementAtEnd1 ) );
        loadLink( coreSession, link, (CorePartitionable) elementAtEnd0 );
    }

    private final void loadLink( SpiSession session, SpiPartitionable elementAtEnd0, SpiPartitionable elementAtEnd1, Association association, byte storageEndNumber ) {

        CoreSession coreSession = (CoreSession) session;
        CorePartitionable storageEnd = null;
        CorePartitionable otherEnd = null;
        if ( storageEndNumber == 0 ) {
            storageEnd = (CorePartitionable) elementAtEnd0;
            otherEnd = (CorePartitionable) elementAtEnd1;
        } else {
            storageEnd = (CorePartitionable) elementAtEnd1;
            otherEnd = (CorePartitionable) elementAtEnd0;
        }
        EndStorageLink link = getLinkFactory( ).createEndStorageLink( coreSession, storageEndNumber, association, createCachedMriReference( storageEnd ), createMoinReferenceForOtherEnd( storageEnd.get___Mri( ).getPri( ), otherEnd ) );
        loadLink( coreSession, link, storageEnd );
    }

    private final void loadLink( SpiSession session, SpiPartitionable elementAtEnd0, SpiPartitionable elementAtEnd1, Attribute attribute, byte storageEndNumber ) {

        CoreSession coreSession = (CoreSession) session;
        CorePartitionable storageEnd = null;
        CorePartitionable otherEnd = null;
        if ( storageEndNumber == 0 ) {
            storageEnd = (CorePartitionable) elementAtEnd0;
            otherEnd = (CorePartitionable) elementAtEnd1;
        } else {
            storageEnd = (CorePartitionable) elementAtEnd1;
            otherEnd = (CorePartitionable) elementAtEnd0;
        }
        EndStorageLink link = getLinkFactory( ).createEndStorageLink( coreSession, storageEndNumber, attribute, createCachedMriReference( storageEnd ), createMoinReferenceForOtherEnd( storageEnd.get___Mri( ).getPri( ), otherEnd ) );
        loadLink( coreSession, link, storageEnd );
    }

    public final void loadLink( SpiSession session, SpiPartitionable elementAtEnd0, SpiPartitionable elementAtEnd1, Association assocation ) {

        byte storedEnd = this.getWorkspace( ).getWorkspaceSet( ).getMoin( ).getJmiHelper( ).getStoredEnd( session, assocation );
        this.loadLogicalLink( session, elementAtEnd0, elementAtEnd1, assocation, storedEnd );
    }

    // Special method required by OCL, which loads links twice !!!
    // This methods makes sure that in the meultiplicity-one case, the previous links gets removed first.
    public final void replaceLogicalLinkMultiplicityOne( CoreConnection connection, CorePartitionable elementAtEnd0, CorePartitionable elementAtEnd1, Association assocation ) {

        byte storedEnd = jmiHelper.getStoredEnd( connection.getSession( ), assocation );
        List<AssociationEnd> ends = jmiHelper.getAssociationEnds( connection.getSession( ), assocation );
        if ( storedEnd == SpiJmiHelper.STORED_END_0 ) {
            AssociationEnd end = ends.get( 1 );
            assertMultiplicityOne( end );
            ( (RefFeaturedExtension) elementAtEnd0 ).set___AssociationLink( end.refMofId( ), null /* value */);
        } else {
            AssociationEnd end = ends.get( 0 );
            assertMultiplicityOne( end );
            ( (RefFeaturedExtension) elementAtEnd1 ).set___AssociationLink( end.refMofId( ), null /* value */);
        }
        loadLink( connection.getSession( ), elementAtEnd0, elementAtEnd1, assocation );
    }

    private void assertMultiplicityOne( AssociationEnd end ) {

        if ( end.getMultiplicity( ).getUpper( ) != 1 ) {
            throw new MoinIllegalArgumentException( CoreLinksMessages.REPLACELOGICALLINKMULTONEWITHMULTASSOCEND );
        }
    }

    public final int getNumberOfElementsForEndAndMetaObjectIncludingOverflows( CoreSession session, EndAndMetaObject endAndMetaObject, CorePartitionable elementAtEnd ) {

        int result = 0;
        if ( endAndMetaObject.isToEndMultiplicityOne( session, getWorkspace( ).getWorkspaceSet( ) ) ) {
            EndStorageLink endStorageLink = getSingleLinkForEndAndMetaObject( session, endAndMetaObject, elementAtEnd );
            if ( endStorageLink != null ) {
                result++;
                OverflowContainer overflowContainer = elementAtEnd.get___Partition( ).getOverflowContainer( );
                Collection<EndStorageLink> overflowLinks = overflowContainer.getOverflowLinks( elementAtEnd.get___Mri( ).getLri( ), endAndMetaObject );
                result += overflowLinks.size( );
            }
        } else {
            result = getLinksForEndAndMetaObject( session, endAndMetaObject, elementAtEnd ).size( );
        }
        return result;
    }

    private void loadLogicalLink( SpiSession session, SpiPartitionable elementAtEnd0, SpiPartitionable elementAtEnd1, Association assocation, byte storedEnd ) {

        this.loadLink( session, elementAtEnd0, elementAtEnd1, assocation, storedEnd );
    }

    public final void loadLink( SpiSession session, SpiPartitionable elementAtEnd0, SpiPartitionable elementAtEnd1, Attribute attribute ) {

        this.loadLink( session, elementAtEnd0, elementAtEnd1, attribute, (byte) 0 );
    }

    private EndStorageLinkFactory getLinkFactory( ) {

        return this.getWorkspace( ).getWorkspaceSet( ).getLinkFactory( );
    }
}
