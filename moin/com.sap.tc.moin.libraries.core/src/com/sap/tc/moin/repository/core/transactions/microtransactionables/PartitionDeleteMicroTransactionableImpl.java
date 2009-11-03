package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.PartitionDeletingNotPossibleException;
import com.sap.tc.moin.repository.PartitionException;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.transactions.actions.ActionFactory;
import com.sap.tc.moin.repository.core.transactions.actions.PartitionDirtyAction;
import com.sap.tc.moin.repository.core.transactions.actions.PartitionEnsureActivityAllowedAction;
import com.sap.tc.moin.repository.core.transactions.actions.PartitionLockAction;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.messages.core.RepositoryCoreMessages;
import com.sap.tc.moin.repository.spi.core.SpiStage;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;
import com.sap.tc.moin.repository.transactions.RecoverableExecutionException;
import com.sap.tc.moin.repository.transactions.actions.Action;
import com.sap.tc.moin.repository.transactions.microtransactionables.PartitionDeleteElementsMicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.PartitionDeleteMicroTransactionable;

@SuppressWarnings( "unchecked" )
public class PartitionDeleteMicroTransactionableImpl extends AbstractMicroTransactionable implements PartitionDeleteMicroTransactionable {

    private CoreModelPartition partitionDeleted = null;

    private PRI partitionDeletedPri = null;

    private SpiStage partitionDeletedStage = null;

    private Workspace partitionDeletedWorkspace = null;

    private boolean isDirty = false;

    private boolean isLocked = false;

    private boolean isStored = false;

    private boolean isVolatile = false;

    private PartitionDeleteElementsMicroTransactionable pdemtx = null;

    public PartitionDeleteMicroTransactionableImpl( CoreConnection aConnection, CoreModelPartition aPartition ) {

        super( aConnection );
        partitionDeleted = aPartition;
        partitionDeletedPri = aPartition.getPri( );
        isVolatile = partitionDeletedPri.isVolatilePartition( );
        partitionDeletedStage = aPartition.getResourceInformation( ).getStage( );
        isDirty = aPartition.isDirty( );
        if ( !isVolatile ) {
            isLocked = connection.getPartitionLockManager( ).isLockedByConnection( aPartition.getPri( ), connection );
            isStored = aPartition.isPersisted( );
        }
        partitionDeletedWorkspace = aPartition.getWorkspace( );
    }

    @Override
    public void assertDoPostConstraints( ) {

        pdemtx.assertDoPostConstraints( );
    }

    @Override
    public void assertDoPreConstraints( ) {

        // check whether the partition to be deleted is a null partition and
        // throw an exception if so
        if ( partitionDeletedPri.isNullPartition( ) ) {
            PartitionException partitionException = new PartitionDeletingNotPossibleException( RepositoryCoreMessages.NULLPARTITIONNOTDELETABLE, partitionDeletedPri );
            RecoverableExecutionException exception = new RecoverableExecutionException( partitionException );
            log.preConstraintCheckException( exception );
            throw exception;
        }
        // check whether the partition to be deleted is a metamodel partition
        // and throw an exception if so
        if ( partitionDeleted.getWorkspace( ) == getWorkspaceSet( ).getMoin( ).getMetamodelWorkspace( ) ) {
            PartitionException partitionException = new PartitionDeletingNotPossibleException( RepositoryCoreMessages.MMPARTITIONCANNOTBECHANGED, partitionDeletedPri );
            RecoverableExecutionException exception = new RecoverableExecutionException( partitionException );
            log.preConstraintCheckException( exception );
            throw exception;
        }
        PRI pri = partitionDeleted.getPri( );
        CRI cri = pri.getCri( );
        SpiFacility facility = (SpiFacility) connection.getSession( ).getMoin( ).getFacilityById( pri.getDataAreaDescriptor( ).getFacilityId( ) );
        SpiClientSpec clientSpec = (SpiClientSpec) connection.getSession( ).getCompoundClientSpec( ).getClientSpec( pri.getDataAreaDescriptor( ) );
        if ( !facility.getLifecycleManagement( ).isContainerModifiable( cri, clientSpec ) ) {
            triggerRollback( new PartitionDeletingNotPossibleException( RepositoryCoreMessages.PARTITIONNOTCREATABLELM, pri ) );
        }
        copyOnWrite( true );
        pdemtx = new PartitionDeleteElementsMicroTransactionableImpl( connection, partitionDeleted );
        pdemtx.assertDoPreConstraints( );
    }

    @Override
    public void assertUndoPostConstraints( ) {

        pdemtx.assertUndoPostConstraints( );
    }

    @Override
    public void assertUndoPreConstraints( ) {

        pdemtx.assertUndoPreConstraints( );
    }

    @Override
    public void computeDoActionsAndDoEvents( ) {

        // collect actions and events from other MicroTransactionables
        pdemtx.computeDoActionsAndDoEvents( );
        Set<Action> actions = new LinkedHashSet<Action>( 0 );
        Set<ChangeEvent> events = new LinkedHashSet<ChangeEvent>( 0 );
        if ( pdemtx.getDoActions( ) != null ) {
            actions.addAll( pdemtx.getDoActions( ) );
            if ( eventCreationNeeded( ) ) {
                events.addAll( pdemtx.getDoEvents( ) );
            }
        }
        computeDoActionsAndDoEvents( actions, events );
    }

    @Override
    public void computeUndoActionsAndUndoEvents( ) {

        // collect actions and events from the MicroTransactionable for the
        // deletion of elements in a partition
        // add the partition create action and event
        Set<Action> actions = new LinkedHashSet<Action>( 0 );
        pdemtx.computeUndoActionsAndUndoEvents( );
        List pdemtxUndoActions = pdemtx.getUndoActions( );
        // locking, dirtyness and ensure activity allowed is computed here, so
        // delete the corresponding actions from the action list
        if ( pdemtxUndoActions != null ) {
            eliminateInstancesOf( pdemtxUndoActions, PartitionLockAction.class, PartitionDirtyAction.class, PartitionEnsureActivityAllowedAction.class );
            actions.addAll( pdemtxUndoActions );
        }
        if ( isVolatile ) {
            actions.add( ActionFactory.createTransientPartitionCreateAction( connection, partitionDeletedPri, partitionDeletedStage, partitionDeletedWorkspace ) );
        } else {
            actions.add( ActionFactory.createPartitionCreateAction( connection, partitionDeletedPri, partitionDeletedStage, partitionDeletedWorkspace, false ) );
        }
        // Undo must not be ensured by the facility, because it only undos the changes and produces the original state again.
//        actions.add( ActionFactory.createEnsureCreationAllowedAction( connection, partitionDeletedPri ) );
        if ( isLocked ) {
            actions.add( ActionFactory.createPartitionEditLockAction( connection, partitionDeletedPri ) );
        } else {
            //if the partition wasn't locked beforehand, lock must be released
            actions.add( ActionFactory.createPartitionLockReleaseAction( connection, partitionDeletedPri ) );
        }

        if ( isDirty && !isVolatile ) {
            actions.add( ActionFactory.createPartitionMarkDirtyAction( connection, partitionDeletedPri ) );
        }
        if ( !actions.isEmpty( ) ) {
            List<Action> undoActions = getOrCreateUndoActions( );
            undoActions.addAll( actions );
            Collections.sort( undoActions, ActionCreateComparator.instance );
        }
        if ( eventCreationNeeded( ) ) {
            getOrCreateUndoEvents( ).add( getEventFactory( ).createPartitionCreatedEvent( connection, partitionDeletedPri ) );
            if ( pdemtx.getUndoEvents( ) != null ) {
                getOrCreateUndoEvents( ).addAll( pdemtx.getUndoEvents( ) );
            }
        }
    }

    @Override
    public void computeRedoActionsAndRedoEvents( ) {

        copyOnWrite( false );
        // collect actions and events from other MicroTransactionables
        pdemtx.computeRedoActionsAndRedoEvents( );
        Set<Action> actions = new LinkedHashSet<Action>( 0 );
        Set<ChangeEvent> events = new LinkedHashSet<ChangeEvent>( 0 );
        if ( pdemtx.getRedoActions( ) != null ) {
            actions.addAll( pdemtx.getRedoActions( ) );
            events.addAll( pdemtx.getRedoEvents( ) );
        }
        computeDoActionsAndDoEvents( actions, events );
    }

    @Override
    public void doFinished( ) {

        super.doFinished( );
        if ( pdemtx != null ) {
            pdemtx.doFinished( );
        }
        unresolve( );
    }

    @Override
    public void undoFinished( ) {

        super.undoFinished( );
        if ( pdemtx != null ) {
            pdemtx.undoFinished( );
        }
    }

    private void unresolve( ) {

        partitionDeleted = null;
    }

    private void computeDoActionsAndDoEvents( Set<Action> actionsFromPdmtx, Set<ChangeEvent> eventsFromPdmtx ) {

        // add the partition delete action and event
        List<Action> actions = new ArrayList<Action>( 0 );
        if ( isVolatile ) {
            actions.add( ActionFactory.createTransientPartitionDeleteAction( connection, partitionDeletedPri ) );
        } else {
            actions.add( ActionFactory.createPartitionDeleteAction( connection, partitionDeletedPri ) );
        }
        actions.add( ActionFactory.createEnsureDeletionAllowedAction( connection, partitionDeletedPri ) );
        if ( isStored ) {
            if ( !isLocked ) {
                actions.add( ActionFactory.createPartitionDeleteLockAction( connection, partitionDeletedPri ) );
            }
            if ( !isDirty ) {
                actions.add( ActionFactory.createPartitionMarkDirtyAction( connection, partitionDeletedPri ) );
            }
        } else {
            // the partition wasn't in the persistence yet, therefore the
            // deletion needs not to be saved
            // clear the dirtiness so that the partition is not saved,
            // because the partition is not saved, its lock isn't released
            // neither and it needs to be released here
            if ( isDirty && !isVolatile ) {
                actions.add( ActionFactory.createPartitionClearDirtyAction( connection, partitionDeletedPri ) );
            }
            if ( isLocked ) {
                actions.add( ActionFactory.createPartitionLockReleaseAction( connection, partitionDeletedPri ) );
            }
        }
        List<Action> doActions = getOrCreateDoActions( );
        if ( !actionsFromPdmtx.isEmpty( ) ) {
            doActions.addAll( actionsFromPdmtx );
        }
        doActions.addAll( actions );
        Collections.sort( doActions, ActionDeleteComparator.instance );
        if ( eventCreationNeeded( ) ) {
            List<ChangeEvent> doEvents = getOrCreateDoEvents( );
            if ( !eventsFromPdmtx.isEmpty( ) ) {
                doEvents.addAll( eventsFromPdmtx );
            }
            doEvents.add( getEventFactory( ).createPartitionRemovedEvent( connection, partitionDeletedPri ) );
        }
    }

    private void copyOnWrite( boolean doCase ) {

        if ( !isVolatile ) {
            if ( !doCase || partitionDeleted.getWorkspace( ) == connection.getSession( ).getCompoundClientSpecWorkspace( ) ) {
                CoreModelPartition privateCopy = createPrivateCopy( partitionDeletedPri );
                if ( privateCopy != null ) {
                    partitionDeleted = privateCopy;
                    partitionDeletedWorkspace = partitionDeleted.getWorkspace( );
                }
            }
        }
    }
}
