package com.sap.finex.interpreter.expressions;

import structure.Association;
import structure.Field;
import structure.FinexClass;
import structure.Type;
import behavior.actions.Statement;
import behavior.expressions.Expression;
import behavior.expressions.literals.DecimalLiteral;
import behavior.functions.NativeImpl;
import behavior.functions.SignatureImplementation;

import com.sap.finex.interpreter.FinexInterpreter;
import com.sap.finex.interpreter.FinexStackFrame;
import com.sap.finex.interpreter.objects.FinexNativeObject;
import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.util.Fraction;

public class DecimalLiteralInterpreter implements Interpreter<DecimalLiteral, FinexClass, Type, FinexClass,
Association, Field, Statement, Expression, SignatureImplementation, FinexStackFrame, NativeImpl, FinexInterpreter> {
    private DecimalLiteral literal;

    public DecimalLiteralInterpreter(DecimalLiteral literal) {
	this.literal = literal;
    }

    @Override
    public FinexNativeObject evaluate(FinexInterpreter interpreter) {
	Fraction fraction = new Fraction(literal.getLiteral());
	// a native object is used to encode the number value
	return new FinexNativeObject((FinexClass) literal.getType(), fraction,
		interpreter.getDefaultSnapshot(), interpreter);
    }

}
