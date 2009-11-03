package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.__impl.AttributeInternal;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.TypeMismatchException;
import com.sap.tc.moin.repository.mmi.reflect.WrongSizeException;

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
import com.sap.tc.moin.repository.shared.util.IteratorKnowingCollection;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.transactions.microtransactionables.ObjectAttributeRemoveElementMicroTransactionable;

@SuppressWarnings( "unchecked" )
public class ObjectAttributeRemoveElementMicroTransactionableImpl extends AbstractMicroTransactionable implements ObjectAttributeRemoveElementMicroTransactionable {

    private boolean attributeChanged = false;

    private RefFeatured featured = null;

    private MRI featuredMri = null;

    private Attribute attribute = null;

    private int index = -1;

    private ArrayList<Integer> indices = null;

    private IteratorKnowingCollection<EndStorageLink> iterator = null;

    private int iterationStepsBeforeRemove = 0;

    private boolean removeAllOccurrences = false;

    private List<Object> elementsToRemove = null;

    private ArrayList<MRI> elementsRemovedMri = null;

    private ArrayList<EndStorageLink> linksRemoved = null;

    private List<MRI> elementsRepartitionedMri = null;

    private Map<MRI, StateSet> affectedElementStates = null;

    /**
     * Creates a Micro Transactionable that removes elements from a multi-valued
     * attribute whose classifier is a class
     */
    public ObjectAttributeRemoveElementMicroTransactionableImpl( CoreConnection aConnection, RefFeatured aFeatured, Attribute anAttribute, Collection theElementsToRemove, boolean isRemoveAllOccurrences ) {

        this( aConnection, aFeatured, anAttribute );

        if ( theElementsToRemove != null ) {
            if ( theElementsToRemove instanceof JmiList ) {
                JmiList elements = (JmiList) theElementsToRemove;
                elementsToRemove = new ArrayList( elements.size( aConnection.getSession( ) ) );
                for ( Iterator it = elements.iterator( aConnection ); it.hasNext( ); ) {
                    elementsToRemove.add( it.next( ) );
                }
            } else {
                elementsToRemove = new ArrayList( theElementsToRemove );
            }
            // eliminate duplicates
            // one element is enough in order to remove all its occurrences in a
            // collection
            eliminateDuplicates( elementsToRemove );
        }

        removeAllOccurrences = isRemoveAllOccurrences;
    }

    /**
     * Creates a Micro Transactionable that removes the element at position
     * <code>index</code> from a multi-valued attribute whose classifier is a
     * class
     */
    public ObjectAttributeRemoveElementMicroTransactionableImpl( CoreConnection aConnection, RefFeatured aFeatured, Attribute anAttribute, int anIndex ) {

        this( aConnection, aFeatured, anAttribute );
        index = anIndex;
    }

    /**
     * Creates a Micro Transactionable that removes the element at position
     * <code>theIterationStepsBeforeRemove - 1</code> via the given
     * <code>iterator</code> from a multi-valued attribute whose classifier is a
     * class
     */
    public ObjectAttributeRemoveElementMicroTransactionableImpl( CoreConnection aConnection, RefFeatured aFeatured, Attribute anAttribute, IteratorKnowingCollection<EndStorageLink> anIterator, int theIterationStepsBeforeRemove ) {

        this( aConnection, aFeatured, anAttribute );
        iterator = anIterator;
        iterationStepsBeforeRemove = theIterationStepsBeforeRemove;
    }

    private ObjectAttributeRemoveElementMicroTransactionableImpl( CoreConnection aConnection, RefFeatured aFeatured, Attribute anAttribute ) {

        super( aConnection );
        featured = aFeatured;
        featuredMri = ( (CorePartitionable) aFeatured ).get___Mri( );
        attribute = anAttribute;
    }

    @Override
    public void assertDoPreConstraints( ) throws JmiException, MoinNullPointerException {

        if ( iterator != null ) {
            // ok, we want to remove an element via an iterator
            // in order to compute the element that should be removed from the iterator, we have
            // to get another iterator from it and have to step over it to the correct position
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
            JmiList elements = getLogicalLinkManager( ).getElementsForEndAndMetaobject( connection, getWorkspaceSet( ).getEndAndMetaObjectPool( ).getEndAndMetaObject( 0, attribute ), (CorePartitionable) featured );
            if ( index > elements.size( connection.getSession( ) ) ) {
                throw new WrongSizeException( attribute, MicroTransactionablesMessages.INDEXISBIGGERTHANNUMBEROFELEMENTS, index, attribute.getName( ), ( (MofClass) featured.refMetaObject( ) ).getName( ), elements.size( connection.getSession( ) ) );
            }
            CorePartitionable elementToRemove = (CorePartitionable) ( elements ).get( connection.getSession( ), index );
            if ( elementsToRemove == null ) {
                elementsToRemove = new ArrayList<Object>( 1 );
            }
            elementsToRemove.add( elementToRemove );
        } else {
            // ok, we want to remove the elements specified
            for ( Object elementToRemove : elementsToRemove ) {
                if ( elementToRemove == null ) {
                    // attribute is multi-valued, so it can not contain null values (JMI Spec, page 68),
                    // a NullPointerException has to be thrown (see JavaDoc of Collection.remove(Object))
                    MoinNullPointerException exception = new MoinNullPointerException( MicroTransactionablesMessages.FEATUREOFCLASSISMULTIVALUEDNOREMOVE, attribute.getName( ), ( (MofClass) featured.refMetaObject( ) ).getName( ) );
                    log.preConstraintCheckException( exception );
                    throw exception;
                }
                Classifier type = ( (AttributeInternal) attribute ).getType( connection );
                if ( !checkTypeCompatibility( type, elementToRemove ) ) {
                    // elementToRemove is not of the correct attribute type (JMI Spec, page 68)
                    TypeMismatchException exception = new TypeMismatchException( type.getClass( ), elementToRemove, featured.refMetaObject( ), MicroTransactionablesMessages.FEATUREWRONGTYPE, attribute.getName( ), ( (MofClass) featured.refMetaObject( ) ).getName( ), attribute.getType( ).getName( ),
                                                                                 elementToRemove.getClass( ) );
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
            resolve( );
            // link add actions and events
            boolean eventCreationNeeded = eventCreationNeeded( );
            for ( int i = 0; i < linksRemoved.size( ); i++ ) {
                EndStorageLink linkRemoved = linksRemoved.get( i );
                CorePartitionable elementToRemove = linkRemoved.getEnd( linkRemoved.getComponentEnd( ) ).get( connection.getSession( ) );
                int position = indices.get( i );
                getOrCreateDoActions( ).add( ActionFactory.createEndStorageLinkAddAction( connection, linkRemoved.getStorageEnd( ).getMri( ), attribute.refMofId( ), linkRemoved, position ) );
                if ( eventCreationNeeded ) {
                    int eventIndex = position == -1 ? -1 : position - i;
                    getOrCreateUndoEvents( ).add( getEventFactory( ).createAttributeValueAddEvent( connection, featured, attribute, elementToRemove, eventIndex ) );
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
            attributeChanged = false;
        }
    }

    @Override
    public void computeRedoActionsAndRedoEvents( ) {

        resolve( );
        computeDoActionsAndDoEvents( false );
    }

    @Override
    public void doFinished( ) {

        super.doFinished( );
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
        unresolve( );
    }

    @Override
    public void undoFinished( ) {

        super.undoFinished( );
        this.elementsRepartitionedMri = null;
        this.elementsToRemove = null;
        unresolve( );
    }

    private void computeDoActionsAndDoEvents( boolean doCase ) {

        //needs to be done both in do and redo case
        copyOnWrite( );

        if ( !doCase ) {
            if ( elementsRemovedMri != null && elementsRemovedMri.size( ) > 0 ) {
                elementsToRemove = new ArrayList<Object>( elementsRemovedMri.size( ) );
                for ( int i = 0; i < elementsRemovedMri.size( ); i++ ) {
                    elementsToRemove.add( getExistingElement( elementsRemovedMri.get( i ) ) );
                }
            }
        }
        if ( elementsToRemove != null ) {

            // compute the links to remove, the affected partitions and the
            // elements to repartition
            CoreModelPartition partitionOfFeatured = ( (CorePartitionable) featured ).get___Partition( );
            boolean isOrdered = attribute.getMultiplicity( ).isOrdered( );
            JmiList<CorePartitionable> elements = (JmiList) ( (RefFeaturedImpl) featured ).refGetValue( connection, attribute );
            // pre calculation of the effective remove list
            // we need a helper structure that maps an element to the links
            // to remove, because
            // in the case of a non-unique attribute the same element can be
            // contained several times
            Set<PRI> affectedPartitionsPri = new HashSet<PRI>( );
            Map<MRI, Iterator> elementMriToLinksToRemoveMap = new HashMap<MRI, Iterator>( elementsToRemove.size( ) );
            linksRemoved = new ArrayList<EndStorageLink>( elementsToRemove.size( ) );
            indices = new ArrayList<Integer>( elementsToRemove.size( ) );
            elementsRemovedMri = new ArrayList<MRI>( elementsToRemove.size( ) );
            for ( Object elementToRemove : elementsToRemove ) {
                Collection<EndStorageLink> linksToRemove = getLogicalLinkManager( ).getLinksForAttribute( connection.getSession( ), (CorePartitionable) featured, (CorePartitionable) elementToRemove, attribute );
                elementMriToLinksToRemoveMap.put( ( (CorePartitionable) elementToRemove ).get___Mri( ), linksToRemove.iterator( ) );
            }
            Iterator<CorePartitionable> elementsIterator = elements.iteratorReadOnly( connection.getSession( ) );
            for ( ; elementsIterator.hasNext( ); ) {
                CorePartitionable element = elementsIterator.next( );
                if ( elementsToRemove.contains( element ) ) {
                    // ok element should be removed
                    int idx = isOrdered ? elements.indexOf( connection, element ) : -1;
                    MRI elementMri = element.get___Mri( );
                    if ( !removeAllOccurrences && elementsRemovedMri.contains( elementMri ) ) {
                        break;
                    }
                    elementsRemovedMri.add( elementMri );
                    // link to remove and affected partitions
                    // get the next link from internal helper structure,
                    // note that we can have non-unique attributes :)
                    EndStorageLink linkToRemove = (EndStorageLink) elementMriToLinksToRemoveMap.get( element.get___Mri( ) ).next( );
                    linksRemoved.add( linkToRemove );
                    indices.add( idx );
                    affectedPartitionsPri.add( linkToRemove.getStorageEndMri( ).getPri( ) );
                    // elements to repartition and affected partitions
                    List<CorePartitionable> elementsToRepartition = getElementsToRepartitionAfterLinkRemove( attribute, 0, element, partitionOfFeatured );
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
            // fulfill the contract, lists should be null if nothing should
            // be done
            linksRemoved = ( linksRemoved.size( ) == 0 ) ? null : linksRemoved;
            elementsRemovedMri = ( elementsRemovedMri.size( ) == 0 ) ? null : elementsRemovedMri;
            PRI[] affectedPartitionPris = affectedPartitionsPri.toArray( new PRI[affectedPartitionsPri.size( )] );
            computePartitionsToLock( affectedPartitionPris );
            computePartitionsToEnsureEditing( affectedPartitionPris );
            computePartitionsToMarkDirty( affectedPartitionPris );
        }

        // actions and events
        if ( linksRemoved != null ) {
            // aquire locks actions
            addEditLockActionsToDoActions( );
            // ensure editing allowed actions
            addEnsureEditingActionsToDoActions( );
            // link remove actions and events
            boolean eventCreationNeeded = eventCreationNeeded( );
            for ( int i = 0; i < linksRemoved.size( ); i++ ) {
                EndStorageLink linkRemoved = linksRemoved.get( i );
                int position = indices.get( i );
                getOrCreateDoActions( ).add( ActionFactory.createEndStorageLinkRemoveAction( connection, featuredMri, attribute.refMofId( ), linkRemoved, position, iterator ) );
                CorePartitionable elementToRemove = linkRemoved.getEnd( linkRemoved.getComponentEnd( ) ).get( connection.getSession( ) );
                if ( eventCreationNeeded ) {
                    int eventindex = position == -1 ? -1 : position - i;
                    getOrCreateDoEvents( ).add( getEventFactory( ).createAttributeValueRemoveEvent( connection, featured, attribute, elementToRemove, eventindex ) );
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
            attributeChanged = true;
        }
    }

    private void copyOnWrite( ) {

        if ( ( (CorePartitionable) featured ).get___Workspace( ) == connection.getSession( ).getCompoundClientSpecWorkspace( ) ) {
            createPrivateCopy( featuredMri.getPri( ) );
            featured = (RefFeatured) getExistingElement( featuredMri );
        }
    }

    private void resolve( ) {

        featured = (RefFeatured) getExistingElement( featuredMri );
    }

    private void unresolve( ) {

        featured = null;
    }

    public boolean attributeChanged( ) {

        return attributeChanged;
    }

    public List getElementsRemoved( ) {

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