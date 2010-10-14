package com.sap.runlet.abstractinterpreter.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.sap.runlet.abstractinterpreter.objects.ClassTypedObject;
import com.sap.runlet.abstractinterpreter.objects.EntityObject;
import com.sap.runlet.abstractinterpreter.objects.Link;
import com.sap.runlet.abstractinterpreter.operationaltransformation.Change;
import com.sap.runlet.abstractinterpreter.util.ClassFilterIterator;
import com.sap.runlet.abstractinterpreter.util.ModelAdapter;
import com.sap.runlet.abstractinterpreter.util.Tuple.Pair;

/**
 * Describes a set of changes to data. This can include creation and deletion of
 * entity objects as well as creation and deletion of links, both subsumed by
 * the {@link RepositoryObject} interface. For links of an ordered association
 * an insert / delete position must be specified.
 * <p>
 * 
 * When links or objects are announced for creation or deletion and this change
 * set already contains the inverse operation for the link/object, then instead
 * of adding a new change the inverse change will be removed from this change
 * set. For links of an ordered association this means that the positional
 * changes of such links have to be tracked with every modification that occurs
 * "before" a link because only then the "inverse" of an operation can be
 * recognized.
 * <p>
 * 
 * If, for example, <tt>l1</tt> and <tt>l2</tt> are links for the same ordered,
 * non-unique association, then
 * 
 * <pre>
 *   objectCreated(l1, 0)
 *   objectCreated(l2, 0)	--&gt; l2, l1
 *   objectCreated(l2, 1)	--&gt; l2, l2, l1
 *   objectCreated(l1, 1)	--&gt; l2, l1, l2, l1
 *   objectDeleted(l1, 3)	--&gt; l2, l1, l2
 * </pre>
 * 
 * should produce the link sequence <tt>l2, l1, l2</tt> because the second
 * occurrence in the list (which was the first to be inserted) should be deleted
 * by <tt>objectDeleted(l1, 3)</tt>. This should leave the change sequence as
 * follows:
 * 
 * <pre>
 *   objectCreated(l2, 0)	--&gt; l2
 *   objectCreated(l2, 1)	--&gt; l2, l2
 *   objectCreated(l1, 1)	--&gt; l2, l1, l2
 * </pre>
 * 
 * Note, that in case of unique associations less effort needs to be spent
 * tracking the positions because inserts will be re-played in the order in
 * which they occurred, and deletion can delete the only element equal to the
 * one to be deleted, regardless of its position.
 * <p>
 * 
 * Furthermore, the order in which events occurred is preserved. This is
 * particularly important for later replay regarding the order of creations and
 * deletions as well as the order and positions at which links have been
 * inserted to or deleted from an (ordered) association.
 * <p>
 * 
 * If an entity is already marked as created or deleted, a second request to
 * mark it the same way is ignored. For links, redundant mark requests are
 * ignored if the association that the link instantiates has "unique"
 * multiplicities (see {@link Multiplicity#isUnique()}). Otherwise, multiple
 * create/delete requests need to be honored because they mean to create/delete
 * multiple copies of the respective link.
 * <p>
 * 
 * There is a logical grouping of {@link LinkCreation}s possible. First of all,
 * those that insert into the same ordered link sequence (see
 * {@link #areLinksFromSameOrderedEntitySequence(LinkChange, LinkChange)}) form
 * one group each. Those groups can further be subdivided into one or more
 * "contiguous stretches" (see {@link StretchOfContiguousLinkCreations}) where
 * each such stretch contains {@link LinkCreation}s that insert before the same
 * original element. With this, each {@link LinkCreation}'s relative position
 * within its stretch can be determined. For each original element it is then
 * possibile to determine the stretch of {@link LinkCreation}s in this change
 * set that end up immediately before this original element. For each stretch,
 * the stretch's length can be determined, too.
 * <p>
 * 
 * When the original element that separates two adjacent stretches of
 * {@link LinkCreation}s is deleted, later inserts into any of these two
 * stretches have to be unambiguously assigned to one of the two stretches. For
 * inserts where there is at least one previously existing element of one of the
 * stretches between the new insert and the delete position, assigning the
 * insert to one of the two stretches is obvious. We onlz have to arbitrate the
 * case where the insert happens "between" the stretches. Since link insert
 * positions are always specified as a "before" position, it seems intuitive to
 * assign a link insertion happening at the boundary between the stretches as an
 * insert into the right stretch because it happens before that stretch's first
 * link.
 * <p>
 * 
 * TODO Currently, adding changes to a change set will have squared effort over
 * the number of changes because adding a change has to scan all previous
 * changes for inverse operations. Hashing / caching the changes for O(1) access
 * will help but is non-trivial given that the cache will have to consider
 * multiple insertions / deletions of equal links in case of non-unique
 * associations.
 * 
 * @author Axel Uhl (D043530)
 * 
 */
public class ChangeSetImpl<LinkMetaObject extends EObject, LinkEndMetaObject extends EObject,
MetaClass extends EObject, TypeUsage extends EObject, ClassUsage extends TypeUsage>
implements MutableChangeSet<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>,
Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> {
    private final List<RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> changes;
    
    /**
     * Remembers the link creations for ordered associations by object to which
     * the links attach on their unordered end. The value is a map that preserves
     * the order in which the creations occurred where the keys describe the creation
     * and the values define the position at which the link has ended up after all
     * changes recorded so far in this change set's full list of {@link #changes}.
     */
    private final Map<Pair<LinkMetaObject, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>>,
    	Map<LinkCreation<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>, Integer>> linkCreationsInOrderedAssociations;

    /**
     * Remembers the link deletions for ordered associations by object to which
     * the links attach on their unordered end. The value is a map that preserves
     * the order in which the deletions occurred where the keys describe the deletion
     * and the values define the position at which the link has ended up after all
     * changes recorded so far in this change set's full list of {@link #changes}.
     */
    private final Map<Pair<LinkMetaObject, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>>,
    Map<LinkDeletion<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>, Integer>> linkDeletionsInOrderedAssociations;

    private ModelAdapter<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> getModelAdapter() {
        return modelAdapter;
    }

    public ChangeSetImpl(ModelAdapter<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> modelAdapter) {
	this.modelAdapter = modelAdapter;
	changes = new LinkedList<RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>();
	linkCreationsInOrderedAssociations = new HashMap<Pair<LinkMetaObject, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>>,
		Map<LinkCreation<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>, Integer>>();
	linkDeletionsInOrderedAssociations = new HashMap<Pair<LinkMetaObject, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>>,
		Map<LinkDeletion<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>, Integer>>();
    }
    
    public ChangeSetImpl(Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> changes,
	    ModelAdapter<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> modelAdapter) {
	this(modelAdapter);
	for (RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> change : changes) {
	    change.addTo(this);
	}
    }

    private final ModelAdapter<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> modelAdapter;

    public Map<Pair<LinkMetaObject, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>>,
    Map<LinkCreation<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>, Integer>> getLinkCreationsInOrderedAssociations() {
        return Collections.unmodifiableMap(linkCreationsInOrderedAssociations);
    }

    public Map<Pair<LinkMetaObject, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>>, 
    Map<LinkDeletion<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>, Integer>> getLinkDeletionsInOrderedAssociations() {
        return Collections.unmodifiableMap(linkDeletionsInOrderedAssociations);
    }
    
    @Override
    public synchronized void entityCreated(EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> entity) {
	EntityDeletion<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> deletion = getDeletionOf(entity);
	if (deletion != null) {
	    changes.remove(deletion);
	} else {
	    if (!entity.isUnique() || getCreationOf(entity) == null) {
		EntityCreation<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> entityCreation =
		    new EntityCreation<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(entity, getModelAdapter());
		changes.add(entityCreation);
	    }
	}
    }

    private EntityCreation<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> getCreationOf(
	    EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> entity) {
	for (RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> change : changes) {
	    if (change.isEntityChange() && change.isCreate() && change.getObject().equals(entity)) {
		return (EntityCreation<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) change;
	    }
	}
	return null;
    }

    private EntityDeletion<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> getDeletionOf(
	    EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> entity) {
	for (RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> change : changes) {
	    if (change.isEntityChange() && change.isDelete() && change.getObject().equals(entity)) {
		return (EntityDeletion<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) change;
	    }
	}
	return null;
    }

    private LinkCreation<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> getCreationOf(
	    Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> link) {
	for (RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> change : changes) {
	    if (change.isLinkChange() && change.isCreate() && change.getObject().equals(link)) {
		return (LinkCreation<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) change;
	    }
	}
	return null;
    }

    private LinkDeletion<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> getDeletionOf(
	    Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> link) {
	for (RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> change : changes) {
	    if (change.isLinkChange() && change.isDelete() && change.getObject().equals(link)) {
		return (LinkDeletion<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) change;
	    }
	}
	return null;
    }

    @Override
    public synchronized void entityDeleted(EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> entity) {
	EntityCreation<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> creation = getCreationOf(entity);
	if (creation != null) {
	    changes.remove(creation);
	} else {
	    if (getDeletionOf(entity) == null) {
		EntityDeletion<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> entityDeletion =
		    new EntityDeletion<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(entity, getModelAdapter());
		changes.add(entityDeletion);
	    }
	}
    }

    @Override
    public synchronized void linkCreated(Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> link, Integer at) {
	if (link.isOrdered() && (at == null || at == -1)) {
	    throw new RuntimeException("Link position for inserting into ordered association "+
		    getModelAdapter().getAssociationName(link.getAssociation())+" not specified");
	}
	// From here on it is safe to assume that for links of ordered associations a
	// valid int has been specified for the "at" argument.
	LinkDeletion<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> deletion = getDeletionOf(link);
	boolean cancel = false; // does the creation cancel out with a previous deletion?
	if (deletion != null) {
	    if (link.isOrdered()) {
		// Check if the link created would appear at the same position to which the
		// link deletion may have shifted over time
		Pair<LinkMetaObject, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>> deletionKey =
		    new Pair<LinkMetaObject, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>>(
			link.getAssociation(), link.getAtOppositeOfOrderedEnd());
		int currentPosOfDeletedLink = linkDeletionsInOrderedAssociations.get(deletionKey).get(deletion);
		// at is guaranteed to be non-null here; see check at beginning of method
		if (currentPosOfDeletedLink == at) {
		    cancel = true;
		}
	    } else {
		cancel = true;
	    }
	}
	if (cancel) {
	    removeChange(deletion);
	} else {
	    if (!link.isUnique() || getCreationOf(link) == null) {
		LinkCreation<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> linkCreation =
		    new LinkCreation<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(link, at);
		changes.add(linkCreation);
		if (link.isOrdered()) {
		    Pair<LinkMetaObject, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>> creationKey =
			new Pair<LinkMetaObject, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>>(
			    link.getAssociation(), link.getAtOppositeOfOrderedEnd());
		    if (at != null) { // null means append, nothing to shift anyway
			shiftOrderedLinkChanges(link.getAssociation(), link.getAtOppositeOfOrderedEnd(), at, +1);
		    }
		    Map<LinkCreation<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>, Integer> creations =
			linkCreationsInOrderedAssociations.get(creationKey);
		    if (creations == null) {
			creations = new HashMap<LinkCreation<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>, Integer>();
			linkCreationsInOrderedAssociations.put(creationKey, creations);
		    }
		    creations.put(linkCreation, at);
		}
	    }
	}
    }

    /**
     * For all link creations and deletions in association <tt>association</tt> with the object
     * at the unordered end being <tt>unorderedEnd</tt> and with their position being greater or
     * equal <tt>at</tt>, increases their current position by <tt>delta</tt>. For negative values
     * of <tt>delta</tt> this effectively means a decrease.
     */
    private void shiftOrderedLinkChanges(LinkMetaObject association,
	    ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> unorderedEnd, int at, int delta) {
	shiftOrderedLinkChanges(association, unorderedEnd, at, delta, linkCreationsInOrderedAssociations);
	shiftOrderedLinkChanges(association, unorderedEnd, at, delta, linkDeletionsInOrderedAssociations);
    }

    /**
     * For all link creations and deletions in association <tt>association</tt> with the object
     * at the unordered end being <tt>unorderedEnd</tt> and with their position being greater or
     * equal <tt>at</tt>, increases their current position by <tt>delta</tt>. For negative values
     * of <tt>delta</tt> this effectively means a decrease.
     */
    private <T extends RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> void shiftOrderedLinkChanges(
	    LinkMetaObject association, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> unorderedEnd, int at, int delta,
	    Map<Pair<LinkMetaObject, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>>, Map<T, Integer>> map) {
	Pair<LinkMetaObject, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>> key =
	    new Pair<LinkMetaObject, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>>(association, unorderedEnd);
	Map<T, Integer> theChanges = map.get(key);
	if (theChanges != null) {
	    for (T change : theChanges.keySet()) {
		if (theChanges.get(change) >= at) {
		    theChanges.put(change, theChanges.get(change) + delta);
		}
	    }
	}
    }

    @Override
    public synchronized void linkDeleted(Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> link, Integer at) {
	if (link.isOrdered() && (at == null || at == -1)) {
	    throw new RuntimeException("Link position for deleting from ordered association "+
		    getModelAdapter().getAssociationName(link.getAssociation())+" not specified");
	}
	LinkCreation<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> creation = getCreationOf(link);
	boolean cancel = false; // does the creation cancel out with a previous deletion?
	if (creation != null) {
	    if (link.isOrdered()) {
		// Check if the link created would appear at the same position to which the
		// link deletion may or may not have shifted over time
		Pair<LinkMetaObject, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>> deletionKey =
		    new Pair<LinkMetaObject, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>>(
			link.getAssociation(), link.getAtOppositeOfOrderedEnd());
		int currentPosOfCreatedLink = linkCreationsInOrderedAssociations.get(deletionKey).get(creation);
		if (currentPosOfCreatedLink == at) {
		    cancel = true;
		}
	    } else {
		cancel = true;
	    }
	}
	if (cancel) {
	    removeChange(creation);
	} else {
	    if (!link.isUnique() || getDeletionOf(link) == null) {
		LinkDeletion<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> linkDeletion =
		    new LinkDeletion<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(link, at);
		changes.add(linkDeletion);
		if (link.isOrdered()) {
		    Pair<LinkMetaObject, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>> deletionKey =
			new Pair<LinkMetaObject, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>>(
			    link.getAssociation(), link.getAtOppositeOfOrderedEnd());
		    shiftOrderedLinkChanges(link.getAssociation(), link.getAtOppositeOfOrderedEnd(), at, -1);
		    Map<LinkDeletion<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>, Integer> deletions =
			linkDeletionsInOrderedAssociations.get(deletionKey);
		    if (deletions == null) {
			deletions = new HashMap<LinkDeletion<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>, Integer>();
			linkDeletionsInOrderedAssociations.put(deletionKey, deletions);
		    }
		    deletions.put(linkDeletion, at);
		}
	    }
	}
    }
    
    @Override
    public Iterator<RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> getChanges() {
	return new ArrayList<RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>(changes).iterator();
    }

    /**
     * Checks if the two link changes describe changes to the same ordered association with
     * the same entity on the unordered end. This makes the two links part of the same
     * link sequence that represents the ordered "collection" of objects on the ordered
     * end when navigated from that same object at the unordered end.
     */
    public static <LinkMetaObject extends EObject, LinkEndMetaObject extends EObject,
    MetaClass extends EObject, TypeUsage extends EObject, ClassUsage extends TypeUsage>
    boolean areLinksFromSameOrderedEntitySequence(
	    LinkChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> lc1,
	    LinkChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> lc2) {
	return (lc1.getObject().isOrdered() &&
		lc1.getObject().getAssociation().equals(lc2.getObject().getAssociation()) &&
		lc1.getObject().getAtOppositeOfOrderedEnd().logicallyEquals(lc2.getObject().getAtOppositeOfOrderedEnd()));
    }

    /**
     * For a link change of an association with one ordered end determines at
     * what <em>original</em> position the change would have occurred if it had
     * been the only change in this change set. Note, that this method will
     * return the same result for multiple contiguous inserts from this change
     * set.
     * <p>
     * 
     * @param linkChange
     *            needs to be contained in this change set's {@link #changes}.
     *            The original position of the change is computed based on the
     *            changes preceding <tt>linkChange</tt>.
     */
    public int getOriginalPosition(LinkChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> linkChange) {
	if (!linkChange.getObject().isOrdered()) {
	    throw new RuntimeException("Can't determine a position for a link of an unordered association");
	}
	RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> change = null;
	int positionMappedToI = linkChange.getPosition();
	// backward-traverse all changes timewise preceding linkChange
	int indexOfLinkChange = changes.indexOf(linkChange);
	int startReverseIterationAt;
	if (indexOfLinkChange == -1) {
	    throw new RuntimeException("link change " + linkChange + " not contained in change set " + this
		    + ". Can't determine its original position.");
	} else {
	    startReverseIterationAt = indexOfLinkChange;
	}
	/*
	 * TODO idea: traverse backwards, track position within the contiguous stretch of inserts;
	 */
	for (ListIterator<RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> i = changes.listIterator(startReverseIterationAt); i.hasPrevious();) {
	    change = i.previous();
	    if (change.isLinkChange()) {
		LinkChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> lc =
		    (LinkChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) change;
		if (areLinksFromSameOrderedEntitySequence(lc, linkChange)) {
		    // manipulation of same "sequence"; check if it affects a
		    // position before that of linkChange
		    if (lc.isCreate()) {
			if (lc.getPosition() < positionMappedToI) {
			    positionMappedToI--;
			}
		    } else {
			if (lc.getPosition() <= positionMappedToI) {
			    positionMappedToI++;
			}
		    }
		}
	    }
	}
	return positionMappedToI;
    }

    /**
     * This change set conflicts with another if any of the following conditions apply:
     * <p>
     * 
     * <ul>
     * <li>an entity that was created in the one was deleted in the other</li>
     * <li>an entity was deleted in the one while the other contains a change of a link of which at
     * least one end is the entity deleted in the one (although it may be conceivable that the
     * resolution of such a situation is to let the delete win)</li>
     * <li>a link created in one was deleted in the other</li>
     * </ul>
     * 
     * @return <tt>true</tt> if this change set conflicts with <tt>other</tt>
     */
    @Override
    public synchronized boolean conflictsWith(ChangeSet<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> other) {
	// TODO implement conflictsWith
	return false;
    }

    /**
     * Returns true if the {@link ChangeSetImpl changeSet} is empty. A {@link ChangeSetImpl changeSet} is empty
     * if no entities or links are created or deleted.
     */
    @Override
    public boolean isEmpty() {
	return changes.size() == 0;
    }
    
    /**
     * Postcondition: <tt>this.isEmpty()</tt>
     */
    @Override
    public synchronized void clear() {
	changes.clear();
	linkCreationsInOrderedAssociations.clear();
	linkDeletionsInOrderedAssociations.clear();
    }

    @Override
    public Iterator<EntityCreation<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> getEntityCreations() {
	return new ClassFilterIterator<EntityCreation<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>(
		EntityCreation.class, changes.iterator());
    }

    @Override
    public Iterator<EntityDeletion<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> getEntityDeletions() {
	return new ClassFilterIterator<EntityDeletion<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>(
		EntityDeletion.class, changes.iterator());
    }
    
    /**
     * Create a clone of this ChangeSet that can be safely modified.
     */
    @SuppressWarnings("unchecked")
    public ChangeSetImpl<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> clone() {
	ChangeSetImpl<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> clone =
	    new ChangeSetImpl<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(getModelAdapter());
	// a map that keeps track of which cloned change descriptors replace which original change descriptors
	Map<RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>, RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> map =
	    new HashMap<RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>, RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>();
	// make clones of the changes so that we can safely modify insert positions
	for (RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> change : changes) {
	    RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> clonedChange =
		(RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) change.clone();
	    map.put(change, clonedChange);
	    clone.changes.add(clonedChange);
	}
	cloneWithChangeObjectAsKeyOfValueMap(linkCreationsInOrderedAssociations, clone.linkCreationsInOrderedAssociations, map);
	cloneWithChangeObjectAsKeyOfValueMap(linkDeletionsInOrderedAssociations, clone.linkDeletionsInOrderedAssociations, map);
	return clone;
    }

    @SuppressWarnings("unchecked")
    private <T extends RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> Map<Pair<LinkMetaObject, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>>, Map<T, Integer>> cloneWithChangeObjectAsKeyOfValueMap(
	    Map<Pair<LinkMetaObject, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>>, Map<T, Integer>> from,
	    Map<Pair<LinkMetaObject, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>>, Map<T, Integer>> result,
	    Map<RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>,
	    RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> mapping) {
	for (Pair<LinkMetaObject, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>> key : from.keySet()) {
	    Map<T, Integer> value = from.get(key);
	    Map<T, Integer> copiedValueMap = new HashMap<T, Integer>();
	    result.put(key, copiedValueMap);
	    for (T change : value.keySet()) {
		copiedValueMap.put((T) mapping.get(change), value.get(change));
	    }
	}
	return result;
    }
    
    /**
     * Removes the <tt>change</tt> from this changeset.<p>
     * 
     * Precondition: {@link #getChanges()} contains <tt>change</tt>
     */
    public void removeChange(RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> change) {
	changes.remove(change);
	if (change.isLinkChange()) {
	    LinkChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> linkChange =
		(LinkChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) change;
	    Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> link = linkChange.getObject();
	    if (link.isOrdered()) {
		if (change.isDelete()) {
		    Map<LinkDeletion<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>, Integer> map =
			linkDeletionsInOrderedAssociations
			    .get(new Pair<LinkMetaObject, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>>(
				    link.getAssociation(), link.getAtOppositeOfOrderedEnd()));
		    map.remove(linkChange);
		    shiftOrderedLinkChanges(link.getAssociation(), link.getAtOppositeOfOrderedEnd(), linkChange.getPosition(), +1);
		} else {
		    Map<LinkCreation<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>, Integer> map =
			linkCreationsInOrderedAssociations
			    .get(new Pair<LinkMetaObject, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>>(
				    link.getAssociation(), link.getAtOppositeOfOrderedEnd()));
		    map.remove(linkChange);
		    shiftOrderedLinkChanges(link.getAssociation(), link.getAtOppositeOfOrderedEnd(), linkChange.getPosition(), -1);
		}
	    }
	}
    }

    @Override
    public Iterator<RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> iterator() {
	return getChanges();
    }
    
    /**
     * Determines the stretch of the given {@link LinkCreation}. This is the contiguous stretch of
     * link insertions into an ordered association with the same element on the unordered end
     * before the same original element on the ordered end.
     */
    public StretchOfContiguousLinkCreations getStretch(LinkCreation<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> linkCreation) {
	return new StretchOfContiguousLinkCreations(linkCreation);
    }
    
    /**
     * Determines the stretch of contiguous link insertions into the given association
     * with the specified object on the unordered end and before the original position
     * specified.
     */
    public StretchOfContiguousLinkCreations getStretch(LinkMetaObject association,
	    ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> objectOnUnorderedEnd, int beforeOriginalPosition) {
	return new StretchOfContiguousLinkCreations(beforeOriginalPosition, association, objectOnUnorderedEnd);
    }

    /**
     * A subsequence of {@link ChangeSetImpl#changes} consisting only of
     * {@link LinkCreation} changes with {@link LinkChange#getObject()
     * getObject()}.{@link Link#isOrdered() isOrdered()} with the same object on
     * the unordered end that all happen before the same element of the original
     * snapshot on the ordered end (meaning in the same link sequence in one
     * contiguous stretch).
     * 
     * @author Axel Uhl D043530
     * 
     */
    public class StretchOfContiguousLinkCreations {
	/**
	 * The original position before which this stretch of link creations
	 * takes place, in the snapshot on which the enclosing change set will be based.
	 * 
	 * @see ChangeSetImpl#getOriginalPosition(LinkChange)
	 */
	private int beforeOriginalPosition;
	
	/**
	 * The ordered association into which this stretch inserts links
	 */
	private LinkMetaObject association;
	
	/**
	 * The object at the unordered end for all insertions of this stretch
	 */
	private ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> objectAtUnorderedEnd;

	protected StretchOfContiguousLinkCreations(LinkCreation<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> linkCreation) {
	    if (!linkCreation.getObject().isOrdered()) {
		throw new RuntimeException("Stretches of link insertions are only managed for ordered associations. "+
			linkCreation.getObject().getAssociation()+" is not ordered");
	    }
	    beforeOriginalPosition = getOriginalPosition(linkCreation);
	    association = linkCreation.getObject().getAssociation();
	    objectAtUnorderedEnd = linkCreation.getObject().getAtOppositeOfOrderedEnd();
	}
	
	protected StretchOfContiguousLinkCreations(int beforeOriginalPosition, LinkMetaObject association,
		ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> objectAtUnorderedEnd) {
	    super();
	    this.beforeOriginalPosition = beforeOriginalPosition;
	    this.association = association;
	    this.objectAtUnorderedEnd = objectAtUnorderedEnd;
	}

	/**
	 * Returns the number of link creations in this stretch
	 */
	public int getLength() {
	    // TODO implement StretchOfContiguousLinkCreations.getLength()
	    return 0;
	}

	/**
	 * Returns the position of the original element before this stretch is
	 * inserted in the snapshot on which the enclosing change set is based.
	 */
	public int getBeforeOriginalPosition() {
	    return beforeOriginalPosition;
	}

	/**
	 * This stretch consists of a number of {@link LinkCreation} changes for
	 * an ordered association that are or have been or shall be executed in
	 * order. Each has a position relative to the object on the unordered
	 * end. Additionally, for each such {@link LinkCreation} we can
	 * determine the position relative to which it needs to be inserted
	 * <em>within</em> this stretch. This view removes the complexity of
	 * other link creations and deletions left of this stretch.
	 * <p>
	 * 
	 * Note, that the position returned by this method does not represent
	 * the final position of the <tt>linkCreation</tt> within this stretch.
	 * For example, if the creation sequence is (0, a), (0, b), (1, c), (1,
	 * d), then we have a stretch consisting of four links to b, d, c, a.
	 * The (0, a) change has shifted to final position 3. Yet, this method will
	 * return 0 for it because when replaying this stretch in order, it needs
	 * to be replayed as (0, a), (0, b), (1, c), (1, d) again, only potentially
	 * shifted altogether in case on the target side something got inserted before
	 * the original element at position 0.
	 */
	public int getPositionInStretchInOrder(LinkCreation<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> linkCreation) {
	    for (RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> change : ChangeSetImpl.this) {
		if (change.isLinkChange() && change.isCreate()) {
		    LinkCreation<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> lc =
			(LinkCreation<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) change;
		    if (lc.getObject().getAssociation().equals(association) &&
			    lc.getObject().getAtOppositeOfOrderedEnd().equals(objectAtUnorderedEnd)) {
			
		    }
		}
	    }
	    return 0; // TODO
	}
	
    }

    @Override
    public int totalSize() {
	return changes.size();
    }
}
