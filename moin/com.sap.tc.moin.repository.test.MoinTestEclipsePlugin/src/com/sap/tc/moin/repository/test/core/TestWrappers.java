/**
 * 
 */
package com.sap.tc.moin.repository.test.core;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import com.sap.mi.gfw.mm.datatypes.Color;
import com.sap.mi.gfw.mm.datatypes.Point;
import com.sap.mi.gfw.mm.graphics.GraphicsPackage;
import com.sap.mi.gfw.mm.pictograms.Polygon;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.serialization.PartitionReaderImpl;
import com.sap.tc.moin.repository.core.serialization.PartitionWriterImpl;
import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Tag;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.testcases.TestcasesPackage;
import com.sap.tc.moin.testcases.case004.A4;
import com.sap.tc.moin.testcases.case004.B4;

/**
 * Containts test cases for the wrapper functionality in MOIN
 * 
 * @author d046074
 */
public class TestWrappers extends CoreMoinTest {

    /**
     * initializes the test; i.e. imports the metal model, selects the
     * ServiceInteractions package and creates messages and an association
     */
    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
    }

    /**
     * Test case to check the usage of wrapped JMI lists in ArrayList
     * constructors. Has been created because of of reported bug in MS6 which
     * should be fixed by now. Stacktrace identifying this bug:
     * java.lang.NullPointerException at
     * com.sap.tc.moin.repository.core.impl.ConnectionImpl
     * .getWrapperForJmiObject(ConnectionImpl.java:935) at
     * com.sap.tc.moin.repository
     * .core.ListWrapper$WrapperDerivationService.getDerivative
     * (ListWrapper.java:265) at
     * com.sap.tc.moin.repository.shared.util.DerivedCollection
     * .toArray(DerivedCollection.java:208) at
     * com.sap.tc.moin.repository.core.ListWrapper.toArray(ListWrapper.java:250)
     * at java.util.ArrayList.<init>(ArrayList.java:136) at
     * com.sap.tc.moin.repository
     * .test.core.TestWrappers.testJmiListWrapperOnArrayListConstructor
     * (TestWrappers.java:56)
     */
    @Test
    public void testJmiListWrapperOnArrayListConstructor( ) throws Exception {

        // Get MofClass instance for GeneralizableElement from UML1.5 MM
        MofClass mofClass = (MofClass) getMOINConnection( ).getClass( GeneralizableElement.CLASS_DESCRIPTOR ).refMetaObject( );
        // get immediate composite of mof class which should be package Core
        MofPackage mp = (MofPackage) mofClass.refImmediateComposite( );
        // get contents of package ModelPackage 
        List list = mp.getContents( );
        // Bug should have happen in the next line
        ArrayList newList = new ArrayList( list );
        assertEquals( list.size( ), newList.size( ) );
    }

    @Test
    public void testListWrapper( ) throws Exception {

        MofClass mofClass = (MofClass) getMOINConnection( ).getClass( GeneralizableElement.CLASS_DESCRIPTOR ).refMetaObject( );
        // get immediate composite of mof class which should be package ModelPackage 
        MofPackage mp = (MofPackage) mofClass.refImmediateComposite( );
        List list = mp.getContents( );
        assertTrue( "Expected list to be wrapped", list instanceof Wrapper );
        assertTrue( "Expected subList to be wrapped", list.subList( 0, 5 ) instanceof Wrapper );
    }

    @Test
    public void testJmiListWrapper( ) throws Exception {

        Connection connection = getMOINConnection( );
        ModelPackage modelPackage = connection.getPackage( ModelPackage.PACKAGE_DESCRIPTOR );
        MofPackage mofPackage = (MofPackage) modelPackage.getMofPackage( ).refCreateInstance( );
        MofClass mc1 = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        MofClass mc2 = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        MofClass mc3 = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        mc1.setContainer( mofPackage );
        mc2.setContainer( mofPackage );
        mc3.setContainer( mofPackage );
        List contents = mofPackage.getContents( );
        List<MofClass> referenceList = Arrays.asList( new MofClass[] { mc1, mc2, mc3 } );
        assertEquals( referenceList, contents );
        assertEquals( contents, referenceList );
        assertEquals( -1, contents.indexOf( null ) );
        assertEquals( 1, contents.indexOf( mc2 ) );
        assertEquals( 1, contents.lastIndexOf( mc2 ) );
        ListIterator<ModelElement> listIterator = contents.listIterator( );
        assertFalse( listIterator.hasPrevious( ) );
        try {
            listIterator.previous( );
            fail( "Expected NoSuchElementException to be thrown" );
        } catch ( NoSuchElementException ex ) {
        }
        assertEquals( -1, listIterator.previousIndex( ) );
        assertEquals( 0, listIterator.nextIndex( ) );
        MofClass mc4 = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        listIterator.add( mc4 );
        try {
            listIterator.set( mc4 );
            fail( "Expected IllegalStateException to be thrown" );
        } catch ( IllegalStateException ex ) {
        }
        listIterator = contents.listIterator( );
        listIterator.next( );
        listIterator.next( );
//        try {
//            listIterator.set( mc4 );
//            fail( "Expected ...Exception to be thrown" );
//        } catch ( Exception ex ) {
//        }
        MofClass mc5 = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        listIterator.set( mc5 );
    }

    @SuppressWarnings( "unchecked" )
    @Test
    public void testAttributeValuesWrapper( ) throws Exception {

        Connection connection = getMOINConnection( );
        ModelPackage modelPackage = connection.getPackage( ModelPackage.PACKAGE_DESCRIPTOR );
        EnumerationType enumType1 = (EnumerationType) modelPackage.getEnumerationType( ).refCreateInstance( );
        EnumerationType enumType2 = (EnumerationType) modelPackage.getEnumerationType( ).refCreateInstance( );
        List labels1 = enumType1.getLabels( );
        for ( int i = 0; i < 10; i++ ) {
            labels1.add( "Label" + i );
        }
        List labels2 = enumType2.getLabels( );
        labels2.addAll( labels1 );
        assertTrue( labels2.get( 0 ).equals( "Label0" ) );
        assertTrue( labels2.get( 9 ).equals( "Label9" ) );

        List subList1 = labels1.subList( 0, 3 );
        subList1.clear( );
        assertTrue( labels1.size( ) == 7 );
        assertTrue( labels1.get( 0 ).equals( "Label3" ) );

        List subList2 = labels2.subList( 0, 3 );
        for ( Iterator it = subList2.iterator( ); it.hasNext( ); ) {
            it.next( );
            it.remove( );
        }
        assertTrue( labels2.size( ) == 7 );
        assertTrue( labels2.get( 0 ).equals( "Label3" ) );

        List subList3 = labels1.subList( 0, 3 );
        int i = 0;
        for ( ListIterator lit = subList3.listIterator( ); lit.hasNext( ); ) {
            lit.next( );
            lit.set( "Test" + i++ );
            if ( !lit.hasNext( ) ) {
                lit.add( "Test3" );
                lit.add( "Test4" );
                lit.add( "Test5" );
            }
        }
        assertTrue( labels1.size( ) == 10 );
        assertTrue( labels1.get( 0 ).equals( "Test0" ) );
        assertTrue( labels1.get( 1 ).equals( "Test1" ) );
        assertTrue( labels1.get( 2 ).equals( "Test2" ) );
        assertTrue( labels1.get( 3 ).equals( "Test3" ) );
        assertTrue( labels1.get( 4 ).equals( "Test4" ) );
        assertTrue( labels1.get( 5 ).equals( "Test5" ) );

        labels1.clear( );
        labels1.add( "Entry1" );
        labels1.add( "Entry2" );
        labels1.add( "Entry3" );
        List<String> referenceList = Arrays.asList( new String[] { "Entry1", "Entry2", "Entry3" } );
        assertEquals( labels1, referenceList );
        assertEquals( referenceList, labels1 );
    }

    @Test
    public void testMetamodelEditing( ) throws Exception {

        Connection conn = getMOINConnection( );
        TestcasesPackage testcasesPackage = conn.getPackage( TestcasesPackage.PACKAGE_DESCRIPTOR );
        MofPackage metaObject = (MofPackage) testcasesPackage.refMetaObject( );
        String testcasesPackageName = metaObject.getName( );
        ModelPartition umlMetamodelPartition = ( (Partitionable) testcasesPackage.refMetaObject( ) ).get___Partition( );
        PRI partitionPri = umlMetamodelPartition.getPri( );
        ByteArrayOutputStream bos = new ByteArrayOutputStream( );
        new PartitionWriterImpl( ).write( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ), bos, getTestHelper( ).getCoreModelPartition( umlMetamodelPartition ) );

        PRI partOnePRI = getPartitionOne( ).getPri( );
        getPartitionOne( ).delete( );
        getMOINConnection( ).save( );

        PRI editablePri = conn.getSession( ).getMoin( ).createPri( partitionPri.getDataAreaDescriptor( ).getFacilityId( ), partOnePRI.getDataAreaDescriptor( ).getDataAreaName( ), partOnePRI.getContainerName( ), partOnePRI.getPartitionName( ) );
        ModelPartition editablePartition = conn.createPartition( editablePri );
        ByteArrayInputStream bis = new ByteArrayInputStream( bos.toByteArray( ) );
        new PartitionReaderImpl( ).read( getTestHelper( ).getCoreConnection( conn ).getSession( ), bis, getTestHelper( ).getCoreModelPartition( editablePartition ) );
        for ( Partitionable element : editablePartition.getElements( ) ) {
            if ( element instanceof MofPackage && ( (MofPackage) element ).getName( ).equals( testcasesPackageName ) ) {
                assertNotSame( "Expected different JMI wrappers for the two different data areas", metaObject, element );
            }
        }
    }

    @SuppressWarnings( "unchecked" )
    @Test
    public void testJmiHelper( ) throws Exception {

        Connection conn = getMOINConnection( );
        JmiHelper jmiHelper = conn.getJmiHelper( );

        GraphicsPackage graphics = (GraphicsPackage) conn.getPackage( TestMetaModels.GFW_CN, TestMetaModels.GFW_TPE );
        Polygon polygon = getMOINConnection( ).createElementInPartition( Polygon.class, null );
        polygon.setFilled( true );
        StructureFieldContainer<Point> container = new StructureFieldContainer<Point>();
        container.put(Point.DESCRIPTORS.X(), 10);
        container.put(Point.DESCRIPTORS.Y(), 10);
        Point p1 = graphics.getDatatypes().createPoint(container);
       
        container = new StructureFieldContainer<Point>();
        container.put(Point.DESCRIPTORS.X(), 20);
        container.put(Point.DESCRIPTORS.Y(), 20);
        Point p2 = graphics.getDatatypes().createPoint(container);
        
        container = new StructureFieldContainer<Point>();
        container.put(Point.DESCRIPTORS.X(), 30);
        container.put(Point.DESCRIPTORS.Y(), 30);
        Point p3 = graphics.getDatatypes().createPoint(container);
        
        polygon.getPoints( ).add( p1 );
        polygon.getPoints( ).add( p2 );
        polygon.getPoints( ).add( p3 );
        Color color = getMOINConnection( ).createElementInPartition( Color.class, null );
        color.setRed( 100 );
        color.setGreen( 100 );
        color.setBlue( 200 );

        polygon.setBackground( color );
        jmiHelper.getAttributesWithValues( polygon, true );

        Association assoc = (Association) graphics.getPictograms( ).getConnectionContainsConnectionDecorators( ).refMetaObject( );
        List<AssociationEnd> ends = jmiHelper.getAssociationEnds( assoc );
        jmiHelper.getReferences( ends.get( 0 ) );
        jmiHelper.getReferences( ends.get( 1 ) );

        jmiHelper.getSubTypes( (GeneralizableElement) graphics.getPictograms( ).getPictogramElement( ).refMetaObject( ) );
        jmiHelper.getAllSubtypes( (GeneralizableElement) graphics.getPictograms( ).getPictogramElement( ).refMetaObject( ) );

        System.out.println( );
    }

    @Test
    public void testListIteratorAdd( ) throws Exception {

        MofPackage mofPackage = getPartitionOne( ).createElement( MofPackage.class );
        MofClass mofClass = getPartitionTwo( ).createElement( MofClass.class );
        mofClass.setContainer( mofPackage );
        getMOINConnection( ).save( );

        List<ModelElement> contents = mofClass.getContents( );
        for ( int i = 0; i < 10; i++ ) {
            contents.add( getPartitionTwo( ).createElement( Attribute.class ) );
        }
        getMOINConnection( ).save( );

        String name = "addedAttr";

        int i = 0;
        for ( ListIterator<ModelElement> listIterator = contents.listIterator( ); listIterator.hasNext( ); ) {
            ModelElement element = listIterator.next( );
            if ( i == 5 ) {
                Attribute addedAttr = getPartitionTwo( ).createElement( Attribute.class );
                addedAttr.setName( name );
                listIterator.add( addedAttr );
            }
            if ( i > 5 ) {
                assertSame( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ).getWorkspace( ), getTestHelper( ).getCorePartitionable( (Partitionable) element ).get___Workspace( ) );
            }
            i++;
        }

        assertEquals( 10, i );
        assertEquals( 11, contents.size( ) );
        assertEquals( name, contents.get( 6 ).getName( ) );
    }

    @Test
    public void testListIteratorSet( ) throws Exception {

        MofClass mofClass = getPartitionTwo( ).createElement( MofClass.class );
        List<ModelElement> contents = mofClass.getContents( );
        for ( int i = 0; i < 10; i++ ) {
            contents.add( getPartitionTwo( ).createElement( Attribute.class ) );
        }
        getMOINConnection( ).save( );

        String name = "replacingAttr";

        int i = 0;
        for ( ListIterator<ModelElement> listIterator = contents.listIterator( ); listIterator.hasNext( ); ) {
            ModelElement element = listIterator.next( );
            if ( i == 5 ) {
                Attribute replacingAttr = getPartitionTwo( ).createElement( Attribute.class );
                replacingAttr.setName( name );
                listIterator.set( replacingAttr );
            }
            if ( i > 5 ) {
                assertSame( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ).getWorkspace( ), getTestHelper( ).getCorePartitionable( (Partitionable) element ).get___Workspace( ) );
            }
            i++;
        }

        assertEquals( 10, i );
        assertEquals( 10, contents.size( ) );
        assertEquals( name, contents.get( 5 ).getName( ) );
    }

    @Test
    public void testListIteratorPrevious( ) throws Exception {

        MofClass mofClass = getPartitionTwo( ).createElement( MofClass.class );
        List<ModelElement> contents = mofClass.getContents( );
        for ( int i = 1; i <= 2; i++ ) {
            Attribute attribute = getPartitionTwo( ).createElement( Attribute.CLASS_DESCRIPTOR );
            attribute.setName( "attribute" + i );
            contents.add( attribute );
        }
        getMOINConnection( ).save( );

        ListIterator<ModelElement> listIterator = contents.listIterator( );
        ModelElement element = null;

        element = listIterator.next( );
        assertEquals( "attribute1", element.getName( ) );

        element = listIterator.next( );
        assertEquals( "attribute2", element.getName( ) );

        element = listIterator.previous( );
        assertEquals( "attribute2", element.getName( ) ); // previous() directly after next() returns the same element again!

        element = listIterator.previous( ); // we are back at attribute1
        assertEquals( "attribute1", element.getName( ) );

        listIterator.remove( );

        assertEquals( 1, contents.size( ) );
        assertTrue( listIterator.hasNext( ) );
    }

    @Test
    public void testJmiListWrapperToArray( ) throws Exception {

        {
            // MOF (unordered)
            Tag tag = getPartitionOne( ).createElement( Tag.class );
            Collection<ModelElement> elements = tag.getElements( );
            Attribute attribute1 = getPartitionOne( ).createElement( Attribute.CLASS_DESCRIPTOR );
            elements.add( attribute1 );
            Attribute attribute2 = getPartitionOne( ).createElement( Attribute.CLASS_DESCRIPTOR );
            elements.add( attribute2 );

            Object[] untypedArray = elements.toArray( );
            assertEquals( 2, untypedArray.length );
            boolean found1 = false;
            boolean found2 = false;
            for ( Object object : untypedArray ) {
                if ( object.equals( attribute1 ) ) {
                    found1 = true;
                }
                if ( object.equals( attribute2 ) ) {
                    found2 = true;
                }
            }
            assertTrue( found1 );
            assertTrue( found2 );

            ModelElement[] typedArray = elements.toArray( new ModelElement[0] );
            assertEquals( 2, typedArray.length );
            found1 = false;
            found2 = false;
            for ( Object object : typedArray ) {
                if ( object.equals( attribute1 ) ) {
                    found1 = true;
                }
                if ( object.equals( attribute2 ) ) {
                    found2 = true;
                }
            }
            assertTrue( found1 );
            assertTrue( found2 );

            typedArray = elements.toArray( new ModelElement[1] );
            assertEquals( 2, typedArray.length );
            found1 = false;
            found2 = false;
            for ( Object object : typedArray ) {
                if ( object.equals( attribute1 ) ) {
                    found1 = true;
                }
                if ( object.equals( attribute2 ) ) {
                    found2 = true;
                }
            }
            assertTrue( found1 );
            assertTrue( found2 );

            typedArray = elements.toArray( new ModelElement[elements.size( )] );
            assertEquals( 2, typedArray.length );
            assertEquals( attribute1, typedArray[0] );
            assertEquals( attribute2, typedArray[1] );
        }

        {
            // MOF (ordered)
            MofClass mofClass = getPartitionOne( ).createElement( MofClass.class );
            List<ModelElement> contents = mofClass.getContents( );
            Attribute attribute1 = getPartitionOne( ).createElement( Attribute.CLASS_DESCRIPTOR );
            contents.add( attribute1 );
            Attribute attribute2 = getPartitionOne( ).createElement( Attribute.CLASS_DESCRIPTOR );
            contents.add( attribute2 );

            Object[] untypedArray = contents.toArray( );
            assertEquals( 2, untypedArray.length );
            assertEquals( attribute1, untypedArray[0] );
            assertEquals( attribute2, untypedArray[1] );

            ModelElement[] typedArray = contents.toArray( new ModelElement[0] );
            assertEquals( 2, typedArray.length );
            assertEquals( attribute1, typedArray[0] );
            assertEquals( attribute2, typedArray[1] );

            typedArray = contents.toArray( new ModelElement[1] );
            assertEquals( 2, typedArray.length );
            assertEquals( attribute1, typedArray[0] );
            assertEquals( attribute2, typedArray[1] );

            typedArray = contents.toArray( new ModelElement[contents.size( )] );
            assertEquals( 2, typedArray.length );
            assertEquals( attribute1, typedArray[0] );
            assertEquals( attribute2, typedArray[1] );
        }

        {
            // Testcases (unordered)
            A4 a4 = getPartitionOne( ).createElement( A4.class );
            Collection<B4> manyBs = a4.getManyBs( );
            B4 b4_1 = getPartitionOne( ).createElement( B4.CLASS_DESCRIPTOR );
            manyBs.add( b4_1 );
            B4 b4_2 = getPartitionOne( ).createElement( B4.CLASS_DESCRIPTOR );
            manyBs.add( b4_2 );

            Object[] untypedArray = manyBs.toArray( );
            assertEquals( 2, untypedArray.length );
            boolean found1 = false;
            boolean found2 = false;
            for ( Object object : untypedArray ) {
                if ( object.equals( b4_1 ) ) {
                    found1 = true;
                }
                if ( object.equals( b4_2 ) ) {
                    found2 = true;
                }
            }
            assertTrue( found1 );
            assertTrue( found2 );

            B4[] typedArray = manyBs.toArray( new B4[0] );
            assertEquals( 2, typedArray.length );
            found1 = false;
            found2 = false;
            for ( Object object : typedArray ) {
                if ( object.equals( b4_1 ) ) {
                    found1 = true;
                }
                if ( object.equals( b4_2 ) ) {
                    found2 = true;
                }
            }
            assertTrue( found1 );
            assertTrue( found2 );

            typedArray = manyBs.toArray( new B4[1] );
            assertEquals( 2, typedArray.length );
            found1 = false;
            found2 = false;
            for ( Object object : typedArray ) {
                if ( object.equals( b4_1 ) ) {
                    found1 = true;
                }
                if ( object.equals( b4_2 ) ) {
                    found2 = true;
                }
            }
            assertTrue( found1 );
            assertTrue( found2 );

            typedArray = manyBs.toArray( new B4[manyBs.size( )] );
            assertEquals( 2, typedArray.length );
            found1 = false;
            found2 = false;
            for ( Object object : typedArray ) {
                if ( object.equals( b4_1 ) ) {
                    found1 = true;
                }
                if ( object.equals( b4_2 ) ) {
                    found2 = true;
                }
            }
            assertTrue( found1 );
            assertTrue( found2 );
        }

        {
            // Testcases (ordered)
            A4 a4 = getPartitionOne( ).createElement( A4.class );
            Collection<B4> manyBsOrdered = a4.getManyBsOrdered( );
            B4 b4_1 = getPartitionOne( ).createElement( B4.CLASS_DESCRIPTOR );
            manyBsOrdered.add( b4_1 );
            B4 b4_2 = getPartitionOne( ).createElement( B4.CLASS_DESCRIPTOR );
            manyBsOrdered.add( b4_2 );

            Object[] untypedArray = manyBsOrdered.toArray( );
            assertEquals( 2, untypedArray.length );
            assertEquals( b4_1, untypedArray[0] );
            assertEquals( b4_2, untypedArray[1] );

            B4[] typedArray = manyBsOrdered.toArray( new B4[0] );
            assertEquals( 2, typedArray.length );
            assertEquals( b4_1, typedArray[0] );
            assertEquals( b4_2, typedArray[1] );

            typedArray = manyBsOrdered.toArray( new B4[1] );
            assertEquals( 2, typedArray.length );
            assertEquals( b4_1, typedArray[0] );
            assertEquals( b4_2, typedArray[1] );

            typedArray = manyBsOrdered.toArray( new B4[manyBsOrdered.size( )] );
            assertEquals( 2, typedArray.length );
            assertEquals( b4_1, typedArray[0] );
            assertEquals( b4_2, typedArray[1] );
        }
    }
}