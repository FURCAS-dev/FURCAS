/**
 * 
 */
package com.sap.mi.textual.epi.conf;

import java.util.Set;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.PRI;

/**
 *
 */
public class ReferenceScopeBean {

    private Connection connection;
    private Set<PRI> referencePRIs;
    /**
     * @param connection
     * @param referencePRIs
     */
    public ReferenceScopeBean(Connection connection, Set<PRI> referencePRIs) {
        super();
        this.connection = connection;
        this.referencePRIs = referencePRIs;
    }
    public Connection getConnection() {
        return connection;
    }
    public Set<PRI> getReferencePRIs() {
        return referencePRIs;
    }
    
    
}
