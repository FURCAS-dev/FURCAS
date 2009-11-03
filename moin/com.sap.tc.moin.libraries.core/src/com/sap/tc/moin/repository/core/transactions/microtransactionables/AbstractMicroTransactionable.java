package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.IllegalLinkException;
import com.sap.tc.moin.repository.IllegalRelocateToDataAreaException;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.LockingException;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.PartitionEditingNotPossibleException;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreEventFactory;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.EndAndMetaObject;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.JmiCoreMessages;
import com.sap.tc.moin.repository.core.LogicalLinkManager;
import com.sap.tc.moin.repository.core.MemoryLinkManager;
import com.sap.tc.moin.repository.core.QueryLinkManager;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.core.jmi.extension.RefFeaturedExtension;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.transactions.AbstractTransactionObject;
import com.sap.tc.moin.repository.core.transactions.actions.ActionFactory;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.messages.core.RepositoryCoreMessages;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.ScopeKindEnum;
import com.sap.tc.moin.repository.mmi.reflect.CompositionCycleException;
import com.sap.tc.moin.repository.mmi.reflect.CompositionViolationException;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.shared.util.Tuple.Pair;
import com.sap.tc.moin.repository.transactions.MicroTransactionable;
import com.sap.tc.moin.repository.transactions.RecoverableExecutionException;
import com.sap.tc.moin.repository.transactions.actions.Action;

/**
 * <b>Instructions for the Design of Micro Transactionables</b>
 * <p>
 * 1. It is a good choice to optimize the memory consumption because micro
 * transactionables are hold in the transaction record of the surrounding
 * transaction.<br>
 * This can be done by introducing a complex inner state class that covers
 * several informations.<br>
 * When this object is set to null one has only one single object pointer that
 * consumes memory instead of one pointer per each single information entity.
 * <p>
 * 2. Don't remember objects, only their IDs , i.e. MRI/PRI/LRI/CRI.<br>
 * This is valid for M1 objects as well as for M2 objects (see point 3. for more
 * details).
 * <p>
 * 3. Objects that are only needed in the precondition check phase should be
 * forgotten after the precondition check phase.<br>
 * Objects that are needed for the precondition check phase and the do phase
 * survive the precondition phase and should be forgotten after the do phase.<br>
 * It should not be recomputed in the do phase because this phase directly comes
 * after the check and a recompute would in general be too expensive.<br>
 * This kind of information has to be nulled out in the doFinished method of a
 * micro transactionable and reactivated (resolved, recomputed) in the beginning
 * of the undo and redo phases.
 * <p>
 * 4. Other information that can be computed at the undo and redo phases should
 * be computed there.<br>
 * They should not be stored in the micro transactionable.<br>
 * This is typically an information that is not needed in the do phase.<br>
 */

public abstract class AbstractMicroTransactionable extends AbstractTransactionObject implements MicroTransactionable {

    MicroTransactionablesLoggingAdapter log = null;

    private ArrayList<Action> doActions = null;

    private ArrayList<ChangeEvent> doEvents = null;

    private ArrayList<PRI> partitionsMarkedDirty = null;

    private ArrayList<PRI> partitionsLocked = null;

    private ArrayList<PRI> partitionsEnsuredEditing = null;

    protected AbstractMicroTransactionable( CoreConnection aConnection ) {

        super( aConnection );
        this.log = new MicroTransactionablesLoggingAdapter( this );
    }

    public void assertDoPostConstraints( ) {

    }

    public void assertDoPreConstraints( ) {

    }

    public void assertUndoPostConstraints( ) {

    }

    public void assertUndoPreConstraints( ) {

    }

    private final ArrayList<PRI> getOrCreatePartitionsMarkedDirty( ) {

        if ( partitionsMarkedDirty == null ) {
            partitionsMarkedDirty = new ArrayList<PRI>( 2 );
        }
        return partitionsMarkedDirty;
    }

    private final ArrayList<PRI> getOrCreatePartitionsLocked( ) {

        if ( partitionsLocked == null ) {
            partitionsLocked = new ArrayList<PRI>( 2 );
        }
        return partitionsLocked;
    }

    private final ArrayList<PRI> getOrCreatePartitionsEnsuredEditing( ) {

        if ( partitionsEnsuredEditing == null ) {
            partitionsEnsuredEditing = new ArrayList<PRI>( 2 );
        }
        return partitionsEnsuredEditing;
    }

    protected final ArrayList<Action> getOrCreateDoActions( ) {

        if ( doActions == null ) {
            doActions = new ArrayList<Action>( );
        }
        return doActions;
    }

    protected final ArrayList<ChangeEvent> getOrCreateDoEvents( ) {

        if ( doEvents == null ) {
            doEvents = new ArrayList<ChangeEvent>( );
        }
        return doEvents;
    }

    protected final ArrayList<Action> getOrCreateUndoActions( ) {

        if ( doActions == null ) {
            doActions = new ArrayList<Action>( );
        }
        return doActions;
    }

    protected final ArrayList<ChangeEvent> getOrCreateUndoEvents( ) {

        if ( doEvents == null ) {
            doEvents = new ArrayList<ChangeEvent>( );
        }
        return doEvents;
    }

    public void doFinished( ) {

        doActions = null;
        doEvents = null;
        if ( partitionsLocked != null ) {
            partitionsLocked.trimToSize( );
        }
        if ( partitionsMarkedDirty != null ) {
            partitionsMarkedDirty.trimToSize( );
        }
        if ( partitionsEnsuredEditing != null ) {
            partitionsEnsuredEditing.trimToSize( );
        }
    }

    public void undoFinished( ) {

        doActions = null;
        doEvents = null;
    }

    public void redoFinished( ) {

        doFinished( );
    }

    public abstract void computeDoActionsAndDoEvents( );

    public abstract void computeUndoActionsAndUndoEvents( );

    public void computeRedoActionsAndRedoEvents( ) {

        computeDoActionsAndDoEvents( );
    }

    public final List<Action> getDoActions( ) {

        return doActions;
    }

    public final List<ChangeEvent> getDoEvents( ) {

        return doEvents;
    }

    public final List<Action> getUndoActions( ) {

        return doActions;
    }

    public final List<ChangeEvent> getUndoEvents( ) {

        return doEvents;
    }

    public final List<Action> getRedoActions( ) {

        return getDoActions( );
    }

    public final List<ChangeEvent> getRedoEvents( ) {

        return getDoEvents( );
    }

    protected final WorkspaceSet getWorkspaceSet( ) {

        return connection.getSession( ).getWorkspaceSet( );
    }

    protected final CoreModelPartition getNullPartition( ) {

        return connection.getNullPartition( );
    }

    protected final LogicalLinkManager getLogicalLinkManager( ) {

        return connection.getSession( ).getWorkspaceSet( ).getLogicalLinkManager( );
    }

    protected final CoreEventFactory getEventFactory( ) {

        return connection.getSession( ).getWorkspaceSet( ).getMoin( ).getEventFactory( );
    }

    protected final CoreModelPartition getExistingPartition( PRI pri ) {

        CoreModelPartition partition = null;
        try {
            partition = connection.getPartition( pri );
        } catch ( RuntimeException e ) {
            triggerRollback( e );
            // the following return statement won't be reached as
            // triggerRollback() will throw an exception in any case
            return null;
        }
        if ( partition == null ) {
            triggerRollback( JmiCoreMessages.PRINOTRESOLVED, pri );
        }
        return partition;
    }

    protected final CorePartitionable getExistingElement( MRI mri ) {

        CorePartitionable element = null;
        try {
            element = (CorePartitionable) connection.getElement( mri );
        } catch ( RuntimeException e ) {
            triggerRollback( e );
            // the following return statement won't be reached as
            // triggerRollback() will throw an exception in any case
            return null;
        }
        if ( element == null ) {
            triggerRollback( JmiCoreMessages.MRINOTRESOLVED, mri );
        }
        return element;
    }

    protected final void assertNotNull( Object object, MoinLocalizedString message, Object... args ) {

        if ( object == null ) {
            RecoverableExecutionException exception = new RecoverableExecutionException( new MoinLocalizedBaseRuntimeException( message, args ), message, args );
            log.preConstraintCheckException( exception );
            throw exception;
        }
    }

    protected final void triggerRollback( MoinLocalizedString message, Object... args ) throws RecoverableExecutionException {

        RecoverableExecutionException exception = new RecoverableExecutionException( message, args );
        log.preConstraintCheckException( exception );
        throw exception;
    }

    protected final void triggerRollback( MoinLocalizedBaseRuntimeException cause ) throws RecoverableExecutionException {

        RecoverableExecutionException exception = new RecoverableExecutionException( cause );
        log.preConstraintCheckException( exception );
        throw exception;
    }

    protected final void triggerRollback( RuntimeException cause ) throws RecoverableExecutionException {

        RecoverableExecutionException exception = new RecoverableExecutionException( cause );
        log.preConstraintCheckException( exception );
        throw exception;
    }

    protected final EndStorageLink getLinkToReplace( EndStorageLink linkToBeAdded, int addedViaReferenceOnEnd ) {

        // implicit link replacement is only done if the link which should be
        // added is established via a "reference"
        // (object-valued attribute has the same semantics as a "reference")
        if ( addedViaReferenceOnEnd == Workspace.LINK_NOT_ADDED_VIA_REFERENCE ) {
            return null;
        }
        // the end "from" where the new link should be established
        int fromEnd = 1 - addedViaReferenceOnEnd;
        // the end "to" where the new link should be established
        int toEnd = addedViaReferenceOnEnd;
        EndStorageLink linkToReplace = null;
        // Check 1-multiplicity within same association/attribute as this is
        // necessary condition for implicit link
        // removal
        if ( linkToBeAdded.isUpperMultiplicityOne( connection.getSession( ), toEnd ) ) {
            linkToReplace = getEndStorageLinkToRemove( linkToBeAdded, fromEnd ).getA( );
        }// else: upper multiplicity is not 1, but that is necessary
        // condition for implicit link removal
        return linkToReplace;
    }

    protected final Pair<EndStorageLink, Integer> getLinkToReplaceWithIndexInformation( EndStorageLink linkToBeAdded, int addedViaReferenceOnEnd ) {

        // implicit link replacement is only done if the link which should be
        // added is established via a "reference"
        // (object-valued attribute has the same semantics as a "reference")
        if ( addedViaReferenceOnEnd == Workspace.LINK_NOT_ADDED_VIA_REFERENCE ) {
            return null;
        }
        // the end "from" where the new link should be established
        int fromEnd = 1 - addedViaReferenceOnEnd;
        // the end "to" where the new link should be established
        int toEnd = addedViaReferenceOnEnd;
        Pair<EndStorageLink, Integer> linkAndIndexToReplace = null;
        // Check 1-multiplicity within same association/attribute as this is
        // necessary condition for implicit link
        // removal
        if ( linkToBeAdded.isUpperMultiplicityOne( connection.getSession( ), toEnd ) ) {
            linkAndIndexToReplace = getEndStorageLinkToRemove( linkToBeAdded, fromEnd );
        }// else: upper multiplicity is not 1, but that is necessary
        // condition for implicit link removal
        return linkAndIndexToReplace;
    }

    private Pair<EndStorageLink, Integer> getEndStorageLinkToRemove( EndStorageLink linkToBeAdded, int fromEnd ) {

        boolean distributed = linkToBeAdded.getEndNumberOfStorageEnd( ) != fromEnd;
        Collection<EndStorageLink> linksToRemoveForEnd = null;
        EndAndMetaObject endAndMetaObject = getWorkspaceSet( ).getEndAndMetaObjectPool( ).getEndAndMetaObject( fromEnd, linkToBeAdded.getMetaObject( ) );
        if ( distributed ) {
            CorePartitionable fromElement = linkToBeAdded.getOtherEnd( ).get( connection.getSession( ) );
            QueryLinkManager queryLinkManager = connection.getSession( ).getWorkspace( ).getQueryLinkManager( );
            linksToRemoveForEnd = queryLinkManager.getLinksForEndAndMetaObject( connection.getSession( ), endAndMetaObject, fromElement );
        } else {
            MemoryLinkManager linkManager = connection.getSession( ).getWorkspace( ).getMemoryLinkManager( );
            linksToRemoveForEnd = linkManager.getLinksForEndAndMetaObject( connection.getSession( ), endAndMetaObject, linkToBeAdded.getStorageEnd( ).getMri( ) );
        }
        if ( linksToRemoveForEnd != null && linksToRemoveForEnd.size( ) > 0 ) {
            if ( linksToRemoveForEnd.size( ) == 1 ) {
                // that's the one we are looking for!
                EndStorageLink linkToRemove = linksToRemoveForEnd.iterator( ).next( );
                int index = -1;
                RefObject metaObject = linkToBeAdded.getMetaObject( );
                if ( metaObject instanceof Association ) {
                    boolean isOrdered = getJmiHelper( ).getOrderedEnd( connection.getSession( ), metaObject ) != -1;
                    if ( isOrdered ) {
                        CorePartitionable elementAtStorageEnd = linkToRemove.getStorageEnd( ).get( this.connection.getSession( ) );
                        List<AssociationEnd> associationEnds = getJmiHelper( ).getAssociationEnds( connection.getSession( ), (Association) metaObject );
                        AssociationEnd otherAssociationEnd = associationEnds.get( linkToRemove.getEndNumberOfOtherEnd( ) );
                        List<EndStorageLink> links = (List<EndStorageLink>) ( (RefFeaturedExtension) elementAtStorageEnd ).get___AssociationLinks( otherAssociationEnd.refMofId( ) );
                        if ( links != null ) {
                            index = links.indexOf( linkToRemove );
                        }
                    }
                }
                return new Pair<EndStorageLink, Integer>( linkToRemove, index );
            }
            // linksToRemoveForEnd.size() > 1
            // that is an inconsistency as the upper multiplicity is one.
            // There should't be more than one link.
            // TODO inconsistency handling
            MoinIllegalStateException exception = new MoinIllegalStateException( MicroTransactionablesMessages.MORETHANONELINKFORREMOVAL );
            log.preConstraintCheckException( exception );
            throw exception;
        }
        return new Pair<EndStorageLink, Integer>( null, -1 );
    }

    protected final CorePartitionable[] constructEnds( CorePartitionable elementAtFromEnd, int fromEndNumber, CorePartitionable elementAtToEnd, int toEndNumber ) {

        CorePartitionable[] ends = new CorePartitionable[2];
        ends[fromEndNumber] = elementAtFromEnd;
        ends[toEndNumber] = elementAtToEnd;
        return ends;
    }

    protected final boolean isAssociationLinkAlreadyExisting( EndStorageLink link ) {

        return link.getMemoryLinkManager( connection ).isAssociationLinkExisting( connection, link );
    }

    protected final void assertNoCompositeLinkToMetamodelIfStorageAtParent( EndStorageLink link ) {

        int endNumberOfParentElement = link.getCompositeEnd( );
        if ( ( endNumberOfParentElement != -1 ) && ( endNumberOfParentElement == link.getEndNumberOfStorageEnd( ) ) ) {
            int endNumberOfChildElement = link.getComponentEnd( );
            CoreSession session = connection.getSession( );
            MRI childElement = link.getEnd( endNumberOfChildElement ).getMri( session );
            MRI parentElement = link.getEnd( endNumberOfParentElement ).getMri( session );
            DataAreaDescriptor dataAreaOfParent;
            if ( parentElement != null ) {
                dataAreaOfParent = parentElement.getDataAreaDescriptor( );
            } else {
                //MRI was null, try to get LRI
                LRI lriOfParentElement = link.getEnd( endNumberOfParentElement ).getLri( );
                if ( lriOfParentElement != null ) {
                    dataAreaOfParent = lriOfParentElement.getDataAreaDescriptor( );
                } else {
                    //we can't determine the data area, therefore we can't say anything
                    return;
                }
            }
            DataAreaDescriptor dataAreaOfChild;
            if ( childElement != null ) {
                dataAreaOfChild = childElement.getDataAreaDescriptor( );
            } else {
                //MRI was null, try to get LRI
                LRI lriOfChildElement = link.getEnd( endNumberOfChildElement ).getLri( );
                if ( lriOfChildElement != null ) {
                    dataAreaOfChild = lriOfChildElement.getDataAreaDescriptor( );
                } else {
                    //we can't determine the data area, therefore we can't say anything
                    return;
                }
            }

            if ( !dataAreaOfParent.isMetamodelDataArea( ) ) {
                //parent is not in metamodel data area -> child must not be in metamodel data area, because
                //otherwise, refDelete() would try to delete elements from the metamodel data area
                if ( dataAreaOfChild.isMetamodelDataArea( ) ) {
                    MRI metaObject = link.getMetaObjectMri( );
                    triggerRollback( new IllegalLinkException( RepositoryCoreMessages.ILLEGALLINKMETAMODELTOMODEL, parentElement, childElement, metaObject ) );
                }
            }

        }
    }

    protected final void assertCompositionCycle( EndStorageLink link ) throws CompositionCycleException {

        if ( link.getCompositeEnd( ) != -1 ) {
            RefObject parent = (RefObject) link.getEnd( link.getCompositeEnd( ) ).get( connection.getSession( ) );
            assertCompositionCycle( link, parent, new HashSet<RefObject>( ) );
        }
    }

    private void assertCompositionCycle( EndStorageLink link, RefObject current, Set<RefObject> visitedObjects ) throws CompositionCycleException {

        if ( visitedObjects.contains( current ) ) {
            CompositionCycleException exception = new CompositionCycleException( link.getEnd( link.getComponentEnd( ) ).get( connection.getSession( ) ), link.getMetaObject( ), RepositoryCoreMessages.MOIN_1011, link );
            log.preConstraintCheckException( exception );
            throw exception;
        } else {
            visitedObjects.add( current );
            Object parent = ( (RefObjectImpl) current ).refImmediateComposite( connection.getSession( ) );
            RefObject parentRefObject = null;
            if ( parent instanceof RefObject ) {
                parentRefObject = (RefObject) parent;
            }
            if ( parentRefObject != null ) {
                assertCompositionCycle( link, parentRefObject, visitedObjects );
            }
        }
    }

    protected final void assertCompositionClosure( EndStorageLink link ) throws CompositionViolationException {

        if ( link.getCompositeEnd( ) != -1 ) {
            CorePartitionable componentElement = link.getEnd( link.getComponentEnd( ) ).get( connection.getSession( ) );
            Collection<EndStorageLink> compositeParentLinks = getWorkspaceSet( ).getLogicalLinkManager( ).getCompositeParentLinks( connection.getSession( ), componentElement );
            if ( compositeParentLinks.size( ) > 1 ) {
                CompositionViolationException exception = new CompositionViolationException( componentElement, link.getMetaObject( ) );
                log.preConstraintCheckException( exception );
                throw exception;
            }
        }
    }

    /**
     * Eliminates instances of the given {@link Class} list <code>classes</code>
     * from the given collection
     */
    protected final void eliminateInstancesOf( Collection<? extends Object> collection, Class<? extends Object>... classes ) {

        for ( Iterator<? extends Object> it = collection.iterator( ); it.hasNext( ); ) {
            Object element = it.next( );
            for ( int i = 0; i < classes.length; i++ ) {
                if ( classes[i].isInstance( element ) ) {
                    it.remove( );
                    break;
                }
            }
        }
    }

    /**
     * Returns all component children recursively, i.e. also the grandchildren
     * etc.
     */
    @SuppressWarnings( "unchecked" )
    protected final List<CorePartitionable> getAllComponentChildrenRecursive( CorePartitionable parent ) {

        Collection result = connection.getCoreJmiHelper( ).getCompositeChildren( connection.getSession( ), (RefObject) parent, true /* recursively */);
        return (List<CorePartitionable>) result;
    }

    protected final List<CorePartitionable> getAllCompositeParents( CorePartitionable componentElement ) {

        List<CorePartitionable> result = null;
        RefFeatured parent = (RefFeatured) componentElement;
        while ( ( parent = ( (RefObjectImpl) parent ).refImmediateComposite( connection.getSession( ) ) ) != null ) {
            if ( result == null ) {
                result = new ArrayList<CorePartitionable>( 4 );
            }
            result.add( (CorePartitionable) parent );
        }
        if ( result == null ) {
            return Collections.emptyList( );
        }
        return result;
    }

    /**
     * Computes the elements to repartition after the specified link was added,
     * considered are those elements that come from the null partition, they
     * land in the partition of the composite parent
     */
    protected final List<CorePartitionable> getElementsToRepartitionAfterLinkAdd( RefObject linkMetaObject, int compositeEndNumber, CorePartitionable elementAtComponentEnd, CoreModelPartition partitionOfCompositeEnd ) {

        List<CorePartitionable> elementsToRepartition = new ArrayList<CorePartitionable>( );
        if ( compositeEndNumber == -1 ) {
            // no composition, return
            return elementsToRepartition;
        }
        CorePartitionable child = elementAtComponentEnd;
        CoreModelPartition partitionOfChild = child.get___Partition( );
        CoreModelPartition partitionOfParent = partitionOfCompositeEnd;
        if ( partitionOfChild.getPri( ).isVolatilePartition( ) && partitionOfChild.equals( getNullPartition( ) ) ) {
            // put component child and grandchildren that are in the null partition into the same partition as the parent is
            if ( getJmiHelper( ).isEndStored( connection.getSession( ), compositeEndNumber, linkMetaObject ) ) {
                // if only the component side and not the composite side of the association/attribute is stored,
                // skip the repartitioning (this enables non-intrusive extension of a meta-model)
                // (note that we have the not-case here :)
                if ( !partitionOfParent.equals( partitionOfChild ) ) {
                    // check data area compatibility
                    DataAreaDescriptor dataAreaOfChild = child.get___Partition( ).getPri( ).getDataAreaDescriptor( );
                    DataAreaDescriptor dataAreaOfParentPartition = partitionOfParent.getPri( ).getDataAreaDescriptor( );
                    if ( !dataAreaOfChild.equals( dataAreaOfParentPartition ) ) {
                        IllegalRelocateToDataAreaException exception = new IllegalRelocateToDataAreaException( RepositoryCoreMessages.ILLEGALRELOCATEACTION, child, dataAreaOfChild, dataAreaOfParentPartition );
                        log.preConstraintCheckException( exception );
                        throw exception;
                    }
                    List<CorePartitionable> childrenToRepartition = new ArrayList<CorePartitionable>( );
                    childrenToRepartition.add( child );
                    // recomposition of all component grandchildren that are in the same partition as the child
                    List<CorePartitionable> grandchildren = getAllComponentChildrenRecursive( child );
                    for ( int i = 0; i < grandchildren.size( ); i++ ) {
                        CorePartitionable grandchild = grandchildren.get( i );
                        CoreModelPartition partitionOfGrandchild = grandchild.get___Partition( );
                        // check data area compatibility
                        DataAreaDescriptor dataAreaOfGrandchild = grandchild.get___Partition( ).getPri( ).getDataAreaDescriptor( );
                        if ( !dataAreaOfGrandchild.equals( dataAreaOfParentPartition ) ) {
                            IllegalRelocateToDataAreaException exception = new IllegalRelocateToDataAreaException( RepositoryCoreMessages.ILLEGALRELOCATEACTION, child, dataAreaOfGrandchild, dataAreaOfParentPartition );
                            log.preConstraintCheckException( exception );
                            throw exception;
                        }
                        if ( partitionOfChild.getPri( ).equals( partitionOfGrandchild.getPri( ) ) ) {
                            childrenToRepartition.add( grandchild );
                        }
                    }
                    elementsToRepartition.addAll( childrenToRepartition );
                }
            }
        }
        return elementsToRepartition;
    }

    /**
     * Computes the elements to repartition after the specified link was
     * removed, these elements land in the null partition
     */
    protected final List<CorePartitionable> getElementsToRepartitionAfterLinkRemove( RefObject linkMetaObject, int compositeEndNumber, CorePartitionable elementAtComponentEnd, CoreModelPartition partitionOfCompositeEnd ) {

        List<CorePartitionable> elementsToRepartition = new ArrayList<CorePartitionable>( );
        if ( compositeEndNumber == -1 ) {
            // no composition, return
            return elementsToRepartition;
        }
        CorePartitionable child = elementAtComponentEnd;
        CoreModelPartition partitionOfChild = child.get___Partition( );
        CoreModelPartition partitionOfParent = partitionOfCompositeEnd;

        // Re-partitioning upon link removal only takes place when parent and child reside in the same partition 
        if ( !partitionOfChild.equals( partitionOfParent ) ) {
            return elementsToRepartition;
        }

        if ( !( partitionOfChild.getPri( ).isVolatilePartition( ) && partitionOfChild.equals( getNullPartition( ) ) ) ) {
            // put component child and grandchildren that are not already in the
            // null partition into the null partition
            if ( getJmiHelper( ).isEndStored( connection.getSession( ), compositeEndNumber, linkMetaObject ) ) {
                // if only the component side and not the composite side of the
                // association/attribute is stored,
                // skip the repartitioning (this enables non-intrusive extension
                // of a meta-model)
                // (note that we have the not-case here :)
                // check data area compatibility
                DataAreaDescriptor dataAreaOfChild = child.get___Partition( ).getPri( ).getDataAreaDescriptor( );
                DataAreaDescriptor dataAreaOfParentPartition = partitionOfParent.getPri( ).getDataAreaDescriptor( );
                if ( !dataAreaOfChild.equals( dataAreaOfParentPartition ) ) {
                    IllegalRelocateToDataAreaException exception = new IllegalRelocateToDataAreaException( RepositoryCoreMessages.ILLEGALRELOCATEACTION, child, dataAreaOfChild, dataAreaOfParentPartition );
                    log.preConstraintCheckException( exception );
                    throw exception;
                }
                List<CorePartitionable> childrenToRepartition = new ArrayList<CorePartitionable>( );
                childrenToRepartition.add( child );
                // recomposition of all component grandchildren that are in the
                // same partition as the child
                List<CorePartitionable> grandchildren = getAllComponentChildrenRecursive( child );
                for ( int i = 0; i < grandchildren.size( ); i++ ) {
                    CorePartitionable grandchild = grandchildren.get( i );
                    CoreModelPartition partitionOfGrandchild = grandchild.get___Partition( );
                    // check data area compatibility
                    DataAreaDescriptor dataAreaOfGrandchild = grandchild.get___Partition( ).getPri( ).getDataAreaDescriptor( );
                    if ( !dataAreaOfGrandchild.equals( dataAreaOfParentPartition ) ) {
                        IllegalRelocateToDataAreaException exception = new IllegalRelocateToDataAreaException( RepositoryCoreMessages.ILLEGALRELOCATEACTION, child, dataAreaOfGrandchild, dataAreaOfParentPartition );
                        log.preConstraintCheckException( exception );
                        throw exception;
                    }
                    if ( partitionOfChild.getPri( ).equals( partitionOfGrandchild.getPri( ) ) ) {
                        childrenToRepartition.add( grandchild );
                    }
                }
                elementsToRepartition.addAll( childrenToRepartition );
            }
        }
        return elementsToRepartition;
    }

    protected final void computePartitionsToEnsureEditing( PRI... partitionPris ) {

        // editing permission does not to be ensured for partitions that were
        // already changed in the current connection. This is also true for the
        // null partition of the connection
        Collection<CoreModelPartition> partitionsOfConnection = connection.getDirtyPartitionsWithoutNullPartition( );
        Collection<PRI> partitionsOfConnectionPris = null;
        if ( partitionsOfConnection.size( ) > 0 ) {
            partitionsOfConnectionPris = new HashSet<PRI>( Utilities.calcInitialCapacity( partitionsOfConnection.size( ) ) );
            for ( ModelPartition modelPartition : partitionsOfConnection ) {
                partitionsOfConnectionPris.add( modelPartition.getPri( ) );
            }
        }
        for ( PRI pri : partitionPris ) {
            if ( pri.isNullPartition( ) ) {
                continue;
            }
            if ( partitionsOfConnectionPris == null || !partitionsOfConnectionPris.contains( pri ) ) {
                getOrCreatePartitionsEnsuredEditing( ).add( pri );
            }
        }
    }

    protected final void computePartitionsToLock( PRI... partitionPris ) {

        for ( int i = 0; i < partitionPris.length; i++ ) {
            PRI pri = partitionPris[i];
            try {
                if ( pri.isNullPartition( ) ) {
                    if ( pri.equals( connection.getNullPartition( ).getPri( ) ) ) {
                        continue;
                    } else {
                        triggerRollback( new PartitionEditingNotPossibleException( RepositoryCoreMessages.TRANSIENTPARTITIONCANNOTCHANGEDBYOTHERCONN, pri ) );
                    }
                }
                if ( !connection.getPartitionLockManager( ).isLockedByConnection( pri, connection ) ) {
                    // partition is not already locked by the connection,
                    // therefore we have to try to get a lock
                    getOrCreatePartitionsLocked( ).add( pri );
                }
            } catch ( LockingException e ) {
                triggerRollback( new PartitionEditingNotPossibleException( e, RepositoryCoreMessages.LOCKINGEXCEPTIONENCOUNTERED, pri ) );
            }
        }
    }

    protected final void computePartitionsToMarkDirty( PRI... partitionPris ) {

        for ( int i = 0; i < partitionPris.length; i++ ) {
            PRI pri = partitionPris[i];
            if ( !pri.isVolatilePartition( ) ) {
                // only mark partitions dirty which are real and aren't already
                // dirty, note that null and transient ones can't be made dirty
                if ( !getExistingPartition( pri ).isDirty( ) ) {
                    getOrCreatePartitionsMarkedDirty( ).add( pri );
                }
            }
        }
    }

    protected final void addEnsureEditingActionsToDoActions( ) {

        if ( partitionsEnsuredEditing == null ) {
            return;
        }
        for ( int i = 0; i < partitionsEnsuredEditing.size( ); i++ ) {
            getOrCreateDoActions( ).add( ActionFactory.createEnsureEditingAllowedAction( connection, partitionsEnsuredEditing.get( i ) ) );
        }
    }

    protected final void addEditLockActionsToDoActions( ) {

        if ( partitionsLocked == null ) {
            return;
        }
        for ( int i = 0; i < partitionsLocked.size( ); i++ ) {
            getOrCreateDoActions( ).add( ActionFactory.createPartitionEditLockAction( connection, partitionsLocked.get( i ) ) );
        }
    }

    protected final void addMarkDirtyActionsToDoActions( ) {

        if ( partitionsMarkedDirty == null ) {
            return;
        }
        for ( int i = 0; i < partitionsMarkedDirty.size( ); i++ ) {
            getOrCreateDoActions( ).add( ActionFactory.createPartitionMarkDirtyAction( connection, partitionsMarkedDirty.get( i ) ) );
        }
    }

    protected final List<PRI> getAffectedPartitionsForCopyOnWriteRedo( ) {

        if ( this.partitionsMarkedDirty == null ) {
            return Collections.emptyList( );
        } else {
            return this.partitionsMarkedDirty;
        }
    }

    protected final void addReleaseLockActionsToUndoActions( ) {

        if ( partitionsLocked == null ) {
            return;
        }
        for ( int i = partitionsLocked.size( ) - 1; i >= 0; i-- ) {
            PRI pri = partitionsLocked.get( i );
            getOrCreateUndoActions( ).add( ActionFactory.createPartitionLockReleaseAction( connection, pri ) );
        }
    }

    protected final void addClearDirtyActionsToUndoActions( ) {

        if ( partitionsMarkedDirty == null ) {
            return; // nothing to do.
        }
        for ( int i = partitionsMarkedDirty.size( ) - 1; i >= 0; --i ) {
            PRI pri = partitionsMarkedDirty.get( i );
            getOrCreateUndoActions( ).add( ActionFactory.createPartitionClearDirtyAction( connection, pri ) );
        }
    }

    protected final List<Attribute> getNonDerivedInstanceAttributes( RefClass refClass ) {

        List<Attribute> allAttributes = getJmiHelper( ).getAttributes( connection.getSession( ), refClass.refMetaObject( ), true );
        List<Attribute> attributes = new ArrayList<Attribute>( allAttributes.size( ) );
        for ( int i = 0; i < allAttributes.size( ); i++ ) {
            Attribute attribute = allAttributes.get( i );
            if ( !attribute.isDerived( ) && attribute.getScope( ) == ScopeKindEnum.INSTANCE_LEVEL ) {
                // only non-derived instance attributes are considered
                attributes.add( attribute );
            }
        }
        return attributes;
    }

    // TODO
    // inspection
    // remove state parameter concept, i.e. get rid of all these constants and state identifications.
    // For example by several spcializations of the StateSet class with special getters and setters
    // that can be inner classes in the micro transactionable implementation class that needs the state
    protected static final class StateSet {

        protected static final String STATE_PARAMETER_MRI = "mri"; //$NON-NLS-1$

        protected static final String STATE_PARAMETER_PRI = "pri"; //$NON-NLS-1$

        protected static final String STATE_PARAMETER_REF_CLASS_MRI = "refClassMri"; //$NON-NLS-1$

        protected static final String STATE_PARAMETER_WORKSPACE = "workspace"; //$NON-NLS-1$

        protected static final String STATE_PARAMETER_INSTANCE_PARAMETER = "parameter"; //$NON-NLS-1$

        protected static final String STATE_PARAMETER_COMPOSITE_PARENTS = "compositeParents"; //$NON-NLS-1$

        protected static final String STATE_PARAMETER_FIRST_LINK_END_MRI = "firstLinkEndMri"; //$NON-NLS-1$

        protected static final String STATE_PARAMETER_FIRST_LINK_END_COMPOSITE_PARENTS = "firstLinkEndCompositeParents"; //$NON-NLS-1$

        protected static final String STATE_PARAMETER_FIRST_LINK_END_META_OBJECT = "firstLinkEndMetaObject"; //$NON-NLS-1$

        protected static final String STATE_PARAMETER_SECOND_LINK_END_MRI = "secondLinkEndMri"; //$NON-NLS-1$

        protected static final String STATE_PARAMETER_SECOND_LINK_END_COMPOSITE_PARENTS = "secondLinkEndCompositeParents"; //$NON-NLS-1$

        protected static final String STATE_PARAMETER_SECOND_LINK_END_META_OBJECT = "secondLinkEndMetaObject"; //$NON-NLS-1$

        private Map<String, Object> initialState = new HashMap<String, Object>( 0 );

        private Map<String, Object> finalState = new HashMap<String, Object>( 0 );

        protected StateSet( Map<String, Object> anInitialState, Map<String, Object> aFinalState ) {

            initialState = anInitialState;
            finalState = aFinalState;
        }

        protected static Map<String, Object> createState( ) {

            return new HashMap<String, Object>( );
        }

        protected static Map<String, Object> createState( String stateParameterName, Object stateParameter ) {

            Map<String, Object> state = new HashMap<String, Object>( 2 );
            state.put( stateParameterName, stateParameter );
            return state;
        }

        protected void setInitialState( Map<String, Object> state ) {

            initialState = state;
        }

        protected void setFinalState( Map<String, Object> state ) {

            finalState = state;
        }

        protected Map<String, Object> getInitialState( ) {

            return initialState;
        }

        protected Map<String, Object> getFinalState( ) {

            return finalState;
        }
    }

    public CoreConnection getConnection( ) {

        return connection;
    }

    public boolean eventCreationNeeded( ) {

        return connection.getSession( ).getEventManager( ).hasListeners( );
    }

    protected final CoreModelPartition createPrivateCopy( PRI pri ) {

        return connection.getSession( ).createPrivateCopyOfPartition( pri );
    }
}
