package com.sap.runlet.abstractinterpreter.repository;

import java.io.Serializable;
import java.util.Date;

/**
 * Whenever the contents of a {@link Repository} change, this creates a new <em>snapshot</em>
 * of the repository. Each snapshot has a unique identifier, represented by a {@link Snapshot}
 * instance. Such an ID can be used to access a specific snapshot in a {@link Repository} later.<p>
 * 
 * There is a semi-ordering defined over snapshots, meaning that one snapshot <em>may</em> be
 * a successor of another snapshot or vice versa, or two snapshots may not be in a successor /
 * predecessor relationship. However, two snapshots <tt>s1</tt> and <tt>s2</tt> may have a common
 * ancestor <tt>s0</tt> such that <tt>s0.precedes(s1)</tt> and <tt>s0.precedes(s2)</tt>.<p>
 * 
 * @author Axel Uhl (D043530)
 *
 */
public interface Snapshot extends Serializable {
    /**
     * Tells when this snapshot was committed, meaning when the {@link Repository} to which this
     * snapshot belongs got aware of the changes committed in this snapshot. Note that this has
     * little or nothing to do with an application-defined notion of <em>validity</em> as, e.g.,
     * for a work agreement or a quotation. The snapshot's date rather means when the repository
     * became aware of some change. Note also that across different repositories, time may not be
     * exactly synchronized. Therefore, it is generally unsafe to assume that
     * <em>physically after</em> exactly corresponds with {@link Date#after(Date)} on the results
     * of this method if the snapshots were created by different repositories.
     */
    Date when();
    
    //TODO: define and implement: equals / hashCode
    // --> equality should not be based on equality of repository content
}
