package com.sap.finex.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;

import structure.Association;
import structure.Field;
import structure.FinexClass;
import structure.Type;
import behavior.actions.Statement;
import behavior.expressions.Equals;
import behavior.expressions.Expression;
import behavior.functions.NativeImpl;
import behavior.functions.SignatureImplementation;

import com.sap.finex.interpreter.FinexInterpreter;
import com.sap.finex.interpreter.FinexStackFrame;
import com.sap.finex.interpreter.objects.FinexNativeObject;
import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

public class EqualsInterpreter
	implements
	Interpreter<Equals, FinexClass, Type, FinexClass, Association, Field, Statement, Expression,
	SignatureImplementation, FinexStackFrame, NativeImpl, FinexInterpreter> {
    private Equals eq;
    
    public EqualsInterpreter(Equals eq) {
	this.eq = eq;
    }

    @Override
    public FinexNativeObject evaluate(FinexInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException, JmiException, NoSuchMethodException, InstantiationException, IllegalAccessException,
	    InvocationTargetException {
	RunletObject<Field, Type, FinexClass> left = interpreter.evaluate(eq.getLeft());
	RunletObject<Field, Type, FinexClass> right = interpreter.evaluate(eq.getRight());
	FinexNativeObject result = new FinexNativeObject((FinexClass) eq.getType(),
		left.logicallyEquals(right), interpreter.getDefaultSnapshot(), interpreter);
	return result; 
    }

}
