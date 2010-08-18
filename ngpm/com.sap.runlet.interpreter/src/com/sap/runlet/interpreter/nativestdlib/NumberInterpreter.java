package com.sap.runlet.interpreter.nativestdlib;

import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.abstractinterpreter.util.Fraction;
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

public class NumberInterpreter implements Interpreter<NativeImpl, SapClass, TypeDefinition, ClassTypeDefinition,
Association, AssociationEnd, Statement, Expression, SignatureImplementation,
RunletStackFrame, NativeImpl, RunletInterpreter> {
    private NativeImpl nativeImpl;

    public NumberInterpreter(NativeImpl nativeImpl) {
	this.nativeImpl = nativeImpl;
    }

    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(
	    RunletInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException {
	MethodSignature sig = nativeImpl.getImplements_();
	Fraction thiz = (Fraction) ((NativeObject) interpreter.getCallstack().peek().getThis()).getNativeObject();
	if (sig.getName().equals("plus")) {
	    Parameter p = sig.getInput().get(0);
	    Fraction result = thiz;
	    for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> argument : interpreter.getCallstack().peek().getValue(p)) {
		result = result.plus((Fraction) ((NativeObject) argument).getNativeObject());
	    }
	    return new ReturnInterpreter.ReturnResult(new NativeObject((ClassTypeDefinition) sig.getOutput(), result, interpreter
		    .getDefaultSnapshot(), interpreter));
	}
	if (sig.getName().equals("minus")) {
	    Parameter p = sig.getInput().get(0);
	    Fraction result = thiz;
	    for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> argument : interpreter.getCallstack().peek().getValue(p)) {
		result = result.minus((Fraction) ((NativeObject) argument).getNativeObject());
	    }
	    return new ReturnInterpreter.ReturnResult(new NativeObject((ClassTypeDefinition) sig.getOutput(), result, interpreter
		    .getDefaultSnapshot(), interpreter));
	}
	if (sig.getName().equals("times")) {
	    Parameter p = sig.getInput().get(0);
	    Fraction result = thiz;
	    for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> argument : interpreter.getCallstack().peek().getValue(p)) {
		result = result.times((Fraction) ((NativeObject) argument).getNativeObject());
	    }
	    return new ReturnInterpreter.ReturnResult(new NativeObject((ClassTypeDefinition) sig.getOutput(), result, interpreter
		    .getDefaultSnapshot(), interpreter));
	}
	if (sig.getName().equals("div")) {
	    Parameter p = sig.getInput().get(0);
	    Fraction result = thiz;
	    for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> argument : interpreter.getCallstack().peek().getValue(p)) {
		result = result.dividedBy((Fraction) ((NativeObject) argument).getNativeObject());
	    }
	    return new ReturnInterpreter.ReturnResult(new NativeObject((ClassTypeDefinition) sig.getOutput(), result, interpreter
		    .getDefaultSnapshot(), interpreter));
	}
	if (sig.getName().equals("greaterThan")) {
	    Parameter p = sig.getInput().get(0);
	    boolean result = true;
	    for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> argument : interpreter.getCallstack().peek().getValue(p)) {
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
	    for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> argument : interpreter.getCallstack().peek().getValue(p)) {
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
	    for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> argument : interpreter.getCallstack().peek().getValue(p)) {
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
	    for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> argument : interpreter.getCallstack().peek().getValue(p)) {
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
		StringFormatter.toString(nativeImpl.getImplements_())+
		" and no native interpreter registered for class "+
		sig.getOwner().getName());
    }

}
