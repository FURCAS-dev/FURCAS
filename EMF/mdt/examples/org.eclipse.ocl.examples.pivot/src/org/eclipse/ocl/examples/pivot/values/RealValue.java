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
 * $Id: RealValue.java,v 1.4 2011/02/21 08:37:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values;

import org.eclipse.ocl.examples.pivot.InvalidValueException;

public interface RealValue extends NumericValue
{
	RealValue abs() throws InvalidValueException;
	RealValue add(RealValue right) throws InvalidValueException;
	RealValue divide(RealValue right) throws InvalidValueException;
	IntegerValue floor() throws InvalidValueException;
	RealValue max(RealValue right) throws InvalidValueException;
	RealValue min(RealValue right) throws InvalidValueException;
	RealValue multiply(RealValue right) throws InvalidValueException;
	RealValue negate() throws InvalidValueException;	
	IntegerValue round() throws InvalidValueException;
	int signum() throws InvalidValueException;
	RealValue subtract(RealValue right) throws InvalidValueException;
}
