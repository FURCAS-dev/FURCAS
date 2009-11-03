package com.sap.tc.moin.repository.exception;

import java.text.MessageFormat;
import java.util.Locale;

import com.sap.tc.moin.repository.util.MoinLocaleProvider;


/**
 * The {@link IllegalArgumentException} wrapper
 */
public class MoinIllegalArgumentException extends IllegalArgumentException {

    private static final long serialVersionUID = 1L;

    private transient MoinLocalizedString myMessage;

    private transient Object[] myArgs;

    /**
     * Message: {@link ExceptionWrapperMessages#ILLEGALARGUMENT}
     * 
     * @param argumentName argument 0
     */
    public MoinIllegalArgumentException( String argumentName ) {

        super( ExceptionWrapperMessages.ILLEGALARGUMENT.format( argumentName ) );
        this.myMessage = ExceptionWrapperMessages.ILLEGALARGUMENT;
        this.myArgs = new Object[] { argumentName };
    }

    /**
     * Message: {@link ExceptionWrapperMessages#ILLEGALARGUMENT}
     * 
     * @param argumentName argument 0
     * @param illegalArgumentValue argument 1
     */
    public MoinIllegalArgumentException( String argumentName, Object illegalArgumentValue ) {

        super( ExceptionWrapperMessages.ILLEGALARGUMENT.format( argumentName, String.valueOf( illegalArgumentValue ) ) );
        this.myMessage = ExceptionWrapperMessages.ILLEGALARGUMENT;
        this.myArgs = new Object[] { argumentName };
    }

    /**
     * Message: {@link ExceptionWrapperMessages#ILLEGAL_ARGUMENT_METHOD_VALUE}
     * 
     * @param methodName argument 0
     * @param argumentName argument 1
     * @param illegalArgumentValue argument 2
     */
    public MoinIllegalArgumentException( String methodName, String argumentName, Object illegalArgumentValue ) {

        super( ExceptionWrapperMessages.ILLEGAL_ARGUMENT_METHOD_VALUE.format( methodName, argumentName, String.valueOf( illegalArgumentValue ) ) );
        this.myMessage = ExceptionWrapperMessages.ILLEGAL_ARGUMENT_METHOD_VALUE;
        this.myArgs = new Object[] { argumentName };
    }

    /**
     * Generic constructor
     * 
     * @param message {@link MoinLocalizedString}
     * @param args arguments
     */
    public MoinIllegalArgumentException( MoinLocalizedString message, Object... args ) {

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
    public MoinIllegalArgumentException( Throwable rootCause, MoinLocalizedString message, Object... args ) {

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
