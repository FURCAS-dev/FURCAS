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

package de.ikv.medini.ocl20.bridge4medini.test.exp.propertycallexp.loopexp.iteratorexp;

import java.util.Collection;
import java.util.List;
import java.util.Vector;

import junit.framework.Assert;

import de.ikv.medini.ocl20.bridge4medini.test.OclInterpreterTestCase;

public class SelectIteratorExpTestCase extends OclInterpreterTestCase {

	public void testSelectIteratorWithoutType() throws Exception {
		List result = this.adapter.evaluate("Set { 1 , 2 , 3}->select( x | x < 3 ) ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Vector resultExpected = new Vector();
		resultExpected.add(this.adapter.getNumber(1));
		resultExpected.add(this.adapter.getNumber(2));
		Assert.assertEquals(2, result1.size());
		Assert.assertTrue(result1.containsAll(new Vector(resultExpected)));

		result = this.adapter.evaluate("Set { }->select( x | x < 3) ");
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		Assert.assertEquals(0, result1.size());
	}

	public void testSelectIteratorWithType() throws Exception {
		List result = this.adapter.evaluate("Set { 1 , 2 , 3}->select( x : Integer | x < 3 ) ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Vector resultExpected = new Vector();
		resultExpected.add(this.adapter.getNumber(1));
		resultExpected.add(this.adapter.getNumber(2));
		Assert.assertEquals(2, result1.size());
		Assert.assertTrue(result1.containsAll(new Vector(resultExpected)));

		// result = adapter.evaluate("Set { }->select( x : Integer | x < 3 ) ");
		// assertEquals(result.size(), 1);
		// result1 = (Collection)result.get(0);
		// assertEquals(0,result1.size());
	}

}
