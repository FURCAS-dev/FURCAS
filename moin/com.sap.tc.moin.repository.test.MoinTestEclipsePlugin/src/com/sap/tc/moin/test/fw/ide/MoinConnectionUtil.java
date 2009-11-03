package com.sap.tc.moin.test.fw.ide;


import com.sap.tc.moin.repository.Moin;

@SuppressWarnings( "nls" )
public interface MoinConnectionUtil {

    static final String DEFAULT_DEV_CONFIG_NAME = "LocalDevelopment";

    static final String DEFAULT_DEV_CONFIG_IMPORTID = "LocalDevelopment";

    Moin getMoinInstance( );

}
