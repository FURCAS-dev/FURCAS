package com.sap.finex.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

import structure.Association;
import structure.Field;
import structure.FinexClass;
import structure.Type;
import behavior.actions.Statement;
import behavior.expressions.Expression;
import behavior.expressions.Not;
import behavior.functions.NativeImpl;
import behavior.functions.SignatureImplementation;

import com.sap.finex.interpreter.FinexInterpreter;
import com.sap.finex.interpreter.FinexStackFrame;
import com.sap.finex.interpreter.objects.FinexNativeObject;
import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.MultiValuedObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

public class NotInterpreter
	implements
	Interpreter<Not, FinexClass, Type, FinexClass, Association, Field, Statement, Expression, SignatureImplementation, FinexStackFrame, NativeImpl, FinexInterpreter> {
    private Not op;

    public NotInterpreter(Not op) {
	this.op = op;
    }

    @Override
    public RunletObject<Field, Type, FinexClass> evaluate(FinexInterpreter interpreter)
    throws SecurityException, IllegalArgumentException,
	    JmiException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
	RunletObject<Field, Type, FinexClass> operand = interpreter.evaluate(op.getOperand());
	RunletObject<Field, Type, FinexClass> result = null;
	if (operand instanceof FinexNativeObject) {
	    result = new FinexNativeObject((FinexClass) op.getType(),
		    !((Boolean) ((FinexNativeObject) operand).getNativeObject()), interpreter.getDefaultSnapshot(),
			    interpreter);
	} else {
	    // expecting a multi-object; return an emulated RunletObject that just produces a recursively negating iterator
	    MultiValuedObject<Field, Type, FinexClass> mvo = (MultiValuedObject<Field, Type, FinexClass>) operand;
	    result = new NegatingRunletObject(mvo, interpreter);
	}
	interpreter.getCallstack().peek().getAliasValues().usedAllOf(operand, op.getOperand(), result, op);
	return result;
    }
    
    public static class NegatingRunletObject extends MultiValuedObject<Field, Type, FinexClass> {
	private final FinexInterpreter interpreter;
	
	public NegatingRunletObject(MultiValuedObject<Field, Type, FinexClass> o, FinexInterpreter interpreter) {
	    super(o.getType(), o, o.isOrdered(), o.isUnique());
	    this.interpreter = interpreter;
	}
	
	public Iterator<RunletObject<Field, Type, FinexClass>> iterator() {
	    return new Iterator<RunletObject<Field,Type,FinexClass>>() {
		Iterator<RunletObject<Field, Type, FinexClass>> unconvertedIterator = NegatingRunletObject.this.iterator();
		
		@Override
		public boolean hasNext() {
		    return unconvertedIterator.hasNext();
		}
		@Override
		public RunletObject<Field, Type, FinexClass> next() {
		    RunletObject<Field, Type, FinexClass> unconverted = unconvertedIterator.next();
		    RunletObject<Field, Type, FinexClass> result;
		    if (unconverted instanceof FinexNativeObject) {
			result = new FinexNativeObject((FinexClass) unconverted.getType(),
				!((Boolean) ((FinexNativeObject) unconverted).getNativeObject()), interpreter
					.getDefaultSnapshot(), interpreter);
		    } else {
			result = new NegatingRunletObject((MultiValuedObject<Field, Type, FinexClass>) unconverted, interpreter);
		    }
		    return result;
		}
		@Override
		public void remove() {
		    unconvertedIterator.remove();
		}
	    };
	}
    }

}
