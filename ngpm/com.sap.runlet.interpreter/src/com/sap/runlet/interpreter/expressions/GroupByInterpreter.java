package com.sap.runlet.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.LogicallyEqualsWrapper;
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
import dataaccess.analytics.DimensionDefinition;
import dataaccess.analytics.GroupBy;
import dataaccess.expressions.Expression;

/**
 * A {@link GroupBy} expression computes the dimension expressions for each fact and groups those facts with equal
 * results for those dimension expressions. If a {@link GroupBy#getMapExpression() map expression} is provided, that
 * expression is evaluated for each group. Based on the required side effect-freeness of both, dimension expressions and
 * map expression, several of these computations can be executed in a parallel map/reduce style.
 * 
 * @author Axel Uhl D043530
 * 
 */
public class GroupByInterpreter implements Interpreter<GroupBy, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    private GroupBy groupBy;

    public GroupByInterpreter(GroupBy groupBy) {
	this.groupBy = groupBy;
    }
    
    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(
	    final RunletInterpreter interpreter) throws SecurityException, IllegalArgumentException, JmiException,
	    NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
	final boolean factsOrdered = groupBy.getObject().getType().isOrdered();
	final boolean factsUnique = groupBy.getObject().getType().isUnique();
	Map<Map<DimensionDefinition, LogicallyEqualsWrapper<AssociationEnd, TypeDefinition, ClassTypeDefinition>>,
	    Collection<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>> groups = computeGroups(interpreter,
		    factsOrdered, factsUnique);	
	Collection<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> resultObjects;
	if (groupBy.getMapExpression() != null) {
	    resultObjects = map(interpreter, groups);
	} else {
	    resultObjects = RunletObject.createCollection(groupBy.getType().isOrdered(), groupBy.getType().isUnique());
	    TypeDefinition typeOfOneGroup = groupBy.getObject().getType();
	    for (Collection<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> group : groups.values()) {
		MultiValuedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> groupMultiObject =
		    new MultiValuedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>(
			    typeOfOneGroup, group, typeOfOneGroup.isOrdered(), typeOfOneGroup.isUnique());
		resultObjects.add(groupMultiObject);
	    }
	}
	MultiValuedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> result = new MultiValuedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>(
		groupBy.getType(), resultObjects, groupBy.getType().isOrdered(), groupBy.getType().isUnique());
	return result;
    }
    
    private Collection<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> map(
	    final RunletInterpreter interpreter,
	    final Map<Map<DimensionDefinition, LogicallyEqualsWrapper<AssociationEnd, TypeDefinition, ClassTypeDefinition>>,
	        Collection<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>> groups) {
	Collection<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> unsynchronizedResultObjects = RunletObject
		.createCollection(groupBy.getType().isOrdered(), groupBy.getType().isUnique());
	final Collection<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> resultObjects = Collections
		.synchronizedCollection(unsynchronizedResultObjects);
	Set<Thread> mappingThreads = new HashSet<Thread>();
	final TypeDefinition typeOfOneGroup = groupBy.getGroupedFacts().getType();
	for (final Map<DimensionDefinition, LogicallyEqualsWrapper<AssociationEnd, TypeDefinition, ClassTypeDefinition>> dimensions :
	     groups.keySet()) {
	    // map each group in parallel because map expression has to be side effect free
	    Thread t = new Thread("GroupBy mapper for group with dimensions "+dimensions) {
		@Override
		public void run() {
		    RunletInterpreter mapperInterpreter = interpreter.spawn();
		    RunletStackFrame frame = new RunletStackFrame(mapperInterpreter.getCallstack().peek());
		    // set all dimension iterators and groupedFacts iterator in new stack frame:
		    for (DimensionDefinition dimension : groupBy.getDimensions()) {
			RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> dimensionValue =
			    dimensions.get(dimension).getWrappedObject();
			frame.enterValue(dimension.getIterator(), dimensionValue);
		    }
		    MultiValuedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> groupMultiObject = new MultiValuedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>(
			    typeOfOneGroup, groups.get(dimensions), typeOfOneGroup.isOrdered(), typeOfOneGroup.isUnique());
		    frame.enterValue(groupBy.getGroupedFacts(), groupMultiObject);
		    mapperInterpreter.push(frame);
		    try {
			resultObjects.add(mapperInterpreter.evaluate(groupBy.getMapExpression()));
			mapperInterpreter.pop();
		    } catch (Exception e) {
			throw new RuntimeException(e);
		    }
		}
	    };
	    mappingThreads.add(t);
	    t.start();
	}
	for (Thread t : mappingThreads) {
	    try {
		t.join();
	    } catch (InterruptedException e) {
		throw new RuntimeException("Didn't expect to get interrupted while waiting for mapping thread "+t, e);
	    }
	}
	return resultObjects;
    }

    private Map<Map<DimensionDefinition, LogicallyEqualsWrapper<AssociationEnd, TypeDefinition, ClassTypeDefinition>>,
                Collection<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>> computeGroups(
	    final RunletInterpreter interpreter, final boolean factsOrdered, final boolean factsUnique)
	    throws JmiException, SecurityException, IllegalArgumentException,
	    NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> facts = interpreter.evaluate(groupBy
		.getObject());
	Set<Thread> groupingThreads = new HashSet<Thread>();
	final Map<Map<DimensionDefinition, LogicallyEqualsWrapper<AssociationEnd, TypeDefinition, ClassTypeDefinition>>, Collection<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>> groups =
	    Collections.synchronizedMap(new HashMap<Map<DimensionDefinition, LogicallyEqualsWrapper<AssociationEnd, TypeDefinition, ClassTypeDefinition>>, Collection<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>>());
	for (final RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> fact : facts) {
	    Thread t = new Thread("GroupBy grouper for fact "+fact) {
		@Override
		public void run() {
		    Map<DimensionDefinition, LogicallyEqualsWrapper<AssociationEnd, TypeDefinition, ClassTypeDefinition>> valuesForDimension = Collections
			    .synchronizedMap(new HashMap<DimensionDefinition, LogicallyEqualsWrapper<AssociationEnd, TypeDefinition, ClassTypeDefinition>>());
		    RunletInterpreter dimensionInterpreter = interpreter.spawn();
		    for (DimensionDefinition dimension : groupBy.getDimensions()) {
			RunletStackFrame frame = new RunletStackFrame(dimensionInterpreter.getCallstack().peek());
			frame.enterValue(groupBy.getFact(), fact);
			dimensionInterpreter.push(frame);
			try {
			    valuesForDimension.put(dimension,
			    	new LogicallyEqualsWrapper<AssociationEnd, TypeDefinition, ClassTypeDefinition>(
			    		dimensionInterpreter.evaluate(dimension.getExpression())));
			    dimensionInterpreter.pop();
			} catch (Exception e) {
			    throw new RuntimeException(e);
			}
		    }
		    Collection<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> group;
		    synchronized(groups) {
			group = groups.get(valuesForDimension);
			if (group == null) {
			    Collection<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> unsynchronizedGroup =
				RunletObject.createCollection(factsOrdered, factsUnique);
			    group = Collections.synchronizedCollection(unsynchronizedGroup);
			    groups.put(valuesForDimension, group);
			}
		    }
		    group.add(fact);
		}
	    };
	    groupingThreads.add(t);
	    t.start();
	}
	for (Thread t : groupingThreads) {
	    try {
		t.join();
	    } catch (InterruptedException e) {
		throw new RuntimeException("Didn't expect to get interrupted while waiting for grouping thread "+t, e);
	    }
	}
	return groups;
    }

}
