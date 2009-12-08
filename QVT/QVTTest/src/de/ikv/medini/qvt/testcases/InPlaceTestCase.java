/**
 * Copyright (c) 2007 ikv++ technologies ag
 * All Rights Reserved
 */
package de.ikv.medini.qvt.testcases;

import java.io.FileNotFoundException;
import java.util.Collection;

import junit.framework.Assert;

import de.ikv.medini.qvt.test.QVTTestCase;
import de.ikv.medini.qvt.test.QVTTestAdapter;

/**
 * Test case to test in-place feature enabled by QvtProcessorConsts.PROP_INPLACE
 * 
 * @author kiegeland
 * 
 */
public class InPlaceTestCase extends QVTTestCase {

	private String qvtFile = "AbstractToConcrete.qvt";

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

	/**
	 * Copy methods into a class from classes to which a relationship transitively exists. Do this by using the in-place feature.
	 * 
	 * @throws FileNotFoundException
	 */
	public void testTraces1() throws FileNotFoundException {
		this.adapter.setQvtProperty(QVTTestCase.PROP_INPLACE, "true");
		this.adapter.evaluateQVT(this.fullPath(this.qvtFile), "AbstractToConcrete", true, "uml2");

		/*
		 * Operation "play" must exist 6 times (in everywhere)
		 */
		Collection col = this.findElementsWithName("play", true);
		Assert.assertEquals(6, col.size());

		/*
		 * Operation "play2" must exist 4 times (in ElectricGuitar, Violin, Guitar and Stringed)
		 */
		Collection col2 = this.findElementsWithName("play2", true);
		Assert.assertEquals(4, col2.size());
	}

	@Override
	protected void setUp() throws Exception {
		System.setProperty(QVTTestAdapter.QVTTESTADAPTER_INPLACE, "true");
		super.setUp();

		/*
		 * Create classes. NOTE: the creation order is important for EMF, since if the order already corresponds to an ordering by relationship dependency, there would be only one
		 * transformation run required!
		 * 
		 */
		this.ElectricGuitar = this.createModelElement(this.META_UMLClass);
		this.Violin = this.createModelElement(this.META_UMLClass);
		this.Guitar = this.createModelElement(this.META_UMLClass);
		this.Percussion = this.createModelElement(this.META_UMLClass);
		this.Stringed = this.createModelElement(this.META_UMLClass);
		this.Instrument = this.createModelElement(this.META_UMLClass);

		/*
		 * Initialize class "Instrument"
		 */
		this.Instrument = this.createModelElement(this.META_UMLClass);
		this.adapter.setValueForFeature(this.Instrument, this.META_UMLNamedElement_name, "Instrument");
		this.adapter.setValueForFeature(this.Instrument, this.META_UMLClassifier_isAbstract, Boolean.TRUE);

		this.play = this.createModelElement(this.META_UMLOperation);
		this.adapter.setValueForFeature(this.play, this.META_UMLElement_the_owner, this.Instrument);
		this.adapter.setValueForFeature(this.play, this.META_UMLNamedElement_name, "play");
		this.pitchAlphabet = this.createModelElement(this.META_UMLParameter);
		this.adapter.setValueForFeature(this.pitchAlphabet, this.META_UMLElement_the_owner, this.play);
		this.adapter.setValueForFeature(this.pitchAlphabet, this.META_UMLNamedElement_name, "pitchAlphabet");

		/*
		 * Initialize class "Percussion"
		 */
		this.adapter.setValueForFeature(this.Percussion, this.META_UMLNamedElement_name, "Percussion");
		this.establishRelationship(this.Percussion, this.Instrument);

		/*
		 * Initialize class "Stringed"
		 */
		this.adapter.setValueForFeature(this.Stringed, this.META_UMLNamedElement_name, "Stringed");
		this.establishRelationship(this.Stringed, this.Instrument);

		this.play2 = this.createModelElement(this.META_UMLOperation);
		this.adapter.setValueForFeature(this.play2, this.META_UMLElement_the_owner, this.Stringed);
		this.adapter.setValueForFeature(this.play2, this.META_UMLNamedElement_name, "play2");
		this.pitchAlphabet2 = this.createModelElement(this.META_UMLParameter);
		this.adapter.setValueForFeature(this.pitchAlphabet2, this.META_UMLElement_the_owner, this.play2);
		this.adapter.setValueForFeature(this.pitchAlphabet2, this.META_UMLNamedElement_name, "pitchAlphabet2");

		/*
		 * Initialize class "Guitar"
		 */
		this.adapter.setValueForFeature(this.Guitar, this.META_UMLNamedElement_name, "Guitar");
		this.establishRelationship(this.Guitar, this.Stringed);

		/*
		 * Initialize class "ElectricGuitar"
		 */
		this.adapter.setValueForFeature(this.ElectricGuitar, this.META_UMLNamedElement_name, "ElectricGuitar");
		this.establishRelationship(this.ElectricGuitar, this.Guitar);

		/*
		 * Initialize class "Violin"
		 */
		this.adapter.setValueForFeature(this.Violin, this.META_UMLNamedElement_name, "Violin");
		this.establishRelationship(this.Violin, this.Stringed);

	}

	private void establishRelationship(Object source, Object target) {
		Object relationship1 = this.createModelElement(this.META_UMLDirectedRelationship);
		try {
			this.adapter.setValueForFeature(relationship1, this.META_UMLElement_the_owner, source);// -- not supported by JMI
		} catch (Exception e) {
			// JMI jumps here
		}
		this.adapter.setValueForFeature(relationship1, this.META_UMLDirectedRelationship_the_source_element, source);
		this.adapter.setValueForFeature(relationship1, this.META_UMLDirectedRelationship_the_target_element, target);

	}

}
