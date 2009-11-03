package com.sap.river.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.MultiValuedObject;
import com.sap.river.interpreter.objects.RiverObject;

import dataaccess.expressions.collectionexpressions.Including;

/**
 * Interprets the {@link Including} expression which creates a new multi-object
 * from an existing one by copying all contained objects plus those specified
 * for inclusion.
 * 
 * @author Axel Uhl (D043530)
 */
public class IncludingInterpreter implements Interpreter<Including> {
    
    private Including including;
    
    public IncludingInterpreter(Including including) {
	this.including = including;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException,
	    NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	Collection<RiverObject> resultCollection = RiverObject.createCollection(
		including.getType().isOrdered(), including.getType().isUnique());
	RiverObject source = interpreter.evaluate(including.getSource());
	if (source != null) {
	    for (RiverObject sourceObject : source) {
		resultCollection.add(sourceObject);
	    }
	}
	RiverObject arg = interpreter.evaluate(including.getArgument());
	if (arg != null) {
	    for (RiverObject argObject : arg) {
		resultCollection.add(argObject);
	    }
	}
	MultiValuedObject result = new MultiValuedObject(including.getType(), resultCollection);
	return result;
    }

}
