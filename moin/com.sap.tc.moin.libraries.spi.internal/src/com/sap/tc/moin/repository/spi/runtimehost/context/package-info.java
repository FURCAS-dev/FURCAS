/**
 * Provides access to scenario-specific functionality of the runtime
 * environment. <br>
 * The MOIN Runtime Context is scenario-specific environment that supports the
 * access to scenario-specific resources, for example JDBC Data Source,
 * Configuration, Thread System, Locking Manager, etc.
 * <p>
 * The package defines interfaces that supports access to MOIN configuration.
 * During the MOIN startup the MOIN configuration is loaded and provided by
 * Configuration Manager. The MOIN components (core, facility and CDAM) can
 * access configuration registering the component-specific configuration
 * listener.
 * <p>
 * The Runtime Context is provided by the scenario-dependent MOIN Runtime Host.
 * <br>
 * <br>
 * This API is for SAP-internal use only and subject to change
 */
package com.sap.tc.moin.repository.spi.runtimehost.context;