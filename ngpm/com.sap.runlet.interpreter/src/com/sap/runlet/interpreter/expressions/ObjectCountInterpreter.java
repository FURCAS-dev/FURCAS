package com.sap.runlet.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.abstractinterpreter.util.Fraction;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.RunletStackFrame;
import com.sap.runlet.interpreter.objects.NativeObject;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.NativeImpl;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.expressions.Expression;
import dataaccess.expressions.ObjectCount;

public class ObjectCountInterpreter implements Interpreter<ObjectCount, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    private ObjectCount objectCount;
    
    public ObjectCountInterpreter(ObjectCount objectCount) {
	this.objectCount = objectCount;
    }
    
    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException, JmiException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> o = interpreter.evaluate(objectCount.getObject());
	// TODO when changing to correct NestedTypeDefinition, remove flatten() magic:
	int count = 0;
	for (Iterator<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> i=o.flatten().iterator(); i.hasNext(); count++) {
	    i.next();
	}
	return new NativeObject((ClassTypeDefinition) objectCount.getType(), new Fraction(count), interpreter.getDefaultSnapshot(), interpreter);
    }

}
