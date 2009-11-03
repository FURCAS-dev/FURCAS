/**
 * 
 */
package com.sap.tc.moin.test.fw.build;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.ModelElement;

import com.sap.tc.moin.facility.primary.build.BuildPrimaryFacilityImpl;
import com.sap.tc.moin.facility.primary.ipi.IpiDataArea;
import com.sap.tc.moin.facility.primary.ipi.IpiPrimaryFacility;
import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiConfigurationAdaptorFactoryImpl;
import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiConfigurationProvider;
import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiDcDefinitionProvider;
import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiConfigurationProvider.Scenario;
import com.sap.tc.moin.facility.primary.ipi.diservice.build.IpiBuildDiService;
import com.sap.tc.moin.facility.primary.persistence.lfs.javaioimpl.FsFolder;
import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.DataArea;
import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.ResourceIdentifierFactory;
import com.sap.tc.moin.repository.cdam.CompoundClientSpec;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.util.MetaModelExtensionRecord;
import com.sap.tc.moin.repository.core.jmi.util.MetaModelExtensionRecordReaderWriter;
import com.sap.tc.moin.repository.filesystem.FileSystemRuntimeHost;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerator;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorModelElementWrapper;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorMofType;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorPathCodePair;
import com.sap.tc.moin.repository.jmigenerator.controller.MoinMMGeneration.JmiGenerationMode;
import com.sap.tc.moin.repository.runtimehost.build.MoinFactory;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.spi.cdam.SpiCompoundDataAreaManager;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.test.fw.AbstractMoinTestHelper;
import com.sap.tc.moin.test.fw.MoinTestHelper;
import com.sap.tc.moin.test.fw.TestClientFactory;

@SuppressWarnings( "nls" )
public class MoinBuildTestHelper extends AbstractMoinTestHelper {

    @Override
    public TestClientFactory getTestClientFactory( String facilityName ) {

        // this method should not be called in this test scenario
        throw new UnsupportedOperationException( );
    }

    public final static String DEFAULT_DATA_AREA_NAME = "DefaultDataArea";

    public static final VendorNamePair DEFAULT_DC = new VendorNamePair( "test.sap.com", "moin/mm/dc1234" );

    public final static String DEFAULT_SOURCE = System.getProperty( "java.io.tmpdir" ) + DEFAULT_DC + "/_comp/";

    // partition root path
    public static final String PARTITION_ROOT_PATH = "moin/meta";

    // the singleton instance
    private static MoinBuildTestHelper _instance;

    private JmiGenerationMode generationMode = JmiGenerationMode.ALL;

    private enum State {
        INITIAL, MOIN_INITIALIZED, STARTED, STOPPED
    };

    /**
     * Vendor and name of a Development or Software component. TODO: overwrite
     * equals, hashcode; move to NWDI Facility API
     */
    public static class VendorNamePair {

        private String _vendor;

        private String _name;

        public VendorNamePair( String vendor, String name ) {

            _vendor = vendor;
            _name = name;
        }

        /**
         * @return Returns the name.
         */
        public String getName( ) {

            return _name;
        }

        /**
         * @return Returns the vendor.
         */
        public String getVendor( ) {

            return _vendor;
        }

        /*
         * (non-Javadoc)
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString( ) {

            StringBuffer sb = new StringBuffer( _vendor.length( ) + _name.length( ) + 1 );
            sb.append( _vendor ).append( '/' ).append( _name );
            return sb.toString( );
        }

    }

    private State state = State.INITIAL;

    private Moin moin;

    private CompoundClientSpec compoundClientSpec;

    private Facility _facility;

    private DataArea _dataArea;

    private FileSystemRuntimeHost host = null;

    private Connection connection;

    private Map<String, File> directories = new HashMap<String, File>( );

    public static synchronized MoinBuildTestHelper getInstance( ) {

        if ( _instance == null ) {
            _instance = new MoinBuildTestHelper( );
            _instance.host = MoinFactory.createRTH( );
            if ( _instance.state != State.INITIAL ) {
                throw new RuntimeException( "MOIN already initialized." );
            }

            // TODO: remove configurationFile
            _instance.moin = MoinFactory.getMoinInstance( _instance.host, null );

            _instance.state = State.MOIN_INITIALIZED;

            Facility facility = _instance.moin.getFacilityById( "PF" );

            IpiBuildDiService nwdiService = ( (BuildPrimaryFacilityImpl) facility ).getBuildDiService( );

            IpiDiConfigurationAdaptorFactoryImpl diAdaptorFactory = new IpiDiConfigurationAdaptorFactoryImpl( );

            ensureDefaultSourceAvailable( );
            IpiDiDcDefinitionProvider dcDefinitionProvider = diAdaptorFactory.getMetaModelDiDcDefinitionAdaptor( DEFAULT_DC.getVendor( ), DEFAULT_DC.getName( ), DEFAULT_SOURCE );

            List<IpiDiDcDefinitionProvider> definitionProviders = new LinkedList<IpiDiDcDefinitionProvider>( );

            definitionProviders.add( dcDefinitionProvider );

            IpiDiConfigurationProvider diConfigurationProvider = diAdaptorFactory.getMetaModelDiConfigurationAdaptor( Scenario.BUILD_SCENARIO, DEFAULT_DATA_AREA_NAME, definitionProviders );

            ClientSpec clientSpec = nwdiService.getClientSpec( diConfigurationProvider );

            try {
                CompoundClientSpec compoundClientSpec = ( (SpiCompoundDataAreaManager) _instance.getMoinScenarioSpecific( ).getCompoundDataAreaManager( ) ).getDefaultCompoundClientSpec( clientSpec );

                _instance.setCompoundClientSpec( compoundClientSpec );
            } catch ( Exception ex ) {
                throw new RuntimeException( "Could not create Client Spec: ", ex );
            }
        }
        return _instance;
    }

    private static void ensureDefaultSourceAvailable( ) {

        FsFolder.createDirsOfPath( DEFAULT_SOURCE );
    }

    @Override
    protected Moin getMoinScenarioSpecific( ) {

//        if ( state != State.MOIN_INITIALIZED && state != State.STARTED ) {
//            throw new RuntimeException( "MOIN not initialized." );
//        }
//
//        return moin;
        if ( _instance == null ) {
            getInstance( );
        }
        return _instance.host.getMoinInstance( );
    }

    public Connection getConnection( ) {

        if ( state != State.STARTED ) {
            throw new RuntimeException( "MOIN not started." );
        }

        if ( connection == null ) {
            this.connection = getMoin( ).createSession( getCompoundClientSpec( ) ).createConnection( );
        }

        return connection;
    }

    public void setCompoundClientSpec( CompoundClientSpec compoundClientSpec ) {

        this.compoundClientSpec = compoundClientSpec;

        this.state = State.STARTED;
    }

    public CompoundClientSpec getCompoundClientSpec( ) {

        if ( state != State.STARTED ) {
            throw new RuntimeException( "MOIN not started yet." );
        }

        return compoundClientSpec;
    }

    @Override
    protected void stopMoinScenarioSpecific( ) {

        if ( this.state != State.STOPPED ) {
            if ( connection != null ) {
                connection.close( );
            }

            this.connection = null;
            this.moin = null;
            this.compoundClientSpec = null;

            this.state = State.STOPPED;
        }
        if ( _instance != null ) {
            _instance.host.shutDown( );
            _instance.host = null;
            _instance._facility = null;
            _instance._dataArea = null;
            _instance = null;
        }
    }

    public boolean isMoinRunning( ) {

        if ( _instance == null || _instance.host == null ) {
            return false;
        }
        return _instance.host.isRunning( );
    }

    public synchronized ModelPartition getOrCreatePartitionStable( String testName, String containerName ) {

        // look for the first DC in the configuration; if there is none, we use a default
        // the partition path is set up by the test case name and the current counter + 1
        String partitionPath = PARTITION_ROOT_PATH + "/" + testName;

        if ( testName == null ) {
            throw new IllegalStateException( "Cannot create or get partition name \"null\" for " + this );
        }

        // Take care for partition suffix in PRI:
        partitionPath += MoinTestHelper.TEST_PARTITION_SUFFIX;

        ResourceIdentifierFactory riFactory = getNwdiFacility( ).getRIFactory( );
        IpiDataArea dataArea = getIpiDataArea( );
        PRI pri = riFactory.createPri( dataArea.getName( ), containerName, partitionPath );
        try {
            ModelPartition mp = getConnection( ).getPartition( pri );
            if ( mp == null ) {
                mp = getConnection( ).createPartition( pri );
            }
            return mp;
        } catch ( Exception e ) {
            // don't deal with checked exceptions in test cases
            throw new IllegalStateException( "Failed to create new model partition for MRI " + pri + " and test client " + this, e );
        }
    }

    public IpiPrimaryFacility getNwdiFacility( ) {

        Facility facility = null;
        try {
            facility = getInstance( ).getMoin( ).getFacilityById( IpiPrimaryFacility.FACILITY_ID );
            return (IpiPrimaryFacility) facility;
        } catch ( ClassCastException e ) {
            throw new IllegalStateException( "Facility of test client " + this + " must be instance of " + IpiPrimaryFacility.class.getName( ) + ", but is instance of " + facility.getClass( ).getName( ) );
        }
    }

    public IpiDataArea getIpiDataArea( ) {

        try {
            return (IpiDataArea) getDataArea( );
        } catch ( ClassCastException e ) {
            throw new IllegalStateException( "Data area of test client " + this + " must be instance of " + IpiDataArea.class.getName( ) + ", but is instance of " + getDataArea( ).getClass( ).getName( ) );
        }
    }

    protected synchronized DataArea getDataArea( ) {

        if ( _facility == null ) {
            _facility = getNwdiFacility( );
        }
        if ( _dataArea == null ) {
            _dataArea = _facility.getDataAreaByName( DEFAULT_DATA_AREA_NAME );
            if ( _dataArea == null ) {
                throw new IllegalStateException( "Bad test configuration: Data Area " + DEFAULT_DATA_AREA_NAME + " not found in facility " + _facility.getId( ) );
            }
        }

        return _dataArea;
    }

    public void build( ModelPartition partition ) {

        JmiGenerator gen = new JmiGenerator( ( (Wrapper<CoreConnection>) connection ).unwrap( ) );
        String targetPath = DEFAULT_SOURCE + "src";
        Set<ModelPartition> partitions = new HashSet<ModelPartition>( );
        partitions.add( partition );
        List<JmiGeneratorModelElementWrapper> wrappers = gen.createObjectList( String.valueOf( DEFAULT_DC ), partitions );
        JmiGenerationKind[] kindFilter;
        switch ( this.generationMode ) {
            case API:
                kindFilter = new JmiGenerationKind[] { JmiGenerationKind.INTERFACE };
                break;
            case IMPL:
                kindFilter = new JmiGenerationKind[] { JmiGenerationKind.CLASS, JmiGenerationKind.WRAPPER };
                break;
            case ALL:
                kindFilter = new JmiGenerationKind[] { JmiGenerationKind.INTERFACE, JmiGenerationKind.CLASS, JmiGenerationKind.WRAPPER };
                break;
            default:
                kindFilter = null;
                break;
        }
        if ( kindFilter != null ) {
            for ( JmiGeneratorModelElementWrapper modelElementWrapper : wrappers ) {
                List<JmiGeneratorPathCodePair> code = modelElementWrapper.createCode( kindFilter );
                for ( JmiGeneratorPathCodePair pair : code ) {
                    try {
                        this.writeFile( pair, targetPath );
                    } catch ( IOException e ) {
                        throw new RuntimeException( e );
                    }
                }
            }

            List<JmiGeneratorPathCodePair> extensions = gen.getDeploymentExtensions( String.valueOf( DEFAULT_DC ), partitions, wrappers, kindFilter );
            for ( JmiGeneratorPathCodePair pair : extensions ) {
                try {
                    this.writeFile( pair, targetPath );
                } catch ( IOException e ) {
                    throw new RuntimeException( e );
                }
            }

            generateDeploymentExtensionIndex( partitions, targetPath, wrappers );
        }
    }

    private void writeFile( JmiGeneratorPathCodePair pair, String targetPath ) throws IOException {

        String code = pair.getCode( );
        StringBuilder fullpath = new StringBuilder( targetPath );
        for ( String comp : pair.getRelativePath( ) ) {
            fullpath.append( File.separator );
            fullpath.append( comp );
        }

        File directory = this.directories.get( fullpath.toString( ) );
        if ( directory == null || !directory.exists( ) ) {
            directory = new File( targetPath );
            for ( String dir : pair.getRelativePath( ) ) {
                String[] subdirs = directory.list( );
                if ( subdirs == null ) {
                    File childDirectory = new File( directory.getCanonicalPath( ) + File.separator + dir );
                    childDirectory.mkdirs( );
                    directory = childDirectory;
                    continue;
                }
                boolean found = false;
                for ( int i = 0; i < subdirs.length; i++ ) {
                    if ( subdirs[i].equals( dir ) ) {
                        directory = new File( directory.getCanonicalPath( ) + File.separator + dir );
                        found = true;
                        continue;
                    }
                }
                if ( !found ) {
                    File childDirectory = new File( directory.getCanonicalPath( ) + File.separator + dir );
                    childDirectory.mkdirs( );
                    directory = childDirectory;
                    continue;
                }

            }

            this.directories.put( fullpath.toString( ), directory );

        }

        String filepath = directory.getPath( ) + File.separator + pair.getFileName( ) + '.' + pair.getFileExtension( );
        File prog = new File( filepath );
        prog.createNewFile( );

        FileWriter w = null;
        BufferedWriter bw = null;
        try {
            w = new FileWriter( prog );
            bw = new BufferedWriter( w );
            bw.write( code );
        } finally {
            if ( bw != null ) {
                bw.close( );
            }

            if ( w != null ) {
                w.close( );
            }
        }
    }

    private void generateDeploymentExtensionIndex( Set<ModelPartition> partitions, String targetPath, List<JmiGeneratorModelElementWrapper> wrappers ) {

        String indexesPrefix = targetPath + "/" + Utilities.getMMPackageQualified( String.valueOf( DEFAULT_DC ) ).replace( '.', '/' ) + "/";

        File deploymentExtensionIndexFile = new File( indexesPrefix + MetaModelExtensionRecordReaderWriter.EXTENSION_INDEX_NAME );
        FileOutputStream deploymentExtensionRecordFileStream = null;

        File deploymentExtensionIndexLogFile = new File( indexesPrefix + MetaModelExtensionRecordReaderWriter.EXTENSION_INDEX_LOG_NAME );
        FileOutputStream deploymentExtensionIndexLogFileStream = null;

        File modelElementNamesFile = new File( indexesPrefix + MetaModelExtensionRecordReaderWriter.NAMES_INDEX_NAME );
        FileOutputStream modelElementNamesFileStream = null;

        try {
            if ( !deploymentExtensionIndexFile.exists( ) ) {
                deploymentExtensionIndexFile.createNewFile( );
            }

            deploymentExtensionRecordFileStream = new FileOutputStream( deploymentExtensionIndexFile );

            if ( !deploymentExtensionIndexLogFile.exists( ) ) {
                deploymentExtensionIndexLogFile.createNewFile( );
            }

            deploymentExtensionIndexLogFileStream = new FileOutputStream( deploymentExtensionIndexLogFile );

            if ( !modelElementNamesFile.exists( ) ) {
                modelElementNamesFile.createNewFile( );
            }

            modelElementNamesFileStream = new FileOutputStream( modelElementNamesFile );

            Set<Partitionable> allModelElements = new HashSet<Partitionable>( );

            for ( ModelPartition partition : partitions ) {
                allModelElements.addAll( partition.getElements( ) );
            }

            MetaModelExtensionRecord rec = new MetaModelExtensionRecord( wrappers.size( ), wrappers.size( ), wrappers.size( ), allModelElements.size( ), wrappers.size( ) );

            // fill the partitionable based maps
            for ( Partitionable part : allModelElements ) {
                if ( part instanceof ModelElement ) {
                    ModelElement me = (ModelElement) part;

                    rec.getMofIdToQualifiedNameMapping( ).put( part.refMofId( ), new ArrayList<String>( me.getQualifiedName( ) ) );
                }

            }

            // fill the template based maps
            List<String> modelElementNames = new ArrayList<String>( wrappers.size( ) );
            List<String> modelElementMofIds = new ArrayList<String>( wrappers.size( ) );
            for ( JmiGeneratorModelElementWrapper wrapper : wrappers ) {
                if ( wrapper.getMofType( ) != JmiGeneratorMofType.EXCEPTION ) {
                    String javaClassName = wrapper.getJavaClassName( JmiGenerationKind.CLASS, true );

                    rec.getMofIdClassNameMap( ).put( wrapper.getModelElementMofId( ), javaClassName );
                    rec.getNameClassNameMap( ).put( wrapper.getModelElementQualifiedName( ), javaClassName );

                    rec.getJmiClasses( ).add( javaClassName );

                    modelElementNames.add( wrapper.getModelElementQualifiedName( ) );
                    modelElementMofIds.add( wrapper.getModelElementMofId( ) );
                }
            }

            // write the index
            MetaModelExtensionRecordReaderWriter.writeExtensionRecord( deploymentExtensionRecordFileStream, rec );
            MetaModelExtensionRecordReaderWriter.writeHumanReadableRecordLog( deploymentExtensionIndexLogFileStream, rec );
            MetaModelExtensionRecordReaderWriter.writeElementNames( modelElementNamesFileStream, modelElementMofIds );
        } catch ( Exception e ) {
//            logCallback.logThrowable( e );
            throw new RuntimeException( e );
        } finally {
            if ( deploymentExtensionRecordFileStream != null ) {
                try {
                    deploymentExtensionRecordFileStream.close( );
                } catch ( IOException e ) {
//                    logCallback.logThrowable( e );
                    throw new RuntimeException( e );
                }
            }

            if ( deploymentExtensionIndexLogFileStream != null ) {
                try {
                    deploymentExtensionIndexLogFileStream.close( );
                } catch ( IOException e ) {
//                    logCallback.logThrowable( e );
                    throw new RuntimeException( e );
                }
            }

            if ( modelElementNamesFileStream != null ) {
                try {
                    modelElementNamesFileStream.close( );
                } catch ( IOException e ) {
//                    logCallback.logThrowable( e );
                    throw new RuntimeException( e );
                }
            }
        }
    }

}
