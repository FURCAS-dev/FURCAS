package com.sap.tc.moin.repository.ide.metamodels;

import java.util.List;
import java.util.Set;

/**
 * The result of
 * {@link MmGenerator#generate(MmGenerationInfo, java.util.Collection)} which
 * includes further details about what was generated.
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface MmGenerationResult {

    /**
     * The path fragments (as dictated by the Java package) of the generated
     * entities in the {@link MmGenerationInfo#getJmiDirectory() jmi directory},
     * e.g. [com,sap,tc,moin], [com,sap,tc,moin,textverticalization], ... in no
     * particular order.
     * 
     * @return the path fragments of the generated entities, an empty set if
     * nothing was generated, never <code>null</code>.
     */
    public Set<List<String>> getGeneratedPathFragments( );
}
