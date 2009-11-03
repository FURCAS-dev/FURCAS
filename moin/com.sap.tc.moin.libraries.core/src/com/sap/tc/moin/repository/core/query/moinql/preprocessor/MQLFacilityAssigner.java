/*
 * Created on 02.03.2006
 */
package com.sap.tc.moin.repository.core.query.moinql.preprocessor;

import com.sap.tc.moin.repository.core.query.moinql.internal.InternalQuery;
import com.sap.tc.moin.repository.mql.MQLPreprocessorException;

/**
 * The assigner is responsible for assigning the facility query services to the
 * different parts of the internal query. If more than one query service is
 * registered (i.e. more than one facility connected), the internal query is
 * transformed such that it considers all registered facilities.
 */
public interface MQLFacilityAssigner {

    /**
     * Assign the registered facility services to the Atomic Parts of the
     * internal query
     */
    InternalQuery assign( InternalQuery internalQuery ) throws MQLPreprocessorException;

}
