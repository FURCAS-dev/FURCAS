package com.sap.runlet.interpreter.statements;

import java.lang.reflect.InvocationTargetException;

import behavioral.actions.Block;
import behavioral.actions.Foreach;
import behavioral.actions.Iterator;
import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.EmptyObject;
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
import dataaccess.expressions.Expression;

/**
 * Note that the iterator variable is defined in the scope of the {@link Block}
 * that contains the {@link Foreach} statement and <em>not</em> in the {@link Block}
 * that contains the body. This in particular means that after the {@link Foreach}
 * statement has finished, the iterator is still in scope.<p>
 * 
 * @author D043530
 */
public class ForeachInterpreter implements Interpreter<Foreach, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    private Foreach foreach;
    
    public ForeachInterpreter(Foreach foreach) {
	this.foreach = foreach;
    }

    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException,
	    NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> result = null;
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> coll = interpreter.evaluate(foreach.getCollection());
	Iterator it = foreach.getForVariable();
	// make the iterator variable visible only to the enclosed block
	RunletStackFrame stackFrame =
	    new RunletStackFrame(/* parent */ interpreter.getCallstack().peek());
	interpreter.push(stackFrame);
	stackFrame.enterValue(it, new EmptyObject<AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition>(
		it.getType(), interpreter.getModelAdapter()));
	if (coll != null) {
	    for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> o : coll.flatten()) {
		stackFrame.setValue(it, interpreter.convert(o, it.getType()));
		result = interpreter.evaluateSignatureImplementation(foreach.getNestedBlocks().get(0));
		if (result instanceof ReturnInterpreter.ReturnResult) {
		    return result;
		}
	    }
	}
	interpreter.pop();
	// TODO decide if it's useful to return the result of the last statement in a foreach, if any
	return result;
    }

}
