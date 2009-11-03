package com.sap.tc.moin.facility.primary.dataareamgmt.impl;

import com.sap.tc.moin.facility.primary.ipi.IpiDataArea;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;

/**
 * Simple handling of data areas and client specs:
 * <p>
 * - for scenarios with single stage (e.g. IDE scenario, pure QueryServer
 * scenario)
 * <p>
 * - with simple mapping: each data area has exactly 1 client spec with the same
 * name
 * <p>
 * - no user-handling (independent of the client).
 * <p>
 * It provides:
 * <p>
 * - creation and deletion of regular and special data areas.
 * <p>
 * Remark:
 * <p>
 * A special data area is e.g. the meta model data area which is handled in a
 * special way. A regular data area is e.g. a data area for a given
 * configuration (in NWDI: DevConfig).
 * 
 * @author d021091
 */

public class SimpleDataAreaManagerImpl extends AbstractDataAreaManagerImpl {

    /** ******************** Internals ************************************** */

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_PRIMARY_FACILITY, MoinLocationEnum.MOIN_FACILITIES_DATA_AREA_MANAGEMENT, SimpleDataAreaManagerImpl.class );

    /** ******************** Construction *********************************** */

    public SimpleDataAreaManagerImpl( ) {

        super( );
    }

    /** ******************** DataAreaManagerImpl **************************** */

    public IpiDataArea createRegularDataArea( String dataAreaName ) {

        DataAreaDescriptor dataAreaDescriptor = _dataAreaDescriptorFactory.createDataAreaDescriptor( dataAreaName );
        return createDataArea( dataAreaDescriptor, IpiDataArea.Kind.Regular );
    }

    @Override
    protected IpiDataArea createDataArea( DataAreaDescriptor dataAreaDescriptor, IpiDataArea.Kind kind ) {

        if ( _dataAreaMap.get( dataAreaDescriptor.getDataAreaName( ) ) != null ) {
            // Message: "Internal Error: Data area "{0}" already exists"
            MoinIllegalStateException e = new MoinIllegalStateException( DataAreaMgmtMessages.INTERNAL_ERROR_DATA_AREA_EXISTS, dataAreaDescriptor.getDataAreaName( ) );
            LOGGER.trace( e, MoinSeverity.DEBUG, e.getMessage( ) );
            throw e;

        }

        SimpleDataAreaImpl dataArea = new SimpleDataAreaImpl( _facility, _coreStageFactory, dataAreaDescriptor, kind );
        _dataAreaMap.put( dataAreaDescriptor.getDataAreaName( ), dataArea );
        return dataArea;
    }

    @Override
    public void deleteDataArea( String dataAreaName ) {

        // Use case:
        // In IDE scenario the user can remove a development configuration import. 
        // Then MOIN has to remove the respective generated MOIN-clientSpec and the respective data-area 
        // and it has to adapt the internal state (indexed data, transient workspaces, ...).
        // This method is only responsible for the actual deletion of the data area and the respective client-specs.
        // The adaptation of the state is done by DiService.

        // Delete the data area:
        _dataAreaMap.remove( dataAreaName );
    }
}
