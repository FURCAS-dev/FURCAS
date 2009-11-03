package com.sap.river.interpreter.statements;

import java.lang.reflect.InvocationTargetException;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.RiverObject;

import behavioral.actions.ExpressionStatement;

public class ExpressionStatementInterpreter implements Interpreter<ExpressionStatement> {
    private ExpressionStatement expressionStatement;
    
    public ExpressionStatementInterpreter(ExpressionStatement expressionStatement) {
	this.expressionStatement = expressionStatement;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException,
	    NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	return interpreter.evaluate(expressionStatement.getExpression());
    }

}
