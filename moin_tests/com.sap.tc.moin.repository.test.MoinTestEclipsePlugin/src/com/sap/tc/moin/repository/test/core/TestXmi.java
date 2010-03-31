package com.sap.tc.moin.repository.test.core;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.model.Constraint;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Tag;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.junit.Test;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionManager;
import com.sap.tc.moin.repository.core.cps.parser.CoreParserCallbackImpl;
import com.sap.tc.moin.repository.core.cps.parser.PartitionParserImpl;
import com.sap.tc.moin.repository.core.cps.serializer.CoreSerializerCallbackImpl;
import com.sap.tc.moin.repository.core.cps.serializer.PartitionSerializerImpl;
import com.sap.tc.moin.repository.core.serialization.PartitionReaderImpl;
import com.sap.tc.moin.repository.core.serialization.PartitionWriterImpl;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.repository.spi.core.serialization.SpiPartitionReader;
import com.sap.tc.moin.repository.spi.core.serialization.SpiPartitionWriter;
import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.testcases.TestcasesPackage;
import com.sap.tc.moin.testcases.case004.A4;
import com.sap.tc.moin.testcases.case004.B4;
import com.sap.tc.moin.testcases.case004.__impl.A4Impl;
import com.sap.tc.moin.testcases.case004.__impl.B4Impl;
import com.sap.tc.moin.testcases.case006.B6;
import com.sap.tc.moin.testcases.case006.C6;
import com.sap.tc.moin.testcases.case006.Case006Package;
import com.sap.tc.moin.testcases.case018.B18;
import com.sap.tc.moin.testcases.case019.serializationcallback.B19Serialization;
import com.sap.tc.moin.testcases.case019.translatabletexts.TranslatabletextsPackage;
import com.sap.tc.moin.testcasesfoundation.case001f.A1f;
import com.sap.tc.moin.textverticalization.TextverticalizationPackage;

public class TestXmi extends CoreMoinTest {

    @Override
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
    }

    @SuppressWarnings( "unchecked" )
    @Test
    public void testWritingAndReadingOfDanglingLinks( ) throws Exception {

        Connection conn1 = getMOINConnection( );
        Connection conn2 = getSecondMOINConnection( );
        ModelPartition mp1 = getPartitionOne( );
        ModelPartition mp2 = conn2.getPartition( getPartitionTwo( ).getPri( ) );

        ModelPackage mpkg = (ModelPackage) conn1.getPackage( null, TestMetaModels.MOIN_MOF_TPE_MODEL );
        MofPackage p1 = (MofPackage) mpkg.getMofPackage( ).refCreateInstance( );
        p1.setName( "MyPackage1" );
        mp1.assignElement( p1 );

        MofPackage p2 = (MofPackage) mpkg.getMofPackage( ).refCreateInstance( );
        p2.setName( "MyPackage2" );
        mp1.assignElement( p2 );

        ModelPackage mpkg2 = (ModelPackage) conn2.getPackage( null, TestMetaModels.MOIN_MOF_TPE_MODEL );
        Tag tag = (Tag) mpkg2.getTag( ).refCreateInstance( );
        tag.setName( "MyTag" );
        mp2.assignElement( tag );

        // Save both connections.
        conn1.save( );
        conn2.save( );

        // Establish links between the tag and the two MofPackages.
        tag.getElements( ).add( p1 );
        tag.getElements( ).add( p2 );

        // Delete the MofPackage p1 and save its connection.
        p1.refDelete( );
        conn1.save( );

        String xmiString = writePartitionXmlIntoString( conn2, mp2 );

        Tag tag2 = (Tag) mpkg2.getTag( ).refCreateInstance( );
        mp2.assignElement( tag2 );
        conn2.revert( );

        PRI pri = getPartitionThree( ).getPri( );
        CoreModelPartition mp3 = getTestHelper( ).getCoreModelPartition( conn2.getPartition( pri ) );
        RefPackage extent = ( (Wrapper<RefPackage>) conn2.getPackage( null, TestMetaModels.MOIN_MOF ) ).unwrap( );
        readPartitionXmlFromString( conn2, mp3, extent, xmiString );

        assertTrue( "Expected to find one model element in partition", mp3.getElements( ).size( ) == 1 );
        assertTrue( "Expected to find two links in partition", mp3.getLinks( ).size( ) == 2 );
    }

    @SuppressWarnings( "unchecked" )
    @Test
    public void testUnintentionalLoadingOfPartitionsDuringWriting( ) throws Exception {

        Connection conn = getMOINConnection( );
        ModelPackage modelPackage = (ModelPackage) conn.getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );
        MofPackage mofPackage = (MofPackage) modelPackage.getMofPackage( ).refCreateInstance( );
        getPartitionOne( ).assignElement( mofPackage );
        MofClass mofClass = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        getPartitionTwo( ).assignElement( mofClass );
        Constraint constraint = (Constraint) modelPackage.getConstraint( ).refCreateInstance( );
        getPartitionThree( ).assignElement( constraint );
        constraint.getConstrainedElements( ).add( mofPackage );
        mofClass.setContainer( mofPackage );
        conn.save( );
        CoreConnection coreConn = getTestHelper( ).getCoreConnection( conn );
        CorePartitionManager partitionManager = coreConn.getSession( ).getCompoundClientSpecWorkspace( ).getPartitionManager( );
        CoreModelPartition corePartitionTwo = getTestHelper( ).getCoreModelPartition( getPartitionTwo( ) );
        CoreModelPartition corePartitionThree = getTestHelper( ).getCoreModelPartition( getPartitionThree( ) );
        partitionManager.evictPartitionForced( corePartitionTwo );
        partitionManager.evictPartitionForced( corePartitionThree );
        mofPackage.setName( "newName" );
        @SuppressWarnings( "unused" )
        String result = writePartitionXmlIntoString( conn, getPartitionOne( ) );
        assertTrue( "Expected partitionTwo to be still evicted", !partitionManager.getLoadedPartitions( ).contains( corePartitionTwo ) );
        assertTrue( "Expected partitionThree to be still evicted", !partitionManager.getLoadedPartitions( ).contains( corePartitionThree ) );
    }

    @Test
    public void testCompositeAssociationWithReferenceOnlyOnChild( ) throws Exception {

        TestcasesPackage testcasesPackage = (TestcasesPackage) getMOINConnection( ).getPackage( TestMetaModels.TESTCASES_CN, new String[] { TestMetaModels.TESTCASES } );
        Case006Package case006Package = testcasesPackage.getCase006( );
        B6 parent = getMOINConnection( ).createElementInPartition( B6.class, null );
        C6 child = getMOINConnection( ).createElementInPartition( C6.class, null );
        child.setX( parent );
        getPartitionOne( ).assignElementIncludingChildren( parent );
        String xmiString = writePartitionXmlIntoString( getMOINConnection( ), getPartitionOne( ) );
        Connection conn2 = getSecondMOINConnection( );
        ModelPartition newPartition = _testClient2.createPartition( "test" );
        readPartitionXmlFromString( conn2, newPartition, testcasesPackage, xmiString );
        Iterator<Partitionable> iter = newPartition.getElements( ).iterator( );
        B6 parentNew = (B6) iter.next( );
        C6 childNew = (C6) iter.next( );
        assertTrue( "Expected to find a composite link", parentNew.equals( childNew.getX( ) ) );
    }

    @Test
    public void testReadingOfModelWithChangedQualifiedNameInMetamodel( ) throws Exception {

        StringBuilder buf = new StringBuilder( );
        buf.append( "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" );
        buf.append( "<Partition xmlns:m='http://xml.sap.com/moin'>" );
        buf.append( "<C n='test.sap.com/tc/moin/metamodel/testcases' i='1' v='1.0.0'/>" );
        buf.append( "<M c='1' q='testcases.case004.wrong.F4' i='45F120A57E4CF493F2554D201E5B9259CB1A21D7' ova='oneC,manyCs,manyCsOrdered'/>" );
        buf.append( "<testcases.case004.wrong.F4 m:c='1' m:i='480614C8FDEE52200BC511DDCEAE001558C93DC9'/>" );
        buf.append( "</Partition>" );
        byte[] partitionContent = buf.toString( ).getBytes( );
        SpiPartitionReader reader = new PartitionReaderImpl( );
        InputStream is = new ByteArrayInputStream( partitionContent );
        CoreConnection conn = getTestHelper( ).getCoreConnection( getMOINConnection( ) );
        CoreModelPartition mp = getTestHelper( ).getCoreModelPartition( getPartitionOne( ) );
        reader.read( conn.getSession( ), is, mp );
        assertEquals( 1, mp.getElements( ).size( ) );
    }

    @Test
    public void testLoadPartitionWithoutOvaInfo( ) throws Exception {

        // Create elements
        A4 a4 = this.getPartitionOne( ).createElement( A4.class );
        B4 b4 = this.getPartitionOne( ).createElement( B4.class );
        a4.setOneBchangeable( b4 );

        OutputStream bos = new ByteArrayOutputStream( );
        CoreSerializerCallbackImpl cbOut = new CoreSerializerCallbackImpl( getTestHelper( ).getCoreSession( getMOINConnection( ).getSession( ) ), getTestHelper( ).getCoreModelPartition( getPartitionOne( ) ) );
        new PartitionSerializerImpl( "1" ).serialize( bos, cbOut );
        String xmlFile = bos.toString( );
        StringBuffer buffer = new StringBuffer( xmlFile );
        String ovaString = " ova='";
        int indexOfOvaStart = xmlFile.indexOf( ovaString );
        int indexOfOvaEnd = xmlFile.indexOf( "'", indexOfOvaStart + ovaString.length( ) ) + 1;
        assertTrue( indexOfOvaStart != -1 );
        buffer.replace( indexOfOvaStart, indexOfOvaEnd, " " );
        String newXmlFile = buffer.toString( );
        InputStream bis = new ByteArrayInputStream( newXmlFile.getBytes( ) );
        CoreModelPartition transientPartition = getTestHelper( ).getCoreModelPartition( getMOINConnection( ).getOrCreateTransientPartition( "test" ) );
        CoreParserCallbackImpl cbIn = new CoreParserCallbackImpl( getTestHelper( ).getCoreMoin( ).getPartitionSerializationManager( ), getTestHelper( ).getCoreSession( getMOINConnection( ).getSession( ) ), getTestHelper( ).getCoreModelPartition( transientPartition ) );
        new PartitionParserImpl( ).parse( bis, cbIn, -1 );

        A4Impl a4Loaded = null;
        B4Impl b4Loaded = null;
        for ( Partitionable element : transientPartition.getElements( ) ) {
            if ( element instanceof A4Impl ) {
                a4Loaded = (A4Impl) element;
            }
            if ( element instanceof B4Impl ) {
                b4Loaded = (B4Impl) element;
            }
        }
        assertNotNull( a4Loaded );
        assertNotNull( b4Loaded );
        assertEquals( b4Loaded, a4Loaded.getOneBchangeable( getTestHelper( ).getCoreConnection( getMOINConnection( ) ) ) );
    }

    @Test
    public void testCompletenessOfUsedMetamodelsInHeader( ) throws Exception {

        CRI criTestcases = getMOINConnection( ).getClass( B18.CLASS_DESCRIPTOR ).refMetaObject( ).get___Partition( ).getPri( ).getCri( );
        CRI criTestcasesFoundation = getMOINConnection( ).getClass( A1f.CLASS_DESCRIPTOR ).refMetaObject( ).get___Partition( ).getPri( ).getCri( );
        CRI criTextverticalization = getMOINConnection( ).getPackage( TextverticalizationPackage.PACKAGE_DESCRIPTOR ).refMetaObject( ).get___Partition( ).getPri( ).getCri( );

        // B18 from testcases inherits from B1f from testcases-foundation
        // => both metamodels must be marked as used
        getPartitionOne( ).createElement( B18.CLASS_DESCRIPTOR );

        getMOINConnection( ).save( );
        Map<CRI, String> usedMetamodels = getPartitionOne( ).getUsedMetamodels( );
        assertEquals( 2, usedMetamodels.size( ) );
        assertTrue( usedMetamodels.containsKey( criTestcases ) );
        assertTrue( usedMetamodels.containsKey( criTestcasesFoundation ) );

        A1f a1f = getPartitionOne( ).createElement( A1f.CLASS_DESCRIPTOR );
        // Creating a RefStruct for the TranslatableText StructureType and setting it as attribute value of a1f
        // must add textverticalization to the list of used metamodels.
        a1f.setTranslatableText( getMOINConnection( ).getPackage( TextverticalizationPackage.PACKAGE_DESCRIPTOR ).createTranslatableText( null ) );

        getMOINConnection( ).save( );
        usedMetamodels = getPartitionOne( ).getUsedMetamodels( );
        assertEquals( 3, usedMetamodels.size( ) );
        assertTrue( usedMetamodels.containsKey( criTestcases ) );
        assertTrue( usedMetamodels.containsKey( criTestcasesFoundation ) );
        assertTrue( usedMetamodels.containsKey( criTextverticalization ) );

        // B19 belongs to testcases, but has a StructureType'd attribute named 'testTranslatableText', which has super-StructureTypes
        // both from testcases-foundation and from textverticalization. Therfore, all 3 metamodels must be marked as used.
        B19Serialization b19 = getPartitionTwo( ).createElement( B19Serialization.CLASS_DESCRIPTOR );
        b19.setTestTranslatableText( getMOINConnection( ).getPackage( TranslatabletextsPackage.PACKAGE_DESCRIPTOR ).createA19TranslatableText( null ) );

        getMOINConnection( ).save( );
        usedMetamodels = getPartitionTwo( ).getUsedMetamodels( );
        assertEquals( 3, usedMetamodels.size( ) );
        assertTrue( usedMetamodels.containsKey( criTestcases ) );
        assertTrue( usedMetamodels.containsKey( criTestcasesFoundation ) );
        assertTrue( usedMetamodels.containsKey( criTextverticalization ) );
    }

    private String writePartitionXmlIntoString( Connection connection, ModelPartition partition ) throws Exception {

        ByteArrayOutputStream bos = new ByteArrayOutputStream( );
        SpiPartitionWriter writer = new PartitionWriterImpl( );
        writer.write( ( (Wrapper<CoreConnection>) connection ).unwrap( ).getSession( ), bos, getTestHelper( ).getCoreModelPartition( partition ) );
        String result = bos.toString( );
        return result;
    }

    private void readPartitionXmlFromString( Connection connection, ModelPartition partition, RefPackage extent, String xmiString ) throws Exception {

        SpiPartitionReader reader = new PartitionReaderImpl( );
        ByteArrayInputStream bis = new ByteArrayInputStream( xmiString.getBytes( ) );
        reader.read( ( (Wrapper<CoreConnection>) connection ).unwrap( ).getSession( ), bis, getTestHelper( ).getCoreModelPartition( partition ) );
    }
}