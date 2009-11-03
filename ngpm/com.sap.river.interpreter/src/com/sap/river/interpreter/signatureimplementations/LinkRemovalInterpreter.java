package com.sap.river.interpreter.signatureimplementations;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.ClassTypedObject;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import data.classes.LinkRemoval;
import data.classes.MethodSignature;
import data.classes.Parameter;

public class LinkRemovalInterpreter implements Interpreter<LinkRemoval> {
    private LinkRemoval linkRemoval;
    
    public LinkRemovalInterpreter(LinkRemoval linkRemoval) {
	this.linkRemoval = linkRemoval;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException {
	MethodSignature sig = linkRemoval.getImplements();
	// parameter and this are in the current stack frame; grab them:
	Parameter param = sig.getInput().get(0);
	boolean isFirstEnd = linkRemoval.getEnd().equals(linkRemoval.getEnd().getAssociation().getEnds().get(0));
	RiverObject paramValue = interpreter.getCallstack().peek().getValue(param);
	ClassTypedObject thiz = interpreter.getCallstack().peek().getThis();
	
	for (RiverObject l : paramValue) {
	    ClassTypedObject cto = (ClassTypedObject) l;
	    interpreter.removeLink(isFirstEnd ? cto : thiz, isFirstEnd ? thiz : cto, linkRemoval
		    .getEnd().getAssociation(), linkRemoval.getAt());
	}
	return null;
    }

}
