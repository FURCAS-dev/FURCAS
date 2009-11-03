package com.sap.tc.moin.repository.test.transactions.microtransactionables;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.ConnectionWrapper;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.MultiValuedAttributesList;
import com.sap.tc.moin.repository.core.events.AttributeValueAddEventImpl;
import com.sap.tc.moin.repository.core.events.AttributeValueChangeEventImpl;
import com.sap.tc.moin.repository.core.events.AttributeValueRemoveEventImpl;
import com.sap.tc.moin.repository.core.events.ElementCreateEventImpl;
import com.sap.tc.moin.repository.core.events.ElementDeleteEventImpl;
import com.sap.tc.moin.repository.core.events.LinkAddEventImpl;
import com.sap.tc.moin.repository.core.events.LinkRemoveEventImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefFeaturedImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.exception.UnrecoverableExecutionException;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.repository.transactions.TransactionRecord;
import com.sap.tc.moin.repository.transactions.Transactionable;
import com.sap.tc.moin.testcases.case004.C4;
import com.sap.tc.moin.testcases.case004.ComposesCsOrdered;
import com.sap.tc.moin.testcases.case004.F4;
import com.sap.tc.moin.testcases.case010.A10;
import com.sap.tc.moin.testcases.case010.OneToManyChangeable;
import com.sap.tc.moin.testcases.case010.OneToManyOrdered;

@SuppressWarnings( "nls" )
public abstract class BaseMicroTransactionablesInstanceTest extends BaseMicroTransactionablesTest {

    protected void instanceDelete( RefObject refObject ) {

        List<CorePartitionable> children = getAllComponentChildrenRecursive( ( (Wrapper<CorePartitionable>) refObject ).unwrap( ) );
        RefObject refMetaObject = refObject.refMetaObject( );
        RefPackage refImmediatePackage = refObject.refImmediatePackage( );
        Collection<EndStorageLink> associationLinks = new ArrayList<EndStorageLink>( );
        EndStorageLink linkToParent = getCompositeParentLink( ( (Wrapper<CorePartitionable>) refObject ).unwrap( ) );
        RefFeatured parent = null;
        Attribute parentAttribute = null;
        if ( linkToParent != null && ( linkToParent.getMetaObject( ) instanceof Attribute ) ) {
            // the instance to delete is an attribute of another instance
            parent = (RefFeatured) linkToParent.getEnd( linkToParent.getCompositeEnd( ) ).get( coreConnection.getSession( ) );
            parentAttribute = (Attribute) linkToParent.getMetaObject( );
        }
        associationLinks.addAll( getAssociationLinksForElement( (CorePartitionable) ( (Wrapper) refObject ).unwrap( ) ) );
        for ( CorePartitionable child : children ) {
            associationLinks.addAll( getAssociationLinksForElement( child ) );
        }
        // for each deleted element, an element delete event is fired, beginning
        // from the bottom of the composition tree
        List<ChangeEvent> doEvents = new ArrayList<ChangeEvent>( );
        List<ChangeEvent> undoEvents = new ArrayList<ChangeEvent>( );
        for ( int i = children.size( ) - 1; i >= 0; i-- ) {
            RefObject child = (RefObject) children.get( i );
            RefObject childMetaObject = child.refMetaObject( );
            RefPackage childImmediatePackage = child.refImmediatePackage( );
            doEvents.add( new ElementDeleteEventImpl( coreConnection, child ) );
            undoEvents.add( new ElementCreateEventImpl( coreConnection, ( (Partitionable) child ).get___Mri( ), ( (Partitionable) childMetaObject ).get___Mri( ), ( (Partitionable) childImmediatePackage ).get___Mri( ) ) );
        }
        doEvents.add( new ElementDeleteEventImpl( coreConnection, refObject ) );
        undoEvents.add( new ElementCreateEventImpl( coreConnection, ( (Partitionable) refObject ).get___Mri( ), ( (Partitionable) refMetaObject ).get___Mri( ), ( (Partitionable) refImmediatePackage ).get___Mri( ) ) );
        // for each deleted association link, a link remove event is fired (not
        // for attribute links!)
        for ( EndStorageLink link : associationLinks ) {
            int position = -1;
            doEvents.add( new LinkRemoveEventImpl( coreConnection, link, position ) );
            undoEvents.add( new LinkAddEventImpl( coreConnection, link, position ) );
        }
        // if the instance to delete has a parent from which it is an attribute,
        // an attribute change or remove event is fired
        if ( parent != null ) {
            int attributeUpperBound = parentAttribute.getMultiplicity( ).getUpper( );
            if ( attributeUpperBound == JmiHelper.MULTIPLICITY_BOUND_INFINITE || attributeUpperBound > 1 ) {
                int index = -1;
                boolean attributeIsOrdered = parentAttribute.getMultiplicity( ).isOrdered( );
                if ( attributeIsOrdered ) {
                    // get the right index for the event
                    index = ( (JmiList) ( (RefFeaturedImpl) parent ).refGetValue( coreConnection, parentAttribute.getName( ) ) ).indexOf( coreConnection, ( (Wrapper<CorePartitionable>) refObject ).unwrap( ) );
                }
                doEvents.add( new AttributeValueRemoveEventImpl( coreConnection, parent, parentAttribute, ( (Partitionable) refObject ).get___Mri( ).getLri( ), index ) );
                undoEvents.add( new AttributeValueAddEventImpl( coreConnection, parent, parentAttribute, ( (Partitionable) refObject ).get___Mri( ).getLri( ), index ) );
            } else {
                doEvents.add( new AttributeValueChangeEventImpl( coreConnection, parent, parentAttribute, ( (Partitionable) refObject ).get___Mri( ).getLri( ), null ) );
                undoEvents.add( new AttributeValueChangeEventImpl( coreConnection, parent, parentAttribute, null, ( (Partitionable) refObject ).get___Mri( ).getLri( ) ) );
            }
        }
        instanceDeleteDoUndoRedoTransaction( new InstanceDeleteTransaction( refObject ), refObject, doEvents, undoEvents );
    }

    protected void instanceCreate( RefClass refClass, List<? extends Object> parameters ) {
        instanceCreate( refClass, parameters, nullPartition );
    }

    protected void instanceCreate( RefClass refClass, List<? extends Object> parameters, ModelPartition partition ) {

        List<Attribute> nonDerivedAttributes = getNonDerivedAttributes( refClass.refMetaObject( ) );
        List<Object> newParameters = null;
        List<Object> expectedParametersForEvent = null;
        if ( ( parameters != null ) && ( parameters.size( ) == nonDerivedAttributes.size( ) ) ) {
            newParameters = new ArrayList<Object>( parameters.size( ) );
            expectedParametersForEvent = new ArrayList<Object>( parameters.size( ) );
            for ( Iterator<? extends Object> parameterIter = parameters.iterator( ), attributeIter = nonDerivedAttributes.iterator( ); parameterIter.hasNext( ) && attributeIter.hasNext( ); ) {
                Object parameter = parameterIter.next( );
                Object newParameter = parameter;
                Object expectedParameterForEvent = parameter;
                Attribute attribute = (Attribute) attributeIter.next( );
                Classifier attributeType = attribute.getType( );
                int attributeLowerBound = attribute.getMultiplicity( ).getLower( );
                int attributeUpperBound = attribute.getMultiplicity( ).getUpper( );
                boolean attributeIsOrdered = attribute.getMultiplicity( ).isOrdered( );
                boolean attributeIsUnique = attribute.getMultiplicity( ).isUnique( );
                if ( parameter == null ) {
                    // correct the values
                    expectedParameterForEvent = null;
                    if ( ( attributeUpperBound == JmiHelper.MULTIPLICITY_BOUND_INFINITE ) || ( attributeUpperBound > 1 ) ) {
                        // multi-valued
                        newParameter = attributeIsOrdered ? Collections.EMPTY_LIST : new MyCollection( );
                    } else if ( ( attributeLowerBound == 1 ) && ( attributeType instanceof PrimitiveType ) ) {
                        // single-valued, required and primitive
                        newParameter = getTestHelper( ).getSpiJmiHelper( getMOINConnection( ).getJmiHelper( ) ).getJavaReturnInitialWrapperValueFromClassifier( coreConnection, attribute.getType( ) );
                    }
                } else if ( attributeIsUnique ) {
                    newParameter = new MyUniqueCollection( (Collection) parameter );
                    expectedParameterForEvent = new MyUniqueCollection( (Collection) parameter );
                }
                newParameters.add( newParameter );
                expectedParametersForEvent.add( expectedParameterForEvent );
            }
        }
        instanceCreateDoUndoRedoTransaction( new InstanceCreateTransaction( refClass, parameters, partition ), nonDerivedAttributes, newParameters, expectedParametersForEvent );
    }

    private void instanceDeleteDoUndoRedoTransaction( Transactionable transactionable, RefObject instanceToDelete, List<ChangeEvent> expectedDoEvents, List<ChangeEvent> expectedUndoEvents ) {

        CoreConnection conn = coreConnection;
        MRI mriOfInstanceToDelete = ( (Partitionable) instanceToDelete ).get___Mri( );
        List<CorePartitionable> childrenToDelete = getAllComponentChildrenRecursive( ( (Wrapper<CorePartitionable>) instanceToDelete ).unwrap( ) );
        Collection<EndStorageLink> associationLinksToDelete = new ArrayList<EndStorageLink>( );
        EndStorageLink linkToParent = getCompositeParentLink( ( (Wrapper<CorePartitionable>) instanceToDelete ).unwrap( ) );
        RefFeatured parent = null;
        Attribute parentAttribute = null;
        if ( linkToParent != null && ( linkToParent.getMetaObject( ) instanceof Attribute ) ) {
            // the instance to delete is an attribute of another instance
            parent = (RefFeatured) linkToParent.getEnd( linkToParent.getCompositeEnd( ) ).get( conn.getSession( ) );
            parentAttribute = (Attribute) linkToParent.getMetaObject( );
        }
        Map<RefObject, PRI> instances2PriMap = new HashMap<RefObject, PRI>( );
        instances2PriMap.put( instanceToDelete, ( (Partitionable) instanceToDelete ).get___Partition( ).getPri( ) );
        Map<RefObject, Map<Attribute, Object>> instances2AttributesMap = new HashMap<RefObject, Map<Attribute, Object>>( );
        instances2AttributesMap.put( instanceToDelete, new HashMap<Attribute, Object>( ) );
        for ( CorePartitionable child : childrenToDelete ) {
            RefObject childWrap = (RefObject) wrapperManager.wrapObject( ( (ConnectionWrapper) getMOINConnection( ) ).unwrap( ), child );
            instances2AttributesMap.put( childWrap, new HashMap<Attribute, Object>( ) );
            instances2PriMap.put( childWrap, ( (Partitionable) child ).get___Partition( ).getPri( ) );
        }
        for ( RefObject instance : instances2AttributesMap.keySet( ) ) {
            List<Attribute> attributes = getNonDerivedAttributes( instance.refClass( ).refMetaObject( ) );
            Map<Attribute, Object> parameters = instances2AttributesMap.get( instance );
            RefObjectImpl instanceUnwrapped = (RefObjectImpl) ( (Wrapper) instance ).unwrap( );
            for ( Attribute attribute : attributes ) {
                int attributeUpperBound = attribute.getMultiplicity( ).getUpper( );
                Object attributeValue = null;
                if ( ( attributeUpperBound == JmiHelper.MULTIPLICITY_BOUND_INFINITE ) || ( attributeUpperBound > 1 ) ) {
                    if ( attribute.getType( ) instanceof PrimitiveType ) {
                        attributeValue = ( (MultiValuedAttributesList) instanceUnwrapped.refGetValue( conn, attribute.getName( ) ) ).clone( );
                    } else {
                        if ( attribute.getMultiplicity( ).isOrdered( ) ) {
                            attributeValue = new ArrayList( (List) instance.refGetValue( attribute.getName( ) ) );
                        } else {
                            attributeValue = new MyCollection( (Collection) instance.refGetValue( attribute.getName( ) ) );
                        }
                    }
                } else {
                    attributeValue = instance.refGetValue( attribute.getName( ) );
                }
                parameters.put( attribute, attributeValue );
            }
            associationLinksToDelete.addAll( getAssociationLinksForElement( (CorePartitionable) ( (Wrapper) instance ).unwrap( ) ) );
        }
//        Map<ModelPartition, List<RefObject>> affectedPartitions = new HashMap<ModelPartition, List<RefObject>>( ); // currently not used
//        affectedPartitions.put( ( (Partitionable) instanceToDelete ).get___Partition( ), Arrays.<RefObject> asList( instanceToDelete ) );
//        for ( Partitionable child : childrenToDelete ) {
//            instancesToDelete.put( (RefObject) child, new HashMap<Attribute, Object>( ) );
//            if ( affectedPartitions.get( child.get___Partition( ) ) == null ) {
//                affectedPartitions.put( child.get___Partition( ), new ArrayList( ) );
//            }
//            affectedPartitions.get( child.get___Partition( ) ).add( (RefObject) child );
//        }
        // currently only the partition of the root instance is tested, could be enhanced
        ModelPartition partitionOfInstanceToDelete = ( (Partitionable) instanceToDelete ).get___Partition( );
        TransactionRecord executeTransactionRecord = null;
        initEventsCheck( );
        // initEventsCheck(new EventTypeFilter(ElementDeleteEvent.class));
        synchronized ( coreSession.getWorkspaceSet( ).getSynchronizationManager( ).getProhibitWriteSyncObject( ) ) {
            // do
            Collection<Partitionable> elementsBeforeDo = partitionOfInstanceToDelete.getElements( );
            try {
                executeTransactionRecord = transactionManager.runInTransaction( transactionable );
            } catch ( UnrecoverableExecutionException unrecoverableExecutionEx ) {
                // unrecoverable exception occurred
                throw unrecoverableExecutionEx;
            } catch ( JmiException jmiEx ) {
                throw jmiEx;
            } catch ( RuntimeException runtimeEx ) {
                // recoverable exception occurred, check that nothing was really
                // done, same checks as in the undo case
                Collection<Partitionable> elementsAfterDo = partitionOfInstanceToDelete.getElements( );
                assertEquals( elementsAfterDo, elementsBeforeDo );
                for ( RefObject instance : instances2AttributesMap.keySet( ) ) {
                    assertTrue( elementsAfterDo.contains( instance ) );
                    assertTrue( ( (Partitionable) instance ).is___Alive( ) );
                    // check whether the parameters of the deleted instances are
                    // the same as before the deletion
                    assertInstanceParameters( instance, instances2AttributesMap.get( instance ) );
                }
                // check parent, if present
                if ( parent != null ) {
                    if ( parentAttribute.getMultiplicity( ).getUpper( ) == 1 ) {
                        assertTrue( parent.refGetValue( parentAttribute.getName( ) ).equals( ( (Wrapper) instanceToDelete ).unwrap( ) ) );
                    } else {
                        assertTrue( containsElementWithMri( conn, (JmiList) ( (RefFeaturedImpl) parent ).refGetValue( conn, parentAttribute.getName( ) ), mriOfInstanceToDelete ) );
                    }
                }
                throw runtimeEx;
            }
            Collection<Partitionable> elementsAfterDo = partitionOfInstanceToDelete.getElements( );
            assertTrue( elementsAfterDo.size( ) == elementsBeforeDo.size( ) - instances2AttributesMap.size( ) );
            for ( RefObject instance : instances2AttributesMap.keySet( ) ) {
                assertFalse( elementsAfterDo.contains( instance ) );
                assertFalse( ( (Partitionable) instance ).is___Alive( ) );
            }
            // check parent, if present
            if ( parent != null ) {
                if ( parentAttribute.getMultiplicity( ).getUpper( ) == 1 ) {
                    assertTrue( ( (RefFeaturedImpl) parent ).refGetValue( conn, parentAttribute.getName( ) ) == null );
                } else {
                    assertFalse( containsElementWithMri( conn, (JmiList) ( (RefFeaturedImpl) parent ).refGetValue( conn, parentAttribute.getName( ) ), mriOfInstanceToDelete ) );
                }
            }
            testEventsCheck( expectedDoEvents );
            // undo
            if ( executeTransactionRecord != null ) {
                initEventsCheck( );
                transactionManager.undo( executeTransactionRecord );
                Collection<Partitionable> elementsAfterUndo = partitionOfInstanceToDelete.getElements( );
                assertEquals( elementsAfterUndo, elementsBeforeDo );
                for ( RefObject instance : instances2AttributesMap.keySet( ) ) {
                    assertTrue( elementsAfterUndo.contains( instance ) );
                    assertTrue( ( (Partitionable) instance ).is___Alive( ) );
                    // check whether the parameters of the deleted instances are the same as before the deletion
                    assertInstanceParameters( instance, instances2AttributesMap.get( instance ) );
                    // check whether the partition of the deleted instances are the same as before the deletion
                    assertTrue( ( (Partitionable) instance ).get___Partition( ).getPri( ).equals( instances2PriMap.get( instance ) ) );
                }
                // check parent, if present
                if ( parent != null ) {
                    if ( parentAttribute.getMultiplicity( ).getUpper( ) == 1 ) {
                        assertTrue( ( (RefFeaturedImpl) parent ).refGetValue( conn, parentAttribute.getName( ) ).equals( ( (Wrapper) instanceToDelete ).unwrap( ) ) );
                    } else {
                        assertTrue( containsElementWithMri( conn, (JmiList) ( (RefFeaturedImpl) parent ).refGetValue( conn, parentAttribute.getName( ) ), mriOfInstanceToDelete ) );
                    }
                }
                testEventsCheck( expectedUndoEvents );
            }
            // redo
            if ( executeTransactionRecord != null ) {
                initEventsCheck( );
                transactionManager.redo( executeTransactionRecord );
                Collection<Partitionable> elementsAfterRedo = partitionOfInstanceToDelete.getElements( );
                assertEquals( elementsAfterRedo, elementsAfterDo );
                for ( RefObject instance : instances2AttributesMap.keySet( ) ) {
                    assertFalse( elementsAfterRedo.contains( instance ) );
                    assertFalse( ( (Partitionable) instance ).is___Alive( ) );
                }
                // check parent, if present
                if ( parent != null ) {
                    if ( parentAttribute.getMultiplicity( ).getUpper( ) == 1 ) {
                        assertTrue( ( (RefFeaturedImpl) parent ).refGetValue( coreConnection, parentAttribute.getName( ) ) == null );
                    } else {
                        assertFalse( containsElementWithMri( conn, (JmiList) ( (RefFeaturedImpl) parent ).refGetValue( conn, parentAttribute.getName( ) ), mriOfInstanceToDelete ) );
                    }
                }
                testEventsCheck( expectedDoEvents );
            }
        }
    }

    private void instanceCreateDoUndoRedoTransaction( InstanceCreateTransaction instanceCreateTransaction, List<Attribute> attributes, List<Object> finalParameters, List<Object> expectedParametersForEvent ) {

        ModelPartition partitionOfInstanceCreated = instanceCreateTransaction.getPartitionOfInstanceCreated( );
        Collection<Partitionable> elementsBefore = partitionOfInstanceCreated.getElements( );
        TransactionRecord executeTransactionRecord = null;
        Map<Attribute, Object> attribute2ParameterMap = null;
        if ( ( finalParameters != null ) && ( finalParameters.size( ) == attributes.size( ) ) ) {
            attribute2ParameterMap = new HashMap<Attribute, Object>( finalParameters.size( ) );
            int index = 0;
            for ( Attribute attribute : attributes ) {
                attribute2ParameterMap.put( attribute, finalParameters.get( index ) );
                index++;
            }
        }
        initEventsCheck( );
        synchronized ( coreSession.getWorkspaceSet( ).getSynchronizationManager( ).getProhibitWriteSyncObject( ) ) {
            // do
            try {
                executeTransactionRecord = transactionManager.runInTransaction( instanceCreateTransaction );
            } catch ( UnrecoverableExecutionException unrecoverableExecutionEx ) {
                // unrecoverable exception occurred
                throw unrecoverableExecutionEx;
            } catch ( JmiException jmiEx ) {
                throw jmiEx;
            } catch ( NullPointerException nullPointerEx ) {
                throw nullPointerEx;
            } catch ( RuntimeException runtimeEx ) {
                // recoverable exception occurred, check that nothing was really
                // done, same checks as in the undo case
                Collection<Partitionable> elementsAfter = partitionOfInstanceCreated.getElements( );
                assertEquals( elementsBefore, elementsAfter );
                throw runtimeEx;
            }

            Partitionable instanceCreated = instanceCreateTransaction.getInstanceCreated( );
            Collection<Partitionable> elementsAfter = partitionOfInstanceCreated.getElements( );
            assertEquals( true, elementsAfter.contains( instanceCreated ) );
            assertEquals( true, instanceCreated.is___Alive( ) );
            assertTrue( elementsBefore.size( ) < elementsAfter.size( ) );
            if ( finalParameters != null ) {
                assertInstanceParameters( (RefObject) instanceCreated, attribute2ParameterMap );
            }
            List<ChangeEvent> expectedDoEvents = new ArrayList<ChangeEvent>( 1 );
            List<ChangeEvent> expectedUndoEvents = new ArrayList<ChangeEvent>( 1 );
            ChangeEvent expectedDoEvent = new ElementCreateEventImpl( coreConnection, instanceCreated.get___Mri( ), ( (Partitionable) ( (RefObject) instanceCreated ).refMetaObject( ) ).get___Mri( ), ( (Partitionable) ( (RefObject) instanceCreated ).refImmediatePackage( ) ).get___Mri( ) );
            ChangeEvent expectedUndoEvent = new ElementDeleteEventImpl( coreConnection, (RefObject) instanceCreated );
            expectedDoEvents.add( expectedDoEvent );
            expectedUndoEvents.add( expectedUndoEvent );
            testEventsCheck( expectedDoEvents );
            // undo
            if ( executeTransactionRecord != null ) {
                initEventsCheck( );
                elementsBefore = elementsAfter;
                transactionManager.undo( executeTransactionRecord );
                elementsAfter = partitionOfInstanceCreated.getElements( );
                assertEquals( false, elementsAfter.contains( instanceCreated ) );
                assertEquals( false, instanceCreated.is___Alive( ) );
                assertTrue( elementsBefore.size( ) > elementsAfter.size( ) );
                testEventsCheck( expectedUndoEvents );
            }
            // redo
            if ( executeTransactionRecord != null ) {
                initEventsCheck( );
                elementsBefore = elementsAfter;
                transactionManager.redo( executeTransactionRecord );
                // instanceCreated = (Partitionable)instanceCreateTransaction.getInstanceCreated();
                elementsAfter = partitionOfInstanceCreated.getElements( );
                assertEquals( true, elementsAfter.contains( instanceCreated ) );
                assertEquals( true, instanceCreated.is___Alive( ) );
                assertTrue( elementsBefore.size( ) < elementsAfter.size( ) );
                if ( finalParameters != null ) {
                    assertInstanceParameters( (RefObject) instanceCreated, attribute2ParameterMap );
                }
                testEventsCheck( expectedDoEvents );
            }
        }
    }

    private class InstanceDeleteTransaction implements Transactionable {

        RefObject refObject = null;

        private InstanceDeleteTransaction( RefObject anObject ) {

            refObject = anObject;
        }

        public void runInTransaction( ) {

            refObject.refDelete( );
        }

        public CoreConnection getConnection( ) {

            return coreConnection;
        }
    }

    private class InstanceCreateTransaction implements Transactionable {

        private ModelPartition partition = null;

        private RefClass refClass = null;

        private RefObject instanceCreated = null;

        private List<Object> parameters = null;

        private InstanceCreateTransaction( RefClass refClass, List<? extends Object> theParameters, ModelPartition partition ) {

            this.refClass = refClass;
            if ( theParameters != null && theParameters.size( ) != 0 ) {
                parameters = new ArrayList<Object>( theParameters.size( ) );
                parameters.addAll( theParameters );
            }
            this.partition = partition;
        }

        public void runInTransaction( ) {
            instanceCreated = refClass.refCreateInstanceInPartition( parameters, partition );
        }

        public RefObject getInstanceCreated( ) {
            return instanceCreated;
        }

        public ModelPartition getPartitionOfInstanceCreated( ) {
            return partition;
        }

        public CoreConnection getConnection( ) {
            return coreConnection;
        }
    }

    @Override
    protected void initializeOneToManyChangeable( A10 oneChangeable ) {

        OneToManyChangeable oneToManyChangeable = case010Package.getOneToManyChangeable( );
        oneToManyChangeable.refQuery( "oneChangeable", oneChangeable ).clear( );
        oneToManyChangeable.refAddLink( oneChangeable, b10Class.refCreateInstance( ) );
        oneToManyChangeable.refAddLink( oneChangeable, b10Class.refCreateInstance( ) );
        oneToManyChangeable.refAddLink( oneChangeable, b10Class.refCreateInstance( ) );
        oneToManyChangeable.refAddLink( oneChangeable, b10Class.refCreateInstance( ) );
    }

    @Override
    protected void initializeOneToManyOrdered( A10 one ) {

        OneToManyOrdered oneToManyOrdered = case010Package.getOneToManyOrdered( );
        oneToManyOrdered.refQuery( "one", one ).clear( );
        oneToManyOrdered.refAddLink( b10Class.refCreateInstance( ), one );
        oneToManyOrdered.refAddLink( b10Class.refCreateInstance( ), one );
        oneToManyOrdered.refAddLink( b10Class.refCreateInstance( ), one );
        oneToManyOrdered.refAddLink( b10Class.refCreateInstance( ), one );
    }

    @Override
    protected void initializeComposesCsOrdered( F4 myF4 ) {

        ComposesCsOrdered composesCsOrdered = case004Package.getComposesCsOrdered( );
        composesCsOrdered.refQuery( "myF", myF4 ).clear( );
        composesCsOrdered.add( myF4, (C4) c4Class.refCreateInstance( ) );
        composesCsOrdered.add( myF4, (C4) c4Class.refCreateInstance( ) );
        composesCsOrdered.add( myF4, (C4) c4Class.refCreateInstance( ) );
        composesCsOrdered.add( myF4, (C4) c4Class.refCreateInstance( ) );
    }
}
