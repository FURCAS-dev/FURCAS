package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import static com.sap.tc.moin.repository.JmiHelper.MULTIPLICITY_BOUND_INFINITE;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.consistency.DuplicateElementConsistencyViolation;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.MultiValuedAttributesList;
import com.sap.tc.moin.repository.core.UnresolvableException;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.consistency.impl.ConsistencyViolationRegistryImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefFeaturedImpl;
import com.sap.tc.moin.repository.core.transactions.actions.ActionFactory;
import com.sap.tc.moin.repository.core.transactions.actions.UpdateConsistencyRegistryAction;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.shared.util.IndexedElement;
import com.sap.tc.moin.repository.shared.util.Utilities;

public abstract class AbstractInstanceDeleteMicroTransactionableImpl extends AbstractMicroTransactionable {

    protected RefObject instanceDeleted = null;

    protected MRI instanceDeletedMri = null;

    protected MRI instanceDeletedMetaObjectMri = null;

    protected MRI instanceDeletedImmediatePackageMri = null;

    protected RefFeatured instanceDeletedParent = null;

    protected MRI instanceDeletedParentAttributeMri = null;

    protected int instanceDeletedParentAttributeIndex = -1;

    private List<IndexedElement<EndStorageLink>> linksRemoved = null;

    private List<MRI> elementsDeletedMri = null;

    private Map<MRI, StateSet> affectedElementStates = null;

    private Map<EndStorageLink, StateSet> affectedLinkStates = null;

    // table of elements that were used in case of duplicates before the deletion
    private Map<LRI, MRI> usedInconsistentElements = null;

    public AbstractInstanceDeleteMicroTransactionableImpl( CoreConnection aConnection, RefObject aRefObject ) {

        super( aConnection );
        instanceDeleted = aRefObject;
        instanceDeletedMri = ( (CorePartitionable) aRefObject ).get___Mri( );
        instanceDeletedMetaObjectMri = ( (CorePartitionable) aRefObject.refMetaObject( ) ).get___Mri( );
        instanceDeletedImmediatePackageMri = ( (CorePartitionable) aRefObject.refImmediatePackage( ) ).get___Mri( );
    }

    protected abstract void addAllComponentChildren( CorePartitionable instanceToDelete, List<CorePartitionable> instancesToDeleteTmp );

    @Override
    public void computeDoActionsAndDoEvents( ) {

        computeDoActionsAndDoEvents( true );
    }

    @Override
    @SuppressWarnings( "unchecked" )
    public void computeUndoActionsAndUndoEvents( ) {

        List<UpdateConsistencyRegistryAction> changeUsedMriActions = null;
        boolean eventCreationNeeded = eventCreationNeeded( );
        // instance create actions, data type attribute change actions and events
        for ( int i = elementsDeletedMri.size( ) - 1; i >= 0; i-- ) {
            MRI elementDeletedMri = elementsDeletedMri.get( i );
            StateSet ss = affectedElementStates.get( elementDeletedMri );
            Map<String, Object> initialState = ss.getInitialState( );
            MRI refClassMri = (MRI) initialState.get( StateSet.STATE_PARAMETER_REF_CLASS_MRI );
            // in the undo phase the attribute values are set from their "final" to their "initial" values
            // "initial" values are those ones, that the attributes had before the do phase of this micro transaction
            Map<Attribute, Object> initialParameters = (Map<Attribute, Object>) initialState.get( StateSet.STATE_PARAMETER_INSTANCE_PARAMETER );
            RefClass refClass = (RefClass) getExistingElement( refClassMri );
            RefPackage immediatePackage = refClass.refImmediatePackage( );
            PRI partitionPri = (PRI) initialState.get( StateSet.STATE_PARAMETER_PRI );
            Workspace workspace = (Workspace) initialState.get( StateSet.STATE_PARAMETER_WORKSPACE );
            List<LRI> parentLris = new ArrayList<LRI>( (List<LRI>) initialState.get( StateSet.STATE_PARAMETER_COMPOSITE_PARENTS ) );
            changeUsedMriActions = getConsistencyRegistryUpdateUndoActions( changeUsedMriActions, elementDeletedMri );
            getOrCreateUndoActions( ).add( ActionFactory.createInstanceCreateAction( connection, refClassMri, elementDeletedMri, partitionPri, workspace ) );
            if ( eventCreationNeeded ) {
                getOrCreateUndoEvents( ).add( getEventFactory( ).createElementCreateEvent( connection, elementDeletedMri, parentLris, refClassMri, ( (CorePartitionable) immediatePackage ).get___Mri( ) ) );
            }
            // we need the complete feature list to get the correct id, i.e. index, of the attribute
            List<StructuralFeature> features = getJmiHelper( ).getStructuralFeatures( connection.getSession( ), refClass.refMetaObject( ), true );
            if ( initialParameters != null ) {
                for ( Entry<Attribute, Object> entry : initialParameters.entrySet( ) ) {
                    Attribute attribute = entry.getKey( );
                    int attributeId = features.indexOf( attribute );
                    // compute the "final" values
                    // we need the final values for the action revert in case of an exception and for the partition change recorder that is called in the action
                    int attributeLowerBound = attribute.getMultiplicity( ).getLower( );
                    int attributeUpperBound = attribute.getMultiplicity( ).getUpper( );
                    Object finalParameter = null;
                    if ( attributeUpperBound == MULTIPLICITY_BOUND_INFINITE || attributeUpperBound > 1 ) {
                        // multi-valued
                        finalParameter = Collections.emptyList( );
                    } else {
                        // single-valued
                        if ( attributeLowerBound != 0 ) {
                            // required, the final value of a required single-valued primitive attribute is its Java default
                            finalParameter = getJmiHelper( ).getJavaReturnInitialWrapperValueFromClassifier( connection, getJmiHelper( ).getType( connection.getSession( ), attribute ) );
                        }
                    }
                    getOrCreateUndoActions( ).add( ActionFactory.createDataTypeAttributeChangeAction( connection, elementDeletedMri, attribute.getName( ), attributeId, finalParameter, entry.getValue( ) ) );
                }
            }
        }
        // link add actions
        if ( linksRemoved != null ) {
            List<IndexedElement<EndStorageLink>> tmpList = new ArrayList<IndexedElement<EndStorageLink>>( linksRemoved );
            Collections.sort( tmpList );
            for ( int i = 0; i < tmpList.size( ); i++ ) {
                EndStorageLink linkRemoved = tmpList.get( i ).element;
                int position = tmpList.get( i ).index;
                // getOrCreateUndoActions( ).add( ActionFactory.createLinkAddAction( connection, linkRemoved ) );
                if ( linkRemoved.getMetaObject( ) instanceof Association ) {
                    List<AssociationEnd> ends = connection.getCoreJmiHelper( ).getAssociationEnds( connection.getSession( ), (Association) linkRemoved.getMetaObject( ) );
                    getOrCreateDoActions( ).add( ActionFactory.createEndStorageLinkAddAction( connection, linkRemoved.getStorageEnd( ).getMri( ), ends.get( linkRemoved.getEndNumberOfOtherEnd( ) ).refMofId( ), linkRemoved, position ) );
                } else {
                    getOrCreateDoActions( ).add( ActionFactory.createEndStorageLinkAddAction( connection, linkRemoved.getStorageEnd( ).getMri( ), linkRemoved.getMetaObject( ).refMofId( ), linkRemoved, position ) );
                }
                if ( eventCreationNeeded ) {
                    ModelElement linkMetaObject = (ModelElement) linkRemoved.getMetaObject( );
                    if ( linkMetaObject instanceof Association ) {
                        // for added links to other instances fire link add events
                        Map<String, Object> initialState = affectedLinkStates.get( linkRemoved ).getInitialState( );
                        MRI firstLinkEndMri = (MRI) initialState.get( StateSet.STATE_PARAMETER_FIRST_LINK_END_MRI );
                        MRI secondLinkEndMri = (MRI) initialState.get( StateSet.STATE_PARAMETER_SECOND_LINK_END_MRI );
                        List<LRI> firstLinkEndParentLris = new ArrayList<LRI>( (List<LRI>) initialState.get( StateSet.STATE_PARAMETER_FIRST_LINK_END_COMPOSITE_PARENTS ) );
                        List<LRI> secondLinkEndParentLris = new ArrayList<LRI>( (List<LRI>) initialState.get( StateSet.STATE_PARAMETER_SECOND_LINK_END_COMPOSITE_PARENTS ) );
                        MofClass firstLinkEndMetaobject = (MofClass) initialState.get( StateSet.STATE_PARAMETER_FIRST_LINK_END_META_OBJECT );
                        MofClass secondLinkEndMetaobject = (MofClass) initialState.get( StateSet.STATE_PARAMETER_SECOND_LINK_END_META_OBJECT );
                        getOrCreateUndoEvents( ).add( getEventFactory( ).createLinkAddEvent( connection, linkMetaObject, position, firstLinkEndMri, firstLinkEndParentLris, firstLinkEndMetaobject, secondLinkEndMri, secondLinkEndParentLris, secondLinkEndMetaobject ) );
                    }
                }
            }
        }
        if ( eventCreationNeeded ) {
            if ( instanceDeletedParent != null && ( (CorePartitionable) instanceDeletedParent ).is___Alive( ) ) {
                Attribute instanceDeletedParentAttribute = (Attribute) getExistingElement( instanceDeletedParentAttributeMri );
                // if the instance to delete has a composite parent, fire an attribute value change or add event for the parent
                // it can be that the parent was deleted during the do phase of a ModelPartition.deleteElements() call for example.
                // This is because this call and its undo currently are not aware of composition hierarchies
                MRI instanceDeletedParentMri = ( (CorePartitionable) instanceDeletedParent ).get___Mri( );
                Map<String, Object> initialState = affectedElementStates.get( instanceDeletedMri ).getInitialState( );
                List<LRI> parentLris = new ArrayList( (List<LRI>) initialState.get( StateSet.STATE_PARAMETER_COMPOSITE_PARENTS ) );
                int parentAttributeUpperBound = instanceDeletedParentAttribute.getMultiplicity( ).getUpper( );
                MofClass instanceDeletedMetaObject = (MofClass) getExistingElement( instanceDeletedMetaObjectMri );
                if ( parentAttributeUpperBound == MULTIPLICITY_BOUND_INFINITE || parentAttributeUpperBound > 1 ) {
                    getOrCreateUndoEvents( ).add(
                                                  getEventFactory( )
                                                      .createAttributeValueAddEvent( connection, instanceDeletedParentMri, instanceDeletedImmediatePackageMri, parentLris, instanceDeletedMetaObject, instanceDeletedParentAttribute, instanceDeletedMri, instanceDeletedParentAttributeIndex ) );
                } else {
                    // value does change from null to not null
                    getOrCreateUndoEvents( ).add( getEventFactory( ).createAttributeValueChangeEvent( connection, instanceDeletedParentMri, instanceDeletedImmediatePackageMri, parentLris, instanceDeletedMetaObject, instanceDeletedParentAttribute, null, instanceDeletedMri ) );
                }
            }
        }
        // update inconsistency registry actions
        if ( changeUsedMriActions != null ) {
            getOrCreateUndoActions( ).addAll( changeUsedMriActions );
        }
        // partition clear dirty actions
        addClearDirtyActionsToUndoActions( );
        // release lock actions
        addReleaseLockActionsToUndoActions( );
    }

    private List<UpdateConsistencyRegistryAction> getConsistencyRegistryUpdateUndoActions( List<UpdateConsistencyRegistryAction> changeUsedMriActions, MRI elementDeletedMri ) {

        boolean toBeUsedIfDuplicate = this.useThisIfDuplicate( elementDeletedMri );
        if ( toBeUsedIfDuplicate ) {
            if ( changeUsedMriActions == null ) {
                changeUsedMriActions = new ArrayList<UpdateConsistencyRegistryAction>( );
            }
            changeUsedMriActions.add( ActionFactory.createUpdateConsistencyRegistryAction( connection, elementDeletedMri ) );
        }
        return changeUsedMriActions;
    }

    private List<UpdateConsistencyRegistryAction> getConsistencyRegistryUpdateDoActions( List<UpdateConsistencyRegistryAction> changeUsedMriActions, MRI elementDeletedMri ) {

        boolean toBeUsedIfDuplicate = this.useThisIfDuplicate( elementDeletedMri );
        if ( toBeUsedIfDuplicate ) {
            if ( changeUsedMriActions == null ) {
                changeUsedMriActions = new ArrayList<UpdateConsistencyRegistryAction>( );
            }
            MRI newUsedMri = null;

            // get new used element
            List<DuplicateElementConsistencyViolation> registeredDuplicateElements = this.connection.getConsistencyViolationRegistry( ).checkRegisteredDuplicateElement( elementDeletedMri.getLri( ) );

            for ( DuplicateElementConsistencyViolation duplicateElement : registeredDuplicateElements ) {
                if ( !duplicateElement.getMri( ).equals( elementDeletedMri ) ) {
                    newUsedMri = duplicateElement.getMri( );
                    break;
                }
            }

            changeUsedMriActions.add( ActionFactory.createUpdateConsistencyRegistryAction( connection, newUsedMri ) );
        }
        return changeUsedMriActions;
    }

    @Override
    public void computeRedoActionsAndRedoEvents( ) {

        resolve( );
        computeDoActionsAndDoEvents( false );
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

    @SuppressWarnings( "unchecked" )
    private void computeDoActionsAndDoEvents( boolean doCase ) {

        copyOnWrite( );//needs to be done in both do and redo case

        if ( doCase ) {

            computeParentData( );
            // collect the instances to delete in a temporary list
            ArrayList<CorePartitionable> instancesToDelete = new ArrayList<CorePartitionable>( );
            instancesToDelete.add( (CorePartitionable) instanceDeleted );

            addAllComponentChildren( (CorePartitionable) instanceDeleted, instancesToDelete );
            instancesToDelete.trimToSize( );

            List<String> instancesToDeleteMofId = new ArrayList<String>( instancesToDelete.size( ) );
            for ( int i = 0, n = instancesToDelete.size( ); i < n; i++ ) {
                instancesToDeleteMofId.add( instancesToDelete.get( i ).refMofId( ) );
            }
            collectInconsistentElements( instancesToDelete );
            // compute the states of the instances to delete and the affected partitions of these elements
            Set<PRI> affectedPartitionsPri = new HashSet<PRI>( );
            elementsDeletedMri = new ArrayList<MRI>( instancesToDelete.size( ) );
            affectedElementStates = new HashMap<MRI, StateSet>( Utilities.calcInitialCapacity( instancesToDelete.size( ) ) );

            for ( int i = 0, n = instancesToDelete.size( ); i < n; i++ ) {
                CorePartitionable instanceToDelete = instancesToDelete.get( i );
                MRI instanceMri = instanceToDelete.get___Mri( );
                Map<String, Object> initialState = StateSet.createState( );
                StateSet ss = new StateSet( initialState, null );
                initialState.put( StateSet.STATE_PARAMETER_PRI, instanceMri.getPri( ) );
                initialState.put( StateSet.STATE_PARAMETER_REF_CLASS_MRI, ( (CorePartitionable) ( (RefObject) instanceToDelete ).refClass( ) ).get___Mri( ) );
                initialState.put( StateSet.STATE_PARAMETER_WORKSPACE, instanceToDelete.get___Workspace( ) );
                List<CorePartitionable> compositeParents = getAllCompositeParents( instanceToDelete );
                List<LRI> compositeParentLris = new ArrayList<LRI>( compositeParents.size( ) );
                for ( int j = 0, m = compositeParents.size( ); j < m; j++ ) {
                    compositeParentLris.add( compositeParents.get( j ).get___Mri( ).getLri( ) );
                }
                initialState.put( StateSet.STATE_PARAMETER_COMPOSITE_PARENTS, compositeParentLris );
                // data type attribute initial values
                List<Attribute> attributes = getJmiHelper( ).getAttributes( connection.getSession( ), ( (RefObject) instanceToDelete ).refClass( ).refMetaObject( ), true );
                Map<Attribute, Object> initialParameters = attributes.size( ) == 0 ? null : new HashMap<Attribute, Object>( attributes.size( ) );
                for ( int j = 0, m = attributes.size( ); j < m; j++ ) {
                    Attribute attribute = attributes.get( j );
                    if ( attribute.isDerived( ) || getJmiHelper( ).getType( connection.getSession( ), attribute ) instanceof MofClass ) {
                        continue;
                    }
                    int attributeUpperBound = attribute.getMultiplicity( ).getUpper( );
                    Object initialParameter = null;
                    if ( attributeUpperBound == MULTIPLICITY_BOUND_INFINITE || attributeUpperBound > 1 ) {
                        // multi-valued
                        initialParameter = ( (MultiValuedAttributesList<Object>) ( (RefFeaturedImpl) instanceToDelete ).refGetValue( connection, attribute.getName( ) ) ).clone( );
                    } else {
                        // single-valued
                        initialParameter = ( (RefFeaturedImpl) instanceToDelete ).refGetValue( connection, attribute.getName( ) );
                    }
                    initialParameters.put( attribute, initialParameter );
                }
                initialState.put( StateSet.STATE_PARAMETER_INSTANCE_PARAMETER, initialParameters );
                // add element and its state set to the element delete list
                elementsDeletedMri.add( instanceMri );
                affectedElementStates.put( instanceMri, ss );
                // affected partition
                affectedPartitionsPri.add( instanceMri.getPri( ) );
            }
            Map<EndStorageLink, Integer> linksToDelete = getLinksToDelete( instancesToDelete );
            // compute the links to delete and the affected partitions
            if ( !linksToDelete.isEmpty( ) ) {
                linksRemoved = new ArrayList<IndexedElement<EndStorageLink>>( linksToDelete.size( ) );
                affectedLinkStates = new HashMap<EndStorageLink, StateSet>( Utilities.calcInitialCapacity( linksToDelete.size( ) ) );
                Set<Entry<EndStorageLink, Integer>> linksToDeleteWithIndexInfo = linksToDelete.entrySet( );
                for ( Entry<EndStorageLink, Integer> linkToDeleteEntry : linksToDeleteWithIndexInfo ) {
                    EndStorageLink linkToDelete = linkToDeleteEntry.getKey( );
                    Integer indexOfLinkToDelete = linkToDeleteEntry.getValue( );
                    Map<String, Object> initialState = StateSet.createState( );
                    Map<String, Object> finalState = StateSet.createState( );
                    StateSet ss = new StateSet( initialState, finalState );
                    // Due to possible inconsistencies, it has to be checked if the link ends can be resolved
                    MRI linkEnd0Mri = getLinkEndMri( linkToDelete, 0 );
                    if ( linkEnd0Mri != null ) {
                        initialState.put( StateSet.STATE_PARAMETER_FIRST_LINK_END_MRI, linkEnd0Mri );
                        initialState.put( StateSet.STATE_PARAMETER_FIRST_LINK_END_META_OBJECT, linkToDelete.getEnd( 0 ).getType( connection.getSession( ) ) );
                    }
                    MRI linkEnd1Mri = getLinkEndMri( linkToDelete, 1 );
                    if ( linkEnd1Mri != null ) {
                        initialState.put( StateSet.STATE_PARAMETER_SECOND_LINK_END_MRI, linkEnd1Mri );
                        initialState.put( StateSet.STATE_PARAMETER_SECOND_LINK_END_META_OBJECT, linkToDelete.getEnd( 1 ).getType( connection.getSession( ) ) );
                    }
                    if ( linkEnd0Mri != null ) {
                        List<CorePartitionable> firstLinkEndCompositeParents = getAllCompositeParents( linkToDelete.getEnd( 0 ).get( connection.getSession( ) ) );
                        List<LRI> firstLinkEndCompositeParentLris = new ArrayList<LRI>( firstLinkEndCompositeParents.size( ) );
                        for ( int i = 0, n = firstLinkEndCompositeParents.size( ); i < n; i++ ) {
                            firstLinkEndCompositeParentLris.add( firstLinkEndCompositeParents.get( i ).get___Mri( ).getLri( ) );
                        }
                        initialState.put( StateSet.STATE_PARAMETER_FIRST_LINK_END_COMPOSITE_PARENTS, firstLinkEndCompositeParentLris );
                    } else {
                	initialState.put( StateSet.STATE_PARAMETER_FIRST_LINK_END_COMPOSITE_PARENTS, Collections.emptyList() );
                    }
                    if ( linkEnd1Mri != null ) {
                        List<CorePartitionable> secondLinkEndCompositeParents = getAllCompositeParents( linkToDelete.getEnd( 1 ).get( connection.getSession( ) ) );
                        List<LRI> secondLinkEndCompositeParentLris = new ArrayList<LRI>( secondLinkEndCompositeParents.size( ) );
                        for ( int i = 0, n = secondLinkEndCompositeParents.size( ); i < n; i++ ) {
                            secondLinkEndCompositeParentLris.add( secondLinkEndCompositeParents.get( i ).get___Mri( ).getLri( ) );
                        }
                        initialState.put( StateSet.STATE_PARAMETER_SECOND_LINK_END_COMPOSITE_PARENTS, secondLinkEndCompositeParentLris );
                    } else {
                	initialState.put( StateSet.STATE_PARAMETER_SECOND_LINK_END_COMPOSITE_PARENTS, Collections.emptyList() );
                    }
                    // compute the affected partitions
                    affectedPartitionsPri.add( linkToDelete.getStorageEndMri( ).getPri( ) );
                    EndStorageLink checkedLink = checkLink( linkToDelete );
                    if ( checkedLink != null ) {
                        linksRemoved.add( new IndexedElement( indexOfLinkToDelete, checkedLink ) );
                        affectedLinkStates.put( checkedLink, ss );
                        // compute the elements to repartition
                        int compositeEndNumber = linkToDelete.getCompositeEnd( );
                        if ( compositeEndNumber == -1 ) {
                            continue;
                        }

                    }
                }
            }
            PRI[] affectedPartitionPris = affectedPartitionsPri.toArray( new PRI[affectedPartitionsPri.size( )] );
            computePartitionsToLock( affectedPartitionPris );
            computePartitionsToEnsureEditing( affectedPartitionPris );
            computePartitionsToMarkDirty( affectedPartitionPris );
        }
        // actions and events
        // aquire locks actions
        addEditLockActionsToDoActions( );
        // ensure editing allowed actions
        addEnsureEditingActionsToDoActions( );
        // link remove actions, before instance delete actions
        if ( linksRemoved != null ) {
            // sort the link list in descending order to ensure ascending order during a potential revert case
            List<IndexedElement<EndStorageLink>> tmpList = new ArrayList<IndexedElement<EndStorageLink>>( linksRemoved );
            Collections.sort( tmpList, Collections.reverseOrder( ) );
            for ( int i = 0, n = tmpList.size( ); i < n; i++ ) {
                EndStorageLink linkRemoved = tmpList.get( i ).element;
                int position = tmpList.get( i ).index;
                if ( linkRemoved.getMetaObject( ) instanceof Association ) {
                    List<AssociationEnd> ends = connection.getCoreJmiHelper( ).getAssociationEnds( connection.getSession( ), (Association) linkRemoved.getMetaObject( ) );
                    getOrCreateDoActions( ).add( ActionFactory.createEndStorageLinkRemoveAction( connection, linkRemoved.getStorageEnd( ).getMri( ), ends.get( linkRemoved.getEndNumberOfOtherEnd( ) ).refMofId( ), linkRemoved, position ) );
                } else {
                    getOrCreateDoActions( ).add( ActionFactory.createEndStorageLinkRemoveAction( connection, linkRemoved.getStorageEnd( ).getMri( ), linkRemoved.getMetaObject( ).refMofId( ), linkRemoved, position ) );
                }
            }
        }
        List<UpdateConsistencyRegistryAction> changeUsedMriActions = null;
        // instance delete actions
        for ( int i = 0, n = elementsDeletedMri.size( ); i < n; i++ ) {
            getOrCreateDoActions( ).add( ActionFactory.createInstanceDeleteAction( connection, elementsDeletedMri.get( i ) ) );
            changeUsedMriActions = this.getConsistencyRegistryUpdateDoActions( changeUsedMriActions, elementsDeletedMri.get( i ) );
        }
        // update inconsistency registry actions
        if ( changeUsedMriActions != null ) {
            getOrCreateDoActions( ).addAll( changeUsedMriActions );
        }
        // partition assign actions are not necessary for the just deleted instances
        // (partition assignment is removed in the instance delete action)
        // partition mark dirty actions
        addMarkDirtyActionsToDoActions( );
        // events
        if ( eventCreationNeeded( ) ) {
            for ( int i = elementsDeletedMri.size( ) - 1; i >= 0; i-- ) {
                // element delete events first, beginning from the bottom of the composition tree
                getOrCreateDoEvents( ).add( getEventFactory( ).createElementDeleteEvent( connection, (RefFeatured) getExistingElement( elementsDeletedMri.get( i ) ) ) );
            }
            if ( linksRemoved != null ) {
                List<IndexedElement<EndStorageLink>> tmpList = new ArrayList<IndexedElement<EndStorageLink>>( linksRemoved );
                Collections.sort( tmpList );
                for ( int i = 0, n = tmpList.size( ); i < n; i++ ) {
                    EndStorageLink linkRemoved = tmpList.get( i ).element;
                    int position = tmpList.get( i ).index;
                    if ( linkRemoved.getMetaObject( ) instanceof Association ) {
                        // for deleted links to other instances fire link remove events
                        getOrCreateDoEvents( ).add( getEventFactory( ).createLinkRemoveEvent( connection, linkRemoved, position ) );
                    }
                }
            }
            if ( instanceDeletedParent != null && ( (CorePartitionable) instanceDeletedParent ).is___Alive( ) ) {
                Attribute instanceDeletedParentAttribute = (Attribute) getExistingElement( instanceDeletedParentAttributeMri );
                // if the instance to delete has a composite parent, fire an attribute value change or remove event for the parent
                // it can be that the parent was deleted during the do phase of a ModelPartition.deleteElements() call for example.
                // This is because this call and its undo currently are not aware of composition hierarchies
                int parentAttributeUpperBound = instanceDeletedParentAttribute.getMultiplicity( ).getUpper( );
                if ( parentAttributeUpperBound == MULTIPLICITY_BOUND_INFINITE || parentAttributeUpperBound > 1 ) {
                    getOrCreateDoEvents( ).add( getEventFactory( ).createAttributeValueRemoveEvent( connection, instanceDeletedParent, instanceDeletedParentAttribute, instanceDeleted, instanceDeletedParentAttributeIndex ) );
                } else {
                    // value does change to null
                    getOrCreateDoEvents( ).add( getEventFactory( ).createAttributeValueChangeEvent( connection, instanceDeletedParent, instanceDeletedParentAttribute, instanceDeleted, null ) );
                }
            }
        }
    }

    private void copyOnWrite( ) {

        CorePartitionable coreElement = (CorePartitionable) instanceDeleted;
        if ( coreElement.get___Workspace( ) == connection.getSession( ).getCompoundClientSpecWorkspace( ) ) {
            createPrivateCopy( coreElement.get___Partition( ).getPri( ) );
            instanceDeleted = (RefObject) getExistingElement( instanceDeletedMri );
        }
        Collection<PRI> affectedPartitionsForRefDelete = getJmiHelper( ).getAffectedPartitionsForRefDelete( connection.getSession( ), instanceDeleted );
        for ( PRI pri : affectedPartitionsForRefDelete ) {
            if ( !pri.equals( instanceDeletedMri.getPri( ) ) ) {
                createPrivateCopy( pri );
            }
        }
    }

    protected Map<EndStorageLink, Integer> getLinksToDelete( ArrayList<CorePartitionable> instancesToDelete ) {

        // collect the links to delete in a temporary set
        // A Set needs to be used to filter out duplicate LogicalLinks which are found by getting all links to children of the element to be deleted
        // Note also that we need to preserve the order of the link collection that is returned by the LogicalLinkManager
        Map<EndStorageLink, Integer> linksToDelete = new LinkedHashMap<EndStorageLink, Integer>( );

        for ( int i = 0, n = instancesToDelete.size( ); i < n; i++ ) {
            Map<EndStorageLink, Integer> linksForElement = getLogicalLinkManager( ).getLinksForElementWithIndexInformation( connection.getSession( ), instancesToDelete.get( i ) );
            linksToDelete.putAll( linksForElement );
        }
        return linksToDelete;
    }

    @SuppressWarnings( "unchecked" )
    protected void computeParentData( ) {

        // get the parent, if present
        EndStorageLink linkToParent = getLogicalLinkManager( ).getCompositeParentLink( connection.getSession( ), (CorePartitionable) instanceDeleted );
        if ( linkToParent != null && ( linkToParent.getMetaObject( ) instanceof Attribute ) ) {
            // the instance to delete is an attribute of another instance
            instanceDeletedParent = (RefFeatured) linkToParent.getEnd( linkToParent.getCompositeEnd( ) ).get( connection.getSession( ) );
            Attribute instanceDeletedParentAttribute = (Attribute) linkToParent.getMetaObject( );
            instanceDeletedParentAttributeMri = ( (CorePartitionable) instanceDeletedParentAttribute ).get___Mri( );
            if ( instanceDeletedParentAttribute.getMultiplicity( ).isOrdered( ) ) {
                instanceDeletedParentAttributeIndex = ( (JmiList) ( (RefFeaturedImpl) instanceDeletedParent ).refGetValue( connection, instanceDeletedParentAttribute.getName( ) ) ).indexOf( connection, instanceDeleted );
            }
        }
    }

    private void collectInconsistentElements( List<CorePartitionable> instancesToDelete ) {

        for ( CorePartitionable element : instancesToDelete ) {
            DuplicateElementConsistencyViolation foundViolation = this.connection.getConsistencyViolationRegistry( ).checkRegisteredDuplicateElement( element.get___Mri( ) );
            if ( foundViolation != null ) {
                // put in to table of used elements
                MRI usedElementsMri = foundViolation.getUsedElementsMri( );
                getUsedInconsistentElements( ).put( usedElementsMri.getLri( ), usedElementsMri );
            }
        }
    }

    private Map<LRI, MRI> getUsedInconsistentElements( ) {

        if ( this.usedInconsistentElements == null ) {
            this.usedInconsistentElements = new HashMap<LRI, MRI>( );
        }
        return this.usedInconsistentElements;
    }

    private boolean useThisIfDuplicate( MRI elementDeletedMri ) {

        if ( this.usedInconsistentElements != null ) {
            MRI mriToBeUsed = this.usedInconsistentElements.get( elementDeletedMri.getLri( ) );
            if ( mriToBeUsed != null ) {
                return ( mriToBeUsed.equals( elementDeletedMri ) );
            }
        }
        return false;
    }

    private void resolve( ) {

        instanceDeleted = (RefObject) getExistingElement( instanceDeletedMri );
    }

    private void unresolve( ) {

        instanceDeleted = null;
    }

    private MRI getLinkEndMri( EndStorageLink linkToDelete, int linkEndNumber ) {

        try {
            return linkToDelete.getEnd( linkEndNumber ).getMri( connection.getSession( ) );
        } catch ( UnresolvableException e ) {
            // inform the ConsistencyViolationRegistry because the information can be used in the undo case
            connection.getConsistencyViolationRegistry( ).notifyDanglingLinkInconsistency( linkToDelete.getEnd( linkEndNumber ).getLri( ), linkToDelete );
            return null;
        }
    }

    protected EndStorageLink checkLink( EndStorageLink linkToCheck ) {

        return checkLink( linkToCheck, false );
    }

    protected EndStorageLink checkLink( EndStorageLink linkToCheck, boolean checkPersistence ) {

        boolean checkIndex = checkPersistence;

        // check consistency of other end
        MRI storageEnd = linkToCheck.getStorageEnd( ).getMri( );
        LRI otherEnd = linkToCheck.getOtherEnd( ).getLri( );
        ConsistencyViolationRegistryImpl consistencyViolationRegistry = (ConsistencyViolationRegistryImpl) connection.getConsistencyViolationRegistry( );
        if ( consistencyViolationRegistry.getUsedDuplicateElement( otherEnd ) != null ) {
            // if there is a used element entry, there was, at least once, an inconsistency - check persistence then
            checkIndex = true;
        }
        if ( ( consistencyViolationRegistry.checkRegisteredDuplicateElement( connection, otherEnd, checkIndex ) != null ) && ( !elementsDeletedMri.contains( storageEnd ) ) ) {
            // if the other end is inconsistent and the stored end does not belong to an element that is to be deleted, return null
            return null;
        } else {
            return linkToCheck;
        }
    }
}
