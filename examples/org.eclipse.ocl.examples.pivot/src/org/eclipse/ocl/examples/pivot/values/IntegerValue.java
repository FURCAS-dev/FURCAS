/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
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
 * $Id: IntegerValue.java,v 1.2 2011/01/24 20:47:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values;

import java.math.BigInteger;

public interface IntegerValue extends NumericValue
{	
	BigInteger bigIntegerValue();
	IntegerValue add(IntegerValue right);
	IntegerValue div(IntegerValue right);
	RealValue divide(IntegerValue right);
	IntegerValue max(IntegerValue right);
	IntegerValue min(IntegerValue right);
	IntegerValue mod(IntegerValue right);
	IntegerValue multiply(IntegerValue right);
	IntegerValue negate();
	IntegerValue subtract(IntegerValue right);
}
