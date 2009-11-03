package com.sap.tc.moin.facility.primary.ipi.diservice;

import java.util.Collection;

/**
 * This interface builds an abstraction layer to the real environment-specific
 * API from DevelopmentInfrastructure area for the access of an environment
 * configuration via development configuration / development component import(in
 * IDE).
 * <p>
 * This allows environment-independent implementations of flows which are equal
 * in different environments, although the respective DevelopmentInfrastructure
 * interfaces are different for the different environments.
 * <p>
 * The currently available APIs from DevelopmentInfrastructure are: Dii05 for
 * IDE, Sdic for JEE, DiBuildInfrastructure-Framework for DcBuild.
 * <p>
 * Caution:
 * <p>
 * The interface <code>IpiDiConfigurationProvider</code> - including the
 * internal interfaces - are not intended to be implemented by consumers,
 * instead the consumers should extend the corresponding basic adaptor
 * <code>IpiDiConfigurationBasicAdaptorImpl</code> - including the internal
 * classes, so that extensions of the interface do not syntactically break the
 * consumers.
 * </p>
 * 
 * @author d021091
 */

public interface IpiDiConfigurationProvider {

    /**
     * Current scenario in which the configuration provider implementation is
     * running:
     */
    enum Scenario {
        IDE_SCENARIO, BUILD_SCENARIO
        // later also: JEE_SCENARIO, ...
    }

    Scenario getScenario( );

    /**
     * The configuration name is computed in a scenario-dependent way. E.g. in
     * IDE it is computed based on the name of the development configuration and
     * the respective import-ID.
     */
    String getConfigurationName( );

    // DC definitions of non-MOIN-DCs are ignored
    /**
     * DC-definitions which are MOIN-relevant, the others are ignored.
     * <p>
     * If a DC-definition is MOIN-relevant can be tested using
     * <code>IpiDiDcDefinitionProvider#IsMoinRelevantDc()</code>
     * </p>
     */
    Collection<IpiDiDcDefinitionProvider> getMoinDiDcDefinitions( );

}
