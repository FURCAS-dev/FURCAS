package com.sap.tc.moin.repository.exception;

import java.text.MessageFormat;
import java.util.Locale;

import com.sap.tc.moin.repository.util.MoinLocaleProvider;


/**
 * The {@link UnsupportedOperationException} wrapper
 */
public class MoinUnsupportedOperationException extends UnsupportedOperationException {

    private static final long serialVersionUID = 1L;

    private transient MoinLocalizedString myMessage;

    private transient Object[] myArgs;

    /**
     * Message: "Operation "{0}" is not supported"
     * 
     * @param operationName argument 0
     */
    public MoinUnsupportedOperationException( String operationName ) {

        super( ExceptionWrapperMessages.UNSUPPORTEDOPERATION.format( operationName ) );
        this.myMessage = ExceptionWrapperMessages.UNSUPPORTEDOPERATION;
        this.myArgs = new Object[] { operationName };
    }

    /**
     * Generic constructor
     * 
     * @param message {@link MoinLocalizedString}
     * @param args arguments
     */
    public MoinUnsupportedOperationException( MoinLocalizedString message, Object... args ) {

        super( message.format( args ) );
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
