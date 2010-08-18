package com.sap.runlet.interpreter.signatureimplementations;

import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.Side;
import com.sap.runlet.abstractinterpreter.objects.ClassTypedObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.RunletStackFrame;
import com.sap.runlet.interpreter.statements.ReturnInterpreter;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.LinkTraversal;
import data.classes.NativeImpl;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.expressions.Expression;

public class LinkTraversalInterpreter implements Interpreter<LinkTraversal, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    private LinkTraversal linkTraversal;
    
    public LinkTraversalInterpreter(LinkTraversal linkTraversal) {
	this.linkTraversal = linkTraversal;
    }

    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException {
	// "this" is in the current stack frame; grab it:
	Side fromSide = linkTraversal.getEnd().equals(
		linkTraversal.getEnd().getAssociation().getEnds().get(0)) ? Side.RIGHT : Side.LEFT;
	ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> thiz = interpreter.getCallstack().peek().getThis();
	return new ReturnInterpreter.ReturnResult(
		interpreter.navigate(thiz, fromSide, linkTraversal.getEnd().getAssociation()));
    }
}
