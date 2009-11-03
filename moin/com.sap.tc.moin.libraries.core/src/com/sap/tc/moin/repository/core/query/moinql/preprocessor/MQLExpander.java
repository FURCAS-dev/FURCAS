/*
 * Created on 02.03.2006
 */
package com.sap.tc.moin.repository.core.query.moinql.preprocessor;

import com.sap.tc.moin.repository.core.query.moinql.internal.InternalQuery;
import com.sap.tc.moin.repository.mql.MQLPreprocessorException;

/**
 * The expander transforms the internal query such that its <i>leafs</i> are
 * interpretable by a facility query language. If a particular part of the MQL
 * query is not supported the
 * {@link com.sap.tc.moin.repository.mql.MQLNotSupportedException} is thrown
 */
public interface MQLExpander {

    /**
     * Expands the internal query structure
     */
    InternalQuery expand( InternalQuery internalQuery ) throws MQLPreprocessorException;

}
