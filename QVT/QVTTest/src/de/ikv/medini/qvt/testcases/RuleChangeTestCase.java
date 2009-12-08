/**
 * Copyright (c) 2007 ikv++ technologies ag
 * All Rights Reserved
 */
package de.ikv.medini.qvt.testcases;

import java.io.FileNotFoundException;

import junit.framework.Assert;

import de.ikv.medini.qvt.test.QVTTestCase;

/**
 * Test case for Bugzilla Bug 1805
 * 
 * @author kiegeland
 * 
 */
public class RuleChangeTestCase extends QVTTestCase {

	private Object topPackage;

	private Object useCase1;

	private Object useCase2;

	public void testExtension() throws FileNotFoundException {
		this.adapter.evaluateQVT(this.fullPath("usecase2activity.qvt"), "usecase2activity", true, "forward");

		this.adapter.evaluateQVT(this.fullPath("usecase2activity_extended.qvt"), "usecase2activity", true, "forward");

		Object useCase1Activity = this.findByName("useCase1Activity", true);
		Assert.assertEquals("useCase1alias", (String) this.adapter.getValueForFeature(useCase1Activity, this.META_UMLNamedElement_alias));

	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		this.topPackage = this.createModelElement(this.META_UMLPackage);
		this.adapter.setValueForFeature(this.topPackage, this.META_UMLNamedElement_name, "topLevelPackage1");

		this.useCase1 = this.createModelElement(this.META_UMLUseCase);
		this.adapter.setValueForFeature(this.useCase1, this.META_UMLNamedElement_name, "useCase1");
		this.adapter.setValueForFeature(this.useCase1, this.META_UMLElement_the_owner, this.topPackage);
		this.adapter.setValueForFeature(this.useCase1, this.META_UMLNamedElement_alias, "useCase1alias");

		this.adapter.setValueForFeature(this.useCase1, this.META_UMLElement_the_owner, this.topPackage);
		this.useCase2 = this.createModelElement(this.META_UMLUseCase);
		this.adapter.setValueForFeature(this.useCase2, this.META_UMLNamedElement_name, "useCase2");
		this.adapter.setValueForFeature(this.useCase2, this.META_UMLElement_the_owner, this.topPackage);
		this.adapter.setValueForFeature(this.useCase2, this.META_UMLNamedElement_alias, "useCase2alias");
	}

}
