package com.sap.tc.moin.repository.consistency;

import com.sap.tc.moin.repository.LRI;

/**
 * Duplicate parent event. This violation event is raised if there are composite
 * parents pointing the same component.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author d026715
 */
public interface DuplicateParentConsistencyViolation extends ConsistencyViolation {

    /**
     * Returns the LRI of the element that has a duplicate parent.
     * 
     * @return LRI of the child element
     */
    LRI getChildLri( );

    /**
     * Returns the duplicate parent.
     * 
     * @return Parent element as {@link LRI}
     */
    LRI getParent( );

    /**
     * Returns the parent that is currently used by MOIN.
     * 
     * @return Parent element that is used by MOIN
     */
    LRI getUsedParent( );

}
