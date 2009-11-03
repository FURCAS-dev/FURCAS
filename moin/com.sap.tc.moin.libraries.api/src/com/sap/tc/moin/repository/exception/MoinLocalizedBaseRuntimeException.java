package com.sap.tc.moin.repository.exception;

import java.text.MessageFormat;
import java.util.Locale;

import com.sap.tc.moin.repository.util.MoinLocaleProvider;

/**
 * The Base class for all localized MOIN Runtime exceptions
 */
public class MoinLocalizedBaseRuntimeException extends MoinBaseRuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * in the case of serialization, we have to fall back on the English message
     */
    private transient MoinLocalizedString myLocalizable;

    /**
     * in the case of serialization, we have to fall back on the English message
     */
    private transient Object[] myParameters = null;

    private MoinLocalizedBaseException myRoot;

    private MoinLocalizedBaseRuntimeException myRtRoot;

    private transient MessageFormat myFormat = null;

    /**
     * @param localizable the root cause
     */
    public MoinLocalizedBaseRuntimeException( MoinLocalizedBaseException localizable ) {

        super( localizable );
        this.myRoot = localizable;
    }

    /**
     * @param localizable the root cause, see
     * {@link Throwable#initCause(Throwable)}
     */
    public MoinLocalizedBaseRuntimeException( MoinLocalizedBaseRuntimeException localizable ) {

        super( localizable );
        this.myRtRoot = localizable;
    }

    /**
     * @param localizable the {@link MoinLocalizedString}
     * @param parameters for replacement
     */
    public MoinLocalizedBaseRuntimeException( MoinLocalizedString localizable, Object... parameters ) {

        super( localizable, parameters );
        this.myLocalizable = localizable;
        this.myParameters = parameters;

    }

    /**
     * @param rootCause see {@link Throwable#initCause(Throwable)}
     * @param localizable the {@link MoinLocalizedString}
     * @param parameters for replacement
     */
    public MoinLocalizedBaseRuntimeException( Throwable rootCause, MoinLocalizedString localizable, Object... parameters ) {

        super( rootCause, localizable, parameters );
        this.myLocalizable = localizable;
        this.myParameters = parameters;
    }

    /**
     * @param locale the requested {@link Locale}
     * @return the localized message
     */
    public String getLocalizedMessage( Locale locale ) {

        if ( this.myLocalizable == null ) {
            if ( this.myRoot != null ) {
                this.myRoot.getLocalizedMessage( locale );
            } else if ( this.myRtRoot != null ) {
                this.myRtRoot.getLocalizedMessage( locale );
            }
            return getMessage( );
        }

        String pattern = this.myLocalizable.getLocalizedMessage( locale );
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
