/**
 * Copyright (c) 2007 ikv++ technologies ag
 * All Rights Reserved
 */
package de.ikv.medini.qvt.testcases;

import java.io.FileNotFoundException;
import java.util.Collection;

import de.ikv.medini.qvt.test.QVTTestAdapter;
import de.ikv.medini.qvt.test.QVTTestCase;

/**
 * Test random model generation for MCM UI modeling
 * 
 * @author kiegeland
 * 
 */
public class RandomActivityUITestCaseForUML2 extends QVTTestCase {

	public void testRandomElementCreation() throws FileNotFoundException {
		if (!this.adapter.supportsRandomMode()) {
			return;
		}
		int randomElementCreationsLimit = 100;
		this.adapter.setQvtProperty(QVTTestCase.PROP_RANDOMIZE, "" + randomElementCreationsLimit);
		// adapter.setQvtProperty(PROP_INPLACE, "true");
		this.adapter.evaluateQVT(this.fullPath("RandomActivityUIForUML2.qvt"), "RandomActivityUI", true, "forward");

		Collection classes = this.findElementsByType(true, "uml::Component");

		/*
		 * Now parse the model. Only the original package shall remain.
		 */
		// adapter.setQvtProperty(PROP_RANDOMIZE, "" + 0);
		// adapter.setQvtProperty(PROP_PARSE, "true");
		// adapter.evaluateQVT(fullPath("RandomActivityUIForUML2.qvt"), "RandomActivityUI", true, "backward");
		// Collection all = findElementsByType(true, "uml::Element");
		// assertEquals(1, all.size());
	}

	@Override
	protected void setUp() throws Exception {
		this.metamodelIDs = new String[] { "uml", "uml", "uml" };
		System.setProperty(QVTTestAdapter.QVTTESTADAPTER_INPLACE, "true");
		super.setUp();
		if (!this.adapter.supportsRandomMode()) {
			return;
		}
		if (!this.metaModelSupported()) {
			return;
		}
		Object p = this.createModelElement("uml::Package");
		this.adapter.setValueForFeature(p, "name", "topLevelPackage");
	}

}
