package com.sap.river.interpreter.expressions;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import dataaccess.expressions.This;

public class ThisInterpreter implements Interpreter<This> {
    
    public ThisInterpreter(This thiz) {
	// no need currently to remember the expression
    }
    
    @Override
    public RiverObject evaluate(RiverInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException {
	return interpreter.getCallstack().peek().getThis();
    }

}
