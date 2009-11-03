package com.sap.tc.moin.repository.spi.runtimehost.context;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseException;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;


/**
 * Environment-independent Wrapper for Transaction Exceptions.
 */
public class SpiTransactionException extends MoinLocalizedBaseRuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;


    /**
     * @param localizable
     */
    public SpiTransactionException( MoinLocalizedBaseException localizable ) {

        super( localizable );
        // TODO Auto-generated constructor stub
    }

    /**
     * @param localizable
     */
    public SpiTransactionException( MoinLocalizedBaseRuntimeException localizable ) {

        super( localizable );
        // TODO Auto-generated constructor stub
    }

    /**
     * @param localizable
     * @param parameters
     */
    public SpiTransactionException( MoinLocalizedString localizable, Object... parameters ) {

        super( localizable, parameters );
        // TODO Auto-generated constructor stub
    }

    /**
     * @param rootCause
     * @param localizable
     * @param parameters
     */
    public SpiTransactionException( Throwable rootCause, MoinLocalizedString localizable, Object... parameters ) {

        super( rootCause, localizable, parameters );
        // TODO Auto-generated constructor stub
    }

}
