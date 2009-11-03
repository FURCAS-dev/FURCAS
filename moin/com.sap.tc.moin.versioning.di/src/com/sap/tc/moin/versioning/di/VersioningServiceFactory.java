package com.sap.tc.moin.versioning.di;

import com.sap.tc.moin.versioning.di.impl.VersioningServiceImpl;

public class VersioningServiceFactory {

    private static VersioningService sVersioningService = null;

    public static VersioningService getInstance( ) {

        if ( sVersioningService == null ) {
            sVersioningService = new VersioningServiceImpl( );
        }
        return sVersioningService;
    }
}
