package com.sap.river.interpreter.statements;

import java.lang.reflect.InvocationTargetException;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import behavioral.actions.IfElse;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.NativeObject;
import com.sap.river.interpreter.objects.RiverObject;

public class IfInterpreter implements Interpreter<IfElse> {
    
    private IfElse ifElse;
    
    public IfInterpreter(IfElse ifElse) {
	this.ifElse = ifElse;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException,
	    NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RiverObject result = null;
	if ((Boolean) ((NativeObject) interpreter.evaluate(ifElse.getCondition())).getNativeObject()) {
	    result = interpreter.evaluate(ifElse.getIfBlock());
	} else if (ifElse.getElseBlock() != null) {
	    result = interpreter.evaluate(ifElse.getElseBlock());
	}
	return result;
    }

}
