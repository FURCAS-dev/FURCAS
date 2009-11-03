/**
 * 
 */
package com.sap.tc.moin.repository.runtimehost.deployment;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.sap.tc.moin.repository.metamodels.MetaModelVersion;
import com.sap.tc.moin.repository.runtimehost.MetamodelRegistrationParser;
import com.sap.tc.moin.repository.runtimehost.MmInfoConst;
import com.sap.tc.moin.repository.runtimehost.RuntimehostMessages;
import com.sap.tc.moin.repository.runtimehost.deployment.MoinArchiveDescriptorImpl.ArchiveFormatVersion;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.shared.util.StringUtils;


/**
 * Utility class for handling properties of meta-model content archives.
 * <p>
 * This class provides basic functionality for reading and storing meta-model
 * archive properties as well as accessing them at runtime.
 */
public class MetaModelArchiveDescriptor {

    private static MoinLogger _log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_RUNTIME_HOST, MoinLocationEnum.MOIN_METAMODELS, MetaModelArchiveDescriptor.class );

    /** ; */
    public static final char PARTITION_LIST_DELIMITER_CHAR = ';';

    /** \ */
    public static final char PARTITION_LIST_ESCAPE_CHAR = '\\';

    /**
     * Comment for descriptor files
     */
    private static final String MM_DESC_FILE_COMMENT = "metamodel meta information"; //$NON-NLS-1$

    /**
     * Last error message
     */
    private String lastErrorMessage = null;

    /**
     * Full (unique) name of the meta-model
     */
    private String name = null;

    /**
     * Name (id) of the facility for this meta-model
     */
    private String facilityName = null;

    private MoinArchiveHeader archiveHeader;

    /**
     * Name of the meta-model extension package
     */
    private String metaModelExtPackageName;

    private String deploymentExtensionClassName;

    private String metaModelResourceBundleName = null;

    /**
     * Map of partition names and their content hash.
     */
    private Map<String, Long> partitionHashcodeMap;

    /**
     * Version of the moin archive format.
     */
    private ArchiveFormatVersion archiveFormatVersion;

    private String deploymentId;

    /**
     * Constructor for new metamodel format
     * 
     * @param archiveFormatVersion
     */
    public MetaModelArchiveDescriptor( MoinArchiveHeader header, String deploymentId ) {

        this.archiveHeader = header;
        this.archiveFormatVersion = ArchiveFormatVersion.VERSION_2;
        this.deploymentId = deploymentId;
    }

    /**
     * Constructor for old metamodel format
     * 
     * @param archiveFormatVersion
     */
    public MetaModelArchiveDescriptor( String deploymentId ) {

        this.archiveFormatVersion = ArchiveFormatVersion.VERSION_1;
        this.deploymentId = deploymentId;
    }

    /**
     * @return the archiveFormatVersion
     */
    public ArchiveFormatVersion getArchiveFormatVersion( ) {

        return archiveFormatVersion;
    }

    /**
     * @return the vendor
     */
    public String getVendor( ) {

        return this.archiveHeader.getVendor( );
    }

    /**
     * @return the name
     */
    public String getName( ) {

        if ( this.name != null ) {
            // fallback - old format
            return this.name;
        } else {
            return this.getContainerName( );
        }
    }

    /**
     * @return the label
     */
    public String getLabel( ) {

        return this.archiveHeader.getLabel( );
    }

    /**
     * @return the facilityName
     */
    public String getFacilityName( ) {

        return this.facilityName;
    }

    /**
     * @return the version
     */
    public MetaModelVersion getVersion( ) {

        return this.archiveHeader.getVersion( );
    }

    /**
     * @return the metaModelExtPackageName
     */
    public String getMetaModelExtPackageName( ) {

        return this.metaModelExtPackageName;
    }


    public String getDeploymentExtensionClassName( ) {

        return deploymentExtensionClassName;
    }


    public String getMetaModelResourceBundleName( ) {

        return metaModelResourceBundleName;
    }

    public Map<String, Long> getPartitionHashes( ) {

        return partitionHashcodeMap;
    }

    /**
     * Loads the data of this descriptor from the specified input stream.
     * 
     * @param is
     * @throws IOException if loading fails due to an I/O error
     */
    public void load( InputStream is ) throws IOException {

        Properties properties = new Properties( );
        properties.load( is );

        this.setProperties( properties );
    }

    /**
     * Sets all fields to the values according to the specified properties
     * object.
     * 
     * @param properties
     */
    protected void setProperties( Properties properties ) {

        this.name = properties.getProperty( MmInfoConst.MM_ID );
        if ( this.name == null || this.name.length( ) == 0 ) {
            _log.trace( MoinSeverity.WARNING, RuntimehostMessages.METAMODEL_NAME_NOT_SET, new Object[] { MmInfoConst.MM_ID, MmInfoConst.MM_PROPERTIES_FILE_NAME } );
            this.name = null;
            //throw new MoinDeploymentException( this.lastErrorMessage, null );
        }

        String vendor = properties.getProperty( MmInfoConst.MM_VENDOR );
        if ( vendor == null || vendor.length( ) == 0 ) {
            _log.trace( MoinSeverity.WARNING, RuntimehostMessages.METAMODEL_VENDOR_NOT_SET, new Object[] { MmInfoConst.MM_VENDOR, MmInfoConst.MM_PROPERTIES_FILE_NAME, this.deploymentId } );

        }

        String label = properties.getProperty( MmInfoConst.MM_LABEL );
        if ( label == null || label.length( ) == 0 ) {
            _log.trace( MoinSeverity.WARNING, RuntimehostMessages.METAMODEL_LABEL_NOT_SET, new Object[] { MmInfoConst.MM_LABEL, MmInfoConst.MM_PROPERTIES_FILE_NAME, this.deploymentId } );
            //throw new MoinDeploymentException( this.lastErrorMessage, null );
        }

        MetaModelVersion version = new MetaModelVersionImpl( properties.getProperty( MmInfoConst.MM_VERSION ) );
        if ( version == null || version.toString( ).length( ) == 0 ) {
            _log.trace( MoinSeverity.WARNING, RuntimehostMessages.METAMODEL_VERSION_NOT_SET, new Object[] { MmInfoConst.MM_VERSION, MmInfoConst.MM_PROPERTIES_FILE_NAME, this.deploymentId } );
            //throw new MoinDeploymentException( this.lastErrorMessage, null );
        }

        this.metaModelExtPackageName = properties.getProperty( MmInfoConst.MM_EXTENSION_PACKAGE );
        if ( this.metaModelExtPackageName == null || this.metaModelExtPackageName.length( ) == 0 ) {
            Object[] params = new Object[] { MmInfoConst.MM_EXTENSION_PACKAGE, MmInfoConst.MM_PROPERTIES_FILE_NAME, this.deploymentId };
            _log.trace( MoinSeverity.FATAL, RuntimehostMessages.METAMODEL_EXTENSION_CLASS_NOT_SET, params );
            throw new MoinDeploymentException( RuntimehostMessages.METAMODEL_EXTENSION_CLASS_NOT_SET, params );
        } else {
            // create class name
            this.deploymentExtensionClassName = this.metaModelExtPackageName + "." + MmInfoConst.MM_EXTENSION_CLASS_NAME; //$NON-NLS-1$
        }

        this.facilityName = properties.getProperty( MmInfoConst.MM_FACILITY_NAME );
        if ( this.facilityName == null || this.facilityName.length( ) == 0 ) {
            _log.trace( MoinSeverity.FATAL, RuntimehostMessages.METAMODEL_FACILTIY_NOT_SET, new Object[] { MmInfoConst.MM_FACILITY_NAME, MmInfoConst.MM_PROPERTIES_FILE_NAME, this.deploymentId } );
            //throw new MoinDeploymentException( this.lastErrorMessage, null );
        }

        String partitionNamesStr = properties.getProperty( MmInfoConst.MM_PARTITION_LIST );
        if ( partitionNamesStr == null || partitionNamesStr.length( ) == 0 ) {
            _log.trace( MoinSeverity.FATAL, RuntimehostMessages.METAMODEL_PARTITIONS_NOT_SET, new Object[] { MmInfoConst.MM_PARTITION_LIST, MmInfoConst.MM_PROPERTIES_FILE_NAME, this.deploymentId } );
            //throw new MoinDeploymentException( this.lastErrorMessage, null );
        }

        String[] partitionNamesArray = StringUtils.split( partitionNamesStr, PARTITION_LIST_DELIMITER_CHAR, PARTITION_LIST_ESCAPE_CHAR );
        List<String> partitionNamesList = Arrays.asList( partitionNamesArray );
        this.partitionHashcodeMap = new HashMap<String, Long>( );
        for ( String partitionName : partitionNamesList ) {
            this.partitionHashcodeMap.put( partitionName, 0L );
        }

        this.partitionHashcodeMap = determinePartitionTimeStampFromProperties( properties, partitionHashcodeMap );

        String dcNameFromMMProperties = properties.getProperty( MmInfoConst.MM_ID );
        if ( dcNameFromMMProperties == null || dcNameFromMMProperties.length( ) == 0 ) {
            Object[] params = new Object[] { MmInfoConst.MM_ID, MmInfoConst.MM_PROPERTIES_FILE_NAME, this.deploymentId };
            _log.trace( MoinSeverity.FATAL, RuntimehostMessages.METAMODEL_CONTAINER_NOT_SET, params );
            throw new MoinDeploymentException( RuntimehostMessages.METAMODEL_CONTAINER_NOT_SET, params );
        }

        this.archiveHeader = new MoinArchiveHeader( dcNameFromMMProperties, label, vendor, version );

    }


    protected Properties getProperties( ) {

        Properties properties = new Properties( );
        properties.setProperty( MmInfoConst.MM_VENDOR, this.archiveHeader.getVendor( ) );
        properties.setProperty( MmInfoConst.MM_FACILITY_NAME, this.facilityName );
        properties.setProperty( MmInfoConst.MM_LABEL, this.archiveHeader.getLabel( ) );
        properties.setProperty( MmInfoConst.MM_ID, this.name );
        properties.setProperty( MmInfoConst.MM_EXTENSION_PACKAGE, this.metaModelExtPackageName );
        properties.setProperty( MmInfoConst.MM_VERSION, this.archiveHeader.getVersion( ).toString( ) );

        String partitionList = StringUtils.combine( this.partitionHashcodeMap.keySet( ).toArray( new String[this.partitionHashcodeMap.size( )] ), PARTITION_LIST_DELIMITER_CHAR, PARTITION_LIST_ESCAPE_CHAR );
        properties.setProperty( MmInfoConst.MM_PARTITION_LIST, partitionList );

        return properties;
    }

    /**
     * @param os
     * @throws IOException
     */
    public void store( OutputStream os ) throws IOException {

        Properties properties = getProperties( );
        properties.store( os, MM_DESC_FILE_COMMENT );
    }

    /**
     * Gets the list of names (container-relative paths) of partitions contained
     * in the archive.
     * 
     * @return an unmodifiable list of partition names
     */
    public List<String> getPartitionNameList( ) {

        List<String> partitionList = new ArrayList<String>( this.partitionHashcodeMap.keySet( ) );
        return Collections.unmodifiableList( partitionList );
    }

    /**
     * Loads all property and registration files from the archive. TODO
     * exception handling !!
     * 
     * @param archiveAccess
     * @return
     */
    public void load( IpiMetamodelArchiveAccess archiveAccess ) {

        InputStream inputStream = null;
        try {

            inputStream = archiveAccess.getResourceAsStream( MmInfoConst.MM_PROPERTIES_FILE_NAME );

            if ( inputStream == null ) {
                throw new MoinDeploymentException( RuntimehostMessages.FILE_NOT_FOUND, new Object[] { MmInfoConst.MM_PROPERTIES_FILE_NAME, this.deploymentId } );
            }

            this.load( inputStream );

        } catch ( IOException e ) {
            _log.trace( e, MoinSeverity.ERROR, RuntimehostMessages.FILE_PROBLEMS, new Object[] { MmInfoConst.MM_PROPERTIES_FILE_NAME, this.deploymentId } );
            throw new MoinDeploymentException( e, RuntimehostMessages.FILE_PROBLEMS, new Object[] { MmInfoConst.MM_PROPERTIES_FILE_NAME, this.deploymentId } );
        } finally {
            if ( inputStream != null ) {
                try {
                    inputStream.close( );
                } catch ( IOException e ) {
                    _log.trace( e, MoinSeverity.ERROR, RuntimehostMessages.FILE_PROBLEMS, new Object[] { MmInfoConst.MM_PROPERTIES_FILE_NAME, this.deploymentId } );
                    throw new MoinDeploymentException( e, RuntimehostMessages.FILE_PROBLEMS, new Object[] { MmInfoConst.MM_PROPERTIES_FILE_NAME, this.deploymentId } );
                }
            }

        }

    }

    /**
     * Loads all property and registration files from an archive in the new
     * format. TODO exception handling !!
     * 
     * @param archiveAccess
     * @return
     */
    public boolean loadV2( IpiMetamodelArchiveAccess archiveAccess ) {

        // load properties from metamodel.xml
        InputStream inputStream = null;
        MetamodelRegistrationParser parser = null;
        try {

            inputStream = archiveAccess.getResourceAsStream( MmInfoConst.MM2_METAMODEL_XML_FILE_NAME );

            if ( inputStream != null ) {
                parser = new MetamodelRegistrationParser( );
                parser.parse( inputStream );

                this.facilityName = parser.getFacilityId( );

                // actually not used, corresponding part set in MetaModelReceiver by method setMdExtensionInstance(DeploymentExtension)
                this.deploymentExtensionClassName = parser.getDeploymentExtensionClass( );

                this.metaModelResourceBundleName = parser.getResourceBundleClass( );

                // TODO decide if package or class is used
                this.metaModelExtPackageName = this.deploymentExtensionClassName.substring( 0, this.deploymentExtensionClassName.lastIndexOf( '.' ) );

                partitionHashcodeMap = parser.getPartitions( );

            } else {
                return false;
            }

        } catch ( IOException e ) {
            _log.trace( e, MoinSeverity.ERROR, RuntimehostMessages.FILE_PROBLEMS, new Object[] { MmInfoConst.MM2_METAMODEL_XML_FILE_NAME, this.deploymentId } );
            throw new MoinDeploymentException( e, RuntimehostMessages.FILE_PROBLEMS, new Object[] { MmInfoConst.MM2_METAMODEL_XML_FILE_NAME, this.deploymentId } );
        } catch ( SAXException e ) {
            _log.trace( e, MoinSeverity.ERROR, RuntimehostMessages.FILE_PROBLEMS, new Object[] { MmInfoConst.MM2_METAMODEL_XML_FILE_NAME, this.deploymentId } );
            throw new MoinDeploymentException( e, RuntimehostMessages.FILE_PROBLEMS, new Object[] { MmInfoConst.MM2_METAMODEL_XML_FILE_NAME, this.deploymentId } );
        } catch ( ParserConfigurationException e ) {
            _log.trace( e, MoinSeverity.ERROR, RuntimehostMessages.FILE_PROBLEMS, new Object[] { MmInfoConst.MM2_METAMODEL_XML_FILE_NAME, this.deploymentId } );
            throw new MoinDeploymentException( e, RuntimehostMessages.FILE_PROBLEMS, new Object[] { MmInfoConst.MM2_METAMODEL_XML_FILE_NAME, this.deploymentId } );
        } finally {
            if ( inputStream != null ) {
                try {
                    inputStream.close( );
                } catch ( IOException e ) {
                    _log.trace( e, MoinSeverity.ERROR, RuntimehostMessages.FILE_PROBLEMS, new Object[] { MmInfoConst.MM2_METAMODEL_XML_FILE_NAME, this.deploymentId } );
                    throw new MoinDeploymentException( e, RuntimehostMessages.FILE_PROBLEMS, new Object[] { MmInfoConst.MM2_METAMODEL_XML_FILE_NAME, this.deploymentId } );
                }
            }

        }

        return true;
    }

    public String getContainerName( ) {

        return this.archiveHeader.getContainerName( );
    }


    public String getLastErrorMessage( ) {

        return lastErrorMessage;
    }

    public MoinArchiveHeader getArchiveHeader( ) {

        if ( archiveHeader == null ) {
            throw new MoinDeploymentException( RuntimehostMessages.MOIN_ARCHIVE_HEADER_NOT_SET, new Object[] { this.deploymentId } );
        }

        return this.archiveHeader;
    }

    private static HashMap<String, Long> determinePartitionTimeStampFromProperties( Properties properties, Map<String, Long> partitionMap ) {

        HashMap<String, Long> partModificationTimes = new HashMap<String, Long>( partitionMap.size( ) );

        for ( String partName : partitionMap.keySet( ) ) {

            Long partModifTime = 0L;
            String partModifTimeStr = properties.getProperty( "lastModified_" + partName ); //$NON-NLS-1$
            if ( partModifTimeStr != null ) {
                partModifTime = new Long( partModifTimeStr );
                if ( partModifTime == 0 ) {
                    _log.trace( MoinSeverity.WARNING, RuntimehostMessages.PARTITION_HASH_DETERMINATION_FAILED, new Object[] { partName } );
                }
            }
            partModificationTimes.put( partName, partModifTime );
        }
        return partModificationTimes;

    }


}
