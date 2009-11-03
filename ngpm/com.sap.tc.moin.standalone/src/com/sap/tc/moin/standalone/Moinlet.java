package com.sap.tc.moin.standalone;

import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiConfigurationProvider;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.cdam.CompoundClientSpec;

/**
 * A moinlet provides the configuration for the definitions of moin DCs (or
 * their standalone equivalents) and the logic which should be executed after
 * MOIN initializtaion.
 * <p>
 * An initialization has to have a parameter-less constructor.
 * </p>
 * 
 * @author D046220
 */
public interface Moinlet {

    /**
     * Retrieves the DI configuration provider.
     * 
     * @see IpiDiConfigurationProvider
     * @param arguments command line arguments passed to the MOIN starter.
     * @return initialized DI configuration provider
     */
    public IpiDiConfigurationProvider getDiConfigurationProvider( String[] arguments );

    /**
     * Will be called after getDiConfigurationProvider. Should contain the
     * actual logic of the moinlet.
     * 
     * @param moin initialized MOIN instance.
     * @param clientSpec compound client spec which can be used for session
     * creation
     */
    public void execute( Moin moin, CompoundClientSpec clientSpec );

}
