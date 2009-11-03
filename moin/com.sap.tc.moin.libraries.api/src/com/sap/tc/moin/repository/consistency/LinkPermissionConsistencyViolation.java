package com.sap.tc.moin.repository.consistency;

import com.sap.tc.moin.repository.MRI;

/**
 * Link permission violation event. This consistency violation event is raised
 * if a link cannot be resolved because the partition of the element on one end
 * does not have access to the partition of the element at the other end due to
 * permission restrictions, for example by the lifecycle management (DCs).
 * <p>
 * This interface is not intended to be implemented by clients.
 * 
 * @author d026715
 */
public interface LinkPermissionConsistencyViolation extends ConsistencyViolation {

    /**
     * Returns the {@link MRI} of end that cannot be accessed.
     * 
     * @return Link end that violates the permission restrictions as {@link MRI}
     */
    MRI getDeniedEnd( );

    /**
     * Returns the {@link MRI} of the end that can be accessed.
     * 
     * @return Source link end as {@link MRI}.
     */
    MRI getAllowedEnd( );
}
