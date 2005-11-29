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

package org.eclipse.emf.ocl.parser;

import org.eclipse.emf.ecore.EOperation;

/**
 * The evaluation environment keeps track of the current values of variables
 * in the evaluation of an OCL expression.
 * 
 * @author Tim Klinger (tklinger)
 * @author Christian W. Damus (cdamus)
 */
public interface EvaluationEnvironment {
    /**
     * Returns the value associated with the supplied name
     * 
     * @param name
     *            the name whose value is to be returned
     * @return the value associated with the name
     */
    Object getValueOf(String name);

    /**
     * Replaces the current value of the supplied name with the supplied value.
     * 
     * @param name
     *            the name
     * @param value
     *            the new value
     */
    void replace(String name, Object value);

    /**
     * Adds the supplied name and value binding to the environment.  The name
     * must not already be bound.
     * 
     * @param name
     *            the name to add
     * @param value
     *            the associated binding
     *            
     * @see #replace(String, Object)
     */
    void add(String name, Object value);

    /**
     * Removes the supplied name and binding from the environment (if it exists)
     * and returns it.
     * 
     * @param name
     *            the name to remove
     * @return the value associated with the removed name
     */
    Object remove(String name);

    /**
     * Clears the environment of variables.
     */
    void clear();
    
    /**
     * Queries whether this evaluation environment provides a custom
     * implementation of the specified OCL <code>operation</code>.  In the case
     * that the receiver does, then it must implement the
     * {@link #evaluate(EOperation, int, Object, Object[])} method to apply
     * the operation.
     * 
     * @param operation an OCL operation
     * @param opcode the operation code, if one of the operations pre-defined
     *    by OCL.  Otherwise, <code>-1</code>
     *    
     * @return <code>true</code> if this evaluation environment provides an
     *    implementation of this <code>operation</code>; <code>false</code>,
     *    otherwise
     *    
     * @see #evaluate(EOperation, int, Object, Object[])
     */
    boolean canEvaluate(EOperation operation, int opcode);
    
    /**
     * Evaluates the specified <code>operation</code> on a given
     * <code>target</code> object with arguments.
     * 
     * @param operation the operation to evaluate
     * @param opcode the operation code, if one of the operations pre-defined
     *    by OCL.  Otherwise, <code>-1</code>
     * @param target the object on which to apply the <code>operation</code>.
     *    the target may be an {@link org.eclipse.emf.ecore.EObject} or it
     *    may not, depending on the {@link org.eclipse.emf.ecore.EClassifier}
     *    type
     * @param args the arguments passed to the <code>operation</code>.  Will
     *    be an empty array if there are none (not <code>null</code>)
     * 
     * @return the value of the operation, or <code>null</code> if the operation
     *    has no return result
     *    
     * @throws UnsupportedOperationException if the specified
     *    <code>operation</code> is not implemented by this environment
     * 
     * @see #canEvaluate(EOperation, int)
     */
    Object evaluate(EOperation operation, int opcode, Object target, Object[] args)
    	throws UnsupportedOperationException;
}