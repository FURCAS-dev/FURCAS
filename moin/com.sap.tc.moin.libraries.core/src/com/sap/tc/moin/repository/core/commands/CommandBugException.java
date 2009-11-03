package com.sap.tc.moin.repository.core.commands;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Command Exception
 */
public class CommandBugException extends MoinLocalizedBaseRuntimeException {

    private static final long serialVersionUID = 2579738818641277029L;

    /**
     * @param message
     * @param args
     */
    public CommandBugException( MoinLocalizedString message, Object... args ) {

        super( message, args );
    }

}
