package com.sap.finex.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

import structure.Association;
import structure.Field;
import structure.FinexClass;
import structure.Type;
import behavior.actions.Statement;
import behavior.expressions.Expression;
import behavior.expressions.FilterExpression;
import behavior.functions.NativeImpl;
import behavior.functions.SignatureImplementation;

import com.sap.finex.interpreter.FinexInterpreter;
import com.sap.finex.interpreter.FinexStackFrame;
import com.sap.finex.interpreter.objects.FinexNativeObject;
import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.MultiValuedObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

public class FilterExpressionInterpreter
implements Interpreter<FilterExpression, FinexClass, Type, FinexClass, Association, Field,
Statement, Expression, SignatureImplementation, FinexStackFrame, NativeImpl, FinexInterpreter> {
    private FilterExpression fe;
    
    public FilterExpressionInterpreter(FilterExpression fe) {
	this.fe = fe;
    }

    @Override
    public RunletObject<Field, Type, FinexClass> evaluate(FinexInterpreter interpreter)
    throws JmiException, SecurityException, IllegalArgumentException, NoSuchMethodException,
    InstantiationException, IllegalAccessException, InvocationTargetException {
	RunletObject<Field, Type, FinexClass> operand = interpreter.evaluate(fe.getOperand());
	Expression condition = fe.getCondition();
	RunletObject<Field, Type, FinexClass> result;
	List<RunletObject<Field, Type, FinexClass>> filteredResults = new LinkedList<RunletObject<Field, Type, FinexClass>>();
	for (RunletObject<Field, Type, FinexClass> o : operand) {
	    FinexStackFrame conditionFrame = new FinexStackFrame(interpreter.getCallstack().peek());
	    conditionFrame.setImplicitContext(o);
	    interpreter.push(conditionFrame);
	    try {
		if ((Boolean) ((FinexNativeObject) interpreter.evaluate(condition)).getNativeObject()) {
		    filteredResults.add(o);
		}
	    } finally {
		interpreter.pop();
	    }
	}
	result = FinexInterpreter.turnIntoObjectOfAppropriateMultiplicity(fe.getType(), interpreter, filteredResults,
							 operand instanceof MultiValuedObject);
	return result;
    }
    
}
