package com.sap.runlet.abstractinterpreter.repository.simpleimpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.sap.runlet.abstractinterpreter.Side;
import com.sap.runlet.abstractinterpreter.objects.ClassTypedObject;
import com.sap.runlet.abstractinterpreter.objects.EntityObject;
import com.sap.runlet.abstractinterpreter.objects.Link;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.abstractinterpreter.repository.SimpleLinkContainer;
import com.sap.runlet.abstractinterpreter.repository.Snapshot;
import com.sap.runlet.abstractinterpreter.util.HashBag;
import com.sap.runlet.abstractinterpreter.util.ModelAdapter;

/**
 * A container for {@link Link}s, similar to the {@link RunletLinkContainer}, but much simpler.
 * Used in the {@link InMemoryRepository} to keep track of the links stored in a
 * {@link Snapshot} and supporting an efficient navigation from one end across an
 * {@link data.classes.Association} to the objects at the other end, meaning a loading
 * of all the links attached to a given object that are type of a specific association.<p>
 * 
 * @author Axel Uhl (D043530)
 */
public class SimpleLinkContainerImpl<LinkMetaObject extends EObject,
				     LinkEndMetaObject extends EObject,
				     MetaClass extends EObject,
				     TypeUsage extends EObject,
				     ClassUsage extends TypeUsage>
implements SimpleLinkContainer<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> {
    /**
     * A value-holder class for an object and a remote association end. Use instances of this class
     * as key for maps in which to store the links for navigating from the <tt>object</tt> to the
     * remote association end. The object's {@link ClassTypedObject#getOrigin() snapshot} is ignored
     * during {@link #hashCode()} and {@link #equals(Object)} because this entire link container is
     * in the scope of a single snapshot anyway. This also avoids trouble during lookups where the
     * object passed in has a snapshot identifier not equal to the one used when the object was
     * stored in the snapshot.
     * 
     * @author Axel Uhl (D043530)
     */
    public class ObjectAndRemoteAssociationEndIgnoringSnapshot {
	private ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> object;
	private LinkEndMetaObject remoteAssociationEnd;
	public ObjectAndRemoteAssociationEndIgnoringSnapshot(ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> object, LinkEndMetaObject remoteAssociationEnd) {
	    this.object = object;
	    this.remoteAssociationEnd = remoteAssociationEnd;
	}
	public ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> getObject() {
	    return object;
	}
	public LinkEndMetaObject getRemoteAssociationEnd() {
	    return remoteAssociationEnd;
	}
	public boolean equals(Object o) {
	    @SuppressWarnings("unchecked")
	    ObjectAndRemoteAssociationEndIgnoringSnapshot oCast = (ObjectAndRemoteAssociationEndIgnoringSnapshot) o;
	    return (getObject() == null && oCast.getObject() == null) ||
		    getObject() != null && getObject().logicallyEquals(
			    oCast.getObject()) &&
			    getRemoteAssociationEnd().equals(oCast.getRemoteAssociationEnd());
	}
	public int hashCode() {
	    return ((getObject()==null)?0:getObject().logicalHashCode()) ^ getRemoteAssociationEnd().hashCode();
	}
	public String toString() {
	    StringBuilder result = new StringBuilder();
	    result.append("ObjectAndRemoteAssociationEnd from object ");
	    result.append(getObject());
	    result.append(" via association ");
	    result.append(getModelAdapter().getAssociationName(getModelAdapter().getAssociation(getRemoteAssociationEnd())));
	    result.append(" to end ");
	    result.append(getModelAdapter().getEndName(getRemoteAssociationEnd()));
	    result.append(" of type ");
	    result.append(getModelAdapter().getClassName(
		    getModelAdapter().getEndType(getRemoteAssociationEnd())));
	    return result.toString();
	}
    }
    
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
    private HashMap<ObjectAndRemoteAssociationEndIgnoringSnapshot, Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>> linksForLeft;

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
    private HashMap<ObjectAndRemoteAssociationEndIgnoringSnapshot, Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>> linksForRight;
    
    /**
     * Values are the sets of links that have the key as their
     * {@link Link<Association, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>#getAssociation() association}. May be an empty set but never <tt>null</tt>.
     * It is possible that an {@link Association} is not contained as a key in this map, meaning
     * that this {@link Link<Association, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>Container} does not know about any {@link Link<Association, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>}s that have this object
     * at their right end. As opposed to {@link #linksForLeft} and {@link #linksForRight}, if
     * this map contains an association as a key, this does not mean that this link container
     * knows the full extent of the association. Besides, links are currently not keyed
     * by snapshot which could result in link collections containing links from multiple different
     * snapshots.
     */
    private HashMap<LinkMetaObject, Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>> linksForAssociation;
    
    private HashBag<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> allLinks;
    
    /**
     * Keeps the link maps by the end number of the keys. See also {@link Side#endNumber}
     */
    private final Map<ObjectAndRemoteAssociationEndIgnoringSnapshot, Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>>[] mapsByEndNumber;

    private final ModelAdapter<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> modelAdapter;
    
    @SuppressWarnings("unchecked")
    public SimpleLinkContainerImpl(ModelAdapter<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> modelAdapter) {
	this.modelAdapter = modelAdapter;
	linksForLeft = new HashMap<ObjectAndRemoteAssociationEndIgnoringSnapshot, Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>>();
	linksForRight = new HashMap<ObjectAndRemoteAssociationEndIgnoringSnapshot, Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>>();
	mapsByEndNumber = (Map<ObjectAndRemoteAssociationEndIgnoringSnapshot, Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>>[]) new Map<?, ?>[Side.values().length];
	mapsByEndNumber[Side.LEFT.endNumber()] = linksForLeft;
	mapsByEndNumber[Side.RIGHT.endNumber()] = linksForRight;
	linksForAssociation = new HashMap<LinkMetaObject, Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>>();
	allLinks = new HashBag<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>();
    }
    
    public SimpleLinkContainerImpl<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> clone() {
	SimpleLinkContainerImpl<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> result =
	    new SimpleLinkContainerImpl<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(getModelAdapter());
	result.allLinks = allLinks.clone();
	result.linksForAssociation = cloneMapWithLinkCollectionAsValue(linksForAssociation);
	result.linksForLeft = cloneMapWithLinkCollectionAsValue(linksForLeft);
	result.linksForRight = cloneMapWithLinkCollectionAsValue(linksForRight);
	result.mapsByEndNumber[Side.LEFT.endNumber()] = result.linksForLeft;
	result.mapsByEndNumber[Side.RIGHT.endNumber()] = result.linksForRight;
	return result;
    }

    private ModelAdapter<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> getModelAdapter() {
        return modelAdapter;
    }

    private <T> HashMap<T, Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>> cloneMapWithLinkCollectionAsValue(HashMap<T, Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>> map) {
	HashMap<T, Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>> result = new HashMap<T, Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>>();
	for (T key:map.keySet()) {
	    Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> linkCollection = createLinkCollection(key);
	    linkCollection.addAll(map.get(key));
	    result.put(key, linkCollection);
	}
	return result;
    }

    public void addLink(Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> link, Integer at) {
	for (Side side : Side.values()) {
	    ObjectAndRemoteAssociationEndIgnoringSnapshot key = new ObjectAndRemoteAssociationEndIgnoringSnapshot(link.get(side),
		    getModelAdapter().getEnds(link.getAssociation()).get(side.otherEndNumber()));
	    addLinkToMap(link, key, getMapForEnd(side), at);
	}
	addLinkToMap(link, link.getAssociation(), getLinksForAssociation(), at);
	allLinks.add(link);
    }
    
    public void removeLink(Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> link, Integer at) {
	for (Side side : Side.values()) {
	    ObjectAndRemoteAssociationEndIgnoringSnapshot key = new ObjectAndRemoteAssociationEndIgnoringSnapshot(link.get(side),
		    getModelAdapter().getEnds(link.getAssociation()).get(side.otherEndNumber()));
	    removeLinkFromMap(link, key, getMapForEnd(side), at);
	}
	removeLinkFromMap(link, link.getAssociation(), getLinksForAssociation(), at);
	allLinks.remove(link);
    }
    
    public Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> all(LinkMetaObject a) {
	return Collections.unmodifiableCollection(getLinksForAssociation().get(a));
    }
    
    public Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> getAllLinks() {
	return Collections.unmodifiableCollection(allLinks);
    }
    
    public Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> navigate(ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> from, LinkEndMetaObject toEnd) {
	ObjectAndRemoteAssociationEndIgnoringSnapshot key = new ObjectAndRemoteAssociationEndIgnoringSnapshot(from, toEnd);
	Side fromSide = getSideOfEnd(toEnd).otherEnd();
	Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> result = getMapForEnd(fromSide).get(key);
	if (result == null) {
	    result = new ArrayList<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>(0);
	}
	return result;
    }
    
    public Map<ObjectAndRemoteAssociationEndIgnoringSnapshot, Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>> getMapForEnd(Side side) {
	return mapsByEndNumber[side.endNumber()];
    }
    
    public <T> void addLinkToMap(Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> link, T key, Map<T, Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>> map, Integer at) {
	if (ObjectAndRemoteAssociationEndIgnoringSnapshot.class.isAssignableFrom(key.getClass())) {
	    @SuppressWarnings("unchecked")
	    ObjectAndRemoteAssociationEndIgnoringSnapshot keyCast = (ObjectAndRemoteAssociationEndIgnoringSnapshot) key;
	    if (keyCast.getObject() instanceof EntityObject<?, ?, ?, ?, ?>) {
		EntityObject<?, ?, ?, ?, ?> e = (EntityObject<?, ?, ?, ?, ?>) keyCast.getObject();
		if (e.getOrigin() != null) {
		    assert link.getOrigin() == null || link.getOrigin().equals(e.getOrigin());
		}
	    }
	}
	
	Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> set = map.get(key);
	if (set == null) {
	    set = createLinkCollection(key);
	    map.put(key, set);
	}
	if (at != null && at >= 0 && set instanceof List<?>) {
	    ((List<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>) set).add(at, link);
	} else {
	    set.add(link);
	}
    }
    
    public <T> void removeLinkFromMap(Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> link, T key, Map<T, Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>> map, Integer at) {
	Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> set = map.get(key);
	if (set != null) {
	    if (at != null && at >= 0 && set instanceof List<?>) {
		((List<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>) set).remove(at);
	    } else {
		set.remove(link);
	    }
	}
    }
    
    /**
     * @param key For type {@link ObjectAndRemoteAssociationEndIgnoringSnapshot}, the resulting collection
     * is created based on the orderedness of the respective
     * {@link ObjectAndRemoteAssociationEndIgnoringSnapshot#getRemoteAssociationEnd() association end}.
     * For type <tt>linkMetaObject</tt>, the collection type is used based on orderedness
     * and uniqueness of the ends: if at least one end is orderer, an ordered collection
     * is returned; if at least one end is non-unique, a collection supporting duplicates
     * is returned.<p>
     * 
     * For all other types of <tt>key</tt>, a {@link LinkedHashSet} is used.
     */
    @SuppressWarnings("unchecked")
    private Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> createLinkCollection(Object key) {
	Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> result;
	if (ObjectAndRemoteAssociationEndIgnoringSnapshot.class.isAssignableFrom(key.getClass())) {
	    ObjectAndRemoteAssociationEndIgnoringSnapshot oarae = (ObjectAndRemoteAssociationEndIgnoringSnapshot) key;
	    result = RunletObject.createCollection(
		    getModelAdapter().isOrdered(oarae.getRemoteAssociationEnd()),
		    getModelAdapter().isUnique(oarae.getRemoteAssociationEnd()));
	} else {
	    // TODO This unchecked cast is ugly; and originally there even was an instanceof check which is not possible anymore due to the use of generics; split into two methods, one for LinkMetaObject, one for ObjectAndRemoteAssociationEndIgnoringSnapshot?
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
    
    public Map<LinkMetaObject,  Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>> getLinksForAssociation() {
        return linksForAssociation;
    }

    Side getSideOfEnd(LinkEndMetaObject end) {
        if (getModelAdapter().getEnds(getModelAdapter().getAssociation(end)).get(Side.LEFT.endNumber()).equals(end)) {
            return Side.LEFT;
        } else {
            return Side.RIGHT;
        }
    }

}
