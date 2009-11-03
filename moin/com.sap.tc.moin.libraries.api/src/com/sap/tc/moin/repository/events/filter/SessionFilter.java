package com.sap.tc.moin.repository.events.filter;

import com.sap.tc.moin.repository.Session;

/**
 * A ConnectionFilter allows filtering for events that were triggered by a
 * specific {@link Session}.
 * 
 * @author Martin Kolb
 */
public class SessionFilter extends EventFilter {

    /**
     * @param session The session that shall be used as filter criterion
     */
    public SessionFilter( Session session ) {

        super( session );
    }

}