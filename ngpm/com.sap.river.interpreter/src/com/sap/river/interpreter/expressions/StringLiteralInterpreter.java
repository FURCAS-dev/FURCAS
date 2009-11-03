package com.sap.river.interpreter.expressions;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.NativeObject;
import com.sap.river.interpreter.objects.ValueObject;

import data.classes.ClassTypeDefinition;
import dataaccess.expressions.literals.StringLiteral;

public class StringLiteralInterpreter implements Interpreter<StringLiteral> {
    private StringLiteral literal;

    public StringLiteralInterpreter(StringLiteral literal) {
	this.literal = literal;
    }

    @Override
    public ValueObject evaluate(RiverInterpreter interpreter) {
	return new NativeObject((ClassTypeDefinition) literal.getType(), literal.getLiteral(), interpreter.getDefaultSnapshot(), interpreter);
    }

}
