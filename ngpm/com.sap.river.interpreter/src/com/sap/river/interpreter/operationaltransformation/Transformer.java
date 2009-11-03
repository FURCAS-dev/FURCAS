package com.sap.river.interpreter.operationaltransformation;

import com.sap.river.interpreter.Side;
import com.sap.river.interpreter.objects.EntityObject;
import com.sap.river.interpreter.repository.ChangeSetImpl;
import com.sap.river.interpreter.repository.EntityDeletion;
import com.sap.river.interpreter.repository.LinkChange;
import com.sap.river.interpreter.repository.LinkCreation;
import com.sap.river.interpreter.repository.LinkDeletion;
import com.sap.river.interpreter.repository.RepositoryChange;
import com.sap.tc.moin.repository.shared.util.Tuple.Pair;

/**
 * Takes two {@link Change} objects, one from the client, the other from the
 * server, and produces two dual changes for the respective other side.
 * 
 * @author Axel Uhl D043530
 *
 */
public class Transformer {
    private enum Direction { TO_SERVER, TO_CLIENT };
    
    /**
     * The transformation works such that applying
     * <tt>transform(c, s).getA()</tt> after <tt>c</tt> leads to the same result
     * as applying <tt>transform(c, s).getB()</tt> after <tt>s</tt>.
     */
    public Pair<Change, Change> transform(Change clientChange, Change serverChange) {
	if (clientChange.totalSize() == 0 || serverChange.totalSize() == 0) {
	    return new Pair<Change, Change>(serverChange, clientChange);
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
    private Pair<Change, Change> ot(Change clientChange, Change serverChange) {
	int totalClientChanges = clientChange.totalSize();
	int totalServerChanges = serverChange.totalSize();
	// the clientChanges' last "row" becomes the list of changes to apply to the server and
	// will be wrapped and returned as the second element of the pair returned
	Change[][] clientChanges = new Change[totalServerChanges+1][totalClientChanges];
	// the serverChanges' last "row" becomes the list of changes to apply to the client and
	// will be wrapped and returned as the first element of the pair returned
	Change[][] serverChanges = new Change[totalClientChanges+1][totalServerChanges];
	// initialize the edges of the trellis
	int i1=0;
	for (RepositoryChange singleClientChange : clientChange) {
	    clientChanges[0][i1++] = new SingleChange(singleClientChange);
	}
	i1=0;
	for (RepositoryChange singleServerChange : serverChange) {
	    serverChanges[0][i1++] = new SingleChange(singleServerChange);
	}
	// Now populate the tellis inside
	for (int i=0; i<totalClientChanges; i++) {
	    for (int j=0; j<totalServerChanges; j++) {
		Pair<Change, Change> stepResult = transform(clientChanges[j][i], serverChanges[i][j]);
		clientChanges[j+1][i] = stepResult.getB(); // assign server change into clientChanges, see above
		serverChanges[i+1][j] = stepResult.getA(); // assign client change into serverChanges, see above
	    }
	}
	return new Pair<Change, Change>(new ChangeList(serverChanges[totalClientChanges]),
		new ChangeList(clientChanges[totalServerChanges]));
    }

    private Pair<Change, Change> transform(RepositoryChange client, RepositoryChange server) {
	return new Pair<Change, Change>(
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
    private Change transformSourceChangeForTarget(RepositoryChange sourceChange, 
	    RepositoryChange targetChange, Direction direction) {
	Change result;
	if (sourceChange.isEntityChange()) {
	    if (sourceChange.isCreate()) {
		// entity create can simply be appended on target side
		result = new SingleChange(sourceChange);
	    } else {
		// entity delete
		result = transformEntityDeletion((EntityDeletion) sourceChange, targetChange);
	    }
	} else {
	    // link change
	    if (sourceChange.isCreate()) {
		result = transformLinkCreation((LinkCreation) sourceChange, targetChange, direction);
	    } else {
		result = transformLinkDeletion((LinkDeletion) sourceChange, targetChange);
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
    private Change transformLinkDeletion(LinkDeletion sourceChange, RepositoryChange targetChange) {
	Change result;
	if (targetChange.isEntityChange() && targetChange.isDelete() &&
		(((EntityDeletion) targetChange).getObject().equals(sourceChange.getObject().get(Side.LEFT)) ||
		 ((EntityDeletion) targetChange).getObject().equals(sourceChange.getObject().get(Side.RIGHT)))) {
	    // entity was deleted; link deletion would be redundant
	    result = new EmptyChange();
	} else if (sourceChange.getObject().isUnique() && targetChange.isLinkChange() && targetChange.isDelete()
		&& ((LinkDeletion) targetChange).getObject().equals(sourceChange.getObject())
		&& ((LinkChange) targetChange).getPosition() == sourceChange.getPosition()) {
	    // redundant link deletion
	    result = new EmptyChange();
	} else if (sourceChange.getObject().isOrdered() && targetChange.isLinkChange() &&
		ChangeSetImpl.areLinksFromSameOrderedEntitySequence(sourceChange, (LinkChange) targetChange)) {
	    if (targetChange.isCreate()) {
		if (sourceChange.getPosition() >= ((LinkChange) targetChange).getPosition()) {
		    result = new SingleChange(new LinkDeletion(sourceChange.getObject(), sourceChange.getPosition()+1));
		} else {
		    result = new SingleChange(sourceChange);
		}
	    } else {
		// targetChange.isDelete()
		if (sourceChange.getPosition() > ((LinkChange) targetChange).getPosition()) {
		    result = new SingleChange(new LinkDeletion(sourceChange.getObject(), sourceChange.getPosition()-1));
		} else {
		    result = new SingleChange(sourceChange);
		}
	    }
	} else {
	    result = new SingleChange(sourceChange);
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
    private Change transformLinkCreation(LinkCreation sourceChange, RepositoryChange targetChange, Direction direction) {
	Change result;
	if (targetChange.isEntityChange() && targetChange.isDelete() &&
		(((EntityDeletion) targetChange).getObject().equals(sourceChange.getObject().get(Side.LEFT)) ||
		 ((EntityDeletion) targetChange).getObject().equals(sourceChange.getObject().get(Side.RIGHT)))) {
	    result = new EmptyChange();
	} else if (sourceChange.getObject().isUnique() && targetChange.isLinkChange() && targetChange.isCreate()
		&& ((LinkCreation) targetChange).getObject().equals(sourceChange.getObject())) {
	    if (((LinkChange) targetChange).getPosition() == sourceChange.getPosition()) {
		// completely redundant creation
		result = new EmptyChange();
	    } else {
		// different positions; this implies that the association is ordered (otherwise both would be null)
		if (direction == Direction.TO_SERVER) {
		    // server position wins; no change on server
		    result = new EmptyChange();
		} else {
		    // client position needs to be adjusted by sending a delete and create at server's position
		    result = new ChangeList(new Change[] {
			new SingleChange(new LinkDeletion(((LinkCreation) targetChange).getObject(), ((LinkChange) targetChange).getPosition())),    
			new SingleChange(sourceChange)
		    });
		}
	    }
	} else if (sourceChange.getObject().isOrdered() && targetChange.isLinkChange() &&
		ChangeSetImpl.areLinksFromSameOrderedEntitySequence(sourceChange, (LinkChange) targetChange)) {
	    if (targetChange.isCreate()) {
		if (sourceChange.getPosition() > ((LinkChange) targetChange).getPosition() ||
			direction == Direction.TO_SERVER && sourceChange.getPosition() == ((LinkChange) targetChange).getPosition()) {
		    result = new SingleChange(new LinkCreation(sourceChange.getObject(), sourceChange.getPosition()+1));
		} else {
		    result = new SingleChange(sourceChange);
		}
	    } else {
		// targetChange.isDelete()
		if (sourceChange.getPosition() > ((LinkChange) targetChange).getPosition()) {
		    result = new SingleChange(new LinkCreation(sourceChange.getObject(), sourceChange.getPosition()-1));
		} else {
		    result = new SingleChange(sourceChange);
		}
	    }
	} else {
	    result = new SingleChange(sourceChange);
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
    private Change transformEntityDeletion(EntityDeletion sourceChange, RepositoryChange targetChange) {
	Change result;
	EntityObject deletedEntity = sourceChange.getObject();
	if (targetChange.isLinkChange() && targetChange.isCreate()) {
	    LinkCreation lc = (LinkCreation) targetChange;
	    if (lc.getObject().get(Side.LEFT).equals(deletedEntity)
		    || lc.getObject().get(Side.RIGHT).equals(deletedEntity)) {
		// produce LinkDeletion followed by original entity deletion as result
		result = new ChangeList(new Change[] {
			new SingleChange(new LinkDeletion(lc.getObject(), lc.getPosition())),
			new SingleChange(sourceChange)});
	    } else {
		result = new SingleChange(sourceChange);
	    }
	} else if (targetChange.isEntityChange() && targetChange.isDelete()) {
	    // if redundant delete, produce empty change for target
	    EntityDeletion ed = (EntityDeletion) targetChange;
	    if (ed.getObject().equals(deletedEntity)) {
		result = new EmptyChange();
	    } else {
		result = new SingleChange(sourceChange);
	    }
	} else {
	    result = new SingleChange(sourceChange);
	}
	return result;
    }
    
}
