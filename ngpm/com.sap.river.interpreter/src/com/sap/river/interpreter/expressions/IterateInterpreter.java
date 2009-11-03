package com.sap.river.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import behavioral.actions.Iterator;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.StackFrame;
import com.sap.river.interpreter.objects.EmptyObject;
import com.sap.river.interpreter.objects.RiverObject;

import dataaccess.expressions.collectionexpressions.Iterate;

public class IterateInterpreter implements Interpreter<Iterate> {
    private Iterate iterate;

    public IterateInterpreter(Iterate iterate) {
	this.iterate = iterate;
    }
    
    @Override
    public RiverObject evaluate(RiverInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException, JmiException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RiverObject source = interpreter.evaluate(iterate.getSource());
	RiverObject acc = null;
	if (iterate.getAccumulator() != null && iterate.getAccumulator().getInitExpression() != null) {
	    acc = interpreter.evaluate(iterate.getAccumulator().getInitExpression());
	} else {
	    // no accumulator or no init expression provided; 
	    // use EmptyObject as accumulator value
	    acc = new EmptyObject(iterate.getIteratorExpression().getType());
	}
	behavioral.actions.Iterator[] iterators = new behavioral.actions.Iterator[iterate.getIterators().size()];
	int i=0;
	for (behavioral.actions.Iterator iterator:iterate.getIterators()) {
	    iterators[i++] = iterator;
	}
	Map<behavioral.actions.Iterator, RiverObject> iteratorValues = new HashMap<Iterator, RiverObject>();
	return iterate(interpreter, iterators, 0, source, acc, iteratorValues);
    }
    
    private RiverObject iterate(RiverInterpreter interpreter,
	    behavioral.actions.Iterator[] iterators, int iteratorIndex,
	    RiverObject source,
	    RiverObject acc, Map<behavioral.actions.Iterator, RiverObject> iteratorValues)
    throws SecurityException, IllegalArgumentException, JmiException, NoSuchMethodException,
    InstantiationException, IllegalAccessException, InvocationTargetException {
	behavioral.actions.Iterator iter = iterators[iteratorIndex];
	for (RiverObject sourceElement:source.flatten()) {
	    iteratorValues.put(iter, sourceElement);
	    if (iteratorIndex < iterators.length-1) {
		acc = iterate(interpreter, iterators, iteratorIndex+1, source, acc, iteratorValues);
	    } else {
		// innermost iterator; perform one "step"
		StackFrame stackFrame = new StackFrame(interpreter.getCallstack().peek());
		stackFrame.enterValue(iterate.getAccumulator(), acc);
		for (behavioral.actions.Iterator iterator:iteratorValues.keySet()) {
		    stackFrame.enterValue(iterator, iteratorValues.get(iterator));
		}
		interpreter.push(stackFrame);
		acc = interpreter.evaluate(iterate.getIteratorExpression());
		interpreter.pop();
	    }
	}
	return acc;
    }

}
