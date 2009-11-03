package com.sap.river.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.MultiValuedObject;
import com.sap.river.interpreter.objects.RiverObject;

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
public class ExcludingAtInterpreter implements Interpreter<ExcludingAt> {
    
    private ExcludingAt excluding;
    
    public ExcludingAtInterpreter(ExcludingAt excluding) {
	this.excluding = excluding;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException,
	    NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	Collection<RiverObject> resultCollection = RiverObject.createCollection(
		/* ordered */ true, excluding.getType().isUnique());
	List<RiverObject> resultList = (List<RiverObject>) resultCollection;
	RiverObject arg = interpreter.evaluate(excluding.getArgument());
	RiverObject source = interpreter.evaluate(excluding.getSource());
	boolean sequenceMatching = true;
	int i=0;
	Iterator<RiverObject> argIterator = arg.iterator();
	for (RiverObject sourceObject:source) {
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
	MultiValuedObject result = new MultiValuedObject(excluding.getType(), resultList);
	return result;
    }

}
