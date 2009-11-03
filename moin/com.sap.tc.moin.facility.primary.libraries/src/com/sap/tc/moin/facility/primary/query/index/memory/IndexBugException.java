package com.sap.tc.moin.facility.primary.query.index.memory;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;


public class IndexBugException extends MoinLocalizedBaseRuntimeException {

    /**
     * Generated ID
     */
    private static final long serialVersionUID = -6409066225848493965L;

    public IndexBugException( Throwable rootCause, MoinLocalizedString localizable, Object... parameters ) {

        super( rootCause, localizable, parameters );
    }

    public IndexBugException( MoinLocalizedString localizable, Object... parameters ) {

        super( localizable, parameters );
    }

}
