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

package de.ikv.medini.ocl20.bridge4medini.test.exp.propertycallexp.loopexp.iterateexp;

import java.util.List;

import junit.framework.Assert;

import de.ikv.medini.ocl20.bridge4medini.test.OclInterpreterTestCase;

public class IterateExpTestCase extends OclInterpreterTestCase {

	// TODO implement !!
	public void testIterateWithNoElementTypeDefinition() throws Exception {
		List result = this.adapter.evaluate("Set { 1 , 2 , 3}->iterate( elem; acc : Integer = 0 | acc + elem ) ");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(6L, ((Number) result.get(0)).longValue());
	}

	public void testIterateWithElementTypeDefinition() throws Exception {
		List result = this.adapter.evaluate("Set { 1 , 2 , 3}->iterate( elem : Integer ; acc : Integer = 0 | acc + elem ) ");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(6L, ((Number) result.get(0)).longValue());
	}

}
