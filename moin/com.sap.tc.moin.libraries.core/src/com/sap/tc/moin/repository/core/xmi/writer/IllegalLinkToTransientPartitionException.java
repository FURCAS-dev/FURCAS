package com.sap.tc.moin.repository.core.xmi.writer;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Thrown by the XmiWriter during serialization in partition mode, if a link is
 * encountered that references a model element which is in a transient
 * partition. During serialization this is considered illegal, because it will
 * most likely produce dangling references.
 */
public final class IllegalLinkToTransientPartitionException extends MoinLocalizedBaseRuntimeException {

    private static final long serialVersionUID = 24013807372762876L;

    /**
     * @param messageId
     * @param args
     */
    public IllegalLinkToTransientPartitionException( MoinLocalizedString messageId, Object[] args ) {

        super( messageId, args );
    }


}