package com.sap.tc.moin.facility.primary;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.facility.primary.ipi.IpiFacilityComponent;
import com.sap.tc.moin.facility.primary.ipi.IpiPrimaryFacility;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.spi.core.SpiCore;
import com.sap.tc.moin.repository.spi.facility.SpiFacilityLifecycle;
import com.sap.tc.moin.repository.spi.runtimehost.context.SpiRuntimeContext;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;

public abstract class AbstractPrimaryFacility implements IpiPrimaryFacility, SpiFacilityLifecycle {

    // trace setup
    private static final MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_PRIMARY_FACILITY, MoinLocationEnum.MOIN_FACILITIES_PRIMARY, AbstractFsPrimaryFacility.class );

    // facility components are kept in a list
    protected List<IpiFacilityComponent> facilityComponents;

    // the Moin Core Proxy is provided to all Primary Facilities
    protected SpiCore core;

    protected SpiPartitionSerializationManager partitionSerializationManager;

    protected SpiRuntimeContext runtimeContext;

    public AbstractPrimaryFacility( SpiCore core, SpiPartitionSerializationManager serializationManager, SpiRuntimeContext runtimeContext ) {

        this.facilityComponents = new ArrayList<IpiFacilityComponent>( 20 );
        this.core = core;
        this.partitionSerializationManager = serializationManager;
        this.runtimeContext = runtimeContext;
    }

    /**
     * initialize delegates to sub-components. Is invoked after component
     * binding
     */
    public void initialize( ) {

        for ( IpiFacilityComponent facilityComponent : facilityComponents ) {
            facilityComponent.initialize( );
        }
    }

    /**
     * Shutdown delegates to sub-components
     */
    public void tearDown( ) {

        for ( IpiFacilityComponent facilityComponent : facilityComponents ) {
            facilityComponent.tearDown( );
        }
    }

    /**
     * finalize startup delegates to sub-components. Is invoked after meta-model
     * deployment
     */
    public void finalizeStartup( ) {

        for ( IpiFacilityComponent facilityComponent : facilityComponents ) {
            facilityComponent.finalizeStartup( );
        }
    }

    public SpiPartitionSerializationManager getPartitionSerializationManager( ) {

        return partitionSerializationManager;
    }


    public SpiRuntimeContext getRuntimeContext( ) {

        return runtimeContext;
    }


}
