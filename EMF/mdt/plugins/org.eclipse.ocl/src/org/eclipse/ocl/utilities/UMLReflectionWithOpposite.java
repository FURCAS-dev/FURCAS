/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.utilities;


/**
 * Adds a method for retrieving a property's opposites
 * 
 * @author Axel Uhl
 * @since 3.1
 */
public interface UMLReflectionWithOpposite<P> {
    /**
     * Obtains the opposite property.
     * @since 3.1
     */
    P getOpposite(P property);
}
