package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.IllegalRelocateToDataAreaException;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.transactions.actions.ActionFactory;
import com.sap.tc.moin.repository.core.transactions.actions.PartitionableAssignPartitionAction;
import com.sap.tc.moin.repository.events.type.PartitionMembershipChangeEvent;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.messages.core.RepositoryCoreMessages;
import com.sap.tc.moin.repository.transactions.microtransactionables.ElementAssignToPartitionMicroTransactionable;

public class ElementAssignToPartitionMicroTransactionableImpl extends AbstractMicroTransactionable implements ElementAssignToPartitionMicroTransactionable {

    private MRI elementMriBeforeRelocation;

    private MRI elementMriAfterRelocation;

    private PRI newPartitionPri;

    private PRI oldPartitionPri;

    private boolean updateChildren;

    private List<LRI> elementsToConsider;

    private CoreModelPartition modelPartition;

    private CorePartitionable element;

    private boolean noOp = false;

    /**
     * Creates a Micro Transactionable that assigns an element to a partition.
     */
    public ElementAssignToPartitionMicroTransactionableImpl( CoreConnection aConnection, CorePartitionable element, CoreModelPartition partition, boolean updateChildren ) {

        super( aConnection );

        // that's an input parameter set via Client API
        this.element = element;

        // that's an input parameter set via Client API
        this.modelPartition = partition;

        // that's a non critical member because it is not set via Client API
        this.updateChildren = updateChildren;
    }

    @Override
    public void assertDoPreConstraints( ) {

        this.assertInputParametersAndInitialize( );
        this.assertCommonPreConstraints( this.elementMriBeforeRelocation, this.oldPartitionPri, this.newPartitionPri );
    }

    private void assertInputParametersAndInitialize( ) {

        if ( this.element == null ) {
            this.triggerRollback( new MoinIllegalArgumentException( RepositoryCoreMessages.ELEMENTTOASSIGNNOTNULL, this.modelPartition ) );
        }
        if ( this.modelPartition == null ) {
            this.triggerRollback( new MoinIllegalArgumentException( RepositoryCoreMessages.PARTITIONTOASSIGNNOTNULL, this.element.get___Mri( ) ) );
        }
        // initialize the member variables
        this.initialize( );
    }

    private void initialize( ) {

        this.newPartitionPri = this.modelPartition.getPri( );
        this.elementMriBeforeRelocation = this.element.get___Mri( );
        this.oldPartitionPri = this.elementMriBeforeRelocation.getPri( );
        this.elementMriAfterRelocation = this.newPartitionPri.createMri( elementMriBeforeRelocation.getMofId( ) );
    }

    @Override
    public void assertUndoPreConstraints( ) {

        // undo just reverses the input for the constraints check: "new" is now
        // "old" and "old" is "new" PRI
        this.assertCommonPreConstraints( this.elementMriAfterRelocation, this.newPartitionPri, this.oldPartitionPri );
    }

    private void assertCommonPreConstraints( MRI elementMri, PRI oldPartitionPri, PRI newPartitionPri ) {

        if ( this.isNoOp( ) ) {
            return;
        }
        this.assertNotNull( elementMri, MicroTransactionablesMessages.MRIOFELEMENTISNULL );
        this.assertNotNull( newPartitionPri, MicroTransactionablesMessages.NEWPARTITIONPRIISNULL );
        this.assertNotNull( oldPartitionPri, MicroTransactionablesMessages.OLDPARTITIONPRIISNULL );
        if ( oldPartitionPri.equals( newPartitionPri ) ) {// do nothing if already
            // assigned
            this.noOp = true;
            return;
        }
        DataAreaDescriptor oldDataArea = oldPartitionPri.getDataAreaDescriptor( );
        DataAreaDescriptor newDataArea = newPartitionPri.getDataAreaDescriptor( );
        if ( !oldDataArea.equals( newDataArea ) ) {
            this.triggerRollback( new IllegalRelocateToDataAreaException( RepositoryCoreMessages.ILLEGALRELOCATEACTION, this.getExistingElement( elementMri ), oldDataArea, newDataArea ) );
        }
    }

    private Collection<CorePartitionable> getChildrenInSamePartition( CoreSession session, CorePartitionable element ) {

        CoreModelPartition partition = element.get___Partition( );
        return partition.getComponentChildrenInThisPartition( session, element );
    }

    @Override
    public void computeDoActionsAndDoEvents( ) {

        computeDoActionsAndDoEvents( true );
    }

    @Override
    public void computeUndoActionsAndUndoEvents( ) {

        if ( this.isNoOp( ) ) {
            return;
        }

        PartitionableAssignPartitionAction assignAction = null;
        PartitionMembershipChangeEvent membershipChangeEvent = null;
        RefObject affectedElement = null;
        ModelPartition oldPartition = this.getExistingPartition( this.newPartitionPri );
        ModelPartition newPartition = this.getExistingPartition( this.oldPartitionPri );

        boolean eventCreationNeeded = eventCreationNeeded( );
        for ( int i = elementsToConsider.size( ) - 1; i >= 0; i-- ) {
            LRI lri = elementsToConsider.get( i );
            MRI mri = this.newPartitionPri.createMri( lri.getMofId( ) );
            assignAction = ActionFactory.createPartitionableAssignPartitionAction( this.connection, mri, this.newPartitionPri, this.oldPartitionPri );
            getOrCreateUndoActions( ).add( assignAction );
            if ( eventCreationNeeded ) {
                affectedElement = (RefObject) this.getExistingElement( mri );
                membershipChangeEvent = getEventFactory( ).createPartitionMembershipChangeEvent( connection, affectedElement, oldPartition, newPartition );
                getOrCreateUndoEvents( ).add( membershipChangeEvent );
            }
        }

        // partition clear dirty actions
        this.addClearDirtyActionsToUndoActions( );

        // release aquired locks
        this.addReleaseLockActionsToUndoActions( );

    }

    @Override
    public void computeRedoActionsAndRedoEvents( ) {

        computeDoActionsAndDoEvents( false );
    }

    private void computeDoActionsAndDoEvents( boolean doCase ) {

        if ( this.isNoOp( ) ) {
            return;
        }

        if ( doCase ) {
            PRI[] affectedPartitionPris = new PRI[] { this.oldPartitionPri, this.newPartitionPri };
            computePartitionsToLock( affectedPartitionPris );
            computePartitionsToEnsureEditing( affectedPartitionPris );
            computePartitionsToMarkDirty( affectedPartitionPris );
        }

        // actions and events

        // aquire locks
        this.addEditLockActionsToDoActions( );

        // ensure editing allowed
        this.addEnsureEditingActionsToDoActions( );

        //must be done in both do and redo case
        copyOnWrite( );

        if ( this.updateChildren ) {// also the children have to be considered
            Collection<CorePartitionable> childrenInSamePartition = this.getChildrenInSamePartition( connection.getSession( ), this.getExistingElement( this.elementMriBeforeRelocation ) );
            this.elementsToConsider = new ArrayList<LRI>( childrenInSamePartition.size( ) + 1 );
            this.elementsToConsider.add( this.elementMriBeforeRelocation.getLri( ) ); // the
            // "main"
            // element
            for ( CorePartitionable child : childrenInSamePartition ) {
                this.elementsToConsider.add( child.get___Mri( ).getLri( ) );
            }

        } else {
            // only the "main" element has to be considered as there are no
            // children to be updated
            this.elementsToConsider = Collections.singletonList( this.elementMriBeforeRelocation.getLri( ) );

        }

        PartitionableAssignPartitionAction assignAction = null;
        PartitionMembershipChangeEvent membershipChangeEvent = null;
        RefObject affectedElement = null;
        ModelPartition oldPartition = this.getExistingPartition( this.oldPartitionPri );
        ModelPartition newPartition = this.getExistingPartition( this.newPartitionPri );
        boolean eventCreationNeeded = eventCreationNeeded( );
        for ( LRI lri : this.elementsToConsider ) {
            MRI mri = this.oldPartitionPri.createMri( lri.getMofId( ) );
            assignAction = ActionFactory.createPartitionableAssignPartitionAction( this.connection, mri, this.oldPartitionPri, this.newPartitionPri );
            this.getOrCreateDoActions( ).add( assignAction );
            if ( eventCreationNeeded ) {
                affectedElement = (RefObject) this.getExistingElement( mri );
                membershipChangeEvent = getEventFactory( ).createPartitionMembershipChangeEvent( connection, affectedElement, oldPartition, newPartition );
                getOrCreateDoEvents( ).add( membershipChangeEvent );
            }
        }

        // set the dirty state
        this.addMarkDirtyActionsToDoActions( );
    }

    private void copyOnWrite( ) {

        element = getExistingElement( elementMriBeforeRelocation ); //has to be done as element could be invalid in "redo" case (after do/undo and another session changing it before "redo")
        if ( element.get___Workspace( ) == connection.getSession( ).getCompoundClientSpecWorkspace( ) ) {
            createPrivateCopy( element.get___Partition( ).getPri( ) );
            element = getExistingElement( elementMriBeforeRelocation );
        }
        createPrivateCopy( newPartitionPri );

    }

    private boolean isNoOp( ) {

        return this.noOp;
    }

    @Override
    public void doFinished( ) {

        super.doFinished( );
        // elements are no longer needed after do
        this.element = null;
        this.modelPartition = null;
    }

}