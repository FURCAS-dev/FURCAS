package com.sap.tc.moin.repository.test.cps;

import java.io.InputStream;

import org.junit.Test;

import com.sap.tc.moin.repository.runtimehost.deployment.ErrorHandlerRegistrationRecord;
import com.sap.tc.moin.repository.runtimehost.deployment.IpiCustomSerializationClassLoader;
import com.sap.tc.moin.repository.runtimehost.deployment.MoinDeploymentException;
import com.sap.tc.moin.repository.runtimehost.deployment.PartitionSerializationManagerImpl;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;
import com.sap.tc.moin.repository.test.core.CoreMoinTest;
import com.sap.tc.moin.testcases.case017.A17;

/**
 * Tests if the moin extensions are available.
 * 
 * @author D026715
 */
public class TestErrorHandlerArchiveRegistration extends CoreMoinTest {

    private static String REG_SOURCE_PATH = "cpstest";

    /**
     * Test the rollback of error handler deployment.
     * 
     * @throws Exception
     */
    @Test
    public void testErrorHandlerRegistrationFailure( ) throws Exception {

        try {

            InputStream srcStream = this.getClass( ).getClassLoader( ).getResourceAsStream( REG_SOURCE_PATH + "/TestErrorhandlerFailure.xml" );

            // register custom serializer
            PartitionSerializationManagerImpl serializationManager = (PartitionSerializationManagerImpl) getPartitionSerializationManager( );

            // Note: deployment id is also the container name used in the registration xml !!
            String deploymentId = A17.CLASS_DESCRIPTOR.getModelContainerName( ) + "/errorHandlerMock";

            ErrorHandlerRegistrationRecord errorHandlerRegistrationRecord = new ErrorHandlerRegistrationRecord( );

            errorHandlerRegistrationRecord.parse( srcStream );
            IpiCustomSerializationClassLoader loader = new IpiCustomSerializationClassLoader( ) {

                public Class<?> loadClass( String className ) throws ClassNotFoundException {

                    return ParserErrorHandlerMock.class.getClassLoader( ).loadClass( className );
                }
            };

            serializationManager.registerParserErrorHandler( deploymentId, errorHandlerRegistrationRecord );
            try {
                serializationManager.createInstancesOfRegisteredExtension( deploymentId, loader );
            } catch ( MoinDeploymentException ex ) {
                // ok, can happen
            }

            verify( ( serializationManager.getParserErrorHandler( deploymentId, null ) == null ), "Error handler must not be found." );

        } catch ( Exception e ) {

            // Exception in Pre- or Postcondition checks
            e.printStackTrace( );
            throw e;

        }

    }

    /**
     * Test the undeployment of error handlers.
     * 
     * @throws Exception
     */
    @Test
    public void testErrorHandlerRegistrationUnregister( ) throws Exception {

        try {
            String SOURCE_PATH = "cpstest";

            InputStream srcStream = this.getClass( ).getClassLoader( ).getResourceAsStream( SOURCE_PATH + "/TestErrorhandlerUnregister.xml" );

            // register custom serializer
            PartitionSerializationManagerImpl serializationManager = (PartitionSerializationManagerImpl) getPartitionSerializationManager( );

            // Note: deployment id is also the container name used in the registration xml !!
            String deploymentId = A17.CLASS_DESCRIPTOR.getModelContainerName( ) + "/errorHandlerUnregister";

            ErrorHandlerRegistrationRecord errorHandlerRegistrationRecord = new ErrorHandlerRegistrationRecord( );

            errorHandlerRegistrationRecord.parse( srcStream );

            IpiCustomSerializationClassLoader loader = new IpiCustomSerializationClassLoader( ) {

                public Class<?> loadClass( String className ) throws ClassNotFoundException {

                    return ParserErrorHandlerMock.class.getClassLoader( ).loadClass( className );
                }
            };

            serializationManager.registerParserErrorHandler( deploymentId, errorHandlerRegistrationRecord );

            serializationManager.createInstancesOfRegisteredExtension( deploymentId, loader );

            verify( ( serializationManager.getParserErrorHandler( deploymentId, null ) != null ), "Error handler not found." );

            serializationManager.unregister( deploymentId );

            verify( ( serializationManager.getParserErrorHandler( deploymentId, null ) == null ), "Error handler must not be found." );

        } catch ( Exception e ) {

            // Exception in Pre- or Postcondition checks
            e.printStackTrace( );
            throw e;

        }

    }

    protected SpiPartitionSerializationManager getPartitionSerializationManager( ) {

        return ( (SpiFacility) getFacility( ) ).getPartitionSerializationManager( );
    }

}
