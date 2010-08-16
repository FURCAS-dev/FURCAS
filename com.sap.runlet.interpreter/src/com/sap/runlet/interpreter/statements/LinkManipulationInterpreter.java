package com.sap.runlet.interpreter.statements;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import behavioral.actions.LinkManipulationStatement;

import com.sap.runlet.abstractinterpreter.Side;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.interpreter.RunletInterpreter;

import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.TypeDefinition;
import dataaccess.expressions.Expression;

public abstract class LinkManipulationInterpreter {
    private LinkManipulationStatement linkManipulationStatement;
    
    public LinkManipulationInterpreter(LinkManipulationStatement linkManipulationStatement) {
	this.linkManipulationStatement = linkManipulationStatement;
    }
    
    /**
     * Returns the results for evaluating the expressions for the sides of the association,
     * {@link RunletInterpreter#convert(RunletObject, data.classes.TypeDefinition) converted} to match
     * the ends' types. Use {@link Side#endNumber} values as index into the array returned.
     */
    @SuppressWarnings("unchecked")
    protected RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] evaluteEndExpressions(RunletInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, NoSuchMethodException,
	    InstantiationException, IllegalAccessException, InvocationTargetException {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[]) new RunletObject<?, ?, ?>[Side.values().length];
	List<Expression> expressions = linkManipulationStatement.getObjects();
	for (Side side:Side.values()) {
	    Expression e = expressions.get(side.endNumber());
	    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> eValue = interpreter.convert(interpreter.evaluate(e),
		    linkManipulationStatement.getAssociation().getEnds().get(side.endNumber()).getType());
	    result[side.endNumber()] = eValue;
	}
	return result;
    }

    protected LinkManipulationStatement getLinkManipulationStatement() {
        return linkManipulationStatement;
    }

}
