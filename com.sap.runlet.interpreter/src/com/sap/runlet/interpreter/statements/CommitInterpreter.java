package com.sap.runlet.interpreter.statements;

import persistence.expressions.Commit;
import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.EmptyObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.abstractinterpreter.repository.FixedSnapshot;
import com.sap.runlet.abstractinterpreter.repository.Snapshot;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.RunletStackFrame;
import com.sap.runlet.interpreter.objects.NativeObject;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.NativeImpl;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.expressions.Expression;

public class CommitInterpreter implements Interpreter<Commit, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {

    private Commit commit;

    public CommitInterpreter(Commit commit) {
	this.commit = commit;
    }

    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException {
	Snapshot newSnapshot = interpreter.commit();
	if (newSnapshot == null) {
	    return new EmptyObject<AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition>(
		    commit.getType(), interpreter.getModelAdapter());
	}
	return new NativeObject((ClassTypeDefinition) commit.getType(), newSnapshot,
		new FixedSnapshot(newSnapshot), interpreter);
    }
}
