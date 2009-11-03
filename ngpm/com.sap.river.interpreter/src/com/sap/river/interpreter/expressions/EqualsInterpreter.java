package com.sap.river.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.NativeObject;
import com.sap.river.interpreter.objects.ValueObject;

import data.classes.ClassTypeDefinition;
import dataaccess.expressions.Equals;
import dataaccess.expressions.Expression;

/**
 * Implements the notion of equality. Two objects of entity classes compare equal if they
 * have equal identity. (Note that in this programming model it shall not be possible to hold
 * two distinct copies of the same entity.)<p>
 * 
 * For objects of value classes this comparison works recursively along all association ends
 * whose navigation feature is exposed by the value class as a signature. The rationale behind this
 * is that otherwise the notion of a value class's equality would be altered by adding an external
 * association to it, which is not a desirable behavior.
 * 
 * TODO Equals must be extensible for natively-implemented value classes
 * 
 * @author Axel Uhl (D043530)
 */
public class EqualsInterpreter implements Interpreter<Equals> {
    
    private Equals equals;
    
    public EqualsInterpreter(Equals equals) {
	this.equals = equals;
    }

    @Override
    public ValueObject evaluate(RiverInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException,
	    NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	Expression firstExp = equals.getLeft();
	Expression secondExp = equals.getRight();
	ValueObject result = new NativeObject((ClassTypeDefinition) equals.getType(),
		interpreter.evaluate(firstExp).logicallyEquals(interpreter.evaluate(secondExp)), interpreter.getDefaultSnapshot(), interpreter);
	return result;
    }

}
