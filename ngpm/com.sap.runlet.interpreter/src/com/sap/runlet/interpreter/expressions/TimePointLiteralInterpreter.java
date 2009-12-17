package com.sap.runlet.interpreter.expressions;

import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.util.DateParser;
import com.sap.runlet.abstractinterpreter.util.InvalidDateException;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.RunletStackFrame;
import com.sap.runlet.interpreter.objects.NativeObject;
import com.sap.runlet.interpreter.objects.ValueObject;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.NativeImpl;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.expressions.Expression;
import dataaccess.expressions.literals.TimePointLiteral;

public class TimePointLiteralInterpreter implements Interpreter<TimePointLiteral, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    private TimePointLiteral literal;
    
    public TimePointLiteralInterpreter(TimePointLiteral literal) {
	this.literal = literal;
    }

    @Override
    public ValueObject evaluate(RunletInterpreter interpreter) {
	// a native object is used to encode the number value
	try {
	    return new NativeObject((ClassTypeDefinition) literal.getType(), DateParser.parse(literal.getLiteral()), interpreter.getDefaultSnapshot(), interpreter);
	} catch (InvalidDateException e) {
	    throw new RuntimeException("Date "+literal.getLiteral()+" could not be parsed although lexer considered it an ISO date", e);
	}
    }
    
}
