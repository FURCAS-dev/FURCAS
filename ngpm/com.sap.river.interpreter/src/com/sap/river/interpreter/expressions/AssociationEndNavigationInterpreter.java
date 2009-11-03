package com.sap.river.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.ClassTypedObject;
import com.sap.river.interpreter.objects.RiverObject;

import data.classes.AssociationEnd;
import dataaccess.expressions.AssociationEndNavigationExpression;

public class AssociationEndNavigationInterpreter implements Interpreter<AssociationEndNavigationExpression> {
    private AssociationEndNavigationExpression aene;
    
    public AssociationEndNavigationInterpreter(AssociationEndNavigationExpression aene) {
	this.aene = aene;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException, JmiException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	ClassTypedObject ro = (ClassTypedObject) interpreter.evaluate(aene.getObject());
	AssociationEnd toEnd = aene.getToEnd();
	if (!toEnd.isNavigable()) {
	    // TODO River exception handling
	    throw new RuntimeException("trying to navigate a non-navigable association end: "+
		    toEnd.getName());
	}
	return interpreter.navigate(ro, toEnd);
    }

}
