package com.sap.tc.moin.repository.test.transactions.microtransactionables;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.LockManager;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.events.ElementCreateEventImpl;
import com.sap.tc.moin.repository.core.events.ElementDeleteEventImpl;
import com.sap.tc.moin.repository.core.events.LinkAddEventImpl;
import com.sap.tc.moin.repository.core.events.LinkRemoveEventImpl;
import com.sap.tc.moin.repository.core.events.PartitionCreateEventImpl;
import com.sap.tc.moin.repository.core.events.PartitionDeleteEventImpl;
import com.sap.tc.moin.repository.core.transactions.microtransactionables.EventComparator;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.PartitionChangeEvent;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.repository.transactions.TransactionRecord;
import com.sap.tc.moin.repository.transactions.Transactionable;

public abstract class BaseMicroTransactionablesPartitionTest extends BaseMicroTransactionablesTest {

    protected void partitionCreate( PRI pri ) {

        partitionCreateDoUndoRedoTransaction( new PartitionCreateTransaction( pri ), pri );
    }

    protected void partitionDelete( ModelPartition partition ) {

        CoreModelPartition partitionUnwrapped = (CoreModelPartition) ( (Wrapper) partition ).unwrap( );
        // for each deleted element, an element delete event is fired
        Set<ChangeEvent> doEventSet = new LinkedHashSet<ChangeEvent>( 0 );
        Set<ChangeEvent> undoEventSet = new LinkedHashSet<ChangeEvent>( 0 );
        undoEventSet.add( new PartitionCreateEventImpl( coreConnection, partition.getPri( ) ) );
        if ( partitionUnwrapped.getWorkspace( ) != coreSession.getWorkspaceSet( ).getMoin( ).getMetamodelWorkspace( ) ) {
            // ok, we have a model partition and not a metamodel partition
            for ( Partitionable partitionable : partition.getElements( ) ) {
                RefObject instance = (RefObject) partitionable;
                // for each composite child an element delete event is fired
                Collection<RefObject> children = coreConnection.getCoreJmiHelper( ).getCompositeChildren( coreConnection.getSession( ), (RefObject) ( (Wrapper) partitionable ).unwrap( ), true /* recursively */);
                for ( RefObject child : children ) {
                    RefObject childMetaObject = child.refMetaObject( );
                    RefPackage childImmediatePackage = child.refImmediatePackage( );
                    doEventSet.add( new ElementDeleteEventImpl( coreConnection, child ) );
                    undoEventSet.add( new ElementCreateEventImpl( coreConnection, ( (Partitionable) child ).get___Mri( ), ( (Partitionable) childMetaObject ).get___Mri( ), ( (Partitionable) childImmediatePackage ).get___Mri( ) ) );
                }
                RefObject instanceMetaObject = instance.refMetaObject( );
                RefPackage instanceImmediatePackage = instance.refImmediatePackage( );
                doEventSet.add( new ElementDeleteEventImpl( coreConnection, instance ) );
                undoEventSet.add( new ElementCreateEventImpl( coreConnection, ( (Partitionable) instance ).get___Mri( ), ( (Partitionable) instanceMetaObject ).get___Mri( ), ( (Partitionable) instanceImmediatePackage ).get___Mri( ) ) );
                // for each deleted association link, a link remove event is fired (not for attribute links!)
                Collection<EndStorageLink> associationLinksToDelete = new ArrayList<EndStorageLink>( getAssociationLinksForElement( (CorePartitionable) ( (Wrapper) instance ).unwrap( ) ) );
                for ( EndStorageLink link : associationLinksToDelete ) {
                    int position = -1;
                    doEventSet.add( new LinkRemoveEventImpl( coreConnection, link, position ) );
                    undoEventSet.add( new LinkAddEventImpl( coreConnection, link, position ) );
                }
            }
        }
        // for the deleted partition, a partition delete event is fired
        doEventSet.add( new PartitionDeleteEventImpl( coreConnection, partition.getPri( ) ) );
        List doEvents = new ArrayList( doEventSet );
        List undoEvents = new ArrayList( undoEventSet );
        Collections.sort( doEvents, EventComparator.instance );
        Collections.sort( undoEvents, EventComparator.instance );
        partitionDeleteDoUndoRedoTransaction( new PartitionDeleteTransaction( partition ), partition, doEvents, undoEvents );
    }

    protected void partitionDeleteElements( ModelPartition partition ) {

        // for each deleted element, an element delete event is fired
        Set<ChangeEvent> doEventSet = new LinkedHashSet<ChangeEvent>( 0 );
        Set<ChangeEvent> undoEventSet = new LinkedHashSet<ChangeEvent>( 0 );
        for ( Partitionable partitionable : partition.getElements( ) ) {
            RefObject instance = (RefObject) partitionable;
            // for each composite child an element delete event is fired
            Collection<RefObject> children = coreConnection.getCoreJmiHelper( ).getCompositeChildren( coreConnection.getSession( ), (RefObject) ( (Wrapper) partitionable ).unwrap( ), true /* recursively */);
            for ( RefObject child : children ) {
                RefObject childMetaObject = child.refMetaObject( );
                RefPackage childImmediatePackage = child.refImmediatePackage( );
                doEventSet.add( new ElementDeleteEventImpl( coreConnection, child ) );
                undoEventSet.add( new ElementCreateEventImpl( coreConnection, ( (Partitionable) child ).get___Mri( ), ( (Partitionable) childMetaObject ).get___Mri( ), ( (Partitionable) childImmediatePackage ).get___Mri( ) ) );
            }
            RefObject instanceMetaObject = instance.refMetaObject( );
            RefPackage instanceImmediatePackage = instance.refImmediatePackage( );
            doEventSet.add( new ElementDeleteEventImpl( coreConnection, instance ) );
            undoEventSet.add( new ElementCreateEventImpl( coreConnection, ( (Partitionable) instance ).get___Mri( ), ( (Partitionable) instanceMetaObject ).get___Mri( ), ( (Partitionable) instanceImmediatePackage ).get___Mri( ) ) );
            // for each deleted association link, a link remove event is fired (not for attribute links!)
            Collection<EndStorageLink> associationLinksToDelete = new ArrayList<EndStorageLink>( getAssociationLinksForElement( (CorePartitionable) ( (Wrapper) instance ).unwrap( ) ) );
            for ( EndStorageLink link : associationLinksToDelete ) {
                int position = -1;
                doEventSet.add( new LinkRemoveEventImpl( coreConnection, link, position ) );
                undoEventSet.add( new LinkAddEventImpl( coreConnection, link, position ) );
            }
        }
        List doEvents = new ArrayList( doEventSet );
        List undoEvents = new ArrayList( undoEventSet );
        Collections.sort( doEvents, EventComparator.instance );
        Collections.sort( undoEvents, EventComparator.instance );
        partitionDeleteElementsDoUndoRedoTransaction( new PartitionDeleteElementsTransaction( partition ), partition, doEvents, undoEvents );
    }

    private void partitionCreateDoUndoRedoTransaction( Transactionable transactionable, PRI pri ) {

        TransactionRecord executeTransactionRecord = null;
        // for the created partition, a partition create event is fired
        initEventsCheck( );
        synchronized ( coreSession.getWorkspaceSet( ).getSynchronizationManager( ).getProhibitWriteSyncObject( ) ) {
            // do
            executeTransactionRecord = transactionManager.runInTransaction( transactionable );
            ModelPartition partition = getMOINConnection( ).getPartition( pri );
            assertEquals( pri, partition.getPri( ) );
            assertEquals( true, partition.isAlive( ) );
            assertEquals( true, partition.isDirty( ) );
            List<ChangeEvent> expectedDoEvents = new ArrayList<ChangeEvent>( 1 );
            List<ChangeEvent> expectedUndoEvents = new ArrayList<ChangeEvent>( 1 );
            PartitionChangeEvent expectedDoEvent = new PartitionCreateEventImpl( coreConnection, pri );
            PartitionChangeEvent expectedUndoEvent = new PartitionDeleteEventImpl( coreConnection, pri );
            expectedDoEvents.add( expectedDoEvent );
            expectedUndoEvents.add( expectedUndoEvent );
            testEventsCheck( expectedDoEvents );
            // undo
            if ( executeTransactionRecord != null ) {
                initEventsCheck( );
                transactionManager.undo( executeTransactionRecord );
                assertEquals( false, partition.isAlive( ) );
                testEventsCheck( expectedUndoEvents );
            }
            // redo
            if ( executeTransactionRecord != null ) {
                initEventsCheck( );
                transactionManager.redo( executeTransactionRecord );
                assertEquals( pri, partition.getPri( ) );
                assertEquals( true, partition.isAlive( ) );
                assertEquals( true, partition.isDirty( ) );
                testEventsCheck( expectedDoEvents );
            }
        }
    }

    private void partitionDeleteDoUndoRedoTransaction( Transactionable transactionable, ModelPartition partition, List<ChangeEvent> expectedDoEvents, List<ChangeEvent> expectedUndoEvents ) {

        TransactionRecord executeTransactionRecord = null;
        PRI partitionPri = partition.getPri( );
        CoreModelPartition partitionUnwrapped = (CoreModelPartition) ( (Wrapper) partition ).unwrap( );
        boolean partitionIsDirty = partition.isDirty( );
        Map<RefObject, Map<Attribute, Object>> instancesToDelete2AttributeMap = new HashMap<RefObject, Map<Attribute, Object>>( );
        Map<RefObject, PRI> instancesToDelete2PartitionMap = new HashMap<RefObject, PRI>( );
        if ( partitionUnwrapped.getWorkspace( ) != coreSession.getWorkspaceSet( ).getMoin( ).getMetamodelWorkspace( ) ) {
            // ok, we have a model partition and not a metamodel partition
            for ( Partitionable partitionable : partition.getElements( ) ) {
                RefObject instance = (RefObject) partitionable;
                List<Attribute> attributes = getNonDerivedAttributes( (MofClass) instance.refClass( ).refMetaObject( ) );
                Map<Attribute, Object> parameters = new HashMap<Attribute, Object>( );
                for ( Attribute attribute : attributes ) {
                    parameters.put( attribute, instance.refGetValue( attribute.getName( ) ) );
                }
                instancesToDelete2AttributeMap.put( instance, parameters );
                instancesToDelete2PartitionMap.put( instance, ( (Partitionable) instance ).get___Partition( ).getPri( ) );
            }
        }
        initEventsCheck( );
        synchronized ( coreSession.getWorkspaceSet( ).getSynchronizationManager( ).getProhibitWriteSyncObject( ) ) {
            // do
            Collection elementsBeforeDo = partition.getElements( );
            executeTransactionRecord = transactionManager.runInTransaction( transactionable );
            assertEquals( false, partition.isAlive( ) );
            for ( RefObject instance : instancesToDelete2AttributeMap.keySet( ) ) {
                assertEquals( false, ( (Partitionable) instance ).is___Alive( ) );
            }
            testEventsCheck( expectedDoEvents );
            // undo
            if ( executeTransactionRecord != null ) {
                initEventsCheck( );
                transactionManager.undo( executeTransactionRecord );
                assertEquals( true, partition.isAlive( ) );
                assertEquals( partitionPri, partition.getPri( ) );
                assertEquals( partitionIsDirty, partition.isDirty( ) );
                Collection<Partitionable> elementsAfterUndo = partition.getElements( );
                assertEquals( elementsAfterUndo, elementsBeforeDo );
                for ( RefObject instance : instancesToDelete2AttributeMap.keySet( ) ) {
                    assertEquals( true, ( (Partitionable) instance ).is___Alive( ) );
                    // check whether the parameters of the deleted instances are
                    // the same as before the deletion
                    assertInstanceParameters( instance, instancesToDelete2AttributeMap.get( instance ) );
                    assertEquals( ( (Partitionable) instance ).get___Partition( ).getPri( ), instancesToDelete2PartitionMap.get( instance ) );
                }
                testEventsCheck( expectedUndoEvents );
            }
            // redo
            if ( executeTransactionRecord != null ) {
                initEventsCheck( );
                transactionManager.redo( executeTransactionRecord );
                assertEquals( false, partition.isAlive( ) );
                for ( RefObject instance : instancesToDelete2AttributeMap.keySet( ) ) {
                    assertEquals( false, ( (Partitionable) instance ).is___Alive( ) );
                }
                testEventsCheck( expectedDoEvents );
            }
        }
    }

    private void partitionDeleteElementsDoUndoRedoTransaction( Transactionable transactionable, ModelPartition partition, List<ChangeEvent> expectedDoEvents, List<ChangeEvent> expectedUndoEvents ) {

        TransactionRecord executeTransactionRecord = null;
        Map<RefObject, Map<Attribute, Object>> instancesToDelete2AttributeMap = new HashMap<RefObject, Map<Attribute, Object>>( );
        Map<RefObject, PRI> instancesToDelete2PartitionMap = new HashMap<RefObject, PRI>( );
        for ( Partitionable partitionable : partition.getElements( ) ) {
            RefObject instance = (RefObject) partitionable;
            List<Attribute> attributes = getNonDerivedAttributes( (MofClass) instance.refClass( ).refMetaObject( ) );
            Map<Attribute, Object> parameters = new HashMap<Attribute, Object>( );
            for ( Attribute attribute : attributes ) {
                parameters.put( attribute, instance.refGetValue( attribute.getName( ) ) );
            }
            instancesToDelete2AttributeMap.put( instance, parameters );
            instancesToDelete2PartitionMap.put( instance, ( (Partitionable) instance ).get___Partition( ).getPri( ) );
        }
        initEventsCheck( );
        synchronized ( coreSession.getWorkspaceSet( ).getSynchronizationManager( ).getProhibitWriteSyncObject( ) ) {
            // do
            Collection elementsBeforeDo = partition.getElements( );
            executeTransactionRecord = transactionManager.runInTransaction( transactionable );
            Collection<Partitionable> elementsAfterDo = partition.getElements( );
            assertEquals( true, elementsAfterDo.size( ) == 0 );
            for ( RefObject instance : instancesToDelete2AttributeMap.keySet( ) ) {
                assertEquals( false, ( (Partitionable) instance ).is___Alive( ) );
            }
            testEventsCheck( expectedDoEvents );
            // undo
            if ( executeTransactionRecord != null ) {
                initEventsCheck( );
                transactionManager.undo( executeTransactionRecord );
                Collection<Partitionable> elementsAfterUndo = partition.getElements( );
                assertEquals( elementsAfterUndo, elementsBeforeDo );
                for ( RefObject instance : instancesToDelete2AttributeMap.keySet( ) ) {
                    assertEquals( true, ( (Partitionable) instance ).is___Alive( ) );
                    // check whether the parameters of the deleted instances are
                    // the same as before the deletion
                    assertInstanceParameters( instance, instancesToDelete2AttributeMap.get( instance ) );
                    assertEquals( ( (Partitionable) instance ).get___Partition( ).getPri( ), instancesToDelete2PartitionMap.get( instance ) );
                }
                testEventsCheck( expectedUndoEvents );
            }
            // redo
            if ( executeTransactionRecord != null ) {
                initEventsCheck( );
                transactionManager.redo( executeTransactionRecord );
                Collection<Partitionable> elementsAfterRedo = partition.getElements( );
                assertEquals( 0, elementsAfterRedo.size( ) );
                for ( RefObject instance : instancesToDelete2AttributeMap.keySet( ) ) {
                    assertEquals( false, ( (Partitionable) instance ).is___Alive( ) );
                }
                testEventsCheck( expectedDoEvents );
            }
        }
    }

    private class PartitionCreateTransaction implements Transactionable {

        PRI pri = null;

        private PartitionCreateTransaction( PRI aPartitionPri ) {

            pri = aPartitionPri;
        }

        public void runInTransaction( ) {

            getMOINConnection( ).createPartition( pri );
        }

        public CoreConnection getConnection( ) {

            return coreConnection;
        }
    }

    private class PartitionDeleteTransaction implements Transactionable {

        ModelPartition partition = null;

        private PartitionDeleteTransaction( ModelPartition aPartition ) {

            partition = aPartition;
        }

        public void runInTransaction( ) {

            partition.delete( );
        }

        public CoreConnection getConnection( ) {

            return coreConnection;
        }
    }

    private class PartitionDeleteElementsTransaction implements Transactionable {

        ModelPartition partition = null;

        private PartitionDeleteElementsTransaction( ModelPartition aPartition ) {

            partition = aPartition;
        }

        public void runInTransaction( ) {

            partition.deleteElements( );
        }

        public CoreConnection getConnection( ) {

            return coreConnection;
        }
    }

    protected static class ObtainTransientLockTestTransaction implements Transactionable {

        LockManager manager = null;

        Connection owner = null;

        PRI pri = null;

        public ObtainTransientLockTestTransaction( LockManager aManager, Connection anOwner, PRI aPri ) {

            manager = aManager;
            owner = anOwner;
            pri = aPri;
        }

        public void runInTransaction( ) {

            manager.obtainTransientLock( pri, owner );
        }

        public CoreConnection getConnection( ) {

            return getTestHelper( ).getCoreConnection( owner );
        }
    }
}
