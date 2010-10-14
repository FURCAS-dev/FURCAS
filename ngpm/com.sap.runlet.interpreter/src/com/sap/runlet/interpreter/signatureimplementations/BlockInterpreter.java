package com.sap.runlet.interpreter.signatureimplementations;

import java.lang.reflect.InvocationTargetException;

import behavioral.actions.Block;
import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.RunletStackFrame;
import com.sap.runlet.interpreter.statements.ReturnInterpreter;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.NativeImpl;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.expressions.Expression;

public class BlockInterpreter implements Interpreter<Block, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    private Block block;
    
    public BlockInterpreter(Block block) {
	this.block = block;
    }

    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException,
	    NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> result = null;
	RunletStackFrame stackFrame =
	    new RunletStackFrame(/* parent */ interpreter.getCallstack().peek());
	interpreter.getCallstack().push(stackFrame);
	for (Statement statement:block.getStatements()) {
	    result = interpreter.evaluateStatement(statement);
	    if (result instanceof ReturnInterpreter.ReturnResult) {
		// The ReturnInterpreter is expected to already have popped the stack frame
		break;
	    }
	}
	interpreter.getCallstack().pop();
	return result;
    }

}
