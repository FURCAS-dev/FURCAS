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
	FinexStackFrame currentStackFrame = interpreter.getCallstack().peek();
	// TODO can there be outer joins for filter expressions such that when no operand results, there shall still be one tuple?
	RunletObject<Field, Type, FinexClass> result;
	List<RunletObject<Field, Type, FinexClass>> filteredResults = new LinkedList<RunletObject<Field, Type, FinexClass>>();
	for (RunletObject<Field, Type, FinexClass> o : operand.flatten()) {
	    // TODO if o has alias, put alias value on stack frame
	    FinexStackFrame conditionFrame = new FinexStackFrame(interpreter.getCallstack().peek());
	    conditionFrame.setImplicitContext(o);
	    conditionFrame.enterCurrentAliasValues(fe.getOperand(), o);
	    interpreter.push(conditionFrame);
	    try {
		if ((Boolean) ((FinexNativeObject) interpreter.evaluate(condition)).getNativeObject()) {
		    filteredResults.add(o);
		    currentStackFrame.getAliasValues().used(o, fe.getOperand(), o, fe);
		}
	    } finally {
		interpreter.pop();
	    }
	}
	result = FinexInterpreter.turnIntoObjectOfAppropriateMultiplicity(fe.getType(), interpreter, filteredResults,
							 operand instanceof MultiValuedObject<?, ?, ?>);
	return result;
    }
    
}
