package com.sap.river.interpreter.nativestdlib;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
import data.classes.Parameter;

public class CalendarInterpreter implements Interpreter<NativeImpl> {
    private NativeImpl nativeImpl;

    public CalendarInterpreter(NativeImpl nativeImpl) {
	this.nativeImpl = nativeImpl;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter) throws SecurityException, IllegalArgumentException, JmiException {
	MethodSignature sig = nativeImpl.getImplements();
    	    Parameter op = sig.getInput().get(0);
	RiverObject argument = interpreter.getCallstack().peek().getValue(op);
	Calendar cal = new GregorianCalendar();
	cal.setTime((Date) ((NativeObject) argument).getNativeObject());
	if (sig.getName().equals("getMonthInYear")) {
	    int result = cal.get(Calendar.MONTH)+1;
	    return new ReturnInterpreter.ReturnResult(new NativeObject((ClassTypeDefinition) sig.getOutput(),
		    new Fraction(result), interpreter
		    .getDefaultSnapshot(), interpreter));
	} else if (sig.getName().equals("getYear")) {
	    int result = cal.get(Calendar.YEAR);
	    return new ReturnInterpreter.ReturnResult(new NativeObject((ClassTypeDefinition) sig.getOutput(),
		    new Fraction(result), interpreter
		    .getDefaultSnapshot(), interpreter));
	    
	}
	throw new RuntimeException("Unknown native method " + StringFormatter.toString(nativeImpl.getImplements())
		+ sig.getOwner().getName());
    }

}
