package com.sap.tc.moin.repository.shared.util;

/**
 * Holds string constants for System Properties keys used within MOIN This is
 * not the complete list, please extend as you see fit.
 * 
 * @author D046074
 */
public class MoinSystemPropertyKeys {

    public static final String MOIN_IMPORT_OCL_CONSTRAINTS = "moin.importOclConstraints"; //$NON-NLS-1$

    public static final String OCL_SHOW_JMI_TREE = "OclShowJmiTree"; //$NON-NLS-1$

    public static final String MOIN_USE_DATABASE_USER = "moin.use.databaseUser"; //$NON-NLS-1$

    public static final String MOIN_USE_DATABASE_PASSWORD = "moin.use.databasePassword"; //$NON-NLS-1$

    public static final String MOIN_USE_DATABASE_URL = "moin.use.databaseUrl"; //$NON-NLS-1$

    public static final String MOIN_USE_DATABASE_DRIVER = "moin.use.databaseDriver"; //$NON-NLS-1$

    public static final String MOIN_CORE_CONSISTENCY_CHECKS = "moin.core.consistencyChecks"; //$NON-NLS-1$

    public static final String MOIN_SERIALIZATION_FORMAT_VERSION = "moin.serialization.format.version"; //$NON-NLS-1$

    //FIXME: partition magic: remove once galaxy fixed the issues
    public static final String MOIN_PARTITIONMAGIC_FIX = "com.sap.tc.moin.partitionmagic.fix"; //$NON-NLS-1$

    /**
     * Test system parameters
     */
    public static final String TEST_S2X_SERIALIZER = "com.sap.tc.moin.s2x"; //$NON-NLS-1$

    /*
     * This system property is used and located in MoinLoggerFactory, since the
     * logger subproject must not have a reference to the util subproject (cross
     * references).
     */
//    public static final String TEST_LOGGER_ERROR_AS_EXCEPTION = "com.sap.tc.moin.errorAsRuntimeException";
}
