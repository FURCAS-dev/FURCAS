package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import static com.sap.tc.moin.repository.JmiHelper.MULTIPLICITY_BOUND_INFINITE;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.__impl.ReferenceImpl;
import com.sap.tc.moin.repository.mmi.reflect.InvalidCallException;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.TypeMismatchException;
import com.sap.tc.moin.repository.mmi.reflect.WrongSizeException;

import com.sap.tc.moin.repository.IllegalRelocateToDataAreaException;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.jmi.extension.RefFeaturedExtension;
import com.sap.tc.moin.repository.core.jmi.reflect.RefFeaturedImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.transactions.actions.ActionFactory;
import com.sap.tc.moin.repository.shared.util.MoinSystemPropertyKeys;
import com.sap.tc.moin.repository.shared.util.Tuple.Pair;
import com.sap.tc.moin.repository.transactions.microtransactionables.ReferenceChangeMicroTransactionable;

public class ReferenceChangeMicroTransactionableImpl extends AbstractMicroTransactionable implements ReferenceChangeMicroTransactionable {

    private boolean referenceChanged = false;

    private RefFeatured featured = null;

    private MRI featuredMri = null;

    private Association association = null;

    private Reference reference = null;

    private Object oldValue = null;

    private Object newValue = null;

    private EndStorageLink linkAdded = null;

    private EndStorageLink linkRemoved = null;

    private List<MRI> elementsRepartitionedMri = null;

    private Map<MRI, StateSet> affectedElementStates = null;

    private byte addedViaReferenceOnEnd = -1;

    private int indexOfAddedLink = -1;

    private int indexOfRemovedLink = -1;

    public ReferenceChangeMicroTransactionableImpl( CoreConnection aConnection, RefFeatured aFeatured, Reference aReference, Association anAssociation, Object aNewValue, byte anAddedViaReferenceOnEnd ) {

        super( aConnection );
        featured = aFeatured;
        featuredMri = ( (CorePartitionable) aFeatured ).get___Mri( );
        association = anAssociation;
        reference = aReference;
        oldValue = ( (RefFeaturedImpl) featured ).refGetValue( connection, reference );
        newValue = aNewValue;
        addedViaReferenceOnEnd = anAddedViaReferenceOnEnd;
    }

    @Override
    public void assertDoPreConstraints( ) throws JmiException {

        int referenceUpperBound = reference.getMultiplicity( ).getUpper( );
        // setting a reference to null IS possible according to MOIN JMI enhancement MJE-01
//        if ( newValue == null ) {
//            // setting a reference to null results in an InvalidObjectException (JMI Spec, 4.8.6 (page 70))
//            InvalidObjectException exception = new InvalidObjectException( reference, "feature \"" + reference.getName( ) + "\" of \"" + ( (MofClass) featured.refMetaObject( ) ).getName( ) + "\" is a reference, references can not be set to null." );
//            log.preConstraintCheckException( exception );
//            throw exception;
//        }
        if ( referenceUpperBound == JmiHelper.MULTIPLICITY_BOUND_INFINITE || referenceUpperBound > 1 ) {
            // reference is multi-valued, so setting the value as a whole results in an InvalidCallException
            // (analogous to multi-valued attributes, JMI Spec, 5.2.2 (page 83), although there is no statement for references)
            InvalidCallException exception = new InvalidCallException( newValue, reference, MicroTransactionablesMessages.MULTIVALUEDREFERENCESNOTSETASWHOLE, reference.getName( ), ( (MofClass) featured.refMetaObject( ) ).getName( ) );
            log.preConstraintCheckException( exception );
            throw exception;
        }
        if ( ( newValue != null ) && !( newValue instanceof RefObject && ( (RefObjectImpl) newValue ).refIsInstanceOf( connection.getSession( ), ( (ReferenceImpl) reference ).getType( connection ), true ) ) ) {
            // newValue is not equals to null, it is also neither a RefObject nor is it of the correct reference type
            TypeMismatchException exception = new TypeMismatchException( ( (ReferenceImpl) reference ).getType( connection ).getClass( ), newValue, featured.refMetaObject( ), MicroTransactionablesMessages.FEATUREWRONGTYPE, reference.getName( ), ( (MofClass) featured.refMetaObject( ) ).getName( ),
                                                                         ( (ReferenceImpl) reference ).getType( connection ).getName( ), newValue.getClass( ) );
            log.preConstraintCheckException( exception );
            throw exception;
        }
    }

    @Override
    public void assertDoPostConstraints( ) throws JmiException {

        if ( linkAdded != null ) {
            MRI newMri = featuredMri;
            if ( elementsRepartitionedMri != null && elementsRepartitionedMri.contains( featuredMri ) ) {
                // ok, we did repartition the element
                StateSet ss = affectedElementStates.get( featuredMri );
                PRI newPartitionPri = (PRI) ss.getFinalState( ).get( StateSet.STATE_PARAMETER_PRI );
                // can not use old MRI because it has changed after
                // repartitioning during do phase
                newMri = newPartitionPri.createMri( featuredMri.getMofId( ) );
            }
            featured = (RefFeatured) getExistingElement( newMri );
            List<AssociationEnd> associationEnds = getJmiHelper( ).getAssociationEnds( connection.getSession( ), association );
            CorePartitionable[] ends = constructEnds( (CorePartitionable) featured, 1 - addedViaReferenceOnEnd, (CorePartitionable) newValue, addedViaReferenceOnEnd );
            if ( ends[1] != null ) {
                int fromEndUpperBound = associationEnds.get( 0 ).getMultiplicity( ).getUpper( );
                if ( fromEndUpperBound != MULTIPLICITY_BOUND_INFINITE ) {
                    int size = getLogicalLinkManager( ).getNumberOfElementsForEndAndMetaObjectIncludingOverflows( connection.getSession( ), getWorkspaceSet( ).getEndAndMetaObjectPool( ).getEndAndMetaObject( 1, association ), ends[1] );
                    if ( size > fromEndUpperBound ) {
                        // upper multiplicity at the from-side violated
                        WrongSizeException exception = new WrongSizeException( associationEnds.get( 0 ), MicroTransactionablesMessages.ASSOCIATIONENDHASUPPERMULTIPLICITY, associationEnds.get( 0 ).getName( ), association.getName( ), fromEndUpperBound );
                        log.preConstraintCheckException( exception );
                        throw exception;
                    }
                }
            }
            if ( ends[0] != null ) {
                int toEndUpperBound = associationEnds.get( 1 ).getMultiplicity( ).getUpper( );
                if ( toEndUpperBound != MULTIPLICITY_BOUND_INFINITE ) {
                    int size = getLogicalLinkManager( ).getNumberOfElementsForEndAndMetaObjectIncludingOverflows( connection.getSession( ), getWorkspaceSet( ).getEndAndMetaObjectPool( ).getEndAndMetaObject( 0, association ), ends[0] );
                    if ( size > toEndUpperBound ) {
                        // upper multiplicity at the to-side violated
                        WrongSizeException exception = new WrongSizeException( associationEnds.get( 1 ), MicroTransactionablesMessages.ASSOCIATIONENDHASUPPERMULTIPLICITY, associationEnds.get( 1 ).getName( ), association.getName( ), toEndUpperBound );
                        log.preConstraintCheckException( exception );
                        throw exception;
                    }
                }
            }
            // composition cycle and closure rule violation detection
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

        boolean eventCreationNeeded = eventCreationNeeded( );
        // actions and events
        if ( linkAdded != null ) {
            List<AssociationEnd> ends = connection.getCoreJmiHelper( ).getAssociationEnds( connection.getSession( ), (Association) linkAdded.getMetaObject( ) );
            getOrCreateDoActions( ).add( ActionFactory.createEndStorageLinkRemoveAction( connection, linkAdded.getStorageEnd( ).getMri( ), ends.get( linkAdded.getEndNumberOfOtherEnd( ) ).refMofId( ), linkAdded, indexOfAddedLink ) );
            if ( eventCreationNeeded ) {
                getOrCreateUndoEvents( ).add( getEventFactory( ).createLinkRemoveEvent( connection, linkAdded, indexOfAddedLink ) );
            }
        }
        // link add action
        if ( linkRemoved != null ) {
            List<AssociationEnd> ends = connection.getCoreJmiHelper( ).getAssociationEnds( connection.getSession( ), (Association) linkRemoved.getMetaObject( ) );
            getOrCreateDoActions( ).add( ActionFactory.createEndStorageLinkAddAction( connection, linkRemoved.getStorageEnd( ).getMri( ), ends.get( linkRemoved.getEndNumberOfOtherEnd( ) ).refMofId( ), linkRemoved, indexOfRemovedLink ) );
            if ( eventCreationNeeded ) {
                getOrCreateUndoEvents( ).add( getEventFactory( ).createLinkAddEvent( connection, linkRemoved, indexOfRemovedLink ) );
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
        referenceChanged = false;
    }

    @Override
    public void computeRedoActionsAndRedoEvents( ) {

        boolean doCase = false;
        copyOnWrite( doCase );
        resolve( true );
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

    private void computeDoActionsAndDoEvents( boolean doCase ) throws IllegalRelocateToDataAreaException {

        if ( doCase ) {
            if ( checkPreconditionsForChanging( (CorePartitionable) oldValue, (CorePartitionable) newValue ) ) {
                boolean isAssociationOrdered = getJmiHelper( ).getOrderedEnd( connection.getSession( ), this.association ) != -1;
                byte compositeEndNumber = getJmiHelper( ).getCompositeEnd( connection.getSession( ), association );
                boolean isComposition = ( compositeEndNumber != -1 );
                copyOnWrite( doCase );
                // compute the logical links to add and to remove, the affected
                // partitions and the elements to repartition
                Set<PRI> affectedPartitionsPri = new HashSet<PRI>( );
                if ( newValue != null ) {
                    // logical link to add
                    CorePartitionable[] ends = constructEnds( (CorePartitionable) featured, 1 - addedViaReferenceOnEnd, (CorePartitionable) newValue, addedViaReferenceOnEnd );
                    linkAdded = getLogicalLinkManager( ).createLink( connection.getSession( ), ends[0], ends[1], association, true );
                    assertNoCompositeLinkToMetamodelIfStorageAtParent( linkAdded );
                    if ( isAssociationOrdered ) {
                        byte storedEnd = getJmiHelper( ).getStoredEnd( connection.getSession( ), association );
                        List<AssociationEnd> associationEnds = getJmiHelper( ).getAssociationEnds( connection.getSession( ), association );
                        Collection<EndStorageLink> associationLinks = ( (RefFeaturedExtension) ends[storedEnd] ).get___AssociationLinks( associationEnds.get( 1 - storedEnd ).refMofId( ) );
                        if ( associationLinks == null ) {
                            indexOfAddedLink = 0;
                        } else {
                            indexOfAddedLink = associationLinks.size( );
                        }
                    }
                    // some additions lead to an implicit replacement of a link,
                    // this link has to be calculated
                    // logical link to remove
                    Pair<EndStorageLink, Integer> pair = getLinkToReplaceWithIndexInformation( linkAdded, addedViaReferenceOnEnd );
                    if ( pair != null ) {
                        linkRemoved = pair.getA( );
                        indexOfRemovedLink = pair.getB( );
                    }
                } else if ( oldValue != null ) {
                    // link deletion, only if there exists one, i.e. if the old
                    // value was != null
                    CorePartitionable[] ends = constructEnds( (CorePartitionable) featured, 1 - addedViaReferenceOnEnd, (CorePartitionable) oldValue, addedViaReferenceOnEnd );
                    // logical link to remove
                    linkRemoved = getLogicalLinkManager( ).getLink( connection.getSession( ), ends[0], ends[1], association, true );
                }
                // their affected partitions
                if ( linkAdded != null ) {
                    affectedPartitionsPri.add( linkAdded.getStorageEndMri( ).getPri( ) );
                }
                if ( linkRemoved != null ) {
                    affectedPartitionsPri.add( linkRemoved.getStorageEndMri( ).getPri( ) );
                }
                // elements to repartition and affected partitions
                if ( isComposition ) {

                    List<CorePartitionable> elementsToRepartitionForLinkAdd = null;
                    List<CorePartitionable> elementsToRepartitionForLinkRemove = null;
                    PRI newPartitionPriForLinkAdd = null;
                    PRI newPartitionPriForLinkRemove = null;

                    if ( linkRemoved != null ) {

                        CorePartitionable compositeEnd = linkRemoved.getEnd( linkRemoved.getCompositeEnd( ) ).get( connection.getSession( ) );
                        CorePartitionable componentEnd = linkRemoved.getEnd( linkRemoved.getComponentEnd( ) ).get( connection.getSession( ) );
                        elementsToRepartitionForLinkRemove = getElementsToRepartitionAfterLinkRemove( association, compositeEndNumber, componentEnd, compositeEnd.get___Partition( ) );
                        newPartitionPriForLinkRemove = getNullPartition( ).getPri( );
                    }

                    if ( linkAdded != null ) {
                        CorePartitionable compositeEnd = linkAdded.getEnd( linkAdded.getCompositeEnd( ) ).get( connection.getSession( ) );
                        CorePartitionable componentEnd = linkAdded.getEnd( linkAdded.getComponentEnd( ) ).get( connection.getSession( ) );
                        elementsToRepartitionForLinkAdd = getElementsToRepartitionAfterLinkAdd( association, compositeEndNumber, componentEnd, compositeEnd.get___Partition( ) );
                        newPartitionPriForLinkAdd = compositeEnd.get___Partition( ).getPri( );

                        //FIXME: partition magic: remove the following statement once the galaxy tests have been fixed 
                        //-> adjust our tests TestMicroTransactionablesReferences.testSingleReferenceChange() , TestPartitionAssignment.testAssociationGoingBackToNullPartitionOnLosingParentInSamePartition()
                        //-> remove System property in MoinSystemPropertyKeys
                        //-> remove method getSystemFlagDefaultFalse
                        if ( !getSystemFlagDefaultFalse( MoinSystemPropertyKeys.MOIN_PARTITIONMAGIC_FIX ) ) {
                            newPartitionPriForLinkRemove = compositeEnd.get___Partition( ).getPri( );
                        }
                    }

                    // If a link was replaced (removed and added), then the affect should be the same as link removal and subsequent link creation.
                    // but only if the same elements are affected both by removal and addition 
                    if ( linkAdded != null && elementsToRepartitionForLinkRemove != null && ( !elementsToRepartitionForLinkRemove.isEmpty( ) ) ) {
                        CorePartitionable componentEndOfLinkRemoved = linkRemoved.getEnd( linkRemoved.getComponentEnd( ) ).get( connection.getSession( ) );
                        CorePartitionable componentEndOfLinkAdded = linkAdded.getEnd( linkAdded.getComponentEnd( ) ).get( connection.getSession( ) );
                        if ( componentEndOfLinkAdded.equals( componentEndOfLinkRemoved ) ) {
                            //if the same direct child element is affected (removed and added), it must go to the parent's partition 
                            newPartitionPriForLinkRemove = newPartitionPriForLinkAdd;
                        }
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

                }

                PRI[] affectedPartitionPris = affectedPartitionsPri.toArray( new PRI[affectedPartitionsPri.size( )] );
                computePartitionsToLock( affectedPartitionPris );
                computePartitionsToEnsureEditing( affectedPartitionPris );
                computePartitionsToMarkDirty( affectedPartitionPris );
            }
        }
        // actions and events
        // aquire lock actions
        addEditLockActionsToDoActions( );
        // ensure editing allowed actions
        addEnsureEditingActionsToDoActions( );
        // link remove action and events, before add action
        boolean eventCreationNeeded = eventCreationNeeded( );
        if ( linkRemoved != null ) {
            List<AssociationEnd> ends = connection.getCoreJmiHelper( ).getAssociationEnds( connection.getSession( ), (Association) linkRemoved.getMetaObject( ) );
            getOrCreateDoActions( ).add( ActionFactory.createEndStorageLinkRemoveAction( connection, linkRemoved.getStorageEnd( ).getMri( ), ends.get( linkRemoved.getEndNumberOfOtherEnd( ) ).refMofId( ), linkRemoved, indexOfRemovedLink ) );
            referenceChanged = true;
            if ( eventCreationNeeded ) {
                getOrCreateDoEvents( ).add( getEventFactory( ).createLinkRemoveEvent( connection, linkRemoved, indexOfRemovedLink ) );
            }
        }
        // link add action and events
        if ( linkAdded != null ) {
            List<AssociationEnd> ends = connection.getCoreJmiHelper( ).getAssociationEnds( connection.getSession( ), (Association) linkAdded.getMetaObject( ) );
            getOrCreateDoActions( ).add( ActionFactory.createEndStorageLinkAddAction( connection, linkAdded.getStorageEnd( ).getMri( ), ends.get( linkAdded.getEndNumberOfOtherEnd( ) ).refMofId( ), linkAdded, indexOfAddedLink ) );
            referenceChanged = true;
            if ( eventCreationNeeded ) {
                getOrCreateDoEvents( ).add( getEventFactory( ).createLinkAddEvent( connection, linkAdded, indexOfAddedLink ) );
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
    }

    private void copyOnWrite( boolean doCase ) {

        if ( doCase ) {
            byte storedEnd = getJmiHelper( ).getStoredEnd( connection.getSession( ), association );
            if ( storedEnd == 1 - addedViaReferenceOnEnd ) {

                CorePartitionable coreElement = ( (CorePartitionable) featured );
                if ( coreElement.get___Workspace( ) == connection.getSession( ).getCompoundClientSpecWorkspace( ) ) {
                    createPrivateCopy( coreElement.get___Partition( ).getPri( ) );
                    featured = (RefObject) getExistingElement( coreElement.get___Mri( ) );
                }
            } else {
                PRI copied = null;
                if ( newValue != null ) {
                    CorePartitionable coreNewElement = ( (CorePartitionable) newValue );
                    if ( coreNewElement.get___Workspace( ) == connection.getSession( ).getCompoundClientSpecWorkspace( ) ) {
                        copied = coreNewElement.get___Partition( ).getPri( );
                        createPrivateCopy( copied );
                        newValue = getExistingElement( coreNewElement.get___Mri( ) );
                    }
                }
                if ( oldValue != null ) {
                    CorePartitionable coreOldElement = ( (CorePartitionable) oldValue );
                    if ( coreOldElement.get___Workspace( ) == connection.getSession( ).getCompoundClientSpecWorkspace( ) ) {
                        PRI oldValuePri = coreOldElement.get___Partition( ).getPri( );
                        if ( !oldValuePri.equals( copied ) ) {
                            createPrivateCopy( oldValuePri );
                        }
                        oldValue = getExistingElement( coreOldElement.get___Mri( ) );
                    }
                }
            }
        } else {//redo
            List<PRI> affectedPartitionsForRedo = getAffectedPartitionsForCopyOnWriteRedo( );
            for ( int i = 0; i < affectedPartitionsForRedo.size( ); i++ ) {
                createPrivateCopy( affectedPartitionsForRedo.get( i ) );
            }
        }
    }

    private void resolve( boolean redoCase ) {

        // newValue and oldValue do not need to be resolved because they are not
        // used after the do phase
        if ( redoCase ) {
            // we can resolve with the old MRIs
            featured = (RefFeatured) getExistingElement( featuredMri );
        } else {
            // undo case, take repartitions during the do phase into account,
            // i.e. resolve with the new MRI
            MRI newMri = featuredMri;
            if ( elementsRepartitionedMri != null && elementsRepartitionedMri.contains( featuredMri ) ) {
                PRI newPartitionPri = (PRI) affectedElementStates.get( featuredMri ).getFinalState( ).get( StateSet.STATE_PARAMETER_PRI );
                newMri = newPartitionPri.createMri( featuredMri.getMofId( ) );
            }
            featured = (RefFeatured) getExistingElement( newMri );
        }
    }

    private void unresolve( ) {

        featured = null;
        newValue = null;
        oldValue = null;
    }

    public boolean referenceChanged( ) {

        return referenceChanged;
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

    private static boolean getSystemFlagDefaultFalse( String flag ) {

        boolean result = false;
        // Check VM parameter
        if ( Boolean.getBoolean( flag ) ) {
            result = true;
        }
        // Check environment variable
        if ( "true".equals( System.getenv( flag ) ) ) { //$NON-NLS-1$
            result = true;
        }
        return result;
    }
}
