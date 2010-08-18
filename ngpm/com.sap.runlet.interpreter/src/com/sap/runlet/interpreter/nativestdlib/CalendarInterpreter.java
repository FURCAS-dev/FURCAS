package com.sap.runlet.interpreter.nativestdlib;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.abstractinterpreter.util.Fraction;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.RunletStackFrame;
import com.sap.runlet.interpreter.objects.NativeObject;
import com.sap.runlet.interpreter.statements.ReturnInterpreter;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.MethodSignature;
import data.classes.NativeImpl;
import data.classes.Parameter;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.expressions.Expression;

public class CalendarInterpreter implements Interpreter<NativeImpl, SapClass, TypeDefinition, ClassTypeDefinition,
Association, AssociationEnd, Statement, Expression, SignatureImplementation,
RunletStackFrame, NativeImpl, RunletInterpreter> {
    private NativeImpl nativeImpl;

    public CalendarInterpreter(NativeImpl nativeImpl) {
	this.nativeImpl = nativeImpl;
    }

    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter) throws SecurityException, IllegalArgumentException, JmiException {
	MethodSignature sig = nativeImpl.getImplements_();
    	    Parameter op = sig.getInput().get(0);
    	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> argument = interpreter.getCallstack().peek().getValue(op);
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
	throw new RuntimeException("Unknown native method " + StringFormatter.toString(nativeImpl.getImplements_())
		+ sig.getOwner().getName());
    }

}
