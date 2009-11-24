package com.sap.finex.interpreter.expressions;

import structure.Association;
import structure.Field;
import structure.FinexClass;
import structure.Type;
import behavior.actions.Statement;
import behavior.expressions.Expression;
import behavior.expressions.literals.BinaryLiteral;
import behavior.functions.NativeImpl;
import behavior.functions.SignatureImplementation;

import com.sap.finex.interpreter.FinexInterpreter;
import com.sap.finex.interpreter.FinexStackFrame;
import com.sap.finex.interpreter.objects.FinexNativeObject;
import com.sap.runlet.abstractinterpreter.Interpreter;

public class BinaryLiteralInterpreter implements Interpreter<BinaryLiteral, FinexClass, Type, FinexClass, Association, Field, Statement, Expression, SignatureImplementation, FinexStackFrame, NativeImpl, FinexInterpreter> {
    private BinaryLiteral literal;
    
    public BinaryLiteralInterpreter(BinaryLiteral literal) {
	this.literal = literal;
    }

    @Override
    public FinexNativeObject evaluate(FinexInterpreter interpreter) {
	String hexOctetSequence = literal.getLiteral();
	assert hexOctetSequence.startsWith("0x");
	byte[] arr = new byte[(hexOctetSequence.length()-2)/2];
	for (int i=0; i<arr.length; i++) {
	    arr[i] = (byte) Integer.parseInt(hexOctetSequence.substring(2+2*i, 4+2*i), 16);
	}
	// a native object is used to encode the binary value
	return new FinexNativeObject((FinexClass) literal.getType(), arr,
		interpreter.getDefaultSnapshot(), interpreter);
    }
    
}
