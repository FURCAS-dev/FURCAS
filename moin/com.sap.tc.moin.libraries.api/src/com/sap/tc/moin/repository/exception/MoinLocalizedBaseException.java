package com.sap.tc.moin.repository.exception;

import java.text.MessageFormat;
import java.util.Locale;

import com.sap.tc.moin.repository.util.MoinLocaleProvider;

/**
 * Base class for all localized MOIN exceptions
 */
public abstract class MoinLocalizedBaseException extends MoinBaseException {

    private static final long serialVersionUID = 1L;

    /**
     * in the case of serialization, we have to fall back on the English message
     */
    private transient MoinLocalizedString myLocalized;

    /**
     * in the case of serialization, we have to fall back on the English message
     */
    private transient Object[] myParameters = null;

    private MoinLocalizedBaseException root;

    private MessageFormat myFormat = null;

    /**
     * @param rootCause see {@link Exception#getCause()}
     */
    public MoinLocalizedBaseException( MoinLocalizedBaseException rootCause ) {

        super( rootCause );
        this.root = rootCause;
    }

    /**
     * @param localizable the {@link MoinLocalizedString}
     * @param parameters for replacement
     */
    public MoinLocalizedBaseException( MoinLocalizedString localizable, Object... parameters ) {

        super( localizable, parameters );
        this.myLocalized = localizable;
        this.myParameters = parameters;

    }

    /**
     * @param rootCause see {@link Throwable#initCause(Throwable)}
     * @param localizable the {@link MoinLocalizedString}
     * @param parameters parameters for replacement
     */
    public MoinLocalizedBaseException( Throwable rootCause, MoinLocalizedString localizable, Object... parameters ) {

        super( rootCause, localizable, parameters );
        this.myLocalized = localizable;
        this.myParameters = parameters;
    }

    /**
     * The corresponding interface is not yet here
     * 
     * @param locale the requested {@link Locale}
     * @return the localized message
     */
    public String getLocalizedMessage( Locale locale ) {

        if ( this.myLocalized == null ) {
            if ( this.root == null ) {
                return getMessage( );
            }
            return this.root.getLocalizedMessage( locale );

        }

        String pattern = this.myLocalized.getLocalizedMessage( locale );
        if ( this.myParameters == null || this.myParameters.length == 0 ) {
            return pattern;
        }

        if ( this.myFormat == null ) {
            this.myFormat = new MessageFormat( pattern, locale );
        } else {
            this.myFormat.setLocale( locale );
            this.myFormat.applyPattern( pattern );
        }
        return this.myFormat.format( this.myParameters );
    }

    @Override
    public String getLocalizedMessage( ) {

        return getLocalizedMessage( MoinLocaleProvider.getInstance( ).getCurrentLocale( ) );
    }

    /**
     * This is overridden, since {@link Throwable#toString()} uses
     * {@link #getLocalizedMessage()}. As {@link #toString()} is in turn used by
     * {@link #printStackTrace()}, we would end up with localized Stack traces
     * otherwise.
     */
    @Override
    public String toString( ) {

        String s = getClass( ).getName( );
        String message = getMessage( );
        return ( message != null ) ? ( s + ": " + message ) : s; //$NON-NLS-1$
    }

}
