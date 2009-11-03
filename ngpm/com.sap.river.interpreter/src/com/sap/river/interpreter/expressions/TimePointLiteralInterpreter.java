package com.sap.river.interpreter.expressions;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.NativeObject;
import com.sap.river.interpreter.objects.ValueObject;
import com.sap.river.interpreter.util.DateParser;
import com.sap.river.interpreter.util.InvalidDateException;

import data.classes.ClassTypeDefinition;
import dataaccess.expressions.literals.TimePointLiteral;

public class TimePointLiteralInterpreter implements Interpreter<TimePointLiteral> {
    private TimePointLiteral literal;
    
    public TimePointLiteralInterpreter(TimePointLiteral literal) {
	this.literal = literal;
    }

    @Override
    public ValueObject evaluate(RiverInterpreter interpreter) {
	// a native object is used to encode the number value
	try {
	    return new NativeObject((ClassTypeDefinition) literal.getType(), DateParser.parse(literal.getLiteral()), interpreter.getDefaultSnapshot(), interpreter);
	} catch (InvalidDateException e) {
	    throw new RuntimeException("Date "+literal.getLiteral()+" could not be parsed although lexer considered it an ISO date", e);
	}
    }
    
}
