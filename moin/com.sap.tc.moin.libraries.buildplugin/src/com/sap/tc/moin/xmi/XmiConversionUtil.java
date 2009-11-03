package com.sap.tc.moin.xmi;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.sap.tc.moin.facility.primary.PrimaryFacility;
import com.sap.tc.moin.facility.primary.build.BuildPrimaryFacilityImpl;
import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiConfigurationAdaptorFactoryImpl;
import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiConfigurationProvider;
import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiDcDefinitionProvider;
import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiConfigurationProvider.Scenario;
import com.sap.tc.moin.facility.primary.ipi.diservice.build.IpiBuildDiService;
import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.cdam.CompoundClientSpec;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.spi.cdam.SpiCompoundDataAreaManager;

public class XmiConversionUtil {

    private static final String MM_PROPERTIES = "metamodel.properties"; //$NON-NLS-1$

    private static final String MOINARCH_PROPERTIES = "moin/reginfo/moinarch.properties"; //$NON-NLS-1$

    private static final String DEFAULT_DATA_AREA_NAME = "DefaultDataArea"; //$NON-NLS-1$

    public static IpiDiConfigurationProvider getConfigurationProvider( File sourcePath, String vendor, String dc, String[] modelsRequiredArchivePaths ) {

        MetamodelSourceInfo sourceInfo = new MetamodelSourceInfo( sourcePath, vendor, dc );
        return getConfigurationProvider( Collections.singletonList( sourceInfo ), modelsRequiredArchivePaths );
    }

    public static Connection createBuildConnection( Collection<MetamodelSourceInfo> metamodelSourceInfos, String[] metamodelJars ) {

        com.sap.tc.moin.repository.runtimehost.build.MoinFactory.shutDown( );
        Moin moin = com.sap.tc.moin.repository.runtimehost.build.MoinFactory.getMoinInstance( null );

        Facility facility = moin.getFacilityById( PrimaryFacility.FACILITY_ID );
        IpiBuildDiService diService = ( (BuildPrimaryFacilityImpl) facility ).getBuildDiService( );
        IpiDiConfigurationProvider configurationProvider = XmiConversionUtil.getConfigurationProvider( metamodelSourceInfos, metamodelJars );
        ClientSpec clientSpec = diService.getClientSpec( configurationProvider );
        CompoundClientSpec compoundClientSpec = ( (SpiCompoundDataAreaManager) moin.getCompoundDataAreaManager( ) ).getDefaultCompoundClientSpec( clientSpec );
        Connection connection = moin.createSession( compoundClientSpec ).createConnection( );
        return connection;
    }

    public static IpiDiConfigurationProvider getConfigurationProvider( Collection<MetamodelSourceInfo> metamodelSourceInfos, String[] modelsRequiredArchivePaths ) {

        IpiDiConfigurationAdaptorFactoryImpl diAdaptorFactory = new IpiDiConfigurationAdaptorFactoryImpl( );
        List<IpiDiDcDefinitionProvider> definitionProviders = new LinkedList<IpiDiDcDefinitionProvider>( );
        for ( MetamodelSourceInfo metamodelSourceInfo : metamodelSourceInfos ) {
            IpiDiDcDefinitionProvider dcDefinitionProvider = diAdaptorFactory.getMetaModelDiDcDefinitionAdaptor( metamodelSourceInfo.getVendor( ), metamodelSourceInfo.getDc( ), metamodelSourceInfo.getSourcePath( ).getAbsolutePath( ) );
            definitionProviders.add( dcDefinitionProvider );
        }

        if ( modelsRequiredArchivePaths != null ) {
            for ( String path : modelsRequiredArchivePaths ) {
                IpiDiDcDefinitionProvider dcProvider = createDcProviderForArchive( path, diAdaptorFactory );

                if ( dcProvider != null ) {
                    definitionProviders.add( dcProvider );
                }
            }
        }

        IpiDiConfigurationProvider diConfigurationProvider = diAdaptorFactory.getMetaModelDiConfigurationAdaptor( Scenario.BUILD_SCENARIO, DEFAULT_DATA_AREA_NAME, definitionProviders );
        return diConfigurationProvider;
    }

    public static IpiDiDcDefinitionProvider createDcProviderForArchive( String archivePath, IpiDiConfigurationAdaptorFactoryImpl diAdaptorFactory ) throws IllegalStateException {

        IpiDiDcDefinitionProvider ret = null;

        ZipFile zip = null;

        try {
            zip = new ZipFile( archivePath );
            if ( isMetamodelArchive( zip ) ) {
                DcDataRecord dr = readDcDataRecord( zip );

                ret = diAdaptorFactory.getMetaModelDiDcDefinitionAdaptor( dr.dcVendor, dr.dcName, Collections.singletonList( archivePath ) );

            }
            zip.close( );
        } catch ( IOException e ) {
            throw new IllegalStateException( e );
        } finally {
            if ( zip != null ) {
                try {
                    zip.close( );
                } catch ( IOException e ) {
                    throw new IllegalStateException( e );
                }
            }
        }

        return ret;
    }

    private static DcDataRecord readDcDataRecord( ZipFile zip ) throws IllegalStateException {

        DcDataRecord ret = new DcDataRecord( );

        try {
            // try to get metamodel version 2.0
            ZipEntry moinArchEntry = zip.getEntry( MOINARCH_PROPERTIES );

            if ( moinArchEntry != null ) {

                InputStream is = zip.getInputStream( moinArchEntry );
                Properties props = new Properties( );
                props.load( is );

                String metamodelId = props.getProperty( "containerId" ); //$NON-NLS-1$

                if ( metamodelId == null ) {
                    throw new MoinIllegalStateException( MoinXmiMessages.METAMODELIDHASNOTBEENDEFINEDIN, zip.getName( ) );
                }

                ret.dcName = convertMetaModelIdIntoDcName( metamodelId );

                ret.dcVendor = props.getProperty( "vendor" ); //$NON-NLS-1$

                if ( ret.dcVendor == null ) {
                    throw new MoinIllegalStateException( MoinXmiMessages.METAMODELVENDORHASNOTBEENDEFINEDIN, zip.getName( ) );
                }

            } else {

                ZipEntry entry = zip.getEntry( MM_PROPERTIES );

                if ( entry == null ) {
                    throw new MoinIllegalStateException( MoinXmiMessages.HASNOTBEENFOUND, MM_PROPERTIES, zip.getName( ) );
                }

                InputStream is = zip.getInputStream( entry );
                Properties props = new Properties( );
                props.load( is );

                String metamodelId = props.getProperty( "metamodelId" ); //$NON-NLS-1$

                if ( metamodelId == null ) {
                    throw new MoinIllegalStateException( MoinXmiMessages.METAMODELIDHASNOTBEENDEFINEDIN, zip.getName( ) );
                }

                ret.dcName = convertMetaModelIdIntoDcName( metamodelId );

                ret.dcVendor = props.getProperty( "vendor" ); //$NON-NLS-1$

                if ( ret.dcVendor == null ) {
                    throw new MoinIllegalStateException( MoinXmiMessages.METAMODELVENDORHASNOTBEENDEFINEDIN, zip.getName( ) );
                }
            }

            return ret;
        } catch ( IOException e ) {
            throw new IllegalStateException( e );
        }
    }

    public static String convertMetaModelIdIntoDcName( String metaModelId ) throws IllegalStateException {

        return convertContainerName( metaModelId ).dcName;

    }

    public static DcDataRecord convertContainerName( String containerName ) {

        if ( containerName.length( ) < 9 ) {
            throw new MoinIllegalStateException( MoinXmiMessages.CANNOTBELEGAL, containerName );
        }
        DcDataRecord result = new DcDataRecord( );
        int indexOfSeparator = containerName.indexOf( "/" ); //$NON-NLS-1$
        if ( indexOfSeparator != -1 ) {
            result.dcName = containerName.substring( indexOfSeparator + 1 );
            result.dcVendor = containerName.substring( 0, indexOfSeparator );
            return result;
        } else {
            throw new MoinIllegalStateException( MoinXmiMessages.EXPECTEDSLASHWITHINCONTAINERNAME, containerName );
        }
    }

    public static boolean isMetamodelArchive( ZipFile archive ) {

        Enumeration<? extends ZipEntry> entries = archive.entries( );
        if ( entries == null ) {
            return false;
        }
        while ( entries.hasMoreElements( ) ) {
            ZipEntry entry = entries.nextElement( );
            if ( entry.getName( ).equals( "moin/meta/" ) || entry.getName( ).equals( "moin/reginfo/" ) ) { //$NON-NLS-1$ //$NON-NLS-2$
                return true;
            }
        }
        return false;
    }

    public static class DcDataRecord {

        public String dcName;

        public String dcVendor;
    }

    public static class MetamodelSourceInfo {

        private File sourcePath;

        private String vendor;

        private String dc;

        public MetamodelSourceInfo( File sourcePath, String vendor, String dc ) {

            super( );
            this.sourcePath = sourcePath;
            this.vendor = vendor;
            this.dc = dc;
        }

        public File getSourcePath( ) {

            return this.sourcePath;
        }

        public String getVendor( ) {

            return this.vendor;
        }

        public String getDc( ) {

            return this.dc;
        }

    }
}
