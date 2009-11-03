package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import static com.sap.tc.moin.repository.JmiHelper.MULTIPLICITY_BOUND_INFINITE;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.reflect.InvalidCallException;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.TypeMismatchException;
import com.sap.tc.moin.repository.mmi.reflect.WrongSizeException;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.transactions.actions.ActionFactory;
import com.sap.tc.moin.repository.core.transactions.actions.NotifyDanglingLinkAction;
import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.transactions.microtransactionables.LinkAddElementMicroTransactionable;

@SuppressWarnings( "unchecked" )
public class LinkAddElementMicroTransactionableImpl extends AbstractMicroTransactionable implements LinkAddElementMicroTransactionable {

    private DoContext doContext = null;

    private boolean linkSetChanged = false;

    private RefObject elementAtFromEnd = null;

    private byte fromEndNumber = -1;

    private byte toEndNumber = -1;

    private int index = -1;

    private int[] indices = null;

    private List<Object> elementsToAdd = null;

    private ArrayList<EndStorageLink> linksAdded = null;

    private List<MRI> elementsRepartitionedMri = null;

    private Map<MRI, StateSet> affectedElementStates = null;

    private boolean danglingLinkCreation = false;

    /**
     * Creates a Micro Transactionable that adds links between the element
     * <code>anElementAtFromEnd</code> at the end with the number <code>0</code>
     * of the Association <code>anAssociation</code> and the given elements
     * <code>theElementsToAddAtToEnd</code>
     */
    public LinkAddElementMicroTransactionableImpl( CoreConnection aConnection, Association anAssociation, RefObject anElementAtFromEnd, Collection theElementsToAddAtToEnd ) {

        this( aConnection, anAssociation, anElementAtFromEnd, (byte) 0, theElementsToAddAtToEnd );
    }

    /**
     * Creates a Micro Transactionable that adds links between the element
     * <code>anElementAtFromEnd</code> at the end with the number
     * <code>aFromEndNumber</code> of the Association <code>anAssociation</code>
     * and the given elements <code>theElementsToAddAtToEnd</code>
     */
    public LinkAddElementMicroTransactionableImpl( CoreConnection aConnection, Association anAssociation, RefObject anElementAtFromEnd, byte aFromEndNumber, Collection theElementsToAddAtToEnd ) {

        this( aConnection, anAssociation, anElementAtFromEnd, aFromEndNumber, -1, theElementsToAddAtToEnd );
    }

    /**
     * Creates a Micro Transactionable that adds links at position
     * <code>anIndex</code> between the element <code>anElementAtFromEnd</code>
     * at the end with the number <code>aFromEndNumber</code> of the Association
     * <code>anAssociation</code> and the given elements
     * <code>theElementsToAddAtToEnd</code>
     */
    public LinkAddElementMicroTransactionableImpl( CoreConnection aConnection, Association anAssociation, RefObject anElementAtFromEnd, byte aFromEndNumber, int anIndex, LRI target ) {

        this( aConnection, anAssociation, anElementAtFromEnd, aFromEndNumber, anIndex, Collections.singletonList( target ) );
        danglingLinkCreation = true;
    }

    /**
     * Creates a Micro Transactionable that adds links at position
     * <code>anIndex</code> between the element <code>anElementAtFromEnd</code>
     * at the end with the number <code>aFromEndNumber</code> of the Association
     * <code>anAssociation</code> and the given elements
     * <code>theElementsToAddAtToEnd</code>
     */
    public LinkAddElementMicroTransactionableImpl( CoreConnection aConnection, Association anAssociation, RefObject anElementAtFromEnd, byte aFromEndNumber, int anIndex, Collection theElementsToAddAtToEnd ) {

        super( aConnection );
        elementAtFromEnd = anElementAtFromEnd;
        fromEndNumber = aFromEndNumber;
        toEndNumber = (byte) ( 1 - aFromEndNumber );
        List<AssociationEnd> ends = getJmiHelper( ).getAssociationEnds( aConnection.getSession( ), anAssociation );
        doContext = new DoContext( anAssociation, ends.get( aFromEndNumber ), ends.get( 1 - aFromEndNumber ) );
        index = anIndex;
        if ( theElementsToAddAtToEnd != null ) {

            if ( theElementsToAddAtToEnd instanceof JmiList ) {
                JmiList elements = (JmiList) theElementsToAddAtToEnd;
                elementsToAdd = new ArrayList( elements.size( aConnection.getSession( ) ) );
                for ( Iterator it = elements.iterator( aConnection ); it.hasNext( ); ) {
                    elementsToAdd.add( it.next( ) );
                }
            } else {
                elementsToAdd = new ArrayList( theElementsToAddAtToEnd );
            }

            // eliminate duplicates
            // note that association ends are always unique, MOF Constraint C-40 (EndsMustBeUnique)
            eliminateDuplicates( elementsToAdd );
        }
    }

    @Override
    public void assertDoPreConstraints( ) throws JmiException, MoinNullPointerException {

        if ( !doContext.fromEnd.isChangeable( ) ) {
            // both ends have to be changeable, if not throw an InvalidCallException (reasonable according to JMI Spec, 4.8.4 (page 62), 5.2.3 (page 86))
            InvalidCallException exception = new InvalidCallException( doContext.association, doContext.fromEnd, MicroTransactionablesMessages.ASSOCIATIONENDSHAVETOBECHANGABLE );
            log.preConstraintCheckException( exception );
            throw exception;
        }
        if ( !doContext.toEnd.isChangeable( ) ) {
            // both ends have to be changeable, if not throw an InvalidCallException (reasonable according to JMI Spec, 4.8.4 (page 62), 5.2.3 (page 86))
            InvalidCallException exception = new InvalidCallException( doContext.association, doContext.toEnd, MicroTransactionablesMessages.ASSOCIATIONENDSHAVETOBECHANGABLE );
            log.preConstraintCheckException( exception );
            throw exception;
        }
        if ( elementAtFromEnd == null ) {
            // setting an association end to null results in a MoinNullPointerException (JMI Spec, 4.8.4 (page 65), 5.2.3 (page 87))
            MoinNullPointerException exception = new MoinNullPointerException( MicroTransactionablesMessages.ASSOCIATIONENDSCANNOTBENULL );
            log.preConstraintCheckException( exception );
            throw exception;
        }
        Classifier fromType = getJmiHelper( ).getType( connection.getSession( ), doContext.fromEnd );
        if ( !( (RefObjectImpl) elementAtFromEnd ).refIsInstanceOf( connection.getSession( ), fromType, true ) ) {
            // element at from end is not of the correct end type (JMI Spec, 4.8.4 (page 65), 5.2.3 (page 87))
            TypeMismatchException exception = new TypeMismatchException( fromType.getClass( ), elementAtFromEnd, doContext.association, MicroTransactionablesMessages.ASSOCIATIONENDHASWRONGTYPE, doContext.fromEnd.getName( ), doContext.association.getName( ), fromType.getName( ), elementAtFromEnd
                .getClass( ) );
            log.preConstraintCheckException( exception );
            throw exception;
        }
        if ( elementsToAdd != null ) {
            for ( int i = 0; i < elementsToAdd.size( ); i++ ) {
                Object elementToAdd = elementsToAdd.get( i );
                Object elementToCheckType = null;
                if ( elementToAdd == null ) {
                    // setting an association end to null results in a MoinNullPointerException (JMI Spec, 4.8.4 (page 65), 5.2.3 (page 87))
                    MoinNullPointerException exception = new MoinNullPointerException( MicroTransactionablesMessages.ASSOCIATIONENDSCANNOTBENULL );
                    log.preConstraintCheckException( exception );
                    throw exception;
                }
                if ( danglingLinkCreation ) {
                    //do the type check only if the target is loaded (we don't want to trigger loading of a partition just for the check)
                    //TODO enable type check also for not loaded, but existing elements
                    Collection<CorePartitionable> lris = getWorkspaceSet( ).resolveLriInMemoryIncludingInconsistencies( this.connection.getSession( ), (LRI) elementToAdd );
                    Iterator<CorePartitionable> iterator = lris.iterator( );
                    if ( iterator.hasNext( ) ) {
                        elementToCheckType = iterator.next( );
                    }
                } else {
                    elementToCheckType = elementToAdd;
                }
                if ( elementToCheckType != null ) {
                    if ( !( elementToCheckType instanceof RefObject && ( (RefObjectImpl) elementToCheckType ).refIsInstanceOf( connection.getSession( ), getJmiHelper( ).getType( connection.getSession( ), doContext.toEnd ), true ) ) ) {
                        // elementToAdd is either not a RefObject or it is not of the correct end type (JMI Spec, 4.8.4 (page 65), 5.2.3 (page 87))
                        TypeMismatchException exception = new TypeMismatchException( getJmiHelper( ).getType( connection.getSession( ), doContext.toEnd ).getClass( ), elementToCheckType, doContext.association, MicroTransactionablesMessages.ASSOCIATIONENDHASWRONGTYPE, doContext.toEnd.getName( ),
                                                                                     doContext.association.getName( ), getJmiHelper( ).getType( connection.getSession( ), doContext.toEnd ).getName( ), elementToCheckType.getClass( ) );
                        log.preConstraintCheckException( exception );
                        throw exception;
                    }
                }
            }
        }
    }

    @Override
    public void assertDoPostConstraints( ) throws JmiException {

        if ( linksAdded != null ) {
            int toEndUpperBound = doContext.toEnd.getMultiplicity( ).getUpper( );
            if ( toEndUpperBound != MULTIPLICITY_BOUND_INFINITE ) {
                // only check upper bound if not unbounded
                int size = getLogicalLinkManager( ).getNumberOfElementsForEndAndMetaObjectIncludingOverflows( connection.getSession( ), getWorkspaceSet( ).getEndAndMetaObjectPool( ).getEndAndMetaObject( fromEndNumber, doContext.association ), (CorePartitionable) elementAtFromEnd );
                if ( size > toEndUpperBound ) {
                    // upper multiplicity at the to-side violated
                    WrongSizeException exception = new WrongSizeException( doContext.toEnd, MicroTransactionablesMessages.ASSOCIATIONENDHASUPPERMULTIPLICITY, doContext.toEnd.getName( ), doContext.association.getName( ), toEndUpperBound );
                    log.preConstraintCheckException( exception );
                    throw exception;
                }
            }
            if ( !danglingLinkCreation ) {
                int fromEndUpperBound = doContext.fromEnd.getMultiplicity( ).getUpper( );
                if ( fromEndUpperBound != MULTIPLICITY_BOUND_INFINITE ) {
                    // only check upper bound if not unbounded
                    for ( int i = 0; i < elementsToAdd.size( ); i++ ) {
                        CorePartitionable elementToAdd = (CorePartitionable) elementsToAdd.get( i );
                        MRI elementToAddMri = elementToAdd.get___Mri( );
                        if ( elementsRepartitionedMri != null && elementsRepartitionedMri.contains( elementToAddMri ) ) {
                            // ok, we did repartition the element
                            PRI newPartitionPri = (PRI) affectedElementStates.get( elementToAddMri ).getFinalState( ).get( StateSet.STATE_PARAMETER_PRI );
                            // can not use old MRI because it has changed after repartitioning during do phase
                            elementToAdd = getExistingElement( newPartitionPri.createMri( elementToAddMri.getMofId( ) ) );
                        }
                        int size = getLogicalLinkManager( ).getNumberOfElementsForEndAndMetaObjectIncludingOverflows( connection.getSession( ), getWorkspaceSet( ).getEndAndMetaObjectPool( ).getEndAndMetaObject( toEndNumber, doContext.association ), elementToAdd );
                        if ( size > fromEndUpperBound ) {
                            // upper multiplicity at the from-side violated
                            WrongSizeException exception = new WrongSizeException( doContext.fromEnd, MicroTransactionablesMessages.ASSOCIATIONENDHASUPPERMULTIPLICITY, doContext.fromEnd.getName( ), doContext.association.getName( ), fromEndUpperBound );
                            log.preConstraintCheckException( exception );
                            throw exception;
                        }
                    }
                }
                // composition cycle and closure rule violation detection
                for ( int i = 0; i < linksAdded.size( ); i++ ) {
                    EndStorageLink linkAdded = linksAdded.get( i );
                    assertCompositionCycle( linkAdded );
                    assertCompositionClosure( linkAdded );
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

        if ( linksAdded != null ) {
            // link remove actions and events
            boolean eventCreationNeeded = eventCreationNeeded( );
            for ( int i = 0; i < linksAdded.size( ); i++ ) {
                EndStorageLink linkAdded = linksAdded.get( i );
                List<AssociationEnd> ends = connection.getCoreJmiHelper( ).getAssociationEnds( connection.getSession( ), (Association) linkAdded.getMetaObject( ) );
                getOrCreateDoActions( ).add( ActionFactory.createEndStorageLinkRemoveAction( connection, linkAdded.getStorageEnd( ).getMri( ), ends.get( linkAdded.getEndNumberOfOtherEnd( ) ).refMofId( ), linkAdded, indices[i] ) );
                if ( eventCreationNeeded ) {

                    getOrCreateUndoEvents( ).add( getEventFactory( ).createLinkRemoveEvent( connection, linkAdded, indices[i] ) );
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
        elementsToAdd = null;
        doContext = null;
        if ( linksAdded != null ) {
            linksAdded.trimToSize( );
        }
    }

    private void computeDoActionsAndDoEvents( boolean doCase ) {

        if ( doCase ) {
            // compute the links to add, the affected partitions and the elements to repartition
            if ( elementsToAdd != null ) {
                JmiList elementsAtToEnd = getLogicalLinkManager( ).getElementsForEndAndMetaobject( connection, getWorkspaceSet( ).getEndAndMetaObjectPool( ).getEndAndMetaObject( fromEndNumber, doContext.association ), (CorePartitionable) elementAtFromEnd );
                boolean isToEndOrdered = doContext.toEnd.getMultiplicity( ).isOrdered( );
                int indexToAdd = ( index == -1 && isToEndOrdered ) ? elementsAtToEnd.size( connection.getSession( ) ) : index;
                byte compositeEndNumber = getJmiHelper( ).getCompositeEnd( connection.getSession( ), doContext.association );
                boolean isComposition = ( compositeEndNumber != -1 );
                Set<PRI> affectedPartitionsPri = new HashSet<PRI>( );
                linksAdded = new ArrayList<EndStorageLink>( elementsToAdd.size( ) );
                indices = new int[elementsToAdd.size( )];

                copyOnWrite( doCase );

                for ( int i = 0, indicesCounter = 0; i < elementsToAdd.size( ); i++ ) {
                    EndStorageLink linkToAdd;
                    if ( !danglingLinkCreation ) {
                        MRI elementToAddMri = ( (CorePartitionable) elementsToAdd.get( i ) ).get___Mri( );
                        CorePartitionable elementToAdd = getExistingElement( elementToAddMri );
                        CorePartitionable[] ends = constructEnds( (CorePartitionable) elementAtFromEnd, fromEndNumber, elementToAdd, toEndNumber );
                        // link to add and affected partitions
                        linkToAdd = getLogicalLinkManager( ).createLink( connection.getSession( ), ends[0], ends[1], doContext.association, true );
                    } else {//danglingLinkCreation
                        linkToAdd = getLogicalLinkManager( ).createLink( connection.getSession( ), (CorePartitionable) elementAtFromEnd, (LRI) elementsToAdd.get( 0 ), fromEndNumber, doContext.association );
                    }

                    if ( !isAssociationLinkAlreadyExisting( linkToAdd ) ) {
                        // note that association ends are always unique, MOF Constraint C-40 (EndsMustBeUnique)
                        assertNoCompositeLinkToMetamodelIfStorageAtParent( linkToAdd );
                        linksAdded.add( linkToAdd );
                        indices[indicesCounter] = indexToAdd;
                        indicesCounter++;
                        affectedPartitionsPri.add( linkToAdd.getStorageEnd( ).getPri( ) );

                        if ( !danglingLinkCreation ) {
                            // elements to repartition and affected partitions
                            if ( isComposition ) {
                                CorePartitionable compositeEnd = linkToAdd.getEnd( linkToAdd.getCompositeEnd( ) ).get( connection.getSession( ) );
                                CorePartitionable componentEnd = linkToAdd.getEnd( linkToAdd.getComponentEnd( ) ).get( connection.getSession( ) );
                                List<CorePartitionable> elementsToRepartition = getElementsToRepartitionAfterLinkAdd( doContext.association, compositeEndNumber, componentEnd, compositeEnd.get___Partition( ) );
                                if ( elementsRepartitionedMri == null ) {
                                    elementsRepartitionedMri = new ArrayList<MRI>( elementsToRepartition.size( ) );
                                }
                                if ( affectedElementStates == null ) {
                                    affectedElementStates = new HashMap<MRI, StateSet>( Utilities.calcInitialCapacity( elementsToRepartition.size( ) ) );
                                }
                                for ( CorePartitionable elementToRepartition : elementsToRepartition ) {
                                    PRI oldPartitionPri = elementToRepartition.get___Partition( ).getPri( );
                                    PRI newPartitionPri = compositeEnd.get___Partition( ).getPri( );
                                    Map<String, Object> initialState = StateSet.createState( StateSet.STATE_PARAMETER_PRI, oldPartitionPri );
                                    Map<String, Object> finalState = StateSet.createState( StateSet.STATE_PARAMETER_PRI, newPartitionPri );
                                    elementsRepartitionedMri.add( elementToRepartition.get___Mri( ) );
                                    affectedElementStates.put( elementToRepartition.get___Mri( ), new StateSet( initialState, finalState ) );
                                    affectedPartitionsPri.add( oldPartitionPri );
                                    affectedPartitionsPri.add( newPartitionPri );
                                }
                            }
                        }
                    }
                    indexToAdd = indexToAdd != -1 ? indexToAdd + 1 : -1;
                }
                // fulfill the contract, lists should be null if nothing should be done
                linksAdded = ( linksAdded.size( ) == 0 ) ? null : linksAdded;
                PRI[] affectedPartitionPris = affectedPartitionsPri.toArray( new PRI[affectedPartitionsPri.size( )] );
                computePartitionsToLock( affectedPartitionPris );
                computePartitionsToEnsureEditing( affectedPartitionPris );
                computePartitionsToMarkDirty( affectedPartitionPris );
            }
        }
        // actions and events
        if ( linksAdded != null ) {
            // actions and events
            // aquire lock actions
            addEditLockActionsToDoActions( );
            // ensure editing allowed actions
            addEnsureEditingActionsToDoActions( );
            // link add actions and events
            boolean eventCreationNeeded = eventCreationNeeded( );
            for ( int i = 0; i < linksAdded.size( ); i++ ) {
                EndStorageLink linkAdded = linksAdded.get( i );
                List<AssociationEnd> ends = connection.getCoreJmiHelper( ).getAssociationEnds( connection.getSession( ), (Association) linkAdded.getMetaObject( ) );
                getOrCreateDoActions( ).add( ActionFactory.createEndStorageLinkAddAction( connection, linkAdded.getStorageEnd( ).getMri( ), ends.get( linkAdded.getEndNumberOfOtherEnd( ) ).refMofId( ), linkAdded, indices[i] ) );
                if ( eventCreationNeeded ) {
                    getOrCreateDoEvents( ).add( getEventFactory( ).createLinkAddEvent( connection, linkAdded, indices[i] ) );
                }
            }

            if ( danglingLinkCreation ) {
                //check if really dangling
                EndStorageLink link = linksAdded.get( 0 );
                LRI lri = link.getOtherEnd( ).getLri( );
                if ( !this.connection.getSession( ).getWorkspaceSet( ).lriExists( this.connection.getSession( ), lri ) ) {
                    getOrCreateDoActions( ).add( new NotifyDanglingLinkAction( this.connection, link, lri ) );
                    //no explicit "ResolvedDanglingLinkAction" needed on undo, because will be implicitly done on link removal
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

        if ( doCase ) {//do
            byte storedEnd = getJmiHelper( ).getStoredEnd( connection.getSession( ), doContext.association );
            if ( storedEnd == fromEndNumber ) {
                CorePartitionable coreElement = ( (CorePartitionable) elementAtFromEnd );
                if ( coreElement.get___Workspace( ) == connection.getSession( ).getCompoundClientSpecWorkspace( ) ) {
                    createPrivateCopy( coreElement.get___Partition( ).getPri( ) );
                    elementAtFromEnd = (RefObject) getExistingElement( coreElement.get___Mri( ) );
                }
            } else {
                Set<PRI> affectedPartitions = new HashSet<PRI>( );
                for ( int i = 0, n = elementsToAdd.size( ); i < n; i++ ) {
                    CorePartitionable element = (CorePartitionable) elementsToAdd.get( i );
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

    private final static class DoContext {

        Association association;

        AssociationEnd fromEnd;

        AssociationEnd toEnd;

        DoContext( Association anAssociation, AssociationEnd aFromEnd, AssociationEnd aToEnd ) {

            association = anAssociation;
            fromEnd = aFromEnd;
            toEnd = aToEnd;
        }
    }
}