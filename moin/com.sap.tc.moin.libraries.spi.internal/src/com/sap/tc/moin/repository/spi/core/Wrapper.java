package com.sap.tc.moin.repository.spi.core;

/**
 * This interface has to be implemented by all wrapper classes (JMI wrappers as well as wrappers for MOIN entities like
 * connections, model partitions etc.) to facilitate an efficient <code>instanceof</code> check whether an object is a
 * wrapper or not, and to get access to the wrapped object.
 * <p>
 * NOTE: This method is for INTERNAL USE only! Client code casting to the {@link Wrapper} interface and working on the
 * unwrapped original objects can break any time without warning due to internal refactorings.
 */
public interface Wrapper<T> {

    /**
     * Returns the object wrapped by this {@link Wrapper} instance.
     */
    public T unwrap( );
}
