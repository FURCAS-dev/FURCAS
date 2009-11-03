package com.sap.tc.moin.repository.ocl.exceptions;

import com.sap.tc.moin.repository.ProcessReport;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseException;

/**
 * This Exception is thrown by the OclParser if it encounters error during
 * parsing an OCL expression
 */
public class ParsingException extends MoinLocalizedBaseException {

    private static final long serialVersionUID = 1L;

    private ProcessReport report;

    /**
     * Creates a new ParsingException
     * 
     * @param semanticException the causing Exception
     * @param theReport the ParsingReport object holding information about
     * errors and warnings.
     */
    public ParsingException( MoinLocalizedBaseException semanticException, ProcessReport theReport ) {

        super( semanticException );
        this.report = theReport;
    }

    /**
     * @return the ParsingReport containing a list of error and warnings which
     * can be used to obtain more information about why parsing failed.
     */
    public ProcessReport getReport( ) {

        return this.report;
    }
}
