package com.sap.finex.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;

import structure.Association;
import structure.Field;
import structure.FinexClass;
import structure.Type;
import behavior.actions.Statement;
import behavior.expressions.Count;
import behavior.expressions.Expression;
import behavior.functions.NativeImpl;
import behavior.functions.SignatureImplementation;

import com.sap.finex.interpreter.FinexInterpreter;
import com.sap.finex.interpreter.FinexStackFrame;
import com.sap.finex.interpreter.objects.FinexNativeObject;
import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

public class CountInterpreter implements Interpreter<Count, FinexClass, Type, FinexClass,
Association, Field, Statement, Expression, SignatureImplementation, FinexStackFrame, NativeImpl, FinexInterpreter> {
    private Count count;

    public CountInterpreter(Count count) {
	this.count = count;
    }

    @Override
    public FinexNativeObject evaluate(FinexInterpreter interpreter) throws JmiException, SecurityException,
	    IllegalArgumentException, NoSuchMethodException, InstantiationException, IllegalAccessException,
	    InvocationTargetException {
	long value = interpreter.evaluate(count.getOperand()).size();
	return new FinexNativeObject((FinexClass) count.getType(), value,
		interpreter.getDefaultSnapshot(), interpreter);
    }

}
