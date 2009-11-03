package com.sap.tc.moin.facility.primary.dataareamgmt.impl;

import com.sap.tc.moin.facility.primary.ipi.IpiDataArea;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.shared.util.ObjectMethodsHelper;
import com.sap.tc.moin.repository.spi.core.SpiStage;
import com.sap.tc.moin.repository.spi.core.SpiStageService;

/**
 * The simple client spec realizes a simple 1-stage realization for the client
 * spec. It provides:
 * <p>
 * - getStageForPri, based on the fact that only client specs with single-stage
 * are supported
 * <p>
 * - hashCode, equals,
 * <p>
 * - but it does not provide any user handling.
 * <p>
 * It can be used e.g. in scenarios with file system or in the pure QueryServer
 * scenario.
 * 
 * @author d021091
 */

public class SimpleClientSpecImpl extends AbstractClientSpecImpl {

    /** ******************** Internals ************************************** */

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_PRIMARY_FACILITY, MoinLocationEnum.MOIN_FACILITIES_DATA_AREA_MANAGEMENT, SimpleClientSpecImpl.class );

    /** ******************** Construction *********************************** */

    SimpleClientSpecImpl( SpiStageService coreStageFactory, IpiDataArea dataArea, String clientSpecId ) {

        super( coreStageFactory, dataArea, clientSpecId );
    }


    /** ******************** AbstractClientSpecImpl ************************* */

    @Override
    protected SpiStage getStageForPri( PRI pri ) {

        IpiDataArea dataArea = getIpiDataArea( );

        // Check if the client-spec is responsible for the PRI:
        if ( !pri.getDataAreaDescriptor( ).equals( dataArea.getDescriptor( ) ) ) {
            // Message: "The partition "{0}" does not belong to the data area "{1}"."
            MoinIllegalArgumentException e = new MoinIllegalArgumentException( DataAreaMgmtMessages.PRI_DOES_NOT_BELONG_TO_DATAAREA, pri.toString( ), dataArea.getName( ) );
            LOGGER.trace( e, MoinSeverity.DEBUG, e.getMessage( ) );
            throw e;
        }

        if ( dataArea.hasSingleStageOnly( ) ) {
            return dataArea.getSingleStage( );

        } else {
            // Message: "Message: "Internal error\: The data area of partition [{0}] is not supported because it has multiple stages"
            MoinIllegalStateException e = new MoinIllegalStateException( DataAreaMgmtMessages.INTERNAL_ERROR_MULTIPLE_STAGES_NOT_SUPPORTED, pri.toString( ) );
            LOGGER.trace( e, MoinSeverity.DEBUG, e.getMessage( ) );
            throw e;
        }
    }

    /** ******************** SpiClientSpec ********************************** */

    public SpiStage getClientSpecificStage( ) {

        return getIpiDataArea( ).getClientSpecificStage( getClientId( ) );
    }

    /** ******************** Object ***************************************** */

    @Override
    public boolean equals( Object obj ) {

        if ( obj != null && obj instanceof SimpleClientSpecImpl ) {
            SimpleClientSpecImpl otherClientSpec = (SimpleClientSpecImpl) obj;
            if ( ObjectMethodsHelper.equals( getClientId( ), otherClientSpec.getClientId( ) ) && ObjectMethodsHelper.equals( getDataArea( ), otherClientSpec.getDataArea( ) ) ) {
                // not needed in scenarios with 1 user:
                // && ObjectMethodsHelper.equals( getUserId( ),
                // otherClientSpec.getUserId( ) )
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode( ) {

        // HashCode based on client-id should be unique in scenarios with 1 user
        return getClientId( ).hashCode( );
    }

    @Override
    public String toString( ) {

        return getClientId( );
    }
}
