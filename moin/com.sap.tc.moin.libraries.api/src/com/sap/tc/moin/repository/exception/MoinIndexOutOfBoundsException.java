package com.sap.tc.moin.repository.exception;

import java.text.MessageFormat;
import java.util.Locale;

import com.sap.tc.moin.repository.util.MoinLocaleProvider;



/**
 * The {@link IndexOutOfBoundsException} wrapper
 */
public class MoinIndexOutOfBoundsException extends IndexOutOfBoundsException {

    private static final long serialVersionUID = 1L;

    private transient MoinLocalizedString myMessage;

    private transient Object[] myArgs;

    /**
     * Message: {@link ExceptionWrapperMessages#INDEXOUTOFBOUNDS}
     */
    public MoinIndexOutOfBoundsException( ) {

        super( ExceptionWrapperMessages.INDEXOUTOFBOUNDS.format( ) );
        this.myMessage = ExceptionWrapperMessages.INDEXOUTOFBOUNDS;
    }

    /**
     * Message: "Index: {0} Size: {1}"
     * 
     * @param index argument 0
     * @param maxIndex argument 1
     */
    @SuppressWarnings( "boxing" )
    public MoinIndexOutOfBoundsException( int index, int maxIndex ) {

        super( ExceptionWrapperMessages.INDEXOUTOFBOUNDSPARAM.format( index, maxIndex ) );
        this.myMessage = ExceptionWrapperMessages.INDEXOUTOFBOUNDS;
        this.myArgs = new Object[] { index, maxIndex };
    }

    /**
     * Generic constructor
     * 
     * @param message localized message
     * @param args arguments
     */
    public MoinIndexOutOfBoundsException( MoinLocalizedString message, Object... args ) {

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
