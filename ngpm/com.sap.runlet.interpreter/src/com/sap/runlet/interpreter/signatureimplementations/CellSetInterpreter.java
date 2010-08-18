package com.sap.runlet.interpreter.signatureimplementations;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.MultiValuedObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.abstractinterpreter.util.Bag;
import com.sap.runlet.abstractinterpreter.util.HashBag;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.RunletStackFrame;
import com.sap.runlet.interpreter.statements.ReturnInterpreter;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.FunctionSignature;
import data.classes.FunctionSignatureImplementation;
import data.classes.NativeImpl;
import data.classes.Parameter;
import data.classes.SapClass;
import data.classes.Signature;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.analytics.CellSet;
import dataaccess.analytics.Dimension;
import dataaccess.expressions.Expression;

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
public class CellSetInterpreter implements Interpreter<CellSet, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
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
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException, JmiException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	Signature cellSetFunctionSignature = cellSet.getImplementedSignature();
	Bag<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> matchingFactsValues = new HashBag<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>();
	Map<Dimension, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> valuesForDimension = new HashMap<Dimension, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>();
	Iterator<Parameter> paramIter = cellSetFunctionSignature.getInput().iterator();
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> facts = interpreter.getCallstack().peek().getValue(paramIter.next());
	Iterator<Dimension> dimensionIter = cellSet.getDimensions().iterator();
	while (paramIter.hasNext()) {
	    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> atValue = interpreter.getCallstack().peek().getValue(paramIter.next());
	    valuesForDimension.put(dimensionIter.next(), atValue);
	}
	FunctionSignature valueFunction = cellSet.getValueFunction();
	FunctionSignatureImplementation valueFunctionImpl = null;
	if (valueFunction != null) {
	    valueFunctionImpl = cellSet.getValueFunction().getImplementation();
	}
	// TODO correct nested multiplicity handling, removing the "flatten()" call again
	for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> fact : facts.flatten()) {
	    boolean factMatchesAllDimensions = true;
	    for (Dimension dimension : cellSet.getDimensions()) {
		FunctionSignatureImplementation impl = dimension.getCharacteristicFunction().getImplementation();
		RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> dimensionValueForFact = interpreter.convert(
			callSingleArgBlock(interpreter, fact, impl),
			dimension.getCharacteristicFunction().getOutput());
		if (!valuesForDimension.get(dimension).logicallyEquals(dimensionValueForFact)) {
		    factMatchesAllDimensions = false;
		    break;
		}
	    }
	    if (factMatchesAllDimensions) {
		RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> value;
		if (valueFunctionImpl != null) {
		    value = callSingleArgBlock(interpreter, fact, valueFunctionImpl);
		} else {
		    value = fact;
		}
		matchingFactsValues.add(value);
	    }
	}
	TypeDefinition valuesType = cellSet.getAggregationFunction().getInput().get(0).getType();
	MultiValuedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> valuesToAggregate =
	    new MultiValuedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>(
		    valuesType, matchingFactsValues, valuesType.isOrdered(), valuesType.isUnique());
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> result = callSingleArgBlock(interpreter, valuesToAggregate,
		cellSet.getAggregationFunction().getImplementation());
	// Wrap the whole thing into a ReturnResult because that's what's expected from
	// a signature implementation:
	ReturnInterpreter.ReturnResult returnResult = new ReturnInterpreter.ReturnResult(result);
	return returnResult;
    }

    private RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> callSingleArgBlock(RunletInterpreter interpreter,
	    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> arg,
	    FunctionSignatureImplementation impl) throws NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RunletStackFrame stackFrame = new RunletStackFrame();
	stackFrame.enterValue(impl.getImplementedSignature().getInput().get(0), arg);
	interpreter.push(stackFrame);
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> dimensionValueForFact = ((ReturnInterpreter.ReturnResult) interpreter.evaluateSignatureImplementation(impl)).getResult();
	interpreter.pop();
	return dimensionValueForFact;
    }

}
