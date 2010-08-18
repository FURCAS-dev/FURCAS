package com.sap.runlet.interpreter.statements;

import java.lang.reflect.InvocationTargetException;

import behavioral.actions.RemoveLink;
import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.Side;
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
import dataaccess.expressions.Expression;

public class RemoveLinkInterpreter extends LinkManipulationInterpreter implements Interpreter<RemoveLink, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    public RemoveLinkInterpreter(RemoveLink linkManipulationStatement) {
	super(linkManipulationStatement);
    }
    
    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException, JmiException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] eValues = evaluteEndExpressions(interpreter);
	// TODO handle multi-valued objects
	interpreter.removeLink((ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>) eValues[Side.LEFT.endNumber()],
		(ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>) eValues[Side.RIGHT.endNumber()],
		getLinkManipulationStatement().getAssociation(), getLinkManipulationStatement().getAt());
	return null; // no return value for adding a link
    }

}
