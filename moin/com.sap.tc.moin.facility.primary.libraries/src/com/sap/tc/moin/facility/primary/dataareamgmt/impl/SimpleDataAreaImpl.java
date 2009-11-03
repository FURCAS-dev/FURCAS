package com.sap.tc.moin.facility.primary.dataareamgmt.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.facility.primary.ipi.IpiDataArea;
import com.sap.tc.moin.facility.primary.ipi.IpiPrimaryFacility;
import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.DataArea;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.Facility;
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
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;

/**
 * The simple data area implementation providesa simple management for the
 * client-specs of the data area:
 * <p>
 * - there is exactly one client
 * <p>
 * - for regular data areas as well as for the meta model data area
 * <p>
 * - with non-persistent client-specs (i.e. client specs are handled only
 * transiently in the respective data area).
 * <p>
 * - hashCode, equals
 * <p>
 * It can be e.g. used in file system based scenarios (e.g. IDE scenario) and in
 * the pure QueryServer scenario.
 * 
 * @author d021091
 */
public class SimpleDataAreaImpl extends AbstractDataAreaImpl {

    /** ******************** Internals ************************************** */

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_PRIMARY_FACILITY, MoinLocationEnum.MOIN_FACILITIES_DATA_AREA_MANAGEMENT, SimpleDataAreaImpl.class );

    private SpiClientSpec _clientSpec;

    private SpiStage _stage;

    private int _hashCode;

    /** ******************** Construction *********************************** */

    SimpleDataAreaImpl( Facility facility, SpiStageService coreStageFactory, DataAreaDescriptor dataAreaDescriptor, IpiDataArea.Kind dataAreaKind ) {

        super( facility, dataAreaDescriptor, dataAreaKind );
        _hashCode = ObjectMethodsHelper.hashCode( getName( ) );
        String clientId;
        switch ( dataAreaKind ) {
            case Metamodel:
                clientId = dataAreaDescriptor.getDataAreaName( );
                _clientSpec = new SimpleClientSpecImpl( coreStageFactory, this, clientId );
                _stage = coreStageFactory.createSharedStage( dataAreaDescriptor, IpiPrimaryFacility.METAMODEL_STAGE_ID );

                break;

            case Transient:
                clientId = dataAreaDescriptor.getDataAreaName( );
                _clientSpec = new SimpleClientSpecImpl( coreStageFactory, this, clientId );
                _stage = coreStageFactory.createClientSpecificStage( dataAreaDescriptor, clientId, clientId );

                break;

            case Regular:
                clientId = dataAreaDescriptor.getDataAreaName( );
                _clientSpec = new SimpleClientSpecImpl( coreStageFactory, this, clientId );
                _stage = coreStageFactory.createClientSpecificStage( dataAreaDescriptor, clientId, clientId );

                break;
            default:
                MoinIllegalArgumentException e = new MoinIllegalArgumentException( "SimpleDataAreaImpl", "dataAreaKind", dataAreaKind ); //$NON-NLS-1$ //$NON-NLS-2$
                LOGGER.trace( e, MoinSeverity.DEBUG, e.getMessage( ) );
                throw e;
        }
    }

    /** ************************ DataArea *********************************** */

    public ClientSpec getClientSpec( String clientId ) {

        if ( _clientSpec.getClientId( ).equals( clientId ) ) {
            return _clientSpec;
        } else {
            return null;
        }
    }

    /** ******************** AbstractDataImpl ******************************* */

    @Override
    public void destroy( ) {

        super.destroy( );
        _clientSpec = null;
        _stage = null;
    }

    /** ******************** Object ***************************************** */

    @Override
    public boolean equals( Object object ) {

        if ( object == this ) {
            return true;
        }
        if ( object instanceof SimpleDataAreaImpl ) {

            return ObjectMethodsHelper.equals( getName( ), ( (DataArea) object ).getName( ) );
        }
        return false;
    }

    @Override
    public int hashCode( ) {

        return _hashCode;
    }

    /** ******************** DataArea *************************************** */

    public Collection<String> getClientIds( ) {

        Collection<String> returnValue = new ArrayList<String>( );
        returnValue.add( _clientSpec.getClientId( ) );
        return returnValue;
    }

    /** ******************** SpiDataArea ************************************ */

    public List<SpiStage> getAllSharedStages( ) {

        List<SpiStage> returnValue = new ArrayList<SpiStage>( );
        if ( _stage.isShared( ) ) {
            returnValue.add( _stage );
        }
        return returnValue;
    }

    public boolean hasSingleStageOnly( ) {

        return true;
    }

    public SpiStage getSingleStage( ) {

        return _stage;
    }

    public boolean hasSingleClientspecOnly( ) {

        return true;
    }

    public SpiClientSpec getSingleClientSpec( ) {

        return _clientSpec;
    }

    public SpiStage getClientSpecificStage( String clientSpecId ) {

        if ( _stage.isClientSpecific( ) ) {
            if ( _stage.getClientSpecId( ).equals( clientSpecId ) ) {
                return _stage;
            } else {
                // UNEXPECTED_STAGE: Data area {0} does not belong to client spec {1}, but it belongs to client spec {2}. 
                MoinIllegalStateException e = new MoinIllegalStateException( DataAreaMgmtMessages.UNEXPECTED_STAGE, getName( ), clientSpecId, _stage.getClientSpecId( ) );
                LOGGER.trace( e, MoinSeverity.DEBUG, e.getMessage( ) );
                throw e;
            }
        }
        return null;
    }


    /** **************** Internal ******************************************* */

    protected SpiStage getClientSpecificStage( ) {

        if ( _stage.isClientSpecific( ) ) {
            return _stage;
        }
        return null;
    }

}
