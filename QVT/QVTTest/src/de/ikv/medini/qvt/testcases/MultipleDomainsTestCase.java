/**
 * Copyright (c) 2007 ikv++ technologies ag
 * All Rights Reserved
 */
package de.ikv.medini.qvt.testcases;

import java.io.FileNotFoundException;

import de.ikv.medini.qvt.test.QVTTestCase;

/**
 * Tests whether a top level relation with two source domains correctly work, and if at backward transformation, two elements for those two domains are correctly generated
 * 
 * @author kiegeland
 * 
 */
public class MultipleDomainsTestCase extends QVTTestCase {

	private String qvtFile = "MultipleDomains.qvt";

	private Object DummyImpl;

	private Object Dummy;

	private Object Dummy2Impl;

	private Object Dummy2;

	/**
	 * General functionality test
	 * 
	 * @throws FileNotFoundException
	 */
	public void testTraces1() throws FileNotFoundException {
		this.checkTraces(this.qvtFile, "MultipleDomains", "target", "source", 3);

		this.findByName("IDummy", true);
		this.findByName("IDummy2", true);
		this.findByName("IDummy2Impl", true);

		Object IDummy4 = this.createModelElementInTarget(this.META_UMLInterface);
		this.adapter.setValueForFeature(IDummy4, this.META_UMLNamedElement_name, "IDummy4");

		this.adapter.evaluateQVTBackward(this.fullPath(this.qvtFile), "MultipleDomains", true, "source");

		this.findByName("Dummy4", false);
		this.findByName("Dummy4Impl", false);

		this.checkTraces(this.qvtFile, "MultipleDomains", "target", "source", 4);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		// will result into interface IDummy1
		this.DummyImpl = this.createModelElement(this.META_UMLClass);
		this.adapter.setValueForFeature(this.DummyImpl, this.META_UMLNamedElement_name, "DummyImpl");
		this.Dummy = this.createModelElement(this.META_UMLClass);
		this.adapter.setValueForFeature(this.Dummy, this.META_UMLNamedElement_name, "Dummy");

		// will result into interface IDummy2 and interface IDummy2Impl
		this.Dummy2Impl = this.createModelElement(this.META_UMLClass);
		this.adapter.setValueForFeature(this.Dummy2Impl, this.META_UMLNamedElement_name, "Dummy2Impl");
		this.Dummy2 = this.createModelElement(this.META_UMLClass);
		this.adapter.setValueForFeature(this.Dummy2, this.META_UMLNamedElement_name, "Dummy2");
		this.Dummy2 = this.createModelElement(this.META_UMLClass);
		this.adapter.setValueForFeature(this.Dummy2, this.META_UMLNamedElement_name, "Dummy2ImplImpl");

		// will not result into an interface
		this.Dummy2Impl = this.createModelElement(this.META_UMLClass);
		this.adapter.setValueForFeature(this.Dummy2Impl, this.META_UMLNamedElement_name, "Dummy3ImplX");
		this.Dummy2 = this.createModelElement(this.META_UMLClass);
		this.adapter.setValueForFeature(this.Dummy2, this.META_UMLNamedElement_name, "Dummy3");

	}

}
