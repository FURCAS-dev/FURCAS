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

package de.ikv.medini.ocl20.bridge4medini.test.exp.literalexp.primitiveliteralexp.numericliteralexp.integerliteralexp;

import java.util.List;

import junit.framework.Assert;

import de.ikv.medini.ocl20.bridge4medini.test.OclInterpreterTestCase;

public class IntegerLiteralExpTestCase extends OclInterpreterTestCase {

	public void testIntegerLiteralExp() throws Exception {
		List result = this.adapter.evaluate("1");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(1L, ((Number) result.get(0)).longValue());

		result = this.adapter.evaluate("6");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(6L, ((Number) result.get(0)).longValue());

		result = this.adapter.evaluate(" -2");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(-2L, ((Number) result.get(0)).longValue());

		result = this.adapter.evaluate("0");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(0L, ((Number) result.get(0)).longValue());
	}
}
