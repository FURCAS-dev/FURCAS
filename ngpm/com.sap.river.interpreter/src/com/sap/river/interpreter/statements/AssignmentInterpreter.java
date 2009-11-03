package com.sap.river.interpreter.statements;

import java.lang.reflect.InvocationTargetException;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.RiverObject;

import behavioral.actions.Assignment;

public class AssignmentInterpreter implements Interpreter<Assignment> {
    private Assignment assignment;
    
    public AssignmentInterpreter(Assignment assignment) {
	this.assignment = assignment;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException,
	    NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RiverObject value = interpreter.evaluate(assignment.getArgument());
	RiverObject convertedToTargetType = interpreter.convert(value, assignment.getAssignTo().getType());
	interpreter.getCallstack().peek().setValue(assignment.getAssignTo(), convertedToTargetType);
	return convertedToTargetType;
    }

}
