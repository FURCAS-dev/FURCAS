package com.sap.river.interpreter.statements;

import java.lang.reflect.InvocationTargetException;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import behavioral.actions.Block;
import behavioral.actions.Foreach;
import behavioral.actions.Iterator;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.StackFrame;
import com.sap.river.interpreter.objects.EmptyObject;
import com.sap.river.interpreter.objects.RiverObject;

/**
 * Note that the iterator variable is defined in the scope of the {@link Block}
 * that contains the {@link Foreach} statement and <em>not</em> in the {@link Block}
 * that contains the body. This in particular means that after the {@link Foreach}
 * statement has finished, the iterator is still in scope.<p>
 * 
 * @author D043530
 */
public class ForeachInterpreter implements Interpreter<Foreach> {
    private Foreach foreach;
    
    public ForeachInterpreter(Foreach foreach) {
	this.foreach = foreach;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException,
	    NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RiverObject result = null;
	RiverObject coll = interpreter.evaluate(foreach.getCollection());
	Iterator it = foreach.getForVariable();
	// make the iterator variable visible only to the enclosed block
	StackFrame stackFrame = new StackFrame(/* parent */ interpreter.getCallstack().peek());
	interpreter.push(stackFrame);
	stackFrame.enterValue(it, new EmptyObject(it.getType()));
	if (coll != null) {
	    for (RiverObject o : coll.flatten()) {
		stackFrame.setValue(it, interpreter.convert(o, it.getType()));
		result = interpreter.evaluate(foreach.getNestedBlocks().get(0));
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
