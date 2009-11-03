package com.sap.tc.moin.repository.s2x;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

public class S2XSerializerException extends MoinLocalizedBaseRuntimeException {

    private static final long serialVersionUID = 2062410808096012194L;

    public S2XSerializerException( MoinLocalizedString message, Object... args ) {
        super( message, args );
    }
}
