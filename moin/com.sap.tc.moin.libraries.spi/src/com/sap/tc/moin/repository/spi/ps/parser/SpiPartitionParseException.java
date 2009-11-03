package com.sap.tc.moin.repository.spi.ps.parser;

import com.sap.tc.moin.repository.exception.MoinBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * This exception can be thrown by any component that parses partition content.
 */
public final class SpiPartitionParseException extends MoinBaseRuntimeException {

    private static final long serialVersionUID = 590536375694485643L;

    private String errorLocation = null;

    /**
     * @param rootCause
     * @param message
     * @deprecated use a localized constructor and finally change the base class
     */
    @Deprecated
    public SpiPartitionParseException( Throwable rootCause, String message ) {

        super( message, rootCause );
    }

    /**
     * @param rootCause
     * @param message
     * @param args
     */
    public SpiPartitionParseException( Throwable rootCause, MoinLocalizedString message, Object... args ) {

        super( rootCause, message, args );
    }

    /**
     * @param message
     * @param args
     */
    public SpiPartitionParseException( MoinLocalizedString message, Object... args ) {

        super( message, args );
    }

    @Override
    public String getMessage( ) {

        if ( errorLocation == null ) {
            return super.getMessage( );
        }
        // Append the parser location that was added later on.
        return super.getMessage( ) + " [location: " + errorLocation + "]"; //$NON-NLS-1$//$NON-NLS-2$
    }

    /**
     * Enriches the exception with information about the error location within
     * the parsed content.
     */
    public void setParserLocation( String locationOfError ) {

        errorLocation = locationOfError;
    }
}
