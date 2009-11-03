package com.sap.tc.moin.repository.consistency;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;

/**
 * Duplicate element event. This violation event is raised when an element
 * cannot be resolved because more than one elements with the same {@link LRI}
 * exist in different partitions. For each of the elements one violation event
 * is raised. <br>
 * The inconsistency handling more or less randomly chooses one of the duplicate
 * elements to be used so that the model partition can be loaded. The element
 * that is currently used can be obtained by {@link #getUsedElementsMri()}.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author d026715
 */
public interface DuplicateElementConsistencyViolation extends ConsistencyViolation {

    /**
     * Returns the MRI of the duplicate element.
     * 
     * @return MRI of the duplicate element
     */
    MRI getMri( );

    /**
     * Returns the MRI of the element that is used. This is the element that
     * MOIN returns when the {@link LRI} of the element is resolved (e. g. by
     * {@link Connection#getElement(LRI)}.
     * 
     * @return MRI of the element that is used
     */
    MRI getUsedElementsMri( );

}
