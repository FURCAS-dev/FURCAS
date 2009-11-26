package com.sap.finex.interpreter.expressions;

import structure.Association;
import structure.Field;
import structure.FinexClass;
import structure.Type;
import behavior.actions.Statement;
import behavior.expressions.Expression;
import behavior.expressions.ImplicitContext;
import behavior.functions.NativeImpl;
import behavior.functions.SignatureImplementation;

import com.sap.finex.interpreter.FinexInterpreter;
import com.sap.finex.interpreter.FinexStackFrame;
import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

public class ImplicitContextInterpreter
implements Interpreter<ImplicitContext, FinexClass, Type, FinexClass, Association, Field,
Statement, Expression, SignatureImplementation, FinexStackFrame, NativeImpl, FinexInterpreter> {
    public ImplicitContextInterpreter(ImplicitContext ic) {
    }

    @Override
    public RunletObject<Field, Type, FinexClass> evaluate(FinexInterpreter interpreter)
    throws JmiException, SecurityException, IllegalArgumentException {
	FinexStackFrame frame = interpreter.getCallstack().peek();
	RunletObject<Field, Type, FinexClass> result = frame.getImplicitContext();
	if (result == null) {
	    result = frame.getThis();
	}
	return result;
    }
    
}
