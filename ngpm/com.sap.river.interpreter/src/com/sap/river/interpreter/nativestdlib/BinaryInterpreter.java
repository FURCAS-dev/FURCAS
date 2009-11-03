package com.sap.river.interpreter.nativestdlib;

import com.sap.ap.metamodel.formatter.StringFormatter;
import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.NativeObject;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.river.interpreter.statements.ReturnInterpreter;
import com.sap.river.interpreter.util.Fraction;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import data.classes.ClassTypeDefinition;
import data.classes.MethodSignature;
import data.classes.NativeImpl;

public class BinaryInterpreter implements Interpreter<NativeImpl> {
    private NativeImpl nativeImpl;

    public BinaryInterpreter(NativeImpl nativeImpl) {
	this.nativeImpl = nativeImpl;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter) throws SecurityException, IllegalArgumentException, JmiException {
	MethodSignature sig = nativeImpl.getImplements();
	byte[] thiz = (byte[]) ((NativeObject) interpreter.getCallstack().peek().getThis()).getNativeObject();
	if (sig.getName().equals("length")) {
	    return new ReturnInterpreter.ReturnResult(new NativeObject((ClassTypeDefinition) sig.getOutput(), new Fraction(
		    thiz.length), interpreter.getDefaultSnapshot(), interpreter));
	}
	throw new RuntimeException("Unknown native method " + StringFormatter.toString(nativeImpl.getImplements())
		+ " and no native interpreter registered for class " + sig.getOwner().getName());
    }

}
