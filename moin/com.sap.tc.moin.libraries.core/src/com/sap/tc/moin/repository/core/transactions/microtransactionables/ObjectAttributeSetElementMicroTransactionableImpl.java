package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.DuplicateException;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.TypeMismatchException;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.jmi.reflect.RefFeaturedImpl;
import com.sap.tc.moin.repository.core.transactions.actions.ActionFactory;
import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.transactions.microtransactionables.ObjectAttributeSetElementMicroTransactionable;

@SuppressWarnings( "unchecked" )
public class ObjectAttributeSetElementMicroTransactionableImpl extends AbstractMicroTransactionable implements ObjectAttributeSetElementMicroTransactionable {

    private RefFeatured featured = null;

    private MRI featuredMri = null;

    private Attribute attribute = null;

    private int index = -1;

    private CorePartitionable oldValue = null;

    private Object newValue = null;

    private MRI oldValueMri = null;

    private MRI newValueMri = null;

    private EndStorageLink linkAdded = null;

    private EndStorageLink linkRemoved = null;

    private List<MRI> elementsRepartitionedMri = null;

    private Map<MRI, StateSet> affectedElementStates = null;

    /**
     * Creates a Micro Transactionable that changes the element at position
     * <code>index</code> of a multi-valued attribute whose classifier is a
     * class
     */
    public ObjectAttributeSetElementMicroTransactionableImpl( CoreConnection aConnection, RefFeatured aFeatured, Attribute anAttribute, int anIndex, Object aNewValue ) {

        super( aConnection );
        featured = aFeatured;
        featuredMri = ( (CorePartitionable) aFeatured ).get___Mri( );
        attribute = anAttribute;
        index = anIndex;
        oldValue = (CorePartitionable) ( (JmiList) ( (RefFeaturedImpl) featured ).refGetValue( aConnection, attribute ) ).get( connection.getSession( ), index );
        newValue = aNewValue;
    }

    @Override
    public void assertDoPreConstraints( ) throws JmiException, MoinNullPointerException {

        if ( newValue == null ) {
            // attribute is multi-valued, so setting a value to null results in a MoinNullPointerException (JMI Spec, page 68)
            MoinNullPointerException exception = new MoinNullPointerException( MicroTransactionablesMessages.FEATUREOFCLASSISMULTIVALUEDNOSET, attribute.getName( ), ( (MofClass) featured.refMetaObject( ) ).getName( ) );
            log.preConstraintCheckException( exception );
            throw exception;
        }
        Classifier type = getJmiHelper( ).getType( connection.getSession( ), attribute );
        if ( !checkTypeCompatibility( type, newValue ) ) {
            // newValue is not of the correct attribute type (JMI Spec, page 68)
            TypeMismatchException exception = new TypeMismatchException( type.getClass( ), newValue, featured.refMetaObject( ), MicroTransactionablesMessages.FEATUREWRONGTYPE, attribute.getName( ), ( (MofClass) featured.refMetaObject( ) ).getName( ), type.getName( ), newValue.getClass( ) );
            log.preConstraintCheckException( exception );
            throw exception;
        }
        JmiList elements = (JmiList) ( (RefFeaturedImpl) featured ).refGetValue( connection, attribute );
        if ( attribute.getMultiplicity( ).isUnique( ) && elements.contains( connection, newValue ) ) {
            DuplicateException exception = new DuplicateException( newValue, featured.refMetaObject( ), MicroTransactionablesMessages.FEATUREISUNIQUE, attribute.getName( ), ( (MofClass) featured.refMetaObject( ) ).getName( ) );
            log.preConstraintCheckException( exception );
            throw exception;
        }
        newValueMri = ( (CorePartitionable) newValue ).get___Mri( );
        oldValueMri = oldValue.get___Mri( );
    }

    @Override
    public void assertDoPostConstraints( ) throws JmiException {

        // composition cycle and closure rule violation detection
        assertCompositionCycle( linkAdded );
        assertCompositionClosure( linkAdded );
    }

    @Override
    public void computeDoActionsAndDoEvents( ) {

        copyOnWrite( );

        // compute the links to add and to remove, the affected partitions
        // and the elements to repartition
        CoreModelPartition partitionOfFeatured = ( (CorePartitionable) featured ).get___Partition( );
        // link to add
        Set<PRI> affectedPartitionsPri = new HashSet<PRI>( );
        linkAdded = getLogicalLinkManager( ).createLink( connection.getSession( ), (CorePartitionable) featured, (CorePartitionable) newValue, attribute, false );
        assertNoCompositeLinkToMetamodelIfStorageAtParent( linkAdded );
        // link to remove
        linkRemoved = getLogicalLinkManager( ).getLink( connection.getSession( ), (CorePartitionable) featured, oldValue, attribute, false );
        // their affected partitions
        affectedPartitionsPri.add( linkRemoved.getStorageEndMri( ).getPri( ) );
        affectedPartitionsPri.add( linkAdded.getStorageEndMri( ).getPri( ) );
        // elements to repartition and affected partitions
        // currently the same as link addition because the old value remains
        // in its partition,
        // but who knows, perhaps this will change in the future
        List<CorePartitionable> elementsToRepartition = getElementsToRepartitionAfterLinkAdd( attribute, 0, (CorePartitionable) newValue, partitionOfFeatured );
        PRI newPartitionPri = partitionOfFeatured.getPri( );
        if ( elementsToRepartition != null && !elementsToRepartition.isEmpty( ) ) {
            if ( elementsRepartitionedMri == null ) {
                elementsRepartitionedMri = new ArrayList<MRI>( elementsToRepartition.size( ) );
            }
            if ( affectedElementStates == null ) {
                affectedElementStates = new HashMap<MRI, StateSet>( Utilities.calcInitialCapacity( elementsToRepartition.size( ) ) );
            }
            // the new partitions and all old partitions are affected
            affectedPartitionsPri.add( newPartitionPri );
            for ( CorePartitionable elementToRepartition : elementsToRepartition ) {
                PRI oldPartitionPri = elementToRepartition.get___Partition( ).getPri( );
                Map<String, Object> initialState = StateSet.createState( StateSet.STATE_PARAMETER_PRI, oldPartitionPri );
                Map<String, Object> finalState = StateSet.createState( StateSet.STATE_PARAMETER_PRI, newPartitionPri );
                elementsRepartitionedMri.add( elementToRepartition.get___Mri( ) );
                affectedElementStates.put( elementToRepartition.get___Mri( ), new StateSet( initialState, finalState ) );
                affectedPartitionsPri.add( oldPartitionPri );
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
        getOrCreateDoActions( ).add( ActionFactory.createEndStorageLinkRemoveAction( connection, featuredMri, attribute.refMofId( ), linkRemoved, index ) );
        boolean eventCreationNeeded = eventCreationNeeded( );
        if ( eventCreationNeeded ) {
            getOrCreateDoEvents( ).add( getEventFactory( ).createAttributeValueRemoveEvent( connection, featured, attribute, oldValue, index ) );
        }
        // link add action and event
        getOrCreateDoActions( ).add( ActionFactory.createEndStorageLinkAddAction( connection, featuredMri, attribute.refMofId( ), linkAdded, index ) );
        if ( eventCreationNeeded ) {
            getOrCreateDoEvents( ).add( getEventFactory( ).createAttributeValueAddEvent( connection, featured, attribute, newValue, index ) );
        }
        // partition assign actions and events
        if ( elementsRepartitionedMri != null ) {
            for ( int i = 0; i < elementsRepartitionedMri.size( ); i++ ) {
                MRI elementRepartitionedMri = elementsRepartitionedMri.get( i );
                StateSet ss = affectedElementStates.get( elementRepartitionedMri );
                PRI oldPartitionPri = (PRI) ss.getInitialState( ).get( StateSet.STATE_PARAMETER_PRI );
                PRI newPartitionPriAfterRepartitioning = (PRI) ss.getFinalState( ).get( StateSet.STATE_PARAMETER_PRI );
                getOrCreateDoActions( ).add( ActionFactory.createPartitionableAssignPartitionAction( connection, elementRepartitionedMri, oldPartitionPri, newPartitionPriAfterRepartitioning ) );
                if ( eventCreationNeeded ) {
                    getOrCreateDoEvents( ).add( getEventFactory( ).createPartitionMembershipChangeEvent( connection, (RefObject) getExistingElement( elementRepartitionedMri ), getExistingPartition( oldPartitionPri ), getExistingPartition( newPartitionPriAfterRepartitioning ) ) );
                }
            }
        }
        // partition mark dirty actions
        addMarkDirtyActionsToDoActions( );

    }

    @Override
    public void computeUndoActionsAndUndoEvents( ) {

        resolve( false );
        // actions and events
        getOrCreateDoActions( ).add( ActionFactory.createEndStorageLinkRemoveAction( connection, linkAdded.getStorageEnd( ).getMri( ), attribute.refMofId( ), linkAdded, index ) );
        getOrCreateDoActions( ).add( ActionFactory.createEndStorageLinkAddAction( connection, linkRemoved.getStorageEnd( ).getMri( ), attribute.refMofId( ), linkRemoved, index ) );
        boolean eventCreationNeeded = eventCreationNeeded( );
        if ( eventCreationNeeded ) {
            getOrCreateUndoEvents( ).add( getEventFactory( ).createAttributeValueRemoveEvent( connection, featured, attribute, newValue, index ) );
            getOrCreateUndoEvents( ).add( getEventFactory( ).createAttributeValueAddEvent( connection, featured, attribute, oldValue, index ) );
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

        resolve( true );
        //we do the same as in the "do"-case as it we cannot easily keep the necessary information
        //e.g. the affected links have to be recalculated as in non-unique, to-n case, the java identity is used for equals
        //and a private copy has also to be done in both "do" and "redo" case
        computeDoActionsAndDoEvents( );
    }

    @Override
    public void doFinished( ) {

        super.doFinished( );
        unresolve( );
    }

    @Override
    public void undoFinished( ) {

        super.undoFinished( );
        this.elementsRepartitionedMri = null;
        unresolve( );
    }

    private void copyOnWrite( ) {

        if ( ( (CorePartitionable) featured ).get___Workspace( ) == connection.getSession( ).getCompoundClientSpecWorkspace( ) ) {
            createPrivateCopy( featuredMri.getPri( ) );
            featured = (RefFeatured) getExistingElement( featuredMri );
        }
    }

    private void resolve( boolean redoCase ) {

        featured = (RefFeatured) getExistingElement( featuredMri );
        if ( redoCase ) {
            // we can resolve with the old MRI
            if ( newValueMri != null ) {
                newValue = getExistingElement( newValueMri );
            }
            if ( oldValueMri != null ) {
                oldValue = getExistingElement( oldValueMri );
            }
        } else {
            // undo case, take repartitions during the do phase into account,
            // i.e. resolve with the new MRI
            if ( newValueMri != null ) {
                MRI newMri = newValueMri;
                if ( elementsRepartitionedMri != null && elementsRepartitionedMri.contains( newValueMri ) ) {
                    PRI newPartitionPri = (PRI) affectedElementStates.get( newValueMri ).getFinalState( ).get( StateSet.STATE_PARAMETER_PRI );
                    newMri = newPartitionPri.createMri( newValueMri.getMofId( ) );
                }
                newValue = getExistingElement( newMri );
            }
            if ( oldValueMri != null ) {
                MRI newMri = oldValueMri;
                if ( elementsRepartitionedMri != null && elementsRepartitionedMri.contains( oldValueMri ) ) {
                    PRI newPartitionPri = (PRI) affectedElementStates.get( oldValueMri ).getFinalState( ).get( StateSet.STATE_PARAMETER_PRI );
                    newMri = newPartitionPri.createMri( oldValueMri.getMofId( ) );
                }
                oldValue = getExistingElement( newMri );
            }
        }
    }

    private void unresolve( ) {

        featured = null;
        newValue = null;
        oldValue = null;
    }

    public Object getElementReplaced( ) {

        MRI newMri = oldValueMri;
        if ( elementsRepartitionedMri != null && elementsRepartitionedMri.contains( oldValueMri ) ) {
            // ok, we did repartition the element
            PRI newPartitionPri = (PRI) affectedElementStates.get( oldValueMri ).getFinalState( ).get( StateSet.STATE_PARAMETER_PRI );
            // can not use old MRI because it has changed after repartitioning
            // during do phase
            newMri = newPartitionPri.createMri( oldValueMri.getMofId( ) );
        }
        return getExistingElement( newMri );
    }
}