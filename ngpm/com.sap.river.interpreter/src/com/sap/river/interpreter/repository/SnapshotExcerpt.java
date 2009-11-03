package com.sap.river.interpreter.repository;

import java.util.Collection;

import com.sap.river.interpreter.objects.EntityObject;
import com.sap.river.interpreter.objects.Link;

/**
 * A subset of the information that a {@link Repository} stores for a {@link Snapshot}. In
 * particular, this is a set of entity objects and a set of links that exist at that snapshot.<p>
 * 
 * A set of consistency rules apply to such a snapshot excerpt. In particular, all links to value
 * objects that are equality-relevant for any of the entities returned by {@link #getObjects()} are
 * guaranteed to be in the collection returned by {@link #getLinks()}.<p>
 * 
 * TODO depending on whether or not a {@link Snapshot} knows its pertinence to a {@link Repository}, we may or may not need to manage this pertinence here
 * 
 * @author Axel Uhl (D043530)
 * 
 */
public interface SnapshotExcerpt {
    /**
     * The snapshot from which this excerpt was taken
     */
    Snapshot getSnapshot();

    Collection<EntityObject> getObjects();
    
    Collection<Link> getLinks();
}
