package com.sap.tc.moin.repository.mql;

import com.sap.tc.moin.repository.ProcessReport;

/**
 * This exception may be thrown during the syntax and type checking of an MQL
 * query. It keeps a collection of type and usage errors in the formulation of
 * an MQL query.
 */
public class MQLFormatException extends MQLPreprocessorException {

    private static final long serialVersionUID = -4739285613393127920L;

    /**
     * Instantiates a new MQL format exception.
     * 
     * @param _report the _report
     */
    public MQLFormatException( ProcessReport _report ) {

        super( _report );
    }

}
