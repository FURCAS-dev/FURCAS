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

package de.ikv.medini.ocl20.bridge4medini.test.exp.propertycallexp.loopexp;

import junit.framework.Test;
import junit.framework.TestSuite;
import de.ikv.medini.ocl20.bridge4medini.test.exp.propertycallexp.loopexp.iterateexp.IterateExpTestSuite;
import de.ikv.medini.ocl20.bridge4medini.test.exp.propertycallexp.loopexp.iteratorexp.IteratorExpTestSuite;

public class LoopExpTestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for de.ikv.medini.ocl20.bridge4medini.test.exp.propertycallexp.loopexp");
		// $JUnit-BEGIN$
		suite.addTest(IterateExpTestSuite.suite());
		suite.addTest(IteratorExpTestSuite.suite());

		// $JUnit-END$
		return suite;
	}

}
