/**
 * Copyright (c) 2007 ikv++ technologies ag
 * All Rights Reserved
 */
package de.ikv.medini.qvt.testcases;

import java.io.FileNotFoundException;

import de.ikv.medini.qvt.test.QVTTestAdapter;
import de.ikv.medini.qvt.test.QVTTestCase;

/**
 * Tests whether a top level relation with two source domains correctly work while having two source models and one target model, and if at backward transformation, two elements
 * for those two domains are correctly generated
 * 
 * @author kiegeland
 * 
 */
public class MultipleDomainsAndMultipleSourceModelsTestCase extends QVTTestCase {

	private String qvtFile = "MultipleDomains.qvt";

	private Object Dummy1Impl;

	private Object Dummy1;

	private Object Dummy2Impl;

	private Object Dummy2;

	private Object Dummy5Impl;

	private Object Dummy5;

	/**
	 * General functionality test
	 * 
	 * @throws FileNotFoundException
	 */
	public void testTraces1() throws FileNotFoundException {
		this.checkTraces(this.qvtFile, "MultipleDomains", "target", "source", 4);

		this.findByName("IDummy1", true);
		this.findByName("IDummy5", true);
		this.findByName("IDummy2", true);
		this.findByName("IDummy2Impl", true);

		Object IDummy4 = this.createModelElementInTarget(this.META_UMLInterface);
		this.adapter.setValueForFeature(IDummy4, this.META_UMLNamedElement_name, "IDummy4");

		this.adapter.evaluateQVTBackward(this.fullPath(this.qvtFile), "MultipleDomains", true, "source");

		this.findByName("Dummy4", false);
		this.findByName("Dummy4Impl", false);

		this.checkTraces(this.qvtFile, "MultipleDomains", "target", "source", 5);
	}

	@Override
	protected void setUp() throws Exception {

		System.setProperty(QVTTestAdapter.QVTTESTADAPTER_TWOSOURCEMODELS, "true");
		super.setUp();

		// will result into interface IDummy1
		this.Dummy1Impl = this.createModelElementInModel(this.META_UMLClass, 1);
		this.adapter.setValueForFeature(this.Dummy1Impl, this.META_UMLNamedElement_name, "Dummy1Impl");
		this.Dummy1 = this.createModelElementInModel(this.META_UMLClass, 0);
		this.adapter.setValueForFeature(this.Dummy1, this.META_UMLNamedElement_name, "Dummy1");

		// will result into interface IDummy5
		this.Dummy5Impl = this.createModelElementInModel(this.META_UMLClass, 1);
		this.adapter.setValueForFeature(this.Dummy5Impl, this.META_UMLNamedElement_name, "Dummy5Impl");
		this.Dummy5 = this.createModelElementInModel(this.META_UMLClass, 0);
		this.adapter.setValueForFeature(this.Dummy5, this.META_UMLNamedElement_name, "Dummy5");

		// will result into interface IDummy2 and interface IDummy2Impl
		this.Dummy2Impl = this.createModelElementInModel(this.META_UMLClass, 1);
		this.adapter.setValueForFeature(this.Dummy2Impl, this.META_UMLNamedElement_name, "Dummy2Impl");
		this.Dummy2 = this.createModelElementInModel(this.META_UMLClass, 0);
		this.adapter.setValueForFeature(this.Dummy2, this.META_UMLNamedElement_name, "Dummy2");
		this.Dummy2 = this.createModelElementInModel(this.META_UMLClass, 1);
		this.adapter.setValueForFeature(this.Dummy2, this.META_UMLNamedElement_name, "Dummy2ImplImpl");

		// will not result into an interface
		this.Dummy2Impl = this.createModelElementInModel(this.META_UMLClass, 1);
		this.adapter.setValueForFeature(this.Dummy2Impl, this.META_UMLNamedElement_name, "Dummy3ImplX");
		this.Dummy2 = this.createModelElementInModel(this.META_UMLClass, 0);
		this.adapter.setValueForFeature(this.Dummy2, this.META_UMLNamedElement_name, "Dummy3");

	}

}
