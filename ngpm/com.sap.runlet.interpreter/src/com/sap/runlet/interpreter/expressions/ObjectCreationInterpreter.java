package com.sap.runlet.interpreter.expressions;

import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.RunletStackFrame;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.NativeImpl;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.expressions.Expression;
import dataaccess.expressions.ObjectCreationExpression;

public class ObjectCreationInterpreter implements Interpreter<ObjectCreationExpression, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame<AssociationEnd, TypeDefinition, ClassTypeDefinition>, NativeImpl, RunletInterpreter> {
    private ObjectCreationExpression oce;
    
    public ObjectCreationInterpreter(ObjectCreationExpression oce) {
	this.oce = oce;
    }

    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> result;
	// can only instantiate entity types
	assert !oce.getClassToInstantiate().isValueType() && !oce.getClassToInstantiate().isAbstract();
	result = interpreter.createEntityObject((ClassTypeDefinition) oce.getType());
	return result;
    }

}
