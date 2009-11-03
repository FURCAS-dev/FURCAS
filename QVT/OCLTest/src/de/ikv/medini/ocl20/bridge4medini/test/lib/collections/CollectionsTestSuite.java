/*******************************************************************************
 * Copyright (c) 2008 ikv++ technologies ag and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     ikv++ technologies ag - initial API and implementation
 *******************************************************************************/

package de.ikv.medini.ocl20.bridge4medini.test.lib.collections;

import junit.framework.Test;
import junit.framework.TestSuite;

public class CollectionsTestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for de.ikv.medini.ocl20.bridge4medini.test.lib.collections");
		// $JUnit-BEGIN$
		suite.addTestSuite(OclSequenceTestCase.class);
		suite.addTestSuite(OclBagTestCase.class);
		suite.addTestSuite(OclSetTestCase.class);
		suite.addTestSuite(OclOrderedSetTestCase.class);
		// $JUnit-END$
		return suite;
	}

}
