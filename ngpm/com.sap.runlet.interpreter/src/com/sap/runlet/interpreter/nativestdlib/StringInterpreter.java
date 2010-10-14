package com.sap.runlet.interpreter.nativestdlib;

import behavioral.actions.Statement;

import com.sap.ap.metamodel.utils.StringFormatter;
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

public class StringInterpreter implements Interpreter<NativeImpl, SapClass, TypeDefinition, ClassTypeDefinition,
Association, AssociationEnd, Statement, Expression, SignatureImplementation,
RunletStackFrame, NativeImpl, RunletInterpreter> {
    private NativeImpl nativeImpl;

    public StringInterpreter(NativeImpl nativeImpl) {
	this.nativeImpl = nativeImpl;
    }

    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter) throws SecurityException, IllegalArgumentException {
	MethodSignature sig = nativeImpl.getImplements_();
	String thiz = (String) ((NativeObject) interpreter.getCallstack().peek().getThis()).getNativeObject();
	if (sig.getName().equals("substring")) {
	    Parameter startP = sig.getInput().get(0);
	    Parameter endP = sig.getInput().get(1);
	    Fraction start = (Fraction) ((NativeObject) interpreter.getCallstack().peek().getValue(startP)).getNativeObject();
	    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> endValue = interpreter.getCallstack().peek().getValue(endP);
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
	    for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> argument : interpreter.getCallstack().peek().getValue(sP)) {
		result.append((String) ((NativeObject) argument).getNativeObject());
	    }
	    return new ReturnInterpreter.ReturnResult(new NativeObject((ClassTypeDefinition) sig.getOutput(), result.toString(),
		    interpreter.getDefaultSnapshot(), interpreter));
	}
	throw new RuntimeException("Unknown native method " + StringFormatter.toString(nativeImpl.getImplements_())
		+ " and no native interpreter registered for class " + sig.getOwner().getName());
    }

}
