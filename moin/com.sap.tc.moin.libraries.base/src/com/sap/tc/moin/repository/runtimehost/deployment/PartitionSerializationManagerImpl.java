package com.sap.tc.moin.repository.runtimehost.deployment;

import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.JMX_ENABLED;
import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.MOIN_DOMAIN;
import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.registerBroadcastingMBean;
import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.unregisterMBean;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicLong;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import javax.management.MBeanNotificationInfo;
import javax.management.MalformedObjectNameException;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import javax.management.ObjectName;
import javax.management.openmbean.CompositeData;
import javax.management.openmbean.CompositeDataSupport;
import javax.management.openmbean.CompositeType;
import javax.management.openmbean.OpenDataException;
import javax.management.openmbean.OpenType;
import javax.management.openmbean.SimpleType;
import javax.management.openmbean.TabularData;
import javax.management.openmbean.TabularDataSupport;
import javax.management.openmbean.TabularType;

import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.InvalidResourceIdentifierException;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.jmx.CpsMBean;
import com.sap.tc.moin.repository.runtimehost.MmInfoConst;
import com.sap.tc.moin.repository.runtimehost.RuntimehostMessages;
import com.sap.tc.moin.repository.runtimehost.deployment.ErrorHandlerRegistrationRecord.ErrorHandlerRecord;
import com.sap.tc.moin.repository.runtimehost.deployment.ErrorHandlerRegistry.VersionInterval;
import com.sap.tc.moin.repository.s2x.S2XSerializer;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.shared.util.WeakReferenceWithObjectName;
import com.sap.tc.moin.repository.spi.core.SpiMoin;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;
import com.sap.tc.moin.repository.spi.ps.SpiAssociation;
import com.sap.tc.moin.repository.spi.ps.SpiCustomParserSerializerFactory;
import com.sap.tc.moin.repository.spi.ps.SpiXmParserSerializerConfiguration;
import com.sap.tc.moin.repository.spi.ps.errorhandler.SpiParserErrorHandler;
import com.sap.tc.moin.repository.spi.ps.parser.SpiCustomParser;
import com.sap.tc.moin.repository.spi.ps.parser.SpiElement;
import com.sap.tc.moin.repository.spi.ps.parser.SpiParserCallback;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiCustomSerializer;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiSerializerCallback;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiCustomContentSelectionManagement;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiCustomContentSelectionManagement.CheckResult;
import com.sap.tc.moin.repository.spi.s2x.serializer.SpiS2XDocument;
import com.sap.tc.moin.repository.spi.s2x.serializer.SpiS2XSerializerCustomCallback;
import com.sap.tc.moin.repository.spi.util.SpiMutableInteger;
import com.sap.tc.moin.xm.cps.XmCpsFactory;

/**
 * Implementation of the partition serialization manager. The manager keeps a
 * registry for all custom parsers/serializers, error handlers and s2x callback
 * implementations.<br>
 * 
 * @author d026715
 */
public class PartitionSerializationManagerImpl implements SpiPartitionSerializationManager {

    private static final String EMPTY_PREFIX = ""; //$NON-NLS-1$

    protected static final MoinLogger log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_RUNTIME_HOST, MoinLocationEnum.MOIN_RUNTIMHOST, PartitionSerializationManagerImpl.class );

    // parser registry
    Map<String /* serialization id */, InstanceReferenceImpl<SpiCustomParserSerializerFactory>> cpsRegistry = new HashMap<String, InstanceReferenceImpl<SpiCustomParserSerializerFactory>>( );

    /*
     * Registry for errorhandlers
     */
    ErrorHandlerRegistry<InstanceReferenceImpl<SpiParserErrorHandler>> criEhRegistry = new ErrorHandlerRegistry<InstanceReferenceImpl<SpiParserErrorHandler>>( );

    /*
     * registry for custom serialization ids - approach for now, might be
     * replaced by a more complex mapping
     */
    PriPatternRegistry cpsPatternRegistry = new PriPatternRegistry( );

    /*
     * Registry for textverticalization callbacks.
     */
    Map<String /* container */, InstanceReferenceImpl<SpiS2XSerializerCustomCallback>> tvCallbackRegistry = new HashMap<String, InstanceReferenceImpl<SpiS2XSerializerCustomCallback>>( );

    /**
     * Content selection registration table. <br>
     * SelectionType -* DeploymentId -* Collection -* Properties
     */
    Map<String /* selection type */, Map<String /* deployment id */, Collection<Properties>>> modelContentSelectionCriteria = new HashMap<String, Map<String, Collection<Properties>>>( );

    /**
     * Deployment state. Contains the deployed archive elements except the
     * built-in parser.
     */
    private Map<String /* deployment id */, List<RegistrationRecordBase>> deployedElements = new HashMap<String, List<RegistrationRecordBase>>( );

    /**
     * Deployed classes as instance references.
     */
    private Map<String, Collection<IpiInstanceReference>> deployedClasses = new HashMap<String, Collection<IpiInstanceReference>>( );

    /**
     * The name identifying this PartitionSerializationManagerImpl instance in
     * JMX.
     */
    private ObjectName objectName;

    /**
     * The MBean instance that gets registered in the MBeanServer. We need it
     * for the emission of JMX notifications.
     */
    private JmxAdapter jmxAdapter;

    /**
     * Whether the emission of JMX notifications is currently enabled.
     */
    public volatile boolean jmxNotificationsEnabled;

    SpiMoin moin;

    /**
     * Standard constructor.
     * 
     * @param moin
     */
    public PartitionSerializationManagerImpl( SpiMoin moin ) {

        this.moin = moin;

        if ( JMX_ENABLED && moin != null ) {

            // Start our MBean.
            try {
                objectName = new ObjectName( MOIN_DOMAIN + "type=PartitionSerializationManager,moin=" + moin.getId( ) ); //$NON-NLS-1$
            } catch ( MalformedObjectNameException e ) {
                throw new RuntimeException( e );
            }
            jmxAdapter = new JmxAdapter( this, objectName, moin.getCore( ).getReferenceQueue( ) );
        }
    }

    /**
     * Registers the following elements of a moin archive: <br>
     * <ul>
     * <li>Custom parser/serializer (modelstorage.xml)</li>
     * <li>Error handler (errorhandler.xml)</li>
     * <li>S2X callback (textverticalization.xml)</li>
     * <li>Custom model content registration / additional DC types
     * (modelcontentselection.xml)</li>
     * </ul>
     * The deployment id used here can be arbitrary but must be unique. It is
     * used to unregister all associated content again.
     * 
     * @param deploymentId Unique deployment id
     * @param archiveDescriptor Archive
     * @param loader Environment specific class loader
     */
    public void registerMetamodelArchive( String deploymentId, MoinArchiveDescriptorImpl archiveDescriptor ) {

        // check deployment id
        if ( deploymentId == null ) {
            throw new MoinDeploymentException( RuntimeHostDeploymentMessages.DEPLOYMENT_ID_NULL );
        }
        // check if default parser is registered
        if ( this.cpsRegistry.get( SpiCustomParserSerializerFactory.DEFAULT_SERIALIZATION ) == null ) {
            throw new MoinDeploymentException( RuntimeHostDeploymentMessages.DEFAULT_PARSER_NOT_REGISTERED );
        }

        ModelstorageRegistrationRecord modelStorageRegistration = archiveDescriptor.getModelStorageRecord( );
        // register parser/serializer     
        if ( modelStorageRegistration != null ) {
            if ( !this.registerModelstorage( deploymentId, modelStorageRegistration ) ) {
                throw new MoinDeploymentException( RuntimehostMessages.REGISTRATION_FAILED, new Object[] { MmInfoConst.MM_STORAGE_INF_FILE_NAME, deploymentId } );
            }
        }

        // register error handler        
        ErrorHandlerRegistrationRecord errorHandlerRegistration = archiveDescriptor.getErrorHandlerRegistrationRecord( );
        if ( errorHandlerRegistration != null ) {
            if ( !this.registerParserErrorHandler( deploymentId, errorHandlerRegistration ) ) {
                throw new MoinDeploymentException( RuntimehostMessages.REGISTRATION_FAILED, new Object[] { MmInfoConst.ERROR_HANDLER_INF_FILE_NAME, deploymentId } );
            }
        }

        // register tv callbacks
        TextVerticalizationRegistrationRecord tvCallbackRegistration = archiveDescriptor.getS2xRegistrationRecord( );
        if ( tvCallbackRegistration != null ) {
            if ( !this.registerS2XCallbacks( deploymentId, archiveDescriptor.getArchiveHeader( ).getContainerName( ), tvCallbackRegistration ) ) {
                throw new MoinDeploymentException( RuntimehostMessages.REGISTRATION_FAILED, new Object[] { MmInfoConst.S2X_CALLBACK_INF_FILE_NAME, deploymentId } );
            }
        }

        // register model content selection criteria
        ModelContentSelectionRecord contentSelectionRecord = archiveDescriptor.getModelContentSelectionRecord( );

        if ( contentSelectionRecord != null ) {
            if ( !this.registerCustomContentSelection( deploymentId, contentSelectionRecord ) ) {
                throw new MoinDeploymentException( RuntimehostMessages.REGISTRATION_FAILED, new Object[] { MmInfoConst.CUSTOM_CONTENT_SELECTION_INF_FILE_NAME, deploymentId } );
            }

            // check content selection criteria
            this.checkContentSelectionCriteria( this.moin, deploymentId );
        }
    }

    /**
     * Registration of custom parsers/serializers without xml. Currently used to
     * add the default parser/serializer at startup.
     * 
     * @param parserSerializerId
     * @param fileSuffixes
     * @param dcTypeCollection
     * @param cpsFactory
     */
    public void registerParserSerializer( String parserSerializerId, String[] fileSuffixes, SpiCustomParserSerializerFactory cpsFactory ) {

        String idToRegister = parserSerializerId;
        for ( String suffix : fileSuffixes ) {

            if ( idToRegister == null ) {
                idToRegister = SpiCustomParserSerializerFactory.DEFAULT_SERIALIZATION;
            }

            // register suffixes for id
            if ( this.cpsPatternRegistry.get( EMPTY_PREFIX, suffix ) == null ) {
                this.cpsPatternRegistry.put( EMPTY_PREFIX, suffix, idToRegister );
            } else if ( log.isTraced( MoinSeverity.WARNING ) ) {
                log.trace( MoinSeverity.WARNING, RuntimehostMessages.PATTERN_ALREADY_REGISTERED, new Object[] { suffix, idToRegister } );
            }

        }

        // register id
        if ( cpsFactory != null ) {
            InstanceReferenceImpl<SpiCustomParserSerializerFactory> ref = new InstanceReferenceImpl<SpiCustomParserSerializerFactory>( cpsFactory.getClass( ).getName( ) );
            ref.setInstance( cpsFactory );
            this.cpsRegistry.put( idToRegister, ref );
            // these references do not need to be added to the list of deployed classes since they are already instantiated and must not
            // be unloaded
        }

        if ( log.isTraced( MoinSeverity.DEBUG ) ) {
            log.trace( MoinSeverity.DEBUG, RuntimehostMessages.PATTERN_REGISTRATION_SUCCESSFUL, new Object[] { idToRegister, fileSuffixes } );
        }
    }

    /**
     * Registration of custom parser/serializer using the configuration xml.
     * 
     * @param deploymentId Generic deployment id
     * @param registrationFile Stream containing the registration as xml
     * @param loader Class loader interface that allows to instantiate the
     * custom parser/serializer classes
     * @return True if registration was successful
     */
    public boolean registerModelstorage( String deploymentId, ModelstorageRegistrationRecord registrationRecord ) {

        try {

            Map<String /* serialization id */, String /* class name */> customParsers = registrationRecord.getCustomParsers( );
            Map<PriPattern, String> patterns = registrationRecord.getPatterns( );

            // precondition check, all or nothing
            for ( String serializationId : customParsers.keySet( ) ) {
                // already registered ?
                if ( this.cpsRegistry.containsKey( serializationId ) ) {
                    log.trace( MoinSeverity.ERROR, RuntimehostMessages.SERIALIZATION_ID_COLLISION, new Object[] { serializationId, this.cpsRegistry.get( serializationId ).getClass( ).getName( ), deploymentId } );
                    return false;
                }
            }

            for ( PriPattern pattern : patterns.keySet( ) ) {
                if ( this.cpsPatternRegistry.get( pattern.getPrefix( ), pattern.getSuffix( ) ) != null ) {
                    log.trace( MoinSeverity.ERROR, RuntimeHostDeploymentMessages.PATTERN_COLLISION, new Object[] { pattern, this.cpsPatternRegistry.get( pattern.getPrefix( ), pattern.getSuffix( ) ), deploymentId } );
                    return false;
                }
            }

            // situation: none of the suffixes or serialization ids is existing
            // continue with registration

            // register parser/serializer factories
            for ( Entry<String, String> entry : customParsers.entrySet( ) ) {
                String serializationId = entry.getKey( );

                // get the class name of the serialization factory
                String className = entry.getValue( );

                // register instance
                InstanceReferenceImpl<SpiCustomParserSerializerFactory> ref = new CpsInstanceReferenceImpl( className );
                this.cpsRegistry.put( serializationId, ref );
                this.addToRegisteredClasses( deploymentId, ref );
            }

            for ( Entry<PriPattern, String> entry : patterns.entrySet( ) ) {
                PriPattern pattern = entry.getKey( );
                String serializationId = entry.getValue( );
                if ( ModelstorageRegistrationRecord.NO_SERIALIZATION_ID.equals( serializationId ) ) {
                    serializationId = SpiCustomParserSerializerFactory.DEFAULT_SERIALIZATION;
                }
                this.cpsPatternRegistry.put( pattern.getPrefix( ), pattern.getSuffix( ), serializationId );
            }

            this.addToDeploymentRegister( deploymentId, registrationRecord );

            return true;
        } catch ( Exception e ) {
            if ( log.isTraced( MoinSeverity.ERROR ) ) {
                log.trace( e, MoinSeverity.ERROR, RuntimehostMessages.CPS_REGISTRATION_FAILED, deploymentId );
            }
            return false;
        }
    }

    /**
     * Unregisters all elements contained in the model storage registration
     * record.
     * 
     * @param registrationContent Parsed registration file
     */
    public void unregister( String deploymentId, ModelstorageRegistrationRecord registrationContent ) {

        Map<String, String> customParsers = registrationContent.getCustomParsers( );
        Map<PriPattern, String> patterns = registrationContent.getPatterns( );

        for ( String serializationId : customParsers.keySet( ) ) {
            this.cpsRegistry.remove( serializationId );
        }

        for ( PriPattern pattern : patterns.keySet( ) ) {
            this.cpsPatternRegistry.remove( pattern.getPrefix( ), pattern.getSuffix( ) );
        }

    }

    /**
     * Registration of parser error handler using the registration xml.
     * 
     * @param registrationFile Stream containing the registration xml.
     */
    public boolean registerParserErrorHandler( String deploymentId, ErrorHandlerRegistrationRecord errorHandlerRegistration ) {

        try {
            Set<ErrorHandlerRecord> errorHandlers = errorHandlerRegistration.getErrorHandlers( );

            // precondition checks
            for ( ErrorHandlerRecord errorHandlerRecord : errorHandlers ) {
                String containerId = errorHandlerRecord.getContainerId( );
                if ( this.criEhRegistry.contains( containerId, errorHandlerRecord.getVersionFrom( ), errorHandlerRecord.getVersionTo( ) ) ) {
                    log.trace( MoinSeverity.ERROR, RuntimehostMessages.ERROR_HANDLER_VERSION_COLLISION, new Object[] { containerId, errorHandlerRecord.getVersionFrom( ), errorHandlerRecord.getVersionTo( ) } );
                    return false;
                }
            }

            // situation: none of the error handlers exists

            for ( ErrorHandlerRecord errorHandlerRecord : errorHandlers ) {
                String containerId = errorHandlerRecord.getContainerId( );

                String className = errorHandlerRecord.getClassName( );

                // register instance reference
                InstanceReferenceImpl<SpiParserErrorHandler> instanceReference = new InstanceReferenceImpl<SpiParserErrorHandler>( className );
                this.criEhRegistry.put( containerId, errorHandlerRecord.getVersionFrom( ), errorHandlerRecord.getVersionTo( ), instanceReference );
                this.addToRegisteredClasses( deploymentId, instanceReference );
            }

            this.addToDeploymentRegister( deploymentId, errorHandlerRegistration );
            return true;
        } catch ( Exception ex ) {
            log.trace( ex, MoinSeverity.ERROR, RuntimehostMessages.EH_REGISTRATION_FAILED, deploymentId );
            return false;
        }

    }

    /**
     * Unregisters all elements contained in the error handler registration
     * record.
     * 
     * @param registrationContent Parsed registration file
     */
    public void unregister( String deploymentId, ErrorHandlerRegistrationRecord errorHandlerRegistration ) {

        Set<ErrorHandlerRecord> errorHandlers = errorHandlerRegistration.getErrorHandlers( );

        // remove it
        for ( ErrorHandlerRecord errorHandlerRecord : errorHandlers ) {
            this.criEhRegistry.remove( errorHandlerRecord.getContainerId( ), errorHandlerRecord.getVersionFrom( ), errorHandlerRecord.getVersionTo( ) );
        }

    }

    /**
     * Registration of text verticalization callbacks using the configuration
     * xml.
     * 
     * @param registrationFile Stream containing the registration xml.
     */
    public boolean registerS2XCallbacks( String deploymentId, String containerId, TextVerticalizationRegistrationRecord s2xRegistration ) {

        try {
            String callbackHandler = s2xRegistration.getTvCallbackHandler( );

            // precondition check
            if ( this.tvCallbackRegistry.containsKey( containerId ) ) {
                log.trace( MoinSeverity.ERROR, RuntimehostMessages.S2X_COLLISION, new Object[] { containerId, this.tvCallbackRegistry.get( containerId ).getClass( ).getName( ) } );
                return false;
            }

            String className = callbackHandler;

            InstanceReferenceImpl<SpiS2XSerializerCustomCallback> reference = new InstanceReferenceImpl<SpiS2XSerializerCustomCallback>( className );
            this.tvCallbackRegistry.put( containerId, reference );
            this.addToRegisteredClasses( deploymentId, reference );

            // add container id for undeployment
            s2xRegistration.setContainerId( containerId );
            this.addToDeploymentRegister( deploymentId, s2xRegistration );

            return true;
        } catch ( Exception ex ) {
            log.trace( ex, MoinSeverity.ERROR, RuntimehostMessages.S2X_REGISTRATION_FAILED );
            return false;
        }

    }

    /**
     * Unregisters all elements contained in the s2x callback registration
     * record.
     * 
     * @param registrationContent Parsed registration file
     */
    public void unregister( String deploymentId, TextVerticalizationRegistrationRecord s2xRegistration ) {

        if ( s2xRegistration.getContainerId( ) != null ) {
            this.tvCallbackRegistry.remove( s2xRegistration.getContainerId( ) );
        } else {
            throw new IllegalStateException( "No container id set to unregister s2x callback" ); //$NON-NLS-1$
        }
    }

    /**
     * Registers the generic custom model content selection criteria.
     * 
     * @param deploymentId
     * @param customContentSelectionRegistrationRecord
     */
    public boolean registerCustomContentSelection( String deploymentId, ModelContentSelectionRecord customContentSelectionRegistrationRecord ) {

        Map<String, Collection<Properties>> selectionCriteria = customContentSelectionRegistrationRecord.getSelectionCriteria( );

        for ( Entry<String, Collection<Properties>> entry : selectionCriteria.entrySet( ) ) {
            String type = entry.getKey( );
            Collection<Properties> propertyCollection = entry.getValue( );

            Map<String, Collection<Properties>> criteriaByType = this.modelContentSelectionCriteria.get( type );
            if ( criteriaByType == null ) {
                criteriaByType = new HashMap<String, Collection<Properties>>( 1 );
                this.modelContentSelectionCriteria.put( type, criteriaByType );
            }

            criteriaByType.put( deploymentId, propertyCollection );
        }

        this.addToDeploymentRegister( deploymentId, customContentSelectionRegistrationRecord );

        return true;
    }

    /**
     * Calls the lifecycle management of the facility to check the content
     * selection criteria.
     * 
     * @param moin
     * @param deploymentId
     * @throws MoinDeploymentException If the check returns severe problems.
     */
    public void checkContentSelectionCriteria( SpiMoin moin, String deploymentId ) {

        // the check is done for all facilities
        Collection<Facility> facilities = moin.getFacilities( );
        for ( Facility facility : facilities ) {
            SpiCustomContentSelectionManagement customContentSelectionManagement = ( (SpiFacility) facility ).getCustomContentSelectionManagement( );

            // the check calls the content selection management (e. g. the DI service) which then retrieves the newly registered
            // content selection criteria with the suitable type and checks it
            // if the check fails, an exception is thrown which causes the undeployment of the archive
            CheckResult checkResult = customContentSelectionManagement.checkContentSelectionProperties( );
            Collection<MoinIllegalArgumentException> warnings = checkResult.getWarnings( );
            for ( MoinIllegalArgumentException warningException : warnings ) {
                log.trace( MoinSeverity.WARNING, warningException.getLocalizedMessage( ), warningException );
            }
            Collection<MoinIllegalArgumentException> errors = checkResult.getErrors( );
            for ( MoinIllegalArgumentException errorException : errors ) {
                log.trace( MoinSeverity.WARNING, errorException.getLocalizedMessage( ), errorException );
            }
            if ( checkResult.getSeverity( ) >= MoinSeverity.ERROR.severity( ) ) {
                throw new MoinDeploymentException( RuntimehostMessages.REGISTRATION_FAILED, new Object[] { MmInfoConst.CUSTOM_CONTENT_SELECTION_INF_FILE_NAME, deploymentId } );
            }
        }
    }

    /**
     * Unregisters the custom model content selection criteria for the given
     * deployment id.
     * 
     * @param deploymentId
     * @param registrationContent
     */
    private void unregister( String deploymentId, ModelContentSelectionRecord registrationContent ) {

        Iterator<String> iterator = this.modelContentSelectionCriteria.keySet( ).iterator( );
        while ( iterator.hasNext( ) ) {
            String type = iterator.next( );
            Map<String, Collection<Properties>> criteriaByType = this.modelContentSelectionCriteria.get( type );
            criteriaByType.remove( deploymentId );
            if ( criteriaByType.size( ) == 0 ) {
                iterator.remove( );
            }
        }
    }

    private void addToDeploymentRegister( String deploymentId, RegistrationRecordBase element ) {

        List<RegistrationRecordBase> elements = this.deployedElements.get( deploymentId );
        if ( elements == null ) {
            elements = new ArrayList<RegistrationRecordBase>( );
            this.deployedElements.put( deploymentId, elements );
        }
        elements.add( element );
    }

    /**
     * Unregisters all elements that were deployed using the given deployment
     * id.
     * 
     * @param deploymentId
     */
    public void unregister( String deploymentId ) {

        List<RegistrationRecordBase> entries = this.deployedElements.get( deploymentId );
        if ( entries != null ) {
            for ( RegistrationRecordBase registrationEntry : entries ) {
                this.unregisterContent( deploymentId, registrationEntry );
            }
        } else {
            log.trace( MoinSeverity.WARNING, RuntimehostMessages.UNDEPLOYED_NOT_FOUND, new Object[] { deploymentId } );
        }

        this.deployedClasses.remove( deploymentId );
    }

    /**
     * Unregisters all elements contained in the registration record.
     * 
     * @param registrationContent Parsed registration file
     */
    public void unregisterContent( String deploymentId, RegistrationRecordBase registrationContent ) {

        // for most of the unregister methods, the deployment id is not needed
        // it is forwarded here just to keep the unregister methods uniform
        if ( registrationContent instanceof ModelstorageRegistrationRecord ) {
            this.unregister( deploymentId, (ModelstorageRegistrationRecord) registrationContent );
        } else if ( registrationContent instanceof ErrorHandlerRegistrationRecord ) {
            this.unregister( deploymentId, (ErrorHandlerRegistrationRecord) registrationContent );
        } else if ( registrationContent instanceof TextVerticalizationRegistrationRecord ) {
            this.unregister( deploymentId, (TextVerticalizationRegistrationRecord) registrationContent );
        } else if ( registrationContent instanceof ModelContentSelectionRecord ) {
            this.unregister( deploymentId, (ModelContentSelectionRecord) registrationContent );
        }

    }

    /**
     *Creates the instances of the registered custom parser/serializer
     * factories, error handlers and s2x callbacks. This method is mainly used
     * by the server runtime host implementation since the classes cannot be
     * instantiated right after the registration.
     * 
     * @param listener Status listener, can be null
     * @param deploymentId Deployment id
     * @param loader Environment specific class loader
     */
    public void createInstancesOfRegisteredExtension( String deploymentId, IpiCustomSerializationClassLoader loader ) {

        Collection<IpiInstanceReference> references = this.deployedClasses.get( deploymentId );
        if ( references != null ) {
            for ( IpiInstanceReference reference : references ) {
                try {
                    reference.createInstance( loader );
                } catch ( Exception ex ) {
                    log.trace( ex, MoinSeverity.ERROR, RuntimehostMessages.CLASS_NOT_FOUND, new Object[] { reference.getClassName( ) } );
                    // undeploy whole archive if problems occur
                    this.unregister( deploymentId );
                    throw new MoinDeploymentException( ex, RuntimehostMessages.CLASS_NOT_FOUND, new Object[] { reference.getClassName( ) } );
                }

            }
        }
    }

    /**
     * Releases the instances of the registered extension classes.
     * 
     * @param deploymentId
     */
    public void releaseInstancesOfRegisteredExtension( String deploymentId ) {

        Collection<IpiInstanceReference> references = this.deployedClasses.get( deploymentId );
        if ( references != null ) {
            for ( IpiInstanceReference reference : references ) {
                reference.releaseInstance( );
            }
        }
    }

    private void addToRegisteredClasses( String deploymentId, IpiInstanceReference reference ) {

        Collection<IpiInstanceReference> classReferences = this.deployedClasses.get( deploymentId );
        if ( classReferences == null ) {
            classReferences = new HashSet<IpiInstanceReference>( 1 );
            this.deployedClasses.put( deploymentId, classReferences );
        }
        classReferences.add( reference );
    }

    /*
     * (non-Javadoc) @seecom.sap.tc.moin.repository.spi.runtimehost.cp.
     * SpiPartitionSerializationManager#getParserErrorHandler(java.lang.String,
     * java.lang.String)
     */
    public SpiParserErrorHandler getParserErrorHandler( String metamodelContainerName, String metamodelVersion ) {

        InstanceReferenceImpl<SpiParserErrorHandler> instanceReference = this.criEhRegistry.get( metamodelContainerName, metamodelVersion );
        if ( instanceReference != null ) {
            return instanceReference.getInstance( );
        }
        return null;
    }

    /*
     * (non-Javadoc) @seecom.sap.tc.moin.repository.spi.runtimehost.cp.
     * SpiPartitionSerializationManager#parse(com.sap.tc.moin.repository.PRI,
     * java.io.InputStream,
     * com.sap.tc.moin.repository.spi.ps.parser.SpiParserCallback, long)
     */
    public void parse( PRI pri, InputStream inputStream, SpiParserCallback parserCallback, long fileSize ) throws IOException {

        try {
            this.parse( getSerializationId( pri ), inputStream, parserCallback, fileSize );
        } catch ( IOException ioEx ) {
            throw ioEx;
        } catch ( AssertionError ae ) {
            throw ae;
        } catch ( Throwable t ) {
            IOException ex = new IOException( );
            ex.initCause( t );
            throw ex;
        }
    }

    public void parse( String serializationId, InputStream inputStream, SpiParserCallback parserCallback, long fileSize ) throws IOException {

        SpiCustomParser parser = getCustomParser( serializationId );
        try {
            if ( JMX_ENABLED && jmxNotificationsEnabled ) {
                long t = System.nanoTime( );
                this.partitionParsingStart( serializationId, parserCallback.getPri( ), fileSize, Thread.currentThread( ).getStackTrace( ) );
                parser.parse( inputStream, parserCallback, fileSize );
                long duration = ( System.nanoTime( ) - t ) / 1000000;
                this.partitionParsingEnd( serializationId, parserCallback.getPri( ), duration );
            } else {
                parser.parse( inputStream, parserCallback, fileSize );
            }
        } catch ( IOException ioEx ) {
            throw ioEx;
        } catch ( AssertionError ae ) {
            throw ae;
        } catch ( Throwable t ) {
            IOException ex = new IOException( );
            ex.initCause( t );
            throw ex;
        }
    }

    /**
     * Gets the parser for a serialization id. The contained checks are
     * necessary because the serialization id can be wrong when coming from a
     * delegation call.
     * 
     * @param customSerializationId
     * @return
     * @throws IOException
     */
    private SpiCustomParser getCustomParser( String customSerializationId ) throws IOException {

        // get factory
        SpiCustomParserSerializerFactory customParserSerializerFactory = this.getCustomParserSerializerFactory( customSerializationId );

        if ( customParserSerializerFactory == null ) {
            log.trace( MoinSeverity.ERROR, RuntimehostMessages.NO_SERIALIZATION_FACTORY_FOUND_FOR_ID, new Object[] { customSerializationId } );
            throw new IOException( RuntimehostMessages.NO_SERIALIZATION_FACTORY_FOUND_FOR_ID.format( new Object[] { customSerializationId } ) );
        }

        // get parser 
        SpiCustomParser parser = customParserSerializerFactory.getParser( );

        if ( parser == null ) {
            log.trace( MoinSeverity.ERROR, RuntimehostMessages.NO_PARSER, new Object[] { customParserSerializerFactory.getClass( ).getName( ) } );
            throw new IOException( RuntimehostMessages.NO_PARSER.format( new Object[] { customParserSerializerFactory.getClass( ).getName( ) } ) );
        }

        return parser;
    }

    /*
     * (non-Javadoc) @seecom.sap.tc.moin.repository.spi.runtimehost.cp.
     * SpiPartitionSerializationManager
     * #serialize(com.sap.tc.moin.repository.PRI, java.io.OutputStream,
     * com.sap.tc.moin.repository.spi.ps.serializer.SpiSerializerCallback)
     */
    public void serialize( PRI pri, OutputStream outputStream, SpiSerializerCallback serializerCallback ) throws IOException {

        // get serialization id
        String customSerializationId = this.getSerializationId( pri );

        try {
            serialize( customSerializationId, outputStream, serializerCallback );
        } catch ( IOException ioEx ) {
            throw ioEx;
        } catch ( AssertionError ae ) {
            throw ae;
        } catch ( Throwable t ) {
            IOException ex = new IOException( );
            ex.initCause( t );
            throw ex;
        }
    }

    public void serialize( String customSerializationId, OutputStream outputStream, SpiSerializerCallback serializerCallback ) throws IOException {

        // get factory
        SpiCustomParserSerializerFactory customParserSerializerFactory = this.getCustomParserSerializerFactory( customSerializationId );

        if ( customParserSerializerFactory == null ) {
            log.trace( MoinSeverity.ERROR, RuntimehostMessages.NO_SERIALIZATION_FACTORY_FOUND_FOR_ID, new Object[] { customSerializationId } );
            throw new IOException( RuntimehostMessages.NO_SERIALIZATION_FACTORY_FOUND_FOR_ID.format( new Object[] { customSerializationId } ) );
        }

        // get serializer
        SpiCustomSerializer serializer = customParserSerializerFactory.getSerializer( );

        if ( serializer != null ) {
            if ( JMX_ENABLED && jmxNotificationsEnabled ) {
                long t = System.nanoTime( );
                this.partitionSerializationStart( customSerializationId, serializerCallback.getPri( ), Thread.currentThread( ).getStackTrace( ) );
                serializer.serialize( outputStream, serializerCallback );
                long duration = ( System.nanoTime( ) - t ) / 1000000;
                this.partitionSerializationEnd( customSerializationId, serializerCallback.getPri( ), duration );
            } else {
                serializer.serialize( outputStream, serializerCallback );
            }
        } else {
            log.trace( MoinSeverity.ERROR, RuntimehostMessages.NO_SERIALIZER, new Object[] { customParserSerializerFactory.getClass( ).getName( ) } );
            throw new IOException( RuntimehostMessages.NO_SERIALIZER.format( customParserSerializerFactory.getClass( ).getName( ) ) );
        }
    }

    public boolean isSerializerAvailable( PRI pri ) {

        // get serialization id
        String customSerializationId = this.getSerializationId( pri );
        // get factory
        SpiCustomParserSerializerFactory customParserSerializerFactory = this.getCustomParserSerializerFactory( customSerializationId );

        if ( customParserSerializerFactory == null ) {
            return false;
        }

        // get serializer
        SpiCustomSerializer serializer = customParserSerializerFactory.getSerializer( );

        return ( serializer != null );
    }

    /*
     * @see com.sap.tc.moin.repository.spi.runtimehost.cp.
     * SpiPartitionSerializationManager
     * #serializeTexts(com.sap.tc.moin.repository.PRI, java.io.OutputStream,
     * com.sap.tc.moin.repository.spi.s2x.serializer.SpiS2XDocument,
     * com.sap.tc.moin.repository.spi.ps.serializer.SpiSerializerCallback)
     */
    public void serializeTexts( PRI pri, OutputStream outputStream, SpiS2XDocument s2xDocument, SpiSerializerCallback serializerCallback ) throws IOException {

        // get S2X serializer
        SpiCustomSerializer textSerializer = new S2XSerializer( s2xDocument, this );
        // serialize
        textSerializer.serialize( outputStream, serializerCallback );
    }

    public SpiS2XSerializerCustomCallback getCustomS2XSerializerCallback( String container ) {

        InstanceReferenceImpl<SpiS2XSerializerCustomCallback> ref = this.tvCallbackRegistry.get( container );

        if ( ref != null ) {
            return ref.getInstance( );
        }

        return null;
    }

    /**
     * Returns the registered serialization id for a given suffix.
     * 
     * @param pri Partition
     * @return serializationId
     */
    public String getSerializationId( PRI pri ) {

        String partitionName = pri.getPartitionName( );

        String customSerializationId = this.cpsPatternRegistry.find( partitionName );
        if ( customSerializationId == null ) {
            log.trace( MoinSeverity.ERROR, RuntimehostMessages.NO_SERIALIZATION_FACTORY_FOUND, new Object[] { partitionName } );
            throw new MoinDeploymentException( RuntimehostMessages.NO_SERIALIZATION_FACTORY_FOUND, new Object[] { partitionName } );
        }
        return customSerializationId;
    }

    /**
     * Returns the registered cps factory for a serialization id.
     * 
     * @param serializationId
     * @return serialization factory
     */
    public SpiCustomParserSerializerFactory getCustomParserSerializerFactory( String serializationId ) {

        SpiCustomParserSerializerFactory result = null;
        InstanceReferenceImpl<SpiCustomParserSerializerFactory> ref = this.cpsRegistry.get( serializationId );
        if ( ref != null ) {
            SpiCustomParserSerializerFactory spiCustomParserSerializerFactory = ref.getInstance( );
            if ( spiCustomParserSerializerFactory != null ) {
                result = spiCustomParserSerializerFactory;
            }
        }
        if ( result != null ) {
            return result;
        }
        log.trace( MoinSeverity.ERROR, RuntimehostMessages.NO_SERIALIZATION_FACTORY_FOUND_FOR_ID, new Object[] { serializationId } );
        throw new MoinDeploymentException( RuntimehostMessages.NO_SERIALIZATION_FACTORY_FOUND_FOR_ID, new Object[] { serializationId } );
    }

    public boolean isValidPartitionName( String partitionName ) {

        return ( this.cpsPatternRegistry.find( partitionName ) != null );
    }

    public void validatePartitionName( String partitionName ) {

        if ( !isValidPartitionName( partitionName ) ) {
            String validPatterns = this.getRegisteredPriPatterns( ).toString( );
            throw new MoinLocalizedBaseRuntimeException( RuntimeHostDeploymentMessages.INVALIDPARTITIONNAMEPATTERN, partitionName, validPatterns );
        }
    }

    private List<String> getRegisteredPriPatterns( ) {

        Set<Entry<PriPattern, String>> patternRegistryEntrySet = this.cpsPatternRegistry.getEntrySet( );
        List<String> patternStrings = new ArrayList<String>( patternRegistryEntrySet.size( ) );

        for ( Entry<PriPattern, String> registryEntry : patternRegistryEntrySet ) {
            patternStrings.add( registryEntry.getKey( ).toString( ) );
        }

        return Collections.unmodifiableList( patternStrings );
    }

    /*
     * (non-Javadoc)
     * @seecom.sap.tc.moin.repository.spi.runtimehost.cp.
     * SpiPartitionSerializationManager
     * #getCustomContentSelections(java.lang.String)
     */
    public Collection<Properties> getCustomContentSelections( String contentSelectionType ) {

        Collection<Properties> result = new ArrayList<Properties>( );
        Map<String, Collection<Properties>> selectionCriteria = this.modelContentSelectionCriteria.get( contentSelectionType );
        if ( selectionCriteria != null ) {
            for ( Collection<Properties> collection : selectionCriteria.values( ) ) {
                result.addAll( collection );
            }
        }
        return result;
    }

    //////
    ////// Test methods, allowing unit tests to directly manipulate the error handler registry
    //////

    public void setParserErrorHandler( String metamodelContainerName, SpiParserErrorHandler testErrorHandler ) {

        this.criEhRegistry.remove( metamodelContainerName, null, null );
        InstanceReferenceImpl<SpiParserErrorHandler> instanceReference = new InstanceReferenceImpl<SpiParserErrorHandler>( testErrorHandler.getClass( ).getName( ) );
        instanceReference.setInstance( testErrorHandler );
        this.criEhRegistry.put( metamodelContainerName, null, null, instanceReference );
    }

    public void removeParserErrorHandler( String metamodelContainerName ) {

        this.criEhRegistry.remove( metamodelContainerName, null, null );
    }

    public void setS2XSerializerCallback( String metamodelContainerName, SpiS2XSerializerCustomCallback testS2XSerializerCustomCallback ) {

        this.tvCallbackRegistry.remove( metamodelContainerName );
        InstanceReferenceImpl<SpiS2XSerializerCustomCallback> instanceReference = new InstanceReferenceImpl<SpiS2XSerializerCustomCallback>( testS2XSerializerCustomCallback.getClass( ).getName( ) );
        instanceReference.setInstance( testS2XSerializerCustomCallback );
        this.tvCallbackRegistry.put( metamodelContainerName, instanceReference );
    }

    public void removeS2XSerializerCallback( String metamodelContainerName ) {

        this.tvCallbackRegistry.remove( metamodelContainerName );
    }

    //////
    ////// JMX support
    //////

    public boolean isJmxNotificationsEnabled( ) {

        return jmxNotificationsEnabled;
    }

    public void partitionParsingStart( String serializationId, PRI pri, long fileSize, StackTraceElement[] elements ) {

        this.jmxAdapter.partitionParsingStart( serializationId, pri, fileSize, elements );
    }

    public void partitionParsingEnd( String serializationId, PRI pri, long duration ) {

        this.jmxAdapter.partitionParsingEnd( serializationId, pri, duration );
    }

    public void partitionSerializationStart( String serializationId, PRI pri, StackTraceElement[] elements ) {

        this.jmxAdapter.partitionSerializationStart( serializationId, pri, elements );
    }

    public void partitionSerializationEnd( String serializationId, PRI pri, long duration ) {

        this.jmxAdapter.partitionSerializationEnd( serializationId, pri, duration );
    }

    public void elementAdded( PRI pri, SpiElement newElement ) {

        this.jmxAdapter.elementAdded( getSerializationId( pri ), newElement );
    }

    public void elementOfNonExistingMofClassAdded( PRI pri, String metamodelContainer, String qualifiedName, String typeMofId, String mofId ) {

        this.jmxAdapter.elementOfNonExistingMofClassAdded( getSerializationId( pri ), metamodelContainer, qualifiedName, typeMofId, mofId );
    }

    public void attributeValueAdded( PRI pri, SpiElement element, Attribute attribute, Object value ) {

        this.jmxAdapter.attributeValueAdded( getSerializationId( pri ), element, attribute, value );
    }

    public void linkAdded( PRI pri, SpiAssociation association, Object firstElement, Object secondElement ) {

        this.jmxAdapter.linkAdded( getSerializationId( pri ), association, firstElement, secondElement );
    }

    public void errorHandlerStart( SpiParserErrorHandler errorHandler, String method, Map<String, String> args ) {

        this.jmxAdapter.errorHandlerStart( errorHandler, method, args );
    }

    public void errorHandlerEnd( SpiParserErrorHandler errorHandler, boolean errorHandled, String method ) {

        this.jmxAdapter.errorHandlerEnd( errorHandler, errorHandled, method );
    }

    public void s2xSerializerStart( PRI pri, String language, String develContact ) {

        this.jmxAdapter.s2xSerializerStart( pri, language, develContact );
    }

    public void s2xSerializerEnd( String content, long duration, int numberOfTexts ) {

        this.jmxAdapter.s2xSerializerEnd( content, duration, numberOfTexts );
    }

    public void s2xSerializerException( Exception exception ) {

        this.jmxAdapter.s2xSerializerException( exception );
    }

    public void s2xSerializerAddTranslationUnit( String serializedTranslationUnit ) {

        this.jmxAdapter.s2xSerializerAddTranslationUnit( serializedTranslationUnit );
    }

    public void s2xSerializerCallback( String serializedInput, String serializedOutput, long duration ) {

        this.jmxAdapter.s2xSerializerCallback( serializedInput, serializedOutput, duration );
    }

    @SuppressWarnings( "unchecked" )
    private static final class JmxAdapter extends NotificationBroadcasterSupport implements CpsMBean {

        private static final CompositeType compositeTypeForCpsFactories;

        private static final TabularType tabularTypeForCpsFactories;

        private static final CompositeType compositeTypeForPriPatternRegistry;

        private static final TabularType tabularTypeForPriPatternRegistry;

        private static final CompositeType compositeTypeForCriteriaByMetamodel;

        private static final TabularType tabularTypeForCriteriaByMetamodel;

        private static final CompositeType compositeTypeForPropertiesByType;

        private static final TabularType tabularTypeForPropertiesByType;

        private static final CompositeType compositeTypeForProperties;

        private static final TabularType tabularTypeForProperties;

        private static final CompositeType compositeTypeForS2XSerializerCallbacks;

        private static final TabularType tabularTypeForS2XSerializerCallbacks;

        private static final CompositeType compositeTypeForErrorHandlers;

        private static final TabularType tabularTypeForErrorHandlers;

        static {
            try {
                {
                    String[] itemNames = new String[] { "1: SerializationId", "2: Factory" }; //$NON-NLS-1$//$NON-NLS-2$
                    OpenType[] itemTypes = new OpenType[] { SimpleType.STRING, SimpleType.STRING };
                    compositeTypeForCpsFactories = new CompositeType( "CpsFactoryInfo", "CpsFactoryInfo", itemNames, itemNames, itemTypes ); //$NON-NLS-1$ //$NON-NLS-2$
                    tabularTypeForCpsFactories = new TabularType( "CpsFactories", "CpsFactories", compositeTypeForCpsFactories, new String[] { "1: SerializationId" } ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                }
                {
                    String[] itemNames = new String[] { "1: PriPattern", "2: SerializationId" }; //$NON-NLS-1$//$NON-NLS-2$
                    OpenType[] itemTypes = new OpenType[] { SimpleType.STRING, SimpleType.STRING };
                    compositeTypeForPriPatternRegistry = new CompositeType( "PriPatternRegistryInfo", "PriPatternRegistryInfo", itemNames, itemNames, itemTypes ); //$NON-NLS-1$ //$NON-NLS-2$
                    tabularTypeForPriPatternRegistry = new TabularType( "PriPatternRegistry", "PriPatternRegistry", compositeTypeForPriPatternRegistry, new String[] { "1: PriPattern" } ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                }
                {
                    String[] itemNames = new String[] { "1: Metamodel", "2: Callback" }; //$NON-NLS-1$//$NON-NLS-2$
                    OpenType[] itemTypes = new OpenType[] { SimpleType.STRING, SimpleType.STRING };
                    compositeTypeForS2XSerializerCallbacks = new CompositeType( "S2XSerializerCallbackInfo", "S2XSerializerCallbackInfo", itemNames, itemNames, itemTypes ); //$NON-NLS-1$ //$NON-NLS-2$
                    tabularTypeForS2XSerializerCallbacks = new TabularType( "S2XSerializerCallbacks", "S2XSerializerCallbacks", compositeTypeForS2XSerializerCallbacks, new String[] { "1: Metamodel" } ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                }
                {
                    String[] itemNames = new String[] { "1: Metamodel", "2: ErrorHandler" }; //$NON-NLS-1$//$NON-NLS-2$
                    OpenType[] itemTypes = new OpenType[] { SimpleType.STRING, SimpleType.STRING };
                    compositeTypeForErrorHandlers = new CompositeType( "ErrorHandlerInfo", "ErrorHandlerInfo", itemNames, itemNames, itemTypes ); //$NON-NLS-1$ //$NON-NLS-2$
                    tabularTypeForErrorHandlers = new TabularType( "ErrorHandlers", "ErrorHandlers", compositeTypeForErrorHandlers, new String[] { "1: Metamodel" } ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                }
                {
                    String[] itemNames = new String[] { "1: Key", "2: Value" }; //$NON-NLS-1$//$NON-NLS-2$
                    OpenType[] itemTypes = new OpenType[] { SimpleType.STRING, SimpleType.STRING };
                    compositeTypeForProperties = new CompositeType( "PropertyInfo", "PropertyInfo", itemNames, itemNames, itemTypes ); //$NON-NLS-1$ //$NON-NLS-2$
                    tabularTypeForProperties = new TabularType( "Properties", "Properties", compositeTypeForProperties, new String[] { "1: Key" } ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                }
                {
                    String[] itemNames = new String[] { "1: ID", "2: Type", "3: Properties" }; //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
                    OpenType[] itemTypes = new OpenType[] { SimpleType.STRING, SimpleType.STRING, tabularTypeForProperties };
                    compositeTypeForPropertiesByType = new CompositeType( "PropertiesByTypeInfo", "PropertiesByTypeInfo", itemNames, itemNames, itemTypes ); //$NON-NLS-1$ //$NON-NLS-2$
                    tabularTypeForPropertiesByType = new TabularType( "PropertiesByType", "PropertiesByType", compositeTypeForPropertiesByType, new String[] { "1: ID" } ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                }
                {
                    String[] itemNames = new String[] { "1: Metamodel", "2: Criteria" }; //$NON-NLS-1$//$NON-NLS-2$
                    OpenType[] itemTypes = new OpenType[] { SimpleType.STRING, tabularTypeForPropertiesByType };
                    compositeTypeForCriteriaByMetamodel = new CompositeType( "CriterionInfo", "CriterionInfo", itemNames, itemNames, itemTypes ); //$NON-NLS-1$ //$NON-NLS-2$
                    tabularTypeForCriteriaByMetamodel = new TabularType( "Criteria", "Criteria", compositeTypeForCriteriaByMetamodel, new String[] { "1: Metamodel" } ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                }
            } catch ( OpenDataException e ) {
                throw new RuntimeException( e ); // not expected to occur
            }
        }

        /**
         * Sequence number if JMX notifications need to be emitted.
         */
        private AtomicLong seqNo = new AtomicLong( 0 );

        private final WeakReferenceWithObjectName<PartitionSerializationManagerImpl> serializationManagerRef;

        private final ObjectName objectName;

        JmxAdapter( PartitionSerializationManagerImpl serializationManager, ObjectName objectName, ReferenceQueue refQueue ) {

            this.objectName = objectName;
            this.serializationManagerRef = new WeakReferenceWithObjectName<PartitionSerializationManagerImpl>( serializationManager, objectName, refQueue );
            registerBroadcastingMBean( this, CpsMBean.class, objectName );
        }

        public void partitionParsingStart( String serializationId, PRI pri, long fileSize, StackTraceElement[] elements ) {

            Notification notification = new Notification( CpsMBean.PARTITION_PARSING_START, this.objectName, this.seqNo.incrementAndGet( ), "Parser=" + serializationId + ",PRI=" + pri.toString( ) + ",FileSize=" + fileSize + "B" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
            notification.setUserData( elements );
            this.sendNotification( notification );
        }

        public void partitionParsingEnd( String serializationId, PRI pri, long duration ) {

            Notification notification = new Notification( CpsMBean.PARTITION_PARSING_END, this.objectName, this.seqNo.incrementAndGet( ), "Parser=" + serializationId + ",PRI=" + pri.toString( ) ); //$NON-NLS-1$ //$NON-NLS-2$
            notification.setUserData( "Time=" + String.valueOf( duration ) + "ms" ); //$NON-NLS-1$ //$NON-NLS-2$
            this.sendNotification( notification );
        }

        public void partitionSerializationStart( String serializationId, PRI pri, StackTraceElement[] elements ) {

            Notification notification = new Notification( CpsMBean.PARTITION_SERIALIZATION_START, this.objectName, this.seqNo.incrementAndGet( ), "Serializer=" + serializationId + ",PRI=" + pri.toString( ) ); //$NON-NLS-1$ //$NON-NLS-2$
            notification.setUserData( elements );
            this.sendNotification( notification );
        }

        public void partitionSerializationEnd( String serializationId, PRI pri, long duration ) {

            Notification notification = new Notification( CpsMBean.PARTITION_SERIALIZATION_END, this.objectName, this.seqNo.incrementAndGet( ), "Serializer=" + serializationId + ",PRI=" + pri.toString( ) ); //$NON-NLS-1$ //$NON-NLS-2$
            notification.setUserData( "Time=" + String.valueOf( duration ) + "ms" ); //$NON-NLS-1$ //$NON-NLS-2$
            this.sendNotification( notification );
        }

        public void elementAdded( String serializationId, SpiElement newElement ) {

            PartitionSerializationManagerImpl serializationManager = this.serializationManagerRef.get( );
            if ( serializationManager != null ) {
                Notification notification = new Notification( CpsMBean.ADD_ELEMENT, this.objectName, this.seqNo.incrementAndGet( ), "MofId=" + newElement.get___MofId( ) ); //$NON-NLS-1$
                String userData = "Parser=" + serializationId + ",Class=" + newElement.get___Type( ).get___QualifiedName( ); //$NON-NLS-1$ //$NON-NLS-2$
                notification.setUserData( userData );
                this.sendNotification( notification );
            }
        }

        public void elementOfNonExistingMofClassAdded( String serializationId, String metamodelContainer, String qualifiedName, String typeMofId, String mofId ) {

            PartitionSerializationManagerImpl serializationManager = this.serializationManagerRef.get( );
            if ( serializationManager != null ) {
                Notification notification = new Notification( CpsMBean.ADD_ELEMENT_OF_NONEXISTING_MOFCLASS, this.objectName, this.seqNo.incrementAndGet( ), "MofId=" + mofId ); //$NON-NLS-1$
                String userData = "Parser=" + serializationId + ",Metamodel=" + metamodelContainer + ",QualifiedName=" + qualifiedName + ",TypeMofId=" + typeMofId; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
                notification.setUserData( userData );
                this.sendNotification( notification );
            }
        }

        public void attributeValueAdded( String serializationId, SpiElement element, Attribute attribute, Object value ) {

            PartitionSerializationManagerImpl serializationManager = this.serializationManagerRef.get( );
            if ( serializationManager != null ) {
                String message = "Attribute=" + attribute.getName( ) + ",Value=" + value; //$NON-NLS-1$ //$NON-NLS-2$
                Notification notification = new Notification( CpsMBean.ADD_ATTRIBUTE_VALUE, this.objectName, this.seqNo.incrementAndGet( ), message );
                String userData = "Parser=" + serializationId + ",Element=" + element.get___MofId( ); //$NON-NLS-1$ //$NON-NLS-2$
                notification.setUserData( userData );
                this.sendNotification( notification );
            }
        }

        public void linkAdded( String serializationId, SpiAssociation association, Object firstElement, Object secondElement ) {

            PartitionSerializationManagerImpl serializationManager = this.serializationManagerRef.get( );
            if ( serializationManager != null ) {
                String message = "First=" //$NON-NLS-1$
                                 + ( firstElement instanceof LRI ? firstElement.toString( ) : ( (SpiElement) firstElement ).get___MofId( ) + " (Class: " + ( (SpiElement) firstElement ).get___Type( ).get___QualifiedName( ) + ")" ); //$NON-NLS-1$//$NON-NLS-2$
                message += ",Second=" //$NON-NLS-1$
                           + ( secondElement instanceof LRI ? secondElement.toString( ) : ( (SpiElement) secondElement ).get___MofId( ) + " (Class: " + ( (SpiElement) secondElement ).get___Type( ).get___QualifiedName( ) + ")" ); //$NON-NLS-1$//$NON-NLS-2$
                Notification notification = new Notification( CpsMBean.ADD_LINK, this.objectName, this.seqNo.incrementAndGet( ), message );
                String userData = "Parser=" + serializationId + ",Association=" + association.get___QualifiedName( ); //$NON-NLS-1$ //$NON-NLS-2$
                notification.setUserData( userData );
                this.sendNotification( notification );
            }
        }

        public void errorHandlerStart( SpiParserErrorHandler errorHandler, String method, Map<String, String> args ) {

            PartitionSerializationManagerImpl serializationManager = this.serializationManagerRef.get( );
            if ( serializationManager != null ) {
                String message = EMPTY_PREFIX;
                for ( Iterator<Entry<String, String>> entryIt = args.entrySet( ).iterator( ); entryIt.hasNext( ); ) {
                    Entry<String, String> entry = entryIt.next( );
                    message += entry.getKey( ) + "=" + entry.getValue( ); //$NON-NLS-1$
                    if ( entryIt.hasNext( ) ) {
                        message += ","; //$NON-NLS-1$
                    }
                }
                Notification notification = new Notification( CpsMBean.ERROR_HANDLER_START, this.objectName, this.seqNo.incrementAndGet( ), message );
                String userData = "ErrorHandler=" + errorHandler + ",Method=" + method; //$NON-NLS-1$ //$NON-NLS-2$
                notification.setUserData( userData );
                this.sendNotification( notification );
            }
        }

        public void errorHandlerEnd( SpiParserErrorHandler errorHandler, boolean errorHandled, String method ) {

            PartitionSerializationManagerImpl serializationManager = this.serializationManagerRef.get( );
            if ( serializationManager != null ) {
                Notification notification = new Notification( CpsMBean.ERROR_HANDLER_END, this.objectName, this.seqNo.incrementAndGet( ), null );
                String userData = "ErrorHandler=" + errorHandler + ",Method=" + method + ",Handled=" + errorHandled; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                notification.setUserData( userData );
                this.sendNotification( notification );
            }
        }

        public void s2xSerializerStart( PRI pri, String language, String develContact ) {

            PartitionSerializationManagerImpl serializationManager = this.serializationManagerRef.get( );
            if ( serializationManager != null ) {
                String message = EMPTY_PREFIX;
                message += "PRI= " + pri + ",language=" + language + ",develContact=" + develContact; //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
                Notification notification = new Notification( CpsMBean.TEXTS_SERIALIZATION_START, this.objectName, this.seqNo.incrementAndGet( ), message );
                String userData = "Begin of S2X serialization"; //$NON-NLS-1$
                notification.setUserData( userData );
                this.sendNotification( notification );
            }
        }

        public void s2xSerializerEnd( String content, long duration, int numberOfTexts ) {

            PartitionSerializationManagerImpl serializationManager = this.serializationManagerRef.get( );
            if ( serializationManager != null ) {
                String message = EMPTY_PREFIX;
                message += content;
                Notification notification = new Notification( CpsMBean.TEXTS_SERIALIZATION_END, this.objectName, this.seqNo.incrementAndGet( ), message );
                String userData = "End of S2X serialization, time=" + String.valueOf( duration ) + "ms,texts serialized=" + numberOfTexts; //$NON-NLS-1$ //$NON-NLS-2$
                notification.setUserData( userData );
                this.sendNotification( notification );
            }
        }

        public void s2xSerializerException( Exception exception ) {

            PartitionSerializationManagerImpl serializationManager = this.serializationManagerRef.get( );
            if ( serializationManager != null ) {
                String message = EMPTY_PREFIX;
                message += exception.getMessage( );
                Notification notification = new Notification( CpsMBean.TEXTS_SERIALIZATION_EXCEPTION, this.objectName, this.seqNo.incrementAndGet( ), message );
                notification.setUserData( exception.getStackTrace( ) );
                this.sendNotification( notification );
            }
        }

        public void s2xSerializerAddTranslationUnit( String serializedTranslationUnit ) {

            PartitionSerializationManagerImpl serializationManager = this.serializationManagerRef.get( );
            if ( serializationManager != null ) {
                String message = EMPTY_PREFIX;
                message += serializedTranslationUnit;
                Notification notification = new Notification( CpsMBean.TEXTS_SERIALIZATION_TRANSLATABLE_TEXT, this.objectName, this.seqNo.incrementAndGet( ), message );
                notification.setUserData( "Translation unit" ); //$NON-NLS-1$
                this.sendNotification( notification );
            }
        }

        public void s2xSerializerCallback( String serializedInput, String serializedOutput, long duration ) {

            PartitionSerializationManagerImpl serializationManager = this.serializationManagerRef.get( );
            if ( serializationManager != null ) {
                String message = EMPTY_PREFIX;
                message += "input: " + serializedInput + ", output: " + serializedOutput; //$NON-NLS-1$//$NON-NLS-2$
                Notification notification = new Notification( CpsMBean.TEXTS_SERIALIZATION_CALLBACK, this.objectName, this.seqNo.incrementAndGet( ), message );
                String userData = "End of S2X serialization callback, time=" + String.valueOf( duration ) + "ms"; //$NON-NLS-1$ //$NON-NLS-2$
                notification.setUserData( userData );
                this.sendNotification( notification );
            }
        }

        @Override
        public MBeanNotificationInfo[] getNotificationInfo( ) {

            MBeanNotificationInfo[] notifsInfo = { new MBeanNotificationInfo( CpsMBean.ALL_NOTIFICATION_TYPES, Notification.class.getName( ), "Notifications sent by a Cps MBean" ) }; //$NON-NLS-1$
            return notifsInfo;
        }

        public void startNotifications( ) throws IOException {

            PartitionSerializationManagerImpl serializationManager = this.serializationManagerRef.get( );
            if ( serializationManager != null ) {
                serializationManager.jmxNotificationsEnabled = true;
            }
        }

        public boolean notificationsStarted( ) throws IOException {

            PartitionSerializationManagerImpl serializationManager = this.serializationManagerRef.get( );
            if ( serializationManager != null ) {
                return serializationManager.jmxNotificationsEnabled;
            }
            return false;
        }

        public void stopNotifications( ) throws IOException {

            PartitionSerializationManagerImpl serializationManager = this.serializationManagerRef.get( );
            if ( serializationManager != null ) {
                serializationManager.jmxNotificationsEnabled = false;
            }
        }

        public TabularData getCustomParserSerializerFactories( ) throws IOException {

            TabularData result = null;
            PartitionSerializationManagerImpl serializationManager = this.serializationManagerRef.get( );
            if ( serializationManager != null ) {
                result = new TabularDataSupport( tabularTypeForCpsFactories );
                for ( Entry<String, InstanceReferenceImpl<SpiCustomParserSerializerFactory>> entry : serializationManager.cpsRegistry.entrySet( ) ) {
                    Map map = new LinkedHashMap<String, Object>( );
                    map.put( "1: SerializationId", entry.getKey( ) ); //$NON-NLS-1$
                    map.put( "2: Factory", entry.getValue( ).getClassName( ) ); //$NON-NLS-1$
                    CompositeData row;
                    try {
                        row = new CompositeDataSupport( compositeTypeForCpsFactories, map );
                    } catch ( OpenDataException e ) {
                        throw new RuntimeException( e );
                    }
                    result.put( row );
                }
            }
            return result;
        }

        public TabularData getPriPatternRegistry( ) throws IOException {

            TabularData result = null;
            PartitionSerializationManagerImpl serializationManager = this.serializationManagerRef.get( );
            if ( serializationManager != null ) {
                result = new TabularDataSupport( tabularTypeForPriPatternRegistry );
                for ( Entry<PriPattern, String> entry : serializationManager.cpsPatternRegistry.getEntrySet( ) ) {
                    Map map = new LinkedHashMap<String, Object>( );
                    map.put( "1: PriPattern", entry.getKey( ).toString( ) ); //$NON-NLS-1$
                    map.put( "2: SerializationId", entry.getValue( ) ); //$NON-NLS-1$
                    CompositeData row;
                    try {
                        row = new CompositeDataSupport( compositeTypeForPriPatternRegistry, map );
                    } catch ( OpenDataException e ) {
                        throw new RuntimeException( e );
                    }
                    result.put( row );
                }
            }
            return result;
        }

        public TabularData getModelContentSelectionCriteria( ) throws IOException {

            TabularData result = null;
            PartitionSerializationManagerImpl serializationManager = this.serializationManagerRef.get( );
            if ( serializationManager != null ) {
                // First, reccode the 'modelContentSelectionCriteria' map.
                Map<String, Map<String, Collection<Properties>>> criteriaByMetamodel = new HashMap<String, Map<String, Collection<Properties>>>( );
                for ( Entry<String, Map<String, Collection<Properties>>> entry : serializationManager.modelContentSelectionCriteria.entrySet( ) ) {
                    String type = entry.getKey( );
                    Map<String, Collection<Properties>> propertiesByMetamodel = entry.getValue( );
                    for ( Entry<String, Collection<Properties>> entry2 : propertiesByMetamodel.entrySet( ) ) {
                        String metamodel = entry2.getKey( );
                        Collection<Properties> properties = entry2.getValue( );
                        Map<String, Collection<Properties>> map = criteriaByMetamodel.get( metamodel );
                        if ( map == null ) {
                            criteriaByMetamodel.put( metamodel, map = new HashMap<String, Collection<Properties>>( ) );
                        }
                        Collection<Properties> props = map.get( type );
                        if ( props == null ) {
                            map.put( type, props = new ArrayList<Properties>( ) );
                        }
                        props.addAll( properties );
                    }
                }
                result = new TabularDataSupport( tabularTypeForCriteriaByMetamodel );
                for ( Entry<String, Map<String, Collection<Properties>>> entry : criteriaByMetamodel.entrySet( ) ) {
                    String metamodel = entry.getKey( );
                    Map<String, Collection<Properties>> criteria = entry.getValue( );
                    Map map1 = new LinkedHashMap<String, Object>( );
                    map1.put( "1: Metamodel", metamodel ); //$NON-NLS-1$
                    TabularDataSupport propertiesByTypeTab = new TabularDataSupport( tabularTypeForPropertiesByType );
                    map1.put( "2: Criteria", propertiesByTypeTab ); //$NON-NLS-1$
                    for ( Entry<String, Collection<Properties>> entry2 : criteria.entrySet( ) ) {
                        String type = entry2.getKey( );
                        Collection<Properties> properties = entry2.getValue( );
                        SpiMutableInteger counter = new SpiMutableInteger( 1 );
                        for ( Properties prop : properties ) {
                            Map map2 = new LinkedHashMap<String, Object>( );
                            map2.put( "1: ID", counter.toString( ) ); //$NON-NLS-1$
                            map2.put( "2: Type", type ); //$NON-NLS-1$
                            TabularDataSupport propertiesTab = new TabularDataSupport( tabularTypeForProperties );
                            map2.put( "3: Properties", propertiesTab ); //$NON-NLS-1$
                            for ( Entry<Object, Object> entry3 : prop.entrySet( ) ) {
                                Map map3 = new LinkedHashMap<String, String>( );
                                map3.put( "1: Key", entry3.getKey( ) ); //$NON-NLS-1$
                                map3.put( "2: Value", entry3.getValue( ) ); //$NON-NLS-1$
                                CompositeData row3;
                                try {
                                    row3 = new CompositeDataSupport( compositeTypeForProperties, map3 );
                                } catch ( OpenDataException e ) {
                                    throw new RuntimeException( e );
                                }
                                propertiesTab.put( row3 );
                            }
                            CompositeData row2;
                            try {
                                row2 = new CompositeDataSupport( compositeTypeForPropertiesByType, map2 );
                            } catch ( OpenDataException e ) {
                                throw new RuntimeException( e );
                            }
                            propertiesByTypeTab.put( row2 );
                            counter.increment( );
                        }
                    }
                    CompositeData row1;
                    try {
                        row1 = new CompositeDataSupport( compositeTypeForCriteriaByMetamodel, map1 );
                    } catch ( OpenDataException e ) {
                        throw new RuntimeException( e );
                    }
                    result.put( row1 );
                }
            }
            return result;
        }

        public TabularData getS2XSerializerCustomCallbacks( ) throws IOException {

            TabularData result = null;
            PartitionSerializationManagerImpl serializationManager = this.serializationManagerRef.get( );
            if ( serializationManager != null ) {
                result = new TabularDataSupport( tabularTypeForS2XSerializerCallbacks );
                for ( Entry<String, InstanceReferenceImpl<SpiS2XSerializerCustomCallback>> entry : serializationManager.tvCallbackRegistry.entrySet( ) ) {
                    Map map = new LinkedHashMap<String, Object>( );
                    map.put( "1: Metamodel", entry.getKey( ) ); //$NON-NLS-1$
                    map.put( "2: Callback", entry.getValue( ).getClassName( ) ); //$NON-NLS-1$
                    CompositeData row;
                    try {
                        row = new CompositeDataSupport( compositeTypeForS2XSerializerCallbacks, map );
                    } catch ( OpenDataException e ) {
                        throw new RuntimeException( e );
                    }
                    result.put( row );
                }
            }
            return result;
        }

        public TabularData getErrorHandlers( ) throws IOException {

            TabularData result = null;
            PartitionSerializationManagerImpl serializationManager = this.serializationManagerRef.get( );
            if ( serializationManager != null ) {
                result = new TabularDataSupport( tabularTypeForErrorHandlers );
                for ( Entry<String, Map<VersionInterval, InstanceReferenceImpl<SpiParserErrorHandler>>> entry : serializationManager.criEhRegistry.registry.entrySet( ) ) {

                    Map map = new LinkedHashMap<String, Object>( );
                    map.put( "1: Metamodel", entry.getKey( ) ); //$NON-NLS-1$
                    map.put( "2: ErrorHandler", entry.getValue( ).values( ).iterator( ).next( ).getClassName( ) ); //$NON-NLS-1$
                    CompositeData row;
                    try {
                        row = new CompositeDataSupport( compositeTypeForErrorHandlers, map );
                    } catch ( OpenDataException e ) {
                        throw new RuntimeException( e );
                    }
                    result.put( row );
                }
            }
            return result;
        }

        public String findResponsibleParserSerializer( String priString ) throws IOException {

            PartitionSerializationManagerImpl serializationManager = this.serializationManagerRef.get( );
            if ( serializationManager != null ) {
                PRI pri = null;
                try {
                    pri = serializationManager.moin.createPri( priString );
                } catch ( InvalidResourceIdentifierException ex ) {
                    throw new RuntimeException( ex );
                }
                return serializationManager.cpsPatternRegistry.find( pri.getPartitionName( ) );
            }
            return null;
        }
    }

    private static final class CpsInstanceReferenceImpl extends InstanceReferenceImpl<SpiCustomParserSerializerFactory> {

        public CpsInstanceReferenceImpl( String className ) {

            super( className );
        }

        @Override
        public void createInstance( IpiCustomSerializationClassLoader loader ) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

            Class<?> factoryClass = loader.loadClass( this.getClassName( ) );
            Object newInstance = factoryClass.newInstance( );
            if ( newInstance instanceof SpiCustomParserSerializerFactory ) {
                this.setInstance( (SpiCustomParserSerializerFactory) newInstance );
            } else if ( newInstance instanceof SpiXmParserSerializerConfiguration ) {
                // register XM factory here
                SpiCustomParserSerializerFactory xmCpsFactory = XmCpsFactory.createXmCpsFactory( (SpiXmParserSerializerConfiguration) newInstance );
                this.setInstance( xmCpsFactory );
            } else {
                log.trace( MoinSeverity.ERROR, RuntimehostMessages.FACTORY_WRONG_INTERFACE, new Object[] { this.getClassName( ), SpiCustomParserSerializerFactory.class.getName( ) } );
                throw new ClassCastException( RuntimehostMessages.FACTORY_WRONG_INTERFACE.format( new Object[] { this.getClassName( ), SpiCustomParserSerializerFactory.class.getName( ) } ) );
            }
        }
    }

    public void shutDown( ) {

        if ( JMX_ENABLED ) {
            unregisterMBean( objectName );
        }
    }
}