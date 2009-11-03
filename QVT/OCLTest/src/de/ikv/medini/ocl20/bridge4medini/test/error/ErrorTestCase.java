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

package de.ikv.medini.ocl20.bridge4medini.test.error;

import java.util.List;

import junit.framework.Assert;

import de.ikv.medini.ocl20.bridge4medini.test.OclInterpreterTestCase;

public class ErrorTestCase extends OclInterpreterTestCase {

	public void testInvariantExecutionOnAllObjectsOfContextKind() throws Exception {
		try {
			long start = System.currentTimeMillis();

			List result = null;
			result = this.adapter
			        .evaluate("con text TestMetaModel::ClassifierTest::SuperClass inv: TestMetaModel::ClassifierTest::SuperClass.allInstances()->reject(x|x.superName <> 'sClass4')->forAll(y|y.superName <> 'sClass4' and self.superName <> 'sClass4') ");

			Assert.assertEquals(result.size(), 1);
			Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());
			Assert.fail("Exception expected!");
		} catch (Exception e) {

			Assert.assertEquals("Error: 1:26 Syntax error near 'text'\r\nError: 1:26 Couldn't repair and continue parse near 'text'\r\n", e.getMessage());
		}
	}

	public void testQueryAndInvariantDistinction() throws Exception {
		try {
			long start = System.currentTimeMillis();

			List result = null;
			result = this.adapter.evaluate("context TestMetaModel::ClassifierTest::SuperClass inv: TestMetaModel::ClassifierTest::SuperClass.allInstances().size() ");
			Assert.assertEquals(result.size(), 1);
			Assert.fail("Exception expected!");
		} catch (Exception e) {
			Assert.assertEquals("Error: A constraint must evaluate to OclBoolean. Current body type is Integer\r\n", e.getMessage());
		}
	}

	/*
	 * TODO: :: instead of -> not property error-reported
	 * 
	 * public void testWrongAccessorOnAllInstances() throws Exception { try { long start = System.currentTimeMillis();
	 * 
	 * List result = null; result = adapter.evaluate("context OclVoid inv: TestMetaModel::ClassifierTest::SuperClass::allInstances() "); assertEquals(result.size(), 1);
	 * fail("Exception expected!"); } catch (Exception e) { assertEquals("Error: eval: Operation allInstances[] not found on object Set { OclType(OclModelElementType(SuperClass))
	 * }\r\n", e.getMessage()); } }
	 * 
	 */

	public void testWrongAccessorOnAllInstances1() throws Exception {
		try {
			long start = System.currentTimeMillis();

			List result = null;
			result = this.adapter.evaluate("context OclVoid inv: TestMetaModel::ClassifierTest::SuperClass->allInstances() ");
			Assert.assertEquals(result.size(), 1);
			Assert.fail("Exception expected!");
		} catch (Exception e) {
			Assert.assertEquals("Error: eval: Operation allInstances[] not found on object Set { OclType(SuperClass) }\r\n", e.getMessage());
		}
	}
	/*
	 * commented out because a void context does not need to return a boolean!
	 * 
	 * public void testWrongAccessorOnSize() throws Exception { try { long start = System.currentTimeMillis(); // . should be -> List result = null; result =
	 * adapter.evaluate("context OclVoid inv: TestMetaModel::ClassifierTest::SuperClass.allInstances().size() "); assertEquals(result.size(), 1); fail("Exception expected!"); }
	 * catch (Exception e) { assertEquals("Error: A constraint must evaluate to OclBoolean. Current body type is Integer\r\n", e.getMessage()); } }
	 */
}
