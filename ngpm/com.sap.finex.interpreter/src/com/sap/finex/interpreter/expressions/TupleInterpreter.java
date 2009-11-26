package com.sap.finex.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import structure.Association;
import structure.Field;
import structure.FinexClass;
import structure.Type;
import behavior.actions.Statement;
import behavior.expressions.Alias;
import behavior.expressions.Expression;
import behavior.expressions.Tuple;
import behavior.functions.NativeImpl;
import behavior.functions.SignatureImplementation;

import com.sap.finex.interpreter.FinexInterpreter;
import com.sap.finex.interpreter.FinexStackFrame;
import com.sap.finex.interpreter.FinexValueObject;
import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.ClassTypedObject;
import com.sap.runlet.abstractinterpreter.objects.EmptyObject;
import com.sap.runlet.abstractinterpreter.objects.MultiValuedObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

public class TupleInterpreter
	implements
	Interpreter<Tuple, FinexClass, Type, FinexClass, Association, Field, Statement, Expression, SignatureImplementation, FinexStackFrame, NativeImpl, FinexInterpreter> {
    private Tuple tuple;

    public TupleInterpreter(Tuple oce) {
	this.tuple = oce;
    }

    @Override
    public RunletObject<Field, Type, FinexClass> evaluate(FinexInterpreter interpreter) throws JmiException,
	    SecurityException, IllegalArgumentException, NoSuchMethodException, InstantiationException, IllegalAccessException,
	    InvocationTargetException {
	List<RunletObject<Field, Type, FinexClass>> resultObjects = new ArrayList<RunletObject<Field, Type, FinexClass>>();
	RunletObject<Field, Type, FinexClass> operand = interpreter.evaluate(tuple.getOperand());
	Alias operandAlias = tuple.getOperand().getAlias();
	FinexStackFrame currentStackFrame = interpreter.getCallstack().peek();
	if (operandAlias != null) {
	    currentStackFrame.enterValue(operandAlias.getName(), new EmptyObject<Field, FinexClass, Type, FinexClass>(
		    operandAlias.getType(), interpreter.getModelAdapter()));
	}
	// TODO can there be outer joins for Tuple expressions such that when no operand results, there shall still be one tuple?
	for (RunletObject<Field, Type, FinexClass> o : operand) {
	    if (operandAlias != null) {
		currentStackFrame.setValue(operandAlias.getName(), o);
	    }
	    HashMap<Field, Collection<ClassTypedObject<Field, Type, FinexClass>>> fieldValues = new HashMap<Field, Collection<ClassTypedObject<Field, Type, FinexClass>>>();
	    Set<Field> allFieldsWithDefault = new HashSet<Field>(tuple.getType().getFieldsWithDefaultValue());
	    for (Field fieldWithDefault : allFieldsWithDefault) {
		try {
		    FinexStackFrame frame = new FinexStackFrame(interpreter.getCallstack().peek());
		    interpreter.push(frame);
		    RunletObject<Field, Type, FinexClass> value = interpreter.evaluate(fieldWithDefault.getDefaultValue());
		    Collection<ClassTypedObject<Field, Type, FinexClass>> flattenedValues = new ArrayList<ClassTypedObject<Field, Type, FinexClass>>();
		    fieldValues.put(fieldWithDefault, flattenedValues);
		    for (RunletObject<Field, Type, FinexClass> vo : value.flatten()) {
			flattenedValues.add((ClassTypedObject<Field, Type, FinexClass>) vo);
		    }
		} finally {
		    interpreter.pop();
		}
	    }
	    FinexValueObject singleResult = interpreter.createValueObject((FinexClass) tuple.getType(), fieldValues);
	    resultObjects.add(singleResult);
	}
	return FinexInterpreter.turnIntoObjectOfAppropriateMultiplicity(tuple.getType(), interpreter,
		resultObjects, operand instanceof MultiValuedObject);
    }

}
