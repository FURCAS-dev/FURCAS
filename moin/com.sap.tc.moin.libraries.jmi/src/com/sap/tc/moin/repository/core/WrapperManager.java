package com.sap.tc.moin.repository.core;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

/**
 * The WrapperManager is able to return wrappers for JMI objects, JmiLists and
 * MOIN-specific entities all of which are handed out to clients via API calls.
 */
public interface WrapperManager {

    /**
     * Returns a wrapper for the given object if wrapping is necessary, and
     * otherwise returns the passed object as is.
     */
    public Object wrapObject( CoreConnection connection, Object object );

    /**
     * Takes the given {@link JmiException} and wraps its query-able attributes
     * (usually the model elements in error) if necessary.
     */
    public void wrapJmiExceptionAttributes( CoreConnection connection, JmiException jmiException );


}