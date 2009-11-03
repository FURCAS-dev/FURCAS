package com.sap.tc.moin.facility.primary.dataareamgmt.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.sap.tc.moin.facility.primary.ipi.IpiDataArea;
import com.sap.tc.moin.facility.primary.ipi.IpiDataAreaDescriptorFactory;
import com.sap.tc.moin.facility.primary.ipi.IpiDataAreaManager;
import com.sap.tc.moin.facility.primary.ipi.IpiFacilityComponent;
import com.sap.tc.moin.facility.primary.ipi.IpiPrimaryFacility;
import com.sap.tc.moin.repository.DataArea;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.core.SpiStage;
import com.sap.tc.moin.repository.spi.core.SpiStageService;

/**
 * Parts of the handling for data areas and client specs, which are:
 * <p>
 * scenario-independent and persistence independent.
 * </p>
 * Those parts can be used as basis class for scenario-dependent
 * implementations, e.g. Fs/Db/JsDataAreaManagerImpl.
 * <p>
 * TODO: what about thread safety of this class?
 * 
 * @author d021091
 */

public abstract class AbstractDataAreaManagerImpl implements IpiDataAreaManager, IpiFacilityComponent {

    /** ******************** Internals ************************************** */

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_PRIMARY_FACILITY, MoinLocationEnum.MOIN_FACILITIES_DATA_AREA_MANAGEMENT, AbstractDataAreaManagerImpl.class );

    protected boolean _initialized = false;

    // References to the related areas:
    protected SpiStageService _coreStageFactory;

    protected Facility _facility;

    protected IpiDataAreaDescriptorFactory _dataAreaDescriptorFactory;

    // Map: data area id --> data area
    protected Map<String, IpiDataArea> _dataAreaMap;

    protected IpiDataArea _metaModelDataArea;

    protected IpiDataArea _transientDataArea;

    protected static final boolean READ_ONLY_STAGE = true;

    protected static final boolean WRITABLE_STAGE = false;

    /** ******************** Construction *********************************** */

    protected AbstractDataAreaManagerImpl( ) {

    }

    public void bind( SpiStageService coreStageFactory ) {

        _coreStageFactory = coreStageFactory;
    }

    public void bind( Facility facility ) {

        _facility = facility;
    }

    public void bind( IpiDataAreaDescriptorFactory dataAreaDescriptorFactory ) {

        _dataAreaDescriptorFactory = dataAreaDescriptorFactory;
    }

    public void initialize( ) {

        _dataAreaMap = new HashMap<String, IpiDataArea>( );
        _metaModelDataArea = createMetaModelDataArea( );
        _transientDataArea = createTransientDataArea( );
        _initialized = true;

    }

    public void tearDown( ) {

        _initialized = false;

        for ( IpiDataArea dataArea : _dataAreaMap.values( ) ) {
            dataArea.destroy( );
        }
        _dataAreaMap = null;
        _metaModelDataArea = null;
        _transientDataArea = null;
    }

    public void finalizeStartup( ) {

    }

    private IpiDataArea createMetaModelDataArea( ) {

        DataAreaDescriptor dataAreaDescriptor = _dataAreaDescriptorFactory.createDataAreaDescriptor( IpiPrimaryFacility.META_MODEL_DATA_AREA_ID );
        return createDataArea( dataAreaDescriptor, IpiDataArea.Kind.Metamodel );
    }

    private IpiDataArea createTransientDataArea( ) {

        DataAreaDescriptor dataAreaDescriptor = _dataAreaDescriptorFactory.createDataAreaDescriptor( IpiPrimaryFacility.TRANSIENT_DATA_AREA_ID );
        return createDataArea( dataAreaDescriptor, IpiDataArea.Kind.Transient );
    }

    protected abstract IpiDataArea createDataArea( DataAreaDescriptor dataAreaDescriptor, IpiDataArea.Kind kind );

    public abstract void deleteDataArea( String dataAreaName );

    public SpiStage getStageOfMetaModelDataArea( ) {

        // Check preconditions:
        if ( !_initialized || _metaModelDataArea == null ) {
            // DATA_AREA_MANAGEMENT_NOT_PROPERLY_INITIALIZED: "Data area management is not properly initialized." );
            MoinIllegalStateException e = new MoinIllegalStateException( DataAreaMgmtMessages.DATA_AREA_MANAGEMENT_NOT_PROPERLY_INITIALIZED );
            LOGGER.trace( e, MoinSeverity.ERROR, e.getMessage( ) );
            throw e;
        }

        // Meta model data area is a single-stage data area (in all scenarios)
        return _metaModelDataArea.getSingleStage( );
    }

    /** ******************** IpiDataAreaManager ************* */

    public IpiDataArea getDataAreaByName( String name ) {

        // Check preconditions:
        if ( !_initialized || _dataAreaMap == null ) {
            // DATA_AREA_MANAGEMENT_NOT_PROPERLY_INITIALIZED: "Data area management is not properly initialized." );
            MoinIllegalStateException e = new MoinIllegalStateException( DataAreaMgmtMessages.DATA_AREA_MANAGEMENT_NOT_PROPERLY_INITIALIZED );
            LOGGER.trace( e, MoinSeverity.ERROR, e.getMessage( ) );
            throw e;
        }

        return _dataAreaMap.get( name );
    }

    public Collection<String> getDataAreaNames( ) {

        // Check preconditions:
        if ( !_initialized || _dataAreaMap == null ) {
            // DATA_AREA_MANAGEMENT_NOT_PROPERLY_INITIALIZED: "Data area management is not properly initialized." );
            MoinIllegalStateException e = new MoinIllegalStateException( DataAreaMgmtMessages.DATA_AREA_MANAGEMENT_NOT_PROPERLY_INITIALIZED );
            LOGGER.trace( e, MoinSeverity.ERROR, e.getMessage( ) );
            throw e;
        }

        return _dataAreaMap.keySet( );
    }

    public DataArea getMetaModelDataArea( ) {

        // Check preconditions:
        if ( !_initialized || _metaModelDataArea == null ) {
            // DATA_AREA_MANAGEMENT_NOT_PROPERLY_INITIALIZED: "Data area management is not properly initialized." );
            MoinIllegalStateException e = new MoinIllegalStateException( DataAreaMgmtMessages.DATA_AREA_MANAGEMENT_NOT_PROPERLY_INITIALIZED );
            LOGGER.trace( e, MoinSeverity.ERROR, e.getMessage( ) );
            throw e;
        }
        return _metaModelDataArea;
    }

    public DataArea getTransientDataArea( ) {

        // Check preconditions:
        if ( !_initialized || _transientDataArea == null ) {
            // DATA_AREA_MANAGEMENT_NOT_PROPERLY_INITIALIZED: "Data area management is not properly initialized." );
            MoinIllegalStateException e = new MoinIllegalStateException( DataAreaMgmtMessages.DATA_AREA_MANAGEMENT_NOT_PROPERLY_INITIALIZED );
            LOGGER.trace( e, MoinSeverity.ERROR, e.getMessage( ) );
            throw e;
        }
        return _transientDataArea;
    }

    /**
     * Get the descriptors for all regular data areas, i.e. all registered data
     * areas except the transient and the meta-model data area.
     * 
     * @return the descriptors for all regular data areas
     */
    public Collection<DataAreaDescriptor> getRegularDataAreaDescriptors( ) {

        // Check preconditions:
        if ( !_initialized || _dataAreaMap == null ) {
            // DATA_AREA_MANAGEMENT_NOT_PROPERLY_INITIALIZED: "Data area management is not properly initialized." );
            MoinIllegalStateException e = new MoinIllegalStateException( DataAreaMgmtMessages.DATA_AREA_MANAGEMENT_NOT_PROPERLY_INITIALIZED );
            LOGGER.trace( e, MoinSeverity.ERROR, e.getMessage( ) );
            throw e;
        }

        List<DataAreaDescriptor> regularDataAreaDescriptors = new ArrayList<DataAreaDescriptor>( _dataAreaMap.size( ) - 2 );
        for ( Entry<String, IpiDataArea> entry : _dataAreaMap.entrySet( ) ) {
            IpiDataArea dataArea = entry.getValue( );
            if ( !( _metaModelDataArea.equals( dataArea ) || _transientDataArea.equals( dataArea ) ) ) {
                regularDataAreaDescriptors.add( dataArea.getDescriptor( ) );
            }
        }

        return regularDataAreaDescriptors;
    }
}
