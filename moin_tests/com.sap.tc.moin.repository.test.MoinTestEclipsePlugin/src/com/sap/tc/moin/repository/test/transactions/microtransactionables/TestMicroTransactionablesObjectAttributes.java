package com.sap.tc.moin.repository.test.transactions.microtransactionables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import com.sap.tc.moin.repository.mmi.reflect.CompositionViolationException;
import com.sap.tc.moin.repository.mmi.reflect.DuplicateException;
import com.sap.tc.moin.repository.mmi.reflect.InvalidCallException;
import com.sap.tc.moin.repository.mmi.reflect.TypeMismatchException;

import org.junit.Test;

import com.sap.tc.moin.repository.core.events.PartitionMembershipChangeEventImpl;
import com.sap.tc.moin.repository.events.type.PartitionMembershipChangeEvent;
import com.sap.tc.moin.testcases.case004.A4;
import com.sap.tc.moin.testcases.case004.B4;

@SuppressWarnings( "nls" )
public class TestMicroTransactionablesObjectAttributes extends BaseMicroTransactionablesFeatureChangeTest {

    @Test
    public void testSingleObjectAttributeChange( ) throws Exception {

        List<PartitionMembershipChangeEvent> expectedPMCDoEvents = new ArrayList<PartitionMembershipChangeEvent>( );
        List<PartitionMembershipChangeEvent> expectedPMCUnDoEvents = new ArrayList<PartitionMembershipChangeEvent>( );
        // change single-valued attributes
        // oneBChangeable: change
        A4 a4 = createA4( );
        featureChange( a4, "oneBChangeable", b4Class.refCreateInstance( ) );
        a4 = createA4( );
        // oneBChangeable: change a value in a different partition, the partition is not dirty
        nullPartition.deleteElements( );
        a4 = createA4( );
        getPartitionOne( ).assignElementIncludingChildren( a4 );
        getMOINConnection( ).save( );
        B4 change = getMOINConnection( ).createElementInPartition( B4.class, nullPartition );
        expectedPMCDoEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, change, nullPartition, getPartitionOne( ) ) );
        expectedPMCDoEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, a4.getOneBchangeable( ), getPartitionOne( ), nullPartition ) );
        expectedPMCUnDoEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, change, getPartitionOne( ), nullPartition ) );
        expectedPMCUnDoEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, a4.getOneBchangeable( ), nullPartition, getPartitionOne( ) ) );
        featureChange( a4, "oneBChangeable", change, expectedPMCDoEvents, expectedPMCUnDoEvents );
        a4 = createA4( );
        expectedPMCDoEvents.clear( );
        expectedPMCUnDoEvents.clear( );
        // oneBChangeable: change a value in a different partition
        getPartitionOne( ).assignElementIncludingChildren( a4 );
        change = getMOINConnection( ).createElementInPartition( B4.class, nullPartition );
        expectedPMCDoEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, change, nullPartition, getPartitionOne( ) ) );
        expectedPMCDoEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, a4.getOneBchangeable( ), getPartitionOne( ), nullPartition ) );
        expectedPMCUnDoEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, change, getPartitionOne( ), nullPartition ) );
        expectedPMCUnDoEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, a4.getOneBchangeable( ), nullPartition, getPartitionOne( ) ) );
        featureChange( a4, "oneBChangeable", change, expectedPMCDoEvents, expectedPMCUnDoEvents );
        a4 = createA4( );
        expectedPMCDoEvents.clear( );
        expectedPMCUnDoEvents.clear( );
        // oneBChangeable: change a value where only the parent is in a
        // different partition, the old child is in the same partition as the new one
        getPartitionOne( ).assignElement( a4 );
        change = getMOINConnection( ).createElementInPartition( B4.class, nullPartition );
        expectedPMCDoEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, change, nullPartition, getPartitionOne( ) ) );
        expectedPMCUnDoEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, change, getPartitionOne( ), nullPartition ) );
        featureChange( a4, "oneBChangeable", change, expectedPMCDoEvents, expectedPMCUnDoEvents );
        a4 = createA4( );
        expectedPMCDoEvents.clear( );
        expectedPMCUnDoEvents.clear( );
        // oneBChangeable: try to change to a value that is already set as attribute of another parent instance
        A4 a4_2 = createA4( );
        try {
            featureChange( a4, "oneBChangeable", a4_2.getOneBchangeable( ) );
            errorAndStop( "Tried to set a second parent to an attribute, should have thrown a CompositionViolationException" );
        } catch ( CompositionViolationException compositionViolationEx ) {
            // composition violation
        }
        // oneBChangeable: change non-optional attribute to null, this IS
        // possible because the underflow constraint is deferred in JMI
        featureChange( a4, "oneBChangeable", null );
        // oneBChangeable: change to type incompatible
        try {
            featureChange( a4, "oneBChangeable", new Boolean( true ) );
            errorAndStop( "Tried to set a type incompatible value to the attribute, should have thrown a TypeMismatchException" );
        } catch ( TypeMismatchException typeMismatchEx ) {
            // type incompatibility
        }
        featureChange( a4, "oneBNotChangeable", getMOINConnection( ).createElementInPartition( B4.class, null ) );
        a4 = createA4( );
        // oneBOptional: change
        change = getMOINConnection( ).createElementInPartition( B4.class, null );
        featureChange( a4, "oneBOptional", change );
        featureChange( a4, "oneBOptional", null );
        featureChange( a4, "oneBOptional", null );
        featureChange( a4, "oneBOptional", change );
        featureChange( a4, "oneBOptional", change );
        a4 = createA4( );
        // oneBOptional: change where the parent is in the same partition
        getPartitionOne( ).assignElementIncludingChildren( a4 );
        change = getMOINConnection( ).createElementInPartition( B4.class, getPartitionOne( ) );
        expectedPMCDoEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, a4.getOneBoptional( ), getPartitionOne( ), nullPartition ) );
        expectedPMCUnDoEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, a4.getOneBoptional( ), nullPartition, getPartitionOne( ) ) );
        featureChange( a4, "oneBOptional", change, expectedPMCDoEvents, expectedPMCUnDoEvents );
        a4 = createA4( );
        expectedPMCDoEvents.clear( );
        expectedPMCUnDoEvents.clear( );
        // oneBOptional: change where the parent is in a different partition
        getPartitionOne( ).assignElementIncludingChildren( a4 );
        change = getMOINConnection( ).createElementInPartition( B4.class, nullPartition );
        expectedPMCDoEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, change, nullPartition, getPartitionOne( ) ) );
        expectedPMCDoEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, a4.getOneBoptional( ), getPartitionOne( ), nullPartition ) );
        expectedPMCUnDoEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, change, getPartitionOne( ), nullPartition ) );
        expectedPMCUnDoEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, a4.getOneBoptional( ), nullPartition, getPartitionOne( ) ) );
        featureChange( a4, "oneBOptional", change, expectedPMCDoEvents, expectedPMCUnDoEvents );
        expectedPMCDoEvents.clear( );
        expectedPMCUnDoEvents.clear( );
        expectedPMCDoEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, a4.getOneBoptional( ), getPartitionOne( ), nullPartition ) );
        expectedPMCUnDoEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, a4.getOneBoptional( ), nullPartition, getPartitionOne( ) ) );
        featureChange( a4, "oneBOptional", null, expectedPMCDoEvents, expectedPMCUnDoEvents );
        expectedPMCDoEvents.clear( );
        expectedPMCUnDoEvents.clear( );
        featureChange( a4, "oneBOptional", null );
        expectedPMCDoEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, change, nullPartition, getPartitionOne( ) ) );
        expectedPMCUnDoEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, change, getPartitionOne( ), nullPartition ) );
        featureChange( a4, "oneBOptional", change, expectedPMCDoEvents, expectedPMCUnDoEvents );
        expectedPMCDoEvents.clear( );
        expectedPMCUnDoEvents.clear( );
        featureChange( a4, "oneBOptional", change );
        a4 = createA4( );
    }

    @Test
    public void testMultiObjectAttributeChange( ) {

        // change multi-valued attributes as a whole
        A4 a4 = createA4( );
        // manyBs
        try {
            featureChange( a4, "manyBs", Arrays.asList( getMOINConnection( ).createElementInPartition( B4.class, null ) ) );
            errorAndStop( "Multi-valued attribute changed as a whole, should have thrown an InvalidCallException" );
        } catch ( InvalidCallException invalidCallEx ) {
            // multi-valued attribute can not be set as a whole
        }
    }

    @Test
    public void testMultiObjectAttributeElementAdd( ) throws Exception {

        // add elements to multi-valued attributes
        A4 a4 = createA4( );
        //
        // simple add
        //
        // manyBs: add
        featureAdd( a4, "manyBs", getMOINConnection( ).createElementInPartition( B4.class, null ) );
        a4 = createA4( );
        // manyBs: add to a parent in a different partition
        getPartitionOne( ).assignElement( a4 );
        featureAdd( a4, "manyBs", getMOINConnection( ).createElementInPartition( B4.class, null ) );
        a4 = createA4( );
        // manyBs: add to a parent in a different partition, the partition is
        // not dirty
        nullPartition.deleteElements( );
        a4 = createA4( );
        getPartitionOne( ).assignElementIncludingChildren( a4 );
        getMOINConnection( ).save( );
        featureAdd( a4, "manyBs", getMOINConnection( ).createElementInPartition( B4.class, null ) );
        a4 = createA4( );
        // manyBs: add same element twice
        B4 add = getMOINConnection( ).createElementInPartition( B4.class, null );
        featureAdd( a4, "manyBs", add );
        featureAdd( a4, "manyBs", add );
        a4 = createA4( );
        // manyBs: add type incompatible
        try {
            featureAdd( a4, "manyBs", new Boolean( true ) );
            errorAndStop( "Tried to add a type incompatible element to the attribute, should have thrown a TypeMismatchException" );
        } catch ( TypeMismatchException typeMismatchEx ) {
            // type incompatibility
        }
        try {
            featureAdd( a4, "manyBs", null );
            errorAndStop( "Tried to add a null element, should have thrown a NullPointerException" );
        } catch ( NullPointerException nullPointerEx ) {
            // null pointer
        }
        // manyBsOrdered: add
        featureAdd( a4, "manyBsOrdered", getMOINConnection( ).createElementInPartition( B4.class, null ) );
        a4 = createA4( );
        // manyBsOrdered: add at index 2
        featureAdd( a4, "manyBsOrdered", 2, getMOINConnection( ).createElementInPartition( B4.class, null ) );
        a4 = createA4( );
        // manyBsOrdered: add all at index 2
        featureAddAll( a4, "manyBsOrdered", 2, Arrays.asList( getMOINConnection( ).createElementInPartition( B4.class, null ), getMOINConnection( ).createElementInPartition( B4.class, null ) ) );
        a4 = createA4( );
        // manyBsUnique: add element that is already present
        try {
            B4 present = a4.getManyBsUnique( ).iterator( ).next( );
            featureAdd( a4, "manyBsUnique", present );
            errorAndStop( "Tried to add an element that is already present in a unique attribute, should have thrown a DuplicateException" );
        } catch ( DuplicateException duplicateEx ) {
            // duplicate
        }
        featureAdd( a4, "manyBsNotChangeable", getMOINConnection( ).createElementInPartition( B4.class, null ) );
        //
        // add all
        //
        // manyBs: add all
        featureAddAll( a4, "manyBs", Arrays.<Object> asList( getMOINConnection( ).createElementInPartition( B4.class, null ), getMOINConnection( ).createElementInPartition( B4.class, null ) ) );
        a4 = createA4( );
        // manyBs: add all to a parent in a different partition
        getPartitionOne( ).assignElement( a4 );
        featureAddAll( a4, "manyBs", Arrays.<Object> asList( getMOINConnection( ).createElementInPartition( B4.class, null ), getMOINConnection( ).createElementInPartition( B4.class, null ) ) );
        a4 = createA4( );
    }

    @Test
    public void testMultiObjectAttributeElementRemove( ) {

        // remove elements from multi-valued attributes
        A4 a4 = createA4( );
        //
        // simple remove
        //
        // manyBs: remove
        B4 remove = a4.getManyBs( ).iterator( ).next( );
        featureRemove( a4, "manyBs", remove );
        a4 = createA4( );
        // manyBs: remove one occurrence of an element that is present multiple
        // times for a non-unique multi-valued attribute
        B4 add = getMOINConnection( ).createElementInPartition( B4.class, null );
        featureAdd( a4, "manyBs", add );
        featureAdd( a4, "manyBs", add );
        featureRemove( a4, "manyBs", add );
        a4 = createA4( );
        // manyBsOrdered: remove
        remove = a4.getManyBsOrdered( ).get( 2 );
        featureRemove( a4, "manyBsOrdered", remove );
        a4 = createA4( );
        // manyBsOrdered: remove from index 2
        featureRemove( a4, "manyBsOrdered", 2 );
        a4 = createA4( );
        // manyBs: remove non-existent
        featureRemove( a4, "manyBs", getMOINConnection( ).createElementInPartition( B4.class, null ) );
        a4 = createA4( );
        // manyBsOrdered: remove from non-existent index
        try {
            featureRemove( a4, "manyBsOrdered", 42 );
            errorAndStop( "Tried to remove an element at an index that is too big, should have thrown a WrongSizeException" );
        } catch ( IndexOutOfBoundsException e ) {
            // wrong index
        }
        //
        // remove via iterator
        //
        // manyBs: several call sequences
        featureIteratorRemove( a4, "manyBs", new String[] { "next()", "next()", "next()", "next()", "next()", "remove()" } );
        a4 = createA4( );
        featureIteratorRemove( a4, "manyBs", new String[] { "next()", "remove()", "next()", "next()", "remove()", "next()", "next()", "remove()" } );
        a4 = createA4( );
        featureIteratorRemove( a4, "manyBs", new String[] { "next()", "remove()", "next()" } );
        a4 = createA4( );
        featureIteratorRemove( a4, "manyBs", new String[] { "next()", "remove()", "next()", "remove()" } );
        a4 = createA4( );
        featureIteratorRemove( a4, "manyBs", new String[] { "next()", "next()", "remove()" } );
        a4 = createA4( );
        try {
            featureIteratorRemove( a4, "manyBs", new String[] { "remove()" } );
            errorAndStop( "Tried to remove via an iterator without having called next at least one time, should have thrown an IllegalStateException" );
        } catch ( IllegalStateException illegalStateEx ) {
            // illegal state
        }
        try {
            featureIteratorRemove( a4, "manyBs", new String[] { "next()", "next()", "next()", "next()", "next()", "next()" } );
            errorAndStop( "Tried to navigate too far, should have thrown a NoSuchElementException" );
        } catch ( NoSuchElementException noSuchElementEx ) {
            // no such element
        }
        // manyBsOrdered: remove via iterator after 3 steps, i.e. element at
        // position 2
        featureIteratorRemove( a4, "manyBsOrdered", new String[] { "next()", "next()", "next()", "remove()" } );
        a4 = createA4( );
        //
        // remove all
        //
        // manyBs: remove all
        Iterator<B4> iter = a4.getManyBs( ).iterator( );
        iter.next( );
        B4 initial1 = iter.next( );
        iter.next( );
        B4 initial3 = iter.next( );
        featureRemoveAll( a4, "manyBs", Arrays.asList( initial1, initial3 ) );
        a4 = createA4( );
        // manyBs: remove all from a parent in a different partition
        getPartitionOne( ).assignElementIncludingChildren( a4 );
        iter = a4.getManyBs( ).iterator( );
        iter.next( );
        initial1 = iter.next( );
        iter.next( );
        initial3 = iter.next( );
        featureRemoveAll( a4, "manyBs", Arrays.asList( initial1, initial3 ) );
        a4 = createA4( );
        // manyBs: remove all occurrences of an element that is present multiple
        // times for a non-unique multi-valued attribute
        add = getMOINConnection( ).createElementInPartition( B4.class, null );
        featureAdd( a4, "manyBs", add );
        featureAdd( a4, "manyBs", add );
        featureRemoveAll( a4, "manyBs", Arrays.asList( add ) );
        a4 = createA4( );
        // manyBsOrdered: remove all
        List<B4> manyBsOrdered = a4.getManyBsOrdered( );
        featureRemoveAll( a4, "manyBsOrdered", Arrays.asList( manyBsOrdered.get( 0 ), manyBsOrdered.get( manyBsOrdered.size( ) - 1 ) ) );
        //
        // retain all
        //
        // manyBs: retain all
        iter = a4.getManyBs( ).iterator( );
        iter.next( );
        initial1 = iter.next( );
        iter.next( );
        initial3 = iter.next( );
        featureRetainAll( a4, "manyBs", Arrays.asList( initial1, initial3 ) );
        a4 = createA4( );
        //
        // clear
        //
        // manyBs: clear
        featureClear( a4, "manyBs" );
        a4 = createA4( );
    }

    @Test
    public void testMultiObjectAttributeElementSet( ) {

        // set elements of multi-valued attributes
        A4 a4 = createA4( );
        // manyBsOrdered: set at index 2
        featureSet( a4, "manyBsOrdered", 2, getMOINConnection( ).createElementInPartition( B4.class, null ) );
        a4 = createA4( );
        // manyBsOrdered: set at index 2 of a parent in a different partition
        getPartitionOne( ).assignElement( a4 );
        B4 set = getMOINConnection( ).createElementInPartition( B4.class, null );
        featureSet( a4, "manyBsOrdered", 2, set );
        a4 = createA4( );
        // manyBsOrdered: set the value at index 2 which is in a different partition
        getPartitionOne( ).assignElementIncludingChildren( a4 );
        set = getMOINConnection( ).createElementInPartition( B4.class, null );
        featureSet( a4, "manyBsOrdered", 2, set );
        a4 = createA4( );
        // manyBsOrdered: set a type incompatible value
        try {
            featureSet( a4, "manyBsOrdered", 2, new Boolean( true ) );
            errorAndStop( "Tried to set a type incompatible value to the element, should have thrown a TypeMismatchException" );
        } catch ( TypeMismatchException typeMismatchEx ) {
            // type incompatibility
        }
        a4 = createA4( );
        // manyBsOrdered: set null
        try {
            featureSet( a4, "manyBsOrdered", 2, null );
            errorAndStop( "Tried to set an element to null, should have thrown a NullPointerException" );
        } catch ( NullPointerException nullPointerEx ) {
            // null pointer
        }
        a4 = createA4( );
        // manyBsOrderedUnique: set element that is already present
        try {
            B4 present = a4.getManyBsOrderedUnique( ).iterator( ).next( );
            int lastIndex = a4.getManyBsOrderedUnique( ).size( ) - 1;
            featureSet( a4, "manyBsOrderedUnique", lastIndex, present );
            errorAndStop( "Tried to set an element that is already present in an ordered unique attribute, should have thrown a DuplicateException" );
        } catch ( DuplicateException duplicateEx ) {
            // duplicate
        }
    }
}
