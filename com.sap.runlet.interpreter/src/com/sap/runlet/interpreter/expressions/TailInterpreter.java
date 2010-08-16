package com.sap.runlet.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;

import persistence.expressions.Snapshot;
import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.EmptyObject;
import com.sap.runlet.abstractinterpreter.objects.MultiValuedObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.RunletStackFrame;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.NativeImpl;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.expressions.Expression;
import dataaccess.expressions.Tail;

public class TailInterpreter implements Interpreter<Snapshot, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {

    private Tail object;

    public TailInterpreter(Tail tail) {
	this.object = tail;
    }

    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> ro = interpreter.evaluate(object.getObject());
	
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> result = null;
	if (ro.getType().isMany()) {
	    // get tail from MO
	    if (ro.size() > 1) {
		result = ((MultiValuedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>) ro).tail();
	    } else {
		result = new EmptyObject<AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition>(ro.getType(), interpreter.getModelAdapter());
	    }
	} else {
	    result = new EmptyObject<AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition>(ro.getType(), interpreter.getModelAdapter());
	}

	assert result != null;
	return result;
    }

}
