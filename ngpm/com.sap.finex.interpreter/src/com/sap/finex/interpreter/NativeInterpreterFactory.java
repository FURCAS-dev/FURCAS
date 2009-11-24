package com.sap.finex.interpreter;

import java.util.LinkedList;
import java.util.List;

import structure.AFunctionsOwner;
import structure.Association;
import structure.Field;
import structure.FinexClass;
import structure.Type;
import behavior.actions.Statement;
import behavior.expressions.Expression;
import behavior.functions.NativeImpl;
import behavior.functions.SignatureImplementation;

import com.sap.runlet.abstractinterpreter.InterpreterFactory;

/**
 * For a native signature implementation ({@link NativeImpl}) finds the most
 * adequate interpreter. This implementation decides based on the type owning
 * the signature for which a native implementation is passed.
 * <p>
 * 
 * Interpreters are registered for one or more signature owners (see
 * {@link SapClass}). If this would lead to an ambiguity for resolving
 * interpreters, an exception is thrown.
 * <p>
 * 
 * The factory chooses the interpreter that can handle the signature owner and
 * for which no other interpreter is registered for a signature owner that
 * conforms to first signature owner. In other words, the most specific handling
 * interpreter is selected.
 * <p>
 * 
 * @author Axel Uhl (D043530)
 */
public class NativeInterpreterFactory
extends InterpreterFactory<FinexClass, NativeImpl, FinexClass, Type, FinexClass,
Association, Field, Statement, Expression, SignatureImplementation,
FinexStackFrame, NativeImpl, FinexInterpreter> {
    protected FinexClass getType(NativeImpl modelElement) {
	FinexClass clazz = modelElement.get___Connection().getAssociation(AFunctionsOwner.ASSOCIATION_DESCRIPTOR).
					getOwner(modelElement.getSignature());
	return clazz;
    }

    protected Iterable<FinexClass> getDirectSupertypes(FinexClass c) {
	List<FinexClass> result = new LinkedList<FinexClass>();
	return result;
    }
}
