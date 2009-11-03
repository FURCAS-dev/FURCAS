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

package de.ikv.medini.ocl20.bridge4medini.test.exp.literalexp.collectionliteralexp;

import java.util.Collection;
import java.util.List;
import java.util.Vector;

import junit.framework.Assert;

public class OrderedSetCollectionLiteralExpTestCase extends CollectionLiteralExpTestCase {

	public void testOrderedSetCollectionLiteralExp() throws Exception {
		List result = this.adapter.evaluate("OrderedSet { 1 , 2 , 3 }");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Vector resultExpected = new Vector();
		resultExpected.add(this.adapter.getNumber(1));
		resultExpected.add(this.adapter.getNumber(2));
		resultExpected.add(this.adapter.getNumber(3));
		Assert.assertTrue(result1.equals(new Vector(resultExpected)));

		result = this.adapter.evaluate("OrderedSet { 1 .. 3 }");
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		resultExpected = new Vector();
		resultExpected.add(this.adapter.getNumber(1));
		resultExpected.add(this.adapter.getNumber(2));
		resultExpected.add(this.adapter.getNumber(3));
		Assert.assertEquals(3, result1.size());

		result = this.adapter.evaluate("OrderedSet {}");
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		resultExpected = new Vector();
		Assert.assertEquals(0, result1.size());

	}

}
