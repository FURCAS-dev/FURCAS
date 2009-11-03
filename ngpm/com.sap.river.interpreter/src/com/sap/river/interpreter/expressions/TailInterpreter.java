package com.sap.river.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import persistence.expressions.Snapshot;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.EmptyObject;
import com.sap.river.interpreter.objects.MultiValuedObject;
import com.sap.river.interpreter.objects.RiverObject;

import dataaccess.expressions.Tail;

public class TailInterpreter implements Interpreter<Snapshot> {

    private Tail object;

    public TailInterpreter(Tail tail) {
	this.object = tail;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException, JmiException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RiverObject ro = interpreter.evaluate(object.getObject());
	
	RiverObject result = null;
	if (ro.getType().isMany()) {
	    // get tail from MO
	    if (ro.size() > 1) {
		result = ((MultiValuedObject) ro).tail();
	    } else {
		result = new EmptyObject(ro.getType());
	    }
	} else {
	    result = new EmptyObject(ro.getType());
	}

	assert result != null;
	return result;
    }

}
