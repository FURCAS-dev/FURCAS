package com.sap.tc.moin.repository.test.transactions.microtransactionables;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.AggregationKindEnum;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.events.PartitionMembershipChangeEventImpl;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.transactions.TransactionRecord;
import com.sap.tc.moin.repository.transactions.Transactionable;

public abstract class BaseMicroTransactionablesAssociationTest extends BaseMicroTransactionablesTest {

    protected void associationAddLink( RefAssociation association, RefObject firstEnd, RefObject secondEnd ) {

        List[] objectsAtEnds = new List[] { new MyUniqueList<RefObject>( ), new MyUniqueList<RefObject>( ) };
        objectsAtEnds[0].add( firstEnd );
        objectsAtEnds[1].add( secondEnd );
        List<Collection>[] oldLinksAtEnds = queryLinksAtEnds( association, objectsAtEnds );
        List<Collection>[] newLinksAtEnds = queryLinksAtEnds( association, objectsAtEnds );
        newLinksAtEnds[0].get( 0 ).add( firstEnd );
        newLinksAtEnds[1].get( 0 ).add( secondEnd );
        List<ChangeEvent> doEvents = new ArrayList<ChangeEvent>( );
        List<ChangeEvent> undoEvents = new ArrayList<ChangeEvent>( );
        if ( newLinksAtEnds[0].get( 0 ).size( ) > oldLinksAtEnds[0].get( 0 ).size( ) || newLinksAtEnds[1].get( 0 ).size( ) > oldLinksAtEnds[1].get( 0 ).size( ) ) {
            doEvents.add( new TestLinkAddEvent( association, firstEnd, 0, secondEnd ) );
            undoEvents.add( new TestLinkRemoveEvent( association, firstEnd, 0, secondEnd ) );
        }
        associationDoUndoRedoTransaction( new AssociationAddLinkTransaction( association, firstEnd, secondEnd ), association, objectsAtEnds[0], objectsAtEnds[1], oldLinksAtEnds[0], newLinksAtEnds[0], oldLinksAtEnds[1], newLinksAtEnds[1], doEvents, undoEvents );
    }

    protected void associationRemoveLink( RefAssociation association, RefObject firstEnd, RefObject secondEnd ) {

        List[] objectsAtEnds = new List[] { new MyUniqueList<RefObject>( ), new MyUniqueList<RefObject>( ) };
        objectsAtEnds[0].add( firstEnd );
        objectsAtEnds[1].add( secondEnd );
        List<Collection>[] oldLinksAtEnds = queryLinksAtEnds( association, objectsAtEnds );
        List<Collection>[] newLinksAtEnds = queryLinksAtEnds( association, objectsAtEnds );
        newLinksAtEnds[0].get( 0 ).remove( firstEnd );
        newLinksAtEnds[1].get( 0 ).remove( secondEnd );
        List<ChangeEvent> doEvents = new ArrayList<ChangeEvent>( );
        List<ChangeEvent> undoEvents = new ArrayList<ChangeEvent>( );
        if ( newLinksAtEnds[0].get( 0 ).size( ) < oldLinksAtEnds[0].get( 0 ).size( ) || newLinksAtEnds[1].get( 0 ).size( ) < oldLinksAtEnds[1].get( 0 ).size( ) ) {
            doEvents.add( new TestLinkRemoveEvent( association, firstEnd, 0, secondEnd ) );
            undoEvents.add( new TestLinkAddEvent( association, firstEnd, 0, secondEnd ) );
        }
        associationDoUndoRedoTransaction( new AssociationRemoveLinkTransaction( association, firstEnd, secondEnd ), association, objectsAtEnds[0], objectsAtEnds[1], oldLinksAtEnds[0], newLinksAtEnds[0], oldLinksAtEnds[1], newLinksAtEnds[1], doEvents, undoEvents );
    }

    protected void associationAddAll( RefAssociation association, RefObject queryObject, int queryEndNumber, Collection elements ) {

        List<AssociationEnd> ends = getMOINConnection( ).getJmiHelper( ).getAssociationEnds( association.refMetaObject( ) );
        boolean isQueryEndComposed = ends.get( queryEndNumber ).getAggregation( ).equals( AggregationKindEnum.COMPOSITE );
        ModelPartition queryObjectPartition = ( (Partitionable) queryObject ).get___Partition( );
        List[] objectsAtEnds = new List[] { new MyUniqueList<RefObject>( ), new MyUniqueList<RefObject>( ) };
        objectsAtEnds[queryEndNumber].add( queryObject );
        objectsAtEnds[1 - queryEndNumber].addAll( elements );
        List<Collection>[] oldLinksAtEnds = queryLinksAtEnds( association, objectsAtEnds );
        List<Collection>[] newLinksAtEnds = queryLinksAtEnds( association, objectsAtEnds );
        for ( int i = 0; i < newLinksAtEnds[queryEndNumber].size( ); i++ ) {
            newLinksAtEnds[queryEndNumber].get( i ).add( objectsAtEnds[queryEndNumber].get( 0 ) );
        }
        newLinksAtEnds[1 - queryEndNumber].get( 0 ).addAll( elements );
        List<ChangeEvent> doEvents = new ArrayList<ChangeEvent>( );
        List<ChangeEvent> undoEvents = new ArrayList<ChangeEvent>( );
        Set<MRI> elementsToRepartitionMri = new LinkedHashSet<MRI>( );
        for ( Object element : newLinksAtEnds[1 - queryEndNumber].get( 0 ) ) {
            // To consider duplicated insertions, iterate over the result, a look for what was really added
            if ( !( oldLinksAtEnds[1 - queryEndNumber].get( 0 ).contains( element ) ) ) {
                doEvents.add( new TestLinkAddEvent( association, queryObject, queryEndNumber, (RefObject) element ) );
                MRI elementMri = ( (Partitionable) element ).get___Mri( );
                if ( isQueryEndComposed ) {
                    ModelPartition childPartition = ( (Partitionable) element ).get___Partition( );
                    if ( !queryObjectPartition.getPri( ).equals( childPartition.getPri( ) ) ) {
                        elementsToRepartitionMri.add( ( (Partitionable) element ).get___Mri( ) );
                        // we have a repartition here, the undo event is sent with the new MRI
                        elementMri = queryObjectPartition.getPri( ).createMri( ( (Partitionable) element ).get___Mri( ).getMofId( ) );
                    }
                }
                undoEvents.add( new TestLinkRemoveEvent( association, queryObject, queryEndNumber, elementMri ) );
            }
        }
        for ( MRI elementToRepartitionMri : elementsToRepartitionMri ) {
            RefObject elementToRepartition = (RefObject) getMOINConnection( ).getElement( elementToRepartitionMri );
            ModelPartition childPartition = ( (Partitionable) elementToRepartition ).get___Partition( );
            doEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, elementToRepartition, childPartition, queryObjectPartition ) );
            undoEvents.add( new TestPartitionMembershipChangeEvent( elementToRepartition.refMofId( ), queryObjectPartition.getPri( ), childPartition.getPri( ) ) );
        }
        associationDoUndoRedoTransaction( new AssociationAddAllTransaction( association, queryObject, queryEndNumber, elements ), association, objectsAtEnds[0], objectsAtEnds[1], oldLinksAtEnds[0], newLinksAtEnds[0], oldLinksAtEnds[1], newLinksAtEnds[1], doEvents, undoEvents );
    }

    protected void associationAddAll( RefAssociation association, RefObject queryObject, int queryEndNumber, int index, Collection elements ) {

        List[] objectsAtEnds = new List[] { new MyUniqueList<RefObject>( ), new MyUniqueList<RefObject>( ) };
        objectsAtEnds[queryEndNumber].add( queryObject );
        objectsAtEnds[1 - queryEndNumber].addAll( elements );
        List<Collection>[] oldLinksAtEnds = queryLinksAtEnds( association, objectsAtEnds );
        List<Collection>[] newLinksAtEnds = queryLinksAtEnds( association, objectsAtEnds );
        for ( int i = 0; i < newLinksAtEnds[queryEndNumber].size( ); i++ ) {
            newLinksAtEnds[queryEndNumber].get( i ).add( objectsAtEnds[queryEndNumber].get( 0 ) );
        }
        ( (List) newLinksAtEnds[1 - queryEndNumber].get( 0 ) ).addAll( index, elements );
        List<ChangeEvent> doEvents = new ArrayList<ChangeEvent>( );
        List<ChangeEvent> undoEvents = new ArrayList<ChangeEvent>( );
        for ( Object element : newLinksAtEnds[1 - queryEndNumber].get( 0 ) ) {
            // To consider duplicated insertions, iterate over the result, a look for what was really added
            if ( !( oldLinksAtEnds[1 - queryEndNumber].get( 0 ).contains( element ) ) ) {
                doEvents.add( new TestLinkAddEvent( association, queryObject, queryEndNumber, (RefObject) element ) );
                undoEvents.add( new TestLinkRemoveEvent( association, queryObject, queryEndNumber, (RefObject) element ) );
            }
        }
        associationDoUndoRedoTransaction( new AssociationAddAllTransaction( association, queryObject, queryEndNumber, index, elements ), association, objectsAtEnds[0], objectsAtEnds[1], oldLinksAtEnds[0], newLinksAtEnds[0], oldLinksAtEnds[1], newLinksAtEnds[1], doEvents, undoEvents );
    }

    protected void associationAdd( RefAssociation association, RefObject queryObject, int queryEndNumber, Object element ) {

        List[] objectsAtEnds = new List[] { new MyUniqueList<RefObject>( ), new MyUniqueList<RefObject>( ) };
        objectsAtEnds[queryEndNumber].add( queryObject );
        objectsAtEnds[1 - queryEndNumber].add( element );
        List<Collection>[] oldLinksAtEnds = queryLinksAtEnds( association, objectsAtEnds );
        List<Collection>[] newLinksAtEnds = queryLinksAtEnds( association, objectsAtEnds );
        for ( int i = 0; i < newLinksAtEnds[queryEndNumber].size( ); i++ ) {
            newLinksAtEnds[queryEndNumber].get( i ).add( objectsAtEnds[queryEndNumber].get( 0 ) );
        }
        newLinksAtEnds[1 - queryEndNumber].get( 0 ).add( element );
        List<ChangeEvent> doEvents = new ArrayList<ChangeEvent>( );
        List<ChangeEvent> undoEvents = new ArrayList<ChangeEvent>( );
        if ( !( oldLinksAtEnds[1 - queryEndNumber].get( 0 ).contains( element ) ) ) {
            try {
                doEvents.add( new TestLinkAddEvent( association, queryObject, queryEndNumber, (RefObject) element ) );
                undoEvents.add( new TestLinkRemoveEvent( association, queryObject, queryEndNumber, (RefObject) element ) );
            } catch ( ClassCastException e ) {
                // do nothing... it will fail
            }
        }
        associationDoUndoRedoTransaction( new AssociationAddTransaction( association, queryObject, queryEndNumber, element ), association, objectsAtEnds[0], objectsAtEnds[1], oldLinksAtEnds[0], newLinksAtEnds[0], oldLinksAtEnds[1], newLinksAtEnds[1], doEvents, undoEvents );
    }

    protected void associationAdd( RefAssociation association, RefObject queryObject, int queryEndNumber, int index, Object element ) {

        List[] objectsAtEnds = new List[] { new MyUniqueList<RefObject>( ), new MyUniqueList<RefObject>( ) };
        objectsAtEnds[queryEndNumber].add( queryObject );
        objectsAtEnds[1 - queryEndNumber].add( element );
        List<Collection>[] oldLinksAtEnds = queryLinksAtEnds( association, objectsAtEnds );
        List<Collection>[] newLinksAtEnds = queryLinksAtEnds( association, objectsAtEnds );
        for ( int i = 0; i < newLinksAtEnds[queryEndNumber].size( ); i++ ) {
            newLinksAtEnds[queryEndNumber].get( i ).add( objectsAtEnds[queryEndNumber].get( 0 ) );
        }
        ( (List) newLinksAtEnds[1 - queryEndNumber].get( 0 ) ).add( index, element );
        List<ChangeEvent> doEvents = new ArrayList<ChangeEvent>( );
        List<ChangeEvent> undoEvents = new ArrayList<ChangeEvent>( );
        doEvents.add( new TestLinkAddEvent( association, queryObject, queryEndNumber, (RefObject) element ) );
        undoEvents.add( new TestLinkRemoveEvent( association, queryObject, queryEndNumber, (RefObject) element ) );
        associationDoUndoRedoTransaction( new AssociationAddTransaction( association, queryObject, queryEndNumber, index, element ), association, objectsAtEnds[0], objectsAtEnds[1], oldLinksAtEnds[0], newLinksAtEnds[0], oldLinksAtEnds[1], newLinksAtEnds[1], doEvents, undoEvents );
    }

    protected void associationClear( RefAssociation association, RefObject queryObject, int queryEndNumber ) {

        List<AssociationEnd> ends = getMOINConnection( ).getJmiHelper( ).getAssociationEnds( association.refMetaObject( ) );
        boolean isQueryEndComposed = ends.get( queryEndNumber ).getAggregation( ).equals( AggregationKindEnum.COMPOSITE );
        Collection<RefObject> elements = association.refQuery( ends.get( queryEndNumber ), queryObject );
        List<RefObject>[] objectsAtEnds = new List[] { new MyUniqueList<RefObject>( ), new MyUniqueList<RefObject>( ) };
        objectsAtEnds[queryEndNumber].add( queryObject );
        objectsAtEnds[1 - queryEndNumber].addAll( elements );
        List<Collection>[] oldLinksAtEnds = queryLinksAtEnds( association, objectsAtEnds );
        List<Collection>[] newLinksAtEnds = queryLinksAtEnds( association, objectsAtEnds );
        for ( int i = 0; i < newLinksAtEnds[queryEndNumber].size( ); i++ ) {
            newLinksAtEnds[queryEndNumber].get( i ).remove( objectsAtEnds[queryEndNumber].get( 0 ) );
        }
        newLinksAtEnds[1 - queryEndNumber].get( 0 ).clear( );
        List<ChangeEvent> doEvents = new ArrayList<ChangeEvent>( );
        List<ChangeEvent> undoEvents = new ArrayList<ChangeEvent>( );
        Set<MRI> elementsToRepartitionMri = new LinkedHashSet<MRI>( );
        for ( Object element : oldLinksAtEnds[1 - queryEndNumber].get( 0 ) ) {
            doEvents.add( new TestLinkRemoveEvent( association, queryObject, queryEndNumber, (RefObject) element ) );
            MRI elementMri = ( (Partitionable) element ).get___Mri( );
            if ( isQueryEndComposed ) {
                ModelPartition childPartition = ( (Partitionable) element ).get___Partition( );
                if ( !nullPartition.getPri( ).equals( childPartition.getPri( ) ) ) {
                    elementsToRepartitionMri.add( ( (Partitionable) element ).get___Mri( ) );
                    // we have a repartition here, the undo event is sent with the new MRI
                    elementMri = nullPartition.getPri( ).createMri( ( (Partitionable) element ).get___Mri( ).getMofId( ) );
                }
            }
            undoEvents.add( new TestLinkAddEvent( association, queryObject, queryEndNumber, elementMri ) );
        }
        for ( MRI elementToRepartitionMri : elementsToRepartitionMri ) {
            RefObject elementToRepartition = (RefObject) getMOINConnection( ).getElement( elementToRepartitionMri );
            ModelPartition childPartition = ( (Partitionable) elementToRepartition ).get___Partition( );
            doEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, elementToRepartition, childPartition, nullPartition ) );
            undoEvents.add( new TestPartitionMembershipChangeEvent( elementToRepartition.refMofId( ), nullPartition.getPri( ), childPartition.getPri( ) ) );
        }
        associationDoUndoRedoTransaction( new AssociationClearTransaction( association, queryObject, queryEndNumber ), association, objectsAtEnds[0], objectsAtEnds[1], oldLinksAtEnds[0], newLinksAtEnds[0], oldLinksAtEnds[1], newLinksAtEnds[1], doEvents, undoEvents );
    }

    protected void associationRemoveAll( RefAssociation association, RefObject queryObject, int queryEndNumber, Collection elements ) {

        List[] objectsAtEnds = new List[] { new MyUniqueList<RefObject>( ), new MyUniqueList<RefObject>( ) };
        objectsAtEnds[queryEndNumber].add( queryObject );
        objectsAtEnds[1 - queryEndNumber].addAll( elements );
        List<Collection>[] oldLinksAtEnds = queryLinksAtEnds( association, objectsAtEnds );
        List<Collection>[] newLinksAtEnds = queryLinksAtEnds( association, objectsAtEnds );
        for ( int i = 0; i < newLinksAtEnds[queryEndNumber].size( ); i++ ) {
            newLinksAtEnds[queryEndNumber].get( i ).remove( objectsAtEnds[queryEndNumber].get( 0 ) );
        }
        newLinksAtEnds[1 - queryEndNumber].get( 0 ).removeAll( elements );
        List<ChangeEvent> doEvents = new ArrayList<ChangeEvent>( );
        List<ChangeEvent> undoEvents = new ArrayList<ChangeEvent>( );
        for ( Object element : oldLinksAtEnds[1 - queryEndNumber].get( 0 ) ) {
            if ( elements.contains( element ) ) {
                doEvents.add( new TestLinkRemoveEvent( association, queryObject, queryEndNumber, (RefObject) element ) );
                undoEvents.add( new TestLinkAddEvent( association, queryObject, queryEndNumber, (RefObject) element ) );
            }
        }
        associationDoUndoRedoTransaction( new AssociationRemoveAllTransaction( association, queryObject, queryEndNumber, elements ), association, objectsAtEnds[0], objectsAtEnds[1], oldLinksAtEnds[0], newLinksAtEnds[0], oldLinksAtEnds[1], newLinksAtEnds[1], doEvents, undoEvents );
    }

    protected void associationRetainAll( RefAssociation association, RefObject queryObject, int queryEndNumber, Collection elements ) {

        List<AssociationEnd> ends = getMOINConnection( ).getJmiHelper( ).getAssociationEnds( association.refMetaObject( ) );
        Collection oldElements = association.refQuery( ends.get( queryEndNumber ), queryObject );
        List[] objectsAtEnds = new List[] { new MyUniqueList<RefObject>( ), new MyUniqueList<RefObject>( ) };
        objectsAtEnds[queryEndNumber].add( queryObject );
        objectsAtEnds[1 - queryEndNumber].addAll( oldElements );
        List<Collection>[] oldLinksAtEnds = queryLinksAtEnds( association, objectsAtEnds );
        List<Collection>[] newLinksAtEnds = queryLinksAtEnds( association, objectsAtEnds );
        for ( int i = 0; i < newLinksAtEnds[queryEndNumber].size( ); i++ ) {
            if ( !elements.contains( objectsAtEnds[1 - queryEndNumber].get( i ) ) ) {
                newLinksAtEnds[queryEndNumber].get( i ).remove( objectsAtEnds[queryEndNumber].get( 0 ) );
            }
        }
        newLinksAtEnds[1 - queryEndNumber].get( 0 ).retainAll( elements );
        List<ChangeEvent> doEvents = new ArrayList<ChangeEvent>( );
        List<ChangeEvent> undoEvents = new ArrayList<ChangeEvent>( );
        for ( Object element : oldLinksAtEnds[1 - queryEndNumber].get( 0 ) ) {
            if ( !elements.contains( element ) ) {
                doEvents.add( new TestLinkRemoveEvent( association, queryObject, queryEndNumber, (RefObject) element ) );
                undoEvents.add( new TestLinkAddEvent( association, queryObject, queryEndNumber, (RefObject) element ) );
            }
        }
        associationDoUndoRedoTransaction( new AssociationRetainAllTransaction( association, queryObject, queryEndNumber, elements ), association, objectsAtEnds[0], objectsAtEnds[1], oldLinksAtEnds[0], newLinksAtEnds[0], oldLinksAtEnds[1], newLinksAtEnds[1], doEvents, undoEvents );
    }

    protected void associationRemove( RefAssociation association, RefObject queryObject, int queryEndNumber, Object element ) {

        List[] objectsAtEnds = new List[] { new ArrayList<RefObject>( ), new ArrayList<RefObject>( ) };
        objectsAtEnds[queryEndNumber].add( queryObject );
        objectsAtEnds[1 - queryEndNumber].add( element );
        List<Collection>[] oldLinksAtEnds = queryLinksAtEnds( association, objectsAtEnds );
        List<Collection>[] newLinksAtEnds = queryLinksAtEnds( association, objectsAtEnds );
        newLinksAtEnds[queryEndNumber].get( 0 ).remove( objectsAtEnds[queryEndNumber].get( 0 ) );
        newLinksAtEnds[1 - queryEndNumber].get( 0 ).remove( element );
        List<ChangeEvent> doEvents = new ArrayList<ChangeEvent>( );
        List<ChangeEvent> undoEvents = new ArrayList<ChangeEvent>( );
        if ( newLinksAtEnds[1 - queryEndNumber].get( 0 ).size( ) < oldLinksAtEnds[1 - queryEndNumber].get( 0 ).size( ) ) {
            doEvents.add( new TestLinkRemoveEvent( association, queryObject, queryEndNumber, (RefObject) element ) );
            undoEvents.add( new TestLinkAddEvent( association, queryObject, queryEndNumber, (RefObject) element ) );
        }
        associationDoUndoRedoTransaction( new AssociationRemoveTransaction( association, queryObject, queryEndNumber, element ), association, objectsAtEnds[0], objectsAtEnds[1], oldLinksAtEnds[0], newLinksAtEnds[0], oldLinksAtEnds[1], newLinksAtEnds[1], doEvents, undoEvents );
    }

    protected void associationRemove( RefAssociation association, RefObject queryObject, int queryEndNumber, int index ) {

        List<AssociationEnd> ends = getMOINConnection( ).getJmiHelper( ).getAssociationEnds( association.refMetaObject( ) );
        boolean isQueryEndComposed = ( getMOINConnection( ).getJmiHelper( ).getCompositeAssociationEnd( association.refMetaObject( ) ) != null );
        List elements = (List) association.refQuery( ends.get( queryEndNumber ), queryObject );
        RefObject elementToRemove = null;
        if ( ( index > 0 ) && ( index <= elements.size( ) ) ) {
            // needed for tests with invalid index values
            elementToRemove = (RefObject) elements.get( index );
        }
        List<RefObject>[] objectsAtEnds = new List[] { new ArrayList<RefObject>( ), new ArrayList<RefObject>( ) };
        objectsAtEnds[queryEndNumber].add( queryObject );
        objectsAtEnds[1 - queryEndNumber].add( elementToRemove );
        List<Collection>[] oldLinksAtEnds = queryLinksAtEnds( association, objectsAtEnds );
        List<Collection>[] newLinksAtEnds = queryLinksAtEnds( association, objectsAtEnds );
        newLinksAtEnds[queryEndNumber].get( 0 ).remove( objectsAtEnds[queryEndNumber].get( 0 ) );
        List<ChangeEvent> doEvents = new ArrayList<ChangeEvent>( );
        List<ChangeEvent> undoEvents = new ArrayList<ChangeEvent>( );
        if ( ( index > 0 ) && ( index <= newLinksAtEnds[1 - queryEndNumber].get( 0 ).size( ) ) ) {
            boolean elementToRepartition = false;
            ( (List) newLinksAtEnds[1 - queryEndNumber].get( 0 ) ).remove( index ); // cast
            // necessary because of autoboxing
            RefObject element = (RefObject) ( (List) oldLinksAtEnds[1 - queryEndNumber].get( 0 ) ).get( index );
            doEvents.add( new TestLinkRemoveEvent( association, queryObject, queryEndNumber, (RefObject) element ) );
            MRI elementMri = ( (Partitionable) element ).get___Mri( );
            if ( isQueryEndComposed ) {
                ModelPartition childPartition = ( (Partitionable) element ).get___Partition( );
                if ( !nullPartition.getPri( ).equals( childPartition.getPri( ) ) ) {
                    elementToRepartition = true;
                    // we have a repartition here, the undo event is sent with the new MRI
                    elementMri = nullPartition.getPri( ).createMri( ( (Partitionable) element ).get___Mri( ).getMofId( ) );
                }
            }
            undoEvents.add( new TestLinkAddEvent( association, queryObject, queryEndNumber, elementMri ) );
            if ( elementToRepartition ) {
                ModelPartition childPartition = ( (Partitionable) element ).get___Partition( );
                doEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, element, childPartition, nullPartition ) );
                undoEvents.add( new TestPartitionMembershipChangeEvent( element.refMofId( ), nullPartition.getPri( ), childPartition.getPri( ) ) );
            }
        }
        associationDoUndoRedoTransaction( new AssociationRemoveTransaction( association, queryObject, queryEndNumber, index ), association, objectsAtEnds[0], objectsAtEnds[1], oldLinksAtEnds[0], newLinksAtEnds[0], oldLinksAtEnds[1], newLinksAtEnds[1], doEvents, undoEvents );
    }

    protected void associationSet( RefAssociation association, RefObject queryObject, int queryEndNumber, int index, Object element ) {

        List<AssociationEnd> ends = getMOINConnection( ).getJmiHelper( ).getAssociationEnds( association.refMetaObject( ) );
        boolean isQueryEndComposed = ends.get( queryEndNumber ).getAggregation( ).equals( AggregationKindEnum.COMPOSITE );
        List[] objectsAtEnds = new List[] { new MyUniqueList<RefObject>( ), new MyUniqueList<RefObject>( ) };
        ModelPartition queryObjectPartition = ( (Partitionable) queryObject ).get___Partition( );
        objectsAtEnds[queryEndNumber].add( queryObject );
        objectsAtEnds[1 - queryEndNumber].add( element );
        List<Collection>[] oldLinksAtEnds = queryLinksAtEnds( association, objectsAtEnds );
        List<Collection>[] newLinksAtEnds = queryLinksAtEnds( association, objectsAtEnds );
        for ( int i = 0; i < newLinksAtEnds[queryEndNumber].size( ); i++ ) {
            newLinksAtEnds[queryEndNumber].get( i ).add( objectsAtEnds[queryEndNumber].get( 0 ) );
        }
        ( (List) newLinksAtEnds[1 - queryEndNumber].get( 0 ) ).set( index, element );
        List<ChangeEvent> doEvents = new ArrayList<ChangeEvent>( );
        List<ChangeEvent> undoEvents = new ArrayList<ChangeEvent>( );
        if ( element instanceof RefObject ) {
            RefObject oldElement = (RefObject) ( (List) oldLinksAtEnds[1 - queryEndNumber].get( 0 ) ).get( index );
            Set<MRI> elementsToRepartitionMri = new LinkedHashSet<MRI>( );
            MRI elementMri = ( (Partitionable) element ).get___Mri( );
            MRI oldElementMri = ( (Partitionable) element ).get___Mri( );
            if ( isQueryEndComposed ) {
                ModelPartition elementPartition = ( (Partitionable) element ).get___Partition( );
                if ( !queryObjectPartition.getPri( ).equals( elementPartition.getPri( ) ) && nullPartition.getPri( ).equals( elementPartition.getPri( ) ) ) {
                    elementsToRepartitionMri.add( ( (Partitionable) element ).get___Mri( ) );
                    // we have a repartition of the element here, the undo event is sent with the new MRI
                    elementMri = queryObjectPartition.getPri( ).createMri( ( (Partitionable) element ).get___Mri( ).getMofId( ) );
                }
            }
            // events, remove before add
            doEvents.add( new TestLinkRemoveEvent( association, queryObject, queryEndNumber, oldElement ) );
            doEvents.add( new TestLinkAddEvent( association, queryObject, queryEndNumber, (RefObject) element ) );
            undoEvents.add( new TestLinkRemoveEvent( association, queryObject, queryEndNumber, elementMri ) );
            undoEvents.add( new TestLinkAddEvent( association, queryObject, queryEndNumber, oldElement ) );
            for ( MRI elementToRepartitionMri : elementsToRepartitionMri ) {
                RefObject elementToRepartition = (RefObject) getMOINConnection( ).getElement( elementToRepartitionMri );
                ModelPartition childPartition = ( (Partitionable) elementToRepartition ).get___Partition( );
                doEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, elementToRepartition, childPartition, queryObjectPartition ) );
                undoEvents.add( new TestPartitionMembershipChangeEvent( elementToRepartition.refMofId( ), queryObjectPartition.getPri( ), childPartition.getPri( ) ) );
            }
        }
        associationDoUndoRedoTransaction( new AssociationSetTransaction( association, queryObject, queryEndNumber, index, element ), association, objectsAtEnds[0], objectsAtEnds[1], oldLinksAtEnds[0], newLinksAtEnds[0], oldLinksAtEnds[1], newLinksAtEnds[1], doEvents, undoEvents );
    }

    private void associationDoUndoRedoTransaction( Transactionable transactionable, RefAssociation association, List<RefObject> queryObjectListAtFirstEnd, List<RefObject> queryObjectListAtSecondEnd, List<Collection> initialLinkListsAtFirstEnd, List<Collection> finalLinkListsAtFirstEnd,
        List<Collection> initialLinkListsAtSecondEnd, List<Collection> finalLinkListsAtSecondEnd, List<ChangeEvent> expectedDoEvents, List<ChangeEvent> expectedUndoEvents ) {

        TransactionRecord executeTransactionRecord = null;
        List<AssociationEnd> ends = getMOINConnection( ).getJmiHelper( ).getAssociationEnds( (Association) association.refMetaObject( ) );
        initEventsCheck( );
        synchronized ( coreSession.getWorkspaceSet( ).getSynchronizationManager( ).getProhibitWriteSyncObject( ) ) {
            // do
            executeTransactionRecord = transactionManager.runInTransaction( transactionable );
            for ( int i = 0; i < finalLinkListsAtFirstEnd.size( ); i++ ) {
                if ( !finalLinkListsAtFirstEnd.get( i ).equals( association.refQuery( ends.get( 1 ), queryObjectListAtSecondEnd.get( i ) ) ) ) {
                    System.out.println( );
                }
                assertEquals( finalLinkListsAtFirstEnd.get( i ), association.refQuery( ends.get( 1 ), queryObjectListAtSecondEnd.get( i ) ) );
            }
            for ( int i = 0; i < finalLinkListsAtSecondEnd.size( ); i++ ) {
                assertEquals( finalLinkListsAtSecondEnd.get( i ), association.refQuery( ends.get( 0 ), queryObjectListAtFirstEnd.get( i ) ) );
            }
            testEventsCheck( expectedDoEvents );
            // undo
            if ( executeTransactionRecord != null ) {
                initEventsCheck( );
                transactionManager.undo( executeTransactionRecord );
                for ( int i = 0; i < initialLinkListsAtFirstEnd.size( ); i++ ) {
                    assertEquals( initialLinkListsAtFirstEnd.get( i ), association.refQuery( ends.get( 1 ), queryObjectListAtSecondEnd.get( i ) ) );
                }
                for ( int i = 0; i < initialLinkListsAtSecondEnd.size( ); i++ ) {
                    assertEquals( initialLinkListsAtSecondEnd.get( i ), association.refQuery( ends.get( 0 ), queryObjectListAtFirstEnd.get( i ) ) );
                }
                testEventsCheck( expectedUndoEvents );
            }
            // redo
            if ( executeTransactionRecord != null ) {
                initEventsCheck( );
                transactionManager.redo( executeTransactionRecord );
                for ( int i = 0; i < finalLinkListsAtFirstEnd.size( ); i++ ) {
                    assertEquals( finalLinkListsAtFirstEnd.get( i ), association.refQuery( ends.get( 1 ), queryObjectListAtSecondEnd.get( i ) ) );
                }
                for ( int i = 0; i < finalLinkListsAtSecondEnd.size( ); i++ ) {
                    assertEquals( finalLinkListsAtSecondEnd.get( i ), association.refQuery( ends.get( 0 ), queryObjectListAtFirstEnd.get( i ) ) );
                }
                testEventsCheck( expectedDoEvents );
            }
        }
    }

    private class AssociationAddLinkTransaction implements Transactionable {

        private RefAssociation association = null;

        private RefObject firstEnd = null;

        private RefObject secondEnd = null;

        private AssociationAddLinkTransaction( RefAssociation anAssociation, RefObject aFirstEnd, RefObject aSecondEnd ) {

            association = anAssociation;
            firstEnd = aFirstEnd;
            secondEnd = aSecondEnd;
        }

        public void runInTransaction( ) {

            association.refAddLink( firstEnd, secondEnd );
        }

        public CoreConnection getConnection( ) {

            return coreConnection;
        }
    }

    private class AssociationRemoveLinkTransaction implements Transactionable {

        private RefAssociation association = null;

        private RefObject firstEnd = null;

        private RefObject secondEnd = null;

        private AssociationRemoveLinkTransaction( RefAssociation anAssociation, RefObject aFirstEnd, RefObject aSecondEnd ) {

            association = anAssociation;
            firstEnd = aFirstEnd;
            secondEnd = aSecondEnd;
        }

        public void runInTransaction( ) {

            association.refRemoveLink( firstEnd, secondEnd );
        }

        public CoreConnection getConnection( ) {

            return coreConnection;
        }
    }

    private class AssociationAddAllTransaction implements Transactionable {

        private RefAssociation association = null;

        private AssociationEnd queryEnd = null;

        private RefObject queryObject = null;

        private int index = -1;

        private Collection elements = null;

        private AssociationAddAllTransaction( RefAssociation anAssociation, RefObject aQueryObject, int aQueryEndNumber, Collection theElementsToAdd ) {

            association = anAssociation;
            List<AssociationEnd> ends = getMOINConnection( ).getJmiHelper( ).getAssociationEnds( (Association) anAssociation.refMetaObject( ) );
            queryEnd = ends.get( aQueryEndNumber );
            queryObject = aQueryObject;
            elements = theElementsToAdd;
        }

        private AssociationAddAllTransaction( RefAssociation anAssociation, RefObject aQueryObject, int aQueryEndNumber, int anIndex, Collection theElementsToAdd ) {

            association = anAssociation;
            List<AssociationEnd> ends = getMOINConnection( ).getJmiHelper( ).getAssociationEnds( (Association) anAssociation.refMetaObject( ) );
            queryEnd = ends.get( aQueryEndNumber );
            queryObject = aQueryObject;
            index = anIndex;
            elements = theElementsToAdd;
        }

        public void runInTransaction( ) {

            if ( index != -1 ) {
                ( (List) association.refQuery( queryEnd, queryObject ) ).addAll( index, elements );
            } else {
                association.refQuery( queryEnd, queryObject ).addAll( elements );
            }
        }

        public CoreConnection getConnection( ) {

            return coreConnection;
        }
    }

    private class AssociationAddTransaction implements Transactionable {

        private RefAssociation association = null;

        private AssociationEnd queryEnd = null;

        private RefObject queryObject = null;

        private int index = -1;

        private Object element = null;

        private AssociationAddTransaction( RefAssociation anAssociation, RefObject aQueryObject, int aQueryEndNumber, Object anElementToAdd ) {

            association = anAssociation;
            List<AssociationEnd> ends = getMOINConnection( ).getJmiHelper( ).getAssociationEnds( (Association) anAssociation.refMetaObject( ) );
            queryEnd = ends.get( aQueryEndNumber );
            queryObject = aQueryObject;
            element = anElementToAdd;
        }

        private AssociationAddTransaction( RefAssociation anAssociation, RefObject aQueryObject, int aQueryEndNumber, int anIndex, Object anElementToAdd ) {

            association = anAssociation;
            List<AssociationEnd> ends = getMOINConnection( ).getJmiHelper( ).getAssociationEnds( (Association) anAssociation.refMetaObject( ) );
            queryEnd = ends.get( aQueryEndNumber );
            queryObject = aQueryObject;
            index = anIndex;
            element = anElementToAdd;
        }

        public void runInTransaction( ) {

            if ( index != -1 ) {
                ( (List) association.refQuery( queryEnd, queryObject ) ).add( index, element );
            } else {
                ( (Collection) association.refQuery( queryEnd, queryObject ) ).add( element );
            }
        }

        public CoreConnection getConnection( ) {

            return coreConnection;
        }
    }

    private class AssociationClearTransaction implements Transactionable {

        private RefAssociation association = null;

        private AssociationEnd queryEnd = null;

        private RefObject queryObject = null;

        private AssociationClearTransaction( RefAssociation anAssociation, RefObject aQueryObject, int aQueryEndNumber ) {

            association = anAssociation;
            List<AssociationEnd> ends = getMOINConnection( ).getJmiHelper( ).getAssociationEnds( (Association) anAssociation.refMetaObject( ) );
            queryEnd = ends.get( aQueryEndNumber );
            queryObject = aQueryObject;
        }

        public void runInTransaction( ) {

            association.refQuery( queryEnd, queryObject ).clear( );
        }

        public CoreConnection getConnection( ) {

            return coreConnection;
        }
    }

    private class AssociationRemoveAllTransaction implements Transactionable {

        private RefAssociation association = null;

        private AssociationEnd queryEnd = null;

        private RefObject queryObject = null;

        private Collection elements = null;

        private AssociationRemoveAllTransaction( RefAssociation anAssociation, RefObject aQueryObject, int aQueryEndNumber, Collection theElementsToRemove ) {

            association = anAssociation;
            List<AssociationEnd> ends = getMOINConnection( ).getJmiHelper( ).getAssociationEnds( (Association) anAssociation.refMetaObject( ) );
            queryEnd = ends.get( aQueryEndNumber );
            queryObject = aQueryObject;
            elements = theElementsToRemove;
        }

        public void runInTransaction( ) {

            association.refQuery( queryEnd, queryObject ).removeAll( elements );
        }

        public CoreConnection getConnection( ) {

            return coreConnection;
        }
    }

    private class AssociationRemoveTransaction implements Transactionable {

        private RefAssociation association = null;

        private AssociationEnd queryEnd = null;

        private RefObject queryObject = null;

        private int index = -1;

        private Object element = null;

        private AssociationRemoveTransaction( RefAssociation anAssociation, RefObject aQueryObject, int aQueryEndNumber, Object anElementToRemove ) {

            this( anAssociation, aQueryObject, aQueryEndNumber );
            element = anElementToRemove;
        }

        private AssociationRemoveTransaction( RefAssociation anAssociation, RefObject aQueryObject, int aQueryEndNumber ) {

            association = anAssociation;
            List<AssociationEnd> ends = getMOINConnection( ).getJmiHelper( ).getAssociationEnds( (Association) anAssociation.refMetaObject( ) );
            queryEnd = ends.get( aQueryEndNumber );
            queryObject = aQueryObject;
        }

        private AssociationRemoveTransaction( RefAssociation anAssociation, RefObject aQueryObject, int aQueryEndNumber, int anIndex ) {

            this( anAssociation, aQueryObject, aQueryEndNumber );
            index = anIndex;
        }

        public void runInTransaction( ) {

            if ( index != -1 ) {
                ( (List) association.refQuery( queryEnd, queryObject ) ).remove( index );
            } else {
                association.refQuery( queryEnd, queryObject ).remove( element );
            }
        }

        public CoreConnection getConnection( ) {

            return coreConnection;
        }
    }

    private class AssociationRetainAllTransaction implements Transactionable {

        private RefAssociation association = null;

        private AssociationEnd queryEnd = null;

        private RefObject queryObject = null;

        private Collection elements = null;

        private AssociationRetainAllTransaction( RefAssociation anAssociation, RefObject aQueryObject, int aQueryEndNumber, Collection theElementsToRemove ) {

            association = anAssociation;
            List<AssociationEnd> ends = getMOINConnection( ).getJmiHelper( ).getAssociationEnds( (Association) anAssociation.refMetaObject( ) );
            queryEnd = ends.get( aQueryEndNumber );
            queryObject = aQueryObject;
            elements = theElementsToRemove;
        }

        public void runInTransaction( ) {

            association.refQuery( queryEnd, queryObject ).retainAll( elements );
        }

        public CoreConnection getConnection( ) {

            return coreConnection;
        }
    }

    private class AssociationSetTransaction implements Transactionable {

        private RefAssociation association = null;

        private AssociationEnd queryEnd = null;

        private RefObject queryObject = null;

        private int index = -1;

        private Object newValue = null;

        private AssociationSetTransaction( RefAssociation anAssociation, RefObject aQueryObject, int aQueryEndNumber, int anIndex, Object aNewValue ) {

            association = anAssociation;
            List<AssociationEnd> ends = getMOINConnection( ).getJmiHelper( ).getAssociationEnds( (Association) anAssociation.refMetaObject( ) );
            queryEnd = ends.get( aQueryEndNumber );
            queryObject = aQueryObject;
            index = anIndex;
            newValue = aNewValue;
        }

        public void runInTransaction( ) {

            ( (List) association.refQuery( queryEnd, queryObject ) ).set( index, newValue );
        }

        public CoreConnection getConnection( ) {

            return coreConnection;
        }
    }
}
