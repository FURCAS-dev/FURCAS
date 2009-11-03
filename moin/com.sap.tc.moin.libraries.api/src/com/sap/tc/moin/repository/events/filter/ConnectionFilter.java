package com.sap.tc.moin.repository.events.filter;

import com.sap.tc.moin.repository.Connection;

/**
 * A ConnectionFilter allows filtering for events that were triggered by a
 * specific {@link Connection}.
 * 
 * @author Martin Kolb
 * @noimplement This interface is not intended to be implemented by clients.
 */
public class ConnectionFilter extends EventFilter {

    /**
     * @param connection The connection that shall be used as filter criterion
     */
    public ConnectionFilter( Connection connection ) {

        super( connection );
    }

}