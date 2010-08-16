package com.sap.runlet.abstractinterpreter;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;

import com.sap.runlet.abstractinterpreter.objects.EntityObject;
import com.sap.runlet.abstractinterpreter.objects.Link;
import com.sap.runlet.abstractinterpreter.repository.ChangeSet;
import com.sap.runlet.abstractinterpreter.repository.ChangeSetImpl;
import com.sap.runlet.abstractinterpreter.repository.EntityCreation;
import com.sap.runlet.abstractinterpreter.repository.EntityDeletion;
import com.sap.runlet.abstractinterpreter.repository.MutableChangeSet;
import com.sap.runlet.abstractinterpreter.repository.Repository;
import com.sap.runlet.abstractinterpreter.repository.RepositoryChange;
import com.sap.runlet.abstractinterpreter.repository.RepositoryObject;
import com.sap.runlet.abstractinterpreter.repository.Snapshot;
import com.sap.runlet.abstractinterpreter.repository.SnapshotIdentifier;
import com.sap.runlet.abstractinterpreter.util.ModelAdapter;

/**
 * A transaction buffer is a change set, thus keeping track of object and link creations and
 * deletions and additionally maintains a {@link Snapshot} to which the changes can be applied. It
 * starts out with a <tt>null</tt> snapshot, meaning the changes may be applied to any snapshot.
 * As soon as a change is announced to this transaction buffer where the entity/link affected by the
 * change pertains to a specific snapshot (and not <tt>null</tt>), this will set this buffer's
 * snapshot. If this buffer's snapshot is already set to a non-<tt>null</tt> one, only changes
 * to entities/links with a <tt>null</tt> snapshot or the same snapshot as that of this buffer
 * can be accounced. Changes based on different snapshots will lead to an assertion error.
 * 
 * FIXME: not Thread safe
 * 
 * @author D046040
 * @author Axel Uhl (D043530)
 * 
 */
public class TransactionBuffer<LinkMetaObject extends EObject, LinkEndMetaObject extends EObject,
MetaClass extends EObject, TypeUsage extends EObject, ClassUsage extends TypeUsage>
implements ChangeSet<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> {

    /**
     * Identifies the snapshot from which the {@link RepositoryObjetc}s that are deleted and
     * created by the changes maintained by this buffer originate. If the buffer only contains
     * creations, this identifier may not yet be bound to a particular {@link Snapshot}. In this
     * case the identifier may be bound during the {@link #commit(Repository)} call. Otherwise,
     * when committing, a successor of the snapshot to which this identifier is bound will be
     * created. The {@link #commit(Repository)} method will then update this tag so that it
     * points to the snapshot produced by the commit. If the snapshot produced by the commit
     * is a direct successor of the snapshot identified by this tag before the commit, or if
     * this identifier was not yet bound to a particular snapshot, all instances in memory
     * are considered still to be consistent after the tag has moved to the successor snapshot.<p>
     * 
     * If during the {@link #commit(Repository)} call the tag moves to a non-direct successor,
     * this means that an auto-merge has taken place which potentially invalidates
     * {@link RepositoryObject}s that are marked with this identifier. The {@link ChangeSet}s
     * in between are then analyzed at the end of {@link #commit(Repository)} and lead to
     * the necessary invalidations of in-memory content.
     */
    private SnapshotIdentifier updatingTag;
    
    private MutableChangeSet<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> changeSet;

    private final ModelAdapter<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> modelAdapter;

    public TransactionBuffer(ModelAdapter<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> modelAdapter) {
	this.modelAdapter = modelAdapter;
	changeSet = new ChangeSetImpl<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(modelAdapter);
    }

    private ModelAdapter<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> getModelAdapter() {
        return modelAdapter;
    }

    /**
     * Records the entity for creation in the persistent repository and sets its
     * {@link RepositoryObject#setOrigin(SnapshotIdentifier) snapshot identifier} to
     * {@link #getUpdatingTag()} which will be initialized to the <tt>defaultSnapshot</tt> if
     * <tt>null</tt> at the beginning of this call.
     * @param at for ordered associations, specify the position at which the link was added
     */
    public void entityCreated(EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> entity) {
	makePersistent(entity);
	changeSet.entityCreated(entity);
    }

    private void makePersistent(RepositoryObject linkOrEntity) {
	if (!linkOrEntity.isPersistent()) {
	    validateAndUpdateBaseSnapshot(linkOrEntity);
	    linkOrEntity.setPersistent(true);
	}
    }

    /**
     * Records the link for creation in the persistent repository and sets its
     * {@link RepositoryObject#setOrigin(SnapshotIdentifier) snapshot identifier} to
     * {@link #getUpdatingTag()} which will be initialized to the <tt>defaultSnapshot</tt> if
     * <tt>null</tt> at the beginning of this call.
     * 
     * @param at for ordered associations, specify the position at which the link was added.
     * <tt>null</tt> or <tt>-1</tt> are not allowed if <tt>link.isOrdered()</tt>. The real
     * insert position must be specified instead which then equals the size of the ordered
     * collection holding the links when viewed from the unordered end.
     */
    public void linkCreated(Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> link, Integer at) {
	makePersistent(link);
	changeSet.linkCreated(link, at);
    }

    /**
     * Records the entity for deletion and sets its
     * {@link RepositoryObject#setOrigin(SnapshotIdentifier) snapshot identifier} to <tt>null</tt>.
     */
    public void entityDeleted(EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> entity) {
	makeTransient(entity);
	changeSet.entityDeleted(entity);
    }

    /**
     * Records the link for deletion and sets its
     * {@link RepositoryObject#setOrigin(SnapshotIdentifier) snapshot identifier} to <tt>null</tt>.
     * @param at for links of ordered associations, specify the position from which the link was deleted
     */
    public void linkDeleted(Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> link, Integer at) {
	makeTransient(link);
	changeSet.linkDeleted(link, at);
    }

    private void makeTransient(final RepositoryObject entityOrLink) {
	if (entityOrLink.isPersistent()) {
	    validateAndUpdateBaseSnapshot(entityOrLink);
	    entityOrLink.setPersistent(false);
	}
    }

    /**
     * Should this buffer's {@link #getUpdatingTag()} be <tt>null</tt>, it will be initialized to
     * the <tt>object</tt>'s {@link RepositoryObject#getOrigin() snapshot identifier}. The
     * <tt>object</tt>'s snapshot identifier has to match with this buffer's
     * {@link #getUpdatingTag()} after the initialization described above. If it does not, an
     * exception is thrown.
     */
    public void validateAndUpdateBaseSnapshot(RepositoryObject object) {
	if (getUpdatingTag() == null) {
	    setUpdatingTag(object.getOrigin());
	}
	assert object.getOrigin().equals(getUpdatingTag());
    }

    /**
     * Commits open changes to the {@link Repository}. Returns <code>null</code> if no open changes exist.
     * 
     * @param repository
     *            the storage component into which to commit the changes in the current {@link #changeSet}.
     *            See also {@link Repository#apply(ChangeSet, SnapshotIdentifier)}
     * @return the snapshot created by committing the change set
     */
    public Snapshot commit(Repository<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> repository) {
	Snapshot result = null;
	if (!changeSet.isEmpty()) {
	    result = repository.apply(changeSet, getUpdatingTag());
	    changeSet = new ChangeSetImpl<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(getModelAdapter());
	    getUpdatingTag().unresolve(); // "unresolve" snapshot identifier to let it resolve
					  // itself again next time around
	    setUpdatingTag(null);
	} 
	return result;
    }

    public SnapshotIdentifier getUpdatingTag() {
        return updatingTag;
    }

    public void setUpdatingTag(SnapshotIdentifier updatingTag) {
        this.updatingTag = updatingTag;
    }

    @Override
    public boolean conflictsWith(ChangeSet<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> other) {
	return changeSet.conflictsWith(other);
    }

    @Override
    public Iterator<RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> getChanges() {
	return changeSet.getChanges();
    }

    @Override
    public boolean isEmpty() {
	return changeSet.isEmpty();
    }

    /**
     * Undoes all changes recorded in this buffer by making those objects/links that were recorded
     * as persistent/created as transient again by clearing their
     * {@link RepositoryObject#setOrigin(SnapshotIdentifier) origin snapshot} and for those
     * objects/link that were recorded as deleted, re-establish them as persistent objects
     * by setting their {@link RepositoryObject#setOrigin(SnapshotIdentifier) original snapshot}
     * back to the identifier that this transaction buffer has as its {@link #getUpdatingTag()}.
     * Finally, all records in this transaction buffer are cleared, asserting {@link #isEmpty()}.
     */
    public void rollback() {
	for (Iterator<RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> i = getChanges(); i.hasNext(); ) {
	    RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> eo = i.next();
	    if (eo.isCreate()) {
		eo.getObject().setPersistent(false);
	    } else {
		eo.getObject().setPersistent(true);
	    }
	}
	changeSet.clear();
    }

    @Override
    public Iterator<EntityCreation<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> getEntityCreations() {
	return changeSet.getEntityCreations();
    }

    @Override
    public Iterator<EntityDeletion<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> getEntityDeletions() {
	return changeSet.getEntityDeletions();
    }

    //FIXME: delete!!!
    public ChangeSetImpl<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> getChangeSetImpl() {
	return (ChangeSetImpl<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) changeSet;
    }

    @Override
    public Iterator<RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> iterator() {
	return changeSet.iterator();
    }

    @Override
    public int totalSize() {
	return changeSet.totalSize();
    }

}
