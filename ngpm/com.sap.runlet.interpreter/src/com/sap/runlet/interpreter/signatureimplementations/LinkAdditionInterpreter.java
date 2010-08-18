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
import data.classes.LinkAddition;
import data.classes.MethodSignature;
import data.classes.NativeImpl;
import data.classes.Parameter;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.expressions.Expression;

public class LinkAdditionInterpreter implements Interpreter<LinkAddition, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    private LinkAddition linkAddition;
    
    public LinkAdditionInterpreter(LinkAddition linkAddition) {
	this.linkAddition = linkAddition;
    }

    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException {
	MethodSignature sig = linkAddition.getImplements_();
	// parameter and this are in the current stack frame; grab them:
	Parameter param = sig.getInput().get(0);
	boolean isFirstEnd = linkAddition.getEnd().equals(linkAddition.getEnd().getAssociation().getEnds().get(0));
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> paramValue = interpreter.getCallstack().peek().getValue(param);
	ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> thiz = interpreter.getCallstack().peek().getThis();
	for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> toAdd:paramValue) {
	    ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> cto = (ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>) toAdd;
	    interpreter.addLink(isFirstEnd?cto:thiz, isFirstEnd?thiz:cto,
		    linkAddition.getEnd().getAssociation(), linkAddition.getAt());
	}
	return null;
    }

}
