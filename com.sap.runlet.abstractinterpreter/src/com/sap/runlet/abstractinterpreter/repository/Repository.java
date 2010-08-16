package com.sap.runlet.abstractinterpreter.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import com.sap.runlet.abstractinterpreter.objects.ClassTypedObject;
import com.sap.runlet.abstractinterpreter.objects.EntityObject;
import com.sap.runlet.abstractinterpreter.objects.Link;

/**
 * <h2>Overview</h2>
 * 
 * Represents a durable, persistent and fully versioned repository of objects, values and links.
 * Entity objects can be saved ("committed") to this repository. According to a strategy explained
 * below, the links and a subset of the linked objects will be saved to the repository, too. Values
 * are only saved as per saving an entity or by saving a link between two values which may happen
 * independently of saving an entity.
 * <p>
 * 
 * The repository manages a persistent <em>extent</em> for each
 * {@link SapClass#isValueType() entity class}, and it manages a persistent extent for each
 * {@link Association association}. Entity objects and links can therefore be added to or removed
 * from their respective extent. The most simple form of query is that of retrieving an entire
 * extent of either a class of an association. The next simple query is that of navigating from one
 * object or a set of objects across the links stored in a certain association extent. Values are
 * part of the ends of the links referring to them. Their classes don't have extents of their own,
 * and a value does not have a life cycle of its own. It conceptually always exists.
 * <p>
 * 
 * It is possible to determine the existence of an entity in the repository. This can, e.g., be
 * useful to find out if the entity has been deleted from the repository or if it hasn't been stored
 * yet.
 * <p>
 * 
 * The strategy for saving an entity to the repository will be that it, all its direct and
 * transitive composite children as well as all links attaching to any of these objects, and all
 * value objects associated with any of these objects that are relevant for the saved objects'
 * equality will be saved into the repository together with the entity. As a result, entities that
 * used to be composite children but that are no longer are considered deleted unless they are
 * explicitly saved again (which may happen in the same call because multiple entities can be passed
 * and saved at once). The same deletion strategy applies for all links: links that used to be
 * attached to any of the objects written by the save and that are no longer attached are considered
 * deleted. In other words: the composition tree with all inner and external links is considered
 * authoritative regarding both the existence of composed entities as well as the existence of links
 * within and attached to the composition tree.
 * <p>
 * 
 * It is possible to <em>delete</em> an entity. If the entity had a composite parent, the result
 * is the same as if the link to the composite parent had been deleted and the composite parent then
 * had been saved. This, according to the strategy defined above, would also delete the entity
 * together with all entities contained by it as well as all links attached to any entity within
 * this composition subtree. However, if the entity to be deleted does not have a composite parent
 * or it is impractical or infeasible for some reason to save the parent, an explicit delete can be
 * performed on an entity with the same effect: it, all its composite children and all links
 * attaching to thie composition tree will be deleted.
 * <p>
 * 
 * <h2>Versioning and Snapshots</h2>
 * 
 * A repository maintains state as a set of <em>snapshots</em> (versions). At any one time, the
 * repository identifies one snapshot as the <em>current default snapshot</em>. Whenever the
 * repository is read without specifying a particular snapshot, this will be the snapshot based on
 * whose contents the read will be satisfied. Access to the repository may also query the repository
 * state as it was at a certain snapshot different from the current default snapshot. Imagine the
 * entire set-up as a versioning repository where a <tt>commit</tt> produces a new snapshot that
 * gets a unique snapshot ID, such as, e.g., in the <a
 * href="http://subversion.tigris.org/design.html#server.fs.struct.bubble-up">Subversion (SVN)</a>
 * versioning system and similar to the <a
 * href="http://eagain.net/articles/git-for-computer-scientists/">git</a> versioning system.
 * <p>
 * 
 * Whenever a change is committed to the repository, it creates a new, unique snapshot (or
 * repository revision) (see {@link Snapshot}. This means in particular that deleting an object or
 * a link does not alter previous snapshots where those will continue to exist. The repository
 * can tell the contents of all the extents it manages at each of the snapshots it ever committed.
 * (An exception to this rule may be the forced physical deletion of data as, e.g., for legal or
 * security reasons. Special permissions and auditing should be required for this operation.) The
 * difference between any two snapshots is called a {@link ChangeSet} and can be determined by the
 * repository from any pair of snapshots. Vice versa, it is possible to create a new snapshot given
 * an existing snapshot and a {@link ChangeSet} that describes the changes transitioning from the
 * existing snapshot to the new one.
 * <p>
 * 
 * <h2>Future extensions</h2>
 * 
 * <ul>
 * 
 * <li>Changes can be based on data coming from existing snapshots. In order to avoid
 * harmful "last writer wins" type of conflicts, snapshots should know their predecessors,
 * and a snapshot should not be promoted to the current default snapshot if the current default
 * snapshot so far is already a successor of the predecessors of the new snapshot that contains
 * conflicting changes. For this, we need a definition of what is a conflict between two
 * {@link ChangeSet}s, and we need a notion of "predecessor" on {@link Snapshot}s.</li>
 * 
 * <li>The repository shall support queries by value and association which will result in a set of
 * entities that are associated with the given value through the association given. For example,
 * this will allow querying persons by name.</li>
 * 
 * </ul>
 * 
 * @author Axel Uhl (D043530)
 * 
 */
public interface Repository<LinkMetaObject extends EObject, LinkEndMetaObject extends EObject, MetaClass extends EObject,
TypeUsage extends EObject, ClassUsage extends TypeUsage> {
    /**
     * @return the "current" or "default" snapshot available at the time of calling. If no means of
     *         locking or synchronization are available or used, it may of course happen that
     *         between asking this snapshot and reading from this snapshot a newer snapshot that
     *         {@link Snapshot#succeeds(Snapshot) succeeds} the snapshot returned may have been
     *         committed to this repository. To avoid this, use snapshot-less access signatures
     *         which will default to using the latest snapshot available at that time.
     */
    Snapshot getCurrent();
    
    /**
     * @return a "tag" for the trunk of this repository, not yet resolved; when the snapshot
     *         identifier returned is {@link #resolve resolved}, it points to the snapshot returned
     *         by {@link #getCurrent} at the point in time of calling {@link #resolve}. Of course,
     *         subsequent calls to {@link #apply} can progress {@link #getCurrent} while the tag
     *         returned by this method still points to a previous
     */
    SnapshotIdentifier getTrunkIdentifier();

    /**
     * Fetches all links stored in this repository at the {@link #getCurrent() current snapshot}
     * that are instance of the <tt>association</tt>. More formally, those links are all
     * guaranteed to have {@link Link#getAssociation()} <tt>== association</tt>.
     * <p>
     * 
     * TODO make some guarantees about the ordering in case the association has an ordered end<p>
     * 
     * @param fromSnapshot
     *                a non-<tt>null</tt> object; read from the snapshot specified; in case the
     *                {@link SnapshotIdentifier#getSnapshot()} returns <tt>null</tt>, the
     *                identifier is {@link #resolve(SnapshotIdentifier) resolved} first.
     * @return all links stored in the snapshot identified by <tt>fromSnapshot</tt> that
     *         are instance of <tt>association</tt>. The links returned will as their
     *         {@link RepositoryObject#getOrigin() snapshot} have <tt>fromSnapshot</tt>.
     */
    Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> allLinks(LinkMetaObject association, SnapshotIdentifier fromSnapshot);

    /**
     * Returns all entities that at the snapshot determined by <tt>fromSnapshot</tt> are stored in
     * this repository and that are instance of class <tt>clazz</tt>. More formally, for all
     * objects <tt>o</tt> returned, <tt>o.getType().getClazz() == clazz</tt> holds. If
     * <tt>fromSnapshot</tt> names a <tt>null</tt> snapshot, the identifier is
     * {@link #resolve(SnapshotIdentifier) resolved} to bind it to a valid {@link Snapshot}.
     * 
     * @param clazz
     *                expected to have {@link SapClass#isValueType()}<tt>==false</tt>.
     * @param fromSnapshot
     *                a non-<tt>null</tt> object; read from the snapshot specified or
     *                {@link #resolve(SnapshotIdentifier) resolve} in case the
     *                {@link SnapshotIdentifier#getSnapshot()} returns <tt>null</tt>, then read
     *                from that snapshot
     * @return all entity objects stored in the snapshot identified by <tt>fromSnapshot</tt> that
     *         are instance of <tt>clazz</tt>. The objects returned will as their
     *         {@link RepositoryObject#getOrigin() snapshot} have <tt>fromSnapshot</tt>. This
     *         call always returns a non-<tt>null</tt> collection which may be empty if no
     *         objects of the class requested are found in the snapshot identified by
     *         <tt>fromSnapshot</tt or if that snapshot is not found.
     */
    Collection<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> all(MetaClass clazz, SnapshotIdentifier fromSnapshot);

    /**
     * Tells if this repository knows the <tt>snapshot</tt>. Return <tt>true</tt> if the
     * <tt>snapshot</tt> equals one that has been returned by a call to
     * {@link #commit(Collection, RiverInterpreter)} on this repository.
     */
    boolean has(Snapshot snapshot);
    
    /**
     * Tells if snapshot <tt>a</tt> is a direct or indirect predecessor of snapshot <tt>b</tt>.
     * The relation implemented by this method is not reflexive, meaning that
     * <tt>precedes(s, s)</tt> always returns <tt>false</tt>. There may be uncomparable
     * snapshots where none is predecessor of the other.
     */
    boolean precedes(Snapshot a, Snapshot b);
    
    /**
     * Tests if the two snapshots are equal. Snapshots are equal iff 
     * they have the same set of {@link EntityObject}s and {@link Link}s.
     * identity.
     * @param s1
     * @param s2
     * @return <code>true</code> iff the s1 and s2 are equal, <code>false</code> otherwise.
     */
    boolean testSnapshotEquality(Snapshot s1, Snapshot s2);
    
    /**
     * Determines those snapshots held by this repository that are immediate predecessors of
     * <tt>snapshot</tt>. If no such snapshot exists, an empty collection is returned.
     */
    Set<Snapshot> getImmediatePredecessors(Snapshot snapshot);
    
    /**
     * Tells if snapshot <tt>a</tt> is a <em>direct</em> predecessor of <tt>b</tt>. If this
     * is the case, no other snapshot <tt>c</tt> exists in this repository for which
     * <tt>precedes(a, c) and precedes(c, b)</tt> holds.
     */
    boolean directlyPrecedes(Snapshot a, Snapshot b);

    /**
     * Creates a new snapshot by applying a changeset. No implicit completions and navigations take
     * place. All additions and deletions have to be specified by the caller. In particular all
     * composite children of an entity that were created or deleted need to be passed in
     * <tt>entities</tt> or <tt>deletedEntities</tt>, respectively.
     * <p>
     * 
     * All other data will remain as would be returned by a query to the snapshot identified by
     * <tt>applyTo</tt>.<p>
     * 
     * Callers should be aware that <tt>applyTo</tt> may be a tag that, when resolved again after
     * this method returns, resolves to the snapshot returned by this method. If the snapshot
     * returned by this method is not an {@link #directlyPrecedes(Snapshot, Snapshot) immediate successor}
     * of the snapshot <tt>applyTo</tt> was bound to at the time of this call, other change sets
     * might have been merged in between, and the in-memory contents pertinent to the
     * <tt>applyTo</tt> identifier may be invalid now.
     * 
     * @param applyTo
     *                a non-<tt>null</tt> object that identifies the snapshot to which to apply
     *                the changeset. If {@link SnapshotIdentifier#getSnapshot()} returns <tt>null</tt>,
     *                the identifier is {@link #resolve(SnapshotIdentifier) resolved} first.
     * 
     * @return the snapshot created by applying the change set. May---depending on <tt>applyTo</tt>'s
     *         type---be the same as the one identified by <tt>applyTo</tt>, either if the
     *         <tt>changeset</tt> was {@link ChangeSet#isEmpty() empty} and therefore no
     *         new snapshot was produced at all, or because <tt>applyTo</tt> identifies the head
     *         of the trunk or some branch and therefore automatically moves to the new snapshot
     *         if {@link #resolve(SnapshotIdentifier) resolved} again.
     */
    Snapshot apply(ChangeSet<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> changeset, SnapshotIdentifier applyTo);
    
    /**
     * Computes the common ancestor of the two snapshots and then merges the changes performed
     * on the branch that led from the common ancestor to the <tt>fromBranch</tt> snapshot into
     * the trunk. This will produce a new successor snapshot that has two predecessors,
     * <tt>fromBranch</tt> and <tt>intoTrunk</tt>.
     */
    Snapshot merge(Snapshot fromBranch, Snapshot intoTrunk);

    /**
     * Looks up all links from <tt>from</tt> towards the association end identified by
     * <tt>otherEnd</tt> within {@link ClassTypedObject#getOrigin() from's snapshot}. All links
     * returned have <tt>from</tt> on the end opposite of <tt>otherEnd</tt>. The collection
     * returned is always non-<tt>null</tt>.
     * 
     * @param from
     *                expected to have a non-<tt>null</tt>
     *                {@link RepositoryObject#getOrigin() snapshot identifier}. The contents of the
     *                snapshot identified by it is used to compute the navigation results.
     * @return a non-null but possibly empty link collection; those are all links in <tt>from</tt>'s
     *         snapshot for which <tt>from</tt> is on end <tt>otherEnd.otherEnd()</tt>. The
     *         links returned will all have the same snapshot identifier as <tt>from</tt>.
     */
    Collection<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> loadLinks(
	    ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> from,
	    LinkEndMetaObject otherEnd);
    
    /**
     * Binds the snapshot identifier to a particular snapshot. Afterwards,
     * {@link SnapshotIdentifier#getSnapshot()} on the <tt>tag</tt> returns the snapshot to which
     * the identifier has been bound by this call.<p>
     */
    void resolve(SnapshotIdentifier tag);

    /**
     * Determines a maximal set of snapshots such that for each of them there is no successor
     * in this repository that has a {@link Snapshot#when() timestamp} before
     * <tt>fromLastConcurrentSnapshotsBefore</tt>.
     */
    Set<SnapshotIdentifier> getLastSnapshotsBeforeOrAt(Date fromLastConcurrentSnapshotsBefore);
    
    /**
     * Determines a snapshot <tt>s</tt> such that for all <tt>t</tt> from <tt>snapshots</tt>
     * the condition <tt>this.precedes(s, t) || s.equals(t)</tt> holds. In particular, if the
     * <tt>snapshots</tt> set contains only one snapshot, that snapshot will be used as <tt>s</tt>.
     * If the elements in <tt>snapshots</tt> are in a predecessor relation with each other,
     * the "first" of them (according to the {@link #precedes} relation) is used as <tt>s</tt>.
     * The method returns the paths from <tt>s</tt> to the respective elements from <tt>snapshots</tt>
     * or <tt>null</tt> if no common ancestor snapshot <tt>s</tt> can be found.
     * 
     * @param snapshots a non-<tt>null</tt> but possibly empty set of snapshots
     */
    List<List<Snapshot>> getPathsFromLastCommonAncestor(Snapshot... snapshots);

    /**
     * Returns the set of all known snapshots.
     * @return Set of all known {@link Snapshot} instances.
     */
    Set<Snapshot> getAllSnapshots();

    Snapshot resolveTag(Tag tag);

    Snapshot resolveLastBeforeDateOnBranch(Date timestamp, Tag branchIdentifier);

}
