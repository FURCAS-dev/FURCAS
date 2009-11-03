package com.sap.river.interpreter.signatureimplementations;

import java.lang.reflect.InvocationTargetException;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import ui.templates.StringTemplate;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.StackFrame;
import com.sap.river.interpreter.objects.NativeObject;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.river.interpreter.statements.ReturnInterpreter;

import data.classes.ClassTypeDefinition;
import dataaccess.expressions.Expression;

public class StringTemplateInterpreter implements Interpreter<StringTemplate> {
    private StringTemplate stringTemplate;
    
    public StringTemplateInterpreter(StringTemplate stringTemplate) {
	this.stringTemplate = stringTemplate;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException,
	    NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	StringBuilder result = new StringBuilder();
	StackFrame stackFrame = new StackFrame(/* parent */ interpreter.getCallstack().peek());
	interpreter.getCallstack().push(stackFrame);
	for (Expression segment:stringTemplate.getExpressions()) {
	    RiverObject segmentResult = interpreter.evaluate(segment);
	    for (RiverObject singleSegmentResult:segmentResult) {
		result.append(singleSegmentResult);
	    }
	}
	interpreter.getCallstack().pop();
	return new ReturnInterpreter.ReturnResult(
		new NativeObject((ClassTypeDefinition) stringTemplate.getImplementedSignature().getOutput(),
			result.toString(), interpreter.getDefaultSnapshot(), interpreter));
    }

}
