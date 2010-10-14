package com.sap.runlet.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;

import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.ClassTypedObject;
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
import dataaccess.expressions.AssociationEndNavigationExpression;
import dataaccess.expressions.Expression;

public class AssociationEndNavigationInterpreter implements Interpreter<AssociationEndNavigationExpression, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    private AssociationEndNavigationExpression aene;
    
    public AssociationEndNavigationInterpreter(AssociationEndNavigationExpression aene) {
	this.aene = aene;
    }

    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> ro = (ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>) interpreter.evaluate(aene.getObject());
	AssociationEnd toEnd = aene.getToEnd();
	if (!toEnd.isNavigable()) {
	    // TODO River exception handling
	    throw new RuntimeException("trying to navigate a non-navigable association end: "+
		    toEnd.getName());
	}
	return interpreter.navigate(ro, toEnd);
    }

}