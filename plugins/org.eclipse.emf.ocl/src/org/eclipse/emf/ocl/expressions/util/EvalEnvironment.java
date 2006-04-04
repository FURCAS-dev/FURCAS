/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */

package org.eclipse.emf.ocl.expressions.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ocl.internal.l10n.OCLMessages;
import org.eclipse.emf.ocl.parser.EvaluationEnvironment;
import org.eclipse.osgi.util.NLS;

/**
 * 
 * A mapping of names to objects used in the evaluation of expressions.
 * 
 * @author Tim Klinger (tklinger)
 */
public class EvalEnvironment implements EvaluationEnvironment {

    private final Map map = new HashMap();
    private final EvaluationEnvironment parent;

    public EvalEnvironment() {
        this(null);
    }
    
    public EvalEnvironment(EvaluationEnvironment parent) {
    	this.parent = parent;
    }

    /**
     * Returns the value associated with the supplied name
     * 
     * @param name
     *            the name whose value is to be returned
     * @return the value associated with the name
     */
    public Object getValueOf(String name) {
        return map.get(name);
    }

    /**
     * Replaces the current value of the supplied name with the supplied value.
     * 
     * @param name
     *            the name
     * @param value
     *            the new value
     */
    public void replace(String name, Object value) {
        map.put(name, value);
    }

    /**
     * Adds the supplied name and value binding to the environment
     * 
     * @param name
     *            the name to add
     * @param value
     *            the associated binding
     */
    public void add(String name, Object value) {
        if (map.containsKey(name)) {
            String message = NLS.bind(OCLMessages.BindingExist_ERROR_,
                    new Object[] { name, map.get(name) });
            throw new IllegalArgumentException(message);
        }
        map.put(name, value);
    }

    /**
     * Removes the supplied name and binding from the environment (if it exists)
     * and returns it.
     * 
     * @param name
     *            the name to remove
     * @return the value associated with the removed name
     */
    public Object remove(String name) {
        return map.remove(name);
    }

    /**
     * Clears the environment of variables.
     */
    public void clear() {
        map.clear();
    }

    /**
     * Returns a string representation of the bindings
     */
    public String toString() {
        return map.toString();
    }

    /**
     * Always returns <code>false</code>, because by default only the operations
     * defined by the OCL itself and the particular EMF metamodel are supported.
     * Subclasses can override to override existing operation implementations or
     * to add operations not defined by either OCL or the metamodel.
     */
    public boolean canEvaluate(EOperation operation, int opcode) {
    	return (parent != null)? parent.canEvaluate(operation, opcode) : false;
    }
    
    /**
     * Implements the interface method by just throwing,
     * as I do not by default provide any implementation of any additional
     * operations.
     */
    public Object evaluate(EOperation operation, int opcode, Object target, Object[] args)
    		throws UnsupportedOperationException {
    	if (parent != null) {
    		return parent.evaluate(operation, opcode, target, args);
    	}
    	
    	throw new UnsupportedOperationException();
    }
}