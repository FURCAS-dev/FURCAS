package com.sap.runlet.abstractinterpreter.repository;


public abstract class AbstractSnapshotIdentifier implements SnapshotIdentifier {
    private static final long serialVersionUID = -7448977232526941461L;
    private Snapshot snapshot;
    
    @Override
    public Snapshot getSnapshot() {
	return snapshot;
    }

    @Override
    public void setSnapshot(Snapshot snapshot) {
	this.snapshot = snapshot;
    }
    
    @Override
    public boolean equals(Object o) {
	return (this.getSnapshot() == null) == (((AbstractSnapshotIdentifier) o).getSnapshot() == null) &&
	       (this.getSnapshot() == null || this.getSnapshot().equals(((AbstractSnapshotIdentifier) o).getSnapshot()));
    }
    
    @Override
    public int hashCode() {
	return getSnapshot().hashCode();
    }
    
    public SnapshotIdentifier clone() {
	try {
	    return (SnapshotIdentifier) super.clone();
	} catch (CloneNotSupportedException e) {
	    throw new RuntimeException("snapshot identifier should have been cloneable: "+this, e);
	}
    }
    
    /**
     * Resolves this identifier in the scope of the <tt>repository</tt> specified as argument.
     * When this method returns, {@link #getSnapshot()} will return the {@link Snapshot} to which
     * this identifier has been resolved. Postcondition: <tt>repository.has(this.getSnapshot())</tt>.
     */
    public abstract void resolve(Repository<?, ?, ?, ?, ?> repository);
}
