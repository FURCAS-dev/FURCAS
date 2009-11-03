package com.sap.tc.moin.repository.mql;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

import com.sap.tc.moin.repository.ProcessReport;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * A preprocessor exception is thrown when something goes wrong unexpectedly
 * during pre-processing that is not a format or type error. Observe that syntax
 * and type errors are usage errors which are thrown as
 * {@link MQLFormatException}s, which is a specialization of this exception.
 */
abstract public class MQLPreprocessorException extends MoinLocalizedBaseRuntimeException {

    private ProcessReport report;

    private static final long serialVersionUID = 8861140627280716070L;

    private static class ProcessReportWrapper implements MoinLocalizedString {

        private final ProcessReport myReport;

        public ProcessReportWrapper( ProcessReport report ) {

            this.myReport = report;
        }

        public String getLocalizedMessage( Locale locale ) {

            try {
                ByteArrayOutputStream os = new ByteArrayOutputStream( );
                this.myReport.printReport( locale, os );
                return os.toString( "UTF-8" ); //$NON-NLS-1$
            } catch ( UnsupportedEncodingException e ) {
                return this.myReport.toString( );
            } catch ( IOException e ) {
                return this.myReport.toString( );
            }
        }

        public String format( Object... args ) {

            return this.myReport.toString( );
        }

    }

    /**
     * Instantiates a new MQL preprocessor exception.
     * 
     * @param report the report
     */
    public MQLPreprocessorException( ProcessReport report ) {

        super( new ProcessReportWrapper( report ) );
        this.report = report;
    }

    /**
     * Obtain a report enlisting the errors and warnings during query parsing
     * and preparation.
     * 
     * @return a report enlisting the errors and warnings during query parsing
     * and preparation.
     */
    public ProcessReport getPreparationReport( ) {

        return this.report;
    }

}
