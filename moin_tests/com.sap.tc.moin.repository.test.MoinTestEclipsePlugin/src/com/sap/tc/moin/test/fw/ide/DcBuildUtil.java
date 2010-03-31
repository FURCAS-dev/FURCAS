package com.sap.tc.moin.test.fw.ide;

import com.sap.ide.dii05.model.api.IDevelopmentComponent;


public interface DcBuildUtil {

    // Caution:
    // This handling is only valid for local-only MM DCs for which no used DCs (MM federation) have to be synced from DTR / CBS.
    boolean executeDcBuildForLocalMMDc( String dcVendor, String dcName ) throws Exception;

    // Caution:
    // This handling is only valid for local-only MM DCs for which no used DCs (MM federation) have to be synced from DTR / CBS.
    // Remark:
    // DC Build must also be possible for DC without project
    boolean executeDcBuildForLocalMMDc( IDevelopmentComponent dc ) throws Exception;
}
