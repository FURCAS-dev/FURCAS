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
import behavior.expressions.PathExpression;
import behavior.functions.NativeImpl;
import behavior.functions.SignatureImplementation;

import com.sap.finex.interpreter.FinexInterpreter;
import com.sap.finex.interpreter.FinexStackFrame;
import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.ClassTypedObject;
import com.sap.runlet.abstractinterpreter.objects.MultiValuedObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

public class PathExpressionInterpreter
implements Interpreter<PathExpression, FinexClass, Type, FinexClass, Association, Field,
Statement, Expression, SignatureImplementation, FinexStackFrame, NativeImpl, FinexInterpreter> {
    private PathExpression pe;
    
    public PathExpressionInterpreter(PathExpression pe) {
	this.pe = pe;
    }

    @Override
    public RunletObject<Field, Type, FinexClass> evaluate(FinexInterpreter interpreter)
    throws JmiException, SecurityException, IllegalArgumentException, NoSuchMethodException,
    InstantiationException, IllegalAccessException, InvocationTargetException {
	RunletObject<Field, Type, FinexClass> operand = interpreter.evaluate(pe.getOperand());
	List<RunletObject<Field, Type, FinexClass>> resultList = new LinkedList<RunletObject<Field, Type, FinexClass>>();
	for (RunletObject<Field, Type, FinexClass> o : operand) {
	    resultList.add(interpreter.navigate((ClassTypedObject<Field, Type, FinexClass>) o, pe.getField()));
	}
	// TODO what about orderedness and uniqueness?
	return FinexInterpreter.turnIntoObjectOfAppropriateMultiplicity(pe.getType(), interpreter,
		resultList, operand instanceof MultiValuedObject);
    }
    
}
