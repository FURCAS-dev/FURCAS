package com.sap.tc.moin.repository.spi.runtimehost.context;

import javax.sql.DataSource;

/**
 * The MOIN runtime specific context.
 * <p>
 * The MOIN runtime context represents infrastructure specific components that
 * are used in MOIN Core and particular facilities. The MOIN runtime context is
 * determined by the MOIN Runtime Host during MOIN startup phase and then hand
 * over to the MOIN Core and particular facilities during the initialization
 * phase.
 */
public interface SpiRuntimeContext {

    /**
     * Get the JDBC data source.
     * 
     * @return JDBC data source
     */
    public DataSource getJdbcDataSource( );

    /**
     * Get transaction system.
     * 
     * @return thread system
     */
    public SpiThreadSystem getThreadSystem( );

    /**
     * Get locking manager.
     * 
     * @return locking manager
     */
    public SpiLockingManager getLockingManager( );

    /**
     * Get transaction manager.
     * 
     * @return transaction manager
     */
    public SpiTransactionManager getTransactionManager( );

    /**
     * Get configuration manager
     * 
     * @return configuration manager
     */
    public SpiConfigManager getConfigurationManager( );
}
