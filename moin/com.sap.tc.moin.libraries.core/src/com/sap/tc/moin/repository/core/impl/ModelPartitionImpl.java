package com.sap.tc.moin.repository.core.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.InvalidResourceIdentifierException;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.DistributedLinkContainer;
import com.sap.tc.moin.repository.core.EndAndMetaObject;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.JmiListContainer;
import com.sap.tc.moin.repository.core.MemoryLinkManager;
import com.sap.tc.moin.repository.core.MoinReference;
import com.sap.tc.moin.repository.core.OverflowContainer;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.core.jmi.extension.RefFeaturedExtension;
import com.sap.tc.moin.repository.core.jmi.reflect.RefClassImpl;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinIllegalNullArgumentException;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor;
import com.sap.tc.moin.repository.messages.core.RepositoryCoreMessages;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.core.SpiLink;
import com.sap.tc.moin.repository.spi.core.SpiResourceInfo;
import com.sap.tc.moin.repository.spi.core.SpiStage;
import com.sap.tc.moin.repository.spi.ps.SpiAssociation;
import com.sap.tc.moin.repository.transactions.TransactionManager;
import com.sap.tc.moin.repository.transactions.microtransactionables.ElementAssignToPartitionMicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.MicroTransactionableFactory;
import com.sap.tc.moin.repository.transactions.microtransactionables.PartitionDeleteElementsMicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.PartitionDeleteMicroTransactionable;

public class ModelPartitionImpl implements CoreModelPartition {


    private static MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CORE, ModelPartitionImpl.class );

    /**
     * Holds the metadata about this model partition.
     */
    private SpiResourceInfo resourceInfo;

    /**
     * Holds the model elements that were explicitly assigned to this model
     * partition. The set keeps the order in which the elements are inserted.
     * This is important, e.g., to ensure that exporting a partition as an XMI
     * stream will produce streams with predictable model element ordering; in
     * particular, when reading a model partition from an XMI stream and
     * afterwards writing it out again shouldn't change the element order in the
     * stream.
     */
    private final Set<Partitionable> elements;

    /**
     * The workspace that is responsible for this model partition.
     */
    private Workspace responsibleWorkspace;

    /**
     * The dirty flag defaults to <code>false</code>.
     */
    private boolean dirty = false;

    /**
     * Indicates if partition has been deleted.
     */
    private boolean deleted = false;

    /**
     * Used to evaluate for Java identity
     */
    private CoreModelPartitionIdentity coreModelPartitionIdentity;

    private transient boolean persisted = false;

    private transient long persistedTimestamp = -1;

    /**
     * Timestamp used for partition eviction.
     */
    private transient long evictionTimestamp;

    /**
     * Manages all {@link EndStorageLink}s stored at elements in this partition,
     * keyed by the LRI of the element at the non-storage end (= otherEnd).
     */
    private DistributedLinkContainer distributedLinkContainer;

    /**
     * Manages all {@link JmiList}s of elements in this partition.
     */
    private JmiListContainer jmiListContainer;

    /**
     * Hosts links temporarily violating a multiplicity-one upper bound.
     */
    private OverflowContainer overflowContainer;

    private boolean errorsDuringLoad;

    private boolean unhandledErrorsDuringLoad;

    private Map<CRI, String> usedMetamodelsInPersistentState;

    private final byte[] prefixForSegmentedMofIds;

    /**
     * @param mri
     * @throws InvalidResourceIdentifierException
     */
    public ModelPartitionImpl( final PRI pri, final SpiStage stage, final Workspace workspace ) throws InvalidResourceIdentifierException {

        if ( workspace == null ) {
            throw new MoinIllegalNullArgumentException( "Workspace" ); //$NON-NLS-1$
        }
        this.resourceInfo = new ResourceInfoImpl( pri, stage );
        this.responsibleWorkspace = workspace;
        this.elements = new TreeSet<Partitionable>( this.responsibleWorkspace.getWorkspaceSet( ).getMoin( ).getByMofIdComparator( ) );
        this.evictionTimestamp = System.currentTimeMillis( );
        this.distributedLinkContainer = new DistributedLinkContainerImpl( );
        this.jmiListContainer = new JmiListContainerImpl( );
        this.overflowContainer = new OverflowContainerImpl( workspace.getWorkspaceSet( ).getEndAndMetaObjectPool( ) );
        this.errorsDuringLoad = false;
        this.unhandledErrorsDuringLoad = false;

        this.prefixForSegmentedMofIds = Utilities.getUtilities( ).calculatePrefixForSegmentedMofId( pri.getContainerName( ), pri.getPartitionName( ) );
    }

    /**
     * @see ModelPartition#getMri()
     */
    public PRI getPri( ) {

        return this.resourceInfo.getPri( );
    }

    public void setPersistedTimestamp( long value ) {

        this.persistedTimestamp = value;
    }

    public long getPersistedTimestamp( ) {

        return this.persistedTimestamp;
    }

    /**
     * Computes the set of model elements owned by this partition. This
     * collection cannot be modified.
     * <p>
     * The result is computed by adding all {@link #getRootElements root
     * elements} plus all direct and transitive composite children that are not
     * explicitly assigned to any other partition.
     * <p>
     * When recursively traversing into the children, references that point to
     * other partitions are not resolved if they haven't been resolved yet, as
     * the referenced model element doesn't belong to this partition. For the
     * other child elements, the algorithm checks if they are assigned as root
     * elements to any other partition.
     */
    public Set<Partitionable> getElements( ) {

        return Collections.unmodifiableSet( this.elements );
    }

    public Collection<SpiLink> getLinks( ) {

        return Collections.unmodifiableCollection( getLinksInternal( ) );
    }

    private Collection<? extends SpiLink> getLinksInternal( ) {

        Collection<SpiLink> result = new LinkedHashSet<SpiLink>( );
        for ( Partitionable element : this.elements ) {
            List<EndStorageLink> links = ( (RefFeaturedExtension) element ).get___AllStoredLinks( );
            if ( links != null ) {
                for ( int i = 0, n = links.size( ); i < n; i++ ) {
                    result.add( links.get( i ) );
                }
            }
        }
        return result;
    }

    private List<EndStorageLink> getAssociationLinksInternal( ) {

        List<EndStorageLink> result = null;
        for ( Partitionable element : this.elements ) {
            List<EndStorageLink> links = ( (RefFeaturedExtension) element ).get___AllStoredAssociationLinks( );
            if ( links != null ) {
                if ( result == null ) {
                    result = new ArrayList<EndStorageLink>( );
                }
                for ( int i = 0, n = links.size( ); i < n; i++ ) {
                    result.add( links.get( i ) );
                }
            }
        }
        if ( result != null ) {
            return result;
        }
        return Collections.emptyList( );
    }

    @SuppressWarnings( "unchecked" )
    public Map<Association, List<EndStorageLink>> getAssociationLinksGroupedByMetaObject( CoreSession session ) {

        WorkspaceSet workspaceSet = getWorkspace( ).getWorkspaceSet( );
        Map<EndAndMetaObject, Set<CorePartitionable>> endAndMetaObject2Elements = new TreeMap<EndAndMetaObject, Set<CorePartitionable>>( );
        MemoryLinkManager memoryLinkManager = this.getWorkspace( ).getMemoryLinkManager( );
        Comparator mofIdComparator = this.getWorkspace( ).getWorkspaceSet( ).getMoin( ).getByMofIdComparator( );
        List<EndStorageLink> associationLinksStoredInPartition = getAssociationLinksInternal( );
        for ( int i = 0, n = associationLinksStoredInPartition.size( ); i < n; i++ ) {
            EndStorageLink endStorageLink = associationLinksStoredInPartition.get( i );
            int endNumberOfStorageEnd = endStorageLink.getEndNumberOfStorageEnd( );
            CorePartitionable element = endStorageLink.getEnd( endNumberOfStorageEnd ).get( session );
            EndAndMetaObject endAndMetaObject = getWorkspace( ).getWorkspaceSet( ).getEndAndMetaObjectPool( ).getEndAndMetaObject( endNumberOfStorageEnd, endStorageLink.getMetaObject( ) );
            Set<CorePartitionable> elementsPerEndAndMetaObject = endAndMetaObject2Elements.get( endAndMetaObject );
            if ( elementsPerEndAndMetaObject == null ) {
                elementsPerEndAndMetaObject = new TreeSet<CorePartitionable>( mofIdComparator );
                endAndMetaObject2Elements.put( endAndMetaObject, elementsPerEndAndMetaObject );
            }
            elementsPerEndAndMetaObject.add( element );
        }
        Map<Association, List<EndStorageLink>> result = new TreeMap<Association, List<EndStorageLink>>( mofIdComparator );
        Set<Entry<EndAndMetaObject, Set<CorePartitionable>>> endAndMetaObject2ElementsEntrySet = endAndMetaObject2Elements.entrySet( );
        for ( Entry<EndAndMetaObject, Set<CorePartitionable>> entry : endAndMetaObject2ElementsEntrySet ) {
            EndAndMetaObject endAndMetaObject = entry.getKey( );
            Association metaObject = (Association) endAndMetaObject.getMetaObject( workspaceSet.getMoin( ) ).get( session );
            Set<CorePartitionable> elementsAtStorageEnd = entry.getValue( );
            for ( CorePartitionable elementAtStorageEnd : elementsAtStorageEnd ) {
                Collection<EndStorageLink> linksForEndAndMetaObject = memoryLinkManager.getLinksForEndAndMetaObject( session, endAndMetaObject, elementAtStorageEnd );
                List<EndStorageLink> links = result.get( metaObject );
                if ( links == null ) {
                    result.put( metaObject, links = new ArrayList<EndStorageLink>( linksForEndAndMetaObject.size( ) ) );
                }
                links.addAll( linksForEndAndMetaObject );
            }
        }
        return result;
    }

    @SuppressWarnings( "unchecked" )
    public Map<SpiAssociation, List<com.sap.tc.moin.repository.spi.ps.serializer.SpiLink>> getAssociationLinksStable( CoreSession session ) {

        List<EndStorageLink> associationLinksStoredInPartition = getAssociationLinksInternal( );
        if ( !associationLinksStoredInPartition.isEmpty( ) ) {
            Comparator mofIdComparator = this.getWorkspace( ).getWorkspaceSet( ).getMoin( ).getByMofIdComparator( );
            Map<SpiAssociation, List<com.sap.tc.moin.repository.spi.ps.serializer.SpiLink>> result = new TreeMap<SpiAssociation, List<com.sap.tc.moin.repository.spi.ps.serializer.SpiLink>>( mofIdComparator );
            SpiJmiHelper jmiHelper = session.getMoin( ).getJmiHelper( );
            for ( int i = 0, n = associationLinksStoredInPartition.size( ); i < n; i++ ) {
                EndStorageLink endStorageLink = associationLinksStoredInPartition.get( i );
                SpiAssociation spiAssociation = (SpiAssociation) jmiHelper.getRefAssociationForAssociation( session, (Association) endStorageLink.getMetaObject( ) );
                List<com.sap.tc.moin.repository.spi.ps.serializer.SpiLink> links = result.get( spiAssociation );
                if ( links == null ) {
                    result.put( spiAssociation, links = new ArrayList<com.sap.tc.moin.repository.spi.ps.serializer.SpiLink>( ) );
                }
                links.add( (com.sap.tc.moin.repository.spi.ps.serializer.SpiLink) endStorageLink );
            }
            return result;
        }
        return Collections.emptyMap( );
    }

    public Set<CorePartitionable> getComponentChildrenInThisPartition( CoreSession session, CorePartitionable parentElement ) {

        if ( parentElement == null ) {
            throw new MoinIllegalArgumentException( RepositoryCoreMessages.MOIN_REPOSITORY_CORE_2008 );
        }

        Set<CorePartitionable> result = new LinkedHashSet<CorePartitionable>( );
        /*
         * TODO: Remove "if (me instanceof RefObject) {" as soon as we have the
         * Reference, which can handle types other than MofClass (also extents)
         * d024227
         */
        if ( parentElement instanceof RefObject ) {

            Collection<EndStorageLink> linksToChildren = this.getWorkspace( ).getWorkspaceSet( ).getLogicalLinkManager( ).getComponentChildrenLinks( session, parentElement );
            for ( Iterator<EndStorageLink> i = linksToChildren.iterator( ); i.hasNext( ); ) {
                EndStorageLink linkToChild = i.next( );
                MoinReference refToChild = linkToChild.getEnd( linkToChild.getComponentEnd( ) );
                PRI childPri = refToChild.getPri( session );
                if ( childPri.equals( getPri( ) ) ) {
                    CorePartitionable child = refToChild.get( session );
                    result.add( child );
                    result.addAll( getComponentChildrenInThisPartition( session, child ) );
                }
            }
        }
        return result;
    }


    @Deprecated
    public void assignElement( Partitionable element ) {

        this.assignElement( (CoreConnection) element.get___Connection( ), element, false );
    }

    public void assignElement( CoreConnection connection, Partitionable element ) {

        this.assignElement( connection, element, false );
    }

    @Deprecated
    public void assignElementIncludingChildren( Partitionable element ) {

        this.assignElement( (CoreConnection) element.get___Connection( ), element, true );
    }

    public void assignElementIncludingChildren( CoreConnection connection, Partitionable element ) {

        this.assignElement( connection, element, true );
    }

    private void assignElement( CoreConnection connection, Partitionable element, boolean includeChildren ) {

        MicroTransactionableFactory microTxFactory = this.getWorkspace( ).getWorkspaceSet( ).getMoin( ).getMicroTransactionableFactory( );
        TransactionManager transactionManager = connection.getSession( ).getTransactionManager( );
        ElementAssignToPartitionMicroTransactionable transactionable = microTxFactory.createElementAssignToPartitionMicroTransactionable( connection, (CorePartitionable) element, this, includeChildren );
        transactionManager.runInMicroTransaction( transactionable );

    }

    /**
     * @see CoreModelPartition#addElement(CorePartitionable)
     */
    public void addElement( CorePartitionable element ) {

        if ( element == null ) {
            throw new MoinIllegalArgumentException( RepositoryCoreMessages.MOIN_REPOSITORY_CORE_2003 );
        }

        // if element was assigned to another partition, it has to be
        // removed from the elements collection of that old partition
        ModelPartitionImpl oldPartition = (ModelPartitionImpl) element.get___Partition( );
        if ( oldPartition != null ) {
            oldPartition.removeModelElementInternal( element );
        }

        if ( isExtentPartition( ) ) {
            synchronized ( this ) {
                addElementInternal( element );
            }
        } else {
            addElementInternal( element );
        }

    }

    private void addElementInternal( CorePartitionable element ) {

        this.elements.add( element );
        element.set___PartitionAssignmentInternal( this );
    }

    /**
     * @see CoreModelPartition#removeElement(CorePartitionable)
     */
    public void removeElement( CorePartitionable element ) {

        if ( element == null ) {
            throw new MoinIllegalArgumentException( RepositoryCoreMessages.MOIN_REPOSITORY_CORE_2002 );
        }
        if ( isExtentPartition( ) ) {
            synchronized ( this ) {
                removeElementInternal( element );
            }
        } else {
            removeElementInternal( element );
        }

    }

    private void removeElementInternal( CorePartitionable element ) {

        LRI lri = element.get___Mri( ).getLri( );
        this.elements.remove( element );
        this.jmiListContainer.invalidateAndRemoveJmiLists( lri );
        element.set___PartitionAssignmentInternal( null );
    }

    /**
     * @see CoreModelPartition#getWorkspace()
     */
    public Workspace getWorkspace( ) {

        if ( responsibleWorkspace == null ) {
            throw new MoinIllegalStateException( CoreImplMessages.WORKSPACEOFPARTITIONISNULL, this );
        }
        return responsibleWorkspace;
    }

    public void setWorkspace( Workspace workspace ) {

        this.responsibleWorkspace = workspace;
    }

    public void setResourceInfo( SpiResourceInfo resourceInfo ) {

        this.resourceInfo = resourceInfo;
    }

    /**
     * @see CoreModelPartition#isEmpty()
     */
    public final boolean isEmpty( ) {

        if ( this.elements.isEmpty( ) ) {
            assert this.getLinks( ).isEmpty( ) : "Encountered partition without elements but with non-empty link set: " + getPri( ); //$NON-NLS-1$
            return true;
        }
        return false;
    }

    /**
     * This implementation always returns <tt>false</tt>.
     * 
     * @see ExtentPartition#isExtentPartition()
     */
    public boolean isExtentPartition( ) {

        return false;
    }

    /**
     * @see CoreModelPartition#isDirty()
     * @see TransientPartition#isDirty()
     */
    public boolean isDirty( ) {

        return this.dirty;
    }

    public boolean isAlive( ) {

        return !deleted;
    }

    /**
     * Clears the dirty state. To be called after partition was persisted.
     * 
     * @param connection
     */
    public void clearDirty( CoreConnection connection ) {

        if ( this.isDirty( ) ) {
            setDirty( false );
            if ( connection != null ) {
                connection.removeFromModifiedPartitions( this );
            }
        }
    }

    public boolean markDirty( CoreConnection connection ) {

        if ( this.dirty ) {
            //is already dirty, we can return at once
            return true;
        }
        // not dirty yet
        // trace who is responsible for making this partition dirty
        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.traceWithStack( MoinSeverity.DEBUG, "Connection \"{0}\" dirties partition \"{1}\". For detail information - see below call stack (created for debugging purposes): ", connection, this ); //$NON-NLS-1$
        }
        setDirty( true );
        if ( connection != null ) {
            connection.modifiedPartition( this );
        } else {
            //connection is null
            if ( logger.isTraced( MoinSeverity.WARNING ) ) {
                logger.trace( MoinSeverity.WARNING, "Connection is null on marking a partition dirty." ); //$NON-NLS-1$
            }
        }
        return false;
    }

    public void updateEvictionTimestamp( ) {

        evictionTimestamp = System.currentTimeMillis( );
    }

    public long getEvictionTimestamp( ) {

        return evictionTimestamp;
    }

    /**
     * Simple setter for the dirty flag.
     * 
     * @param dirty the flag to set
     */
    private void setDirty( boolean dirty ) {

        this.dirty = dirty;
        if ( !dirty ) {
            updateEvictionTimestamp( );
        }
    }

    /**
     * Simple removal from the internal data structure for model elements
     */
    private void removeModelElementInternal( CorePartitionable element ) {

        this.elements.remove( element );
    }

    /**
     * Returns the {@link CoreModelPartitionIdentity} instance which can be used
     * to compare CoreModelPartition for Java identity.
     * 
     * @return CoreModelPartitionIdentity instance of this
     * CoreModelPartitionIdentity
     */
    public CoreModelPartitionIdentity getCoreModelPartitionIdentity( ) {

        if ( this.coreModelPartitionIdentity == null ) {
            this.coreModelPartitionIdentity = new CoreModelPartitionIdentityImpl( );
        }
        return this.coreModelPartitionIdentity;
    }

    /**
     * Equality is based on the equality of the {@link #metadata}. Since
     * instances of {@link ModelPartition} are also instances of
     * {@link ModelPartitionInfo}, the implementation compares this instance's
     * {@link #metadata} object with the other {@link ModelPartition} object.
     * 
     * @see ModelPartitionInfoImpl#equals(Object)
     */
    @Override
    public boolean equals( Object o ) {

        if ( o == this ) {
            return true;
        }
        if ( o instanceof CoreModelPartition ) {
            CoreModelPartition p = (CoreModelPartition) o;
            return p.getResourceInformation( ).equals( this.resourceInfo );
        }
        return false;
    }

    /**
     * The hash code is computed as the hash code of the {@link #metadata}
     * attribute.
     * 
     * @see ModelPartitionInfoImpl#hashCode
     */
    @Override
    public int hashCode( ) {

        return this.resourceInfo.hashCode( );
    }

    @Override
    public String toString( ) {

        return this.resourceInfo.toString( );
    }

    /**
     * Inner class to check for Java identify of ModelPartitionImpl. If the
     * CoreModelPartitionIdentity is used for hash structures equality is just
     * based on Java object identity and therefore very fast. The equals method
     * of the CoreModelPartition delegates to the ResourceInfo in order to check
     * for equality. That is much more costly and in many cases not necessary.
     * The evication manager will make use of the CoreModelPartitionIdentity in
     * order to key statistics info for model partitions.
     * 
     * @author d024227
     */
    private class CoreModelPartitionIdentityImpl implements CoreModelPartitionIdentity {

        protected CoreModelPartitionIdentityImpl( ) {

        }

        /**
         * Provides a getter for the enclosing ModelPartitionImpl.
         */
        public CoreModelPartition getCoreModelPartition( ) {

            return ModelPartitionImpl.this;
        }

        @Override
        public boolean equals( Object obj ) {

            return super.equals( obj );
        }

        @Override
        public int hashCode( ) {

            return super.hashCode( );
        }

        @Override
        public String toString( ) {

            return getCoreModelPartition( ).toString( );
        }
    }

    public boolean isPersisted( ) {

        return persisted;
    }

    public void markPersisted( ) {

        persisted = true;
    }

    public void clearPersisted( ) {

        persisted = false;
    }

    /**
     * @see CoreModelPartition#getResourceInformation()
     */
    public SpiResourceInfo getResourceInformation( ) {

        return this.resourceInfo;
    }

    public void ___delete( ) {

        deleted = true;
    }

    @Deprecated
    public void delete( ) {

        delete( getCurrentConnection( ) );
    }

    public void delete( CoreConnection connection ) {

        MicroTransactionableFactory microTxFactory = getWorkspace( ).getWorkspaceSet( ).getMoin( ).getMicroTransactionableFactory( );
        PartitionDeleteMicroTransactionable transactionable = microTxFactory.createPartitionDeleteMicroTransactionable( connection, this );
        connection.getSession( ).getTransactionManager( ).runInMicroTransaction( transactionable );
    }

    protected CoreConnection getCurrentConnection( ) {

        return this.getWorkspace( ).getWorkspaceSet( ).getMoin( ).getCurrentConnection( );
    }

    @Deprecated
    public void deleteElements( ) {

        deleteElements( getCurrentConnection( ) );
    }

    public void deleteElements( CoreConnection connection ) {

        MicroTransactionableFactory microTxFactory = this.getWorkspace( ).getWorkspaceSet( ).getMoin( ).getMicroTransactionableFactory( );
        PartitionDeleteElementsMicroTransactionable transactionable = microTxFactory.createPartitionDeleteElementsMicroTransactionable( connection, this );
        connection.getSession( ).getTransactionManager( ).runInMicroTransaction( transactionable );
    }

    public Collection<EndStorageLink> evictLinks( ) {

        Collection<EndStorageLink> result = new ArrayList<EndStorageLink>( elements.size( ) );
        for ( Partitionable element : elements ) {
            List<EndStorageLink> links = ( (RefFeaturedExtension) element ).clear___AllLinks( );
            if ( links != null ) {
                for ( int i = 0, n = links.size( ); i < n; i++ ) {
                    result.add( links.get( i ) );
                }
            }
        }
        distributedLinkContainer.clear( );
        return result;
    }

    public DistributedLinkContainer getDistributedLinkContainer( ) {

        return distributedLinkContainer;
    }

    public JmiListContainer getJmiListContainer( ) {

        return jmiListContainer;
    }

    public OverflowContainer getOverflowContainer( ) {

        return overflowContainer;
    }

    public <T extends RefObject> T createElement( ClassDescriptor<? extends RefClass, T> classDescriptor ) {

        return createElement( getCurrentConnection( ), classDescriptor );
    }

    @SuppressWarnings( "unchecked" )
    public <T extends RefObject> T createElement( CoreConnection connection, ClassDescriptor<? extends RefClass, T> classDescriptor ) {

        RefClassImpl refClass = (RefClassImpl) connection.getClass( classDescriptor );
        return (T) refClass.refCreateInstanceInPartition( connection, null, this );
    }

    public <T extends RefObject> T createElement( Class<T> clazz ) {

        return createElement( getCurrentConnection( ), clazz );
    }

    public <T extends RefObject> T createElement( CoreConnection connection, Class<T> clazz ) {

        return connection.createElementInPartition( clazz, this );
    }

    public void trimToSize( ) {

        distributedLinkContainer.trimToSize( );
    }

    public boolean hasLinksToPartition( CoreModelPartition partition ) {

        Collection<Partitionable> elementsInOtherPartition = partition.getElements( );
        for ( Partitionable partitionable : elementsInOtherPartition ) {
            List<EndStorageLink> linksForElement = getDistributedLinkContainer( ).getLinksForElement( (CorePartitionable) partitionable );
            if ( linksForElement != null ) {
                return true;
            }
        }
        return false;
    }

    public void markHadErrorsDuringLoad( ) {

        this.errorsDuringLoad = true;
    }

    public void clearHadErrorsDuringLoad( ) {

        this.errorsDuringLoad = false;
    }

    public boolean isMemoryStateDifferentFromPersistentStateAfterLoad( ) {

        return errorsDuringLoad;
    }

    public void markHadUnhandledErrorsDuringLoad( ) {

        this.unhandledErrorsDuringLoad = true;
    }

    public void clearHadUnhandledErrorsDuringLoad( ) {

        this.unhandledErrorsDuringLoad = false;
    }

    public boolean hadUnhandledErrorsDuringLoad( ) {

        return unhandledErrorsDuringLoad;
    }

    public Map<CRI, String> getUsedMetamodels( ) {

        if ( usedMetamodelsInPersistentState != null ) {
            return usedMetamodelsInPersistentState;
        }
        return Collections.emptyMap( );
    }

    public void addUsedMetamodel( CRI metamodel, String version ) {

        if ( usedMetamodelsInPersistentState == null ) {
            usedMetamodelsInPersistentState = new LinkedHashMap<CRI, String>( );
        }
        usedMetamodelsInPersistentState.put( metamodel, version );
    }

    public void clearUsedMetamodels( ) {

        usedMetamodelsInPersistentState = null;
    }

    public byte[] getPrefixForSegmentedMofIds( ) {

        return this.prefixForSegmentedMofIds;
    }
}