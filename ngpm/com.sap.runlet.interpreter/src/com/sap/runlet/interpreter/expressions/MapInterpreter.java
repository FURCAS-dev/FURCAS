package com.sap.runlet.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.EmptyObject;
import com.sap.runlet.abstractinterpreter.objects.MultiValuedObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.RunletStackFrame;
import com.sap.runlet.interpreter.objects.FunctionObject;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.NativeImpl;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.expressions.Expression;
import dataaccess.expressions.Map;

public class MapInterpreter implements Interpreter<Map, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {

    private Map mapExpr;

    public MapInterpreter(Map mapExpr) {
	this.mapExpr = mapExpr;
    }

    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException, JmiException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	TypeDefinition mapExprType = mapExpr.getType();
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> o = interpreter.evaluate(mapExpr.getObject());
	// f is currently expected to be a single function object;
	// mapping with multiple functions concurrently may be supported in the future
	FunctionObject f = (FunctionObject) interpreter.evaluate(mapExpr.getArgument());
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> result = null;
	Collection<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> resultCollection = null;
	boolean pushed = false;
	try {
	    // TODO check use of flatten() once NestedTypeDefinition use has been finalized
	    // TODO parallelize
	    for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> singleO : o) {
		List<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> parameterValues = new ArrayList<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>(1);
		parameterValues.add(singleO);
		RunletStackFrame newStackFrame =
		    interpreter.pushArgumentsToStackFrame(parameterValues, f);
		pushed = true;
		interpreter.push(newStackFrame); // TODO this must not happen before function expression has been evaluated (errr... why again?)
		RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluationResult = f.evaluate(interpreter);
		if (result != null) {
		    // already a result; this is a "many" case; put previous and this result into collection
		    resultCollection = RunletObject.createCollection(
			    mapExprType.isOrdered(), mapExprType.isUnique());
		    resultCollection.add(result);
		    result = null;
		    resultCollection.add(evaluationResult);
		} else {
		    result = evaluationResult;
		}
	    }
	} finally {
	    if (pushed) {
		interpreter.pop();
	    }
	}
	if (mapExprType != null) {
	    if (resultCollection != null) {
		result = new MultiValuedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>(
			mapExprType, resultCollection, mapExprType.isOrdered(), mapExprType.isUnique());
	    } else {
		if (result == null) {
		    // non-void return type; return valid EmptyObject
		    result = new EmptyObject<AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition>(mapExprType, interpreter.getModelAdapter());
		}
	    }
	} else {
	    // return type is void; force a null result
	    assert result == null;
	}
	return result;
    }
    
}
