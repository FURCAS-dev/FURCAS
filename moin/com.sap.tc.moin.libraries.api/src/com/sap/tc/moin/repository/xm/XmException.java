package com.sap.tc.moin.repository.xm;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.util.MoinLocaleProvider;
import com.sap.tc.moin.repository.xm.ie.ModelExporter;
import com.sap.tc.moin.repository.xm.ie.ModelImporter;



/**
 * Exception thrown by XM Parser, XM Serializer, {@link ModelImporter} or
 * {@link ModelExporter}.
 * <p>
 * This class is not intended to be extended by clients. Use
 * {@link XmCustomException} instead.
 */
public abstract class XmException extends IOException {

    private static final long serialVersionUID = -6346029142408526419L;

    private transient final MoinLocalizedString myMessage;

    private transient final Object[] myArgs;

    /**
     * Constructor with localized error message.
     * 
     * @param message localized error message
     */
    public XmException( final MoinLocalizedString message, final Object... args ) {

        super( message.format( args ) );
        this.myMessage = message;
        this.myArgs = args;
    }

    /**
     * Constructor with localized error message and root cause exception.
     * 
     * @param cause root cause exception
     * @param message localized error message
     */
    public XmException( final Throwable cause, final MoinLocalizedString message, final Object... args ) {

        super( message.format( args ) );
        this.initCause( cause );
        this.myMessage = message;
        this.myArgs = args;
    }

    @Override
    public String getLocalizedMessage( ) {

        if ( this.myMessage != null ) {
            final Locale locale = MoinLocaleProvider.getInstance( ).getCurrentLocale( );
            if ( this.myArgs != null && this.myArgs.length > 0 ) {
                final MessageFormat format = new MessageFormat( this.myMessage.getLocalizedMessage( locale ), locale );
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

        final String s = getClass( ).getName( );
        final String message = getMessage( );
        return ( message != null ) ? ( s + ": " + message ) : s; //$NON-NLS-1$
    }
}
