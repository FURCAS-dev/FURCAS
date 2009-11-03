package com.sap.river.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import persistence.expressions.Snapshot;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.EmptyObject;
import com.sap.river.interpreter.objects.RiverObject;

import dataaccess.expressions.Head;

public class HeadInterpreter implements Interpreter<Snapshot> {

    private Head object;

    public HeadInterpreter(Head head) {
	this.object = head;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException, JmiException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RiverObject ro = interpreter.evaluate(object.getObject());

	RiverObject result = null;
	if (ro.getType().isMany()) {
	    // get head from MO
	    if (ro.size() >= 1) {
		result = ro.iterator().next();
	    } else {
		// TODO: set upperMultiplicity of Type to 0
		result = new EmptyObject(ro.getType());
	    }
	} else {
	    // object is head
	    result = ro;
	}

	assert result != null;
	return result;
    }

}
