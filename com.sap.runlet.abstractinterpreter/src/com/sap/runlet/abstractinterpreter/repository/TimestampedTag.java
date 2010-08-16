package com.sap.runlet.abstractinterpreter.repository;

import java.util.Date;


/**
 * On a branch or the trunk as identified by the {@link Tag#getName() tag name} identifies
 * a snapshot by telling a timestamp such that the snapshot is the last on the branch/trunk
 * created <em>before</em> that point in time.
 * 
 * @author Axel Uhl (D043530)
 */
public class TimestampedTag extends AbstractSnapshotIdentifier {
    private static final long serialVersionUID = 2339075510432948233L;
    private Date timestamp;
    private Tag branchIdentifier;
    
    public TimestampedTag(Date timestamp, String name) {
	branchIdentifier = new Tag(name);
	this.timestamp = timestamp;
    }
    
    public Date getTimestamp() {
	return timestamp;
    }

    public Tag getBranchIdentifier() {
	return branchIdentifier;
    }
    
    @Override
    public String toString() {
	return "Last on "+getBranchIdentifier().toString()+" before "+getTimestamp();
    }

    @Override
    public void resolve(Repository<?, ?, ?, ?, ?> repository) {
	Snapshot snapshot = repository.resolveLastBeforeDateOnBranch(getTimestamp(), getBranchIdentifier());
	if (snapshot == null) {
	    throw new RuntimeException(""+this+" unknown in the context of repository "+repository);
	} else {
	    setSnapshot(snapshot);
	}
    }
    
    @Override
    public void unresolve() {
	setSnapshot(null);
    }
}
