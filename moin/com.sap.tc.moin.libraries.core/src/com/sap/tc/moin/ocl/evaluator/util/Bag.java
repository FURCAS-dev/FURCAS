/*
 * Created on Jun 16, 2005
 *
 */
package com.sap.tc.moin.ocl.evaluator.util;

import java.util.Collection;

import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;

/**
 * @author C5065057
 *
 * Describes the interface for a "Bag" collection.
 */
public interface Bag extends Collection<OclAny> {

    /**
     * Returns the number of objects contained in this bag that
     * are equal to <em>o</em>.
     * @param o The object to search for.
     * @return The number of time <em>o<em> appears in this Bag.
     */
    public int count( OclAny o );
}
