package com.sap.tc.moin.repository.test.core;

import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.MOIN_DOMAIN;

import java.lang.management.ManagementFactory;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Tag;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanInfo;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.RuntimeMBeanException;
import javax.management.openmbean.TabularData;

import org.junit.Test;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.CommandStack;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.consistency.ConsistencyListener;
import com.sap.tc.moin.repository.consistency.ConsistencyViolation;
import com.sap.tc.moin.repository.core.commands.CommandStackImpl;
import com.sap.tc.moin.repository.core.events.framework.simple.SessionEventManagerSimple;
import com.sap.tc.moin.repository.core.eviction.EvictionThreadImpl;
import com.sap.tc.moin.repository.core.impl.ConnectionImpl;
import com.sap.tc.moin.repository.core.impl.MoinImpl;
import com.sap.tc.moin.repository.core.impl.SessionImpl;
import com.sap.tc.moin.repository.core.impl.SynchronizationManagerImpl;
import com.sap.tc.moin.repository.core.query.moinql.controller.MQLProcessorImpl;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.filter.EventTypeFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.jmx.CommandStackMBean;
import com.sap.tc.moin.repository.jmx.ConnectionMBean;
import com.sap.tc.moin.repository.jmx.CpsMBean;
import com.sap.tc.moin.repository.jmx.EvictionMBean;
import com.sap.tc.moin.repository.jmx.LockingMBean;
import com.sap.tc.moin.repository.jmx.MoinLoggerMBean;
import com.sap.tc.moin.repository.jmx.MoinMBean;
import com.sap.tc.moin.repository.jmx.MqlProcessorMBean;
import com.sap.tc.moin.repository.jmx.RuntimeHostIdeMBean;
import com.sap.tc.moin.repository.jmx.SessionEventManagerMBean;
import com.sap.tc.moin.repository.jmx.SessionMBean;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper;
import com.sap.tc.moin.repository.test.logger.TestMessage;
import com.sap.tc.moin.test.fw.JmxRemoteConnection;


public class TestJmx extends CoreMoinTest {

    @Test
    public void testConnectionMBean( ) throws Exception {

        ConnectionImpl connection = (ConnectionImpl) getTestHelper( ).getCoreConnection( getMOINConnection( ) );
        ObjectName objName = connection.getObjectName( );
        JmxRemoteConnection jmxConnection = getTestHelper( ).createJmxRemoteConnection( objName );
        try {
            ConnectionMBean mbean = jmxConnection.newProxy( ConnectionMBean.class );
            mbean.save( );
            assertTrue( mbean.getAllocationStackTrace( ).length > 0 );
            assertTrue( mbean.getId( ) != null );
            assertTrue( mbean.getLabel( ) != null );
            assertTrue( mbean.isAlive( ) );

            MofPackage mofPackage = getPartitionOne( ).createElement( MofPackage.class );
            RefClass classProxy = getMOINConnection( ).getClass( MofClass.CLASS_DESCRIPTOR );
            MofClass mofClass = (MofClass) classProxy.refCreateInstance( );

            assertSame( 3, mbean.getCachedPartitionWrappers( ) );
            List<String> cachedPartitionWrappers = Arrays.asList( mbean.showCachedPartitionWrappers( ) );
            assertTrue( cachedPartitionWrappers.contains( getPartitionOne( ).getPri( ).toString( ) ) );
            assertTrue( cachedPartitionWrappers.contains( getPartitionTwo( ).getPri( ).toString( ) ) );
            assertTrue( cachedPartitionWrappers.contains( getPartitionThree( ).getPri( ).toString( ) ) );

            assertSame( 3, mbean.getCachedJmiWrappers( ) );
            List<String> cachedJmiWrappers = Arrays.asList( mbean.showCachedJmiWrappers( ) );
            assertTrue( cachedJmiWrappers.contains( ( (Partitionable) mofClass ).get___Mri( ).toString( ) ) );
            assertTrue( cachedJmiWrappers.contains( ( (Partitionable) mofClass.refClass( ) ).get___Mri( ).toString( ) ) );
            assertTrue( cachedJmiWrappers.contains( ( (Partitionable) mofPackage ).get___Mri( ).toString( ) ) );

            assertSame( 0, mbean.getCachedJmiListWrappers( ) );
            List<ModelElement> contents = mofPackage.getContents( ); // assigning to variable to prevent garbage collection!
            assertSame( 1, mbean.getCachedJmiListWrappers( ) );

            String priOfNullPartition = mbean.getNullPartition( );
            String priOne = getPartitionOne( ).getPri( ).toString( );
            List<String> dirtyPartitions = Arrays.asList( mbean.getDirtyPartitions( ) );
            assertTrue( dirtyPartitions.size( ) == 2 );
            assertTrue( dirtyPartitions.contains( priOfNullPartition ) );
            assertTrue( dirtyPartitions.contains( priOne ) );
            assertSame( 1, mbean.getNumberOfElementsInNullPartition( ) );

            assertSame( 1, mbean.getTransientPartitions( ).length );
            getMOINConnection( ).getOrCreateTransientPartition( "transientPartition" );
            String[] transientPartitions = mbean.getTransientPartitions( );
            assertSame( 2, transientPartitions.length );

            String mriString = ( (Partitionable) mofClass ).get___Mri( ).toString( );
            assertTrue( mbean.getElementByMRI( mriString ) != null );
            String[] elementsInPartition = mbean.getElementsInPartition( priOfNullPartition );
            assertSame( 1, elementsInPartition.length );
            assertEquals( mriString, elementsInPartition[0] );

            mriString = ( (Partitionable) mofPackage ).get___Mri( ).toString( );
            assertTrue( mbean.getElementByLRI( ( (Partitionable) mofPackage ).get___Mri( ).getLri( ).toString( ) ) != null );
            elementsInPartition = mbean.getElementsInPartition( priOne );
            assertSame( 1, elementsInPartition.length );
            assertEquals( mriString, elementsInPartition[0] );
            String[] rootElementsInPartition = mbean.getRootElementsInPartition( priOne );
            assertSame( 1, rootElementsInPartition.length );
            assertEquals( mriString, rootElementsInPartition[0] );

            mbean.showAllPartitionDeltas( );
            mbean.showPartitionDelta( priOne );
            assertTrue( mbean.showContentOfPartition( priOne ).length( ) > 0 );
            assertTrue( mbean.showContentOfPartition( priOfNullPartition ).length( ) > 0 );
            assertTrue( mbean.showContentOfPartition( priOne, "2" ).length( ) > 0 );
            assertTrue( mbean.showContentOfPartition( priOfNullPartition, "2" ).length( ) > 0 );
            assertTrue( mbean.showContentOfPartitionInNativeFormat( priOne ).length( ) > 0 );
            assertTrue( mbean.showContentOfPartitionInNativeFormat( priOfNullPartition ).length( ) > 0 );

            try {
                mbean.save( );
                fail( "Expected NullPartitionNotEmptyException during save() because null-partition is not empty" );
            } catch ( RuntimeMBeanException ex ) {
                // expected (JDK 5)
                assertTrue( ex.getCause( ) instanceof NullPartitionNotEmptyException );
            } catch ( NullPartitionNotEmptyException ex ) {
                // Probably bug in JDK 6: RuntimeException is not wrapped in a RuntimeMBeanException (bug reported to Sun)
                assertTrue( System.getProperty( "java.version" ).indexOf( "1.6.0" ) != -1 );
            }

            mbean.initializeMqlProcessor( );
            mbean.deleteAllElementsInNullPartition( );
            mbean.save( );
            assertSame( 0, mbean.getDirtyPartitions( ).length );
            mbean.revert( );
            mbean.close( );
        } finally {
            if ( jmxConnection != null ) {
                jmxConnection.shutdown( );
            }
        }
    }

    @Test
    public void testSessionMBean( ) throws Exception {

        SessionImpl session = (SessionImpl) getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( );
        ObjectName objName = session.getObjectName( );
        JmxRemoteConnection jmxConnection = getTestHelper( ).createJmxRemoteConnection( objName );
        try {
            SessionMBean mbean = jmxConnection.newProxy( SessionMBean.class );
            assertTrue( mbean.getLoadedPartitions( ).length >= 3 );
            assertTrue( mbean.showSummaryOfLoadedPartitions( ) != null );
            mbean.initializeOclRegistryService( );
            ConsistencyListener consistencyListener = new ConsistencyListener( ) {

                public void onConsistencyResolution( ConsistencyViolation[] consistencyViolation, Connection connection ) {

                }

                public void onConsistencyViolation( ConsistencyViolation[] consistencyViolation, Connection connection ) {

                }
            };
            getMOINConnection( ).getConsistencyViolationListenerRegistry( ).addListener( consistencyListener );
            List<String> consistencyListeners = Arrays.asList( mbean.getAllConsistencyListeners( ) );
            assertTrue( consistencyListeners.contains( consistencyListener.toString( ) ) );
            mbean.getAllConsistencyViolations( );
            mbean.startNotifications( );
            assertTrue( mbean.notificationsStarted( ) );
            mbean.stopNotifications( );
            assertFalse( mbean.notificationsStarted( ) );
        } finally {
            if ( jmxConnection != null ) {
                jmxConnection.shutdown( );
            }
        }
    }

    public void testCommandStackMBean( ) throws Exception {

        ConnectionImpl connection = (ConnectionImpl) getTestHelper( ).getCoreConnection( getMOINConnection( ) );
        CommandStack commandStack = getMOINConnection( ).getCommandStack( );
        ObjectName objName = ( (CommandStackImpl) connection.getCommandStack( ) ).getObjectName( );
        JmxRemoteConnection jmxConnection = getTestHelper( ).createJmxRemoteConnection( objName );

        try {
            CommandStackMBean mbean = jmxConnection.newProxy( CommandStackMBean.class );

            mbean.stopNotifications( );
            assertFalse( mbean.notificationsStarted( ) );
            mbean.startNotifications( );
            assertTrue( mbean.notificationsStarted( ) );

            assertSame( 0, mbean.getCommandGroupStack( ).length );

            commandStack.openGroup( "TestJmx" );
            assertSame( 1, mbean.getCommandGroupStack( ).length );

            getPartitionOne( ).createElement( MofPackage.class );
            commandStack.closeGroup( );
            assertSame( 1, mbean.getCommandsOnUndoStack( ).length );
            assertSame( 0, mbean.getCommandsOnRedoStack( ).length );

            commandStack.undo( );
            assertSame( 0, mbean.getCommandsOnUndoStack( ).length );
            assertSame( 1, mbean.getCommandsOnRedoStack( ).length );

            commandStack.redo( );
            assertSame( 1, mbean.getCommandsOnUndoStack( ).length );
            assertSame( 0, mbean.getCommandsOnRedoStack( ).length );

            DummyCommand command = new DummyCommand( getMOINConnection( ), "TestJmx.testCommandStackMBean()" );
            command.execute( );
            assertSame( 2, mbean.getCommandsOnUndoStack( ).length );
            assertSame( 0, mbean.getCommandsOnRedoStack( ).length );

            mbean.stopNotifications( );
        } finally {
            if ( jmxConnection != null ) {
                jmxConnection.shutdown( );
            }
        }
    }

    @Test
    public void testEvictionMBean( ) throws Exception {

        ConnectionImpl connection = (ConnectionImpl) getTestHelper( ).getCoreConnection( getMOINConnection( ) );
        ObjectName objName = ( (EvictionThreadImpl) connection.getSession( ).getMoin( ).getEvictionThread( ) ).getObjectName( );
        JmxRemoteConnection jmxConnection = getTestHelper( ).createJmxRemoteConnection( objName );

        try {
            EvictionMBean mbean = jmxConnection.newProxy( EvictionMBean.class );

            mbean.stopNotifications( );
            assertFalse( mbean.notificationsStarted( ) );
            mbean.startNotifications( );
            assertTrue( mbean.notificationsStarted( ) );

            long oldEvictionInterval = mbean.getEvictionInterval( );
            mbean.setEvictionInterval( 2 * oldEvictionInterval );
            assertEquals( 2 * oldEvictionInterval, mbean.getEvictionInterval( ) );
            mbean.setEvictionInterval( oldEvictionInterval );

            long oldMaximumAge = mbean.getMaximumAge( );
            mbean.setMaximumAge( 2 * oldMaximumAge );
            assertEquals( 2 * oldMaximumAge, mbean.getMaximumAge( ) );
            mbean.setMaximumAge( oldMaximumAge );

            mbean.stopNotifications( );
        } finally {
            if ( jmxConnection != null ) {
                jmxConnection.shutdown( );
            }
        }
    }

    @Test
    public void testMqlProcessorMBean( ) throws Exception {

        ConnectionImpl connection = (ConnectionImpl) getTestHelper( ).getCoreConnection( getMOINConnection( ) );
        ObjectName objName = ( (MQLProcessorImpl) connection.getMQLProcessor( ) ).getObjectName( );
        JmxRemoteConnection jmxConnection = getTestHelper( ).createJmxRemoteConnection( objName );

        try {
            MqlProcessorMBean mbean = jmxConnection.newProxy( MqlProcessorMBean.class );

            mbean.stopNotifications( );
            assertFalse( mbean.notificationsStarted( ) );
            mbean.startNotifications( );
            assertTrue( mbean.notificationsStarted( ) );

            String query = "select class from Model::Class as class in containers {\"sap.com/tc/moin/mof_1.4\"} where class.name = 'ModelElement'";
            TabularData resultSet = mbean.query( query );
            assertEquals( 1, resultSet.values( ).size( ) );

            mbean.stopNotifications( );
        } finally {
            if ( jmxConnection != null ) {
                jmxConnection.shutdown( );
            }
        }
    }

    @Test
    public void testLockingMBean( ) throws Exception {

        ConnectionImpl connection = (ConnectionImpl) getTestHelper( ).getCoreConnection( getMOINConnection( ) );
        ObjectName objName = ( (SynchronizationManagerImpl) connection.getSession( ).getWorkspaceSet( ).getSynchronizationManager( ) ).getObjectName( );
        JmxRemoteConnection jmxConnection = getTestHelper( ).createJmxRemoteConnection( objName );

        try {
            LockingMBean mbean = jmxConnection.newProxy( LockingMBean.class );

            mbean.stopNotifications( );
            assertFalse( mbean.notificationsStarted( ) );
            mbean.startNotifications( );
            assertTrue( mbean.notificationsStarted( ) );

            MofPackage mofPackage = getPartitionOne( ).createElement( MofPackage.class );
            assertTrue( getPartitionOne( ).getElements( ).contains( mofPackage ) );
            getMOINConnection( ).save( );

            mbean.stopNotifications( );
        } finally {
            if ( jmxConnection != null ) {
                jmxConnection.shutdown( );
            }
        }
    }

    @Test
    public void testMoinLoggerMBean( ) throws Exception {

        ObjectName objName = new ObjectName( SpiJmxHelper.MOIN_DOMAIN + "type=Logging,*" );
        JmxRemoteConnection jmxConnection = getTestHelper( ).createJmxRemoteConnection( objName );
        objName = jmxConnection.getObjectName( );

        try {
            MoinLoggerMBean mbean = jmxConnection.newProxy( MoinLoggerMBean.class );

            mbean.getCategories( );
            mbean.getLocations( );

            MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CORE, TestJmx.class );

            mbean.stopNotifications( );
            assertFalse( mbean.notificationsStarted( ) );
            mbean.startNotifications( );
            assertTrue( mbean.notificationsStarted( ) );

            logger.logAndTrace( MoinSeverity.INFO, TestMessage.LOGGER_0000 );
            logger.logAndTrace( MoinSeverity.WARNING, TestMessage.LOGGER_0000 );
            logger.logAndTrace( MoinSeverity.ERROR, TestMessage.LOGGER_0000 );
            logger.logAndTrace( MoinSeverity.FATAL, TestMessage.LOGGER_0000 );
            logger.logAndTrace( MoinSeverity.DEBUG, TestMessage.LOGGER_0000 );
            logger.logAndTrace( MoinSeverity.PATH, TestMessage.LOGGER_0000 );

            mbean.stopNotifications( );
        } finally {
            jmxConnection.shutdown( );
        }
    }

    @Test
    public void testMoinMBean( ) throws Exception {

        ConnectionImpl connection = (ConnectionImpl) getTestHelper( ).getCoreConnection( getMOINConnection( ) );
        ObjectName objName = ( (MoinImpl) connection.getSession( ).getMoin( ) ).getObjectName( );
        JmxRemoteConnection jmxConnection = getTestHelper( ).createJmxRemoteConnection( objName );
        try {
            MoinMBean mbean = jmxConnection.newProxy( MoinMBean.class );
            mbean.getUptime( );
            mbean.getStartedAt( );
            mbean.getMoinVersionNumber( );
            mbean.getMoinVersionDate( );
            mbean.getMoinVersionComment( );
            mbean.getMoinCoreRuntimeVersionMajor( );
            mbean.getMoinCoreRuntimeVersionMinor( );
            mbean.checkConsistencyOfMoinCore( );
            mbean.checkConsistencyOfMoinCoreWithoutLocks( );
        } finally {
            if ( jmxConnection != null ) {
                jmxConnection.shutdown( );
            }
        }
    }

    @Test
    public void testRuntimeHostIdeMBean( ) throws Exception {

        ObjectName objName = new ObjectName( SpiJmxHelper.MOIN_DOMAIN + "type=RuntimeHost,*" );
        JmxRemoteConnection jmxConnection = getTestHelper( ).createJmxRemoteConnection( objName );
        try {
            RuntimeHostIdeMBean mbean = jmxConnection.newProxy( RuntimeHostIdeMBean.class );
            assertTrue( mbean.showAllMetamodels( ) != null );
        } finally {
            if ( jmxConnection != null ) {
                jmxConnection.shutdown( );
            }
        }
    }

    @Test
    public void testSessionEventManagerMBean( ) throws Exception {

        ConnectionImpl connection = (ConnectionImpl) getTestHelper( ).getCoreConnection( getMOINConnection( ) );
        ObjectName objName = ( (SessionEventManagerSimple) connection.getSession( ).getEventManager( ) ).getObjectName( );
        JmxRemoteConnection jmxConnection = getTestHelper( ).createJmxRemoteConnection( objName );

        // Register dummy listener to trigger event creation.
        connection.getEventRegistry( ).registerListener( new ChangeListener( ) {

            public void notify( ChangeEvent event ) {

            }
        }, new EventTypeFilter( ) );

        try {
            SessionEventManagerMBean mbean = jmxConnection.newProxy( SessionEventManagerMBean.class );
            mbean.stopNotifications( );
            assertFalse( mbean.notificationsStarted( ) );
            mbean.startNotifications( );
            assertTrue( mbean.notificationsStarted( ) );

            int oldMonitoringLevel = mbean.getMonitoringLevel( );
            mbean.setMonitoringLevel( 3 );

            MofPackage mofPackage = getPartitionOne( ).createElement( MofPackage.class );
            mofPackage.setName( "MyMofPackage" );
            MofClass mofClass = getPartitionOne( ).createElement( MofClass.class );
            mofClass.setContainer( mofPackage );
            mofClass.setName( "MyMofClass" );
            mofPackage.getContents( ).clear( );
            mofClass.refDelete( );
            EnumerationType enumerationType = getPartitionOne( ).createElement( EnumerationType.class );
            List<String> labels = enumerationType.getLabels( );
            labels.add( "label1" );
            labels.add( "label2" );
            labels.remove( "label2" );
            getMOINConnection( ).save( );
            mofPackage.setRoot( true );
            getMOINConnection( ).save( );
            getPartitionTwo( ).assignElement( mofPackage );
            getMOINConnection( ).save( );
            ModelPartition createdPartition = _testClient1.createPartition( "JMX" );
            createdPartition.delete( );
            getMOINConnection( ).save( );
            ModelPartition partition = getSecondMOINConnection( ).getPartition( getPartitionOne( ).getPri( ) );
            partition.createElement( Tag.class );
            getSecondMOINConnection( ).save( );

            mbean.setFireEvents( mbean.getFireEvents( ) );
            mbean.setLogPreEvents( mbean.getLogPreEvents( ) );

            assertTrue( mbean.getNumAttributeValueAddEvents( ) > 0 );
            assertTrue( mbean.getNumAttributeValueChangeEvents( ) > 0 );
            assertTrue( mbean.getNumAttributeValueRemoveEvents( ) > 0 );
            assertTrue( mbean.getNumElementCreateEvents( ) > 0 );
            assertTrue( mbean.getNumElementDeleteEvents( ) > 0 );
            assertTrue( mbean.getNumLinkAddEvents( ) > 0 );
            assertTrue( mbean.getNumLinkRemoveEvents( ) > 0 );
            assertTrue( mbean.getNumPartitionMembershipChangeEvents( ) > 0 );
            assertTrue( mbean.getNumPartitionSaveEvents( ) > 0 );
            assertTrue( mbean.getNumPartitionCreateEvents( ) > 0 );
            assertTrue( mbean.getNumPartitionRemoveEvents( ) > 0 );
            assertTrue( mbean.getNumPartitionContentChangeEvents( ) > 0 );
            mbean.showEventListeners( );

            mbean.resetEventCounters( );

            assertTrue( mbean.getNumAttributeValueAddEvents( ) == 0 );
            assertTrue( mbean.getNumAttributeValueChangeEvents( ) == 0 );
            assertTrue( mbean.getNumAttributeValueRemoveEvents( ) == 0 );
            assertTrue( mbean.getNumElementCreateEvents( ) == 0 );
            assertTrue( mbean.getNumElementDeleteEvents( ) == 0 );
            assertTrue( mbean.getNumLinkAddEvents( ) == 0 );
            assertTrue( mbean.getNumLinkRemoveEvents( ) == 0 );
            assertTrue( mbean.getNumPartitionMembershipChangeEvents( ) == 0 );
            assertTrue( mbean.getNumPartitionSaveEvents( ) == 0 );
            assertTrue( mbean.getNumPartitionCreateEvents( ) == 0 );
            assertTrue( mbean.getNumPartitionRemoveEvents( ) == 0 );
            assertTrue( mbean.getNumPartitionContentChangeEvents( ) == 0 );
            assertTrue( mbean.getNumPartitionPropertyChangeEvents( ) == 0 );

            mbean.setMonitoringLevel( oldMonitoringLevel );

            mbean.stopNotifications( );
        } finally {
            jmxConnection.shutdown( );
        }
    }

    @Test
    public void testCpsMBean( ) throws Exception {

        ObjectName objName = new ObjectName( MOIN_DOMAIN + "type=PartitionSerializationManager,*" );
        JmxRemoteConnection jmxConnection = getTestHelper( ).createJmxRemoteConnection( objName );
        objName = jmxConnection.getObjectName( );

        try {
            CpsMBean mbean = jmxConnection.newProxy( CpsMBean.class );

            mbean.getCustomParserSerializerFactories( );
            mbean.getErrorHandlers( );
            mbean.getS2XSerializerCustomCallbacks( );
            mbean.getPriPatternRegistry( );
            mbean.getModelContentSelectionCriteria( );

            String id = mbean.findResponsibleParserSerializer( "PF.MetaModelDataArea:DCs/test.sap.com/tc/moin/metamodel/testcases/_comp/moin/meta/testcases.moinmm" );
            assertEquals( "com.sap.tc.moin.repository.DefaultParserSerializer", id );
            id = mbean.findResponsibleParserSerializer( "PF.LocalDevelopment[local]:DCs/test.sap.com/moin/pf/srcModelCustomParser/_comp/src/moin/folder1/CustomSerializerPartition.cpstest2" );
            assertEquals( "com.sap.tc.moin.repository.cps.test.SimpleTestSerialization", id );

            mbean.stopNotifications( );
            assertFalse( mbean.notificationsStarted( ) );
            mbean.startNotifications( );
            assertTrue( mbean.notificationsStarted( ) );
            mbean.stopNotifications( );
        } finally {
            jmxConnection.shutdown( );
        }
    }

    @Test
    public void testJmxGenericForCodeCoverage( ) throws Exception {

        MBeanServer mbeanServer = ManagementFactory.getPlatformMBeanServer( );
        Set<ObjectName> objectNames = mbeanServer.queryNames( null, null );

        try {
            for ( ObjectName objectName : objectNames ) {
                if ( objectName.getCanonicalName( ).indexOf( SpiJmxHelper.MOIN_DOMAIN ) != -1 ) {
                    try {
                        MBeanInfo beanInfo = mbeanServer.getMBeanInfo( objectName );
                        MBeanAttributeInfo[] beanAttributeInfos = beanInfo.getAttributes( );
                        for ( MBeanAttributeInfo beanAttributeInfo : beanAttributeInfos ) {
                            if ( beanAttributeInfo.isReadable( ) ) {
                                mbeanServer.getAttribute( objectName, beanAttributeInfo.getName( ) );
                                System.out.println( "Getting attribute: " + objectName + "->" + beanAttributeInfo.getName( ) );
                            }
                        }
                        MBeanOperationInfo[] operations = beanInfo.getOperations( );
                        for ( MBeanOperationInfo operationInfo : operations ) {
                            if ( operationInfo.getSignature( ).length == 0 ) {
                                mbeanServer.invoke( objectName, operationInfo.getName( ), new Object[0], new String[0] );
                                System.out.println( "Invoking operation: " + objectName + "->" + operationInfo.getName( ) + "()" );
                            }
                        }
                    } catch ( Exception e ) {
                    }
                }
            }
        } finally {
            getTestHelper( ).reset( );
        }
    }

    private static class DummyCommand extends Command {

        protected DummyCommand( Connection connection, String description ) {

            super( connection, description );
        }

        @Override
        public boolean canExecute( ) {

            return true;
        }

        @Override
        public void doExecute( ) {

        }

        @Override
        public Collection<PartitionOperation> getAffectedPartitions( ) {

            return Collections.emptyList( );
        }
    }
}