package com.sap.runlet.interpreter.nativestdlib;

import java.util.Date;

import behavioral.actions.Statement;

import com.sap.ap.metamodel.formatter.StringFormatter;
import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.RunletStackFrame;
import com.sap.runlet.interpreter.objects.NativeObject;
import com.sap.runlet.interpreter.statements.ReturnInterpreter;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

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

public class TimepointInterpreter implements Interpreter<NativeImpl, SapClass, TypeDefinition, ClassTypeDefinition,
Association, AssociationEnd, Statement, Expression, SignatureImplementation,
RunletStackFrame<AssociationEnd, TypeDefinition, ClassTypeDefinition>, NativeImpl, RunletInterpreter> {
    private NativeImpl nativeImpl;

    public TimepointInterpreter(NativeImpl nativeImpl) {
	this.nativeImpl = nativeImpl;
    }

    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter) throws SecurityException, IllegalArgumentException, JmiException {
	MethodSignature sig = nativeImpl.getImplements();
	Date thiz = (Date) ((NativeObject) interpreter.getCallstack().peek().getThis()).getNativeObject();
	if (sig.getName().equals("before")) {
	    Parameter op = sig.getInput().get(0);
	    boolean result = true;
	    for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> argument : interpreter.getCallstack().peek().getValue(op)) {
		result = result && thiz.before((Date) ((NativeObject) argument).getNativeObject());
		if (!result) {
		    break;
		}
	    }
	    return new ReturnInterpreter.ReturnResult(new NativeObject((ClassTypeDefinition) sig.getOutput(), result, interpreter
		    .getDefaultSnapshot(), interpreter));
	}
	throw new RuntimeException("Unknown native method " + StringFormatter.toString(nativeImpl.getImplements())
		+ " and no native interpreter registered for class " + sig.getOwner().getName());
    }

}
