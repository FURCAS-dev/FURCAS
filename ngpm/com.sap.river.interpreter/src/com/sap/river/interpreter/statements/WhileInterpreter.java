package com.sap.river.interpreter.statements;

import java.lang.reflect.InvocationTargetException;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import behavioral.actions.IfElse;
import behavioral.actions.WhileLoop;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.NativeObject;
import com.sap.river.interpreter.objects.RiverObject;

public class WhileInterpreter implements Interpreter<IfElse> {
    
    private WhileLoop whileLoop;
    
    public WhileInterpreter(WhileLoop whileLoop) {
	this.whileLoop = whileLoop;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException,
	    NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RiverObject result = null;
	while ((Boolean) ((NativeObject) interpreter.evaluate(whileLoop.getCondition())).getNativeObject()) {
	    result = interpreter.evaluate(whileLoop.getNestedBlocks().get(0));
	    if (result instanceof ReturnInterpreter.ReturnResult) {
		return result;
	    }
	}
	return result;
    }

}
