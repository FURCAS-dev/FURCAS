package com.sap.finex.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;

import structure.Association;
import structure.Field;
import structure.FinexClass;
import structure.Type;
import behavior.actions.Statement;
import behavior.expressions.Expression;
import behavior.expressions.Unequals;
import behavior.functions.NativeImpl;
import behavior.functions.SignatureImplementation;

import com.sap.finex.interpreter.FinexInterpreter;
import com.sap.finex.interpreter.FinexStackFrame;
import com.sap.finex.interpreter.objects.FinexNativeObject;
import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

public class UnequalsInterpreter
	implements
	Interpreter<Unequals, FinexClass, Type, FinexClass, Association, Field, Statement, Expression,
	SignatureImplementation, FinexStackFrame, NativeImpl, FinexInterpreter> {
    private Unequals ueq;
    
    public UnequalsInterpreter(Unequals ueq) {
	this.ueq = ueq;
    }

    @Override
    public FinexNativeObject evaluate(FinexInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException, JmiException, NoSuchMethodException, InstantiationException, IllegalAccessException,
	    InvocationTargetException {
	RunletObject<Field, Type, FinexClass> left = interpreter.evaluate(ueq.getLeft());
	RunletObject<Field, Type, FinexClass> right = interpreter.evaluate(ueq.getRight());
	FinexNativeObject result = new FinexNativeObject((FinexClass) ueq.getType(),
		!left.logicallyEquals(right), interpreter.getDefaultSnapshot(), interpreter);
	return result; 
    }

}
