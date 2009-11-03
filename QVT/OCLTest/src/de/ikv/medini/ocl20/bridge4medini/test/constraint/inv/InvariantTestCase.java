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

package de.ikv.medini.ocl20.bridge4medini.test.constraint.inv;

import java.util.List;

import testmetamodel.classifiertest.SubClass;
import testmetamodel.classifiertest.SuperClass;

import junit.framework.Assert;

import de.ikv.medini.ocl20.bridge4medini.test.OclInterpreterTestCase;

public class InvariantTestCase extends OclInterpreterTestCase {

	Object/* SuperClass */superClass1;

	Object/* SuperClass */superClass2;

	Object/* SuperClass */[] superClasses;

	Object/* SubClass */subClass1;

	Object/* SubClass */subClass2;

	Object/* SubClass */subClass3;

	Object/* SuperClass */[] all;

	public void testInvariantExecutionOnAllObjectsOfContextKind() throws Exception {
		// TODO string is parsed even iv incorrect !! List result = adapter.evaluate("context
		// TestMetaModel::ClassifierTest::SubClass inv: self.subName != 'subClass4' ");
		// List result = adapter.evaluate("context TestMetaModel::ClassifierTest::SubClass inv: self.subName <> 'subClass4' ");
		List result = this.adapter.evaluate("context TestMetaModel::ClassifierTest::SuperClass inv: self.superName <> 'sClass4' ");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate("context OclVoid inv: TestMetaModel::ClassifierTest::SuperClass.allInstances().superName");

		// result = adapter.evaluate("context TestMetaModel::ClassifierTest::SubClass inv: self.subName <> 'subClass3' ");

		// TODO uncomment result = adapter.evaluate("context TestMetaModel::ClassifierTest::SubClass inv: not self.subName.oclIsUndefined() ");
		// assertEquals(result.size(), 1);
		// assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		// TODO remove
		result = this.adapter.evaluate("context OclVoid inv: TestMetaModel::ClassifierTest::SuperClass.allInstances()->select(x | true)->forAll(x | x.subClass->size() = 0 ) ");

	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		this.superClass1 = this.adapter.createModelElement(this.META_SuperClass);
		((SuperClass)superClass1).setSuperName("superClass1");
		this.superClass2 = this.adapter.createModelElement(this.META_SuperClass);
		((SuperClass)superClass2).setSuperName("superClass2");
		this.superClasses = new Object[] { this.superClass1, this.superClass2 };

		this.subClass1 = this.adapter.createModelElement(this.META_SubClass);
		((SubClass)subClass1).setSubName("subClass1");
		((SuperClass)subClass1).setSuperName("superClass1");
		this.subClass2 = this.adapter.createModelElement(this.META_SubClass);
		((SubClass)subClass2).setSubName("subClass2");
		((SuperClass)subClass2).setSuperName("superClass2");
		this.subClass3 = this.adapter.createModelElement(this.META_SubClass);

		((SubClass)subClass3).setSubName("subClass3");
		((SuperClass)subClass3).setSuperName("superClass3");
		this.all = new Object[] { this.subClass1, this.subClass2, this.subClass3, this.superClass1, this.superClass2 };
	}

	@Override
	protected void tearDown() throws Exception {
		this.adapter.delete(this.superClass2);
		this.adapter.delete(this.superClass1);
		this.adapter.delete(this.subClass1);
		this.adapter.delete(this.subClass2);
		this.adapter.delete(this.subClass3);

		super.tearDown();
	}

}
