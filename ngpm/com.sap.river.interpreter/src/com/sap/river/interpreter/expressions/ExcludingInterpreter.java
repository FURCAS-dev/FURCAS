package com.sap.river.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.MultiValuedObject;
import com.sap.river.interpreter.objects.RiverObject;

import dataaccess.expressions.collectionexpressions.Excluding;

/**
 * Interprets the {@link Excluding} expression which creates a new multi-object
 * from an existing one by copying all contained objects except for those specified
 * for exclusion.
 * 
 * @author Axel Uhl (D043530)
 */
public class ExcludingInterpreter implements Interpreter<Excluding> {
    
    private Excluding excluding;
    
    public ExcludingInterpreter(Excluding excluding) {
	this.excluding = excluding;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException,
	    NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	Collection<RiverObject> resultCollection = RiverObject.createCollection(
		excluding.getType().isOrdered(), excluding.getType().isUnique());
	Collection<RiverObject> stillToExclude = RiverObject.createCollection(
		excluding.getArgument().getType().isOrdered(), excluding.getArgument().getType().isUnique());
	RiverObject arg = interpreter.evaluate(excluding.getArgument());
	for (RiverObject argObject:arg) {
	    stillToExclude.add(argObject);
	}
	RiverObject source = interpreter.evaluate(excluding.getSource());
	for (RiverObject sourceObject:source) {
	    if (stillToExclude.contains(sourceObject)) {
		stillToExclude.remove(sourceObject);
	    } else {
		resultCollection.add(sourceObject);
	    }
	}
	MultiValuedObject result = new MultiValuedObject(excluding.getType(), resultCollection);
	return result;
    }

}
