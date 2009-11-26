package com.sap.finex.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

import structure.Association;
import structure.Field;
import structure.FinexClass;
import structure.Type;
import behavior.actions.Statement;
import behavior.expressions.Expression;
import behavior.expressions.FieldInitializer;
import behavior.expressions.ObjectCreationExpression;
import behavior.functions.NativeImpl;
import behavior.functions.SignatureImplementation;

import com.sap.finex.interpreter.FinexInterpreter;
import com.sap.finex.interpreter.FinexStackFrame;
import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.Side;
import com.sap.runlet.abstractinterpreter.objects.ClassTypedObject;
import com.sap.runlet.abstractinterpreter.objects.EntityObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

public class ObjectCreationInterpreter
implements Interpreter<ObjectCreationExpression, FinexClass, Type, FinexClass, Association, Field,
Statement, Expression, SignatureImplementation, FinexStackFrame, NativeImpl, FinexInterpreter> {
    private ObjectCreationExpression oce;
    
    public ObjectCreationInterpreter(ObjectCreationExpression oce) {
	this.oce = oce;
    }

    @Override
    public ClassTypedObject<Field, Type, FinexClass> evaluate(FinexInterpreter interpreter)
    throws JmiException, SecurityException, IllegalArgumentException, NoSuchMethodException,
    InstantiationException, IllegalAccessException, InvocationTargetException {
	EntityObject<Association, Field, FinexClass, Type, FinexClass> result =
	    interpreter.createEntityObject(oce.getClassToInstantiate());
	Set<Field> allFieldsWithDefault = new HashSet<Field>(oce.getClassToInstantiate().getFieldsWithDefaultValue());
	// execute field initializers from create expression
	for (FieldInitializer fieldInitializer : oce.getFieldInitializers()) {
	    Field fieldToInitialize = fieldInitializer.getFieldToInitialize();
	    allFieldsWithDefault.remove(fieldToInitialize); // don't use default if explicit initialization provided
	    RunletObject<Field, Type, FinexClass> value =
		interpreter.evaluate(fieldInitializer.getInitExpression());
	    for (RunletObject<Field, Type, FinexClass> o : value.flatten()) {
		if (interpreter.getModelAdapter().getSideOfEnd(fieldToInitialize).equals(Side.LEFT)) {
		    interpreter.addLink((ClassTypedObject<Field, Type, FinexClass>) o, result, fieldToInitialize.getAssociation(), null);
		} else {
		    interpreter.addLink(result, (ClassTypedObject<Field, Type, FinexClass>) o, fieldToInitialize.getAssociation(), null);
		}
	    }
	}
	// fill remaining fields with their default values
	for (Field fieldWithDefault : allFieldsWithDefault) {
	    RunletObject<Field, Type, FinexClass> value =
		interpreter.evaluate(fieldWithDefault.getDefaultValue());
	    for (RunletObject<Field, Type, FinexClass> o : value.flatten()) {
		if (interpreter.getModelAdapter().getSideOfEnd(fieldWithDefault).equals(Side.LEFT)) {
		    interpreter.addLink((ClassTypedObject<Field, Type, FinexClass>) o, result, fieldWithDefault.getAssociation(), null);
		} else {
		    interpreter.addLink(result, (ClassTypedObject<Field, Type, FinexClass>) o, fieldWithDefault.getAssociation(), null);
		}
	    }
	}
	return result;
    }
    
}
