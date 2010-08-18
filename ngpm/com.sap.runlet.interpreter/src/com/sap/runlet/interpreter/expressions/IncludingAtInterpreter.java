package com.sap.runlet.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;

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
import dataaccess.expressions.collectionexpressions.IncludingAt;

/**
 * Interprets the {@link Including} expression which creates a new multi-object
 * from an existing one by copying all contained objects plus those specified
 * for inclusion.
 * 
 * @author Axel Uhl (D043530)
 */
public class IncludingAtInterpreter implements Interpreter<IncludingAt, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    
    private IncludingAt including;
    
    public IncludingAtInterpreter(IncludingAt including) {
	this.including = including;
    }

    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException,
	    NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	Collection<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> resultCollection = RunletObject.createCollection(
		/* ordered */ true, including.getType().isUnique());
	List<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> resultList = (List<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>) resultCollection;
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> source = interpreter.evaluate(including.getSource());
	if (source != null) {
	    for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> sourceObject : source) {
		resultList.add(sourceObject);
	    }
	}
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> arg = interpreter.evaluate(including.getArgument());
	if (arg != null) {
	    int insertPosition = including.getAt();
	    for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> argObject : arg) {
		int oldSize = resultList.size();
		resultList.add(insertPosition, argObject);
		insertPosition += resultList.size()-oldSize; // only increment if really inserted (unique?)
	    }
	}
	MultiValuedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> result =
	    new MultiValuedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>(
		    including.getType(), resultList, including.getType().isOrdered(), including.getType().isUnique());
	return result;
    }

}
