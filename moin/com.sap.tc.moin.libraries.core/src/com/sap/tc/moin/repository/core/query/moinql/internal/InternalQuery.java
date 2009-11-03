/*
 * Created on 03.02.2006
 */
package com.sap.tc.moin.repository.core.query.moinql.internal;

import com.sap.tc.moin.repository.ProcessReport;
import com.sap.tc.moin.repository.mql.MQLPreparedQuery;

/**
 * The InternalQuery is the basic representation of internally processed
 * queries. It is the result of the preprocessor and is transformed by the
 * scheduler to be interpreted by the MQL interpreter.
 */
public abstract class InternalQuery extends FromEntry implements MQLPreparedQuery {

    private ProcessReport report = null;

    public ProcessReport getPreparationReport( ) {

        return this.report;
    }

    public void setReport( ProcessReport _report ) {

        this.report = _report;
    }

    abstract public String toString( int indent, StringBuilder accumSb );

    @Override
    public String toString( ) {

        return toString( 0, new StringBuilder( ) );
    }
}
