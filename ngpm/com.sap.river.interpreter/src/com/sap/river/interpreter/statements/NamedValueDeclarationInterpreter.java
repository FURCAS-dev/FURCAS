package com.sap.river.interpreter.statements;

import java.lang.reflect.InvocationTargetException;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import behavioral.actions.NamedValueDeclaration;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.EmptyObject;
import com.sap.river.interpreter.objects.RiverObject;

import dataaccess.expressions.Expression;

public class NamedValueDeclarationInterpreter implements Interpreter<NamedValueDeclaration> {
    private NamedValueDeclaration namedValueDeclaration;
    
    public NamedValueDeclarationInterpreter(NamedValueDeclaration variableDeclaration) {
	this.namedValueDeclaration = variableDeclaration;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException,
	    NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	Expression initExpression = namedValueDeclaration.getNamedValue().getInitExpression();
	RiverObject initValue;
	if (initExpression != null) {
	    initValue = interpreter.evaluate(initExpression);
	} else {
	    // assign a valid EmptyObject
	    initValue = new EmptyObject(namedValueDeclaration.getNamedValue().getType());
	}
	interpreter.getCallstack().peek().enterValue(namedValueDeclaration.getNamedValue(),
		interpreter.convert(initValue, namedValueDeclaration.getNamedValue().getType()));
	return initValue;
    }

}
