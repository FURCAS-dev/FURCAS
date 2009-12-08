/**
 * Copyright (c) 2007 ikv++ technologies ag
 * All Rights Reserved
 */
package de.ikv.medini.qvt.testcases;

import java.io.FileNotFoundException;

import de.ikv.medini.qvt.test.QVTTestCase;

/**
 * Tests that if a target domain variable is not bound in the when-clauses, it is created in the target domain.
 * 
 * @author kiegeland
 * 
 */
public class BindOrCreateTestCase extends QVTTestCase {

	private Object topPackage;

	private Object component1;

	private Object attribute1;

	private Object activity1;

	private Object attribute2;

	private Object collaboration1;

	private Object attribute3;

	public void testForwardForwardBackward() throws FileNotFoundException {
		this.adapter.evaluateQVT(this.fullPath("usecase2activity_bindOrCreate.qvt"), "usecase2activity", true, "forward");
		this.findByName("Collaboration", true, this.META_UMLCollaboration); // tests that the variable is created and this name is assigned
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		// topPackage
		this.topPackage = this.createModelElement(this.META_UMLPackage);
		this.adapter.setValueForFeature(this.topPackage, this.META_UMLNamedElement_name, "topPackage");

	}

}
