package com.sap.finex.interpreter.expressions;

import structure.Association;
import structure.Field;
import structure.FinexClass;
import structure.Type;
import behavior.actions.Statement;
import behavior.expressions.All;
import behavior.expressions.Expression;
import behavior.functions.NativeImpl;
import behavior.functions.SignatureImplementation;

import com.sap.finex.interpreter.FinexInterpreter;
import com.sap.finex.interpreter.FinexStackFrame;
import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.EntityObject;
import com.sap.runlet.abstractinterpreter.objects.MultiValuedObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.abstractinterpreter.util.RelaxingIterableWrapper;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

public class AllInterpreter
implements Interpreter<All, FinexClass, Type, FinexClass, Association, Field,
Statement, Expression, SignatureImplementation, FinexStackFrame, NativeImpl, FinexInterpreter> {
    private All all;
    
    public AllInterpreter(All all) {
	this.all = all;
    }

    @Override
    public MultiValuedObject<Field, Type, FinexClass> evaluate(FinexInterpreter interpreter)
    throws JmiException, SecurityException, IllegalArgumentException {
	Iterable<RunletObject<Field, Type, FinexClass>> resultIterator =
	    new RelaxingIterableWrapper<RunletObject<Field, Type, FinexClass>,
	                        EntityObject<Association, Field, FinexClass, Type, FinexClass>>(interpreter.all(
	                        	all.getClazz(), interpreter.getDefaultSnapshot()));
	MultiValuedObject<Field, Type, FinexClass> result = new MultiValuedObject<Field, Type, FinexClass>(all.getType(),
		resultIterator, /* ordered */ false, /* unique */ true);
	return result;
    }
    
}
