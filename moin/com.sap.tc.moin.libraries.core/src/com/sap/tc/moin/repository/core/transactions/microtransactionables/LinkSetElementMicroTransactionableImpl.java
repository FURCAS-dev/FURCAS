package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndInternal;
import com.sap.tc.moin.repository.mmi.reflect.DuplicateException;
import com.sap.tc.moin.repository.mmi.reflect.InvalidCallException;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
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
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.transactions.microtransactionables.LinkSetElementMicroTransactionable;

@SuppressWarnings( "unchecked" )
public class LinkSetElementMicroTransactionableImpl extends AbstractMicroTransactionable implements LinkSetElementMicroTransactionable {

    private RefObject elementAtFromEnd = null;

    private Association association = null;

    private AssociationEnd fromEnd = null;

    private byte fromEndNumber = -1;

    private AssociationEnd toEnd = null;

    private byte toEndNumber = -1;

    private int index = -1;

    private Object elementToAdd = null;

    private CorePartitionable elementToRemove = null;

    private MRI elementToRemoveMri = null;

    private EndStorageLink linkAdded = null;

    private EndStorageLink linkRemoved = null;

    private List<MRI> elementsRepartitionedMri = null;

    private Map<MRI, StateSet> affectedElementStates = null;

    /**
     * Creates a Micro Transactionable that changes the link at position
     * <code>index</code> of a link list
     */
    public LinkSetElementMicroTransactionableImpl( CoreConnection aConnection, Association anAssociation, RefObject anElementAtFromEnd, byte aFromEndNumber, int anIndex, Object anElementToSetAtToEnd ) {

        super( aConnection );
        elementAtFromEnd = anElementAtFromEnd;
        fromEndNumber = aFromEndNumber;
        toEndNumber = (byte) ( 1 - aFromEndNumber );
        association = anAssociation;
        List<AssociationEnd> ends = getJmiHelper( ).getAssociationEnds( aConnection.getSession( ), anAssociation );
        fromEnd = ends.get( aFromEndNumber );
        toEnd = ends.get( 1 - aFromEndNumber );
        index = anIndex;
        elementToAdd = anElementToSetAtToEnd;
    }

    @Override
    public void assertDoPreConstraints( ) throws JmiException, MoinNullPointerException {

        if ( !fromEnd.isChangeable( ) ) {
            // both ends have to be changeable, if not throw an InvalidCallException (reasonable according to JMI Spec, 4.8.4 (page 62), 5.2.3 (page 86))
            InvalidCallException exception = new InvalidCallException( association, fromEnd, MicroTransactionablesMessages.ASSOCIATIONENDSHAVETOBECHANGABLE );
            log.preConstraintCheckException( exception );
            throw exception;
        }
        if ( !toEnd.isChangeable( ) ) {
            // both ends have to be changeable, if not throw an InvalidCallException (reasonable according to JMI Spec, 4.8.4 (page 62), 5.2.3 (page 86))
            InvalidCallException exception = new InvalidCallException( association, toEnd, MicroTransactionablesMessages.ASSOCIATIONENDSHAVETOBECHANGABLE );
            log.preConstraintCheckException( exception );
            throw exception;
        }
        if ( elementToAdd == null ) {
            // setting an association end to null results in a MoinNullPointerException (JMI Spec, 4.8.4 (page 65))
            MoinNullPointerException exception = new MoinNullPointerException( MicroTransactionablesMessages.ASSOCIATIONENDSCANNOTBESETTONULL );
            log.preConstraintCheckException( exception );
            throw exception;
        }
        Classifier toEndType = ( (AssociationEndInternal) toEnd ).getType( connection );
        if ( !( elementToAdd instanceof RefObject && ( (RefObjectImpl) elementToAdd ).refIsInstanceOf( connection.getSession( ), toEndType, true ) ) ) {
            // elementToSet is either not a RefObject or it is not of the correct end type (JMI Spec, page 65)
            TypeMismatchException exception = new TypeMismatchException( toEndType.getClass( ), elementToAdd, association, MicroTransactionablesMessages.ASSOCIATIONENDHASWRONGTYPE, toEnd.getName( ), association.getName( ), toEndType.getName( ), elementToAdd.getClass( ) );
            log.preConstraintCheckException( exception );
            throw exception;
        }
        JmiList elementsAtToEnd = getLogicalLinkManager( ).getElementsForEndAndMetaobject( connection, getWorkspaceSet( ).getEndAndMetaObjectPool( ).getEndAndMetaObject( fromEndNumber, association ), (CorePartitionable) elementAtFromEnd );
        if ( elementsAtToEnd.contains( connection, elementToAdd ) ) {
            DuplicateException exception = new DuplicateException( elementToAdd, association, MicroTransactionablesMessages.ASSOCIATIONENDALREADYCONTAINSELEMENT, toEnd.getName( ), association.getName( ), elementToAdd );
            log.preConstraintCheckException( exception );
            throw exception;
        }
        elementToRemove = (CorePartitionable) elementsAtToEnd.get( connection.getSession( ), index );
        elementToRemoveMri = elementToRemove.get___Mri( );
    }

    @Override
    public void assertDoPostConstraints( ) throws JmiException {

        // composition cycle and closure rule violation detection
        assertCompositionCycle( linkAdded );
        assertCompositionClosure( linkAdded );

    }

    @Override
    public void computeDoActionsAndDoEvents( ) {

        computeDoActionsAndDoEvents( true );
    }

    @Override
    public void computeUndoActionsAndUndoEvents( ) {

        // actions and events, remove before add
        List<AssociationEnd> ends = connection.getCoreJmiHelper( ).getAssociationEnds( connection.getSession( ), (Association) linkAdded.getMetaObject( ) );
        getOrCreateDoActions( ).add( ActionFactory.createEndStorageLinkRemoveAction( connection, linkAdded.getStorageEnd( ).getMri( ), ends.get( linkAdded.getEndNumberOfOtherEnd( ) ).refMofId( ), linkAdded, index ) );
        ends = connection.getCoreJmiHelper( ).getAssociationEnds( connection.getSession( ), (Association) linkRemoved.getMetaObject( ) );
        getOrCreateDoActions( ).add( ActionFactory.createEndStorageLinkAddAction( connection, linkRemoved.getStorageEnd( ).getMri( ), ends.get( linkRemoved.getEndNumberOfOtherEnd( ) ).refMofId( ), linkRemoved, index ) );
        boolean eventCreationNeeded = eventCreationNeeded( );
        if ( eventCreationNeeded ) {
            getOrCreateUndoEvents( ).add( getEventFactory( ).createLinkRemoveEvent( connection, linkAdded, index ) );
            getOrCreateUndoEvents( ).add( getEventFactory( ).createLinkAddEvent( connection, linkRemoved, index ) );
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
        elementToAdd = null;
        elementToRemove = null;
        elementAtFromEnd = null;
    }

    private void computeDoActionsAndDoEvents( boolean doCase ) {

        if ( doCase ) {
            int compositeEndNumber = getJmiHelper( ).getCompositeEnd( connection.getSession( ), association );
            boolean isComposition = ( compositeEndNumber != -1 );

            copyOnWrite( doCase );

            CorePartitionable[] newEnds = constructEnds( (CorePartitionable) elementAtFromEnd, fromEndNumber, (CorePartitionable) elementToAdd, toEndNumber );
            CorePartitionable[] oldEnds = constructEnds( (CorePartitionable) elementAtFromEnd, fromEndNumber, elementToRemove, toEndNumber );
            // compute the links to add and to remove, the affected partitions and the elements to repartition link to add
            linkAdded = getLogicalLinkManager( ).createLink( connection.getSession( ), newEnds[0], newEnds[1], association, true );
            assertNoCompositeLinkToMetamodelIfStorageAtParent( linkAdded );
            // link to remove
            linkRemoved = getLogicalLinkManager( ).getLink( connection.getSession( ), oldEnds[0], oldEnds[1], association, true );
            // their affected partitions
            Set<PRI> affectedPartitionsPri = new HashSet<PRI>( Utilities.calcInitialCapacity( 4 ) );
            affectedPartitionsPri.add( linkRemoved.getStorageEndMri( ).getPri( ) );
            affectedPartitionsPri.add( linkAdded.getStorageEndMri( ).getPri( ) );
            // elements to repartition and affected partitions
            if ( isComposition ) {
                // currently the same as link addition, but who knows, perhaps this will change in the future
                CorePartitionable compositeEnd = linkAdded.getEnd( linkAdded.getCompositeEnd( ) ).get( connection.getSession( ) );
                CorePartitionable componentEnd = linkAdded.getEnd( linkAdded.getComponentEnd( ) ).get( connection.getSession( ) );
                List<CorePartitionable> elementsToRepartition = getElementsToRepartitionAfterLinkAdd( association, compositeEndNumber, componentEnd, compositeEnd.get___Partition( ) );
                PRI newPartitionPri = compositeEnd.get___Partition( ).getPri( );
                if ( !elementsToRepartition.isEmpty( ) ) {
                    if ( elementsRepartitionedMri == null ) {
                        elementsRepartitionedMri = new ArrayList<MRI>( elementsToRepartition.size( ) );
                    }
                    if ( affectedElementStates == null ) {
                        affectedElementStates = new HashMap<MRI, StateSet>( Utilities.calcInitialCapacity( elementsToRepartition.size( ) ) );
                    }
                    affectedPartitionsPri.add( newPartitionPri );
                    for ( CorePartitionable elementToRepartition : elementsToRepartition ) {
                        PRI oldPartitionPri = elementToRepartition.get___Partition( ).getPri( );
                        Map<String, Object> initialState = StateSet.createState( StateSet.STATE_PARAMETER_PRI, oldPartitionPri );
                        Map<String, Object> finalState = StateSet.createState( StateSet.STATE_PARAMETER_PRI, newPartitionPri );
                        elementsRepartitionedMri.add( elementToRepartition.get___Mri( ) );
                        affectedElementStates.put( elementToRepartition.get___Mri( ), new StateSet( initialState, finalState ) );
                        affectedPartitionsPri.add( oldPartitionPri );
                    }
                }
            }
            PRI[] affectedPartitionPris = affectedPartitionsPri.toArray( new PRI[affectedPartitionsPri.size( )] );
            computePartitionsToLock( affectedPartitionPris );
            computePartitionsToEnsureEditing( affectedPartitionPris );
            computePartitionsToMarkDirty( affectedPartitionPris );
        }
        // actions and events
        // aquire lock actions
        addEditLockActionsToDoActions( );
        // ensure editing allowed actions
        addEnsureEditingActionsToDoActions( );
        // link remove action and event, before add action
        List<AssociationEnd> ends = connection.getCoreJmiHelper( ).getAssociationEnds( connection.getSession( ), (Association) linkRemoved.getMetaObject( ) );
        getOrCreateDoActions( ).add( ActionFactory.createEndStorageLinkRemoveAction( connection, linkRemoved.getStorageEnd( ).getMri( ), ends.get( linkRemoved.getEndNumberOfOtherEnd( ) ).refMofId( ), linkRemoved, index ) );
        boolean eventCreationNeeded = eventCreationNeeded( );
        if ( eventCreationNeeded ) {
            getOrCreateDoEvents( ).add( getEventFactory( ).createLinkRemoveEvent( connection, linkRemoved, index ) );
        } // link add action and event
        ends = connection.getCoreJmiHelper( ).getAssociationEnds( connection.getSession( ), (Association) linkAdded.getMetaObject( ) );
        getOrCreateDoActions( ).add( ActionFactory.createEndStorageLinkAddAction( connection, linkAdded.getStorageEnd( ).getMri( ), ends.get( linkAdded.getEndNumberOfOtherEnd( ) ).refMofId( ), linkAdded, index ) );
        if ( eventCreationNeeded ) {
            getOrCreateDoEvents( ).add( getEventFactory( ).createLinkAddEvent( connection, linkAdded, index ) );
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
                CorePartitionable coreElement = ( (CorePartitionable) elementToAdd );
                if ( coreElement.get___Workspace( ) == connection.getSession( ).getCompoundClientSpecWorkspace( ) ) {
                    createPrivateCopy( coreElement.get___Partition( ).getPri( ) );
                    elementToAdd = getExistingElement( coreElement.get___Mri( ) );
                }
                if ( elementToRemove.get___Workspace( ) == connection.getSession( ).getCompoundClientSpecWorkspace( ) ) {
                    createPrivateCopy( elementToRemove.get___Partition( ).getPri( ) );
                    elementToRemove = getExistingElement( elementToRemove.get___Mri( ) );
                }
            }
        } else {//redo
            List<PRI> affectedPartitionsForRedo = getAffectedPartitionsForCopyOnWriteRedo( );
            for ( int i = 0; i < affectedPartitionsForRedo.size( ); i++ ) {
                createPrivateCopy( affectedPartitionsForRedo.get( i ) );
            }
        }
    }

    public Object getElementReplaced( ) {

        MRI newMri = elementToRemoveMri;
        if ( elementsRepartitionedMri != null && elementsRepartitionedMri.contains( elementToRemoveMri ) ) {
            // ok, we did repartition the element
            PRI newPartitionPri = (PRI) affectedElementStates.get( elementToRemoveMri ).getFinalState( ).get( StateSet.STATE_PARAMETER_PRI );
            // can not use old MRI because it has changed after repartitioning during do phase
            newMri = newPartitionPri.createMri( elementToRemoveMri.getMofId( ) );
        }
        return getExistingElement( newMri );
    }
}