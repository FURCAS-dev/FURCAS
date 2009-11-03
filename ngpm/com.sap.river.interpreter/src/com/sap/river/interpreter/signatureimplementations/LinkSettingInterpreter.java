package com.sap.river.interpreter.signatureimplementations;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.Side;
import com.sap.river.interpreter.objects.ClassTypedObject;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import data.classes.LinkSetting;
import data.classes.MethodSignature;
import data.classes.Parameter;

public class LinkSettingInterpreter implements Interpreter<LinkSetting> {
    private LinkSetting linkSetting;
    
    public LinkSettingInterpreter(LinkSetting linkSetting) {
	this.linkSetting = linkSetting;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException {
	MethodSignature sig = linkSetting.getImplements();
	// parameter and this are in the current stack frame; grab them:
	Parameter param = sig.getInput().get(0);
	boolean isFirstEnd = linkSetting.getEnd().equals(linkSetting.getEnd().getAssociation().getEnds().get(0));
	RiverObject paramValue = interpreter.getCallstack().peek().getValue(param);
	ClassTypedObject thiz = interpreter.getCallstack().peek().getThis();
	
	// remove all existing links
	Side fromSide = linkSetting.getEnd().equals(
		linkSetting.getEnd().getAssociation().getEnds().get(0)) ? Side.RIGHT : Side.LEFT;
	RiverObject existingLinks = interpreter.navigate(thiz, fromSide, linkSetting.getEnd().getAssociation());
	if (existingLinks != null) {
	    for (RiverObject l : existingLinks) {
		ClassTypedObject cto = (ClassTypedObject) l;
		interpreter.removeLink(isFirstEnd ? cto : thiz, isFirstEnd ? thiz : cto,
			linkSetting.getEnd().getAssociation(),
			/* if duplicates exist, they will all be removed by this loop, so the position doesn't matter */ null);
	    }
	}
	for (RiverObject toAdd:paramValue) {
	    ClassTypedObject cto = (ClassTypedObject) toAdd;
	    interpreter.addLink(isFirstEnd?cto:thiz, isFirstEnd?thiz:cto,
		    linkSetting.getEnd().getAssociation(), 
		    /* always append to end */ -1);
	}
	return null;
    }

}
