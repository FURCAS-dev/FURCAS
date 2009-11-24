package com.sap.runlet.abstractinterpreter.repository;




/**
 * Objects that are or will be stored in a {@link Repository repository}.
 * @author D046040
 *
 */
public interface RepositoryObject extends Cloneable {
    
    /**
     * Returns the Snapshot this object belongs to. Always non-<tt>null</tt>. The snapshot
     * identifier of a {@link RepositoryObject} cannot be set except at construction time.
     * It defines this object's Java equality and hash code, meaning that two objects that
     * are otherwise equal but differ in their snapshot identifier return <tt>false</tt>
     * from {@link Object#equals(Object)}.
     */
    SnapshotIdentifier getOrigin();

    /**
     * Tells if this object has been saved (does not need to be committed yet) to the
     * persistent repository or has been loaded from there.
     */
    boolean isPersistent();
    
    /**
     * Marks this object as peristent. Postcondition: {@link #isPersistent()}<tt>==persistent</tt>
     */
    void setPersistent(boolean persistent);

    /**
     * Tells if this repository object can occur only once in a changeset. For example,
     * links of non-unique associations may occur multiple times.
     */
    boolean isUnique();
    
    /**
     * If this object's {@link #getOrigin() original snapshot} is not identival (<tt>==</tt>)
     * the expected <tt>snapshotIdentifier</tt>, a clone is created using the {@link #clone()}
     * operation, and the clone's origin is set to <tt>snapshotIdentifier</tt>. This also works
     * if <tt>snapshotIdentifier</tt> happens to be <tt>null</tt> or this object's
     * {@link #getOrigin() snapshot identifier} is <tt>null</tt>.<p>
     * 
     * Identical snapshot identifiers are important because then they will at the same
     * time get resolved, unresolved and advanced to some snapshot.
     */
    RepositoryObject getCopyWithOrigin(SnapshotIdentifier snapshotIdentifier);
    
    RepositoryObject clone() throws CloneNotSupportedException;
}
