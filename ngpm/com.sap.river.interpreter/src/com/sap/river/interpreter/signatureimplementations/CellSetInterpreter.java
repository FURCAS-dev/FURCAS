package com.sap.river.interpreter.signatureimplementations;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.StackFrame;
import com.sap.river.interpreter.objects.MultiValuedObject;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.river.interpreter.statements.ReturnInterpreter;
import com.sap.river.interpreter.util.Bag;
import com.sap.river.interpreter.util.HashBag;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import data.classes.FunctionSignature;
import data.classes.FunctionSignatureImplementation;
import data.classes.Parameter;
import data.classes.Signature;
import dataaccess.analytics.CellSet;
import dataaccess.analytics.Dimension;

/**
 * A {@link CellSet} is considered an implementation of a
 * {@link FunctionSignature} that takes as arguments the dimension coordinates
 * and delivers as result the aggregated cell value at that coordinate. The implementation
 * therefore assumes that the dimension parameters have been pushed onto the stack. They
 * are identified by position.
 * 
 * @author Axel Uhl D043530
 * 
 */
public class CellSetInterpreter implements Interpreter<CellSet> {
    private CellSet cellSet;

    public CellSetInterpreter(CellSet cellSet) {
	this.cellSet = cellSet;
    }
    
    /**
     * There is no caching in here. For each cell requested this will re-compute all dimension values
     * and do the aggregation for the cell requested. Just barely enough to demonstrate the intended
     * semantics of this kind of expression. Don't expect useful performance!
     * 
     * TODO consider multi-valued coordinates and return a multi-dimensional structure according to the coordinate's multiplicities
     */
    @Override
    public RiverObject evaluate(RiverInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException, JmiException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	Signature cellSetFunctionSignature = cellSet.getImplementedSignature();
	Bag<RiverObject> matchingFactsValues = new HashBag<RiverObject>();
	Map<Dimension, RiverObject> valuesForDimension = new HashMap<Dimension, RiverObject>();
	Iterator<Parameter> paramIter = cellSetFunctionSignature.getInput().iterator();
	RiverObject facts = interpreter.getCallstack().peek().getValue(paramIter.next());
	Iterator<Dimension> dimensionIter = cellSet.getDimensions().iterator();
	while (paramIter.hasNext()) {
	    RiverObject atValue = interpreter.getCallstack().peek().getValue(paramIter.next());
	    valuesForDimension.put(dimensionIter.next(), atValue);
	}
	FunctionSignature valueFunction = cellSet.getValueFunction();
	FunctionSignatureImplementation valueFunctionImpl = null;
	if (valueFunction != null) {
	    valueFunctionImpl = cellSet.getValueFunction().getImplementation();
	}
	// TODO correct nested multiplicity handling, removing the "flatten()" call again
	for (RiverObject fact : facts.flatten()) {
	    boolean factMatchesAllDimensions = true;
	    for (Dimension dimension : cellSet.getDimensions()) {
		FunctionSignatureImplementation impl = dimension.getCharacteristicFunction().getImplementation();
		RiverObject dimensionValueForFact = interpreter.convert(
			callSingleArgBlock(interpreter, fact, impl),
			dimension.getCharacteristicFunction().getOutput());
		if (!valuesForDimension.get(dimension).logicallyEquals(dimensionValueForFact)) {
		    factMatchesAllDimensions = false;
		    break;
		}
	    }
	    if (factMatchesAllDimensions) {
		RiverObject value;
		if (valueFunctionImpl != null) {
		    value = callSingleArgBlock(interpreter, fact, valueFunctionImpl);
		} else {
		    value = fact;
		}
		matchingFactsValues.add(value);
	    }
	}
	MultiValuedObject valuesToAggregate = new MultiValuedObject(
		cellSet.getAggregationFunction().
		getInput().get(0).getType(), matchingFactsValues);
	RiverObject result = callSingleArgBlock(interpreter, valuesToAggregate,
		cellSet.getAggregationFunction().getImplementation());
	// Wrap the whole thing into a ReturnResult because that's what's expected from
	// a signature implementation:
	ReturnInterpreter.ReturnResult returnResult = new ReturnInterpreter.ReturnResult(result);
	return returnResult;
    }

    private RiverObject callSingleArgBlock(RiverInterpreter interpreter, RiverObject arg,
	    FunctionSignatureImplementation impl) throws NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	StackFrame stackFrame = new StackFrame();
	stackFrame.enterValue(impl.getImplementedSignature().getInput().get(0), arg);
	interpreter.push(stackFrame);
	RiverObject dimensionValueForFact = ((ReturnInterpreter.ReturnResult) interpreter.evaluate(impl)).getResult();
	interpreter.pop();
	return dimensionValueForFact;
    }

}
