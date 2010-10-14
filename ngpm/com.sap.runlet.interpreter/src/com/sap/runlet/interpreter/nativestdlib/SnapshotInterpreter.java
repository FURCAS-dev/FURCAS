package com.sap.runlet.interpreter.nativestdlib;

import behavioral.actions.Statement;

import com.sap.ap.metamodel.utils.StringFormatter;
import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.abstractinterpreter.repository.Repository;
import com.sap.runlet.abstractinterpreter.repository.Snapshot;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.RunletStackFrame;
import com.sap.runlet.interpreter.objects.NativeObject;
import com.sap.runlet.interpreter.statements.ReturnInterpreter;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.MethodSignature;
import data.classes.NativeImpl;
import data.classes.Parameter;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.expressions.Expression;

public class SnapshotInterpreter implements Interpreter<NativeImpl, SapClass, TypeDefinition, ClassTypeDefinition,
Association, AssociationEnd, Statement, Expression, SignatureImplementation,
RunletStackFrame, NativeImpl, RunletInterpreter> {
    private NativeImpl nativeImpl;

    public SnapshotInterpreter(NativeImpl nativeImpl) {
	this.nativeImpl = nativeImpl;
    }

    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter) throws SecurityException, IllegalArgumentException {
	MethodSignature sig = nativeImpl.getImplements_();
	Snapshot thiz = (Snapshot) ((NativeObject) interpreter.getCallstack().peek().getThis()).getNativeObject();
	if (sig.getName().equals("when")) {
	    return new ReturnInterpreter.ReturnResult(new NativeObject((ClassTypeDefinition) sig.getOutput(), thiz.when(),
		    interpreter.getDefaultSnapshot(), interpreter));
	}
	if (sig.getName().equals("precedes")) {
	    Parameter op = sig.getInput().get(0);
	    boolean result = true;
	    for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> argument : interpreter.getCallstack().peek().getValue(op)) {
		result = result
			&& interpreter.getRepository().precedes(thiz, (Snapshot) ((NativeObject) argument).getNativeObject());
		if (!result) {
		    break;
		}
	    }
	    return new ReturnInterpreter.ReturnResult(new NativeObject((ClassTypeDefinition) sig.getOutput(), result, interpreter
		    .getDefaultSnapshot(), interpreter));
	}
	if (sig.getName().equals("resolve")) {
	    Parameter op = sig.getInput().get(0);
	    Snapshot ss = (Snapshot) ((NativeObject) interpreter.getCallstack().peek().getValue(op)).getNativeObject();
	    Repository<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition> repository = interpreter.getRepository();
	    Snapshot result = repository.merge(thiz, ss);
	    return new ReturnInterpreter.ReturnResult(new NativeObject((ClassTypeDefinition) sig.getOutput(), result, interpreter
		    .getDefaultSnapshot(), interpreter));
	}
	if (sig.getName().equals("equals")) {
	    Parameter op = sig.getInput().get(0);
	    Snapshot other = (Snapshot) ((NativeObject) interpreter.getCallstack().peek().getValue(op)).getNativeObject();
	    Repository<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition> repository = interpreter.getRepository();
	    boolean result = repository.testSnapshotEquality(thiz, other);
	    return new ReturnInterpreter.ReturnResult(new NativeObject((ClassTypeDefinition) sig.getOutput(), result, interpreter
		    .getDefaultSnapshot(), interpreter));
	}
	throw new RuntimeException("Unknown native method " + StringFormatter.toString(nativeImpl.getImplements_())
		+ " and no native interpreter registered for class " + sig.getOwner().getName());
    }

}
