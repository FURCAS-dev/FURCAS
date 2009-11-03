package com.sap.tc.moin.repository.core.xmi.reader;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Internal exception thrown by
 * {@link com.sap.tc.moin.repository.core.xmi.reader.RepositoryService}
 * implementations, if errors occur during the update of the repository content.
 * 
 * @author d027299
 */
public final class RepositoryUpdateException extends MoinLocalizedBaseRuntimeException {

    private static final long serialVersionUID = -4653249067003520655L;


    public RepositoryUpdateException( MoinLocalizedString messageId, Object[] args ) {

        super( messageId, args );
    }

    public RepositoryUpdateException( MoinLocalizedString messageId, Object[] args, Throwable rootCause ) {

        super( rootCause, messageId, args );
    }

    public RepositoryUpdateException( MoinLocalizedString messageId, Throwable cause ) {

        super( cause, messageId );
    }

}