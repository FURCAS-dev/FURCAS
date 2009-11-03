package com.sap.tc.moin.repository.core.jmi.reflect;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * This is an Exception which is thrown by the JMI base classes in case of an
 * recoverable exceptional condition
 */
public class JmiBaseRuntimeException extends MoinLocalizedBaseRuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * @param messageId the {@link MoinLocalizedString}
     */
    public JmiBaseRuntimeException( MoinLocalizedString messageId ) {

        super( messageId );
    }

    /**
     * @param messageId the {@link MoinLocalizedString}
     * @param args the arguments arguments
     */
    public JmiBaseRuntimeException( MoinLocalizedString messageId, Object... args ) {

        super( messageId, args );
    }

    /**
     * @param messageId message key
     * @param cause root cause
     */
    public JmiBaseRuntimeException( MoinLocalizedString messageId, Throwable cause ) {

        super( cause, messageId );
    }

}
