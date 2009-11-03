package com.sap.tc.moin.repository.core.xmi.writer;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Internal exception thrown by the
 * {@link com.sap.tc.moin.repository.xmi.XmiWriter} during serialization of an
 * XMI document.
 */
public final class XmiWriteException extends MoinLocalizedBaseRuntimeException {

    private static final long serialVersionUID = -2458405607314207816L;

    /**
     * @param messageId
     * @param cause
     */
    public XmiWriteException( MoinLocalizedString messageId, Throwable cause ) {

        super( cause, messageId );
    }

}