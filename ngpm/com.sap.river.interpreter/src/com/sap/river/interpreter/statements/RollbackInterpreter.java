package com.sap.river.interpreter.statements;

import persistence.actions.Rollback;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

public class RollbackInterpreter implements Interpreter<Rollback> {
    public RollbackInterpreter(Rollback rollback) {
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException, JmiException {
	interpreter.rollback();
	return null;
    }
}
