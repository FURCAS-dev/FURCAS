package com.sap.tc.moin.repository.test.transactions.microtransactionables;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.sap.tc.moin.repository.mmi.reflect.InvalidCallException;
import com.sap.tc.moin.repository.mmi.reflect.TypeMismatchException;

import org.junit.Test;

import com.sap.tc.moin.testcases.case004.A4;
import com.sap.tc.moin.testcases.case004.B4;
import com.sap.tc.moin.testcases.case004.C4;
import com.sap.tc.moin.testcases.case004.ComposesCs;
import com.sap.tc.moin.testcases.case004.D4;
import com.sap.tc.moin.testcases.case004.F4;
import com.sap.tc.moin.testcases.case004.HasCs;
import com.sap.tc.moin.testcases.case010.B10;
import com.sap.tc.moin.testcases.case013.B13;

@SuppressWarnings( "nls" )
public class TestMicroTransactionablesPartitionables extends BaseMicroTransactionablesInstanceTest {

    @Test
    public void testInstanceCreateProduceExceptions( ) {

        // create instance, produce exceptions
        // A21Abstract: can not be instantiated
        try {
            instanceCreate( a21AbstractClass, null );
            errorAndStop( "Instance creation of an abstract class, should have thrown an InvalidCallException" );
        } catch ( InvalidCallException invalidCallEx ) {
            // class is abstract
        }
        // A4: initialize with with too few parameters
        try {
            instanceCreate( a4Class, Arrays.asList( "initial" ) );
            errorAndStop( "Instance creation with too few parameters, should have thrown an InvalidCallException" );
        } catch ( InvalidCallException invalidCallEx ) {
            // too few parameters
        }
        // A10 (has no parameters): initialize with too many parameters
        try {
            instanceCreate( a10Class, Arrays.asList( "initial" ) );
            errorAndStop( "Instance creation with too many parameters, should have thrown an InvalidCallException" );
        } catch ( InvalidCallException invalidCallEx ) {
            // too many parameters
        }
        // B4 (has one parameter): initialize with too many parameters
        try {
            instanceCreate( b4Class, Arrays.asList( "initial0", "initial1" ) );
            errorAndStop( "Instance creation with too many parameters, should have thrown an InvalidCallException" );
        } catch ( InvalidCallException invalidCallEx ) {
            // too many parameters
        }
        // B4: initialize with type incompatible parameter
        try {
            instanceCreate( b4Class, Arrays.asList( new Boolean( true ) ) );
            errorAndStop( "Instance creation with a type incompatible value, should have thrown a TypeMismatchException" );
        } catch ( TypeMismatchException typeMismatchEx ) {
            // type incompatibility
        }
        // A4: initialize with type incompatible parameter for a multi-valued non-ordered attribute
        try {
            instanceCreate( a4Class, Arrays.asList( null, null, null, new Boolean( "true" ), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null ) );
            errorAndStop( "Instance creation with a type incompatible value, should have thrown a TypeMismatchException" );
        } catch ( TypeMismatchException typeMismatchEx ) {
            // type incompatibility
        }
        // A4: initialize with type incompatible parameter for a multi-valued ordered attribute
        try {
            instanceCreate( a4Class, Arrays.asList( null, null, null, null, null, null, new Boolean( "true" ), null, null, null, null, null, null, null, null, null, null, null, null, null, null ) );
            errorAndStop( "Instance creation with a type incompatible value, should have thrown a TypeMismatchException" );
        } catch ( TypeMismatchException typeMismatchEx ) {
            // type incompatibility
        }
        try {
            // Collection instead of List
            instanceCreate( a4Class, Arrays.asList( null, null, null, null, null, null, null, null, Collections.EMPTY_SET, null, null, null, null, null, null, null, null, null, null, null, null ) );
            errorAndStop( "Instance creation with a type incompatible value, should have thrown a TypeMismatchException" );
        } catch ( TypeMismatchException typeMismatchEx ) {
            // type incompatibility
        }
        // A4: initialize with type incompatible parameter ELEMENT for a multi-valued attribute
        try {
            instanceCreate( a4Class, Arrays.<Object> asList( null, null, null, null, Arrays.asList( new Boolean[] { new Boolean( "true" ) } ), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null ) );
            errorAndStop( "Instance creation with a type incompatible value, should have thrown a TypeMismatchException" );
        } catch ( TypeMismatchException typeMismatchEx ) {
            // type incompatibility
        }
        // A4: initialize with null as parameter ELEMENT for a multi-valued attribute
        try {
            instanceCreate( a4Class, Arrays.<Object> asList( null, null, null, null, Arrays.asList( (Object) null ), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null ) );
            errorAndStop( "Instance creation with a null member for a multi-valued attribute, should have thrown a NullPointerException" );
        } catch ( NullPointerException nullPointerEx ) {
            // null pointer
        }
    }

    @Test
    public void testInstanceCreateDefault( ) {

        // create instance, default constructor case
        // A4: initialize without parameters
        instanceCreate( a4Class, null );
    }

    @Test
    public void testInstanceCreateWithParameters( ) {

        // create instance
        List<Object> a4ParameterListFull = Arrays.<Object> //
            asList( "initial", // onePrimitive
                    null, // onePrimitiveOptional
                    "initial", // onePrimitiveNotChangeable
                    new MyCollection( Arrays.asList( "initial0", "initial1", "initial2", "initial3", "initial4" ) ), // manyPrimitive
                    new MyCollection( Arrays.asList( new Double( 45.0 ), new Double( 44.0 ) ) ), // manyPrimitiveDouble
                    new MyCollection( Arrays.asList( "initial0", "initial1", "initial2", "initial3", "initial3", "initial4" ) ), // manyPrimitiveUnique
                    new MyCollection( ), // manyPrimitiveOptional
                    new MyCollection( Arrays.asList( "initial0", "initial1", "initial2", "initial3", "initial4" ) ), // manyPrimitiveNotChangeable
                    Arrays.asList( "initial0", "initial1", "initial2", "initial3", "initial4" ), // manyPrimitiveOrdered
                    Arrays.asList( "initial0", "initial1", "initial2", "initial3", "initial4" ), // manyPrimitiveOrderedUnique
                    new Vector<Object>( ), // manyPrimitiveOrderedNotChangeable
                    b4Class.refCreateInstance( ), // oneBChangeable
                    null, // oneBnotChangeable
                    null, // oneBoptional
                    new MyCollection( Arrays.asList( b4Class.refCreateInstance( ), b4Class.refCreateInstance( ), b4Class.refCreateInstance( ), b4Class.refCreateInstance( ), b4Class.refCreateInstance( ) ) ), // manyBs
                    new MyCollection( Arrays.asList( b4Class.refCreateInstance( ), b4Class.refCreateInstance( ), b4Class.refCreateInstance( ), b4Class.refCreateInstance( ), b4Class.refCreateInstance( ) ) ), // manyBsUnique
                    new MyCollection( ), // manyBsNotUnique
                    Arrays.asList( b4Class.refCreateInstance( ), b4Class.refCreateInstance( ), b4Class.refCreateInstance( ), b4Class.refCreateInstance( ), b4Class.refCreateInstance( ) ), // manyBsOrdered
                    Arrays.asList( b4Class.refCreateInstance( ), b4Class.refCreateInstance( ), b4Class.refCreateInstance( ), b4Class.refCreateInstance( ), b4Class.refCreateInstance( ) ), // manyBsOrderedUnique
                    new MyCollection( ), // manyBsNotOrdered
                    new MyCollection( ) ); // manyBsNotChangeable
        List<Object> a4ParameterListAllNull = Arrays.<Object> asList( null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null );
        // A4
        instanceCreate( a4Class, a4ParameterListFull );
        instanceCreate( a4Class, a4ParameterListAllNull );
        // A4: creation in a partition but with a multi-valued attribute in the null partition
        List<Object> a4ParameterList = Arrays.<Object> //
            asList( null, null, null, null, null, null, null, null, null, null, null, null, null, null, //
                    new MyCollection( Arrays.asList( (B4) b4Class.refCreateInstanceInPartition( nullPartition ), (B4) b4Class.refCreateInstanceInPartition( nullPartition ) ) ), // manyBs
                    null, null, null, null, null, null );
        instanceCreate( a4Class, a4ParameterList, getPartitionOne( ) );
        // B4: initialize required attribute with null, this IS possible
        instanceCreate( b4Class, Arrays.asList( (Object) null ) );
        // B4
        instanceCreate( b4Class, Arrays.asList( "initial" ) );
        // D4: has only Java primitives
        instanceCreate( d4Class, Arrays.<Object> asList( false, null, 0.0, null, new Float( 0 ), null, 0, null, 0L, null, "initial", null ) );
        // D4: has only Java primitives, set all but one to null
        instanceCreate( d4Class, Arrays.asList( null, null, new Double( 66.6 ), null, null, null, null, null, null, null, null, null ) );
        // C4
        instanceCreate( c4Class, Arrays.asList( "initial", b4Class.refCreateInstance( ) ) );
        // C4: creation in a partition but with a single-valued attribute in the null partition
        B4 b4 = (B4) b4Class.refCreateInstanceInPartition( nullPartition );
        instanceCreate( c4Class, Arrays.asList( "initial", b4 ), getPartitionOne( ) );
        // A8: structures and enumerations: initialize with null
        instanceCreate( a8Class, Arrays.asList( null, null, null, null, null, null ) );
    }

    @Test
    public void testInstanceDelete( ) {

        // D4: with primitive parameters
        D4 d4 = createD4( );
        instanceDelete( d4 );
        // B10: without parameters
        B10 b10 = createB10( );
        instanceDelete( b10 );
        // C4: is in a real partition and has a composite child of type B4
        C4 c4 = createC4( );
        getPartitionOne( ).assignElementIncludingChildren( c4 );
        instanceDelete( c4 );
        // A4: with parameters
        A4 a4 = createA4( );
        instanceDelete( a4 );
        // A4: has single-valued attribute of type B4
        a4 = createA4( );
        B4 b4 = a4.getOneBchangeable( );
        instanceDelete( b4 );
        // A4: has multi-valued ordered attribute of type B4
        a4 = createA4( );
        b4 = a4.getManyBsOrdered( ).get( 1 );
        instanceDelete( b4 );
        // F4: has a single-valued attribute, oneC of type C4, which has a single-valued attribute, instanceComplex
        // it is also associated with another instance f4_2 of F4
        F4 f4_1 = createF4( );
        F4 f4_2 = createF4( );
        HasCs hasCs = case004Package.getHasCs( );
        c4 = f4_1.getOneC( );
        hasCs.add( f4_2, c4 );
        instanceDelete( c4 );
        // F4: has a multi-valued attribute, manyCs of type C4, which has a single-valued attribute, instanceComplex
        F4 f4 = createF4( );
        Iterator<C4> iter = f4.getManyCs( ).iterator( );
        iter.next( );
        c4 = iter.next( );
        instanceDelete( c4 );
        // F4: has a multi-valued ordered attribute, manyCsOrdered of type C4, which has a single-valued attribute, instanceComplex
        f4 = createF4( );
        c4 = f4.getManyCsOrdered( ).get( 1 );
        instanceDelete( c4 );
        // F4: has an association, hasCs, to C4
        f4 = createF4( );
        c4 = createC4( );
        hasCs = case004Package.getHasCs( );
        hasCs.add( f4, c4 );
        instanceDelete( c4 );
        // F4: has a multi-valued composite child via association composesCs
        f4 = createF4( );
        c4 = createC4( );
        ComposesCs composesCs = case004Package.getComposesCs( );
        composesCs.add( f4, c4 );
        instanceDelete( c4 );
        // B13: with nitializers
        B13 b13 = createB13( );
        instanceDelete( b13 );
    }

    @Test
    public void testPackageDelete( ) {

        try {
            case004Package.refDelete( );
            errorAndStop( "Package deletion, should have thrown an UnsupportedOperationException" );
        } catch ( UnsupportedOperationException unsupportedOperationEx ) {
            // unsupported operation
        }
    }
}
