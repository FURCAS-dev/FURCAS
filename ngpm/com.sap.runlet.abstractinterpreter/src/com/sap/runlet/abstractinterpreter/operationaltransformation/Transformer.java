package com.sap.runlet.abstractinterpreter.operationaltransformation;

import org.eclipse.emf.ecore.EObject;

import com.sap.runlet.abstractinterpreter.Side;
import com.sap.runlet.abstractinterpreter.objects.EntityObject;
import com.sap.runlet.abstractinterpreter.repository.ChangeSetImpl;
import com.sap.runlet.abstractinterpreter.repository.EntityDeletion;
import com.sap.runlet.abstractinterpreter.repository.LinkChange;
import com.sap.runlet.abstractinterpreter.repository.LinkCreation;
import com.sap.runlet.abstractinterpreter.repository.LinkDeletion;
import com.sap.runlet.abstractinterpreter.repository.RepositoryChange;

/**
 * Takes two {@link Change} objects, one from the client, the other from the
 * server, and produces two dual changes for the respective other side.
 * 
 * @author Axel Uhl D043530
 *
 */
public class Transformer<LinkMetaObject extends EObject, LinkEndMetaObject extends EObject,
MetaClass extends EObject, TypeUsage extends EObject, ClassUsage extends TypeUsage> {
    private enum Direction { TO_SERVER, TO_CLIENT };
    
    /**
     * The transformation works such that applying
     * <tt>transform(c, s).getA()</tt> after <tt>c</tt> leads to the same result
     * as applying <tt>transform(c, s).getB()</tt> after <tt>s</tt>.
     */
    public Pair<Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>,
    Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> transform(
	    Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> clientChange,
	    Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> serverChange) {
	if (clientChange.totalSize() == 0 || serverChange.totalSize() == 0) {
	    return new Pair<Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>,
	    Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>(serverChange, clientChange);
	} else if (clientChange.totalSize() == 1 && serverChange.totalSize() == 1) {
	    return transform(clientChange.iterator().next(), serverChange.iterator().next());
	} else {
	    return ot(clientChange, serverChange);
	}
    }

    /**
     * Perform an operational transformation over the two change lists of which at least
     * one contains more than one element.
     */
    @SuppressWarnings("unchecked")
    private Pair<Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>,
    Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> ot(
	    Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> clientChange,
	    Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> serverChange) {
	int totalClientChanges = clientChange.totalSize();
	int totalServerChanges = serverChange.totalSize();
	// the clientChanges' last "row" becomes the list of changes to apply to the server and
	// will be wrapped and returned as the second element of the pair returned
	Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>[][] clientChanges =
	    (Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>[][]) new Change<?, ?, ?, ?, ?>[totalServerChanges+1][totalClientChanges];
	// the serverChanges' last "row" becomes the list of changes to apply to the client and
	// will be wrapped and returned as the first element of the pair returned
	Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>[][] serverChanges =
	    (Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>[][]) new Change<?, ?, ?, ?, ?>[totalClientChanges+1][totalServerChanges];
	// initialize the edges of the trellis
	int i1=0;
	for (RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> singleClientChange : clientChange) {
	    clientChanges[0][i1++] = new SingleChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(singleClientChange);
	}
	i1=0;
	for (RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> singleServerChange : serverChange) {
	    serverChanges[0][i1++] = new SingleChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(singleServerChange);
	}
	// Now populate the tellis inside
	for (int i=0; i<totalClientChanges; i++) {
	    for (int j=0; j<totalServerChanges; j++) {
		Pair<Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>,
		Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> stepResult =
		    transform(clientChanges[j][i], serverChanges[i][j]);
		clientChanges[j+1][i] = stepResult.getB(); // assign server change into clientChanges, see above
		serverChanges[i+1][j] = stepResult.getA(); // assign client change into serverChanges, see above
	    }
	}
	return new Pair<Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>,
	Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>(
		new ChangeList<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(serverChanges[totalClientChanges]),
		new ChangeList<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(clientChanges[totalServerChanges]));
    }

    private Pair<Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>,
    Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> transform(
	    RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> client,
	    RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> server) {
	return new Pair<Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>,
	Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>(
		transformSourceChangeForTarget(server, client, Direction.TO_CLIENT),
		transformSourceChangeForTarget(client, server, Direction.TO_SERVER));
    }
    
    /**
     * Takes <tt>change</tt> from the "source" side and checks if any
     * transformation needs to happen in order to apply the semantically same
     * change on the "target" side, based on what changes have happend on the
     * target side concurrently as described by <tt>appliedTargetChangeSet</tt>.
     * The result of the transformation is appended to <tt>result</tt> and to
     * <tt>targetChangesPlusTransformedSourceChanges</tt>. The latter is
     * important because this combined "target" side change set is used to track
     * ordered link movements on the "target" side in order to be able to
     * compute the transformations properly.
     * 
     * @param toServer
     *            if <tt>true</tt>, the "target" side is the server side;
     *            otherwise, the "target" side is the client side.
     */
    private Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> transformSourceChangeForTarget(RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> sourceChange, 
	    RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> targetChange, Direction direction) {
	Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> result;
	if (sourceChange.isEntityChange()) {
	    if (sourceChange.isCreate()) {
		// entity create can simply be appended on target side
		result = new SingleChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(sourceChange);
	    } else {
		// entity delete
		result = transformEntityDeletion((EntityDeletion<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) sourceChange, targetChange);
	    }
	} else {
	    // link change
	    if (sourceChange.isCreate()) {
		result = transformLinkCreation((LinkCreation<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) sourceChange, targetChange, direction);
	    } else {
		result = transformLinkDeletion((LinkDeletion<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) sourceChange, targetChange);
	    }
	}
	return result;
    }

    /**
     * A link deletion is only applied on the "target" side if none of the
     * entities to which it connects has been deleted by the
     * <tt>targetChange</tt> and in case the association is unique, <tt>targetChange</tt>
     * is not a redundant deletion for the same link on the "target"
     * side. (Note, that link deletions are implied by entity deletions for all
     * links connected to that entity known at the time of the entitiy
     * deletion.)
     * <p>
     */
    private Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> transformLinkDeletion(
	    LinkDeletion<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> sourceChange,
	    RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> targetChange) {
	Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> result;
	if (targetChange.isEntityChange() && targetChange.isDelete() &&
		(((EntityDeletion<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) targetChange).getObject().equals(sourceChange.getObject().get(Side.LEFT)) ||
		 ((EntityDeletion<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) targetChange).getObject().equals(sourceChange.getObject().get(Side.RIGHT)))) {
	    // entity was deleted; link deletion would be redundant
	    result = new EmptyChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>();
	} else if (sourceChange.getObject().isUnique() && targetChange.isLinkChange() && targetChange.isDelete()
		&& ((LinkDeletion<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) targetChange).getObject().equals(sourceChange.getObject())
		&& ((LinkChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) targetChange).getPosition() == sourceChange.getPosition()) {
	    // redundant link deletion
	    result = new EmptyChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>();
	} else if (sourceChange.getObject().isOrdered() && targetChange.isLinkChange() &&
		ChangeSetImpl.areLinksFromSameOrderedEntitySequence(sourceChange, (LinkChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) targetChange)) {
	    if (targetChange.isCreate()) {
		if (sourceChange.getPosition() >= ((LinkChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) targetChange).getPosition()) {
		    result = new SingleChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(new LinkDeletion<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(sourceChange.getObject(), sourceChange.getPosition()+1));
		} else {
		    result = new SingleChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(sourceChange);
		}
	    } else {
		// targetChange.isDelete()
		if (sourceChange.getPosition() > ((LinkChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) targetChange).getPosition()) {
		    result = new SingleChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(
			    new LinkDeletion<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(sourceChange.getObject(), sourceChange.getPosition()-1));
		} else {
		    result = new SingleChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(sourceChange);
		}
	    }
	} else {
	    result = new SingleChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(sourceChange);
	}
	return result;
    }

    /**
     * A link creation is only applied on the "target" side if none of the
     * entities to which it connects is deleted by the <tt>targetChange</tt> and
     * in the case of a unique association <tt>targetChange</tt> is not a
     * redundant link creation. In case of a unique ordered association, if
     * <tt>targetChange</tt> is an otherwise equal link created at a different
     * position, the server side's position wins. Therefore, if the direction is
     * <tt>TO_SERVER/tt>, the client's {@link LinkCreation} is skipped
     * whereas in the <tt>TO_CLIENT</tt> case, the server's different insert
     * posiiton is established on the client by adding a {@link LinkDeletion} at
     * the client's ("target") create position, followed by a
     * {@link LinkCreation} at the position to where the server's ("source")
     * original create position has shifted on the client ("target") in the
     * meantime.
     * <p>
     * 
     * If the "source" link will be created on the "target" side and the
     * association is ordered, and the <tt>targetChange</tt> is also a link
     * creation for the same association with the same object at the unordered
     * end, the link creation position shifts by one if the insertion is after
     * (for <tt>TO_SERVER</tt>) or after or at (<tt>TO_CLIENT</tt>) the
     * <tt>targetChange</tt> position.
     */
    @SuppressWarnings("unchecked")
    private Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> transformLinkCreation(LinkCreation<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> sourceChange,
	    RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> targetChange, Direction direction) {
	Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> result;
	if (targetChange.isEntityChange() && targetChange.isDelete() &&
		(((EntityDeletion<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) targetChange).getObject().equals(sourceChange.getObject().get(Side.LEFT)) ||
		 ((EntityDeletion<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) targetChange).getObject().equals(sourceChange.getObject().get(Side.RIGHT)))) {
	    result = new EmptyChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>();
	} else if (sourceChange.getObject().isUnique() && targetChange.isLinkChange() && targetChange.isCreate()
		&& ((LinkCreation<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) targetChange).getObject().equals(sourceChange.getObject())) {
	    if (((LinkChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) targetChange).getPosition() == sourceChange.getPosition()) {
		// completely redundant creation
		result = new EmptyChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>();
	    } else {
		// different positions; this implies that the association is ordered (otherwise both would be null)
		if (direction == Direction.TO_SERVER) {
		    // server position wins; no change on server
		    result = new EmptyChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>();
		} else {
		    // client position needs to be adjusted by sending a delete and create at server's position
		    result = new ChangeList<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(
			    (Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>[]) new Change<?, ?, ?, ?, ?>[] {
				    new SingleChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(
					    new LinkDeletion(((LinkCreation) targetChange).getObject(),
						    ((LinkChange) targetChange).getPosition())),
				    new SingleChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(
					    sourceChange) });
		}
	    }
	} else if (sourceChange.getObject().isOrdered() && targetChange.isLinkChange() &&
		ChangeSetImpl.areLinksFromSameOrderedEntitySequence(sourceChange, (LinkChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) targetChange)) {
	    if (targetChange.isCreate()) {
		if (sourceChange.getPosition() > ((LinkChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) targetChange).getPosition() ||
			direction == Direction.TO_SERVER && sourceChange.getPosition() == ((LinkChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) targetChange).getPosition()) {
		    result = new SingleChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(
			    new LinkCreation<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(
				    sourceChange.getObject(), sourceChange.getPosition()+1));
		} else {
		    result = new SingleChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(sourceChange);
		}
	    } else {
		// targetChange.isDelete()
		if (sourceChange.getPosition() > ((LinkChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) targetChange).getPosition()) {
		    result = new SingleChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(
			    new LinkCreation<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(
				    sourceChange.getObject(), sourceChange.getPosition()-1));
		} else {
		    result = new SingleChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(sourceChange);
		}
	    }
	} else {
	    result = new SingleChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(sourceChange);
	}
	return result;
    }

    /**
     * For <tt>targetChange</tt> being a {@link LinkCreation} that has the
     * entity deleted by <tt>sourceChange</tt> on either side, a corresponding
     * {@link LinkDeletion} is added to the result before the original
     * <tt>sourceChange</tt>. If <tt>targetChange</tt> is not a redundant entity
     * deletion, the <tt>sourceChange</tt> is taken as the <tt>result</tt>.
     */
    @SuppressWarnings("unchecked")
    private Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> transformEntityDeletion(EntityDeletion<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> sourceChange,
	    RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> targetChange) {
	Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> result;
	EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> deletedEntity = sourceChange.getObject();
	if (targetChange.isLinkChange() && targetChange.isCreate()) {
	    LinkCreation<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> lc = (LinkCreation<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) targetChange;
	    if (lc.getObject().get(Side.LEFT).equals(deletedEntity)
		    || lc.getObject().get(Side.RIGHT).equals(deletedEntity)) {
		// produce LinkDeletion followed by original entity deletion as result
		result = new ChangeList<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(
			(Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>[]) new Change<?, ?, ?, ?, ?>[] {
			new SingleChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(
				new LinkDeletion<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(lc.getObject(), lc.getPosition())),
			new SingleChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(sourceChange)});
	    } else {
		result = new SingleChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(sourceChange);
	    }
	} else if (targetChange.isEntityChange() && targetChange.isDelete()) {
	    // if redundant delete, produce empty change for target
	    EntityDeletion<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> ed =
		(EntityDeletion<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) targetChange;
	    if (ed.getObject().equals(deletedEntity)) {
		result = new EmptyChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>();
	    } else {
		result = new SingleChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(sourceChange);
	    }
	} else {
	    result = new SingleChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(sourceChange);
	}
	return result;
    }
    
}
