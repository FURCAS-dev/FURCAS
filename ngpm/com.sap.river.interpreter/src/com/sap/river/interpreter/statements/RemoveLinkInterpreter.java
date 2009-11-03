package com.sap.river.interpreter.statements;

import java.lang.reflect.InvocationTargetException;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import behavioral.actions.RemoveLink;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.Side;
import com.sap.river.interpreter.objects.ClassTypedObject;
import com.sap.river.interpreter.objects.RiverObject;

public class RemoveLinkInterpreter extends LinkManipulationInterpreter implements Interpreter<RemoveLink> {
    public RemoveLinkInterpreter(RemoveLink linkManipulationStatement) {
	super(linkManipulationStatement);
    }
    
    @Override
    public RiverObject evaluate(RiverInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException, JmiException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RiverObject[] eValues = evaluteEndExpressions(interpreter);
	// TODO handle multi-valued objects
	interpreter.removeLink((ClassTypedObject) eValues[Side.LEFT.endNumber()],
		(ClassTypedObject) eValues[Side.RIGHT.endNumber()],
		getLinkManipulationStatement().getAssociation(), getLinkManipulationStatement().getAt());
	return null; // no return value for adding a link
    }

}
