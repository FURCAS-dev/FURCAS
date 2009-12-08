/**
 * Copyright (c) 2007 ikv++ technologies ag
 * All Rights Reserved
 */
package de.ikv.medini.qvt.testcases;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;

import junit.framework.Assert;

import de.ikv.medini.ocl.test.util.Utilities;
import de.ikv.medini.qvt.test.QVTTestCase;

/**
 * This test case tests whether adding new model elements and putting them to the beginning of the_owned_elements-array respects traces of the already existent child elements
 * 
 * @author kiegeland
 * 
 */
public class OrderingTestCase extends QVTTestCase {

	private Object topPackage;

	private Object useCase1;

	private Object useCase2;

	/**
	 * Tests transformation in one QVT file
	 * 
	 * @throws FileNotFoundException
	 */
	public void testTraces2() throws FileNotFoundException {
		this.checkTraces("toplevel_usecase2activity.qvt", "usecase2activity", "forward", "backward", -1);
	}

	/**
	 * Tests second forward transformation after adding new use cases
	 * 
	 * @throws FileNotFoundException
	 */
	public void testTraces5() throws FileNotFoundException {
		this.adapter.evaluateQVT(this.fullPath("toplevel_usecase2activity.qvt"), "usecase2activity", true, "forward");

		Object Col1 = this.findByName("Col1", true);
		Object first_useCase1Activity = this.findByName("useCase1Activity", true);

		ArrayList c0 = new ArrayList((Collection) this.adapter.evaluateOnSource("Generic::UseCases::UMLUseCase.allInstances()").get(0));

		Object useCase3 = this.createModelElement(this.META_UMLUseCase);
		this.adapter.setValueForFeature(useCase3, this.META_UMLNamedElement_name, "useCase3");
		// adapter.setValueForFeature(useCase3, META_UMLElement_the_owner, topPackage);

		Object useCase4 = this.createModelElement(this.META_UMLUseCase);
		this.adapter.setValueForFeature(useCase4, this.META_UMLNamedElement_name, "useCase4");
		// adapter.setValueForFeature(useCase4, META_UMLElement_the_owner, topPackage);

		// adapter.setValueForFeature(useCase1, META_UMLElement_the_owner, null);
		// adapter.setValueForFeature(useCase1, META_UMLElement_the_owner, topPackage);

		c0.add(0, useCase3);
		c0.add(useCase4);
		this.adapter.setValueForFeature(this.topPackage, this.META_UMLElement_the_owned_elements, c0);

		this.adapter.evaluateQVT(this.fullPath("toplevel_usecase2activity.qvt"), "usecase2activity", true, "forward");

		Object Second_Col1 = this.findByName("Col1", true);

		Collection c1 = new ArrayList((Collection) this.adapter.evaluateOnTarget("Generic::Activities::UMLActivity.allInstances()").get(0));
		Collection c2 = new ArrayList((Collection) this.adapter.evaluateOnTarget("Generic::Activities::UMLActivity.allInstances()").get(0));

		Assert.assertTrue(Utilities.areIdentitiesEqual(c1, c2, this.adapter));

		Object useCase1Activity = this.findByName("useCase1Activity", true);
		Object useCase2Activity = this.findByName("useCase2Activity", true);
		Object useCase3Activity = this.findByName("useCase3Activity", true);
		Object useCase4Activity = this.findByName("useCase4Activity", true);

		Collection c3 = Utilities.asArrayList(new Object[] { useCase1Activity, useCase2Activity, useCase3Activity, useCase4Activity });

		Assert.assertTrue(Utilities.areIdentitiesEqual(c1, c3, this.adapter));

		Assert.assertEquals(this.adapter.getIdentityObject(Col1), this.adapter.getIdentityObject(Second_Col1));
		Assert.assertEquals(this.adapter.getIdentityObject(first_useCase1Activity), this.adapter.getIdentityObject(useCase1Activity));

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
