package com.sap.runlet.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import behavioral.actions.Iterator;
import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.EmptyObject;
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
import dataaccess.expressions.collectionexpressions.Iterate;

public class IterateInterpreter implements Interpreter<Iterate, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    private Iterate iterate;

    public IterateInterpreter(Iterate iterate) {
	this.iterate = iterate;
    }

    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> source = interpreter.evaluate(iterate.getSource());
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> acc = null;
	if (iterate.getAccumulator() != null && iterate.getAccumulator().getInitExpression() != null) {
	    acc = interpreter.evaluate(iterate.getAccumulator().getInitExpression());
	} else {
	    // no accumulator or no init expression provided;
	    // use EmptyObject as accumulator value
	    acc = new EmptyObject<AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition>(
		    iterate.getIteratorExpression().getType(), interpreter.getModelAdapter());
	}
	behavioral.actions.Iterator[] iterators = new behavioral.actions.Iterator[iterate.getIterators().size()];
	int i = 0;
	for (behavioral.actions.Iterator iterator : iterate.getIterators()) {
	    iterators[i++] = iterator;
	}
	Map<behavioral.actions.Iterator, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> iteratorValues =
	    new HashMap<Iterator, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>();
	return iterate(interpreter, iterators, 0, source, acc, iteratorValues);
    }

    private RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> iterate(RunletInterpreter interpreter,
	    behavioral.actions.Iterator[] iterators, int iteratorIndex,
	    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> source,
	    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> acc,
	    Map<behavioral.actions.Iterator, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> iteratorValues)
	    throws SecurityException, IllegalArgumentException, JmiException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	behavioral.actions.Iterator iter = iterators[iteratorIndex];
	for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> sourceElement : source.flatten()) {
	    iteratorValues.put(iter, sourceElement);
	    if (iteratorIndex < iterators.length - 1) {
		acc = iterate(interpreter, iterators, iteratorIndex + 1, source, acc, iteratorValues);
	    } else {
		// innermost iterator; perform one "step"
		RunletStackFrame stackFrame =
		    new RunletStackFrame(interpreter.getCallstack().peek());
		stackFrame.enterValue(iterate.getAccumulator(), acc);
		for (behavioral.actions.Iterator iterator : iteratorValues.keySet()) {
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
