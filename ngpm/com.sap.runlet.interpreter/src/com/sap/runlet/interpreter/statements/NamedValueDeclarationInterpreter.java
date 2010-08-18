package com.sap.runlet.interpreter.statements;

import java.lang.reflect.InvocationTargetException;

import behavioral.actions.NamedValueDeclaration;
import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.EmptyObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.RunletStackFrame;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.NativeImpl;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.expressions.Expression;

public class NamedValueDeclarationInterpreter implements Interpreter<NamedValueDeclaration, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    private NamedValueDeclaration namedValueDeclaration;
    
    public NamedValueDeclarationInterpreter(NamedValueDeclaration variableDeclaration) {
	this.namedValueDeclaration = variableDeclaration;
    }

    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException,
	    NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	Expression initExpression = namedValueDeclaration.getNamedValue().getInitExpression();
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> initValue;
	if (initExpression != null) {
	    initValue = interpreter.evaluate(initExpression);
	} else {
	    // assign a valid EmptyObject
	    initValue = new EmptyObject<AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition>(
		    namedValueDeclaration.getNamedValue().getType(), interpreter.getModelAdapter());
	}
	interpreter.getCallstack().peek().enterValue(namedValueDeclaration.getNamedValue(),
		interpreter.convert(initValue, namedValueDeclaration.getNamedValue().getType()));
	return initValue;
    }

}
