package com.sap.finex.interpreter.expressions;

import structure.Association;
import structure.Field;
import structure.FinexClass;
import structure.Type;
import behavior.actions.Statement;
import behavior.expressions.Expression;
import behavior.expressions.This;
import behavior.functions.NativeImpl;
import behavior.functions.SignatureImplementation;

import com.sap.finex.interpreter.FinexInterpreter;
import com.sap.finex.interpreter.FinexStackFrame;
import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

public class ThisInterpreter
implements Interpreter<This, FinexClass, Type, FinexClass, Association, Field,
Statement, Expression, SignatureImplementation, FinexStackFrame, NativeImpl, FinexInterpreter> {
    public ThisInterpreter(This ic) {
    }

    @Override
    public RunletObject<Field, Type, FinexClass> evaluate(FinexInterpreter interpreter)
    throws JmiException, SecurityException, IllegalArgumentException {
	FinexStackFrame frame = interpreter.getCallstack().peek();
	return frame.getThis();
    }
    
}
