package com.sap.runlet.interpreter.expressions;

import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.Interpreter;
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
import dataaccess.expressions.literals.StringLiteral;

public class StringLiteralInterpreter implements Interpreter<StringLiteral, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    private StringLiteral literal;

    public StringLiteralInterpreter(StringLiteral literal) {
	this.literal = literal;
    }

    @Override
    public ValueObject evaluate(RunletInterpreter interpreter) {
	return new NativeObject((ClassTypeDefinition) literal.getType(), literal.getLiteral(), interpreter.getDefaultSnapshot(), interpreter);
    }

}
