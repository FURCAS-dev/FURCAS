package com.sap.tc.moin.friends.ide.impl;

import org.eclipse.core.resources.IProject;

import com.sap.tc.moin.facility.primary.ide.IdePrimaryFacility;
import com.sap.tc.moin.friends.ide.IdePrimaryFacilityUtil;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.spi.facility.ide.SpiIdeFacility;


/**
 * The class provides the mapping of the MOIN friends API for IDE facility to
 * the implementation located in the IDE facility. It knows the respecitive
 * internal interfaces and components in the IDE facility.
 */
public class IdePrimaryFacilityUtilImpl implements IdePrimaryFacilityUtil {

    /**
     * Caution:
     * <p>
     * The mapping from the internal enum
     * IpiIdeNwdiService.ContainerInitializationState to the enum in the MOIN
     * friends API IdePrimaryFacilityUtil.ContainerInitializationState is
     * necessary, for details see
     * {@link IpiIdeNwdiService.ContainerInitializationState}.
     * </p>
     */
    public IdePrimaryFacilityUtil.ContainerInitializationState getContainerInitializationState( final IdePrimaryFacility idePrimaryFacility, final IProject eclipseProject ) {

        com.sap.tc.moin.repository.spi.facility.ide.ContainerInitializationState initState = ( (SpiIdeFacility) idePrimaryFacility ).getContainerInitializationState( eclipseProject );

        // Mapping to deprecated enum:
        switch ( initState ) {
            case NOT_MOIN_RELEVANT:
                return IdePrimaryFacilityUtil.ContainerInitializationState.NOT_MOIN_RELEVANT;
            case NOT_INITIALIZED:
                return IdePrimaryFacilityUtil.ContainerInitializationState.NOT_INITIALIZED;
            case CLIENT_SPEC_ONLY_INITIALIZED:
                return IdePrimaryFacilityUtil.ContainerInitializationState.CLIENT_SPEC_ONLY_INITIALIZED;
            case INITIALIZED:
                return IdePrimaryFacilityUtil.ContainerInitializationState.INITIALIZED;
            default:
                return IdePrimaryFacilityUtil.ContainerInitializationState.NOT_INITIALIZED;
        }
    }

    /**
     * Caution:
     * <p>
     * The mapping from the internal enum
     * IpiIdeNwdiService.ContainerInitializationState to the enum in the MOIN
     * friends API IdePrimaryFacilityUtil.ContainerInitializationState is
     * necessary, for details see
     * {@link IpiIdeNwdiService.ContainerInitializationState}.
     * </p>
     */
    public IdePrimaryFacilityUtil.ContainerInitializationState getContainerInitializationState( IdePrimaryFacility idePrimaryFacility, ClientSpec clientSpec, CRI cri ) {

        com.sap.tc.moin.repository.spi.facility.ide.ContainerInitializationState initState = ( (SpiIdeFacility) idePrimaryFacility ).getContainerInitializationState( clientSpec, cri );

        // Mapping to deprecated enum:
        switch ( initState ) {
            case NOT_MOIN_RELEVANT:
                return IdePrimaryFacilityUtil.ContainerInitializationState.NOT_MOIN_RELEVANT;
            case NOT_INITIALIZED:
                return IdePrimaryFacilityUtil.ContainerInitializationState.NOT_INITIALIZED;
            case CLIENT_SPEC_ONLY_INITIALIZED:
                return IdePrimaryFacilityUtil.ContainerInitializationState.CLIENT_SPEC_ONLY_INITIALIZED;
            case INITIALIZED:
                return IdePrimaryFacilityUtil.ContainerInitializationState.INITIALIZED;
            default:
                return IdePrimaryFacilityUtil.ContainerInitializationState.NOT_INITIALIZED;
        }
    }

    public ClientSpec initializeClientSpec( final IdePrimaryFacility idePrimaryFacility, final IProject eclipseProject ) {

        return ( (SpiIdeFacility) idePrimaryFacility ).initializeClientSpec( eclipseProject );
    }

    public void refreshClientSpecFromFileSystem( IdePrimaryFacility idePrimaryFacility, IProject eclipseProject ) {

        ( (SpiIdeFacility) idePrimaryFacility ).refreshClientSpecFromFileSystem( eclipseProject );
    }

}
