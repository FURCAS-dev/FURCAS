package com.sap.river.interpreter;

import java.util.LinkedList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import dataaccess.expressions.Expression;

/**
 * For a model element, such as an expression, finds the most adequate
 * interpreter. This implementation decides based on the actual type of the
 * model element.
 * <p>
 * 
 * Interpreters are registered for one or more concrete types. If this would
 * lead to an ambiguity for resolving interpreters, an exception is thrown.
 * <p>
 * 
 * The factory chooses the interpreter that can handle the actual type of the
 * model element and for which no other interpreter is registered for a type to
 * which the model element conforms and that conforms to the type the chosen
 * interpreter can handle. In other words, the most specific handling
 * interpreter is selected.
 * <p>
 * 
 * @param <C>
 *            the type class on which direct supertypes can be computed which
 *            defines a conformance relation for finding the most specific
 *            interpreter
 * @param <T>
 *            the type of the model elements that interpreters managed by this
 *            factory can interpret. Example: {@link Expression} as the abstract
 *            superclass of all expressions. In particular, elements passed to
 *            {@link #getInterpreterFor(RefObject)} have to be at least of that
 *            type.
 * 
 * @author Axel Uhl (D043530)
 */
public class MofClassInterpreterFactory<T extends RefObject> extends InterpreterFactory<MofClass, T> {
    protected MofClass getType(T modelElement) {
	MofClass clazz = (MofClass) modelElement.refMetaObject();
	return clazz;
    }

    protected Iterable<MofClass> getDirectSupertypes(MofClass c) {
	List<MofClass> result = new LinkedList<MofClass>();
	for (GeneralizableElement ge:c.getSupertypes()) {
	    result.add((MofClass) ge);
	}
	return result;
    }
}
