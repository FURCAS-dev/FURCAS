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

public class OclSequenceTestCase extends OclInterpreterTestCase {

	// orderd non unique

	// collection operation tests

	public void testSize() throws Exception {
		List result = this.adapter.evaluate("Sequence { 1 , 2 , 2 , 3  }.size()");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(4, ((Number) result.get(0)).longValue());
	}

	public void testIncludes() throws Exception {
		List result = this.adapter.evaluate("Sequence { 1 , 2 , 2 , 3  }.includes(1)");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("Sequence { 1 , 2 , 2 , 3  }.includes(2)");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("Sequence { 1 , 2 , 2 , 3  }.includes(5)");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());
	}

	public void testExcludes() throws Exception {
		List result = this.adapter.evaluate("Sequence { 1 , 2 , 2 , 3  }.excludes(1)");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("Sequence { 1 , 2 , 2 , 3  }.excludes(2)");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("Sequence { 1 , 2 , 2 , 3  }.excludes(5)");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

	}

	public void testCount() throws Exception {
		List result = this.adapter.evaluate("Sequence { 1 , 2 , 2 , 3 , 2 }.count(5)");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(0, ((Number) result.get(0)).longValue());

		result = this.adapter.evaluate("Sequence { 1 , 2 , 2 , 3  }.count(2)");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(2, ((Number) result.get(0)).longValue());

		result = this.adapter.evaluate("Sequence { 1 , 2 , 2 , 3  }.count(1)");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(1, ((Number) result.get(0)).longValue());
	}

	public void testIncludesAll() throws Exception {
		List result = this.adapter.evaluate("Sequence { 1 , 2 , 2 , 3 , 2 }.includesAll( Bag { 5 , 4 } )");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("Sequence { 1 , 2 , 2 , 3 , 2 }.includesAll( Set { 5 , 4 } )");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("Sequence { 1 , 2 , 2 , 3 , 2 }.includesAll( Bag { 5 , 2 } )");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("Sequence { 1 , 2 , 2 , 3 , 2 }.includesAll( Set { 5 , 2 } )");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("Sequence { 1 , 2 , 2 , 3 , 2 }.includesAll( Bag { 1 , 2 } )");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("Sequence { 1 , 2 , 2 , 3 , 2 }.includesAll( Set { 1 , 2 } )");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());
	}

	public void testExcludesAll() throws Exception {
		List result = this.adapter.evaluate("Sequence { 1 , 2 , 2 , 3 , 2 }.excludesAll( Bag { 5 , 4 } )");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("Sequence { 1 , 2 , 2 , 3 , 2 }.excludesAll( Set { 5 , 4 } )");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("Sequence { 1 , 2 , 2 , 3 , 2 }.excludesAll( Bag { 5 , 2 } )");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("Sequence { 1 , 2 , 2 , 3 , 2 }.excludesAll( Set { 5 , 2 } )");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("Sequence { 1 , 2 , 2 , 3 , 2 }.excludesAll( Bag { 1 , 2 } )");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("Sequence { 1 , 2 , 2 , 3 , 2 }.excludesAll( Set { 1 , 2 } )");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());
	}

	public void testIsEmpty() throws Exception {
		List result = this.adapter.evaluate("Sequence { 1 , 2 , 2 , 3 , 2 }.isEmpty()");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("Sequence { }.isEmpty()");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

	}

	public void testNotEmpty() throws Exception {
		List result = this.adapter.evaluate("Sequence { 1 , 2 , 2 , 3 , 2 }.notEmpty()");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("Sequence { }.notEmpty()");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

	}

	// TODO
	// sum() : T
	// product(c2: Collection(T2)) : Set( Tuple( first: T, second: T2) )

	// specific tests

	public void testUnion() throws Exception {
		List result = this.adapter.evaluate("Sequence { 1 , 2 , 2 , 3 }.union( Sequence { 2 , 2 , 3 , 4 } )");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Vector resultExpected = new Vector();
		resultExpected.add(this.adapter.getNumber(1));
		resultExpected.add(this.adapter.getNumber(2));
		resultExpected.add(this.adapter.getNumber(2));
		resultExpected.add(this.adapter.getNumber(3));
		resultExpected.add(this.adapter.getNumber(2));
		resultExpected.add(this.adapter.getNumber(2));
		resultExpected.add(this.adapter.getNumber(3));
		resultExpected.add(this.adapter.getNumber(4));
		Assert.assertEquals(resultExpected, result1);

		result = this.adapter.evaluate("let testSet : Sequence( Integer ) = Sequence {  } in testSet.union( Sequence { 2 , 3 , 4 , 4 } )");
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		resultExpected = new Vector();
		resultExpected.add(this.adapter.getNumber(2));
		resultExpected.add(this.adapter.getNumber(3));
		resultExpected.add(this.adapter.getNumber(4));
		resultExpected.add(this.adapter.getNumber(4));
		Assert.assertEquals(resultExpected, result1);
	}

	public void testFlatten() throws Exception {
		List result = this.adapter.evaluate("Sequence{ Sequence { 1 , 2, 2 } , Sequence { 3 , 2 , 2 } }.flatten() ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Vector resultExpected = new Vector();
		resultExpected.add(this.adapter.getNumber(1));
		resultExpected.add(this.adapter.getNumber(2));
		resultExpected.add(this.adapter.getNumber(3));
		Assert.assertEquals(6, result1.size());
		Assert.assertTrue(result1.containsAll(new Vector(resultExpected)));

		result = this.adapter.evaluate("Sequence{ Sequence { 1 , 2 , 2 } , Bag { 3 , 2 , 2 } }.flatten() ");
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		resultExpected = new Vector();
		resultExpected.add(this.adapter.getNumber(1));
		resultExpected.add(this.adapter.getNumber(2));
		resultExpected.add(this.adapter.getNumber(3));
		Assert.assertEquals(6, result1.size());
		Assert.assertTrue(result1.containsAll(new Vector(resultExpected)));
	}

	public void testAppend() throws Exception {
		List result = this.adapter.evaluate("Sequence { 1 , 2 , 2 , 3 }.append(4) ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Vector resultExpected = new Vector();
		resultExpected.add(this.adapter.getNumber(1));
		resultExpected.add(this.adapter.getNumber(2));
		resultExpected.add(this.adapter.getNumber(2));
		resultExpected.add(this.adapter.getNumber(3));
		resultExpected.add(this.adapter.getNumber(4));
		Assert.assertEquals(resultExpected, result1);
		// TODO equal for all others instead of containsAll

		result = this.adapter.evaluate("let testSet : Sequence( Integer ) = Sequence {  } in testSet.append(4) ");
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		resultExpected = new Vector();
		resultExpected.add(this.adapter.getNumber(4));
		Assert.assertEquals(resultExpected, result1);
	}

	public void testPrepend() throws Exception {
		List result = this.adapter.evaluate("Sequence { 1 , 2 , 3 , 3 }.prepend(4) ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Vector resultExpected = new Vector();
		resultExpected.add(this.adapter.getNumber(4));
		resultExpected.add(this.adapter.getNumber(1));
		resultExpected.add(this.adapter.getNumber(2));
		resultExpected.add(this.adapter.getNumber(3));
		resultExpected.add(this.adapter.getNumber(3));
		Assert.assertEquals(resultExpected, result1);
		// TODO equal for all others instead of containsAll

		result = this.adapter.evaluate("let testSet : Sequence( Integer ) = Sequence {  } in testSet.prepend(4) ");
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		resultExpected = new Vector();
		resultExpected.add(this.adapter.getNumber(4));
		Assert.assertEquals(resultExpected, result1);
	}

	public void testInsertAt() throws Exception {
		List result = this.adapter.evaluate("Sequence { 1 , 2 , 2 , 3 }.insertAt(2 , 4) ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Vector resultExpected = new Vector();
		resultExpected.add(this.adapter.getNumber(1));
		resultExpected.add(this.adapter.getNumber(4));
		resultExpected.add(this.adapter.getNumber(2));
		resultExpected.add(this.adapter.getNumber(2));
		resultExpected.add(this.adapter.getNumber(3));
		Assert.assertEquals(resultExpected, result1);
	}

	public void testSubOrderedSet() throws Exception {
		List result = this.adapter.evaluate("Sequence { 1 , 2 , 3 , 3 , 4 }.subSequence(2 , 4) ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Vector resultExpected = new Vector();
		resultExpected.add(this.adapter.getNumber(2));
		resultExpected.add(this.adapter.getNumber(3));
		resultExpected.add(this.adapter.getNumber(3));
		Assert.assertEquals(resultExpected, result1);
		// TODO check for ocl undefined too
	}

	public void testAt() throws Exception {
		List result = this.adapter.evaluate("Sequence { 1 , 3 , 2 , 4 }.at( 3 ) ");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(2, ((Number) result.get(0)).longValue());
		// TODO check for ocl undefined too
	}

	public void testIndexOf() throws Exception {
		List result = this.adapter.evaluate("Sequence { 1 , 3 , 2 , 4 }.indexOf( 2 ) ");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(3, ((Number) result.get(0)).longValue());
		// TODO check for ocl undefined too
	}

	public void testFirst() throws Exception {
		List result = this.adapter.evaluate("Sequence { 1 , 2 , 3 , 4 }.first() ");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(1, ((Number) result.get(0)).longValue());
		// TODO check for ocl undefined too
	}

	public void testLast() throws Exception {
		List result = this.adapter.evaluate("Sequence { 1 , 2 , 3 , 4 }.last() ");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(4, ((Number) result.get(0)).longValue());
		// TODO check for ocl undefined too
	}

	public void testIncluding() throws Exception {
		List result = this.adapter.evaluate("Sequence { 1 , 2 , 3 }.including(4) ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Vector resultExpected = new Vector();
		resultExpected.add(this.adapter.getNumber(1));
		resultExpected.add(this.adapter.getNumber(2));
		resultExpected.add(this.adapter.getNumber(3));
		resultExpected.add(this.adapter.getNumber(4));
		Assert.assertEquals(resultExpected, result1);

		result = this.adapter.evaluate("Sequence { 2 }.including(2) ");
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		resultExpected = new Vector();
		resultExpected.add(this.adapter.getNumber(2));
		resultExpected.add(this.adapter.getNumber(2));
		Assert.assertEquals(resultExpected, result1);
	}

	public void testExcluding() throws Exception {
		List result = this.adapter.evaluate("Sequence { 1 , 2 , 3 }.excluding(4) ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Vector resultExpected = new Vector();
		resultExpected.add(this.adapter.getNumber(1));
		resultExpected.add(this.adapter.getNumber(2));
		resultExpected.add(this.adapter.getNumber(3));
		Assert.assertEquals(resultExpected, result1);

		result = this.adapter.evaluate("Sequence { 1 , 3 , 2 , 3 }.excluding(3) ");
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		resultExpected = new Vector();
		resultExpected.add(this.adapter.getNumber(1));
		resultExpected.add(this.adapter.getNumber(2));
		Assert.assertEquals(resultExpected, result1);
	}

	public void testAsSet() throws Exception {
		List result = this.adapter.evaluate("Sequence { 1 , 2 , 2 , 3 }.asSet() ");
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
		List result = this.adapter.evaluate("Sequence { 1 , 2 , 3 , 3 }.asOrderedSet() ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Vector resultExpected = new Vector();
		resultExpected.add(this.adapter.getNumber(1));
		resultExpected.add(this.adapter.getNumber(2));
		resultExpected.add(this.adapter.getNumber(3));
		Assert.assertEquals(resultExpected, result1);
	}

	public void testAsSequence() throws Exception {
		List result = this.adapter.evaluate("Sequence { 1 , 2 , 3 , 3 }.asSequence() ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Vector resultExpected = new Vector();
		resultExpected.add(this.adapter.getNumber(1));
		resultExpected.add(this.adapter.getNumber(2));
		resultExpected.add(this.adapter.getNumber(3));
		resultExpected.add(this.adapter.getNumber(3));
		Assert.assertEquals(resultExpected, result1);
	}

	public void testAsBag() throws Exception {
		List result = this.adapter.evaluate("Sequence { 1 , 2 , 3 , 3 }.asBag() ");
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
