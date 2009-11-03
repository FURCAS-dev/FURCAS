package com.sap.tc.moin.friends.ocl.editor;

import java.util.List;

import com.sap.tc.moin.repository.ProcessError;
import com.sap.tc.moin.repository.ProcessReport;
import com.sap.tc.moin.repository.ProcessWarning;


/**
 * The process report enriched with location information
 */
public class IncrementalProcessReport {

    ProcessReport report;

    int offset;

    int length;

    /**
     * @param actReport
     * @param actOffset
     * @param actLength
     */
    public IncrementalProcessReport( ProcessReport actReport, int actOffset, int actLength ) {

        this.report = actReport;
        this.offset = actOffset;
        this.length = actLength;
    }

    /**
     * @return the errors
     */
    public List<ProcessError> getErrors( ) {

        return this.report.getErrors( );
    }

    /**
     * @return the warnings
     */
    public List<ProcessWarning> getWarnings( ) {

        return this.report.getWarnings( );
    }

    /**
     * @return the offset
     */
    public int getOffset( ) {

        return this.offset;
    }

    /**
     * @return the length
     */
    public int getLength( ) {

        return this.length;
    }

}
