package com.sap.runlet.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;

import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.RunletStackFrame;
import com.sap.runlet.interpreter.objects.NativeObject;
import com.sap.runlet.interpreter.objects.ValueObject;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.NativeImpl;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.expressions.ContentEquals;
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
public class ContentEqualsInterpreter implements Interpreter<ContentEquals, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    
    private ContentEquals contentEequals;
    
    public ContentEqualsInterpreter(ContentEquals equals) {
	this.contentEequals = equals;
    }

    @Override
    public ValueObject evaluate(RunletInterpreter interpreter)
	    throws SecurityException, IllegalArgumentException,
	    NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	Expression firstExp = contentEequals.getLeft();
	Expression secondExp = contentEequals.getRight();
	ValueObject result = new NativeObject((ClassTypeDefinition) contentEequals.getType(),
		interpreter.evaluate(firstExp).contentEquals(interpreter.evaluate(secondExp)),
		interpreter.getDefaultSnapshot(), interpreter);
	return result;
    }

}
