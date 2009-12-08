/**
 * Copyright (c) 2007 ikv++ technologies ag
 * All Rights Reserved
 */
package de.ikv.medini.qvt.testcases;

import java.io.FileNotFoundException;

import junit.framework.Assert;

import de.ikv.medini.qvt.test.QVTTestCase;

/**
 * This test case tests different delete-model-element situations
 * 
 * @author kiegeland
 * 
 */
public class DeleteTestCase extends QVTTestCase {

	private Object topLevelPackage1;

	private Object useCase1;

	private Object useCase2;

	private String qvtFile = "usecase2activity_delete.qvt";

	/**
	 * General functionality test
	 * 
	 * @throws FileNotFoundException
	 */
	public void testTraces1() throws FileNotFoundException {
		this.checkTraces(this.qvtFile, "usecase2activity", "forward", "backward", 3);
	}

	/**
	 * Tests on deleting source element not appearing in a trace binding but in a trace domain argument
	 * 
	 * -One forward transformation
	 * 
	 * -Delete topLevelPackage1 source element
	 * 
	 * -Next forward transformation
	 * 
	 * -Corresponding target element must be deleted
	 * 
	 * @throws FileNotFoundException
	 */
	public void testTraces2() throws FileNotFoundException {

		Assert.assertEquals(this.adapter.getIdentityObject(this.findByName("topLevelPackage1", false)), this.adapter.getIdentityObject(this.topLevelPackage1));

		this.adapter.evaluateQVT(this.fullPath(this.qvtFile), "usecase2activity", true, "forward");

		Object col1 = this.findByName("Col1", true);

		Object useCase1Activity = this.findByName("useCase1Activity", true);
		Object useCase2Activity = this.findByName("useCase2Activity", true);

		// List list=adapter.evaluate("context EUML::Generic::Activities::UMLActivity inv:
		// self.oclIsKindOf(EUML::Generic::Activities::UMLActivity)", useCase1Activity);
		// Collection list=adapter.evaluate("-- something something\n"+"context OclVoid inv:
		// EUML::Generic::Activities::UMLActivity.allInstances()");
		// List list=adapter.evaluate("-- something something\n\n "+"context EUML::Generic::Activities::UMLActivity inv:
		// self.the_owner.the_owned_elements", useCase1Activity);

		this.adapter.delete(this.topLevelPackage1);

		this.adapter.evaluateQVT(this.fullPath(this.qvtFile), "usecase2activity", true, "forward");

		this.notFindByName("Col1", true);
		this.notFindByName("useCase1Activity", true);
		this.notFindByName("useCase2Activity", true);

	}

	/**
	 * Tests on deleting source element appearing in a trace binding
	 * 
	 * -One forward transformation
	 * 
	 * -Delete useCase1 source element
	 * 
	 * -Next forward transformation
	 * 
	 * -useCase1Activity must not exist
	 * 
	 * @throws FileNotFoundException
	 */
	public void testTraces3() throws FileNotFoundException {

		Assert.assertEquals(this.adapter.getIdentityObject(this.findByName("useCase1", false)), this.adapter.getIdentityObject(this.useCase1));

		this.adapter.evaluateQVT(this.fullPath(this.qvtFile), "usecase2activity", true, "forward");

		Object col1 = this.findByName("Col1", true);
		Object useCase1Activity = this.findByName("useCase1Activity", true);
		Object useCase2Activity = this.findByName("useCase2Activity", true);

		this.adapter.delete(this.useCase1);

		this.adapter.evaluateQVT(this.fullPath(this.qvtFile), "usecase2activity", true, "forward");

		this.findByName("Col1", true);
		this.notFindByName("useCase1Activity", true);
		this.findByName("useCase2Activity", true);

	}

	/**
	 * Tests on deleting target element
	 * 
	 * -One forward transformation
	 * 
	 * -Delete useCase1Activity target element
	 * 
	 * -One backward transformation
	 * 
	 * -useCase1 must not exist
	 * 
	 * @throws FileNotFoundException
	 */
	public void testTraces4() throws FileNotFoundException {

		Assert.assertEquals(this.adapter.getIdentityObject(this.findByName("useCase1", false)), this.adapter.getIdentityObject(this.useCase1));

		this.adapter.evaluateQVT(this.fullPath(this.qvtFile), "usecase2activity", true, "forward");

		Object col1 = this.findByName("Col1", true);
		Object useCase1Activity = this.findByName("useCase1Activity", true);
		Object useCase2Activity = this.findByName("useCase2Activity", true);

		this.adapter.delete(useCase1Activity);

		this.adapter.evaluateQVTBackward(this.fullPath(this.qvtFile), "usecase2activity", true, "backward");

		this.findByName("topLevelPackage1", false);
		this.notFindByName("useCase1", false);
		this.findByName("useCase2", false);

	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		this.topLevelPackage1 = this.createModelElement(this.META_UMLPackage);
		this.adapter.setValueForFeature(this.topLevelPackage1, this.META_UMLNamedElement_name, "topLevelPackage1");

		this.useCase1 = this.createModelElement(this.META_UMLUseCase);
		this.adapter.setValueForFeature(this.useCase1, this.META_UMLNamedElement_name, "useCase1");
		this.adapter.setValueForFeature(this.useCase1, this.META_UMLElement_the_owner, this.topLevelPackage1);

		this.useCase2 = this.createModelElement(this.META_UMLUseCase);
		this.adapter.setValueForFeature(this.useCase2, this.META_UMLNamedElement_name, "useCase2");
		this.adapter.setValueForFeature(this.useCase2, this.META_UMLElement_the_owner, this.topLevelPackage1);
	}

}
