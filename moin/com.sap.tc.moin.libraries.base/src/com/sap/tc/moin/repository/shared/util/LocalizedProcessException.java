package com.sap.tc.moin.repository.shared.util;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;


/**
 * Used to report problems
 */
public class LocalizedProcessException extends MoinLocalizedBaseRuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * @param localizable
     * @param parameters
     */
    public LocalizedProcessException( MoinLocalizedString localizable, Object... parameters ) {

        super( localizable, parameters );
    }


}
