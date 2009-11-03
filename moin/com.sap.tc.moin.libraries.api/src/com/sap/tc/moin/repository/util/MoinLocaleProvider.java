package com.sap.tc.moin.repository.util;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;

/**
 * Provides the "current" Locale, i.e. the Locale used for
 * {@link Throwable#getLocalizedMessage()} and other localizable interfaces.
 * <p>
 * The default instance obtained by {@link #getInstance()} simply uses
 * {@link Locale#getDefault()}. Subclasses may override this behavior,
 * {@link #init(MoinLocaleProvider)} can then be used to replace the default
 * instance with such a subclass.
 * <p>
 * The {@link #init(MoinLocaleProvider)} method can only be called once;
 * repeated calls will result in a RuntimeException; {@link #isInitialized()}
 * allows to check whether {@link #init(MoinLocaleProvider)} was called before
 * or not.
 */
public abstract class MoinLocaleProvider {

    final static class DefaultMoinLocaleProvider extends MoinLocaleProvider {

        @Override
        public Locale getCurrentLocale( ) {

            return Locale.getDefault( );
        }
    }

    private static volatile MoinLocaleProvider INSTANCE = new DefaultMoinLocaleProvider( );

    private static boolean initialized = false;

    protected MoinLocaleProvider( ) {

        // nothing special, but protected so that this can be sub-classed
    }

    /**
     * @return the instance, either the default instance or the instance
     * provided by {@link #init(MoinLocaleProvider)}
     */
    public static MoinLocaleProvider getInstance( ) {

        return INSTANCE;
    }

    /**
     * Initializes this with a different {@link MoinLocaleProvider}.
     * <p>
     * This method can only be called once; repeated call will result in a
     * RuntimeException.
     * <p>
     * <b><em>MOIN Clients must never call this method!</em></b>
     * 
     * @see #isInitialized()
     * @param provider a suitable subclass of this
     */
    public static synchronized void init( MoinLocaleProvider provider ) {

        if ( initialized ) {
            throw new MoinLocalizedBaseRuntimeException( MoinApiMessages.LOCALEPROVIDERINITIALIZEDONCE );
        }
        INSTANCE = provider;
        initialized = true;
    }

    /**
     * @return <code>true</code> if {@link #init(MoinLocaleProvider)} has been
     * called before
     */
    public static synchronized boolean isInitialized( ) {

        return initialized;
    }

    /**
     * @return the "current" {@link Locale}
     */
    public abstract Locale getCurrentLocale( );
}
