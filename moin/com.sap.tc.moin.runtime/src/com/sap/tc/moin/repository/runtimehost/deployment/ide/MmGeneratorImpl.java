package com.sap.tc.moin.repository.runtimehost.deployment.ide;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.eclipse.osgi.baseadaptor.BaseData;
import org.eclipse.osgi.baseadaptor.bundlefile.BundleFile;
import org.eclipse.osgi.framework.adaptor.BundleData;
import org.eclipse.osgi.framework.internal.core.AbstractBundle;
import org.osgi.framework.Bundle;

import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.DataArea;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.ide.MoinFactory;
import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentInfo;
import com.sap.tc.moin.repository.ide.metamodels.MmExecutableInfo;
import com.sap.tc.moin.repository.ide.metamodels.MmGenerationBaseInfo;
import com.sap.tc.moin.repository.ide.metamodels.MmGenerationInfo;
import com.sap.tc.moin.repository.ide.metamodels.MmGenerationResult;
import com.sap.tc.moin.repository.ide.metamodels.MmGenerator;
import com.sap.tc.moin.repository.jmigenerator.DeploymentFilesGeneration;
import com.sap.tc.moin.repository.jmigenerator.controller.LogCallback;
import com.sap.tc.moin.repository.jmigenerator.controller.MoinMMGeneration;
import com.sap.tc.moin.repository.runtimehost.MmInfoConst;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.shared.util.Tuple;
import com.sap.tc.moin.repository.shared.util.Tuple.Pair;
import com.sap.tc.moin.xmi.XmiConversionUtil;
import com.sap.tc.moin.xmi.XmiConverter;
import com.sap.tc.moin.xmi.XmiConversionUtil.DcDataRecord;
import com.sap.tc.moin.xmi.XmiConversionUtil.MetamodelSourceInfo;

public class MmGeneratorImpl implements MmGenerator {

    private static MoinLogger log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_RUNTIME_HOST, MoinLocationEnum.MOIN_BUILD, MmGeneratorImpl.class );

    private static final String JAPRO_METAMODEL_XMI_RESOURCE_PATH = "moin/meta/"; //$NON-NLS-1$

    private MoinMMGeneration mmGeneration = new MoinMMGeneration( null, new MmGeneratorLogCallBack( ) );

    private DeploymentFilesGeneration deploymentFilesGeneration = new DeploymentFilesGeneration( new MmGeneratorLogCallBack( ) );

    private static final String MOIN_SRC_V2 = "moinsrc"; //$NON-NLS-1$

    public MmGenerationResult generate( MmGenerationInfo mmGenerationInfo, Collection<MmGenerationBaseInfo> additionalMetamodelsToConsider ) {

        if ( mmGenerationInfo == null ) {
            throw new IllegalArgumentException( "Info for metamodel to generate jmis for must no be null" ); //$NON-NLS-1$
        }

        /*
         * MOIN archive build version 2.0: MmInfoConst.MM2_PROPERTIES_FILE_NAME
         * file is evaluated. The archive might not include partitions, and no
         * meta model descriptor is generated for this.
         */
        boolean hasPartitions = true;
        File[] metamodelPartitionFiles = mmGenerationInfo.getMetamodelPartitionFiles( );
        if ( metamodelPartitionFiles == null || metamodelPartitionFiles.length == 0 || mmGenerationInfo.getSourcePath( ) == null ) {
            // Only version 2.0 without partition handling is supported. Neither source path (= partition root above "moin/meta/...") nor partitions are accounted for
            hasPartitions = false;
        }

        if ( mmGenerationInfo.getJmiDirectory( ) == null ) {
            throw new IllegalArgumentException( "JMI directory must not be null" ); //$NON-NLS-1$
        }

        if ( mmGenerationInfo.getOutputLocation( ) == null ) {
            throw new IllegalArgumentException( "Output location directory must not be null" ); //$NON-NLS-1$
        }

        if ( mmGenerationInfo.getMetamodelProperties( ) == null ) {
            throw new IllegalArgumentException( "Properties must not be null" ); //$NON-NLS-1$
        }

        String containerName = mmGenerationInfo.getContainerName( );
        if ( containerName == null ) {
            throw new IllegalArgumentException( "Container name must not be null" ); //$NON-NLS-1$
        }

        MmGenerationResultImpl result = new MmGenerationResultImpl( );

        this.mmGeneration.setDestPathJmi( mmGenerationInfo.getJmiDirectory( ).getAbsolutePath( ) );
        this.mmGeneration.setGenerateMof( mmGenerationInfo.isMofCase( ) );
        this.mmGeneration.setIgnoreMetamodelCheck( mmGenerationInfo.ignoreChecks( ) );

        this.deploymentFilesGeneration.setDcDescription( getNonNullProperty( mmGenerationInfo.getMetamodelProperties( ), DC_DESCRIPTION ) );
        this.deploymentFilesGeneration.setDcName( getNonNullProperty( mmGenerationInfo.getMetamodelProperties( ), DC_NAME ) );
        this.deploymentFilesGeneration.setDcVendor( getNonNullProperty( mmGenerationInfo.getMetamodelProperties( ), DC_VENDOR ) );
        this.deploymentFilesGeneration.setDcVersion( getNonNullProperty( mmGenerationInfo.getMetamodelProperties( ), DC_VERSION ) );
        this.deploymentFilesGeneration.setFacilityName( getNonNullProperty( mmGenerationInfo.getMetamodelProperties( ), FACILITY_NAME ) );

        this.deploymentFilesGeneration.setPropertiesFileName( MmInfoConst.MM_PROPERTIES_FILE_NAME );
        //xmiDir is the directory, where the deployment file(s) will be generated
        this.deploymentFilesGeneration.setXmiDir( mmGenerationInfo.getJmiDirectory( ).getAbsolutePath( ) );

        this.deploymentFilesGeneration.setPropertiesV2FileName( MmInfoConst.MM2_PROPERTIES_FILE_NAME );
        HashMap<String, String> xmiList2 = createXmiList2( mmGenerationInfo.getMetamodelPartitionFiles( ) );
        this.deploymentFilesGeneration.setXmiList2( xmiList2 );
        this.deploymentFilesGeneration.setMetaModelResourceBundleName( getMetaModelResourceBundleName( mmGenerationInfo ) );

        HashMap<String, String> xmiList = createXmiList( mmGenerationInfo.getMetamodelPartitionFiles( ) );
        this.deploymentFilesGeneration.setXmiList( xmiList );
        HashSet<List<String>> generatedPathFragments = new HashSet<List<String>>( );

        // have deployment files generation including checks first
        try {
            this.deploymentFilesGeneration.execute2( );
            generatedPathFragments.addAll( this.deploymentFilesGeneration.getGeneratedPathFragments( ) );
        } catch ( IOException e ) {
            throw new RuntimeException( e );
        }

        if ( hasPartitions ) {
            Pair<Collection<MetamodelSourceInfo>, String[]> metamodelEnvironment = getMetamodelEnvironment( mmGenerationInfo, filterValidAdditionalMetamodelsToConsider( additionalMetamodelsToConsider ) );
            Collection<MetamodelSourceInfo> metamodelsAvailableInSource = metamodelEnvironment.getA( );
            String[] referencedMetamodelJars = metamodelEnvironment.getB( );
            Connection buildConnection = XmiConversionUtil.createBuildConnection( metamodelsAvailableInSource, referencedMetamodelJars );
            Moin moin = buildConnection.getSession( ).getMoin( );
            DataArea dataArea = getNonMetamodelDataArea( buildConnection );
            if ( dataArea == null ) {
                throw new IllegalStateException( "Couldn't find appropriate data area" ); //$NON-NLS-1$
            }
            Set<String> partitionNames = xmiList.keySet( );
            Set<ModelPartition> partitions = new HashSet<ModelPartition>( );
            for ( String partitionName : partitionNames ) {
                PRI pri = moin.createPri( dataArea.getFacility( ).getId( ), dataArea.getName( ), containerName, partitionName );
                ModelPartition partition = buildConnection.getPartition( pri );
                if ( partition == null ) {
                    throw new IllegalStateException( "Couldn't get partition " + pri ); //$NON-NLS-1$
                }
                partitions.add( partition );
            }

            this.mmGeneration.execute( buildConnection, partitions, containerName );
            generatedPathFragments.addAll( this.mmGeneration.getGeneratedPathFragments( ) );
        }

        result.setGeneratedPathFragments( generatedPathFragments );
        return result;
    }

    private String getMetaModelResourceBundleName( MmGenerationInfo mmGenerationInfo ) {

        // start with root of moin folder, retrieving the java folder aside if existing
        String moinRoot = mmGenerationInfo.getSourcePath( );
        if ( moinRoot == null ) {
            return null;
        }
        File javaDirectory = new File( moinRoot, "java" ); //$NON-NLS-1$
        if ( !javaDirectory.exists( ) || javaDirectory.isFile( ) ) {
            return null;
        }
        return DeploymentFilesGeneration.scanResourceBundleFileName( javaDirectory );
    }

    private Collection<MmGenerationBaseInfo> filterValidAdditionalMetamodelsToConsider( Collection<MmGenerationBaseInfo> additionalMetamodelsToConsider ) {

        if ( additionalMetamodelsToConsider == null ) {
            return null;
        }
        ArrayList<MmGenerationBaseInfo> result = new ArrayList<MmGenerationBaseInfo>( additionalMetamodelsToConsider.size( ) );
        for ( MmGenerationBaseInfo mmGenerationBaseInfo : additionalMetamodelsToConsider ) {
            if ( mmGenerationBaseInfo.getContainerName( ) != null && mmGenerationBaseInfo.getSourcePath( ) != null ) {
                result.add( mmGenerationBaseInfo );
            }
        }
        return result;
    }

    private DataArea getNonMetamodelDataArea( Connection buildConnection ) {

        Collection<ClientSpec> clientSpecs = buildConnection.getSession( ).getCompoundClientSpec( ).getClientSpecs( );
        for ( ClientSpec clientSpec : clientSpecs ) {
            DataArea dataArea = clientSpec.getDataArea( );
            if ( dataArea.getDescriptor( ).isMetamodelDataArea( ) == false ) {
                return dataArea;
            }
        }
        return null;
    }

    public void convertXmi( MmExecutableInfo metamodelToConvert, Collection<MmGenerationBaseInfo> additionalMetamodelsToConsider ) {

        //projectPath = "M:\\dev\\moin\\moin.test\\dev\\src\\_tc~moin~testcases_1.0_source";
        if ( metamodelToConvert == null ) {
            throw new IllegalArgumentException( "Info for metamodel to convert must not be null" ); //$NON-NLS-1$
        }
        if ( metamodelToConvert.getContainerName( ) == null ) {
            throw new IllegalArgumentException( "Container name for metamodel to convert must not be null" ); //$NON-NLS-1$
        }

        if ( metamodelToConvert.getSourcePath( ) == null ) {
            throw new IllegalArgumentException( "Source path for metamodel to convert must not be null" ); //$NON-NLS-1$
        }

        Pair<Collection<MetamodelSourceInfo>, String[]> environment = getMetamodelEnvironment( metamodelToConvert, filterValidAdditionalMetamodelsToConsider( additionalMetamodelsToConsider ) );
        Collection<MetamodelSourceInfo> metamodelsAvailableInSource = environment.getA( );
        metamodelsAvailableInSource = patchSourcePathV2( metamodelsAvailableInSource );


        String[] referencedMetamodelJars = environment.getB( );
        Connection buildConnection = XmiConversionUtil.createBuildConnection( metamodelsAvailableInSource, referencedMetamodelJars );
        Moin moin = buildConnection.getSession( ).getMoin( );
        boolean verbose = log.isTraced( MoinSeverity.DEBUG );
        boolean convertMof = metamodelToConvert.isMofCase( );
        boolean ignoreChecks = metamodelToConvert.ignoreChecks( );
        boolean patchDisabled = false;
        XmiConverter converter = new XmiConverter( moin, buildConnection, metamodelToConvert.getSourcePath( ), verbose, patchDisabled, convertMof, ignoreChecks );
        try {
            converter.run( );
        } catch ( Exception e ) {
            throw new RuntimeException( e );
        }
    }

    private Collection<MetamodelSourceInfo> patchSourcePathV2( Collection<MetamodelSourceInfo> metamodelsAvailableInSource ) {

        ArrayList<MetamodelSourceInfo> result = new ArrayList<MetamodelSourceInfo>( metamodelsAvailableInSource.size( ) );
        for ( MetamodelSourceInfo metamodelSourceInfo : metamodelsAvailableInSource ) {
            File sourcePath = metamodelSourceInfo.getSourcePath( );
            if ( needsPatchingV2( sourcePath ) ) {
                String patchedSourcePath = sourcePath.getAbsolutePath( ) + File.separator + MOIN_SRC_V2;
                MetamodelSourceInfo info = new MetamodelSourceInfo( new File( patchedSourcePath ), metamodelSourceInfo.getVendor( ), metamodelSourceInfo.getDc( ) );
                result.add( info );
            } else {
                result.add( metamodelSourceInfo );
            }
        }
        return result;
    }

    private boolean needsPatchingV2( final File sourcePath ) {

        //does this directory contain a folder "moinsrc"
        return sourcePath.list( new FilenameFilter( ) {

            public boolean accept( File dir, String name ) {

                if ( dir.equals( sourcePath ) && MOIN_SRC_V2.equals( name ) ) {
                    return true;
                }
                return false;
            }
        } ).length > 0;
    }

    private Tuple.Pair<Collection<MetamodelSourceInfo>, String[]> getMetamodelEnvironment( MmGenerationBaseInfo mmBaseInfo, Collection<MmGenerationBaseInfo> additionalMetamodelsToConsider ) {

        ArrayList<String> referencedMetamodels = new ArrayList<String>( );
        Collection<MmDeploymentInfo> deployedMetamodels = MoinFactory.getMmDeploymentManager( ).getMetaModelPluginList( );
        HashSet<String> containerNamesToSkip = new HashSet<String>( );

        containerNamesToSkip.add( mmBaseInfo.getContainerName( ) );
        if ( additionalMetamodelsToConsider != null ) {
            for ( MmGenerationBaseInfo mmInfo : additionalMetamodelsToConsider ) {
                containerNamesToSkip.add( mmInfo.getContainerName( ) );
            }
        }
        try {
            for ( MmDeploymentInfo metaModelInfo : deployedMetamodels ) {
                MmDeploymentInfo info = metaModelInfo;
                String containerNameOfDeployedMetamodel = getContainerName( info );
                if ( containerNameOfDeployedMetamodel == null ) {
                    continue; //if the deployed metamodel doesn't have a container name we have to skip it
                }

                if ( containerNamesToSkip.contains( containerNameOfDeployedMetamodel ) ) {
                    continue;
                }


                final File baseFile = getBaseFile( info );
                if ( baseFile != null ) {
                    String referencedMetamodelJarPath = null;
                    if ( baseFile.getName( ).endsWith( ".jar" ) ) { //$NON-NLS-1$
                        referencedMetamodelJarPath = baseFile.getAbsolutePath( );
                    } else {//must be a directory -> Still not all metamodels are jared-plugins :-(
                        if ( baseFile.isDirectory( ) ) {
                            File[] listFiles = baseFile.listFiles( new FilenameFilter( ) {

                                public boolean accept( File dir, String name ) {

                                    if ( "lib".equals( name ) && dir.equals( baseFile ) ) { //$NON-NLS-1$
                                        return true;
                                    }
                                    return false;

                                }
                            } );

                            if ( listFiles != null && listFiles.length > 0 ) {
                                final File libDirectory = listFiles[0];
                                File[] libFolderXmiJarFile = libDirectory.listFiles( new FilenameFilter( ) {

                                    public boolean accept( File dir, String name ) {

                                        if ( name.endsWith( "xmi.jar" ) && dir.equals( libDirectory ) ) { //$NON-NLS-1$
                                            return true;
                                        }
                                        return false;

                                    }
                                } );
                                if ( libFolderXmiJarFile != null && libFolderXmiJarFile.length > 0 ) {
                                    referencedMetamodelJarPath = libFolderXmiJarFile[0].getAbsolutePath( );
                                }
                            }

                        }
                    }

                    if ( referencedMetamodelJarPath != null ) {
                        referencedMetamodels.add( referencedMetamodelJarPath );
                    }
                }
            }
        } catch ( Exception e ) {
            throw new RuntimeException( e );
        }

        ArrayList<MetamodelSourceInfo> metamodelSourceInfos = new ArrayList<MetamodelSourceInfo>( );
        metamodelSourceInfos.add( convertToMetamodelSourceInfo( mmBaseInfo ) );
        if ( additionalMetamodelsToConsider != null ) {
            for ( MmGenerationBaseInfo mmInfo : additionalMetamodelsToConsider ) {
                metamodelSourceInfos.add( convertToMetamodelSourceInfo( mmInfo ) );
            }
        }


        String[] referencedMetamodelJars = referencedMetamodels.toArray( new String[referencedMetamodels.size( )] );
        Tuple.Pair<Collection<MetamodelSourceInfo>, String[]> result = new Tuple.Pair<Collection<MetamodelSourceInfo>, String[]>( metamodelSourceInfos, referencedMetamodelJars );
        return result;
    }


    private MetamodelSourceInfo convertToMetamodelSourceInfo( MmGenerationBaseInfo info ) {

        File sourcePath = new File( info.getSourcePath( ) );
        DcDataRecord dcInfo = XmiConversionUtil.convertContainerName( info.getContainerName( ) );
        return new MetamodelSourceInfo( sourcePath, dcInfo.dcVendor, dcInfo.dcName );
    }


    private File getBaseFile( MmDeploymentInfo info ) throws Exception {

        Bundle bundle = info.getBundle( );

        if ( bundle instanceof AbstractBundle ) {
            AbstractBundle abstractBundle = (AbstractBundle) bundle;
            BundleData bundleData = abstractBundle.getBundleData( );
            if ( bundleData instanceof BaseData ) {
                BaseData baseData = (BaseData) bundleData;
                BundleFile bundleFile = baseData.getBundleFile( );
                if ( bundleFile != null ) {
                    return bundleFile.getBaseFile( );

                }
            }
        }

        return null;

    }


    private HashMap<String, String> createXmiList( File[] metamodelPartitionFiles ) {

        HashMap<String, String> partitions = new HashMap<String, String>( metamodelPartitionFiles.length );
        for ( File file : metamodelPartitionFiles ) {
            partitions.put( JAPRO_METAMODEL_XMI_RESOURCE_PATH + file.getName( ), ( (Long) file.lastModified( ) ).toString( ) );
        }
        return partitions;
    }

    private HashMap<String, String> createXmiList2( File[] metamodelPartitionFiles ) {

        HashMap<String, String> partitions = new HashMap<String, String>( metamodelPartitionFiles.length );
        for ( File file : metamodelPartitionFiles ) {
            String contentHash = deploymentFilesGeneration.getContentHash( file );
            if ( contentHash != null ) {
                partitions.put( JAPRO_METAMODEL_XMI_RESOURCE_PATH + file.getName( ), contentHash );
            } else {
                partitions.put( JAPRO_METAMODEL_XMI_RESOURCE_PATH + file.getName( ), ( (Long) file.lastModified( ) ).toString( ) );
            }
        }
        return partitions;
    }

    private String getNonNullProperty( Properties properties, String key ) {

        return properties.getProperty( key, "" ); //$NON-NLS-1$
    }

    private String getContainerName( MmDeploymentInfo mmInfo ) throws IOException {

        return mmInfo.getContainerName( );
    }

    private static final class MmGenerationResultImpl implements MmGenerationResult {

        private Set<List<String>> generatedPaths;

        public Set<List<String>> getGeneratedPathFragments( ) {

            return generatedPaths;
        }

        public void setGeneratedPathFragments( Set<List<String>> generatedPaths ) {

            this.generatedPaths = generatedPaths;
        }

    }

    private static final class MmGeneratorLogCallBack implements LogCallback {

        public void log( String message ) {

            log.trace( MoinSeverity.DEBUG, message );

        }

        public void logInfo( String message ) {

            log.trace( MoinSeverity.INFO, message );

        }

        public void logThrowable( Throwable throwable ) {

            log.trace( throwable, MoinSeverity.ERROR, "Exception occured" ); //$NON-NLS-1$

        }

        public void logWarn( String message ) {

            log.trace( MoinSeverity.WARNING, message );

        }

        public void logError( String message ) {

            log.trace( MoinSeverity.ERROR, message );

        }
    }
}
