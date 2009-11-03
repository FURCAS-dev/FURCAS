package com.sap.tc.moin.repository.test.transactions.microtransactionables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.CompositionCycleException;
import com.sap.tc.moin.repository.mmi.reflect.InvalidCallException;
import com.sap.tc.moin.repository.mmi.reflect.TypeMismatchException;
import com.sap.tc.moin.repository.mmi.reflect.WrongSizeException;

import org.junit.Test;

import com.sap.tc.moin.repository.core.events.PartitionMembershipChangeEventImpl;
import com.sap.tc.moin.repository.events.type.PartitionMembershipChangeEvent;
import com.sap.tc.moin.testcases.case006.B6;
import com.sap.tc.moin.testcases.case006.C6;
import com.sap.tc.moin.testcases.case006.D6;
import com.sap.tc.moin.testcases.case010.A10;
import com.sap.tc.moin.testcases.case010.B10;
import com.sap.tc.moin.testcases.case017.A17;
import com.sap.tc.moin.testcases.case020.A20;
import com.sap.tc.moin.testcases.case020.ChildInheritsMultiple1;

@SuppressWarnings( "nls" )
public class TestMicroTransactionablesReferences extends BaseMicroTransactionablesFeatureChangeTest {

    @Test
    public void testSingleReferenceChange( ) {

        List<PartitionMembershipChangeEvent> expectedPMCDoEvents = new ArrayList<PartitionMembershipChangeEvent>( );
        List<PartitionMembershipChangeEvent> expectedPMCUnDoEvents = new ArrayList<PartitionMembershipChangeEvent>( );
        // change single-valued references
        A10 a10_1 = createA10( );
        A10 a10_2 = createA10( );
        B10 b10 = createB10( );
        A20 a20 = (A20) case020Package.getA20( ).refCreateInstance( );
        // B10.oneAChangeable: change
        featureChange( b10, "oneAChangeable", a10Class.refCreateInstance( ) );
        featureChange( b10, "oneAChangeable", a10Class.refCreateInstance( ) );
        b10 = createB10( );
        // B10.oneAChangeable: change reference to null, this IS possible
        // according
        // MOIN JMI enhancement MJE-01
        featureChange( b10, "oneAChangeable", a10Class.refCreateInstance( ) );
        featureChange( b10, "oneAChangeable", null );
        featureChange( b10, "oneAChangeable", null );
        // B10.oneAChangeable: change to type incompatible
        try {
            featureChange( b10, "oneAChangeable", new Boolean( true ) );
            errorAndStop( "Tried to set a type incompatible value to the reference, should have thrown a TypeMismatchException" );
        } catch ( TypeMismatchException typeMismatchEx ) {
            // type incompatibility
        }
        featureChange( b10, "oneANotChangeable", a10Class.refCreateInstance( ) );
        // A10.navigable: set a new navigable to a B10 which is already
        // associated
        // with another A10
        B10 navigable = a10_2.getNavigable( );
        try {
            a10_1.setNavigable( navigable );
        } catch ( WrongSizeException wrongSizeEx ) {
            // wrong size
        }
        // A20.refSuper1 and A20.refSuper2: References to classes, Super1 and
        // Super2, that have a common child, ChildInheritsMultiple1
        // set an instance of that child to both references
        ChildInheritsMultiple1 child = getMOINConnection( ).createElementInPartition( ChildInheritsMultiple1.class, null );
        featureChange( a20, "refSuper1", child );
        featureChange( a20, "refSuper2", child );
        // C6.W, Association ReferenceAtComposite, End W: storage on composite end side
        C6 c6 = createC6( getPartitionOne( ) );
        D6 w = createD6( getPartitionOne( ) );
        D6 wOld = c6.getW( );
        expectedPMCDoEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, c6.getW( ), getPartitionOne( ), nullPartition ) );
        expectedPMCUnDoEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, c6.getW( ), nullPartition, getPartitionOne( ) ) );

        assertEquals( getPartitionOne( ), wOld.get___Partition( ) );

        //FIXME: partition magic: enable once the issue is fixed in ReferenceChangeMicroTransactionable
        //featureChange( c6, "W", w, expectedPMCDoEvents, expectedPMCUnDoEvents );
        //assertEquals( nullPartition, wOld.get___Partition( ) );

        expectedPMCDoEvents.clear( );
        expectedPMCUnDoEvents.clear( );
        // C6.X, Association ReferenceAtComponent, End X: storage on component end side, no repartitioning takes place
        c6 = createC6( getPartitionOne( ) );
        B6 x = createB6( getPartitionOne( ) );
        featureChange( c6, "X", x );
    }

    @Test
    public void testMultiReferenceChange( ) {

        // change multi-valued references as a whole
        A10 a10 = createA10( );
        // manyBsChangeable: change
        try {
            featureChange( a10, "manyBsChangeable", Arrays.asList( b10Class.refCreateInstance( ) ) );
            errorAndStop( "Multi-valued reference changed as a whole, should have thrown an InvalidCallException" );
        } catch ( InvalidCallException invalidCallEx ) {
            // multi-valued reference can not be set as a whole
        }
        try {
            featureChange( a10, "manyBsChangeable", null );
            errorAndStop( "Multi-valued reference changed as a whole, should have thrown an InvalidCallException" );
        } catch ( InvalidCallException invalidCallEx ) {
            // multi-valued reference can not be set as a whole
        }
    }

    @Test
    public void testMultiReferenceElementAdd( ) {

        // add elements to multi-valued references
        A10 a10 = createA10( );
        A17 a17 = createA17( );
        //
        // simple add
        //
        // manyBsChangeable: add
        featureAdd( a10, "manyBsChangeable", b10Class.refCreateInstance( ) );
        a10 = createA10( );
        try {
            featureAdd( a10, "manyBsChangeable", new Boolean( true ) );
            errorAndStop( "Tried to add a type incompatible element to the attribute, should have thrown a TypeMismatchException" );
        } catch ( TypeMismatchException typeMismatchEx ) {
            // type incompatibility
        }
        try {
            featureAdd( a10, "manyBsChangeable", null );
            errorAndStop( "Tried to add a null element, should have thrown a NullPointerException" );
        } catch ( NullPointerException nullPointerEx ) {
            // null pointer
        }
        // manyBsNotChangeable: change not changeable
        try {
            featureAdd( a10, "manyBsNotChangeable", b10Class.refCreateInstance( ) );
            errorAndStop( "Tried to change a non-changeable reference, should have thrown an InvalidCallException" );
        } catch ( InvalidCallException invalidCallEx ) {
            // non-changeable association ends can not be changed
        }
        // manyBsOrdered: add
        featureAdd( a10, "manyBsOrdered", b10Class.refCreateInstance( ) );
        a10 = createA10( );
        // manyBsOrdered: add at index 2
        featureAdd( a10, "manyBsOrdered", 2, b10Class.refCreateInstance( ) );
        a10 = createA10( );
        //
        // add all
        //
        // manyBsChangeable: add all
        featureAddAll( a10, "manyBsChangeable", Arrays.<Object> asList( b10Class.refCreateInstance( ), b10Class.refCreateInstance( ) ) );
        a10 = createA10( );
        // manyBsOrdered: add all at index 2
        featureAddAll( a10, "manyBsOrdered", 2, Arrays.asList( b10Class.refCreateInstance( ), b10Class.refCreateInstance( ) ) );
        a10 = createA10( );
        // toEnd: add another instance of the same class to a composite end, no
        // composition cycle
        A17 a17_other = createA17( );
        featureAdd( a17, "toEnd", a17_other );
        a17 = createA17( );
        // toEnd: add the same instance to a composite end, composition cycle
        try {
            featureAdd( a17, "toEnd", a17 );
            errorAndStop( "Tried to add a component to itself, should have thrown a CompositionCycleException" );
        } catch ( CompositionCycleException compositionCycleEx ) {
            // composition cycle
        }
    }

    @Test
    public void testMultiReferenceElementRemove( ) {

        // remove elements of multi-valued references
        A10 a10 = createA10( );
        //
        // simple remove
        //
        // manyBsChangeable: remove
        B10 remove = a10.getManyBsChangeable( ).iterator( ).next( );
        featureRemove( a10, "manyBsChangeable", remove );
        a10 = createA10( );
        // manyBsOrdered: remove
        remove = a10.getManyBsOrdered( ).get( 2 );
        featureRemove( a10, "manyBsOrdered", remove );
        a10 = createA10( );
        // manyBsOrdered: remove from index 2
        featureRemove( a10, "manyBsOrdered", 2 );
        a10 = createA10( );
        // manyBs: remove non-existent
        featureRemove( a10, "manyBsChangeable", b10Class.refCreateInstance( ) );
        a10 = createA10( );
        // manyBsOrdered: remove from non-existent index
        try {
            featureRemove( a10, "manyBsOrdered", 42 );
            errorAndStop( "Tried to remove an element at an index that is too big, should have thrown an IndexOutOfBoundsException " );
        } catch ( IndexOutOfBoundsException e ) {
            // wrong index
        }
        //
        // remove all
        //
        // manyBsChangeable: remove all
        Collection<B10> manyBsChangeable = a10.getManyBsChangeable( );
        Iterator<B10> iter = manyBsChangeable.iterator( );
        iter.next( );
        B10 initial1 = iter.next( );
        iter.next( );
        B10 initial3 = iter.next( );
        featureRemoveAll( a10, "manyBsChangeable", Arrays.asList( initial1, initial3 ) );
        a10 = createA10( );
        // manyBsOrdered: remove all
        List<B10> manyBsOrdered = a10.getManyBsOrdered( );
        featureRemoveAll( a10, "manyBsOrdered", Arrays.asList( manyBsOrdered.get( 0 ), manyBsOrdered.get( 1 ), manyBsOrdered.get( manyBsOrdered.size( ) - 1 ) ) );
        //
        // retain all
        //
        // manyBsChangeable: retain all
        manyBsChangeable = a10.getManyBsChangeable( );
        iter = manyBsChangeable.iterator( );
        iter.next( );
        initial1 = iter.next( );
        iter.next( );
        initial3 = iter.next( );
        featureRetainAll( a10, "manyBsChangeable", Arrays.asList( initial1, initial3 ) );
        a10 = createA10( );
        //
        // clear
        //
        // manyBs: clear
        featureClear( a10, "manyBsChangeable" );
        a10 = createA10( );
        // TODO
        // at removeAll and retainAll the logic in the JMI List Iterator Itr is
        // used, try to move that logic into the new TA framework
        // but clear does not go over that iterator, why?
    }

    @Test
    public void testMultiReferenceElementSet( ) {

        // set elements of multi-valued references
        A10 a10 = createA10( );
        // manyBsOrdered: set at index 2
        featureSet( a10, "manyBsOrdered", 2, b10Class.refCreateInstance( ) );
        a10 = createA10( );
        // manyBsOrdered: set type incompatible
        try {
            featureSet( a10, "manyBsOrdered", 2, new Boolean( true ) );
            errorAndStop( "Tried to set a type incompatible value to the element, should have thrown a TypeMismatchException" );
        } catch ( TypeMismatchException typeMismatchEx ) {
            // type incompatibility
        }
        // manyBsOrdered: set to null
        try {
            featureSet( a10, "manyBsOrdered", 2, null );
            errorAndStop( "Tried to set an element to null, should have thrown a NullPointerException" );
        } catch ( NullPointerException nullPointerEx ) {
            // null pointer
        }
    }
}
