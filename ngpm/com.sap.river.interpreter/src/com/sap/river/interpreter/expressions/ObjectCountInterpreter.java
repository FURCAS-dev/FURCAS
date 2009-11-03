package com.sap.river.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.NativeObject;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.river.interpreter.util.Fraction;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import data.classes.ClassTypeDefinition;
import dataaccess.expressions.ObjectCount;

public class ObjectCountInterpreter implements Interpreter<ObjectCount> {
    private ObjectCount objectCount;
    
    public ObjectCountInterpreter(ObjectCount objectCount) {
	this.objectCount = objectCount;
    }
    
    @Override
    public RiverObject evaluate(RiverInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException, JmiException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RiverObject o = interpreter.evaluate(objectCount.getObject());
	// TODO when changing to correct NestedTypeDefinition, remove flatten() magic:
	int count = 0;
	for (Iterator<RiverObject> i=o.flatten().iterator(); i.hasNext(); count++) {
	    i.next();
	}
	return new NativeObject((ClassTypeDefinition) objectCount.getType(), new Fraction(count), interpreter.getDefaultSnapshot(), interpreter);
    }

}
