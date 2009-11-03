package com.sap.river.interpreter.statements;

import java.lang.reflect.InvocationTargetException;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import persistence.actions.Delete;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.EntityObject;
import com.sap.river.interpreter.objects.RiverObject;

public class DeleteInterpreter implements Interpreter<Delete> {
    private Delete delete;
    
    public DeleteInterpreter(Delete delete) {
	this.delete = delete;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException, JmiException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	for (RiverObject toDelete : interpreter.evaluate(delete.getArgument())) {
	    interpreter.deleteEntity((EntityObject) toDelete);
	}
	return null;
    }
}
