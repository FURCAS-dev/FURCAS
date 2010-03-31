package com.sap.tc.moin.repository.test.cps;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.sap.tc.moin.repository.runtimehost.MetamodelRegistrationParser;
import com.sap.tc.moin.repository.runtimehost.MetamodelRegistrationSerializer;
import com.sap.tc.moin.repository.runtimehost.deployment.ErrorHandlerRegistrationRecord;
import com.sap.tc.moin.repository.runtimehost.deployment.ModelstorageRegistrationRecord;
import com.sap.tc.moin.repository.runtimehost.deployment.TextVerticalizationRegistrationRecord;
import com.sap.tc.moin.repository.runtimehost.deployment.ErrorHandlerRegistrationRecord.ErrorHandlerRecord;
import com.sap.tc.moin.test.testcase.MoinTestCase;


public class TestRegistrationParsers extends MoinTestCase {

    private static final String PF = "PF";

    private static final String TEST_RESOURCE_BUNDLE_NAME = "TestResourceBundleName";

    private static final String TEST_EXTENSION_CLASS = "TestExtensionClass";


    /**
     * Tests the registration parser of custom parsers/serializers.
     * 
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    @Test
    public void testCpsRegistrationParser( ) throws SAXException, IOException, ParserConfigurationException {

        List<String> cpsClasses = Arrays.asList( new String[] { "com.sap.tc.moin.cps.mock.TestCpsFactoryX", "com.sap.tc.moin.cps.mock.TestCpsFactoryY" } );

        InputStream stream = this.getClass( ).getClassLoader( ).getResourceAsStream( "cpstest/modelstorage.xml" );

        ModelstorageRegistrationRecord parser = new ModelstorageRegistrationRecord( );

        parser.parse( stream );

        Collection<String> values = parser.getCustomParsers( ).values( );

        int found = 0;

        for ( String className : values ) {
            if ( cpsClasses.contains( className ) ) {
                found++;
            }
        }

        verify( found == 2, "Found " + found + " error handlers but expected 2" );
    }


    /**
     * Tests the text verticalization registry.
     * 
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    @Test
    public void testTextVerticalizationRegistrationParser( ) throws SAXException, IOException, ParserConfigurationException {

        InputStream stream = this.getClass( ).getClassLoader( ).getResourceAsStream( "cpstest/textverticalization.xml" );

        TextVerticalizationRegistrationRecord parser = new TextVerticalizationRegistrationRecord( );

        parser.parse( stream );

        String tvCallbackHandler = parser.getTvCallbackHandler( );

        verify( ( tvCallbackHandler != null ) && ( tvCallbackHandler.equals( "com.sap.tc.repository.test.cps.MockTvCallbackX" ) ), "Callback X not found." );
    }

    /**
     * Tests the error handler registry.
     * 
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    @Test
    public void testErrorHandlerRegistrationParser( ) throws SAXException, IOException, ParserConfigurationException {

        List<String> errorHandlerClasses = Arrays.asList( new String[] { "com.sap.tc.moin.cps.mock.TestErrorHandlerX", "com.sap.tc.moin.cps.mock.TestErrorHandlerX" } );

        InputStream stream = this.getClass( ).getClassLoader( ).getResourceAsStream( "cpstest/errorhandler.xml" );

        ErrorHandlerRegistrationRecord parser = new ErrorHandlerRegistrationRecord( );

        parser.parse( stream );

        Set<ErrorHandlerRecord> errorHandlers = parser.getErrorHandlers( );

        int found = 0;

        for ( ErrorHandlerRecord errorHandlerRecord : errorHandlers ) {
            if ( errorHandlerClasses.contains( errorHandlerRecord.getClassName( ) ) ) {
                found++;
            }
        }

        verify( found == 2, "Found " + found + " error handlers but expected 2" );
    }

    /**
     * Tests the error handling of the error handler registration parser.
     * 
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    @Test
    public void testErrorHandlerRegistrationParserWrongSyntax( ) throws SAXException, IOException, ParserConfigurationException {

        boolean exceptionThrown = false;
        try {
            InputStream stream = this.getClass( ).getClassLoader( ).getResourceAsStream( "cpstest/errorhandlerWrongSyntax.xml" );

            ErrorHandlerRegistrationRecord parser = new ErrorHandlerRegistrationRecord( );

            parser.parse( stream );
        } catch ( Exception ex ) {
            exceptionThrown = true;
        }

        verify( exceptionThrown, "Parsing must be aborted with faulty registration file." );
    }

    /**
     * Tests the error handling of the error handler registration parser.
     * 
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    @Test
    public void testErrorHandlerRegistrationParserSchemaViolation( ) throws SAXException, IOException, ParserConfigurationException {

        boolean exceptionThrown = false;
        try {
            InputStream stream = this.getClass( ).getClassLoader( ).getResourceAsStream( "cpstest/errorhandlerSchemaViolation.xml" );

            ErrorHandlerRegistrationRecord parser = new ErrorHandlerRegistrationRecord( );

            parser.parse( stream );
        } catch ( Exception ex ) {
            exceptionThrown = true;
        }

        verify( exceptionThrown, "Parsing must be aborted with faulty registration file." );
    }


    /**
     * Tests the text verticalization registry.
     * 
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    @Test
    public void testMetamodelRegistrationParser( ) throws SAXException, IOException, ParserConfigurationException {

        InputStream stream = this.getClass( ).getClassLoader( ).getResourceAsStream( "cpstest/metamodel.xml" );

        MetamodelRegistrationParser reg = new MetamodelRegistrationParser( );

        reg.parse( stream );

        verify( reg.getPartitions( ).containsKey( "moin/meta/toplevel3.moinmm" ), "Partitions not correctly set." );
        verify( PF.equals( reg.getFacilityId( ) ), "Facility not set." );
    }


    /**
     * Tests the registration parser of custom parsers/serializers.
     * 
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    @Test
    public void testMmRegistrationParser( ) throws SAXException, IOException, ParserConfigurationException {

        Map<String, String> partitions = new HashMap<String, String>( );
        partitions.put( "partition1", "10000000000000000000000000000000" );
        partitions.put( "partition2", "11111111111111111111111111111111" );
        MetamodelRegistrationSerializer serializer = new MetamodelRegistrationSerializer( TEST_EXTENSION_CLASS, TEST_RESOURCE_BUNDLE_NAME, PF, partitions );

        ByteArrayOutputStream out = new ByteArrayOutputStream( );

        serializer.serialize( out );

        ByteArrayInputStream in = new ByteArrayInputStream( out.toByteArray( ) );

        MetamodelRegistrationParser parser = new MetamodelRegistrationParser( );

        parser.parse( in );

        verify( TEST_EXTENSION_CLASS.equals( parser.getDeploymentExtensionClass( ) ), "Extension class not set" );

        verify( TEST_RESOURCE_BUNDLE_NAME.equals( parser.getResourceBundleClass( ) ), "Resource bundle class not set" );

        verify( parser.getPartitions( ).keySet( ).containsAll( partitions.keySet( ) ), "Partitions not correctly set" );
    }
}
