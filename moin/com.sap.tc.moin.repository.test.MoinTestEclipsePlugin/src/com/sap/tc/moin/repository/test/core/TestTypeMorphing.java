/*
 * Created on 08.06.2006
 */
package com.sap.tc.moin.repository.test.core;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.junit.Test;
import org.omg.ocl.stdlibrary.BagTypeStdLib;
import org.omg.ocl.stdlibrary.CollectionTypeStdLib;

import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.commands.PartitionOperation.Operation;
import com.sap.tc.moin.repository.util.MigrateToSubTypeCommand;
import com.sap.tc.moin.testcases.case003.A3;
import com.sap.tc.moin.testcases.case003.B3;
import com.sap.tc.moin.testcases.case003.B3Sub;
import com.sap.tc.moin.testcases.case003.C3;
import com.sap.tc.moin.testcases.case003.OrderedReferences;
import com.sap.tc.moin.testcases.case003.StorageAtA3;
import com.sap.tc.moin.testcases.case004.A4;
import com.sap.tc.moin.testcases.case004.A4Sub;
import com.sap.tc.moin.testcases.case004.B4;
import com.sap.tc.moin.testcases.case004.D4;
import com.sap.tc.moin.testcases.case004.D4Sub;
import com.sap.tc.moin.testcases.case013.B13;
import com.sap.tc.moin.testcases.case013.B13Sub1Sub2;
import com.sap.tc.moin.testcases.case023.A23;
import com.sap.tc.moin.testcases.case023.A23Sub;
import com.sap.tc.moin.testcases.case023.Aa;

public class TestTypeMorphing extends CoreMoinTest {

    @Test
    public void testIllegalSubType( ) throws Exception {

        RefObject a4 = createA4( );
        try {
            new MigrateToSubTypeCommand( getMOINConnection( ), null, a4, D4Sub.CLASS_DESCRIPTOR );
            fail( "Expected IllegalArgumentException" );
        } catch ( IllegalArgumentException e ) {
            // expected
        }

    }

    @Test
    public void testIdenticalType( ) throws Exception {

        RefObject a4 = createA4( );
        try {
            new MigrateToSubTypeCommand( getMOINConnection( ), null, a4, A4.CLASS_DESCRIPTOR );
            fail( "Expected IllegalArgumentException" );
        } catch ( IllegalArgumentException e ) {
            // expected
        }

    }

    @Test
    public void testCopyAttributesOfA4( ) throws Exception {

        A4 a4 = createA4( );
        MigrateToSubTypeCommand migrateToSubType = new MigrateToSubTypeCommand( getMOINConnection( ), null, a4, A4Sub.CLASS_DESCRIPTOR );
        migrateToSubType.execute( );
        A4Sub a4sub = (A4Sub) migrateToSubType.getMigratedElement( );
        assertNotNull( a4sub );

        assertEquals( a4sub.getOnePrimitive( ), "initial" );
        assertNull( a4sub.getOnePrimitiveOptional( ) );
        assertEquals( a4sub.getOnePrimitiveNotChangeable( ), "initial" );
        assertEquals( a4sub.getManyPrimitive( ).size( ), 5 );
        assertTrue( a4sub.getManyPrimitive( ).contains( "initial4" ) );
        assertEquals( a4sub.getManyPrimitiveUnique( ).size( ), 5 );
        assertTrue( a4sub.getManyPrimitiveUnique( ).contains( "initial4" ) );
        assertEquals( a4sub.getManyPrimitiveOptional( ).size( ), 0 );
        assertEquals( a4sub.getManyPrimitiveNotChangeable( ).size( ), 5 );
        assertTrue( a4sub.getManyPrimitiveNotChangeable( ).contains( "initial3" ) );
        assertEquals( a4sub.getManyPrimitiveOrdered( ).size( ), 5 );
        assertTrue( a4sub.getManyPrimitiveOrdered( ) instanceof List );
        assertTrue( a4sub.getManyPrimitiveOrdered( ).get( 2 ).equals( "initial2" ) );
        assertEquals( a4sub.getManyPrimitiveOrderedUnique( ).size( ), 5 );
        assertTrue( a4sub.getManyPrimitiveOrderedUnique( ) instanceof List );
        assertTrue( a4sub.getManyPrimitiveOrderedUnique( ).get( 1 ).equals( "initial1" ) );
        assertEquals( a4sub.getManyPrimitiveOrderedNotChangeable( ).size( ), 0 );

        assertNotNull( a4sub.getOneBchangeable( ) );
        assertNull( a4sub.getOneBnotChangeable( ) );
        assertNull( a4sub.getOneBoptional( ) );
        assertEquals( a4sub.getManyBs( ).size( ), 5 );
        assertTrue( a4sub.getManyBs( ).iterator( ).next( ).getOnePrimitive( ).startsWith( "B4-Initial" ) );
        assertEquals( a4sub.getManyBsUnique( ).size( ), 0 );
        assertEquals( a4sub.getManyBsNotUnique( ).size( ), 0 );
        assertEquals( a4sub.getManyBsOrdered( ).size( ), 5 );

    }

    @Test
    public void testCopyAttributesOfD4( ) throws Exception {

        D4 d4 = createD4( );
        MigrateToSubTypeCommand migrateToSubType = new MigrateToSubTypeCommand( getMOINConnection( ), null, d4, D4Sub.CLASS_DESCRIPTOR );
        migrateToSubType.execute( );
        D4Sub d4sub = (D4Sub) migrateToSubType.getMigratedElement( );

        assertNotNull( d4sub );
        assertFalse( ( (Partitionable) d4 ).is___Alive( ) );

        assertTrue( d4sub.isAttributeBoolean( ) );
        assertTrue( d4sub.isAttributeBooleanOptional( ) );
        assertEquals( d4sub.getAttributeDouble( ), 1.1 );
        assertEquals( d4sub.getAttributeDoubleOptional( ), 1.2 );
    }

    @Test
    public void testCopyLinksOfB3( ) throws Exception {

        RefObject b3 = getMOINConnection( ).createElementInPartition( B3.class, null );
        OrderedReferences orderedReferences = getMOINConnection( ).getAssociation( OrderedReferences.ASSOCIATION_DESCRIPTOR );
        StorageAtA3 storageAtA3 = getMOINConnection( ).getAssociation( StorageAtA3.ASSOCIATION_DESCRIPTOR );
        A3 a3_1 = getMOINConnection( ).createElementInPartition( A3.class, null );
        A3 a3_2 = getMOINConnection( ).createElementInPartition( A3.class, null );
        orderedReferences.add( (B3) b3, a3_1 );
        storageAtA3.add( a3_2, (B3) b3 );
        assertEquals( b3, storageAtA3.getB3( a3_2 ) );

        MigrateToSubTypeCommand migrateToSubType = new MigrateToSubTypeCommand( getMOINConnection( ), null, b3, B3Sub.CLASS_DESCRIPTOR );
        migrateToSubType.execute( );
        B3Sub b3sub = (B3Sub) migrateToSubType.getMigratedElement( );

        assertNotNull( b3sub );
        assertFalse( ( (Partitionable) b3 ).is___Alive( ) );

        List<B3> y = orderedReferences.getY( a3_1 );
        assertTrue( y.contains( b3sub ) );

        assertEquals( b3sub, storageAtA3.getB3( a3_2 ) );
    }

    @Test
    public void testCopyLinksOfA3( ) throws Exception {

        A3 a3 = getMOINConnection( ).createElementInPartition( A3.class, null );
        OrderedReferences orderedReferences = getMOINConnection( ).getAssociation( OrderedReferences.ASSOCIATION_DESCRIPTOR );
        StorageAtA3 storageAtA3 = getMOINConnection( ).getAssociation( StorageAtA3.ASSOCIATION_DESCRIPTOR );
        B3 b3_1 = getMOINConnection( ).createElementInPartition( B3.class, null );
        B3 b3_2 = getMOINConnection( ).createElementInPartition( B3.class, null );
        orderedReferences.add( b3_1, a3 );
        storageAtA3.add( a3, b3_2 );

        MigrateToSubTypeCommand migrateToSubType = new MigrateToSubTypeCommand( getMOINConnection( ), null, a3, C3.CLASS_DESCRIPTOR );
        migrateToSubType.execute( );
        C3 a3sub = (C3) migrateToSubType.getMigratedElement( );

        assertNotNull( a3sub );
        assertFalse( ( (Partitionable) a3 ).is___Alive( ) );

        assertEquals( a3sub, orderedReferences.getA3( b3_1 ) );

        assertEquals( a3sub, storageAtA3.getZ( b3_2 ) );
    }

    @Test
    public void testCopyLinksOfSelfReferencingElementOrdered( ) throws Exception {

        GeneralizableElement element = getMOINConnection( ).createElementInPartition( CollectionTypeStdLib.class, null );
        element.getSupertypes( ).add( element );
        assertNotNull( element );

        MigrateToSubTypeCommand migrateToSubType = new MigrateToSubTypeCommand( getMOINConnection( ), null, element, BagTypeStdLib.CLASS_DESCRIPTOR );
        migrateToSubType.execute( );
        BagTypeStdLib bagTypeStdLib = (BagTypeStdLib) migrateToSubType.getMigratedElement( );
        List<GeneralizableElement> supertypes = bagTypeStdLib.getSupertypes( );
        assertEquals( 1, supertypes.size( ) );
        assertEquals( bagTypeStdLib, supertypes.get( 0 ) );
    }

    @Test
    public void testCopyLinksOfSelfReferencingElementNonOrdered( ) throws Exception {

        A23 element = getMOINConnection( ).createElementInPartition( A23.class, null );
        Aa association = getMOINConnection( ).getAssociation( Aa.ASSOCIATION_DESCRIPTOR );
        association.add( element, element );
        assertNotNull( element );

        MigrateToSubTypeCommand migrateToSubType = new MigrateToSubTypeCommand( getMOINConnection( ), null, element, A23Sub.CLASS_DESCRIPTOR );
        migrateToSubType.execute( );
        A23Sub subElement = (A23Sub) migrateToSubType.getMigratedElement( );
        assertFalse( element.is___Alive( ) );
        assertTrue( association.exists( subElement, subElement ) );

        Collection<A23> down = association.getADown( subElement );
        assertEquals( 1, down.size( ) );
        assertEquals( subElement, down.iterator( ).next( ) );

        Collection<A23> up = association.getAUp( subElement );
        assertEquals( 1, up.size( ) );
        assertEquals( subElement, up.iterator( ).next( ) );

    }

    @Test
    public void testGetAffecteddPartitionsOfA3( ) throws Exception {

        A3 a3 = getMOINConnection( ).createElementInPartition( A3.class, getPartitionOne( ) );
        OrderedReferences orderedReferences = getMOINConnection( ).getAssociation( OrderedReferences.ASSOCIATION_DESCRIPTOR );
        StorageAtA3 storageAtA3 = getMOINConnection( ).getAssociation( StorageAtA3.ASSOCIATION_DESCRIPTOR );
        B3 b3_1 = getMOINConnection( ).createElementInPartition( B3.class, getPartitionTwo( ) );
        B3 b3_2 = getMOINConnection( ).createElementInPartition( B3.class, getPartitionThree( ) );
        orderedReferences.add( b3_1, a3 );
        storageAtA3.add( a3, b3_2 );

        MigrateToSubTypeCommand migrateToSubType = new MigrateToSubTypeCommand( getMOINConnection( ), null, a3, C3.CLASS_DESCRIPTOR );
        Collection<PartitionOperation> affectedPartitions = migrateToSubType.getAffectedPartitions( );
        assertEquals( 1, affectedPartitions.size( ) );
        assertTrue( affectedPartitions.contains( new PartitionOperation( Operation.EDIT, getPartitionOne( ).getPri( ) ) ) );
    }

    @Test
    public void testGetAffecteddPartitionsOfB3( ) throws Exception {

        RefObject b3 = getMOINConnection( ).createElementInPartition( B3.class, getPartitionOne( ) );
        OrderedReferences orderedReferences = getMOINConnection( ).getAssociation( OrderedReferences.ASSOCIATION_DESCRIPTOR );
        StorageAtA3 storageAtA3 = getMOINConnection( ).getAssociation( StorageAtA3.ASSOCIATION_DESCRIPTOR );
        A3 a3_1 = getMOINConnection( ).createElementInPartition( A3.class, getPartitionTwo( ) );
        A3 a3_2 = getMOINConnection( ).createElementInPartition( A3.class, getPartitionThree( ) );
        orderedReferences.add( (B3) b3, a3_1 );
        storageAtA3.add( a3_2, (B3) b3 );
        assertEquals( b3, storageAtA3.getB3( a3_2 ) );

        MigrateToSubTypeCommand migrateToSubType = new MigrateToSubTypeCommand( getMOINConnection( ), null, b3, B3Sub.CLASS_DESCRIPTOR );
        Collection<PartitionOperation> affectedPartitions = migrateToSubType.getAffectedPartitions( );
        assertEquals( 3, affectedPartitions.size( ) );
        assertTrue( affectedPartitions.contains( new PartitionOperation( Operation.EDIT, getPartitionOne( ).getPri( ) ) ) );
        assertTrue( affectedPartitions.contains( new PartitionOperation( Operation.EDIT, getPartitionTwo( ).getPri( ) ) ) );
        assertTrue( affectedPartitions.contains( new PartitionOperation( Operation.EDIT, getPartitionThree( ).getPri( ) ) ) );
    }

    @Test
    public void testMorphMultipleHierarchies( ) throws Exception {

        B13 b13 = getMOINConnection( ).createElement( B13.class );
        b13.setNotInitializedStringAttribute1( "Attr1" );

        MigrateToSubTypeCommand migrateToSubType = new MigrateToSubTypeCommand( getMOINConnection( ), null, b13, B13Sub1Sub2.CLASS_DESCRIPTOR );
        migrateToSubType.execute( );
        B13Sub1Sub2 migratedElement = (B13Sub1Sub2) migrateToSubType.getMigratedElement( );

        assertEquals( migratedElement.getNotInitializedStringAttribute1( ), "Attr1" );
    }

    private A4 createA4( ) {

        A4 a4 = getMOINConnection( ).createElementInPartition( A4.class, null );
        a4.setOnePrimitive( "initial" ); // onePrimitive
        a4.setOnePrimitiveNotChangeable( "initial" ); // onePrimitiveNotChangeable
        a4.getManyPrimitive( ).addAll( Arrays.asList( new String[] { "initial0", "initial1", "initial2", "initial3", "initial4" } ) ); // manyPrimitive
        a4.getManyPrimitiveUnique( ).addAll( Arrays.asList( new String[] { "initial0", "initial1", "initial2", "initial3", "initial4" } ) ); // manyPrimitiveUnique
        a4.getManyPrimitiveNotChangeable( ).addAll( Arrays.asList( new String[] { "initial0", "initial1", "initial2", "initial3", "initial4" } ) ); // manyPrimitiveNotChangeable
        a4.getManyPrimitiveOrdered( ).addAll( Arrays.asList( new String[] { "initial0", "initial1", "initial2", "initial3", "initial4" } ) ); // manyPrimitiveOrdered
        a4.getManyPrimitiveOrderedUnique( ).addAll( Arrays.asList( new String[] { "initial0", "initial1", "initial2", "initial3", "initial4" } ) ); // manyPrimitiveOrderedUnique
        a4.setOneBchangeable( getMOINConnection( ).createElementInPartition( B4.class, null ) ); // oneBChangeable
        a4.getManyBs( ).addAll( Arrays.asList( createB4( "B4-Initial0" ), createB4( "B4-Initial1" ), createB4( "B4-Initial2" ), createB4( "B4-Initial3" ), createB4( "B4-Initial4" ) ) ); // manyBs
        a4.getManyBsOrdered( ).addAll( Arrays.asList( createB4( "B4-Initial0" ), createB4( "B4-Initial1" ), createB4( "B4-Initial2" ), createB4( "B4-Initial3" ), createB4( "B4-Initial4" ) ) ); // manyBsOrdered
        a4.getManyBsOrderedUnique( ).addAll( Arrays.asList( createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ) ) ); // manyBsOrderedUnique
        return a4;
    }

    private B4 createB4( String value ) {

        B4 b4 = getMOINConnection( ).createElementInPartition( B4.class, null );
        b4.setOnePrimitive( value );
        return b4;
    }

    private D4 createD4( ) {

        D4 d4 = getMOINConnection( ).createElementInPartition( D4.class, null );
        d4.setAttributeBoolean( true );
        d4.setAttributeBooleanOptional( true );
        d4.setAttributeDouble( 1.1 );
        d4.setAttributeDoubleOptional( 1.2 );
        d4.setAttributeFloat( 1.3f );
        d4.setAttributeFloatOptional( 1.5f );
        d4.setAttributeInteger( 1 );
        d4.setAttributeIntegerOptional( 2 );
        d4.setAttributeLong( 3 );
        d4.setAttributeLongOptional( 4L );
        d4.setAttributeString( "String" );
        d4.setAttributeStringOptional( "StringOptional" );
        return d4;
    }
}