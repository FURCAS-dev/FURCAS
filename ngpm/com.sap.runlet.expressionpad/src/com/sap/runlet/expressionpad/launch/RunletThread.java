package com.sap.runlet.expressionpad.launch;

import org.eclipse.debug.core.ILaunch;

import com.sap.runlet.abstractinterpreter.AbstractObjectFormatter;
import com.sap.runlet.abstractinterpreter.AbstractRunletInterpreter;
import com.sap.runlet.abstractinterpreter.StackFrame;
import com.sap.runlet.interpreter.RunletObjectFormatter;

import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;

public class RunletThread extends AbstractRunletThread  {
    public RunletThread(AbstractRunletInterpreter<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> interpreter,
	    ILaunch launch, RunletDebugTarget debugTarget,
	    AbstractObjectFormatter<?, ?, ?, ?> formatter) {
	super(interpreter, launch, debugTarget, formatter);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected RunletStackFrame createStackFrame(StackFrame<?, ?, ?, ?> frame) {
	return new RunletStackFrame(this, getDebugTarget(), (StackFrame<AssociationEnd, TypeDefinition, ClassTypeDefinition, SignatureImplementation>) frame, (RunletObjectFormatter) getFormatter());
    }
}
