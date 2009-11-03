package com.sap.river.interpreter;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import data.classes.MethodSignature;
import data.classes.NativeImpl;
import data.classes.SapClass;
import data.classes.TypeAdapter;

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
public class NativeInterpreterFactory extends InterpreterFactory<SapClass, NativeImpl> {
    protected SapClass getType(NativeImpl modelElement) {
	SapClass clazz = (SapClass) ((MethodSignature) modelElement.getImplementedSignature()).getOwner();
	return clazz;
    }

    protected Iterable<SapClass> getDirectSupertypes(SapClass c) {
	List<SapClass> result = new LinkedList<SapClass>();
	Collection<TypeAdapter> adapters = c.getAdapters();
	for (TypeAdapter a:adapters) {
	    result.add(a.getTo());
	}
	return result;
    }
}
