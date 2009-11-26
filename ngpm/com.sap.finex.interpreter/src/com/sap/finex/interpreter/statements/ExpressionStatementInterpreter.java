package com.sap.finex.interpreter.statements;

import java.lang.reflect.InvocationTargetException;

import structure.Association;
import structure.Field;
import structure.FinexClass;
import structure.Type;
import behavior.actions.ExpressionStatement;
import behavior.actions.Statement;
import behavior.expressions.Expression;
import behavior.functions.NativeImpl;
import behavior.functions.SignatureImplementation;

import com.sap.finex.interpreter.FinexInterpreter;
import com.sap.finex.interpreter.FinexStackFrame;
import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

public class ExpressionStatementInterpreter
	implements
	Interpreter<ExpressionStatement, FinexClass, Type, FinexClass, Association, Field, Statement, Expression,
	SignatureImplementation, FinexStackFrame, NativeImpl, FinexInterpreter> {
    private ExpressionStatement expressionStatement;

    public ExpressionStatementInterpreter(ExpressionStatement expressionStatement) {
	this.expressionStatement = expressionStatement;
    }

    @Override
    public RunletObject<Field, Type, FinexClass> evaluate(FinexInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException, JmiException, NoSuchMethodException, InstantiationException, IllegalAccessException,
	    InvocationTargetException {
	// remove aliases from stack frame
	FinexStackFrame frame = new FinexStackFrame(interpreter.getCallstack().peek());
	try {
	    interpreter.push(frame);
	    RunletObject<Field, Type, FinexClass> result = interpreter.evaluate(expressionStatement.getExpression());
	    return result;
	} finally {
	    interpreter.pop();
	}
    }

}
