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

package de.ikv.medini.ocl20.bridge4medini.test.lib;

import java.util.Collection;
import java.util.List;
import java.util.Vector;

import junit.framework.Assert;

import de.ikv.medini.ocl20.bridge4medini.test.OclInterpreterTestCase;

public class PredefinedPropertiesOnAllObjectsTestCase extends OclInterpreterTestCase {

	// not supported oclInState (s : OclState) : Boolean
	// not supported oclIsNew () : Boolean

	public void testOclIsTypeOf() throws Exception {
		// for primitive types
		List result = this.adapter.evaluate("1.oclIsTypeOf(Integer) ");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate(" 1.oclIsTypeOf(Real) ");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate(" 1.1.oclIsTypeOf(Real) ");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate(" 1.oclIsTypeOf(String) ");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate(" 'test'.oclIsTypeOf(String) ");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate(" 'test'.oclIsTypeOf(Integer) ");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate(" true.oclIsTypeOf(Boolean) ");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate(" true.oclIsTypeOf(Integer) ");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		// for collections
	}

	public void testOclIsKindOf() throws Exception {
		// for primitive types
		List result = this.adapter.evaluate(" 1.oclIsKindOf(Integer) ");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate(" 1.oclIsKindOf(Real) ");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate(" 1.1.oclIsKindOf(Real) ");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate(" 1.oclIsKindOf(String) ");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate(" 'test'.oclIsKindOf(String) ");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate(" 'test'.oclIsKindOf(Integer) ");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate(" true.oclIsKindOf(Boolean) ");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate(" true.oclIsKindOf(Integer) ");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		// for collections

	}

	public void testOclAsType() throws Exception {
		// for primitive types
		List result = this.adapter.evaluate(" 1.oclAsType(Integer).oclIsTypeOf(Real) ");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(false, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate(" 1.oclAsType(Integer).oclIsTypeOf(Integer) ");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

		this.adapter.evaluate(" 1.oclAsType(Real).oclIsTypeOf(Real) ");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

		result = this.adapter.evaluate(" 1.oclAsType(Real).oclIsTypeOf(Integer) ");
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(true, ((Boolean) result.get(0)).booleanValue());

		// // for collections
		// result = adapter.evaluate(" Set{ 1 , 2 , 3 }.oclAsType(Integer).oclIsTypeOf(Real) ");
		// assertEquals(result.size(), 1);
		// assertEquals(true,((Boolean)result.get(0)).booleanValue());

		// allInstances()
	}

	// allInstances

	public void testAllInstances() throws Exception {
		// for primitive types
		List result = this.adapter.evaluate(" TestMetaModel::ClassifierTest::SubClass.allInstances() ");
		Assert.assertEquals(result.size(), 1);
		Collection result1 = (Collection) result.get(0);
		Vector resultExpected = new Vector();
		Assert.assertEquals(0, result1.size());

		// List result = this.mediniOclProcessorAmedato.evaluate(" AmedatoModeling::Generic::Kernel::UMLElement.allInstances()");
		// assertEquals(result.size(), 1);
		// Collection result1 = (Collection)result.get(0);
		// Vector resultExpected = new Vector();
		// assertEquals(1,result1.size());

		result = this.adapter.evaluate(" TestMetaModel::ClassifierTest::SuperClass.allInstances() ");
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		resultExpected = new Vector();
		Assert.assertEquals(0, result1.size());

		// assertTrue(result1.containsAll(new Vector(resultExpected)));

		Object superClass1 = this.adapter.createModelElement(this.META_SuperClass);
		this.adapter.setValueForFeature(superClass1, this.META_SuperClass_superName, "superClass1");

		Object superClass2 = this.adapter.createModelElement(this.META_SuperClass);
		this.adapter.setValueForFeature(superClass2, this.META_SuperClass_superName, "superClass2");
		Object[] superClasses = new Object[] { superClass1, superClass2 };

		Object subClass1 = this.adapter.createModelElement(this.META_SubClass);
		this.adapter.setValueForFeature(subClass1, this.META_SubClass_subName, "subClass1");
		this.adapter.setValueForFeature(subClass1, this.META_SuperClass_superName, "superClass1");

		Object subClass2 = this.adapter.createModelElement(this.META_SubClass);
		this.adapter.setValueForFeature(subClass2, this.META_SubClass_subName, "subClass2");
		this.adapter.setValueForFeature(subClass2, this.META_SuperClass_superName, "superClass2");

		Object subClass3 = this.adapter.createModelElement(this.META_SubClass);
		this.adapter.setValueForFeature(subClass3, this.META_SubClass_subName, "subClass3");
		this.adapter.setValueForFeature(subClass3, this.META_SuperClass_superName, "superClass3");

		Object[] all = new Object[] { subClass1, subClass2, subClass3, superClass1, superClass2 };

		result = this.adapter.evaluate(" TestMetaModel::ClassifierTest::SuperClass.allInstances() ");
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		resultExpected = new Vector();
		Assert.assertEquals(all.length, result1.size());
		// TODO TODOMWA correct unit test and complete !!!
		// result = adapter.evaluate(" TestMetaModel::ClassifierTest::SuperClass.allInstances() ");
		// assertEquals(result.size(), 1);
		// result1 = (Collection)result.get(0);
		// resultExpected = new Vector();
		// assertEquals(superClasses.length, result1.size());

		this.adapter.delete(superClass2);
		this.adapter.delete(superClass1);
		this.adapter.delete(subClass1);
		this.adapter.delete(subClass2);
		this.adapter.delete(subClass3);

		// TODO TODOMWA do not test delete !!
		result = this.adapter.evaluate(" TestMetaModel::ClassifierTest::SubClass.allInstances() ");
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		resultExpected = new Vector();
		Assert.assertEquals(0, result1.size());

		result = this.adapter.evaluate(" TestMetaModel::ClassifierTest::SuperClass.allInstances() ");
		Assert.assertEquals(result.size(), 1);
		result1 = (Collection) result.get(0);
		resultExpected = new Vector();
		Assert.assertEquals(0, result1.size());

	}

}
