package com.sap.tc.moin.repository.consistency;

import com.sap.tc.moin.repository.LRI;

/**
 * Missing element violation. This violation event is raised when a link cannot
 * be resolved because the element on one end does not exist.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author d026715
 */
public interface DanglingLinkConsistencyViolation extends ConsistencyViolation {

    /**
     * Returns the LRI of the missing model element.
     * 
     * @return Missing element as {@link LRI}
     */
    LRI getMissingElement( );

    /**
     * Returns the opposite end of the missing element.
     * 
     * @return Existing link end as {@link LRI}
     */
    LRI getExistingEnd( );
}
