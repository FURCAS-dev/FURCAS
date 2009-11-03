package com.sap.tc.moin.repository.test.core;

import java.util.Arrays;
import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.junit.Test;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.cdam.CompoundClientSpec;
import com.sap.tc.moin.repository.cdam.CompoundDataAreaManager;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.testcases.case004.A4;
import com.sap.tc.moin.testcases.case004.B4;

/**
 * Generic persistence test. Current tests:
 * <p>
 * Primitive attribute with null-value.
 * <p>
 * 
 * @author d026715
 */
public class TestTransientDataArea extends CoreMoinTest {

    static boolean EVENTS_CHECK = true;

    private Connection transientConnection;

    private Connection getTransientConnection( ) {

        if ( transientConnection == null ) {
            Moin moin = this.getTestHelper( ).getMoin( );
            CompoundDataAreaManager cdam = moin.getCompoundDataAreaManager( );
            CompoundClientSpec compoundClientSpec = cdam.getCompoundClientSpecTransientOnly( );

            Session session = moin.createSession( compoundClientSpec );
            transientConnection = session.createConnection( );
        }
        return transientConnection;
    }

    protected A4 createA4( ) {

        A4 a4 = getTransientConnection( ).createElementInPartition( A4.class, null );
        a4.setOnePrimitive( "initial" ); // onePrimitive
        a4.setOnePrimitiveNotChangeable( "initial" ); // onePrimitiveNotChangeable
        a4.getManyPrimitive( ).addAll( Arrays.asList( new String[] { "initial0", "initial1", "initial2", "initial3", "initial4" } ) ); // manyPrimitive
        a4.getManyPrimitiveUnique( ).addAll( Arrays.asList( new String[] { "initial0", "initial1", "initial2", "initial3", "initial4" } ) ); // manyPrimitiveUnique
        a4.getManyPrimitiveNotChangeable( ).addAll( Arrays.asList( new String[] { "initial0", "initial1", "initial2", "initial3", "initial4" } ) ); // manyPrimitiveNotChangeable
        a4.getManyPrimitiveOrdered( ).addAll( Arrays.asList( new String[] { "initial0", "initial1", "initial2", "initial3", "initial4" } ) ); // manyPrimitiveOrdered
        a4.getManyPrimitiveOrderedUnique( ).addAll( Arrays.asList( new String[] { "initial0", "initial1", "initial2", "initial3", "initial4" } ) ); // manyPrimitiveOrderedUnique
        a4.setOneBchangeable( getTransientConnection( ).createElementInPartition( B4.class, null ) ); // oneBChangeable
        a4.getManyBs( ).addAll( Arrays.asList( createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ) ) ); // manyBs
        a4.getManyBs( ).addAll( Arrays.asList( createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ) ) ); // manyBsUnique
        a4.getManyBsOrdered( ).addAll( Arrays.asList( createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ) ) ); // manyBsOrdered
        a4.getManyBsOrderedUnique( ).addAll( Arrays.asList( createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ) ) ); // manyBsOrderedUnique
        return a4;
    }

    private B4 createB4( String value ) {

        B4 b4 = getTransientConnection( ).createElementInPartition( B4.class, null );
        b4.setOnePrimitive( value );
        return b4;
    }

    @Test
    public void testTransientDataArea( ) throws Exception {

        Connection transientConnection = this.getTransientConnection( );

        // change single-valued attributes
        A4 a4 = createA4( );

        MRI mri = ( (Partitionable) a4 ).get___Mri( );

        RefBaseObject element = transientConnection.getElement( mri );

        verify( element != null, "Element not found." );

        ( (RefObject) element ).refDelete( );

        RefBaseObject elementAgain = transientConnection.getElement( mri );

        verify( elementAgain == null, "Element not found." );

        transientConnection.close( );

    }

    @Test
    public void testTransientDataAreaWithCommand( ) throws Exception {

        final Connection transientConnection = this.getTransientConnection( );

        MyCommand commandCreate = new MyCommand( transientConnection, null ) {

            @Override
            public void doExecute( ) {

                ModelPartition mp = this.getConnection( ).getOrCreateTransientPartition( "A4" );
                A4 a4 = createA4( );

                for ( Partitionable element : this.getConnection( ).getNullPartition( ).getElements( ) ) {
                    mp.assignElement( element );
                }
                mri = ( (Partitionable) a4 ).get___Mri( );
            }

            @Override
            public boolean canExecute( ) {

                return true;
            }

        };

        transientConnection.getCommandStack( ).execute( commandCreate );

        final MRI mri = commandCreate.getMri( );

        Command commandDelete = new MyCommand( transientConnection, mri ) {

            @Override
            public void doExecute( ) {

                RefObject element = (RefObject) transientConnection.getElement( mri );
                element.refDelete( );
            }

            @Override
            public boolean canExecute( ) {

                return true;
            }

        };

        RefBaseObject elementCreated = transientConnection.getElement( mri );

        transientConnection.getCommandStack( ).execute( commandDelete );

        RefBaseObject elementDeleted = transientConnection.getElement( mri );

        transientConnection.getCommandStack( ).undo( );

        RefBaseObject elementUndo = transientConnection.getElement( mri );

        verify( elementCreated != null, "Element not found." );

        verify( elementDeleted == null, "Deleted element found." );

        verify( elementUndo != null, "Element not found." );

        transientConnection.close( );

    }

    abstract class MyCommand extends Command {

        protected MRI mri;

        protected MyCommand( Connection connection, MRI aMri ) {

            super( connection );
            mri = aMri;
        }

        public MRI getMri( ) {

            return mri;
        }

        @Override
        public Collection<PartitionOperation> getAffectedPartitions( ) {

            if ( mri != null ) {
                PartitionOperation[] operations = new PartitionOperation[] { new PartitionOperation( PartitionOperation.Operation.EDIT, mri.getPri( ) ) };
                return Arrays.asList( operations );
            }
            return null;
        }

    }
}
