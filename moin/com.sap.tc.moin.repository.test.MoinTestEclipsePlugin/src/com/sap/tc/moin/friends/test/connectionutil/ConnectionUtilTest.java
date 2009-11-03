package com.sap.tc.moin.friends.test.connectionutil;

import java.util.Collection;
import java.util.Collections;

import com.sap.tc.moin.repository.mmi.model.MofClass;

import org.junit.Test;

import com.sap.tc.moin.friends.CommandStackObserver;
import com.sap.tc.moin.friends.ConnectionUtil;
import com.sap.tc.moin.friends.factory.UtilitiesFactory;
import com.sap.tc.moin.friends.test.MoinFriendsBaseTest;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.CommandHandle;
import com.sap.tc.moin.repository.commands.PartitionOperation;


public class ConnectionUtilTest extends MoinFriendsBaseTest {

    @Test
    public void testCommandStackObserver( ) {

        ConnectionUtil connectionUtil = UtilitiesFactory.getConnectionUtil( );
        TestCommandStackListener stackListener = new TestCommandStackListener( );
        connectionUtil.setCommandStackObserver( getMOINConnection( ), stackListener );

        Command cmd = new Command( getMOINConnection( ) ) {

            @Override
            public boolean canExecute( ) {

                return true;
            }

            @Override
            public void doExecute( ) {

                getMOINConnection( ).createElementInPartition( MofClass.class, null );
            }

            @Override
            public Collection<PartitionOperation> getAffectedPartitions( ) {

                return null;
            }

        };

        cmd.execute( );

        assertEquals( stackListener.notifyCount, 2 );
    }

    private class TestCommandStackListener implements CommandStackObserver {

        public int notifyCount;

        public Collection<Connection> getConnectionsToBeSaved( Command cmd, Collection<PartitionOperation> affectedPartitions ) {

            return Collections.emptyList( );
        }

        public void notifyBeforeRootCommandExecution( Command cmd, Collection<PartitionOperation> affectedPartitions ) {

            notifyCount++;
        }

        public void notifyTopLevelCommandExecuted( CommandHandle cmdHnd, Connection con ) {

            notifyCount++;
        }

        public void notifyTopLevelCommandRedone( CommandHandle cmdHnd, Connection con ) {

            notifyCount++;
        }

        public void notifyTopLevelCommandUndone( CommandHandle cmdHnd, Connection con ) {

            notifyCount++;
        }

        public void notifyTopLevelStacksCleared( Connection con ) {

            notifyCount++;
        }
    }

}
