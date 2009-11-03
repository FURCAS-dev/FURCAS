package com.sap.river.interpreter.expressions;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.NativeObject;
import com.sap.river.interpreter.objects.ValueObject;

import data.classes.ClassTypeDefinition;
import dataaccess.expressions.literals.BooleanLiteral;

public class BooleanLiteralInterpreter implements Interpreter<BooleanLiteral> {
    private BooleanLiteral literal;
    
    public BooleanLiteralInterpreter(BooleanLiteral literal) {
	this.literal = literal;
    }

    @Override
    public ValueObject evaluate(RiverInterpreter interpreter) {
	// a native object is used to encode the number value
	return new NativeObject((ClassTypeDefinition) literal.getType(), new Boolean(literal.getLiteral()), interpreter.getDefaultSnapshot(), interpreter);
    }
    
}
