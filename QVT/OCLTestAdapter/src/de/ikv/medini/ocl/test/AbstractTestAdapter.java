/*******************************************************************************
 * Copyright (c) 2008 ikv++ technologies ag and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     ikv++ technologies ag - initial API and implementation
 *******************************************************************************/

package de.ikv.medini.ocl.test;

import java.util.List;

public abstract class AbstractTestAdapter implements OCLTestAdapter {

	Object evaluateOne(String oclExpression) {
		List result = this.evaluate(oclExpression);
		return result.get(0);
	}

}
