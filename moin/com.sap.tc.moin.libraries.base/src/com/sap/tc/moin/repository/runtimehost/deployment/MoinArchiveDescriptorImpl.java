/**
 * 
 */
package com.sap.tc.moin.repository.runtimehost.deployment;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.sap.tc.moin.repository.metamodels.MetaModelVersion;
import com.sap.tc.moin.repository.runtimehost.MmInfoConst;
import com.sap.tc.moin.repository.runtimehost.RuntimehostMessages;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;


/**
 * Utility class for handling properties of meta-model content archives.
 * <p>
 * This class provides basic functionality for reading and storing meta-model
 * archive properties as well as accessing them at runtime.
 */
public class MoinArchiveDescriptorImpl {

    public enum ArchiveFormatVersion {
        VERSION_1, VERSION_2, UNKNOWN_VERSION;
    };

    private static MoinLogger _log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_RUNTIME_HOST, MoinLocationEnum.MOIN_METAMODELS, MoinArchiveDescriptorImpl.class );

    public MoinArchiveDescriptorImpl( IpiMetamodelArchiveAccess archiveAccess ) {

    }

    private MetaModelArchiveDescriptor metamodelArchiveDescriptor;

    private ModelstorageRegistrationRecord modelStorageRecord;

    private ErrorHandlerRegistrationRecord errorHandlerRegistrationRecord;

    private TextVerticalizationRegistrationRecord s2xRegistration;

    private ArchiveFormatVersion archiveFormatVersion = ArchiveFormatVersion.UNKNOWN_VERSION;

    private MoinArchiveHeader archiveHeader;

    private ModelContentSelectionRecord customContentSelection;

    private List<String> deployedResources = new ArrayList<String>( );

    /**
     * Loads all property and registration files from the archive.
     * 
     * @param archiveAccess
     * @return
     */
    public void load( IpiMetamodelArchiveAccess archiveAccess ) {

        // if there is no metamodel, the metamodelArchiveDescriptor remains null
        switch ( this.getArchiveFormatVersion( archiveAccess ) ) {
            case VERSION_2:
                // version 2 is checked via the existence of moinarch.properties
                // this does not necessarily mean that there is a metamodel -> use return value
                this.archiveHeader = this.loadNewArchiveProperties( archiveAccess );
                MetaModelArchiveDescriptor mmArchiveDescriptor = new MetaModelArchiveDescriptor( this.archiveHeader, archiveAccess.getArchiveId( ) );
                if ( mmArchiveDescriptor.loadV2( archiveAccess ) ) {
                    this.metamodelArchiveDescriptor = mmArchiveDescriptor;
                    this.deployedResources.add( MmInfoConst.MM2_METAMODEL_XML_FILE_NAME );
                }
                break;
            case VERSION_1:
                // version 1 is check via the existence of the metamodel.properties
                // if it exists, there is always a metamodel
                this.metamodelArchiveDescriptor = new MetaModelArchiveDescriptor( archiveAccess.getArchiveId( ) );
                this.metamodelArchiveDescriptor.load( archiveAccess );
                this.getArchivePropertiesFromMetamodel( );
                this.deployedResources.add( MmInfoConst.MM_PROPERTIES_FILE_NAME );
                break;
            default:
                throw new MoinDeploymentException( RuntimehostMessages.ARCHIVE_VERSION_UNKNOWN, new Object[] { archiveAccess.getArchiveId( ) } );
        }

        // load registration files other than metamodel files
        this.loadRegistrationFiles( archiveAccess );

    }

    private void getArchivePropertiesFromMetamodel( ) {

        this.archiveHeader = this.metamodelArchiveDescriptor.getArchiveHeader( );
    }

    private MoinArchiveHeader loadNewArchiveProperties( IpiMetamodelArchiveAccess archiveAccess ) {

        InputStream inputStream = null;

        try {

            inputStream = archiveAccess.getResourceAsStream( MmInfoConst.MM2_PROPERTIES_FILE_NAME );

            if ( inputStream == null ) {
                throw new MoinDeploymentException( RuntimehostMessages.FILE_NOT_FOUND, new Object[] { MmInfoConst.MM2_PROPERTIES_FILE_NAME } );
            }

            Properties properties = new Properties( );
            properties.load( inputStream );

            // assign properties to internal values
            String dcNameFromMMProperties = properties.getProperty( MmInfoConst.MM2_ID );
            if ( dcNameFromMMProperties == null || dcNameFromMMProperties.length( ) == 0 ) {
                Object[] params = new Object[] { MmInfoConst.MM2_ID, MmInfoConst.MM2_PROPERTIES_FILE_NAME, archiveAccess.getArchiveId( ) };
                _log.trace( MoinSeverity.FATAL, RuntimehostMessages.METAMODEL_CONTAINER_NOT_SET, params );
                throw new MoinDeploymentException( RuntimehostMessages.METAMODEL_CONTAINER_NOT_SET, params );
            }

            String vendor = properties.getProperty( MmInfoConst.MM2_VENDOR );
            if ( vendor == null || vendor.length( ) == 0 ) {
                Object[] params = new Object[] { MmInfoConst.MM2_VENDOR, MmInfoConst.MM2_PROPERTIES_FILE_NAME, archiveAccess.getArchiveId( ) };
                _log.trace( MoinSeverity.FATAL, RuntimehostMessages.METAMODEL_VENDOR_NOT_SET, params );
                throw new MoinDeploymentException( RuntimehostMessages.METAMODEL_VENDOR_NOT_SET, params );
            }

            String label = properties.getProperty( MmInfoConst.MM2_LABEL );
            if ( label == null || label.length( ) == 0 ) {
                Object[] params = new Object[] { MmInfoConst.MM2_LABEL, MmInfoConst.MM2_PROPERTIES_FILE_NAME, archiveAccess.getArchiveId( ) };
                _log.trace( MoinSeverity.FATAL, RuntimehostMessages.METAMODEL_LABEL_NOT_SET, params );
                throw new MoinDeploymentException( RuntimehostMessages.METAMODEL_LABEL_NOT_SET, params );
            }

            MetaModelVersion version = new MetaModelVersionImpl( properties.getProperty( MmInfoConst.MM2_VERSION ) );
            if ( version == null || version.toString( ).length( ) == 0 ) {
                _log.trace( MoinSeverity.FATAL, RuntimehostMessages.METAMODEL_VERSION_NOT_SET, new Object[] { MmInfoConst.MM2_VERSION, MmInfoConst.MM2_PROPERTIES_FILE_NAME, archiveAccess.getArchiveId( ) } );
                // TODO tolerance?
                //throw new TempDeploymentException( this.lastErrorMessage );
            }

            this.archiveHeader = new MoinArchiveHeader( dcNameFromMMProperties, label, vendor, version );

            return this.archiveHeader;
        } catch ( IOException e ) {
            _log.trace( e, MoinSeverity.ERROR, RuntimehostMessages.FILE_PROBLEMS, new Object[] { MmInfoConst.MM2_PROPERTIES_FILE_NAME, archiveAccess.getArchiveId( ) } );
            throw new MoinDeploymentException( e, RuntimehostMessages.FILE_PROBLEMS, new Object[] { MmInfoConst.MM2_PROPERTIES_FILE_NAME, archiveAccess.getArchiveId( ) } );
        } finally {
            if ( inputStream != null ) {
                try {
                    inputStream.close( );
                } catch ( IOException e ) {
                    _log.trace( e, MoinSeverity.ERROR, RuntimehostMessages.FILE_PROBLEMS, new Object[] { MmInfoConst.MM2_PROPERTIES_FILE_NAME, archiveAccess.getArchiveId( ) } );
                    throw new MoinDeploymentException( e, RuntimehostMessages.FILE_PROBLEMS, new Object[] { MmInfoConst.MM2_PROPERTIES_FILE_NAME, archiveAccess.getArchiveId( ) } );
                }
            }

        }

    }


    public MoinArchiveHeader getArchiveHeader( ) {

        return archiveHeader;
    }

    /**
     * Determines version of metamodel format.
     * 
     * @param archiveAccess
     * @return
     * @throws IOException
     */
    private ArchiveFormatVersion getArchiveFormatVersion( IpiMetamodelArchiveAccess archiveAccess ) {

        if ( archiveAccess.resourceExists( MmInfoConst.MM2_PROPERTIES_FILE_NAME ) ) {
            this.archiveFormatVersion = ArchiveFormatVersion.VERSION_2;
        } else if ( archiveAccess.resourceExists( MmInfoConst.MM_PROPERTIES_FILE_NAME ) ) {
            this.archiveFormatVersion = ArchiveFormatVersion.VERSION_1;
        }

        return this.archiveFormatVersion;
    }

    public ArchiveFormatVersion getArchiveFormatVersion( ) {

        return this.archiveFormatVersion;
    }

    private void loadRegistrationFiles( IpiMetamodelArchiveAccess archive ) {

        // register parser/serializer
        InputStream cpsRegistration = null;
        try {
            cpsRegistration = archive.getResourceAsStream( MmInfoConst.MM_STORAGE_INF_FILE_NAME );
            if ( cpsRegistration != null ) {

                try {
                    this.modelStorageRecord = new ModelstorageRegistrationRecord( );

                    this.modelStorageRecord.parse( cpsRegistration );
                    this.deployedResources.add( MmInfoConst.MM_STORAGE_INF_FILE_NAME );
                } finally {
                    cpsRegistration.close( );
                }

            } else {
                _log.trace( MoinSeverity.DEBUG, RuntimehostMessages.NO_CUSTOM_PARSER, new Object[] { MmInfoConst.MM_STORAGE_INF_FILE_NAME } );
            }
        } catch ( IOException e ) {
            Object[] args = new Object[] { MmInfoConst.MM_STORAGE_INF_FILE_NAME, archive.getArchiveId( ) };
            _log.trace( e, MoinSeverity.ERROR, RuntimehostMessages.FILE_PROBLEMS, args );
            throw new MoinDeploymentException( e, RuntimehostMessages.FILE_PROBLEMS, args );
        } catch ( SAXException e ) {
            Object[] args = new Object[] { MmInfoConst.MM_STORAGE_INF_FILE_NAME, archive.getArchiveId( ), e.getMessage( ) };
            _log.trace( e, MoinSeverity.ERROR, RuntimehostMessages.PARSE_PROBLEMS, args );
            throw new MoinDeploymentException( e, RuntimehostMessages.PARSE_PROBLEMS, args );
        } catch ( ParserConfigurationException e ) {
            Object[] args = new Object[] { MmInfoConst.MM_STORAGE_INF_FILE_NAME, archive.getArchiveId( ), e.getMessage( ) };
            _log.trace( e, MoinSeverity.ERROR, RuntimehostMessages.PARSE_PROBLEMS, args );
            throw new MoinDeploymentException( e, RuntimehostMessages.PARSE_PROBLEMS, args );
        }

        try {
            // register error handler
            InputStream errorHandlerRegistration = null;

            errorHandlerRegistration = archive.getResourceAsStream( MmInfoConst.ERROR_HANDLER_INF_FILE_NAME );
            if ( errorHandlerRegistration != null ) {

                try {
                    this.errorHandlerRegistrationRecord = new ErrorHandlerRegistrationRecord( );

                    this.errorHandlerRegistrationRecord.parse( errorHandlerRegistration );
                    this.deployedResources.add( MmInfoConst.ERROR_HANDLER_INF_FILE_NAME );
                } finally {
                    errorHandlerRegistration.close( );
                }

            } else {
                _log.trace( MoinSeverity.INFO, RuntimehostMessages.NO_ERRORHANDLER, new Object[] { MmInfoConst.ERROR_HANDLER_INF_FILE_NAME } );
            }
        } catch ( IOException e ) {
            Object[] args = new Object[] { MmInfoConst.ERROR_HANDLER_INF_FILE_NAME, archive.getArchiveId( ) };
            _log.trace( e, MoinSeverity.ERROR, RuntimehostMessages.FILE_PROBLEMS, args );
            throw new MoinDeploymentException( e, RuntimehostMessages.FILE_PROBLEMS, args );
        } catch ( SAXException e ) {
            Object[] args = new Object[] { MmInfoConst.ERROR_HANDLER_INF_FILE_NAME, archive.getArchiveId( ), e.getMessage( ) };
            _log.trace( e, MoinSeverity.ERROR, RuntimehostMessages.PARSE_PROBLEMS, args );
            throw new MoinDeploymentException( e, RuntimehostMessages.PARSE_PROBLEMS, args );
        } catch ( ParserConfigurationException e ) {
            Object[] args = new Object[] { MmInfoConst.ERROR_HANDLER_INF_FILE_NAME, archive.getArchiveId( ), e.getMessage( ) };
            _log.trace( e, MoinSeverity.ERROR, RuntimehostMessages.PARSE_PROBLEMS, args );
            throw new MoinDeploymentException( e, RuntimehostMessages.PARSE_PROBLEMS, args );
        }

        try {
            // register tv callbacks
            InputStream tvCallbackRegistration = null;

            tvCallbackRegistration = archive.getResourceAsStream( MmInfoConst.S2X_CALLBACK_INF_FILE_NAME );
            if ( tvCallbackRegistration != null ) {

                try {
                    this.s2xRegistration = new TextVerticalizationRegistrationRecord( );

                    this.s2xRegistration.parse( tvCallbackRegistration );
                    this.deployedResources.add( MmInfoConst.S2X_CALLBACK_INF_FILE_NAME );
                } finally {
                    tvCallbackRegistration.close( );
                }

            } else {
                _log.trace( MoinSeverity.INFO, RuntimehostMessages.NO_S2X_CALLBACK, new Object[] { MmInfoConst.S2X_CALLBACK_INF_FILE_NAME } );
            }
        } catch ( IOException e ) {
            Object[] args = new Object[] { MmInfoConst.S2X_CALLBACK_INF_FILE_NAME, archive.getArchiveId( ) };
            _log.trace( e, MoinSeverity.ERROR, RuntimehostMessages.FILE_PROBLEMS, args );
            throw new MoinDeploymentException( e, RuntimehostMessages.FILE_PROBLEMS, args );
        } catch ( SAXException e ) {
            Object[] args = new Object[] { MmInfoConst.S2X_CALLBACK_INF_FILE_NAME, archive.getArchiveId( ), e.getMessage( ) };
            _log.trace( e, MoinSeverity.ERROR, RuntimehostMessages.PARSE_PROBLEMS, args );
            throw new MoinDeploymentException( e, RuntimehostMessages.PARSE_PROBLEMS, args );
        } catch ( ParserConfigurationException e ) {
            Object[] args = new Object[] { MmInfoConst.S2X_CALLBACK_INF_FILE_NAME, archive.getArchiveId( ) };
            _log.trace( e, MoinSeverity.ERROR, RuntimehostMessages.PARSE_PROBLEMS, args );
            throw new MoinDeploymentException( e, RuntimehostMessages.PARSE_PROBLEMS, args );
        }

        try {
            // parse custom content selection registration
            InputStream contentSelectionRegistration = null;

            contentSelectionRegistration = archive.getResourceAsStream( MmInfoConst.CUSTOM_CONTENT_SELECTION_INF_FILE_NAME );
            if ( contentSelectionRegistration != null ) {

                try {
                    this.customContentSelection = new ModelContentSelectionRecord( );

                    this.customContentSelection.parse( contentSelectionRegistration );
                    this.deployedResources.add( MmInfoConst.CUSTOM_CONTENT_SELECTION_INF_FILE_NAME );
                } finally {
                    contentSelectionRegistration.close( );
                }

            } else {
                _log.trace( MoinSeverity.INFO, RuntimehostMessages.NO_CUSTOM_CONTENT_SELECTION, new Object[] { MmInfoConst.CUSTOM_CONTENT_SELECTION_INF_FILE_NAME } );
            }
        } catch ( IOException e ) {
            Object[] args = new Object[] { MmInfoConst.CUSTOM_CONTENT_SELECTION_INF_FILE_NAME, archive.getArchiveId( ) };
            _log.trace( e, MoinSeverity.ERROR, RuntimehostMessages.FILE_PROBLEMS, args );
            throw new MoinDeploymentException( e, RuntimehostMessages.FILE_PROBLEMS, args );
        } catch ( SAXException e ) {
            Object[] args = new Object[] { MmInfoConst.CUSTOM_CONTENT_SELECTION_INF_FILE_NAME, archive.getArchiveId( ), e.getMessage( ) };
            _log.trace( e, MoinSeverity.ERROR, RuntimehostMessages.PARSE_PROBLEMS, args );
            throw new MoinDeploymentException( e, RuntimehostMessages.PARSE_PROBLEMS, args );
        } catch ( ParserConfigurationException e ) {
            Object[] args = new Object[] { MmInfoConst.CUSTOM_CONTENT_SELECTION_INF_FILE_NAME, archive.getArchiveId( ), e.getMessage( ) };
            _log.trace( e, MoinSeverity.ERROR, RuntimehostMessages.PARSE_PROBLEMS, args );
            throw new MoinDeploymentException( e, RuntimehostMessages.PARSE_PROBLEMS, args );
        }
    }

    public ModelstorageRegistrationRecord getModelStorageRecord( ) {

        return modelStorageRecord;
    }


    public ErrorHandlerRegistrationRecord getErrorHandlerRegistrationRecord( ) {

        return errorHandlerRegistrationRecord;
    }


    public TextVerticalizationRegistrationRecord getS2xRegistrationRecord( ) {

        return s2xRegistration;
    }



    public MetaModelArchiveDescriptor getMetamodelArchiveDescriptor( ) {

        return metamodelArchiveDescriptor;
    }

    public ModelContentSelectionRecord getModelContentSelectionRecord( ) {

        return this.customContentSelection;
    }


    public List<String> getDeployedResources( ) {

        return deployedResources;
    }

}
