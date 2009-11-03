package com.sap.river.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import persistence.expressions.Snapshot;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.RiverObject;

import dataaccess.expressions.AsList;

public class AsListInterpreter implements Interpreter<Snapshot> {

    private AsList object;

    public AsListInterpreter(AsList asList) {
	this.object = asList;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException, JmiException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RiverObject ro = interpreter.evaluate(object.getObject());
	RiverObject result = null;
	if (!ro.getType().isOrdered()) {
	    //TODO: wrap into type definition
	    //result = RiverInterpreter.getRiverObjectFromIterable(object.g);
	} else {
	    // object is head
	    result = ro;
	}

	assert result != null;
	return result;
    }

}
