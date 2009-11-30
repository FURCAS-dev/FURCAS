package com.sap.finex.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;

import structure.Association;
import structure.Field;
import structure.FinexClass;
import structure.Type;
import behavior.actions.Statement;
import behavior.expressions.Expression;
import behavior.expressions.NumericAggregate;
import behavior.functions.NativeImpl;
import behavior.functions.SignatureImplementation;

import com.sap.finex.interpreter.FinexInterpreter;
import com.sap.finex.interpreter.FinexStackFrame;
import com.sap.finex.interpreter.objects.FinexNativeObject;
import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.abstractinterpreter.util.Fraction;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

public class NumericAggregateInterpreter
	implements
	Interpreter<NumericAggregate, FinexClass, Type, FinexClass, Association, Field, Statement, Expression,
	SignatureImplementation, FinexStackFrame, NativeImpl, FinexInterpreter> {
    private NumericAggregate agg;
    
    public NumericAggregateInterpreter(NumericAggregate agg) {
	this.agg = agg;
    }

    @Override
    public FinexNativeObject evaluate(FinexInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException, JmiException, NoSuchMethodException, InstantiationException, IllegalAccessException,
	    InvocationTargetException {
	Fraction result;
	FinexNativeObject runletResult;
	String opName = agg.getOperator();
	RunletObject<Field, Type, FinexClass> operand = interpreter.evaluate(agg.getOperand());
	if (opName.equals("sum")) {
	    result = Fraction.ZERO;
	    for (RunletObject<Field, Type, FinexClass> o : operand.flatten()) {
		Object next = ((FinexNativeObject) o).getNativeObject();
		if (next instanceof Fraction) {
		    result = result.plus((Fraction) next);
		} else {
		    result = result.plus(new Fraction((Long) next));
		}
	    }
	} else {
	    throw new RuntimeException("Numeric aggregate "+opName+" not (yet) supported");
	}
	runletResult = interpreter.convertFractionToNativeObject(result, agg.getType());
	interpreter.getCallstack().peek().getAliasValues().usedAllOf(operand, agg.getOperand(), runletResult, agg);
	return runletResult;
    }

}
