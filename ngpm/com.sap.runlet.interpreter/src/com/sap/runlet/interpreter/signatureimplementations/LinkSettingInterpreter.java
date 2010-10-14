package com.sap.runlet.interpreter.signatureimplementations;

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
import data.classes.LinkSetting;
import data.classes.MethodSignature;
import data.classes.NativeImpl;
import data.classes.Parameter;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.expressions.Expression;

public class LinkSettingInterpreter implements Interpreter<LinkSetting, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    private LinkSetting linkSetting;
    
    public LinkSettingInterpreter(LinkSetting linkSetting) {
	this.linkSetting = linkSetting;
    }

    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException {
	MethodSignature sig = linkSetting.getImplements_();
	// parameter and this are in the current stack frame; grab them:
	Parameter param = sig.getInput().get(0);
	boolean isFirstEnd = linkSetting.getEnd().equals(linkSetting.getEnd().getAssociation().getEnds().get(0));
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> paramValue = interpreter.getCallstack().peek().getValue(param);
	ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> thiz = interpreter.getCallstack().peek().getThis();
	
	// remove all existing links
	Side fromSide = linkSetting.getEnd().equals(
		linkSetting.getEnd().getAssociation().getEnds().get(0)) ? Side.RIGHT : Side.LEFT;
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> existingLinks = interpreter.navigate(thiz, fromSide, linkSetting.getEnd().getAssociation());
	if (existingLinks != null) {
	    for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> l : existingLinks) {
		ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> cto = (ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>) l;
		interpreter.removeLink(isFirstEnd ? cto : thiz, isFirstEnd ? thiz : cto,
			linkSetting.getEnd().getAssociation(),
			/* if duplicates exist, they will all be removed by this loop, so the position doesn't matter */ null);
	    }
	}
	for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> toAdd:paramValue) {
	    ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> cto = (ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>) toAdd;
	    interpreter.addLink(isFirstEnd?cto:thiz, isFirstEnd?thiz:cto,
		    linkSetting.getEnd().getAssociation(), 
		    /* always append to end */ -1);
	}
	return null;
    }

}
