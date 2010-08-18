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
import dataaccess.expressions.collectionexpressions.Excluding;

/**
 * Interprets the {@link Excluding} expression which creates a new multi-object
 * from an existing one by copying all contained objects except for those specified
 * for exclusion.
 * 
 * @author Axel Uhl (D043530)
 */
public class ExcludingInterpreter implements Interpreter<Excluding, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    
    private Excluding excluding;
    
    public ExcludingInterpreter(Excluding excluding) {
	this.excluding = excluding;
    }

    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException,
	    NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	Collection<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> resultCollection = RunletObject.createCollection(
		excluding.getType().isOrdered(), excluding.getType().isUnique());
	Collection<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> stillToExclude = RunletObject.createCollection(
		excluding.getArgument().getType().isOrdered(), excluding.getArgument().getType().isUnique());
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> arg = interpreter.evaluate(excluding.getArgument());
	for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> argObject:arg) {
	    stillToExclude.add(argObject);
	}
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> source = interpreter.evaluate(excluding.getSource());
	for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> sourceObject:source) {
	    if (stillToExclude.contains(sourceObject)) {
		stillToExclude.remove(sourceObject);
	    } else {
		resultCollection.add(sourceObject);
	    }
	}
	MultiValuedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> result =
	    new MultiValuedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>(
		    excluding.getType(), resultCollection, excluding.getType().isOrdered(), excluding.getType().isUnique());
	return result;
    }

}
