package com.sap.river.interpreter.statements;

import java.lang.reflect.InvocationTargetException;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import persistence.actions.Store;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.EntityObject;
import com.sap.river.interpreter.objects.RiverObject;

public class StoreInterpreter implements Interpreter<Store> {
    private Store store;
    
    public StoreInterpreter(Store save) {
	this.store = save;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException, JmiException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RiverObject toSave = interpreter.evaluate(store.getArgument());
	for (RiverObject objectToSave:toSave) {
	    interpreter.storeEntity((EntityObject) objectToSave);
	}
	return toSave;
    }
}
