package com.sap.river.interpreter.repository.simpleimpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import com.sap.river.interpreter.LinkContainer;
import com.sap.river.interpreter.Side;
import com.sap.river.interpreter.objects.ClassTypedObject;
import com.sap.river.interpreter.objects.EntityObject;
import com.sap.river.interpreter.objects.Link;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.river.interpreter.repository.SimpleLinkContainer;
import com.sap.river.interpreter.repository.Snapshot;
import com.sap.river.interpreter.util.HashBag;

import data.classes.Association;
import data.classes.AssociationEnd;

/**
 * A container for {@link Link}s, similar to the {@link LinkContainer}, but much simpler.
 * Used in the {@link InMemoryRepository} to keep track of the links stored in a
 * {@link Snapshot} and supporting an efficient navigation from one end across an
 * {@link data.classes.Association} to the objects at the other end, meaning a loading
 * of all the links attached to a given object that are type of a specific association.<p>
 * 
 * @author Axel Uhl (D043530)
 */
public class SimpleLinkContainerImpl implements SimpleLinkContainer {
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
    public class ObjectAndRemoteAssociationEnd {
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
		    getObject() != null && getObject().logicallyEquals(((ObjectAndRemoteAssociationEnd) o).getObject()) &&
	    	getRemoteAssociationEnd().equals(((ObjectAndRemoteAssociationEnd) o).getRemoteAssociationEnd());
	}
	public int hashCode() {
	    return ((getObject()==null)?0:getObject().logicalHashCode()) ^ getRemoteAssociationEnd().hashCode();
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
    private HashMap<ObjectAndRemoteAssociationEnd, Collection<Link>> linksForLeft;

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
    private HashMap<ObjectAndRemoteAssociationEnd, Collection<Link>> linksForRight;
    
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
    private HashMap<Association, Collection<Link>> linksForAssociation;
    
    private HashBag<Link> allLinks;
    
    /**
     * Keeps the link maps by the end number of the keys. See also {@link Side#endNumber}
     */
    private Map<ObjectAndRemoteAssociationEnd, Collection<Link>>[] mapsByEndNumber;
    
    @SuppressWarnings("unchecked")
    public SimpleLinkContainerImpl() {
	linksForLeft = new HashMap<ObjectAndRemoteAssociationEnd, Collection<Link>>();
	linksForRight = new HashMap<ObjectAndRemoteAssociationEnd, Collection<Link>>();
	mapsByEndNumber = (Map<ObjectAndRemoteAssociationEnd, Collection<Link>>[]) new Map<?, ?>[Side.values().length];
	mapsByEndNumber[Side.LEFT.endNumber()] = linksForLeft;
	mapsByEndNumber[Side.RIGHT.endNumber()] = linksForRight;
	linksForAssociation = new HashMap<Association, Collection<Link>>();
	allLinks = new HashBag<Link>();
    }
    
    public SimpleLinkContainerImpl clone() {
	SimpleLinkContainerImpl result = new SimpleLinkContainerImpl();
	result.allLinks = allLinks.clone();
	result.linksForAssociation = cloneMapWithLinkCollectionAsValue(linksForAssociation);
	result.linksForLeft = cloneMapWithLinkCollectionAsValue(linksForLeft);
	result.linksForRight = cloneMapWithLinkCollectionAsValue(linksForRight);
	result.mapsByEndNumber[Side.LEFT.endNumber()] = result.linksForLeft;
	result.mapsByEndNumber[Side.RIGHT.endNumber()] = result.linksForRight;
	return result;
    }

    private <T> HashMap<T, Collection<Link>> cloneMapWithLinkCollectionAsValue(HashMap<T, Collection<Link>> map) {
	HashMap<T, Collection<Link>> result = new HashMap<T, Collection<Link>>();
	for (T key:map.keySet()) {
	    Collection<Link> linkCollection = createLinkCollection(key);
	    linkCollection.addAll(map.get(key));
	    result.put(key, linkCollection);
	}
	return result;
    }

    public void addLink(Link link, Integer at) {
	for (Side side : Side.values()) {
	    ObjectAndRemoteAssociationEnd key = new ObjectAndRemoteAssociationEnd(link.get(side),
		    link.getAssociation().getEnds().get(side.otherEndNumber()));
	    addLinkToMap(link, key, getMapForEnd(side), at);
	}
	addLinkToMap(link, link.getAssociation(), getLinksForAssociation(), at);
	allLinks.add(link);
    }
    
    public void removeLink(Link link, Integer at) {
	for (Side side : Side.values()) {
	    ObjectAndRemoteAssociationEnd key = new ObjectAndRemoteAssociationEnd(link.get(side),
		    link.getAssociation().getEnds().get(side.otherEndNumber()));
	    removeLinkFromMap(link, key, getMapForEnd(side), at);
	}
	removeLinkFromMap(link, link.getAssociation(), getLinksForAssociation(), at);
	allLinks.remove(link);
    }
    
    public Collection<Link> all(Association a) {
	return Collections.unmodifiableCollection(getLinksForAssociation().get(a));
    }
    
    public Collection<Link> getAllLinks() {
	return Collections.unmodifiableCollection(allLinks);
    }
    
    public Collection<Link> navigate(ClassTypedObject from, AssociationEnd toEnd) {
	ObjectAndRemoteAssociationEnd key = new ObjectAndRemoteAssociationEnd(from, toEnd);
	Side fromSide = getSideOfEnd(toEnd).otherEnd();
	Collection<Link> result = getMapForEnd(fromSide).get(key);
	if (result == null) {
	    result = new ArrayList<Link>(0);
	}
	return result;
    }
    
    public Map<ObjectAndRemoteAssociationEnd, Collection<Link>> getMapForEnd(Side side) {
	return mapsByEndNumber[side.endNumber()];
    }
    
    public <T> void addLinkToMap(Link link, T key, Map<T, Collection<Link>> map, Integer at) {
	if (key instanceof ObjectAndRemoteAssociationEnd) {
	    if (((ObjectAndRemoteAssociationEnd)key).getObject() instanceof EntityObject) {
		EntityObject e = (EntityObject) ((ObjectAndRemoteAssociationEnd)key).getObject();
		if (e.getOrigin() != null) {
		    assert link.getOrigin() == null || link.getOrigin().equals(e.getOrigin());
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
    
    public <T> void removeLinkFromMap(Link link, T key, Map<T, Collection<Link>> map, Integer at) {
	Collection<Link> set = map.get(key);
	if (set != null) {
	    if (at != null && at >= 0 && set instanceof List) {
		((List<Link>) set).remove(at);
	    } else {
		set.remove(link);
	    }
	}
    }
    
    /**
     * @param key For type {@link ObjectAndRemoteAssociationEnd}, the resulting collection
     * is created based on the orderedness of the respective
     * {@link ObjectAndRemoteAssociationEnd#getRemoteAssociationEnd() association end}.
     * For type {@link Association}, the collection type is used based on orderedness
     * and uniqueness of the ends: if at least one end is orderer, an ordered collection
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
    
    public Map<Association,  Collection<Link>> getLinksForAssociation() {
        return linksForAssociation;
    }

    Side getSideOfEnd(AssociationEnd end) {
        if (end.getAssociation().getEnds().get(Side.LEFT.endNumber()).equals(end)) {
            return Side.LEFT;
        } else {
            return Side.RIGHT;
        }
    }

}
