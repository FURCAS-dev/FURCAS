/**
 * Copyright (c) 2007 ikv++ technologies ag
 * All Rights Reserved
 */
package de.ikv.medini.qvt.testcases;

import java.io.FileNotFoundException;
import java.util.Collection;

import junit.framework.Assert;

import de.ikv.medini.qvt.test.QVTTestAdapter;
import de.ikv.medini.qvt.test.QVTTestCase;

/**
 * Test random model generation for MCM UI modeling. Note that the QVT script also tests using three domains.
 * 
 * @author kiegeland
 * 
 */
public class RandomActivityUITestCase extends QVTTestCase {

	public void testRandomElementCreation() throws FileNotFoundException {
		if (!this.adapter.supportsRandomMode()) {
			return;
		}
		int randomElementCreationsLimit = 100;
		this.adapter.setQvtProperty(QVTTestCase.PROP_RANDOMIZE, "" + randomElementCreationsLimit);
		// adapter.setQvtProperty(PROP_INPLACE, "true");
		this.adapter.evaluateQVT(this.fullPath("RandomActivityUI.qvt"), "RandomActivityUI", true, "forward");

		Collection classes = this.findElementsByType(true, this.META_UMLComponent);

		// assertEquals(2, classes.size());

		/*
		 * Now parse the model. Only the original package shall remain.
		 */
		this.adapter.setQvtProperty(QVTTestCase.PROP_RANDOMIZE, "" + 0);
		this.adapter.setQvtProperty(QVTTestCase.PROP_PARSE, "true");
		this.adapter.evaluateQVT(this.fullPath("RandomActivityUI.qvt"), "RandomActivityUI", true, "backward");
		Collection all = this.findElementsByType(true, this.META_UMLElement);
		Assert.assertEquals(1, all.size());
	}

	@Override
	protected void setUp() throws Exception {
		this.metamodelIDs = new String[] { "EUML", "EUML", "EUML" };
		System.setProperty(QVTTestAdapter.QVTTESTADAPTER_INPLACE, "true");
		super.setUp();
		if (!this.adapter.supportsRandomMode()) {
			return;
		}
		Object p = this.createModelElement(this.META_UMLPackage);
		this.adapter.setValueForFeature(p, this.META_UMLNamedElement_name, "topLevelPackage");
	}

}
