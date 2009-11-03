package com.sap.tc.moin.repository.runtimehost.deployment;

/**
 * Internal interface for an instance reference.
 * 
 * @author D026715
 */
interface IpiInstanceReference {

    /**
     * Creates the instance of the contained {@link #className} using the given
     * class loader.
     * 
     * @param loader Class loader interface
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    void createInstance( IpiCustomSerializationClassLoader loader ) throws ClassNotFoundException, InstantiationException, IllegalAccessException;

    Object getClassName( );

    /**
     * Releases the referenced instance.
     */
    void releaseInstance( );
}