/**
 * <copyright>
 *
 * Copyright (c) 2006, 2007 IBM Corporation and others.
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
 * $Id: TupleValue.java,v 1.2 2011/01/24 20:47:51 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.values;

import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TupleType;

/**
 * Interface of a tuple instance value.  OCL expressions resulting in tuples
 * yield instances of this interface.
 * 
 * @author Christian W. Damus (cdamus)
 */
public interface TupleValue extends Value {
    /**
     * Obtains the tuple's type.
     * 
     * @return its type
     */
	TupleType getTupleType();
	
    /**
     * Queries the value of the specified tuple part.
     * 
     * @param partName the name of the part
     * @return the corresponding value
     */
	Object getValue(String partName);
    
    /**
     * Queries the value of the specified tuple part.
     * 
     * @param part the tuple part (as an attribute)
     * @return the corresponding value
     */
	Object getValue(Property part);
}
