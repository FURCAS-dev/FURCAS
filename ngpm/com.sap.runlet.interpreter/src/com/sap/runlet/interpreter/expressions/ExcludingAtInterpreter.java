package com.sap.runlet.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
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
import dataaccess.expressions.collectionexpressions.Excluding;
import dataaccess.expressions.collectionexpressions.ExcludingAt;

/**
 * Interprets the {@link Excluding} expression which creates a new multi-object
 * from an existing one by copying all contained objects except for those specified
 * for exclusion.<p>
 * 
 * TODO currently the semantics implemented are somewhat odd: the exclude sequence
 * will be removed starting at the "at" position up to the point where the exclude
 * sequence no longer matches the source sequence. For example,
 * [1, 2, 3]->excluding[2]([2, 2]) will remove only the 2, resulting in [1, 3] because
 * the second occurrence of 2 in the exclude sequence is not matched. It may be more
 * straightforward to try to remove the exclude sequence atomically (all or nothing).
 * 
 * @author Axel Uhl (D043530)
 */
public class ExcludingAtInterpreter implements Interpreter<ExcludingAt, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    
    private ExcludingAt excluding;
    
    public ExcludingAtInterpreter(ExcludingAt excluding) {
	this.excluding = excluding;
    }

    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException,
	    NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	Collection<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> resultCollection = RunletObject.createCollection(
		/* ordered */ true, excluding.getType().isUnique());
	List<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> resultList = (List<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>) resultCollection;
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> arg = interpreter.evaluate(excluding.getArgument());
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> source = interpreter.evaluate(excluding.getSource());
	boolean sequenceMatching = true;
	int i=0;
	Iterator<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> argIterator = arg.iterator();
	for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> sourceObject:source) {
	    if (sequenceMatching && i>=excluding.getAt()) {
		if (argIterator.hasNext()) {
		    sequenceMatching = sourceObject.equals(argIterator.next());
		} else {
		    sequenceMatching = false; // arg sequence end reached; no further checking required
		}
		if (!sequenceMatching) {
		    // mismatch with exclude sequence or exclude sequence ended
		    resultList.add(sourceObject);
		}
	    } else {
		// arg sequence ended or hasn't started yet or mismatch found
		resultList.add(sourceObject);
	    }
	    i++;
	}
	MultiValuedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> result =
	    new MultiValuedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>(
		    excluding.getType(), resultList, excluding.getType().isOrdered(), excluding.getType().isUnique());
	return result;
    }

}
