package com.sap.tc.moin.repository.filesystem;

import com.sap.tc.moin.repository.admin.RuntimeHost;


public interface FileSystemRuntimeHost extends RuntimeHost {

    public boolean isRunning( );

    public void shutDown( );
}
