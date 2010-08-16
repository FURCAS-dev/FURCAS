package com.sap.runlet.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashSet;
import java.util.Set;

import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.MultiValuedObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.abstractinterpreter.repository.RepositoryObject;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.RunletStackFrame;
import com.sap.runlet.interpreter.objects.FunctionObject;
import com.sap.runlet.interpreter.statements.ReturnInterpreter;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.FunctionSignatureImplementation;
import data.classes.NativeImpl;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.analytics.CellSet;
import dataaccess.analytics.Dimension;
import dataaccess.analytics.DimensionExpression;
import dataaccess.expressions.Expression;

public class DimensionExpressionInterpreter implements Interpreter<DimensionExpression, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {

    /**
     * Wraps a {@link RunletObject} such that its {@link #equals(Object)} and
     * {@link #hashCode()} implementation map to
     * {@link RunletObject#logicallyEquals(RunletObject)} and
     * {@link RunletObject#logicalHashCode()}, respectively. These compare/hash
     * ignoring the {@link RepositoryObject#getOrigin() snapshot} to which the
     * object belongs.
     * 
     * @author Axel Uhl D043530
     */
    private static class LogicalWrapper {
	private RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> ro;

	public LogicalWrapper(RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> ro) {
	    this.ro = ro;
	}

	@SuppressWarnings("unchecked")
	public boolean equals(Object o) {
	    if (o instanceof LogicalWrapper) {
		return ro.logicallyEquals(((LogicalWrapper) o).get());
	    } else if (o instanceof RunletObject) {
		return ro.logicallyEquals((RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>) o);
	    } else {
		return false;
	    }
	}

	public int hashCode() {
	    return ro.logicalHashCode();
	}

	public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> get() {
	    return ro;
	}
    }

    private DimensionExpression dimensionExpression;

    public DimensionExpressionInterpreter(DimensionExpression dimensionExpression) {
	this.dimensionExpression = dimensionExpression;
    }

    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> facts = interpreter.evaluate(dimensionExpression.getFacts());
	FunctionObject cellSetFunction = (FunctionObject) interpreter.evaluate(dimensionExpression.getCellSet());
	CellSet cellSet = (CellSet) cellSetFunction.getImplementation();
	Set<LogicalWrapper> wrappedDimensionValues = new LinkedHashSet<LogicalWrapper>();
	Set<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> dimensionValues = new LinkedHashSet<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>();
	int dimensionIndex = dimensionExpression.getDimensionParameter().getOwnerSignature().getInput().indexOf(dimensionExpression.getDimensionParameter()) - 1;
	Dimension dimension = cellSet.getDimensions().get(dimensionIndex);
	FunctionSignatureImplementation impl = dimension.getCharacteristicFunction().getImplementation();
	// TODO correct nested multiplicity handling, removing the "flatten()"
	// call again
	for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> fact : facts.flatten()) {
	    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> dimensionValueForFact = interpreter.convert(
		    callSingleArgFunction(interpreter, fact, impl), dimensionExpression.getDimensionParameter().getType());
	    // compare dimension values ignoring snapshot
	    LogicalWrapper lw = new LogicalWrapper(dimensionValueForFact);
	    if (!wrappedDimensionValues.contains(lw)) {
		wrappedDimensionValues.add(lw);
		dimensionValues.add(dimensionValueForFact);
	    }
	}

	MultiValuedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> result = 
	    new MultiValuedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>(
		    dimensionExpression.getType(), dimensionValues, dimensionExpression.getType().isOrdered(),
		    dimensionExpression.getType().isUnique());
	return result;
    }

    private RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> callSingleArgFunction(RunletInterpreter interpreter,
	    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> arg, FunctionSignatureImplementation impl)
	    throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
	RunletStackFrame stackFrame = new RunletStackFrame();
	stackFrame.enterValue(impl.getImplementedSignature().getInput().get(0).getName(), arg);
	interpreter.push(stackFrame);
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> dimensionValueForFact = ((ReturnInterpreter.ReturnResult) interpreter
		.evaluateSignatureImplementation(impl)).getResult();
	interpreter.pop();
	return dimensionValueForFact;
    }

}
