package com.sap.tc.moin.facility.primary.ipi;

import com.sap.tc.moin.facility.primary.PrimaryFacility;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;

/**
 * Facility internal IPI interface which defines a set of constants which are
 * valid for Primary Facility implementations.
 */
public interface IpiPrimaryFacility extends PrimaryFacility, SpiFacility {

    // Test switch is turned on and off by test cases.
    // It causes that facility and core write messages concerning partition eviction into console.
    // The messages are not written into trace because the in LKG test setup and in the test cases 
    // the trace level cannot be set.
    public static final String TEST_NOTIFICATION_AND_PARTITION_EVICTION_BY_MOIN_CORE = "com.sap.tc.moin.test.coreeviction"; //$NON-NLS-1$

    /**
     * Constant denoting the ID of the active workspace.
     * <p>
     * Depending on the deployment scenario, the NWDI Facility implementation
     * may use a workspace configuration with a stack of layered workspaces,
     * consisting on a client-specific workspace for each MOIN client, and 2
     * shared workspaces hosting the model partitions in the inactive and active
     * state.
     * <p>
     * The value of this constant is <em>active<em>.
     */
    public static final String ACTIVE_WORKSPACE_ID = "active"; //$NON-NLS-1$

    /**
     * Constant denoting the ID of the inactive workspace.
     * <p>
     * Depending on the deployment scenario, the NWDI Facility implementation
     * may use a workspace configuration with a stack of layered workspaces,
     * consisting on a client-specific workspace for each MOIN client, and 2
     * shared workspaces hosting the model partions in the inactive and active
     * state.
     * <p>
     * The value of this constant is <em>inactive<em>.
     */
    public static final String INACTIVE_WORKSPACE_ID = "inactive"; //$NON-NLS-1$

    /**
     * The ID of the client specific workspace.
     */
    public static final String CLIENT_SPECIFIC_WORKSPACE_ID = "clientspecific"; //$NON-NLS-1$

    /**
     * The ID of the metamodel stage.
     */
    public static final String METAMODEL_STAGE_ID = "metamodel"; //$NON-NLS-1$

    /**
     * The ID of the metamodel data area.
     */
    public static final String META_MODEL_DATA_AREA_ID = "MetaModelDataArea"; //$NON-NLS-1$

    /**
     * The ID of the metamodel client spec.
     */
    public static final String META_MODEL_CLIENT_SPEC_ID = "MetaModelClientSpec"; //$NON-NLS-1$

    /**
     * The ID of the transient data area.
     */
    public static final String TRANSIENT_DATA_AREA_ID = "TransientDataArea"; //$NON-NLS-1$

    /**
     * The ID of the transient client spec.
     */
    public static final String TRANSIENT_CLIENT_SPEC_ID = "TransientClientSpec"; //$NON-NLS-1$
}
