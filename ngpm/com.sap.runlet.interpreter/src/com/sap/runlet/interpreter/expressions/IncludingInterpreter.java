package com.sap.runlet.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.MultiValuedObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.RunletStackFrame;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.NativeImpl;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.expressions.Expression;
import dataaccess.expressions.collectionexpressions.Including;

/**
 * Interprets the {@link Including} expression which creates a new multi-object
 * from an existing one by copying all contained objects plus those specified
 * for inclusion.
 * 
 * @author Axel Uhl (D043530)
 */
public class IncludingInterpreter implements Interpreter<Including, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    
    private Including including;
    
    public IncludingInterpreter(Including including) {
	this.including = including;
    }

    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException,
	    NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	Collection<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> resultCollection = RunletObject.createCollection(
		including.getType().isOrdered(), including.getType().isUnique());
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> source = interpreter.evaluate(including.getSource());
	if (source != null) {
	    for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> sourceObject : source) {
		resultCollection.add(sourceObject);
	    }
	}
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> arg = interpreter.evaluate(including.getArgument());
	if (arg != null) {
	    for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> argObject : arg) {
		resultCollection.add(argObject);
	    }
	}
	MultiValuedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> result =
	    new MultiValuedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>(
		    including.getType(), resultCollection, including.getType().isOrdered(), including.getType().isUnique());
	return result;
    }

}
