package com.sap.river.interpreter.expressions;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import data.classes.ClassTypeDefinition;
import dataaccess.expressions.ObjectCreationExpression;

public class ObjectCreationInterpreter implements Interpreter<ObjectCreationExpression> {
    private ObjectCreationExpression oce;
    
    public ObjectCreationInterpreter(ObjectCreationExpression oce) {
	this.oce = oce;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException {
	RiverObject result;
	// can only instantiate entity types
	assert !oce.getClassToInstantiate().isValueType() && !oce.getClassToInstantiate().isAbstract();
	result = interpreter.createEntityObject((ClassTypeDefinition) oce.getType());
	return result;
    }

}
