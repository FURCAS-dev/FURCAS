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

package de.ikv.medini.ocl20.bridge4medini.test.performance;

import java.util.List;

import junit.framework.Assert;

import de.ikv.medini.ocl20.bridge4medini.test.OclInterpreterTestCase;

public class PerformanceTest extends OclInterpreterTestCase {

	// int superClassesCount = 5;
	// int subClassesCount = 5;
	// int superClassesCount = 500;
	// int subClassesCount = 500;
	int superClassesCount = 100;

	int subClassesCount = 100;

	Object/* SuperClass */[] superClasses;

	Object/* SuperClass */[] all;

	long init = 0;

	public void testInvariantExecutionOnAllObjectsOfContextKind() throws Exception {
		// TODO string is parsed even iv incorrect !! List result = adapter.evaluate("context
		// TestMetaModel::ClassifierTest::SubClass inv: self.subName != 'subClass4' ");
		// List result = adapter.evaluate("context TestMetaModel::ClassifierTest::SubClass inv: self.subName <> 'subClass4' ");
		long start = System.currentTimeMillis();
		// List result = adapter.evaluate("context TestMetaModel::ClassifierTest::SuperClass inv: self.superName <> 'sClass4' or self.superName = 'sClass4' ");
		// junit.framework.AssertionFailedError: init = 4063; run = 41265; perf = 1.0
		// junit.framework.AssertionFailedError: init = 3828; run = 5516; perf = 1.0
		// junit.framework.AssertionFailedError: init = 3812; run = 4985; perf = 1.0

		List result = null;
		// for (int i = 0; i < 60; i++) {
		result = this.adapter
		        .evaluate("context TestMetaModel::ClassifierTest::SuperClass inv: TestMetaModel::ClassifierTest::SuperClass.allInstances()->reject(x|x.superName <> 'sClass4')->forAll(y|y.superName <> 'sClass4' and self.superName <> 'sClass4') ");
		// }

		// junit.framework.AssertionFailedError: init = 829; run = 66837; perf = 1.0
		// junit.framework.AssertionFailedError: init = 859; run = 2594; perf = 1.0
		// junit.framework.AssertionFailedError: init = 892; run = 14837; perf = 1.0

		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());
		long stop = System.currentTimeMillis() - start;

		// result = adapter.evaluate("context TestMetaModel::ClassifierTest::SubClass inv: self.subName <> 'subClass3' ");
		// result = adapter.evaluate("context TestMetaModel::ClassifierTest::SubClass inv: !self.subName.oclIsUndefined() ");
		// assertEquals(result.size(), 1);
		// assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		// fail("init = " + init + "; run = " + stop + "; perf = " + ((double)((double)stop) / ((double)stop)));

	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		long start = System.currentTimeMillis();
		this.superClasses = new Object/* SuperClass */[this.superClassesCount];
		for (int i = 0; i < this.superClasses.length; i++) {
			Object/* SuperClass */superClass1 = this.adapter.createModelElement(this.META_SuperClass);
			this.adapter.setValueForFeature(superClass1, this.META_SuperClass_superName, "superClass1");
			this.superClasses[i] = superClass1;
		}
		this.init = System.currentTimeMillis() - start;

		// superClass2 = SuperClassHelper.narrow(superClassClass.ref_create_instance(new Any[0]));
		// // superClass1.set_super_name("superClass2");
		//
		// subClass1 = SubClassHelper.narrow(subClassClass.ref_create_instance(new Any[0]));
		// // subClass1.set_sub_name("subClass1");
		// // subClass1.set_super_name("superClass1");
		// subClass2 = SubClassHelper.narrow(subClassClass.ref_create_instance(new Any[0]));
		// // subClass2.set_sub_name("subClass2");
		// // subClass2.set_super_name("superClass2");
		// subClass3 = SubClassHelper.narrow(subClassClass.ref_create_instance(new Any[0]));
		// // subClass3.set_sub_name("subClass3");
		// // subClass3.set_super_name("superClass3");
		// all = new SuperClass[] { subClass1, subClass2, subClass3, superClass1, superClass2 };
	}

	@Override
	protected void tearDown() throws Exception {
		// superClass2.ref_delete();
		// superClass1.ref_delete();
		//
		// subClass1.ref_delete();
		// subClass2.ref_delete();
		// subClass3.ref_delete();
		super.tearDown();
	}

}
