/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl;



/**
 * Introduces the {@link #navigateOppositeProperty(P, Object)} method to
 * {@link AbstractEvaluationEnvironment} which implements this interface.
 * 
 * @author Axel Uhl
 * @since 3.1
 *
 */
public interface EvaluationEnvironmentWithHiddenOpposites<P> {
    /**
     * Obtains the value of the specified operation, for the given source element,
     * according to the particular metamodel semantics.
     * 
     * @param property the property to navigate in reverse direction
     * @param source the source element from where to start navigating / querying
     * @return the property value
     * 
     * @throws IllegalArgumentException if the property is not supported by the
     *     element or by this environment
     * @since 3.0
     */
    Object navigateOppositeProperty(P property, Object source)
    	throws IllegalArgumentException;

}
