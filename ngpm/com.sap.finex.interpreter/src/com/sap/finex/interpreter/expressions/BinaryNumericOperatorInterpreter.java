package com.sap.finex.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

import structure.Association;
import structure.Field;
import structure.FinexClass;
import structure.Type;
import behavior.actions.Statement;
import behavior.expressions.BinaryNumericOperator;
import behavior.expressions.Expression;
import behavior.functions.NativeImpl;
import behavior.functions.SignatureImplementation;

import com.sap.finex.interpreter.FinexInterpreter;
import com.sap.finex.interpreter.FinexStackFrame;
import com.sap.finex.interpreter.objects.FinexNativeObject;
import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.abstractinterpreter.util.Fraction;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

public class BinaryNumericOperatorInterpreter
	implements
	Interpreter<BinaryNumericOperator, FinexClass, Type, FinexClass, Association, Field, Statement, Expression,
	SignatureImplementation, FinexStackFrame, NativeImpl, FinexInterpreter> {
    private BinaryNumericOperator op;
    
    public BinaryNumericOperatorInterpreter(BinaryNumericOperator op) {
	this.op = op;
    }

    @Override
    public FinexNativeObject evaluate(FinexInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException, JmiException, NoSuchMethodException, InstantiationException, IllegalAccessException,
	    InvocationTargetException {
	Fraction result;
	FinexNativeObject runletResult;
	String opName = op.getOperator();
	RunletObject<Field, Type, FinexClass> left = interpreter.evaluate(op.getLeft());
	RunletObject<Field, Type, FinexClass> right = interpreter.evaluate(op.getRight());
	if (opName.equals(">") || opName.equals(">=") || opName.equals("<") ||
		opName.equals("<=") || opName.equals("==")) {
	    // comparison operators with boolean result
	    Iterator<RunletObject<Field, Type, FinexClass>> leftFlatIter = left.flatten().iterator();
	    Object nextLeft = ((FinexNativeObject) leftFlatIter.next()).getNativeObject();
	    if (nextLeft instanceof Long) {
		nextLeft = new Fraction((Long) nextLeft);
	    }
	    Iterator<RunletObject<Field, Type, FinexClass>> rightFlatIter = right.flatten().iterator();
	    Object nextRight = ((FinexNativeObject) rightFlatIter.next()).getNativeObject();
	    if (nextRight instanceof Long) {
		nextRight = new Fraction((Long) nextRight);
	    }
	    int comparison = ((Fraction) nextLeft).compareTo((Fraction) nextRight);
	    boolean boolResult = false;
	    if (opName.equals(">")) {
		boolResult = comparison > 0;
	    } else if (opName.equals(">=")) {
		boolResult = comparison >= 0;
	    } else if (opName.equals("<")) {
		boolResult = comparison < 0;
	    } else if (opName.equals("<=")) {
		boolResult = comparison <= 0;
	    } else if (opName.equals("==")) {
		boolResult = comparison == 0;
	    }
	    runletResult = new FinexNativeObject((FinexClass) op.getType(), boolResult,
		    interpreter.getDefaultSnapshot(), interpreter);
	} else {
	    // non-comparison operators with numeric result:
	    if (opName.equals("*")) {
		result = Fraction.ONE;
		Iterator<RunletObject<Field, Type, FinexClass>> leftFlatIter = left.flatten().iterator();
		while (!result.equals(Fraction.ZERO) && leftFlatIter.hasNext()) {
		    Object next = ((FinexNativeObject) leftFlatIter.next()).getNativeObject();
		    if (next instanceof Fraction) {
			result = result.times((Fraction) next);
		    } else {
			result = result.times(new Fraction((Long) next));
		    }
		}
		if (!result.equals(Fraction.ZERO)) {
		    Iterator<RunletObject<Field, Type, FinexClass>> rightFlatIter = right.flatten().iterator();
		    while (!result.equals(Fraction.ZERO) && rightFlatIter.hasNext()) {
			Object next = ((FinexNativeObject) rightFlatIter.next()).getNativeObject();
			if (next instanceof Fraction) {
			    result = result.times((Fraction) next);
			} else {
			    result = result.times(new Fraction((Long) next));
			}
		    }
		}
	    } else if (opName.equals("/")) {
		result = Fraction.ONE;
		Iterator<RunletObject<Field, Type, FinexClass>> leftFlatIter = left.flatten().iterator();
		while (!result.equals(Fraction.ZERO) && leftFlatIter.hasNext()) {
		    Object next = ((FinexNativeObject) leftFlatIter.next()).getNativeObject();
		    if (next instanceof Fraction) {
			result = result.times((Fraction) next);
		    } else {
			result = result.times(new Fraction((Long) next));
		    }
		}
		if (!result.equals(Fraction.ZERO)) {
		    Iterator<RunletObject<Field, Type, FinexClass>> rightFlatIter = right.flatten().iterator();
		    while (!result.equals(Fraction.ZERO) && rightFlatIter.hasNext()) {
			Object next = ((FinexNativeObject) rightFlatIter.next()).getNativeObject();
			if (next instanceof Fraction) {
			    result = result.dividedBy((Fraction) next);
			} else {
			    result = result.dividedBy(new Fraction((Long) next));
			}
		    }
		}
	    } else if (opName.equals("+")) {
		result = Fraction.ZERO;
		Iterator<RunletObject<Field, Type, FinexClass>> leftFlatIter = left.flatten().iterator();
		while (leftFlatIter.hasNext()) {
		    Object next = ((FinexNativeObject) leftFlatIter.next()).getNativeObject();
		    if (next instanceof Fraction) {
			result = result.plus((Fraction) next);
		    } else {
			result = result.plus(new Fraction((Long) next));
		    }
		}
		Iterator<RunletObject<Field, Type, FinexClass>> rightFlatIter = right.flatten().iterator();
		while (rightFlatIter.hasNext()) {
		    Object next = ((FinexNativeObject) rightFlatIter.next()).getNativeObject();
		    if (next instanceof Fraction) {
			result = result.plus((Fraction) next);
		    } else {
			result = result.plus(new Fraction((Long) next));
		    }
		}
	    } else if (opName.equals("-")) {
		result = Fraction.ZERO;
		Iterator<RunletObject<Field, Type, FinexClass>> leftFlatIter = left.flatten().iterator();
		while (leftFlatIter.hasNext()) {
		    Object next = ((FinexNativeObject) leftFlatIter.next()).getNativeObject();
		    if (next instanceof Fraction) {
			result = result.plus((Fraction) next);
		    } else {
			result = result.plus(new Fraction((Long) next));
		    }
		}
		Iterator<RunletObject<Field, Type, FinexClass>> rightFlatIter = right.flatten().iterator();
		while (rightFlatIter.hasNext()) {
		    Object next = ((FinexNativeObject) rightFlatIter.next()).getNativeObject();
		    if (next instanceof Fraction) {
			result = result.minus((Fraction) next);
		    } else {
			result = result.minus(new Fraction((Long) next));
		    }
		}
	    } else {
		// TODO add support for less, greater, equals, lessEquals, greaterEquals
		throw new RuntimeException("Unknown binary numeric operator " + opName);
	    }
	    runletResult = interpreter.convertFractionToNativeObject(result, op.getType());
	}
	interpreter.getCallstack().peek().getAliasValues().usedAllOf(left, op.getLeft(), runletResult, op);
	interpreter.getCallstack().peek().getAliasValues().usedAllOf(right, op.getRight(), runletResult, op);
	return runletResult;
    }

}
