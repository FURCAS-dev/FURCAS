/**
 * Copyright (c) 2007 ikv++ technologies ag
 * All Rights Reserved
 */
package de.ikv.medini.qvt.testcases;

import java.io.FileNotFoundException;

import de.ikv.medini.qvt.test.QVTTestCase;

/**
 * This test case tests fix for Bugzilla Bug 1825
 * 
 * @author kiegeland
 * 
 */
public class PrimitiveDomainTestCase extends QVTTestCase {

	Object topPackage;

	Object component1;

	public void testForwardForwardBackward() throws FileNotFoundException {
		this.checkTraces("PrimitiveDomainTestCase.qvt", "PrimitiveDomainTestCase", "forward", "backward", 3);
	}

	/**
	 * Renaming one_component1 is not propagated to source model, implementation dependent!
	 * 
	 * @throws FileNotFoundException
	 */
	public void testRename1() throws FileNotFoundException {
		this.adapter.evaluateQVT(this.fullPath("PrimitiveDomainTestCase.qvt"), "PrimitiveDomainTestCase", true, "forward");

		this.adapter.setValueForFeature(this.findByName("one_component1", true), this.META_UMLNamedElement_name, "one_component2");

		this.adapter.evaluateQVTBackward(this.fullPath("PrimitiveDomainTestCase.qvt"), "PrimitiveDomainTestCase", true, "backward");

		this.findByName("component1", false);
	}

	/**
	 * Renaming two_component1 is propagated to source model, implementation dependent!
	 * 
	 * @throws FileNotFoundException
	 */
	public void testRename2() throws FileNotFoundException {
		this.adapter.evaluateQVT(this.fullPath("PrimitiveDomainTestCase.qvt"), "PrimitiveDomainTestCase", true, "forward");

		this.adapter.setValueForFeature(this.findByName("two_component1", true), this.META_UMLNamedElement_name, "two_component2");

		this.adapter.evaluateQVTBackward(this.fullPath("PrimitiveDomainTestCase.qvt"), "PrimitiveDomainTestCase", true, "backward");

		this.findByName("component2", false);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		this.topPackage = this.createModelElement(this.META_UMLPackage);
		this.adapter.setValueForFeature(this.topPackage, this.META_UMLNamedElement_name, "topPackage");

		this.component1 = this.createModelElement(this.META_UMLComponent);
		this.adapter.setValueForFeature(this.component1, this.META_UMLNamedElement_name, "component1");
		this.adapter.setValueForFeature(this.component1, this.META_UMLElement_the_owner, this.topPackage);

	}

}
