package com.sap.river.interpreter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import com.sap.river.interpreter.objects.ClassTypedObject;
import com.sap.river.interpreter.objects.EmptyObject;
import com.sap.river.interpreter.objects.EntityObject;
import com.sap.river.interpreter.objects.Link;
import com.sap.river.interpreter.objects.MultiValuedObject;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.river.interpreter.objects.ValueObject;
import com.sap.river.interpreter.repository.Repository;
import com.sap.river.interpreter.repository.RepositoryObject;
import com.sap.river.interpreter.repository.Snapshot;
import com.sap.river.interpreter.repository.SnapshotIdentifier;
import com.sap.river.interpreter.util.Bag;
import com.sap.river.interpreter.util.HashBag;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;

/**
 * Objects are structurally connected by links which are typed by associations. Each link has two
 * ends, at each of which it has one object whose type is a value or entity class. The type of an
 * object at an end has to conform with the type specified by the association end's type.
 * <p>
 * 
 * A link container is an in-memory cache of links created by an
 * {@link RiverInterpreter interpreter} and those loaded from a {@link Repository}. The link
 * container keeps track of the entities for which it has authoritative information regarding the
 * links attaching to them for a given snapshot and for a given remote association end. It also does
 * this for those entities/ends where no links exist in a given snapshot, just to ensure that if
 * asked again it knows that the empty link set is the authoritative answer and no round-trip to the
 * repository is required.
 * 
 * @author Axel Uhl (D043530)
 */
public class LinkContainer {
    /**
     * A value-holder class for an object and a remote association end. Use instances
     * of this class as key for maps in which to store the links for navigating from the
     * <tt>object</tt> to the remote association end.
     * 
     * @author Axel Uhl (D043530)
     */
    protected class ObjectAndRemoteAssociationEnd {
	private ClassTypedObject object;
	private AssociationEnd remoteAssociationEnd;
	public ObjectAndRemoteAssociationEnd(ClassTypedObject object, AssociationEnd remoteAssociationEnd) {
	    this.object = object;
	    this.remoteAssociationEnd = remoteAssociationEnd;
	}
	public ClassTypedObject getObject() {
	    return object;
	}
	public AssociationEnd getRemoteAssociationEnd() {
	    return remoteAssociationEnd;
	}
	public boolean equals(Object o) {
	    return (getObject() == null && ((ObjectAndRemoteAssociationEnd) o).getObject() == null) ||
		    getObject() != null && getObject().equals(((ObjectAndRemoteAssociationEnd) o).getObject()) &&
	    	getRemoteAssociationEnd().equals(((ObjectAndRemoteAssociationEnd) o).getRemoteAssociationEnd());
	}
	public int hashCode() {
	    return ((getObject()==null)?0:getObject().hashCode()) ^ getRemoteAssociationEnd().hashCode();
	}
	public String toString() {
	    StringBuilder result = new StringBuilder();
	    result.append("ObjectAndRemoteAssociationEnd from object ");
	    result.append(getObject());
	    result.append(" via association ");
	    result.append(getRemoteAssociationEnd().getAssociation().getName());
	    result.append(" to end ");
	    result.append(getRemoteAssociationEnd().getName());
	    result.append(" of type ");
	    result.append(getRemoteAssociationEnd().getType().getClazz().getName());
	    return result.toString();
	}
    }
    
    /**
     * Values are the sets of links that have the key as their {@link Link#getLeft() left} end.
     * May be an empty set but never <tt>null</tt>. It is possible that a {@link ClassTypeObject}
     * is not contained as a key in this map, meaning that this {@link LinkContainer} does not
     * know about the links connected to that object; in this case, queries need to be forwarded
     * to the {@link #repository} for resolution.<p>
     *  
     * <pre>Invariant:
     * 	   if ObjectAndRemoteAssociationEnd.getObject() instanceOf EntityObject then
     *      	if entityObject.getSnapshot() != null then
     *      		for all links:    link.getSnapshot() == null 
     *                                 || link.getSnapshot().equals(entityObject.getSnapshot())
     * </pre>
     */
    private Map<ObjectAndRemoteAssociationEnd, Collection<Link>> linksForLeft;

    /**
     * Values are the sets of links that have the key as their {@link Link#getRight() right} end.
     * May be an empty set but never <tt>null</tt>. It is possible that a {@link ClassTypeObject}
     * is not contained as a key in this map, meaning that this {@link LinkContainer} does not
     * know about the links connected to that object; in this case, queries need to be forwarded
     * to the {@link #repository} for resolution.<p>
     * 
     * <pre>Invariant:
     * 	   if ObjectAndRemoteAssociationEnd.getObject() instanceOf EntityObject then
     *      	if entityObject.getSnapshot() != null then
     *      		for all links:    link.getSnapshot() == null 
     *                                 || link.getSnapshot().equals(entityObject.getSnapshot())
     * </pre> 
     */
    private Map<ObjectAndRemoteAssociationEnd, Collection<Link>> linksForRight;
    
    /**
     * Values are the sets of links that have the key as their
     * {@link Link#getAssociation() association}. May be an empty set but never <tt>null</tt>.
     * It is possible that an {@link Association} is not contained as a key in this map, meaning
     * that this {@link LinkContainer} does not know about any {@link Link}s that have this object
     * at their right end. As opposed to {@link #linksForLeft} and {@link #linksForRight}, if
     * this map contains an association as a key, this does not mean that this link container
     * knows the full extent of the association. Besides, links are currently not keyed
     * by snapshot which could result in link collections containing links from multiple different
     * snapshots.
     */
    private Map<Association, Collection<Link>> linksForAssociation;

    /**
     * Keeps the link maps by the end number of the keys. See also {@link Side#endNumber}<p>
     */
    private Map<ObjectAndRemoteAssociationEnd, Collection<Link>>[] mapsByEndNumber;
    
    /**
     * Queries that cannot be resolved by the data cached in this link container are
     * forwarded to the durably-storing repository. Results are cached, assuming that
     * each snapshot in the repository is immutable.
     */
    private Repository repository;
    
    @SuppressWarnings("unchecked")
    public LinkContainer(Repository repository) {
	linksForLeft = new HashMap<ObjectAndRemoteAssociationEnd, Collection<Link>>();
	linksForRight = new HashMap<ObjectAndRemoteAssociationEnd, Collection<Link>>();
	mapsByEndNumber = (Map<ObjectAndRemoteAssociationEnd, Collection<Link>>[]) new Map<?, ?>[Side.values().length];
	mapsByEndNumber[Side.LEFT.endNumber()] = linksForLeft;
	mapsByEndNumber[Side.RIGHT.endNumber()] = linksForRight;
	linksForAssociation = new HashMap<Association, Collection<Link>>();
	this.repository = repository;
    }
    
    /**
     * Returns a (possible multi-valued, possibly <tt>null</tt>) object resulting from navigating
     * the association <tt>over</tt> from <tt>from</tt> on <tt>fromSide</tt> of that
     * association to the other end. The collection will be empty if no links exist that match these
     * criteria. The collection's type corresponds with the other association end's (the "to" end's)
     * uniqueness and orderedness settings. Navigation happens within
     * {@link ClassTypedObject#getOrigin() from's snapshot}.
     * <p>
     * 
     * If <tt>from</tt> is <tt>null</tt>, <tt>null</tt> will result.
     */
    public RiverObject navigate(ClassTypedObject from, Side fromSide,
	    Association over) {
	AssociationEnd otherEnd = over.getEnds().get(fromSide.otherEndNumber());
	ClassTypeDefinition toEndType = otherEnd.getType();
	Collection<RiverObject> resultCollection = RiverObject.
		createCollection(toEndType.isOrdered(), toEndType.isUnique());
	RiverObject result;
	Collection<Link> links = loadLinks(from, fromSide, otherEnd);
	if (links != null) {
	    for (Link link : links) {
		resultCollection.add(link.get(fromSide.otherEnd()));
	    }
	}
	if (toEndType.getUpperMultiplicity() == 1) {
	    if (resultCollection.size() > 0) {
		result = resultCollection.iterator().next();
	    } else {
		result = new EmptyObject(toEndType);
	    }
	} else {
	    result = new MultiValuedObject(toEndType, resultCollection);
	}
	return result;
    }

    /**
     * Makes sure that links that exist for <tt>from</tt> on <tt>fromSide</tt> in association
     * <tt>toEnd.getAssociation()</tt> are loaded and returns them. If this requires fetching them
     * from the {@link #getRepository repository}, this will be done.
     */
    private Collection<Link> loadLinks(ClassTypedObject from, Side fromSide, AssociationEnd toEnd) {
	ObjectAndRemoteAssociationEnd key = new ObjectAndRemoteAssociationEnd(from, toEnd);
	Collection<Link> links = getMapForEnd(fromSide).get(key);
	if (links == null && ((from instanceof ValueObject) || from.isPersistent())) {
	    // this container doesn't know anything about this and the from object
	    // is persistent; ask repository:
	    links = getRepository().loadLinks(from, toEnd);
	    Collection<Link> mutableLinkCollection = createLinkCollection(key);
	    if (links != null) {
		mutableLinkCollection.addAll(links);
	    }
	    // TODO what about adding to the linksForAssociation map?
	    getMapForEnd(fromSide).put(key, mutableLinkCollection); // now we know
	    // and cache the result
	    if (toEnd.getType().getClazz().isValueType()) {
		loadValueLinks(links, fromSide.otherEnd());
	    }
	}
	return links;
    }
    
    /**
     * When a set of links has been loaded during a navigation starting from one object,
     * and those links have a value object on their other end, those value objects may
     * contain equality-relevant links to other objects. If this link container does not
     * yet know the respective emerging link set of the value object, this method will
     * establish it, recursively and transitively for all value objects reachable
     * through equality-relevant links.<p>
     * 
     * Example: if a link between a <tt>Person</tt> object and an <tt>Address</tt> object
     * just got loaded, and <tt>Address</tt> has equality-relevant associations to
     * the value class <tt>String</tt> (for role <tt>name</tt>) and to the entity
     * class <tt>City</tt>, those two links will be loaded into this link container
     * by invoking this method with the link between the <tt>Person</tt> and the
     * <tt>Address</tt> instance in <tt>links</tt> and the <tt>address</tt> end
     * as <tt>otherEnd</tt>.
     */
    private void loadValueLinks(Collection<Link> links, Side valueClassSide) {
	for (Link link:links) {
	    ValueObject vo = (ValueObject) link.get(valueClassSide);
	    loadEqualityRelevantLinksOfValue(vo);
	}
    }

    /**
     * Ensures that all links that establish the value object <tt>vo</tt> are loaded into
     * this link container. This includes all equality-relevant links of <tt>vo</tt> itself
     * as well as all equality-relevant links of all value objects that contribute to
     * <tt>vo</tt>'s value.
     */
    protected void loadEqualityRelevantLinksOfValue(ValueObject vo) {
	Map<AssociationEnd, Collection<ClassTypedObject>> equalityRelevant = vo
		.getEqualityRelevantAssociationEndValues();
	for (AssociationEnd farEnd : equalityRelevant.keySet()) {
	    ObjectAndRemoteAssociationEnd key = new ObjectAndRemoteAssociationEnd(vo, farEnd);
	    Collection<Link> linkCollection = getMapForEnd(getSideOfEnd(farEnd.otherEnd())).get(key);
	    // if the link collection already exists, we assume it's up to date
	    if (linkCollection == null) {
		// in this case we'll insert all those links
		Collection<Link> equalityRelevantLinks = vo.getEqualityRelevantLinks(farEnd);
		boolean farEndIsValueType = farEnd.getType().getClazz().isValueType();
		Side farSide = getSideOfEnd(farEnd);
		for (Link erl : equalityRelevantLinks) {
		    loadLink(erl);
		    if (farEndIsValueType) {
			loadEqualityRelevantLinksOfValue((ValueObject) erl.get(farSide));
		    }
		}
	    }
	}
    }

    /**
     * Add <tt>link</tt> to the directed link maps and the association-keyed map. This does
     * not represent a logical <em>link creation</em> but rather loads an already existing
     * link into this link container's in-memory structures. It does not verify any constraints
     * nor does it throw any events. Links are added to the link collections at the default
     * position (e.g., append for ordered ends), so the client has to ensure by the sequence
     * of the calls to this method that the correct order is maintained.
     */
    private void loadLink(Link link) {
	for (Side side : Side.values()) {
	    ObjectAndRemoteAssociationEnd key = new ObjectAndRemoteAssociationEnd(link.get(side), link.getAssociation().getEnds()
		    .get(side.otherEndNumber()));
	    // If a persistent link collection for one end exists but hasn't been loaded yet,
	    // it must be loaded first; otherwise a new empty collection would be created which
	    // would then probably overwrite the existing one
	    loadLinks(link.get(side), side, link.getAssociation().getEnds().get(side.otherEndNumber()));
	    addLinkToMap(link, key, getMapForEnd(side),
		    /* use default insert position, e.g., append */ null);
	}
	addLinkToMap(link, link.getAssociation(), getLinksForAssociation(),
		/* use default insert position, e.g., append */ null);
    }

    /**
     * Creates a link between the two objects <tt>left</tt> and <tt>right</tt>
     * on behalf of the respective association and adds it to this
     * {@link LinkContainer}. If the {@link RepositoryObject#getOrigin()
     * snapshots} of <tt>left</tt> and <tt>right</tt> differ, an attempt is made
     * to unify them, as follows: if the link is equality-relevant only for one
     * side and the other side is a {@link ValueObject value object}, that other
     * side's value object will be cloned into the snapshot of the object for
     * which the link is equality-relevant. For example, if a link between
     * <tt>Address</tt> and <tt>String</tt> is to be established that is
     * equality-relevant only for the <tt>Address</tt> side, the <tt>String</tt>
     * value object will be cloned into the <tt>Address</tt> object's snapshot,
     * and the link will be established in that snapshot.
     * <p>
     * 
     * If <tt>left</tt>'s and <tt>right</tt>'s snapshots differ and no-one is a
     * value for which the link is not equality-relevant, an exception is
     * thrown.
     * 
     * @param at
     *            if a non-<tt>null</tt> value is supplied for an association
     *            with one ordered end, <tt>at</tt> is used as the insert position.
     *            It <tt>-1</tt> or <tt>null</tt> is supplied, the link will be
     *            appended to the end. Note that there is no total ordering on
     *            all the links of an association but only a semi-ordering over
     *            those links emerging from one object with the remote end being
     *            ordered.
     * @param transactionBuffer
     *            a non-<tt>null</tt> object; if the link added should be
     *            persistent, it will be added to the transaction buffer (see
     *            {@link TransactionBuffer#linkCreated(Link)}). A link is
     *            perceived to be persistent, if any of the two objects
     *            connected by it is an entity object that is persistent. Inc
     *            ase of composite links, if the link is considered persistent,
     *            the composite child including its composition hierarchy and
     *            attaching links will be made persistent if the are not
     *            persistent yet.
     * @param interpreter
     *            required to perform the hash code change when updating
     *            <tt>entityOrLink</tt>'s snapshot
     */
    public void addLink(ClassTypedObject left, ClassTypedObject right, Association association,
	    Integer at, TransactionBuffer transactionBuffer, RiverInterpreter interpreter) {
	if (!left.getOrigin().equals(right.getOrigin())) {
	    if ((association.getEnds().get(Side.LEFT.endNumber()).isContributesToEquality() && right instanceof ValueObject)) {
		right = right.getCopyWithOrigin(left.getOrigin());
	    } else if (association.getEnds().get(Side.RIGHT.endNumber()).isContributesToEquality() && left instanceof ValueObject) {
		left = left.getCopyWithOrigin(right.getOrigin());
	    } else {
		throw new RuntimeException("Can't establish link between objects in different snapshots: "+
			left.getOrigin()+" and "+right.getOrigin());
	    }
	}
	assert left.getOrigin().equals(right.getOrigin());
	Link link = new Link(left, right, association, left.getOrigin());
	addLink(link, at, transactionBuffer, interpreter);
    }

    /**
     * Removes a link between the two objects <tt>left</tt> and <tt>right</tt>
     * on behalf of the respective association from this {@link LinkContainer}.
     * If multiple such links exist (non-unique association end), one of them is
     * picked arbitrarily.
     * 
     * @param at
     *            if a non-</tt>null</tt> value is supplied for an association
     *            with an ordered end and the association is non-unique,
     *            <tt>at</tt> specifies which copy of multiple equal links to
     *            remove. If at least one occurrence of a matching link is found
     *            but <tt>at</tt> specifies a non-<tt>null</tt> and non-negative
     *            position that does not match with any of those links, an
     *            exception is raised.
     * @param transactionBuffer
     *            a non-<tt>null</tt> object; if anything needs to be queried
     *            from the repository, use the snapshot specified by the buffer
     *            or use the current one and set it as the transaction buffer's
     *            fixed snapshot. If the link removed was persistent, this
     *            change will be recorded in the transaction buffer (see
     *            {@link TransactionBuffer#linkDeleted(Link, Integer)}
     *            ). A link is perceived to be persistent if it has a non-
     *            <tt>null</tt> snapshot or has been recorded in the transaction
     *            buffer as created.
     * @param defaultSnapshot
     *            if the link is not marked to pertain to a specific snapshot
     *            (see {@link RepositoryObject#getOrigin()}), consider the
     *            change to be based on this snapshot identifier. If the
     *            <tt>transactionBuffer</tt> is not tied to any snapshot yet and
     *            the link does not pertain to a specific snapshot, the
     *            <tt>defaultSnapshot</tt> will be used for the transaction
     *            buffer.
     * @param interpreter
     *            required to perform the hash code change when updating
     *            <tt>entityOrLink</tt>'s snapshot
     */
    public void removeLink(ClassTypedObject left, ClassTypedObject right, Association association,
	    Integer at, TransactionBuffer transactionBuffer, SnapshotIdentifier defaultSnapshot, RiverInterpreter interpreter) {
	AssociationEnd rightEnd = association.getEnds().get(Side.RIGHT.endNumber());
	Collection<Link> fromLeft = loadLinks(left, Side.LEFT, rightEnd);
	if (fromLeft != null) {
	    AssociationEnd leftEnd = association.getEnds().get(Side.LEFT.endNumber());
	    Collection<Link> fromRight = loadLinks(right, Side.RIGHT, leftEnd);
	    if (fromRight != null) {
		Collection<Link> candidates = new HashSet<Link>(fromLeft);
		candidates.retainAll(fromRight);
		if (candidates.size() > 0) {
		    removeLink(candidates.iterator().next(), at, transactionBuffer, defaultSnapshot, interpreter);
		}
	    }
	}
    }

    private Map<ObjectAndRemoteAssociationEnd, Collection<Link>> getMapForEnd(Side side) {
	return mapsByEndNumber[side.endNumber()];
    }
    
    private void addLink(final Link link, Integer at,
	    TransactionBuffer transactionBuffer, RiverInterpreter interpreter) {
	// TODO check multiplicities?
	// TODO check aggregation relevance (will "child" move to parent's aggregate?)
	RiverObject currentCompositeParent = getCompositeParentForChild(link);
	if (!link.getAssociation().getEnds().get(0).getType().isUnique()
	// if the association is unique, check if the link already exists
	|| !doesLinkExist(link)) {
	    if (currentCompositeParent != null) {
		throw new RuntimeException(
			"Illegal attempt to establish a second composite parent link for composite child "
				+ link.get(getCompositeParentSide(link).otherEnd())
				+ " which is already owned by " + currentCompositeParent);
	    }
	    for (final Side side : Side.values()) {
		if (link.getAssociation().getEnds().get(side.endNumber()).isContributesToEquality() &&
			link.getAssociation().getEnds().get(side.endNumber()).getType().getClazz().isValueType()) {
		    throw new RuntimeException("Illegal attempt to modify a value object. Trying to establish link "+
			    link);
		}
		ObjectAndRemoteAssociationEnd key = new ObjectAndRemoteAssociationEnd(link
			.get(side), link.getAssociation().getEnds().get(side.otherEndNumber()));
		// If a persistent link collection for one end exists but hasn't been loaded yet,
		// it must be loaded first; otherwise a new empty collection would be created which
		// would then probably overwrite the existing one
		loadLinks(link.get(side), side, link.getAssociation().getEnds().get(side.otherEndNumber()));
		addLinkToMap(link, key, getMapForEnd(side), at);
	    }
	    addLinkToMap(link, link.getAssociation(), getLinksForAssociation(), at);
	    // handle persistence and transaction buffer aspects:
	    if (shouldBeStoredToRepository(link)) {
		if (link.isOrdered() && (at == null || at == -1)) {
		    at = getLinkPosition(link); // for addition at default position, determine position
		}
		transactionBuffer.linkCreated(link, at);
		Side compositeParentSide = getCompositeParentSide(link);
		if (compositeParentSide != null) {
		    // recurse into composition and mark composite children and all attaching links
		    // as created in persistence
		    EntityObject child = (EntityObject) link.get(compositeParentSide.otherEnd());
		    if (!child.isPersistent()) {
			interpreter.storeEntity(child);
		    }
		}
	    }
	}
    }
    
    /**
     * Checks if a link that is in the process of being added to this link container should
     * be stored in the {@link #repository}. This is the case if at least one of the two ends
     * is an {@link EntityObject entity object} that is already stored in the repository (indicated
     * by a non-<tt>null</tt> snapshot) or is marked for storage in the <tt>transactionBuffer</tt>, and
     * if the link is equality-relevant for that entity. Note, that with this definition links to
     * value objects are not considered to need storing if they are not relevant for the entity's
     * equality.
     *  
     * @param link
     *                the link for which to check whether it should be stored persistently in the
     *                repository
     */
    private boolean shouldBeStoredToRepository(Link link) {
	for (Side side : Side.values()) {
	    if (link.get(side) instanceof EntityObject && link.get(side).isPersistent()) {
		if (link.getAssociation().getEnds().get(side.endNumber()).isContributesToEquality()) {
		    return true;
		}
	    }
	}
	return false;
    }

    private boolean doesLinkExist(Link link) {
	ObjectAndRemoteAssociationEnd key = new ObjectAndRemoteAssociationEnd(link.get(Side.LEFT),
		link.getAssociation().getEnds().get(Side.RIGHT.endNumber()));
	Collection<Link> existingLinks = getMapForEnd(Side.LEFT).get(key);
	return existingLinks != null && existingLinks.contains(link);
    }

    /**
     * If the link is of a non-composite association (an association with no end marked
     * {@link AssociationEnd#isComposite()}), the result is always <tt>null</tt>. If one
     * end is marked composite, this method looks for another composite link emerging from
     * the composite child of <tt>link</tt>. If such a link is found, the result is the
     * parent object of the link found. During finding such a link, all associations are
     * considered that contain a composite end and where <tt>link</tt>'s child's class
     * conforms to the child end's class of the link found.  Navigation happens within
     * {@link ClassTypedObject#getOrigin() the child's snapshot}.
     */
    private RiverObject getCompositeParentForChild(Link link) {
	RiverObject result = null;
	Side compositeParentSide = getCompositeParentSide(link);
	if (compositeParentSide != null) {
	    ClassTypedObject child = link.get(compositeParentSide.otherEnd());
	    result = getCompositeParent(child);
	}
	return result;
    }

    /**
     * Finds all child ends of composite associations such that <tt>child</tt>'s class
     * conforms to the association end's class, meaning that it could potentially participate
     * on that end in an association. Those associations are queried. If a link is found,
     * the object at the composite parent end is returned for the first such link found.
     * Otherwise, <tt>null</tt> is returned. Navigation happens within
     * {@link ClassTypedObject#getOrigin() child's snapshot}.
     */
    private EntityObject getCompositeParent(ClassTypedObject child) {
	RiverObject result = null;
	ObjectAndRemoteAssociationEnd oarae = getCompositeParentObjectAndChildAssociationEnd(child);
	if (oarae != null) {
	    result = oarae.getObject();
	}
	return (EntityObject) result;
    }
    
    protected ObjectAndRemoteAssociationEnd getCompositeParentObjectAndChildAssociationEnd(ClassTypedObject child) {
	// look for existing composite links emerging from the child of the new composite link
	for (AssociationEnd compositeChildEnd : child.getType().getClazz()
		.getConformsToCompositeChildAssociationEnds()) {
	    RiverObject parent = navigate(child, getSideOfEnd(compositeChildEnd),
		    compositeChildEnd.getAssociation());
	    if (parent != null && !parent.isEmpty()) {
		return new ObjectAndRemoteAssociationEnd((ClassTypedObject) parent.iterator().next(),
			compositeChildEnd);
	    }
	}
	return null;
    }

    /**
     * Determines if and which of the two sides of the <tt>link</tt> is a composite parent end
     * of a composite association. If none is, <tt>null</tt> is returned; otherwise, the side
     * on which the association end marked as {@link AssociationEnd#isComposite()} resides is returned.
     */
    private Side getCompositeParentSide(Link link) {
	Side compositeParentSide = null;
	int i=0;
	List<AssociationEnd> ends = link.getAssociation().getEnds();
	for (Side side:Side.values()) {
	    if (ends.get(side.endNumber()).isComposite()) {
		compositeParentSide = side;
		break;
	    }
	    i++;
	}
	return compositeParentSide;
    }

    private void removeLink(Link link, Integer at,
	    TransactionBuffer transactionBuffer, SnapshotIdentifier defaultSnapshot, RiverInterpreter interpreter) {
	// TODO check multiplicities (underflow)?
	for (Side side:Side.values()) {
	    ObjectAndRemoteAssociationEnd key = new ObjectAndRemoteAssociationEnd(link.get(side),
		    link.getAssociation().getEnds().get(side.otherEndNumber()));
	    if (link.getAssociation().getEnds().get(side.endNumber()).isContributesToEquality()
		    && link.getAssociation().getEnds().get(side.endNumber()).getType().getClazz().isValueType()) {
		throw new RuntimeException(
			"Illegal attempt to modify a value object. Trying to remove link "
				+ link);
	    }
	    // If a persistent link collection for one end exists but hasn't been loaded yet,
	    // it must be loaded first; otherwise a new empty collection would be created which
	    // would then probably overwrite the existing one
	    loadLinks(link.get(side), side, link.getAssociation().getEnds().get(side.otherEndNumber()));
	    removeLinkFromMap(link, key, getMapForEnd(side), at);
	}
	removeLinkFromMap(link, link.getAssociation(), getLinksForAssociation(), at);
	// TODO if link is composite, decide if composite children tree should be made transient
	if (link.isPersistent()) {
	    transactionBuffer.linkDeleted(link, at);
	}
    }

    private <T> void addLinkToMap(Link link, T key, Map<T, Collection<Link>> map, Integer at) {
	if (key instanceof ObjectAndRemoteAssociationEnd) {
	    if (((ObjectAndRemoteAssociationEnd)key).getObject() instanceof EntityObject) {
		EntityObject e = (EntityObject) ((ObjectAndRemoteAssociationEnd)key).getObject();
		if (e.getOrigin() != null) {
		    // no cross-snapshot links
		    if (link.getOrigin() != null && !link.getOrigin().equals(e.getOrigin())) {
			throw new RuntimeException("Cross snapshot links not allowed");
		    }
		}
	    }
	}
	Collection<Link> set = map.get(key);
	if (set == null) {
	    set = createLinkCollection(key);
	    map.put(key, set);
	}
	if (at != null && at >= 0 && set instanceof List) {
	    ((List<Link>) set).add(at, link);
	} else {
	    set.add(link);
	}
    }
    
    /**
     * @param key For type {@link ObjectAndRemoteAssociationEnd}, the resulting collection
     * is created based on the orderedness of the respective
     * {@link ObjectAndRemoteAssociationEnd#getRemoteAssociationEnd() association end}.
     * For type {@link Association}, the collection type is used based on orderedness
     * and uniqueness of the ends: if at least one end is ordered, an ordered collection
     * is returned; if at least one end is non-unique, a collection supporting duplicates
     * is returned.<p>
     * 
     * For all other types of <tt>key</tt>, a {@link LinkedHashSet} is used.
     */
    private Collection<Link> createLinkCollection(Object key) {
	Collection<Link> result;
	if (key instanceof ObjectAndRemoteAssociationEnd) {
	    ObjectAndRemoteAssociationEnd oarae = (ObjectAndRemoteAssociationEnd) key;
	    result = RiverObject.createCollection(oarae.getRemoteAssociationEnd().getType().isOrdered(),
		    oarae.getRemoteAssociationEnd().getType().isUnique());
	} else if (key instanceof Association) {
	    Association a = (Association) key;
	    boolean ordered = false;
	    boolean unique = true;
	    for (Side side : Side.values()) {
		if (a.getEnds().get(side.endNumber()).getType().isOrdered()) {
		    ordered = true;
		}
		if (!a.getEnds().get(side.endNumber()).getType().isUnique()) {
		    unique = false;
		}
	    }
	    result = RiverObject.createCollection(ordered, unique);
	} else {
	    result = new LinkedHashSet<Link>();
	}
	return result;
    }
    
    private <T> void removeLinkFromMap(Link link, T key, Map<T, Collection<Link>> map, Integer at) {
	Collection<Link> set = map.get(key);
	if (set != null) {
	    if (at != null && at >= 0 && set instanceof List<?> && !((List<Link>) set).get(at).equals(link)) {
		throw new RuntimeException("Requested removal of link "+link+
				" from specific position "+at+" but found "+
				((List<Link>) set).get(at)+" at that position");
	    }
	    // TODO respect *at* parameter in case of list
	    if (set instanceof List && at != null && at >= 0) {
		((List<Link>) set).remove(at);
	    } else {
		set.remove(link);
	    }
	    // Note: don't remove empty collections from map for persistent keys because they still have a meaning.
	    // They state that the link container is aware of the fact that this link set is empty. This
	    // avoids loading a "clean" link set from the repository which would be wrong after modifications
	    // such as a removal took place on the link set.
	    if (set.isEmpty()) {
		if (key instanceof ObjectAndRemoteAssociationEnd) {
		    ObjectAndRemoteAssociationEnd oarae = (ObjectAndRemoteAssociationEnd) key;
		    if (!oarae.getObject().isPersistent()) {
			map.remove(key);
		    }
		}
	    }
	}
    }
    
    private Map<Association,  Collection<Link>> getLinksForAssociation() {
        return linksForAssociation;
    }

    public static Side getSideOfEnd(AssociationEnd end) {
        if (end.getAssociation().getEnds().get(Side.LEFT.endNumber()).equals(end)) {
            return Side.LEFT;
        } else {
            return Side.RIGHT;
        }
    }

    private Repository getRepository() {
        return repository;
    }

    /**
     * Computes a bag of {@link RepositoryObject}s containing <tt>toSave</tt>
     * and all of its composite children that are transient so far and all
     * transient links attached to any of those. This also captures links to
     * value objects that are equality-relevant for the <tt>toSave</tt> entity.
     * The value objects are referenced by the respective link.
     * Equality-relevant links emerging from those value objects are further
     * traversed to find other entity objects that are relevant for the value's
     * equality and are added to the result if not yet persistent. Value objects
     * are expected to describe its value by themselves.
     * <p>
     * The resulting bag is unordered, hence links may be returned by an
     * iterator before the entities linked by it.
     * <p>
     * 
     * <tt>toSave</tt> is contained in the resulting bag.
     * 
     * FIXME Bug #1956: if values have equality-relevant entities in them, those
     * entities need to be added to the result recursively
     * 
     */
    protected Bag<RepositoryObject> getTransientCompositionTree(EntityObject toSave) {
        Bag<RepositoryObject> result = new HashBag<RepositoryObject>();
        Collection<Link> allLinks = getAllLinks(toSave);
        Set<EntityObject> children = new HashSet<EntityObject>();
        for (Link l:allLinks) {
            Side compositeParentSide = getCompositeParentSide(l);
            if (compositeParentSide != null && l.get(compositeParentSide).equals(toSave)) {
        	// cast is ok because composition is not possible for values
        	EntityObject child = (EntityObject) l.get(compositeParentSide.otherEnd());
        	// check if the object is transient
        	if (!child.isPersistent()) {
        	    children.add(child);
        	    // the child will add the composite parent link l to its results
        	} else {
        	    if (!l.isPersistent()) {
        		result.add(l);
        	    }
        	}
            } else {
        	// not a composite link; add link if it leads to an entity or if it is equality-relevant for toSave
        	Side sideOfToSave = l.getSideOf(toSave);
        	AssociationEnd toSaveEnd = l.getAssociation().getEnds().get(sideOfToSave.endNumber());
        	boolean otherEndIsValueType = toSaveEnd.otherEnd().getType().getClazz().isValueType();
        	if (!l.isPersistent() &&
        		(!otherEndIsValueType || toSaveEnd.isContributesToEquality())) {
		    result.add(l);
		    ClassTypedObject objectAtOtherEnd = l.get(sideOfToSave.otherEnd());
		    if (otherEndIsValueType) {
			result.addAll(getTransientEntitiesEqualityRelevantForValueRecursively((ValueObject) objectAtOtherEnd));
		    }
		}
            }
        }
        for (EntityObject child:children) {
            result.addAll(getTransientCompositionTree(child));
        }
        result.add(toSave);
        return result;
    }

    /**
     * For the value object <tt>objectAtOtherEnd</tt> checks all objects associated with it that
     * are relevant for its equality. If again a value object, the results of recursively calling
     * this method for the nested value are added to the results. If an entity object that is not yet
     * marked persisted, that entity object is passed to {{@link #getTransientCompositionTree(EntityObject)}}
     * again to transitively grab all transient objects that need to be stored with the value. Note
     * that the value object itself is <em>not</em> added to the result.
     */
    private Bag<RepositoryObject> getTransientEntitiesEqualityRelevantForValueRecursively(
	    ValueObject objectAtOtherEnd) {
        Bag<RepositoryObject> result = new HashBag<RepositoryObject>();
	Map<AssociationEnd, Collection<ClassTypedObject>> equalityRelevantObjects = objectAtOtherEnd
		.getEqualityRelevantAssociationEndValues();
	for (Collection<ClassTypedObject> coll : equalityRelevantObjects.values()) {
	    for (ClassTypedObject cto : coll) {
		if (cto instanceof ValueObject) {
		    result.addAll(getTransientEntitiesEqualityRelevantForValueRecursively((ValueObject) cto));
		} else {
		    // entity object
		    if (!cto.isPersistent()) {
			result.addAll(getTransientCompositionTree((EntityObject) cto));
		    }
		}
	    }
	}
	return result;
    }

    /**
     * Obtains all links known to this link container attached to object <tt>o</tt>. Reflexive
     * links having the same object on both ends are added only once per occurrence. Of course,
     * non-unique links of this kind still occur as many times as they were added.
     */
    private List<Link> getAllLinks(ClassTypedObject o) {
	List<Link> result = new LinkedList<Link>();
	for (AssociationEnd end:o.getType().getClazz().getConformsToAssociationEnds()) {
	    ObjectAndRemoteAssociationEnd key = new ObjectAndRemoteAssociationEnd(o, end.otherEnd());
	    Side sideOfEnd = getSideOfEnd(end);
	    Collection<Link> links = getMapForEnd(sideOfEnd).get(key);
	    if (links != null) {
		for (Link l : links) {
		    // add them, avoiding adding reflexive links twice
		    if (sideOfEnd.equals(Side.LEFT) || !l.get(Side.LEFT).equals(l.get(Side.RIGHT))) {
			result.add(l);
		    }
		}
	    }
	}
	return result;
    }

    /**
     * Computes a bag of {@link RepositoryObject}s containing <tt>object</tt> and all of its
     * composite children and all links attached to any of those.
     */
    public Bag<RepositoryObject> getCompositionTree(EntityObject object) {
	Bag<RepositoryObject> result = new HashBag<RepositoryObject>();
	Collection<Link> allLinks = getAllLinks(object);
	Set<EntityObject> children = new HashSet<EntityObject>();
	for (Link l : allLinks) {
	    Side compositeParentSide = getCompositeParentSide(l);
	    if (compositeParentSide != null && l.get(compositeParentSide).equals(object)) {
		// cast is ok because composition is not possible for values
		EntityObject eo = (EntityObject) l.get(compositeParentSide.otherEnd());
		// check if the object is transient
		children.add(eo);
		// the child will add the composite parent link l to its results
	    } else {
		// not a composite link; need to add it to the results here
		result.add(l);
	    }
	}
	for (EntityObject child : children) {
	    result.addAll(getCompositionTree(child));
	}
	result.add(object);
	return result;
    }

    /**
     * Tells this link container that there are no links for this object yet, and that the link
     * container does not need to look up any such links in the persistence {@link #repository}. It
     * does so by inserting empty link collections into the directed link maps for all association
     * ends in which the <tt>object</tt> could potentially appear.
     */
    public void newEntity(EntityObject object) {
	for (AssociationEnd ae:object.getType().getClazz().getConformsToAssociationEnds()) {
	    ObjectAndRemoteAssociationEnd key = new ObjectAndRemoteAssociationEnd(object, ae.otherEnd());
	    getMapForEnd(getSideOfEnd(ae)).put(key, createLinkCollection(key));
	}
    }

    public Iterable<EntityObject> removeUnchangedEntities(Map<Snapshot, Set<EntityObject>> entitiesFromSnapshot) {
	//  create subsets for each entityObject
	Map<UUID, Set<EntityObject>> entitySets = new HashMap<UUID, Set<EntityObject>>();
	
	for (Set<EntityObject> entities : entitiesFromSnapshot.values()) {
	    for (EntityObject entity : entities) {
		if (!entitySets.containsKey(entity.getId())) {
		    Set<EntityObject> set = new HashSet<EntityObject>();
		    set.add(entity);
		    entitySets.put(entity.getId(), set);
		}
		else {
		    entitySets.get(entity.getId()).add(entity);
		}
	    }
	}
	
	Set<EntityObject> result = new HashSet<EntityObject>();
	// loop over subsets and remove unchanged entities from different snapshots
	for (UUID uuid : entitySets.keySet()) {
	    Set<EntityObject> set = entitySets.get(uuid);
	    if (set.size() > 1) {  // only if there are more than one entity versions
		List<EntityObject> entities = new ArrayList<EntityObject>(set.size());
		entities.addAll(set);
		Collections.sort(entities, new SnapshotComparator());
		
		for (int i = 0; i < entities.size(); i++) {
		    EntityObject entity = entities.get(i);
		    if (i == 0) {
			result.add(entity);
		    }
		    else {
			int predecessorIndex = i - 1;
			while (predecessorIndex >= 0) {
			    EntityObject predecessor = entities.get(predecessorIndex);
			    Set<Snapshot> predecessorSnapthots = repository.getImmediatePredecessors(entity.getOrigin().getSnapshot());
			    if (predecessorSnapthots.contains(predecessor.getOrigin().getSnapshot())) {
				if (areDifferent(entity, predecessor)) { // changed?
				    result.add(entity);
				    break;
				}
			    }
			    --predecessorIndex;
			} // while (true)
		    }
		} // for all entities[]
	    } // if set.size() > 1
	    else {
		// just one entity found, add to result
		result.addAll(set);
	    }
	} // for all uuids
	return result;
    }
    
    /**
     * Returns <code>true</code> if the two objects are different. RiverObjects are always different
     * if they have different concrete subclasses. Otherwise they are compared with respect to their
     * content but ignoring snapshot containment.
     * @param o1
     * @param o2
     * @return
     */
    private boolean areDifferent(RiverObject o1, RiverObject o2) {
	if (!o1.getClass().equals(o2.getClass())) {
	    return true;
	}
	if (o1 instanceof EntityObject) {
	    return areDifferent((EntityObject) o1, (EntityObject) o2);
	}
	if (o1 instanceof ValueObject) {
	    return areDifferent((ValueObject) o1, (ValueObject) o2);
	}
	if (o1 instanceof MultiValuedObject) {
	    MultiValuedObject m1 = (MultiValuedObject) o1;
	    MultiValuedObject m2 = (MultiValuedObject) o2;
	    // must be different if size differs
	    if (m1.size() != m2.size()) {
		return true;
	    }
	    // not different if size 0
	    else if (m1.size() == 0) {
		return false;
	    }
	    Iterator<RiverObject> i1 = m1.flatten().iterator();
	    Iterator<RiverObject> i2 = m2.flatten().iterator();
	    while (i1.hasNext()) {
		if (areDifferent(i1.next(), i2.next())) {
		    return true;
		}
	    }
	    return false;
	}
	throw new RuntimeException("Illegal class in 'areDifferent': " + o1.getClass().getName());
    }
    
    /**
     * Delegates to {@link ValueObject#logicallyEquals(RiverObject)}.
     * @param v1
     * @param v2
     * @return
     */
    private boolean areDifferent(ValueObject v1, ValueObject v2) {
	return v1.logicallyEquals(v2);
    }
    
    /**
     * Returns <code>true</code> if the entities are different. An entity from the same
     * snapshot are always equal to itself. If two versions from different snapshots
     * are compared, the entities are equal if all outgoing associations are logically
     * equal along the composition hierarchy.
     * 
     * @precondition e1 and e2 are the same entity instance
     * @param e1
     *                {@link EntityObject} to compare
     * @param e2
     *                {@link EntityObject} to compare
     * @return <code>true</code> if the {@link EntityObject}s there are changes from e1 to e2,
     *         <code>false</code> otherwise.
     */
    private boolean areDifferent(EntityObject e1, EntityObject e2) {
	if (!e1.getId().equals(e2.getId())) {
	    throw new RuntimeException(
		    "The two entity instances are not referring to the same entity: " + e1.getId()
			    + " <> " + e1.getId());
	}
	// FIXME: better have equals on SnapshotIdentifier
	if (e1.getOrigin().getSnapshot().when().equals(e2.getOrigin().getSnapshot().when())) {
	    return false;
	}

	for (AssociationEnd ae : e1.getType().getClazz().getAssociationEnds()) {
	    AssociationEnd otherEnd = ae.otherEnd();
	    // FIXME: navigate can return null
	    RiverObject o1 = navigate(e1, getSideOfEnd(otherEnd).otherEnd(), otherEnd
		    .getAssociation());
	    RiverObject o2 = navigate(e2, getSideOfEnd(otherEnd).otherEnd(), otherEnd
		    .getAssociation());
	    if (!o1.logicallyEquals(o2)) {
		return true;
	    }
	    if (ae.isComposite()) {
		if (areDifferent(o1, o2)) {
		    return true;
		}
	    }
	}
	return false;
    }
    
    public class SnapshotComparator implements Comparator<ClassTypedObject> {

	@Override
	public int compare(ClassTypedObject o1, ClassTypedObject o2) {
	    return o1.getOrigin().getSnapshot().when().compareTo(
		    o2.getOrigin().getSnapshot().when());
	}

    }

    /**
     * Determines the position of the <tt>link</tt> which is part of an ordered association with respect
     * to the object at its unordered end.
     */
    protected int getLinkPosition(Link link) {
	Side orderedSide = link.getOrderedSide();
	AssociationEnd orderedEnd = link.getAssociation().getEnds().get(orderedSide.endNumber());
	ClassTypedObject objectAtUnorderedEnd = link.get(orderedSide.otherEnd());
	ObjectAndRemoteAssociationEnd oarae = new ObjectAndRemoteAssociationEnd(objectAtUnorderedEnd, orderedEnd);
	List<Link> embeddedInList = (List<Link>) getMapForEnd(orderedSide.otherEnd()).get(oarae);
	return embeddedInList.indexOf(link);
    }
}
