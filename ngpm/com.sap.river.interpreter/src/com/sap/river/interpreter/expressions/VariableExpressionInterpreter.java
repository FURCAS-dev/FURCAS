package com.sap.river.interpreter.expressions;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import dataaccess.expressions.VariableExpression;

public class VariableExpressionInterpreter implements Interpreter<VariableExpression> {
    
    private VariableExpression variableExpression;
    
    public VariableExpressionInterpreter(VariableExpression variableExpression) {
	this.variableExpression = variableExpression;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException {
	return interpreter.getCallstack().peek().getValue(variableExpression.getVariable());
    }

}
