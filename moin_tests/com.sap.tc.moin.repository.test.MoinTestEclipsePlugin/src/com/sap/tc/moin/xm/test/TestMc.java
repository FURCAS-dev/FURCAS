package com.sap.tc.moin.xm.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.xm.XmInvalidXmlException;
import com.sap.tc.moin.repository.xm.ie.ModelExporter;
import com.sap.tc.moin.repository.xm.ie.ModelImporter;
import com.sap.tc.moin.repository.xm.parser.PModelElementHandle;
import com.sap.tc.moin.repository.xm.parser.ParserErrorHandler;
import com.sap.tc.moin.repository.xm.parser.ParserErrorHandlerDefault;
import com.sap.tc.moin.repository.xm.parser.XmParserConfiguration;
import com.sap.tc.moin.repository.xm.parser.XmParserHandler;
import com.sap.tc.moin.repository.xm.serializer.XmCustomSerializer;
import com.sap.tc.moin.repository.xm.serializer.XmSerializerConfiguration;
import com.sap.tc.moin.test.fw.TestClient;
import com.sap.tc.moin.test.testcase.MoinTestCase;
import com.sap.tc.moin.test.util.printer.MoinTestLogger;
import com.sap.tc.moin.xm.test.ps.McParser;
import com.sap.tc.moin.xm.test.ps.McParserWithoutLogicalSystemReference;
import com.sap.tc.moin.xm.test.ps.McSerializer;
import com.sap.tc.moin.xm.test.ps.PModelElementHandleTest;
import com.sap.tc.moin.xm.test.ps.ParserHelperApiTest;
import com.sap.tc.moin.xm.test.ps.ParserHelperApiTestRetardedLinkWrongEndAType;
import com.sap.tc.moin.xm.test.ps.ParserHelperApiTestRetardedLinkWrongEndATypeInterPartition;
import com.sap.tc.moin.xm.test.ps.ParserHelperApiTestRetardedLinkWrongEndBClassifier;
import com.sap.tc.moin.xm.test.ps.ParserHelperApiTestRetardedLinkWrongEndBClassifierInterPartition;
import com.sap.tc.moin.xm.test.ps.ParserHelperApiTestRetardedLinkWrongEndBName;
import com.sap.tc.moin.xm.test.ps.PersonParser;
import com.sap.tc.moin.xm.test.ps.PersonSerializer;
import com.sap.tc.moin.xm.test.ps.SerializerApiTest;
import com.sap.tc.moin.xm.test.ps.TestParser;
import com.sap.tc.moin.xm.test.ps.TestSerializer;
import com.sap.tc.moin.xm.test.ps.generated.ComplexTypeWithSimpleContentParser;
import com.sap.tc.moin.xm.test.ps.generated.ComplexTypeWithSimpleContentSerializer;
import com.sap.tc.moin.xm.test.ps.generated.ImportIncludeParser;
import com.sap.tc.moin.xm.test.ps.generated.ImportIncludeSerializer;
import com.sap.tc.moin.xm.test.ps.generated.RecursiveParser;
import com.sap.tc.moin.xm.test.ps.generated.RecursiveSerializer;
import com.sap.tc.moin.xm.test.xml.IOUtil;
import com.sap.tc.moin.xm.test.xml.XmlComparator;


/**
 * Tests for XM which use the mass configuration meta model.
 */
@SuppressWarnings( "nls" )
public class TestMc extends MoinTestCase {


    private TestClient testClient;

    @Before
    @Override
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        testClient = getTestHelper( ).getDefaultTestClient( true );

    }



    /**
     * Tests the import and export of Mass configuration data.
     * 
     * @throws Exception
     */
    @Test
    public void testMassConfiguration( ) throws Exception {

        final InputStream is = this.getXmlInstance( );
        // do not compare imported and exported file, because the order of the sub-elements of the exported
        // document is not identical with the order of the sub-elements of the imported document
        // (The Mass Configuration meta-model does not keep the order for LogicalSystem and ServiceReference model elements)     
        massConfiguration( is, null, null, false );
    }


    /**
     * Tests the usage of non-string attributes and mutli-attributes in XM.
     * 
     * @throws Exception
     */
    @Test
    public void testNonStringAtributesAndMultiAttributes( ) throws Exception {

        final InputStream xmlSource = this.getClass( ).getClassLoader( ).getResourceAsStream( "com/sap/tc/moin/xm/test/ps/test.xml" ); //$NON-NLS-1$
        final InputStream xsd = this.getClass( ).getClassLoader( ).getResourceAsStream( "com/sap/tc/moin/xm/test/ps/test.xsd" ); //$NON-NLS-1$
        final List<InputStream> xsdDocs = new ArrayList<InputStream>( 1 );
        xsdDocs.add( xsd );

        final Schema schema = getSchema( xsdDocs );

        importExport( new TestParser( ), new TestSerializer( false ), xmlSource, schema, new ParserErrorHandlerDefault( ), true, null ); //$NON-NLS-1$//$NON-NLS-2$
    }

    /**
     * Tests the generated parser/serializer for complex type with simple
     * content.
     * 
     * @throws Exception
     */
    @Test
    public void testGeneratedComplexTypeWithSimpleContent( ) throws Exception {

        final InputStream xmlSource = this.getClass( ).getClassLoader( ).getResourceAsStream( "com/sap/tc/moin/xm/test/ps/ComplexTypeWithSimpleContent.xml" ); //$NON-NLS-1$
        importExport( new ComplexTypeWithSimpleContentParser( ), new ComplexTypeWithSimpleContentSerializer( ), xmlSource, null, new ParserErrorHandlerDefault( ), true, null ); //$NON-NLS-1$//$NON-NLS-2$
    }

    /**
     * Tests recursive calls. And tests whether different root elements can be
     * treated by the XM Parser/Serializer.
     * 
     * @throws Exception
     */
    @Test
    public void testGeneratedRecursive( ) throws Exception {

        final RecursiveParser p = new RecursiveParser( );
        final RecursiveSerializer s = new RecursiveSerializer( );

        InputStream xmlSource = this.getClass( ).getClassLoader( ).getResourceAsStream( "com/sap/tc/moin/xm/test/ps/recursiveSource.xml" );
        importExport( p, s, xmlSource, null, new ParserErrorHandlerDefault( ), true, null );

        xmlSource = this.getClass( ).getClassLoader( ).getResourceAsStream( "com/sap/tc/moin/xm/test/ps/recursiveSourceStructure.xml" );
        importExport( p, s, xmlSource, null, new ParserErrorHandlerDefault( ), true, null );

        xmlSource = this.getClass( ).getClassLoader( ).getResourceAsStream( "com/sap/tc/moin/xm/test/ps/recursiveSourceField.xml" );
        importExport( p, s, xmlSource, null, new ParserErrorHandlerDefault( ), true, null );
    }

    /**
     * Tests the ordering.
     * 
     * @throws Exception
     */
    @Test
    public void testCompany( ) throws Exception {

        final PersonParser p = new PersonParser( );
        final PersonSerializer s = new PersonSerializer( );

        InputStream xmlSource = this.getClass( ).getClassLoader( ).getResourceAsStream( "com/sap/tc/moin/xm/test/ps/testPerson.xml" );
        importExport( p, s, xmlSource, null, new ParserErrorHandlerDefault( ), true, null );

    }

    /**
     * Tests the import and export of an XML root element with simple type XM
     * Parser/Serializer.
     * 
     * @throws Exception
     */
    @Test
    public void testGeneratedImportIncludeXmlRootElementWithSimpleType( ) throws Exception {

        final ImportIncludeParser p = new ImportIncludeParser( );
        final ImportIncludeSerializer s = new ImportIncludeSerializer( );

        InputStream xmlSource = this.getClass( ).getClassLoader( ).getResourceAsStream( "com/sap/tc/moin/xm/test/ps/importIncludeSource.xml" );
        importExport( p, s, xmlSource, null, new ParserErrorHandlerDefault( ), true, null );
    }

    /**
     * Tests the import and export of two XML root elements with different names
     * but the same complex type.
     * 
     * @throws Exception
     */
    @Test
    public void testGeneratedImportIncludeXml( ) throws Exception {

        final ImportIncludeParser p = new ImportIncludeParser( );
        final ImportIncludeSerializer s = new ImportIncludeSerializer( );

        InputStream xmlSource = this.getClass( ).getClassLoader( ).getResourceAsStream( "com/sap/tc/moin/xm/test/ps/importIncludeSourceElementWithThirdComplexType.xml" ); //$NON-NLS-1$
        importExport( p, s, xmlSource, null, new ParserErrorHandlerDefault( ), true, null ); //$NON-NLS-1$//$NON-NLS-2$

        xmlSource = this.getClass( ).getClassLoader( ).getResourceAsStream( "com/sap/tc/moin/xm/test/ps/importIncludeSourceImportElementSecondWithThirdComplexType.xml" ); //$NON-NLS-1$
        importExport( p, s, xmlSource, null, new ParserErrorHandlerDefault( ), true, null ); //$NON-NLS-1$//$NON-NLS-2$

    }

    /**
     * Tests the validation of the source XML with the Mass Configuration
     * example.
     * 
     * @throws Exception
     */
    @Test
    public void testXmlSourceValidation( ) throws Exception {

        InputStream xmlSource = this.getClass( ).getClassLoader( ).getResourceAsStream( "com/sap/tc/moin/xm/test/ps/mc_SourceMc.xml" );
        final InputStream lsXsd = this.getClass( ).getClassLoader( ).getResourceAsStream( "com/sap/tc/moin/xm/test/ps/mc-logical-system.xsd" );
        final InputStream srXsd = this.getClass( ).getClassLoader( ).getResourceAsStream( "com/sap/tc/moin/xm/test/ps/mc-service-references.xsd" );
        final InputStream mcXsd = this.getClass( ).getClassLoader( ).getResourceAsStream( "com/sap/tc/moin/xm/test/ps/mc.xsd" );
        final List<InputStream> xsdDocs = new ArrayList<InputStream>( 3 );
        xsdDocs.add( lsXsd );
        xsdDocs.add( srXsd );
        xsdDocs.add( mcXsd );

        final Schema schema = getSchema( xsdDocs );

        massConfiguration( xmlSource, schema, new ParserErrorHandlerDefault( ), true );

        // try a second time with a wrong XML
        xmlSource = this.getClass( ).getClassLoader( ).getResourceAsStream( "com/sap/tc/moin/xm/test/ps/mc_SourceMcInvalid.xml" );
        boolean success = false;
        try {
            massConfiguration( xmlSource, schema, new ParserErrorHandlerDefault( ), false );
        } catch ( final XmInvalidXmlException e ) {
            // the exception is expected
            success = true;
        }
        assertTrue( "The validator has not detected the invalid source XML", success ); //$NON-NLS-1$
    }

    private void massConfiguration( final InputStream sourceXml, final Schema xmlSchema, final ParserErrorHandler errorHandler, final boolean comparisonOn ) throws Exception {

        final XmParserConfiguration pConfig = XmParserConfiguration.getInstance( new McParser( ), xmlSchema, errorHandler );
        final XmSerializerConfiguration sConfig = XmSerializerConfiguration.getInstance( new McSerializer( ) );
        importExport( sourceXml, pConfig, sConfig, comparisonOn, null );
    }

    /**
     * Tests the import of only a part of the document. The parser mapping XML
     * does not contain a xmlElement for a certain XML element of the source
     * document, so that the part tree of this XML element is not imported to
     * MOIN.
     * 
     * @throws Exception
     */
    @Test
    public void testPartImport( ) throws Exception {

        final InputStream xmlSource = this.getClass( ).getClassLoader( ).getResourceAsStream( "com/sap/tc/moin/xm/test/ps/mc_SourceMc.xml" ); //$NON-NLS-1$
        final InputStream xmlComparison = this.getClass( ).getClassLoader( ).getResourceAsStream( "com/sap/tc/moin/xm/test/ps/mc_SourceMcWithoutLogicalSystemReference.xml" ); //$NON-NLS-1$

        final XmParserConfiguration pConfig = XmParserConfiguration.getInstance( new McParserWithoutLogicalSystemReference( ), null, null );
        final XmSerializerConfiguration sConfig = XmSerializerConfiguration.getInstance( new McSerializer( ) );

        importExport( xmlSource, pConfig, sConfig, true, xmlComparison );
    }

    /**
     * Tests the exceptions of the ParserHelper API.
     * 
     * @throws Exception
     */
    @Test
    public void testExceptionsOfParserHelperApi( ) throws Exception {

        System.setProperty( "com.sap.tc.moin.xm.apitest.failure.importexport", "" );
        InputStream xmlSource = this.getClass( ).getClassLoader( ).getResourceAsStream( "com/sap/tc/moin/xm/test/ps/mc_SourceMc.xml" );
        final XmParserConfiguration pConfig = XmParserConfiguration.getInstance( new ParserHelperApiTest( ), null, null );
        //final XmSerializerConfiguration sConfig = XmSerializerConfiguration.getInstance( new McSerializer( ) );

        boolean success = false;
        try {
            importExport( xmlSource, pConfig, null, false, null );
        } catch ( IllegalArgumentException e ) {
            // exception is expected
            success = true;
        }

        String errors = System.getProperty( "com.sap.tc.moin.xm.apitest.failure.importexport" );
        if ( errors != null ) {
            assertTrue( errors, errors.length( ) == 0 );
        }
        assertTrue( "Expected IllegalArgumentException was not thrown", success );
    }

    /**
     * Tests the exceptions of the methods of {@link PModelElementHandle}.
     * 
     * @throws Exception
     */
    @Test
    public void testPModelElementHandle( ) throws Exception {

        System.setProperty( "com.sap.tc.moin.xm.apitest.failure.importexport", "" );
        InputStream xmlSource = this.getClass( ).getClassLoader( ).getResourceAsStream( "com/sap/tc/moin/xm/test/ps/mc_SourceMc.xml" );
        final XmParserConfiguration pConfig = XmParserConfiguration.getInstance( new PModelElementHandleTest( ), null, null );
        //final XmSerializerConfiguration sConfig = XmSerializerConfiguration.getInstance( new McSerializer( ) );

        importExport( xmlSource, pConfig, null, false, null );

        String errors = System.getProperty( "com.sap.tc.moin.xm.apitest.failure.importexport" );
        if ( errors != null ) {
            assertTrue( errors, errors.length( ) == 0 );
        }

    }

    /**
     * Tests the exceptions of the Serializer API.
     * 
     * @throws Exception
     */
    @Test
    public void testExceptionsOfSerializerApi( ) throws Exception {

        System.setProperty( "com.sap.tc.moin.xm.apitest.failure.importexport", "" );
        InputStream xmlSource = this.getClass( ).getClassLoader( ).getResourceAsStream( "com/sap/tc/moin/xm/test/ps/mc_SourceMc.xml" );
        final XmParserConfiguration pConfig = XmParserConfiguration.getInstance( new McParser( ), null, null );

        final XmSerializerConfiguration sConfig = XmSerializerConfiguration.getInstance( new SerializerApiTest( ) );

        importExport( xmlSource, pConfig, sConfig, false, null );

        String errors = System.getProperty( "com.sap.tc.moin.xm.apitest.failure.importexport" );
        if ( errors != null ) {
            assertTrue( errors, errors.length( ) == 0 );
        }
    }

    /**
     * Tests the creation of a retarded link with wrong end B name.
     * 
     * @throws Exception
     */
    @Test
    public void testRetardedLinkCreationWithWrongEndBName( ) throws Exception {

        InputStream xmlSource = this.getClass( ).getClassLoader( ).getResourceAsStream( "com/sap/tc/moin/xm/test/ps/mc_SourceMc.xml" );
        final XmParserConfiguration pConfig = XmParserConfiguration.getInstance( new ParserHelperApiTestRetardedLinkWrongEndBName( ), null, null );
        //final XmSerializerConfiguration sConfig = XmSerializerConfiguration.getInstance( new McSerializer( ) );

        boolean success = false;
        try {
            importExport( xmlSource, pConfig, null, false, null );
        } catch ( IllegalArgumentException e ) {
            // exception is expected
            String error = e.getMessage( );
            if ( error != null && error.contains( "wrong" ) ) {
                success = true;
            }
        }
        assertTrue( "Expected IllegalArgumentException was not thrown", success );
    }

    /**
     * Tests the creation of a retarded intra-partition link with wrong end B
     * classifier.
     * 
     * @throws Exception
     */
    @Test
    public void testRetardedLinkCreationWithWrongEndBClassifier( ) throws Exception {

        boolean success = false;
        InputStream xmlSource = this.getClass( ).getClassLoader( ).getResourceAsStream( "com/sap/tc/moin/xm/test/ps/mc_SourceMc.xml" );
        final XmParserConfiguration pConfig = XmParserConfiguration.getInstance( new ParserHelperApiTestRetardedLinkWrongEndBClassifier( ), null, null );
        try {
            importExport( xmlSource, pConfig, null, false, null );
        } catch ( IllegalArgumentException e ) {
            String s = e.getMessage( );
            if ( s != null && s.contains( "has to be of type \"LogicalSystem\"" ) ) {
                success = true;
            }
        }
        assertTrue( "Expected TypeMismatchException was not thrown", success );
    }

    /**
     * Tests the creation of a retarded inter-partition link with wrong end B
     * classifier.
     * 
     * @throws Exception
     */
    @Test
    public void testRetardedLinkCreationWithWrongEndBClassifierInterPartition( ) throws Exception {

        InputStream xmlSource = this.getClass( ).getClassLoader( ).getResourceAsStream( "com/sap/tc/moin/xm/test/ps/mc_SourceMc.xml" );
        final XmParserConfiguration pConfig = XmParserConfiguration.getInstance( new ParserHelperApiTestRetardedLinkWrongEndBClassifierInterPartition( ), null, null );

        importExport( xmlSource, pConfig, null, false, null );

        // no exception expected
    }

    /**
     * Tests the creation of a retarded intra-partition link with wrong end A
     * type.
     * 
     * @throws Exception
     */
    @Test
    public void testRetardedLinkCreationWithWrongEndAType( ) throws Exception {

        boolean success = false;
        InputStream xmlSource = this.getClass( ).getClassLoader( ).getResourceAsStream( "com/sap/tc/moin/xm/test/ps/mc_SourceMc.xml" );
        final XmParserConfiguration pConfig = XmParserConfiguration.getInstance( new ParserHelperApiTestRetardedLinkWrongEndAType( ), null, null );
        try {
            importExport( xmlSource, pConfig, null, false, null );
        } catch ( IllegalArgumentException e ) {
            String s = e.getMessage( );
            if ( s != null && s.contains( "has to be of type \"ServiceReference\"" ) ) {
                success = true;
            }
        }
        assertTrue( "Expected TypeMismatchException was not thrown", success );
    }

    /**
     * Tests the creation of a retarded inter-partition link with wrong end A
     * type.
     * 
     * @throws Exception
     */
    @Test
    public void testRetardedLinkCreationWithWrongEndATypeInterPartition( ) throws Exception {

        boolean success = false;
        InputStream xmlSource = this.getClass( ).getClassLoader( ).getResourceAsStream( "com/sap/tc/moin/xm/test/ps/mc_SourceMc.xml" );
        final XmParserConfiguration pConfig = XmParserConfiguration.getInstance( new ParserHelperApiTestRetardedLinkWrongEndATypeInterPartition( ), null, null );
        try {
            importExport( xmlSource, pConfig, null, false, null );
        } catch ( IllegalArgumentException e ) {
            String s = e.getMessage( );
            if ( s != null && s.contains( "has to be of type \"ServiceReference\"" ) ) {
                success = true;
            }
        }
        assertTrue( "Expected TypeMismatchException was not thrown", success );
    }



    /**
     * Tests the import and export of a PFL Business Process Catalog document.
     * 
     * @throws Exception
     */
    public void testPFLBusinessProcessCatalog( ) throws Exception {

//        final InputStream xmlSource = McCustomExitImport.class.getClassLoader( ).getResourceAsStream( "com/sap/tc/moin/xm/test/pfl/xsd/example/BusinessProcessCatalog.xml" ); //$NON-NLS-1$
////        final InputStream xmlComparison = McCustomExitImport.class.getClassLoader( ).getResourceAsStream( "com/sap/tc/moin/xm/test/customexit/mc/mc_SourceMcWithoutLogicalSystemReference.xml" ); //$NON-NLS-1$
//
//        importExport( null, null, "com/sap/tc/moin/xm/test/pfl/mapping/BusinessProcessCatalogParser.xml", "com/sap/tc/moin/xm/test/pfl/mapping/BusinessProcessCatalogSerializer.xml", xmlSource, null, null, false, null ); //$NON-NLS-1$//$NON-NLS-2$
    }

    /**
     * Tests the import and export of a PFL Business Scenario Catalog document.
     * 
     * @throws Exception
     */
    public void testPFLBusinessScenarioCatalog( ) throws Exception {

//        final InputStream xmlSource = McCustomExitImport.class.getClassLoader( ).getResourceAsStream( "com/sap/tc/moin/xm/test/pfl/xsd/example/BusinessScenarioCatalog.xml" ); //$NON-NLS-1$
////        final InputStream xmlComparison = McCustomExitImport.class.getClassLoader( ).getResourceAsStream( "com/sap/tc/moin/xm/test/customexit/mc/mc_SourceMcWithoutLogicalSystemReference.xml" ); //$NON-NLS-1$
//
//        importExport( null, null, "com/sap/tc/moin/xm/test/pfl/mapping/BusinessScenarioCatalogParser.xml", "com/sap/tc/moin/xm/test/pfl/mapping/BusinessScenarioCatalogSerializer.xml", xmlSource, null, null, false, null ); //$NON-NLS-1$//$NON-NLS-2$
    }

    /**
     * @param parserMappingXmlPath
     * @param serializerMappingXmlPath
     * @param sourceXml
     * @param xmlSchema
     * @param errorHandler
     * @param comparisonOn
     * @param compareExportedDocWithDoc XML document with which the exported
     * document should be compared, if <code>null</code> then the exported
     * document is compared with the original document which is imported
     * @throws Exception
     */
    private void importExport( final XmParserHandler customParser, final XmCustomSerializer serializer, final InputStream sourceXml, final Schema xmlSchema, final ParserErrorHandler errorHandler, final boolean comparisonOn, final InputStream compareExportedDocWithDoc ) throws Exception {

        final XmParserConfiguration pConfig = XmParserConfiguration.getInstance( customParser, xmlSchema, errorHandler );

        XmSerializerConfiguration sConfig = null;
        if ( serializer != null ) {
            sConfig = XmSerializerConfiguration.getInstance( serializer );
        }

        importExport( sourceXml, pConfig, sConfig, comparisonOn, compareExportedDocWithDoc );
    }



    /**
     * Tests the creation of an Inter Partition Link.
     * 
     * @throws Exception
     */
    @Test
    public void testInterPartitionLink( ) throws Exception {

        final Connection connection = testClient.getConnection( );
        final ModelPartition mpReferencing = testClient.getOrCreatePartitionStable( "TestMcReferencing" );
        mpReferencing.deleteElements( );
        final ModelPartition mpReferenced = testClient.getOrCreatePartitionStable( "TestMcReferenced" );
        mpReferenced.deleteElements( );
        try {

            final ModelImporter modelImporter = connection.createModelImporter( XmParserConfiguration.getInstance( new McParser( ), null, null ) );

            // import referencing resource
            final InputStream sourceReferencing = this.getRepeatableReadableInputStream( this.getClass( ).getClassLoader( ).getResourceAsStream( "com/sap/tc/moin/xm/test/ps/mc_SourceInterPartitonLinkReferencing.xml" ) );

            modelImporter.doImport( sourceReferencing, mpReferencing.getPri( ) );
            sourceReferencing.close( );

            // check what does happen with a dangling link; there should not occur any NullPointer Exceptions --------------------
            // export referencing resource
            final ModelExporter modelExporter = connection.createModelExporter( XmSerializerConfiguration.getInstance( new McSerializer( ) ) );

            ByteArrayOutputStream outputStreamReferencing = new ByteArrayOutputStream( );
            modelExporter.doExport( outputStreamReferencing, mpReferencing.getPri( ) );
            outputStreamReferencing.close( );
            // ------------------------------

            // import referenced resource
            final InputStream sourceReferenced = this.getRepeatableReadableInputStream( this.getClass( ).getClassLoader( ).getResourceAsStream( "com/sap/tc/moin/xm/test/ps/mc_SourceInterPartitonLinkReferenced.xml" ) );


            modelImporter.doImport( sourceReferenced, mpReferenced.getPri( ) );
            sourceReferenced.close( );

            connection.save( );

            // export referencing resource a second time, this time with a correct link
            outputStreamReferencing = new ByteArrayOutputStream( );
            modelExporter.doExport( outputStreamReferencing, mpReferencing.getPri( ) );
            outputStreamReferencing.close( );

            byte[] bytes = outputStreamReferencing.toByteArray( );
            sourceReferencing.reset( );
            this.compare( sourceReferencing, bytes );
            //System.out.println( new String( bytes, "UTF-8" ) );

            // export referenced resource
            final ByteArrayOutputStream outputStreamReferenced = new ByteArrayOutputStream( );
            modelExporter.doExport( outputStreamReferenced, mpReferenced.getPri( ) );
            outputStreamReferencing.close( );

            bytes = outputStreamReferenced.toByteArray( );
            sourceReferenced.reset( );
            this.compare( sourceReferenced, bytes );
            //System.out.println( new String( bytes, "UTF-8" ) );

        } finally {
            MoinTestLogger.printInfo( "revert partition" );
            if ( mpReferenced != null ) {
                mpReferenced.delete( );
            }
            if ( mpReferencing != null ) {
                mpReferencing.delete( );
            }
            if ( connection != null ) {
                connection.save( );
            }
            MoinTestLogger.printInfo( "revert partition finished" );
        }
    }

    /**
     * Tests the creation of an Inter Partition Link which is stored on the
     * wrong side.
     * 
     * @throws Exception
     */
    public void testInterPartitionLinkWrongStorageSide( ) throws Exception {

//        Connection connection = testClient.getConnection( );
//        try {
//            InputStream importMappingXML = McCustomExitImport.class.getClassLoader( ).getResourceAsStream( "com/sap/tc/moin/xm/test/customexit/mc/mc_mappingImportWrongInterpartition.xml" );
//
//            ModelImporter modelImporter = connection.createModelImporter( XmParserConfiguration.getInstance( new McCustomExitImport( ), null, null ) );
//            importMappingXML.close( );
//
//            // import referenced resource
//            InputStream sourceReferenced = McCustomExitImport.class.getClassLoader( ).getResourceAsStream( "com/sap/tc/moin/xm/test/customexit/mc/mc_SourceInterPartitonLinkReferenced.xml" );
//
//            ModelPartition mpReferenced = testClient.getOrCreatePartitionStable( "TestMcReferenced" );
//            mpReferenced.deleteElements( );
//
//            boolean successful = false;
//            try {
//                modelImporter.doImport( sourceReferenced, mpReferenced.getPri( ) );
//            } catch ( XmException e ) {
//                //test is successful if the exception is thrown.
//                MoinTestLogger.printInfo( e.getMessage( ) );
//                successful = true;
//            }
//
//            sourceReferenced.close( );
//
//            assertTrue( "No XmException was thrown. XmException expected because of storing of link on side on which it is not allowed", successful );
//
//        } finally {
//            MoinTestLogger.printInfo( "revert partition" );
//            connection.revert( );
//            MoinTestLogger.printInfo( "revert partition finished" );
//        }
    }


    private InputStream getXmlInstance( ) {

        final StringBuilder sb = new StringBuilder( this.getgetLogicalSystemsStart( ) );
        final String ls = this.getLogicalSystem( );
        sb.append( ls );
        sb.append( this.getLogicalSystemsClose( ) );

        sb.append( this.getServiceRefStart( ) );
        final String sr = this.getServiceRefs( );
        sb.append( sr );
        sb.append( this.getServiceRefClose( ) );
        try {
            final byte[] bytes = sb.toString( ).getBytes( "UTF-8" ); //$NON-NLS-1$
            return new ByteArrayInputStream( bytes );
        } catch ( final UnsupportedEncodingException e ) {
            // cannot happen
            throw new IllegalStateException( e );
        }
    }


    /**
     * Imports and exports a XML instance and compares the imported and exported
     * XML document.
     * 
     * @param xmlInstance XML instance
     * @param pConfig parser configuration
     * @param sConfig serializer configuration, can be <code>null</code> then
     * the export is not triggered
     * @param comparisonOn indicator whether the imported and exported XML
     * document should be compared
     * @param compareExportedDocWithDoc XML document with which the exported
     * document should be compared, if <code>null</code> then the exported
     * document is compared with the original document which is imported
     */
    private void importExport( InputStream xmlInstance, final XmParserConfiguration pConfig, final XmSerializerConfiguration sConfig, final boolean comparisonOn, final InputStream compareExportedDocWithDoc ) throws Exception {

        final Connection connection = testClient.getConnection( );
        if ( xmlInstance == null ) {
            throw new NullPointerException( "xmlInstance must not be null" );
        }
        if ( pConfig == null ) {
            throw new NullPointerException( "pConfig is null" );
        }

        // make xmlInstance repeatable readable
        xmlInstance = this.getRepeatableReadableInputStream( xmlInstance );

        try {
            final ModelImporter modelImporterNew = connection.createModelImporter( pConfig );

            final ModelPartition mp = testClient.getOrCreatePartitionStable( "TestMc" );
            mp.deleteElements( );

            /* import */
            long start = System.currentTimeMillis( );

            modelImporterNew.doImport( xmlInstance, mp.getPri( ) );

            long end = System.currentTimeMillis( );

            xmlInstance.close( );

            long result = end - start;

            final String importS = "NewImport ";

            MoinTestLogger.printInfo( importS + " takes " + result + "ms" );

            if ( sConfig != null ) {
                /* export */
                final ModelExporter modelExporterNew = connection.createModelExporter( sConfig );

                final ByteArrayOutputStream outputStream = new ByteArrayOutputStream( );
                start = System.currentTimeMillis( );
                modelExporterNew.doExport( outputStream, mp.getPri( ) );
                end = System.currentTimeMillis( );
                outputStream.close( );

                result = end - start;

                final String export = "NewExport ";

                MoinTestLogger.printInfo( export + " takes " + result + "ms" );

                if ( comparisonOn ) {
                    final byte[] exportedBytes = outputStream.toByteArray( );
                    //String s = new String( exportedBytes, "UTF-8" );
                    //System.out.println( s );
                    // compare imported and exported XML document
                    InputStream docToCompareWith;
                    if ( compareExportedDocWithDoc == null ) {
                        xmlInstance.reset( );
                        docToCompareWith = xmlInstance;
                    } else {
                        docToCompareWith = compareExportedDocWithDoc;
                    }
                    this.compare( docToCompareWith, exportedBytes );
                }
            }
        } finally {
            MoinTestLogger.printInfo( "revert partition" );
            if ( connection != null ) {
                connection.revert( );
            }
            MoinTestLogger.printInfo( "revert partition finished" );
        }
    }

    private InputStream getRepeatableReadableInputStream( InputStream xmlInstance ) throws IOException {

        if ( !( xmlInstance instanceof ByteArrayInputStream ) ) {
            // make xmlInstance repeatable readable
            return new ByteArrayInputStream( IOUtil.read( xmlInstance, false ) );
        }
        return xmlInstance;
    }

    private void compare( final InputStream docToCompareWith, final byte[] exportedBytes ) throws IOException {

        if ( exportedBytes != null ) {
            final StringBuilder differences = new StringBuilder( );
            XmlComparator.compare( docToCompareWith, new ByteArrayInputStream( exportedBytes ), differences );
            assertTrue( "The exported XML document is different from the imported XML document: \n" + differences.toString( ), differences.length( ) == 0 );
        } else {
            assertNotNull( exportedBytes );
        }
    }

    private String getLogicalSystem( ) {

        final StringBuilder sb = new StringBuilder( );
        for ( int i = 1; i <= 100; i++ ) {
            sb.append( this.getLogicalSystem( Integer.toString( i ) ) );
        }
        return sb.toString( );
    }

    private String getServiceRefs( ) {

        final StringBuilder sb = new StringBuilder( );
        for ( int i = 1; i <= 100; i++ ) {
            sb.append( this.getServiceRef( Integer.toString( i ) ) );
        }
        return sb.toString( );
    }

    private String getgetLogicalSystemsStart( ) {

        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "<ns0:mass-configuration xmlns:ns0=\"http://www.sap.com/webas/2007/03/esoa/config/mc\" " + "xmlns:ns1=\"http://www.sap.com/webas/2007/03/esoa/config/system\" " + "xmlns:ns2=\"http://www.sap.com/webas/2007/03/esoa/config\" > "
               + "<ns0:logical-systems> ";
    }

    private String getLogicalSystem( final String counter ) {

        return "<ns0:logical-system> " + "<ns1:name >LS" + counter + "</ns1:name> " + "<ns1:description >desc LS" + counter + "</ns1:description>" + "<ns1:origin>originLS" + counter + "</ns1:origin>" + "<ns1:value>" + "<ns1:key>classificationLS" + counter + "</ns1:key>"
               + "<ns1:value>valueClassificationLS" + counter + "</ns1:value>" + "</ns1:value>" + "<ns1:context-restriction >" + "<ns1:key>contextRestriction1LS" + counter + "</ns1:key>" + "<ns1:value>contextRestriction1ValueLS" + counter + "</ns1:value>" + "</ns1:context-restriction>"
               + "<ns1:context-restriction >" + "<ns1:key>contextRestriction2LS" + counter + "</ns1:key>" + "<ns1:value>contextRestriction2ValueLS" + counter + "</ns1:value>" + "</ns1:context-restriction>" + "</ns0:logical-system>";
    }

    private String getLogicalSystemsClose( ) {

        return "</ns0:logical-systems> ";
    }

    private String getServiceRefStart( ) {

        return "<ns2:service-references>";
    }

    private String getServiceRef( final String counter ) {

        return "<ns2:reference type=\"WS SRef1\">" + "<ns2:name>SRef" + counter + "</ns2:name>" + "<ns2:namespace>com.sap1</ns2:namespace>" + "<ns2:logical-system-name>LS" + counter + "</ns2:logical-system-name>" + "</ns2:reference>";

    }

    private String getServiceRefClose( ) {

        return "</ns2:service-references>" + "</ns0:mass-configuration>";
    }

    static Schema getSchema( final List<InputStream> inputStreams ) throws SAXException {

        if ( inputStreams == null ) {
            throw new NullPointerException( "inputStreams is null" );
        }
        final Source[] docs = new Source[inputStreams.size( )];
        int counter = 0;
        for ( final InputStream is : inputStreams ) {
            docs[counter] = new StreamSource( is );
            counter++;
        }
        final SchemaFactory schemaFactory = SchemaFactory.newInstance( XMLConstants.W3C_XML_SCHEMA_NS_URI );
        return schemaFactory.newSchema( docs );
    }



}
