package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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
import com.sap.tc.moin.repository.mmi.reflect.WrongSizeException;

import com.sap.tc.moin.repository.JmiHelper;
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
import com.sap.tc.moin.repository.transactions.microtransactionables.ObjectAttributeAddElementMicroTransactionable;

@SuppressWarnings( "unchecked" )
public class ObjectAttributeAddElementMicroTransactionableImpl extends AbstractMicroTransactionable implements ObjectAttributeAddElementMicroTransactionable {

    private boolean attributeChanged = false;

    private RefFeatured featured = null;

    private MRI featuredMri = null;

    private Attribute attribute = null;

    private int index = -1;

    private List<Object> elementsToAdd = null;

    private List<EndStorageLink> linksAdded = null;

    private int[] indices = null;

    private List<MRI> elementsRepartitionedMri = null;

    private Map<MRI, StateSet> affectedElementStates = null;

    /**
     * Creates a Micro Transactionable that adds elements to a multi-valued
     * attribute whose classifier is a class
     */
    public ObjectAttributeAddElementMicroTransactionableImpl( CoreConnection aConnection, RefFeatured aFeatured, Attribute anAttribute, Collection theElementsToAdd ) {

        this( aConnection, aFeatured, anAttribute, -1, theElementsToAdd );
    }

    /**
     * Creates a Micro Transactionable that adds elements at position
     * <code>index</code> to a multi-valued attribute whose classifier is a
     * class
     */
    public ObjectAttributeAddElementMicroTransactionableImpl( CoreConnection aConnection, RefFeatured aFeatured, Attribute anAttribute, int anIndex, Collection theElementsToAdd ) {

        super( aConnection );
        featured = aFeatured;
        featuredMri = ( (CorePartitionable) aFeatured ).get___Mri( );
        attribute = anAttribute;
        index = anIndex;
        if ( theElementsToAdd != null ) {

            if ( theElementsToAdd instanceof JmiList ) {
                JmiList elements = (JmiList) theElementsToAdd;
                elementsToAdd = new ArrayList( elements.size( aConnection.getSession( ) ) );
                for ( Iterator it = elements.iterator( aConnection ); it.hasNext( ); ) {
                    elementsToAdd.add( it.next( ) );
                }
            } else {
                elementsToAdd = new ArrayList( theElementsToAdd );
            }

            if ( anAttribute.getMultiplicity( ).isUnique( ) ) {
                // eliminate duplicates if the attribute is unique
                eliminateDuplicates( elementsToAdd );
            }
        }
    }

    @Override
    public void assertDoPreConstraints( ) throws JmiException, MoinNullPointerException {

        if ( elementsToAdd != null ) {
            JmiList elements = (JmiList) ( (RefFeaturedImpl) featured ).refGetValue( connection, attribute );
            for ( int i = 0; i < elementsToAdd.size( ); i++ ) {
                Object elementToAdd = elementsToAdd.get( i );
                if ( elementToAdd == null ) {
                    // attribute is multi-valued, so adding a null value results in a MoinNullPointerException (JMI Spec, page 68)
                    MoinNullPointerException exception = new MoinNullPointerException( MicroTransactionablesMessages.FEATUREOFCLASSISMULTIVALUEDNOADD, attribute.getName( ), ( (MofClass) featured.refMetaObject( ) ).getName( ) );
                    log.preConstraintCheckException( exception );
                    throw exception;
                }
                Classifier type = getJmiHelper( ).getType( connection.getSession( ), attribute );
                if ( !checkTypeCompatibility( type, elementToAdd ) ) {
                    // elementToAdd is not of the correct attribute type (JMI Spec, page 68)
                    TypeMismatchException exception = new TypeMismatchException( type.getClass( ), elementToAdd, featured.refMetaObject( ), MicroTransactionablesMessages.FEATUREWRONGTYPE, attribute.getName( ), ( (MofClass) featured.refMetaObject( ) ).getName( ), type.getName( ), elementToAdd
                        .getClass( ) );
                    log.preConstraintCheckException( exception );
                    throw exception;
                }
                if ( attribute.getMultiplicity( ).isUnique( ) && elements.contains( connection, elementToAdd ) ) {
                    DuplicateException exception = new DuplicateException( elementToAdd, featured.refMetaObject( ), MicroTransactionablesMessages.FEATUREISUNIQUE, attribute.getName( ), ( (MofClass) featured.refMetaObject( ) ).getName( ) );
                    log.preConstraintCheckException( exception );
                    throw exception;
                }
            }
        }
    }

    @Override
    public void assertDoPostConstraints( ) throws JmiException {

        if ( linksAdded != null ) {
            int attributeUpperBound = attribute.getMultiplicity( ).getUpper( );
            JmiList elements = (JmiList) ( (RefFeaturedImpl) featured ).refGetValue( connection, attribute );
            if ( attributeUpperBound != JmiHelper.MULTIPLICITY_BOUND_INFINITE && elements.size( connection.getSession( ) ) > attributeUpperBound ) {
                // upper multiplicity violated
                WrongSizeException exception = new WrongSizeException( attribute, MicroTransactionablesMessages.FEATUREHASUPPERMULTIPLICITY, attribute.getName( ), ( (MofClass) featured.refMetaObject( ) ).getName( ), attributeUpperBound );
                log.preConstraintCheckException( exception );
                throw exception;
            }
            // composition cycle and closure rule violation detection
            for ( int i = 0; i < linksAdded.size( ); i++ ) {
                EndStorageLink linkAdded = linksAdded.get( i );
                assertCompositionCycle( linkAdded );
                assertCompositionClosure( linkAdded );
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
            resolve( );
            // link remove actions and events
            boolean eventCreationNeeded = eventCreationNeeded( );
            for ( int i = 0; i < linksAdded.size( ); i++ ) {
                EndStorageLink linkAdded = linksAdded.get( i );
                CorePartitionable elementToAdd = linkAdded.getEnd( linkAdded.getComponentEnd( ) ).get( connection.getSession( ) );
                int position = indices[i];
                getOrCreateDoActions( ).add( ActionFactory.createEndStorageLinkRemoveAction( connection, linkAdded.getStorageEnd( ).getMri( ), attribute.refMofId( ), linkAdded, position ) );
                if ( eventCreationNeeded ) {
                    getOrCreateUndoEvents( ).add( getEventFactory( ).createAttributeValueRemoveEvent( connection, featured, attribute, elementToAdd, position ) );
                }
            }
            // partition assign actions and events
            if ( elementsRepartitionedMri != null ) {
                for ( int i = 0; i < elementsRepartitionedMri.size( ); i++ ) {
                    MRI elementRepartitionedMri = elementsRepartitionedMri.get( i );
                    StateSet ss = affectedElementStates.get( elementRepartitionedMri );
                    PRI oldPartitionPri = (PRI) ss.getInitialState( ).get( StateSet.STATE_PARAMETER_PRI );
                    PRI newPartitionPri = (PRI) ss.getFinalState( ).get( StateSet.STATE_PARAMETER_PRI );
                    // can not use old MRI because it has changed after
                    // repartitioning
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
        elementsToAdd = null;
        unresolve( );
    }

    @Override
    public void undoFinished( ) {

        super.undoFinished( );
        unresolve( );
    }

    private void computeDoActionsAndDoEvents( boolean doCase ) {

        //must be done both in do and redo case
        copyOnWrite( );

        if ( doCase ) {
            // compute the links to add, the affected partitions and the
            // elements to repartition
            if ( elementsToAdd != null ) {
                Set<PRI> affectedPartitionsPri = new HashSet<PRI>( );
                CoreModelPartition partitionOfFeatured = ( (CorePartitionable) featured ).get___Partition( );
                boolean isOrdered = attribute.getMultiplicity( ).isOrdered( );
                Collection elements = (Collection) ( (RefFeaturedImpl) featured ).refGetValue( connection, attribute );
                int indexToAdd = ( index == -1 && isOrdered ) ? ( (JmiList) elements ).size( connection.getSession( ) ) : index;
                int size = elementsToAdd.size( );
                linksAdded = new ArrayList<EndStorageLink>( size );
                indices = new int[size];
                for ( int i = 0; i < elementsToAdd.size( ); i++ ) {
                    CorePartitionable elementToAdd = (CorePartitionable) elementsToAdd.get( i );
                    // link to add and affected partitions
                    EndStorageLink linkToAdd = getLogicalLinkManager( ).createLink( connection.getSession( ), (CorePartitionable) featured, elementToAdd, attribute, false );
                    linksAdded.add( linkToAdd );
                    assertNoCompositeLinkToMetamodelIfStorageAtParent( linkToAdd );
                    indices[i] = indexToAdd;
                    affectedPartitionsPri.add( linkToAdd.getStorageEndMri( ).getPri( ) );
                    // elements to repartition and affected partitions
                    List<CorePartitionable> elementsToRepartition = getElementsToRepartitionAfterLinkAdd( attribute, 0, elementToAdd, partitionOfFeatured );
                    if ( elementsRepartitionedMri == null && !elementsToRepartition.isEmpty( ) ) {
                        elementsRepartitionedMri = new ArrayList<MRI>( elementsToRepartition.size( ) );
                    }
                    if ( affectedElementStates == null ) {
                        affectedElementStates = new HashMap<MRI, StateSet>( Utilities.calcInitialCapacity( elementsToRepartition.size( ) ) );
                    }
                    for ( CorePartitionable elementToRepartition : elementsToRepartition ) {
                        PRI oldPartitionPri = elementToRepartition.get___Partition( ).getPri( );
                        PRI newPartitionPri = partitionOfFeatured.getPri( );
                        Map<String, Object> initialState = StateSet.createState( StateSet.STATE_PARAMETER_PRI, oldPartitionPri );
                        Map<String, Object> finalState = StateSet.createState( StateSet.STATE_PARAMETER_PRI, newPartitionPri );
                        elementsRepartitionedMri.add( elementToRepartition.get___Mri( ) );
                        affectedElementStates.put( elementToRepartition.get___Mri( ), new StateSet( initialState, finalState ) );
                        affectedPartitionsPri.add( oldPartitionPri );
                        affectedPartitionsPri.add( newPartitionPri );
                    }
                    indexToAdd = indexToAdd != -1 ? indexToAdd + 1 : -1;
                }
                PRI[] affectedPartitionPris = affectedPartitionsPri.toArray( new PRI[affectedPartitionsPri.size( )] );
                computePartitionsToLock( affectedPartitionPris );
                computePartitionsToEnsureEditing( affectedPartitionPris );
                computePartitionsToMarkDirty( affectedPartitionPris );
            }
        }
        // actions and events
        if ( linksAdded != null ) {
            // aquire lock actions
            addEditLockActionsToDoActions( );
            // ensure editing allowed actions
            addEnsureEditingActionsToDoActions( );
            // link add actions and events
            boolean eventCreationNeeded = eventCreationNeeded( );
            for ( int i = 0; i < linksAdded.size( ); i++ ) {
                EndStorageLink linkAdded = linksAdded.get( i );
                int position = indices[i];
                getOrCreateDoActions( ).add( ActionFactory.createEndStorageLinkAddAction( connection, featuredMri, attribute.refMofId( ), linkAdded, position ) );
                CorePartitionable elementToAdd = linkAdded.getEnd( linkAdded.getComponentEnd( ) ).get( connection.getSession( ) );
                if ( eventCreationNeeded ) {
                    getOrCreateDoEvents( ).add( getEventFactory( ).createAttributeValueAddEvent( connection, featured, attribute, elementToAdd, position ) );
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
            resolve( );
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
}