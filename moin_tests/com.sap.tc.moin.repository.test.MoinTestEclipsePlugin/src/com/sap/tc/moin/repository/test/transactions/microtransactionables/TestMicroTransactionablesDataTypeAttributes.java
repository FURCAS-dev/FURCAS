package com.sap.tc.moin.repository.test.transactions.microtransactionables;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.DuplicateException;
import com.sap.tc.moin.repository.mmi.reflect.InvalidCallException;
import com.sap.tc.moin.repository.mmi.reflect.InvalidNameException;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.TypeMismatchException;
import com.sap.tc.moin.repository.mmi.reflect.WrongSizeException;

import org.junit.Test;

import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;
import com.sap.tc.moin.testcases.case004.A4;
import com.sap.tc.moin.testcases.case004.D4;
import com.sap.tc.moin.testcases.case008.A8;
import com.sap.tc.moin.testcases.case008.E8Enum;
import com.sap.tc.moin.testcases.case008.S8;

@SuppressWarnings( "nls" )
public class TestMicroTransactionablesDataTypeAttributes extends BaseMicroTransactionablesFeatureChangeTest {

    @Test
    public void testFeatureNotExistChange( ) {

        A4 a4 = createA4( );
        // change the feature "null"
        try {
            a4.refSetValue( (RefObject) null, "" );
            errorAndStop( "Feature is null, should have thrown an InvalidCallException" );
        } catch ( InvalidCallException invalidCallEx ) {
            // null is an invalid attribute
        } catch ( Exception ex ) {
            errorAndStop( "Feature is null, should have thrown an InvalidCallException, but exception is " + ex );
        }
        try {
            a4.refSetValue( (String) null, "" );
            errorAndStop( "Feature is null, should have thrown an InvalidNameException" );
        } catch ( InvalidNameException invalidNameEx ) {
            // null is an invalid attribute
        } catch ( Exception ex ) {
            errorAndStop( "Feature is null, should have thrown an InvalidNameException, but exception is " + ex );
        }
        // change non-existing feature "notExist"
        try {
            a4.refSetValue( "notExist", "" );
            errorAndStop( "Feature does not exist, should have thrown an InvalidCallException" );
        } catch ( InvalidCallException invalidCallEx ) {
            // notExist is not a feature of A4
        } catch ( Exception ex ) {
            errorAndStop( "Feature does not exist, should have thrown an InvalidCallException, but exception is " + ex );
        }
    }

    @Test
    public void testSingleDataTypeAttributeChange( ) {

        // change single-valued attributes
        A4 a4 = createA4( );
        A8 a8 = createA8( );
        D4 d4 = createD4( );
        // onePrimitive: change
        featureChange( a4, "onePrimitive", "changed" );
        a4 = createA4( );
        // onePrimitive: change non-optional attribute to null, this IS possible because the underflow constraint is deferred in JMI
        featureChange( a4, "onePrimitive", null );
        a4 = createA4( );
        // change non-optional Java primitives to null, this IS possible because the underflow constraint is deferred in JMI
        featureChange( d4, "attributeBoolean", null );
        featureChange( d4, "attributeDouble", null );
        featureChange( d4, "attributeFloat", null );
        featureChange( d4, "attributeInteger", null );
        featureChange( d4, "attributeLong", null );
        featureChange( d4, "attributeString", null );
        d4 = createD4( );
        // onePrimitive: change to type incompatible
        try {
            featureChange( a4, "onePrimitive", new Boolean( true ) );
            errorAndStop( "Tried to set a type incompatible value to the attribute, should have thrown a TypeMismatchException" );
        } catch ( TypeMismatchException typeMismatchEx ) {
            // type incompatibility
        }
        featureChange( a4, "onePrimitiveNotChangeable", "changed" );
        // oneEnumerationE: change
        featureChange( a8, "oneEnumerationE", E8Enum.LABEL2 );
        a8 = createA8( );
        // oneStructureS: change
        StructureFieldContainer<S8> contS8 = new StructureFieldContainer<S8>( );
        contS8.put( a8.getOneStructureS( ) ).put( S8.DESCRIPTORS.FIELD2( ), "changed" );
        S8 s8 = case008Package.createS8( contS8 );
        featureChange( a8, "oneStructureS", s8 );
        a8 = createA8( );
    }

    @Test
    public void testMultiDataTypeAttributeChange( ) {

        // change multi-valued attributes as a whole
        A4 a4 = createA4( );
        // manyPrimitive: change
        try {
            featureChange( a4, "manyPrimitive", Arrays.asList( "changed" ) );
            errorAndStop( "Multi-valued attribute changed as a whole, should have thrown an InvalidCallException" );
        } catch ( InvalidCallException invalidCallEx ) {
            // multi-valued attribute can not be set as a whole
        }
    }

    @Test
    public void testMultiDataTypeAttributeElementAdd( ) {

        // add elements to multi-valued attributes
        A4 a4 = createA4( );
        //
        // simple add
        //
        // manyPrimitive: add
        featureAdd( a4, "manyPrimitive", "add" );
        a4 = createA4( );
        // manyPrimitive: add same element twice
        featureAdd( a4, "manyPrimitive", "add" );
        featureAdd( a4, "manyPrimitive", "add" );
        a4 = createA4( );
        // manyPrimitive: add type incompatible
        try {
            featureAdd( a4, "manyPrimitive", new Boolean( true ) );
            errorAndStop( "Tried to add a type incompatible element to the attribute, should have thrown a TypeMismatchException" );
        } catch ( TypeMismatchException typeMismatchEx ) {
            // type incompatibility
        }
        // manyPrimitive: add null
        try {
            featureAdd( a4, "manyPrimitive", null );
            errorAndStop( "Tried to add a null element, should have thrown a NullPointerException" );
        } catch ( NullPointerException nullPointerEx ) {
            // null pointer
        }
        // manyPrimitiveOrdered: add
        featureAdd( a4, "manyPrimitiveOrdered", "add" );
        a4 = createA4( );
        // manyPrimitiveOrdered: add at index 2
        featureAdd( a4, "manyPrimitiveOrdered", 2, "add" );
        a4 = createA4( );
        // manyPrimitiveUnique: add element that is already present
        try {
            featureAdd( a4, "manyPrimitiveUnique", "initial0" );
            errorAndStop( "Tried to add an element that is already present in a unique attribute, should have thrown a DuplicateException" );
        } catch ( DuplicateException duplicateEx ) {
            // duplicate
        }
        featureAdd( a4, "manyPrimitiveNotChangeable", "add" );
        //
        // add all
        //
        // manyPrimitive: add all
        featureAddAll( a4, "manyPrimitive", Arrays.<Object> asList( new Object[] { "add0", "add1" } ) );
        a4 = createA4( );
        // manyPrimitiveOrdered: add all at index 2
        featureAddAll( a4, "manyPrimitiveOrdered", 2, Arrays.asList( new String[] { "add0", "add1" } ) );
        a4 = createA4( );
        // manyPrimitiveOrdered: add all at index 2
        featureAddAll( a4, "manyPrimitiveOrdered", 2, Arrays.asList( new String[] { "add0", "add0", "add1" } ) );
        a4 = createA4( );
        // manyPrimitiveOrdered: add all at the end
        featureAddAll( a4, "manyPrimitiveOrdered", Arrays.<Object> asList( new Object[] { "add0", "add1" } ) );
        a4 = createA4( );
    }

    @Test
    public void testMultiDataTypeAttributeElementRemove( ) {

        // remove elements from multi-valued attributes
        A4 a4 = createA4( );
        //
        // simple remove
        //
        // manyPrimitive: remove
        String remove = a4.getManyPrimitive( ).iterator( ).next( );
        featureRemove( a4, "manyPrimitive", remove );
        a4 = createA4( );
        // manyPrimitive: remove one occurrence of an element that is present multiple times for a non-unique multi-valued attribute
        String add = "add";
        featureAdd( a4, "manyPrimitive", add );
        featureAdd( a4, "manyPrimitive", add );
        featureRemove( a4, "manyPrimitive", add );
        a4 = createA4( );
        // manyPrimitiveOrdered: remove
        remove = a4.getManyPrimitiveOrdered( ).get( 2 );
        featureRemove( a4, "manyPrimitiveOrdered", remove );
        a4 = createA4( );
        // manyPrimitiveOrdered: remove from index 2
        featureRemove( a4, "manyPrimitiveOrdered", 2 );
        a4 = createA4( );
        // manyPrimitive: remove non-existent
        featureRemove( a4, "manyPrimitive", "non-existent" );
        a4 = createA4( );
        // manyPrimitiveOrdered: remove from non-existent index
        try {
            featureRemove( a4, "manyPrimitiveOrdered", 42 );
            errorAndStop( "Tried to remove an element at an index that is too big, should have thrown a WrongSizeException" );
        } catch ( WrongSizeException wrongSizeEx ) {
            // wrong size
        }
        //
        // remove all
        //
        // manyPrimitive: remove all
        Collection<String> manyPrimitive = a4.getManyPrimitive( );
        Iterator<String> iter = manyPrimitive.iterator( );
        iter.next( );
        String initial1 = iter.next( );
        iter.next( );
        String initial3 = iter.next( );
        featureRemoveAll( a4, "manyPrimitive", Arrays.asList( initial1, initial3 ) );
        a4 = createA4( );
        // manyPrimitive: remove all occurrences of an element that is present multiple times for a non-unique multi-valued attribute
        add = "add";
        featureAdd( a4, "manyPrimitive", add );
        featureAdd( a4, "manyPrimitive", add );
        featureRemoveAll( a4, "manyPrimitive", Arrays.asList( add ) );
        a4 = createA4( );
        // manyPrimitiveOrdered: remove all
        List<String> manyPrimitiveOrdered = a4.getManyPrimitiveOrdered( );
        featureRemoveAll( a4, "manyPrimitiveOrdered", Arrays.asList( manyPrimitiveOrdered.get( 0 ), manyPrimitiveOrdered.get( manyPrimitiveOrdered.size( ) - 1 ), manyPrimitiveOrdered.get( 1 ) ) );
        a4 = createA4( );
        //
        // retain all
        //
        // manyPrimitive: retain all
        manyPrimitive = a4.getManyPrimitive( );
        iter = manyPrimitive.iterator( );
        iter.next( );
        iter.next( );
        String initial2 = iter.next( );
        initial3 = iter.next( );
        String initial4 = iter.next( );
        featureRetainAll( a4, "manyPrimitive", Arrays.asList( initial2, initial3, initial4 ) );
        a4 = createA4( );
        //
        // clear
        //
        // manyPrimitive: clear
        featureClear( a4, "manyPrimitive" );
        a4 = createA4( );
    }

    @Test
    public void testMultiDataTypeAttributeElementSet( ) {

        // set elements of multi-valued attributes
        A4 a4 = createA4( );
        // manyPrimitiveOrdered: set at index 2
        featureSet( a4, "manyPrimitiveOrdered", 2, "set" );
        a4 = createA4( );
        // manyPrimitiveOrdered: set a type incompatible value
        try {
            featureSet( a4, "manyPrimitiveOrdered", 2, new Boolean( true ) );
            errorAndStop( "Tried to set a type incompatible value to the element, should have thrown a TypeMismatchException" );
        } catch ( TypeMismatchException typeMismatchEx ) {
            // type incompatibility
        }
        a4 = createA4( );
        // manyPrimitiveOrdered: set null
        try {
            featureSet( a4, "manyPrimitiveOrdered", 2, null );
            errorAndStop( "Tried to set an element to null, should have thrown a NullPointerException" );
        } catch ( NullPointerException nullPointerEx ) {
            // null pointer
        }
        a4 = createA4( );
        // manyPrimitiveOrderedUnique: set element that is already present
        try {
            String present = a4.getManyPrimitiveOrderedUnique( ).iterator( ).next( );
            int lastIndex = a4.getManyPrimitiveOrderedUnique( ).size( ) - 1;
            featureSet( a4, "manyPrimitiveOrderedUnique", lastIndex, present );
            errorAndStop( "Tried to set an element that is already present in an ordered unique attribute, should have thrown a DuplicateException" );
        } catch ( DuplicateException duplicateEx ) {
            // duplicate
        }
    }
}
