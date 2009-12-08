/**
 * Copyright (c) 2007 ikv++ technologies ag
 * All Rights Reserved
 */
package de.ikv.medini.qvt.testcases;

import junit.framework.Assert;
import de.ikv.medini.qvt.test.QVTTestCase;

/**
 * @author Omar Ekine
 * @author Joerg Kiegeland
 * 
 */
public class BindSubclassInWhereClauseTestCase extends QVTTestCase {

	private Object component;

	private String qvtFile = "bindSubclassInWhereClause.qvt";

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.component = this.createModelElement(this.META_UMLComponent);
		this.adapter.setValueForFeature(this.component, this.META_UMLNamedElement_name, "NavigationSystem");
	}

	/**
	 * Test purpose:
	 * <ul>
	 * <li>Transform the component created in setUp()
	 * <li>Check that two UMLPackages are created with correct names and one contained in the other.
	 * 
	 * @throws Exception
	 */
	public void testCreateContainerPackageInWhereClause() throws Exception {

		this.adapter.evaluateQVT(this.fullPath(this.qvtFile), "TestTransformation", true, "target");

		Object componentPackage = this.findByName("NavigationSystemPackage", true);
		Object componentPackageContainer = this.findByName("NavigationSystemPackageContainer", true);
		Assert.assertTrue("This model element must be a UMLPackage", this.adapter.isOfType(componentPackageContainer, this.META_UMLPackage, false));
		Object componentPackageOwner = this.adapter.getValueForFeature(componentPackage, this.META_UMLElement_the_owner);
		Assert.assertNotNull(componentPackageOwner);

		componentPackageOwner = this.adapter.getIdentityObject(componentPackageOwner);

		Assert.assertNotNull(componentPackageOwner);
		componentPackageContainer = this.adapter.getIdentityObject(componentPackageContainer);
		Assert.assertNotNull(componentPackageContainer);
		Assert.assertEquals(componentPackageOwner, componentPackageContainer);
	}
}
