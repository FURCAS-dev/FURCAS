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
import com.sap.finex.metamodel.utils.MetamodelUtils;
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
	String opName = op.getOperator();
	RunletObject<Field, Type, FinexClass> left = interpreter.evaluate(op.getLeft());
	RunletObject<Field, Type, FinexClass> right = interpreter.evaluate(op.getRight());
	if (opName.equals("*")) {
	    result = Fraction.ONE;
	    Iterator<RunletObject<Field, Type, FinexClass>> leftFlatIter = left.flatten().iterator();
	    while (!result.equals(Fraction.ZERO)&& leftFlatIter.hasNext()) {
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
	    while (!result.equals(Fraction.ZERO)&& leftFlatIter.hasNext()) {
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
	    throw new RuntimeException("Unknown binary boolean operator " + opName);
	}
	if (op.getType().equals(MetamodelUtils.findClass(interpreter.getConnection(), "Decimal"))) {
	    // decimals are represented as Fractions, we're okay
	    return new FinexNativeObject((FinexClass) op.getType(), result, interpreter.getDefaultSnapshot(), interpreter);
	} else {
	    // Integers are represented as long; convert
	    return new FinexNativeObject((FinexClass) op.getType(), result.asLong(), interpreter.getDefaultSnapshot(),
		    interpreter);
	}
    }

}
