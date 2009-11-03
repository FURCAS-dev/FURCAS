package com.sap.river.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashSet;
import java.util.Set;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.StackFrame;
import com.sap.river.interpreter.objects.FunctionObject;
import com.sap.river.interpreter.objects.MultiValuedObject;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.river.interpreter.repository.RepositoryObject;
import com.sap.river.interpreter.statements.ReturnInterpreter;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import data.classes.FunctionSignatureImplementation;
import dataaccess.analytics.CellSet;
import dataaccess.analytics.Dimension;
import dataaccess.analytics.DimensionExpression;

public class DimensionExpressionInterpreter implements Interpreter<DimensionExpression> {
    
    /**
     * Wraps a {@link RiverObject} such that its {@link #equals(Object)} and {@link #hashCode()}
     * implementation map to {@link RiverObject#logicallyEquals(RiverObject)} and
     * {@link RiverObject#logicalHashCode()}, respectively. These compare/hash ignoring the
     * {@link RepositoryObject#getOrigin() snapshot} to which the object belongs.
     * 
     * @author Axel Uhl D043530
     */
    private static class LogicalWrapper {
	private RiverObject ro;
	public LogicalWrapper(RiverObject ro) {
	    this.ro = ro;
	}
	public boolean equals(Object o) {
	    if (o instanceof LogicalWrapper) {
		return ro.logicallyEquals(((LogicalWrapper) o).get());
	    } else if (o instanceof RiverObject) {
		return ro.logicallyEquals((RiverObject) o);
	    } else {
		return false;
	    }
	}
	public int hashCode() {
	    return ro.logicalHashCode();
	}
	public RiverObject get() {
	    return ro;
	}
    }
    
    private DimensionExpression dimensionExpression;

    public DimensionExpressionInterpreter(DimensionExpression dimensionExpression) {
	this.dimensionExpression = dimensionExpression;
    }
    
    @Override
    public RiverObject evaluate(RiverInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException, JmiException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RiverObject facts = interpreter.evaluate(dimensionExpression.getFacts());
	FunctionObject cellSetFunction = (FunctionObject) interpreter.evaluate(dimensionExpression.getCellSet());
	CellSet cellSet = (CellSet) cellSetFunction.getImplementation();
	Set<LogicalWrapper> wrappedDimensionValues = new LinkedHashSet<LogicalWrapper>();
	Set<RiverObject> dimensionValues = new LinkedHashSet<RiverObject>();
	int dimensionIndex = dimensionExpression.getDimension().getOwnerSignature().getInput().indexOf(
		dimensionExpression.getDimension())-1;
	Dimension dimension = cellSet.getDimensions().get(dimensionIndex);
	FunctionSignatureImplementation impl = dimension.getCharacteristicFunction().getImplementation();
	// TODO correct nested multiplicity handling, removing the "flatten()" call again
	for (RiverObject fact : facts.flatten()) {
	    RiverObject dimensionValueForFact = interpreter.convert(callSingleArgFunction(interpreter, fact, impl),
		    dimensionExpression.getDimension().getType());
	    // compare dimension values ignoring snapshot
	    LogicalWrapper lw = new LogicalWrapper(dimensionValueForFact);
	    if (!wrappedDimensionValues.contains(lw)) {
		wrappedDimensionValues.add(lw);
		dimensionValues.add(dimensionValueForFact);
	    }
	}
	
	MultiValuedObject result = new MultiValuedObject(
		dimensionExpression.getType(), dimensionValues);
	return result;
    }

    private RiverObject callSingleArgFunction(RiverInterpreter interpreter, RiverObject arg,
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
