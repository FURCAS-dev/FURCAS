package com.sap.river.interpreter.statements;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import behavioral.actions.LinkManipulationStatement;

import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.Side;
import com.sap.river.interpreter.objects.RiverObject;

import dataaccess.expressions.Expression;

public abstract class LinkManipulationInterpreter {
    private LinkManipulationStatement linkManipulationStatement;
    
    public LinkManipulationInterpreter(LinkManipulationStatement linkManipulationStatement) {
	this.linkManipulationStatement = linkManipulationStatement;
    }
    
    /**
     * Returns the results for evaluating the expressions for the sides of the association,
     * {@link RiverInterpreter#convert(RiverObject, data.classes.TypeDefinition) converted} to match
     * the ends' types. Use {@link Side#endNumber} values as index into the array returned.
     */
    protected RiverObject[] evaluteEndExpressions(RiverInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, NoSuchMethodException,
	    InstantiationException, IllegalAccessException, InvocationTargetException {
	RiverObject[] result = new RiverObject[Side.values().length];
	List<Expression> expressions = linkManipulationStatement.getObjects();
	for (Side side:Side.values()) {
	    Expression e = expressions.get(side.endNumber());
	    RiverObject eValue = interpreter.convert(interpreter.evaluate(e),
		    linkManipulationStatement.getAssociation().getEnds().get(side.endNumber()).getType());
	    result[side.endNumber()] = eValue;
	}
	return result;
    }

    protected LinkManipulationStatement getLinkManipulationStatement() {
        return linkManipulationStatement;
    }

}
