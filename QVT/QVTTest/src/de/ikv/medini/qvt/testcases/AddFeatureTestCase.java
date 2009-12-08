/**
 * Copyright (c) 2007 ikv++ technologies ag
 * All Rights Reserved
 */
package de.ikv.medini.qvt.testcases;

import java.io.FileNotFoundException;
import java.util.Collection;

import junit.framework.Assert;

import de.ikv.medini.ocl.test.util.Utilities;
import de.ikv.medini.qvt.test.QVTTestCase;

/**
 * Test case to test whether <code>QvtModelManipulationAdapter.setOrAddValueForFeauture</code> respects traces in the sense, that model elements, which are added to associations
 * by older transformations, are correctly removed from associations where the currently transformation does not induce them, even if the added model elements are still existent
 * after the current transformation.
 * 
 * @author kiegeland
 * 
 */
public class AddFeatureTestCase extends QVTTestCase {

	private Object topLevelPackage1;

	private String qvtFile = "AddFeatureTestCase.qvt";

	private Object topLevelPackage2;

	private Object child1a;

	private Object child1b;

	private Object child2a;

	private Object child2b;

	/**
	 * General functionality test
	 * 
	 * @throws FileNotFoundException
	 */
	public void testTraces1() throws FileNotFoundException {
		this.checkTraces(this.qvtFile, "AddFeatureTestCase", "target", "source", 6);
	}

	/**
	 * Tests that the_utilized_elements not contains elements added in a previous transformation
	 * 
	 * @throws FileNotFoundException
	 */
	public void testTraces2() throws FileNotFoundException {

		/*
		 * First forward transformation now must
		 */
		this.adapter.evaluateQVT(this.fullPath(this.qvtFile), "AddFeatureTestCase", true, "target");

		/*
		 * Assert that only topLevelPackage1 is included in child1a.the_utilized_elements
		 */
		{
			Object topLevelPackage1_target = this.findByName("topLevelPackage1", true);
			Object child1a_target = this.findByName("child1a", true);
			Collection child1a_association = Utilities.getIdentities((Collection) this.adapter.getValueForFeature(child1a_target, "the_utilized_elements"), this.adapter);
			Assert.assertTrue(child1a_association.contains(this.adapter.getIdentityObject(topLevelPackage1_target)));
			Assert.assertEquals(1, child1a_association.size());
		}

		Collection s1 = this.getSourceIDs(true);

		/*
		 * Exchange ownership
		 */
		this.adapter.setValueForFeature(this.child1a, this.META_UMLElement_the_owner, this.topLevelPackage2);
		this.adapter.setValueForFeature(this.child2b, this.META_UMLElement_the_owner, this.topLevelPackage1);

		/*
		 * Second forward transformation now must
		 */
		this.adapter.evaluateQVT(this.fullPath(this.qvtFile), "AddFeatureTestCase", true, "target");

		Collection s2 = this.getSourceIDs(true);

		Assert.assertEquals(s1, s2);

		/*
		 * Assert that only topLevelPackage2 is included in child1a.the_utilized_elements (and not topLevelPackage1 anymore)
		 */
		{
			Object topLevelPackage2_target = this.findByName("topLevelPackage2", true);
			Object child1a_target = this.findByName("child1a", true);
			Collection child1a_association = Utilities.getIdentities((Collection) this.adapter.getValueForFeature(child1a_target, "the_utilized_elements"), this.adapter);
			Assert.assertTrue(child1a_association.contains(this.adapter.getIdentityObject(topLevelPackage2_target)));
			Assert.assertEquals(1, child1a_association.size());
		}

	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		/*
		 * Create package topLevelPackage1 with children child1a and child1b
		 */
		this.topLevelPackage1 = this.createModelElement(this.META_UMLPackage);
		this.adapter.setValueForFeature(this.topLevelPackage1, this.META_UMLNamedElement_name, "topLevelPackage1");
		this.child1a = this.createModelElement(this.META_UMLPackage);
		this.adapter.setValueForFeature(this.child1a, this.META_UMLElement_the_owner, this.topLevelPackage1);
		this.adapter.setValueForFeature(this.child1a, this.META_UMLNamedElement_name, "child1a");
		this.child1b = this.createModelElement(this.META_UMLPackage);
		this.adapter.setValueForFeature(this.child1b, this.META_UMLElement_the_owner, this.topLevelPackage1);
		this.adapter.setValueForFeature(this.child1b, this.META_UMLNamedElement_name, "child1b");

		/*
		 * Create package topLevelPackage2 with children child2a and child2b
		 */
		this.topLevelPackage2 = this.createModelElement(this.META_UMLPackage);
		this.adapter.setValueForFeature(this.topLevelPackage2, this.META_UMLNamedElement_name, "topLevelPackage2");
		this.child2a = this.createModelElement(this.META_UMLPackage);
		this.adapter.setValueForFeature(this.child2a, this.META_UMLElement_the_owner, this.topLevelPackage2);
		this.adapter.setValueForFeature(this.child2a, this.META_UMLNamedElement_name, "child2a");
		this.child2b = this.createModelElement(this.META_UMLPackage);
		this.adapter.setValueForFeature(this.child2b, this.META_UMLElement_the_owner, this.topLevelPackage2);
		this.adapter.setValueForFeature(this.child2b, this.META_UMLNamedElement_name, "child2b");

	}

}
