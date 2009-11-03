package com.sap.tc.moin.repository.spi.runtimehost.context;

import java.util.List;

/**
 * This is the lock manager abstraction. Depending on the environment (Java Server, Eclipse - IDE),
 * different implementations of this will be required.
 */
public interface SpiLockingManager {

    /**
     * Shared locking
     */
    public final static byte MODE_SHARED = 0;

    /**
     * Exclusive locking
     */
    public final static byte MODE_EXCLUSIVE = 1;

    /**
     * Lock timeout
     */
    public final static int TIMEOUT = 5000;

    /**
     * Acquire lock.
     * 
     * @param id the locking ID
     * @param mode the locking mode (see {@link #MODE_EXCLUSIVE},
     * {@link #MODE_SHARED})
     * @throws LockExceptionProxy wrapper Exception if lock can not be obtained
     * @throws IllegalArgumentException wrong argument
     */
    public void lock(String id, byte mode) throws SpiLockingException, IllegalArgumentException;

    /**
     * Acquire lock (mass operation).
     * 
     * @param ids the locking IDs
     * @param mode the locking mode (see {@link #lock(String, byte)})
     * @throws LockExceptionProxy see ({@link #lock(String, byte)})
     * @throws IllegalArgumentException see ({@link #lock(String, byte)})
     */
    public void massLock(List ids, byte mode) throws SpiLockingException, IllegalArgumentException;

    /**
     * Return lock.
     * 
     * @param id the locking ID
     * @param mode the locking mode (see {@link #lock(String, byte)})
     * @throws LockExceptionProxy see ({@link #lock(String, byte)})
     * @throws IllegalArgumentException see ({@link #lock(String, byte)})
     */
    public void unlock(String id, byte mode) throws SpiLockingException, IllegalArgumentException;

    /**
     * Return lock (mass operation.
     * 
     * @param ids The locking IDs
     * @param mode the locking mode (see {@link #lock(String, byte)})
     * @throws LockExceptionProxy see ({@link #lock(String, byte)})
     * @throws IllegalArgumentException see ({@link #lock(String, byte)})
     */
    public void massUnlock(List ids, byte mode) throws SpiLockingException, IllegalArgumentException;

}
