package com.sap.river.interpreter.signatureimplementations;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.Side;
import com.sap.river.interpreter.objects.ClassTypedObject;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.river.interpreter.statements.ReturnInterpreter;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import data.classes.LinkTraversal;

public class LinkTraversalInterpreter implements Interpreter<LinkTraversal> {
    private LinkTraversal linkTraversal;
    
    public LinkTraversalInterpreter(LinkTraversal linkTraversal) {
	this.linkTraversal = linkTraversal;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException {
	// "this" is in the current stack frame; grab it:
	Side fromSide = linkTraversal.getEnd().equals(
		linkTraversal.getEnd().getAssociation().getEnds().get(0)) ? Side.RIGHT : Side.LEFT;
	ClassTypedObject thiz = interpreter.getCallstack().peek().getThis();
	return new ReturnInterpreter.ReturnResult(
		interpreter.navigate(thiz, fromSide, linkTraversal.getEnd().getAssociation()));
    }
}
