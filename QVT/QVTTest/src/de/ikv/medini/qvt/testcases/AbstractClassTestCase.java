/**
 * Copyright (c) 2007 ikv++ technologies ag
 * All Rights Reserved
 */
package de.ikv.medini.qvt.testcases;

import java.io.FileNotFoundException;

import de.ikv.medini.qvt.test.QVTTestCase;

/**
 * This test case tests handling of element instantiation for abstract classes in conjunction with checkonly domains.
 * 
 * @author kiegeland
 * 
 */
public class AbstractClassTestCase extends QVTTestCase {

	private Object topPackage;

	private Object component1;

	private Object attribute1;

	private Object activity1;

	private Object attribute2;

	private Object collaboration1;

	private Object attribute3;

	public void testForwardForwardBackward() throws FileNotFoundException {
		this.adapter.evaluateQVT(this.fullPath("AbstraktClassTest.qvt"), "AbstraktClassTest", true, "target");
		// check comments in the qvt script to see tests on checkonly domains
		this.findByName("behavior1", true, this.META_UMLInterface);
		this.notFindByName("behavior1", true, this.META_UMLCollaboration);
		this.findByName("component1", true, this.META_UMLCollaboration);
		this.findByName("collaboration1FromCollaboration", true, this.META_UMLInterface);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		// topPackage
		this.topPackage = this.createModelElement(this.META_UMLPackage);
		this.adapter.setValueForFeature(this.topPackage, this.META_UMLNamedElement_name, "topPackage");

		// component1
		this.component1 = this.createModelElement(this.META_UMLComponent);
		this.adapter.setValueForFeature(this.component1, this.META_UMLNamedElement_name, "component1");
		this.adapter.setValueForFeature(this.component1, this.META_UMLElement_the_owner, this.topPackage);

		this.attribute1 = this.createModelElement(this.META_UMLProperty);
		this.adapter.setValueForFeature(this.attribute1, this.META_UMLNamedElement_name, "attribute1");
		this.adapter.setValueForFeature(this.attribute1, this.META_UMLElement_the_owner, this.component1);

		// activity1
		this.activity1 = this.createModelElement(this.META_UMLActivity);
		this.adapter.setValueForFeature(this.activity1, this.META_UMLNamedElement_name, "behavior1");
		this.adapter.setValueForFeature(this.activity1, this.META_UMLElement_the_owner, this.topPackage);

		this.attribute2 = this.createModelElement(this.META_UMLProperty);
		this.adapter.setValueForFeature(this.attribute2, this.META_UMLNamedElement_name, "attribute2");
		this.adapter.setValueForFeature(this.attribute2, this.META_UMLElement_the_owner, this.activity1);

		// collaboration1
		this.collaboration1 = this.createModelElement(this.META_UMLCollaboration);
		this.adapter.setValueForFeature(this.collaboration1, this.META_UMLNamedElement_name, "collaboration1");
		this.adapter.setValueForFeature(this.collaboration1, this.META_UMLElement_the_owner, this.topPackage);

		this.attribute3 = this.createModelElement(this.META_UMLProperty);
		this.adapter.setValueForFeature(this.attribute3, this.META_UMLNamedElement_name, "attribute3");
		this.adapter.setValueForFeature(this.attribute3, this.META_UMLElement_the_owner, this.collaboration1);

	}

}
