package com.sap.river.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import behavioral.actions.Iterator;

import com.sap.ap.metamodel.utils.MetamodelUtils;
import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.StackFrame;
import com.sap.river.interpreter.objects.EmptyObject;
import com.sap.river.interpreter.objects.MultiValuedObject;
import com.sap.river.interpreter.objects.NativeObject;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.river.interpreter.util.Fraction;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import data.classes.ClassTypeDefinition;
import dataaccess.expressions.Expression;
import dataaccess.query.Selection;

/**
 * Evaluates the <tt>object</tt> expression. If the selection expression is of boolean type
 * then it will be applied as a filter predicate. If the selection expression is of
 * numeric type then it is assumed that the <tt>object</tt> expression evaluates to an
 * ordered object, and the result of the selection expression will be iterated (it could
 * contain more than one numeric single object), and for each number the element of the
 * <tt>object</tt> evaluation result at the respective position is added to the result.
 * This allows for array-like access to ordered multi objects.
 * 
 * @author Axel Uhl D043530
 *
 */
public class SelectionInterpreter implements Interpreter<Selection> {
    
    private Selection selection;
    
    public SelectionInterpreter(Selection selection) {
	this.selection = selection;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException,
	    NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RiverObject source = interpreter.evaluate(selection.getObject());
	// add a new stack frame to place fresh "self" iterator on it that is local to this Selection expression
	Collection<RiverObject> result;
	boolean isNumericIndex = ((ClassTypeDefinition) selection.getSelectionExpr().getType()).getClazz().equals(
		MetamodelUtils.findClass(interpreter.getConnection(), "Number"));
	if (isNumericIndex) {
	    result = selectAtIndices(interpreter, source, interpreter.evaluate(selection.getSelectionExpr()));
	} else {
	    result = selectMatches(interpreter, source, selection.getSelectionExpr());
	}
	if (result.size() > 0) {
	    return new MultiValuedObject(selection.getType(), result);
	} else {
	    if (result.isEmpty()) {
		return new EmptyObject(selection.getType());
	    } else {
		return result.iterator().next();
	    }
	}
    }

    private Collection<RiverObject> selectAtIndices(RiverInterpreter interpreter, RiverObject source,
	    RiverObject atIndices) throws JmiException, SecurityException, IllegalArgumentException, NoSuchMethodException,
	    InstantiationException, IllegalAccessException, InvocationTargetException {
	boolean uniqueResult = source.getType().isUnique() && atIndices.getType().isUnique();
	Collection<RiverObject> result = RiverObject.createCollection(/* ordered */true, uniqueResult);
	boolean indicesAreOrdered = atIndices.getType().isOrdered();
	if (indicesAreOrdered) {
	    // in this case preserve index order in result
	    int i=0;
	    Map<Integer, Set<Integer>> mapSourceIndexToResultIndices = new HashMap<Integer, Set<Integer>>();
	    for (RiverObject index : interpreter.evaluate(selection.getSelectionExpr())) {
		Fraction indexAsFraction = (Fraction) ((NativeObject) index).getNativeObject();
		int indexAsInt = indexAsFraction.intValue();
		Set<Integer> resultIndices = mapSourceIndexToResultIndices.get(indexAsInt);
		if (resultIndices == null) {
		    resultIndices = new HashSet<Integer>();
		    mapSourceIndexToResultIndices.put(indexAsInt, resultIndices);
		}
		resultIndices.add(i++);
	    }
	    // i now holds the number of indices specified in the selection expression
	    RiverObject[] resultAsArray = new RiverObject[i];
	    int j=0;
	    for (RiverObject sourceObject : source.flatten()) {
		Set<Integer> resultPositions = mapSourceIndexToResultIndices.get(j++);
		if (resultPositions != null) {
		    for (int resultPosition : resultPositions) {
			resultAsArray[resultPosition] = sourceObject;
		    }
		}
	    }
	    for (int k=0; k<resultAsArray.length; k++) {
		if (resultAsArray[k] == null) {
		    result.add(new EmptyObject(source.getType()));
		} else {
		    result.add(resultAsArray[k]);
		}
	    }
	} else {
	    // indices are unordered; preserve source order in results; but multiple occurrences of
	    // the same index may be possible if indices are non-unique
	    Map<Integer, Integer> occurrencesForSourceIndex = new HashMap<Integer, Integer>();
	    for (RiverObject index : interpreter.evaluate(selection.getSelectionExpr())) {
		Fraction indexAsFraction = (Fraction) ((NativeObject) index).getNativeObject();
		int indexAsInt = indexAsFraction.intValue();
		Integer occurrences = occurrencesForSourceIndex.get(indexAsInt);
		if (occurrences == null) {
		    occurrencesForSourceIndex.put(indexAsInt, 1);
		} else {
		    occurrencesForSourceIndex.put(indexAsInt, occurrences+1);
		}
	    }
	    int j=0;
	    for (RiverObject sourceObject : source.flatten()) {
		Integer occurrences = occurrencesForSourceIndex.get(j++);
		if (occurrences != null) {
		    for (int i=0; i<occurrences; i++) {
			result.add(sourceObject);
		    }
		}
	    }
	}
	return result;
    }

    private Collection<RiverObject> selectMatches(RiverInterpreter interpreter, RiverObject source, Expression expression)
	    throws JmiException, SecurityException, IllegalArgumentException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	Collection<RiverObject> result = RiverObject.createCollection(selection.getType().isOrdered(),
		      selection.getType().isUnique());
	StackFrame frame = new StackFrame(interpreter.getCallstack().peek());
	interpreter.push(frame);
	try {
	    Iterator iter = selection.getIterator();
	    frame.enterValue(iter, new EmptyObject(iter.getType())); // create entry in local stack frame
	    // TODO optionally parallelize because condition is guaranteed to be side effect free
	    for (RiverObject o : source.flatten()) { // TODO consider not flattening?
		frame.setValue(iter, interpreter.convert(o, iter.getType()));
		if ((Boolean) ((NativeObject) interpreter.evaluate(selection.getSelectionExpr())).getNativeObject()) {
		    result.add(o);
		}
	    }
	    return result;
	} finally {
	    interpreter.pop();
	}
    }
}
