package com.sap.tc.moin.repository.test.errorhandler;

import java.io.ByteArrayInputStream;

import org.junit.Test;

import com.sap.tc.moin.repository.spi.ps.SpiType;
import com.sap.tc.moin.repository.spi.ps.errorhandler.SpiDefaultParserErrorHandler;
import com.sap.tc.moin.repository.spi.ps.errorhandler.SpiParserErrorHandler;
import com.sap.tc.moin.repository.spi.ps.parser.SpiElement;
import com.sap.tc.moin.repository.spi.ps.parser.SpiParserCallback;
import com.sap.tc.moin.test.fw.TestMetaModels;

@SuppressWarnings( "nls" )
public class TestTextErrorHandlerGLX extends TestErrorHandlerAbstract {

    private SpiParserErrorHandler errorHandlerTestcasesFoundationBak = null;

    @Override
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        errorHandlerTestcasesFoundationBak = serializationManager.getParserErrorHandler( TestMetaModels.TESTCASES_FOUNDATION_CN, null );
        serializationManager.setParserErrorHandler( TestMetaModels.TESTCASES_FOUNDATION_CN, new TextErrorHandlerTestcasesFoundation( ) );
    }

    @Override
    public void afterTestMethod( ) throws Exception {

        if ( errorHandlerTestcasesFoundationBak == null ) {
            serializationManager.removeParserErrorHandler( TestMetaModels.TESTCASES_FOUNDATION_CN );
        } else {
            serializationManager.setParserErrorHandler( TestMetaModels.TESTCASES_FOUNDATION_CN, errorHandlerTestcasesFoundationBak );
        }
        super.afterTestMethod( );
    }

    @Test
    public void testTextErrorHandler( ) throws Exception {
        // TODO
    }

    private ByteArrayInputStream getContentOfGalaxyPartition( ) throws Exception {

        StringBuilder buf = new StringBuilder( );
        return new ByteArrayInputStream( buf.toString( ).getBytes( ) );
    }

    // this error handler is an adapted copy of the original GLX error handler
    // the adaptions are: replacement of GLX metamodel entities by suitable chosen entities from the testcases foundation metamodel
    private static final class TextErrorHandlerTestcasesFoundation extends SpiDefaultParserErrorHandler {

        @Override
        public SpiType handleUnknownType( SpiParserCallback callback, String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName ) {

            return null;
        }

        @Override
        public boolean handleIllegalAttributeValue( SpiParserCallback callback, SpiElement element, String attributeName, Object attributeValue ) {

            return false;
        }
    }

}