package com.sap.river.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.NativeObject;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import dataaccess.expressions.Ternary;

public class TernaryInterpreter implements Interpreter<Ternary> {
    
    private Ternary ternary;
    
    public TernaryInterpreter(Ternary ternary) {
	this.ternary = ternary;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException,
	    NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RiverObject result;
	if ((Boolean) ((NativeObject) interpreter.evaluate(ternary.getCondition())).getNativeObject()) {
	    result = interpreter.evaluate(ternary.getTrueExpr());
	} else {
	    result = interpreter.evaluate(ternary.getFalseExpr());
	}
	return result;
    }

}
