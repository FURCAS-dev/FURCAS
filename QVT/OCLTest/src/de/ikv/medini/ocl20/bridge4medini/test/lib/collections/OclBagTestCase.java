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

package de.ikv.medini.ocl20.bridge4medini.test.lib.collections;

import java.util.Collection;
import java.util.List;
import java.util.Vector;

import junit.framework.Assert;

import de.ikv.medini.ocl20.bridge4medini.test.OclInterpreterTestCase;

public class OclBagTestCase extends OclInterpreterTestCase {

	// non orderd non unique

	// collection operation tests

	public void testSize() throws Exception {
		List result = this.adapter.evaluate("Bag { 1 , 2 , 2 , 3  }.size()");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(4, ((Number) result.get(0)).longValue());
	}

	public void testIncludes() throws Exception {
		List result = this.adapter.evaluate("Bag { 1 , 2 , 2 , 3  }.includes(1)");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("Bag { 1 , 2 , 2 , 3  }.includes(2)");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("Bag { 1 , 2 , 2 , 3  }.includes(5)");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());
	}

	public void testExcludes() throws Exception {
		List result = this.adapter.evaluate("Bag { 1 , 2 , 2 , 3  }.excludes(1)");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("Bag { 1 , 2 , 2 , 3  }.excludes(2)");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("Bag { 1 , 2 , 2 , 3  }.excludes(5)");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

	}

	public void testCount() throws Exception {
		List result = this.adapter.evaluate("Bag { 1 , 2 , 2 , 3 , 2 }.count(5)");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(0, ((Number) result.get(0)).longValue());

		result = this.adapter.evaluate("Bag { 1 , 2 , 2 , 3  }.count(2)");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(2, ((Number) result.get(0)).longValue());

		result = this.adapter.evaluate("Bag { 1 , 2 , 2 , 3  }.count(1)");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(1, ((Number) result.get(0)).longValue());
	}

	public void testIncludesAll() throws Exception {
		List result = this.adapter.evaluate("Bag { 1 , 2 , 2 , 3 , 2 }.includesAll( Bag { 5 , 4 } )");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("Bag { 1 , 2 , 2 , 3 , 2 }.includesAll( Set { 5 , 4 } )");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("Bag { 1 , 2 , 2 , 3 , 2 }.includesAll( Bag { 5 , 2 } )");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("Bag { 1 , 2 , 2 , 3 , 2 }.includesAll( Set { 5 , 2 } )");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("Bag { 1 , 2 , 2 , 3 , 2 }.includesAll( Bag { 1 , 2 } )");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("Bag { 1 , 2 , 2 , 3 , 2 }.includesAll( Set { 1 , 2 } )");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());
	}

	public void testExcludesAll() throws Exception {
		List result = this.adapter.evaluate("Bag { 1 , 2 , 2 , 3 , 2 }.excludesAll( Bag { 5 , 4 } )");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("Bag { 1 , 2 , 2 , 3 , 2 }.excludesAll( Set { 5 , 4 } )");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("Bag { 1 , 2 , 2 , 3 , 2 }.excludesAll( Bag { 5 , 2 } )");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("Bag { 1 , 2 , 2 , 3 , 2 }.excludesAll( Set { 5 , 2 } )");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("Bag { 1 , 2 , 2 , 3 , 2 }.excludesAll( Bag { 1 , 2 } )");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("Bag { 1 , 2 , 2 , 3 , 2 }.excludesAll( Set { 1 , 2 } )");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());
	}

	public void testIsEmpty() throws Exception {
		List result = this.adapter.evaluate("Bag { 1 , 2 , 2 , 3 , 2 }.isEmpty()");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("Bag { }.isEmpty()");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

	}

	public void testNotEmpty() throws Exception {
		List result = this.adapter.evaluate("Bag { 1 , 2 , 2 , 3 , 2 }.notEmpty()");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("Bag { }.notEmpty()");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

	}

	// TODO
	// sum() : T
	// product(c2: Collection(T2)) : Set( Tuple( first: T, second: T2) )

	// specific tests

	public void testEquals() throws Exception {
		List result = this.adapter.evaluate("Bag { 1 , 2 , 3 , 3 } = Bag { 3 , 3 , 2 , 1 } ");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("Bag { 2 , 3 , 4 } = Bag {  3 , 2 , 1 }");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("Bag { 1 , 2 , 3 , 3 } = Bag { 1 , 3 , 2 , 1 }");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());
	}

	public void testUnionSet() throws Exception {
		List result = this.adapter.evaluate("Bag { 1 , 2 , 3 , 3 }.union( Set { 2 , 3 , 4 } )");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Vector resultExpected = new Vector();
		resultExpected.add(this.adapter.getNumber(1));
		resultExpected.add(this.adapter.getNumber(2));
		resultExpected.add(this.adapter.getNumber(3));
		resultExpected.add(this.adapter.getNumber(4));
		Assert.assertEquals(7, result1.size());
		Assert.assertTrue(result1.containsAll(new Vector(resultExpected)));

		result = this.adapter.evaluate("let testSet : Bag( Integer ) = Bag {  } in testSet.union( Set { 2 , 3 , 4 } )");
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		resultExpected = new Vector();
		resultExpected.add(this.adapter.getNumber(2));
		resultExpected.add(this.adapter.getNumber(3));
		resultExpected.add(this.adapter.getNumber(4));
		Assert.assertEquals(3, result1.size());
		Assert.assertTrue(result1.containsAll(new Vector(resultExpected)));
	}

	public void testUnionBag() throws Exception {
		List result = this.adapter.evaluate("Bag { 1 , 2 , 3 , 3 }.union( Bag { 2 , 3 , 3 , 4 , 4 } )");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Vector resultExpected = new Vector();
		resultExpected.add(this.adapter.getNumber(1));
		resultExpected.add(this.adapter.getNumber(2));
		resultExpected.add(this.adapter.getNumber(3));
		resultExpected.add(this.adapter.getNumber(4));
		Assert.assertEquals(9, result1.size());
		Assert.assertTrue(result1.containsAll(new Vector(resultExpected)));
		// TODO TODOMWA better !! 2x2 2x3

		result = this.adapter.evaluate("let testSet : Bag( Integer ) = Bag {  } in testSet.union( Bag { 2 , 3 , 4 , 4 } )");
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		resultExpected = new Vector();
		resultExpected.add(this.adapter.getNumber(2));
		resultExpected.add(this.adapter.getNumber(3));
		resultExpected.add(this.adapter.getNumber(4));
		Assert.assertEquals(4, result1.size());
		Assert.assertTrue(result1.containsAll(new Vector(resultExpected)));
	}

	public void testIntersectionSet() throws Exception {
		List result = this.adapter.evaluate("Bag { 1 , 2 , 3 , 3 }.intersection( Set { 3 , 2 , 4 } ) ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Vector resultExpected = new Vector();
		resultExpected.add(this.adapter.getNumber(2));
		resultExpected.add(this.adapter.getNumber(3));
		Assert.assertEquals(2, result1.size());
		Assert.assertTrue(result1.containsAll(new Vector(resultExpected)));

		result = this.adapter.evaluate("Bag { 1 , 2 , 3 , 3 }.intersection( Set { 4 , 5 , 6 } ) ");
		result1 = (Collection) result.get(0);
		Assert.assertEquals(0, result1.size());
	}

	public void testIntersectionBag() throws Exception {
		List result = this.adapter.evaluate("Bag { 1 , 2 , 3 , 3 }.intersection( Bag { 3 , 3 , 2 , 4 } ) ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Vector resultExpected = new Vector();
		resultExpected.add(this.adapter.getNumber(2));
		resultExpected.add(this.adapter.getNumber(3));
		Assert.assertEquals(3, result1.size());
		Assert.assertTrue(result1.containsAll(new Vector(resultExpected)));

		result = this.adapter.evaluate("Bag { 1 , 2 , 3 , 3 }.intersection( Bag { 4 , 5 , 6 , 6 } ) ");
		result1 = (Collection) result.get(0);
		Assert.assertEquals(0, result1.size());
	}

	public void testIncluding() throws Exception {
		List result = this.adapter.evaluate("Bag { 1 , 2 , 3 }.including(4) ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Vector resultExpected = new Vector();
		resultExpected.add(this.adapter.getNumber(1));
		resultExpected.add(this.adapter.getNumber(2));
		resultExpected.add(this.adapter.getNumber(3));
		resultExpected.add(this.adapter.getNumber(4));
		Assert.assertEquals(4, result1.size());
		Assert.assertTrue(result1.containsAll(new Vector(resultExpected)));

		result = this.adapter.evaluate("Bag { 2 }.including(2) ");
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		resultExpected = new Vector();
		resultExpected.add(this.adapter.getNumber(2));
		Assert.assertEquals(2, result1.size());
		Assert.assertTrue(result1.containsAll(new Vector(resultExpected)));
	}

	public void testExcluding() throws Exception {
		List result = this.adapter.evaluate("Bag { 1 , 2 , 2 , 3 }.excluding(4) ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Vector resultExpected = new Vector();
		resultExpected.add(this.adapter.getNumber(1));
		resultExpected.add(this.adapter.getNumber(2));
		resultExpected.add(this.adapter.getNumber(3));
		Assert.assertEquals(4, result1.size());
		Assert.assertTrue(result1.containsAll(new Vector(resultExpected)));

		result = this.adapter.evaluate("Bag { 1 , 2 , 3 , 3 }.excluding(3) ");
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		resultExpected = new Vector();
		resultExpected.add(this.adapter.getNumber(1));
		resultExpected.add(this.adapter.getNumber(2));
		Assert.assertEquals(2, result1.size());
		Assert.assertTrue(result1.containsAll(new Vector(resultExpected)));
	}

	public void testFlatten() throws Exception {
		List result = this.adapter.evaluate("Bag{ Set { 1 , 2 } , Set { 3 , 2 } }.flatten() ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Vector resultExpected = new Vector();
		resultExpected.add(this.adapter.getNumber(1));
		resultExpected.add(this.adapter.getNumber(2));
		resultExpected.add(this.adapter.getNumber(3));
		Assert.assertEquals(4, result1.size());
		Assert.assertTrue(result1.containsAll(new Vector(resultExpected)));

		result = this.adapter.evaluate("Bag{ Set { 1 , 2 } , Bag { 3 , 2 , 2 } }.flatten() ");
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		resultExpected = new Vector();
		resultExpected.add(this.adapter.getNumber(1));
		resultExpected.add(this.adapter.getNumber(2));
		resultExpected.add(this.adapter.getNumber(3));
		Assert.assertEquals(5, result1.size());
		Assert.assertTrue(result1.containsAll(new Vector(resultExpected)));
	}

	public void testAsSet() throws Exception {
		List result = this.adapter.evaluate("Bag { 1 , 2 , 2 , 3 }.asSet() ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Vector resultExpected = new Vector();
		resultExpected.add(this.adapter.getNumber(1));
		resultExpected.add(this.adapter.getNumber(2));
		resultExpected.add(this.adapter.getNumber(3));
		Assert.assertEquals(3, result1.size());
		Assert.assertTrue(result1.containsAll(new Vector(resultExpected)));
	}

	public void testAsOrderedSet() throws Exception {
		List result = this.adapter.evaluate("Bag { 1 , 2 , 2 , 3 }.asOrderedSet() ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Vector resultExpected = new Vector();
		resultExpected.add(this.adapter.getNumber(1));
		resultExpected.add(this.adapter.getNumber(2));
		resultExpected.add(this.adapter.getNumber(3));
		Assert.assertEquals(3, result1.size());
		Assert.assertTrue(result1.containsAll(new Vector(resultExpected)));
	}

	public void testAsSequence() throws Exception {
		List result = this.adapter.evaluate("Bag { 1 , 2 , 2 , 3 }.asSequence() ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Vector resultExpected = new Vector();
		resultExpected.add(this.adapter.getNumber(1));
		resultExpected.add(this.adapter.getNumber(2));
		resultExpected.add(this.adapter.getNumber(3));
		Assert.assertEquals(4, result1.size());
		Assert.assertTrue(result1.containsAll(new Vector(resultExpected)));
	}

	public void testAsBag() throws Exception {
		List result = this.adapter.evaluate("Bag { 1 , 2 , 2 , 3 }.asBag() ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Vector resultExpected = new Vector();
		resultExpected.add(this.adapter.getNumber(1));
		resultExpected.add(this.adapter.getNumber(2));
		resultExpected.add(this.adapter.getNumber(3));
		Assert.assertEquals(4, result1.size());
		Assert.assertTrue(result1.containsAll(new Vector(resultExpected)));
	}

}
