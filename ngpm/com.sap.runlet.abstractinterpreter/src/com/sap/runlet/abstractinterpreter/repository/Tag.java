package com.sap.runlet.abstractinterpreter.repository;



public class Tag extends AbstractSnapshotIdentifier {
    private static final long serialVersionUID = 8648570198069488870L;
    private String name;

    public Tag(String name) {
	super();
	this.name = name;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public boolean equals(Object o) {
	if (!(o instanceof Tag)) {
	    return false;
	}
	return ((Tag) o).getName().equals(getName());
    }
    
    @Override
    public int hashCode() {
	return 987249823 ^ getName().hashCode();
    }

    @Override
    public String toString() {
	return getName();
    }

    @Override
    public void resolve(Repository<?, ?, ?, ?, ?> repository) {
	Snapshot snapshot = repository.resolveTag(this);
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
