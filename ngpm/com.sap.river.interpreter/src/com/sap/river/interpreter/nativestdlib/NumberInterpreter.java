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

public class NumberInterpreter implements Interpreter<NativeImpl> {
    private NativeImpl nativeImpl;

    public NumberInterpreter(NativeImpl nativeImpl) {
	this.nativeImpl = nativeImpl;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter) throws SecurityException, IllegalArgumentException, JmiException {
	MethodSignature sig = nativeImpl.getImplements();
	Fraction thiz = (Fraction) ((NativeObject) interpreter.getCallstack().peek().getThis()).getNativeObject();
	if (sig.getName().equals("plus")) {
	    Parameter p = sig.getInput().get(0);
	    Fraction result = thiz;
	    for (RiverObject argument : interpreter.getCallstack().peek().getValue(p)) {
		result = result.plus((Fraction) ((NativeObject) argument).getNativeObject());
	    }
	    return new ReturnInterpreter.ReturnResult(new NativeObject((ClassTypeDefinition) sig.getOutput(), result, interpreter
		    .getDefaultSnapshot(), interpreter));
	}
	if (sig.getName().equals("minus")) {
	    Parameter p = sig.getInput().get(0);
	    Fraction result = thiz;
	    for (RiverObject argument : interpreter.getCallstack().peek().getValue(p)) {
		result = result.minus((Fraction) ((NativeObject) argument).getNativeObject());
	    }
	    return new ReturnInterpreter.ReturnResult(new NativeObject((ClassTypeDefinition) sig.getOutput(), result, interpreter
		    .getDefaultSnapshot(), interpreter));
	}
	if (sig.getName().equals("times")) {
	    Parameter p = sig.getInput().get(0);
	    Fraction result = thiz;
	    for (RiverObject argument : interpreter.getCallstack().peek().getValue(p)) {
		result = result.times((Fraction) ((NativeObject) argument).getNativeObject());
	    }
	    return new ReturnInterpreter.ReturnResult(new NativeObject((ClassTypeDefinition) sig.getOutput(), result, interpreter
		    .getDefaultSnapshot(), interpreter));
	}
	if (sig.getName().equals("div")) {
	    Parameter p = sig.getInput().get(0);
	    Fraction result = thiz;
	    for (RiverObject argument : interpreter.getCallstack().peek().getValue(p)) {
		result = result.dividedBy((Fraction) ((NativeObject) argument).getNativeObject());
	    }
	    return new ReturnInterpreter.ReturnResult(new NativeObject((ClassTypeDefinition) sig.getOutput(), result, interpreter
		    .getDefaultSnapshot(), interpreter));
	}
	if (sig.getName().equals("greaterThan")) {
	    Parameter p = sig.getInput().get(0);
	    boolean result = true;
	    for (RiverObject argument : interpreter.getCallstack().peek().getValue(p)) {
		result = result && thiz.compareTo((Fraction) ((NativeObject) argument).getNativeObject()) > 0;
		if (!result) {
		    break;
		}
	    }
	    return new ReturnInterpreter.ReturnResult(new NativeObject((ClassTypeDefinition) sig.getOutput(), result, interpreter
		    .getDefaultSnapshot(), interpreter));
	}
	if (sig.getName().equals("lessThan")) {
	    Parameter p = sig.getInput().get(0);
	    boolean result = true;
	    for (RiverObject argument : interpreter.getCallstack().peek().getValue(p)) {
		result = result && thiz.compareTo((Fraction) ((NativeObject) argument).getNativeObject()) < 0;
		if (!result) {
		    break;
		}
	    }
	    return new ReturnInterpreter.ReturnResult(new NativeObject((ClassTypeDefinition) sig.getOutput(), result, interpreter
		    .getDefaultSnapshot(), interpreter));
	}
	if (sig.getName().equals("greaterOrEquals")) {
	    Parameter p = sig.getInput().get(0);
	    boolean result = true;
	    for (RiverObject argument : interpreter.getCallstack().peek().getValue(p)) {
		result = result && thiz.compareTo((Fraction) ((NativeObject) argument).getNativeObject()) >= 0;
		if (!result) {
		    break;
		}
	    }
	    return new ReturnInterpreter.ReturnResult(new NativeObject((ClassTypeDefinition) sig.getOutput(), result, interpreter
		    .getDefaultSnapshot(), interpreter));
	}
	if (sig.getName().equals("lessOrEquals")) {
	    Parameter p = sig.getInput().get(0);
	    boolean result = true;
	    for (RiverObject argument : interpreter.getCallstack().peek().getValue(p)) {
		result = result && thiz.compareTo((Fraction) ((NativeObject) argument).getNativeObject()) <= 0;
		if (!result) {
		    break;
		}
	    }
	    return new ReturnInterpreter.ReturnResult(new NativeObject((ClassTypeDefinition) sig.getOutput(), result, interpreter
		    .getDefaultSnapshot(), interpreter));
	}
	if (sig.getName().equals("negate")) {
	    return new ReturnInterpreter.ReturnResult(new NativeObject((ClassTypeDefinition) sig.getOutput(), thiz.negative(), interpreter
		    .getDefaultSnapshot(), interpreter));
	}
	throw new RuntimeException("Unknown native method "+
		StringFormatter.toString(nativeImpl.getImplements())+
		" and no native interpreter registered for class "+
		sig.getOwner().getName());
    }

}
