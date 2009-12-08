/**
 * Copyright (c) 2007 ikv++ technologies ag
 * All Rights Reserved
 */
package de.ikv.medini.qvt.testcases;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import junit.framework.Assert;

import de.ikv.medini.ocl.test.util.Utilities;
import de.ikv.medini.qvt.test.QVTTestCase;

/**
 * Tests whether allInstances() collects data of multiple models (here: of the source and target model)
 * 
 * @author kiegeland
 * 
 */
public class OclAllInstancesTestCase extends QVTTestCase {

	public void test1() throws FileNotFoundException {
		Set set = new HashSet();
		set.add("topPackage1");
		set.add("topPackage2");
		set.add("useCase1");
		set.add("useCase2");
		Collection actual = (Collection) this.adapter.evaluate("EUML::Generic::Kernel::UMLNamedElement.allInstances()->collect(x | x.name)").get(0);
		Assert.assertTrue(set.size() + "!=" + actual.size(), Utilities.areCollectionsEqual(set, actual));
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		Object topPackage1 = this.createModelElement(this.META_UMLPackage);
		this.adapter.setValueForFeature(topPackage1, this.META_UMLNamedElement_name, "topPackage1");

		Object useCase1 = this.createModelElement(this.META_UMLUseCase);
		this.adapter.setValueForFeature(useCase1, this.META_UMLNamedElement_name, "useCase1");
		this.adapter.setValueForFeature(useCase1, this.META_UMLElement_the_owner, topPackage1);

		Object topPackage2 = this.createModelElement(this.META_UMLPackage);
		this.adapter.setValueForFeature(topPackage2, this.META_UMLNamedElement_name, "topPackage2");

		Object useCase2 = this.createModelElement(this.META_UMLUseCase);
		this.adapter.setValueForFeature(useCase2, this.META_UMLNamedElement_name, "useCase2");
		this.adapter.setValueForFeature(useCase2, this.META_UMLElement_the_owner, topPackage2);
	}

}
