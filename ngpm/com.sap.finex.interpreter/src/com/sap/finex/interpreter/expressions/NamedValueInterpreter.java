package com.sap.finex.interpreter.expressions;

import structure.Association;
import structure.Field;
import structure.FinexClass;
import structure.Type;
import behavior.actions.Statement;
import behavior.expressions.Expression;
import behavior.expressions.NamedValueExpression;
import behavior.functions.NativeImpl;
import behavior.functions.SignatureImplementation;

import com.sap.finex.interpreter.FinexInterpreter;
import com.sap.finex.interpreter.FinexStackFrame;
import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

public class NamedValueInterpreter implements Interpreter<NamedValueExpression, FinexClass, Type, FinexClass,
Association, Field, Statement, Expression, SignatureImplementation, FinexStackFrame, NativeImpl, FinexInterpreter> {
    private NamedValueExpression nve;

    public NamedValueInterpreter(NamedValueExpression nve) {
	this.nve = nve;
    }

    @Override
    public RunletObject<Field, Type, FinexClass> evaluate(FinexInterpreter interpreter) throws JmiException, SecurityException,
	    IllegalArgumentException {
	return interpreter.getCallstack().peek().getValue(nve.getNamedValue().getName());
    }

}
