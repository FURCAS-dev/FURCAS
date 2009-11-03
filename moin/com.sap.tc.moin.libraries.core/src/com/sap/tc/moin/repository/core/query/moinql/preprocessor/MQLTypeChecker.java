/*
 * Created on 02.02.2006
 */
package com.sap.tc.moin.repository.core.query.moinql.preprocessor;

import com.sap.tc.moin.repository.ProcessReport;
import com.sap.tc.moin.repository.core.query.moinql.internal.InternalQuery;
import com.sap.tc.moin.repository.mql.MQLFormatException;
import com.sap.tc.moin.repository.mql.MQLQuery;

/**
 * The type checker is responsible for translating the client api data structure
 * into the
 * {@link com.sap.tc.moin.repository.core.query.moinql.internal.InternalQuery}
 * structure. In doing so, the preprocessor resolves all relevant type
 * information and checks if the provided query has an interpretable format.
 */
public interface MQLTypeChecker {

    /**
     * Converts the user-defined query by doing type and format checkings
     */
    InternalQuery convert( MQLQuery selectClause, ProcessReport processReport ) throws MQLFormatException;

}
