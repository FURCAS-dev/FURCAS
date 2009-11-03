package com.sap.tc.moin.facility.primary.metamodelmanager;

import java.util.List;

import com.sap.tc.moin.facility.primary.ipi.IpiFacilityComponent;
import com.sap.tc.moin.facility.primary.ipi.IpiIndexManagement;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.facility.SpiMofRomInjectionService;


public class IndexMofRomInjectionServiceImpl implements IpiFacilityComponent, SpiMofRomInjectionService {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_PRIMARY_FACILITY, MoinLocationEnum.MOIN_FACILITIES_PRIMARY, IndexMofRomInjectionServiceImpl.class );

    /**
     * The index to supply with MOFROM content
     */
    private IpiIndexManagement indexManager;

    public void bind( IpiIndexManagement indexManager ) {

        this.indexManager = indexManager;
    }

    public void injectMofRomPartitions( List<SpiMofRomPartitionContent> mofRomPartitions ) {

        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            StringBuilder sb = new StringBuilder( "Inject MOF-Rom partitions:" ); //$NON-NLS-1$
            for ( SpiMofRomPartitionContent record : mofRomPartitions ) {
                sb.append( "\n\t[ " ); //$NON-NLS-1$
                sb.append( record.toString( ) );
                sb.append( " ]" ); //$NON-NLS-1$
            }
            LOGGER.trace( MoinSeverity.DEBUG, sb.toString( ) );
        }

        for ( SpiMofRomPartitionContent partitionContent : mofRomPartitions ) {
            this.indexManager.indexMofRomPartition( partitionContent, System.currentTimeMillis( ) );
        }
    }

    public void finalizeStartup( ) {

        // TODO Auto-generated method stub

    }

    public void initialize( ) {

        // TODO Auto-generated method stub

    }

    public void tearDown( ) {

        // TODO Auto-generated method stub

    }

}
