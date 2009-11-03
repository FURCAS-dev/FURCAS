package com.sap.tc.moin.repository.spi.core;

import java.util.Collection;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.SessionCreationListener;
import com.sap.tc.moin.repository.metamodels.MetaModelCatalog;
import com.sap.tc.moin.repository.metamodels.MetaModelInfo;
import com.sap.tc.moin.repository.spi.cdam.SpiCompoundDataAreaManager;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;
import com.sap.tc.moin.repository.spi.runtimehost.mm.SpiMetaModelInfo;
import com.sap.tc.moin.repository.spi.runtimehost.mm.SpiMetamodelRegistry;

public interface SpiMoin extends Moin {

    /*
     * Moin life cycle related methods called by the runtime host.
     */

    /**
     * Initializes the MOIN singleton instance with the specified facilities.
     * <p>
     * This will fail once the instance has already been initialized unless it
     * was shut down in the meantime.
     * <p>
     * This method should <em>only</em> be called by the Moin initializer!
     * 
     * @param facilities a collection of {@link Facility} objects for the MOIN
     * @param compoundDataAreaManager compound data area manager
     * @param metamodelCatalog the catalog (API view on deployed meta-models)
     * @param metamodelRegistry the meta-model registry (core internal view on
     * deployed meta-models)
     * @param partitionSerializationManager the serialization manager (customer
     * parser/serialized registry)
     * @see #shutDown()
     */
    public void init( Collection<Facility> facilities, SpiCompoundDataAreaManager compoundDataAreaManager, MetaModelCatalog metamodelCatalog, SpiMetamodelRegistry metamodelRegistry, SpiPartitionSerializationManager partitionSerializationManager );

    /**
     * Shuts down the MOIN singleton instance.
     * <p>
     * This method should <em>only</em> be called by the Moin initializer! Be
     * sure you called {@link #shutdownThreads()} before to stop all MOIN
     * threads!
     * 
     * @see #init(Collection, SpiCompoundDataAreaManager, MetaModelCatalog,
     * SpiMetamodelRegistry, SpiPartitionSerializationManager) MetaModelCatalog,
     * SpiPartitionSerializationManager)
     */
    public void shutDown( );

    /**
     * Triggers MOIN to shut down its global threads
     */
    public void shutdownThreads( );

    /**
     * Finalizes the shutdown of MOIN. Introduced to avoid finalize() on
     * MoinImpl (JLin).
     */
    public void finalizeShutdown( );

    /**
     * Finalize the MOIN startup. When this method is called, all available
     * metamodels are ready-for-use.
     */
    public void finalizeStartup( );


    /*
     * Core functionality provided as services. Called by the runtime host
     * (passed to facilities). Could this be returned by a lifecycle method
     * after creation or initialization?
     */

    /**
     * Provides access to MOIN Core functionality.
     */
    public SpiCore getCore( );


    /*
     * Non life cycle related methods, mainly used by the runtime host.
     */

    /**
     * @return the wrapped {@link Moin} instance.
     */
    public Moin getWrapper( );

    /**
     * Returns the unique ID of this Moin instance. This ID is for example used
     * as part of the ObjectName of JMX MBeans.
     */
    public String getId( );

    /**
     * Returns the cri for the MOFROM
     */
    public CRI getMofRomCri( );

    /**
     * @return The {@link MetaModelInfo} for the MofRom.
     */
    public SpiMetaModelInfo getMofRomInfo( );
    
    /**
     * Determines if the second MOF ROM stage has been injected.
     * 
     * @return true if the second MOF ROM stage is injected, false otherwise.
     */
    public boolean isSecondStageInjected( );

    /**
     * Injects second MOF ROM stage.
     * 
     */
    public void injectSecondMofRomStage( );

    /**
     * Adds a listener that will be notified upon each creation of a session by
     * {@link #createSession(com.sap.tc.moin.repository.cdam.CompoundClientSpec)}.
     * Listeners are referenced only weakly inside MOIN. In other words, listeners
     * that are no longer referenced otherwise will stop to get notified because they
     * will become subject to garbage collection and will hence be removed from the
     * set of listeners to notify about session creation. Therefore, clients have
     * to make sure to keep their listeners strongly referenced as long as they want
     * to keep receiving session creation events.
     */
    public void addSessionCreationListener(SessionCreationListener listener);
    
    /**
     * Will notify all registered {@link SessionCreationListener}s that MOIN is now
     * initialized.
     */
    public void fireInitialized();
}
