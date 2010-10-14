package com.sap.runlet.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import behavioral.actions.Block;
import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.EmptyObject;
import com.sap.runlet.abstractinterpreter.objects.MultiValuedObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.abstractinterpreter.repository.SnapshotIdentifier;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.RunletStackFrame;
import com.sap.runlet.interpreter.objects.FunctionFromMethodObject;
import com.sap.runlet.interpreter.objects.FunctionObject;
import com.sap.runlet.interpreter.objects.NativeObject;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.NativeImpl;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.expressions.Expression;
import dataaccess.expressions.FunctionCallExpression;
import dataaccess.expressions.SignatureCallExpression;

public class SignatureCallInterpreter implements Interpreter<SignatureCallExpression, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    protected SignatureCallExpression sce;
    
    static class ExceptionObject extends NativeObject {
	public ExceptionObject(RunletInterpreter interpreter, Throwable t, SnapshotIdentifier snapshot) {
	    super(/* ClassTypeDefinition */ null, t, snapshot, interpreter);
	}
    }
    
    public SignatureCallInterpreter(SignatureCallExpression sce) {
	this.sce = sce;
    }
    
    protected SignatureCallExpression getSignatureCallExpression() {
	return sce;
    }

    protected List<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> getParameterValues(
	    final RunletInterpreter interpreter) throws NoSuchMethodException,
	    InstantiationException, IllegalAccessException,
	    InvocationTargetException {
	// Collect side effect-free subexpressions and compute in parallel
	final LinkedHashMap<Expression, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> parameterValues = new LinkedHashMap<Expression, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>();
	Map<Thread, Expression> spawnedThreads = new HashMap<Thread, Expression>();
	List<Expression> effectiveParameters = new ArrayList<Expression>(sce.getParameters());
	if (effectiveParameters.size() < sce.getSignature().getInput().size()) {
	    // fill up with default values
	    for (int i=effectiveParameters.size(); i<sce.getSignature().getInput().size(); i++) {
		effectiveParameters.add(sce.getSignature().getInput().get(i).getDefaultValue());
	    }
	}
	for (final Expression paramExp:effectiveParameters) {
	    // FIXME execute non-side-effect-free args first and sequentially, then parallelize only on side effect-free ones
	    if (effectiveParameters.size() > 1 && paramExp.isSideEffectFree()) {
		// background execution
		Thread t = new Thread("Parallel parameter evaluation") {
		    public void run() {
			try {
			    parameterValues.put(paramExp, interpreter.spawn().evaluate(paramExp));
			} catch (Throwable e) {
			    e.printStackTrace();
			    parameterValues.put(paramExp, new ExceptionObject(interpreter, e, interpreter.getDefaultSnapshot()));
			}
		    }
		};
		spawnedThreads.put(t, paramExp);
		t.start();
	    } else {
		// foreground execution
		parameterValues.put(paramExp, interpreter.evaluate(paramExp));
	    }
	}
	for (Thread t:spawnedThreads.keySet()) {
	    try {
		t.join();
		if (parameterValues.get(spawnedThreads.get(t)) instanceof ExceptionObject) {
		    throw new RuntimeException((Throwable) ((ExceptionObject) parameterValues
			    .get(spawnedThreads.get(t))).getNativeObject());
		}
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
	List<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> result = new ArrayList<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>();
	for (Expression paramExp:effectiveParameters) {
	    result.add(parameterValues.get(paramExp));
	}
	return result;
    }

    /**
     * Evaluation of a signature call expression works in the following phases:
     * <ul>
     * 	<li>compute actual parameter values if the call takes parameters</li>
     * 	<li>create a new stack frame with the parameter values bound to the parameters</li>
     * 	<li>give subclasses a chance to enrich the stack before executing the implementation,
     *      e.g., as to set the <tt>this</tt> pointer for a method call expression and iterate
     *      over its values in case it's a multi-valued object</li>
     * 	<li>push the stack frame onto the call stack</li>
     *  <li>determine the implementation to execute, e.g., by evaluating the function expression
     *      or by doing polymorphic resolution based on the value of <tt>this</tt>; this step
     *      has to happen before the new stack frame has been activated because it may require
     *      another evaluation, and that needs to take place in the current and not the new
     *      stack frame context</li>
     *  <li>execute the implementation by asking the interpreter to evaluate it</li>
     * </ul>
     */
    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(final RunletInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	List<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> parameterValues = getParameterValues(interpreter);
	return completeStackFrameAndExecute(interpreter, parameterValues); // compute "on" object before pushing stack
    }
    
    /**
     * For a function signature call, a {@link FunctionObject} is returned that results from
     * evaluating the expression that yields the {@link Block} to execute. In particular the
     * subclass for method call execution needs to return a {@link FunctionFromMethodObject}
     * wrapping the method implementation to call.
     * 
     * @return a single of multiple/nested {@link FunctionObject}.
     */
    protected RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> getExecutableToCall(RunletInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException,
	    NoSuchMethodException, InstantiationException, IllegalAccessException,
	    InvocationTargetException {
	return interpreter.evaluate(((FunctionCallExpression) sce).getCalledBlock());
    }
    
    /**
     * Subclasses can optionally override this to add more stuff to the stack frame than
     * just the arguments, such as the <tt>this</tt> value in case of method calls.
     */
    protected RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> completeStackFrameAndExecute(final RunletInterpreter interpreter,
	    List<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> parameterValues) throws NoSuchMethodException,
	    InstantiationException, IllegalAccessException,
	    InvocationTargetException {
	// Note that there is no polymorphism for function calls
	return exec(interpreter, parameterValues, getExecutableToCall(interpreter));
    }

    /**
     * Pushes a new stack frame on the <tt>interpreter</tt>'s stack and adds the parameters with
     * their values to that stack frame. The evaluators are expected to be {@link FunctionObject}s
     * whose {@link FunctionObject#evaluate(RunletInterpreter)} is used to evaluate the
     * signature implementation. When the evaluation has finished the stack frame is popped
     * again from the interpreter's stack.
     */
    protected RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> exec(RunletInterpreter interpreter, List<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> parameterValues,
	    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluators) throws SecurityException, IllegalArgumentException,
	    NoSuchMethodException, InstantiationException, IllegalAccessException,
	    InvocationTargetException {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> result = null;
	Collection<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> resultCollection = null;
	TypeDefinition sceType = sce.getType();
	boolean pushed = false;
	try {
	    // TODO check use of flatten() once NestedTypeDefinition use has been finalized
	    // TODO parallelize if side effect-free
	    for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> functionObject : evaluators.flatten()) {
		FunctionObject evaluator = (FunctionObject) functionObject;
		RunletStackFrame newStackFrame =
		    interpreter.pushArgumentsToStackFrame(parameterValues, evaluator);
		pushed = true;
		interpreter.push(newStackFrame); // TODO this must not happen before function expression has been evaluated (errr... why again?)
		RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluationResult = evaluator.evaluate(interpreter);
		if (result != null) {
		    // already a result; this is a "many" case; put previous and this result into collection
		    resultCollection = RunletObject.createCollection(
				sce.getType().isOrdered(), sce.getType().isUnique());
		    resultCollection.add(result);
		    result = null;
		    resultCollection.add(evaluationResult);
		} else {
		    result = evaluationResult;
		}
	    }
	} finally {
	    if (pushed) {
		interpreter.pop();
	    }
	}
	if (sceType != null) {
	    if (resultCollection != null) {
		result = new MultiValuedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>(
			sce.getType(), resultCollection, sce.getType().isOrdered(), sce.getType().isUnique());
	    } else {
		if (result == null) {
		    // non-void return type; return valid EmptyObject
		    result = new EmptyObject<AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition>(sce.getType(), interpreter.getModelAdapter());
		}
	    }
	} else {
	    // return type is void; force a null result
	    assert result == null;
	}
	return result;
    }

}
