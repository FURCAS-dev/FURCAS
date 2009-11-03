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

package de.ikv.medini.ocl20.bridge4medini.test.lib.datatype;

import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import de.ikv.medini.ocl20.bridge4medini.test.OclInterpreterTestCase;

public class TupleTestCase extends OclInterpreterTestCase {

	public void testIncrement() throws Exception {
		// List result = adapter.evaluate("context Integer def: inc() : Integer = self + 1 ");

		List result = this.adapter.evaluate("context Integer def: inc() : Integer = self + 1  context OclVoid inv: 1.inc() ");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(2, ((Number) result.get(0)).intValue());

		// assertEquals("hihi", adapter.evaluateToString("context xyd Integer def: inc() : Integer = self + 1 context
		// OclVoid inv: 1.inc() ", new EnvironmentEntry[0]));

	}

	public void testEq() throws Exception {
		List result = this.adapter.evaluate("Tuple { name : String = 'test' , value : Integer = 2 } = Tuple { value : Integer = 2 , name : String = 'test' }");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("Tuple { name : String = 'test' , value : Integer = 2 } = Tuple { value : Integer = 2 , name : String = 'tes' }");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());
	}

	public void testNotEq() throws Exception {
		List result = this.adapter.evaluate("Tuple { name : String = 'test' , value : Integer = 2 } <> Tuple { value : Integer = 2 , name : String = 'test' }");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("Tuple { name : String = 'test' , value : Integer = 2 } <> Tuple { value : Integer = 2 , name : String = 'tes' }");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());
	}

	// public void testCreation() throws Exception {
	// List result = adapter.evaluate("Tuple { name : String = 'test' , value : Integer = 2 } ");
	// assertEquals(result.size(), 1);
	// Map tuple = (Map)result.get(0);
	// assertEquals(tuple.keySet().size() , 2);
	// assertTrue(tuple.keySet().contains("name"));
	// assertTrue(tuple.keySet().contains("value"));
	// assertEquals(((OclStringImpl)tuple.get("name")).asJavaObject(), "test");
	// assertEquals(((OclIntegerImpl)tuple.get("value")).asJavaObject(), adapter.getNumber(2));
	// }

	public void testCreation() throws Exception {

		if (this.adapter.supportsTuple()) {
			List result = this.adapter.evaluate("Tuple { name : String = 'test' , value : Integer = 2 } ");
			Assert.assertEquals(result.size(), 1);
			if (result.get(0) instanceof Map) {
				Map m = (Map) result.get(0);
				Assert.assertTrue("'test'".equals(m.get("name").toString()));
				Assert.assertTrue("2".equals(m.get("value").toString()));
				return;
			}
			/*
			 * Collection tuples = (Collection) result.get(0); assertEquals(tuples.size(), 2); StructureFieldValuePair[] structureFieldValuePairs = new StructureFieldValuePair[2];
			 * structureFieldValuePairs[0] = new StructureFieldValuePair("name", "test", null); structureFieldValuePairs[1] = new StructureFieldValuePair("value", "2", null);
			 * assertTrue(tuples.contains(new GenericStructureValue(structureFieldValuePairs)));
			 */
		}
	}
}
