package com.sap.tc.moin.repository.test.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.mi.gfw.mm.graphics.GraphicsPackage;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.DiagramAggregatesConnections;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.DeepCopyError;
import com.sap.tc.moin.repository.DeepCopyMap;
import com.sap.tc.moin.repository.DeepCopyMappingEntry;
import com.sap.tc.moin.repository.DeepCopyPolicy;
import com.sap.tc.moin.repository.DeepCopyPolicyHandler;
import com.sap.tc.moin.repository.DeepCopyResultSet;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.ReferencedTransientElementsException;
import com.sap.tc.moin.repository.DeepCopyError.DeepCopyErrorType;
import com.sap.tc.moin.repository.DeepCopyPolicy.DeepCopyPolicyOption;
import com.sap.tc.moin.repository.core.ConnectionWrapper;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Contains;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.repository.test.query.generatedmetamodel.Assoc0Composite;
import com.sap.tc.moin.repository.test.query.generatedmetamodel.Assoc0x1;
import com.sap.tc.moin.repository.test.query.generatedmetamodel.Assoc0xRefElement;
import com.sap.tc.moin.repository.test.query.generatedmetamodel.Assoc1Composite;
import com.sap.tc.moin.repository.test.query.generatedmetamodel.Assoc1xRefElement;
import com.sap.tc.moin.repository.test.query.generatedmetamodel.Assoc2x1;
import com.sap.tc.moin.repository.test.query.generatedmetamodel.Assoc2xRefElement;
import com.sap.tc.moin.repository.test.query.generatedmetamodel.Assoc3x1;
import com.sap.tc.moin.repository.test.query.generatedmetamodel.EnumTpEnum;
import com.sap.tc.moin.repository.test.query.generatedmetamodel.GeneratedmetamodelPackage;
import com.sap.tc.moin.repository.test.query.generatedmetamodel.StructInStructTp;
import com.sap.tc.moin.repository.test.query.generatedmetamodel.StructTp;
import com.sap.tc.moin.repository.test.query.generatedmetamodel.TestClass0;
import com.sap.tc.moin.repository.test.query.generatedmetamodel.TestClass1;
import com.sap.tc.moin.repository.test.query.generatedmetamodel.TestClass2;
import com.sap.tc.moin.repository.test.query.generatedmetamodel.TestClass3;
import com.sap.tc.moin.repository.test.query.generatedmetamodel.TestSubClass0;
import com.sap.tc.moin.repository.test.query.generatedmetamodel.TestSubClass1;
import com.sap.tc.moin.test.fw.TestClient;
import com.sap.tc.moin.testcases.case004.A4;
import com.sap.tc.moin.testcases.case004.B4;
import com.sap.tc.moin.testcases.case019.B19;
import com.sap.tc.moin.testcases.case019.serializationcallback.B19Serialization;
import com.sap.tc.moin.testcases.case019.translatabletexts.A19TranslatableTextFragment;
import com.sap.tc.moin.testcases.case019.translatabletexts.TranslatabletextsPackage;
import com.sap.tc.moin.testcasesfoundation.case001f.A1f;
import com.sap.tc.moin.testcasesfoundation.case004f.ButtonTextF;
import com.sap.tc.moin.testcasesfoundation.case004f.Case004fPackage;
import com.sap.tc.moin.textverticalization.TextverticalizationPackage;
import com.sap.tc.moin.textverticalization.TranslatableText;
import com.sap.tc.moin.textverticalization.TranslatableTextFragment;

/**
 * @author d046918
 */
@SuppressWarnings( { "nls", "unchecked" } )
public class TestDeepCopy extends CoreMoinTest {

    protected static final MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, TestDeepCopy.class );

    protected Connection myConn;

    static protected TestClient myTestClient;

    public TestDeepCopy( ) {

    }

    protected void clear( ) {

        if ( myConn != null ) {
            myConn.close( );
        }
        if ( myTestClient != null ) {
            myTestClient.clear( );
        }
        myTestClient = null;
        myConn = null;
    }

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        myTestClient = getTestHelper( ).getDefaultTestClient( true );
        myTestClient.setAsCurrentClient( );
        myConn = myTestClient.getConnection( );
        super.beforeTestMethod( );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        clear( );
        super.afterTestMethod( );
    }

    /**
     * Test that the attributes has been copied correctly
     */
    @Test
    public void testIdentity( ) {

        GeneratedmetamodelPackage gpackage1 = (GeneratedmetamodelPackage) ( myConn.getPackage( null, new String[] { "generatedmetamodel" } ) );
        TestClass0 tc0 = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );

        tc0.setName( "TestClass0Inst0" );
        tc0.setAttrInt0( 0 );
        tc0.setAttrDouble0( 0 );
        tc0.setAttrString0( "TestClass0Inst0attrString0" );

        List<RefObject> list1 = new ArrayList<RefObject>( );
        list1.add( tc0 );

        DeepCopyResultSet resultSet = myConn.deepCopy( list1, null, true );
        Collection<RefObject> copiedElements = resultSet.getCopiedElements( );

        boolean containsTc0 = false;

        for ( RefObject copy : copiedElements ) {
            assertFalse( copy.equals( tc0 ) );
            assertTrue( ( (TestClass0) copy ).getAttrString0( ) == "TestClass0Inst0attrString0" );
            if ( copy.refGetValue( "name" ) == "TestClass0Inst0" ) {
                containsTc0 = true;
            }
        }
        assertTrue( containsTc0 );
    }

    /**
     * Test that elements with object valued attributes are correctly copied
     */
    @Test
    public void testObjectValuedAttributes( ) {

        GeneratedmetamodelPackage gpackage1 = (GeneratedmetamodelPackage) ( myConn.getPackage( null, new String[] { "generatedmetamodel" } ) );
        TestClass0 tc0 = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );

        tc0.setName( "TestClass0Inst0" );

        TestClass0 tc0ov0 = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc0ov0.setName( "TestClass0Inst0attrObjValued0" );
        TestClass1 tc0ov1 = (TestClass1) gpackage1.getTestClass1( ).refCreateInstance( );
        tc0ov1.setName( "TestClass0Inst0attrObjValued1" );
        TestClass2 tc0ov2 = (TestClass2) gpackage1.getTestClass2( ).refCreateInstance( );
        tc0ov2.setName( "TestClass0Inst0attrObjValued2" );

        tc0.setAttrObjectValued0( tc0ov0 );
        tc0.setAttrObjectValued1( tc0ov1 );
        tc0.setAttrObjectValued2( tc0ov2 );

        TestClass0 tc0ov0ov0 = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc0ov0ov0.setName( "TestClass0Inst0attrObjValued0attrObjValued0" );
        TestClass1 tc0ov0ov1 = (TestClass1) gpackage1.getTestClass1( ).refCreateInstance( );
        tc0ov0ov1.setName( "TestClass0Inst0attrObjValued0attrObjValued1" );
        TestClass2 tc0ov0ov2 = (TestClass2) gpackage1.getTestClass2( ).refCreateInstance( );
        tc0ov0ov2.setName( "TestClass0Inst0attrObjValued0attrObjValued2" );

        tc0ov0.setAttrObjectValued0( tc0ov0ov0 );
        tc0ov0.setAttrObjectValued1( tc0ov0ov1 );
        tc0ov0.setAttrObjectValued2( tc0ov0ov2 );

        List<RefObject> list1 = new ArrayList<RefObject>( );
        list1.add( tc0 );

        DeepCopyResultSet resultSet = myConn.deepCopy( list1, null, true );
        Collection<RefObject> copiedElements = resultSet.getCopiedElements( );

        boolean containsTc0 = false;

        for ( RefObject copy : copiedElements ) {
            if ( copy instanceof TestClass0 && ( (TestClass0) copy ).getName( ).equals( "TestClass0Inst0" ) ) {
                assertTrue( ( (TestClass0) copy ).getAttrObjectValued0( ).getAttrObjectValued2( ).getName( ) == "TestClass0Inst0attrObjValued0attrObjValued2" );
                containsTc0 = true;
                break;
            }
        }

        assertTrue( containsTc0 );
    }

    /**
     * Test that elements with object valued attributes with multiplicity n are
     * correctly copied
     */
    @Test
    public void testObjectValuedAttributesN( ) {

        // Test with empty attribute
        A4 a4Empty = myConn.createElement( A4.CLASS_DESCRIPTOR );
        a4Empty.setOnePrimitive( "a4Empty" );

        // Test with 2 attributes 
        A4 a4with2Attributes = myConn.createElement( A4.CLASS_DESCRIPTOR );
        a4with2Attributes.setOnePrimitive( "a4with2Attributes" );
        Collection<B4> manyBs = a4with2Attributes.getManyBs( );
        B4 b4_01 = myConn.createElement( B4.CLASS_DESCRIPTOR );
        b4_01.setOnePrimitive( "b4_01" );
        manyBs.add( b4_01 );
        B4 b4_02 = myConn.createElement( B4.CLASS_DESCRIPTOR );
        b4_02.setOnePrimitive( "b4_02" );
        manyBs.add( b4_02 );

        List<RefObject> list1 = new ArrayList<RefObject>( );
        list1.add( a4Empty );
        list1.add( a4with2Attributes );

        DeepCopyResultSet resultSet = myConn.deepCopy( list1, null, true );
        Collection<RefObject> copiedElements = resultSet.getCopiedElements( );

        boolean foundA4Empty = false;
        boolean foundA4with2Attributes = false;
        boolean foundA4Attributes = false;

        assert ( copiedElements.size( ) == 4 );
        for ( RefObject copy : copiedElements ) {
            if ( copy instanceof A4 ) {
                A4 copiedA4 = ( (A4) copy );
                String a4Name = copiedA4.getOnePrimitive( );
                if ( "a4Empty".equals( a4Name ) ) {
                    foundA4Empty = true;
                } else if ( "a4with2Attributes".equals( a4Name ) ) {
                    foundA4with2Attributes = true;
                    foundA4Attributes = ( copiedA4.getManyBs( ).size( ) == 2 );
                }
            }
        }

        assertTrue( "a4Empty not copied correctly", foundA4Empty );
        assertTrue( "a4with2Attributes not copied correctly", foundA4with2Attributes );
        assertTrue( "Attributes of a4with2Attributes not copied correctly", foundA4Attributes );
    }

    /**
     * Test that elements with object valued attributes that have composite
     * children are correctly copied
     */
    @Test
    public void testObjectValuedAttributesWithCompositeChildren( ) {

        TestClass0 a = myConn.createElementInPartition( TestClass0.CLASS_DESCRIPTOR, getPartitionOne( ) );
        a.setName( "a" );
        TestClass0 b = myConn.createElementInPartition( TestClass0.CLASS_DESCRIPTOR, getPartitionOne( ) );
        b.setName( "b" );
        TestClass0 c = myConn.createElementInPartition( TestClass0.CLASS_DESCRIPTOR, getPartitionOne( ) );
        c.setName( "c" );
        TestClass0 d = myConn.createElementInPartition( TestClass0.CLASS_DESCRIPTOR, getPartitionOne( ) );
        d.setName( "d" );
        TestClass1 e = myConn.createElementInPartition( TestClass1.CLASS_DESCRIPTOR, getPartitionOne( ) );
        e.setName( "e" );
        TestClass2 f = myConn.createElementInPartition( TestClass2.CLASS_DESCRIPTOR, getPartitionOne( ) );
        f.setName( "f" );

        a.setAttrObjectValued0( b );
        b.getReference0Composite( ).add( c );
        b.getReference0x1( ).add( e ); // should not be copied (because of 0..1) !!
        c.getReference0Composite( ).add( d );
        f.getReference2x0( ).add( b ); // should be copied, i.e. bCopy should also be referenced by f 

        DeepCopyResultSet resultSet = myConn.deepCopy( Collections.singletonList( (RefObject) a ), null, true );
        Collection<RefObject> copiedElements = resultSet.getCopiedElements( );

        assertEquals( 4, copiedElements.size( ) );

        TestClass0 aCopy = null;
        for ( RefObject copy : copiedElements ) {
            if ( copy.refGetValue( "name" ).equals( "a" ) ) {
                aCopy = (TestClass0) copy;
                break;
            }
        }
        assertNotNull( aCopy );

        TestClass0 bCopy = aCopy.getAttrObjectValued0( );
        assertNotNull( bCopy );
        assertEquals( "b", bCopy.getName( ) );
        assertFalse( b.get___Mri( ).equals( bCopy.get___Mri( ) ) );

        Collection<TestClass0> compositeChildren = bCopy.getReference0Composite( );
        assertEquals( 1, compositeChildren.size( ) );
        TestClass0 cCopy = compositeChildren.iterator( ).next( );
        assertNotNull( cCopy );
        assertEquals( "c", cCopy.getName( ) );
        assertFalse( c.get___Mri( ).equals( cCopy.get___Mri( ) ) );

        Collection<TestClass0> compositeChildrenOfC = cCopy.getReference0Composite( );
        assertEquals( 1, compositeChildrenOfC.size( ) );
        TestClass0 dCopy = compositeChildrenOfC.iterator( ).next( );
        assertNotNull( dCopy );
        assertEquals( "d", dCopy.getName( ) );
        assertFalse( d.get___Mri( ).equals( dCopy.get___Mri( ) ) );

        Collection<TestClass1> reference0x1 = bCopy.getReference0x1( );
        assertEquals( 0, reference0x1.size( ) );

        Collection<TestClass0> reference2x0 = f.getReference2x0( );
        assertEquals( 2, reference2x0.size( ) );
        boolean bFound = false, bCopyFound = false;
        for ( TestClass0 testClass0 : reference2x0 ) {
            if ( testClass0.equals( b ) ) {
                bFound = true;
            }
            if ( testClass0.equals( bCopy ) ) {
                bCopyFound = true;
            }
        }
        assertTrue( bFound );
        assertTrue( bCopyFound );
    }

    @Test
    public void testEnumerationAttributes( ) {

        GeneratedmetamodelPackage gpackage1 = (GeneratedmetamodelPackage) ( myConn.getPackage( null, new String[] { "generatedmetamodel" } ) );
        TestClass0 tc0 = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );

        tc0.setName( "TestClass0Inst0" );

        tc0.setAttrEnum( EnumTpEnum.LABEL7 );

        List<RefObject> list1 = new ArrayList<RefObject>( );
        list1.add( tc0 );

        DeepCopyResultSet resultSet = myConn.deepCopy( list1, null, true );
        Collection<RefObject> copiedElements = resultSet.getCopiedElements( );

        boolean containsTc0 = false;

        for ( RefObject copy : copiedElements ) {
            assertTrue( ( (TestClass0) copy ).getAttrEnum( ).equals( EnumTpEnum.LABEL7 ) );
            if ( copy.refGetValue( "name" ) == "TestClass0Inst0" ) {
                containsTc0 = true;
            }
        }

        assertTrue( containsTc0 );

    }

    @Test
    public void testStructureTypedAttributes( ) {

        StructureFieldContainer<StructInStructTp> contStructInStructTp = new StructureFieldContainer<StructInStructTp>( );
        StructureFieldContainer<StructTp> contStructTp = new StructureFieldContainer<StructTp>( );

        GeneratedmetamodelPackage gpackage1 = (GeneratedmetamodelPackage) ( myConn.getPackage( null, new String[] { "generatedmetamodel" } ) );
        TestClass0 tc0 = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );

        tc0.setName( "TestClass0Inst0" );

        contStructInStructTp.put( StructInStructTp.DESCRIPTORS.FIELD1( ), 23 ).put( StructInStructTp.DESCRIPTORS.FIELD2( ), "innerStructString" );
        StructInStructTp innerStructAttr = gpackage1.createStructInStructTp( contStructInStructTp );
        contStructTp.put( StructTp.DESCRIPTORS.FIELD1( ), 42 ).put( StructTp.DESCRIPTORS.FIELD2( ), "structString" ).put( StructTp.DESCRIPTORS.FIELD3( ), innerStructAttr );
        StructTp structureTypedAttr = gpackage1.createStructTp( contStructTp );
        tc0.setAttrStruct( structureTypedAttr );

        List<RefObject> list1 = new ArrayList<RefObject>( );
        list1.add( tc0 );

        DeepCopyResultSet resultSet = myConn.deepCopy( list1, null, true );
        Collection<RefObject> copiedElements = resultSet.getCopiedElements( );

        boolean containsTc0 = false;

        for ( RefObject copy : copiedElements ) {
            assertTrue( ( (TestClass0) copy ).getAttrStruct( ).getField1( ) == 42 );
            assertTrue( ( (TestClass0) copy ).getAttrStruct( ).getField3( ).getField1( ) == 23 );
            if ( copy.refGetValue( "name" ) == "TestClass0Inst0" ) {
                containsTc0 = true;
            }
        }

        assertTrue( containsTc0 );
    }

    @Test
    public void testMultiValuedAttributes( ) {

        GeneratedmetamodelPackage gpackage1 = (GeneratedmetamodelPackage) ( myConn.getPackage( null, new String[] { "generatedmetamodel" } ) );
        TestClass0 tc0 = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );

        tc0.setName( "TestClass0Inst0" );

        Collection<String> mv0 = tc0.getAttrStringMultiValued0( );

        mv0.add( "TestClass0Inst0attrStringMv0value0" );
        mv0.add( "TestClass0Inst0attrStringMv0value1" );
        mv0.add( "TestClass0Inst0attrStringMv0value2" );

        List<RefObject> list1 = new ArrayList<RefObject>( );
        list1.add( tc0 );

        DeepCopyResultSet resultSet = myConn.deepCopy( list1, null, true );
        Collection<RefObject> copiedElements = resultSet.getCopiedElements( );

        boolean containsTc0 = false;

        for ( RefObject copy : copiedElements ) {
            assertTrue( ( (TestClass0) copy ).getAttrStringMultiValued0( ).containsAll( mv0 ) );
            if ( copy.refGetValue( "name" ) == "TestClass0Inst0" ) {
                containsTc0 = true;
            }
        }

        assertTrue( containsTc0 );

    }

    /**
     * Test that composite children are also copied when not explicitly given as
     * seed.
     */
    @Test
    public void testCompositeChildren( ) {

        GeneratedmetamodelPackage gpackage1 = (GeneratedmetamodelPackage) ( myConn.getPackage( null, new String[] { "generatedmetamodel" } ) );
        TestClass0 tc0 = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc0.setName( "tc0" );
        TestClass0 tc0child1 = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc0child1.setName( "tc0child1" );
        TestClass0 tc0child2 = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc0child2.setName( "tc0child2" );

        Assoc0Composite ass0comp = gpackage1.getAssoc0Composite( );
        ass0comp.add( tc0, tc0child1 );
        ass0comp.add( tc0, tc0child2 );

        List<RefObject> elementsToBeCopied = new ArrayList<RefObject>( );
        elementsToBeCopied.add( tc0 );

        DeepCopyResultSet resultSet = myConn.deepCopy( elementsToBeCopied, null, true );

        boolean containsTc0 = false;

        for ( RefObject copy : resultSet.getCopiedElements( ) ) {
            if ( ( (TestClass0) copy ).getName( ).equals( "tc0" ) ) {
                containsTc0 = true;
                Collection<TestClass0> children = ( (TestClass0) copy ).getReference0Composite( );
                assertTrue( children.size( ) == 2 );
                if ( children.iterator( ).hasNext( ) ) {
                    assertTrue( children.iterator( ).next( ).getName( ).startsWith( "tc0child" ) );
                }
            }
            if ( ( (TestClass0) copy ).getName( ).equals( "tc0child1" ) ) {
                assertFalse( copy.equals( tc0child1 ) );
            }
        }

        assertTrue( containsTc0 );
    }

    /**
     * Test that linked elements are also linked by the copied elements
     */
    @Test
    public void testDirectLinks( ) {

        GeneratedmetamodelPackage gpackage1 = (GeneratedmetamodelPackage) ( myConn.getPackage( null, new String[] { "generatedmetamodel" } ) );
        TestClass0 tc0 = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc0.setName( "tc0" );
        TestClass1 tc1 = (TestClass1) gpackage1.getTestClass1( ).refCreateInstance( );
        tc1.setName( "tc1" );
        TestClass2 tc2 = (TestClass2) gpackage1.getTestClass2( ).refCreateInstance( );
        tc2.setName( "tc2" );
        TestClass3 tc3 = (TestClass3) gpackage1.getTestClass3( ).refCreateInstance( );
        tc3.setName( "tc3" );

        Assoc0xRefElement ass0xRef = gpackage1.getAssoc0xRefElement( );
        ass0xRef.add( tc0, tc1 );
        ass0xRef.add( tc0, tc2 );

        Assoc1xRefElement ass1xRef = gpackage1.getAssoc1xRefElement( );
        ass1xRef.add( tc1, tc3 );

        List<RefObject> elementsToBeCopied = new ArrayList<RefObject>( );
        elementsToBeCopied.add( tc0 );
        elementsToBeCopied.add( tc1 );

        DeepCopyResultSet resultSet = myConn.deepCopy( elementsToBeCopied, null, true );

        logger.trace( MoinSeverity.DEBUG, resultSet.getMappingTable( ).toString( ) );

        boolean containsTc2 = resultSet.getMappingTable( ).containsKey( tc2 );
        boolean containsTc3 = resultSet.getMappingTable( ).containsKey( tc3 );

        for ( RefObject copiedObject : resultSet.getCopiedElements( ) ) {
            String name = (String) copiedObject.refGetValue( "name" );
            if ( name == "tc0" ) {
                assertTrue( ( (TestClass0) copiedObject ).getReference0xRefElement( ).contains( tc2 ) );
            }
        }

        assertTrue( containsTc2 && containsTc3 );
    }

    @Test
    public void testFalselySetReverseAssociations( ) {

        GeneratedmetamodelPackage gpackage1 = (GeneratedmetamodelPackage) ( myConn.getPackage( null, new String[] { "generatedmetamodel" } ) );
        TestClass0 tc01 = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc01.setName( "tc01" );
        TestClass0 tc02 = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc02.setName( "tc02" );

        Assoc0xRefElement ass0xRef = gpackage1.getAssoc0xRefElement( );
        ass0xRef.add( tc01, tc02 );

        List<RefObject> elementsToBeCopied = new ArrayList<RefObject>( );
        elementsToBeCopied.add( tc02 );
        elementsToBeCopied.add( tc01 );

        DeepCopyResultSet resultSet = myConn.deepCopy( elementsToBeCopied, null, true );

        for ( RefObject copiedObject : resultSet.getCopiedElements( ) ) {
            String name = (String) copiedObject.refGetValue( "name" );
            if ( name == "tc01" ) {
                assertTrue( resultSet.getCopiedElements( ).containsAll( ( (TestClass0) copiedObject ).getReference0xRefElement( ) ) );
            } else if ( name == "tc02" ) {
                assertTrue( ( (TestClass0) copiedObject ).getReference0xRefElement( ).isEmpty( ) );
            }
        }
    }

    /**
     * Test a PolicyHandler that STOPS copying a composite children
     */
    @Test
    public void testRemoveCompositeChild( ) {

        GeneratedmetamodelPackage gpackage1 = (GeneratedmetamodelPackage) ( myConn.getPackage( null, new String[] { "generatedmetamodel" } ) );
        TestClass0 tc0 = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc0.setName( "tc0" );
        TestClass0 tc0child1 = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc0child1.setName( "tc0child1" );
        TestClass0 tc0child2 = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc0child2.setName( "tc0child2" );

        Assoc0Composite ass0comp = gpackage1.getAssoc0Composite( );
        ass0comp.add( tc0, tc0child1 );
        ass0comp.add( tc0, tc0child2 );

        List<RefObject> elementsToBeCopied = new ArrayList<RefObject>( );
        elementsToBeCopied.add( tc0 );

        /*
         * prevent the element "tc0child2" from being mapped
         */
        DeepCopyPolicyHandler testHandler1 = new DeepCopyPolicyHandler( ) {

            public DeepCopyPolicy getDeepCopyingPolicy( RefObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap ) {

                DeepCopyPolicy resultPolicy = null;
                if ( sourceElement instanceof TestClass0 ) {
                    if ( ( (TestClass0) sourceElement ).getName( ).equals( "tc0child2" ) ) {
                        resultPolicy = new DeepCopyPolicy( DeepCopyPolicyOption.STOP, null );
                    } else {
                        resultPolicy = defaultPolicy;
                    }
                } else {
                    resultPolicy = defaultPolicy;
                }
                return resultPolicy;
            }
        };

        DeepCopyResultSet resultSet = myConn.deepCopy( elementsToBeCopied, testHandler1, true );
        logger.trace( MoinSeverity.DEBUG, resultSet.getMappingTable( ).toString( ) );

        for ( RefObject copy : resultSet.getCopiedElements( ) ) {
            if ( ( copy != null ) && ( (TestClass0) copy ).getName( ).equals( "tc0" ) ) {
                Collection<TestClass0> children = ( (TestClass0) copy ).getReference0Composite( );
                if ( children.iterator( ).hasNext( ) ) {
                    assertFalse( children.iterator( ).next( ).getName( ).equals( "tc0child2" ) );
                }
            }
        }
    }

    /**
     * Test a PolicyHandler that returns a wrong CUSTOM element
     */
    @Test
    public void testInvalidCustomType( ) {

        GeneratedmetamodelPackage gpackage1 = (GeneratedmetamodelPackage) ( myConn.getPackage( null, new String[] { "generatedmetamodel" } ) );
        TestClass0 tc0 = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc0.setName( "tc0" );
        TestClass1 tc1 = (TestClass1) gpackage1.getTestClass1( ).refCreateInstance( );
        tc1.setName( "tc1" );
        TestClass2 tc2 = (TestClass2) gpackage1.getTestClass2( ).refCreateInstance( );
        tc2.setName( "tc2" );
        TestClass3 tc3 = (TestClass3) gpackage1.getTestClass3( ).refCreateInstance( );
        tc3.setName( "tc3" );

        List<RefObject> elementsToBeCopied = new ArrayList<RefObject>( );
        elementsToBeCopied.add( tc0 );
        elementsToBeCopied.add( tc1 );
        elementsToBeCopied.add( tc2 );
        elementsToBeCopied.add( tc3 );

        DeepCopyPolicyHandler testHandler1 = new DeepCopyPolicyHandler( ) {

            public DeepCopyPolicy getDeepCopyingPolicy( RefObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap ) {

                DeepCopyPolicy resultPolicy = null;
                if ( sourceElement instanceof TestClass0 ) {
                    GeneratedmetamodelPackage gpackage2 = (GeneratedmetamodelPackage) ( myConn.getPackage( null, new String[] { "generatedmetamodel" } ) );
                    TestClass1 tc1fault = (TestClass1) gpackage2.getTestClass1( ).refCreateInstance( );
                    tc1fault.setName( "tc0_faultyType_tc1" );
                    resultPolicy = new DeepCopyPolicy( DeepCopyPolicyOption.CUSTOM, tc1fault );
                } else {
                    resultPolicy = defaultPolicy;
                }
                return resultPolicy;
            }
        };

        DeepCopyResultSet resultSet = myConn.deepCopy( elementsToBeCopied, testHandler1, true );
        assertFalse( resultSet.getCopyErrors( ).isEmpty( ) );

        logger.trace( MoinSeverity.DEBUG, resultSet.getMappingTable( ).toString( ) );
        for ( DeepCopyError e : resultSet.getCopyErrors( ) ) {
            assertTrue( e.getErrorType( ).equals( DeepCopyErrorType.ERR_006 ) );
            logger.trace( MoinSeverity.DEBUG, e.toString( ) );
        }

    }

    /**
     * Test a PolicyHandler that uses CUSTOM mapping
     */
    @Test
    public void testCustomHandler( ) {

        GeneratedmetamodelPackage gpackage1 = (GeneratedmetamodelPackage) ( myConn.getPackage( null, new String[] { "generatedmetamodel" } ) );
        TestClass0 tc0 = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc0.setName( "tc0" );
        TestClass1 tc1 = (TestClass1) gpackage1.getTestClass1( ).refCreateInstance( );
        tc1.setName( "tc1" );
        TestClass2 tc2 = (TestClass2) gpackage1.getTestClass2( ).refCreateInstance( );
        tc2.setName( "tc2" );
        TestClass3 tc3 = (TestClass3) gpackage1.getTestClass3( ).refCreateInstance( );
        tc3.setName( "tc3" );

        List<RefObject> elementsToBeCopied = new ArrayList<RefObject>( );
        elementsToBeCopied.add( tc0 );
        elementsToBeCopied.add( tc1 );
        elementsToBeCopied.add( tc2 );
        elementsToBeCopied.add( tc3 );

        DeepCopyPolicyHandler testHandler1 = new DeepCopyPolicyHandler( ) {

            public DeepCopyPolicy getDeepCopyingPolicy( RefObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap ) {

                logger.trace( MoinSeverity.DEBUG, "Mapping Element " + sourceElement.refGetValue( "name" ) );
                RefObject newObject = sourceElement.refClass( ).refCreateInstance( null );
                newObject.refSetValue( "name", sourceElement.refGetValue( "name" ) + "_copy" );
                return new DeepCopyPolicy( DeepCopyPolicyOption.CUSTOM, newObject );
            }
        };

        DeepCopyResultSet resultSet = myConn.deepCopy( elementsToBeCopied, testHandler1, true );

        logger.trace( MoinSeverity.DEBUG, resultSet.getMappingTable( ).toString( ) );
        assertTrue( resultSet.getCopyErrors( ).isEmpty( ) );
        assertTrue( resultSet.getCopiedElements( ).size( ) == 4 );
    }

    @Test
    public void testInvalidMappingModification( ) {

        GeneratedmetamodelPackage gpackage1 = (GeneratedmetamodelPackage) ( myConn.getPackage( null, new String[] { "generatedmetamodel" } ) );
        TestClass0 tc0 = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc0.setName( "tc0" );
        TestClass1 tc1 = (TestClass1) gpackage1.getTestClass1( ).refCreateInstance( );
        tc1.setName( "tc1" );
        TestClass2 tc2 = (TestClass2) gpackage1.getTestClass2( ).refCreateInstance( );
        tc2.setName( "tc2" );

        Assoc0xRefElement ass0xRef = gpackage1.getAssoc0xRefElement( );
        ass0xRef.add( tc0, tc1 );
        ass0xRef.add( tc0, tc2 );

        List<RefObject> elementsToBeCopied = new ArrayList<RefObject>( );
        elementsToBeCopied.add( tc0 );

        DeepCopyPolicyHandler testHandler1 = new DeepCopyPolicyHandler( ) {

            public DeepCopyPolicy getDeepCopyingPolicy( RefObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap ) {

                logger.trace( MoinSeverity.DEBUG, "Mapping Element " + sourceElement.refGetValue( "name" ) );
                if ( defaultPolicy.getDeepCopyPolicyOption( ).equals( DeepCopyPolicyOption.FULL_COPY ) ) {
                    return new DeepCopyPolicy( DeepCopyPolicyOption.REF_COPY, null );
                } else {
                    return defaultPolicy;
                }
            }
        };

        DeepCopyResultSet resultSet = myConn.deepCopy( elementsToBeCopied, testHandler1, true );

        logger.trace( MoinSeverity.DEBUG, resultSet.getMappingTable( ).toString( ) );
        for ( DeepCopyError e : resultSet.getCopyErrors( ) ) {
            assertTrue( e.getErrorType( ).equals( DeepCopyErrorType.ERR_005 ) );
            logger.trace( MoinSeverity.DEBUG, e.toString( ) );
        }
    }

    @Test
    public void testWrongAssociationCardinality( ) {

        GeneratedmetamodelPackage gpackage1 = (GeneratedmetamodelPackage) ( myConn.getPackage( null, new String[] { "generatedmetamodel" } ) );
        TestClass0 tc0 = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc0.setName( "tc0" );
        TestClass1 tc1 = (TestClass1) gpackage1.getTestClass1( ).refCreateInstance( );
        tc1.setName( "tc1" );

        Assoc0x1 ass0x1 = gpackage1.getAssoc0x1( );
        ass0x1.add( tc0, tc1 );

        List<RefObject> elementsToBeCopied = new ArrayList<RefObject>( );
        elementsToBeCopied.add( tc1 );

        DeepCopyResultSet resultSet = myConn.deepCopy( elementsToBeCopied, null, true );
        for ( DeepCopyError e : resultSet.getCopyErrors( ) ) {
            assertTrue( e.getErrorType( ).equals( DeepCopyErrorType.ERR_001 ) );
            logger.trace( MoinSeverity.DEBUG, e.toString( ) );
        }

    }

    @Test
    public void testSubClassWithAssociationInheritedFromSuperclass( ) {

        GeneratedmetamodelPackage gpackage1 = (GeneratedmetamodelPackage) ( myConn.getPackage( null, new String[] { "generatedmetamodel" } ) );
        TestSubClass0 tc0 = (TestSubClass0) gpackage1.getTestSubClass0( ).refCreateInstance( );
        tc0.setName( "tc0" );
        TestSubClass1 tc1 = (TestSubClass1) gpackage1.getTestSubClass1( ).refCreateInstance( );
        tc1.setName( "tc1" );

        Assoc0xRefElement ass0xRef = gpackage1.getAssoc0xRefElement( );
        ass0xRef.add( tc0, tc1 );

        List<RefObject> elementsToBeCopied = new ArrayList<RefObject>( );
        elementsToBeCopied.add( tc0 );

        DeepCopyResultSet resultSet = myConn.deepCopy( elementsToBeCopied, null, true );

        for ( RefObject copy : resultSet.getCopiedElements( ) ) {
            if ( copy instanceof TestClass0 ) {
                assertTrue( ( (TestClass0) copy ).getReference0xRefElement( ).contains( tc1 ) );
            }
        }
    }

    @Test
    public void testCriticalCase( ) {

        GeneratedmetamodelPackage gpackage1 = (GeneratedmetamodelPackage) ( myConn.getPackage( null, new String[] { "generatedmetamodel" } ) );
        TestClass0 tc0a = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc0a.setName( "tc0a" );
        TestClass0 tc0b = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc0b.setName( "tc0b" );
        TestClass1 tc1c = (TestClass1) gpackage1.getTestClass1( ).refCreateInstance( );
        tc1c.setName( "tc1c" );
        TestClass1 tc1d = (TestClass1) gpackage1.getTestClass1( ).refCreateInstance( );
        tc1d.setName( "tc1d" );

        Assoc0Composite ass0Comp = gpackage1.getAssoc0Composite( );
        ass0Comp.add( tc0a, tc0b );

        Assoc1Composite ass1Comp = gpackage1.getAssoc1Composite( );
        ass1Comp.add( tc1c, tc1d );

        Assoc0xRefElement ass0xRefElement = gpackage1.getAssoc0xRefElement( );
        ass0xRefElement.add( tc0a, tc1d );
        ass0xRefElement.add( tc0b, tc1c );

        List<RefObject> elementsToBeCopied = new ArrayList<RefObject>( );
        elementsToBeCopied.add( tc0b );
        elementsToBeCopied.add( tc0a );

        DeepCopyPolicyHandler testHandler1 = new DeepCopyPolicyHandler( ) {

            public DeepCopyPolicy getDeepCopyingPolicy( RefObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap ) {

                // logger.trace(MoinSeverity.DEBUG,
                // deepCopier.printMappingTable(copyMap));
                logger.trace( MoinSeverity.DEBUG, "Now Mapping Element " + sourceElement.refGetValue( "name" ) );

                if ( sourceElement.refGetValue( "name" ) == "tc1c" ) {
                    return new DeepCopyPolicy( DeepCopyPolicyOption.FULL_COPY, null );
                } else {
                    return defaultPolicy;
                }
            }
        };

        DeepCopyResultSet resultSet = myConn.deepCopy( elementsToBeCopied, testHandler1, true );

        logger.trace( MoinSeverity.DEBUG, resultSet.getMappingTable( ).toString( ) );
        for ( DeepCopyError e : resultSet.getCopyErrors( ) ) {
            logger.trace( MoinSeverity.DEBUG, e.toString( ) );
        }
    }

    @Test
    public void testCompositeInSeed( ) {

        GeneratedmetamodelPackage gpackage1 = (GeneratedmetamodelPackage) ( myConn.getPackage( null, new String[] { "generatedmetamodel" } ) );
        TestClass0 tc0a = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc0a.setName( "tc0a" );
        TestClass0 tc0b = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc0b.setName( "tc0b" );
        TestClass0 tc0c = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc0c.setName( "tc0c" );

        Assoc0Composite ass0Comp = gpackage1.getAssoc0Composite( );
        ass0Comp.add( tc0a, tc0b );
        ass0Comp.add( tc0b, tc0c );

        List<RefObject> elementsToBeCopied = new ArrayList<RefObject>( );
        elementsToBeCopied.add( tc0a );
        elementsToBeCopied.add( tc0c );

        DeepCopyPolicyHandler testHandler1 = new DeepCopyPolicyHandler( ) {

            public DeepCopyPolicy getDeepCopyingPolicy( RefObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap ) {

                // logger.trace(MoinSeverity.DEBUG,
                // deepCopier.printMappingTable(copyMap));
                logger.trace( MoinSeverity.DEBUG, "Now Mapping Element " + sourceElement.refGetValue( "name" ) );

                return defaultPolicy;
            }
        };

        DeepCopyResultSet resultSet = myConn.deepCopy( elementsToBeCopied, testHandler1, true );

        logger.trace( MoinSeverity.DEBUG, resultSet.getMappingTable( ).toString( ) );
        for ( DeepCopyError e : resultSet.getCopyErrors( ) ) {
            logger.trace( MoinSeverity.DEBUG, e.toString( ) );
        }
    }

    @Test
    public void testWrongAssocEndCardinality( ) {

        GeneratedmetamodelPackage gpackage1 = (GeneratedmetamodelPackage) ( myConn.getPackage( null, new String[] { "generatedmetamodel" } ) );
        TestClass0 tc0 = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc0.setName( "tc0" );
        TestClass1 tc1 = (TestClass1) gpackage1.getTestClass1( ).refCreateInstance( );
        tc1.setName( "tc1" );

        Assoc0x1 ass0x1 = gpackage1.getAssoc0x1( );
        ass0x1.add( tc0, tc1 );

        List<RefObject> elementsToBeCopied = new ArrayList<RefObject>( );
        elementsToBeCopied.add( tc0 );

        DeepCopyPolicyHandler testHandler1 = new DeepCopyPolicyHandler( ) {

            public DeepCopyPolicy getDeepCopyingPolicy( RefObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap ) {

                // logger.trace(MoinSeverity.DEBUG,
                // deepCopier.printMappingTable(copyMap));
                logger.trace( MoinSeverity.DEBUG, "Now Mapping Element " + sourceElement.refGetValue( "name" ) );

                return defaultPolicy;
            }
        };

        DeepCopyResultSet resultSet = myConn.deepCopy( elementsToBeCopied, testHandler1, true );

        logger.trace( MoinSeverity.DEBUG, resultSet.getMappingTable( ).toString( ) );
        for ( DeepCopyError e : resultSet.getCopyErrors( ) ) {
            assertTrue( e.getErrorType( ).equals( DeepCopyErrorType.ERR_007 ) );
            logger.trace( MoinSeverity.DEBUG, e.toString( ) );
        }
    }

    @Test
    public void testComplexExample( ) {

        GeneratedmetamodelPackage gpackage1 = (GeneratedmetamodelPackage) ( myConn.getPackage( null, new String[] { "generatedmetamodel" } ) );
        TestClass1 tc_A = (TestClass1) gpackage1.getTestClass1( ).refCreateInstance( );
        tc_A.setName( "A" );
        TestClass0 tc_B = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc_B.setName( "B" );
        TestClass1 tc_C = (TestClass1) gpackage1.getTestClass1( ).refCreateInstance( );
        tc_C.setName( "C" );
        TestClass1 tc_D = (TestClass1) gpackage1.getTestClass1( ).refCreateInstance( );
        tc_D.setName( "D" );
        TestClass1 tc_E = (TestClass1) gpackage1.getTestClass1( ).refCreateInstance( );
        tc_E.setName( "E" );
        TestClass3 tc_F = (TestClass3) gpackage1.getTestClass3( ).refCreateInstance( );
        tc_F.setName( "F" );
        TestClass2 tc_G = (TestClass2) gpackage1.getTestClass2( ).refCreateInstance( );
        tc_G.setName( "G" );
        TestClass0 tc_H = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc_H.setName( "H" );

        Assoc0Composite ass0Comp = gpackage1.getAssoc0Composite( );
        ass0Comp.add( tc_H, tc_B );

        Assoc1Composite ass1Comp = gpackage1.getAssoc1Composite( );
        ass1Comp.add( tc_E, tc_A );
        ass1Comp.add( tc_A, tc_C );
        ass1Comp.add( tc_C, tc_D );

        Assoc1xRefElement ass1xRef = gpackage1.getAssoc1xRefElement( );
        ass1xRef.add( tc_A, tc_D );

        Assoc0xRefElement ass0xRef = gpackage1.getAssoc0xRefElement( );
        ass0xRef.add( tc_B, tc_G );

        Assoc2xRefElement ass2xRef = gpackage1.getAssoc2xRefElement( );
        ass2xRef.add( tc_G, tc_C );
        ass2xRef.add( tc_G, tc_D );

        Assoc3x1 ass3x1 = gpackage1.getAssoc3x1( );
        ass3x1.add( tc_F, tc_C );

        List<RefObject> elementsToBeCopied = new ArrayList<RefObject>( );
        elementsToBeCopied.add( tc_A );
        elementsToBeCopied.add( tc_B );

        DeepCopyPolicyHandler testHandler1 = new DeepCopyPolicyHandler( ) {

            public DeepCopyPolicy getDeepCopyingPolicy( RefObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap ) {

                logger.trace( MoinSeverity.DEBUG, "Now Mapping Element " + sourceElement.refGetValue( "name" ) );

                return defaultPolicy;
            }
        };

        DeepCopyResultSet resultSet = myConn.deepCopy( elementsToBeCopied, testHandler1, true );

        logger.trace( MoinSeverity.DEBUG, resultSet.getMappingTable( ).toString( ) );
        for ( DeepCopyError e : resultSet.getCopyErrors( ) ) {
            logger.trace( MoinSeverity.DEBUG, e.toString( ) );
        }

        assertTrue( resultSet.getMappingTable( ).containsKey( tc_C ) );
        assertTrue( resultSet.getMappingTable( ).containsKey( tc_D ) );
        assertTrue( resultSet.getMappingTable( ).containsKey( tc_E ) );
        assertTrue( resultSet.getMappingTable( ).containsKey( tc_F ) );
        assertTrue( resultSet.getMappingTable( ).containsKey( tc_G ) );
        assertTrue( resultSet.getMappingTable( ).containsKey( tc_H ) );

        assertTrue( resultSet.getMappingTable( ).get( tc_C ).getModifiedPolicy( ).getDeepCopyPolicyOption( ).equals( DeepCopyPolicyOption.FULL_COPY ) );
        assertTrue( resultSet.getMappingTable( ).get( tc_D ).getModifiedPolicy( ).getDeepCopyPolicyOption( ).equals( DeepCopyPolicyOption.FULL_COPY ) );
        assertTrue( resultSet.getMappingTable( ).get( tc_E ).getModifiedPolicy( ).getDeepCopyPolicyOption( ).equals( DeepCopyPolicyOption.REF_COPY ) );
        assertTrue( resultSet.getMappingTable( ).get( tc_F ).getModifiedPolicy( ).getDeepCopyPolicyOption( ).equals( DeepCopyPolicyOption.REF_COPY ) );
        assertTrue( resultSet.getMappingTable( ).get( tc_G ).getModifiedPolicy( ).getDeepCopyPolicyOption( ).equals( DeepCopyPolicyOption.REF_COPY ) );
        assertTrue( resultSet.getMappingTable( ).get( tc_H ).getModifiedPolicy( ).getDeepCopyPolicyOption( ).equals( DeepCopyPolicyOption.REF_COPY ) );

        TestClass1 tc_A_copy = (TestClass1) ( resultSet.getMappingTable( ).get( tc_A ).getMappingTarget( ) );
        TestClass0 tc_B_copy = (TestClass0) ( resultSet.getMappingTable( ).get( tc_B ).getMappingTarget( ) );
        TestClass1 tc_C_copy = (TestClass1) ( resultSet.getMappingTable( ).get( tc_C ).getMappingTarget( ) );
        TestClass1 tc_D_copy = (TestClass1) ( resultSet.getMappingTable( ).get( tc_D ).getMappingTarget( ) );

        assertTrue( ( (Collection<RefObject>) ( tc_A_copy.refGetValue( "reference1xRefElement" ) ) ).contains( tc_D_copy ) );
        assertTrue( ( (Collection<RefObject>) ( tc_B_copy.refGetValue( "reference0xRefElement" ) ) ).contains( tc_G ) );

        assertTrue( ( (Collection<RefObject>) ( tc_A_copy.refGetValue( "reference1Composite" ) ) ).contains( tc_C_copy ) );
        assertTrue( ( (Collection<RefObject>) ( tc_C_copy.refGetValue( "reference1Composite" ) ) ).contains( tc_D_copy ) );
    }

    @Test
    public void testOverrideMappingEntry( ) {

        GeneratedmetamodelPackage gpackage1 = (GeneratedmetamodelPackage) ( myConn.getPackage( null, new String[] { "generatedmetamodel" } ) );
        TestClass1 tc_A = (TestClass1) gpackage1.getTestClass1( ).refCreateInstance( );
        tc_A.setName( "A" );

        List<RefObject> elementsToBeCopied = new ArrayList<RefObject>( );
        elementsToBeCopied.add( tc_A );
        elementsToBeCopied.add( tc_A );

        DeepCopyPolicyHandler testHandler1 = new DeepCopyPolicyHandler( ) {

            public DeepCopyPolicy getDeepCopyingPolicy( RefObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap ) {

                // logger.trace(MoinSeverity.DEBUG,
                // deepCopier.printMappingTable(copyMap));
                logger.trace( MoinSeverity.DEBUG, "Now Mapping Element " + sourceElement.refGetValue( "name" ) );

                DeepCopyPolicy modifiedPolicy;

                if ( copyMap.get( sourceElement ) != null ) {
                    modifiedPolicy = new DeepCopyPolicy( DeepCopyPolicyOption.FULL_COPY, null );
                } else {
                    modifiedPolicy = new DeepCopyPolicy( DeepCopyPolicyOption.STOP, null );
                }

                return modifiedPolicy;
            }
        };
        DeepCopyResultSet resultSet = myConn.deepCopy( elementsToBeCopied, testHandler1, true );

        logger.trace( MoinSeverity.DEBUG, resultSet.getMappingTable( ).toString( ) );
        for ( DeepCopyError e : resultSet.getCopyErrors( ) ) {
            logger.trace( MoinSeverity.DEBUG, e.toString( ) );
        }

        assertTrue( resultSet.getMappingTable( ).get( tc_A ).getModifiedPolicy( ).getDeepCopyPolicyOption( ).equals( DeepCopyPolicyOption.STOP ) );

    }

    @Test
    public void testWrappers( ) {

        GeneratedmetamodelPackage gpackage1 = (GeneratedmetamodelPackage) ( myConn.getPackage( null, new String[] { "generatedmetamodel" } ) );
        TestClass1 tc_A = (TestClass1) gpackage1.getTestClass1( ).refCreateInstance( );
        tc_A.setName( "A" );
        TestClass0 tc_B = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc_B.setName( "B" );
        TestClass1 tc_C = (TestClass1) gpackage1.getTestClass1( ).refCreateInstance( );
        tc_C.setName( "C" );
        TestClass1 tc_D = (TestClass1) gpackage1.getTestClass1( ).refCreateInstance( );
        tc_D.setName( "D" );
        TestClass1 tc_E = (TestClass1) gpackage1.getTestClass1( ).refCreateInstance( );
        tc_E.setName( "E" );
        TestClass3 tc_F = (TestClass3) gpackage1.getTestClass3( ).refCreateInstance( );
        tc_F.setName( "F" );
        TestClass2 tc_G = (TestClass2) gpackage1.getTestClass2( ).refCreateInstance( );
        tc_G.setName( "G" );
        TestClass0 tc_H = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc_H.setName( "H" );

        Assoc0Composite ass0Comp = gpackage1.getAssoc0Composite( );
        ass0Comp.add( tc_H, tc_B );

        Assoc1Composite ass1Comp = gpackage1.getAssoc1Composite( );
        ass1Comp.add( tc_E, tc_A );
        ass1Comp.add( tc_A, tc_C );
        ass1Comp.add( tc_C, tc_D );

        Assoc1xRefElement ass1xRef = gpackage1.getAssoc1xRefElement( );
        ass1xRef.add( tc_A, tc_D );

        Assoc0xRefElement ass0xRef = gpackage1.getAssoc0xRefElement( );
        ass0xRef.add( tc_B, tc_G );

        Assoc2xRefElement ass2xRef = gpackage1.getAssoc2xRefElement( );
        ass2xRef.add( tc_G, tc_C );
        ass2xRef.add( tc_G, tc_D );

        Assoc3x1 ass3x1 = gpackage1.getAssoc3x1( );
        ass3x1.add( tc_F, tc_C );

        List<RefObject> elementsToBeCopied = new ArrayList<RefObject>( );
        elementsToBeCopied.add( tc_A );
        elementsToBeCopied.add( tc_B );

        DeepCopyPolicyHandler testHandler1 = new DeepCopyPolicyHandler( ) {

            public DeepCopyPolicy getDeepCopyingPolicy( RefObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap ) {

                // logger.trace(MoinSeverity.DEBUG,
                // deepCopier.printMappingTable(copyMap));
                logger.trace( MoinSeverity.DEBUG, "Now Mapping Element " + sourceElement.refGetValue( "name" ) );

                return defaultPolicy;
            }
        };

        DeepCopyResultSet resultSet = myConn.deepCopy( elementsToBeCopied, testHandler1, true );
        Collection<RefObject> copiedElements = resultSet.getCopiedElements( );

        boolean containsD = false;

        for ( RefObject copy : copiedElements ) {
            if ( copy.refGetValue( "name" ) == "D" ) {
                containsD = true;
            }
            assertTrue( copy instanceof Wrapper );
        }
        assertTrue( containsD );
    }

    @Test
    public void testUnWrappedElements( ) {

        GeneratedmetamodelPackage gpackage1 = (GeneratedmetamodelPackage) ( myConn.getPackage( null, new String[] { "generatedmetamodel" } ) );
        TestClass1 tc_A = (TestClass1) gpackage1.getTestClass1( ).refCreateInstance( );
        tc_A.setName( "A" );
        TestClass0 tc_B = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc_B.setName( "B" );

        List<RefObject> elementsToBeCopied = new ArrayList<RefObject>( );
        elementsToBeCopied.add( (RefObject) ( (Wrapper) tc_A ).unwrap( ) );
        elementsToBeCopied.add( (RefObject) ( (Wrapper) tc_B ).unwrap( ) );

        DeepCopyPolicyHandler testHandler1 = new DeepCopyPolicyHandler( ) {

            public DeepCopyPolicy getDeepCopyingPolicy( RefObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap ) {

                // logger.trace(MoinSeverity.DEBUG,
                // deepCopier.printMappingTable(copyMap));
                logger.trace( MoinSeverity.DEBUG, "Now Mapping Element " + sourceElement.refGetValue( "name" ) );

                return defaultPolicy;
            }
        };

        CoreConnection coreConn = ( (ConnectionWrapper) myConn ).unwrap( );
        DeepCopyResultSet resultSet = null;
        synchronized ( coreConn.getSession( ).getWorkspaceSet( ).getSynchronizationManager( ).getProhibitWriteSyncObject( ) ) {
            try {
                resultSet = coreConn.deepCopy( elementsToBeCopied, testHandler1, true );
                fail( "Expected UnsupportedOperationException" );
            } catch ( UnsupportedOperationException ex ) {
                // expected!
            }
        }
    }

    @Test
    public void testWrappedCustomHandler( ) {

        GeneratedmetamodelPackage gpackage1 = (GeneratedmetamodelPackage) ( myConn.getPackage( null, new String[] { "generatedmetamodel" } ) );
        TestClass1 tc_A = (TestClass1) gpackage1.getTestClass1( ).refCreateInstance( );
        tc_A.setName( "A" );
        TestClass0 tc_B = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc_B.setName( "B" );

        List<RefObject> elementsToBeCopied = new ArrayList<RefObject>( );
        elementsToBeCopied.add( tc_A );
        elementsToBeCopied.add( tc_B );

        DeepCopyPolicyHandler testHandler1 = new DeepCopyPolicyHandler( ) {

            public DeepCopyPolicy getDeepCopyingPolicy( RefObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap ) {

                // logger.trace(MoinSeverity.DEBUG,
                // deepCopier.printMappingTable(copyMap));
                logger.trace( MoinSeverity.DEBUG, "Now Mapping Element " + sourceElement.refGetValue( "name" ) );
                RefObject newObject = sourceElement.refClass( ).refCreateInstance( null );
                newObject.refSetValue( "name", sourceElement.refGetValue( "name" ) + "_copy" );
                return new DeepCopyPolicy( DeepCopyPolicyOption.CUSTOM, newObject );
            }
        };

        DeepCopyResultSet resultSet = myConn.deepCopy( elementsToBeCopied, testHandler1, true );
        Collection<RefObject> copiedElements = resultSet.getCopiedElements( );

    }

    @Test
    public void testMultipleConnections( ) throws Exception {

        Connection myConn2 = getTestHelper( ).getDefaultTestClient( true ).getConnection( );
        assertFalse( myConn.equals( myConn2 ) );

        GeneratedmetamodelPackage gpackage1 = (GeneratedmetamodelPackage) ( myConn.getPackage( null, new String[] { "generatedmetamodel" } ) );
        TestClass1 tc_A = (TestClass1) gpackage1.getTestClass1( ).refCreateInstance( );
        tc_A.setName( "A" );
        TestClass0 tc_B = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc_B.setName( "B" );
        TestClass1 tc_C = (TestClass1) gpackage1.getTestClass1( ).refCreateInstance( );
        tc_C.setName( "C" );
        TestClass1 tc_D = (TestClass1) gpackage1.getTestClass1( ).refCreateInstance( );
        tc_D.setName( "D" );
        TestClass1 tc_E = (TestClass1) gpackage1.getTestClass1( ).refCreateInstance( );
        tc_E.setName( "E" );
        TestClass3 tc_F = (TestClass3) gpackage1.getTestClass3( ).refCreateInstance( );
        tc_F.setName( "F" );
        TestClass2 tc_G = (TestClass2) gpackage1.getTestClass2( ).refCreateInstance( );
        tc_G.setName( "G" );
        TestClass0 tc_H = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc_H.setName( "H" );

        Assoc0Composite ass0Comp = gpackage1.getAssoc0Composite( );
        ass0Comp.add( tc_H, tc_B );

        Assoc1Composite ass1Comp = gpackage1.getAssoc1Composite( );
        ass1Comp.add( tc_E, tc_A );
        ass1Comp.add( tc_A, tc_C );
        ass1Comp.add( tc_C, tc_D );

        Assoc1xRefElement ass1xRef = gpackage1.getAssoc1xRefElement( );
        ass1xRef.add( tc_A, tc_D );

        Assoc0xRefElement ass0xRef = gpackage1.getAssoc0xRefElement( );
        ass0xRef.add( tc_B, tc_G );

        Assoc2xRefElement ass2xRef = gpackage1.getAssoc2xRefElement( );
        ass2xRef.add( tc_G, tc_C );
        ass2xRef.add( tc_G, tc_D );

        Assoc3x1 ass3x1 = gpackage1.getAssoc3x1( );
        ass3x1.add( tc_F, tc_C );

        List<RefObject> elementsToBeCopied = new ArrayList<RefObject>( );
        elementsToBeCopied.add( tc_A );
        elementsToBeCopied.add( tc_B );

        DeepCopyPolicyHandler testHandler1 = new DeepCopyPolicyHandler( ) {

            public DeepCopyPolicy getDeepCopyingPolicy( RefObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap ) {

                // logger.trace(MoinSeverity.DEBUG,
                // deepCopier.printMappingTable(copyMap));
                logger.trace( MoinSeverity.DEBUG, "Now Mapping Element " + sourceElement.refGetValue( "name" ) );

                return defaultPolicy;
            }
        };

        ModelPartition mp1 = myTestClient.getOrCreatePartition( "deepCopy1" );

        mp1.assignElement( tc_A );
        mp1.assignElement( tc_B );
        mp1.assignElement( tc_C );
        mp1.assignElement( tc_D );
        mp1.assignElement( tc_E );
        mp1.assignElement( tc_F );
        mp1.assignElement( tc_G );
        mp1.assignElement( tc_H );

        myConn.save( );

        DeepCopyResultSet resultSet = myConn2.deepCopy( elementsToBeCopied, testHandler1, true );

        assertTrue( resultSet.getCopyErrors( ).isEmpty( ) );

        for ( DeepCopyError e : resultSet.getCopyErrors( ) ) {
            logger.trace( MoinSeverity.DEBUG, e.toString( ) );
        }

        assertTrue( resultSet.getMappingTable( ).containsKey( tc_C ) );
        assertTrue( resultSet.getMappingTable( ).containsKey( tc_D ) );

        assertTrue( resultSet.getMappingTable( ).get( tc_C ).getModifiedPolicy( ).getDeepCopyPolicyOption( ).equals( DeepCopyPolicyOption.FULL_COPY ) );
        assertTrue( resultSet.getMappingTable( ).get( tc_D ).getModifiedPolicy( ).getDeepCopyPolicyOption( ).equals( DeepCopyPolicyOption.FULL_COPY ) );

        TestClass1 tc_A_copy = (TestClass1) ( resultSet.getMappingTable( ).get( tc_A ).getMappingTarget( ) );
        TestClass0 tc_B_copy = (TestClass0) ( resultSet.getMappingTable( ).get( tc_B ).getMappingTarget( ) );
        TestClass1 tc_C_copy = (TestClass1) ( resultSet.getMappingTable( ).get( tc_C ).getMappingTarget( ) );
        TestClass1 tc_D_copy = (TestClass1) ( resultSet.getMappingTable( ).get( tc_D ).getMappingTarget( ) );

        // Check internal associations
        assertTrue( ( (Collection<RefObject>) ( tc_A_copy.refGetValue( "reference1xRefElement" ) ) ).contains( tc_D_copy ) );
        assertTrue( ( (Collection<RefObject>) ( tc_B_copy.refGetValue( "reference0xRefElement" ) ) ).contains( tc_G ) );

        assertTrue( ( (Collection<RefObject>) ( tc_A_copy.refGetValue( "reference1Composite" ) ) ).contains( tc_C_copy ) );
        assertTrue( ( (Collection<RefObject>) ( tc_C_copy.refGetValue( "reference1Composite" ) ) ).contains( tc_D_copy ) );

        // Check external associations
        assertTrue( tc_B.refImmediateComposite( ).equals( tc_H ) );

        myConn2.revert( );
        mp1.delete( );
        myConn.save( );
    }

    @Test
    public void testExternalComposition( ) throws Exception {

        Connection myConn2 = getTestHelper( ).getDefaultTestClient( true ).getConnection( );
        assertFalse( myConn.equals( myConn2 ) );

        GeneratedmetamodelPackage gpackage1 = (GeneratedmetamodelPackage) ( myConn.getPackage( null, new String[] { "generatedmetamodel" } ) );
        TestClass0 tc_A = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc_A.setName( "A" );
        TestClass0 tc_B = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc_B.setName( "B" );

        Assoc0Composite ass0Comp = gpackage1.getAssoc0Composite( );
        ass0Comp.add( tc_A, tc_B );

        List<RefObject> elementsToBeCopied = new ArrayList<RefObject>( );
        elementsToBeCopied.add( tc_B );

        DeepCopyPolicyHandler testHandler1 = new DeepCopyPolicyHandler( ) {

            public DeepCopyPolicy getDeepCopyingPolicy( RefObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap ) {

                logger.trace( MoinSeverity.DEBUG, "Now Mapping Element " + sourceElement.refGetValue( "name" ) );

                return defaultPolicy;
            }
        };

        ModelPartition mp1 = myTestClient.getOrCreatePartition( "deepCopy1" );

        mp1.assignElement( tc_A );
        mp1.assignElement( tc_B );

        myConn.save( );

        DeepCopyResultSet resultSet = myConn2.deepCopy( elementsToBeCopied, testHandler1, true );

        assertTrue( resultSet.getCopyErrors( ).isEmpty( ) );

        for ( DeepCopyError e : resultSet.getCopyErrors( ) ) {
            logger.trace( MoinSeverity.DEBUG, e.toString( ) );
        }

        TestClass0 tc_B_copy = (TestClass0) ( resultSet.getMappingTable( ).get( tc_B ).getMappingTarget( ) );
        assertTrue( tc_B_copy.refImmediateComposite( ) != null );

        myConn2.revert( );
        mp1.delete( );
        myConn.save( );
    }

    @Test
    public void testExternalComposition4Mof( ) throws Exception {

        Connection myConn2 = getTestHelper( ).getDefaultTestClient( true ).getConnection( );
        assertFalse( myConn.equals( myConn2 ) );

        ModelPackage gpackage1 = (ModelPackage) ( myConn.getPackage( null, new String[] { "Model" } ) );
        MofClass tc_A = (MofClass) gpackage1.getMofClass( ).refCreateInstance( );
        tc_A.setName( "A" );
        Attribute tc_B = (Attribute) gpackage1.getAttribute( ).refCreateInstance( );
        tc_B.setName( "B" );

        Contains ass0Comp = gpackage1.getContains( );
        ass0Comp.add( tc_A, tc_B );

        List<RefObject> elementsToBeCopied = new ArrayList<RefObject>( );
        elementsToBeCopied.add( tc_B );

        DeepCopyPolicyHandler testHandler1 = new DeepCopyPolicyHandler( ) {

            public DeepCopyPolicy getDeepCopyingPolicy( RefObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap ) {

                return defaultPolicy;
            }
        };

        ModelPartition mp1 = myTestClient.getOrCreatePartition( "deepCopy1" );

        mp1.assignElement( tc_A );
        mp1.assignElement( tc_B );

        myConn.save( );
        boolean useDeepCopy = true;
        if ( useDeepCopy ) {
            DeepCopyResultSet resultSet = myConn2.deepCopy( elementsToBeCopied, testHandler1, true );

        } else {
            ModelPackage gpackage2 = (ModelPackage) ( myConn2.getPackage( null, new String[] { "Model" } ) );
            Attribute tc_C = (Attribute) gpackage2.getAttribute( ).refCreateInstance( );
            tc_C.setName( "C" );
            Contains ass0Comp2 = gpackage2.getContains( );
            MofClass tc_Ax = (MofClass) ( myConn2.getElement( ( (Partitionable) tc_A ).get___Mri( ) ) );
            ass0Comp2.refAddLink( tc_Ax, tc_C );
        }
        myConn2.revert( );
        mp1.delete( );
        myConn.save( );
    }

    @Test
    public void testExternalComposition4Gfw( ) throws Exception {

        Connection myConn2 = getTestHelper( ).getDefaultTestClient( true ).getConnection( );
        assertFalse( myConn.equals( myConn2 ) );

        GraphicsPackage gpackage1 = (GraphicsPackage) ( myConn.getPackage( "sap.com/com/sap/moin/mm/gfw", new String[] { "graphics" } ) );
        Diagram gd = (Diagram) gpackage1.getPictograms( ).getDiagram( ).refCreateInstance( );
        com.sap.moin.mm.gfw.pictograms.Connection gc = (com.sap.moin.mm.gfw.pictograms.Connection) gpackage1.getPictograms( ).getConnection( ).refCreateInstance( );

        DiagramAggregatesConnections ass0Comp = gpackage1.getPictograms( ).getDiagramAggregatesConnections( );
        gd.getConnections( ).add( gc );

        List<RefObject> elementsToBeCopied = new ArrayList<RefObject>( );
        elementsToBeCopied.add( gc );

        DeepCopyPolicyHandler testHandler1 = new DeepCopyPolicyHandler( ) {

            public DeepCopyPolicy getDeepCopyingPolicy( RefObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap ) {

                //logger.trace(MoinSeverity.DEBUG, "Now Mapping Element " + sourceElement.refGetValue("name"));

                return defaultPolicy;
            }
        };

        ModelPartition mp1 = myTestClient.getOrCreatePartition( "deepCopy1" );

        mp1.assignElement( gd );
        mp1.assignElement( gc );

        myConn.save( );

        DeepCopyResultSet resultSet = myConn2.deepCopy( elementsToBeCopied, testHandler1, true );

        assertTrue( resultSet.getCopyErrors( ).isEmpty( ) );

        for ( DeepCopyError e : resultSet.getCopyErrors( ) ) {
            logger.trace( MoinSeverity.DEBUG, e.toString( ) );
        }

        Diagram gd_copy = (Diagram) ( resultSet.getMappingTable( ).get( gd ).getMappingTarget( ) );
        com.sap.moin.mm.gfw.pictograms.Connection gc_copy = (com.sap.moin.mm.gfw.pictograms.Connection) ( resultSet.getMappingTable( ).get( gc ).getMappingTarget( ) );

        myConn2.revert( );
        mp1.delete( );
        myConn.save( );
    }

    @Test
    public void testWriteLockedPartition( ) throws Exception {

        Connection myConn2 = getTestHelper( ).getDefaultTestClient( true ).getConnection( );
        assertFalse( myConn.equals( myConn2 ) );

        GeneratedmetamodelPackage gpackage1 = (GeneratedmetamodelPackage) ( myConn.getPackage( null, new String[] { "generatedmetamodel" } ) );

        TestClass1 tc_A = (TestClass1) gpackage1.getTestClass1( ).refCreateInstance( );
        tc_A.setName( "A" );

        TestClass2 tc_B = (TestClass2) gpackage1.getTestClass2( ).refCreateInstance( );
        tc_B.setName( "B" );

        Assoc2x1 ass2x1 = gpackage1.getAssoc2x1( );
        ass2x1.add( tc_B, tc_A );

        ModelPartition mp1 = myTestClient.getOrCreatePartition( "deepCopy1" );
        ModelPartition mp2 = myTestClient.getOrCreatePartition( "deepCopy2" );

        mp1.assignElement( tc_A );
        mp2.assignElement( tc_B );

        MRI bMRI = ( (Partitionable) tc_B ).get___Mri( );

        myConn.save( );

        // acquire write-lock on element A
        tc_B = (TestClass2) myConn2.getElement( bMRI );
        tc_B.setName( "B2" );

        // copy element B; this also changes the link storage on element A, so
        // there should be an exception of some kind
        Collection<RefObject> elementsToBeCopied = new ArrayList<RefObject>( );
        elementsToBeCopied.add( tc_A );

        DeepCopyResultSet resultSet = myConn.deepCopy( elementsToBeCopied, null, true );

        for ( DeepCopyError e : resultSet.getCopyErrors( ) ) {
            logger.trace( MoinSeverity.DEBUG, e.toString( ) );
        }
        assertTrue( resultSet.getMappingTable( ).containsKey( tc_A ) );
        assertTrue( resultSet.getMappingTable( ).get( tc_A ).getMappingTarget( ) != null );
        assertTrue( resultSet.getMappingTable( ).containsKey( tc_B ) );

        myConn2.revert( );

        mp1.delete( );
        mp2.delete( );

        for ( RefObject obj : resultSet.getCopiedElements( ) ) {
            obj.refDelete( );
        }

        myConn.save( );

    }

    @Test
    public void testRefQuery( ) {

        GeneratedmetamodelPackage gpackage1 = (GeneratedmetamodelPackage) ( myConn.getPackage( null, new String[] { "generatedmetamodel" } ) );
        TestClass0 tc_B = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc_B.setName( "B" );
        TestClass0 tc_H = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc_H.setName( "H" );
        Assoc0Composite ass0Comp = gpackage1.getAssoc0Composite( );
        ass0Comp.add( tc_H, tc_B );

        // This is actually working!
        assertTrue( ass0Comp.getAssoc0CompositeEndA( tc_B ).equals( tc_H ) );

        Collection<RefObject> refRet = ass0Comp.refQuery( "assoc0CompositeEndB", tc_B );
        assertSame( 1, refRet.size( ) );
        assertEquals( tc_H, refRet.iterator( ).next( ) );

    }

    @Test
    public void testNonVisibleMri( ) throws Exception {

        Connection myConn2 = getTestHelper( ).getDefaultTestClient( true ).getConnection( );
        assertFalse( myConn.equals( myConn2 ) );

        GeneratedmetamodelPackage gpackage1 = (GeneratedmetamodelPackage) ( myConn.getPackage( null, new String[] { "generatedmetamodel" } ) );
        TestClass1 tc_A = (TestClass1) gpackage1.getTestClass1( ).refCreateInstance( );
        tc_A.setName( "A" );
        TestClass2 tc_B = (TestClass2) gpackage1.getTestClass2( ).refCreateInstance( );
        tc_B.setName( "B" );

        Assoc1xRefElement ass1xR = gpackage1.getAssoc1xRefElement( );

        ass1xR.add( tc_A, tc_B );

        ModelPartition mp1 = myTestClient.getOrCreatePartition( "deepCopy1" );
        ModelPartition mp2 = myTestClient.getOrCreatePartition( "deepCopy2" );

        mp1.assignElement( tc_A );
        mp1.assignElement( tc_B );

        try {
            myConn.save( );
        } catch ( NullPartitionNotEmptyException e ) {
            logger.trace( MoinSeverity.DEBUG, e.toString( ) );
        } catch ( ReferencedTransientElementsException e ) {
            logger.trace( MoinSeverity.DEBUG, e.toString( ) );
        } catch ( PartitionsNotSavedException e ) {
            logger.trace( MoinSeverity.DEBUG, e.toString( ) );
        }

        Collection<RefObject> elementsToBeCopied = new ArrayList<RefObject>( );
        elementsToBeCopied.add( tc_A );

        DeepCopyResultSet resultSet = myConn2.deepCopy( elementsToBeCopied, null, true );
        for ( DeepCopyError e : resultSet.getCopyErrors( ) ) {
            logger.trace( MoinSeverity.DEBUG, e.toString( ) );
        }

        assertTrue( resultSet.getMappingTable( ).containsKey( tc_B ) );

        mp1.delete( );
        mp2.delete( );

        myConn.save( );

    }

    @Test
    public void testIgnoreCompositeParents( ) {

        GeneratedmetamodelPackage gpackage1 = (GeneratedmetamodelPackage) ( myConn.getPackage( null, new String[] { "generatedmetamodel" } ) );
        TestClass1 tc_A = (TestClass1) gpackage1.getTestClass1( ).refCreateInstance( );
        tc_A.setName( "A" );
        TestClass0 tc_B = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc_B.setName( "B" );
        TestClass1 tc_E = (TestClass1) gpackage1.getTestClass1( ).refCreateInstance( );
        tc_E.setName( "E" );
        TestClass0 tc_H = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc_H.setName( "H" );

        Assoc0Composite ass0Comp = gpackage1.getAssoc0Composite( );
        ass0Comp.add( tc_H, tc_B );

        Assoc1Composite ass1Comp = gpackage1.getAssoc1Composite( );
        ass1Comp.add( tc_E, tc_A );

        List<RefObject> elementsToBeCopied = new ArrayList<RefObject>( );
        elementsToBeCopied.add( tc_A );
        elementsToBeCopied.add( tc_B );

        DeepCopyPolicyHandler testHandler1 = new DeepCopyPolicyHandler( ) {

            public DeepCopyPolicy getDeepCopyingPolicy( RefObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap ) {

                logger.trace( MoinSeverity.DEBUG, "Now Mapping Element " + sourceElement.refGetValue( "name" ) );

                return defaultPolicy;
            }
        };

        DeepCopyResultSet resultSet = myConn.deepCopy( elementsToBeCopied, testHandler1, false );

        for ( DeepCopyError e : resultSet.getCopyErrors( ) ) {
            logger.trace( MoinSeverity.DEBUG, e.toString( ) );
        }

        assertTrue( resultSet.getMappingTable( ).containsKey( tc_A ) );
        assertTrue( resultSet.getMappingTable( ).containsKey( tc_B ) );
        assertTrue( resultSet.getMappingTable( ).containsKey( tc_E ) );
        assertTrue( resultSet.getMappingTable( ).containsKey( tc_H ) );

        TestClass1 tc_A_copy = (TestClass1) ( resultSet.getMappingTable( ).get( tc_A ).getMappingTarget( ) );
        TestClass0 tc_B_copy = (TestClass0) ( resultSet.getMappingTable( ).get( tc_B ).getMappingTarget( ) );

        assertFalse( ( (Collection<RefObject>) ( tc_E.refGetValue( "reference1Composite" ) ) ).contains( tc_A_copy ) );
        assertFalse( ( (Collection<RefObject>) ( tc_H.refGetValue( "reference0Composite" ) ) ).contains( tc_B_copy ) );
    }

    /**
     * Test copy of elements from a dirty connection (not persisted)
     */
    @Test
    public void testNonVisibleElements( ) throws Exception {

        final Connection myConnVar = myConn;
        final Connection myConn2 = getTestHelper( ).getDefaultTestClient( true ).getConnection( );
        assertFalse( myConn.equals( myConn2 ) );

        GeneratedmetamodelPackage gpackage1 = (GeneratedmetamodelPackage) ( myConn.getPackage( null, new String[] { "generatedmetamodel" } ) );
        TestClass1 tc_A = (TestClass1) gpackage1.getTestClass1( ).refCreateInstance( );
        tc_A.setName( "A" );
        TestClass2 tc_B = (TestClass2) gpackage1.getTestClass2( ).refCreateInstance( );
        tc_B.setName( "B" );

        Assoc1xRefElement ass1xR = gpackage1.getAssoc1xRefElement( );
        ass1xR.add( tc_A, tc_B );

        TestClass0 tc_C = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc_C.setName( "C" );
        TestClass0 tc_D = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc_D.setName( "D" );

        Assoc0Composite ass0Comp = gpackage1.getAssoc0Composite( );
        ass0Comp.add( tc_C, tc_D );

        Collection<RefObject> elementsToBeCopied = new ArrayList<RefObject>( );
        elementsToBeCopied.add( tc_A );
        elementsToBeCopied.add( tc_C );

        DeepCopyPolicyHandler testHandler = new DeepCopyPolicyHandler( ) {

            public DeepCopyPolicy getDeepCopyingPolicy( RefObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap ) {

                // Check that sourceElements are wrappers in the original connection!
                if ( !myConnVar.equals( sourceElement.get___Connection( ) ) ) {
                    throw new IllegalStateException( "sourceElement is not in the original connection!" );
                }
                logger.trace( MoinSeverity.DEBUG, "Now Mapping Element " + sourceElement.refGetValue( "name" ) );

                return defaultPolicy;
            }
        };

        DeepCopyResultSet resultSet = myConn2.deepCopy( elementsToBeCopied, testHandler, true );

        assertEquals( 3, resultSet.getCopiedElements( ).size( ) ); // tc_A, tc_C and tc_D must have been copied
        assertEquals( 1, resultSet.getCopyErrors( ).size( ) );
        assertSame( DeepCopyError.DeepCopyErrorType.ERR_009, resultSet.getCopyErrors( ).iterator( ).next( ).getErrorType( ) );

        TestClass1 tc_A_copy = (TestClass1) ( resultSet.getMappingTable( ).get( tc_A ).getMappingTarget( ) );
        TestClass2 tc_B_copy = (TestClass2) ( resultSet.getMappingTable( ).get( tc_B ).getMappingTarget( ) );
        TestClass0 tc_C_copy = (TestClass0) ( resultSet.getMappingTable( ).get( tc_C ).getMappingTarget( ) );
        TestClass0 tc_D_copy = (TestClass0) ( resultSet.getMappingTable( ).get( tc_D ).getMappingTarget( ) );

        assertEquals( "A", tc_A_copy.getName( ) );
        assertNull( tc_B_copy );
        assertEquals( "C", tc_C_copy.getName( ) );
        assertEquals( "D", tc_D_copy.getName( ) );
        assertEquals( tc_C_copy, tc_D_copy.refImmediateComposite( ) );
    }

    @Test
    public void testCompositeAssocs( ) {

        // Create a mof class and an Attribute
        ModelPackage modelPackage = (ModelPackage) ( myConn.getPackage( null, new String[] { "Model" } ) );
        MofClass clss = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        clss.setName( "TestClass" );
        Attribute attr = (Attribute) modelPackage.getAttribute( ).refCreateInstance( );
        attr.setName( "TestAttr" );

        // Ask for possible composition relationships between Class and
        // Attribute
        Collection<Association> comps = myConn.getJmiHelper( ).getCompositeAssociations( (MofClass) clss.refMetaObject( ), (MofClass) attr.refMetaObject( ) );
        assertTrue( comps.size( ) == 1 );

        // Use the obtained association to compose the attribute into the class
        if ( comps.size( ) > 0 ) {
            Association assoc = comps.iterator( ).next( );
            compose( clss, attr, assoc );
            assertTrue( clss.getContents( ).contains( attr ) );
        }
    }

    private void compose( RefObject parent, RefObject child, Association assoc ) {

        AssociationEnd ae = myConn.getJmiHelper( ).getCompositeAssociationEnd( assoc );
        // Note that the composition is done using the connection of actualAssoc
        // (myConn)
        RefAssociation actualAssoc = myConn.getJmiHelper( ).getRefAssociationForAssociation( assoc );
        if ( myConn.getJmiHelper( ).isFirstAssociationEnd( assoc, ae ) ) {
            actualAssoc.refAddLink( parent, child );
        } else {
            actualAssoc.refAddLink( child, parent );
        }
    }

    @Test
    public void testDeepCopyUndo( ) {

        GeneratedmetamodelPackage gpackage1 = (GeneratedmetamodelPackage) ( myConn.getPackage( null, new String[] { "generatedmetamodel" } ) );
        TestClass0 tc0 = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc0.setName( "tc0" );
        TestClass0 tc0child1 = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc0child1.setName( "tc0child1" );
        TestClass0 tc0child2 = (TestClass0) gpackage1.getTestClass0( ).refCreateInstance( );
        tc0child2.setName( "tc0child2" );

        Assoc0Composite ass0comp = gpackage1.getAssoc0Composite( );
        ass0comp.add( tc0, tc0child1 );
        ass0comp.add( tc0, tc0child2 );

        List<RefObject> elementsToBeCopied = new ArrayList<RefObject>( );
        elementsToBeCopied.add( tc0 );

        myConn.getCommandStack( ).clear( );
        assertTrue( myConn.getCommandStack( ).getUndoStack( ).size( ) == 0 );
        DeepCopyResultSet resultSet = myConn.deepCopy( elementsToBeCopied, null, true );

        assertTrue( resultSet.getCopiedElements( ).size( ) == 3 );

        myConn.getCommandStack( ).undo( );

        for ( RefObject ce : resultSet.getCopiedElements( ) ) {
            assertFalse( ( (Partitionable) ce ).is___Alive( ) );
        }
    }

    @Test
    public void testDeepCopyWithSave( ) throws Exception {

        ModelPartition myPartition = getPartitionOne( );
        MofClass elementToBeCopied = getMOINConnection( ).createElementInPartition( MofClass.class, myPartition );
        DeepCopyResultSet result = getMOINConnection( ).deepCopy( Collections.singletonList( (RefObject) elementToBeCopied ), null, false );
        Collection<RefObject> copiedElements = result.getCopiedElements( );
        assertEquals( 1, copiedElements.size( ) );
        RefObject copiedElement = copiedElements.iterator( ).next( );
        copiedElement.assign___Partition( myPartition );
        assertTrue( myPartition.isDirty( ) );
        getMOINConnection( ).save( );
        DeepCopyMappingEntry deepCopyMappingEntry = result.getMappingTable( ).get( elementToBeCopied );
        assertEquals( copiedElement, deepCopyMappingEntry.getMappingTarget( ) );
        // clean up
        myPartition.deleteElements( );
        getMOINConnection( ).save( );
    }

    /**
     * Check whether the text field "transUnitId" differs (!) after the copy and
     * all other fields remain the same for translatable text fragments.
     */
    @Test
    public void testTranslatableTextFragmentAttributes( ) {
        ModelPartition myPartition = getPartitionOne( );
        StructureFieldContainer<TranslatableTextFragment> cont = new StructureFieldContainer<TranslatableTextFragment>( );
        TranslatableTextFragment.Descriptors desc = TranslatableTextFragment.DESCRIPTORS;
        // create a text with a given transUnitId
        cont.put( desc.MAX_WIDTH( ), 100 ).put( desc.ORIGINAL_TEXT( ), "deep copy test" ).put( desc.RES_TYPE( ), "resType" ).put( desc.TRANSLATE( ), true ).put( desc.TRANS_UNIT_ID( ), "transUnitId" );
        A19TranslatableTextFragment text = getMOINConnection( ).getPackage( TranslatabletextsPackage.PACKAGE_DESCRIPTOR ).createA19TranslatableTextFragment( cont );
        B19Serialization b19Serialization = getMOINConnection( ).createElementInPartition( B19Serialization.class, myPartition );
        b19Serialization.setTestTranslatableTextFragment( text );
        // deep copy
        DeepCopyResultSet result = getMOINConnection( ).deepCopy( Collections.singletonList( (RefObject) b19Serialization ), null, false );
        Collection<RefObject> copiedElements = result.getCopiedElements( );
        assertEquals( 1, copiedElements.size( ) );
        RefObject copiedElement = copiedElements.iterator( ).next( );
        assertTrue( copiedElement instanceof B19Serialization );
        B19Serialization b19SerializationCopied = (B19Serialization) copiedElement;
        // check all fields for equality
        A19TranslatableTextFragment textCopied = b19SerializationCopied.getTestTranslatableTextFragment( );
        assertTrue( "The max width should be equal, but it isn't.", textCopied.getMaxWidth( ) == 100 );
        assertTrue( "The max width should be equal, but it isn't.", textCopied.getOriginalText( ).equals( "deep copy test" ) );
        assertTrue( "The max width should be equal, but it isn't.", textCopied.getResType( ).equals( "resType" ) );
        assertTrue( "The max width should be equal, but it isn't.", textCopied.isTranslate( ) == true );
        // check whether the "transUnitId" field differs
        assertFalse( "The translation unit IDs should differ, but they are equal.", textCopied.getTransUnitId( ).equals( "transUnitId" ) );
    }

    /**
     * Check whether the text field "transUnitId" differs (!) after the copy and
     * all other fields remain the same for translatable texts.
     */
    @Test
    public void testTranslatableTextAttributes( ) {
        ModelPartition myPartition = getPartitionOne( );
        StructureFieldContainer<TranslatableText> cont = new StructureFieldContainer<TranslatableText>( );
        TranslatableText.Descriptors desc = TranslatableText.DESCRIPTORS;
        // create a text with a given transUnitId
        cont.put( desc.MAX_WIDTH( ), 100 ).put( desc.ORIGINAL_TEXT( ), "deep copy test" ).put( desc.RES_TYPE( ), "resType" ).put( desc.TRANSLATE( ), true ).put( desc.TRANS_UNIT_ID( ), "transUnitId" ).put( desc.RES_NAME( ), "resName" );
        TranslatableText text = getMOINConnection( ).getPackage( TextverticalizationPackage.PACKAGE_DESCRIPTOR ).createTranslatableText( cont );
        A1f a1f = getMOINConnection( ).createElementInPartition( A1f.class, myPartition );
        a1f.setTranslatableText( text );
        // deep copy
        DeepCopyResultSet result = getMOINConnection( ).deepCopy( Collections.singletonList( (RefObject) a1f ), null, false );
        Collection<RefObject> copiedElements = result.getCopiedElements( );
        assertEquals( 1, copiedElements.size( ) );
        RefObject copiedElement = copiedElements.iterator( ).next( );
        assertTrue( copiedElement instanceof A1f );
        A1f a1fCopied = (A1f) copiedElement;
        // check all fields for equality
        TranslatableText textCopied = a1fCopied.getTranslatableText( );
        assertTrue( "The max width should be equal, but it isn't.", textCopied.getMaxWidth( ) == 100 );
        assertTrue( "The max width should be equal, but it isn't.", textCopied.getOriginalText( ).equals( "deep copy test" ) );
        assertTrue( "The max width should be equal, but it isn't.", textCopied.getResType( ).equals( "resType" ) );
        assertTrue( "The max width should be equal, but it isn't.", textCopied.isTranslate( ) == true );
        assertTrue( "The max width should be equal, but it isn't.", textCopied.getResName( ).equals( "resName" ) );
        // check whether the "transUnitId" field differs
        assertFalse( "The translation unit IDs should differ, but they are equal.", textCopied.getTransUnitId( ).equals( "transUnitId" ) );
    }

    /**
     * Check whether the text field "transUnitId" differs (!) after the copy and
     * all other fields remain the same for translatable texts.
     */
    @Test
    public void testTranslatableTextAttributesMulti( ) {
        ModelPartition myPartition = getPartitionOne( );
        StructureFieldContainer<TranslatableText> cont = new StructureFieldContainer<TranslatableText>( );
        TranslatableText.Descriptors desc = TranslatableText.DESCRIPTORS;
        // create button texts with given transUnitIds
        // note that the resType is given by an initializer and is equals to "button"
        cont.put( desc.MAX_WIDTH( ), 100 ).put( desc.TRANSLATE( ), true ).put( desc.RES_NAME( ), "resName" );
        cont.put( desc.ORIGINAL_TEXT( ), "deep copy test of button1" );
        cont.put( desc.TRANS_UNIT_ID( ), "transUnitId1" );
        ButtonTextF buttonText1 = getMOINConnection( ).getPackage( Case004fPackage.PACKAGE_DESCRIPTOR ).createButtonTextF( cont );
        cont.put( desc.ORIGINAL_TEXT( ), "deep copy test of button2" );
        cont.put( desc.TRANS_UNIT_ID( ), "transUnitId2" );
        ButtonTextF buttonText2 = getMOINConnection( ).getPackage( Case004fPackage.PACKAGE_DESCRIPTOR ).createButtonTextF( cont );
        B19 b19 = getMOINConnection( ).createElementInPartition( B19.class, myPartition );
        b19.getTranslatableButtons( ).add( buttonText1 );
        b19.getTranslatableButtons( ).add( buttonText2 );
        // deep copy
        DeepCopyResultSet result = getMOINConnection( ).deepCopy( Collections.singletonList( (RefObject) b19 ), null, false );
        Collection<RefObject> copiedElements = result.getCopiedElements( );
        assertEquals( 1, copiedElements.size( ) );
        RefObject copiedElement = copiedElements.iterator( ).next( );
        assertTrue( copiedElement instanceof B19 );
        B19 b19Copied = (B19) copiedElement;
        // check all fields for equality
        ButtonTextF buttonText1Copied = null;
        ButtonTextF buttonText2Copied = null;
        // determine the right things to compare
        Iterator<ButtonTextF> iterator = b19Copied.getTranslatableButtons( ).iterator( );
        ButtonTextF firstButtonCopied = iterator.next( );
        ButtonTextF secondButtonCopied = iterator.next( );
        if ( firstButtonCopied.getOriginalText( ).equals( "deep copy test of button1" ) ) {
            buttonText1Copied = firstButtonCopied;
            buttonText2Copied = secondButtonCopied;
        } else {
            buttonText2Copied = firstButtonCopied;
            buttonText1Copied = secondButtonCopied;
        }
        // ok, now we have the copies, compare them with the originals now
        // compare the first button text
        assertTrue( "The max width should be equal, but it isn't.", buttonText1Copied.getMaxWidth( ) == 100 );
        assertTrue( "The max width should be equal, but it isn't.", buttonText1Copied.getOriginalText( ).equals( "deep copy test of button1" ) );
        assertTrue( "The max width should be equal, but it isn't.", buttonText1Copied.getResType( ).equals( "button" ) );
        assertTrue( "The max width should be equal, but it isn't.", buttonText1Copied.isTranslate( ) == true );
        assertTrue( "The max width should be equal, but it isn't.", buttonText1Copied.getResName( ).equals( "resName" ) );
        // check whether the "transUnitId" field differs
        assertFalse( "The translation unit IDs should differ, but they are equal.", buttonText1Copied.getTransUnitId( ).equals( "transUnitId1" ) );
        // compare the second button text
        assertTrue( "The max width should be equal, but it isn't.", buttonText2Copied.getMaxWidth( ) == 100 );
        assertTrue( "The max width should be equal, but it isn't.", buttonText2Copied.getOriginalText( ).equals( "deep copy test of button2" ) );
        assertTrue( "The max width should be equal, but it isn't.", buttonText2Copied.getResType( ).equals( "button" ) );
        assertTrue( "The max width should be equal, but it isn't.", buttonText2Copied.isTranslate( ) == true );
        assertTrue( "The max width should be equal, but it isn't.", buttonText2Copied.getResName( ).equals( "resName" ) );
        // check whether the "transUnitId" field differs
        assertFalse( "The translation unit IDs should differ, but they are equal.", buttonText2Copied.getTransUnitId( ).equals( "transUnitId2" ) );
    }
}
