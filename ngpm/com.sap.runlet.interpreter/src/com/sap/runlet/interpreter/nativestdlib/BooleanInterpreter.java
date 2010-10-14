package com.sap.runlet.interpreter.nativestdlib;

import behavioral.actions.Statement;

import com.sap.ap.metamodel.utils.StringFormatter;
import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
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

public class BooleanInterpreter implements Interpreter<NativeImpl, SapClass, TypeDefinition, ClassTypeDefinition,
Association, AssociationEnd, Statement, Expression, SignatureImplementation,
RunletStackFrame, NativeImpl, RunletInterpreter> {
    private NativeImpl nativeImpl;

    public BooleanInterpreter(NativeImpl nativeImpl) {
	this.nativeImpl = nativeImpl;
    }

    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter) throws SecurityException, IllegalArgumentException {
	MethodSignature sig = nativeImpl.getImplements_();
	Boolean thiz = (Boolean) ((NativeObject) interpreter.getCallstack().peek().getThis()).getNativeObject();
	if (sig.getName().equals("and")) {
	    Parameter op = sig.getInput().get(0);
	    boolean result = thiz;
	    if (result) {
		for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> argument : interpreter.getCallstack().peek().getValue(op)) {
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
		for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> argument : interpreter.getCallstack().peek().getValue(op)) {
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
	throw new RuntimeException("Unknown native method " + StringFormatter.toString(nativeImpl.getImplements_())
		+ " and no native interpreter registered for class " + sig.getOwner().getName());
    }

}
