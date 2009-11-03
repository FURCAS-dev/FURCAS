package com.sap.tc.moin.repository.runtimehost.deployment;



import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.ResourceIdentifierFactory;
import com.sap.tc.moin.repository.Version;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.metamodels.DeploymentExtension;
import com.sap.tc.moin.repository.metamodels.MetaModelVersion;
import com.sap.tc.moin.repository.runtimehost.MmInfoConst;
import com.sap.tc.moin.repository.runtimehost.RuntimehostMessages;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.core.SpiMoin;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;
import com.sap.tc.moin.repository.spi.facility.SpiPartitionStreamProvider;
import com.sap.tc.moin.repository.spi.runtimehost.mm.SpiMetaModelInfo;

/**
 * Class containing the metamodel parts of a MOIN archive. The instances of this
 * class are put into the {
 * 
 * @author D026715
 */
public class MmInfoImpl implements SpiMetaModelInfo, SpiPartitionStreamProvider {

    protected static final MoinLogger _log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_RUNTIME_HOST, MoinLocationEnum.MOIN_METAMODELS, MmInfoImpl.class );

    protected MetaModelArchiveDescriptor metamodelArchiveDescriptor = null;

    protected CRI cri = null;

    protected SpiFacility facility = null;

    private Collection<PRI> PRIs = null;

    private Hashtable<PRI, String> partitionFingerprints = null;

    private DeploymentExtension mmExtensionInstance = null;

    private IpiMetamodelArchiveAccess archiveAccess = null;

    private MetaModelVersion deployedVersion = null;

    private StatusListener statusListener;

    private MoinArchiveHeader archiveHeader;

    public MmInfoImpl( IpiMetamodelArchiveAccess archiveAccess, MetaModelArchiveDescriptor archiveDescriptor, MoinArchiveHeader header ) {

        this.metamodelArchiveDescriptor = archiveDescriptor;
        this.archiveAccess = archiveAccess;
        this.archiveHeader = header;
    }

    /**
     * Initialize the metamodel info. Returns false if no metamodel is
     * available.
     * 
     * @param moin
     * @param loader
     * @return
     */
    public void load( Moin moin, IpiCustomSerializationClassLoader loader ) {

        try {
            switch ( metamodelArchiveDescriptor.getArchiveFormatVersion( ) ) {
                case VERSION_1:
                    this.initMetamodelProperties( moin, loader );
                    break;
                case VERSION_2:
                    this.initNewMetamodelProperties( moin, loader );
                    break;
                default:
                    // no metamodel archive data set
            }

            // update status listener
            this.enableDeployment( );

        } catch ( MoinDeploymentException e ) {
            _log.trace( e, MoinSeverity.FATAL, RuntimehostMessages.METAMODEL_PROPERTY_LOADING, new Object[] { this.archiveAccess.getArchiveId( ) } );
            this.disableDeployment( );
            throw e;
        }

    }

    public void registerStatusListener( StatusListener listener ) {

        this.statusListener = listener;
    }

    public String getArchiveId( ) {

        return this.archiveAccess.getArchiveId( );
    }

    public MetaModelArchiveDescriptor getMetaModelArchiveDescriptor( ) {

        return this.metamodelArchiveDescriptor;
    }

    private boolean checkCurrentCoreRuntimeVersionValid( SpiMoin moin ) {

        Version coreRuntimeVersion = this.getMmExtensionInstance( ).getCoreRuntimeVersion( );
        if ( coreRuntimeVersion.getMajor( ) != moin.getCoreRuntimeVersion( ).getMajor( ) ) {
            this.handleVersionDifference( );
            Object[] params = new Object[] { this.getContainerName( ), coreRuntimeVersion.toString( ), moin.getCoreRuntimeVersion( ).toString( ) };
            _log.trace( MoinSeverity.ERROR, RuntimehostMessages.METAMODEL_VERSION_CONFLICT, params );
            throw new MoinDeploymentException( RuntimehostMessages.METAMODEL_VERSION_CONFLICT, params );
        }
        return true;
    }

    /**
     * Returns the descriptive name of meta-model.
     * 
     * @return the descriptive name of meta-model.
     * @deprecated
     */
    @Deprecated
    public String getName( ) {

        return getContainerName( );
    }

    /**
     * Returns the descriptive name of meta-model.
     * 
     * @return the descriptive name of meta-model.
     */
    public String getContainerName( ) {

        if ( this.cri != null ) {
            return this.cri.getContainerName( );
        }

        return null;
    }

    public CRI getContainer( ) {

        return cri;
    }

    /**
     * Returns the descriptive name of meta-model.
     * 
     * @return descriptive name of meta-model.
     */
    public String getLabel( ) {

        return this.archiveHeader.getLabel( );
    }

    /**
     * Returns name of the meta-model vendor.
     * 
     * @return name of the meta-model vendor.
     */
    public String getVendor( ) {

        return this.archiveHeader.getVendor( );
    }

    public String getFacilityName( ) {

        return this.getMetaModelArchiveDescriptor( ).getFacilityName( );
    }

    /**
     * @deprecated
     */
    @Deprecated
    public String getDeployedMetaModelFacilityName( ) {

        // TODO Auto-generated method stub
        return null;
    }

    protected void initNewMetamodelProperties( Moin moin, IpiCustomSerializationClassLoader loader ) {

        if ( this.getMetaModelArchiveDescriptor( ) == null ) {
            throw new MoinDeploymentException( RuntimehostMessages.METAMODEL_PROPERTY_LOADING, new Object[] { this.archiveAccess.getArchiveId( ) } );
        }

        this.partitionFingerprints = new Hashtable<PRI, String>( );

        this.PRIs = new ArrayList<PRI>( );

        String facilityName = this.getMetaModelArchiveDescriptor( ).getFacilityName( );

        this.facility = (SpiFacility) moin.getFacilityById( facilityName );
        if ( this.facility == null ) {
            RuntimehostMessages message = RuntimehostMessages.FACILITY_DOES_NOT_EXIST;
            Object[] params = new Object[] { facilityName, MmInfoConst.MM2_METAMODEL_XML_FILE_NAME };
            message.format( facilityName, params );
            this.errorMessage( message.getLocalizedMessage( Locale.getDefault( ) ) );
            _log.trace( MoinSeverity.FATAL, message );

            throw new MoinDeploymentException( message, params );
        } else {
            if ( this.getMetaModelArchiveDescriptor( ).getContainerName( ) != null ) {
                this.cri = facility.getRIFactory( ).createCri( facility.getMetamodelDataArea( ).getName( ), this.getMetaModelArchiveDescriptor( ).getContainerName( ) );
            }
        }
        ResourceIdentifierFactory riFactory = facility.getRIFactory( );

        // actually not used, corresponding part set in MetaModelReceiver by method setMdExtensionInstance(DeploymentExtension)
        String deploymentExtensionClassName = this.getMetaModelArchiveDescriptor( ).getDeploymentExtensionClassName( );

        this.createDeploymentExtensionInstance( moin, loader, deploymentExtensionClassName );

        // for this part the partitionList originally is evaluated, PRIs, partitions and partModificationTimes are evaluated from there on demand
        Map<String, Long> partitionsMap = this.getMetaModelArchiveDescriptor( ).getPartitionHashes( );

        for ( Entry<String, Long> partName : partitionsMap.entrySet( ) ) {
            if ( riFactory != null && facility != null ) {
                PRI pri = riFactory.createPri( facility.getMetamodelDataArea( ).getName( ), this.getContainerName( ), partName.getKey( ) );

                this.PRIs.add( pri );
                this.partitionFingerprints.put( pri, partName.getKey( ) );
            }

            if ( partName.getValue( ) == 0 ) {
                _log.trace( MoinSeverity.WARNING, RuntimehostMessages.PARTITION_HASH_DETERMINATION_FAILED, partName.getKey( ) );
            }
        }
    }

    protected void initMetamodelProperties( Moin moin, IpiCustomSerializationClassLoader loader ) {

        if ( this.getMetaModelArchiveDescriptor( ) == null ) {
            throw new MoinDeploymentException( RuntimehostMessages.METAMODEL_PROPERTY_LOADING, this.archiveAccess.getArchiveId( ) );
        }

        if ( this.PRIs == null || this.partitionFingerprints == null ) {
            if ( this.partitionFingerprints != null ) {
                this.partitionFingerprints.clear( );
            } else {
                this.partitionFingerprints = new Hashtable<PRI, String>( );
            }
            if ( this.PRIs != null ) {
                this.PRIs.clear( );
            } else {
                this.PRIs = new ArrayList<PRI>( );
            }
        }

        String facilityName = this.getMetaModelArchiveDescriptor( ).getFacilityName( );

        this.facility = (SpiFacility) moin.getFacilityById( facilityName );
        if ( this.facility == null ) {
            RuntimehostMessages message = RuntimehostMessages.FACILITY_DOES_NOT_EXIST;
            Object[] params = new Object[] { facilityName, MmInfoConst.MM_PROPERTIES_FILE_NAME };
            _log.trace( MoinSeverity.FATAL, message, params );
            this.errorMessage( message.format( params ) );
            throw new MoinDeploymentException( RuntimehostMessages.FACILITY_DOES_NOT_EXIST, params );

        } else {
            if ( this.getMetaModelArchiveDescriptor( ).getContainerName( ) != null ) {
                this.cri = facility.getRIFactory( ).createCri( facility.getMetamodelDataArea( ).getName( ), this.archiveHeader.getContainerName( ) );
            }
        }
        ResourceIdentifierFactory riFactory = facility.getRIFactory( );

        this.createDeploymentExtensionInstance( moin, loader, this.getMetaModelArchiveDescriptor( ).getDeploymentExtensionClassName( ) );

        // for this part the partitionList originally is evaluated, PRIs, partitions and partModificationTimes are evaluated from there on demand
        Map<String, Long> partitionsMap = this.getMetaModelArchiveDescriptor( ).getPartitionHashes( );
        for ( String partName : partitionsMap.keySet( ) ) {

            if ( riFactory != null && facility != null ) {
                PRI pri = riFactory.createPri( facility.getMetamodelDataArea( ).getName( ), this.getContainerName( ), partName );

                this.PRIs.add( pri );
                this.partitionFingerprints.put( pri, partName );
            }
        }

    }

    private void createDeploymentExtensionInstance( Moin moin, IpiCustomSerializationClassLoader loader, String extensionClassName ) {

        try {
            // Obtain meta-model deployment extension class
            Class<?> extensionClass = loader.loadClass( extensionClassName );
            Object mmEI = extensionClass.newInstance( );

            if ( mmEI instanceof DeploymentExtension ) {
                this.setMmExtensionInstance( (DeploymentExtension) mmEI );

                // Check the meta-model and MOIN runtime version            
                this.checkCurrentCoreRuntimeVersionValid( (SpiMoin) moin );
            } else {

                _log.trace( MoinSeverity.FATAL, RuntimehostMessages.EXTENSION_CLASS_WRONG_INTERFACE, extensionClassName, this.archiveAccess.getArchiveId( ) );
                this.disableDeployment( );
            }


        } catch ( Error e ) {
            // probably a binary incompatible change in meta-model deployment extension interface
            _log.trace( e, MoinSeverity.FATAL, RuntimehostMessages.EXTENSION_CLASS_INSTANTIATION_ERROR, this.getContainerName( ) );
            throw new MoinDeploymentException( e, RuntimehostMessages.EXTENSION_CLASS_INSTANTIATION_ERROR, this.getContainerName( ) );
        } catch ( ClassNotFoundException e ) {
            Object[] parameters = new String[] { extensionClassName, this.getContainerName( ) };
            _log.trace( e, MoinSeverity.FATAL, RuntimehostMessages.EXTENSION_CLASS_NOT_FOUND, parameters );
            throw new MoinDeploymentException( e, RuntimehostMessages.EXTENSION_CLASS_NOT_FOUND, parameters );
        } catch ( InstantiationException e ) {
            Object[] parameters = new String[] { extensionClassName, this.getContainerName( ) };
            _log.trace( e, MoinSeverity.FATAL, RuntimehostMessages.EXTENSION_CLASS_INSTANTIATION_EXCEPTION, parameters );
            throw new MoinDeploymentException( e, RuntimehostMessages.EXTENSION_CLASS_INSTANTIATION_EXCEPTION, parameters );
        } catch ( IllegalAccessException e ) {
            Object[] parameters = new String[] { extensionClassName, this.getContainerName( ) };
            _log.trace( e, MoinSeverity.FATAL, RuntimehostMessages.EXTENSION_CLASS_ILLEGAL_ACCESS, parameters, e );
            throw new MoinDeploymentException( e, RuntimehostMessages.EXTENSION_CLASS_ILLEGAL_ACCESS, parameters );
        }

    }

    /**
     * Return the collection of metamodel PRIs.
     * 
     * @param facility used facility
     * @return collection of metamodel PRIs
     */
    public Collection<PRI> getPRIs( ) {

        if ( this.PRIs != null && !this.PRIs.isEmpty( ) ) {
            return this.PRIs;
        }

        ResourceIdentifierFactory riFactory = facility.getRIFactory( );

        if ( this.getMetaModelArchiveDescriptor( ).getPartitionHashes( ) == null ) {
            Object[] params = new Object[] { MmInfoConst.MM2_PARTITION_LIST, MmInfoConst.MM2_METAMODEL_XML_FILE_NAME, this.archiveAccess.getArchiveId( ) };
            RuntimehostMessages message = RuntimehostMessages.METAMODEL_PARTITIONS_NOT_SET;
            _log.trace( MoinSeverity.FATAL, message, params );
            this.disableDeployment( );
            this.errorMessage( message.format( params ) );
            return this.PRIs;
        }

        for ( String partitionName : this.getMetaModelArchiveDescriptor( ).getPartitionHashes( ).keySet( ) ) {
            PRI pri = riFactory.createPri( facility.getMetamodelDataArea( ).getName( ), this.getContainerName( ), partitionName );

            this.PRIs.add( pri );
            this.partitionFingerprints.put( pri, partitionName );
        }

        return this.PRIs;
    }

    /**
     * Returns the metamodel input stream for particular PRI.
     * 
     * @param pri PRI
     * @return metamodel input stream for particular PRI
     */
    public InputStream getPartitionStream( PRI pri ) {

        if ( this.partitionFingerprints == null /* || this.timeStamps == null */) {
            // partitions or time stamp table not initialized
            MoinLocalizedString message = RuntimeHostDeploymentMessages.PARTITIONINFORMATIONNOTINITIALIZED;
            _log.trace( MoinSeverity.ERROR, message, pri );
            throw new MMDeploymentRuntimeException( message, pri );
        }

        try {
            String xmiName = this.partitionFingerprints.get( pri );

            return this.archiveAccess.getResourceAsStream( xmiName );

        } catch ( IOException e ) {
            _log.trace( MoinSeverity.ERROR, RuntimeHostDeploymentMessages.GETPARTITIONSTREAMFAILED );
            throw new MMDeploymentRuntimeException( e, RuntimeHostDeploymentMessages.GETPARTITIONSTREAMFAILED );
        }

    }

    /**
     * Returns the version of currently deployed in Moin meta-model (meta-model
     * definition stored in Moin).
     * 
     * @return the version of currently deployed in Moin meta-model.
     */
    public MetaModelVersion getDeployedMetaModelVersion( ) {

        return this.deployedVersion;
    }

    /**
     * Sets the version of currently deployed in Moin meta-model (meta-model
     * definition stored in Moin). The version is read from the archive.
     * 
     * @param version
     */
    public void updateDeployedMetaModelVersion( ) {

        this.deployedVersion = this.metamodelArchiveDescriptor.getVersion( );
    }

    /**
     * @return the path to archive containing the main XMI file. Is
     * <code>null</code> in case both XMI and properties file are not packaged
     * in an archive.
     * @see #getMainXmiFilePath()
     * @deprecated
     */
    @Deprecated
    public String getXmiArchivePath( ) {

        return ""; //$NON-NLS-1$
    }

    /**
     * Returns the metamodel facility.
     * 
     * @return metamodel facility.
     */
    public SpiFacility getFacility( ) {

        return this.facility;
    }

    /**
     * Returns the time-stamp (last modified time) of the particular partition
     * (PRI). <br>
     * The current implementation returns the same time-stamp (based on the last
     * modification of the related bundle) for all partitions of this meta
     * model.
     * 
     * @param pri partition
     * @return timestamp (last modified time) of particular partition (PRI).
     */
    public long getTimeStamp( PRI pri ) {

        Long modifTime = this.getMetaModelArchiveDescriptor( ).getPartitionHashes( ).get( pri.getPartitionName( ) );
        if ( modifTime != null && modifTime != 0 ) {
            return modifTime;
        }
        _log.trace( MoinSeverity.ERROR, RuntimehostMessages.PARTITION_HASH_DETERMINATION_FAILED, pri );

        // Get last modification time from meta-model plug-in
        return this.archiveAccess.getLastModified( );
    }

    /**
     * Returns the meta-model deployment extension object.
     * 
     * @return deployment extension object.
     */
    public DeploymentExtension getMmExtensionInstance( ) {

        return this.mmExtensionInstance;
    }

    public void setMmExtensionInstance( DeploymentExtension extensionInstance ) {

        this.mmExtensionInstance = extensionInstance;
    }

    public String getMetaModelResourceBundleName( ) {

        // get bundle name from archive descriptor
        MetaModelArchiveDescriptor mmArchiveDescriptor = getMetaModelArchiveDescriptor( );
        if ( mmArchiveDescriptor != null ) {
            String bundleName = mmArchiveDescriptor.getMetaModelResourceBundleName( );
            if ( bundleName != null && bundleName.length( ) > 0 ) {
                return bundleName;
            }
        }
        // use default bundle name
        return MmInfoConst.MM_RESOURCEBUNDLE_NAME;
    }

    public interface StatusListener {

        public void handleVersionDifference( );

        public void disableDeployment( );

        public void disableDeployment( Exception reason );

        public void enableDeployment( );

        public void errorMessage( String message );

        public void setDeployed( );

    }

    public void errorMessage( String message ) {

        if ( this.statusListener != null ) {
            this.statusListener.errorMessage( message );
        }
    }

    public void handleVersionDifference( ) {

        if ( this.statusListener != null ) {
            this.statusListener.handleVersionDifference( );
        }
    }

    public void disableDeployment( ) {

        if ( this.statusListener != null ) {
            this.statusListener.disableDeployment( );
        }
    }

    public void enableDeployment( ) {

        if ( this.statusListener != null ) {
            this.statusListener.enableDeployment( );
        }
        this.updateDeployedMetaModelVersion( );
    }

    public void setDeployed( ) {

        if ( this.statusListener != null ) {
            this.statusListener.setDeployed( );
        }
    }

}
