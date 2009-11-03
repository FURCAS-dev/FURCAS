package com.sap.tc.moin.facility.primary.diservice.impl;

import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiDcToPpDependencyProvider;

public class DiDcToPpDependencyImpl {

    /** ******************** Internals ************************************** */

    IpiDiDcToPpDependencyProvider _diPpDependencyProvider;

    DiConfigurationImpl _diConfiguration;

    // The public part object is computed only once and cached:
    // - objective: to avoid duplicates
    // - reset is not needed: see below under term 'reset-method'.
    DiPublicPartImpl _diPublicPart;

    /** ******************** Construction *********************************** */

    DiDcToPpDependencyImpl( IpiDiDcToPpDependencyProvider diPpDependencyProvider, DiConfigurationImpl diConfiguration ) {

        _diPpDependencyProvider = diPpDependencyProvider;
        _diConfiguration = diConfiguration;
    }

    /** ************************* API ************************************** */

    public DiPublicPartImpl getPublicPart( ) {

        // Lazy retrieval and cached:
        if ( _diPublicPart == null ) {
            _diPublicPart = new DiPublicPartImpl( _diPpDependencyProvider.getPublicPart( ), _diConfiguration );
        }
        return _diPublicPart;

    }

    public boolean isVisibleForBuildTime( ) {

        // Lazy retrieval:
        return _diPpDependencyProvider.isVisibleForBuildTime( );
    }

    /**
     * A reset-method is not needed:
     * <p>
     * If a DC has changed then DiDevelopmentComponentImpl takes care for a
     * proper refresh. The DiPpDependencyImpl objects are not cached up to now
     * and do not need to be refreshed therefore.
     */

}
