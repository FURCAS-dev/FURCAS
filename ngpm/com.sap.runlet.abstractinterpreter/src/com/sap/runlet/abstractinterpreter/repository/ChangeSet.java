package com.sap.runlet.abstractinterpreter.repository;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;

import com.sap.runlet.abstractinterpreter.operationaltransformation.Change;

/**
 * Describes a set of changes to data. This can include creation and deletion of entity objects as
 * well as creation and deletion of links, both subsumed by the {@link RepositoryObject} interface.
 * For links of an ordered association an insert / delete position must be specified.
 * <p>
 * 
 * When links or objects are announced for creation or deletion and this change set already
 * contains the inverse operation for the link/object, then instead of adding a new change
 * the inverse change will be removed from this change set. For links of an ordered association
 * this means that the positional changes of such links have to be tracked with every modification
 * that occurs "before" a link because only then the "inverse" of an operation can be
 * recognized.<p>
 * 
 * If, for example, <tt>l1</tt> and <tt>l2</tt> are links for the same ordered, non-unique association, then
 * <pre>
 *   objectCreated(l1, 0)
 *   objectCreated(l2, 0)
 *   objectCreated(l2, 1)
 *   objectCreated(l1, 1)
 *   objectDeleted(l1, 3)
 * </pre>
 * 
 * should produce the link sequence <tt>l2, l1, l2</tt> because the second occurrence in the list
 * (which was the first to be inserted) should be deleted by <tt>objectDeleted(l1, 3)</tt>. Note, that
 * in case of unique associations less effort needs to be spent tracking the positions because inserts
 * will be re-played in the order in which they occurred, and deletion can delete the only element
 * equal to the one to be deleted, regardless of its position.<p>
 * 
 * Furthermore, the order in which events occurred is preserved. This is particularly important
 * for later replay regarding the order of creations and deletions as well as the order and
 * positions at which links have been inserted to or deleted from an (ordered) association.<p>
 * 
 * If an entity is already marked as created or deleted, a second request to mark it the same
 * way is ignored. For links, redundant mark requests are ignored if the association that the link
 * instantiates has "unique" multiplicities (see {@link Multiplicity#isUnique()}). Otherwise,
 * multiple create/delete requests need to be honored because they mean to create/delete multiple
 * copies of the respective link.<p>
 * 
 * TODO What does killing inverse changes mean for representing ordering changes in link collections?<p>
 * 
 * TODO How to encode link positions and their changes in ordered associations? How does this affect
 * the conflict definition?<p>
 * 
 * @author Axel Uhl (D043530)
 * 
 */
public interface ChangeSet<LinkMetaObject extends EObject, LinkEndMetaObject extends EObject,
MetaClass extends EObject, TypeUsage extends EObject, ClassUsage extends TypeUsage>
extends Iterable<RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>,
Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> {
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
    boolean conflictsWith(ChangeSet<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> other);

    /**
     * Returns true if the {@link ChangeSet changeSet} is empty. A {@link ChangeSet changeSet} is empty
     * if no entities or links are created or deleted.
     */
    boolean isEmpty();

    /**
     * Retrieves the sequence of changes described by this change set. Clients may perform
     * changes on this change set while iterating with this iterator but should not expect to
     * see the changes reflected by the iterator. Implementations may choose to achieve this
     * behavior by iterating over a copy of the original list of changes.
     */
    Iterator<RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> getChanges();
    
    /**
     * Retrieves the sequence of all entity creations in this change set
     */
    Iterator<EntityCreation<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> getEntityCreations();
    
    /**
     * Retrieves the sequence of all entity deletions in this change set
     */
    Iterator<EntityDeletion<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> getEntityDeletions();
}