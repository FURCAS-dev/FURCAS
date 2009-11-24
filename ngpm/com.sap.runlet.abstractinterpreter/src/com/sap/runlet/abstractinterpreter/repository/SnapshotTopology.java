package com.sap.runlet.abstractinterpreter.repository;

import java.util.List;
import java.util.Set;


/**
 * Describes the topological relationship between two {@link Snapshot}s. If they are in a
 * predecessor/successor relationship, tells all snapshots on the path between them. If they are not
 * in a predecessor/successor relationship, tells if they have common predecessors / successors and
 * again tells the respective paths.
 * 
 * @author Axel Uhl (D043530)
 * 
 */
public interface SnapshotTopology {
    /**
     * Tells the two snapshots whose topological relationship is described by this object
     */
    Set<Snapshot> getSnapshots();
    
    /**
     * If one of the two snapshots is a direct or indirect predecessor of the other, returns the
     * path from the predecessor snapshot to the successor snapshot. Adjacent path elements are
     * direct predecessors/successors with no other snapshots in between. The first and the last
     * element of the list returned then are the two snapshots connected by this topology. If no
     * such path exists, <tt>null</tt> is returned.
     * <p>
     * 
     * Callers may use this method to determine if the two snapshots are direct neighbours:
     * <tt>getPath() != null && getPath().size() == 2</tt> is the predicate that tests for
     * direct neighbourhood.
     * 
     * Invariant:
     * <tt>getPath() != null implies (i&lt;j implies (getPath().get(i).precedes(getPath().get(j)) and not exists s:Snapshot | getPath().get(i).precedes(s) and s.precedes(getPath().get(j)))</tt>
     */
    List<Snapshot> getPath();
    
    /**
     * If the two {@link #snapshots snapshots} are not in a predecessor/successor relationship and
     * have one or more common predecessors, those are returned from this method.
     * <p>
     * 
     * For all snapshots <tt>s</tt> in the result the condition
     * <tt>forall (t:getSnapshots()) | s.precedes(t)</tt> holds. Furthermore,
     * all pairs of snapshots from the result are guaranteed not to be in a
     * predecessor/successor relationship to one another. There will be no snapshot
     * <tt>t</tt> such that for any <tt>s</tt> from the result set <tt>s.precedes(t)</tt>
     * and <tt>forall (s:getSnapshots()) | t.precedes(s)</tt>. In other words,
     * there is no successor of the common predecessors returned that still is a common
     * predecessor of the two {@link #getSnapshots() snapshots}. 
     */
    Set<Snapshot> getCommonPredecessors();
    
    /**
     * If the two {@link #snapshots snapshots} are not in a predecessor/successor relationship and
     * have one or more common successors, those are returned from this method.
     * <p>
     * 
     * For all snapshots <tt>s</tt> in the result the condition
     * <tt>forall (t:getSnapshots()) | s.succeeds(t)</tt> holds. Furthermore,
     * all pairs of snapshots from the result are guaranteed not to be in a
     * predecessor/successor relationship to one another. There will be no snapshot
     * <tt>t</tt> such that for any <tt>s</tt> from the result set <tt>s.succeeds(t)</tt>
     * and <tt>forall (s:getSnapshots()) | t.succeeds(s)</tt>. In other words,
     * there is no predecessor of the common successors returned that still is a common
     * successor of the two {@link #getSnapshots() snapshots}. 
     */
    Set<Snapshot> getCommonSuccessors();
}
