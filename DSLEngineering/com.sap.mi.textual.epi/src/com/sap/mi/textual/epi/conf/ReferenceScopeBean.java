/**
 * 
 */
package com.sap.mi.textual.epi.conf;

import java.util.Set;



/**
 *
 */
public class ReferenceScopeBean {

    private ResourceSet connection;
    private Set<URI> referencePRIs;
    /**
     * @param connection
     * @param referencePRIs
     */
    public ReferenceScopeBean(ResourceSet connection, Set<URI> referencePRIs) {
        super();
        this.connection = connection;
        this.referencePRIs = referencePRIs;
    }
    public ResourceSet getConnection() {
        return connection;
    }
    public Set<URI> getReferencePRIs() {
        return referencePRIs;
    }
    
    
}
