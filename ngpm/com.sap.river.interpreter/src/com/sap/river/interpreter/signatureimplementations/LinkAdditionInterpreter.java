package com.sap.river.interpreter.signatureimplementations;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.ClassTypedObject;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import data.classes.LinkAddition;
import data.classes.MethodSignature;
import data.classes.Parameter;

public class LinkAdditionInterpreter implements Interpreter<LinkAddition> {
    private LinkAddition linkAddition;
    
    public LinkAdditionInterpreter(LinkAddition linkAddition) {
	this.linkAddition = linkAddition;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException {
	MethodSignature sig = linkAddition.getImplements();
	// parameter and this are in the current stack frame; grab them:
	Parameter param = sig.getInput().get(0);
	boolean isFirstEnd = linkAddition.getEnd().equals(linkAddition.getEnd().getAssociation().getEnds().get(0));
	RiverObject paramValue = interpreter.getCallstack().peek().getValue(param);
	ClassTypedObject thiz = interpreter.getCallstack().peek().getThis();
	for (RiverObject toAdd:paramValue) {
	    ClassTypedObject cto = (ClassTypedObject) toAdd;
	    interpreter.addLink(isFirstEnd?cto:thiz, isFirstEnd?thiz:cto,
		    linkAddition.getEnd().getAssociation(), linkAddition.getAt());
	}
	return null;
    }

}
