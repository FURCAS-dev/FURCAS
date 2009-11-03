package com.sap.tc.moin.facility.filesystem.componentmodel;

import com.sap.tc.moin.facility.componentmodel.CMServices;


public class CMFSServices {

    private static boolean initDone = false;

    public static synchronized void init( ) {

        if ( initDone ) {
            return;
        }

        CMServices.registerContainerType( CMFSContainerArchiveFolders.class );
        CMServices.registerContainerType( CMFSContainerArchives.class );
        CMServices.registerContainerType( CMFSContainerFolder.class );

        CMServices.registerDataAreaType( CMFSDataArea.class );

        initDone = true;
    }
}
