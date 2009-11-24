package com.sap.finex.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

import structure.Association;
import structure.Field;
import structure.FinexClass;
import structure.Type;
import behavior.actions.Statement;
import behavior.expressions.BinaryBooleanOperator;
import behavior.expressions.Expression;
import behavior.functions.NativeImpl;
import behavior.functions.SignatureImplementation;

import com.sap.finex.interpreter.FinexInterpreter;
import com.sap.finex.interpreter.FinexStackFrame;
import com.sap.finex.interpreter.objects.FinexNativeObject;
import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

public class BinaryBooleanOperatorInterpreter
	implements
	Interpreter<BinaryBooleanOperator, FinexClass, Type, FinexClass, Association, Field, Statement, Expression,
	SignatureImplementation, FinexStackFrame, NativeImpl, FinexInterpreter> {
    private BinaryBooleanOperator op;
    
    public BinaryBooleanOperatorInterpreter(BinaryBooleanOperator op) {
	this.op = op;
    }

    @Override
    public FinexNativeObject evaluate(FinexInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException, JmiException, NoSuchMethodException, InstantiationException, IllegalAccessException,
	    InvocationTargetException {
	String opName = op.getOperator();
	RunletObject<Field, Type, FinexClass> left = interpreter.evaluate(op.getLeft());
	RunletObject<Field, Type, FinexClass> right = interpreter.evaluate(op.getRight());
	if (opName.equals("and")) {
	    boolean result = true;
	    Iterator<RunletObject<Field, Type, FinexClass>> leftFlatIter = left.flatten().iterator();
	    while (result && leftFlatIter.hasNext()) {
		result = result && (Boolean) ((FinexNativeObject) leftFlatIter.next()).getNativeObject();
	    }
	    if (result) {
		Iterator<RunletObject<Field, Type, FinexClass>> rightFlatIter = right.flatten().iterator();
		while (result && rightFlatIter.hasNext()) {
		    result = result && (Boolean) ((FinexNativeObject) rightFlatIter.next()).getNativeObject();
		}
	    }
	    return new FinexNativeObject((FinexClass) op.getType(), result, interpreter.getDefaultSnapshot(), interpreter);
	} else if (opName.equals("or")) {
	    boolean result = false;
	    Iterator<RunletObject<Field, Type, FinexClass>> leftFlatIter = left.flatten().iterator();
	    while (!result && leftFlatIter.hasNext()) {
		result = result || (Boolean) ((FinexNativeObject) leftFlatIter.next()).getNativeObject();
	    }
	    if (!result) {
		Iterator<RunletObject<Field, Type, FinexClass>> rightFlatIter = right.flatten().iterator();
		while (!result && rightFlatIter.hasNext()) {
		    result = result || (Boolean) ((FinexNativeObject) rightFlatIter.next()).getNativeObject();
		}
	    }
	    return new FinexNativeObject((FinexClass) op.getType(), result, interpreter.getDefaultSnapshot(), interpreter);
	} else {
	    throw new RuntimeException("Unknown binary boolean operator " + opName);
	}
    }

}
