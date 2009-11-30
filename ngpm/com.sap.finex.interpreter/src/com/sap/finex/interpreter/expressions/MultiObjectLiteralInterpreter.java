package com.sap.finex.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import structure.Association;
import structure.Field;
import structure.FinexClass;
import structure.Type;
import behavior.actions.Statement;
import behavior.expressions.Expression;
import behavior.expressions.literals.MultiObjectLiteral;
import behavior.functions.NativeImpl;
import behavior.functions.SignatureImplementation;

import com.sap.finex.interpreter.FinexInterpreter;
import com.sap.finex.interpreter.FinexStackFrame;
import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.MultiValuedObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;

public class MultiObjectLiteralInterpreter
	implements
	Interpreter<MultiObjectLiteral, FinexClass, Type, FinexClass, Association, Field, Statement, Expression, SignatureImplementation, FinexStackFrame, NativeImpl, FinexInterpreter> {
    
    private MultiObjectLiteral literal;

    public MultiObjectLiteralInterpreter(MultiObjectLiteral literal) {
	this.literal = literal;
    }

    @Override
    public RunletObject<Field, Type, FinexClass> evaluate(FinexInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException, NoSuchMethodException, InstantiationException, IllegalAccessException,
	    InvocationTargetException {
	FinexStackFrame frame = interpreter.getCallstack().peek();
	List<RunletObject<Field, Type, FinexClass>> values = new ArrayList<RunletObject<Field, Type, FinexClass>>(literal
		.getElements().size());
	Map<Expression, RunletObject<Field, Type, FinexClass>> elementsToValues = new HashMap<Expression, RunletObject<Field, Type, FinexClass>>();
	for (Expression element : literal.getElements()) {
	    RunletObject<Field, Type, FinexClass> value = interpreter.evaluate(element);
	    values.add(value);
	    elementsToValues.put(element, value);
	}
	MultiValuedObject<Field, Type, FinexClass> result = new MultiValuedObject<Field, Type, FinexClass>(literal.getType(),
		values, /* ordered */true, /* unique */false);
	for (Expression e : elementsToValues.keySet()) {
	    for (RunletObject<Field, Type, FinexClass> singleResultObject : result) {
		frame.getAliasValues().used(elementsToValues.get(e), e, singleResultObject, literal);
	    }
	}
	return result;
    }

}
