package com.sap.tc.moin.js.query.service.client.test;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.List;

import javax.xml.ws.WebServiceException;

import org.junit.Test;

import com.sap.junit.Staged;
import com.sap.tc.moin.js.query.service.client.RemoteMqlProcessor;
import com.sap.tc.moin.js.query.service.client.RemoteMqlProcessorFactory;
import com.sap.tc.moin.test.testcase.MoinTestCase;

/**
 * Black box test cases for the Query Service Client API of MOIN's Team Server.
 * 
 * @see com.sap.tc.moin.js.query.service.client.RemoteMqlProcessor
 * @author D044522
 */
@SuppressWarnings( "nls" )
public class RemoteMqlProcessorFactoryApiTest extends MoinTestCase {

    public static final String TEST_SERVER_URL = "http://vemoin03.dhcp.wdf.sap.corp:50000/QueryService/QueryImplBean?wsdl";

    @Test
    public void createMqlProcessor( ) throws Exception {

        final RemoteMqlProcessorFactory rmpf = new RemoteMqlProcessorFactory( );
        final URL serviceUrl = new URL( "http://non.existing.host/foo?wsdl" );
        try {
            rmpf.createRemoteMqlProcessor( serviceUrl );
            fail( "Web Service runtime did not complain about non existing host" );
        } catch ( InvocationTargetException ite ) {
            //Caused by: javax.xml.ws.WebServiceException: com.sap.engine.services.webservices.espbase.wsdl.exceptions.WSDLException: somehost
            assertTrue( "Unexpected exception thrown", ite.getCause( ) instanceof WebServiceException );
        }
    }

    @Test
    @Staged
    public void getFacilities( ) throws Exception {

        final RemoteMqlProcessorFactory rmpf = new RemoteMqlProcessorFactory( );
        final URL serviceUrl = new URL( TEST_SERVER_URL );
        final RemoteMqlProcessor rmp = rmpf.createRemoteMqlProcessor( serviceUrl );
        final List<String> fcts = rmp.getFacilities( );
        assertNotNull( fcts );
        assertFalse( fcts.isEmpty( ) );
    }
}
