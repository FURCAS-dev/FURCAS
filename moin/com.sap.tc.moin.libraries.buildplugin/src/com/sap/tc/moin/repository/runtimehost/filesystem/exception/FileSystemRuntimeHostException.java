package com.sap.tc.moin.repository.runtimehost.filesystem.exception;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * The MOIN Runtime Host exception class used to report e.g. problems in MOIN
 * metamodel deployment functionality.
 * 
 * @param message exception description.
 * @param rootCause root exception.
 */

@SuppressWarnings( "serial" )
public class FileSystemRuntimeHostException extends MoinLocalizedBaseRuntimeException {

    /**
     * The MOIN Runtime Host exception, used for example to report deployment
     * exception.
     * 
     * @param reason the exception reason.
     */
    public FileSystemRuntimeHostException( MoinLocalizedString reason ) {

        super( reason );
    }


    public FileSystemRuntimeHostException( MoinLocalizedString reason, Object... parameters ) {

        super( reason, parameters );
    }

    public FileSystemRuntimeHostException( Throwable rootCause, MoinLocalizedString reason, Object... parameters ) {

        super( rootCause, reason, parameters );
    }

    /**
     * The MOIN Runtime Host exception, used for example to report deployment
     * exception.
     * 
     * @param e root exception.
     */
//    public FileSystemRuntimeHostException( Throwable e ) {
//
//        super( e );
//    }
    /**
     * Constructs a runtime host RuntimeException with the specified message and
     * root cause exception.
     * 
     * @param message
     * @param cause
     */
//    public FileSystemRuntimeHostException( String message, Throwable cause ) {
//
//        super( message, cause );
//    }
}
