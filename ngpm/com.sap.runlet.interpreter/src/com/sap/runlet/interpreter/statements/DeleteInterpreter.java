package com.sap.runlet.interpreter.statements;

import java.lang.reflect.InvocationTargetException;

import persistence.actions.Delete;
import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.EntityObject;
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

public class DeleteInterpreter implements Interpreter<Delete, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    private Delete delete;
    
    public DeleteInterpreter(Delete delete) {
	this.delete = delete;
    }

    @SuppressWarnings("unchecked")
    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException,NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> toDelete : interpreter.evaluate(delete.getArgument())) {
	    interpreter.deleteEntity(
		    (EntityObject<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition>) toDelete);
	}
	return null;
    }
}
