/**
 * 
 */
package com.sap.tc.moin.repository.runtimehost.deployment;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.ResourceIdentifierFactory;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.runtimehost.MmInfoConst;
import com.sap.tc.moin.repository.shared.util.StringUtils;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;
import com.sap.tc.moin.repository.spi.facility.SpiPartitionContentRecord;
import com.sap.tc.moin.repository.spi.runtimehost.deployment.SpiContentDeploymentData;
import com.sap.tc.moin.repository.spi.runtimehost.deployment.SpiRegistrationContentRecord;


/**
 * Implementation of the {@link SpiContentDeploymentData} interface.
 * <p>
 * This class uses a {@link IpiMetamodelArchiveAccess} instance internally to
 * extract information from a meta-model archive. In addition, it has a runtime
 * dependency to Moin to construct facility-dependent {@link PRI}s and
 * {@link CRI}s.
 * <p>
 * <b>Note</b>: this class is currently only relevant for the server scenario
 * and would better be part of the server-side runtimehost implementation. But
 * we have unit tests in the hybrid test scenario which require both the SPI
 * interface as well as the implementation.
 */
public class ContentDeploymentDataImpl implements SpiContentDeploymentData {

    private IpiMetamodelArchiveAccess contentArchive;

    private ResourceIdentifierFactory riFactory;

    private String dataAreaName;

    private CRI cri;

    private List<SpiPartitionContentRecord> partitonContentRecordList;

    private List<SpiRegistrationContentRecord> registrationContentRecordList;

    private class PartitionContentRecordImpl implements SpiPartitionContentRecord {

        IpiMetamodelArchiveAccess archive;

        // pri 
        private PRI pri;

        public PartitionContentRecordImpl( IpiMetamodelArchiveAccess archive, String partitionName ) {

            this.archive = archive;
            this.pri = createPri( partitionName );
        }

        public InputStream getContentInputStream( ) throws IOException {

            return this.archive.getResourceAsStream( this.pri.getPartitionName( ) );
        }

        public long getContentLength( ) {

            return this.archive.getContentLength( this.pri.getPartitionName( ) );
        }

        public PRI getPri( ) {

            return this.pri;
        }
    }

    private static class RegistrationContentRecordImpl implements SpiRegistrationContentRecord {

        private IpiMetamodelArchiveAccess archive;

        private String contentName;

        public RegistrationContentRecordImpl( IpiMetamodelArchiveAccess archive, String registrationName ) {

            this.contentName = registrationName;
            this.archive = archive;
        }

        public String getRegistrationContentName( ) {

            return this.contentName;
        }

        public InputStream getContentInputStream( ) throws IOException {

            return this.archive.getResourceAsStream( this.contentName );
        }

        public long getContentLength( ) {

            return this.archive.getContentLength( this.contentName );
        }
    }

    /**
     * Constructs a content deployment data instance for the specified
     * meta-model archive.
     * 
     * @param moin the Moin instance (needed for getting the facility)
     * @param contentArchive the corresponding content archive
     * @throws IOException if reading from the archive fails
     */
    public ContentDeploymentDataImpl( Moin moin, MoinArchiveInfoImpl archiveInfo ) throws IOException {

        if ( archiveInfo == null ) {
            throw new MoinIllegalArgumentException( RuntimeHostDeploymentMessages.CANNOTCONSTRUCTJSCONTENTDEPLOYMENTDATA__PARAMETERCONTENTARCHIVEMUSTNOTBENULL );
        }
        // set the archive
        this.contentArchive = archiveInfo.getArchiveAccess( );

        // create registration file list
        this.registrationContentRecordList = new ArrayList<SpiRegistrationContentRecord>( );
        for ( String registrationName : MmInfoConst.resourceList ) {
            if ( this.contentArchive.resourceExists( registrationName ) ) {
                this.registrationContentRecordList.add( new RegistrationContentRecordImpl( this.contentArchive, registrationName ) );
            }
        }

        // set the RI factory
        MetaModelArchiveDescriptor metamodelArchiveDescriptor = archiveInfo.getArchiveDescriptor( ).getMetamodelArchiveDescriptor( );

        // if metamodelArchiveDescriptor is null, this is a standalone extension
        if ( metamodelArchiveDescriptor != null ) {
            String facilityId = metamodelArchiveDescriptor.getFacilityName( );
            SpiFacility facility = (SpiFacility) moin.getFacilityById( facilityId );
            if ( facility == null ) {
                throw new MoinIllegalStateException( RuntimeHostDeploymentMessages.REFERENCEDFACILITYNOTFOUND, facilityId, contentArchive );
            }

            this.riFactory = facility.getRIFactory( );

            // set the data area name (for now, this is always meta-model)
            this.dataAreaName = facility.getMetamodelDataArea( ).getName( );

            // set the CRI
            this.cri = riFactory.createCri( dataAreaName, metamodelArchiveDescriptor.getName( ) );

            List<String> partitionNames = metamodelArchiveDescriptor.getPartitionNameList( );

            this.partitonContentRecordList = new ArrayList<SpiPartitionContentRecord>( partitionNames.size( ) );
            for ( String partitionName : partitionNames ) {
                this.partitonContentRecordList.add( new PartitionContentRecordImpl( this.contentArchive, partitionName ) );
            }
        }


    }

    public boolean hasMetamodel( ) {

        return ( this.partitonContentRecordList != null );
    }

    /**
     * @see com.sap.tc.moin.repository.spi.facility.js.deployment.SpiContentDeploymentData#getCri()
     */
    public CRI getCri( ) {

        return cri;
    }

    /**
     * @see com.sap.tc.moin.repository.spi.facility.js.deployment.SpiContentDeploymentData#getPartitionContentRecords()
     */
    public List<SpiPartitionContentRecord> getPartitionContentRecords( ) {

        ensureOpen( );
        return partitonContentRecordList;
    }

    public List<SpiRegistrationContentRecord> getRegistrationContentRecords( ) {

        ensureOpen( );
        return this.registrationContentRecordList;
    }


    /**
     * Closes this data object and frees all used resources (especially the
     * referenced content archive). Only the CRI is remained to have an identity
     * even for closed instances.
     */
    public void close( ) {

        if ( this.contentArchive != null ) {
            try {
                this.contentArchive.close( );
            } catch ( IOException e ) {
                throw new RuntimeException( e );
            }
        }

        this.partitonContentRecordList = null;
    }


//    protected MetaModelArchiveDescriptor getMmArchiveDescriptor( ) {
//
//        return this.contentArchive.getArchiveDescriptor( ).getMetamodelArchiveDescriptor( );
//    }

    /**
     * Creates a PRI from a container-relative partition name
     * 
     * @param partitonName the partition name (container-relative path)
     * @return a PRI for the specified partition name
     */
    protected PRI createPri( String partitionName ) {

        return this.riFactory.createPri( this.dataAreaName, this.getCri( ).getContainerName( ), partitionName );
    }

    /**
     * Ensures that the data object is still open.
     * 
     * @throws IllegalStateException if the instance was already closed
     */
    protected void ensureOpen( ) {

        if ( this.contentArchive == null ) {
            throw new MoinIllegalStateException( RuntimeHostDeploymentMessages.CONTENTDEPLOYMENTDATAFORCONTAINERARECLOSED, this.cri );
        }
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString( ) {

        return StringUtils.concatenateUnsynced( super.toString( ), "; CRI=", this.cri, "; archive=", this.contentArchive ); //$NON-NLS-1$ //$NON-NLS-2$
    }


    /**
     * @return the contentArchive
     */
//    public MoinArchiveInfoImpl getContentArchive( ) {
//
//        return contentArchive;
//    }
}
