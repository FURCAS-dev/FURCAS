package com.sap.runlet.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.ClassTypedObject;
import com.sap.runlet.abstractinterpreter.objects.MultiValuedObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.RunletStackFrame;
import com.sap.runlet.interpreter.objects.FunctionFromMethodObject;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.NativeImpl;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.expressions.Expression;
import dataaccess.expressions.fp.FunctionFromMethodExpr;

/**
 * The value returned from evaluating a {@link FunctionFromMethodExpr} is an instance of
 * {@link FunctionFromMethodObject}.
 * 
 * @author Axel Uhl (D043530)
 */
public class FunctionFromMethodExpressionInterpreter implements Interpreter<FunctionFromMethodExpr, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    private FunctionFromMethodExpr ffm;
    
    public FunctionFromMethodExpressionInterpreter(FunctionFromMethodExpr ffm) {
	this.ffm = ffm;
    }

    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException,
	    NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	final Collection<FunctionFromMethodObject> resultCollection = RunletObject.createCollection(
		ffm.getType().isOrdered(), ffm.getType().isUnique());
	for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> thisFlattened : interpreter.evaluate(ffm.getObject()).flatten()) {
	    ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> thiz = (ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>) thisFlattened;
	    SignatureImplementation implementation = interpreter.resolveMethodCallToImplementation(
		    ffm.getMethod().getImplementation().getImplements(), thiz);
	    resultCollection.add(new FunctionFromMethodObject(ffm.getType(), implementation, thiz));
	}
	return new MultiValuedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>(
		ffm.getType(), RunletInterpreter
		.getRunletObjectFromIterable(ffm.getType(), resultCollection, interpreter.getModelAdapter(), ffm.getType().isOrdered(), ffm.getType().isUnique()),
		ffm.getType().isOrdered(), ffm.getType().isUnique());
    }

}
