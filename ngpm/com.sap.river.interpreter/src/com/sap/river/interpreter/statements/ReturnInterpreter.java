package com.sap.river.interpreter.statements;

import java.lang.reflect.InvocationTargetException;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.expressions.MethodCallInterpreter;
import com.sap.river.interpreter.objects.RiverObject;

import behavioral.actions.Return;
import behavioral.actions.Statement;

/**
 * Computes the return expression and returns it from the {@link #evaluate(RiverInterpreter)}
 * operation, wrapped in an instance of {@link ReturnInterpreter.ReturnResult} to allow
 * surrounding blocks to recognize this situation and terminate all blocks and unwind all
 * frames up to the method / function invocation frame.<p>
 * 
 * The evaluation does <em>not</em> pop the current stack frame off the stack.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public class ReturnInterpreter implements Interpreter<Statement> {
    private Return ret;
    
    /**
     * Used to indicate that a <tt>return</tt> statement was executed. This then
     * is supposed to percolate up the interpreter's call stack until it reaches the
     * {@link MethodCallInterpreter} or {@link FunctionCallInterpreter} where it is
     * unwrapped and returned as the result of the method/function call.
     *
     */
    public static class ReturnResult extends RiverObject {
	private RiverObject result;
	public ReturnResult(RiverObject result) {
	    super(/* TypeDefinition */ null);
	    this.result = result;
	}
	public RiverObject getResult() {
	    return result;
	}
    }
    
    public ReturnInterpreter(Return ret) {
	this.ret = ret;
    }

    @Override
    public ReturnResult evaluate(RiverInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException,
	    NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RiverObject result = interpreter.evaluate(ret.getArgument());
	return new ReturnResult(result);
    }

}
