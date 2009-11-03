package com.sap.tc.moin.repository.shared.logger;

import com.sap.tc.logging.Severity;

/**
 * Definition of the MOIN-relevant severities.
 * <p>
 * The MOIN severieties maps to the SAP Logging and Tracing severities. For more
 * information, see SAP Logging API and the com.sap.tc.logging.Severity class.
 * 
 * @author d029324
 */

public enum MoinSeverity {
    /**
     * The fatal severity.
     * <p>
     * The fatal severity should be used to inform about problems that make the
     * MOIN application not usable.
     */
    FATAL( Severity.FATAL ),

    /**
     * The error severity.
     * <p>
     * The error severity should be used to inform about important problems /
     * errors, for example prevent the normal execution of particular MOIN
     * client requests.
     */
    ERROR( Severity.ERROR ),

    /**
     * The warning severity.
     * <p>
     * The warning severity should be used if some potential problem occurs and
     * the administrator should be inform about this.
     */
    WARNING( Severity.WARNING ),

    /**
     * The info severity.
     * <p>
     * The info severity should be used to inform about some important
     * application states, events, etc.
     */
    INFO( Severity.INFO ),

    /**
     * The path severity.
     * <p>
     * The path severity can only be used for trace functionality. It should be
     * used for messages that reports the program flow.
     */
    PATH( Severity.PATH ),

    /**
     * The debug severity.
     * <p>
     * The debug severity can only be used for trace functionality. It should
     * should be used to report messages that contains content relevant trace
     * information.
     */
    DEBUG( Severity.DEBUG );

    private int severity;

    MoinSeverity( int severity ) {

        this.severity = severity;
    }

    public int severity( ) {

        return this.severity;
    }
}
