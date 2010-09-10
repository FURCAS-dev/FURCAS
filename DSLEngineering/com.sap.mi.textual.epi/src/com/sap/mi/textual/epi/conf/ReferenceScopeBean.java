/**
 * 
 */
package com.sap.mi.textual.epi.conf;

import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;



/**
 *
 */
public class ReferenceScopeBean {

    private final ResourceSet connection;
    private final Set<URI> referencePRIs;
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
