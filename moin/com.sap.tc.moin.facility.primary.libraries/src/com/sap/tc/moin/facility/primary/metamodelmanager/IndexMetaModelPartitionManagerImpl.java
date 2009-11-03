package com.sap.tc.moin.facility.primary.metamodelmanager;

import java.util.List;

import com.sap.tc.moin.facility.primary.ipi.IpiDataAreaManager;
import com.sap.tc.moin.facility.primary.ipi.IpiFacilityComponent;
import com.sap.tc.moin.facility.primary.ipi.IpiIndexManagement;
import com.sap.tc.moin.facility.primary.ipi.IpiIndexManagement.SyncReport;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;

public class IndexMetaModelPartitionManagerImpl extends MetaModelPartitionManagerImpl implements IpiFacilityComponent {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_PRIMARY_FACILITY, MoinLocationEnum.MOIN_FACILITIES_PRIMARY, IndexMetaModelPartitionManagerImpl.class );

    /**
     * The index to supply with metamodel partition content
     */
    private IpiIndexManagement indexManager;

    private IpiDataAreaManager dataAreaManager;

    public IndexMetaModelPartitionManagerImpl( ) {

    }

    public void bind( IpiIndexManagement indexManager ) {

        this.indexManager = indexManager;
    }

    public void bind( IpiDataAreaManager dataAreaManager ) {

        this.dataAreaManager = dataAreaManager;
    }

    public void finalizeStartup( ) {

    }

    public void initialize( ) {

    }

    public void tearDown( ) {

    }

    public List<PRI> setDeployedMetamodelPartitions( List<MetaModelPartitionDeploymentRecord> metamodelPartitions ) {

        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            StringBuilder sb = new StringBuilder( "Deploy Metamodels:" ); //$NON-NLS-1$
            for ( MetaModelPartitionDeploymentRecord record : metamodelPartitions ) {
                sb.append( "\n\t[ " ); //$NON-NLS-1$
                sb.append( record.pri.toString( ) );
                sb.append( " , timestamp=" ); //$NON-NLS-1$
                sb.append( record.timestamp );
                sb.append( " ]" ); //$NON-NLS-1$
            }
            LOGGER.trace( MoinSeverity.DEBUG, sb.toString( ) );
        }

        // define arrays for indexing
        PRI pris[] = new PRI[metamodelPartitions.size( )];
        long timestamps[] = new long[metamodelPartitions.size( )];

        // process given data
        int i = 0;
        for ( MetaModelPartitionDeploymentRecord metamodelPartition : metamodelPartitions ) {
            // register PRI to stream provider mapping
            this.metamodelPartitionToStreamProvider.put( metamodelPartition.pri, metamodelPartition.streamProvider );
            // copy copy indexing information into arrays
            pris[i] = metamodelPartition.pri;
            timestamps[i] = metamodelPartition.timestamp;
            i++;
        }

        // update the index (we expect the index to report empty lists and not null)
//        SyncReport sr = indexManager.synchronize( SyncKind.METAMODEL_CONTENT, pris, timestamps, this, false );
        SyncReport sr = indexManager.synchronize( pris, timestamps, this, false, this.dataAreaManager.getMetaModelDataArea( ).getDescriptor( ) );

        // unregister defective partitions that could not be indexed
        for ( PRI defectivePartition : sr.EXCEPTION ) {
            this.metamodelPartitionToStreamProvider.remove( defectivePartition );
        }

        // return list of partitions that could not be indexed
        return sr.EXCEPTION;
    }

    @Override
    public void removeDeployedMetamodelPartitions( CRI metamodelCri ) {

        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, "Remove deployed metamodel CRI=" + metamodelCri.toString( ) ); //$NON-NLS-1$
        }

        // remove metamodel partitions from  
        super.removeDeployedMetamodelPartitions( metamodelCri );

        // remove all partitions in the given container from the index
        // (use forced synchronize() with empty parameter lists as bulk operation)
        PRI[] emptyPris = new PRI[0];
        long[] emptyTimestamps = new long[0];
        indexManager.synchronize( emptyPris, emptyTimestamps, this, true, metamodelCri );
    }

}
