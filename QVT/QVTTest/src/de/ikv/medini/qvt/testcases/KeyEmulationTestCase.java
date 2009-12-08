/**
 * Copyright (c) 2007 ikv++ technologies ag
 * All Rights Reserved
 */
package de.ikv.medini.qvt.testcases;

import java.io.FileNotFoundException;

import junit.framework.Assert;

import de.ikv.medini.qvt.test.QVTTestCase;

/**
 * Tests a special kind of using relations, aiming at having a QVT key concept functionality, but being much more powerful in general
 * 
 * @author kiegeland
 * 
 */
public class KeyEmulationTestCase extends QVTTestCase {

	protected String qvtFile = "KeyEmulation.qvt";

	private Object OS;

	private Object attribute1;

	private Object OS_WIN;

	private Object relationship1;

	private Object relationship2;

	private Object OS_LINUX;

	private Object MyInt;

	private Object relationship3;

	/**
	 * Two classes named "REPOImpl" are created in the target, which must map to the same source interface after backward transformation
	 * 
	 * @throws FileNotFoundException
	 */
	public void testTraces2() throws FileNotFoundException {
		this.adapter.evaluateQVT(this.fullPath(this.qvtFile), "KeyEmulation", true, "target");

		this.findByName("OS_WIN", true, this.META_UMLPackage);
		this.findByName("OS_LINUX", true, this.META_UMLPackage);

		/*
		 * Find two generated class attributes named "attribute1" from the corresponding interface attribute "attribute1"
		 */
		Assert.assertEquals(2, this.findElementsWithName("OS", true, this.META_UMLClass).size());
		Assert.assertEquals(2, this.findElementsWithName("attribute1", true, this.META_UMLProperty).size());

		/**
		 * Create package "REPO_EMF_package", containing class "REPOImpl" with properties "attribute_repo" and "property do_log"
		 */
		Object REPO_EMF_package = this.createModelElementInTarget(this.META_UMLPackage);
		this.adapter.setValueForFeature(REPO_EMF_package, this.META_UMLNamedElement_name, "REPO_EMF_package");
		Object REPO_EMF_class = this.createModelElementInTargetWithOwner(this.META_UMLClass, REPO_EMF_package);
		this.adapter.setValueForFeature(REPO_EMF_class, this.META_UMLNamedElement_name, "REPOImpl");
		Object attribute_emf = this.createModelElementInTargetWithOwner(this.META_UMLProperty, REPO_EMF_class);
		this.adapter.setValueForFeature(attribute_emf, this.META_UMLNamedElement_name, "attribute_repo");
		Object attribute_do_log_emf = this.createModelElementInTargetWithOwner(this.META_UMLProperty, REPO_EMF_class);
		this.adapter.setValueForFeature(attribute_do_log_emf, this.META_UMLNamedElement_name, "do_log");

		/**
		 * Create package "REPO_MEDINI_package", containing class "REPOImpl" with property "attribute_repo"
		 */
		Object REPO_MEDINI_package = this.createModelElementInTarget(this.META_UMLPackage);
		this.adapter.setValueForFeature(REPO_MEDINI_package, this.META_UMLNamedElement_name, "REPO_MEDINI_package");
		Object REPO_MEDINI_class = this.createModelElementInTargetWithOwner(this.META_UMLClass, REPO_MEDINI_package);
		this.adapter.setValueForFeature(REPO_MEDINI_class, this.META_UMLNamedElement_name, "REPOImpl");
		Object attribute_medini = this.createModelElementInTargetWithOwner(this.META_UMLProperty, REPO_MEDINI_class);
		this.adapter.setValueForFeature(attribute_medini, this.META_UMLNamedElement_name, "attribute_repo");

		this.adapter.evaluateQVTBackward(this.fullPath(this.qvtFile), "KeyEmulation", true, "source");

		this.findByName("OS", false, this.META_UMLInterface);
		this.findByName("REPOImpl", false, this.META_UMLInterface);
		Object attribute_do_log = this.findByName("do_log", false, this.META_UMLProperty);

		/**
		 * Change attribute name
		 */
		Object attribute_repo = this.findByName("attribute_repo", false);
		this.adapter.setValueForFeature(attribute_repo, this.META_UMLNamedElement_name, "attribute_repo_changed");

		this.adapter.evaluateQVT(this.fullPath(this.qvtFile), "KeyEmulation", true, "target");

		/**
		 * There must be two occurences of attributes of the new name and no occurence of the old name
		 */
		Assert.assertEquals(2, this.findElementsWithName("attribute_repo_changed", true).size());
		this.notFindByName("attribute_repo", true);

		/**
		 * There must be two occurences of "do_log" attributes
		 */
		Assert.assertEquals(2, this.findElementsWithName("do_log", true).size());

		/**
		 * Delete all "attribute_repo_changed" properties
		 */
		for (Object attribute_repo_changed : this.findElementsWithName("attribute_repo_changed", true)) {
			this.adapter.delete(attribute_repo_changed);
		}

		/**
		 * Rename all "do_log" properties
		 */
		for (Object do_log : this.findElementsWithName("do_log", true)) {
			this.adapter.setValueForFeature(do_log, this.META_UMLNamedElement_name, "do_log_changed");
		}

		this.adapter.evaluateQVTBackward(this.fullPath(this.qvtFile), "KeyEmulation", true, "source");

		/**
		 * property "do_log_changed" must exist in source model and must have preserved the identity
		 */
		Object attribute_do_log_changed = this.findByName("do_log_changed", false);
		Assert.assertEquals(this.adapter.getIdentityObject(attribute_do_log_changed), this.adapter.getIdentityObject(attribute_do_log));

		/**
		 * property "attribute_repo_changed" must be deleted
		 */
		this.notFindByName("attribute_repo_changed", false);

		this.checkTraces(this.qvtFile, "KeyEmulation", "target", "source", 6 * 2 + 1);
	}

	/**
	 * General functionality test
	 * 
	 * @throws FileNotFoundException
	 */
	public void testTraces1() throws FileNotFoundException {
		this.checkTraces(this.qvtFile, "KeyEmulation", "target", "source", 7);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		/*
		 * Create interface "MyInt" with no attributes
		 */
		this.MyInt = this.createModelElement(this.META_UMLInterface);
		this.adapter.setValueForFeature(this.MyInt, this.META_UMLNamedElement_name, "MyInt");

		/*
		 * Create interface "OS" with attribute "attribute1"
		 */
		this.OS = this.createModelElement(this.META_UMLInterface);
		this.adapter.setValueForFeature(this.OS, this.META_UMLNamedElement_name, "OS");
		this.attribute1 = this.createModelElementWithOwner(this.META_UMLProperty, this.OS);
		this.adapter.setValueForFeature(this.attribute1, this.META_UMLNamedElement_name, "attribute1");

		/*
		 * Create component "OS_WIN" with a relationship directed to interface "OS"
		 */
		this.OS_WIN = this.createModelElement(this.META_UMLComponent);
		this.adapter.setValueForFeature(this.OS_WIN, this.META_UMLNamedElement_name, "OS_WIN");
		this.relationship1 = this.createModelElementWithOwner(this.META_UMLDirectedRelationship, this.OS_WIN);
		this.adapter.setValueForFeature(this.relationship1, this.META_UMLDirectedRelationship_the_source_element, this.OS_WIN);
		this.adapter.setValueForFeature(this.relationship1, this.META_UMLDirectedRelationship_the_target_element, this.OS);

		/*
		 * Create component "OS_LINUX" with a relationship directed to interface "OS"
		 */
		this.OS_LINUX = this.createModelElement(this.META_UMLComponent);
		this.adapter.setValueForFeature(this.OS_LINUX, this.META_UMLNamedElement_name, "OS_LINUX");
		this.relationship2 = this.createModelElementWithOwner(this.META_UMLDirectedRelationship, this.OS_LINUX);
		this.adapter.setValueForFeature(this.relationship2, this.META_UMLDirectedRelationship_the_source_element, this.OS_LINUX);
		this.adapter.setValueForFeature(this.relationship2, this.META_UMLDirectedRelationship_the_target_element, this.OS);

		this.relationship3 = this.createModelElementWithOwner(this.META_UMLDirectedRelationship, this.OS_LINUX);
		this.adapter.setValueForFeature(this.relationship3, this.META_UMLDirectedRelationship_the_source_element, this.OS_LINUX);
		this.adapter.setValueForFeature(this.relationship3, this.META_UMLDirectedRelationship_the_target_element, this.MyInt);

	}

}
