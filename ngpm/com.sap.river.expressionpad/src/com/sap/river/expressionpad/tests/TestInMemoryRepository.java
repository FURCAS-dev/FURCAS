package com.sap.river.expressionpad.tests;

import java.util.List;

import com.sap.river.interpreter.operationaltransformation.Change;
import com.sap.river.interpreter.repository.ChangeSetImpl;
import com.sap.river.interpreter.repository.Snapshot;
import com.sap.river.interpreter.repository.simpleimpl.FixedSnapshot;
import com.sap.river.interpreter.repository.simpleimpl.InMemoryRepository;

public class TestInMemoryRepository extends InMemoryRepository {
    /**
     * If <tt>from</tt> and <tt>to</tt> are connected by a predecessor path,
     * this method will return the changes that happened from the one to the
     * other, otherwise <tt>null</tt>.
     */
    private Change getChanges(Snapshot from, Snapshot to) {
	Change result = null;
	List<Snapshot> path = getPath(from, to);
	if (path != null) {
	    result = getChanges(path);
	}
	return result;
    }
    
    public boolean doesChangeSetProduceEqualResults(Snapshot from, Snapshot to) {
	Change recordedChange = getChanges(from, to);
	Snapshot snapshotObtainedByReapplying = apply(new ChangeSetImpl(recordedChange), new FixedSnapshot(from));
	return testSnapshotEquality(to, snapshotObtainedByReapplying);
    }
    
}
