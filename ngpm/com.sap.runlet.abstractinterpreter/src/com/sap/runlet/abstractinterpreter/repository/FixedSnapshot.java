package com.sap.runlet.abstractinterpreter.repository;


/**
 * Identifies a fixed snapshot, not a general branch. Identifiers of this type
 * don't "move" to another snapshot. Their resolution is trivial because it
 * just delivers the snapshot to which this "identifier" is bound.<p>
 * 
 * The {@link #setSnapshot(Snapshot)} operation will throw an exception if invoked
 * on an instance of this class.
 * 
 * @author Axel Uhl (D043530)
 */
public class FixedSnapshot extends AbstractSnapshotIdentifier {
    private static final long serialVersionUID = -7584518811494247598L;

    public FixedSnapshot(Snapshot snapshot) {
	super.setSnapshot(snapshot);
    }
    
    @Override
    public void setSnapshot(Snapshot snapshot) {
	throw new RuntimeException("Fixed snapshot identifiers can't be re-assigned to another snapshot");
    }

    @Override
    public void resolve(Repository<?, ?, ?, ?, ?> repository) {
	assert repository.has(getSnapshot());
    }
    
    @Override
    public String toString() {
	return getSnapshot().toString();
    }
    
    @Override
    public void unresolve() {
	// can't unresolve a fixed snapshot; no-op
    }
}
