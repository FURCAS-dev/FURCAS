package com.sap.runlet.expressionpad.tests;

import java.util.List;

import com.sap.runlet.abstractinterpreter.operationaltransformation.Change;
import com.sap.runlet.abstractinterpreter.repository.ChangeSetImpl;
import com.sap.runlet.abstractinterpreter.repository.FixedSnapshot;
import com.sap.runlet.abstractinterpreter.repository.Snapshot;
import com.sap.runlet.abstractinterpreter.util.ModelAdapter;
import com.sap.runlet.interpreter.repository.simpleimpl.RunletInMemoryRepository;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.SapClass;
import data.classes.TypeDefinition;

public class TestInMemoryRepository extends RunletInMemoryRepository {
    public TestInMemoryRepository(ModelAdapter<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition> modelAdapter) {
	super(modelAdapter);
    }

    /**
     * If <tt>from</tt> and <tt>to</tt> are connected by a predecessor path,
     * this method will return the changes that happened from the one to the
     * other, otherwise <tt>null</tt>.
     */
    private Change<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition> getChanges(Snapshot from, Snapshot to) {
	Change<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition> result = null;
	List<Snapshot> path = getPath(from, to);
	if (path != null) {
	    result = getChanges(path);
	}
	return result;
    }
    
    public boolean doesChangeSetProduceEqualResults(Snapshot from, Snapshot to) {
	Change<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition> recordedChange = getChanges(from, to);
	Snapshot snapshotObtainedByReapplying = apply(new ChangeSetImpl<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition>(
		recordedChange, getModelAdapter()), new FixedSnapshot(from));
	return testSnapshotEquality(to, snapshotObtainedByReapplying);
    }
    
}
