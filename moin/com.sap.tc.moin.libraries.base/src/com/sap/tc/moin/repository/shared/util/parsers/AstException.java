package com.sap.tc.moin.repository.shared.util.parsers;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseException;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Exception to report AST errors to the outside
 */
public class AstException extends MoinLocalizedBaseRuntimeException {


    private static final long serialVersionUID = 1L;

    /**
     * @param jmiException
     */
    public AstException( JmiException jmiException ) {

        super( LPGMessages.LPG_AST_BUILDER_JMIEXCEPTION, jmiException.getMessage( ) );
    }

    /**
     * @param rootCause
     */
    public AstException( Exception rootCause ) {

        super( LPGMessages.LPG_AST_BUILDER_ERROR, rootCause.getMessage( ) );
    }

    /**
     * @param message
     * @param args
     */
    public AstException( MoinLocalizedString message, Object... args ) {

        super( message, args );
    }

    /**
     * @param ex
     */
    public AstException( MoinLocalizedBaseException ex ) {

        super( ex );
    }
}
