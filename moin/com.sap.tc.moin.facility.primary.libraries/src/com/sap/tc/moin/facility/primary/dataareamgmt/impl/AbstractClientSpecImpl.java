package com.sap.tc.moin.facility.primary.dataareamgmt.impl;

import com.sap.tc.moin.facility.primary.ipi.IpiDataArea;
import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.DataArea;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.core.SpiResourceInfo;
import com.sap.tc.moin.repository.spi.core.SpiStage;
import com.sap.tc.moin.repository.spi.core.SpiStageService;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;
import com.sap.tc.moin.repository.spi.facility.SpiFacilityException;

/**
 * Scenario-independent and persistence-independent parts of the client spec
 * implementation, basis class for the scenario-dependent client spec
 * implementations, e.g. Fs/Db/JsClientSpecImpl.
 * 
 * @author d021091
 */

public abstract class AbstractClientSpecImpl implements SpiClientSpec {

    /** ******************** Internals ************************************** */

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_PRIMARY_FACILITY, MoinLocationEnum.MOIN_FACILITIES_DATA_AREA_MANAGEMENT, AbstractClientSpecImpl.class );

    private IpiDataArea _dataArea;

    private String _clientSpecId;

    private SpiStageService _coreStageFactory;

    /** ******************** Construction *********************************** */

    protected AbstractClientSpecImpl( SpiStageService coreStageFactory, IpiDataArea dataArea, String clientSpecId ) {

        _dataArea = dataArea;

        _clientSpecId = clientSpecId;

        _coreStageFactory = coreStageFactory;
    }

    /** ******************** ClientSpec ************************************* */

    public String getClientId( ) {

        return _clientSpecId;
    }

    public DataArea getDataArea( ) {

        return _dataArea;
    }

    /**
     * Convenience variant of {@link #getDataArea}.
     * 
     * @return
     */
    protected IpiDataArea getIpiDataArea( ) {

        return _dataArea;
    }

    /** ******************** SpiClientSpec ********************************** */

    public SpiResourceInfo getResourceInfo( PRI pri ) throws SpiFacilityException {

        // Check preconditions: validate input parameter
        if ( pri == null ) {
            MoinIllegalArgumentException e = new MoinIllegalArgumentException( "getResourceInfo", "pri", "null" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            LOGGER.trace( e, MoinSeverity.DEBUG, e.getMessage( ) );
            throw e;
        }

        // Determine the resource info based on the stage of respective partition:
        return _coreStageFactory.createResourceInfo( pri, getStageForPri( pri ) );
    }

    public SpiResourceInfo getResourceInfo( LRI lri ) throws SpiFacilityException {

        // Get the PRI for the LRI:
        PRI pri = getPriForLri( lri );
        if ( pri == null ) {
            // model object with lri was not yet saved
            // --> index does not contain the LRI --> PRI mapping
            // --> caller has to resolve based on transient state
            return null;
        }
        return getResourceInfo( pri );

    }

    private PRI getPriForLri( LRI lri ) {

        // Determine the PRI for LRI from the Persistence, i.e. more exactly: from the respective index
        // FIXME does this make sense? What if the LRI does not exist within this clientspec?
        return ( (SpiFacility) getIpiDataArea( ).getFacility( ) ).getCoreQueryService( ).getPriForLri( new ClientSpec[] { this }, lri );
    }

    /** ******************** Object ***************************************** */

    // equals and hashCode should be overwritten in derived classes
    @Override
    public abstract boolean equals( Object obj );

    @Override
    public abstract int hashCode( );

    @Override
    public String toString( ) {

        String dataAreaName = getDataArea( ).getName( );
        String clientId = getClientId( );
        StringBuffer sb = new StringBuffer( dataAreaName.length( ) + clientId.length( ) + 4 );
        sb.append( clientId ).append( " in " ).append( dataAreaName ); //$NON-NLS-1$
        return sb.toString( );
    }

    protected abstract SpiStage getStageForPri( PRI pri );

}
