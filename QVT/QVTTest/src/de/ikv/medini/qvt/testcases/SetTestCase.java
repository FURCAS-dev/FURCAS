/**
 * Copyright (c) 2007 ikv++ technologies ag
 * All Rights Reserved
 */
package de.ikv.medini.qvt.testcases;

import java.io.FileNotFoundException;

import junit.framework.Assert;
import de.ikv.medini.qvt.test.QVTTestAdapter;
import de.ikv.medini.qvt.test.QVTTestCase;

/**
 * This test case tests the movement of contained classes from one package to another by assigning the "the_owned_elements" attribute the set of classes from the other package all
 * at once
 * 
 * @author kiegeland
 * 
 */
public class SetTestCase extends QVTTestCase {

	private String qvtFile = "SetTest.qvt";

	private Object Instrument;

	private Object play;

	private Object pitchAlphabet;

	private Object octaveFrequency;

	private Object Percussion;

	private Object Stringed;

	private Object Guitar;

	private Object Violin;

	private Object ElectricGuitar;

	private Object play2;

	private Object pitchAlphabet2;

	private Object topLevelPackage1;

	private Object topLevelPackage2;

	public void testTraces1() throws FileNotFoundException {
		this.adapter.evaluateQVT(this.fullPath(this.qvtFile), "SetTest", true, "forward");

		// tests that "ElectricGuitar" is now contained in Package2
		Object x = this.adapter.getValueForFeature(this.ElectricGuitar, this.META_UMLElement_the_owner);
		Assert.assertEquals(this.topLevelPackage2, x);

	}

	@Override
	protected void setUp() throws Exception {
		System.setProperty(QVTTestAdapter.QVTTESTADAPTER_INPLACE, "true");
		super.setUp();

		this.topLevelPackage1 = this.createModelElement(this.META_UMLPackage);
		this.adapter.setValueForFeature(this.topLevelPackage1, this.META_UMLNamedElement_name, "Package1");

		this.ElectricGuitar = this.createModelElement(this.META_UMLClass);
		this.adapter.setValueForFeature(this.ElectricGuitar, this.META_UMLNamedElement_name, "ElectricGuitar");
		this.Violin = this.createModelElement(this.META_UMLClass);
		this.adapter.setValueForFeature(this.Violin, this.META_UMLNamedElement_name, "Violin");
		this.Guitar = this.createModelElement(this.META_UMLClass);
		this.adapter.setValueForFeature(this.Guitar, this.META_UMLNamedElement_name, "Guitar");
		this.Percussion = this.createModelElement(this.META_UMLClass);
		this.adapter.setValueForFeature(this.Percussion, this.META_UMLNamedElement_name, "Percussion");
		this.Stringed = this.createModelElement(this.META_UMLClass);
		this.adapter.setValueForFeature(this.Stringed, this.META_UMLNamedElement_name, "Stringed");
		this.Instrument = this.createModelElement(this.META_UMLClass);
		this.adapter.setValueForFeature(this.Instrument, this.META_UMLNamedElement_name, "Instrument");

		this.adapter.setValueForFeature(this.ElectricGuitar, this.META_UMLElement_the_owner, this.topLevelPackage1);
		this.adapter.setValueForFeature(this.Violin, this.META_UMLElement_the_owner, this.topLevelPackage1);
		this.adapter.setValueForFeature(this.Guitar, this.META_UMLElement_the_owner, this.topLevelPackage1);
		this.adapter.setValueForFeature(this.Percussion, this.META_UMLElement_the_owner, this.topLevelPackage1);
		this.adapter.setValueForFeature(this.Stringed, this.META_UMLElement_the_owner, this.topLevelPackage1);
		this.adapter.setValueForFeature(this.Instrument, this.META_UMLElement_the_owner, this.topLevelPackage1);

		this.topLevelPackage2 = this.createModelElement(this.META_UMLPackage);
		this.adapter.setValueForFeature(this.topLevelPackage2, this.META_UMLNamedElement_name, "Package2");

	}

}
