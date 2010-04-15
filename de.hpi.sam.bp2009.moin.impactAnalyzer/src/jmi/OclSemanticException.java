package com.sap.tc.moin.ocl.utils.jmi;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;

/**
 * Describes a Semantic Exception when parsing an OCL Expression
 */
public class OclSemanticException extends MoinLocalizedBaseException {

    /**
     * JLin
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param messageId message
     * @param args args
     */
    public OclSemanticException( MoinLocalizedString messageId, Object... args ) {

        super( messageId, args );

    }

    /**
     * @param rootCause root
     * @param messageId message
     * @param args args
     */
    public OclSemanticException( Throwable rootCause, MoinLocalizedString messageId, Object... args ) {

        super( rootCause, messageId, args );

    }

    /**
     * @param root root
     */
    public OclSemanticException( OclManagerException root ) {

        super( root );
    }

}
