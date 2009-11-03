package com.sap.river.interpreter.nativestdlib;

import com.sap.ap.metamodel.formatter.StringFormatter;
import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.NativeObject;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.river.interpreter.statements.ReturnInterpreter;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import data.classes.ClassTypeDefinition;
import data.classes.MethodSignature;
import data.classes.NativeImpl;
import data.classes.Parameter;

public class BooleanInterpreter implements Interpreter<NativeImpl> {
    private NativeImpl nativeImpl;

    public BooleanInterpreter(NativeImpl nativeImpl) {
	this.nativeImpl = nativeImpl;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter) throws SecurityException, IllegalArgumentException, JmiException {
	MethodSignature sig = nativeImpl.getImplements();
	Boolean thiz = (Boolean) ((NativeObject) interpreter.getCallstack().peek().getThis()).getNativeObject();
	if (sig.getName().equals("and")) {
	    Parameter op = sig.getInput().get(0);
	    boolean result = thiz;
	    if (result) {
		for (RiverObject argument : interpreter.getCallstack().peek().getValue(op)) {
		    result = result && (Boolean) ((NativeObject) argument).getNativeObject();
		    if (!result) {
			break;
		    }
		}
	    }
	    return new ReturnInterpreter.ReturnResult(new NativeObject((ClassTypeDefinition) sig.getOutput(), result, interpreter
		    .getDefaultSnapshot(), interpreter));
	}
	if (sig.getName().equals("or")) {
	    Parameter op = sig.getInput().get(0);
	    boolean result = thiz;
	    if (!result) {
		for (RiverObject argument : interpreter.getCallstack().peek().getValue(op)) {
		    result = result || (Boolean) ((NativeObject) argument).getNativeObject();
		    if (result) {
			break;
		    }
		}
	    }
	    return new ReturnInterpreter.ReturnResult(new NativeObject((ClassTypeDefinition) sig.getOutput(), result, interpreter
		    .getDefaultSnapshot(), interpreter));
	}
	if (sig.getName().equals("not")) {
	    return new ReturnInterpreter.ReturnResult(new NativeObject((ClassTypeDefinition) sig.getOutput(), !thiz
		    .booleanValue(), interpreter.getDefaultSnapshot(), interpreter));
	}
	throw new RuntimeException("Unknown native method " + StringFormatter.toString(nativeImpl.getImplements())
		+ " and no native interpreter registered for class " + sig.getOwner().getName());
    }

}
