/**
 * Copyright (c) 2007 ikv++ technologies ag
 * All Rights Reserved
 */
package de.ikv.medini.qvt.testcases;

import java.io.FileNotFoundException;

import de.ikv.medini.qvt.test.QVTTestCase;

/**
 * This test case tests fix for Bugzilla Bug 1812 and Bugzilla Bug 1849
 * 
 * @author kiegeland
 * 
 */
public class ImportTestCase extends QVTTestCase {

	private Object topPackage;

	private Object useCase1;

	private Object useCase2;

	/**
	 * Tests transformation in one QVT file
	 * 
	 * @throws FileNotFoundException
	 */
	public void testTraces2() throws FileNotFoundException {
		this.checkTraces("usecase2activity.qvt", "usecase2activity", "forward", "backward", 3);
	}

	/**
	 * Tests call to a non-top relation of an imported QVT file
	 * 
	 * @throws FileNotFoundException
	 */
	public void testTraces1() throws FileNotFoundException {
		this.checkTraces("usecase2activity_frontend.qvt", "usecase2activity_frontend", "forward", "backward", 3);
	}

	/**
	 * Tests that no top relations are executed from imported QVT files
	 * 
	 * @throws FileNotFoundException
	 */
	public void testTraces3() throws FileNotFoundException {
		this.checkTraces("usecase2activity_proxy.qvt", "usecase2activity_proxy", "forward", "backward", 0);
	}

	/**
	 * Tests execution of a transformation in an imported QVT file
	 * 
	 * @throws FileNotFoundException
	 */
	// public void testTraces4() throws FileNotFoundException {
	// // comment out this test method since it is no required feature and not works either
	// checkTraces("usecase2activity_proxy.qvt", "usecase2activity", "forward", "backward", 3);
	// }
	/**
	 * Tests whether a concat-operation is properly inversed for a backward transformation
	 * 
	 * @throws FileNotFoundException
	 */
	public void testStringMatching() throws FileNotFoundException {
		this.adapter.evaluateQVT(this.fullPath("usecase2activity.qvt"), "usecase2activity", true, "forward");

		this.adapter.setValueForFeature(this.findByName("useCase1Activity", true), this.META_UMLNamedElement_name, "useCaseXActivity");

		this.adapter.evaluateQVTBackward(this.fullPath("usecase2activity.qvt"), "usecase2activity", true, "backward");

		this.findByName("useCaseX", false);

	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		this.topPackage = this.createModelElement(this.META_UMLPackage);
		this.adapter.setValueForFeature(this.topPackage, this.META_UMLNamedElement_name, "topLevelPackage1");

		this.useCase1 = this.createModelElement(this.META_UMLUseCase);
		this.adapter.setValueForFeature(this.useCase1, this.META_UMLNamedElement_name, "useCase1");
		this.adapter.setValueForFeature(this.useCase1, this.META_UMLElement_the_owner, this.topPackage);

		this.useCase2 = this.createModelElement(this.META_UMLUseCase);
		this.adapter.setValueForFeature(this.useCase2, this.META_UMLNamedElement_name, "useCase2");
		this.adapter.setValueForFeature(this.useCase2, this.META_UMLElement_the_owner, this.topPackage);
	}

}
