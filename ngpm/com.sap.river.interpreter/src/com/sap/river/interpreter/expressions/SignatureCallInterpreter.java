package com.sap.river.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import behavioral.actions.Block;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.StackFrame;
import com.sap.river.interpreter.objects.EmptyObject;
import com.sap.river.interpreter.objects.FunctionFromMethodObject;
import com.sap.river.interpreter.objects.FunctionObject;
import com.sap.river.interpreter.objects.MultiValuedObject;
import com.sap.river.interpreter.objects.NativeObject;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.river.interpreter.repository.SnapshotIdentifier;

import data.classes.TypeDefinition;
import dataaccess.expressions.Expression;
import dataaccess.expressions.FunctionCallExpression;
import dataaccess.expressions.SignatureCallExpression;

public class SignatureCallInterpreter implements Interpreter<SignatureCallExpression> {
    protected SignatureCallExpression sce;
    
    static class ExceptionObject extends NativeObject {
	public ExceptionObject(RiverInterpreter interpreter, Throwable t, SnapshotIdentifier snapshot) {
	    super(/* ClassTypeDefinition */ null, t, snapshot, interpreter);
	}
    }
    
    public SignatureCallInterpreter(SignatureCallExpression sce) {
	this.sce = sce;
    }
    
    protected SignatureCallExpression getSignatureCallExpression() {
	return sce;
    }

    protected List<RiverObject> getParameterValues(
	    final RiverInterpreter interpreter) throws NoSuchMethodException,
	    InstantiationException, IllegalAccessException,
	    InvocationTargetException {
	// Collect side effect-free subexpressions and compute in parallel
	final LinkedHashMap<Expression, RiverObject> parameterValues = new LinkedHashMap<Expression, RiverObject>();
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
	    if (paramExp.isSideEffectFree()) {
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
	List<RiverObject> result = new ArrayList<RiverObject>();
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
    public RiverObject evaluate(final RiverInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException, JmiException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	List<RiverObject> parameterValues = getParameterValues(interpreter);
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
    protected RiverObject getExecutableToCall(RiverInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException,
	    NoSuchMethodException, InstantiationException, IllegalAccessException,
	    InvocationTargetException {
	return interpreter.evaluate(((FunctionCallExpression) sce).getCalledBlock());
    }
    
    /**
     * Subclasses can optionally override this to add more stuff to the stack frame than
     * just the arguments, such as the <tt>this</tt> value in case of method calls.
     */
    protected RiverObject completeStackFrameAndExecute(final RiverInterpreter interpreter,
	    List<RiverObject> parameterValues) throws NoSuchMethodException,
	    InstantiationException, IllegalAccessException,
	    InvocationTargetException {
	// Note that there is no polymorphism for function calls
	return exec(interpreter, parameterValues, getExecutableToCall(interpreter));
    }

    /**
     * Pushes a new stack frame on the <tt>interpreter</tt>'s stack and adds the parameters with
     * their values to that stack frame. The evaluators are expected to be {@link FunctionObject}s
     * whose {@link FunctionObject#evaluate(RiverInterpreter)} is used to evaluate the
     * signature implementation. When the evaluation has finished the stack frame is popped
     * again from the interpreter's stack.
     */
    protected RiverObject exec(RiverInterpreter interpreter, List<RiverObject> parameterValues,
	    RiverObject evaluators) throws SecurityException, IllegalArgumentException,
	    JmiException, NoSuchMethodException, InstantiationException, IllegalAccessException,
	    InvocationTargetException {
	RiverObject result = null;
	Collection<RiverObject> resultCollection = null;
	TypeDefinition sceType = sce.getType();
	boolean pushed = false;
	try {
	    // TODO check use of flatten() once NestedTypeDefinition use has been finalized
	    // TODO parallelize if side effect-free
	    for (RiverObject functionObject : evaluators.flatten()) {
		FunctionObject evaluator = (FunctionObject) functionObject;
		StackFrame newStackFrame = interpreter.pushArgumentsToStackFrame(parameterValues, evaluator);
		pushed = true;
		interpreter.push(newStackFrame); // TODO this must not happen before function expression has been evaluated (errr... why again?)
		RiverObject evaluationResult = evaluator.evaluate(interpreter);
		if (result != null) {
		    // already a result; this is a "many" case; put previous and this result into collection
		    resultCollection = RiverObject.createCollection(
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
		result = new MultiValuedObject(sce.getType(), resultCollection);
	    } else {
		if (result == null) {
		    // non-void return type; return valid EmptyObject
		    result = new EmptyObject(sce.getType());
		}
	    }
	} else {
	    // return type is void; force a null result
	    assert result == null;
	}
	return result;
    }

}
