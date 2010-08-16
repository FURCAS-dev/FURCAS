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
import dataaccess.expressions.literals.BinaryLiteral;

public class BinaryLiteralInterpreter implements Interpreter<BinaryLiteral, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    private BinaryLiteral literal;
    
    public BinaryLiteralInterpreter(BinaryLiteral literal) {
	this.literal = literal;
    }

    @Override
    public ValueObject evaluate(RunletInterpreter interpreter) {
	String hexOctetSequence = literal.getLiteral();
	assert hexOctetSequence.startsWith("0x");
	byte[] arr = new byte[(hexOctetSequence.length()-2)/2];
	for (int i=0; i<arr.length; i++) {
	    arr[i] = (byte) Integer.parseInt(hexOctetSequence.substring(2+2*i, 4+2*i), 16);
	}
	// a native object is used to encode the binary value
	return new NativeObject((ClassTypeDefinition) literal.getType(), arr,
		interpreter.getDefaultSnapshot(), interpreter);
    }
    
}
