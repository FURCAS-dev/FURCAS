/**
 * Copyright (c) 2007 ikv++ technologies ag
 * All Rights Reserved
 */
package de.ikv.medini.qvt.testcases;

import java.io.FileNotFoundException;

import junit.framework.Assert;
import de.ikv.medini.qvt.test.QVTTestCase;

/**
 * Test key concept implementation
 * 
 * @author kiegeland
 * 
 */
public class SimpleKeyConceptTestCase extends QVTTestCase {

	/**
	 * Delete generated class in target, create same-named class in target, retransform, and assert to use the manually created class (instead of creating a new one)
	 * 
	 * @throws FileNotFoundException
	 */
	public void testExtension2() throws FileNotFoundException {
		this.adapter.evaluateQVT(this.fullPath("SimpleKeyConceptTest.qvt"), "SimpleKeyConceptTest", true, "forward");
		Object c1 = this.findByName("i1", true, this.META_UMLClass);
		this.findByName("i2", true, this.META_UMLClass);
		this.adapter.delete(c1);
		this.notFindByName("i1", true, this.META_UMLClass);

		// not to be used
		Object source_c1 = this.createModelElement(this.META_UMLClass);
		this.adapter.setValueForFeature(source_c1, this.META_UMLNamedElement_name, "i1");

		// to be used by key concept:
		Object created_c1 = this.createModelElementInTarget(this.META_UMLClass);
		this.adapter.setValueForFeature(created_c1, this.META_UMLNamedElement_name, "i1");

		// not to be used
		source_c1 = this.createModelElement(this.META_UMLClass);
		this.adapter.setValueForFeature(source_c1, this.META_UMLNamedElement_name, "i1");

		// not to be used
		source_c1 = this.createModelElement(this.META_UMLClass);
		this.adapter.setValueForFeature(source_c1, this.META_UMLNamedElement_name, "i1");

		this.findByName("i1", true, this.META_UMLClass);

		this.adapter.evaluateQVT(this.fullPath("SimpleKeyConceptTest.qvt"), "SimpleKeyConceptTest", true, "forward");
		c1 = this.findByName("i1", true, this.META_UMLClass);
		this.findByName("i2", true, this.META_UMLClass);

		// transformation must use created_c1 by key concept
		Assert.assertEquals(this.adapter.getIdentityObject(created_c1), this.adapter.getIdentityObject(c1));

	}

	public void testExtension() throws FileNotFoundException {
		this.checkTraces("SimpleKeyConceptTest.qvt", "SimpleKeyConceptTest", "forward", "backward", 2);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Object i1 = this.createModelElement(this.META_UMLInterface);
		this.adapter.setValueForFeature(i1, this.META_UMLNamedElement_name, "i1");
		Object i2 = this.createModelElement(this.META_UMLInterface);
		this.adapter.setValueForFeature(i2, this.META_UMLNamedElement_name, "i2");
	}

}
