package com.sap.tc.moin.repository.runtimehost.deployment;

import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;

/**
 * Class loader wrapper used by the {@link SpiPartitionSerializationManager}.
 * 
 * @author d026715
 */

public interface IpiCustomSerializationClassLoader {

    /**
     * Returns the class specified by the given class name.
     * 
     * @param className
     * @return
     * @throws ClassNotFoundException
     */
    Class<?> loadClass( String className ) throws ClassNotFoundException;
}
