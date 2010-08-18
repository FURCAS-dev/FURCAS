package com.sap.runlet.interpreter.statements;

import java.lang.reflect.InvocationTargetException;

import behavioral.actions.IfElse;
import behavioral.actions.Statement;

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

public class IfInterpreter implements Interpreter<IfElse, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    
    private IfElse ifElse;
    
    public IfInterpreter(IfElse ifElse) {
	this.ifElse = ifElse;
    }

    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException,
	    NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> result = null;
	if ((Boolean) ((NativeObject) interpreter.evaluate(ifElse.getCondition())).getNativeObject()) {
	    result = interpreter.evaluateSignatureImplementation(ifElse.getIfBlock());
	} else if (ifElse.getElseBlock() != null) {
	    result = interpreter.evaluateSignatureImplementation(ifElse.getElseBlock());
	}
	return result;
    }

}
