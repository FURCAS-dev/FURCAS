package com.sap.tc.moin.repository.spi.core.cps;


/**
 * Internal interface implemented by all implementors of
 * {@link SpiParserCallback}.
 */
public interface SpiParserCallbackInternal {

    /**
     * Notifies the parser callback that errors occurred during parsing.
     */
    public void markHadErrorsDuringLoad( );

    /**
     * Notifies the parser callback that errors occurred during parse and the
     * error handler could not fix the problem.
     */
    public void markHadUnhandledErrorsDuringLoad( );
}
