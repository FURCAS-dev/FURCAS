package com.sap.river.interpreter.statements;

import persistence.expressions.Commit;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.EmptyObject;
import com.sap.river.interpreter.objects.NativeObject;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.river.interpreter.repository.Snapshot;
import com.sap.river.interpreter.repository.simpleimpl.FixedSnapshot;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import data.classes.ClassTypeDefinition;

public class CommitInterpreter implements Interpreter<Commit> {

    private Commit commit;

    public CommitInterpreter(Commit commit) {
	this.commit = commit;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException, JmiException {
	Snapshot newSnapshot = interpreter.commit();
	if (newSnapshot == null) {
	    return new EmptyObject(commit.getType());
	}
	return new NativeObject((ClassTypeDefinition) commit.getType(), newSnapshot,
		new FixedSnapshot(newSnapshot), interpreter);
    }
}
