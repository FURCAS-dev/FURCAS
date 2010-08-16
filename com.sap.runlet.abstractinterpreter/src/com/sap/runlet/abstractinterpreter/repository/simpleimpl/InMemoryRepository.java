package com.sap.runlet.abstractinterpreter.repository.simpleimpl;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

import org.eclipse.emf.ecore.EObject;

import com.sap.runlet.abstractinterpreter.objects.AbstractValueObject;
import com.sap.runlet.abstractinterpreter.objects.ClassTypedObject;
import com.sap.runlet.abstractinterpreter.objects.EntityObject;
import com.sap.runlet.abstractinterpreter.objects.Link;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.abstractinterpreter.operationaltransformation.Change;
import com.sap.runlet.abstractinterpreter.operationaltransformation.ChangeList;
import com.sap.runlet.abstractinterpreter.operationaltransformation.EmptyChange;
import com.sap.runlet.abstractinterpreter.operationaltransformation.Transformer;
import com.sap.runlet.abstractinterpreter.repository.AbstractSnapshotIdentifier;
import com.sap.runlet.abstractinterpreter.repository.ChangeSet;
import com.sap.runlet.abstractinterpreter.repository.ChangeSetImpl;
import com.sap.runlet.abstractinterpreter.repository.FixedSnapshot;
import com.sap.runlet.abstractinterpreter.repository.Repository;
import com.sap.runlet.abstractinterpreter.repository.RepositoryChange;
import com.sap.runlet.abstractinterpreter.repository.RepositoryObject;
import com.sap.runlet.abstractinterpreter.repository.Snapshot;
import com.sap.runlet.abstractinterpreter.repository.SnapshotIdentifier;
import com.sap.runlet.abstractinterpreter.repository.SnapshotImpl;
import com.sap.runlet.abstractinterpreter.repository.Tag;
import com.sap.runlet.abstractinterpreter.util.ModelAdapter;
import com.sap.runlet.abstractinterpreter.util.Tuple.Pair;



public class InMemoryRepository<LinkMetaObject extends EObject,
LinkEndMetaObject extends EObject,
MetaClass extends EObject,
TypeUsage extends EObject,
ClassUsage extends TypeUsage> implements Repository<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>{
    private Map<Snapshot, SimpleLinkContainerImpl<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> linkContainers;
    private Map<Snapshot, Set<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>> entities;
    private Map<Snapshot, Map<MetaClass, Set<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>>> entitiesByClass;
    
    /**
     * Holds all snapshots of this repository that don't have a successor.<p>
     * 
     * <b>Invariant:</b> <tt>tipsOfBranches.contains(current)</tt>
     */
    private Set<Snapshot> tipsOfBranches;
    
    /**
     * Keeps track of what the predecessors of each snapshot are. This data
     * is used to answer any topology query about snapshots.
     * 
     * @see #precedes(Snapshot, Snapshot)
     * @see #getTopology(Snapshot, Snapshot)
     */
    private Map<Snapshot, Set<Snapshot>> predecessors;
    
    /**
     * Keeps track of the changes that connect predecessor snapshots with their
     * successors. For any snapshot <tt>predecessor</tt> that appears in a value set in
     * {@link #predecessors} for key <tt>successor</tt>, an entry with key
     * <tt>new Pair(predecessor, successor)</tt> exists in this map such that the
     * value for this pair is the change set that transforms the <tt>predecessor</tt>
     * snapshot into the <tt>successor</tt> snapshot.
     */
    protected Map<Pair<Snapshot, Snapshot>, ChangeSet<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> changes;
    
    private SnapshotIdentifier trunk = new Tag("HEAD of TRUNK");
    
    /**
     * The current snapshot 
     */
    private Snapshot current;
    
    private final ModelAdapter<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> modelAdapter;
    
    public InMemoryRepository(ModelAdapter<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> modelAdapter) {
	this.modelAdapter = modelAdapter;
	linkContainers = new HashMap<Snapshot, SimpleLinkContainerImpl<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>();
	entities = new HashMap<Snapshot, Set<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>>();
	entitiesByClass = new HashMap<Snapshot, Map<MetaClass, Set<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>>>();
	tipsOfBranches = new HashSet<Snapshot>();
	predecessors = new HashMap<Snapshot, Set<Snapshot>>();
	changes = new HashMap<Pair<Snapshot, Snapshot>, ChangeSet<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>();
	current = addEmptySnapshot();
    }

    protected ModelAdapter<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> getModelAdapter() {
        return modelAdapter;
    }

    /**
     * Returns a collection that equals the collection passed, except that all
     * {@link RepositoryObject}s contained have their snapshot
     * {@link RepositoryObject#getCopyWithOrigin(SnapshotIdentifier) adjusted} to
     * <tt>toSnapshot</tt>.
     */
    @SuppressWarnings("unchecked")
    private <T extends RepositoryObject> Collection<T> adjustSnapshot(Collection<T> collection,
	    SnapshotIdentifier toSnapshot) {
	// The assumption that the collection class has a default constructor is a bit risky...
	// If anyone knows a better way, please fix this.
	try {
	    Collection<T> result;
	    if (collection.size() == 0) {
		result = Collections.emptyList();
	    } else {
		result = collection.getClass().newInstance();
		for (T ro : collection) {
		    result.add((T) ro.getCopyWithOrigin(toSnapshot));
		}
	    }
	    return result;
	} catch (Exception e) {
	    throw new RuntimeException("Collection class "+collection.getClass().getName()+
		    " does not have a default constructor; can't clone", e);
	}
    }
    
    private Snapshot addEmptySnapshot() {
	Snapshot result = new SnapshotImpl();
	addSnapshot(result, /* predecessor */ null, null,
		new SimpleLinkContainerImpl<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(getModelAdapter()),
		new HashSet<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>(),
		new HashMap<MetaClass, Set<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>>());
	return result;
    }

    @Override
    public Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> allLinks(LinkMetaObject association, SnapshotIdentifier fromSnapshot) {
	/** check invariants */
	assert association != null && fromSnapshot != null;
	resolveIfNotBound(fromSnapshot);
	assert has(fromSnapshot.getSnapshot());
	return adjustSnapshot(getLinkContainers().get(fromSnapshot.getSnapshot()).all(association), fromSnapshot);
    }

    @Override
    public Collection<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> all(MetaClass clazz, SnapshotIdentifier fromSnapshot) {
	Collection<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> result;
	/** check invariants */
	assert clazz != null && fromSnapshot != null;
	// TODO contemplate resolving to multiple snapshots and returning instances from all of them
	resolveIfNotBound(fromSnapshot);
	assert has(fromSnapshot.getSnapshot());
	Map<MetaClass, Set<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>> entitiesByClassFromSnapshot = getEntitiesByClass().get(fromSnapshot.getSnapshot());
	if (entitiesByClassFromSnapshot != null) {
	    Set<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> allEntitiesFromSnapshot = entitiesByClassFromSnapshot.get(clazz);
	    if (allEntitiesFromSnapshot != null) {
		result = adjustSnapshot(allEntitiesFromSnapshot, fromSnapshot);
	    } else {
		result = Collections.emptySet();
	    }
	} else {
	    result = Collections.emptySet();
	}
	return result;
    }

    @Override
    public Snapshot getCurrent() {
	return current;
    }
    
    private void setCurrent(Snapshot newHeadOfTrunk) {
	Snapshot oldCurrent = getCurrent();
	if (oldCurrent != null) {
	    tipsOfBranches.remove(oldCurrent);
	}
	current = newHeadOfTrunk;
	tipsOfBranches.add(newHeadOfTrunk);
    }

    @Override
    public boolean has(Snapshot snapshot) {
	/** check invariants */
	assert snapshot != null;
	return getSnapshots().contains(snapshot);
    }

    @Override
    public Snapshot apply(ChangeSet<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> changeset, SnapshotIdentifier applyTo) {
	/** check invariants */
	assert changeset != null && applyTo != null;
	resolveIfNotBound(applyTo);
	assert applyTo.getSnapshot() != null;
	assert getSnapshots().contains(applyTo.getSnapshot());

	Snapshot result = new SnapshotImpl();
	SimpleLinkContainerImpl<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> snapshotLinkContainer = getLinkContainers().get(applyTo.getSnapshot()).clone();
	Set<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> snapshotEntities = new HashSet<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>();
	for (EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> eo : getEntities().get(applyTo.getSnapshot())) {
	    snapshotEntities.add(eo.clone());
	}

	for (Iterator<RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> i = changeset.getChanges(); i.hasNext(); ) {
	    RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> change = i.next();
	    change.apply(snapshotEntities, snapshotLinkContainer);
	}
	Map<MetaClass, Set<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>> snapshotEntitiesByClass = new HashMap<MetaClass, Set<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>>();
	for (EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> eo:snapshotEntities) {
	    Set<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> set = snapshotEntitiesByClass.get(
		    getModelAdapter().getClazz(eo.getType()));
	    if (set == null) {
		set = new HashSet<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>();
		snapshotEntitiesByClass.put(getModelAdapter().getClazz(eo.getType()), set);
	    }
	    set.add(eo);
	}
	addSnapshot(result, applyTo, changeset, snapshotLinkContainer,
		snapshotEntities, snapshotEntitiesByClass);
	
	/** check post conditions */
	assert has(result);
	return result;
    }

    private void addSnapshot(Snapshot snapshot, SnapshotIdentifier predecessor,
	    ChangeSet<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> changesFromPredecessor,
	    SimpleLinkContainerImpl<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> snapshotLinkContainer,
	    Set<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> snapshotEntities,
	    Map<MetaClass, Set<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>> snapshotEntitiesByClass) {
	HashSet<Snapshot> preds = new HashSet<Snapshot>();
	if (predecessor != null) {
	    resolveIfNotBound(predecessor);
	    if (predecessor.getSnapshot().equals(getCurrent())) {
		// successor of previous current becomes current
		setCurrent(snapshot);
	    }
	    if (predecessor.getSnapshot() != null) {
		preds.add(predecessor.getSnapshot());
		changes.put(new Pair<Snapshot, Snapshot>(predecessor.getSnapshot(), snapshot), changesFromPredecessor);
		tipsOfBranches.remove(predecessor.getSnapshot());
	    }
	}
	getLinkContainers().put(snapshot, snapshotLinkContainer);
	getEntities().put(snapshot, Collections.unmodifiableSet(snapshotEntities));
	getEntitiesByClass().put(snapshot, Collections.unmodifiableMap(snapshotEntitiesByClass));
	predecessors.put(snapshot, preds);
	tipsOfBranches.add(snapshot);
    }

    private void resolveIfNotBound(SnapshotIdentifier snapshotIdentifier) {
	if (snapshotIdentifier.getSnapshot() == null) {
	    resolve(snapshotIdentifier);
	}
    }

    private Map<Snapshot, SimpleLinkContainerImpl<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> getLinkContainers() {
        return linkContainers;
    }

    private Map<Snapshot, Set<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>> getEntities() {
        return entities;
    }

    private Map<Snapshot, Map<MetaClass, Set<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>>> getEntitiesByClass() {
        return entitiesByClass;
    }

    private Set<Snapshot> getSnapshots() {
	return getEntities().keySet();
    }

    @Override
    public Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> loadLinks(ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> from, LinkEndMetaObject otherEnd) {
	assert (from instanceof AbstractValueObject<?, ?, ?, ?, ?>) || from.isPersistent();
	SnapshotIdentifier si = from.getOrigin();
	resolveIfNotBound(si);
	assert has(si.getSnapshot());
	SimpleLinkContainerImpl<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> lc = getLinkContainers().get(si.getSnapshot());
	return adjustSnapshot(lc.navigate(from, otherEnd), from.getOrigin());
    }

    @Override
    public boolean directlyPrecedes(Snapshot a, Snapshot b) {
	Set<Snapshot> preds = getImmediatePredecessors(b);
	return preds != null && preds.contains(a);
    }

    @Override
    public boolean precedes(Snapshot a, Snapshot b) {
	return getPath(a, b) != null;
    }
    
    /**
     * If <tt>from</tt> precedes <tt>to</tt>, a list of {@link Snapshot}s results of which the
     * first (0) element is <tt>from</tt>, the last element it <tt>to</tt> and for all <tt>i&gt0</tt>
     * the following condition holds: <tt>directlyPrecedes(result.get(i-1), result.get(i))</tt>. If
     * <tt>from</tt> is not a predecessor of <tt>to</tt>, <tt>null</tt> is returned.
     */
    protected List<Snapshot> getPath(Snapshot from, Snapshot to) {
	List<Snapshot> result = null;
	// the algorithm avoids recursion and therefore should scale also for longer paths
	Map<Snapshot, List<Snapshot>> searchBaseForAWithPath = new HashMap<Snapshot, List<Snapshot>>();
	List<Snapshot> pathForPredecessor = new LinkedList<Snapshot>();
	pathForPredecessor.add(to);
	searchBaseForAWithPath.put(to, pathForPredecessor);
	while (result == null && !searchBaseForAWithPath.isEmpty()) {
	    if (searchBaseForAWithPath.containsKey(from)) {
		result = searchBaseForAWithPath.get(from);
	    } else {
		Set<Snapshot> preds = new HashSet<Snapshot>();
		Map<Snapshot, List<Snapshot>> nextSearchBaseForAWithPath = new HashMap<Snapshot, List<Snapshot>>();
		for (Snapshot s : searchBaseForAWithPath.keySet()) {
		    Set<Snapshot> sPredecessors = predecessors.get(s);
		    if (sPredecessors != null) {
			for (Snapshot predecessor : sPredecessors) {
			    List<Snapshot> pathForSPredecessor = new LinkedList<Snapshot>(searchBaseForAWithPath.get(s));
			    pathForSPredecessor.add(0, predecessor); // prepend predecessor to path from s to "to"
			    nextSearchBaseForAWithPath.put(predecessor, pathForSPredecessor);
			}
			preds.addAll(sPredecessors);
		    }
		}
		searchBaseForAWithPath = nextSearchBaseForAWithPath;
	    }
	}
	return result;
    }

    @Override
    public void resolve(SnapshotIdentifier tag) {
	// dispatches resolution through the different implementations in AbstractSnapshotIdentifier
	// subclasses
	((AbstractSnapshotIdentifier) tag).resolve(this);
    }


    public Snapshot resolveTag(Tag tag) {
	if (trunk.equals(tag)) {
	    return getCurrent();
	} else {
	    // TODO support tags for branches other than the trunk
	    return null;
	}
    }

    public Snapshot resolveLastBeforeDateOnBranch(Date timestamp, Tag branchIdentifier) {
	Snapshot result = null;
	Set<Snapshot> candidates = new HashSet<Snapshot>();
	candidates.add(resolveTag(branchIdentifier));
	Set<SnapshotIdentifier> resultSet = getLastSnapshotsBeforeOrAt(timestamp, candidates);
	if (resultSet.size() > 0) {
	    SnapshotIdentifier si = resultSet.iterator().next();
	    resolve(si);
	    result = si.getSnapshot();
	}
	return result;
    }

    @Override
    public SnapshotIdentifier getTrunkIdentifier() {
	return trunk.clone();
    }

    @Override
    public Set<Snapshot> getImmediatePredecessors(Snapshot snapshot) {
	Set<Snapshot> preds = predecessors.get(snapshot);
	Set<Snapshot> result = new HashSet<Snapshot>();
	if (preds != null) {
	    result.addAll(preds);
	}
	return result;
    }

    @Override
    public Set<SnapshotIdentifier> getLastSnapshotsBeforeOrAt(Date fromLastConcurrentSnapshotsBefore) {
	/* Starts from the tips of all branches and works its way through the predecessors.
	   It is assumed that time descends while walking through the predecessors. On each
	   path, the first snapshot found that has a timestamp before fromLastConcurrentSnapshotsBefore
	   will be added to the result set. All its immediate and transitive predecessors will be added
	   to the inverse result set, and the descent into that path stops. Finally, when all branches
	   have been explored, the inverse result set will be subtracted from the result set so far,
	   removing any snapshots that have a successor before the date requested on another branch.
	 */
	Set<Snapshot> candidates = new HashSet<Snapshot>(tipsOfBranches);
	return getLastSnapshotsBeforeOrAt(fromLastConcurrentSnapshotsBefore, candidates);
    }

    private Set<SnapshotIdentifier> getLastSnapshotsBeforeOrAt(Date fromLastConcurrentSnapshotsBefore, Set<Snapshot> candidates) {
	Set<Snapshot> resultSnapshots = new HashSet<Snapshot>();
	Set<Snapshot> noCandidates = new HashSet<Snapshot>();
	while (!candidates.isEmpty()) {
	    Set<Snapshot> newCandidates = new HashSet<Snapshot>();
	    for (Snapshot candidate:candidates) {
		if (!noCandidates.contains(candidate)) {
		    if (candidate.when().equals(fromLastConcurrentSnapshotsBefore) ||
		        candidate.when().before(fromLastConcurrentSnapshotsBefore)) {
			// found one; don't check its predecessors anymore
			resultSnapshots.add(candidate);
			noCandidates.addAll(getAllPredecessors(candidate));
		    } else {
			noCandidates.add(candidate);
			// candidate was at or after requested date; check its predecessors, if
			// there are any
			newCandidates.addAll(getImmediatePredecessors(candidate));
		    }
		}
	    }
	    candidates.addAll(newCandidates);
	    candidates.removeAll(resultSnapshots);
	    candidates.removeAll(noCandidates);
	}
	Set<SnapshotIdentifier> result = new HashSet<SnapshotIdentifier>();
	for (Snapshot resultSnapshot:resultSnapshots) {
	    result.add(new FixedSnapshot(resultSnapshot));
	}
	return result;
    }

    private Set<Snapshot> getAllPredecessors(Snapshot snapshot) {
	Set<Snapshot> result = new HashSet<Snapshot>();
	Set<Snapshot> immediate = getImmediatePredecessors(snapshot);
	result.addAll(immediate);
	for (Snapshot immediatePredecessor:immediate) {
	    result.addAll(getAllPredecessors(immediatePredecessor));
	}
	return result;
    }

    @Override
    public Set<Snapshot> getAllSnapshots() {
	Set<Snapshot> resultSnapshots = new HashSet<Snapshot>();
	Queue<Snapshot> snapshotQueue = new LinkedBlockingQueue<Snapshot>();
	// add all tips to queue for traversal
	snapshotQueue.addAll(tipsOfBranches);
	// iterate over queue of snapshots and add them to the results if not present yet
	while (snapshotQueue.peek() != null) {
	    Snapshot snapshot2 = snapshotQueue.remove();
	    if (resultSnapshots.add(snapshot2)) {
		snapshotQueue.addAll(getImmediatePredecessors(snapshot2));
	    }
	}
	return resultSnapshots;
    }

    @Override
    public List<List<Snapshot>> getPathsFromLastCommonAncestor(Snapshot... snapshots) {
	Map<Snapshot, List<Snapshot>> result = new LinkedHashMap<Snapshot, List<Snapshot>>();
	Snapshot commonAncestor = null;
	for (Snapshot s : snapshots) {
	    // Invariant: result contains all s from snapshots traversed so far as key and
	    //            the list contained as the respective value denotes the path from
	    //            the commonAncestor to the key snapshot.
	    if (commonAncestor == null) {
		commonAncestor = s;
		List<Snapshot> pathFromCommonAncestorToS = new LinkedList<Snapshot>();
		pathFromCommonAncestorToS.add(s);
		result.put(s, pathFromCommonAncestorToS);
	    } else {
		List<Snapshot> pathFromCommonAncestorToS = getPath(commonAncestor, s);
		if (pathFromCommonAncestorToS == null) {
		    // commonAncestor is no ancestor of s; traverse through commonAncestor's
		    // ancestors until bottom is reached or an ancestor of s is found
		    Snapshot newCommonAncestor = null;
		    // the lists in the candidatesAndPath values contain the paths from the key candidates
		    // up to but excluding the commonAncestor snapshot
		    Map<Snapshot, List<Snapshot>> candidatesAndPath = new HashMap<Snapshot, List<Snapshot>>();
		    List<Snapshot> emptyList = Collections.emptyList();
		    candidatesAndPath.put(commonAncestor, emptyList);
		    List<Snapshot> pathFromNewCommonAncestorToS = null;
		    // Loop Invariant: pathFromNewCommonAncestorToS != null iff newCommonAncestor != null
		    while (newCommonAncestor == null && candidatesAndPath.size() > 0) {
			Map<Snapshot, List<Snapshot>> newCandidatesAndPath = new HashMap<Snapshot, List<Snapshot>>();
			for (Snapshot c : candidatesAndPath.keySet()) {
			    pathFromNewCommonAncestorToS = getPath(c, s); // null for the first iteration where c==commonAncestor
			    if (pathFromNewCommonAncestorToS != null) {
				newCommonAncestor = c;
				newCandidatesAndPath.put(c, candidatesAndPath.get(c));
				break;
			    } else {
				for (Snapshot immediateCandidatePredecessor : getImmediatePredecessors(c)) {
				    List<Snapshot> immediatePredecessorPath = new LinkedList<Snapshot>(
					    	candidatesAndPath.get(c));
				    immediatePredecessorPath.add(0, immediateCandidatePredecessor);
				    newCandidatesAndPath.put(immediateCandidatePredecessor, immediatePredecessorPath);
				}
			    }
			}
			candidatesAndPath = newCandidatesAndPath;
		    }
		    if (newCommonAncestor == null) {
			return null; // no common ancestor found
		    }
		    // extend all existing paths by prepending the path from the new common ancestor to the
		    // previous common ancestor (excluding the previous common ancestor because that's what
		    // the paths already start with)
		    for (Snapshot r : result.keySet()) {
			if (r != s) {
			    List<Snapshot> newPath = new LinkedList<Snapshot>(result.get(r));
			    newPath.addAll(0, candidatesAndPath.get(newCommonAncestor));
			    result.put(r, newPath); // replacement doesn't harm iterator, no modCount increase
			}
		    }
		    result.put(s, pathFromNewCommonAncestorToS);
		    commonAncestor = newCommonAncestor;
		} else {
		    result.put(s, pathFromCommonAncestorToS);
		}
	    }
	}
	return new LinkedList<List<Snapshot>>(result.values());
    }

    @Override
    public Snapshot merge(Snapshot fromBranch, Snapshot intoTrunk) {
	List<List<Snapshot>> paths = getPathsFromLastCommonAncestor(fromBranch, intoTrunk);
	if (paths == null) {
	    throw new RuntimeException("Can't merge "+fromBranch+" into "+intoTrunk+
		    " because they don't have a common ancestor");
	}
	Iterator<List<Snapshot>> pathIter = paths.iterator();
	Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> changesOnBranch = getChanges(pathIter.next());
	Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> changesOnTrunk = getChanges(pathIter.next());
	Transformer<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> t = new Transformer<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>();
	Pair<Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>, Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> mergingChanges = t.transform(changesOnBranch, changesOnTrunk);
	ChangeSet<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> mergingChangeSetForTrunk =
	    new ChangeSetImpl<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(
		mergingChanges.getB(), getModelAdapter());
	Snapshot mergeResult = apply(mergingChangeSetForTrunk, new FixedSnapshot(intoTrunk));
	predecessors.get(mergeResult).add(fromBranch); // declare merged snapshot a successor of fromBranch
	changes.put(new Pair<Snapshot, Snapshot>(fromBranch, mergeResult),
		new ChangeSetImpl<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(
		mergingChanges.getA(), getModelAdapter()));
	return mergeResult;
    }

    protected Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> getChanges(List<Snapshot> snapshotList) {
	Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> result;
	Iterator<Snapshot> iter = snapshotList.iterator();
	if (!iter.hasNext()) {
	    result = new EmptyChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>();
	} else {
	    Snapshot successor = iter.next();
	    if (!iter.hasNext()) {
		// there was only one snapshot on the path
		result = new EmptyChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>();
	    } else {
		ChangeList<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> changeList =
		    new ChangeList<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>();
		while (iter.hasNext()) {
		    Snapshot predecessor = successor;
		    successor = iter.next();
		    ChangeSet<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> changeSetBetweenPredAndSucc = changes.get(new Pair<Snapshot, Snapshot>(predecessor, successor));
		    changeList.add(changeSetBetweenPredAndSucc);
		}
		result = changeList;
	    }
	}
	return result;
    }
    
    public boolean testSnapshotEquality(Snapshot s1, Snapshot s2) {
	if (s1 == null || s2 == null) {
	    throw new IllegalArgumentException("Snapshot must not be null");
	}
	if (s1 != s2) {
	    Set<EntityObjectWrapper> es1 = new HashSet<EntityObjectWrapper>();
	    for (EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> o: entities.get(s1)) {
		es1.add(new EntityObjectWrapper(o));
	    }
	    Set<EntityObjectWrapper> es2 = new HashSet<EntityObjectWrapper>();
	    for (EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> o: entities.get(s2)) {
		es2.add(new EntityObjectWrapper(o));
	    }
	    Set<LinkWrapper> lc1 = new HashSet<LinkWrapper>();
	    for (Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> l: linkContainers.get(s1).getAllLinks()) {
		lc1.add(new LinkWrapper(l));
	    }
	    Set<LinkWrapper> lc2 = new HashSet<LinkWrapper>();
	    for (Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> l: linkContainers.get(s2).getAllLinks()) {
		lc2.add(new LinkWrapper(l));
	    }
	    // entity sets and link sets should be of same size
	    if (! ( es1.equals(es2) && lc1.equals(lc2) ) ) {
		return false;
	    }
	}
	return true;
    }
    
    private class EntityObjectWrapper {
	private EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> delegate;
	public EntityObjectWrapper(EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> o) {
	    delegate = o;
	}
	@SuppressWarnings("unchecked")
	public boolean equals(Object o) {
	    if (o instanceof EntityObject) {
		return delegate.logicallyEquals((RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>) o);
	    } else if (EntityObjectWrapper.class.isAssignableFrom(o.getClass())) {
		return delegate.logicallyEquals(((EntityObjectWrapper) o).delegate);
	    } else {
		return false;
	    }
	}
	public int hashCode() {
	    return delegate.logicalHashCode();
	}
    }
    
    private class LinkWrapper {
	private Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> delegate;
	public LinkWrapper(Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> l) {
	    delegate = l;
	}
	@Override
	public boolean equals(Object o) {
	    if (o instanceof Link<?, ?, ?, ?, ?>) {
		return delegate.logicallyEquals(o);
	    } else if (LinkWrapper.class.isAssignableFrom(o.getClass())) {
		@SuppressWarnings("unchecked")
		LinkWrapper oAsLinkWrapper = (LinkWrapper) o;
		return delegate.logicallyEquals(oAsLinkWrapper.delegate);
	    } else {
		return false;
	    }
	}
	@Override
	public int hashCode() {
	    return delegate.logicalHashCode();
	}
    }

}
