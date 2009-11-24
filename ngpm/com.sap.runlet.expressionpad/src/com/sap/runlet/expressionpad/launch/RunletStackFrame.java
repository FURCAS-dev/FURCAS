package com.sap.runlet.expressionpad.launch;

import java.util.Map;

import com.sap.runlet.abstractinterpreter.AbstractObjectFormatter;
import com.sap.runlet.abstractinterpreter.StackFrame;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;

import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;

public class RunletStackFrame
extends AbstractRunletStackFrame<AssociationEnd, TypeDefinition, ClassTypeDefinition, SignatureImplementation> {
    public RunletStackFrame(RunletThread runletThread, RunletDebugTarget debugTarget,
	    StackFrame<AssociationEnd, TypeDefinition, ClassTypeDefinition, SignatureImplementation> stackFrame, AbstractObjectFormatter<AssociationEnd, TypeDefinition, ClassTypeDefinition, SignatureImplementation> formatter) {
	super(runletThread, debugTarget, stackFrame, formatter);
    }
    protected RunletVariable createVariable(
	    Map<String, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> allVisibleVariables, String varName) {
	return new RunletVariable(varName, allVisibleVariables.get(varName), getDebugTarget(), getFormatter());
    }
}
