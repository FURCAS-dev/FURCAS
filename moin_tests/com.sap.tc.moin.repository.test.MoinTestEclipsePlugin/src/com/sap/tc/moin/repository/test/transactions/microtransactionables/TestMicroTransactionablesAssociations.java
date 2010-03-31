package com.sap.tc.moin.repository.test.transactions.microtransactionables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.DuplicateException;
import com.sap.tc.moin.repository.mmi.reflect.InvalidCallException;
import com.sap.tc.moin.repository.mmi.reflect.TypeMismatchException;
import com.sap.tc.moin.repository.mmi.reflect.WrongSizeException;

import org.junit.Test;

import com.sap.tc.moin.testcases.case004.A4;
import com.sap.tc.moin.testcases.case004.B4;
import com.sap.tc.moin.testcases.case004.C4;
import com.sap.tc.moin.testcases.case004.ComposesCsOrdered;
import com.sap.tc.moin.testcases.case004.F4;
import com.sap.tc.moin.testcases.case010.A10;
import com.sap.tc.moin.testcases.case010.B10;
import com.sap.tc.moin.testcases.case010.OneToManyChangeable;
import com.sap.tc.moin.testcases.case010.OneToManyNotChangeable;
import com.sap.tc.moin.testcases.case010.OneToManyOrdered;

@SuppressWarnings( "nls" )
public class TestMicroTransactionablesAssociations extends BaseMicroTransactionablesAssociationTest {

    @Test
    public void testAssociationAddLink( ) {

        // add links to associations
        A10 oneChangeable = getMOINConnection( ).createElementInPartition( A10.class, null );
        A10 one = getMOINConnection( ).createElementInPartition( A10.class, null );
        initializeOneToManyChangeable( oneChangeable );
        initializeOneToManyOrdered( one );
        OneToManyChangeable oneToManyChangeable = case010Package.getOneToManyChangeable( );
        OneToManyNotChangeable oneToManyNotChangeable = case010Package.getOneToManyNotChangeable( );
        OneToManyOrdered oneToManyOrdered = case010Package.getOneToManyOrdered( );
        // oneToManyChangeable: add
        B10 add1 = getMOINConnection( ).createElementInPartition( B10.class, null );
        B10 add2 = getMOINConnection( ).createElementInPartition( B10.class, null );
        associationAddLink( oneToManyChangeable, oneChangeable, add1 );
        associationAddLink( oneToManyChangeable, oneChangeable, add2 );
        initializeOneToManyChangeable( oneChangeable );
        // oneToManyChangeable: add the same link twice
        B10 addTwice = getMOINConnection( ).createElementInPartition( B10.class, null );
        associationAddLink( oneToManyChangeable, oneChangeable, addTwice );
        associationAddLink( oneToManyChangeable, oneChangeable, addTwice );
        initializeOneToManyChangeable( oneChangeable );
        // oneToManyChangeable: add type incompatible to end 0
        try {
            A4 incompatible = getMOINConnection( ).createElementInPartition( A4.class, null );
            associationAddLink( oneToManyChangeable, incompatible, getMOINConnection( ).createElementInPartition( B10.class, null ) );
            errorAndStop( "Tried to set a type incompatible association end at the from-side, should have thrown a TypeMismatchException" );
        } catch ( TypeMismatchException typeMismatchEx ) {
            // type incompatibility
        }
        // oneToManyChangeable: add type incompatible to end 1
        try {
            B4 incompatible = getMOINConnection( ).createElementInPartition( B4.class, null );
            associationAddLink( oneToManyChangeable, getMOINConnection( ).createElementInPartition( A10.class, null ), incompatible );
            errorAndStop( "Tried to set a type incompatible association end at the to-side, should have thrown a TypeMismatchException" );
        } catch ( TypeMismatchException typeMismatchEx ) {
            // type incompatibility
        }
        // oneToManyChangeable: add null to end 0
        try {
            associationAddLink( oneToManyChangeable, null, getMOINConnection( ).createElementInPartition( B10.class, null ) );
            errorAndStop( "Tried to set a null association end at the from-side, should have thrown a NullPointerException" );
        } catch ( NullPointerException nullPointerEx ) {
            // null pointer
        }
        // oneToManyChangeable: add null to end 1
        try {
            associationAddLink( oneToManyChangeable, getMOINConnection( ).createElementInPartition( A10.class, null ), null );
            errorAndStop( "Tried to set a null association end at the to-side, should have thrown a NullPointerException" );
        } catch ( NullPointerException nullPointerEx ) {
            // null pointer
        }
        // oneToManyNotChangeable: add to non-changeable end
        try {
            A10 notChangeable = getMOINConnection( ).createElementInPartition( A10.class, null );
            associationAddLink( oneToManyNotChangeable, notChangeable, getMOINConnection( ).createElementInPartition( B10.class, null ) );
            errorAndStop( "Tried to set a non-changeable association end, should have thrown an InvalidCallException" );
        } catch ( InvalidCallException invalidCallEx ) {
            // non-changeable association ends can not be changed
        }
        // oneToManyChangeable: add to single-valued end 0
        try {
            B10 end1 = (B10) oneToManyChangeable.refQuery( "oneChangeable", oneChangeable ).iterator( ).next( );
            A10 second = getMOINConnection( ).createElementInPartition( A10.class, null );
            associationAddLink( oneToManyChangeable, second, end1 );
            errorAndStop( "Tried to add more than one element to a single-valued association end, should have thrown a WrongSizeException" );
        } catch ( WrongSizeException wrongSizeEx ) {
            // wrong size
        }
        // oneToManyOrdered: add
        associationAddLink( oneToManyOrdered, getMOINConnection( ).createElementInPartition( B10.class, null ), one );
        associationAddLink( oneToManyOrdered, getMOINConnection( ).createElementInPartition( B10.class, null ), one );
        initializeOneToManyOrdered( one );
    }

    @Test
    public void testAssociationRemoveLink( ) {

        // remove links from associations
        A10 oneChangeable = getMOINConnection( ).createElementInPartition( A10.class, null );
        A10 one = getMOINConnection( ).createElementInPartition( A10.class, null );
        initializeOneToManyChangeable( oneChangeable );
        initializeOneToManyOrdered( one );
        OneToManyChangeable oneToManyChangeable = case010Package.getOneToManyChangeable( );
        OneToManyNotChangeable oneToManyNotChangeable = case010Package.getOneToManyNotChangeable( );
        OneToManyOrdered oneToManyOrdered = case010Package.getOneToManyOrdered( );
        // oneToManyChangeable: remove
        Collection<B10> manyChangeable = new ArrayList<B10>( oneToManyChangeable.getManyChangeable( oneChangeable ) );
        Iterator<B10> iter = manyChangeable.iterator( );
        B10 remove = iter.next( );
        associationRemoveLink( oneToManyChangeable, oneChangeable, remove );
        iter.next( );
        associationRemoveLink( oneToManyChangeable, oneChangeable, iter.next( ) );
        initializeOneToManyChangeable( oneChangeable );
        // oneToManyChangeable: remove incompatible at end 0
        try {
            A4 incompatible = getMOINConnection( ).createElementInPartition( A4.class, null );
            associationRemoveLink( oneToManyChangeable, incompatible, getMOINConnection( ).createElementInPartition( B10.class, null ) );
            errorAndStop( "Tried to remove a type incompatible association end at the from-side, should have thrown a TypeMismatchException" );
        } catch ( TypeMismatchException typeMismatchEx ) {
            // type incompatibility
        }
        // oneToManyChangeable: remove incompatible at end 1
        try {
            B4 incompatible = getMOINConnection( ).createElementInPartition( B4.class, null );
            associationRemoveLink( oneToManyChangeable, getMOINConnection( ).createElementInPartition( A10.class, null ), incompatible );
            errorAndStop( "Tried to remove a type incompatible association end at the to-side, should have thrown a TypeMismatchException" );
        } catch ( TypeMismatchException typeMismatchEx ) {
            // type incompatibility
        }
        // oneToManyChangeable: remove null at end 0
        try {
            associationRemoveLink( oneToManyChangeable, null, getMOINConnection( ).createElementInPartition( B10.class, null ) );
            errorAndStop( "Tried to remove a null association end from the from-side, should have thrown a NullPointerException" );
        } catch ( NullPointerException nullPointerEx ) {
            // null pointer
        }
        // oneToManyChangeable: remove null at end 1
        try {
            associationRemoveLink( oneToManyChangeable, getMOINConnection( ).createElementInPartition( A10.class, null ), null );
            errorAndStop( "Tried to remove a null association end from the to-side, should have thrown a NullPointerException" );
        } catch ( NullPointerException nullPointerEx ) {
            // null pointer
        }
        // oneToManyNotChangeable: remove from non-changeable end
        try {
            associationRemoveLink( oneToManyNotChangeable, getMOINConnection( ).createElementInPartition( A10.class, null ), getMOINConnection( ).createElementInPartition( B10.class, null ) );
            errorAndStop( "Tried to remove a non-changeable association end, should have thrown an InvalidCallException" );
        } catch ( InvalidCallException invalidCallEx ) {
            // non-changeable association ends can not be changed
        }
        // oneToManyOrdered: remove
        List<B10> manyOrdered = oneToManyOrdered.getManyOrdered( one );
        associationRemoveLink( oneToManyOrdered, manyOrdered.get( 2 ), one );
        associationRemoveLink( oneToManyOrdered, manyOrdered.get( 1 ), one );
        initializeOneToManyOrdered( one );
        // oneToManyChangeable: remove non-existing link
        B10 notExist = getMOINConnection( ).createElementInPartition( B10.class, null );
        associationRemoveLink( oneToManyChangeable, oneChangeable, notExist );
    }

    @Test
    public void testAssociationElementAdd( ) {

        // add elements to association ends
        A10 oneChangeable = getMOINConnection( ).createElementInPartition( A10.class, null );
        A10 one = getMOINConnection( ).createElementInPartition( A10.class, null );
        F4 myF4 = (F4) f4Class.refCreateInstance( );
        initializeOneToManyChangeable( oneChangeable );
        initializeOneToManyOrdered( one );
        initializeComposesCsOrdered( myF4 );
        OneToManyChangeable oneToManyChangeable = case010Package.getOneToManyChangeable( );
        OneToManyOrdered oneToManyOrdered = case010Package.getOneToManyOrdered( );
        ComposesCsOrdered composesCsOrdered = case004Package.getComposesCsOrdered( );
        //
        // simple add
        //
        // oneToManyChangeable: add to end 1
        associationAdd( oneToManyChangeable, oneChangeable, 0, getMOINConnection( ).createElementInPartition( B10.class, null ) );
        initializeOneToManyChangeable( oneChangeable );
        // oneToManyChangeable: add to end 1 twice
        B10 addTwice = getMOINConnection( ).createElementInPartition( B10.class, null );
        associationAdd( oneToManyChangeable, oneChangeable, 0, addTwice );
        associationAdd( oneToManyChangeable, oneChangeable, 0, addTwice );
        initializeOneToManyChangeable( oneChangeable );
        // oneToManyChangeable: add type incompatible to end 1
        try {
            associationAdd( oneToManyChangeable, oneChangeable, 0, new Boolean( true ) );
            errorAndStop( "Tried to add a type incompatible element to the attribute, should have thrown a TypeMismatchException" );
        } catch ( TypeMismatchException typeMismatchEx ) {
            // type incompatibility
        }
        // oneToManyChangeable: add null to end 1
        try {
            associationAdd( oneToManyChangeable, oneChangeable, 0, null );
            errorAndStop( "Tried to add a null element, should have thrown a NullPointerException" );
        } catch ( NullPointerException nullPointerEx ) {
            // null pointer
        }
        // oneToManyChangeable: add to single-valued end 0
        try {
            B10 end1 = (B10) oneToManyChangeable.refQuery( "oneChangeable", oneChangeable ).iterator( ).next( );
            A10 second = getMOINConnection( ).createElementInPartition( A10.class, null );
            associationAdd( oneToManyChangeable, end1, 1, second );
            errorAndStop( "Tried to add more than one element to a single-valued association end, should have thrown a WrongSizeException" );
        } catch ( WrongSizeException wrongSizeEx ) {
            // wrong size
        }
        // oneToManyChangeable: add all to end 1
        associationAddAll( oneToManyChangeable, oneChangeable, 0, Arrays.asList( getMOINConnection( ).createElementInPartition( B10.class, null ), getMOINConnection( ).createElementInPartition( B10.class, null ) ) );
        initializeOneToManyChangeable( oneChangeable );
        // oneToManyOrdered: add at index 2 of end 0
        associationAdd( oneToManyOrdered, one, 1, 2, getMOINConnection( ).createElementInPartition( B10.class, null ) );
        initializeOneToManyOrdered( one );
        //
        // add all
        //
        // oneToManyOrdered: add all at index 2 of end 0
        associationAddAll( oneToManyOrdered, one, 1, 2, Arrays.asList( getMOINConnection( ).createElementInPartition( B10.class, null ), getMOINConnection( ).createElementInPartition( B10.class, null ) ) );
        initializeOneToManyOrdered( one );
        // oneToManyOrdered: add all at the end index of end 0
        associationAddAll( oneToManyOrdered, one, 1, Arrays.asList( getMOINConnection( ).createElementInPartition( B10.class, null ), getMOINConnection( ).createElementInPartition( B10.class, null ) ) );
        initializeOneToManyOrdered( one );
        // oneToManyOrdered: add all with duplicates at index 2 of end 0
        B10 duplicate = getMOINConnection( ).createElementInPartition( B10.class, null );
        associationAddAll( oneToManyOrdered, one, 1, 2, Arrays.asList( duplicate, duplicate, getMOINConnection( ).createElementInPartition( B10.class, null ) ) );
        initializeOneToManyOrdered( one );
        // composesCsOrdered: add all elements at the end index of end 1, elements at end 0 and end 1 are in a partition
        getPartitionOne( ).assignElementIncludingChildren( myF4 );
        associationAddAll( composesCsOrdered, myF4, 0, Arrays.asList( c4Class.refCreateInstance( ), c4Class.refCreateInstance( ) ) );
        myF4 = (F4) f4Class.refCreateInstance( );
        initializeComposesCsOrdered( myF4 );
    }

    @Test
    public void testAssociationElementRemove( ) {

        // remove elements from association ends
        A10 oneChangeable = getMOINConnection( ).createElementInPartition( A10.class, null );
        A10 one = getMOINConnection( ).createElementInPartition( A10.class, null );
        F4 myF4 = (F4) f4Class.refCreateInstance( );
        initializeOneToManyChangeable( oneChangeable );
        initializeOneToManyOrdered( one );
        initializeComposesCsOrdered( myF4 );
        OneToManyChangeable oneToManyChangeable = case010Package.getOneToManyChangeable( );
        OneToManyOrdered oneToManyOrdered = case010Package.getOneToManyOrdered( );
        ComposesCsOrdered composesCsOrdered = case004Package.getComposesCsOrdered( );
        //
        // simple remove
        //
        // oneToManyChangeable: remove from end 1
        Collection<B10> manyChangeable = oneToManyChangeable.getManyChangeable( oneChangeable );
        associationRemove( oneToManyChangeable, oneChangeable, 0, manyChangeable.iterator( ).next( ) );
        initializeOneToManyChangeable( oneChangeable );
        // oneToManyOrdered: remove from end 0
        List<B10> manyOrdered = oneToManyOrdered.getManyOrdered( one );
        associationRemove( oneToManyOrdered, one, 1, manyOrdered.get( 2 ) );
        initializeOneToManyOrdered( one );
        // oneToManyOrdered: remove from index 2 of end 0
        associationRemove( oneToManyOrdered, one, 1, 2 );
        initializeOneToManyOrdered( one );
        // oneToManyChangeable: remove non-existent from end 1
        associationRemove( oneToManyChangeable, oneChangeable, 0, getMOINConnection( ).createElementInPartition( B10.class, null ) );
        initializeOneToManyChangeable( oneChangeable );
        // composesCsOrdered: F4 and many C4 in a partition, remove one C4 (goes into the null partition then)
        getPartitionOne( ).assignElementIncludingChildren( myF4 );
        associationRemove( composesCsOrdered, myF4, 0, 1 );
        myF4 = (F4) f4Class.refCreateInstance( );
        initializeComposesCsOrdered( myF4 );
        // oneToManyOrdered: remove from non-existent index of end 0
        try {
            associationRemove( oneToManyOrdered, one, 1, 42 );
            errorAndStop( "Tried to remove an element at an index that is too big, should have thrown an IndexOutOfBoundsException" );
        } catch ( IndexOutOfBoundsException wrongSizeEx ) {
            // wrong index
        }
        //
        // remove all
        //
        // oneToManyChangeable: remove all from end 1
        manyChangeable = oneToManyChangeable.getManyChangeable( oneChangeable );
        Iterator<B10> iter = manyChangeable.iterator( );
        iter.next( );
        B10 initial1 = iter.next( );
        iter.next( );
        B10 initial3 = iter.next( );
        associationRemoveAll( oneToManyChangeable, oneChangeable, 0, Arrays.asList( initial1, initial3 ) );
        initializeOneToManyChangeable( oneChangeable );
        // oneToManyOrdered: remove all from end 0
        manyOrdered = oneToManyOrdered.getManyOrdered( one );
        associationRemoveAll( oneToManyOrdered, one, 1, Arrays.asList( manyOrdered.get( 1 ), manyOrdered.get( 3 ) ) );
        //
        // retain all
        //
        // oneToManyChangeable: retain all at end 1
        manyChangeable = oneToManyChangeable.getManyChangeable( oneChangeable );
        iter = manyChangeable.iterator( );
        iter.next( );
        initial1 = iter.next( );
        iter.next( );
        initial3 = iter.next( );
        associationRetainAll( oneToManyChangeable, oneChangeable, 0, Arrays.asList( initial1, initial3 ) );
        //
        // clear
        //
        // oneToManyChangeable: clear all elements at end 1
        associationClear( oneToManyChangeable, oneChangeable, 0 );
        initializeOneToManyChangeable( oneChangeable );
        // composesCsOrdered: clear all elements at end 1, elements at end 0 and end 1 are in a partition
        getPartitionOne( ).assignElementIncludingChildren( myF4 );
        associationClear( composesCsOrdered, myF4, 0 );
        myF4 = (F4) f4Class.refCreateInstance( );
        initializeComposesCsOrdered( myF4 );
    }

    @Test
    public void testAssociationElementSet( ) {

        // set elements of multi-valued association ends
        A10 one = getMOINConnection( ).createElementInPartition( A10.class, null );
        initializeOneToManyOrdered( one );
        OneToManyOrdered oneToManyOrdered = case010Package.getOneToManyOrdered( );
        ComposesCsOrdered composesCsOrdered = case004Package.getComposesCsOrdered( );
        // oneToManyOrdered: set at index 2
        B10 set = getMOINConnection( ).createElementInPartition( B10.class, null );
        associationSet( oneToManyOrdered, one, 1, 2, set );
        initializeOneToManyOrdered( one );
        // oneToManyOrdered: set type incompatible
        try {
            associationSet( oneToManyOrdered, one, 1, 2, new Boolean( true ) );
            errorAndStop( "Tried to set a type incompatible value to the element, should have thrown a TypeMismatchException" );
        } catch ( TypeMismatchException typeMismatchEx ) {
            // type incompatibility
        }
        // oneToManyOrdered: set null
        try {
            associationSet( oneToManyOrdered, one, 1, 2, null );
            errorAndStop( "Tried to set an element to null, should have thrown a NullPointerException" );
        } catch ( NullPointerException nullPointerEx ) {
            // null pointer
        }
        // oneToManyOrdered: set non-existent index
        try {
            associationSet( oneToManyOrdered, one, 1, 42, getMOINConnection( ).createElementInPartition( B10.class, null ) );
            errorAndStop( "Tried to remove an element at an index that is too big, should have thrown an IndexOutOfBoundsException" );
        } catch ( IndexOutOfBoundsException wrongSizeEx ) {
            // wrong index
        }
//        // oneToManyNotChangeable: set non-changeable end
//        try {
//            A10 notChangeable = getMOINConnection( ).createElementInPartition( A10.class, null );
//            associationSet( oneToManyNotChangeable, notChangeable, 0, 0, getMOINConnection( ).createElementInPartition( B10.class, null ) );
//            errorAndStop( "Tried to set a non-changeable association end, should have thrown an InvalidCallException" );
//        } catch ( InvalidCallException invalidCallEx ) {
//            // non-changeable association ends can not be changed
//        }
        // oneToManyOrdered: set element that is already present, note that association ends are unique
        try {
            B10 present = one.getManyBsOrdered( ).iterator( ).next( );
            int lastIndex = one.getManyBsOrdered( ).size( ) - 1;
            associationSet( oneToManyOrdered, one, 1, lastIndex, present );
            errorAndStop( "Tried to set an element that is already present in an ordered end, should have thrown a DuplicateException" );
        } catch ( DuplicateException duplicateEx ) {
            // duplicate
        }
        // composesCs: set a composite element that is in the null partition to an element that is in a real partition
        F4 myF4 = (F4) f4Class.refCreateInstanceInPartition( getPartitionOne( ) );
        initializeComposesCsOrdered( myF4 );
        C4 myC4 = (C4) c4Class.refCreateInstance( );
        associationSet( composesCsOrdered, myF4, 0, 0, myC4 );
    }
}
