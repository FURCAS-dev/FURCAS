package com.sap.tc.moin.repository;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * The DeepCopyMap contains the mappings for the elements being copied during a
 * deep copy process.
 * 
 * @see Connection#deepCopy(java.util.Collection, DeepCopyPolicyHandler,
 * boolean)
 * @author d046918
 * <p>
 * @noimplement This interface is not intended to be implemented by clients.
 */

public interface DeepCopyMap {

    /**
     * @param element The element for which the mapping target is looked up
     * @return The mapping entry for the element
     */

    public DeepCopyMappingEntry get( RefObject element );

    /**
     * @param element
     * @return True if the mapping table contains an entry for the element
     */
    public boolean containsKey( RefObject element );

}
