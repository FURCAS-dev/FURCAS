package com.sap.finex.interpreter.expressions;

import structure.Association;
import structure.Field;
import structure.FinexClass;
import structure.Type;
import behavior.actions.Statement;
import behavior.expressions.Expression;
import behavior.expressions.literals.StringLiteral;
import behavior.functions.NativeImpl;
import behavior.functions.SignatureImplementation;

import com.sap.finex.interpreter.FinexInterpreter;
import com.sap.finex.interpreter.FinexStackFrame;
import com.sap.finex.interpreter.objects.FinexNativeObject;
import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.AbstractValueObject;

public class StringLiteralInterpreter
implements Interpreter<StringLiteral, FinexClass, Type, FinexClass, Association, Field, Statement, Expression, SignatureImplementation, FinexStackFrame, NativeImpl, FinexInterpreter> {
    private StringLiteral literal;

    public StringLiteralInterpreter(StringLiteral literal) {
	this.literal = literal;
    }

    @Override
    public AbstractValueObject<Association, Field, FinexClass, Type, FinexClass> evaluate(FinexInterpreter interpreter) {
	return new FinexNativeObject((FinexClass) literal.getType(), literal.getLiteral(), interpreter.getDefaultSnapshot(), interpreter);
    }

}
