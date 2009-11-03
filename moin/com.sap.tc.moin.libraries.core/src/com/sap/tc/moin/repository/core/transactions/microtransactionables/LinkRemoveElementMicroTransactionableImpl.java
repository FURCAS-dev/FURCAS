package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndInternal;
import com.sap.tc.moin.repository.mmi.reflect.InvalidCallException;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.TypeMismatchException;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.transactions.actions.ActionFactory;
import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.shared.util.IteratorKnowingCollection;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.transactions.microtransactionables.LinkRemoveElementMicroTransactionable;

@SuppressWarnings( "unchecked" )
public class LinkRemoveElementMicroTransactionableImpl extends AbstractMicroTransactionable implements LinkRemoveElementMicroTransactionable {

    private boolean linkSetChanged = false;

    private RefObject elementAtFromEnd = null;

    private Association association = null;

    private AssociationEnd fromEnd = null;

    private byte fromEndNumber = -1;

    private AssociationEnd toEnd = null;

    private byte toEndNumber = -1;

    private int index = -1;

    private ArrayList<Integer> indices = null;

    private IteratorKnowingCollection<EndStorageLink> iterator = null;

    private int iterationStepsBeforeRemove = 0;

    private Collection<Object> elementsToRemove = null;

    private ArrayList<MRI> elementsRemovedMri = null;

    private ArrayList<EndStorageLink> linksRemoved = null;

    private ArrayList<MRI> elementsRepartitionedMri = null;

    private Map<MRI, StateSet> affectedElementStates = null;

    /**
     * Creates a Micro Transactionable that removes links between the element
     * <code>anElementAtFromEnd</code> at the end with the number
     * <code>aFromEndNumber</code> of the Association <code>anAssociation</code>
     * and the given elements <code>theElementsToRemoveFromToEnd</code>
     */
    public LinkRemoveElementMicroTransactionableImpl( CoreConnection aConnection, Association anAssociation, RefObject anElementAtFromEnd, byte aFromEndNumber, Collection theElementsToRemoveFromToEnd ) {

        this( aConnection, anAssociation, anElementAtFromEnd, aFromEndNumber );
        if ( theElementsToRemoveFromToEnd != null ) {
            if ( theElementsToRemoveFromToEnd instanceof JmiList ) {
                JmiList elements = (JmiList) theElementsToRemoveFromToEnd;
                elementsToRemove = new LinkedHashSet( elements.size( aConnection.getSession( ) ) );
                for ( Iterator it = elements.iterator( aConnection ); it.hasNext( ); ) {
                    elementsToRemove.add( it.next( ) );
                }
            } else {
                elementsToRemove = new LinkedHashSet( theElementsToRemoveFromToEnd );
            }
        }
    }

    /**
     * Creates a Micro Transactionable that removes the link at position
     * <code>index</code> in the link list of the element
     * <code>anElementAtFromEnd</code> at the end with the number
     * <code>aFromEndNumber</code> of the Association <code>anAssociation</code>
     */
    public LinkRemoveElementMicroTransactionableImpl( CoreConnection aConnection, Association anAssociation, RefObject anElementAtFromEnd, byte aFromEndNumber, int anIndex ) {

        this( aConnection, anAssociation, anElementAtFromEnd, aFromEndNumber );
        index = anIndex;
    }

    /**
     * Creates a Micro Transactionable that removes the link at position
     * <code>theIterationStepsBeforeRemove - 1</code> in the link list of the
     * element <code>anElementAtFromEnd</code> at the end with the number
     * <code>aFromEndNumber</code> of the Association <code>anAssociation</code>
     * via the given <code>iterator</code>
     */
    public LinkRemoveElementMicroTransactionableImpl( CoreConnection aConnection, Association anAssociation, RefObject anElementAtFromEnd, byte aFromEndNumber, IteratorKnowingCollection<EndStorageLink> anIterator, int theIterationStepsBeforeRemove ) {

        this( aConnection, anAssociation, anElementAtFromEnd, aFromEndNumber );
        iterator = anIterator;
        iterationStepsBeforeRemove = theIterationStepsBeforeRemove;
    }

    private LinkRemoveElementMicroTransactionableImpl( CoreConnection aConnection, Association anAssociation, RefObject anElementAtFromEnd, byte aFromEndNumber ) {

        super( aConnection );
        elementAtFromEnd = anElementAtFromEnd;
        fromEndNumber = aFromEndNumber;
        toEndNumber = (byte) ( 1 - aFromEndNumber );
        association = anAssociation;
        List<AssociationEnd> ends = getJmiHelper( ).getAssociationEnds( aConnection.getSession( ), anAssociation );
        fromEnd = ends.get( aFromEndNumber );
        toEnd = ends.get( 1 - aFromEndNumber );
    }

    @Override
    public void assertDoPreConstraints( ) throws JmiException, MoinNullPointerException {

        if ( !fromEnd.isChangeable( ) ) {
            // both ends have to be changeable, if not throw an InvalidCallException
            // (reasonable according to JMI Spec, 4.8.4 (page 62) and according to the
            // exception thrown in the add case for that situation, 5.2.3 (page 86))
            InvalidCallException exception = new InvalidCallException( association, fromEnd, MicroTransactionablesMessages.ASSOCIATIONENDSHAVETOBECHANGABLE );
            log.preConstraintCheckException( exception );
            throw exception;
        }
        if ( !toEnd.isChangeable( ) ) {
            // both ends have to be changeable, if not throw an InvalidCallException
            // (reasonable according to JMI Spec, 4.8.4 (page 62) and according to the
            // exception thrown in the add case for that situation, 5.2.3 (page 86))
            InvalidCallException exception = new InvalidCallException( association, toEnd, MicroTransactionablesMessages.ASSOCIATIONENDSHAVETOBECHANGABLE );
            log.preConstraintCheckException( exception );
            throw exception;
        }
        if ( elementAtFromEnd == null ) {
            // removing a null element from an association end results in a NullPointerException (JMI Spec, 5.2.3 (page 87))
            MoinNullPointerException exception = new MoinNullPointerException( MicroTransactionablesMessages.ASSOCIATIONENDSCANNOTBENULL );
            log.preConstraintCheckException( exception );
            throw exception;
        }
        Classifier fromEndType = ( (AssociationEndInternal) fromEnd ).getType( connection );
        if ( !( (RefObjectImpl) elementAtFromEnd ).refIsInstanceOf( connection.getSession( ), fromEndType, true ) ) {
            // element at from end is not of the correct end type (5.2.3 (page 87))
            TypeMismatchException exception = new TypeMismatchException( fromEndType.getClass( ), elementAtFromEnd, association, MicroTransactionablesMessages.ASSOCIATIONENDHASWRONGTYPE, fromEnd.getName( ), association.getName( ), fromEndType.getName( ), elementAtFromEnd.getClass( ) );
            log.preConstraintCheckException( exception );
            throw exception;
        }
        if ( iterator != null ) {
            // ok, we want to remove an element via an iterator
            // in order to compute the element that should be removed from the iterator,
            // we have to get another iterator from it and have to step over it to the correct position
            Iterator<EndStorageLink> iter = iterator.getOtherIterator( );
            EndStorageLink endStorageLink = null;
            for ( int i = 0; i < iterationStepsBeforeRemove; i++ ) {
                endStorageLink = iter.next( );
            }
            CorePartitionable elementToRemove = endStorageLink.getOtherEnd( ).get( connection.getSession( ) );
            if ( elementsToRemove == null ) {
                elementsToRemove = new ArrayList<Object>( 1 );
            }
            elementsToRemove.add( elementToRemove );
        } else if ( index != -1 ) {
            // ok, we want to remove an element specified by an index
            JmiList elementsAtToEnd = getLogicalLinkManager( ).getElementsForEndAndMetaobject( connection, getWorkspaceSet( ).getEndAndMetaObjectPool( ).getEndAndMetaObject( fromEndNumber, association ), (CorePartitionable) elementAtFromEnd );
            CorePartitionable elementToRemove = (CorePartitionable) ( elementsAtToEnd ).get( connection.getSession( ), index );
            if ( elementsToRemove == null ) {
                elementsToRemove = new ArrayList<Object>( 1 );
            }
            elementsToRemove.add( elementToRemove );
        } else {
            // ok, we want to remove the elements specified
            for ( Object elementToRemove : elementsToRemove ) {
                if ( elementToRemove == null ) {
                    // removing a null element from an association end results in a NullPointerException (JMI Spec, 5.2.3 (page 87))
                    MoinNullPointerException exception = new MoinNullPointerException( MicroTransactionablesMessages.ASSOCIATIONENDSCANNOTBENULL );
                    log.preConstraintCheckException( exception );
                    throw exception;
                }
                Classifier toEndType = ( (AssociationEndInternal) toEnd ).getType( connection );
                if ( !( elementToRemove instanceof RefObject && ( (RefObjectImpl) elementToRemove ).refIsInstanceOf( connection.getSession( ), toEndType, true ) ) ) {
                    // elementToAdd is either not a RefObject or it is not of the correct end type (JMI Spec, 5.2.3 (page 87))
                    TypeMismatchException exception = new TypeMismatchException( toEndType.getClass( ), elementToRemove, association, MicroTransactionablesMessages.ASSOCIATIONENDHASWRONGTYPE, toEnd.getName( ), association.getName( ), toEndType.getName( ), elementToRemove.getClass( ) );
                    log.preConstraintCheckException( exception );
                    throw exception;
                }
            }
        }
    }

    @Override
    public void computeDoActionsAndDoEvents( ) {

        computeDoActionsAndDoEvents( true );
    }

    @Override
    public void computeUndoActionsAndUndoEvents( ) {

        if ( linksRemoved != null ) {
            // link add actions and events
            boolean eventCreationNeeded = eventCreationNeeded( );
            for ( int i = 0; i < linksRemoved.size( ); i++ ) {
                EndStorageLink linkRemoved = linksRemoved.get( i );
                int position = indices.get( i );
                List<AssociationEnd> ends = connection.getCoreJmiHelper( ).getAssociationEnds( connection.getSession( ), (Association) linkRemoved.getMetaObject( ) );
                getOrCreateDoActions( ).add( ActionFactory.createEndStorageLinkAddAction( connection, linkRemoved.getStorageEnd( ).getMri( ), ends.get( linkRemoved.getEndNumberOfOtherEnd( ) ).refMofId( ), linkRemoved, position ) );
                if ( eventCreationNeeded ) {
                    getOrCreateUndoEvents( ).add( getEventFactory( ).createLinkAddEvent( connection, linkRemoved, position ) );
                }
            }
            // partition assign actions and events
            if ( elementsRepartitionedMri != null ) {
                for ( int i = 0; i < elementsRepartitionedMri.size( ); i++ ) {
                    MRI elementRepartitionedMri = elementsRepartitionedMri.get( i );
                    StateSet ss = affectedElementStates.get( elementRepartitionedMri );
                    PRI oldPartitionPri = (PRI) ss.getInitialState( ).get( StateSet.STATE_PARAMETER_PRI );
                    PRI newPartitionPri = (PRI) ss.getFinalState( ).get( StateSet.STATE_PARAMETER_PRI );
                    // can not use old MRI because it has changed after repartitioning
                    MRI newMri = newPartitionPri.createMri( elementRepartitionedMri.getMofId( ) );
                    getOrCreateUndoActions( ).add( ActionFactory.createPartitionableAssignPartitionAction( connection, newMri, newPartitionPri, oldPartitionPri ) );
                    if ( eventCreationNeeded ) {
                        getOrCreateUndoEvents( ).add( getEventFactory( ).createPartitionMembershipChangeEvent( connection, (RefObject) getExistingElement( newMri ), getExistingPartition( newPartitionPri ), getExistingPartition( oldPartitionPri ) ) );
                    }
                }
            }
            // partition clear dirty actions
            addClearDirtyActionsToUndoActions( );
            // release lock actions
            addReleaseLockActionsToUndoActions( );
            // changed flag
            linkSetChanged = false;
        }
    }

    @Override
    public void computeRedoActionsAndRedoEvents( ) {

        boolean doCase = false;
        copyOnWrite( doCase );
        computeDoActionsAndDoEvents( doCase );
    }

    @Override
    public void doFinished( ) {

        super.doFinished( );
        elementAtFromEnd = null;
        elementsToRemove = null;
        if ( linksRemoved != null ) {
            linksRemoved.trimToSize( );
        }
        if ( elementsRemovedMri != null ) {
            elementsRemovedMri.trimToSize( );
        }
        // the iterator can only be used once, so it needs to be nulled out here
        // note that if we would use the iterator more that once, e.g. in a
        // second
        // do call or in a redo call we would get an IllegalStateException from
        // the
        // iterator because an iterator remove would be called without a
        // previous call
        // of the iterator method next. But calling next before would clearly be
        // an error :)
        // As a result, from a second call onwards, i.e. in a redo, the link is
        // removed
        // via the link collection in the MemoryLinkManager.removeLink method
        // called by the
        // LinkRemoveAction (because iterator is null) and the iterator is not
        // usable anymore
        // from outside. Calling any method of the iterator leads than to a
        // ConcurrentModificationException.
        iterator = null;
    }

    private void computeDoActionsAndDoEvents( boolean doCase ) {

        if ( doCase ) {
            if ( elementsToRemove != null ) {
                // compute the links to remove, the affected partitions and the
                // elements to repartition
                boolean isToEndOrdered = toEnd.getMultiplicity( ).isOrdered( );
                int compositeEndNumber = getJmiHelper( ).getCompositeEnd( connection.getSession( ), association );
                boolean isComposition = ( compositeEndNumber != -1 );
                copyOnWrite( doCase );
                JmiList<CorePartitionable> elementsAtToEnd = getLogicalLinkManager( ).getElementsForEndAndMetaobject( connection, getWorkspaceSet( ).getEndAndMetaObjectPool( ).getEndAndMetaObject( fromEndNumber, association ), (CorePartitionable) elementAtFromEnd );
                Set<PRI> affectedPartitionsPri = new HashSet<PRI>( );
                linksRemoved = new ArrayList<EndStorageLink>( elementsToRemove.size( ) );
                indices = new ArrayList<Integer>( elementsToRemove.size( ) );
                elementsRemovedMri = new ArrayList<MRI>( elementsToRemove.size( ) );
                Iterator<CorePartitionable> elementsAtToEndIterator = elementsAtToEnd.iteratorReadOnly( connection.getSession( ) );
                for ( ; elementsAtToEndIterator.hasNext( ); ) {
                    CorePartitionable elementAtToEnd = elementsAtToEndIterator.next( );
                    if ( elementsToRemove.contains( elementAtToEnd ) ) {
                        // ok element should be removed
                        int idx = isToEndOrdered ? ( elementsAtToEnd ).indexOf( connection, elementAtToEnd ) : -1;
                        MRI elementMri = elementAtToEnd.get___Mri( );
                        elementsRemovedMri.add( elementMri );
                        // link to remove and affected partitions
                        CorePartitionable[] oldEnds = constructEnds( (CorePartitionable) elementAtFromEnd, fromEndNumber, elementAtToEnd, toEndNumber );
                        EndStorageLink linkToRemove = getLogicalLinkManager( ).getLink( connection.getSession( ), oldEnds[0], oldEnds[1], association, true );
                        indices.add( idx );
                        linksRemoved.add( linkToRemove );
                        affectedPartitionsPri.add( linkToRemove.getStorageEndMri( ).getPri( ) );
                        // elements to repartition and affected partitions
                        if ( isComposition ) {
                            CorePartitionable compositeEnd = linkToRemove.getEnd( linkToRemove.getCompositeEnd( ) ).get( connection.getSession( ) );
                            CorePartitionable componentEnd = linkToRemove.getEnd( linkToRemove.getComponentEnd( ) ).get( connection.getSession( ) );
                            List<CorePartitionable> elementsToRepartition = getElementsToRepartitionAfterLinkRemove( association, compositeEndNumber, componentEnd, compositeEnd.get___Partition( ) );
                            if ( elementsRepartitionedMri == null && !elementsToRepartition.isEmpty( ) ) {
                                elementsRepartitionedMri = new ArrayList<MRI>( elementsToRepartition.size( ) );
                            }
                            if ( affectedElementStates == null ) {
                                affectedElementStates = new HashMap<MRI, StateSet>( Utilities.calcInitialCapacity( elementsToRepartition.size( ) ) );
                            }
                            for ( CorePartitionable elementToRepartition : elementsToRepartition ) {
                                PRI oldPartitionPri = elementToRepartition.get___Partition( ).getPri( );
                                PRI newPartitionPri = getNullPartition( ).getPri( );
                                Map<String, Object> initialState = StateSet.createState( StateSet.STATE_PARAMETER_PRI, oldPartitionPri );
                                Map<String, Object> finalState = StateSet.createState( StateSet.STATE_PARAMETER_PRI, newPartitionPri );
                                elementsRepartitionedMri.add( elementToRepartition.get___Mri( ) );
                                affectedElementStates.put( elementToRepartition.get___Mri( ), new StateSet( initialState, finalState ) );
                                if ( affectedPartitionsPri.add( oldPartitionPri ) ) {
                                    createPrivateCopy( oldPartitionPri );
                                }
                                if ( affectedPartitionsPri.add( newPartitionPri ) ) {
                                    createPrivateCopy( newPartitionPri );
                                }
                            }
                        }
                    }
                }
                // fulfill the contract, lists should be null if nothing should
                // be done
                linksRemoved = ( linksRemoved.size( ) == 0 ) ? null : linksRemoved;
                elementsRemovedMri = ( elementsRemovedMri.size( ) == 0 ) ? null : elementsRemovedMri;
                PRI[] affectedPartitionPris = affectedPartitionsPri.toArray( new PRI[affectedPartitionsPri.size( )] );
                computePartitionsToLock( affectedPartitionPris );
                computePartitionsToEnsureEditing( affectedPartitionPris );
                computePartitionsToMarkDirty( affectedPartitionPris );
            }
        }
        // actions and events
        if ( linksRemoved != null ) {
            // actions and events
            // aquire locks actions
            addEditLockActionsToDoActions( );
            // ensure editing allowed actions
            addEnsureEditingActionsToDoActions( );
            // link remove actions and events
            boolean eventCreationNeeded = eventCreationNeeded( );
            for ( int i = 0; i < linksRemoved.size( ); i++ ) {
                EndStorageLink linkRemoved = linksRemoved.get( i );
                int position = indices.get( i );
                List<AssociationEnd> ends = connection.getCoreJmiHelper( ).getAssociationEnds( connection.getSession( ), (Association) linkRemoved.getMetaObject( ) );
                getOrCreateDoActions( ).add( ActionFactory.createEndStorageLinkRemoveAction( connection, linkRemoved.getStorageEnd( ).getMri( ), ends.get( linkRemoved.getEndNumberOfOtherEnd( ) ).refMofId( ), linkRemoved, position, iterator ) );
                if ( eventCreationNeeded ) {
                    getOrCreateDoEvents( ).add( getEventFactory( ).createLinkRemoveEvent( connection, linkRemoved, indices.get( 0 ) ) );
                }
            }
            // partition assign actions and events
            if ( elementsRepartitionedMri != null ) {
                for ( int i = 0; i < elementsRepartitionedMri.size( ); i++ ) {
                    MRI elementRepartitionedMri = elementsRepartitionedMri.get( i );
                    StateSet ss = affectedElementStates.get( elementRepartitionedMri );
                    PRI oldPartitionPri = (PRI) ss.getInitialState( ).get( StateSet.STATE_PARAMETER_PRI );
                    PRI newPartitionPri = (PRI) ss.getFinalState( ).get( StateSet.STATE_PARAMETER_PRI );
                    getOrCreateDoActions( ).add( ActionFactory.createPartitionableAssignPartitionAction( connection, elementRepartitionedMri, oldPartitionPri, newPartitionPri ) );
                    if ( eventCreationNeeded ) {
                        getOrCreateDoEvents( ).add( getEventFactory( ).createPartitionMembershipChangeEvent( connection, (RefObject) getExistingElement( elementRepartitionedMri ), getExistingPartition( oldPartitionPri ), getExistingPartition( newPartitionPri ) ) );
                    }
                }
            }
            // partition mark dirty actions
            addMarkDirtyActionsToDoActions( );
            // changed flag
            linkSetChanged = true;
        }
    }

    private void copyOnWrite( boolean doCase ) {

        if ( doCase ) {
            byte storedEnd = getJmiHelper( ).getStoredEnd( connection.getSession( ), association );
            if ( storedEnd == fromEndNumber ) {
                CorePartitionable coreElement = ( (CorePartitionable) elementAtFromEnd );
                if ( coreElement.get___Workspace( ) == connection.getSession( ).getCompoundClientSpecWorkspace( ) ) {
                    createPrivateCopy( coreElement.get___Partition( ).getPri( ) );
                    elementAtFromEnd = (RefObject) getExistingElement( coreElement.get___Mri( ) );
                }
            } else {
                Set<PRI> affectedPartitions = new HashSet<PRI>( );
                for ( Object elementToRemove : elementsToRemove ) {
                    CorePartitionable element = (CorePartitionable) elementToRemove;
                    if ( element.get___Workspace( ) == connection.getSession( ).getCompoundClientSpecWorkspace( ) ) {
                        affectedPartitions.add( element.get___Partition( ).getPri( ) );
                    }
                }
                for ( PRI pri : affectedPartitions ) {
                    createPrivateCopy( pri );
                }
            }
        } else {//redo
            List<PRI> affectedPartitionsForRedo = getAffectedPartitionsForCopyOnWriteRedo( );
            for ( int i = 0; i < affectedPartitionsForRedo.size( ); i++ ) {
                createPrivateCopy( affectedPartitionsForRedo.get( i ) );
            }
        }
    }

    public boolean linkSetChanged( ) {

        return linkSetChanged;
    }

    public List<RefBaseObject> getElementsRemoved( ) {

        if ( elementsRemovedMri != null ) {
            List<RefBaseObject> elementsRemoved = new ArrayList<RefBaseObject>( elementsRemovedMri.size( ) );
            for ( int i = 0; i < elementsRemovedMri.size( ); i++ ) {
                MRI elementRemovedMri = elementsRemovedMri.get( i );
                if ( elementsRepartitionedMri != null && elementsRepartitionedMri.contains( elementRemovedMri ) ) {
                    // ok, we did repartition the element
                    PRI newPartitionPri = (PRI) affectedElementStates.get( elementRemovedMri ).getFinalState( ).get( StateSet.STATE_PARAMETER_PRI );
                    // can not use old MRI because it has changed after
                    // repartitioning during do phase
                    elementRemovedMri = newPartitionPri.createMri( elementRemovedMri.getMofId( ) );
                }
                elementsRemoved.add( (RefBaseObject) getExistingElement( elementRemovedMri ) );
            }
            return elementsRemoved;
        }
        return Collections.emptyList( );
    }
}