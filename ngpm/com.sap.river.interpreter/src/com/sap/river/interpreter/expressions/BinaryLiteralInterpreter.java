package com.sap.river.interpreter.expressions;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.NativeObject;
import com.sap.river.interpreter.objects.ValueObject;

import data.classes.ClassTypeDefinition;
import dataaccess.expressions.literals.BinaryLiteral;

public class BinaryLiteralInterpreter implements Interpreter<BinaryLiteral> {
    private BinaryLiteral literal;
    
    public BinaryLiteralInterpreter(BinaryLiteral literal) {
	this.literal = literal;
    }

    @Override
    public ValueObject evaluate(RiverInterpreter interpreter) {
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
