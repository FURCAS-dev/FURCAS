package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.jmi.reflect.RefFeaturedImpl;
import com.sap.tc.moin.repository.core.transactions.actions.ActionFactory;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.InvalidCallException;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.TypeMismatchException;
import com.sap.tc.moin.repository.transactions.microtransactionables.ObjectAttributeChangeMicroTransactionable;

public class ObjectAttributeChangeMicroTransactionableImpl extends AbstractMicroTransactionable implements ObjectAttributeChangeMicroTransactionable {

    private RefFeatured featured = null;

    private MRI featuredMri = null;

    private Attribute attribute = null;

    private Object oldValue = null;

    private Object newValue = null;

    private MRI oldValueMri = null;

    private MRI newValueMri = null;

    private EndStorageLink linkAdded = null;

    private EndStorageLink linkRemoved = null;

    private List<MRI> elementsRepartitionedMri = null;

    private Map<MRI, StateSet> affectedElementStates = null;

    /**
     * Creates a Micro Transactionable that changes a single-valued attribute
     * whose classifier is a class
     */
    public ObjectAttributeChangeMicroTransactionableImpl( CoreConnection aConnection, RefFeatured aFeatured, Attribute anAttribute, Object aNewValue ) {

        super( aConnection );
        featured = aFeatured;
        featuredMri = ( (CorePartitionable) aFeatured ).get___Mri( );
        attribute = anAttribute;
        oldValue = ( (RefFeaturedImpl) featured ).refGetValue( aConnection, attribute );
        newValue = aNewValue;
    }

    @Override
    public void assertDoPreConstraints( ) throws JmiException {

        int attributeUpperBound = attribute.getMultiplicity( ).getUpper( );
        if ( attributeUpperBound == JmiHelper.MULTIPLICITY_BOUND_INFINITE || attributeUpperBound > 1 ) {
            // attribute is multi-valued, so setting the value as a whole results in an InvalidCallException (JMI Spec, page 83)
            InvalidCallException exception = new InvalidCallException( newValue, attribute, MicroTransactionablesMessages.MULTIVALUEDATTRIBUTESNOTSETASWHOLE, attribute.getName( ), ( (MofClass) featured.refMetaObject( ) ).getName( ) );
            log.preConstraintCheckException( exception );
            throw exception;
        }
        if ( newValue != null ) {
            Classifier type = getJmiHelper( ).getType( connection.getSession( ), attribute );
            if ( !checkTypeCompatibility( type, newValue ) ) {
                // newValue is not of the correct attribute type
                TypeMismatchException exception = new TypeMismatchException( type.getClass( ), newValue, featured.refMetaObject( ), MicroTransactionablesMessages.FEATUREWRONGTYPE, attribute.getName( ), ( (MofClass) featured.refMetaObject( ) ).getName( ), type.getName( ), newValue.getClass( ) );
                log.preConstraintCheckException( exception );
                throw exception;
            }
        }
        if ( newValue != null ) {
            newValueMri = ( (CorePartitionable) newValue ).get___Mri( );
        }
        if ( oldValue != null ) {
            oldValueMri = ( (CorePartitionable) oldValue ).get___Mri( );
        }
    }

    @Override
    public void assertDoPostConstraints( ) throws JmiException {

        // composition cycle and closure rule violation detection
        if ( linkAdded != null ) {
            assertCompositionCycle( linkAdded );
            assertCompositionClosure( linkAdded );

        }
    }

    @Override
    public void computeDoActionsAndDoEvents( ) {

        computeDoActionsAndDoEvents( true );
    }

    @Override
    public void computeUndoActionsAndUndoEvents( ) {

        resolve( false );
        // actions and events
        if ( linkAdded != null ) {
            getOrCreateDoActions( ).add( ActionFactory.createEndStorageLinkRemoveAction( connection, linkAdded.getStorageEnd( ).getMri( ), attribute.refMofId( ), linkAdded, -1 ) );
        }
        if ( linkRemoved != null ) {
            getOrCreateDoActions( ).add( ActionFactory.createEndStorageLinkAddAction( connection, linkRemoved.getStorageEnd( ).getMri( ), attribute.refMofId( ), linkRemoved, -1 ) );
        }
        boolean eventCreationNeeded = eventCreationNeeded( );
        if ( eventCreationNeeded ) {
            if ( linkAdded != null || linkRemoved != null ) {
                // compute change event only if a change action is present
                getOrCreateUndoEvents( ).add( getEventFactory( ).createAttributeValueChangeEvent( connection, featured, attribute, newValue, oldValue ) );
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
    }

    @Override
    public void computeRedoActionsAndRedoEvents( ) {

        resolve( true );
        boolean doCase = false;
        copyOnWrite( doCase );
        computeDoActionsAndDoEvents( doCase );
    }

    @Override
    public void doFinished( ) {

        super.doFinished( );
        unresolve( );
    }

    @Override
    public void undoFinished( ) {

        super.undoFinished( );
        unresolve( );
    }

    private void computeDoActionsAndDoEvents( boolean doCase ) {

        if ( doCase ) {
            if ( checkPreconditionsForChanging( (CorePartitionable) oldValue, (CorePartitionable) newValue ) ) {

                copyOnWrite( doCase );

                // compute the links to add and to remove, the affected
                // partitions and the elements to repartition
                CoreModelPartition partitionOfFeatured = ( (CorePartitionable) featured ).get___Partition( );
                Set<PRI> affectedPartitionsPri = new HashSet<PRI>( );
                if ( newValue != null ) {
                    // link to add
                    linkAdded = getLogicalLinkManager( ).createLink( connection.getSession( ), (CorePartitionable) featured, (CorePartitionable) newValue, attribute, false );
                    assertNoCompositeLinkToMetamodelIfStorageAtParent( linkAdded );
                    // some additions lead to an implicit replacement of a link,
                    // this link has to be calculated
                    // link to remove
                    linkRemoved = getLinkToReplace( linkAdded, Workspace.LINK_ADDED_VIA_ATTRIBUTE );
                } else if ( oldValue != null ) {
                    // link deletion, only if there exists one, i.e. if the old
                    // value was != null
                    // link to remove
                    linkRemoved = getLogicalLinkManager( ).getLink( connection.getSession( ), (CorePartitionable) featured, (CorePartitionable) oldValue, attribute, false );
                }
                // their affected partitions
                if ( linkAdded != null ) {
                    affectedPartitionsPri.add( linkAdded.getStorageEndMri( ).getPri( ) );
                }
                if ( linkRemoved != null ) {
                    affectedPartitionsPri.add( linkRemoved.getStorageEndMri( ).getPri( ) );
                }
                // elements to repartition and affected partitions
                List<CorePartitionable> elementsToRepartitionForLinkAdd = null;
                List<CorePartitionable> elementsToRepartitionForLinkRemove = null;
                PRI newPartitionPriForLinkAdd = null;
                PRI newPartitionPriForLinkRemove = null;
                if ( linkRemoved != null ) {
                    elementsToRepartitionForLinkRemove = getElementsToRepartitionAfterLinkRemove( attribute, 0, (CorePartitionable) oldValue, partitionOfFeatured );
                    newPartitionPriForLinkRemove = getNullPartition( ).getPri( );
                }
                if ( linkAdded != null ) {
                    elementsToRepartitionForLinkAdd = getElementsToRepartitionAfterLinkAdd( attribute, 0, (CorePartitionable) newValue, partitionOfFeatured );
                    newPartitionPriForLinkAdd = partitionOfFeatured.getPri( );
                }
                if ( elementsRepartitionedMri == null ) {
                    elementsRepartitionedMri = new ArrayList<MRI>( );
                }
                if ( affectedElementStates == null ) {
                    affectedElementStates = new HashMap<MRI, StateSet>( );
                }
                // the new partitions and all old partitions are affected
                if ( newPartitionPriForLinkAdd != null && elementsToRepartitionForLinkAdd != null && elementsToRepartitionForLinkAdd.size( ) > 0 ) {
                    if ( affectedPartitionsPri.add( newPartitionPriForLinkAdd ) ) {
                        createPrivateCopy( newPartitionPriForLinkAdd );
                    }
                    for ( CorePartitionable elementToRepartition : elementsToRepartitionForLinkAdd ) {
                        PRI oldPartitionPri = elementToRepartition.get___Partition( ).getPri( );
                        Map<String, Object> initialState = StateSet.createState( StateSet.STATE_PARAMETER_PRI, oldPartitionPri );
                        Map<String, Object> finalState = StateSet.createState( StateSet.STATE_PARAMETER_PRI, newPartitionPriForLinkAdd );
                        elementsRepartitionedMri.add( elementToRepartition.get___Mri( ) );
                        affectedElementStates.put( elementToRepartition.get___Mri( ), new StateSet( initialState, finalState ) );
                        if ( affectedPartitionsPri.add( oldPartitionPri ) ) {
                            createPrivateCopy( oldPartitionPri );
                        }
                    }
                }
                if ( newPartitionPriForLinkRemove != null && elementsToRepartitionForLinkRemove != null && elementsToRepartitionForLinkRemove.size( ) > 0 ) {
                    if ( affectedPartitionsPri.add( newPartitionPriForLinkRemove ) ) {
                        createPrivateCopy( newPartitionPriForLinkRemove );
                    }
                    for ( CorePartitionable elementToRepartition : elementsToRepartitionForLinkRemove ) {
                        PRI oldPartitionPri = elementToRepartition.get___Partition( ).getPri( );
                        Map<String, Object> initialState = StateSet.createState( StateSet.STATE_PARAMETER_PRI, oldPartitionPri );
                        Map<String, Object> finalState = StateSet.createState( StateSet.STATE_PARAMETER_PRI, newPartitionPriForLinkRemove );
                        elementsRepartitionedMri.add( elementToRepartition.get___Mri( ) );
                        affectedElementStates.put( elementToRepartition.get___Mri( ), new StateSet( initialState, finalState ) );
                        if ( affectedPartitionsPri.add( oldPartitionPri ) ) {
                            createPrivateCopy( oldPartitionPri );
                        }
                    }
                }
                PRI[] affectedPartitionPris = affectedPartitionsPri.toArray( new PRI[affectedPartitionsPri.size( )] );
                computePartitionsToLock( affectedPartitionPris );
                computePartitionsToEnsureEditing( affectedPartitionPris );
                computePartitionsToMarkDirty( affectedPartitionPris );
            }
        }
        // actions and events
        if ( linkAdded != null || linkRemoved != null ) {
            // aquire lock actions
            addEditLockActionsToDoActions( );
            // ensure editing allowed actions
            addEnsureEditingActionsToDoActions( );
            // link remove action, before add action
            if ( linkRemoved != null ) {
                getOrCreateDoActions( ).add( ActionFactory.createEndStorageLinkRemoveAction( connection, featuredMri, attribute.refMofId( ), linkRemoved, -1 ) );
            }
            // link add action
            if ( linkAdded != null ) {
                getOrCreateDoActions( ).add( ActionFactory.createEndStorageLinkAddAction( connection, featuredMri, attribute.refMofId( ), linkAdded, -1 ) );
            }
            // change event
            if ( eventCreationNeeded( ) ) {
                getOrCreateDoEvents( ).add( getEventFactory( ).createAttributeValueChangeEvent( connection, featured, attribute, oldValue, newValue ) );
            }
            // partition assign actions and events
            if ( elementsRepartitionedMri != null ) {
                for ( int i = 0; i < elementsRepartitionedMri.size( ); i++ ) {
                    MRI elementRepartitionedMri = elementsRepartitionedMri.get( i );
                    StateSet ss = affectedElementStates.get( elementRepartitionedMri );
                    PRI oldPartitionPri = (PRI) ss.getInitialState( ).get( StateSet.STATE_PARAMETER_PRI );
                    PRI newPartitionPri = (PRI) ss.getFinalState( ).get( StateSet.STATE_PARAMETER_PRI );
                    getOrCreateDoActions( ).add( ActionFactory.createPartitionableAssignPartitionAction( connection, elementRepartitionedMri, oldPartitionPri, newPartitionPri ) );
                    if ( eventCreationNeeded( ) ) {
                        getOrCreateDoEvents( ).add( getEventFactory( ).createPartitionMembershipChangeEvent( connection, (RefObject) getExistingElement( elementRepartitionedMri ), getExistingPartition( oldPartitionPri ), getExistingPartition( newPartitionPri ) ) );
                    }
                }
            }
            // partition mark dirty actions
            addMarkDirtyActionsToDoActions( );
        }
    }
    
    @Override
    public boolean eventCreationNeeded() {
	boolean valueUnchanged = oldValue != null && oldValue.equals(newValue) || oldValue == null && newValue == null;
	return !valueUnchanged && super.eventCreationNeeded();
    }

    private void copyOnWrite( boolean doCase ) {

        if ( ( (CorePartitionable) featured ).get___Workspace( ) == connection.getSession( ).getCompoundClientSpecWorkspace( ) ) {
            createPrivateCopy( featuredMri.getPri( ) );
            featured = (RefFeatured) getExistingElement( featuredMri );
        }

        if ( !doCase ) {//redo
            List<PRI> affectedPartitions = getAffectedPartitionsForCopyOnWriteRedo( );
            for ( PRI pri : affectedPartitions ) {
                createPrivateCopy( pri );
            }
        }
    }

    private void resolve( boolean redoCase ) {

        if ( redoCase ) {
            // we can resolve with the old MRIs
            featured = (RefFeatured) getExistingElement( featuredMri );
            if ( newValueMri != null ) {
                newValue = getExistingElement( newValueMri );
            }
            if ( oldValueMri != null ) {
                oldValue = getExistingElement( oldValueMri );
            }
        } else {
            // undo case, take repartitions during the do phase into account,
            // i.e. resolve with the new MRI
            MRI newMri = featuredMri;
            if ( elementsRepartitionedMri != null && elementsRepartitionedMri.contains( featuredMri ) ) {
                PRI newPartitionPri = (PRI) affectedElementStates.get( featuredMri ).getFinalState( ).get( StateSet.STATE_PARAMETER_PRI );
                newMri = newPartitionPri.createMri( featuredMri.getMofId( ) );
            }
            featured = (RefFeatured) getExistingElement( newMri );
            if ( newValueMri != null ) {
                newMri = newValueMri;
                if ( elementsRepartitionedMri != null && elementsRepartitionedMri.contains( newValueMri ) ) {
                    PRI newPartitionPri = (PRI) affectedElementStates.get( newValueMri ).getFinalState( ).get( StateSet.STATE_PARAMETER_PRI );
                    newMri = newPartitionPri.createMri( newValueMri.getMofId( ) );
                }
                newValue = getExistingElement( newMri );
            }
            if ( oldValueMri != null ) {
                newMri = oldValueMri;
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

    private boolean checkPreconditionsForChanging( CorePartitionable theOldValue, CorePartitionable theNewValue ) {

        if ( ( theNewValue == null ) && ( theOldValue == null ) ) {
            // both are equal, return false then
            return false;
        } else if ( ( theNewValue != null ) && ( theOldValue != null ) ) {
            return !theNewValue.equals( theOldValue );
        } else {
            // ((newValue != null) && (oldValue == null)) || ((oldValue != null)
            // && (newValue == null)), i.e. both are different, return true then
            return true;
        }
    }
}