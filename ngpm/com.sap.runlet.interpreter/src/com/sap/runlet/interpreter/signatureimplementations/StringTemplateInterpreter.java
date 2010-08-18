package com.sap.runlet.interpreter.signatureimplementations;

import java.lang.reflect.InvocationTargetException;

import ui.templates.StringTemplate;
import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.RunletStackFrame;
import com.sap.runlet.interpreter.objects.NativeObject;
import com.sap.runlet.interpreter.statements.ReturnInterpreter;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.NativeImpl;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.expressions.Expression;

public class StringTemplateInterpreter implements Interpreter<StringTemplate, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    private StringTemplate stringTemplate;
    
    public StringTemplateInterpreter(StringTemplate stringTemplate) {
	this.stringTemplate = stringTemplate;
    }

    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException,
	    NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	StringBuilder result = new StringBuilder();
	RunletStackFrame stackFrame = new RunletStackFrame(/* parent */ interpreter.getCallstack().peek());
	interpreter.getCallstack().push(stackFrame);
	for (Expression segment:stringTemplate.getExpressions()) {
	    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> segmentResult = interpreter.evaluate(segment);
	    for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> singleSegmentResult:segmentResult) {
		result.append(singleSegmentResult);
	    }
	}
	interpreter.getCallstack().pop();
	return new ReturnInterpreter.ReturnResult(
		new NativeObject((ClassTypeDefinition) stringTemplate.getImplementedSignature().getOutput(),
			result.toString(), interpreter.getDefaultSnapshot(), interpreter));
    }

}
