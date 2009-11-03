package com.sap.river.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.MultiValuedObject;
import com.sap.river.interpreter.objects.RiverObject;

import dataaccess.expressions.collectionexpressions.Including;
import dataaccess.expressions.collectionexpressions.IncludingAt;

/**
 * Interprets the {@link Including} expression which creates a new multi-object
 * from an existing one by copying all contained objects plus those specified
 * for inclusion.
 * 
 * @author Axel Uhl (D043530)
 */
public class IncludingAtInterpreter implements Interpreter<IncludingAt> {
    
    private IncludingAt including;
    
    public IncludingAtInterpreter(IncludingAt including) {
	this.including = including;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException,
	    NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	Collection<RiverObject> resultCollection = RiverObject.createCollection(
		/* ordered */ true, including.getType().isUnique());
	List<RiverObject> resultList = (List<RiverObject>) resultCollection;
	RiverObject source = interpreter.evaluate(including.getSource());
	if (source != null) {
	    for (RiverObject sourceObject : source) {
		resultList.add(sourceObject);
	    }
	}
	RiverObject arg = interpreter.evaluate(including.getArgument());
	if (arg != null) {
	    int insertPosition = including.getAt();
	    for (RiverObject argObject : arg) {
		int oldSize = resultList.size();
		resultList.add(insertPosition, argObject);
		insertPosition += resultList.size()-oldSize; // only increment if really inserted (unique?)
	    }
	}
	MultiValuedObject result = new MultiValuedObject(including.getType(), resultList);
	return result;
    }

}
