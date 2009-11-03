package com.sap.river.interpreter.nativestdlib;

import com.sap.ap.metamodel.formatter.StringFormatter;
import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.NativeObject;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.river.interpreter.statements.ReturnInterpreter;
import com.sap.river.interpreter.util.Fraction;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import data.classes.ClassTypeDefinition;
import data.classes.MethodSignature;
import data.classes.NativeImpl;
import data.classes.Parameter;

public class StringInterpreter implements Interpreter<NativeImpl> {
    private NativeImpl nativeImpl;

    public StringInterpreter(NativeImpl nativeImpl) {
	this.nativeImpl = nativeImpl;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter) throws SecurityException, IllegalArgumentException, JmiException {
	MethodSignature sig = nativeImpl.getImplements();
	String thiz = (String) ((NativeObject) interpreter.getCallstack().peek().getThis()).getNativeObject();
	if (sig.getName().equals("substring")) {
	    Parameter startP = sig.getInput().get(0);
	    Parameter endP = sig.getInput().get(1);
	    Fraction start = (Fraction) ((NativeObject) interpreter.getCallstack().peek().getValue(startP)).getNativeObject();
	    RiverObject endValue = interpreter.getCallstack().peek().getValue(endP);
	    Fraction end = null;
	    if (!endValue.isEmpty()) {
		end = (Fraction) ((NativeObject) interpreter.getCallstack().peek().getValue(endP)).getNativeObject();
	    }
	    if (end != null) {
		return new ReturnInterpreter.ReturnResult(new NativeObject((ClassTypeDefinition) sig.getOutput(), thiz.substring(
			start.intValue(), end.intValue()), interpreter.getDefaultSnapshot(), interpreter));
	    } else {
		return new ReturnInterpreter.ReturnResult(new NativeObject((ClassTypeDefinition) sig.getOutput(), thiz
			.substring(start.intValue()), interpreter.getDefaultSnapshot(), interpreter));
	    }
	}
	if (sig.getName().equals("length")) {
	    return new ReturnInterpreter.ReturnResult(new NativeObject((ClassTypeDefinition) sig.getOutput(), new Fraction(thiz
		    .length()), interpreter.getDefaultSnapshot(), interpreter));
	}
	if (sig.getName().equals("append")) {
	    Parameter sP = sig.getInput().get(0);
	    StringBuilder result = new StringBuilder(thiz);
	    for (RiverObject argument : interpreter.getCallstack().peek().getValue(sP)) {
		result.append((String) ((NativeObject) argument).getNativeObject());
	    }
	    return new ReturnInterpreter.ReturnResult(new NativeObject((ClassTypeDefinition) sig.getOutput(), result.toString(),
		    interpreter.getDefaultSnapshot(), interpreter));
	}
	throw new RuntimeException("Unknown native method " + StringFormatter.toString(nativeImpl.getImplements())
		+ " and no native interpreter registered for class " + sig.getOwner().getName());
    }

}
