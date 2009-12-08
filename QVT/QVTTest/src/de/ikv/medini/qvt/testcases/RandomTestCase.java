/**
 * Copyright (c) 2007 ikv++ technologies ag
 * All Rights Reserved
 */
package de.ikv.medini.qvt.testcases;

import java.io.FileNotFoundException;
import java.util.Collection;

import junit.framework.Assert;

import de.ikv.medini.qvt.test.QVTTestAdapter;
import de.ikv.medini.qvt.test.QVTTestCase;

/**
 * Test random model generation.
 * 
 * Also tests parsing the generated model.
 * 
 * @author kiegeland
 * 
 */
public class RandomTestCase extends QVTTestCase {

	/**
	 * Three elements, two properties in one class, shall be randomly created.
	 * 
	 * @throws FileNotFoundException
	 */
	public void testRandomElementCreation() throws FileNotFoundException {
		if (!this.adapter.supportsRandomMode()) {
			return;
		}
		int randomElementCreationsLimit = 3;
		this.adapter.setQvtProperty(QVTTestCase.PROP_RANDOMIZE, "" + randomElementCreationsLimit);
		// adapter.setQvtProperty(PROP_INPLACE, "true");
		this.adapter.evaluateQVT(this.fullPath("RandomTest.qvt"), "RandomTest", true, "forward");

		Collection classes = this.findElementsByType(true, this.META_UMLClass);
		Collection properties = this.findElementsByType(true, this.META_UMLProperty);

		/*
		 * Only one class can be created by traces , since the relation GenerateClass is called by other relations.
		 */
		Assert.assertEquals(1, classes.size());

		/*
		 * Thus, to match 3 relations, 2 properties will be created.
		 */
		Assert.assertEquals(2, properties.size());

		/*
		 * Now parse the model. Only the original package shall remain.
		 */
		this.adapter.setQvtProperty(QVTTestCase.PROP_RANDOMIZE, "" + 0);
		this.adapter.setQvtProperty(QVTTestCase.PROP_PARSE, "true");
		this.adapter.evaluateQVT(this.fullPath("RandomTest.qvt"), "RandomTest", true, "backward");
		Collection all = this.findElementsByType(true, this.META_UMLElement);
		Assert.assertEquals(1, all.size());

	}

	/**
	 * Four elements, one property and two operations in one class, shall be randomly created.
	 * 
	 * @throws FileNotFoundException
	 */
	public void testRandomElementCreation2() throws FileNotFoundException {
		if (!this.adapter.supportsRandomMode()) {
			return;
		}
		int randomElementCreationsLimit = 4;
		this.adapter.setQvtProperty(QVTTestCase.PROP_RANDOMIZE, "" + randomElementCreationsLimit);
		// adapter.setQvtProperty(PROP_INPLACE, "true");
		this.adapter.evaluateQVT(this.fullPath("RandomTest2.qvt"), "RandomTest2", true, "forward");

		Collection classes = this.findElementsByType(true, this.META_UMLClass);
		Collection properties = this.findElementsByType(true, this.META_UMLProperty);
		Collection operations = this.findElementsByType(true, this.META_UMLOperation);

		/*
		 * Only one class can be created by traces , since bound by key concept.
		 */
		Assert.assertEquals(1, classes.size());

		/*
		 * Thus, to match 4 relations, first one property will be created..
		 */
		Assert.assertEquals(1, properties.size());

		/*
		 * .. and then 2 operations
		 */
		Assert.assertEquals(2, operations.size());

		/*
		 * Now parse the model. Only the original package shall remain.
		 */
		this.adapter.setQvtProperty(QVTTestCase.PROP_RANDOMIZE, "" + 0);
		this.adapter.setQvtProperty(QVTTestCase.PROP_PARSE, "true");
		this.adapter.evaluateQVT(this.fullPath("RandomTest2.qvt"), "RandomTest2", true, "backward");
		Collection all = this.findElementsByType(true, this.META_UMLElement);
		Assert.assertEquals(1, all.size());
	}

	@Override
	protected void setUp() throws Exception {
		System.setProperty(QVTTestAdapter.QVTTESTADAPTER_INPLACE, "true");
		super.setUp();
		if (!this.adapter.supportsRandomMode()) {
			return;
		}
		Object p = this.createModelElement(this.META_UMLPackage);
		this.adapter.setValueForFeature(p, this.META_UMLNamedElement_name, "topLevelPackage");
	}

}
