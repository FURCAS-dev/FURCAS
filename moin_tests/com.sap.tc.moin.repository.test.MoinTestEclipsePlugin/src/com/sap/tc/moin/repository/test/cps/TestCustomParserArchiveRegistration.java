package com.sap.tc.moin.repository.test.cps;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;
import java.util.Map.Entry;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.InvalidResourceIdentifierException;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.ReferencedTransientElementsException;
import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;
import com.sap.tc.moin.repository.runtimehost.deployment.IpiCustomSerializationClassLoader;
import com.sap.tc.moin.repository.runtimehost.deployment.ModelContentSelectionRecord;
import com.sap.tc.moin.repository.runtimehost.deployment.ModelstorageRegistrationRecord;
import com.sap.tc.moin.repository.runtimehost.deployment.MoinDeploymentException;
import com.sap.tc.moin.repository.runtimehost.deployment.PartitionSerializationManagerImpl;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;
import com.sap.tc.moin.repository.spi.ps.SpiCustomParserSerializerFactory;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;
import com.sap.tc.moin.repository.test.core.CoreMoinTest;
import com.sap.tc.moin.testcases.TestcasesPackage;
import com.sap.tc.moin.testcases.case001.B1;
import com.sap.tc.moin.testcases.case004.A4;
import com.sap.tc.moin.testcases.case008.A8;
import com.sap.tc.moin.testcases.case008.Case008Package;
import com.sap.tc.moin.testcases.case008.T8;
import com.sap.tc.moin.testcases.case017.A17;
import com.sap.tc.moin.testcases.case025.B25;
import com.sap.tc.moin.testcases.case025.C25;
import com.sap.tc.moin.testcases.case025.D25;

/**
 * Tests if the moin extensions are available.
 * 
 * @author D026715
 */
public class TestCustomParserArchiveRegistration extends CoreMoinTest {

    private static final String SERIALIZATION_FACTORY_MOCK = "com.sap.tc.moin.repository.cps.test.Mock";

    private static String REG_SOURCE_PATH = "cpstest";

    protected SpiPartitionSerializationManager getPartitionSerializationManager( ) {

        return ( (SpiFacility) getFacility( ) ).getPartitionSerializationManager( );
    }

    /**
     * Test the robustness in case of registration problems. Registration must
     * fail since the serialization id is already registered.
     * 
     * @throws Exception
     */
    @Test
    public void TestSerializationRegistrationExisting( ) throws Exception {

        Connection connection = null;

        try {

            connection = getMOINConnection( );

            // -- create and fill partition and save --> partition available in MOIN workspaces, on FS, in index
            String partitionName_01 = "CustomPartition3";

            // just for getting a valid pri ...
            ModelPartition partition_01 = this._testClient1.getOrCreatePartitionStable( "src/moin/meta/" + partitionName_01 );
            PRI mmPri_01 = partition_01.getPri( );
            partition_01.delete( );
            connection.save( );

            String SOURCE_PATH = "cpstest";

            InputStream srcStream = this.getClass( ).getClassLoader( ).getResourceAsStream( SOURCE_PATH + "/TestModelstorageExisting.xml" );

            // register custom serializer
            PartitionSerializationManagerImpl serializationManager = (PartitionSerializationManagerImpl) getPartitionSerializationManager( );

            String deploymentId = A17.CLASS_DESCRIPTOR.getModelContainerName( ) + "/ToFail";

            ModelstorageRegistrationRecord cpsRegistrationRecord = new ModelstorageRegistrationRecord( );

            cpsRegistrationRecord.parse( srcStream );

            boolean success = serializationManager.registerModelstorage( deploymentId, cpsRegistrationRecord );

            verify( !success, "Custom parser/serializer deployed regardless of problems." );

            // load custom partition
            String priString = mmPri_01.toString( );

            String newPriString = priString.replace( ".mointest", ".cpsexisting" );

            boolean failed = false;
            try {
                PRI newPri = getFacility( ).getRIFactory( ).createPri( newPriString );
                ModelPartition partition = connection.createPartition( newPri );
                connection.save( );
                partition.delete( );
                connection.save( );
            } catch ( InvalidResourceIdentifierException ex ) {
                failed = true;
            } catch ( PartitionsNotSavedException ex ) {
                failed = true;
            }

            verify( failed, "Custom parser/serializer deployed although serialization id was already registered." );

            String anotherPriString = priString.replace( ".mointest", ".cpsexistingdefault" );

            failed = false;
            try {
                PRI newPri = getFacility( ).getRIFactory( ).createPri( anotherPriString );
                ModelPartition partition = connection.createPartition( newPri );
                connection.save( );
                partition.delete( );
                connection.save( );
            } catch ( InvalidResourceIdentifierException ex ) {
                failed = true;
            } catch ( PartitionsNotSavedException ex ) {
                failed = true;
            }

            verify( failed, "Custom parser/serializer deployed although other parts of the registration failed." );

        } catch ( Exception e ) {

            // Exception in Pre- or Postcondition checks
            e.printStackTrace( );
            throw e;

        }

    }

    /**
     * Test the robustness in case of registration problems.
     * 
     * @throws Exception
     */
    @Test
    public void TestSerializationRegistrationFailure( ) throws Exception {

        Connection connection = null;

        try {

            connection = getMOINConnection( );

            // -- create and fill partition and save --> partition available in MOIN workspaces, on FS, in index
            String partitionName_01 = "CustomPartition3";
            ModelPartition partition_01 = this._testClient1.getOrCreatePartitionStable( "src/moin/meta/" + partitionName_01 );
            PRI mmPri_01 = partition_01.getPri( );
            partition_01.delete( );
            connection.save( );

            String SOURCE_PATH = "cpstest";

            InputStream srcStream = this.getClass( ).getClassLoader( ).getResourceAsStream( SOURCE_PATH + "/TestModelstorageFailure.xml" );

            // register custom serializer
            // IdePrimaryFacilityImpl idePrimaryFacility = (IdePrimaryFacilityImpl) getIdePrimaryFacility( );

            PartitionSerializationManagerImpl serializationManager = (PartitionSerializationManagerImpl) getPartitionSerializationManager( );

            String deploymentId = A17.CLASS_DESCRIPTOR.getModelContainerName( ) + "/ToFail";

            ModelstorageRegistrationRecord cpsRegistrationRecord = new ModelstorageRegistrationRecord( );

            cpsRegistrationRecord.parse( srcStream );

            String serializationId = cpsRegistrationRecord.getCustomParsers( ).keySet( ).iterator( ).next( );

            IpiCustomSerializationClassLoader loader = new IpiCustomSerializationClassLoader( ) {

                public Class<?> loadClass( String className ) throws ClassNotFoundException {

                    return this.getClass( ).getClassLoader( ).loadClass( className );
                }
            };

            boolean success = serializationManager.registerModelstorage( deploymentId, cpsRegistrationRecord );

            try {
                // tries to instantiate the factory and should unregister it if this fails
                serializationManager.createInstancesOfRegisteredExtension( deploymentId, loader );
                serializationManager.getCustomParserSerializerFactory( serializationId );
            } catch ( MoinDeploymentException ex ) {
                success = false;
            }

            verify( !success, "Custom parser/serializer deployed regardless of problems." );

            // load custom partition
            String priString = mmPri_01.toString( );

            String newPriString = priString.replace( ".mointest", ".testbla" );

            boolean failed = false;
            try {
                PRI newPri = getFacility( ).getRIFactory( ).createPri( newPriString );
                ModelPartition partition = connection.createPartition( newPri );
                connection.save( );
                partition.delete( );
                connection.save( );
            } catch ( InvalidResourceIdentifierException ex ) {
                failed = true;
            } catch ( PartitionsNotSavedException ex ) {
                failed = true;
            }

            verify( failed, "Custom parser/serializer deployed although serialization factory class does not exist." );

            String anotherPriString = priString.replace( ".mointest", ".testblablub" );

            failed = false;
            try {
                PRI newPri = getFacility( ).getRIFactory( ).createPri( anotherPriString );
                ModelPartition partition = connection.createPartition( newPri );
                connection.save( );
                partition.delete( );
                connection.save( );
            } catch ( InvalidResourceIdentifierException ex ) {
                failed = true;
            } catch ( PartitionsNotSavedException ex ) {
                failed = true;
            }

            verify( failed, "Custom parser/serializer deployed although other parts of the registrationf failed." );

            SpiCustomParserSerializerFactory foundFactory = null;
            try {
                foundFactory = serializationManager.getCustomParserSerializerFactory( SERIALIZATION_FACTORY_MOCK );
            } catch ( Exception ex ) {

            }

            verify( foundFactory == null, "Registration not rolled back correctly." );

        } catch ( Exception e ) {

            // Exception in Pre- or Postcondition checks
            e.printStackTrace( );
            throw e;

        }

    }

    /**
     * Tests the undeployment of a custom parser/serializer.
     * 
     * @throws Exception
     */
    @Test
    public void TestUnregisterCustomSerialization( ) throws Exception {

        Connection connection = null;

        try {
            connection = getMOINConnection( );

            // -- create and fill partition and save --> partition available in MOIN workspaces, on FS, in index
            String partitionName_01 = "CustomPartition2";
            ModelPartition partition_01 = this._testClient1.getOrCreatePartitionStable( "src/moin/meta/" + partitionName_01 );
            PRI mmPri_01 = partition_01.getPri( );
            partition_01.delete( );
            connection.save( );

            String SOURCE_PATH = "cpstest";

            InputStream srcStream = this.getClass( ).getClassLoader( ).getResourceAsStream( SOURCE_PATH + "/TestModelstorageUnregister.xml" );

            // register custom serializer
            PartitionSerializationManagerImpl serializationManager = (PartitionSerializationManagerImpl) getPartitionSerializationManager( );

            String deploymentId = A17.CLASS_DESCRIPTOR.getModelContainerName( ) + "/ToBeUnregistered";

            ModelstorageRegistrationRecord cpsRegistrationRecord = new ModelstorageRegistrationRecord( );

            cpsRegistrationRecord.parse( srcStream );

            serializationManager.registerModelstorage( deploymentId, cpsRegistrationRecord );

            // load custom partition
            String priString = mmPri_01.toString( );

            String newPriString = priString.replace( ".mointest", ".unregtest" );

            boolean failed = false;
            try {
                PRI newPri = getFacility( ).getRIFactory( ).createPri( newPriString );
                ModelPartition partition = connection.createPartition( newPri );
                connection.save( );
                partition.delete( );
                connection.save( );

            } catch ( InvalidResourceIdentifierException ex ) {
                failed = true;
            } catch ( PartitionsNotSavedException ex ) {
                failed = true;
            }

            verify( !failed, "Custom parser/serializer not correctly deployed." );

            serializationManager.unregister( deploymentId );

            failed = false;
            try {
                PRI newPri = getFacility( ).getRIFactory( ).createPri( newPriString );
                ModelPartition partition = connection.createPartition( newPri );
                connection.save( );
                partition.delete( );
                connection.save( );

            } catch ( InvalidResourceIdentifierException ex ) {
                failed = true;
            } catch ( PartitionsNotSavedException ex ) {
                failed = true;
            }

            verify( failed, "Custom parser/serializer not correctly undeployed." );

        } catch ( Exception e ) {

            // Exception in Pre- or Postcondition checks
            e.printStackTrace( );
            throw e;

        }

    }

    /**
     * Tests the registration of the content selection criteria.
     * 
     * @throws Exception
     */
    @Test
    public void TestContentSelectionRegistrationSimple( ) throws Exception {

        String propertyString = "dcTypeName=com.sap.tc.silver.bullet.nwdi.dctype.sb\ndcTypeVendor=sap.com\nfolder=moin/models";
        byte[] bytes = propertyString.getBytes( );
        ByteArrayInputStream inStream = new ByteArrayInputStream( bytes );

        Properties reference = new Properties( );
        reference.load( inStream );

        InputStream srcStream = this.getClass( ).getClassLoader( ).getResourceAsStream( REG_SOURCE_PATH + "/TestContentSelectionCriteria.xml" );

        try {

            String deploymentId = A17.CLASS_DESCRIPTOR.getModelContainerName( ) + "/CustomContentSelectionMock";

            ModelContentSelectionRecord customContentSelectionRegistrationRecord = new ModelContentSelectionRecord( );

            customContentSelectionRegistrationRecord.parse( srcStream );

            PartitionSerializationManagerImpl serializationManager = (PartitionSerializationManagerImpl) getPartitionSerializationManager( );

            serializationManager.registerCustomContentSelection( deploymentId, customContentSelectionRegistrationRecord );

            // get registrations
            Collection<Properties> customRegistrationCollection = serializationManager.getCustomContentSelections( "DI" );

            boolean regOk = false;
            for ( Properties customRegistrations : customRegistrationCollection ) {

                boolean found = false;
                for ( Object key : reference.keySet( ) ) {
                    if ( customRegistrations.containsKey( key ) ) {
                        if ( customRegistrations.get( key ).equals( reference.get( key ) ) ) {
                            found = true;
                        } else {
                            found = false;
                            break;
                        }
                    } else {
                        found = false;
                        break;
                    }
                }

                if ( found ) {
                    regOk = true;
                    break;
                }
            }

            verify( regOk, "Custom content selection criteria not correctly registered." );

            Collection<Properties> customContentSelections = serializationManager.getCustomContentSelections( "DI" );

            int size = customContentSelections.size( );

            serializationManager.unregister( deploymentId );

            int sizeAfterUnregister = 0;

            customContentSelections = serializationManager.getCustomContentSelections( "DI" );

            if ( customContentSelections != null ) {
                sizeAfterUnregister = customContentSelections.size( );
            }

            verify( sizeAfterUnregister < size, "Content selection criteria not correctly undeployed." );

        } catch ( Exception e ) {

            // Exception in Pre- or Postcondition checks
            e.printStackTrace( );
            throw e;

        }

    }

    private void createContentForPartition( Connection connection, ModelPartition partition_01 ) {

        // create some content
        C25 a = this.createC25( connection );
        C25 b = this.createC25( connection );
        a.getToEnd( ).add( b );

        B25 c = this.createB25( connection );
        c.setOnePrimitive( "Value" );

        D25 d = this.createD25( connection );

        T8 structureValue = this.createT8( 12, "Value", connection );

        d.setOneStructureT( structureValue );

        a.setExternalId( "1" );
        partition_01.assignElement( a );
        b.setExternalId( "2" );
        partition_01.assignElement( b );
        c.setExternalId( "34" );
        partition_01.assignElement( c );
        d.setExternalId( "44" );
        partition_01.assignElement( d );
    }

    private B1 createB1( Connection conn ) {

        return conn.createElementInPartition( B1.class, null );
    }

    private A17 createA17( Connection conn ) {

        return conn.createElementInPartition( A17.class, null );
    }

    private C25 createC25( Connection conn ) {

        return conn.createElementInPartition( C25.class, null );
    }

    private B25 createB25( Connection conn ) {

        return conn.createElementInPartition( B25.class, null );
    }

    private D25 createD25( Connection conn ) {

        return conn.createElementInPartition( D25.class, null );
    }

    private T8 createT8( int field1, String field2, Connection conn ) {

        StructureFieldContainer<T8> contT8 = new StructureFieldContainer<T8>( );
        TestcasesPackage testcasesPackage = (TestcasesPackage) conn.getPackage( null, new String[] { "testcases" } );

        Case008Package case008Package = testcasesPackage.getCase008( );
        contT8.put( T8.DESCRIPTORS.FIELD1( ), field1 ).put( T8.DESCRIPTORS.FIELD2( ), field2 );
        T8 a = case008Package.createT8( contT8 );

        return a;
    }

    private A4 createA4( Connection conn ) {

        return conn.createElementInPartition( A4.class, null );
    }

    private A8 createA8( Connection conn ) {

        return conn.createElementInPartition( A8.class, null );
    }

    /**
     * Test the robustness in case of registration problems. Registration must
     * fail since the serialization id is already registered.
     * 
     * @throws Exception
     */
    @Test
    public void testSerializationRegistrationNommArchive( ) throws Exception {

        Connection connection = null;

        try {

            connection = getMOINConnection( );

            // -- create and fill partition and save --> partition available in MOIN workspaces, on FS, in index
            String partitionName_01 = "CustomPartitionNomm";

            // just for getting a valid pri ...
            ModelPartition partition_01 = this._testClient1.getOrCreatePartitionStable( "src/moin/meta/" + partitionName_01 );
            PRI mmPri_01 = partition_01.getPri( );
            partition_01.delete( );
            connection.save( );

            // check creation of PRI
            String priString = mmPri_01.toString( );

            String newPriString = priString.replace( ".mointest", ".cpstest11" );

            boolean failed = false;
            try {
                PRI newPri = getFacility( ).getRIFactory( ).createPri( newPriString );
                ModelPartition partition = connection.createPartition( newPri );
                connection.save( );
                partition.delete( );
                connection.save( );
            } catch ( InvalidResourceIdentifierException ex ) {
                failed = true;
            } catch ( PartitionsNotSavedException ex ) {
                failed = true;
            }

            verify( !failed, "Nomm metamodel not registered - PRI suffix not accepted" );


        } catch ( Exception e ) {

            // Exception in Pre- or Postcondition checks
            e.printStackTrace( );
            throw e;

        }

    }

    /**
     * Tests the registration parser of custom parsers/serializers.
     * 
     * @throws PartitionsNotSavedException
     * @throws ReferencedTransientElementsException
     * @throws NullPartitionNotEmptyException
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    @Test
    public void testCpsRegistration( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        Connection connection = getMOINConnection( );

        ModelPartition partitionTemplate = this._testClient1.getOrCreatePartitionStable( "CustomPartitionA" );
        PRI priTemplate = partitionTemplate.getPri( );

        String priString = priTemplate.toString( );
        priString = priString.replace( ".mointest", ".cpstest" );

        PRI customPri = getFacility( ).getRIFactory( ).createPri( priString );

        ModelPartition customPartition = connection.createPartition( customPri );

        createContentForPartition( connection, customPartition );

        connection.save( );

        Connection connection2 = this.getSecondMOINConnection( );

        ModelPartition partition = connection2.getPartition( customPri );

        verify( ( partition != null ) && !partition.getElements( ).isEmpty( ), "Partition was not correctly loaded." );

        boolean attributesOk = false;
        boolean contentOk = false;
        Collection<Partitionable> elements = partition.getElements( );

        for ( Partitionable partitionable : elements ) {
            if ( partitionable instanceof A8 ) {
                A8 a8Instance = (A8) partitionable;
                T8 oneStructureT = a8Instance.getOneStructureT( );
                attributesOk = oneStructureT.getField1( ) > 0;
                attributesOk &= ( oneStructureT.getField2( ) != null );
            } else if ( partitionable instanceof C25 ) {
                C25 c25Instance = (C25) partitionable;
                if ( c25Instance.getExternalId( ).equals( "1" ) ) {
                    if ( c25Instance.getToEnd( ) != null ) {
                        contentOk = true;
                    }
                }
            }
        }

        verify( attributesOk, "Attributes not correctly set" );
        verify( contentOk, "C25 content not correctly set" );

        customPartition.delete( );
        partitionTemplate.delete( );
        connection.save( );

    }

    /**
     * Tests the registration of the content selection criteria.
     * 
     * @throws Exception
     */
    @Test
    public void TestContentSelectionRegistrationFailure( ) throws Exception {

        InputStream srcStream = this.getClass( ).getClassLoader( ).getResourceAsStream( REG_SOURCE_PATH + "/TestModelcontentselectionFailure.xml" );

        try {

            String deploymentId = A17.CLASS_DESCRIPTOR.getModelContainerName( ) + "/CustomContentSelectionFailureMock";

            ModelContentSelectionRecord customContentSelectionRegistrationRecord = new ModelContentSelectionRecord( );

            customContentSelectionRegistrationRecord.parse( srcStream );

            PartitionSerializationManagerImpl serializationManager = (PartitionSerializationManagerImpl) getPartitionSerializationManager( );

            serializationManager.registerCustomContentSelection( deploymentId, customContentSelectionRegistrationRecord );

            boolean checkFailed = false;
            try {
                serializationManager.checkContentSelectionCriteria( getTestHelper( ).getCoreMoin( ), deploymentId );
            } catch ( MoinDeploymentException de ) {
                checkFailed = true;
                serializationManager.unregister( deploymentId );
            }

            verify( checkFailed, "Custom content selection criteria check succeeded but should fail." );

            // get registrations
            Collection<Properties> customRegistrationCollection = serializationManager.getCustomContentSelections( "DI" );

            boolean found = false;
            for ( Properties customRegistrations : customRegistrationCollection ) {

                for ( Entry<Object, Object> propertyEntry : customRegistrations.entrySet( ) ) {
                    if ( propertyEntry.getValue( ).equals( "x/src/models" ) ) {
                        found = true;
                    }
                }
            }

            verify( !found, "Custom content selection criteria not correctly unregistered." );

            serializationManager.unregister( deploymentId );

        } catch ( Exception e ) {

            // Exception in Pre- or Postcondition checks
            e.printStackTrace( );
            throw e;

        }

    }
}
