package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.events.type.AttributeValueEvent;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.transactions.actions.Action;
import com.sap.tc.moin.repository.transactions.microtransactionables.InstanceDeleteMicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.PartitionDeleteElementsMicroTransactionable;

public class PartitionDeleteElementsMicroTransactionableImpl extends AbstractMicroTransactionable implements PartitionDeleteElementsMicroTransactionable {

    private PRI partitionPri = null;

    private List<InstanceDeleteMicroTransactionable> idmtxs = new ArrayList<InstanceDeleteMicroTransactionable>( );

    public PartitionDeleteElementsMicroTransactionableImpl( CoreConnection aConnection, CoreModelPartition aPartition ) {

        super( aConnection );
        partitionPri = aPartition.getPri( );
        copyOnWrite( aPartition );
    }

    private void copyOnWrite( CoreModelPartition aPartition ) {

        if ( aPartition.getWorkspace( ) == connection.getSession( ).getCompoundClientSpecWorkspace( ) ) {
            createPrivateCopy( aPartition.getPri( ) );
        }
    }

    @Override
    public void assertDoPostConstraints( ) {

        for ( InstanceDeleteMicroTransactionable idmtx : idmtxs ) {
            idmtx.assertDoPostConstraints( );
        }
    }

    @Override
    public void assertDoPreConstraints( ) {

        CoreModelPartition partition = connection.getPartition( partitionPri );
        for ( Partitionable partitionable : partition.getElements( ) ) {
            idmtxs.add( new InstanceDeleteMicroTransactionableImpl( connection, (RefObject) partitionable ) );
        }
        for ( InstanceDeleteMicroTransactionable idmtx : idmtxs ) {
            idmtx.assertDoPreConstraints( );
        }
    }

    @Override
    public void assertUndoPostConstraints( ) {

        for ( InstanceDeleteMicroTransactionable idmtx : idmtxs ) {
            idmtx.assertUndoPostConstraints( );
        }
    }

    @Override
    public void assertUndoPreConstraints( ) {

        for ( InstanceDeleteMicroTransactionable idmtx : idmtxs ) {
            idmtx.assertUndoPreConstraints( );
        }
    }

    @Override
    public void computeDoActionsAndDoEvents( ) {

        // collect actions and events from other MicroTransactionables
        Set<Action> actions = new LinkedHashSet<Action>( 0 );
        Set<ChangeEvent> events = new LinkedHashSet<ChangeEvent>( 0 );
        boolean eventCreationNeeded = eventCreationNeeded( );
        for ( InstanceDeleteMicroTransactionable idmtx : idmtxs ) {
            idmtx.computeDoActionsAndDoEvents( );
            actions.addAll( idmtx.getDoActions( ) );
            if ( eventCreationNeeded ) {
                events.addAll( idmtx.getDoEvents( ) );
            }
        }
        computeDoActionsAndDoEvents( actions, events );
    }

    @Override
    public void computeUndoActionsAndUndoEvents( ) {

        // collect actions and events from other MicroTransactionables
        // preserve stable ordering, prevent duplicates, throw away wrong
        // entries and sort them
        Set<Action> actions = new LinkedHashSet<Action>( 0 );
        Set<ChangeEvent> events = new LinkedHashSet<ChangeEvent>( 0 );
        boolean eventCreationNeeded = eventCreationNeeded( );
        for ( InstanceDeleteMicroTransactionable idmtx : idmtxs ) {
            idmtx.computeUndoActionsAndUndoEvents( );
            actions.addAll( idmtx.getUndoActions( ) );
            if ( eventCreationNeeded ) {
                events.addAll( idmtx.getUndoEvents( ) );
            }
        }
        if ( !actions.isEmpty( ) ) {
            List<Action> undoActions = getOrCreateUndoActions( );
            undoActions.addAll( actions );
            Collections.sort( undoActions, ActionCreateComparator.instance );
        }
        if ( !events.isEmpty( ) ) {
            eliminateInstancesOf( events, AttributeValueEvent.class );
            List<ChangeEvent> undoEvents = getOrCreateUndoEvents( );
            undoEvents.addAll( events );
            Collections.sort( undoEvents, EventComparator.instance );
        }
    }

    @Override
    public void computeRedoActionsAndRedoEvents( ) {

        // collect actions and events from other MicroTransactionables
        Set<Action> actions = new LinkedHashSet<Action>( 0 );
        Set<ChangeEvent> events = new LinkedHashSet<ChangeEvent>( 0 );
        for ( InstanceDeleteMicroTransactionable idmtx : idmtxs ) {
            idmtx.computeRedoActionsAndRedoEvents( );
            actions.addAll( idmtx.getRedoActions( ) );
            List<ChangeEvent> redoEvents = idmtx.getRedoEvents( );
            if ( redoEvents != null ) {
                events.addAll( redoEvents );
            }
        }
        computeDoActionsAndDoEvents( actions, events );
    }

    @Override
    public void doFinished( ) {

        super.doFinished( );
        for ( InstanceDeleteMicroTransactionable idmtx : idmtxs ) {
            idmtx.doFinished( );
        }
    }

    @Override
    public void undoFinished( ) {

        super.undoFinished( );
        for ( InstanceDeleteMicroTransactionable idmtx : idmtxs ) {
            idmtx.undoFinished( );
        }
    }

    private void computeDoActionsAndDoEvents( Set<Action> actionsFromIdmtx, Set<ChangeEvent> eventsFromIdmtx ) {

        // preserve stable ordering, prevent duplicates, throw away wrong entries and sort them
        if ( !actionsFromIdmtx.isEmpty( ) ) {
            List<Action> doActions = getOrCreateDoActions( );
            doActions.addAll( actionsFromIdmtx );
            Collections.sort( doActions, ActionDeleteComparator.instance );
        }
        if ( eventCreationNeeded( ) ) {
            if ( !eventsFromIdmtx.isEmpty( ) ) {
                eliminateInstancesOf( eventsFromIdmtx, AttributeValueEvent.class );
                List<ChangeEvent> doEvents = getOrCreateDoEvents( );
                doEvents.addAll( eventsFromIdmtx );
                Collections.sort( doEvents, EventComparator.instance );
            }
        }
    }
}
