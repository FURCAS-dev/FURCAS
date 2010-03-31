package com.sap.tc.moin.repository.test.core;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.core.events.framework.simple.CoreEventRegistry;
import com.sap.tc.moin.repository.events.filter.EventTypeFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.test.fw.TestMetaModels;

public class TestEventFrameworkUndo extends EventFrameworkTest {

    private ModelPackage mofModelPackage;

    private TestChangeListener listener;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        mofModelPackage = (ModelPackage) connection.getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );
        listener = createAndRegisterTestChangeListener( new EventTypeFilter( ChangeEvent.class ) );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
        mofModelPackage = null;
    }

    @Test
    public void testCreateElement( ) {

        listener.expectedElementCreateEvents = 3;

        connection.getCommandStack( ).openGroup( "Test" );
        mofModelPackage.getMofPackage( ).refCreateInstance( );
        mofModelPackage.getMofClass( ).refCreateInstance( );
        mofModelPackage.getAttribute( ).refCreateInstance( );
        connection.getCommandStack( ).closeGroup( );
        checkReceivedEvents( );

        listener.expectedElementDeleteEvents = 3;
        getMOINConnection( ).getCommandStack( ).undo( );
        checkReceivedEvents( );
    }

    @Test
    public void testDeleteElement( ) {

        listener.expectedElementCreateEvents = 3;
        listener.expectedElementDeleteEvents = 1;

        connection.getCommandStack( ).openGroup( "Test" );
        mofModelPackage.getMofPackage( ).refCreateInstance( );
        mofModelPackage.getMofClass( ).refCreateInstance( );
        Attribute attr = (Attribute) mofModelPackage.getAttribute( ).refCreateInstance( );
        attr.refDelete( );
        connection.getCommandStack( ).closeGroup( );
        checkReceivedEvents( );

        listener.expectedElementDeleteEvents = 3;
        listener.expectedElementCreateEvents = 1;
        getMOINConnection( ).getCommandStack( ).undo( );
        checkReceivedEvents( );
    }

    @Test
    public void testChangeAttributeValue( ) {

        listener.expectedElementCreateEvents = 3;
        listener.expectedAttributeValueChangeEvents = 1;

        connection.getCommandStack( ).openGroup( "Test" );
        mofModelPackage.getMofPackage( ).refCreateInstance( );
        mofModelPackage.getMofClass( ).refCreateInstance( );
        Attribute attr = (Attribute) mofModelPackage.getAttribute( ).refCreateInstance( );
        attr.setName( "Hello" );
        connection.getCommandStack( ).closeGroup( );
        checkReceivedEvents( );

        listener.expectedElementDeleteEvents = 3;
        listener.expectedAttributeValueChangeEvents = 1;
        getMOINConnection( ).getCommandStack( ).undo( );
        checkReceivedEvents( );
    }

    @Test
    public void testAttributeValueAdd( ) {

        listener.expectedElementCreateEvents = 1;
        listener.expectedAttributeValueAddEvents = 3;
        listener.expectedAttributeValueChangeEvents = 1;

        connection.getCommandStack( ).openGroup( "Test" );
        EnumerationType enumD = (EnumerationType) mofModelPackage.getEnumerationType( ).refCreateInstance( );
        enumD.setName( "EnumD" );
        enumD.getLabels( ).add( "Label1" );
        enumD.getLabels( ).add( "Label2" );
        enumD.getLabels( ).add( "LabelTmp" );
        connection.getCommandStack( ).closeGroup( );
        checkReceivedEvents( );

        listener.expectedElementDeleteEvents = 1;
        listener.expectedAttributeValueRemoveEvents = 3;
        listener.expectedAttributeValueChangeEvents = 1;
        getMOINConnection( ).getCommandStack( ).undo( );
        checkReceivedEvents( );
    }

    @Test
    public void testAttributeValueRemove( ) {

        listener.expectedElementCreateEvents = 1;
        listener.expectedAttributeValueAddEvents = 3;
        listener.expectedAttributeValueRemoveEvents = 1;
        listener.expectedAttributeValueChangeEvents = 1;

        connection.getCommandStack( ).openGroup( "Test" );
        EnumerationType enumD = (EnumerationType) mofModelPackage.getEnumerationType( ).refCreateInstance( );
        enumD.setName( "EnumD" );
        enumD.getLabels( ).add( "Label1" );
        enumD.getLabels( ).add( "Label2" );
        enumD.getLabels( ).add( "LabelTmp" );
        enumD.getLabels( ).remove( "LabelTmp" );
        connection.getCommandStack( ).closeGroup( );
        checkReceivedEvents( );

        listener.expectedElementDeleteEvents = 1;
        listener.expectedAttributeValueRemoveEvents = 3;
        listener.expectedAttributeValueAddEvents = 1;
        listener.expectedAttributeValueChangeEvents = 1;
        getMOINConnection( ).getCommandStack( ).undo( );
        checkReceivedEvents( );
    }

    @Test
    public void testLinkAdd( ) {

        listener.expectedElementCreateEvents = 3;
        listener.expectedLinkAddEvents = 2;

        connection.getCommandStack( ).openGroup( "Test" );
        MofPackage mofPackage = (MofPackage) mofModelPackage.getMofPackage( ).refCreateInstance( );
        MofClass mofClass = (MofClass) mofModelPackage.getMofClass( ).refCreateInstance( );
        Attribute attr = (Attribute) mofModelPackage.getAttribute( ).refCreateInstance( );
        attr.setContainer( mofClass );
        mofClass.setContainer( mofPackage );

        connection.getCommandStack( ).closeGroup( );
        checkReceivedEvents( );

        listener.expectedElementDeleteEvents = 3;
        listener.expectedLinkRemoveEvents = 2;
        getMOINConnection( ).getCommandStack( ).undo( );
        checkReceivedEvents( );
    }

    @Test
    public void testLinkRemove( ) {

        listener.expectedElementCreateEvents = 3;
        listener.expectedLinkAddEvents = 2;
        listener.expectedLinkRemoveEvents = 1;

        connection.getCommandStack( ).openGroup( "Test" );
        MofPackage mofPackage = (MofPackage) mofModelPackage.getMofPackage( ).refCreateInstance( );
        MofClass mofClass = (MofClass) mofModelPackage.getMofClass( ).refCreateInstance( );
        Attribute attr = (Attribute) mofModelPackage.getAttribute( ).refCreateInstance( );
        attr.setContainer( mofClass );
        mofClass.setContainer( mofPackage );
        attr.setContainer( null );

        connection.getCommandStack( ).closeGroup( );
        checkReceivedEvents( );

        listener.expectedElementDeleteEvents = 3;
        listener.expectedLinkRemoveEvents = 2;
        listener.expectedLinkAddEvents = 1;
        getMOINConnection( ).getCommandStack( ).undo( );
        checkReceivedEvents( );
    }

    @Test
    public void testPartitionAssignment( ) {

        listener.expectedElementCreateEvents = 3;
        listener.expectedPartitionMembershipChangeEvents = 1;

        connection.getCommandStack( ).openGroup( "Test" );
        MofPackage mofPackage = (MofPackage) mofModelPackage.getMofPackage( ).refCreateInstance( );
        MofClass mofClass = (MofClass) mofModelPackage.getMofClass( ).refCreateInstance( );
        Attribute attr = (Attribute) mofModelPackage.getAttribute( ).refCreateInstance( );
        getPartitionOne( ).assignElement( mofPackage );

        connection.getCommandStack( ).closeGroup( );
        checkReceivedEvents( );

        listener.expectedElementDeleteEvents = 3;
        listener.expectedPartitionMembershipChangeEvents = 1;
        getMOINConnection( ).getCommandStack( ).undo( );
        checkReceivedEvents( );
    }

    @Test
    public void testCreatePartition( ) {

        listener.expectedPartitionCreateEvents = 1;

        connection.getCommandStack( ).openGroup( "Test" );
        this._testClient1.getOrCreatePartition( "testCreatePartition" + System.currentTimeMillis( ) );

        connection.getCommandStack( ).closeGroup( );
        checkReceivedEvents( );

        listener.expectedPartitionDeleteEvents = 1;
        getMOINConnection( ).getCommandStack( ).undo( );
        checkReceivedEvents( );
    }

    @Test
    public void testDeletePartition( ) {

        listener.expectedPartitionDeleteEvents = 1;

        connection.getCommandStack( ).openGroup( "Test" );
        getPartitionOne( ).delete( );
        connection.getCommandStack( ).closeGroup( );
        checkReceivedEvents( );

        listener.expectedPartitionCreateEvents = 1;
        getMOINConnection( ).getCommandStack( ).undo( );
        checkReceivedEvents( );
    }

    @Test
    public void testUndoRegistration( ) {

        CoreEventRegistry eventRegistry = (CoreEventRegistry) ( (Wrapper) getMOINConnection( ).getSession( ).getEventRegistry( ) ).unwrap( );

        // Register event
        getMOINConnection( ).getEventRegistry( ).registerListener( new TestChangeListener( ), new EventTypeFilter( ChangeEvent.class ) );
        int changeListenerCount = eventRegistry.getChangeNotifiers( ).size( );

        // Perform undo and check listener count
        getMOINConnection( ).getCommandStack( ).undo( );
        int changeListenerCountAfterUndo = eventRegistry.getChangeNotifiers( ).size( );
        assertEquals( changeListenerCount, changeListenerCountAfterUndo + 1 );

        // Perform redo and check listener count
        getMOINConnection( ).getCommandStack( ).redo( );
        int changeListenerCountAfterRedo = eventRegistry.getChangeNotifiers( ).size( );
        assertEquals( changeListenerCount, changeListenerCountAfterRedo );
    }

    @Test
    public void testUndoDeregistration( ) {

        CoreEventRegistry eventRegistry = (CoreEventRegistry) ( (Wrapper) getMOINConnection( ).getSession( ).getEventRegistry( ) ).unwrap( );

        // Register event
        TestChangeListener testChangeListener = new TestChangeListener( );
        getMOINConnection( ).getEventRegistry( ).registerListener( testChangeListener, new EventTypeFilter( ChangeEvent.class ) );
        int changeListenerCountBeforeDeregister = eventRegistry.getChangeNotifiers( ).size( );

        getMOINConnection( ).getEventRegistry( ).deregister( testChangeListener );
        int changeListenerCountAfterDeregister = eventRegistry.getChangeNotifiers( ).size( );

        assertEquals( changeListenerCountBeforeDeregister - 1, changeListenerCountAfterDeregister );

        // Undo the deregistration
        getMOINConnection( ).getCommandStack( ).undo( );
        int changeListenerCountAfterUndoOfDeregister = eventRegistry.getChangeNotifiers( ).size( );
        assertEquals( changeListenerCountBeforeDeregister, changeListenerCountAfterUndoOfDeregister );
    }

    @Test
    public void testRollbackRegistration( ) {

        final CoreEventRegistry eventRegistry = (CoreEventRegistry) ( (Wrapper) getMOINConnection( ).getSession( ).getEventRegistry( ) ).unwrap( );
        final int changeListenerCount = eventRegistry.getChangeNotifiers( ).size( );

        Command cmd = new Command( connection ) {

            @Override
            public boolean canExecute( ) {

                return true;
            }

            @Override
            public void doExecute( ) {

                getMOINConnection( ).getEventRegistry( ).registerListener( new TestChangeListener( ), new EventTypeFilter( ChangeEvent.class ) );
                int changeListenerCountAfterRegistration = eventRegistry.getChangeNotifiers( ).size( );
                assertEquals( changeListenerCount + 1, changeListenerCountAfterRegistration );

                throw new RuntimeException( );
            }

            @Override
            public Collection<PartitionOperation> getAffectedPartitions( ) {

                return null;
            }

        };

        try {
            cmd.execute( );
            fail( "Exception Expected during command execution" );
        } catch ( RuntimeException e ) {
            int changeListenerCountAfterRollback = eventRegistry.getChangeNotifiers( ).size( );
            assertEquals( changeListenerCount, changeListenerCountAfterRollback );
        }
    }

    @Test
    public void testRollbackDeregistration( ) {

        final CoreEventRegistry eventRegistry = (CoreEventRegistry) ( (Wrapper) getMOINConnection( ).getSession( ).getEventRegistry( ) ).unwrap( );
        final int changeListenerCount = eventRegistry.getChangeNotifiers( ).size( );
        final TestChangeListener testChangeListener = new TestChangeListener( );
        getMOINConnection( ).getEventRegistry( ).registerListener( testChangeListener, new EventTypeFilter( ChangeEvent.class ) );
        int changeListenerCountAfterRegistration = eventRegistry.getChangeNotifiers( ).size( );
        assertEquals( changeListenerCount + 1, changeListenerCountAfterRegistration );

        Command cmd = new Command( connection ) {

            @Override
            public boolean canExecute( ) {

                return true;
            }

            @Override
            public void doExecute( ) {

                getMOINConnection( ).getEventRegistry( ).deregister( testChangeListener );
                int changeListenerCountAfterDeregistration = eventRegistry.getChangeNotifiers( ).size( );
                assertEquals( changeListenerCount, changeListenerCountAfterDeregistration );
                throw new RuntimeException( );
            }

            @Override
            public Collection<PartitionOperation> getAffectedPartitions( ) {

                return null;
            }

        };

        try {
            cmd.execute( );
            fail( "Exception Expected during command execution" );
        } catch ( RuntimeException e ) {
            int changeListenerCountAfterRollback = eventRegistry.getChangeNotifiers( ).size( );
            assertEquals( changeListenerCountAfterRegistration, changeListenerCountAfterRollback );
        }
    }
}
