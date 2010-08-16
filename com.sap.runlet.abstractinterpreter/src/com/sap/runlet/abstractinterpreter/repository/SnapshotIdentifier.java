package com.sap.runlet.abstractinterpreter.repository;

import java.io.Serializable;

/**
 * Identifies a snapshot. Over time, depending on the state of the repository, the identifier may
 * resolve to different snapshots. However, at any given point in time the identifier can resolve to
 * at most one snapshot in any given repository. If the identifier is currently resolved to a
 * specific snapshot, that snapshot is returned by the {@link #getSnapshot()} method. A
 * {@link Repository} may use the {@link #setSnapshot(Snapshot)} method to resolve the identifier in
 * the current repository's state.
 * 
 * @see Repository#resolve(SnapshotIdentifier)
 * 
 * @author Axel Uhl (D043530)
 */
public interface SnapshotIdentifier extends Cloneable, Serializable {
    /**
     * The snapshot from which to answer the query. If <tt>null</tt>, answer the query
     * from the latest ({@link Repository#getCurrent}) snapshot.
     */
    Snapshot getSnapshot();
    
    /**
     * If {@link #getSnapshot()} returns <tt>null</tt> and the {@link Repository} needs to
     * answer a query in the context of a particular snapshot, the repository will call
     * this operation to announce from which snapshot it actually did read data.
     */
    void setSnapshot(Snapshot snapshot);

    SnapshotIdentifier clone();

    /**
     * If a snapshot identifier can be resolved to a particular snapshot it may
     * also be possible to unresolve it. If a snapshot identifier supports this, it
     * should implement this method by untying from the snapshot. If a snapshot
     * identifier is attached to a snapshot and cannot be unresolved, it may just
     * ignore this call.
     */
    void unresolve();

}
