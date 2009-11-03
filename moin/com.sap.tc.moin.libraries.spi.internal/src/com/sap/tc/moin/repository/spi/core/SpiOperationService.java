package com.sap.tc.moin.repository.spi.core;

import com.sap.tc.moin.repository.DataAreaDescriptor;


/**
 * Provides operation management related MOIN Core functionality to other
 * layers.
 * <p>
 * This interface is not intended to be implemented by service providers. The
 * implementation will be provided by the MOIN Core.
 * 
 * @author d047015
 */
public interface SpiOperationService {

    public static interface SpiCoreRunnable {

        public void run( );
    }

    /**
     * Checks if a Command is running in the current thread.
     * 
     * @return <code>true</code> if a Command is running in the current thread
     */
    public boolean isCommandRunningInCurrentThread( );

    public void executeCoreRunnable( SpiCoreRunnable coreRunnable, DataAreaDescriptor... dataAreaScope );
}
