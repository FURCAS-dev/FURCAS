package com.sap.tc.moin.repository.core.ocl.editorutils;

import com.sap.tc.moin.repository.ProcessError;
import com.sap.tc.moin.repository.ProcessWarning;
import com.sap.tc.moin.repository.shared.util.ProcessReportImpl;

/**
 * Overrides the default implementation so that errors are also consumed after a
 * fatal error was reported
 */
public class AllConsumingProcessReport extends ProcessReportImpl {

    private static final long serialVersionUID = 1L;

    /**
     * @param maxErrors max number of errros
     */
    public AllConsumingProcessReport( int maxErrors ) {

        super( maxErrors );
    }

    /**
     * @param offset offset
     */
    public void shiftMessagesByOffset( int offset ) {

        for ( ProcessError error : this.errors ) {
            error.setStartPosition( error.getStartPosition( ) + offset );
            error.setEndPosition( error.getEndPosition( ) + offset );
        }
        for ( ProcessWarning warning : this.warnings ) {
            warning.setStartPosition( warning.getStartPosition( ) + offset );
            warning.setEndPosition( warning.getEndPosition( ) + offset );
        }
    }

    /**
     * Adds a fatal error to the report and causes the process to fail. No
     * additional errors are registered
     */
    @Override
    public void reportFatalError( ProcessError error ) {

        this.processStatus = FATAL;
        if ( !this.fatal ) {
            this.errors.add( error );
            this.fatal = this.errors.size( ) >= this.MAX_NUMBER_OF_ERRORS;
        }
    }
}
