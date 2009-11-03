package com.sap.river.interpreter;

import java.lang.reflect.InvocationTargetException;

import com.sap.ap.metamodel.formatter.StringFormatter;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.river.interpreter.statements.ReturnInterpreter;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import data.classes.MethodSignature;
import data.classes.NativeImpl;

/**
 * Expected to return a {@link ReturnInterpreter.ReturnResult} from the
 * {@link #evaluate(RiverInterpreter)} method.
 * 
 * @author Axel Uhl (D043530)
 */
public class NativeInterpreter implements Interpreter<NativeImpl> {
    private NativeImpl nativeImpl;

    public NativeInterpreter(NativeImpl nativeImpl) {
	this.nativeImpl = nativeImpl;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter) throws SecurityException, IllegalArgumentException, JmiException,
	    NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
	MethodSignature sig = nativeImpl.getImplements();
	Interpreter<? extends NativeImpl> extensionInterpreter = interpreter.getNativeInterpreterFor(nativeImpl);
	if (extensionInterpreter != null) {
	    return extensionInterpreter.evaluate(interpreter);
	}
	throw new RuntimeException("Unknown native method " + StringFormatter.toString(nativeImpl.getImplements())
		+ " and no native interpreter registered for class " + sig.getOwner().getName());
    }

}
