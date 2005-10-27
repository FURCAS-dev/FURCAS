/******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.emf.ocl.parser;


/**
 * The evaluation environment keeps track of the current values of variables
 * in the evaluation of an OCL expression.
 * 
 * @author tklinger
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
}