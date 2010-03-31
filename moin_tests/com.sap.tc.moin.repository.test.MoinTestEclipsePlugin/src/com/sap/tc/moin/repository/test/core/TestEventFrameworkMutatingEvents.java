package com.sap.tc.moin.repository.test.core;

import com.sap.tc.moin.repository.mmi.model.MofClass;

import org.junit.Test;

import com.sap.tc.moin.repository.events.CommitListener;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.filter.EventTypeFilter;
import com.sap.tc.moin.repository.events.type.AttributeValueChangeEvent;
import com.sap.tc.moin.repository.events.type.ChangeEvent;

public class TestEventFrameworkMutatingEvents extends EventFrameworkTest {

    @Test
    public void testMutatingCommitListener( ) {

        CommitListener listener = new MutatingCommitListener( );
        getMOINConnection( ).getSession( ).getEventRegistry( ).registerCommitListener( listener, new EventTypeFilter( AttributeValueChangeEvent.class ) );
        MofClass mofClass = getMOINConnection( ).createElementInPartition( MofClass.class, null );
        mofClass.setName( "NewName" );

        // Check if the event listener has changed the Annotation to the same value as the name
        assertEquals( mofClass.getName( ), mofClass.getAnnotation( ) );

        getMOINConnection( ).getSession( ).getEventRegistry( ).deregister( listener );

        getMOINConnection( ).getCommandStack( ).undo( );
        assertEquals( mofClass.getName( ), "NewName" );
        assertNull( mofClass.getAnnotation( ) );

        getMOINConnection( ).getCommandStack( ).undo( );
        assertNull( mofClass.getName( ) );
        assertNull( mofClass.getAnnotation( ) );


    }

    @Test
    public void testMutatingCommitListenerInCommandGroup( ) {

        CommitListener listener = new MutatingCommitListener( );
        getMOINConnection( ).getSession( ).getEventRegistry( ).registerCommitListener( listener, new EventTypeFilter( AttributeValueChangeEvent.class ) );
        MofClass mofClass = getMOINConnection( ).createElementInPartition( MofClass.class, null );

        getMOINConnection( ).getCommandStack( ).openGroup( "Test" );
        mofClass.setName( "NewName" );
        getMOINConnection( ).getCommandStack( ).closeGroup( );

        // Check if the event listener has changed the Annotation to the same value as the name
        assertEquals( mofClass.getName( ), mofClass.getAnnotation( ) );

        getMOINConnection( ).getSession( ).getEventRegistry( ).deregister( listener );

        // due to the command group, the undo should both revert the "name" and the "annotation"
        getMOINConnection( ).getCommandStack( ).undo( );
        assertNull( mofClass.getName( ) );
        assertNull( mofClass.getAnnotation( ) );


    }

    private class MutatingCommitListener implements CommitListener {

        public void notifyCommit( EventChain events ) {

            for ( ChangeEvent event : events.getEvents( ) ) {
                AttributeValueChangeEvent attrEvent = (AttributeValueChangeEvent) event;
                MofClass changedClass = (MofClass) attrEvent.getAffectedElement( getMOINConnection( ) );
                if ( !changedClass.getName( ).equals( changedClass.getAnnotation( ) ) ) {
                    changedClass.setAnnotation( changedClass.getName( ) );
                }
            }
        }
    }
}
