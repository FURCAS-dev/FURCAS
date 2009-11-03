package com.sap.tc.moin.repository.core;

import com.sap.tc.moin.repository.LockManager;

public interface CoreLockManager extends LockManager {

    /**
     * Returns this Lockmanager's wrapper.
     */
    public LockManagerWrapper getWrapper( );
}
