package com.sap.runlet.abstractinterpreter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.eclipse.emf.ecore.EObject;

import com.sap.runlet.abstractinterpreter.objects.AbstractValueObject;
import com.sap.runlet.abstractinterpreter.objects.ClassTypedObject;
import com.sap.runlet.abstractinterpreter.objects.EmptyObject;
import com.sap.runlet.abstractinterpreter.objects.EntityObject;
import com.sap.runlet.abstractinterpreter.objects.Link;
import com.sap.runlet.abstractinterpreter.objects.MultiValuedObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.abstractinterpreter.repository.Repository;
import com.sap.runlet.abstractinterpreter.repository.RepositoryObject;
import com.sap.runlet.abstractinterpreter.repository.Snapshot;
import com.sap.runlet.abstractinterpreter.repository.SnapshotIdentifier;
import com.sap.runlet.abstractinterpreter.util.Bag;
import com.sap.runlet.abstractinterpreter.util.HashBag;
import com.sap.runlet.abstractinterpreter.util.ModelAdapter;

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
public abstract class LinkContainer<LinkMetaObject extends EObject,
				    LinkEndMetaObject extends EObject,
				    MetaClass extends EObject,
				    TypeUsage extends EObject,
				    ClassUsage extends TypeUsage,
				    StatementType extends EObject,
				    ExpressionType extends EObject,
				    SignatureImplementationType extends EObject,
				    StackFrameType extends StackFrame<LinkEndMetaObject, TypeUsage, ClassUsage, SignatureImplementationType>,
				    NativeType extends SignatureImplementationType,
				    InterpreterType extends AbstractRunletInterpreter<MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType>> {

    /**
     * Values are the sets of links that have the key as their {@link Link#getLeft() left} end.
     * May be an empty set but never <tt>null</tt>. It is possible that a {@link ClassTypeObject}
     * is not contained as a key in this map, meaning that this {@link RunletLinkContainer} does not
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
    private Map<ObjectAndRemoteAssociationEnd<LinkMetaObject, LinkEndMetaObject, TypeUsage, ClassUsage, MetaClass>, Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>> linksForLeft;

    /**
     * Values are the sets of links that have the key as their {@link Link#getRight() right} end.
     * May be an empty set but never <tt>null</tt>. It is possible that a {@link ClassTypeObject}
     * is not contained as a key in this map, meaning that this {@link RunletLinkContainer} does not
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
    private Map<ObjectAndRemoteAssociationEnd<LinkMetaObject, LinkEndMetaObject, TypeUsage, ClassUsage, MetaClass>, Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>> linksForRight;
    
    /**
     * Values are the sets of links that have the key as their
     * {@link Link#getAssociation() association}. May be an empty set but never <tt>null</tt>.
     * It is possible that an {@link LinkMetaObject} is not contained as a key in this map, meaning
     * that this {@link RunletLinkContainer} does not know about any {@link Link}s that have this object
     * at their right end. As opposed to {@link #linksForLeft} and {@link #linksForRight}, if
     * this map contains an association as a key, this does not mean that this link container
     * knows the full extent of the association. Besides, links are currently not keyed
     * by snapshot which could result in link collections containing links from multiple different
     * snapshots.
     */
    private Map<LinkMetaObject, Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>> linksForAssociation;

    /**
     * Keeps the link maps by the end number of the keys. See also {@link Side#endNumber}<p>
     */
    private Map<ObjectAndRemoteAssociationEnd<LinkMetaObject, LinkEndMetaObject, TypeUsage, ClassUsage, MetaClass>, Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>>[] mapsByEndNumber;
    
    /**
     * Queries that cannot be resolved by the data cached in this link container are
     * forwarded to the durably-storing repository. Results are cached, assuming that
     * each snapshot in the repository is immutable.
     */
    private final Repository<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> repository;

    private final ModelAdapter<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> modelAdapter;

    @SuppressWarnings("unchecked")
    public LinkContainer(ModelAdapter<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> modelAdapter,
	    Repository<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> repository) {
	this.modelAdapter = modelAdapter;
	this.repository = repository;
	linksForLeft = new HashMap<ObjectAndRemoteAssociationEnd<LinkMetaObject, LinkEndMetaObject, TypeUsage, ClassUsage, MetaClass>, Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>>();
	linksForRight = new HashMap<ObjectAndRemoteAssociationEnd<LinkMetaObject, LinkEndMetaObject, TypeUsage, ClassUsage, MetaClass>, Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>>();
	mapsByEndNumber = (Map<ObjectAndRemoteAssociationEnd<LinkMetaObject, LinkEndMetaObject, TypeUsage, ClassUsage, MetaClass>, Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>>[])
		new Map<?, ?>[Side.values().length];
	mapsByEndNumber[Side.LEFT.endNumber()] = linksForLeft;
	mapsByEndNumber[Side.RIGHT.endNumber()] = linksForRight;
	linksForAssociation = new HashMap<LinkMetaObject, Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>>();
    }

    protected ModelAdapter<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> getModelAdapter() {
        return modelAdapter;
    }

    protected Map<ObjectAndRemoteAssociationEnd<LinkMetaObject, LinkEndMetaObject, TypeUsage, ClassUsage, MetaClass>, Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>> getMapForEnd(Side side) {
	return mapsByEndNumber[side.endNumber()];
    }
    
    protected Repository<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> getRepository() {
        return repository;
    }

    protected Map<LinkMetaObject,  Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>> getLinksForAssociation() {
        return linksForAssociation;
    }

    /**
     * Removes a link between the two objects <tt>left</tt> and <tt>right</tt>
     * on behalf of the respective association from this {@link RunletLinkContainer}.
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
    public void removeLink(ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> left,
	    ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> right,
	    LinkMetaObject association,
	    Integer at,
	    TransactionBuffer<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> transactionBuffer,
	    SnapshotIdentifier defaultSnapshot,
	    AbstractRunletInterpreter<MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType>interpreter) {
	LinkEndMetaObject rightEnd = getModelAdapter().getEnds(association).get(Side.RIGHT.endNumber());
	Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> fromLeft = loadLinks(left, Side.LEFT, rightEnd);
	if (fromLeft != null) {
	    LinkEndMetaObject leftEnd = getModelAdapter().getEnds(association).get(Side.LEFT.endNumber());
	    Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> fromRight = loadLinks(right, Side.RIGHT, leftEnd);
	    if (fromRight != null) {
		Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> candidates = new HashSet<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>(fromLeft);
		candidates.retainAll(fromRight);
		if (candidates.size() > 0) {
		    removeLink(candidates.iterator().next(), at, transactionBuffer, defaultSnapshot, interpreter);
		}
	    }
	}
    }

    /**
     * Makes sure that links that exist for <tt>from</tt> on <tt>fromSide</tt> in association
     * <tt>toEnd.getAssociation()</tt> are loaded and returns them. If this requires fetching them
     * from the {@link #getRepository repository}, this will be done.
     */
    protected Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> loadLinks(
	    ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> from, Side fromSide, LinkEndMetaObject toEnd) {
	ObjectAndRemoteAssociationEnd<LinkMetaObject, LinkEndMetaObject, TypeUsage, ClassUsage, MetaClass> key = new ObjectAndRemoteAssociationEnd<LinkMetaObject, LinkEndMetaObject, TypeUsage, ClassUsage, MetaClass>(from, toEnd, getModelAdapter());
	Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> links = getMapForEnd(fromSide).get(key);
	if (links == null && ((from instanceof AbstractValueObject<?, ?, ?, ?, ?>) || from.isPersistent())) {
	    // this container doesn't know anything about this and the from object
	    // is persistent; ask repository:
	    links = getRepository().loadLinks(from, toEnd);
	    Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> mutableLinkCollection =
		createLinkCollection(key);
	    if (links != null) {
		mutableLinkCollection.addAll(links);
	    }
	    // TODO what about adding to the linksForAssociation map?
	    getMapForEnd(fromSide).put(key, mutableLinkCollection); // now we know
	    // and cache the result
	    if (getModelAdapter().isValueType(getModelAdapter().getEndType(toEnd))) {
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
    @SuppressWarnings("unchecked")
    private void loadValueLinks(Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> links,
	    Side valueClassSide) {
	for (Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> link:links) {
	    AbstractValueObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> vo =
		(AbstractValueObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) link.get(valueClassSide);
	    loadEqualityRelevantLinksOfValue(vo);
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
    private void loadLink(Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> link) {
	for (Side side : Side.values()) {
	    ObjectAndRemoteAssociationEnd<LinkMetaObject, LinkEndMetaObject, TypeUsage, ClassUsage, MetaClass> key =
		new ObjectAndRemoteAssociationEnd<LinkMetaObject, LinkEndMetaObject, TypeUsage, ClassUsage, MetaClass>(link.get(side),
			getModelAdapter().getEnds(link.getAssociation())
		    .get(side.otherEndNumber()), getModelAdapter());
	    // If a persistent link collection for one end exists but hasn't been loaded yet,
	    // it must be loaded first; otherwise a new empty collection would be created which
	    // would then probably overwrite the existing one
	    loadLinks(link.get(side), side, getModelAdapter().getEnds(link.getAssociation()).get(side.otherEndNumber()));
	    addLinkToMap(link, key, getMapForEnd(side),
		    /* use default insert position, e.g., append */ null);
	}
	addLinkToMap(link, link.getAssociation(), getLinksForAssociation(),
		/* use default insert position, e.g., append */ null);
    }

    /**
     * Creates a link between the two objects <tt>left</tt> and <tt>right</tt>
     * on behalf of the respective association and adds it to this
     * {@link RunletLinkContainer}. If the {@link RepositoryObject#getOrigin()
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
    public void addLinkFromObjectsForEnds(
	    ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> left,
	    ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> right,
	    LinkMetaObject association,
	    Integer at,
	    TransactionBuffer<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> transactionBuffer,
	    InterpreterType interpreter) {
	if (!left.getOrigin().equals(right.getOrigin())) {
	    if ((getModelAdapter().isContributesToEquality(getModelAdapter().getEnds(association).get(Side.LEFT.endNumber())) &&
		    right instanceof AbstractValueObject<?, ?, ?, ?, ?>)) {
		right = right.getCopyWithOrigin(left.getOrigin());
	    } else if (getModelAdapter().isContributesToEquality(getModelAdapter().getEnds(association).get(Side.RIGHT.endNumber())) &&
		    left instanceof AbstractValueObject<?, ?, ?, ?, ?>) {
		left = left.getCopyWithOrigin(right.getOrigin());
	    } else {
		throw new RuntimeException("Can't establish link between objects in different snapshots: "+
			left.getOrigin()+" and "+right.getOrigin());
	    }
	}
	assert left.getOrigin().equals(right.getOrigin());
	Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> link = new Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(left, right, association, left.getOrigin(), getModelAdapter());
	addLink(link, at, transactionBuffer, interpreter);
    }

    @SuppressWarnings("unchecked")
    private <T> void addLinkToMap(Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> link, T key, Map<T, Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>> map, Integer at) {
	if (key instanceof ObjectAndRemoteAssociationEnd) {
	    if (((ObjectAndRemoteAssociationEnd<LinkMetaObject, LinkEndMetaObject, TypeUsage, ClassUsage, MetaClass>)key).getObject() instanceof EntityObject) {
		EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> e =
		    (EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>)
		    ((ObjectAndRemoteAssociationEnd<LinkMetaObject, LinkEndMetaObject, TypeUsage, ClassUsage, MetaClass>) key).getObject();
		if (e.getOrigin() != null) {
		    // no cross-snapshot links
		    if (link.getOrigin() != null && !link.getOrigin().equals(e.getOrigin())) {
			throw new RuntimeException("Cross snapshot links not allowed");
		    }
		}
	    }
	}
	Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> set = map.get(key);
	if (set == null) {
	    set = createLinkCollection(key);
	    map.put(key, set);
	}
	if (at != null && at >= 0 && set instanceof List) {
	    ((List<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>) set).add(at, link);
	} else {
	    set.add(link);
	}
    }
    
    private boolean doesLinkExist(Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> link) {
	ObjectAndRemoteAssociationEnd<LinkMetaObject, LinkEndMetaObject, TypeUsage, ClassUsage, MetaClass> key =
	    new ObjectAndRemoteAssociationEnd<LinkMetaObject, LinkEndMetaObject, TypeUsage, ClassUsage, MetaClass>(
		    link.get(Side.LEFT),
		    getModelAdapter().getEnds(link.getAssociation()).get(Side.RIGHT.endNumber()),
		    getModelAdapter());
	Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> existingLinks =
	    getMapForEnd(Side.LEFT).get(key);
	return existingLinks != null && existingLinks.contains(link);
    }

    @SuppressWarnings("unchecked")
    private void addLink(final Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>link, Integer at,
	    TransactionBuffer<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> transactionBuffer,
	    InterpreterType interpreter) {
	// TODO check multiplicities?
	// TODO check aggregation relevance (will "child" move to parent's aggregate?)
	RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> currentCompositeParent = getCompositeParentForChild(link);
	if (!getModelAdapter().isUnique(getModelAdapter().getEnds(link.getAssociation()).get(0))
	// if the association is unique, check if the link already exists
	|| !doesLinkExist(link)) {
	    if (currentCompositeParent != null) {
		throw new RuntimeException(
			"Illegal attempt to establish a second composite parent link for composite child "
				+ link.get(getCompositeParentSide(link).otherEnd())
				+ " which is already owned by " + currentCompositeParent);
	    }
	    for (final Side side : Side.values()) {
		if (getModelAdapter().isContributesToEquality(
			getModelAdapter().getEnds(link.getAssociation()).get(side.endNumber())) &&
			getModelAdapter().isValueType(
				getModelAdapter().getEndType(
					getModelAdapter().getEnds(link.getAssociation()).get(side.endNumber())))) {
		    throw new RuntimeException("Illegal attempt to modify a value object. Trying to establish link "+
			    link);
		}
		ObjectAndRemoteAssociationEnd<LinkMetaObject, LinkEndMetaObject, TypeUsage, ClassUsage, MetaClass> key = new ObjectAndRemoteAssociationEnd<LinkMetaObject, LinkEndMetaObject, TypeUsage, ClassUsage, MetaClass>(link
			.get(side), getModelAdapter().getEnds(link.getAssociation()).get(side.otherEndNumber()),
			getModelAdapter());
		// If a persistent link collection for one end exists but hasn't been loaded yet,
		// it must be loaded first; otherwise a new empty collection would be created which
		// would then probably overwrite the existing one
		loadLinks(link.get(side), side, getModelAdapter().getEnds(link.getAssociation()).get(side.otherEndNumber()));
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
		    EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> child =
			(EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) link.get(compositeParentSide.otherEnd());
		    if (!child.isPersistent()) {
			interpreter.storeEntity(child);
		    }
		}
	    }
	}
    }
    
    /**
     * Determines if and which of the two sides of the <tt>link</tt> is a composite parent end
     * of a composite association. If none is, <tt>null</tt> is returned; otherwise, the side
     * on which the association end marked as {@link LinkEndMetaObject#isComposite()} resides is returned.
     */
    private Side getCompositeParentSide(Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> link) {
	Side compositeParentSide = null;
	int i=0;
	List<LinkEndMetaObject> ends = getModelAdapter().getEnds(link.getAssociation());
	for (Side side:Side.values()) {
	    if (getModelAdapter().isComposite(ends.get(side.endNumber()))) {
		compositeParentSide = side;
		break;
	    }
	    i++;
	}
	return compositeParentSide;
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
     */
    @SuppressWarnings("unchecked")
    public Bag<RepositoryObject> getTransientCompositionTree(EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> toSave) {
        Bag<RepositoryObject> result = new HashBag<RepositoryObject>();
        Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> allLinks = getAllLinks(toSave);
        Set<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> children = new HashSet<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>();
        for (Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> l:allLinks) {
            Side compositeParentSide = getCompositeParentSide(l);
            if (compositeParentSide != null && l.get(compositeParentSide).equals(toSave)) {
        	// cast is ok because composition is not possible for values
        	EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> child =
        	    (EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) l.get(
        		    compositeParentSide.otherEnd());
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
        	LinkEndMetaObject toSaveEnd = getModelAdapter().getEnds(l.getAssociation()).get(sideOfToSave.endNumber());
        	boolean otherEndIsValueType = getModelAdapter().isValueType(
        		getModelAdapter().getEndType(getModelAdapter().otherEnd(toSaveEnd)));
        	if (!l.isPersistent() &&
        		(!otherEndIsValueType || getModelAdapter().isContributesToEquality(toSaveEnd))) {
		    result.add(l);
		    ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> objectAtOtherEnd = l.get(sideOfToSave.otherEnd());
		    if (otherEndIsValueType) {
			result.addAll(getTransientEntitiesEqualityRelevantForValueRecursively(
				(AbstractValueObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) objectAtOtherEnd));
		    }
		}
            }
        }
        for (EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> child:children) {
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
    @SuppressWarnings("unchecked")
    private Bag<RepositoryObject> getTransientEntitiesEqualityRelevantForValueRecursively(
	    AbstractValueObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> objectAtOtherEnd) {
        Bag<RepositoryObject> result = new HashBag<RepositoryObject>();
	Map<LinkEndMetaObject, Collection<ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>>> equalityRelevantObjects =
	    objectAtOtherEnd.getEqualityRelevantAssociationEndValues();
	for (Collection<ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>> coll : equalityRelevantObjects.values()) {
	    for (ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> cto : coll) {
		if (cto instanceof AbstractValueObject) {
		    result.addAll(getTransientEntitiesEqualityRelevantForValueRecursively((AbstractValueObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) cto));
		} else {
		    // entity object
		    if (!cto.isPersistent()) {
			result.addAll(getTransientCompositionTree(
				(EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) cto));
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
    @SuppressWarnings("unchecked")
    public Bag<RepositoryObject> getCompositionTree(EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> object) {
	Bag<RepositoryObject> result = new HashBag<RepositoryObject>();
	Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> allLinks = getAllLinks(object);
	Set<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> children = new HashSet<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>();
	for (Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>l : allLinks) {
	    Side compositeParentSide = getCompositeParentSide(l);
	    if (compositeParentSide != null && l.get(compositeParentSide).equals(object)) {
		// cast is ok because composition is not possible for values
		EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> eo =
		    (EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) l.get(
			    compositeParentSide.otherEnd());
		// check if the object is transient
		children.add(eo);
		// the child will add the composite parent link l to its results
	    } else {
		// not a composite link; need to add it to the results here
		result.add(l);
	    }
	}
	for (EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> child : children) {
	    result.addAll(getCompositionTree(child));
	}
	result.add(object);
	return result;
    }

    /**
     * Obtains all links known to this link container attached to object <tt>o</tt>. Reflexive
     * links having the same object on both ends are added only once per occurrence. Of course,
     * non-unique links of this kind still occur as many times as they were added.
     */
    private List<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> getAllLinks(ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> o) {
	List<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> result =
	    new LinkedList<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>();
	for (LinkEndMetaObject end:getModelAdapter().getConformsToAssociationEnds(
		getModelAdapter().getClazz(o.getType()))) {
	    ObjectAndRemoteAssociationEnd<LinkMetaObject, LinkEndMetaObject, TypeUsage, ClassUsage, MetaClass> key =
		new ObjectAndRemoteAssociationEnd<LinkMetaObject, LinkEndMetaObject, TypeUsage, ClassUsage, MetaClass>(
			o, getModelAdapter().otherEnd(end),
		    getModelAdapter());
	    Side sideOfEnd = getModelAdapter().getSideOfEnd(end);
	    Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> links = getMapForEnd(sideOfEnd).get(key);
	    if (links != null) {
		for (Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> l : links) {
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
    private boolean shouldBeStoredToRepository(Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> link) {
	for (Side side : Side.values()) {
	    if (link.get(side) instanceof EntityObject<?, ?, ?, ?, ?> && link.get(side).isPersistent()) {
		if (getModelAdapter().isContributesToEquality(
			getModelAdapter().getEnds(link.getAssociation()).get(side.endNumber()))) {
		    return true;
		}
	    }
	}
	return false;
    }

    /**
     * Finds all child ends of composite associations such that <tt>child</tt>'s class
     * conforms to the association end's class, meaning that it could potentially participate
     * on that end in an association. Those associations are queried. If a link is found,
     * the object at the composite parent end is returned for the first such link found.
     * Otherwise, <tt>null</tt> is returned. Navigation happens within
     * {@link ClassTypedObject#getOrigin() child's snapshot}.
     */
    @SuppressWarnings("unchecked")
    private EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> getCompositeParent(ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> child) {
	RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> result = null;
	ObjectAndRemoteAssociationEnd<LinkMetaObject, LinkEndMetaObject, TypeUsage, ClassUsage, MetaClass> oarae = getCompositeParentObjectAndChildAssociationEnd(child);
	if (oarae != null) {
	    result = oarae.getObject();
	}
	return (EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) result;
    }
    
    /**
     * If the link is of a non-composite association (an association with no end marked
     * {@link LinkEndMetaObject#isComposite()}), the result is always <tt>null</tt>. If one
     * end is marked composite, this method looks for another composite link emerging from
     * the composite child of <tt>link</tt>. If such a link is found, the result is the
     * parent object of the link found. During finding such a link, all associations are
     * considered that contain a composite end and where <tt>link</tt>'s child's class
     * conforms to the child end's class of the link found.  Navigation happens within
     * {@link ClassTypedObject#getOrigin() the child's snapshot}.
     */
    private RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> getCompositeParentForChild(Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>link) {
	RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> result = null;
	Side compositeParentSide = getCompositeParentSide(link);
	if (compositeParentSide != null) {
	    ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> child = link.get(compositeParentSide.otherEnd());
	    result = getCompositeParent(child);
	}
	return result;
    }

    /**
     * Ensures that all links that establish the value object <tt>vo</tt> are loaded into
     * this link container. This includes all equality-relevant links of <tt>vo</tt> itself
     * as well as all equality-relevant links of all value objects that contribute to
     * <tt>vo</tt>'s value.
     */
    @SuppressWarnings("unchecked")
    public void loadEqualityRelevantLinksOfValue(AbstractValueObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> vo) {
	Map<LinkEndMetaObject, Collection<ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>>> equalityRelevant = vo
		.getEqualityRelevantAssociationEndValues();
	for (LinkEndMetaObject farEnd : equalityRelevant.keySet()) {
	    ObjectAndRemoteAssociationEnd<LinkMetaObject, LinkEndMetaObject, TypeUsage, ClassUsage, MetaClass> key = new ObjectAndRemoteAssociationEnd<LinkMetaObject, LinkEndMetaObject, TypeUsage, ClassUsage, MetaClass>(vo, farEnd, getModelAdapter());
	    Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> linkCollection =
		getMapForEnd(getModelAdapter().getSideOfEnd(getModelAdapter().otherEnd(farEnd))).get(key);
	    // if the link collection already exists, we assume it's up to date
	    if (linkCollection == null) {
		// in this case we'll insert all those links
		Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> equalityRelevantLinks = vo.getEqualityRelevantLinks(farEnd);
		boolean farEndIsValueType = getModelAdapter().isValueType(getModelAdapter().getEndType(farEnd));
		Side farSide = getModelAdapter().getSideOfEnd(farEnd);
		for (Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> erl : equalityRelevantLinks) {
		    loadLink(erl);
		    if (farEndIsValueType) {
			loadEqualityRelevantLinksOfValue(
				(AbstractValueObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) erl.get(farSide));
		    }
		}
	    }
	}
    }

    private <T> void removeLinkFromMap(Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> link, T key, Map<T, Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>> map, Integer at) {
	Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> set = map.get(key);
	if (set != null) {
	    if (at != null && at >= 0 && set instanceof List<?> && !((List<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>) set).get(at).equals(link)) {
		throw new RuntimeException("Requested removal of link "+link+
				" from specific position "+at+" but found "+
				((List<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>) set).get(at)+" at that position");
	    }
	    // TODO respect *at* parameter in case of list
	    if (set instanceof List<?> && at != null && at >= 0) {
		((List<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>) set).remove(at);
	    } else {
		set.remove(link);
	    }
	    // Note: don't remove empty collections from map for persistent keys because they still have a meaning.
	    // They state that the link container is aware of the fact that this link set is empty. This
	    // avoids loading a "clean" link set from the repository which would be wrong after modifications
	    // such as a removal took place on the link set.
	    if (set.isEmpty()) {
		if (key instanceof ObjectAndRemoteAssociationEnd<?, ?, ?, ?, ?>) {
		    ObjectAndRemoteAssociationEnd<?, ?, ?, ?, ?> oarae = (ObjectAndRemoteAssociationEnd<?, ?, ?, ?, ?>) key;
		    if (!oarae.getObject().isPersistent()) {
			map.remove(key);
		    }
		}
	    }
	}
    }
    
    protected void removeLink(Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> link, Integer at,
	    TransactionBuffer<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> transactionBuffer,
	    SnapshotIdentifier defaultSnapshot,
	    AbstractRunletInterpreter<MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType> interpreter) {
	// TODO check multiplicities (underflow)?
	for (Side side:Side.values()) {
	    ObjectAndRemoteAssociationEnd<LinkMetaObject, LinkEndMetaObject, TypeUsage, ClassUsage, MetaClass> key = new ObjectAndRemoteAssociationEnd<LinkMetaObject, LinkEndMetaObject, TypeUsage, ClassUsage, MetaClass>(link.get(side),
		    getModelAdapter().getEnds(link.getAssociation()).get(side.otherEndNumber()),
		    getModelAdapter());
	    if (getModelAdapter().isContributesToEquality(
		    getModelAdapter().getEnds(link.getAssociation()).get(side.endNumber()))
		    && getModelAdapter().isValueType(
			    getModelAdapter().getEndType(getModelAdapter().getEnds(link.getAssociation()).get(side.endNumber())))) {
		throw new RuntimeException(
			"Illegal attempt to modify a value object. Trying to remove link "
				+ link);
	    }
	    // If a persistent link collection for one end exists but hasn't been loaded yet,
	    // it must be loaded first; otherwise a new empty collection would be created which
	    // would then probably overwrite the existing one
	    loadLinks(link.get(side), side, getModelAdapter().getEnds(link.getAssociation()).get(side.otherEndNumber()));
	    removeLinkFromMap(link, key, getMapForEnd(side), at);
	}
	removeLinkFromMap(link, link.getAssociation(), getLinksForAssociation(), at);
	// TODO if link is composite, decide if composite children tree should be made transient
	if (link.isPersistent()) {
	    transactionBuffer.linkDeleted(link, at);
	}
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
    public RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> navigate(
	    ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> from,
	    Side fromSide,
	    LinkMetaObject over) {
	LinkEndMetaObject otherEnd = getModelAdapter().getEnds(over).get(fromSide.otherEndNumber());
	ClassUsage toEndType = getModelAdapter().getClassUsage(otherEnd);
	Collection<RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>> resultCollection = RunletObject.
		createCollection(getModelAdapter().isOrdered(otherEnd), getModelAdapter().isUnique(otherEnd));
	RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> result;
	Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> links = loadLinks(from, fromSide, otherEnd);
	if (links != null) {
	    for (Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> link : links) {
		resultCollection.add(link.get(fromSide.otherEnd()));
	    }
	}
	if (!getModelAdapter().isMany(otherEnd)) {
	    if (resultCollection.size() > 0) {
		result = resultCollection.iterator().next();
	    } else {
		result = new EmptyObject<LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(toEndType, getModelAdapter());
	    }
	} else {
	    result = new MultiValuedObject<LinkEndMetaObject, TypeUsage, ClassUsage>(toEndType, resultCollection,
		    getModelAdapter().isOrdered(otherEnd), getModelAdapter().isUnique(otherEnd));
	}
	return result;
    }

    public ObjectAndRemoteAssociationEnd<LinkMetaObject, LinkEndMetaObject, TypeUsage, ClassUsage, MetaClass> getCompositeParentObjectAndChildAssociationEnd(
	    ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> child) {
	// look for existing composite links emerging from the child of the new composite link
	for (LinkEndMetaObject compositeChildEnd : getModelAdapter().getConformsToCompositeChildAssociationEnds(
		getModelAdapter().getClazz(child.getType()))) {
	    RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> parent = navigate(child,
		    getModelAdapter().getSideOfEnd(compositeChildEnd),
		    getModelAdapter().getAssociation(compositeChildEnd));
	    if (parent != null && !parent.isEmpty()) {
		return new ObjectAndRemoteAssociationEnd<LinkMetaObject, LinkEndMetaObject, TypeUsage, ClassUsage, MetaClass>((ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>) parent.iterator().next(),
			compositeChildEnd, getModelAdapter());
	    }
	}
	return null;
    }

    /**
     * @param key For type {@link ObjectAndRemoteAssociationEnd}, the resulting collection
     * is created based on the orderedness of the respective
     * {@link ObjectAndRemoteAssociationEnd#getRemoteAssociationEnd() association end}.
     * For type {@link LinkMetaObject}, the collection type is used based on orderedness
     * and uniqueness of the ends: if at least one end is ordered, an ordered collection
     * is returned; if at least one end is non-unique, a collection supporting duplicates
     * is returned.<p>
     * 
     * For all other types of <tt>key</tt>, a {@link LinkedHashSet} is used.
     */
    @SuppressWarnings("unchecked")
    private Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> createLinkCollection(Object key) {
	Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> result;
	if (key instanceof ObjectAndRemoteAssociationEnd) {
	    ObjectAndRemoteAssociationEnd<?, ? extends LinkEndMetaObject, ?, ?, ?> oarae = (ObjectAndRemoteAssociationEnd<?, ? extends LinkEndMetaObject, ?, ?, ?>) key;
	    result = RunletObject.createCollection(getModelAdapter().isOrdered(oarae.getRemoteAssociationEnd()),
		    getModelAdapter().isUnique(oarae.getRemoteAssociationEnd()));
	} else {
	    LinkMetaObject a = (LinkMetaObject) key;
	    boolean ordered = false;
	    boolean unique = true;
	    for (Side side : Side.values()) {
		if (getModelAdapter().isOrdered(getModelAdapter().getEnds(a).get(side.endNumber()))) {
		    ordered = true;
		}
		if (!getModelAdapter().isUnique(getModelAdapter().getEnds(a).get(side.endNumber()))) {
		    unique = false;
		}
	    }
	    result = RunletObject.createCollection(ordered, unique);
	}
	return result;
    }
    
    /**
     * Tells this link container that there are no links for this object yet, and that the link
     * container does not need to look up any such links in the persistence {@link #repository}. It
     * does so by inserting empty link collections into the directed link maps for all association
     * ends in which the <tt>object</tt> could potentially appear.
     */
    public void newEntity(EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> object) {
	for (LinkEndMetaObject ae:getModelAdapter().getConformsToAssociationEnds(
		getModelAdapter().getClazz(object.getType()))) {
	    ObjectAndRemoteAssociationEnd<LinkMetaObject, LinkEndMetaObject, TypeUsage, ClassUsage, MetaClass> key =
		new ObjectAndRemoteAssociationEnd<LinkMetaObject, LinkEndMetaObject, TypeUsage, ClassUsage, MetaClass>(
			object, getModelAdapter().otherEnd(ae),
		    getModelAdapter());
	    getMapForEnd(getModelAdapter().getSideOfEnd(ae)).put(key, createLinkCollection(key));
	}
    }

    public Iterable<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> removeUnchangedEntities(Map<Snapshot, Set<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>> entitiesFromSnapshot) {
	//  create subsets for each entityObject
	Map<UUID, Set<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>> entitySets = new HashMap<UUID, Set<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>>();
	
	for (Set<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> entities : entitiesFromSnapshot.values()) {
	    for (EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> entity : entities) {
		if (!entitySets.containsKey(entity.getId())) {
		    Set<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> set = new HashSet<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>();
		    set.add(entity);
		    entitySets.put(entity.getId(), set);
		}
		else {
		    entitySets.get(entity.getId()).add(entity);
		}
	    }
	}
	
	Set<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> result = new HashSet<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>();
	// loop over subsets and remove unchanged entities from different snapshots
	for (UUID uuid : entitySets.keySet()) {
	    Set<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> set = entitySets.get(uuid);
	    if (set.size() > 1) {  // only if there are more than one entity versions
		List<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> entities = new ArrayList<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>(set.size());
		entities.addAll(set);
		Collections.sort(entities, new SnapshotComparator());
		
		for (int i = 0; i < entities.size(); i++) {
		    EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> entity = entities.get(i);
		    if (i == 0) {
			result.add(entity);
		    }
		    else {
			int predecessorIndex = i - 1;
			while (predecessorIndex >= 0) {
			    EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> predecessor = entities.get(predecessorIndex);
			    Set<Snapshot> predecessorSnapthots = getRepository().getImmediatePredecessors(entity.getOrigin().getSnapshot());
			    if (predecessorSnapthots.contains(predecessor.getOrigin().getSnapshot())) {
				if (!entity.contentEquals(predecessor)) { // changed?
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
    
    public class SnapshotComparator implements Comparator<ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>> {
	@Override
	public int compare(ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> o1, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> o2) {
	    return o1.getOrigin().getSnapshot().when().compareTo(
		    o2.getOrigin().getSnapshot().when());
	}
    }

    /**
     * Determines the position of the <tt>link</tt> which is part of an ordered association with respect
     * to the object at its unordered end.
     */
    public int getLinkPosition(Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> link) {
	Side orderedSide = link.getOrderedSide();
	LinkEndMetaObject orderedEnd = getModelAdapter().getEnds(link.getAssociation()).get(orderedSide.endNumber());
	ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> objectAtUnorderedEnd = link.get(orderedSide.otherEnd());
	ObjectAndRemoteAssociationEnd<LinkMetaObject, LinkEndMetaObject, TypeUsage, ClassUsage, MetaClass> oarae = new ObjectAndRemoteAssociationEnd<LinkMetaObject, LinkEndMetaObject, TypeUsage, ClassUsage, MetaClass>(objectAtUnorderedEnd, orderedEnd,
		getModelAdapter());
	List<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> embeddedInList = (List<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>) getMapForEnd(orderedSide.otherEnd()).get(oarae);
	return embeddedInList.indexOf(link);
    }

}
