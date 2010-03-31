package com.sap.tc.moin.repository.test.persistence;

import java.util.Arrays;

import com.sap.tc.moin.repository.mmi.reflect.RefClass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.MoinPackage;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.repository.test.core.CoreMoinTest;
import com.sap.tc.moin.testcases.TestcasesPackage;
import com.sap.tc.moin.testcases.case001.A1;
import com.sap.tc.moin.testcases.case001.B1;
import com.sap.tc.moin.testcases.case004.A4;
import com.sap.tc.moin.testcases.case004.B4;
import com.sap.tc.moin.testcases.case004.Case004Package;
import com.sap.tc.moin.testcases.case004.D4;
import com.sap.tc.moin.testcases.case008.A8;
import com.sap.tc.moin.testcases.case008.Case008Package;
import com.sap.tc.moin.testcases.case008.S8;
import com.sap.tc.moin.testcases.case008.T8;
import com.sap.tc.moin.testcases.case010.Case010Package;
import com.sap.tc.moin.testcases.case011.Case011Package;
import com.sap.tc.moin.testcases.case017.Case017Package;

/**
 * Generic persistence test. Current tests:
 * <p>
 * Primitive attribute with null-value.
 * <p>
 * 
 * @author d026715
 */
public class TestModelPersistence extends CoreMoinTest {

    static boolean EVENTS_CHECK = true;

    protected MoinPackage moinPackage = null;

    protected TestcasesPackage testcasesPackage = null;

    protected Case004Package case004Package = null;

    protected Case008Package case008Package = null;

    protected Case010Package case010Package = null;

    protected Case011Package case011Package = null;

    protected Case017Package case017Package = null;

    protected RefClass a4Class = null;

    protected RefClass d4Class = null;

    protected RefClass a8Class = null;

    protected RefClass a10Class = null;

    protected RefClass a11Class = null;

    protected RefClass a17Class = null;

    protected RefClass b4Class = null;

    protected RefClass b10Class = null;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        testcasesPackage = (TestcasesPackage) getMOINConnection( ).getPackage( null, new String[] { "testcases" } );
        moinPackage = (MoinPackage) getMOINConnection( ).getPackage( null, new String[] { "MOIN" } );
        case004Package = testcasesPackage.getCase004( );
        case008Package = testcasesPackage.getCase008( );
        case010Package = testcasesPackage.getCase010( );
        case011Package = testcasesPackage.getCase011( );
        case017Package = testcasesPackage.getCase017( );
        a4Class = case004Package.getA4( );
        a8Class = case008Package.getA8( );
        a10Class = case010Package.getA10( );
        a11Class = case011Package.getA11( );
        a17Class = case017Package.getA17( );
        b4Class = case004Package.getB4( );
        b10Class = case010Package.getB10( );
        d4Class = case004Package.getD4( );
        // System.setProperty(com.sap.tc.moin.repository.core.Workspace.USE_MICROTRANSACTIONABLES_PARAMETER,
        // "false");

        ModelPartition mp = this._testClient1.getOrCreatePartition( "PersistenceTestSetup" );

        for ( Partitionable element : this.getMOINConnection( ).getNullPartition( ).getElements( ) ) {
            mp.assignElement( element );
        }
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
    }

    private B1 createB1( ) {

        return getMOINConnection( ).createElementInPartition( B1.class, null );
    }

    private A1 createA1( ) {

        return getMOINConnection( ).createElementInPartition( A1.class, null );
    }

    protected A4 createA4( ) {

        A4 a4 = (A4) a4Class.refCreateInstance( );
        a4.setOnePrimitive( "initial" ); // onePrimitive
        a4.setOnePrimitiveNotChangeable( "initial" ); // onePrimitiveNotChangeable
        a4.getManyPrimitive( ).addAll( Arrays.asList( new String[] { "initial0", "initial1", "initial2", "initial3", "initial4" } ) ); // manyPrimitive
        a4.getManyPrimitiveUnique( ).addAll( Arrays.asList( new String[] { "initial0", "initial1", "initial2", "initial3", "initial4" } ) ); // manyPrimitiveUnique
        a4.getManyPrimitiveNotChangeable( ).addAll( Arrays.asList( new String[] { "initial0", "initial1", "initial2", "initial3", "initial4" } ) ); // manyPrimitiveNotChangeable
        a4.getManyPrimitiveOrdered( ).addAll( Arrays.asList( new String[] { "initial0", "initial1", "initial2", "initial3", "initial4" } ) ); // manyPrimitiveOrdered
        a4.getManyPrimitiveOrderedUnique( ).addAll( Arrays.asList( new String[] { "initial0", "initial1", "initial2", "initial3", "initial4" } ) ); // manyPrimitiveOrderedUnique
        a4.setOneBchangeable( createB4( null ) ); // oneBChangeable
        a4.getManyBs( ).addAll( Arrays.asList( createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ) ) ); // manyBs
        a4.getManyBsUnique( ).addAll( Arrays.asList( createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ) ) ); // manyBsUnique
        a4.getManyBsOrdered( ).addAll( Arrays.asList( createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ) ) ); // manyBsOrdered
        a4.getManyBsOrderedUnique( ).addAll( Arrays.asList( createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ) ) ); // manyBsOrderedUnique
        return a4;
    }

    private B4 createB4( String value ) {

        B4 b4 = getMOINConnection( ).createElementInPartition( B4.class, null );
        b4.setOnePrimitive( value );
        return b4;
    }

    private D4 createD4( ) {

        return getMOINConnection( ).createElementInPartition( D4.class, null );
    }

    @Test
    public void testNullAttribute( ) throws Exception {

        // change single-valued attributes
        A4 a4 = createA4( );
        D4 d4 = createD4( );

        a4.setOnePrimitive( null );

        ModelPartition mp = this._testClient1.getOrCreatePartition( "PersistenceNullTest" );

        for ( Partitionable element : this.getMOINConnection( ).getNullPartition( ).getElements( ) ) {
            mp.assignElement( element );
        }

        MRI mriA4 = ( (Partitionable) a4 ).get___Mri( );
        MRI mriD4 = ( (Partitionable) d4 ).get___Mri( );

        this.getMOINConnection( ).save( );

        CoreModelPartition cmp = ( (Wrapper<CoreModelPartition>) mp ).unwrap( );

        cmp.getWorkspace( ).getPartitionManager( ).evictPartitionForced( cmp );

        a4 = (A4) this.getMOINConnection( ).getElement( mriA4 );
        d4 = (D4) this.getMOINConnection( ).getElement( mriD4 );

        // Test null value
        this.verify( a4.getOnePrimitive( ) == null, "String Attribute value must be null." );
        this.verify( d4.getAttributeDoubleOptional( ) == null, "Double Attribute value must be null." );
        this.verify( d4.getAttributeFloatOptional( ) == null, "Float Attribute value must be null." );
        this.verify( d4.getAttributeIntegerOptional( ) == null, "Integer Attribute value must be null." );
        this.verify( d4.isAttributeBooleanOptional( ) == null, "Boolean value must be null." );

        // Set some value
        d4.setAttributeDoubleOptional( 44.0 );
        d4.setAttributeFloatOptional( new Float( 15.3 ) );
        d4.setAttributeIntegerOptional( 128 );
        d4.setAttributeBooleanOptional( true );
        a4.setOnePrimitiveOptional( "test" );

        try {
            this.getMOINConnection( ).save( );
        } catch ( NullPartitionNotEmptyException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace( );
        } catch ( PartitionsNotSavedException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace( );
        }
        cmp = ( (Wrapper<CoreModelPartition>) mp ).unwrap( );
        cmp.getWorkspace( ).getPartitionManager( ).evictPartitionForced( cmp );

        // Load elements from persistence
        a4 = (A4) this.getMOINConnection( ).getElement( mriA4 );
        d4 = (D4) this.getMOINConnection( ).getElement( mriD4 );

        // Set some NULL again
        d4.setAttributeDoubleOptional( null );
        d4.setAttributeFloatOptional( null );
        d4.setAttributeIntegerOptional( null );
        d4.setAttributeBooleanOptional( null );
        a4.setOnePrimitiveOptional( null );

        try {
            this.getMOINConnection( ).save( );
        } catch ( NullPartitionNotEmptyException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace( );
        } catch ( PartitionsNotSavedException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace( );
        }
        cmp = ( (Wrapper<CoreModelPartition>) mp ).unwrap( );
        cmp.getWorkspace( ).getPartitionManager( ).evictPartitionForced( cmp );

        // Load elements from persistence
        a4 = (A4) this.getMOINConnection( ).getElement( mriA4 );
        d4 = (D4) this.getMOINConnection( ).getElement( mriD4 );

        // Test null value
        this.verify( a4.getOnePrimitive( ) == null, "String Attribute value must be null." );
        this.verify( d4.getAttributeDoubleOptional( ) == null, "Double Attribute value must be null." );
        this.verify( d4.getAttributeFloatOptional( ) == null, "Float Attribute value must be null." );
        this.verify( d4.getAttributeIntegerOptional( ) == null, "Integer Attribute value must be null." );
        this.verify( d4.isAttributeBooleanOptional( ) == null, "Boolean value must be null." );
    }

    @Test
    public void testStructureTypes( ) throws Exception {

        StructureFieldContainer<S8> contS8 = new StructureFieldContainer<S8>( );
        StructureFieldContainer<T8> contT8 = new StructureFieldContainer<T8>( );

        int INT_FIELD = 8;
        String STRING_FIELD = "StringValue";

        int T8INT_FIELD = 33;
        String T8STRING_FIELD = "T8Value";

        A8 a8 = getMOINConnection( ).createElementInPartition( A8.class, null );

        contT8.put( T8.DESCRIPTORS.FIELD1( ), T8INT_FIELD ).put( T8.DESCRIPTORS.FIELD2( ), T8STRING_FIELD );
        T8 t8 = case008Package.createT8( contT8 );

        contS8.put( S8.DESCRIPTORS.FIELD1( ), INT_FIELD ).put( S8.DESCRIPTORS.FIELD2( ), STRING_FIELD ).put( S8.DESCRIPTORS.STRUCTURE1( ), t8 );
        S8 s8 = case008Package.createS8( contS8 );

        a8.setOneStructureS( s8 );

        ModelPartition mp = this._testClient1.getOrCreatePartition( "PersisitenceStructureTest" );

        mp.deleteElements( );

        for ( Partitionable element : this.getMOINConnection( ).getNullPartition( ).getElements( ) ) {
            mp.assignElement( element );
        }

        MRI mri = ( (Partitionable) a8 ).get___Mri( );

        this.getMOINConnection( ).save( );

        CoreModelPartition cmp = ( (Wrapper<CoreModelPartition>) mp ).unwrap( );

        cmp.getWorkspace( ).getPartitionManager( ).evictPartitionForced( cmp );

        a8 = (A8) this.getMOINConnection( ).getElement( mri );

        s8 = a8.getOneStructureS( );

        verify( s8 != null, "StructureType attribute must not be null." );

        if ( s8 != null ) {
            verifyAndLog( "Structure field value", s8.getField1( ), INT_FIELD );
            verifyAndLog( "Structure field value", s8.getField2( ), STRING_FIELD );
            t8 = s8.getStructure1( );
            verify( t8 != null, "StructureType attribute must not be null." );
            if ( t8 != null ) {
                verifyAndLog( "Structure field value", t8.getField1( ), T8INT_FIELD );
                verifyAndLog( "Structure field value", t8.getField2( ), T8STRING_FIELD );
            }
        }

    }

    @Test
    public void testPartitionDelta( ) throws NullPartitionNotEmptyException, PartitionsNotSavedException {

        StructureFieldContainer<S8> contS8 = new StructureFieldContainer<S8>( );
        StructureFieldContainer<T8> contT8 = new StructureFieldContainer<T8>( );

        // change single-valued attributes
        A4 a4 = createA4( );

        ModelPartition mp = this._testClient1.getOrCreatePartition( "PersistenceDeltaTest" );

        for ( Partitionable element : this.getMOINConnection( ).getNullPartition( ).getElements( ) ) {
            mp.assignElement( element );
        }

        MRI mri = ( (Partitionable) a4 ).get___Mri( );

        this.getMOINConnection( ).save( );

        a4 = (A4) this.getMOINConnection( ).getElement( mri );

        // add element
        A1 a1 = this.createA1( );
        mp.assignElement( a1 );
        this.getMOINConnection( ).save( );

        // add link
        B1 b1 = this.createB1( );
        mp.assignElement( b1 );
        a1.getBs( ).add( b1 );
        this.getMOINConnection( ).save( );

        // add attribute
        a4.setOnePrimitiveOptional( "Value1" );
        this.getMOINConnection( ).save( );

        // change attribute
        a4.setOnePrimitiveOptional( "Value2" );
        this.getMOINConnection( ).save( );

        a4.getManyBs( ).add( createB4( "B4" ) );
        this.getMOINConnection( ).save( );

        int INT_FIELD = 8;
        String STRING_FIELD = "StringValue";

        int T8INT_FIELD = 33;
        String T8STRING_FIELD = "T8Value";

        A8 a8 = getMOINConnection( ).createElementInPartition( A8.class, mp );
        this.getMOINConnection( ).save( );

        contT8.put( T8.DESCRIPTORS.FIELD1( ), T8INT_FIELD ).put( T8.DESCRIPTORS.FIELD2( ), T8STRING_FIELD );
        T8 t8 = case008Package.createT8( contT8 );
        contS8.put( S8.DESCRIPTORS.FIELD1( ), INT_FIELD ).put( S8.DESCRIPTORS.FIELD2( ), STRING_FIELD ).put( S8.DESCRIPTORS.STRUCTURE1( ), t8 );
        S8 s8 = case008Package.createS8( contS8 );
        a8.setOneStructureS( s8 );
        this.getMOINConnection( ).save( );

        // String value = a4.getOnePrimitive();
        //        
        // this.verify(value == null, "Attribute value must be null.");

    }

    private void evictPartition( ModelPartition mp ) {

        CoreModelPartition cmp = ( (Wrapper<CoreModelPartition>) mp ).unwrap( );

        cmp.getWorkspace( ).getPartitionManager( ).evictPartition( cmp );
    }

}
