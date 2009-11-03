package com.sap.tc.moin.repository.exception;

import java.text.MessageFormat;
import java.util.Locale;

import com.sap.tc.moin.repository.util.MoinLocaleProvider;


/**
 * Localized {@link IllegalStateException} wrapper
 */
public class MoinIllegalStateException extends IllegalStateException {

    private static final long serialVersionUID = 1L;

    private transient MoinLocalizedString myMessage;

    private transient Object[] myArgs;

    /**
     * Generic constructor
     * 
     * @param message {@link MoinLocalizedString}
     * @param args arguments
     */
    public MoinIllegalStateException( MoinLocalizedString message, Object... args ) {

        super( message.format( args ) );
        this.myMessage = message;
        this.myArgs = args;
    }

    /**
     * Generic constructor
     * 
     * @param rootCause root cause
     * @param message {@link MoinLocalizedString}
     * @param args arguments
     */
    public MoinIllegalStateException( Throwable rootCause, MoinLocalizedString message, Object... args ) {

        super( message.format( args ), rootCause );

        this.myMessage = message;
        this.myArgs = args;
    }

    @Override
    public String getLocalizedMessage( ) {

        if ( this.myMessage != null ) {
            Locale locale = MoinLocaleProvider.getInstance( ).getCurrentLocale( );
            if ( this.myArgs != null && this.myArgs.length > 0 ) {
                MessageFormat format = new MessageFormat( this.myMessage.getLocalizedMessage( locale ), locale );
                return format.format( this.myArgs );
            }
            return this.myMessage.getLocalizedMessage( locale );
        }
        return getMessage( );

    }

    /**
     * See
     * {@link com.sap.tc.moin.repository.exception.MoinLocalizedBaseException#toString()}
     * for an explanation of this
     */
    @Override
    public String toString( ) {

        String s = getClass( ).getName( );
        String message = getMessage( );
        return ( message != null ) ? ( s + ": " + message ) : s; //$NON-NLS-1$
    }
}
