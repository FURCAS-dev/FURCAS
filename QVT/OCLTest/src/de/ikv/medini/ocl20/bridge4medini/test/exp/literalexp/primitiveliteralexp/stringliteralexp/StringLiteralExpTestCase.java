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

package de.ikv.medini.ocl20.bridge4medini.test.exp.literalexp.primitiveliteralexp.stringliteralexp;

import java.util.List;

import junit.framework.Assert;

import de.ikv.medini.ocl20.bridge4medini.test.OclInterpreterTestCase;

public class StringLiteralExpTestCase extends OclInterpreterTestCase {

	public void testStringLiteralExp() throws Exception {
		List result = this.adapter.evaluate("'test'");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals("test", ((String) result.get(0)));

		result = this.adapter.evaluate("''");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals("", ((String) result.get(0)));

		result = this.adapter.evaluate("'sha?���������kfas�fb8798zW<>!�Q%)=�\\\"$=)�I$&EWZ'");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals("sha?���������kfas�fb8798zW<>!�Q%)=�\\\"$=)�I$&EWZ", ((String) result.get(0)));

		result = this.adapter.evaluate("'asd''sdafds'");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals("asd'sdafds", ((String) result.get(0)));

		result = this.adapter.evaluate("'asd''''sdafds'");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals("asd''sdafds", ((String) result.get(0)));

	}

	// TODO TODOMWA test exotic chararcters !!! unicode

}
