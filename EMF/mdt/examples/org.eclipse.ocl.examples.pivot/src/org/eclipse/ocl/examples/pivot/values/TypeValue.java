/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: TypeValue.java,v 1.4 2011/04/25 09:49:15 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values;

import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.Type;

public interface TypeValue extends ElementValue<Type>
{
	TypeValue asTypeValue() throws InvalidValueException;
	Type getInstanceType();
	Type getType();
}
