package com.sap.runlet.interpreter.signatureimplementations;

import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.ClassTypedObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.RunletStackFrame;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.LinkRemoval;
import data.classes.MethodSignature;
import data.classes.NativeImpl;
import data.classes.Parameter;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.expressions.Expression;

public class LinkRemovalInterpreter implements Interpreter<LinkRemoval, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    private LinkRemoval linkRemoval;
    
    public LinkRemovalInterpreter(LinkRemoval linkRemoval) {
	this.linkRemoval = linkRemoval;
    }

    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException {
	MethodSignature sig = linkRemoval.getImplements_();
	// parameter and this are in the current stack frame; grab them:
	Parameter param = sig.getInput().get(0);
	boolean isFirstEnd = linkRemoval.getEnd().equals(linkRemoval.getEnd().getAssociation().getEnds().get(0));
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> paramValue = interpreter.getCallstack().peek().getValue(param);
	ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> thiz = interpreter.getCallstack().peek().getThis();
	
	for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> l : paramValue) {
	    ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> cto = (ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>) l;
	    interpreter.removeLink(isFirstEnd ? cto : thiz, isFirstEnd ? thiz : cto, linkRemoval
		    .getEnd().getAssociation(), linkRemoval.getAt());
	}
	return null;
    }

}
