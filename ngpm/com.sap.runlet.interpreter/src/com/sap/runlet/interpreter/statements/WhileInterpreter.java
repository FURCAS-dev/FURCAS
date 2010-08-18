package com.sap.runlet.interpreter.statements;

import java.lang.reflect.InvocationTargetException;

import behavioral.actions.IfElse;
import behavioral.actions.Statement;
import behavioral.actions.WhileLoop;

import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.RunletStackFrame;
import com.sap.runlet.interpreter.objects.NativeObject;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.NativeImpl;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.expressions.Expression;

public class WhileInterpreter implements Interpreter<IfElse, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    
    private WhileLoop whileLoop;
    
    public WhileInterpreter(WhileLoop whileLoop) {
	this.whileLoop = whileLoop;
    }

    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException,
	    NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> result = null;
	while ((Boolean) ((NativeObject) interpreter.evaluate(whileLoop.getCondition())).getNativeObject()) {
	    result = interpreter.evaluateSignatureImplementation(whileLoop.getNestedBlocks().get(0));
	    if (result instanceof ReturnInterpreter.ReturnResult) {
		return result;
	    }
	}
	return result;
    }

}
