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

package de.ikv.medini.ocl20.bridge4medini.test.exp.literalexp.primitiveliteralexp.numericliteralexp.realliteralexp;

import java.util.List;

import junit.framework.Assert;

import de.ikv.medini.ocl20.bridge4medini.test.OclInterpreterTestCase;

public class RealLiteralExpTestCase extends OclInterpreterTestCase {

	public void testRealLiteralExp() throws Exception {
		List result = this.adapter.evaluate("1.1");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(1.1, ((Double) result.get(0)).doubleValue(), 0);

		result = this.adapter.evaluate("6.3");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(6.3, ((Double) result.get(0)).doubleValue(), 0);

		result = this.adapter.evaluate(" -2.2");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(-2.2, ((Double) result.get(0)).doubleValue(), 0);

		result = this.adapter.evaluate("0.0");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(0.0, ((Double) result.get(0)).doubleValue(), 0);
	}

}
