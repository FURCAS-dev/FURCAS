package com.sap.river.interpreter.nativestdlib;

import com.sap.ap.metamodel.formatter.StringFormatter;
import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.NativeObject;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.river.interpreter.repository.Repository;
import com.sap.river.interpreter.repository.Snapshot;
import com.sap.river.interpreter.statements.ReturnInterpreter;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import data.classes.ClassTypeDefinition;
import data.classes.MethodSignature;
import data.classes.NativeImpl;
import data.classes.Parameter;

public class SnapshotInterpreter implements Interpreter<NativeImpl> {
    private NativeImpl nativeImpl;

    public SnapshotInterpreter(NativeImpl nativeImpl) {
	this.nativeImpl = nativeImpl;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter) throws SecurityException, IllegalArgumentException, JmiException {
	MethodSignature sig = nativeImpl.getImplements();
	Snapshot thiz = (Snapshot) ((NativeObject) interpreter.getCallstack().peek().getThis()).getNativeObject();
	if (sig.getName().equals("when")) {
	    return new ReturnInterpreter.ReturnResult(new NativeObject((ClassTypeDefinition) sig.getOutput(), thiz.when(),
		    interpreter.getDefaultSnapshot(), interpreter));
	}
	if (sig.getName().equals("precedes")) {
	    Parameter op = sig.getInput().get(0);
	    boolean result = true;
	    for (RiverObject argument : interpreter.getCallstack().peek().getValue(op)) {
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
	    Repository repository = interpreter.getRepository();
	    Snapshot result = repository.merge(thiz, ss);
	    return new ReturnInterpreter.ReturnResult(new NativeObject((ClassTypeDefinition) sig.getOutput(), result, interpreter
		    .getDefaultSnapshot(), interpreter));
	}
	if (sig.getName().equals("equals")) {
	    Parameter op = sig.getInput().get(0);
	    Snapshot other = (Snapshot) ((NativeObject) interpreter.getCallstack().peek().getValue(op)).getNativeObject();
	    Repository repository = interpreter.getRepository();
	    boolean result = repository.testSnapshotEquality(thiz, other);
	    return new ReturnInterpreter.ReturnResult(new NativeObject((ClassTypeDefinition) sig.getOutput(), result, interpreter
		    .getDefaultSnapshot(), interpreter));
	}
	throw new RuntimeException("Unknown native method " + StringFormatter.toString(nativeImpl.getImplements())
		+ " and no native interpreter registered for class " + sig.getOwner().getName());
    }

}
