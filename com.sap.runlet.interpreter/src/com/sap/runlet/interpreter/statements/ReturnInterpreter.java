package com.sap.runlet.interpreter.statements;

import java.lang.reflect.InvocationTargetException;

import behavioral.actions.Return;
import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.RunletStackFrame;
import com.sap.runlet.interpreter.expressions.MethodCallInterpreter;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.NativeImpl;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.expressions.Expression;

/**
 * Computes the return expression and returns it from the {@link #evaluate(RunletInterpreter)}
 * operation, wrapped in an instance of {@link ReturnInterpreter.ReturnResult} to allow
 * surrounding blocks to recognize this situation and terminate all blocks and unwind all
 * frames up to the method / function invocation frame.<p>
 * 
 * The evaluation does <em>not</em> pop the current stack frame off the stack.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public class ReturnInterpreter implements Interpreter<Statement, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    private Return ret;
    
    /**
     * Used to indicate that a <tt>return</tt> statement was executed. This then
     * is supposed to percolate up the interpreter's call stack until it reaches the
     * {@link MethodCallInterpreter} or {@link FunctionCallInterpreter} where it is
     * unwrapped and returned as the result of the method/function call.
     *
     */
    public static class ReturnResult extends RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> {
	private RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> result;
	public ReturnResult(RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> result) {
	    super(/* TypeDefinition */ null);
	    this.result = result;
	}
	public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> getResult() {
	    return result;
	}
    }
    
    public ReturnInterpreter(Return ret) {
	this.ret = ret;
    }

    @Override
    public ReturnResult evaluate(RunletInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException,
	    NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> result = interpreter.evaluate(ret.getArgument());
	return new ReturnResult(result);
    }

}
